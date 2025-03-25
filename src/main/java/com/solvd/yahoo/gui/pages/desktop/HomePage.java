package com.solvd.yahoo.gui.pages.desktop;

import com.solvd.yahoo.gui.components.WeatherModule;
import com.solvd.yahoo.gui.components.header.Header;
import com.solvd.yahoo.gui.pages.common.FinancePageBase;
import com.solvd.yahoo.gui.pages.common.ForecastPageBase;
import com.solvd.yahoo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(id = "ybar")
    private Header header;

    @FindBy(id = "module-weather")
    private WeatherModule weatherModule;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ForecastPageBase moveToForecastPage() {
        weatherModule.scrollTo();
        weatherModule.clickOnSeeMoreLink();
        return initPage(getDriver(), ForecastPageBase.class);
    }

    @Override
    public FinancePageBase moveToFinancePage() {
        return header.clickOnFinanceLink();
    }
}
