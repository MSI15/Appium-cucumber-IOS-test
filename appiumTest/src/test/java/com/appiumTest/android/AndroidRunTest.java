package com.appiumTest.android;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "html:reports/html-report" },
		tags={"@android,@Ooyala"}
		)
public class AndroidRunTest {

}
