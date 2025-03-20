package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.components.header.Header;
import com.solvd.ebay.gui.pages.common.SearchResultsPageBase;
import com.solvd.ebay.gui.pages.common.SubCategoryPageBase;
import com.solvd.ebay.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class.getName());

    @FindBy(className = "gh-header__main")
    private Header header;

    @FindBy(xpath = "//*[@id=\"vl-flyout-nav\"]/ul/li")
    private List<ExtendedWebElement> categoriesBar;

    @FindBy(xpath = "//*[@id=\"vl-flyout-nav\"]/ul/li[4]/div[2]/div[1]/nav[1]/ul/li/a")
    private List<ExtendedWebElement> subcategoryLinks;

    public HomePage(WebDriver driver) {
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
        for (ExtendedWebElement link : subcategoryLinks) {
            String current = link.getText();
            if (name.equalsIgnoreCase(current)) {
                link.click();
                return initPage(getDriver(), SubCategoryPageBase.class);
            }
        }
        LOGGER.error("Unable to open page : {}", name);
        return null;
    }

    public Header getHeader() {
        return header;
    }

    @Override
    public SearchResultsPageBase search(String searchText) {
        return getHeader().search(searchText);
    }
}
