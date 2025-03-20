package com.solvd.yahoo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ForecastPageBase extends AbstractPage {
    public ForecastPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ForecastPageBase selectLocationFromPopulars(String locationName);

    public abstract String getLocationTitle();

    public abstract String getMaxTemperature(String dayOfWeek);

    public abstract String getMinTemperature(String dayOfWeek);

    public abstract String getMoreDetails(String dayOfWeek);
}
