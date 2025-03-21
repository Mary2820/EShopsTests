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

    public boolean IsDayOfWeekNamePresent(){
        return dayOfWeekName.isPresent();
    }

    public boolean IsAmountOfPrecipitationPresent(){
        return amountOfPrecipitation.isPresent();
    }

    public boolean IsMaxTemperaturePresent(){
        return maxTemperature.isPresent();
    }

    public boolean IsMinTemperaturePresent(){
        return minTemperature.isPresent();
    }

    public boolean IsMoreDetailsTextPresent(){
        return moreDetails.isPresent();
    }
}
