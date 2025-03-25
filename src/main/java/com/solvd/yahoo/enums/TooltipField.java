package com.solvd.yahoo.enums;

public enum TooltipField {
    DATE("Date"),
    CLOSE("Close"),
    OPEN("Open"),
    HIGH("High"),
    LOW("Low"),
    VOLUME("Volume");

    private final String fieldName;

    TooltipField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
