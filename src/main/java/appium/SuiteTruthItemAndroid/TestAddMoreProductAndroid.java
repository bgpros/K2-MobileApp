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


public class TestAddMoreProductAndroid extends TestSuiteBaseTIAndroid {
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";  
    public boolean abTesting = false;
    public boolean ADABAS = false;
    public boolean ADONET = false;
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
	    	
	    	//Click Product
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("productEditAndroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("productEditAndroid"))).click();
	    	APP_LOGS.debug("Project Product was found and clicked");
	
        	//Click on Add other Product
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("productAddEditAndroid"))));
	    	driver.findElement(MobileBy.id(OR.getProperty("productAddEditAndroid"))).click();
	    	APP_LOGS.debug("Add other product");
	    	
        	//Click on the product that wanted to be added
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("productABTestingEditAndroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("productABTestingEditAndroid"))).click();
	    	APP_LOGS.debug("A/B Testing Added");
	    	
	    	//Click on ADABAS
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("productADABASEditAndroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("productADABASEditAndroid"))).click();
	    	APP_LOGS.debug("ADABAS Added");
	    	
	    	//Click Search
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("searchProductEditAndroid"))));
	    	driver.findElement(MobileBy.id(OR.getProperty("searchProductEditAndroid"))).sendKeys("ADO.NET");
	    	APP_LOGS.debug("Search ADO.NET");
	    	
	    	//Click ADO.NET
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("producADONETEditAndroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("producADONETEditAndroid"))).click();
	    	APP_LOGS.debug("Catering ADO.NET");
	    	
	    	
	    	//Click OK
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("OKsaveAndroid"))));
	    	driver.findElement(MobileBy.xpath(OR.getProperty("OKsaveAndroid"))).click();
	    	APP_LOGS.debug("Click OK");
	    	
	    	//Click Save
	    	
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("saveTIAndroid"))));
	    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("saveTIAndroid"))).click();
	    	APP_LOGS.debug("Click Save");
        	
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("firstTIIndustryAndroid"))));
	    	APP_LOGS.debug("First Industry from the list is found");
	    	
	    	
	    	
	    	/*Scroll Using Touch Action Classes
	    	startEl=OR.getProperty("startIndustry");
	    	endEl=OR.getProperty("endIndustry");
	    	scrollDown(startEl, endEl);
	    	Thread.sleep(1000);*/
  	
	    	
	    	abTesting = driver.getPageSource().contains("A/B Testing");
	    	ADABAS = driver.getPageSource().contains("ADABAS");
	    	ADONET = driver.getPageSource().contains("ADO.NET");
	    	
	    	if(abTesting == true){
        		APP_LOGS.debug("A/B Testing tag was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
                FinalMessage = "A/B Testing tag was found";
                if(ADABAS == true){
            		APP_LOGS.debug("ADABAS tag was found");
            		pass=true;
                    fail=false;
                    isTestPass=true;
                    org.testng.Assert.assertTrue(pass);
                    FinalMessage = "ADABAS tag was found";
                    if(ADONET == true){
                		APP_LOGS.debug("ADO.NET tag was found");
                		pass=true;
                        fail=false;
                        isTestPass=true;
                        org.testng.Assert.assertTrue(pass);
                        FinalMessage = "ADO.NET tag was found";
                        
                		}else{
                			pass=false;
                            fail=true;
                            isTestPass=false;
                			APP_LOGS.debug("ADO.NET tag wasn't found");
                			FinalMessage = "ADO.NET tag wasn't found";
                			org.testng.Assert.fail("ADO.NET tag wasn't found");
                			//sa.fail();
                		}
            		}else{
            			pass=false;
                        fail=true;
                        isTestPass=false;
            			APP_LOGS.debug("ADABAS tag wasn't found");
            			FinalMessage = "ADABAS tag wasn't found";
            			org.testng.Assert.fail("ADABAS tag wasn't found");
            			//sa.fail();
            		}
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("A/B Testing tag wasn't found");
        			FinalMessage = "A/B Testing tag wasn't found";
        			org.testng.Assert.fail("A/B Testing tag wasn't found");
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
	   	  
	