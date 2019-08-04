package bunningsWishList.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bunningsWishList.utilities.ReadConfig;

public class ProductDetailsPage {

	public static String selectedProductId = null;
	public static WebDriver ldriver = null;
	ReadConfig rc = new ReadConfig();

	public ProductDetailsPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	/*@FindBy(xpath = "//span[@class='product-in']")
	WebElement productId;

	@FindBy(xpath = "//span[contains(text(),'Add to Wish List')]")
	WebElement wishList;

	@FindBy(xpath = "//span[contains(text(),'Added')]")
	WebElement addedButton;

	@FindBy(xpath = "//a[@class='header_navbar-link header_navbar-link-wishlist']")
	WebElement wishListButton;*/
	
	

	By productId = By.xpath("//span[@class='product-in']");
	By wishList = By.xpath("//span[contains(text(),'Add to Wish List')]");
	By addedButton = By.xpath("//span[contains(text(),'Added')]");
	By wishListButton = By.xpath("//a[@class='header_navbar-link header_navbar-link-wishlist']");
	
	public String getProductIdNumber() {
		String getProductIdText = ldriver.findElement(productId).getText();
		System.out.println(getProductIdText);
		selectedProductId = getProductIdText;
		return getProductIdText;
	}

	public void addItemToWishlist() {
		ldriver.findElement(wishList).click();
	}

	public void clickWishListLink() {
		WebDriverWait wait = new WebDriverWait(ldriver, 10);
		String wishListButtontext = wait.until(ExpectedConditions.visibilityOfElementLocated((By) addedButton))
				.getText();
		if (wishListButtontext.equalsIgnoreCase(rc.wishListButtontext())) {
			ldriver.findElement(wishListButton).click();
		}

	}

}
