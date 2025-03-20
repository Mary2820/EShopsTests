package com.solvd.ebay.gui.components.header;

import com.solvd.ebay.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends AbstractUIObject {
    public HeaderBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchResultsPageBase search(String searchText);
}
