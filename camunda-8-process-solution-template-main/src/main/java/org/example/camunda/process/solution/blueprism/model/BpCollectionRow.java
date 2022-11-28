package org.example.camunda.process.solution.blueprism.model;

public class BpCollectionRow {

    String value;
    ValueType valueType;

    public BpCollectionRow(String value, ValueType valueType) {
        this.value = value;
        this.valueType = valueType;
    }

    public BpCollectionRow() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }
}
