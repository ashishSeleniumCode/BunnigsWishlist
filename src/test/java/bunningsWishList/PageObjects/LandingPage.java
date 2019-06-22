package bunningsWishList.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import bunningsWishList.utilities.ReadConfig;

public class LandingPage {

	ReadConfig rc = new ReadConfig();
	public static WebDriver ldriver = null;

	public LandingPage(WebDriver rdriver)
	{
		ldriver=rdriver;
	}


	public void enterTextInSearchField() 
	{
		ldriver.findElement(By.xpath("//div[@class='search-container_container']//input[@type='text']")).sendKeys(rc.enterTextInResultfield());
	}


	public void clickSearchButton() 
	{
		ldriver.findElement(By.xpath("//*[@class='search-container_icon-search']")).click();
	}

}
