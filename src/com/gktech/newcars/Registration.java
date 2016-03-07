package com.gktech.newcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class Registration extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseskip(){
		if(!TestUtil.isTestCaseRunnable(newcarsxls, "Registration")){
			throw new SkipException("Runmode of the Registration test case is set as no, so skipping Registration testcase");
		}
		runmodes=TestUtil.getTestDataRunmodes(newcarsxls, "Registration");
	}
	//test case:
	@Test(dataProvider="getData")
	public void registration(String name, String email, String mobile, String pass, String confpass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode of the test data is set as no, so skipping row number: "+count);
		}
		//executing testcase
		System.out.println(name+"=="+email+"=="+mobile+"=="+pass+"=="+confpass);
		//webdriver code
		Openbrowser("Mozilla");
		driver.get("http://carwale.com");
		getObject("loglink").click();
		getObject("regsignup").click();
		getObject("regname").sendKeys(name);
		getObject("regemail").sendKeys(email);
		getObject("regmobile").sendKeys(mobile);
		getObject("regpass").sendKeys(pass);
		getObject("regconfpass").sendKeys(confpass);
		getObject("regsignupbutton").click();
		closebrowser();
	}
	
	
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getTestData(newcarsxls, "Registration");
		
	}
	
}
