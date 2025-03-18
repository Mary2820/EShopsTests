package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductListingPageBase extends AbstractPage {

    public ProductListingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductTitle(int number);

    public abstract Double[] getProductPrice(int number);

    public abstract ProductPageBase clickOnCard(int number);
}
