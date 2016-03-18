package utils;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public abstract class AbstractMethods {

	public AppiumDriver<?> driver;
	Dimension size;
	String testReports;

	public AbstractMethods(AppiumDriver<?> driver2) {
		this.driver = driver2;
	}
	
	public void runInbackground(int duration) 
	{
		driver.runAppInBackground(duration);
	}
	
	public void rotateScreen(String orientation)
	{
		if(orientation.equals("Landscape"))
		{
			driver.rotate(ScreenOrientation.LANDSCAPE);
		}
		else if(orientation.equals("Portrait"))
		{
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
		else
		{
			System.out.println("Invalid screen rotation parameter passed. Use Landscape or Portrait");
		}
		
	}

	protected boolean isElementPresent(By by) throws IOException {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void waitForMe(By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	} 
	
	@SuppressWarnings("unchecked")
	public List<WebElement> getWebElementList(By by) 
	{
		List<WebElement> elementList = (List<WebElement>) driver.findElements(by);
		return elementList;
	}

	public void scrollToElement(String elementStr)
    {
        //calculate the screen size and get the coords for the swipe
        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.getWidth()/2;
        int screenHight = screenSize.getHeight()-20;
        System.out.println("Screen Size = " + screenSize);
        System.out.println("Screen Width = " + screenWidth);
        System.out.println("Screen Height = " + screenHight);
        
        System.out.println("This is the element String = " + elementStr);
        
        //this swipes down the screen until the given element is visible                
        if (!driver.findElement(By.xpath(elementStr)).isDisplayed())
        {
            do {
                driver.swipe(screenWidth, screenHight, screenWidth, screenHight-600, 1000);
            }
            while (!driver.findElement(By.xpath(elementStr)).isDisplayed());

        }
     }
	
	/* Horizontal swipe
	 * Pass : Right2Left to swipe from right to left
	 * Pass : Left2Right to swipe from left to right
	 */
	public void swipingHorizontal(String direction) throws InterruptedException 
	{ 
		//Get the size of screen. 
		size = driver.manage().window().getSize(); 
		System.out.println(size); 

		int startx = (int) (size.width * 0.70);  
		int endx = (int) (size.width * 0.30); 
		int starty = size.height / 2; System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty); 

		//Swipe from Right to Left. 
		if(direction.contentEquals("Right2Left"))
		{
			driver.swipe(startx, starty, endx, starty, 3000); Thread.sleep(2000); 
		}
		
		//Swipe from Left to Right.
		if(direction.contentEquals("Left2Right"))
		{
			driver.swipe(endx, starty, startx, starty, 3000); Thread.sleep(2000); 
		}
	}
	
	/* Vertical swipe
	 * Pass : Bottom2Top to swipe upwards
	 * Pass : Top2Bottom to swipe downwards
	 */
	public void swipingVertical(String direction) throws InterruptedException 
	{ 
		//Get the size of screen. 
		size = driver.manage().window().getSize(); 
		
		int starty = (int) (size.height * 0.20); 
		int endy = (int) (size.height * 0.80); 
		//int bottom = (int) (size.height);
		int startx = size.width / 2; System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx); 
	
		//Swipe from Bottom to Top. 
		if(direction.contentEquals("Top2Bottom"))
		{
			driver.swipe(startx, starty, startx, endy, 3000); Thread.sleep(2000); 
		}
			
		//Swipe from Top to Bottom.
		if(direction.contentEquals("Bottom2Top"))
		{
			driver.swipe(startx, endy, startx, starty, 3000); Thread.sleep(2000); 
		}
	}	
	
	
}


