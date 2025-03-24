package com.solvd.yahoo.gui.pages.desktop;

import com.solvd.yahoo.enums.financepage.Category;
import com.solvd.yahoo.gui.pages.common.FinancePageBase;
import com.solvd.yahoo.gui.pages.common.ForecastPageBase;
import com.solvd.yahoo.gui.pages.common.MarketsOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = FinancePageBase.class)
public class FinancePage extends FinancePageBase {
    private static final Logger LOGGER = LogManager.getLogger(FinancePage.class.getName());
    @FindBy(xpath = "//div[@id='ybar-navigation']//span")
    private List<ExtendedWebElement> categoriesBar;

    public FinancePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MarketsOverviewPageBase moveToMarketOverridePage() {
        for (ExtendedWebElement category : categoriesBar) {
            String currentCategoryName = category.getText();
            if (currentCategoryName.equalsIgnoreCase(Category.MARKETS.getDisplayName())) {
                category.click();
                return initPage(getDriver(), MarketsOverviewPageBase.class);
            }
        }
        LOGGER.error("Unable to open Markets Overview page ");
        return null;
    }



}
