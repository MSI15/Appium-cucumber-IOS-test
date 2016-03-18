package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class CreateDriver {
	private static AndroidDriver<WebElement> ANDROID_DRIVER = null;
	private static IOSDriver<WebElement> iOS_DRIVER = null;
    public static WebDriverWait driverWait = null;
    static Map<String, String> devices = new HashMap<String, String>();
    protected static int deviceCount;
    protected String port, deviceId, deviceName, osVersion;
    static DeviceConfiguration deviceConf = new DeviceConfiguration();
	static AppiumManager appiumMan = new AppiumManager();
	static CommandPrompt cmd = new CommandPrompt();
	AndroidEmulator emu = new AndroidEmulator();
	String testPlatform;
	
    public void setUp(String device) throws Exception {
    	
    	appiumMan.startDefaultAppium();
    	
        if (device.equals("iOS")) {
        	startIOSDriver();
        }
        if (device.equals("android")) {
        	deviceConf.startADB();
        	startAndroidDriver();
        }
    }
    
    private AndroidDriver<WebElement> startAndroidDriver() throws Exception 
    {
    	URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = getAndroidDesiredCapabilities();
        ANDROID_DRIVER = new AndroidDriver<WebElement>(serverAddress, capabilities);
        return ANDROID_DRIVER;
    }

    private DesiredCapabilities getAndroidDesiredCapabilities() throws Exception 
    {
        //create appium driver instance
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		
		System.out.println("Target test platform is : " + Settings.device + "" + Settings.androidEmulator);
		System.out.println("app Package : " + Settings.applicationPackage);
		System.out.println("Activity : " + Settings.launchActivity);
		System.out.println("app Path : " + Settings.applicationPath);
		
		if((Settings.device.equals("android")) && (Settings.androidEmulator.equals("default")))
		{
			emu.startDefaultEmulator();	
			capabilities.setCapability(CapabilityType.VERSION, "6.0");
			capabilities.setCapability("deviceName", "Nexus9");
		}
		else if((Settings.device.equals("android")) && (Settings.androidEmulator.equals("no")))
		{
			devices = deviceConf.getDevices(); /* @return hashmap of connected devices information */
		    deviceCount = devices.size()/3;
		    if(deviceCount==0)
		    {
		        System.out.println("No device connected");
		        System.exit(0);
		    }
		    else
		    {
		        	System.out.println("Total number of devices connected : " + deviceCount);
		        	for(int deviceNumber=1; deviceNumber<=deviceCount; deviceNumber++)
		        	{
		        		this.deviceId = devices.get("deviceID"+deviceNumber);
		        		this.deviceName = devices.get("deviceName"+deviceNumber);
		        		this.osVersion = devices.get("osVersion"+deviceNumber);
		        		System.out.println("Device ID : " + deviceId);
		        		System.out.println("Device Name : " + deviceName);
		        		System.out.println("OS Version : " + osVersion);
		        	}
		     }
		        	
		       capabilities.setCapability(CapabilityType.VERSION, osVersion);
		       capabilities.setCapability("deviceName", deviceName);
		       capabilities.setCapability("udid", deviceId);
		}
		else if((Settings.device.equals("android")) && (Settings.androidEmulator.isEmpty()==false))
		{
				emu.startEmulator(Settings.androidEmulator);	
				capabilities.setCapability(CapabilityType.VERSION, Settings.emulatorVersion);
				capabilities.setCapability("deviceName", Settings.androidEmulator);
		}
        
		 capabilities.setCapability("app", Settings.applicationPath);
		 capabilities.setCapability("appPackage", Settings.applicationPackage);
		 capabilities.setCapability("appActivity", Settings.launchActivity);

         return capabilities;
    }

    public AndroidDriver<WebElement> getAndroidWebDriver() {
        return ANDROID_DRIVER;
    }
    
    private IOSDriver<WebElement> startIOSDriver() throws Exception 
    {
    	URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities capabilities = getIosDesiredCapabilities();
        iOS_DRIVER = new IOSDriver<WebElement>(serverAddress, capabilities);
        return iOS_DRIVER;
    }
    
    private DesiredCapabilities getIosDesiredCapabilities() throws Exception 
    {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("automationName", "appium");
		capabilities.setCapability(CapabilityType.VERSION, Settings.iOSversion);
		capabilities.setCapability("deviceName", Settings.iOSDevice);
		capabilities.setCapability("udid", Settings.udid); 
		capabilities.setCapability("nativeInstrumentsLib", true);
		capabilities.setCapability("bundleId", Settings.bundleID);
		capabilities.setCapability("command-timeout", 300);
		capabilities.setCapability("app", Settings.applicationPath);
		if(Settings.iOSversion.contains("8"))
		{
			capabilities.setCapability("autoAcceptAlerts", true); // Auto accept notification and location pop-up on app launch -- 
		}

		return capabilities;
    }
    
    public IOSDriver<WebElement> getIOSWebDriver() {
        return iOS_DRIVER;
    }

	public void tearDown() throws Exception {
			if(ANDROID_DRIVER!=null)
			{
				ANDROID_DRIVER.quit();
				deviceConf.stopADB();
				cmd.stopServer();
			}
			if(iOS_DRIVER!=null)
			{
				iOS_DRIVER.quit();
			}
	}

	
}
