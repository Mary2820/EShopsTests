package com.solvd.yahoo.gui.pages.desktop;

import com.solvd.yahoo.gui.components.DayForecast;
import com.solvd.yahoo.gui.pages.common.ForecastPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ForecastPageBase.class)
public class ForecastPage extends ForecastPageBase {
    private static final Logger LOGGER = LogManager.getLogger(ForecastPage.class.getName());

    @FindBy(xpath = "//*[@id='module-weather-popular-locations']//a")
    private List<ExtendedWebElement> popularLocationsLinks;

    @FindBy(xpath = "//*[@id=\"module-location-heading\"]/div[1]/div/div[1]/h1")
    private ExtendedWebElement locationTitle;

    @FindBy(xpath = "//*[@id=\"module-weather-forecast\"]/table/tbody/tr")
    private List<DayForecast> dayForecasts;

    @FindBy(id = "module-weather-forecast")
    private ExtendedWebElement forecastModule;

    public ForecastPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ForecastPageBase selectLocationFromPopulars(String locationName){
        for (ExtendedWebElement location : popularLocationsLinks) {
            String current = location.getText();
            if (locationName.equalsIgnoreCase(current)) {
                location.click();
                return initPage(getDriver(), ForecastPageBase.class);
            }
        }
        LOGGER.error("Unable to open page for location : {}", locationName);
        return null;
    }

    @Override
    public String getLocationTitle() {
        return locationTitle.getText();
    }

    @Override
    public void scrollToForecastModule() {
        forecastModule.scrollTo();
    }

    @Override
    public DayForecast getDayForecast(String dayOfWeek) {
        for (DayForecast dayForecast : dayForecasts){
            dayForecast.scrollTo();
            String current = dayForecast.getDayOfWeekName();
            if (current.contains(dayOfWeek)) {
                return dayForecast;
            }
        }
        LOGGER.error("Unable to get day forecast for : {}", dayOfWeek);
        return null;
    }
}
