package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutSignInPopupPageBase extends AbstractPage {
    public CheckoutSignInPopupPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutPageBase clickContinueAsGuestButton();
}
