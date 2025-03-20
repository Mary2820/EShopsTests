package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public abstract class CheckoutPageBase extends AbstractPage {
    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillUserInformation(Map<String, String> testData);

    public abstract void clickOnDoneButton();

    public abstract void selectPayViaPayPal();

    public abstract void clickOnPayViaPayPalButton();
}
