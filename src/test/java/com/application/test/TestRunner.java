package com.application.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue= {"com.framework.webdriver","com.application.test"},
plugin= {"pretty","html:Reports/CucumberAutomationReport.html"})

public class TestRunner {

}
