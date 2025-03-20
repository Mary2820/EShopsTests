package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AddToCartDialogPageBase extends AbstractPage {
    public AddToCartDialogPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase clickOnSeeInCartButton();
}
