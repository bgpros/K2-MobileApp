package appium.SuiteTruthItemAndroid;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class NewAnswerQ2Android {
	@BeforeTest
	  public void beforeTest() {
		  }
		
	  @Test(dataProvider = "dp")
	  public void f(Integer n, String s) {
	  }
	 
	//Login
	//Go to Project
	//Select a Project
	//Go to Detail
	//Click Edit
	//Click Deliverable
	//Click on the second Question
	//Clean the field
	//Enter another text
	//Click Save


	  
	  

	  @AfterTest
	  public void afterTest() {
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
	  }

	 
	  
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }

}
