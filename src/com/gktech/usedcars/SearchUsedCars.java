package com.gktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class SearchUsedCars extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
	if(!TestUtil.isTestCaseRunnable(usedcarsxls, "SearchUsedCars")){
		throw new SkipException("Runmode of the SearchUsedCars test case is set as no, so skipping SearchUsedCars test case");
	}
	runmodes=TestUtil.getTestDataRunmodes(usedcarsxls, "SearchUsedCars");	
	}
	
	//test case
	@Test(dataProvider="getData")
	public void SearchUsedCars(String uname, String pass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode of the test data is set as no, so skipping rownumber: "+count);
		}
		//executing testcase
		System.out.println(uname+"==="+pass);
		//webdriver code
		
	}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getTestData(usedcarsxls, "SearchUsedCars");
		
	}
	

}
