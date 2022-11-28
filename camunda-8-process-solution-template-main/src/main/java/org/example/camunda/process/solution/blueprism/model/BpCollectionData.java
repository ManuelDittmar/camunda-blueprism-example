package org.example.camunda.process.solution.blueprism.model;

import java.util.Map;

public class BpCollectionData {

    Map<String, BpCollectionRow>[] rows;

    public Map<String, BpCollectionRow>[] getRows() {
        return rows;
    }

    public void setRows(Map<String, BpCollectionRow>[] rows) {
        this.rows = rows;
    }
}
