package com.solvd.yahoo;

import com.solvd.yahoo.enums.PopularCity;
import com.solvd.yahoo.gui.components.DayForecast;
import com.solvd.yahoo.gui.pages.common.FinancePageBase;
import com.solvd.yahoo.gui.pages.common.ForecastPageBase;
import com.solvd.yahoo.gui.pages.common.HomePageBase;
import com.solvd.yahoo.gui.pages.common.MarketsOverviewPageBase;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static com.solvd.yahoo.data.Constants.TestData.DAY_OF_WEEK;

import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_YAHOO_001")
    public void verifyDayForecastOnForecastPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage = homePage.openAndReturn();

        ForecastPageBase forecastPage = homePage.moveToForecastPage();
        forecastPage = forecastPage.selectLocationFromPopulars(PopularCity.NEW_YORK.getCityName());
        String locationTitle = forecastPage.getLocationTitle();
        assertEquals(locationTitle, PopularCity.NEW_YORK.getCityName());
        forecastPage.scrollToForecastModule();
        DayForecast dayForecast = forecastPage.getDayForecast(DAY_OF_WEEK);

        assertTrue(dayForecast.isDayOfWeekNamePresent());
        assertTrue(dayForecast.isAmountOfPrecipitationPresent());
        assertTrue(dayForecast.isMaxTemperaturePresent());
        assertTrue(dayForecast.isMinTemperaturePresent());
        assertTrue(dayForecast.isMoreDetailsTextPresent());
    }

    @Test
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_YAHOO_002")
    public void verifyStockData() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage = homePage.openAndReturn();

        FinancePageBase financePage = homePage.moveToFinancePage();
        MarketsOverviewPageBase marketsOverviewPage = financePage.moveToMarketOverridePage();
        assertTrue(marketsOverviewPage.isPageOpened());
    }

}
