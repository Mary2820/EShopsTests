package com.solvd.yahoo;

import com.solvd.yahoo.enums.PopularCity;
import com.solvd.yahoo.gui.pages.common.ForecastPageBase;
import com.solvd.yahoo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    public void test1(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage = homePage.openAndReturn();

        ForecastPageBase forecastPage = homePage.moveToForecastPage();
        forecastPage = forecastPage.selectLocationFromPopulars(PopularCity.NEW_YORK.getCityName());
        String locationTitle = forecastPage.getLocationTitle();
        Assert.assertEquals(locationTitle, PopularCity.NEW_YORK.getCityName());

        String minTemperature = forecastPage.getMinTemperature("Monday");
        String maxTemperature = forecastPage.getMaxTemperature("Monday");
        String moreDetails = forecastPage.getMoreDetails("Monday");

        Assert.assertTrue(moreDetails.contains(minTemperature),
                String.format("More details '%s' should contain min temperature '%s'", moreDetails, minTemperature));
        Assert.assertTrue(moreDetails.contains(maxTemperature),
                String.format("More details '%s' should contain max temperature '%s'", moreDetails, maxTemperature));

    }

}
