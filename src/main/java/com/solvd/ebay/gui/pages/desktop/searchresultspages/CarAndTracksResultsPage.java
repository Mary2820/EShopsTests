package com.solvd.ebay.gui.pages.desktop.searchresultspages;

import com.solvd.ebay.gui.components.ProductItemForResultPage;
import com.solvd.ebay.gui.pages.common.ProductPageBase;
import com.solvd.ebay.gui.pages.common.SearchResultsPageBase;
import com.solvd.ebay.utils.WindowUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultsPageBase.class)
public class CarAndTracksResultsPage extends SearchResultsPageBase {
    @FindBy(xpath = "//*[@id=\"x-refine__group__3\"]/ul/li/div/a/div/div/div/span[1]")
    private List<ExtendedWebElement> conditionFilter;

    @FindBy(xpath = "//*[@id=\"x-refine__group__4\"]/ul/li/div/a/div/div/span[1]")
    private List<ExtendedWebElement> buyingFormatFilter;

    @FindBy(xpath = "//*[@class='srp-results srp-list clearfix']//*[@class='s-item__wrapper clearfix']")
    private List<ProductItemForResultPage> productsCards;

    @FindBy(xpath = "//*[@class='tourtip__overlay']//button")
    private ExtendedWebElement popupCloseButton;

    public CarAndTracksResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultsPageBase chooseCondition(String conditionName) {
        for (ExtendedWebElement condition : conditionFilter) {
            condition.scrollTo();
            String current = condition.getText();
            if (current.contains(conditionName)) {
                condition.click();
                return initPage(getDriver(), SearchResultsPageBase.class);
            }
        }
        return this;
    }

    @Override
    public SearchResultsPageBase chooseBuyingFormat(String formatName) {
        for (ExtendedWebElement format : buyingFormatFilter) {
            format.scrollTo();
            String current = format.getText();
            if (formatName.equalsIgnoreCase(current)) {
                format.click();
                return initPage(getDriver(), SearchResultsPageBase.class);
            }
        }
        return this;
    }

    private ProductItemForResultPage getProductItemByOrder(int number) {
        return productsCards.get(number - 1);
    }

    @Override
    public void closePopup() {
        popupCloseButton.click();
    }

    @Override
    public ProductPageBase clickOnCard(int number) {
        getProductItemByOrder(number).clickOnTitle();
        WindowUtils.switchToNewTabAndCloseOld(getDriver());

        return initPage(getDriver(), ProductPageBase.class);
    }
}
