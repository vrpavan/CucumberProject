#Author: ABC
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Orange HRM Login feature and forgot password feature
  I want to use this feature file to test login functionality and reset password functionality of orange HRM application

  Background: Launch the orangeHRM application
    Given Launch the application

  @Smoke
  Scenario: Verify application title
    Then Verify application title

  @Sanity @Regression
  Scenario Outline: Verify application login with valid credentials
    When Enter <username> and <password> and the click on login
    Then Verify application login

    Examples: 
      | username | password |
      | admin    | admin123 |
