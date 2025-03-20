package com.solvd.ebay.gui.components;

import com.solvd.ebay.utils.PriceUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItemForCartPage extends AbstractUIObject {
    @FindBy(xpath = "//*[@class='grid-item-title']//a")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@class='item-price font-title-3']/span/span/span")
    private ExtendedWebElement price;

    public ProductItemForCartPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }

    public Double getPrice() {
        String text = price.getText();
        return PriceUtils.extractPriceAsDouble(text);
    }

    public void clickOnTitle() {
        title.clickIfPresent();
    }
}
