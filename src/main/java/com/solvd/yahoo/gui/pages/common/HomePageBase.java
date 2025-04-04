package com.solvd.yahoo.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageBase extends AbstractPage {
    @FindBy(id = "scroll-down-btn")
    private ExtendedWebElement scrollDownButton;

    @FindBy(xpath = "//button[@class='btn secondary accept-all ']")
    private ExtendedWebElement acceptCookiesButton;

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open(){
        super.open();

        scrollDownButton.clickIfPresent();
        acceptCookiesButton.clickIfPresent();
    }

    public HomePageBase openAndReturn(){
        open();
        return initPage(getDriver(), HomePageBase.class);
    }

    public abstract ForecastPageBase moveToForecastPage();

    public abstract FinancePageBase moveToFinancePage();
}
