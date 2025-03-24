package com.solvd.yahoo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DayForecast extends AbstractUIObject {
    @FindBy(xpath = "./td[1]")
    private ExtendedWebElement dayOfWeekName;

    public DayForecast(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "./td[3]/dl/dd")
    private ExtendedWebElement amountOfPrecipitation;

    @FindBy(xpath = "./td[4]/dl/dd[1]")
    private ExtendedWebElement maxTemperature;

    @FindBy(xpath = "./td[4]/dl/dd[3]")
    private ExtendedWebElement minTemperature;

    @FindBy(xpath = "./td[5]")
    private ExtendedWebElement moreDetails;

    public String getDayOfWeekName() {
        return dayOfWeekName.getText();
    }

    public boolean isDayOfWeekNamePresent(){
        return dayOfWeekName.isPresent();
    }

    public boolean isAmountOfPrecipitationPresent(){
        return amountOfPrecipitation.isPresent();
    }

    public boolean isMaxTemperaturePresent(){
        return maxTemperature.isPresent();
    }

    public boolean isMinTemperaturePresent(){
        return minTemperature.isPresent();
    }

    public boolean isMoreDetailsTextPresent(){
        return moreDetails.isPresent();
    }
}
