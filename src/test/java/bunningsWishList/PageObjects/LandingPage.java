package bunningsWishList.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import bunningsWishList.utilities.ReadConfig;

public class LandingPage {

	ReadConfig rc = new ReadConfig();
	public static WebDriver ldriver = null;

	public LandingPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	
	  By searchTextField= By.xpath("//div[@class='search-container_container']//input[@type='text']");
	  By searchButton= By.xpath("//*[@class='search-container_icon-search']");
	 

	/*@FindBy(xpath ="//div[@class='search-container_container']//input[@type='text']")
	WebElement searchTextField;

	@FindBy(xpath = "//div[@class='search-container_icon-search']")
	WebElement searchButton;*/

	public void enterTextInSearchField() {
		ldriver.findElement(searchTextField).sendKeys(rc.enterTextInResultfield());
	}

	public void clickSearchButton() {
		ldriver.findElement(searchButton).click();
	}

}
