package com.solvd.ebay;

import com.solvd.ebay.enums.homepage.Category;
import com.solvd.ebay.enums.subcategorypage.ComputerTabletsNetworkingSubCategory;
import com.solvd.ebay.enums.homepage.ElectronicsSubCategory;
import com.solvd.ebay.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(WebTest.class.getName());

    @Test
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_EBAY_001")
    public void verifyProductDetailsFromListingToProductPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.hoverOverCategory(Category.ELECTRONICS.getDisplayName());
        SubCategoryPageBase categoryPage = homePage.selectSubcategory(ElectronicsSubCategory.
                COMPUTERS_TABLETS_NETWORK.getDisplayName());
        ProductListingPageBase productListingPage = categoryPage.selectCategory(ComputerTabletsNetworkingSubCategory.
                COMPONENTS_PARTS.getDisplayName());

        String title = productListingPage.getProductTitle(1);
        Double[] listingPrice = productListingPage.getProductPrice(1);
        LOGGER.info("Product from listing page - title: {}, price range: {} - {}", title, listingPrice[0], listingPrice[1]);

        ProductPageBase productPage = productListingPage.clickOnCard(1);
        String titleFromProductPage = productPage.getTitle();
        Double priceFromProductPage = productPage.getPrice();
        LOGGER.info("Product from product page - title: {}, price: {}", titleFromProductPage, priceFromProductPage);

        Assert.assertEquals(title, titleFromProductPage, "Product titles don't match");
        Assert.assertTrue(priceFromProductPage >= listingPrice[0] && priceFromProductPage <= listingPrice[1],
            "Product price is not within expected range");
    }

    @Test
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_EBAY_001")
    public void test2() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SearchResultsPageBase searchResultsPage = homePage.search("bmw e30");

        searchResultsPage = searchResultsPage.chooseBuyingFormat("Buy it now");
        searchResultsPage = searchResultsPage.chooseCondition("New");

        ProductPageBase productPage = searchResultsPage.clickOnCard(1);

        String titleForProductPage = productPage.getTitle();
        Double priceForProductPage = productPage.getPrice();

        AddToCartDialogPageBase addToCartDialogPage = productPage.clickOnAddToCartButton();
        CartPageBase cartPage = addToCartDialogPage.clickOnSeeInCartButton();
        String titleForCardPage = cartPage.getProductTitle(1);
        Double priceForCardPage = cartPage.getProductPrice(1);

        Assert.assertEquals(titleForProductPage, titleForCardPage, "Product titles don't match");
        Assert.assertEquals(priceForProductPage, priceForCardPage, "Product price is not within expected range");
    }

    @Test
    @MethodOwner(owner = "Marina")
    @TestRailCaseId("TC_EBAY_001")
    public void test3() {
        ProductPageBase productPage = initPage(getDriver(), ProductPageBase.class);
        productPage.open();

        try {
            Thread.sleep(5000);
            productPage.acceptCookies.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        AddToCartDialogPageBase addToCartDialogPage = productPage.clickOnAddToCartButton();
        CartPageBase cartPage = addToCartDialogPage.clickOnSeeInCartButton();
        CheckoutSignInPopupPageBase checkoutSignInPopup = cartPage.clickOnGoToCheckoutButton();
        checkoutSignInPopup.clickContinueAsGuestButton();


    }

}
