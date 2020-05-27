package qa.ProPine;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import qa.utility.PropertyReader;


public class BasePropine {
	public static WebDriver driver;
	public static Properties propertiesFile;
	

	/*
	 * Constructor for load from Initialization of base class
	 */
	public BasePropine() {

		PropertyReader pro = new PropertyReader();
		propertiesFile = pro.PropertyReaderfile();

	}

	public void launchBrowser(String url) throws InterruptedException {

		
		// Read File for Operating System
		String os = propertiesFile.getProperty("OS");
		
		// Read Property For Browser Selection
		String browserName = propertiesFile.getProperty("browserName");
	


		// Condition for Select Operating System
		if (os.equalsIgnoreCase("window")) {

			// condition for launch chrome browser
			if (browserName.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver81.exe");
				System.setProperty("webdriver.chrome.silentOutput", "true");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();

			} else {

				System.out.println("unable to find chrome browser");

			}
		}

		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
		// Maximize the window
		driver.manage().window().maximize();
		// Enter url of the website
		driver.navigate().to(url);
		
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);

		

	}


}
