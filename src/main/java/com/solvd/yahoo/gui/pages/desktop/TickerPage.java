package com.solvd.yahoo.gui.pages.desktop;

import com.solvd.yahoo.gui.components.Chart;
import com.solvd.yahoo.gui.components.Tooltip;
import com.solvd.yahoo.gui.pages.common.TickerPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = TickerPageBase.class)
public class TickerPage extends TickerPageBase {
    @FindBy(xpath = "//*[@data-testid='chart-container']")
    private Chart chart;

    @FindBy(xpath = "//table[contains(@class, 'hu-tooltip')]")
    private Tooltip tooltip;

    public TickerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Chart getChart() {
        return chart;
    }

    @Override
    public Tooltip getTooltip() {
        return tooltip;
    }

}
