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


public class TestSearchRoleAndroid extends TestSuiteBaseTIAndroid {
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";  
    public boolean bancking = false;
    public boolean cable = false;
    public boolean catering = false;
    String startEl;
    String endEl;
    	
	
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
	    	
	    	//Click  industry
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("industryEditAndroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("industryEditAndroid"))).click();
	    	APP_LOGS.debug("Project Industry was found and clicked");
	
        	//Click on Add other Industry
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("industryAddEditAndroid"))));
	    	driver.findElement(MobileBy.id(OR.getProperty("industryAddEditAndroid"))).click();
	    	APP_LOGS.debug("Add other industry");
	    	
        	//Click on the Industry that wanted to be added
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("industryBankingEditAndroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("industryBankingEditAndroid"))).click();
	    	APP_LOGS.debug("Banking Added");
	    	
	    	//Click Search
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("searchIndustryEditAndroid"))));
	    	driver.findElement(MobileBy.id(OR.getProperty("searchIndustryEditAndroid"))).sendKeys("Cable");
	    	APP_LOGS.debug("Search Cable");
	    	
	    	//Click on Cable
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("industryCableEditAndroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("industryCableEditAndroid"))).click();
	    	APP_LOGS.debug("Cable Added");
	    	
	    	
	    	//Click OK
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("OKsaveAndroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("OKsaveAndroid"))).click();
	    	APP_LOGS.debug("Click OK");
	    	

	    	
	    	cable = driver.getPageSource().contains("Cable");
	    	
	    	
	    	
                    if(cable == true){
                		APP_LOGS.debug("cable tag was found");
                		pass=true;
                        fail=false;
                        isTestPass=true;
                        org.testng.Assert.assertTrue(pass);
                        FinalMessage = "cable tag was found";
                        
                		}else{
                			pass=false;
                            fail=true;
                            isTestPass=false;
                			APP_LOGS.debug("cable tag wasn't found");
                			FinalMessage = "cable tag wasn't found";
                			org.testng.Assert.fail("cable tag wasn't found");
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