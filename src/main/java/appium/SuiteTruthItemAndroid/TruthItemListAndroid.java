package appium.SuiteTruthItemAndroid;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appium.util.TestUtil;
import io.appium.java_client.MobileBy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TruthItemListAndroid extends TestSuiteBaseTIAndroid {
	
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";  
    public boolean roleType = false;
    public boolean industryType = false;
    public boolean technologyType = false;
    public boolean productType = false;
    public boolean deliverableType = false;
    
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
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty(col4))));
	driver.findElement(MobileBy.xpath(OR.getProperty(col4))).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	APP_LOGS.debug("Project was found and clicked");
	
	//Go to Detail
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Details")));
	driver.findElement(MobileBy.AccessibilityId("Details")).click();
	APP_LOGS.debug("Detail was found and clicked");
	
	//Click Edit
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("editAndroid"))));
	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("editAndroid"))).click();
	APP_LOGS.debug("Edit button was found and clicked");

	//Validations
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("roleFindEditAndroid"))));
	
	roleType = driver.getPageSource().contains("Project Roles");
	industryType = driver.getPageSource().contains("Industries");
	technologyType = driver.getPageSource().contains("Technologies");
	productType = driver.getPageSource().contains("Products");
	deliverableType = driver.getPageSource().contains("Deliverables");
	
	if(roleType == true){
		APP_LOGS.debug("Role tag was found");
		pass=true;
        fail=false;
        isTestPass=true;
        org.testng.Assert.assertTrue(pass);
        if(industryType == true){
    		APP_LOGS.debug("Industry tag was found");
    		pass=true;
            fail=false;
            isTestPass=true;
            org.testng.Assert.assertTrue(pass);
            if(technologyType == true){
        		APP_LOGS.debug("Technology tag was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
                if(productType == true){
            		APP_LOGS.debug("Product tag was found");
            		pass=true;
                    fail=false;
                    isTestPass=true;
                    org.testng.Assert.assertTrue(pass);
                    if(deliverableType == true){
                		APP_LOGS.debug("Deliverable tag was found");
                		pass=true;
                        fail=false;
                        isTestPass=true;
                        org.testng.Assert.assertTrue(pass);
                        FinalMessage = "All the Tags where found";
                		}else{
                			pass=false;
                            fail=true;
                            isTestPass=false;
                			APP_LOGS.debug("Deliverable wasn't found");
                			FinalMessage = "Deliverable wasn't found";
                			//sa.fail();
                		}
            		}else{
            			pass=false;
                        fail=true;
                        isTestPass=false;
            			APP_LOGS.debug("Product wasn't found");
            			FinalMessage = "Product wasn't found";
            			//sa.fail();
            		}
                
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Technology wasn't found");
        			FinalMessage = "Technology wasn't found";
        			//sa.fail();
        		}
    		}else{
    			pass=false;
                fail=true;
                isTestPass=false;
    			APP_LOGS.debug("Industry wasn't found");
    			FinalMessage = "Industry wasn't found";
    			//sa.fail();
    		}
			
		}else{
		 pass=false;
         fail=true;
         isTestPass=false;
	     APP_LOGS.debug("Role wasn't found");
	     FinalMessage = "Role wasn't found";
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
