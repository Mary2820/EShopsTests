package com.solvd.yahoo.gui.pages.desktop;

import com.solvd.yahoo.gui.pages.common.SubCategoryPageBase;
import com.solvd.yahoo.gui.pages.common.TickerPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SubCategoryPageBase.class)
public class StocksPage extends SubCategoryPageBase {
    private static final Logger LOGGER = LogManager.getLogger(StocksPage.class.getName());

    @FindBy(xpath = "//*[@data-testid='table-container']//span[@class='symbol yf-1fqyif7']")
    private List<ExtendedWebElement> tickerLinks;

    public StocksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TickerPageBase selectTickerByName(String tickerName) {
        for (ExtendedWebElement link : tickerLinks) {
            String current = link.getText();
            if (current.equals(tickerName)) {
                link.click();
                return initPage(getDriver(), TickerPageBase.class);
            }
        }
        LOGGER.error("Unable to move to page for : {}", tickerName);
        return null;
    }
}
