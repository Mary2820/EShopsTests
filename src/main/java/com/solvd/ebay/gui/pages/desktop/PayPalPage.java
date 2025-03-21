package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.pages.common.PayPalPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PayPalPageBase.class)
public class PayPalPage extends PayPalPageBase {
    @FindBy(id = "headerText")
    private ExtendedWebElement headerText;

    public PayPalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getHeaderText() {
        return headerText.getText();
    }
}
