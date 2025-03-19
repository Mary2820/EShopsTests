package com.solvd.ebay.enums.homepage;

public enum Category {
    EXPLORE_NEW("Explore (New!)"),
    SAVED("Saved"),
    MOTORS("Motors"),
    ELECTRONICS("Electronics"),
    COLLECTIBLES("Collectibles"),
    HOME_GARDEN("Home & Garden"),
    CLOTHING_SHOES_ACCESSORIES("Clothing, Shoes & Accessories"),
    TOYS("Toys"),
    SPORTING_GOODS("Sporting Goods"),
    BUSINESS_INDUSTRIAL("Business & Industrial"),
    JEWELRY_WATCHES("Jewelry & Watches"),
    EBAY_LIVE("eBay Live"),
    REFURBISHED("Refurbished");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
