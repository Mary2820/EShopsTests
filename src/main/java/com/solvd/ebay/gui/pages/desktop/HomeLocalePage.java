package com.solvd.ebay.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.checkerframework.checker.i18n.qual.Localized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomeLocalePage extends AbstractPage {
    @Localized
    @FindBy(xpath = "//input[@id='gh-ac']")
    private ExtendedWebElement searchInput;

    @Localized
    @FindBy(xpath = "//*[@id=\"gh-search-btn\"]/span")
    private ExtendedWebElement searchButton;

    public HomeLocalePage(WebDriver driver) {
        super(driver);
    }

    public void inputText(String text) {
        searchInput.type(text);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }
}
