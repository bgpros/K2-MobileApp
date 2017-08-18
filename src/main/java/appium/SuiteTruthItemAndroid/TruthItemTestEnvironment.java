package appium.SuiteTruthItemAndroid;

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

public class TruthItemTestEnvironment extends TestSuiteBaseTIAndroid {
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
    public void wizardTruthItemsAndroid(String col1, String col2, String col3, String col4, String col5, String col6, String col7) throws Throwable {

        count++;
        APP_LOGS.debug("------>Starting Test Case" );
        if (!runmodes[count].equalsIgnoreCase("Y")) {
            skip = true;
            APP_LOGS.debug("Runmode for test set is NO");
            throw new SkipException("Runmode for test set is NO");
           
        }

        createAppiumDriverAndroid();
        loginInTheAppAndroid(col2, col3);
        
        //********************Precondition****************************
        //The project must start with only this information before running the test:
        //Role: Agile like primary
        //Industry: Aviation
        //Technology:Internet of Things
        //Product:.Net
        //Deliverable no matter what information does it have
        
        SoftAssert sa = new SoftAssert(); 
        
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
        
    	//Select a Project, the name of the project comes from the xls file, so the name ther should be the same as the one in the OR.property file
    	
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty(col4))));
    	driver.findElement(MobileBy.xpath(OR.getProperty(col4))).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	APP_LOGS.debug("Project was found and clicked");
    	
    	//Go to Details
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Details")));
    	driver.findElement(MobileBy.AccessibilityId("Details")).click();
    	APP_LOGS.debug("Detail was found and clicked");
    	
    	//Click Start
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("startWizardAndroid"))));
    	driver.findElement(MobileBy.id(OR.getProperty("startWizardAndroid"))).click();
    	APP_LOGS.debug("Start button was found and clicked");
    	
    	//Click Yes on Popup (This is only for IOS)
    	//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Yes")));
    	//driver.findElement(MobileBy.AccessibilityId("Yes")).click();
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	//Click start IOS
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Start")));
        //driver.findElement(MobileBy.AccessibilityId("Start")).click();
    	
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
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("otherRoleAndroid"))));
        	driver.findElement(MobileBy.id(OR.getProperty("otherRoleAndroid"))).click();
        	APP_LOGS.debug("Looking for other Role TI");
        	
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("AnalystAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("AnalystAndroid"))).click();
        	APP_LOGS.debug("Selecting Analyst");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("ArchitectsEnterpriseAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("ArchitectsEnterpriseAndroid"))).click();
        	APP_LOGS.debug("Selecting Architecte Enterpise ");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("ArchitectsSolutionAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("ArchitectsSolutionAndroid"))).click();
        	APP_LOGS.debug("Selecting Arquitect Solution");
        	//Click Ok
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Ok")));
        	driver.findElement(MobileBy.AccessibilityId("Ok")).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	//Validate that all the tags selected are on the list
        	agileTag = driver.getPageSource().contains(" Agile");
        	analystTag = driver.getPageSource().contains("Analyst");
        	archEntTag = driver.getPageSource().contains("Architects - Enterprise");
        	archSolTag = driver.getPageSource().contains("Architects - Solution");
        	//Select Agile that was un selected
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("AgileAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("AgileAndroid"))).click();
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
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("otherRoleAndroid"))));
        	driver.findElement(MobileBy.id(OR.getProperty("otherRoleAndroid"))).click();
        	APP_LOGS.debug("Looking for other Industry TI");
        	
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("AccountancyAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("AccountancyAndroid"))).click();
        	APP_LOGS.debug("Selecting Accountancy");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("AutomotiveAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("AutomotiveAndroid"))).click();
        	APP_LOGS.debug("Selecting Automotive ");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("AerospaceAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("AerospaceAndroid"))).click();
        	APP_LOGS.debug("Selecting Aerospace Solution");
        	//Click Ok
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Ok")));
        	driver.findElement(MobileBy.AccessibilityId("Ok")).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	//Validate that all the tags selected are on the list
        	aviationTag = driver.getPageSource().contains("Aviation");
        	accountancyTag = driver.getPageSource().contains("Accountancy");
        	aerospaceTag = driver.getPageSource().contains("Aerospace & Defence");
        	automotiveTag = driver.getPageSource().contains("Automotive");
        	
        	//Select Aviation that was selected
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("AgileAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("AgileAndroid"))).click();
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
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("otherRoleAndroid"))));
        	driver.findElement(MobileBy.id(OR.getProperty("otherRoleAndroid"))).click();
        	APP_LOGS.debug("Looking for other Industry TI");
        	
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("CyberSecutityAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("CyberSecutityAndroid"))).click();
        	APP_LOGS.debug("Selecting Cyber Security");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("EnterpriseAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("EnterpriseAndroid"))).click();
        	APP_LOGS.debug("Selecting Selecting Enterprise ");
        	
        	//Click Ok
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Ok")));
        	driver.findElement(MobileBy.AccessibilityId("Ok")).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	//Validate that all the tags selected are on the list
        	internetTag = driver.getPageSource().contains("Internet of Things");
        	cyberTag = driver.getPageSource().contains("Cyber Security");
        	enterpriseTag = driver.getPageSource().contains("Enterprise on Premise");
        	
        	
        	//Select Internet of things that was selected
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("InternetThingsTIAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("InternetThingsTIAndroid"))).click();
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
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.id(OR.getProperty("otherRoleAndroid"))));
        	driver.findElement(MobileBy.id(OR.getProperty("otherRoleAndroid"))).click();
        	APP_LOGS.debug("Looking for other Industry TI");
        	
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("2DAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("2DAndroid"))).click();
        	APP_LOGS.debug("Selecting 2D ");
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("3DAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("3DAndroid"))).click();
        	APP_LOGS.debug("Selecting 3D ");
        	
        	//Click Ok
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Ok")));
        	driver.findElement(MobileBy.AccessibilityId("Ok")).click();
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	
        	//Validate that all the tags selected are on the list
        	netTag = driver.getPageSource().contains(".NET");
        	twoDTag = driver.getPageSource().contains("2D");
        	threeDTag = driver.getPageSource().contains("3D");
        	
        	
        	//Select Agile that was selected
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty(".netTIAndroid"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty(".netTIAndroid"))).click();
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
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("DelivQ1Android"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("DelivQ1Android"))).sendKeys("Test question overall objective (Automated)");
        	//Entering data for question 2
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("DelivQ2Android"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("DelivQ2Android"))).sendKeys("Test question achive objective (Automated)");
        	//Entering data for question 3
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath(OR.getProperty("DelivQ3Android"))));
        	driver.findElement(MobileBy.xpath(OR.getProperty("DelivQ3Android"))).sendKeys("Test question help overcome challenges (Automated)");
        	
        	
        	//click Next to move to Deliverable 
        	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Next")));
        	driver.findElement(MobileBy.AccessibilityId("Next")).click();
        	
        
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
