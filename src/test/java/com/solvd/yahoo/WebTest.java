package com.solvd.yahoo;

import com.solvd.yahoo.enums.PopularCity;
import com.solvd.yahoo.gui.components.DayForecast;
import com.solvd.yahoo.gui.pages.common.ForecastPageBase;
import com.solvd.yahoo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
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

}
