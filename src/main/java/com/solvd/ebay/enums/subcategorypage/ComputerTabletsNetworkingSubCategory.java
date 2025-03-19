package com.solvd.ebay.enums.subcategorypage;

public enum ComputerTabletsNetworkingSubCategory {
    PRINTERS_3D("3D Printers & Supplies"),
    CABLES_CONNECTORS("Computer Cables & Connectors"),
    COMPONENTS_PARTS("Computer Components & Parts"),
    DESKTOPS_ALL_IN_ONES("Desktops & All-In-Ones"),
    DRIVES_STORAGE("Drives, Storage & Blank Media"),
    ENTERPRISE_NETWORKING("Enterprise Networking, Servers"),
    HOME_NETWORKING("Home Networking & Connectivity"),
    KEYBOARDS_MICE("Keyboards, Mice & Pointers"),
    LAPTOP_ACCESSORIES("Laptop & Desktop Accessories"),
    LAPTOPS_NETBOOKS("Laptops & Netbooks"),
    MANUALS_RESOURCES("Manuals & Resources"),
    MIXED_LOTS("Mixed Lots"),
    MONITORS_PROJECTORS("Monitors, Projectors & Accs"),
    OTHER_COMPUTERS("Other Computers & Networking"),
    POWER_PROTECTION("Power Protection, Distribution"),
    PRINTERS_SCANNERS("Printers, Scanners & Supplies"),
    SOFTWARE("Software");

    private final String displayName;

    ComputerTabletsNetworkingSubCategory(String displayName) {
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