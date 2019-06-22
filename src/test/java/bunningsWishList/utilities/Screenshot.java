package bunningsWishList.utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void captureScreenshot(WebDriver driver, String screenShotName) {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(source, new File("./Screenshots/"+screenShotName+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while taking screenshot"+ e.getMessage());
		}


	}



}
