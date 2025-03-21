package com.solvd.ebay.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchResultsPageBase extends AbstractPage {
    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchResultsPageBase chooseCondition(String conditionName);

    public abstract SearchResultsPageBase chooseBuyingFormat(String formatName);

    public abstract ProductPageBase clickOnCard(int number);
}
