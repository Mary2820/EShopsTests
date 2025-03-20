package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.components.ShippingAddressForm;
import com.solvd.ebay.gui.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {
    @FindBy(xpath = "//div[@data-test-id='SHIPPING_ADDRESS_FORM']")
    private ShippingAddressForm shippingAddressForm;

    @FindBy(xpath = "//*[@class='payment-entry--PAYPAL payment-entry']")
    private ExtendedWebElement payPalPaymentEntry;

    @FindBy(id = "PAYPAL_CTA_BUTTON")
    private ExtendedWebElement payViaPayPalButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillUserInformation(Map<String, String> testData) {
        shippingAddressForm.selectCountry(testData.get("Country"));
        shippingAddressForm.typeFirstName(testData.get("FirstName"));
        shippingAddressForm.typeLastName(testData.get("LastName"));
        shippingAddressForm.typeAddress(testData.get("Address"));
        shippingAddressForm.typeCity(testData.get("City"));
        shippingAddressForm.selectStateOrProvince(testData.get("State/Province"));
        shippingAddressForm.typePostalCode(testData.get("PostCode"));
        shippingAddressForm.typeEmail(testData.get("Email"));
        shippingAddressForm.typeConfirmEmail(testData.get("Email"));
        shippingAddressForm.typePhoneNumber(testData.get("PhoneNumber"));
    }

    @Override
    public void clickOnDoneButton() {
        shippingAddressForm.clickDoneButton();
    }

    @Override
    public void selectPayViaPayPal() {
        payPalPaymentEntry.click();
    }

    @Override
    public void clickOnPayViaPayPalButton(){
        payViaPayPalButton.click();
    }
}
