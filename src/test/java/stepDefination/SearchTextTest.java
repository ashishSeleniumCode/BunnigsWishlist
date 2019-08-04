package stepDefination;

import bunningsWishList.PageObjects.LandingPage;
import bunningsWishList.PageObjects.ProductDetailsPage;
import bunningsWishList.PageObjects.SearchResultPage;
import bunningsWishList.PageObjects.WishListPage;
import bunningsWishList.testCases.BaseClass;
import bunningsWishList.utilities.ReadConfig;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchTextTest extends BaseClass {

	LandingPage searchText;
	SearchResultPage resultPage;
	ProductDetailsPage productDetails;
	WishListPage wishList;
	ReadConfig rc = new ReadConfig();
	private String productId;
	public static WebDriver driver = null;
	
	

	@Given("^User is on the Bunnings Landing page$")
	public void user_is_on_the_Bunnings_Landing_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bunnings.com.au/");
	}

	@When("^User enters the text in search box$")
	public void user_enters_the_text_in_search_box() throws Throwable {
		searchText = new LandingPage(driver);
		searchText.enterTextInSearchField();
		searchText.clickSearchButton();
		resultPage = new SearchResultPage(driver);
		resultPage.getSearchResultText();

	}

	@Then("^user is navigated to the search result page$")
	public void user_is_navigated_to_the_search_result_page() throws Throwable {
		Assert.assertEquals(rc.enterTextInResultfield(), resultPage.getSearchResultText());
	}

	@Given("^User is on the search page$")
	public void user_is_on_the_search_page() throws Throwable {
		resultPage= new SearchResultPage(driver);
		resultPage.clickOnProduct();
		
	}

	@Then("^Add it to the Wishist$")
	public void user_select_the_product() throws Throwable {
		productDetails = new ProductDetailsPage(driver);
		this.productId = productDetails.getProductIdNumber();
		productDetails.addItemToWishlist();
		productDetails.clickWishListLink();

	}

	@And("^Product should be added in the wishlist$")
	public void product_should_be_added_in_the_wishlist() throws Throwable {
		wishList = new WishListPage(driver);
		Assert.assertEquals(productId, wishList.getWishlistItemIdNumber());
	}

}
