package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"gdpr-banner-accept\"]")
    private ExtendedWebElement acceptCookies;

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void hoverOverCategory(String categoryName);

    @Override
    public void open() {
        super.open();
        acceptCookies.isPresent(20);
        acceptCookies.isClickable(10);
        acceptCookies.click();
    }

    public abstract SubCategoryPageBase selectSubcategory(String name);
}
