package com.application.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.commons.WebCommons;
import com.framework.utilities.ReadDataFromPropFile;
import com.framework.webdriver.WebDriverClass;

public class LoginPage extends WebCommons{	
	
	//WebElements related to Login page
	
	@FindBy(xpath="//img[contains(@src,'logo.png')]")
	private WebElement logo;
	
	@FindBy(id="logInPanelHeading")
	private WebElement logInPanelHeading;
	
	@FindBy(name="txtUsername")
	private WebElement usernameTextbox;
	
	@FindBy(name="txtPassword")
	private WebElement passwordTextbox;
	
	@FindBy(name="Submit")
	private WebElement loginButton;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotYourPassword;
	
	private By welcomePageLocator = By.xpath("//a[@id='welcome']");
	
	//Actions for Login Page

	//Method to Launch the Application
	public void launchApplication() throws IOException {
		try {
			driver.get(ReadDataFromPropFile.readProperties("Config.properties").getProperty("url"));
		}catch(Exception e) {
			takeScreenshot("AppLaunch", driver);
			Assert.fail("Error while Launching the Application");
		}
	}
	
	//Method to Verify Application Title
	public void verifyApplicationTitle() throws IOException {
		if(getTitle().equals(ReadDataFromPropFile.readProperties("Config.properties").getProperty("title"))) {
		}else {
			takeScreenshot("AppTitle", driver);
			Assert.fail("Application Title is Not Matching");
		}
	}
	
	//Method to login into the application
	public void loginIntoApplication(String username,String password) throws IOException {
		try {
			EnterText(usernameTextbox, username);
			EnterText(passwordTextbox, password);
			Click(loginButton);
		}catch(Exception e) {
			takeScreenshot("AppLogin", driver);
			Assert.fail("Error while Login into the Application");
		}
	}
		
		//Method to verify Login Successful
		public void verifySuccessfulLogin() throws IOException {
			try {
				WaitForElement(welcomePageLocator);	
			}catch(Exception e) {
				takeScreenshot("Welcome", driver);
				Assert.fail("Application Login is not Successful");
			}
	}
			
	public static LoginPage getLoginPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPage.class);
	}
}
