package bunningsWishList.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage {

	public static WebDriver ldriver = null;
	public WishListPage(WebDriver rdriver)
	{
		ldriver=rdriver;
	}


	public String getWishlistItemIdNumber() 
	{
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("scroll(0, 550);");
		String idOfProductInWishlist = null;
		List <WebElement> totalCount= ldriver.findElements(By.xpath("//small[@class='fineline']"));
		System.out.println(totalCount.size());
		for (int i=1;i<=totalCount.size();i++)
		{
			idOfProductInWishlist= ldriver.findElement(By.xpath("//tr["+i+"]//td[2]//small[@class='fineline']")).getText();
			System.out.println(idOfProductInWishlist); 
			if (idOfProductInWishlist.equals(ProductDetailsPage.selectedProductId) )
			{
				return idOfProductInWishlist;

			}
		}	
		return null;

	}

}
