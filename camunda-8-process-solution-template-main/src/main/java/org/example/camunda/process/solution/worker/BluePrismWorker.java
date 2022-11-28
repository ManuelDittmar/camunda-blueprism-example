package org.example.camunda.process.solution.worker;

import com.google.gson.Gson;
import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import org.example.camunda.process.solution.blueprism.model.AddQueueItemResponse;
import org.example.camunda.process.solution.blueprism.model.ItemResponse;
import org.example.camunda.process.solution.blueprism.model.QueueItem;
import org.example.camunda.process.solution.service.BluePrismService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class BluePrismWorker {

  private static final Logger LOG = LoggerFactory.getLogger(BluePrismWorker.class);
  private static final long retryCycle = 2;

  @Autowired
  private ZeebeClient zeebeClient;

  private final BluePrismService bpService;

    public BluePrismWorker(BluePrismService bpService) {
        this.bpService = bpService;
    }

    @JobWorker(type = "io.camunda:blueprism.addItem", autoComplete = false)
    public void handleAddItemJob(final JobClient client, final ActivatedJob job) {
        Map<String, Object> variables = job.getVariablesAsMap();
        Gson gson = new Gson();
        AddItemInput input = gson.fromJson(job.getVariables(), AddItemInput.class);
        LOG.info("Received Input {}", input);
        AddQueueItemResponse response = bpService.addQueueItem(input.getQueueId(),input.getItems());
        LOG.info("Added Queue Item(s) {}", response.getIds());
        client.newCompleteCommand(job.getKey()).variables(response).send();
    }

    @JobWorker(type = "io.camunda:blueprism.checkItem", autoComplete = false, fetchVariables = "item")
    public void handleCheckStatusJob(final JobClient client, final ActivatedJob job) throws InterruptedException {
        String itemId = (String) job.getVariablesAsMap().get("item");
        LOG.info("Checking Status for {} in an interval of {} seconds", itemId, retryCycle);

        Boolean checkRequired = true;
        while (checkRequired) {
            ItemResponse item = bpService.getQueueItem(itemId);
            ItemResponse.StateEnum state = item.getState();
            LOG.info("Status for Item {} is currently {}", itemId,state.getValue());
            switch (state) {
                case COMPLETED:
                    client.newCompleteCommand(job.getKey())
                            .send();
                    checkRequired = false;
                    break;
                case EXCEPTIONED:
                    zeebeClient.newPublishMessageCommand()
                            .messageName("ExceptionOccured")
                            .correlationKey(itemId)
                            .variables(item)
                            .send();
                    checkRequired = false;
                    break;
                default:
                    LOG.info("no status change yet. Try again in {} seconds", retryCycle);
                    TimeUnit.SECONDS.sleep(retryCycle);
            }
        }

    }
}
