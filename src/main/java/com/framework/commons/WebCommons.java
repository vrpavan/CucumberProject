package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.webdriver.WebDriverClass;

public class WebCommons {
	
	public WebDriver driver = WebDriverClass.getDriver();

	// To perform click action after scrolling to target element
	public void Click(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()" , element);
		element.click();
	}
	
	// To enter text after scrolling to target element and clearing the auto filled text
	public void EnterText(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()" , element);
		element.clear();
		element.sendKeys(value);
	}
	
	//Method to select check box
	public void SelectCheckbox(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		if(!element.isSelected())	
			element.click();
	}
	
	//Method to select option from drop down
	public void SelectOption(WebElement element,String option , String By) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		Select s = new Select(element);
		if(By.equalsIgnoreCase("Index")) {
			s.selectByIndex(Integer.parseInt(option));
		}else if(By.equalsIgnoreCase("value")) {
			s.selectByValue(option);
		}else if(By.equalsIgnoreCase("VisibleText")) {
			s.selectByVisibleText(option);
		}
	}
	
	//Method to perform double click
	public void DoubleClick(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
	//Method to perform right click
	public void RightClick(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}
	
	//Method to switch to alert 
	public void SwitchToAlert(String action) {
		Alert alert = driver.switchTo().alert();
		if(action.equalsIgnoreCase("Ok")) {
			alert.accept();
		}else if(action.equalsIgnoreCase("Cancel")) {
			alert.dismiss();
		}		
	}
	
	//Method to get title	
	public String getTitle() {
		return driver.getTitle();
	}
	
	//Method to wait for element (explicit) using Locator
	public void WaitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	//Method to wait for element (explicit) using WebElement
	public void WaitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Method to take screenshot
	public static String takeScreenshot(String screenshotname, WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot)driver; //to take screenshot
		File screenshotfile = screen.getScreenshotAs(OutputType.FILE); //to convert screenshot into file format
		String screenshotpath = System.getProperty("user.dir") + "\\TestScreenshots\\"+screenshotname+uniqueId()+".png"; //collect the folder path to store screenshot
		FileUtils.copyFile(screenshotfile, new File(screenshotpath));// copy screenshot file into folderpath		
		return screenshotpath;
	}
	
	
	//Method to generate unique id
	public static String uniqueId() {
		SimpleDateFormat s = new SimpleDateFormat("MMddyyhhmmss");
		String uniqueid = s.format(Calendar.getInstance().getTime());
		return uniqueid;
	}

}
