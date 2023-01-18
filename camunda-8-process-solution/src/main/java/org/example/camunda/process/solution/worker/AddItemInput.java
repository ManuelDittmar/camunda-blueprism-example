package org.example.camunda.process.solution.worker;

import org.example.camunda.process.solution.blueprism.model.QueueItem;

import java.util.Arrays;

public class AddItemInput {

    String queueId;
    QueueItem[] items;

    public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public QueueItem[] getItems() {
        return items;
    }

    public void setItems(QueueItem[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "AddItemInput{" +
                "queueId='" + queueId + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
