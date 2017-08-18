package appium.SuiteTruthItemIOS;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appium.SuiteLoginAndroid.TestSuiteBaseAndroid;
import appium.util.TestUtil;
import io.appium.java_client.MobileBy;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TruthItemTestEnvironmentIOS extends TestSuiteBaseTIIOS {
	String runmodes[] = null;
	static boolean isTestPass = true;
	static int count = -1;
    static boolean fail = false;
    static boolean pass = false;
    static boolean skip = false;
    String FinalMessage = "";  
    public boolean agileTag = false;
    public boolean analystTag = false;
    public boolean archEntTag = false;
    public boolean archSolTag = false;
    public boolean aviationTag = false;
    public boolean accountancyTag = false;
    public boolean automotiveTag = false;
    public boolean aerospaceTag = false;
    public boolean internetTag = false;
    public boolean cyberTag = false;
    public boolean enterpriseTag = false;
    public boolean netTag = false;
    public boolean twoDTag = false;
    public boolean threeDTag = false;
    public boolean DelivQone = false;
    public boolean DelivQtwo = false;
    public boolean DelivQthree = false;
    		
	
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
    public void wizardTruthItemsIOS(String col1, String col2, String col3, String col4, String col5, String col6, String col7) throws Throwable {

        count++;
        APP_LOGS.debug("------>Starting Test Case" );
        if (!runmodes[count].equalsIgnoreCase("Y")) {
            skip = true;
            APP_LOGS.debug("Runmode for test set is NO");
            throw new SkipException("Runmode for test set is NO");
           
        }

        createAppiumDriverIOS();
        loginInTheAppIOS(col2, col3);
        
        //********************Precondition****************************
        //The project must start with only this information before running the test:
        //Role: Agile like primary
        //Industry: Aviation
        //Technology:Internet of Things
        //Product:.Net
        //Deliverable no matter what information does it have
        
        SoftAssert sa = new SoftAssert(); 
        
        //Allow Access button
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(" Allow ")));
    	driver.findElement(MobileBy.AccessibilityId(" Allow ")).click();
    	APP_LOGS.debug("Allow was found and clicked");
    	
        //Go to Projects 
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Projects")));
    	driver.findElement(MobileBy.AccessibilityId("Projects")).click();
    	APP_LOGS.debug("Project button was found and clicked");
        
    	//Select a Project, the name of the project comes from the xls file, so the name there should be the same as the one in the OR.property file
    	
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty(col4))));
    	driver.findElement(MobileBy.xpath(OR.getProperty(col4))).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	APP_LOGS.debug("Project was found and clicked");
    	
    	//Go to Details
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.name("bt timesheetdetails")));
    	driver.findElement(MobileBy.name("bt timesheetdetails")).click();
    	APP_LOGS.debug("Detail was found and clicked");
    	
    	//Click Start
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("startWizardIOS"))));
    	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("startWizardIOS"))).click();
    	APP_LOGS.debug("Start button was found and clicked");
    	
    	
    	
    	//*******Role was already Saved validating data***********
    	
    	agileTag = driver.getPageSource().contains("Agile");
       	
        	if(agileTag == true){
        		APP_LOGS.debug("Agile tag was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Agile wasn't found");
        			sa.fail();
        		}
        	
        	
        	//Select Other Truth Items
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("otherRoleIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("otherRoleIOS"))).click();
        	APP_LOGS.debug("Looking for other Role TI");
        	
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("AnalystIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("AnalystIOS"))).click();
        	APP_LOGS.debug("Selecting Analyst");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("ArchitectsEnterpriseIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("ArchitectsEnterpriseIOS"))).click();
        	APP_LOGS.debug("Selecting Architecte Enterpise ");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("ArchitectsSolutionIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("ArchitectsSolutionIOS"))).click();
        	APP_LOGS.debug("Selecting Arquitect Solution");
        	//Click Ok
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("OK")));
        	driver.findElement(MobileBy.AccessibilityId("OK")).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	//Validate that all the tags selected are on the list
        	agileTag = driver.getPageSource().contains(" Agile");
        	analystTag = driver.getPageSource().contains("Analyst");
        	archEntTag = driver.getPageSource().contains("Architects - Enterprise");
        	archSolTag = driver.getPageSource().contains("Architects - Solution");
        	//Select Agile that was un selected
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("AgileIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("AgileIOS"))).click();
        	if(agileTag == true){
        		APP_LOGS.debug("Agile tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Agile wasn't found on list");
        			sa.fail();
        		}
        	if(analystTag == true){
        		
        		APP_LOGS.debug("Analyst tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Analyst wasn't found on list");
        			sa.fail();
        		}
        	if(archEntTag == true){
        		APP_LOGS.debug("Arquitect Enterprise tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Arquitect Enterprise wasn't found on list");
        			sa.fail();
        		}
        	if(archSolTag == true){
        		APP_LOGS.debug("Arquitect Solution tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Aqrquitect Solution wasn't found on list");
        			sa.fail();
        		}
        	//Click Next
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
    
        	
        //Validate Primary Role TI tags	
    	agileTag = driver.getPageSource().contains("Agile");
    	analystTag = driver.getPageSource().contains("Analyst");
    	archEntTag = driver.getPageSource().contains("Architects - Enterprise");
    	archSolTag = driver.getPageSource().contains("Architects - Solution");
        	
        	
        	
        	if(agileTag == true){
        		APP_LOGS.debug("Agile tag was found on primary Role page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Agile wasn't found on primary Role page");
        			sa.fail();
        		}
        	if(analystTag == true){
        		APP_LOGS.debug("Analyst tag was found on primary Role page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Analyst wasn't found on primary Role page");
        			sa.fail();
        		}
        	if(archEntTag == true){
        		APP_LOGS.debug("Arquitect Enterprise tag was found on primary Role page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Arquitect Enterprise wasn't found on primary Role page");
        			sa.fail();
        		}
        	if(archSolTag == true){
        		APP_LOGS.debug("Arquitect Solution tag was found on primary Role page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Aqrquitect Solution wasn't found on primary Role page");
        			sa.fail();
        		}
        	//click Next to move to industry
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
        	APP_LOGS.debug("click Next to go to Industry");
        	
        	
    	//*******Select Industry  Truth Items************
        	aviationTag = driver.getPageSource().contains("	Aviation");
           	
        	if(agileTag == true){
        		APP_LOGS.debug("Aviation tag was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Aviation wasn't found");
        			sa.fail();
        		}
        	
        	
        	//Select Other Truth Items
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("otherIndustryIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("otherIndustryIOS"))).click();
        	APP_LOGS.debug("Looking for other Industry TI");
        	
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("AccountancyIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("AccountancyIOS"))).click();
        	APP_LOGS.debug("Selecting Accountancy");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("AutomotiveIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("AutomotiveIOS"))).click();
        	APP_LOGS.debug("Selecting Automotive ");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("AerospaceIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("AerospaceIOS"))).click();
        	APP_LOGS.debug("Selecting Aerospace Solution");
        	//Click Ok
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("OK")));
        	driver.findElement(MobileBy.AccessibilityId("OK")).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	//Validate that all the tags selected are on the list
        	aviationTag = driver.getPageSource().contains("Aviation");
        	accountancyTag = driver.getPageSource().contains("Accountancy");
        	aerospaceTag = driver.getPageSource().contains("Aerospace & Defence");
        	automotiveTag = driver.getPageSource().contains("Automotive");
        	
        	//Select Aviation that was selected
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("AgileIOS"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("AgileIOS"))).click();
        	if(aviationTag == true){
        		APP_LOGS.debug("Aviation tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Aviation wasn't found on list");
        			sa.fail();
        		}
        	if(accountancyTag == true){
        		
        		APP_LOGS.debug("Accountancy tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Accountancy wasn't found on list");
        			sa.fail();
        		}
        	if(aerospaceTag == true){
        		APP_LOGS.debug("Aerospace tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Aerospace wasn't found on list");
        			sa.fail();
        		}
        	if(automotiveTag == true){
        		APP_LOGS.debug("Automotive Solution tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Automotive Solution wasn't found on list");
        			sa.fail();
        		}
        	//Click Next
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
    
        	
        //Validate Primary Industry TI tags	
        	aviationTag = driver.getPageSource().contains("Aviation");
        	accountancyTag = driver.getPageSource().contains("Accountancy");
        	aerospaceTag = driver.getPageSource().contains("Aerospace & Defence");
        	automotiveTag = driver.getPageSource().contains("Automotive");
        	
        	
        	
        	if(aviationTag == true){
        		APP_LOGS.debug("Aviation tag was found on primary Industry page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Aviation wasn't found on primary Industry page");
        			sa.fail();
        		}
        	if(accountancyTag == true){
        		APP_LOGS.debug("Accountancy tag was found on primary Industry page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Accountancy wasn't found on primary Industry page");
        			sa.fail();
        		}
        	if(aerospaceTag == true){
        		APP_LOGS.debug("Aerospace tag was found on primary Industry page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Aerospace Enterprise wasn't found on primary Industry page");
        			sa.fail();
        		}
        	if(automotiveTag == true){
        		APP_LOGS.debug("Automotive Solution tag was found on primary Industry page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Automotive Solution wasn't found on primary Industry page");
        			sa.fail();
        		}
        	//click Next to move to Technology
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
        	APP_LOGS.debug("click Next to go to Techbology");
        	
        	//*************Select technology Truth Items
        	
        	internetTag = driver.getPageSource().contains("Internet of Things");
           	
        	if(internetTag == true){
        		APP_LOGS.debug("Internet of things tag was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Internet of things wasn't found");
        			sa.fail();
        		}
        	
        	
        	//Select Other Truth Items
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("otherTechnologyIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("otherTechnologyIOS"))).click();
        	APP_LOGS.debug("Looking for other Industry TI");
        	
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("CyberSecutityIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("CyberSecutityIOS"))).click();
        	APP_LOGS.debug("Selecting Cyber Security");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("EnterpriseIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("EnterpriseIOS"))).click();
        	APP_LOGS.debug("Selecting Selecting Enterprise ");
        	
        	//Click Ok
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("OK")));
        	driver.findElement(MobileBy.AccessibilityId("OK")).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	//Validate that all the tags selected are on the list
        	internetTag = driver.getPageSource().contains("Internet of Things");
        	cyberTag = driver.getPageSource().contains("Cyber Security");
        	enterpriseTag = driver.getPageSource().contains("Enterprise on Premise");
        	
        	
        	//Select Internet of things that was selected
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("InternetThingsTIIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("InternetThingsTIIOS"))).click();
        	if(internetTag == true){
        		APP_LOGS.debug("Internet of things tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Internet of things wasn't found on list");
        			sa.fail();
        		}
        	if(cyberTag == true){
        		
        		APP_LOGS.debug("Cyber security tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Cyber Security wasn't found on list");
        			sa.fail();
        		}
        	if(enterpriseTag == true){
        		APP_LOGS.debug("Enterprise tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Enterprise wasn't found on list");
        			sa.fail();
        		}
        	
        	//Click Next
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
    
        	
        //Validate Primary Technology TI tags	
        	internetTag = driver.getPageSource().contains("Internet of Things");
        	cyberTag = driver.getPageSource().contains("Cyber Security");
        	enterpriseTag = driver.getPageSource().contains("Enterprise on Premise");
        	
        	
        	
        	if(internetTag == true){
        		APP_LOGS.debug("Internet of things tag was found on primary Technology page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Internet of things wasn't found on primary Technology page");
        			sa.fail();
        		}
        	if(cyberTag == true){
        		APP_LOGS.debug("Cyber tag was found on primary Technology page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Cyber tag wasn't found on primary Technology page");
        			sa.fail();
        		}
        	if(aerospaceTag == true){
        		APP_LOGS.debug("Aerospace tag was found on primary Technology page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Aerospace Enterprise wasn't found on primary Technology page");
        			sa.fail();
        		}
        	if(enterpriseTag == true){
        		APP_LOGS.debug("Enterprise Solution tag was found on primary Technology page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Enterprise Solution wasn't found on primary Techology page");
        			sa.fail();
        		}
        	//click Next to move to Products
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
        	APP_LOGS.debug("Click Next to go to Product");
        	
        	//*******************Select Product Truth Item
        	
        	netTag = driver.getPageSource().contains("netTag");
           	
        	if(netTag == true){
        		APP_LOGS.debug(".NET tag was found");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug(".NET wasn't found");
        			sa.fail();
        		}
        	
        	
        	//Select Other Truth Items
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("otherProductsIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("otherProductsIOS"))).click();
        	APP_LOGS.debug("Looking for other Industry TI");
        	
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("2DIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("2DIOS"))).click();
        	APP_LOGS.debug("Selecting 2D ");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty("3DIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty("3DIOS"))).click();
        	APP_LOGS.debug("Selecting 3D ");
        	
        	//Click Ok
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("OK")));
        	driver.findElement(MobileBy.AccessibilityId("OK")).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	//Validate that all the tags selected are on the list
        	netTag = driver.getPageSource().contains(".NET");
        	twoDTag = driver.getPageSource().contains("2D");
        	threeDTag = driver.getPageSource().contains("3D");
        	
        	
        	//Select Agile that was selected
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId(OR.getProperty(".netTIIOS"))));
        	driver.findElement(MobileBy.AccessibilityId(OR.getProperty(".netTIIOS"))).click();
        	if(netTag == true){
        		APP_LOGS.debug(".NET tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug(".NET wasn't found on list");
        			sa.fail();
        		}
        	if(twoDTag == true){
        		
        		APP_LOGS.debug("2D tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("2D wasn't found on list");
        			sa.fail();
        		}
        	if(threeDTag == true){
        		APP_LOGS.debug("3D tag was found on list");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("3D wasn't found on list");
        			sa.fail();
        		}
        
        	//Click Next
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
    
        	
        //Validate Primary Role TI tags	
        	netTag = driver.getPageSource().contains(".NET");
        	twoDTag = driver.getPageSource().contains("2D");
        	threeDTag = driver.getPageSource().contains("3D");
        	
        	
        	
        	if(netTag == true){
        		APP_LOGS.debug(".NET tag was found on primary Product page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug(".NET wasn't found on primary Product page");
        			sa.fail();
        		}
        	if(twoDTag == true){
        		APP_LOGS.debug("2D tag was found on primary Product page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("2D wasn't found on primary Product page");
        			sa.fail();
        		}
        	if(threeDTag == true){
        		APP_LOGS.debug("3D tag was found on primary Product page");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("3D Enterprise wasn't found on primary Product page");
        			sa.fail();
        		}
        	
        	//click Next to move to Deliverable 
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
        	APP_LOGS.debug("click Next to go to Deliverable");
        	
        	//************************** Entering Deliverable
        	//Validate if the 3 questions exists
        	DelivQone = driver.getPageSource().contains("What was the overall project objective?");
        	DelivQtwo = driver.getPageSource().contains("How did you help to achieve the objective?");
        	DelivQthree = driver.getPageSource().contains("What challenges did you help overcome?");
        	
        	if(DelivQone == true){
        		APP_LOGS.debug("First question for deliverable exists");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("First question for deliverable doesn't exists");
        			sa.fail();
        		}
        	if(DelivQtwo == true){
        		APP_LOGS.debug("Second question for deliverable exists");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Second question for deliverable exists");
        			sa.fail();
        		}
        	if(DelivQthree == true){
        		APP_LOGS.debug("Third question for deliverable exists");
        		pass=true;
                fail=false;
                isTestPass=true;
                org.testng.Assert.assertTrue(pass);
        		}else{
        			pass=false;
                    fail=true;
                    isTestPass=false;
        			APP_LOGS.debug("Third question for deliverable exists");
        			sa.fail();
        		}
        	//Entering data for question 1
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("DelivQ1IOS"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("DelivQ1IOS"))).sendKeys("Test question overall objective (Automated)");
        	//Entering data for question 2
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("DelivQ2IOS"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("DelivQ2IOS"))).sendKeys("Test question achive objective (Automated)");
        	//Entering data for question 3
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("DelivQ3IOS"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("DelivQ3IOS"))).sendKeys("Test question help overcome challenges (Automated)");
        	
        	
        	//click Next to move to Deliverable 
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
        	
        
        if (driver.getPageSource().contains("Truth Item wizard with no problem.")){
        
         pass=false;
         fail=true;
         isTestPass=false;
         FinalMessage="Something went wrong with the wizard";
        }else{
        	
        	pass=true;
        	fail=false;
            isTestPass=true;
            FinalMessage="Wizard Complete";
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

