package bunningsWishList.utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import bunningsWishList.testCases.BaseClass;

public class Screenshot extends BaseClass {

	public static void captureScreenshot(String result) {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(source, new File("./Screenshots/"+result+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while taking screenshot"+ e.getMessage());
		}


	}



}
