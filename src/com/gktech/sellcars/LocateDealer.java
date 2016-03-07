package com.gktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class LocateDealer extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
	if(!TestUtil.isTestCaseRunnable(sellcarsxls, "LocateDealer")){
		throw new SkipException("Runmode of the LocateDealer test case is set as no, so skipping LocateDealer test case");
	}
	runmodes=TestUtil.getTestDataRunmodes(sellcarsxls, "LocateDealer");	
	}
	
	//test case
	@Test(dataProvider="getData")
	public void locateDealer(String uname, String pass){
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
		return TestUtil.getTestData(sellcarsxls, "LocateDealer");
		
	}
	

}
