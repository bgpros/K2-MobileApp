package appium.SuiteLoginAndroid;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import appium.actionwords.Actionwords;
import appium.util.TestUtil;

public class TestSuiteBaseAndroid extends Actionwords{

	@BeforeSuite
	public void checkSuiteSkip() throws Exception {
		initialize();
		if(!TestUtil.isSuiteRunable(Suite, "SuiteLoginAndroid")){
			APP_LOGS.debug("Run Mode is set to NO");
			throw new SkipException("Run Mode for Links is NO");
			
		}
	}
}

