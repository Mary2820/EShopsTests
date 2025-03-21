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
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_YAHOO_001")
    public void verifyDayForecastOnForecastPage(){
        String dayOfWeek = "Monday";
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage = homePage.openAndReturn();

        ForecastPageBase forecastPage = homePage.moveToForecastPage();
        forecastPage = forecastPage.selectLocationFromPopulars(PopularCity.NEW_YORK.getCityName());
        String locationTitle = forecastPage.getLocationTitle();
        Assert.assertEquals(locationTitle, PopularCity.NEW_YORK.getCityName());
        forecastPage.scrollToForecastModule();
        DayForecast dayForecast = forecastPage.getDayForecast(dayOfWeek);

        Assert.assertTrue(dayForecast.IsDayOfWeekNamePresent());
        Assert.assertTrue(dayForecast.IsAmountOfPrecipitationPresent());
        Assert.assertTrue(dayForecast.IsMaxTemperaturePresent());
        Assert.assertTrue(dayForecast.IsMinTemperaturePresent());
        Assert.assertTrue(dayForecast.IsMoreDetailsTextPresent());
    }

    @Test
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_YAHOO_002")
    public void verifyStockData() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage = homePage.openAndReturn();

        FinancePageBase financePage = homePage.moveToFinancePage();
        MarketsOverviewPageBase marketsOverviewPage = financePage.moveToMarketOverridePage();
        Assert.assertTrue(marketsOverviewPage.isPageOpened());
    }

}
