package appium.base;

import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import appium.util.Xls_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class AppiumDriverBase {	
	
	protected MobileDriver mobDriver;
	protected WebDriver driver;
	protected WebDriverWait wait;
	public static Logger APP_LOGS=null;
	public static Properties OR=null;
	public static Xls_reader Suite=null;
	public static Xls_reader SuiteLogin=null;
	public static Xls_reader SuiteLoginAndroid=null;
	public static Xls_reader SuiteTruthItemsAndroid=null;
	public static Xls_reader SuiteTruthItemsIOS=null;
	public static Properties CONFIG=null;
	public static boolean isInitialized=false;
	
	
	public void initialize() throws IOException{


		if(! isInitialized){
		   APP_LOGS=Logger.getLogger("devpinoyLogger");
		   APP_LOGS.debug("Loading Property files");
		   
		   ClassLoader loader = Test.class.getClassLoader();
		   //System.out.println("hola");
	        //System.out.println(loader.getResource("foo/Test.class"));
		   
		   URL location = Test.class.getProtectionDomain().getCodeSource().getLocation();
	        
		   CONFIG = new Properties();
		  // InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/main/resources/config/config.properties");
		   InputStream is = getClass().getClassLoader().getResourceAsStream("./././config/config.properties");
		   
		   
		   if (is != null) {
			   CONFIG.load(is);
			} else {
				throw new FileNotFoundException("property file config.properties not found in the classpath");
			}
		   CONFIG.load(is);
		
		   OR = new Properties();
		   OR.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("./././config/OR.properties"));
		   
		
		   APP_LOGS.debug("Loaded Property files success");
		   APP_LOGS.debug("Loading XLS files");
					   
		   //Suite       = new Xls_Reader("./././xls/Suite.xlsx");
		   Suite      = new Xls_reader("/Users/Brenda/Documents/workspace/MobileApp/src/main/resources/xls/Suite.xlsx");
		   SuiteLogin = new Xls_reader("/Users/Brenda/Documents/workspace/MobileApp/src/main/resources/xls/SuiteLogin.xlsx");
		   SuiteLoginAndroid = new Xls_reader("/Users/Brenda/Documents/workspace/MobileApp/src/main/resources/xls/SuiteLoginAndroid.xlsx");
		   SuiteTruthItemsAndroid = new Xls_reader("/Users/Brenda/Documents/workspace/MobileApp/src/main/resources/xls/SuiteTruthItemsAndroid.xlsx");
		   SuiteTruthItemsIOS = new Xls_reader("/Users/Brenda/Documents/workspace/MobileApp/src/main/resources/xls/SuiteTruthItemsIOS.xlsx");
		   //FirstTest = new Xls_Reader("./././xls/FirstTest.xlsx");
		   //SecondTest = new Xls_Reader("xls/SecondTest.xlsx");
		   APP_LOGS.debug("----> Loaded XLS files successfully");
		   isInitialized = true;
		}
	}	
	
	
	
	
 public static void ReadProperties(String[] args){

 try {
	    Properties properties = new Properties();
properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("appium/config/OR.properties"));

	} catch (IOException e) {
		e.printStackTrace();
	}
	
		
}
  
 public void createAppiumDriverIOS() throws MalformedURLException, InterruptedException {
	//relative path to apk file
	 
	  Properties properties = new Properties();
	  	 
	  final File classpathRoot = new File(System.getProperty("user.dir"));
	  final File appDir = new File (classpathRoot,"src/main/resources/app/");
	  final File apptest = new File (appDir, "K2KonnectApp 2.app");
	  final File app = new File (appDir, "K2KonnectApp 2.app" );
	  
	  //Setting desired capabilties
	  DesiredCapabilities caps = new DesiredCapabilities();
	  //caps.setCapability("automationName", "Appium");
	  
	  caps.setCapability("platformName", "iOS");
	  caps.setCapability("platformVersion", "10.3");
	  caps.setCapability("deviceName", "iPhone Simulator");
	  caps.setCapability("app", app.getAbsolutePath());
	  
	//ChromeDriver
	  System.setProperty("webdriver.chrome.driver", "/Users/Brenda/Documents/Brenda K2/chromedriver");

    // initialize driver object	  
	  driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    // initialize explicit wait object	  
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  wait = new WebDriverWait(driver, 30);
	  
  }
 
 public void createAppiumDriverAndroid() throws MalformedURLException, InterruptedException {
		//relative path to apk file
		 
		  Properties properties = new Properties();
		  	 
		  final File classpathRoot = new File(System.getProperty("user.dir"));
		  final File appDir = new File (classpathRoot,"src/main/resources/app/");
		  final File app = new File (appDir, "app-release.apk" );
		  
		  //Setting desired capabilties
		  DesiredCapabilities caps = new DesiredCapabilities();
		  //caps.setCapability("automationName", "Appium");
		  
		  caps.setCapability("platformName", "Android");
		  caps.setCapability("platformVersion", "6.0");
		  caps.setCapability("deviceName", "Android Emulator");
		  caps.setCapability("app", app.getAbsolutePath());
		  caps.setCapability("appActivity", ".MainActivity");
		  caps.setCapability("appWaitActivity", "com.salesforce.androidsdk.ui.LoginActivity");
		  caps.setCapability("unicodeKeyboard", "true");
		  caps.setCapability("resetKeyboard", "true");
		  
		//ChromeDriver
		  System.setProperty("webdriver.chrome.driver", "/Users/Brenda/Documents/Brenda K2/chromedriver");

	    // initialize driver object	
		  URL serveraddress = new URL("http://127.0.0.1:4723/wd/hub"); 
		  //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		  driver = new AndroidDriver<MobileElement>(serveraddress, caps);
	    // initialize explicit wait object	  
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  wait = new WebDriverWait(driver, 30);
		  
	  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
