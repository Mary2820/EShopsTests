package com.solvd.ebay.gui.components.footer;

import com.solvd.ebay.gui.pages.desktop.HomeLocalePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer extends FooterBase {
    private static final Logger LOGGER = LogManager.getLogger(Footer.class.getName());

    @FindBy(xpath = "//*[@id=\"glbfooter\"]//button")
    private ExtendedWebElement selectCountryButton;

    @FindBy(xpath = "//*[@id=\"s0-1-6-1-1-18[2[4]]-7-dialog\"]/div/ul/li/a/span")
    private List<ExtendedWebElement> countriesLinks;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hoverOverSelectCountryButton() {
        selectCountryButton.hover();
    }

    public HomeLocalePage moveToLocalHomePage(String countryName){
        for(ExtendedWebElement countryLink : countriesLinks) {
            String currentCountry = countryLink.getText();
            if (currentCountry.equals(countryName)) {
                countryLink.click();
                return new HomeLocalePage(getDriver());
            }
        }
        LOGGER.error("Unable to open page for  : {}", countryName);
        return null;
    }
}
