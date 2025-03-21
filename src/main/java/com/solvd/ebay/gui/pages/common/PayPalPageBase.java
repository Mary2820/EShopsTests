package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PayPalPageBase extends AbstractPage {
    public PayPalPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getHeaderText();
}
