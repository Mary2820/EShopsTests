package com.solvd.ebay.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItemForResultPage extends AbstractUIObject {
    @FindBy(xpath = "//*[@class='s-item__title']/span/span")
    private ExtendedWebElement title;

    public ProductItemForResultPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickOnTitle() {
        title.clickIfPresent();
    }
}
