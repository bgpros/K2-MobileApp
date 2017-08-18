package appium.SuiteLogin;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class LoginUserName extends AppiumDriverBase {
  @Test
  public void LoginUser() {
	  System.out.println("Esta probando");
		//Click on Accesibility link
		 
		  //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Username")));
		  driver.findElement(MobileBy.AccessibilityId("Username")).click();
		  //click on Accesibility link
		  //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility Node Querying")));
		  driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();
		  //Back
		  driver.navigate().back();
		  //Back
		  driver.navigate().back();
  }
}
