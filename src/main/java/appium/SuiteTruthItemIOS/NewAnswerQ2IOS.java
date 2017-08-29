package appium.SuiteTruthItemIOS;

import org.testng.annotations.Test;

import appium.util.TestUtil;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class NewAnswerQ2IOS extends TestSuiteBaseTIIOS {
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";  
    public boolean question1Answer = false;
    
	
	@BeforeTest
  public void checkTestSkip() {
    	
		
        if (!TestUtil.isTestCaseRunnable(SuiteTruthItemsIOS, this.getClass().getSimpleName())) {
        	System.out.println("Test case is not runable");
            APP_LOGS.debug("Test Case " + this.getClass().getSimpleName() + " is set to NO");
            throw new SkipException("Test Case " + this.getClass().getSimpleName() + " is set to NO");
        } else {
            APP_LOGS.debug("Test Case " + this.getClass().getSimpleName() + " is set to YES");
            System.out.println("Test case is runable");
        }
        
        runmodes = TestUtil.getDataSetRunModes(SuiteTruthItemsIOS, this.getClass().getSimpleName());
       
     }
		
	  @Test(dataProvider = "getTestData")
	  public void TestPrimaryRoleAnd(String col1, String col2, String col3, String col4, String col5, String col6, String col7) throws Throwable {
		  count++;
	        APP_LOGS.debug("------>Starting Test Case" );
	        if (!runmodes[count].equalsIgnoreCase("Y")) {
	            skip = true;
	            APP_LOGS.debug("Runmode for test set is NO");
	            throw new SkipException("Runmode for test set is NO");
		  
	  }
	      //Login
	    	createAppiumDriverIOS();
	    	loginInTheAppIOS(col2, col3);      
	    	
	    	//Go to Project
	    	goToProjectDetailIOS(col4);
	    	
	    	//Click Edit
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("editIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("editIOS"))).click();
	    	APP_LOGS.debug("Edit button was found and clicked");
	    	
	    	//Confirm Edit
	    	
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("proDetailyesIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("proDetailyesIOS"))).click();
	    	APP_LOGS.debug("Edit confirm was clicked");
	    	
	    	
	    	//Click  Deliverable
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("deliverableEditIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("deliverableEditIOS"))).click();
	    	APP_LOGS.debug("Deliverable was found and clicked");
	    	
	    	//Click on the first question
	    	WebElement getLocationQ1=driver.findElement(MobileBy.xpath(OR.getProperty("deliverableQ2EditIOS")));
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("deliverableQ2EditIOS"))));
	    	((IOSDriver) driver).tap(1, getLocationQ1.getLocation().x + getLocationQ1.getSize().width - 10, getLocationQ1.getLocation().y + getLocationQ1.getSize().height - 10, 100);
	    	driver.findElement(MobileBy.xpath(OR.getProperty("deliverableQ2EditIOS"))).clear();
	    	driver.findElement(MobileBy.xpath(OR.getProperty("deliverableQ2EditIOS"))).sendKeys("Deliverable Q2 Answer");
	    	APP_LOGS.debug("Deliverable question 2 was updated");
	    	
	    	//Click Save
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("saveTIAndroid"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("saveTIAndroid"))).click();
	    	APP_LOGS.debug("Deliverable was found and clicked");
	    	
	    	//Click OK after saving
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("saveOKIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("saveOKIOS"))).click();
	    	APP_LOGS.debug("Click OK after saving");
	  
	    	//Locate again in the field list
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("deliverableQ2EditIOS"))));
	    	
	        //Finding First Element
	    	question1Answer = driver.getPageSource().contains("Deliverable Q2 Answer");
	    	
	    	if(question1Answer == true){
        		APP_LOGS.debug("Question 2 answer was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                FinalMessage = "Question 2 answer was found";
                org.testng.Assert.assertTrue(pass);
                
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Question 2 answer wasn't found");
        			FinalMessage = "Question 2 answer wasn't found";
        			org.testng.Assert.fail("Question 2 answer wasn't found");
        			//sa.fail();
        		}
	  }
	 
	

	  @AfterTest
	  public void reportTestResult() {
	    	System.out.println("Report test run");
	        int NumeroRow = 0;

	        NumeroRow = TestUtil.getRowNum(SuiteTruthItemsIOS, this.getClass().getSimpleName());

	        if (isTestPass)
	            TestUtil.reportDataSetResult(SuiteTruthItemsIOS, "TestCases", NumeroRow, "PASS");
	        else
	            TestUtil.reportDataSetResult(SuiteTruthItemsIOS, "TestCases", NumeroRow, "FAIL");

	        
	    }
	  
	  @AfterMethod
	  public void reportDataSetResult() throws Throwable {

	        if (skip)
	            TestUtil.reportDataSetResult(SuiteTruthItemsIOS, this.getClass().getSimpleName(), count + 2, "SKIP");
	        else if (fail) {
	            isTestPass = false;
	            TestUtil.reportDataSetResult(SuiteTruthItemsIOS, this.getClass().getSimpleName(), count + 2, "FAIL");
	        } else {
	            TestUtil.reportDataSetResult(SuiteTruthItemsIOS, this.getClass().getSimpleName(), count + 2, "PASS");

	        }
	        
	        Thread.sleep(500);
	        System.out.println("AFTER METHOD " + FinalMessage);
	        TestUtil.SetShareResult(SuiteTruthItemsIOS, this.getClass().getSimpleName(), count + 2, FinalMessage);
	        skip = false;
	        fail = false;
	        FinalMessage = "";
	        System.gc();
	    }

	 
	  
	  @DataProvider
	  public Object[][] getTestData() {
	        return TestUtil.getData(SuiteTruthItemsIOS, this.getClass().getSimpleName());
	    } 

}