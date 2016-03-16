package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

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
	String testPlatform;
    
    public void setUp(String device) throws Exception {
        if (device.equals("iOS")) {
        	startIOSDriver();
        }
        if (device.contains("android")) {
        	testPlatform = device;
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
    	String appPackage = "com.bskyb.digitalcontentsdk.video.ooyala.sample"; 
        String mainActivity = "MainActivity";
        //String appPath = Settings.applicationPath;
        String path = System.getProperty("user.dir");
        String appPath = path+"/app/app-debug.apk";
      
        //create appium driver instance
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		 
        if(testPlatform.equals("androidDevice"))
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
        else if(testPlatform.equals("androidEmulator"))
        {
        	AndroidEmulator emu = new AndroidEmulator();
        	emu.startDefaultEmulator();	
        	capabilities.setCapability(CapabilityType.VERSION, "");
      		capabilities.setCapability("deviceName", "Nexus9");
        }
       
		 capabilities.setCapability("app", appPath);
		 capabilities.setCapability("appPackage", appPackage);
		 capabilities.setCapability("appActivity", mainActivity);

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
    	String bundleID = ""; 
        String UDID = "";
        String testDevice = "";
        String OSVersion = "";
        String appPath = Settings.applicationPath;
       
       
        DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("automationName", "appium");
		capabilities.setCapability(CapabilityType.VERSION, OSVersion);
		capabilities.setCapability("deviceName", testDevice);
		capabilities.setCapability("udid", UDID); 
		capabilities.setCapability("nativeInstrumentsLib", true);
		capabilities.setCapability("bundleId", bundleID);
		capabilities.setCapability("command-timeout", 300);
		capabilities.setCapability("app", appPath);
		if(OSVersion.contains("8"))
		{
			capabilities.setCapability("autoAcceptAlerts", true); // Auto accept notification and location pop-up on app launch -- 
		}

		return capabilities;
    }
    
    public static IOSDriver<WebElement> getIOSWebDriver() {
        return iOS_DRIVER;
    }

}
