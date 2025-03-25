package com.solvd.yahoo.gui.pages.common;

import com.solvd.yahoo.gui.components.Chart;
import com.solvd.yahoo.gui.components.Tooltip;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TickerPageBase extends AbstractPage {

    public TickerPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Chart getChart();

    public abstract Tooltip getTooltip();
}
