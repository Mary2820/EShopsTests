package com.solvd.yahoo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DayForecast extends AbstractUIObject {
    @FindBy(xpath = "//*[@id=\"module-weather-forecast\"]/table/tbody/tr/td[1]")
    private ExtendedWebElement dayOfWeek;

    public DayForecast(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//*[@id=\"module-weather-forecast\"]/table/tbody/tr/td[3]/dl/dd")
    private ExtendedWebElement amountOfPrecipitation;

    @FindBy(xpath = "//*[@id=\"module-weather-forecast\"]/table/tbody/tr/td[4]/dl/dd[1]")
    private ExtendedWebElement maxTemperature;

    @FindBy(xpath = "//*[@id=\"module-weather-forecast\"]/table/tbody/tr/td[4]/dl/dd[3]")
    private ExtendedWebElement minTemperature;

    @FindBy(xpath = "//*[@id=\"module-weather-forecast\"]/table/tbody/tr/td[5]")
    private ExtendedWebElement moreDetails;

    public String getDayOfWeek() {
        return dayOfWeek.getText();
    }

    public String getAmountOfPrecipitation() {
        return amountOfPrecipitation.getText();
    }

    public String getMaxTemperature() {
        return maxTemperature.getText();
    }

    public String getMinTemperature() {
        return minTemperature.getText();
    }

    public String getMoreDetails() {
        return moreDetails.getText();
    }
}
