package appium.util;

import org.apache.log4j.Logger;

public class TestUtil {
	
	public static Logger APP_LOGS=null;
	
	public static boolean isSuiteRunable(Xls_reader xls, String SuiteName) {
		boolean isExecutable = false;
		APP_LOGS=Logger.getLogger("devpinoyLogger");
		
		for (int i=2; i <= xls.getRowCount("TestSuite"); i++){
			String suite = xls.getCellData("TestSuite", "Suite",i);
			String runMode = xls.getCellData("TestSuite", "Run Mode", i);
			
			if(suite.equals(SuiteName)){
				if(runMode.equals("Y")) {
					isExecutable = true;
					APP_LOGS.debug("Suite is Runnable: " + isExecutable);
				}else{
					isExecutable = false;
					APP_LOGS.debug("Suite is Runnable: " + isExecutable);
				}
			}
		}
		xls=null;
		return isExecutable;
	}
	
	public static boolean isTestCaseRunnable(Xls_reader xls,  String testCaseName){
		 boolean isExecutable = false;
		 
		 APP_LOGS=Logger.getLogger("devpinoyLogger");
		 APP_LOGS.debug("Test Case name " + testCaseName);
		 APP_LOGS.debug("xls file name " + xls);
		 for(int i=2; i<=xls.getRowCount("TestCases"); i++){
			 
			 String tcid=xls.getCellData("TestCases", "ID", i);		 
			 String runmode=xls.getCellData("TestCases", "RunMode", i);			 
			 if(tcid.equalsIgnoreCase(testCaseName)){				 
				 if(runmode.equalsIgnoreCase("Y")){
					 isExecutable = true;
					 				 
				 }else{
					 isExecutable = false;
					 
				 }
			 }		 
		 }
		APP_LOGS.debug("Test Case is Executable " + isExecutable);
		xls=null;
		return isExecutable;
		
	}	
	
	
	public static Object[][] getData(Xls_reader xls, String TestCaseName){	
		
		if(!xls.isSheetExist(TestCaseName)){
			xls=null;
			return new Object[1][0];
			
		}
		int rows=xls.getRowCount(TestCaseName);
		int cols=xls.getColumnCount(TestCaseName);
		
		
		Object[][] data = new Object[rows-1][cols];
		for(int rowNum=2;rowNum<=rows; rowNum++){
			for(int colNum=0; colNum<cols; colNum++){
				data[rowNum-2][colNum] = xls.getCellData(TestCaseName, colNum, rowNum);
			}
		}
		return data;
	}

	public static void reportDataSetResult(Xls_reader xls, String testCaseName, int rowNum, String result){
		xls.setCellData(testCaseName, "Results", rowNum, result);
	}
	
	public static void reportStatsResult(Xls_reader xls, String testCaseName, int rowNum, String stats, int result) throws Throwable{
		Thread.sleep(300);
		xls.setCellData(testCaseName, stats, rowNum, Integer.toString(result));
	}
	
	public static String[] getDataSetRunModes(Xls_reader xls, String SheetName){
		String[] runmodes=null;
		APP_LOGS=Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Getting data from Runmode");
		if(!xls.isSheetExist(SheetName)){
			xls=null;
			SheetName=null;
			runmodes = new String[1];
			runmodes[0]="Y";
			System.out.println("runmodes" + runmodes);
			return runmodes;
			
		}
		runmodes = new String[xls.getRowCount(SheetName)-1];	
		for (int i=2; i<=runmodes.length+1;i++){
			runmodes[i-2]=xls.getCellData(SheetName,"RunMode",i);
			
		}
		xls=null;
		SheetName=null;
		return runmodes;
		
	}
	
	public static int getRowNum(Xls_reader xls, String id){
		for(int i=2; i<= xls.getRowCount("TestCases") ; i++){
			String tcid=xls.getCellData("TestCases", "ID", i);
			if(tcid.equals(id)){
				xls=null;
				return i;
			}
		}
		return -1;	
	}
	
	public static void StatsToReport(Xls_reader xls, String TestCaseName, int count, String status, int linkCount, int MalFormedURL, int Informational, int Success, int Redirection, int ClientError, int ServerError ) throws Throwable{
		reportDataSetResult(xls, TestCaseName, count+2,status);
		Thread.sleep(200);
		reportStatsResult(xls, TestCaseName, count+2, "Links Found", (linkCount-1));
		Thread.sleep(200);
		reportStatsResult(xls, TestCaseName, count+2, "MalFormed URL", MalFormedURL);
		Thread.sleep(200);
		reportStatsResult(xls, TestCaseName, count+2, "Informational", Informational);
		Thread.sleep(200);
		reportStatsResult(xls, TestCaseName, count+2, "Success", Success);
		Thread.sleep(200);
		reportStatsResult(xls, TestCaseName, count+2, "Redirection", Redirection);
		Thread.sleep(200);
		reportStatsResult(xls, TestCaseName, count+2, "Client Error", ClientError);
		Thread.sleep(200);
		reportStatsResult(xls, TestCaseName, count+2, "Server Error", ServerError);
		
	}
	
	public static void SetShareResult(Xls_reader xls, String TestCaseName, int count, String status) throws Throwable{
		Thread.sleep(300);
		xls.setCellData(TestCaseName, "Description", count, status);
	}
}

