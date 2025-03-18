package com.solvd.ebay;

import com.solvd.ebay.gui.pages.common.ProductListingPageBase;
import com.solvd.ebay.gui.pages.common.ProductPageBase;
import com.solvd.ebay.gui.pages.common.SubCategoryPageBase;
import com.solvd.ebay.gui.pages.common.HomePageBase;
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

        homePage.hoverOverCategory("Electronics");
        SubCategoryPageBase categoryPage = homePage.selectSubcategory("Computers, Tablets & Network Hardware");
        ProductListingPageBase productListingPage = categoryPage.selectCategory("Computer Components & Parts");

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
}
