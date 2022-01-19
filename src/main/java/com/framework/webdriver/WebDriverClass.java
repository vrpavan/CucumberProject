package com.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.framework.utilities.ReadDataFromPropFile;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverClass {
	
	private static WebDriver driver = null;
	
	// Method to launch browser and application and give you the browser session in return
	@Before  // similar to before test
	public static synchronized void setubBrowser() {
		String browsername = ReadDataFromPropFile.readProperties("Config.properties").getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browsername.equals("fireox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}
	
	
	//Method to close browser
	@After
	public static synchronized void closeBrowser() {
		driver.quit();
	}
	
	//to share valid session with all other classes in framework
	public static WebDriver getDriver() {
		return driver;
	}
}
