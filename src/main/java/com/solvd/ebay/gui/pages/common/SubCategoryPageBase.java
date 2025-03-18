package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SubCategoryPageBase extends AbstractPage {
    public SubCategoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListingPageBase selectCategory(String name);
}
