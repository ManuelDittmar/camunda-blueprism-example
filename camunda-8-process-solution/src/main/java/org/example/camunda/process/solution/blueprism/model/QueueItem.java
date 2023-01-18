package org.example.camunda.process.solution.blueprism.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class QueueItem {

    @SerializedName("data")
    BpCollectionData collectionData;
    int priority;
    String[] tags;
    String status;

    public BpCollectionData getCollectionData() {
        return collectionData;
    }

    public void setCollectionData(BpCollectionData collectionData) {
        this.collectionData = collectionData;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QueueItem{" +
                "collectionData=" + collectionData +
                ", priority=" + priority +
                ", tags=" + Arrays.toString(tags) +
                ", status='" + status + '\'' +
                '}';
    }
}
