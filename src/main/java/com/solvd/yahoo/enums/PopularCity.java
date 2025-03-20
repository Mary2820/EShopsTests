package com.solvd.yahoo.enums;

public enum PopularCity {
    NEW_YORK("New York"),
    LOS_ANGELES("Los Angeles"),
    CHICAGO("Chicago"),
    HOUSTON("Houston"),
    PHILADELPHIA("Philadelphia"),
    SAN_FRANCISCO("San Francisco"),
    MEXICO_CITY("Mexico City"),
    TOKYO("Tokyo"),
    SAO_PAULO("Sao Paulo"),
    LONDON("London"),
    PARIS("Paris"),
    VENICE("Venice");

    private final String cityName;

    PopularCity(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
