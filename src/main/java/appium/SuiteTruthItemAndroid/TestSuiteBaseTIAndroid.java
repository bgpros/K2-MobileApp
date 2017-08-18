package appium.SuiteTruthItemAndroid;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import appium.actionwords.Actionwords;
import appium.util.TestUtil;

public class TestSuiteBaseTIAndroid extends Actionwords{

	@BeforeSuite
	public void checkSuiteSkip() throws Exception {
		initialize();
		if(!TestUtil.isSuiteRunable(Suite, "SuiteTruthItemsAndroid")){
			APP_LOGS.debug("Run Mode is set to NO");
			throw new SkipException("Run Mode for Links is NO");
			
		}
	}

}

