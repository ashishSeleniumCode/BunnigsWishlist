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

	public String getProductIdNumber() {
		String getProductIdText = ldriver.findElement(By.xpath("//span[@class='product-in']")).getText();
		System.out.println(getProductIdText);
		selectedProductId = getProductIdText;
		return getProductIdText;
	}

	public void addItemToWishlist() {
		ldriver.findElement(By.xpath("//span[contains(text(),'Add to Wish List')]")).click();
	}

	public void clickWishListLink() {
		WebDriverWait wait = new WebDriverWait(ldriver, 10);
		String wishListButtontext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Added')]"))).getText();
		if (wishListButtontext.equalsIgnoreCase(rc.wishListButtontext())) {
			ldriver.findElement(By.xpath("//a[@class='header_navbar-link header_navbar-link-wishlist']")).click();
		}

	}

}
