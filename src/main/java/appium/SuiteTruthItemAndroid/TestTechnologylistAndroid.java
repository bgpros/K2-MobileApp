package appium.SuiteTruthItemAndroid;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appium.util.TestUtil;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class TestTechnologylistAndroid extends TestSuiteBaseTIAndroid {
	
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";  
    public boolean internetTag = false;
    public boolean cyberTag = false;
    public boolean enterpriseTag = false;
    
    
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
	  public void TruthItemListAnd(String col1, String col2, String col3, String col4, String col5, String col6, String col7) throws Throwable {
		  count++;
	        APP_LOGS.debug("------>Starting Test Case" );
	        if (!runmodes[count].equalsIgnoreCase("Y")) {
	            skip = true;
	            APP_LOGS.debug("Runmode for test set is NO");
	            throw new SkipException("Runmode for test set is NO");
		  
	  }
	SoftAssert sa = new SoftAssert();  
	//Login
	createAppiumDriverAndroid();
	loginInTheAppAndroid(col2, col3);      
	
	//Go to Project
	goToProjectDetailAndroid (col4);
		

	//Click Edit
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("editAndroid"))));
	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("editAndroid"))).click();
	APP_LOGS.debug("Edit button was found and clicked");
	
	//Click Product
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("technologyEditAndroid"))));
	driver.findElement(MobileBy.xpath(OR.getProperty("technologyEditAndroid"))).click();
	APP_LOGS.debug("Find and Click technology");

	//Validations
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("firstTITechnologyAndroid"))));
	
	internetTag = driver.getPageSource().contains("Internet of Things");
	cyberTag = driver.getPageSource().contains("Cyber Security");
	enterpriseTag = driver.getPageSource().contains("Enterprise on Premise");
	
	
	if(internetTag == true){
		APP_LOGS.debug("Internet of things tag was found");
		pass=true;
        fail=false;
        isTestPass=true;
        org.testng.Assert.assertTrue(pass);
        if(cyberTag == true){
    		APP_LOGS.debug("Cyber Security tag was found");
    		pass=true;
            fail=false;
            isTestPass=true;
            org.testng.Assert.assertTrue(pass);
            if(enterpriseTag == true){
        		APP_LOGS.debug("Enterprise on Premise tag was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);

        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Enterprise on Premise wasn't found");
        			FinalMessage = "Enterprise on Premise wasn't found";
        			org.testng.Assert.fail("Enterprise on Premise wasn't found");
        			//sa.fail();
        		}
    		}else{
    			pass=false;
                fail=true;
                isTestPass=false;
    			APP_LOGS.debug("Cyber Security wasn't found");
    			FinalMessage = "Cyber Security wasn't found";
    			org.testng.Assert.fail("Cyber Security wasn't found");
    			//sa.fail();
    		}
			
		}else{
		 pass=false;
         fail=true;
         isTestPass=false;
	     APP_LOGS.debug("Internet of things wasn't found");
	     FinalMessage = "Internet of things wasn't found";
	     org.testng.Assert.fail("Internet of things wasn't found");
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