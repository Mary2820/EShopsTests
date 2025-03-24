/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
