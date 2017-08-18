package appium.SuiteLoginAndroid;

import org.testng.SkipException;
import org.testng.annotations.*;

import appium.SuiteLoginIOS.TestSuiteBase;
import appium.util.TestUtil;

public class LoginEmailAndroid extends TestSuiteBaseAndroid {
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";  
	
	@BeforeTest
	
public void checkTestSkip() {
    	
		
        if (!TestUtil.isTestCaseRunnable(SuiteLoginAndroid, this.getClass().getSimpleName())) {
        	System.out.println("Test case is not runable");
            APP_LOGS.debug("Test Case " + this.getClass().getSimpleName() + " is set to NO");
            throw new SkipException("Test Case " + this.getClass().getSimpleName() + " is set to NO");
        } else {
            APP_LOGS.debug("Test Case " + this.getClass().getSimpleName() + " is set to YES");
            System.out.println("Test case is runable");
        }
        
        runmodes = TestUtil.getDataSetRunModes(SuiteLoginAndroid, this.getClass().getSimpleName());
       
    }
	
   
    @Test(dataProvider = "getTestData")
    public void emailLoginAndroid(String col1, String col2, String col3, String col4, String col5, String col6) throws Throwable {

        count++;
        APP_LOGS.debug("------>Starting Test Case" );
        if (!runmodes[count].equalsIgnoreCase("Y")) {
            skip = true;
            APP_LOGS.debug("Runmode for test set is NO");
            throw new SkipException("Runmode for test set is NO");
           
        }

        createAppiumDriverAndroid();
        loginInTheAppAndroid(col2, col3);
        
        if (driver.getPageSource().contains("Your login attempt has failed. Make sure the username and password are correct.")){
        
         pass=false;
         fail=true;
         isTestPass=false;
         FinalMessage="App wasn't able to login";
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

        NumeroRow = TestUtil.getRowNum(SuiteLoginAndroid, this.getClass().getSimpleName());

        if (isTestPass)
            TestUtil.reportDataSetResult(SuiteLoginAndroid, "TestCases", NumeroRow, "PASS");
        else
            TestUtil.reportDataSetResult(SuiteLoginAndroid, "TestCases", NumeroRow, "FAIL");

        
    }

    @AfterMethod
    public void reportDataSetResult() throws Throwable {

        if (skip)
            TestUtil.reportDataSetResult(SuiteLoginAndroid, this.getClass().getSimpleName(), count + 2, "SKIP");
        else if (fail) {
            isTestPass = false;
            TestUtil.reportDataSetResult(SuiteLoginAndroid, this.getClass().getSimpleName(), count + 2, "FAIL");
        } else {
            TestUtil.reportDataSetResult(SuiteLoginAndroid, this.getClass().getSimpleName(), count + 2, "PASS");

        }
        
        Thread.sleep(500);
        System.out.println("AFTER METHOD " + FinalMessage);
        TestUtil.SetShareResult(SuiteLoginAndroid, this.getClass().getSimpleName(), count + 2, FinalMessage);
        skip = false;
        fail = false;
        FinalMessage = "";
        System.gc();
    }

    @DataProvider
    public Object[][] getTestData() {
        return TestUtil.getData(SuiteLoginAndroid, this.getClass().getSimpleName());
    }  
	
	
    
 
   
}