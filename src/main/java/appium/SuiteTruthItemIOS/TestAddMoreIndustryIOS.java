package appium.SuiteTruthItemIOS;

import org.testng.annotations.Test;

import appium.util.TestUtil;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class TestAddMoreIndustryIOS extends TestSuiteBaseTIIOS {
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";  
    public boolean banking = false;
    public boolean cable = false;
    public boolean catering = false;
    String startEl;
    String endEl;
    	
	
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
	    	
	    	//Click  industry
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("industryEditIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("industryEditIOS"))).click();
	    	APP_LOGS.debug("Project Industry was found and clicked");
	
        	//Click on Add other Product
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("industryAddEditIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("industryAddEditIOS"))).click();
	    	APP_LOGS.debug("Add other industry");
	    	
        	//Click on the Industry that wanted to be added
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("industryBankingEditIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("industryBankingEditIOS"))).click();
	    	APP_LOGS.debug("Banking Added");
	    	
	    	//Click Search
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("searchIndustryEditIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("searchIndustryEditIOS"))).sendKeys("Cable");
	    	APP_LOGS.debug("Search Cable");
	    	
	    	//Click on Cable
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("industryCableEditIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("industryCableEditIOS"))).click();
	    	APP_LOGS.debug("Cable Added");
	    	
	    	//Click OK
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("saveOKIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("saveOKIOS"))).click();
	    	APP_LOGS.debug("Click OK");
	    	
	    	//Click on Add other Product
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("industryAddEditIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("industryAddEditIOS"))).click();
	    	APP_LOGS.debug("Add other industry");
	    	
	    	
	    	//Click Search
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("searchIndustryEditIOS"))));
	    	//driver.findElement(MobileBy.AccessibilityId(OR.getProperty("searchIndustryEditIOS"))).clear();
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("searchIndustryEditIOS"))).sendKeys("Catering");
	    	APP_LOGS.debug("Search Catering");
	    	
	    	//Click Catering
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("industryCateringEditIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("industryCateringEditIOS"))).click();
	    	APP_LOGS.debug("Catering Added");
	    	
	    	//Click OK
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("saveOKIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("saveOKIOS"))).click();
	    	APP_LOGS.debug("Click OK");
	    	
	    	//Click Save
	    	
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("saveTIIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("saveTIIOS"))).click();
	    	APP_LOGS.debug("Click Save");
	    	
	    	//Click OK after saving
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("saveOKIOS"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("saveOKIOS"))).click();
	    	APP_LOGS.debug("Click OK after saving");
	    	
	    	//Click OK after saving
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("successAfterSaveOK"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("successAfterSaveOK"))).click();
	    	APP_LOGS.debug("Click OK for Success");
        	
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("industryBankingEditIOS"))));
	    	APP_LOGS.debug("First Industry from the list is found");
	    	
	    	
	    	
	    	/*Scroll Using Touch Action Classes
	    	startEl=OR.getProperty("startIndustry");
	    	endEl=OR.getProperty("endIndustry");
	    	scrollDown(startEl, endEl);
	    	Thread.sleep(1000);*/
  	
	    	
	    	banking = driver.getPageSource().contains("Banking");
	    	cable = driver.getPageSource().contains("Cable");
	    	catering = driver.getPageSource().contains("Catering");
	    	
	    	if(banking == true){
        		APP_LOGS.debug("Banking tag was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
                FinalMessage = "Banking tag was found";
                if(cable == true){
            		APP_LOGS.debug("Cable tag was found");
            		pass=true;
                    fail=false;
                    isTestPass=true;
                    org.testng.Assert.assertTrue(pass);
                    FinalMessage = "Catering tag was found";
                    if(catering == true){
                		APP_LOGS.debug("Catering tag was found");
                		pass=true;
                        fail=false;
                        isTestPass=true;
                        org.testng.Assert.assertTrue(pass);
                        FinalMessage = "Catering tag was found";
                        
                		}else{
                			pass=false;
                            fail=true;
                            isTestPass=false;
                			APP_LOGS.debug("Catering tag wasn't found");
                			FinalMessage = "Catering tag wasn't found";
                			org.testng.Assert.fail("Catering tag wasn't found");
                			//sa.fail();
                		}
            		}else{
            			pass=false;
                        fail=true;
                        isTestPass=false;
            			APP_LOGS.debug("Cable tag wasn't found");
            			FinalMessage = "Cable tag wasn't found";
            			org.testng.Assert.fail("Cable tag wasn't found");
            			//sa.fail();
            		}
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Bancking tag wasn't found");
        			FinalMessage = "Bancking tag wasn't found";
        			org.testng.Assert.fail("Banking tag wasn't found");
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
