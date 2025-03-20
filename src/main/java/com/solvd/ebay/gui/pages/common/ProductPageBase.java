package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public  abstract class ProductPageBase extends AbstractPage {
    @FindBy(id = "gdpr-banner-accept")
    public ExtendedWebElement acceptCookies;


    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Double getPrice();

    public abstract String getTitle();

    public abstract AddToCartDialogPageBase clickOnAddToCartButton();
}
