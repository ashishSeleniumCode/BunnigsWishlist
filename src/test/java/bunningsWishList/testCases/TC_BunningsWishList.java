package bunningsWishList.testCases;

import org.testng.annotations.Test;

import bunningsWishList.PageObjects.LandingPage;
import bunningsWishList.PageObjects.ProductDetailsPage;
import bunningsWishList.PageObjects.SearchResultPage;
import bunningsWishList.PageObjects.WishListPage;
import org.junit.Assert;

public class TC_BunningsWishList extends BaseClass {

	LandingPage searchField;
	SearchResultPage result;
	ProductDetailsPage productDetails;
	WishListPage wishList;

	@Test(priority = 1)
	public void verifySearchresultText() {
		searchField = new LandingPage(driver);
		result = new SearchResultPage(driver);
		searchField.enterTextInSearchField();
		logger.info("Text entered successfully in the text field");
		searchField.clickSearchButton();
		logger.info("Search button clicked successfully");
		result.getSearchResultText();
		Assert.assertEquals("Test case Passed successfully", rc.enterTextInResultfield(), result.getSearchResultText());
		logger.info("Assertion applied successfully");
		//Screenshot.captureScreenshot(driver, "SearchPage");
		//logger.info("Search result page screenshot");
		result.clickOnProduct();
		logger.info("Item selected successfully");
	}

	@Test(priority = 2)
	public void verifyProductAddedToWishlist() {
		productDetails = new ProductDetailsPage(driver);
		String productId = productDetails.getProductIdNumber();
		productDetails.addItemToWishlist();
		logger.info("Item added to Wishlist successfully");
		productDetails.clickWishListLink();
		logger.info("Wishlist link clicked successfully");
		wishList = new WishListPage(driver);
		Assert.assertEquals("Product id matches successfully", productId, wishList.getWishlistItemIdNumber());
		logger.info("Assertion applied successfully");
		//Screenshot.captureScreenshot(driver, "Wishlist");
		logger.info("Wishlist page screenshot");
	}

}
