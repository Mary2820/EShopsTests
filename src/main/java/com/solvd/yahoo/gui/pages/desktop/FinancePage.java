package com.solvd.yahoo.gui.pages.desktop;

import com.solvd.yahoo.gui.pages.common.FinancePageBase;
import com.solvd.yahoo.gui.pages.common.SubCategoryPageBase;
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

    @FindBy(xpath = "//*[@id=\"ybar-navigation\"]/div/ul/li[3]/div/ul/li/a/div")
    private List<ExtendedWebElement> marketSubcategoriesLinks;

    public FinancePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void hoverOverCategory(String categoryName) {
        for (ExtendedWebElement category : categoriesBar) {
            String currentCategoryName = category.getText();
            if (categoryName.equalsIgnoreCase(currentCategoryName)) {
                category.hover();
            }
        }
    }

    @Override
    public SubCategoryPageBase selectSubcategory(String name) {
        for (ExtendedWebElement link : marketSubcategoriesLinks) {
            String current = link.getText();
            if (name.equalsIgnoreCase(current)) {
                link.click();
                return initPage(getDriver(), SubCategoryPageBase.class);
            }
        }
        LOGGER.error("Unable to open page : {}", name);
        return null;
    }



}
