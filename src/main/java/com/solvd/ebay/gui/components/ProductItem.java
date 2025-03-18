package com.solvd.ebay.gui.components;

import com.solvd.ebay.utils.PriceUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(ProductItem.class.getName());

    @FindBy(xpath = "//*[@class='bsig__title']/a/h3")
    private ExtendedWebElement title;
    
    @FindBy(xpath = "//span[@class='textual-display bsig__price bsig__price--displayprice']")
    private ExtendedWebElement price;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }

    public Double[] getPrice() {
        String text = price.getText();
        LOGGER.info("price before convert : {}", text);
        return PriceUtils.extractPriceRange(text);
    }

    public void clickOnTitle() {
        title.clickIfPresent();
    }
}
