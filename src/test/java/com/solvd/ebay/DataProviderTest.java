//package com.solvd.ebay;
//
//import com.solvd.ebay.enums.homepage.Category;
//import com.solvd.ebay.enums.homepage.ElectronicsSubCategory;
//import com.solvd.ebay.enums.subcategorypage.ComputerTabletsNetworkingSubCategory;
//import com.solvd.ebay.gui.pages.common.HomePageBase;
//import com.solvd.ebay.gui.pages.common.ProductListingPageBase;
//import com.solvd.ebay.gui.pages.common.ProductPageBase;
//import com.solvd.ebay.gui.pages.common.SubCategoryPageBase;
//import com.zebrunner.carina.core.IAbstractTest;
//import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
//import com.zebrunner.carina.core.report.testrail.TestRailCases;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static com.solvd.ebay.data.Constants.TestData.CARD_NUMBER;
//import static org.testng.Assert.*;
//
//public class DataProviderTest implements IAbstractTest {
//
//    @DataProvider(name = "conditionOptions")
//    public Object[][] getConditionData() {
//        return new Object[][] {
//            {"TUID: 1", "testRail: 1", "Excellent", true},
//            {"TUID: 2", "testRail: 2", "Very Good", true},
//            {"TUID: 3", "testRail: 3", "Good", true},
//            {"TUID: 4", "testRail: 4", "Acceptable", true},
//            {"TUID: 5", "testRail: 5", "New", false}
//        };
//    }
//
//    @Test(dataProvider = "conditionOptions")
//    @MethodOwner(owner = "Marina")
//    @TestRailCases(testCasesId = "44")
//    public void testProductConditions(String TUID, String testRailColumn, String condition, boolean shouldExist) {
//        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
//        homePage.open();
//        assertTrue(homePage.isPageOpened(), "Home page is not opened");
//
//        homePage.hoverOverCategory(Category.ELECTRONICS.getDisplayName());
//        SubCategoryPageBase categoryPage = homePage.selectSubcategory(ElectronicsSubCategory.
//                COMPUTERS_TABLETS_NETWORK.getDisplayName());
//        ProductListingPageBase productListingPage = categoryPage.selectCategory(ComputerTabletsNetworkingSubCategory.
//                COMPONENTS_PARTS.getDisplayName());
//        ProductPageBase productPage = productListingPage.clickOnCard(CARD_NUMBER);
//
//        List<String> availableConditions = productPage.getAvailableConditions();
//        assertEquals(availableConditions.contains(condition), shouldExist,
//            String.format("Condition '%s' availability should be %s", condition, shouldExist));
//
//        // Выполняем выбор и проверку только для существующих опций
//        if (shouldExist) {
//            productPage.selectCondition(condition);
//            assertEquals(productPage.getSelectedCondition(), condition,
//                "Selected condition should match expected");
//        }
//    }
//}
