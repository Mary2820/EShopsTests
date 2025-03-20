package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(id = "gdpr-banner-accept")
    private ExtendedWebElement acceptCookies;

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void hoverOverCategory(String categoryName);

    @Override
    public void open() {
        super.open();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitUntil(ExpectedConditions.presenceOfElementLocated(acceptCookies.getBy()), 10);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(acceptCookies.getBy()), 10);
        waitUntil(ExpectedConditions.elementToBeClickable(acceptCookies.getBy()), 10);
        acceptCookies.click();
    }

    public abstract SubCategoryPageBase selectSubcategory(String name);

    public abstract SearchResultsPageBase search(String searchText);
}
