package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
}
