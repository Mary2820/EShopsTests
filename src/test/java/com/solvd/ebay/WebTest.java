package com.solvd.ebay;

import com.solvd.ebay.enums.homepage.Category;
import com.solvd.ebay.enums.serchresultpage.BuyingFormat;
import com.solvd.ebay.enums.serchresultpage.Condition;
import com.solvd.ebay.enums.subcategorypage.ComputerTabletsNetworkingSubCategory;
import com.solvd.ebay.enums.homepage.ElectronicsSubCategory;
import com.solvd.ebay.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static com.solvd.ebay.data.Constants.TestData.CARD_NUMBER;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

public class WebTest implements IAbstractTest, IAbstractDataProvider {
    private static final Logger LOGGER = LogManager.getLogger(WebTest.class.getName());

    @Test
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_EBAY_001")
    public void verifyProductDetailsFromListingToProductPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.hoverOverCategory(Category.ELECTRONICS.getDisplayName());
        SubCategoryPageBase categoryPage = homePage.selectSubcategory(ElectronicsSubCategory.
                COMPUTERS_TABLETS_NETWORK.getDisplayName());
        ProductListingPageBase productListingPage = categoryPage.selectCategory(ComputerTabletsNetworkingSubCategory.
                COMPONENTS_PARTS.getDisplayName());

        String title = productListingPage.getProductTitle(CARD_NUMBER);
        Double[] listingPrice = productListingPage.getProductPrice(CARD_NUMBER);
        LOGGER.info("Product from listing page - title: {}, price range: {} - {}", title, listingPrice[0], listingPrice[1]);

        ProductPageBase productPage = productListingPage.clickOnCard(CARD_NUMBER);
        String titleFromProductPage = productPage.getTitle();
        Double priceFromProductPage = productPage.getPrice();
        LOGGER.info("Product from product page - title: {}, price: {}", titleFromProductPage, priceFromProductPage);

        assertEquals(title, titleFromProductPage, "Product titles don't match");
        assertTrue(priceFromProductPage >= listingPrice[0] && priceFromProductPage <= listingPrice[1],
            "Product price is not within expected range");
    }

    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_EBAY_002")
    @XlsDataSourceParameters(path = "ebay/data_source/shippingAddress.xlsx", sheet = "address", dsUid = "TUID")
    public void verifySearchAndPurchaseItem(HashMap<String, String> testData) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SearchResultsPageBase searchResultsPage = homePage.search("bmw e30");

        searchResultsPage = searchResultsPage.chooseBuyingFormat(BuyingFormat.BUY_IT_NOW.getName());
        searchResultsPage = searchResultsPage.chooseCondition(Condition.NEW.getName());

        ProductPageBase productPage = searchResultsPage.clickOnCard(CARD_NUMBER);

        String titleForProductPage = productPage.getTitle();
        Double priceForProductPage = productPage.getPrice();

        AddToCartDialogPageBase addToCartDialogPage = productPage.clickOnAddToCartButton();
        CartPageBase cartPage = addToCartDialogPage.clickOnSeeInCartButton();
        String titleForCardPage = cartPage.getProductTitle(CARD_NUMBER);
        Double priceForCardPage = cartPage.getProductPrice(CARD_NUMBER);

        assertEquals(titleForProductPage, titleForCardPage, "Product titles don't match");
        assertEquals(priceForProductPage, priceForCardPage, "Product price is not within expected range");

        CheckoutSignInPopupPageBase checkoutSignInPopup = cartPage.clickOnGoToCheckoutButton();
        CheckoutPageBase checkoutPage = checkoutSignInPopup.clickContinueAsGuestButton();

        checkoutPage.fillUserInformation(testData);
        checkoutPage.clickOnDoneButton();

        checkoutPage.selectPayViaPayPal();
        checkoutPage.closeSelectCurrencyPopup();

        PayPalPageBase payPalPage = checkoutPage.clickOnPayViaPayPalButton();
        assertEquals(payPalPage.getHeaderText(), "Pay with PayPal");
    }
}
