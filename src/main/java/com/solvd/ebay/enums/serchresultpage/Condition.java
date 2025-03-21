package com.solvd.ebay.enums.serchresultpage;

public enum Condition {
    NEW("New"),
    USED("Used"),
    NOT_SPECIFIED("Not Specified");

    private final String name;

    Condition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
