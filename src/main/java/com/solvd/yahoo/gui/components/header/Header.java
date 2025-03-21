package com.solvd.yahoo.gui.components.header;

import com.solvd.yahoo.gui.pages.common.FinancePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class Header extends HeaderBase{
    @FindBy(xpath = "//*[@id=\"ybar-l1-nav\"]/li[2]/a")
    private ExtendedWebElement financeLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public FinancePageBase clickOnFinanceLink() {
        financeLink.click();
        return initPage(getDriver(), FinancePageBase.class);
    }
}
