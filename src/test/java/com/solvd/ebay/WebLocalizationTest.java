package com.solvd.ebay;

import com.solvd.ebay.gui.pages.common.HomePageBase;
import com.solvd.ebay.gui.pages.desktop.HomeLocalePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.resources.L10N;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static com.solvd.ebay.data.Constants.TestData.SEARCH_TEXT;
import static com.solvd.ebay.data.Constants.TestData.COUNTRY_NAME;

import java.util.Locale;

public class WebLocalizationTest implements IAbstractTest {

    @BeforeClass
    public void testLocaleLoad() {
        Locale locale = L10N.getLocale();
        String loadedLocale = locale.getLanguage() + "_" + locale.getCountry();
        String configLocale = Configuration.getRequired(WebDriverConfiguration.Parameter.LOCALE);
        assertEquals(loadedLocale, configLocale);
    }

    @Test
    @MethodOwner(owner = "Marina")
    @TestLabel(name = "feature", value = "l10n")
    public void testLanguages() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();

        homePage.hoverOverSelectCountryButton();
        HomeLocalePage homeLocalePage = homePage.moveToHomeLocalePage(COUNTRY_NAME);
        homeLocalePage.inputText(SEARCH_TEXT);
        homeLocalePage.clickOnSearchButton();

        L10N.assertAll();
    }
}
