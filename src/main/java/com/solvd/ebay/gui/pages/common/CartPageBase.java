package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {
    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductTitle(int number);

    public abstract Double getProductPrice(int number);

    public abstract CheckoutSignInPopupPageBase clickOnGoToCheckoutButton();
}
