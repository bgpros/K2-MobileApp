package appium.SuiteLogin;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class AppiumDriverBase {
	protected WebDriver driver;
	protected WebDriverWait wait;
  
  @BeforeTest
  public void creatAppiumDriver() throws MalformedURLException, InterruptedException {
	//relative path to apk file
	  
	  System.out.println("HOLA");
	  final File classpathRoot = new File(System.getProperty("user.dir"));
	  
	  final File appDir = new File (classpathRoot,"src/test/resources/apps/");
	  final File apptest = new File (appDir, "ApiDemos-debug.apk");
	  final File app = new File (appDir, "k2konnect (2).apk" );
	  
	 //Setting desired capabilties
	  DesiredCapabilities caps = new DesiredCapabilities();
	  //caps.setCapability("automationName", "Appium");
	  caps.setCapability("browserName", "");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("platformVersion", "5.0");
	  caps.setCapability("deviceName", "Android Emulator");
	  caps.setCapability("app", app.getAbsolutePath());
	  
	//ChromeDriver
	  System.setProperty("webdriver.chrome.driver", "/Users/Brenda/Documents/Brenda K2/chromedriver");

    // initialize driver object	  
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    // initialize explicit wait object	  
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  wait = new WebDriverWait(driver, 30);
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
