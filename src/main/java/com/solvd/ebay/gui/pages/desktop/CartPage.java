package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.components.ProductItemForCartPage;
import com.solvd.ebay.gui.pages.common.CartPageBase;
import com.solvd.ebay.gui.pages.common.CheckoutSignInPopupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    @FindBy(xpath = "//ul[@class=\"cart-bucket__vendor-list\"]/li/div")
    private List<ProductItemForCartPage> productsCards;

    @FindBy(xpath = "//*[@data-test-id='cta-top']")
    private ExtendedWebElement goToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductTitle(int number) {
        return getProductItemByOrder(number).getTitle();
    }

    @Override
    public Double getProductPrice(int number) {
        return getProductItemByOrder(number).getPrice();
    }

    @Override
    public CheckoutSignInPopupPageBase clickOnGoToCheckoutButton() {
        goToCheckoutButton.clickIfPresent();
        return initPage(getDriver(), CheckoutSignInPopupPageBase.class);
    }

    private ProductItemForCartPage getProductItemByOrder(int number) {
        return productsCards.get(number - 1);
    }
}
