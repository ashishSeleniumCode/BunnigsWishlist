package bunningsWishList.testCases;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import bunningsWishList.utilities.ReadConfig;


public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String url = rc.url();
	public static WebDriver driver = null;
	public static Logger logger;


	@Parameters("browser")

	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("Bunnings");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
		}

		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
		}

		else if (br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
		logger.info("Browser opened");
	}

	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}


}
