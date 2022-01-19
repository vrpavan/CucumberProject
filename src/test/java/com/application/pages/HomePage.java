package com.application.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.framework.commons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class HomePage extends WebCommons{
	
	@FindBy(xpath ="//a[@id='welcome']")
	private WebElement welcomeLabel;
	
	private By bywelcomeLabel = By.xpath("//a[@id='welcome']");
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	private By bylogoutButton = By.xpath("//a[text()='Logout']");

	private By byLoginPanelHeading = By.xpath("//div[@id='logInPanelHeading']");
		
		
	public void verifyApplicationLogout() throws IOException {
		try {
			WaitForElement(bywelcomeLabel);
			Click(welcomeLabel);
			WaitForElement(bylogoutButton);
			Click(logoutButton);
			WaitForElement(byLoginPanelHeading);
		} catch (Exception e) {
			takeScreenshot("ApplicationLogout", driver);
			Assert.fail("Application Logout is Not Successful");
		}
	}
	
	public static HomePage getHomePage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), HomePage.class);
	}
}
