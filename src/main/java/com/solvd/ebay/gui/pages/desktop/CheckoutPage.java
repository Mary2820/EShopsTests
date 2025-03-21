package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.components.ShippingAddressForm;
import com.solvd.ebay.gui.pages.common.CheckoutPageBase;
import com.solvd.ebay.gui.pages.common.PayPalPageBase;
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

    @FindBy(xpath = "//*[@data-test-id='PAYPAL_CTA_BUTTON']//button")
    private ExtendedWebElement payViaPayPalButton;

    @FindBy(xpath = "//button[@class='icon-btn lightbox-dialog__close']")
    private ExtendedWebElement closeSelectCurrencyPopupButton;

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
    public PayPalPageBase clickOnPayViaPayPalButton(){
        payViaPayPalButton.click();
        return initPage(getDriver(), PayPalPageBase.class);
    }

    @Override
    public void closeSelectCurrencyPopup() {
        closeSelectCurrencyPopupButton.click();
    }
}
