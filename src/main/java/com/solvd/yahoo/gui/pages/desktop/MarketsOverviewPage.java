package com.solvd.yahoo.gui.pages.desktop;

import com.solvd.yahoo.gui.pages.common.MarketsOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = MarketsOverviewPageBase.class)
public class MarketsOverviewPage extends MarketsOverviewPageBase {
    public MarketsOverviewPage(WebDriver driver) {
        super(driver);
    }
}
