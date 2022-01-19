package com.application.test;

import java.io.IOException;

import com.application.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	@Given("Launch the application")
	public void launch_the_application() throws IOException {
		LoginPage loginPage = LoginPage.getLoginPage();
		loginPage.launchApplication();
	}

	@Then("Verify application title")
	public void verifyTitle() throws IOException {
		LoginPage loginPage = LoginPage.getLoginPage();
		loginPage.verifyApplicationTitle();
	}

	@When("^Enter (.*) and (.*) and the click on login$")
	public void login(String username,String password) throws IOException {
		LoginPage loginPage = LoginPage.getLoginPage();
		loginPage.loginIntoApplication(username, password);
	}

	@Then("Verify application login")
	public void verify_application_login() throws IOException {
		LoginPage loginPage = LoginPage.getLoginPage();
		loginPage.verifySuccessfulLogin();
	}

}
