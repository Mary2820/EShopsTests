package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.pages.common.AddToCartDialogPageBase;
import com.solvd.ebay.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AddToCartDialogPageBase.class)
public class AddToCartDialogPage extends AddToCartDialogPageBase {
    @FindBy(xpath = "//div[@class='ux-section__item']/*[@class='ux-call-to-action fake-btn fake-btn--secondary']")
    private ExtendedWebElement seeInCartButton;

    public AddToCartDialogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickOnSeeInCartButton(){
        seeInCartButton.clickIfPresent();
        return initPage(getDriver(), CartPageBase.class);
    }
}
