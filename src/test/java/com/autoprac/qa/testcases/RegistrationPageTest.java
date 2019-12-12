package com.autoprac.qa.testcases;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autoprac.qa.base.TestBase;
import com.autoprac.qa.pages.HomePage;
import com.autoprac.qa.pages.RegistrationPage;
import com.autoprac.qa.pages.SignInPage;
import com.autoprac.qa.utils.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RegistrationPageTest extends TestBase{
	HomePage homepage;
	SignInPage signinpage;
	RegistrationPage registrationpage;
	TestUtil testutil;
	private String excelPath = "/Users/tanu/eclipse-workspace/AutomationPracticeProject/src/main/java/com/autoprac/qa/testdata/TestData.xlsx";
	private String sheetName = "RegistrationData";
	
	
	public RegistrationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		homepage = new HomePage();
		signinpage = homepage.clickOnSigninLink();
		registrationpage = signinpage.createAccount(prop.getProperty("registrationEmail"));
	}
	
	

    @Test(dataProvider = "excelData")
    public void read(String fname, String lname, 
			String passwd, String adrs,String city,String state, CharSequence postcode,
			String country,CharSequence phoneNo, String aliasAdrs) {
        System.out.println(fname + ":" + lname + ":" + passwd + ":" + adrs + ":" + city + ":" + state + ":" + postcode + ":" +
    			country + ":" + phoneNo + ":" +  aliasAdrs);

    }
   

    @Test(dataProvider = "excelData", priority=1, description="verifying SignIn page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: registering from RegistrationPage test")
	@Story("Story Name: registering from RegistrationPage")
    public void validateRegistration(String fname, String lname, 
			String passwd, String adrs,String city,String state,CharSequence postcode,
			String country,CharSequence phoneNo, String aliasAdrs) {
       registrationpage.validateRegistration(fname, lname, passwd, adrs, city, state, postcode,country,phoneNo, aliasAdrs);
//      String customername=  homepage.checkCustomerName();
//      Assert.assertEquals(customername, "Chetan G");
    }

    @DataProvider(name="excelData")
    public Object[][] readExcel() throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException{
    	testutil = new TestUtil();
    	return testutil.readExcel(excelPath, sheetName);
    }


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
