package org.example.camunda.process.solution.service;

import com.google.gson.Gson;
import okhttp3.*;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.example.camunda.process.solution.blueprism.model.AddQueueItemResponse;
import org.example.camunda.process.solution.blueprism.model.QueueItem;
import org.example.camunda.process.solution.blueprism.model.ItemResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BluePrismService {

    private final OkHttpClient client = new OkHttpClient() ;
    private final Gson gson = new Gson();
    private final String AUTHENTICATION_URL = "https://authentication.local/connect/token";
    private final String CLIENT_ID = "api-sa";
    private final String CLIENT_SECRET = "Fc1KfSeBZofbc2R2F38inNqpeC8ZI2qsuyBl4eegxMs=";
    private final String SCOPE = "bp-api bpserver";
    private final String BASE_URL = "https://localhost/api/v7";

    private static final Logger LOGGER = LoggerFactory.getLogger(BluePrismService.class);


    public AddQueueItemResponse addQueueItem(String queueId, QueueItem[] queueItems)  {
        try {
            LOGGER.info("Queue Id: " + queueId);
            String token = getToken();
            String itemsAsJson = gson.toJson(queueItems);
            Request postRequest = new Request.Builder()
                    .url(BASE_URL + "/workqueues/" + queueId + "/items")
                    .addHeader("Authorization", "Bearer " + token)
                    .post(RequestBody.create(
                            itemsAsJson, MediaType.parse("application/json")))
                    .build();
            Call call = client.newCall(postRequest);
            Response response = call.execute();
            return gson.fromJson(response.body().string(), AddQueueItemResponse.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ItemResponse getQueueItem(String itemId) {
        try {
            String token = getToken();
            Request getRequest = new Request.Builder()
                    .url(BASE_URL + "/workqueues/items/" + itemId)
                    .addHeader("Authorization", "Bearer " + token)
                    .get()
                    .build();
            Call call = client.newCall(getRequest);
            Response response = call.execute();
            return gson.fromJson(response.body().string(), ItemResponse.class);

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private String getToken() throws OAuthSystemException, OAuthProblemException {
        OAuthClientRequest clientRequest = OAuthClientRequest
                .tokenLocation(AUTHENTICATION_URL)
                .setGrantType(GrantType.CLIENT_CREDENTIALS)
                .setClientId(CLIENT_ID)
                .setClientSecret(CLIENT_SECRET)
                .setScope(SCOPE)
                .buildBodyMessage();

        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        OAuthJSONAccessTokenResponse respone = oAuthClient.accessToken(clientRequest);
        return respone.getAccessToken();
    }

}
