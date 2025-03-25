package com.solvd.yahoo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FinancePageBase extends AbstractPage {
    public FinancePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void hoverOverCategory(String categoryName);

    public abstract SubCategoryPageBase selectSubcategory(String name);
}
