package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public  abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Double getPrice();

    public abstract String getTitle();

    public abstract AddToCartDialogPageBase clickOnAddToCartButton();
}
