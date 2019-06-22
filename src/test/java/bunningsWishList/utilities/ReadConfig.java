package bunningsWishList.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig()
	{
		File src = new File ("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e){
			System.out.println("Exception is: " + e.getMessage());
		}
	}

	public String enterTextInResultfield()
	{
		String text = pro.getProperty("searchText");
		return text;

	}

	public int selectProductPosition()
	{
		String position = pro.getProperty("productPosition");
		return Integer.parseInt(position);

	}

	public String url()
	{
		String url = pro.getProperty("url");
		return url;
	}

	public String wishListButtontext()
	{
		String buttontext = pro.getProperty("wishListButtonText");
		return buttontext;
	}

}
