package testPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class OoyalaPlayer {
	
	public AppiumDriver<?> driver;
	
	public OoyalaPlayer(AppiumDriver<?> driver2){
		this.driver = driver2;
	}

	
	public void selectVideo() throws IOException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement launchOoyalaVideo = driver.findElementByAccessibilityId("launchOoyalaVideo");
		launchOoyalaVideo.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.RelativeLayout[1]/android.view.View[1]")));
	}
	
	public void checkVideoStatus() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc='Playing']")));
		boolean isPlaying = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Playing']")).isDisplayed();
		if(isPlaying==true)
		{
			driver.findElementByAccessibilityId("Playing");
			System.out.println("Video is playing");
			driver.findElement(By.xpath("//android.widget.RelativeLayout[1]/android.view.View[1]")).click();
			
			driver.navigate().back(); //to go back to previous screen
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'OoyalaSDK')]")));
		} 
		else
		{
			System.out.println("Video not playing");
		}
		
	}
	
}
