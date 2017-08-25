package appium.SuiteTruthItemAndroid;

import org.testng.annotations.Test;

import appium.util.TestUtil;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class NewAnswerQ3Android extends TestSuiteBaseTIAndroid {
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";  
    public boolean question3Answer = false;
    
	
	@BeforeTest
  public void checkTestSkip() {
    	
		
        if (!TestUtil.isTestCaseRunnable(SuiteTruthItemsAndroid, this.getClass().getSimpleName())) {
        	System.out.println("Test case is not runable");
            APP_LOGS.debug("Test Case " + this.getClass().getSimpleName() + " is set to NO");
            throw new SkipException("Test Case " + this.getClass().getSimpleName() + " is set to NO");
        } else {
            APP_LOGS.debug("Test Case " + this.getClass().getSimpleName() + " is set to YES");
            System.out.println("Test case is runable");
        }
        
        runmodes = TestUtil.getDataSetRunModes(SuiteTruthItemsAndroid, this.getClass().getSimpleName());
       
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
	    	createAppiumDriverAndroid();
	    	loginInTheAppAndroid(col2, col3);      
	    	
	    	//Go to Project
	    	goToProjectDetailAndroid(col4);
	    	
	    	//Click Edit
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("editAndroid"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("editAndroid"))).click();
	    	APP_LOGS.debug("Edit button was found and clicked");
	    	
	    	//Click  Deliverable
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("deliverableEditandroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("deliverableEditandroid"))).click();
	    	APP_LOGS.debug("Deliverable was found and clicked");
	    	
	    	//Click on the first question
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("deliverableQ3EditAndroid"))));
	    	driver.findElement(MobileBy.id(OR.getProperty("deliverableQ3EditAndroid"))).sendKeys("Completing question 3 for deliverable");
	    	APP_LOGS.debug("Deliverable question 3 was updated");
	    	
	    	//Click Save
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("saveTIAndroid"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("saveTIAndroid"))).click();
	    	APP_LOGS.debug("Deliverable was found and clicked");
	    	
	    	//Locate again in the field list
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("deliverableQ3EditAndroid"))));
	    	
	    	question3Answer = driver.getPageSource().contains("Completing question 3 for deliverable");
	    	
	    	if(question3Answer == true){
        		APP_LOGS.debug("Question 3 answer was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                FinalMessage = "Question 3 answer was found";
                org.testng.Assert.assertTrue(pass);
                
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Question 3 answer wasn't found");
        			FinalMessage = "Question 3 answer wasn't found";
        			org.testng.Assert.fail("Question 3 answer wasn't found");
        			//sa.fail();
        		}
	  }
	 
	

	  @AfterTest
	  public void reportTestResult() {
	    	System.out.println("Report test run");
	        int NumeroRow = 0;

	        NumeroRow = TestUtil.getRowNum(SuiteTruthItemsAndroid, this.getClass().getSimpleName());

	        if (isTestPass)
	            TestUtil.reportDataSetResult(SuiteTruthItemsAndroid, "TestCases", NumeroRow, "PASS");
	        else
	            TestUtil.reportDataSetResult(SuiteTruthItemsAndroid, "TestCases", NumeroRow, "FAIL");

	        
	    }
	  
	  @AfterMethod
	  public void reportDataSetResult() throws Throwable {

	        if (skip)
	            TestUtil.reportDataSetResult(SuiteTruthItemsAndroid, this.getClass().getSimpleName(), count + 2, "SKIP");
	        else if (fail) {
	            isTestPass = false;
	            TestUtil.reportDataSetResult(SuiteTruthItemsAndroid, this.getClass().getSimpleName(), count + 2, "FAIL");
	        } else {
	            TestUtil.reportDataSetResult(SuiteTruthItemsAndroid, this.getClass().getSimpleName(), count + 2, "PASS");

	        }
	        
	        Thread.sleep(500);
	        System.out.println("AFTER METHOD " + FinalMessage);
	        TestUtil.SetShareResult(SuiteTruthItemsAndroid, this.getClass().getSimpleName(), count + 2, FinalMessage);
	        skip = false;
	        fail = false;
	        FinalMessage = "";
	        System.gc();
	    }

	 
	  
	  @DataProvider
	  public Object[][] getTestData() {
	        return TestUtil.getData(SuiteTruthItemsAndroid, this.getClass().getSimpleName());
	    } 

}