package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.components.ProductItemForListingPage;
import com.solvd.ebay.gui.pages.common.ProductListingPageBase;
import com.solvd.ebay.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductListingPageBase.class)
public class ProductListingPage extends ProductListingPageBase {

    @FindBy(xpath = "//div[@class='brwrvr__item-card__body']")
    private List<ProductItemForListingPage> productsCards;

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    private ProductItemForListingPage getProductItemByOrder(int number) {
        return productsCards.get(number - 1);
    }

    @Override
    public String getProductTitle(int number) {
        return getProductItemByOrder(number).getTitle();
    }

    @Override
    public Double[] getProductPrice(int number) {
        return getProductItemByOrder(number).getPrice();
    }

    @Override
    public ProductPageBase clickOnCard(int number) {
        getProductItemByOrder(number).clickOnTitle();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
