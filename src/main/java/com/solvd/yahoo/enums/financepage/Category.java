package com.solvd.yahoo.enums.financepage;

public enum Category {
    MY_PORTFOLIO("My Portfolio"),
    NEWS("News"),
    MARKETS("Markets"),
    RESEARCH("Research"),
    PERSONAL_FINANCE("Personal Finance"),
    VIDEOS("Videos"),
    STREAMING_NOW("Streaming Now");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
