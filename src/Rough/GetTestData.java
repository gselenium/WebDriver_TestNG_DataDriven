package Rough;

import com.gktech.util.XLS_Reader;

public class GetTestData {
	
	public static void main(String[] args) {
		XLS_Reader xls=new XLS_Reader("D:/Online_Batches/LaasyaUK/Workspace/WebDriver_TestNG_DataDriven/src/com/gktech/xlsfiles/newcars.xlsx");
		getTestData(xls, "Registration");
	}
	
	//to get the test data from the excel file:
	public static Object[][] getTestData(XLS_Reader xls, String sheetName){
		if(!xls.isSheetExist(sheetName)){
			System.out.println("Sheet Not found");
		}
		int rows=xls.getRowCount(sheetName);
		int cols=xls.getColumnCount(sheetName);
		//size declaration
		Object[][] data=new Object[rows-1][cols-1];
		//values declaration
		for(int rowNum=2;rowNum<=rows;rowNum++){
			for(int colNum=0;colNum<=cols-2;colNum++){
				System.out.print(xls.getCellData(sheetName, colNum, rowNum)+"===");
				data[rowNum-2][colNum]=xls.getCellData(sheetName, colNum, rowNum);
			}
			System.out.println();
		}
		return data;
		
	}

}
