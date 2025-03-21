package com.solvd.ebay.gui.pages.desktop;

import com.solvd.ebay.gui.pages.common.SubCategoryPageBase;
import com.solvd.ebay.gui.pages.common.ProductListingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SubCategoryPageBase.class)
public class SubCategoryPage extends SubCategoryPageBase {

    @FindBy(xpath = "//li/section/div/ul/li")
    private List<ExtendedWebElement> categoriesLinks;

    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductListingPageBase selectCategory(String name) {
        for (ExtendedWebElement link : categoriesLinks) {
            String current = link.getText();
            if (name.equalsIgnoreCase(current)) {
                link.click();
                return initPage(getDriver(), ProductListingPageBase.class);
            }
        }
        throw new RuntimeException("Unable to open page : " + name);
    }
}
