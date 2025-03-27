package com.solvd.yahoo;

import com.solvd.yahoo.enums.PopularCity;
import com.solvd.yahoo.enums.financepage.Category;
import com.solvd.yahoo.gui.components.Chart;
import com.solvd.yahoo.gui.components.DayForecast;
import com.solvd.yahoo.gui.components.Tooltip;
import com.solvd.yahoo.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static com.solvd.yahoo.data.Constants.TestData.DAY_OF_WEEK;
import static com.solvd.yahoo.data.Constants.TestData.SUBCATEGORY;
import static com.solvd.yahoo.enums.TooltipField.*;

import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "stockTestData")
    public Object[][] getTestData() {
        return new Object[][] {
                {"TSLA", "1D", 0.1, 0.9},
                {"LCID", "5D", 0.5, 0.7},
                {"IQ", "1M", 0.8, 0.9},
                {"F", "6M", 0.7, 0.6},
                {"NIO", "YTD", 0.6, 0.8},
                {"GME", "1Y", 0.6, 0.6},
                {"PLTR", "5Y", 0.5, 0.7},
                {"SOFI", "All", 0.9, 0.9},
        };
    }

    @Test(dataProvider = "stockTestData")
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_YAHOO_002")
    public void verifyStockData(String tickerName, String period, double xPosition, double yPosition) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage = homePage.openAndReturn();

        FinancePageBase financePage = homePage.moveToFinancePage();
        financePage.hoverOverCategory(Category.MARKETS.getDisplayName());
        SubCategoryPageBase stockPage = financePage.selectSubcategory(SUBCATEGORY);
        TickerPageBase tickerPage = stockPage.selectTickerByName(tickerName);
        Chart chart = tickerPage.getChart();
        chart.selectPeriod(period);
        chart.hoverAndClickOnPointOnChart(xPosition, yPosition);

        Tooltip tooltip = tickerPage.getTooltip();

        assertTrue(tooltip.isPresent());
        assertTrue(tooltip.getDateFieldName().equalsIgnoreCase(DATE.getFieldName()));
        assertTrue(tooltip.getCloseFieldName().equalsIgnoreCase(CLOSE.getFieldName()));
        assertTrue(tooltip.getOpenFieldName().equalsIgnoreCase(OPEN.getFieldName()));
        assertTrue(tooltip.getHighFieldName().equalsIgnoreCase(HIGH.getFieldName()));
        assertTrue(tooltip.getLowFieldName().equalsIgnoreCase(LOW.getFieldName()));
        assertTrue(tooltip.getVolumeFieldName().equalsIgnoreCase(VOLUME.getFieldName()));
    }
}
