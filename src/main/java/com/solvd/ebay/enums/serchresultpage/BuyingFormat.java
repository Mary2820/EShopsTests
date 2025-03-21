package com.solvd.ebay.enums.serchresultpage;

public enum BuyingFormat {
    ALL_LISTINGS("All Listings"),
    AUCTION("Auction"),
    BUY_IT_NOW("Buy It Now"),
    ACCEPTS_OFFERS("Accepts Offers");

    private final String name;

    BuyingFormat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
