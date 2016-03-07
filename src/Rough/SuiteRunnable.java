package Rough;

import com.gktech.util.XLS_Reader;

public class SuiteRunnable {
	
	public static void main(String[] args) {
		XLS_Reader xls=new XLS_Reader("D:/Online_Batches/LaasyaUK/Workspace/WebDriver_TestNG_DataDriven/src/com/gktech/xlsfiles/Suite.xlsx");
		System.out.println(isSuiteRunnable(xls, "newcars"));
	}
	//to get runmode of the test suite
	public static boolean isSuiteRunnable(XLS_Reader xls, String suiteName){
		boolean isExecutable=false;
		for(int i=2;i<=xls.getRowCount("Testsuites");i++){
			String suite=xls.getCellData("Testsuites", "TSID", i);
			String runmode=xls.getCellData("Testsuites", "Runmode", i);
			System.out.println(suite+"==="+runmode);
			if(suite.equalsIgnoreCase(suiteName)){
				if(runmode.equalsIgnoreCase("Y")){
					isExecutable=true;
				}
			}
		}
		return isExecutable;		
	}

}
