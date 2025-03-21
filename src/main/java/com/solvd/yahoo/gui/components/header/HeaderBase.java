package com.solvd.yahoo.gui.components.header;

import com.solvd.yahoo.gui.pages.common.FinancePageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends AbstractUIObject {
    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract FinancePageBase clickOnFinanceLink();
}
