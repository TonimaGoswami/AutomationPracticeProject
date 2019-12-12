package com.autoprac.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autoprac.qa.base.TestBase;
import com.autoprac.qa.pages.HomePage;
import com.autoprac.qa.pages.SignInPage;
import com.autoprac.qa.utils.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SignInPageTest extends TestBase{
	SignInPage signinpage;
	HomePage homepage;
	TestUtil testutil;
	
	
	public SignInPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		homepage = new HomePage();
		signinpage = homepage.clickOnSigninLink();
	}
	
	@Test(priority=1, description="verifying SignIn page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: Verify signin page title test")
	@Story("Story Name: Check SignIn page title")
	public void validateTitleOfSignInPageTest() {
		String Stitle = signinpage.validateTitleOfSignInPage();
		Assert.assertEquals(Stitle, "Login - My Store");
	}
	
	@Test(priority=2, description="signin into app test ")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case description: verify signin into application with correct credentials")
	@Story("Story Name: To check signin functionality ")
	public void SignInTest() {
		signinpage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=3, description="signin from SignIn page ")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: verifying forgot password link on SignInPage  test")
	@Story("Story Name: Check forgot password link on SignIn page ")
	public void clickOnForgotPasswdLinkTest() {
		signinpage.clickOnForgotPasswdLink();
	}
	
	
	@Test(priority=4, description="signin from SignIn page ")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case description: registering from SignIn page  test")
	@Story("Story Name: Check registration from SignIn page ")
	public void createAccountTest() {
		signinpage.createAccount(prop.getProperty("registrationEmail"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
