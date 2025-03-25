package com.solvd.yahoo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SubCategoryPageBase extends AbstractPage {
    public SubCategoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TickerPageBase selectTickerByName(String tickerName);
}
