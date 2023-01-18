package org.example.camunda.process.solution;

import com.google.gson.Gson;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.example.camunda.process.solution.blueprism.model.*;
import org.example.camunda.process.solution.service.BluePrismService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest {

    @Test
    public void shouldCreateItemInQueue() throws OAuthProblemException, OAuthSystemException, IOException {

        QueueItem queueItem = new QueueItem();

        queueItem.setPriority(134);

        queueItem.setStatus("My Custom Status");

        String[] tags = new String[2];
        tags[0] = "First Tag";
        tags[1] = "Second Tag";
        queueItem.setTags(tags);

        BpCollectionRow row = new BpCollectionRow();
        row.setValue("Hallo");
        row.setValueType(ValueType.TEXT);
        Map<String, BpCollectionRow>[] rows = new Map[1];
        rows[0] = Map.of("first",row);

        BpCollectionData data = new BpCollectionData();
        data.setRows(rows);
        queueItem.setCollectionData(data);

        QueueItem[] items = new QueueItem[1];
        items[0] = queueItem;

        BluePrismService service = new BluePrismService();
        AddQueueItemResponse response = service.addQueueItem("3abe0cb1-b2f2-4c5e-97a2-63c21db82b74", items);

        assertEquals(1, response.getIds().length);

    }

    @Test
    public void shouldReturnQueueItem() {
        String id = "c5df1c62-29a4-4f40-96d2-58ebb47dc9a8";
        BluePrismService service = new BluePrismService();
        ItemResponse item = service.getQueueItem(id);
        assertEquals(id,String.valueOf(item.getId()));
        System.out.println(item.toString());
    }

    @Test
    public void testGson() {
        String json = "\t\r\n[{\"data\":{\"rows\":[{\"first\":{\"value\":\"Hallo\",\"valueType\":\"Text\"}}]},\"priority\":134,\"tags\":[\"First Tag\",\"Second Tag\"],\"status\":\"My Custom Status\"}]";
        Gson gson = new Gson();
        QueueItem[] items = gson.fromJson(json, QueueItem[].class);
        assertEquals(1,items[0].getCollectionData().getRows().length);
        System.out.println("HERE");
    }

}
