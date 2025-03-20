package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.pages.common.AddToCartDialogPageBase;
import com.solvd.ebay.gui.pages.common.ProductPageBase;
import com.solvd.ebay.utils.PriceUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    private static final Logger LOGGER = LogManager.getLogger(ProductPage.class.getName());

    @FindBy(xpath = "//*[@class='x-item-title__mainTitle']/span")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@class='x-price-primary']/span")
    private ExtendedWebElement price;

    @FindBy(id = "atcBtn_btn_1")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Double getPrice() {
        String text = price.getText();
        LOGGER.info("price before convert : {}", text);
        return PriceUtils.extractPriceAsDouble(text);
    }

    @Override
    public String getTitle() {
        return title.getText();
    }

    @Override
    public AddToCartDialogPageBase clickOnAddToCartButton() {
        addToCartButton.clickIfPresent();
        return initPage(getDriver(), AddToCartDialogPageBase.class);
    }

}
