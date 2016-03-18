package com.appiumTest.iOS;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "html:reports/html-report" },
		tags={"@iOS"}
		)
public class iOSRunTest {

}
