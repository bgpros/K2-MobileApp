package appium.SuiteLoginIOS;

import org.testng.annotations.Test;

import appium.util.TestUtil;
import io.appium.java_client.MobileBy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ForgotPasswordIOS extends TestSuiteBase {
	
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";
	
    @BeforeTest

    public void checkTestSkip() {
    	
		
        if (!TestUtil.isTestCaseRunnable(SuiteLogin, this.getClass().getSimpleName())) {
        	System.out.println("Test case is not runable");
            APP_LOGS.debug("Test Case " + this.getClass().getSimpleName() + " is set to NO");
            throw new SkipException("Test Case " + this.getClass().getSimpleName() + " is set to NO");
        } else {
            APP_LOGS.debug("Test Case " + this.getClass().getSimpleName() + " is set to YES");
            System.out.println("Test case is runable");
        }
        
        runmodes = TestUtil.getDataSetRunModes(SuiteLogin, this.getClass().getSimpleName());
       
    }	
	
	
  @Test(dataProvider = "getTestData")
  public void emailLogin(String col1, String col2, String col3, String col4, String col5, String col6) throws Throwable {

      count++;
      APP_LOGS.debug("------>Starting Test Case" );
      if (!runmodes[count].equalsIgnoreCase("Y")) {
          skip = true;
          APP_LOGS.debug("Runmode for test set is NO");
          throw new SkipException("Runmode for test set is NO");
         
      }

      createAppiumDriverIOS();
      //loginInTheAppIOS(col2, col3);
      
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Forgot your password?")));
      driver.findElement(MobileBy.AccessibilityId("Forgot your password?")).click();
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("ResetUsernameIOS"))));
      driver.findElement(MobileBy.xpath(OR.getProperty("ResetUsernameIOS"))).sendKeys(col2);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(MobileBy.AccessibilityId("Send Password Reset Email")).click();
      try{
    	  driver.findElement(MobileBy.AccessibilityId("NOW, CHECK YOUR EMAIL")).isDisplayed();
    	  APP_LOGS.debug("Reset Email Sent");
      	  
          pass=true;
          fail=false;
          isTestPass=false;
          FinalMessage="Reset Email Sent";
          org.testng.Assert.assertTrue(pass, FinalMessage);
      }catch(Exception e){
    	  APP_LOGS.debug("Reset Email wasn't sent");
    	  pass=false;
          fail=true;
          isTestPass=true;
          FinalMessage="Reset email wasn't sent";
          org.testng.Assert.fail("Reset Email wasn't sent");
      }
      
     
 }
  
  @AfterTest
  public void reportTestResult() {
  	System.out.println("Report test run");
      int NumeroRow = 0;

      NumeroRow = TestUtil.getRowNum(SuiteLogin, this.getClass().getSimpleName());

      if (isTestPass)
          TestUtil.reportDataSetResult(SuiteLogin, "TestCases", NumeroRow, "PASS");
      else
          TestUtil.reportDataSetResult(SuiteLogin, "TestCases", NumeroRow, "FAIL");

      
  }
  
  @AfterMethod
  public void reportDataSetResult() throws Throwable {

      if (skip)
          TestUtil.reportDataSetResult(SuiteLogin, this.getClass().getSimpleName(), count + 2, "SKIP");
      else if (fail) {
          isTestPass = false;
          TestUtil.reportDataSetResult(SuiteLogin, this.getClass().getSimpleName(), count + 2, "FAIL");
      } else {
          TestUtil.reportDataSetResult(SuiteLogin, this.getClass().getSimpleName(), count + 2, "PASS");

      }
      
      Thread.sleep(500);
      System.out.println("AFTER METHOD " + FinalMessage);
      TestUtil.SetShareResult(SuiteLogin, this.getClass().getSimpleName(), count + 2, FinalMessage);
      skip = false;
      fail = false;
      FinalMessage = "";
      System.gc();
  }

  @DataProvider
  public Object[][] getTestData() {
      return TestUtil.getData(SuiteLogin, this.getClass().getSimpleName());
  }  
  


  

}
