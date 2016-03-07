package Rough;

import com.gktech.util.XLS_Reader;

public class GetTestDataRunmodes {
	public static void main(String[] args) {
		XLS_Reader xls=new XLS_Reader("D:/Online_Batches/LaasyaUK/Workspace/WebDriver_TestNG_DataDriven/src/com/gktech/xlsfiles/newcars.xlsx");
		getTestDataRunmodes(xls, "Registration");
	}
	
	
	//to get the test data runmodes
	public static String[] getTestDataRunmodes(XLS_Reader xls, String sheetName){
		String[] runmodes;
		if(!xls.isSheetExist(sheetName)){
			System.out.println("Sheet not found");
		}
		//size declaration
		runmodes=new String[xls.getRowCount(sheetName)-1];
		System.out.println("Total rows: "+xls.getRowCount(sheetName));
		//values declaration
		for(int i=2;i<=xls.getRowCount(sheetName);i++){
			System.out.println(xls.getCellData(sheetName, "Runmode", i));
			runmodes[i-2]=xls.getCellData(sheetName, "Runmode", i);
		}
		return runmodes;
	}

}
