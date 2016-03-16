package com.appiumTest.android;

import java.io.IOException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testPack.OoyalaPlayer;
import utils.CreateDriver;

public class AndroidStepDef {
   CreateDriver driver = new CreateDriver();

    @Before(value = "@android")
    public void setUp() throws Exception {
    	driver.setUp("android");
    }
    
    @Given("^app is launched$")
    public void app_is_launched() throws InterruptedException {
    	driver.getAndroidWebDriver().launchApp();
    }

    @When("^I select video$")
    public void I_select_video() throws IOException {
    	OoyalaPlayer player = new OoyalaPlayer(driver.getAndroidWebDriver());
    	player.selectVideo();
    }

    @Then("^video should play$")
    public void video_should_play() throws IOException {
    	OoyalaPlayer player = new OoyalaPlayer(driver.getAndroidWebDriver());
    	player.checkVideoStatus();
    }

    @After
    public void tearDown() throws Exception {
       
    }
}
