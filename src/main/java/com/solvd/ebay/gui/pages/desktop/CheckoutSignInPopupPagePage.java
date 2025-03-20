package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.pages.common.CheckoutPageBase;
import com.solvd.ebay.gui.pages.common.CheckoutSignInPopupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutSignInPopupPageBase.class)
public class CheckoutSignInPopupPagePage extends CheckoutSignInPopupPageBase {
    @FindBy(id = "gxo-btn")
    private ExtendedWebElement continueAsGuestButton;

    public CheckoutSignInPopupPagePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutPageBase clickContinueAsGuestButton() {
        continueAsGuestButton.clickIfPresent();
        return initPage(getDriver(), CheckoutPageBase.class);
    }
}
