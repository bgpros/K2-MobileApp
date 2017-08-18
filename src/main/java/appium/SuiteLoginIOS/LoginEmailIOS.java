package appium.SuiteLoginIOS;

import org.testng.SkipException;
import org.testng.annotations.*;
import appium.util.TestUtil;

public class LoginEmailIOS extends TestSuiteBase {
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
        loginInTheAppIOS(col2, col3);
        
        if (driver.getPageSource().contains("Your login attempt has failed. Make sure the username and password are correct.")){
        
         pass=false;
         fail=true;
         isTestPass=false;
         FinalMessage="App wasn't able to login";
         org.testng.Assert.fail("Error to login");
        }else{
        	
        	pass=true;
        	fail=false;
            isTestPass=true;
            FinalMessage="App was able to login";
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