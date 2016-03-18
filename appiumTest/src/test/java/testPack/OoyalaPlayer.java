package testPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AbstractMethods;
import io.appium.java_client.AppiumDriver;

public class OoyalaPlayer extends AbstractMethods {
	
	public AppiumDriver<?> driver;
	
	public OoyalaPlayer(AppiumDriver<?> driver2){
		super(driver2);
		this.driver = driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'OoyalaSDK')]")
	private WebElement appHomePage;
	
	@AndroidFindBy(accessibility = "launchOoyalaVideo")
	private WebElement ooyalaPlayer;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Playing']")
	private WebElement playingState;
	
	@AndroidFindBy(accessibility = "Playing")
	private WebElement play;

	
	public void selectVideo() throws IOException 
	{
		appHomePage.isDisplayed();
		ooyalaPlayer.click();
		
	}
	
	public void checkVideoStatus() throws IOException
	{
		//waitForMe(playingState.isDisplayed());
		
		boolean isPlaying = playingState.isDisplayed();
		if(isPlaying==true)
		{
			play.isEnabled();
			System.out.println("Video is playing");
			driver.findElement(By.xpath("//android.widget.RelativeLayout[1]/android.view.View[1]")).click();
			
			driver.navigate().back(); //to go back to previous screen
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'OoyalaSDK')]")));
		} 
		else
		{
			System.out.println("Video not playing");
		}
		
	}
	
}
