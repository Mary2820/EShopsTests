package com.solvd.ebay.gui.components.footer;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterBase extends AbstractUIObject {
    public FooterBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
