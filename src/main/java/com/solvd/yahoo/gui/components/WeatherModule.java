package com.solvd.yahoo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WeatherModule extends AbstractUIObject {
    @FindBy(css = "#grid-layout > div.weather-card-content.Pos\\(r\\) > a > u")
    private ExtendedWebElement seeMoreLink;

    public WeatherModule(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickOnSeeMoreLink() {
        seeMoreLink.clickIfPresent();
    }
}
