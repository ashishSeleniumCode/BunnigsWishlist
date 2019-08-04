package bunningsWishList.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import bunningsWishList.utilities.RandomNumberGenerator;

public class SearchResultPage {

	public static WebDriver ldriver = null;
	RandomNumberGenerator rg = new RandomNumberGenerator();

	public SearchResultPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	/*@FindBy(xpath = "//span[@class='search-term']")
	WebElement getSearchText;*/
	
	By getSearchText = By.xpath("//span[@class='search-term']");

	public String getSearchResultText() {
		String SearchResultText = ldriver.findElement(getSearchText).getText();
		return SearchResultText;
	}

	public void clickOnProduct() {
		ldriver.findElement(
				By.xpath("//div[@class='product-list-group paged-items']//div[1]//div[1]//section[1]//article["
						+ rg.getRandomInteger() + "]//a[1]//div[1]//div[5]/div[1]//p[1]"))
		.click();
	}

}
