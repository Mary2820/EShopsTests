package com.solvd.ebay.gui.components.header;

import com.solvd.ebay.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends HeaderBase {
    @FindBy(id = "gh-ac")
    private ExtendedWebElement searchInput;

    @FindBy(id = "gh-search-btn")
    private ExtendedWebElement searchButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultsPageBase search(String searchText) {
        searchInput.clickIfPresent();
        searchInput.type(searchText);
        searchButton.click();
        return initPage(getDriver(), SearchResultsPageBase.class);
    }
}
