package com.solvd.yahoo.gui.pages.common;

import com.solvd.yahoo.gui.components.DayForecast;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ForecastPageBase extends AbstractPage {
    public ForecastPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ForecastPageBase selectLocationFromPopulars(String locationName);

    public abstract String getLocationTitle();

    public abstract void scrollToForecastModule();

    public abstract DayForecast getDayForecast(String dayOfWeek);
}
