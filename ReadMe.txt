

								::: Bunnigs WishList Test scenario :::




Steps to execute the script:

1. Open the project in Eclipse.
2. Open the Testng.xml(Path: BunningsWishList/Testng.xml)
3. Now click on Run as button of eclipse and run the script as "BunningsWishList_Testng.xml" or Right click on the Testng.xml file and select Run As-->TestNG Suite
4. The script will execute and perform the desired task.


About the Project:

The project created is maven and framework used is TestNG which follows the Page Object model pattern. The url can be easily configured to different environment like Production, Testing or Staging using "config.properties" file. Also the search text entered, is configurable and can be changed at any point of time. 

Eclipse(Vesrion: Oxygen.3a) and Java is used as a language.


Framework Architecture:

The project is divided into following folder structure,

1. src/test/java Folder:
 It is further divided into 3 packages namely,
   bunningsWishList.PageObjects: All classes contains only webelement locators so in future it is easy to find elements and update.
   bunningsWishList.testCases: Contains two classes namely a Base class to perform Before and After class functionality and the Testcase class.
   bunningsWishList.utilities: As the name suggests it contains different types of utilities like ReadConfig, Screenshot, RandomNumber generation

2. Configuration folder: 
 It contains config.properties file which can be used to change the url, text to be entered in search field

3. Drivers folder: 
 It contains 3 drivers .exe namely, Chrome, Firefox and IE. The script can be executed in any one of the browser by changing the name in Testng.xml(Path: BunningsWishList/Testng.xml). For example below mentioned xml will execute chrome browser,
 
 <test name="WishList">
		<parameter name="browser" value="chrome" />
		<classes>
			<class name="bunningsWishList.testCases.TC_BunningsWishList" />
		</classes>
	</test>

4. 	Log folder: 
 Log folder as the name suggest will display the logs which can be used in case of script failure in future. 
 
5. Screeshot folder:
 It contains the screenshots as per given in the script. 
 
6. POM.xml:
 Contains muliple dependencies like, 
 -org.seleniumhq.selenium,
 -org.testng,
 -org.apache.poi etc

This helps to update the jar version in future by editing the POM.xml 
 







