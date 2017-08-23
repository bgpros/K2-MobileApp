package appium.actionwords;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.*;
import appium.base.AppiumDriverBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;



public class Actionwords extends AppiumDriverBase{
	
    
    public void loginInTheAppIOS(String user, String pass) {
    	
    	
    	
    	// TODO: Implement action: "Login in the app"
    	
    	// TODO: Implement action: "Fin and Insert userID""
    	
    	
    	
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("userIOS"))));
    	APP_LOGS.debug("Email was found");
    	
    	
    	driver.findElement(MobileBy.xpath(OR.getProperty("userIOS"))).sendKeys(user);
    	
    	// TODO: Implement action: "Find and Insert the password"
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("passIOS"))));
    	APP_LOGS.debug("Password was found");
        driver.findElement(MobileBy.xpath(OR.getProperty("passIOS"))).sendKeys(pass); 
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	// TODO: Implement action: "Tap in Login"
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id("Log in")));
    	driver.findElement(MobileBy.AccessibilityId("Log in")).click();
        // TODO: Implement result: "Validate that it redirects you to the landing page"
    	
    	
       
    }
    
public void loginInTheAppAndroid(String user, String pass) {
    	
    	
    	
    	// TODO: Implement action: "Login in the app"
    	
    	// TODO: Implement action: "Fin and Insert userID""
    	
    	
    	
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("userAndroid"))));
    	APP_LOGS.debug("Email was found");
    	
    	
    	driver.findElement(MobileBy.xpath(OR.getProperty("userAndroid"))).sendKeys(user);
    	
    	// TODO: Implement action: "Find and Insert the password"
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("passAndroid"))));
    	APP_LOGS.debug("Password was found");
        driver.findElement(MobileBy.xpath(OR.getProperty("passAndroid"))).sendKeys(pass); 
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	// TODO: Implement action: "Tap in Login"
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id("Log in")));
    	driver.findElement(MobileBy.AccessibilityId("Log in")).click();
        // TODO: Implement result: "Validate that it redirects you to the landing page"
    	
    	
       
    }

public void goToProjectDetailAndroid (String projectName){
	
	
	//Allow Access button
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Allow")));
	driver.findElement(MobileBy.AccessibilityId("Allow")).click();
	APP_LOGS.debug("Allow was found and clicked");
	
	//Allow popup
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("AllowPopupAndroid"))));
	driver.findElement(MobileBy.id(OR.getProperty("AllowPopupAndroid"))).click();
	APP_LOGS.debug("Allow popup was found and clicked");
	
	//Go to Projects 
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Projects")));
	driver.findElement(MobileBy.AccessibilityId("Projects")).click();
	APP_LOGS.debug("Project button was found and clicked");
	
	//Select a Project
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty(projectName))));
	driver.findElement(MobileBy.xpath(OR.getProperty(projectName))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	APP_LOGS.debug("Project was found and clicked");
	
	//Go to Detail
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Details")));
	driver.findElement(MobileBy.AccessibilityId("Details")).click();
	APP_LOGS.debug("Detail was found and clicked");
	
}

public void goToProjectDetailIOS (){
	
	
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("Allow"))));
	driver.findElement(MobileBy.AccessibilityId("Allow")).click();
	
}
   
public void scrollDown (String startElement, String endElement ){
	
	APP_LOGS.debug("Starting to find the X and Y for Scroll");
	TouchAction tAction=new TouchAction(mobDriver);
	
	
	int startX = driver.findElement(MobileBy.xpath(startElement)).getLocation().getX();
	APP_LOGS.debug("Start X found");
	int startY = driver.findElement(MobileBy.xpath(startElement)).getLocation().getY();
	APP_LOGS.debug("Start Y found");
	int endX = driver.findElement(MobileBy.xpath(endElement)).getLocation().getX();
	APP_LOGS.debug("End Y found");
	int endY = driver.findElement(MobileBy.xpath(endElement)).getLocation().getY();
	APP_LOGS.debug("End X found");
	System.out.println(startX + " ::::::: " + startY + " ::::::: " + endX +  " ::::::: " +	endY); 
	
	
	//First tap on the screen and swipe it down (Scroll Down)
	tAction.press(startX,startY).waitAction(1000).moveTo(endX,endY).release().perform(); 
	

  }


}