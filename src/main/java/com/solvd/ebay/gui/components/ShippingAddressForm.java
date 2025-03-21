package com.solvd.ebay.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShippingAddressForm extends AbstractUIObject {
    @FindBy(id = "country")
    private ExtendedWebElement countryDropdown;

    @FindBy(id = "firstName")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "lastName")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "addressLine1")
    private ExtendedWebElement addressField;

    @FindBy(id = "addressLine2")
    private ExtendedWebElement optionalAddressField;

    @FindBy(id = "city")
    private ExtendedWebElement cityField;

    @FindBy(id = "stateOrProvince")
    private ExtendedWebElement stateOrProvinceDropDown;

    @FindBy(id = "postalCode")
    private ExtendedWebElement postalCodeField;

    @FindBy(id = "email")
    private ExtendedWebElement emailField;

    @FindBy(id = "emailConfirm")
    private ExtendedWebElement emailConfirmField;

    @FindBy(id = "phoneCountryCode")
    private ExtendedWebElement phoneCountryCodeDropDown;

    @FindBy(id = "phoneNumber")
    private ExtendedWebElement phoneNumberField;

    @FindBy(xpath = "//button[@data-test-id='ADD_ADDRESS_SUBMIT']")
    private ExtendedWebElement doneButton;

    public ShippingAddressForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectCountry(String countryName) {
        if (countryDropdown.getText().equals(countryName)) {
            return;
        }
        countryDropdown.select(countryName);
    }

    public void typeFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameField.type(lastName);
    }

    public void typeAddress(String address) {
        addressField.type(address);
    }

    public void typeOptionalAddress(String optionalAddress) {
        optionalAddressField.type(optionalAddress);
    }

    public void typeCity(String city) {
        cityField.type(city);
    }

    public void selectStateOrProvince(String stateOrProvince) {
        stateOrProvinceDropDown.select(stateOrProvince);
    }

    public void typePostalCode(String postalCode) {
        postalCodeField.click();
        postalCodeField.type(postalCode);
    }

    public void typeEmail(String email) {
        emailField.type(email);
    }

    public void typeConfirmEmail(String email) {
        emailConfirmField.type(email);
    }

    public void selectPhoneCountryCode(String countryCode) {
        phoneCountryCodeDropDown.select(countryCode);
    }

    public void typePhoneNumber(String phoneNumber) {
        phoneNumberField.type(phoneNumber);
    }

    public void clickDoneButton() {
        doneButton.click();
    }
}
