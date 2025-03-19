package com.solvd.ebay.enums.homepage;

public enum ElectronicsSubCategory {
    COMPUTERS_TABLETS_NETWORK("Computers, Tablets & Network Hardware"),
    CAMERAS_AND_PHOTO("Cameras & Photo"),
    CELL_PHONES_AND_SMARTPHONES("Cell Phones & Smartphones"),
    CELL_PHONE_CASES("Cell Phone Cases, Covers & Skins"),
    TV_VIDEO_HOME_AUDIO("TV, Video & Home Audio Electronics"),
    VEHICLE_ELECTRONICS_GPS("Vehicle Electronics & GPS"),
    HEADPHONES("Headphones"),
    SURVEILLANCE_SMART_HOME("Surveillance & Smart Home Electronics"),

    EBAY_REFURBISHED("eBay Refurbished"),
    VIDEO_GAMES("Video Games"),
    VIDEO_GAME_CONSOLES("Video Game Consoles"),
    APPLE_IPHONE("Apple iPhone"),
    PC_DESKTOPS("PC Desktops & All-In-One Computers"),
    COMPUTER_GRAPHICS_CARDS("Computer Graphics Cards"),
    TABLETS_AND_EREADERS("Tablets & eReaders"),
    LAPTOPS_AND_NETBOOKS("Laptops & Netbooks");

    private final String displayName;

    ElectronicsSubCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
} 