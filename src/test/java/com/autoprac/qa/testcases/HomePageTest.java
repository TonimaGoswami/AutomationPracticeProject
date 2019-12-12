package com.autoprac.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autoprac.qa.base.TestBase;
import com.autoprac.qa.pages.CartPage;
import com.autoprac.qa.pages.ContactUsPage;
import com.autoprac.qa.pages.HomePage;
import com.autoprac.qa.pages.RegistrationPage;
import com.autoprac.qa.pages.SignInPage;
import com.autoprac.qa.utils.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class HomePageTest extends TestBase{
	HomePage homepage;
	ContactUsPage contactpage;
	SignInPage signinpage;
	CartPage cartpage;
	TestUtil testutil;
	 RegistrationPage registrationpage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		homepage = new HomePage();
		contactpage = new ContactUsPage();
		signinpage = new SignInPage();
		registrationpage = new RegistrationPage();
		}
	
	@Test(priority=1, description="verifying logo is displayed on HomePage")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: verifying logo is displayed on HomePage test")
	@Story("Story Name: Check logo is displayed on HomePage")
	public void verifyLogoIsDisplayedTest() {
		Assert.assertTrue(homepage.verifyLogoIsDisplayed());
	}
	
	@Test(priority=2, description="verifying SignIn link on HomePage")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: verifying SignIn link on HomePage test")
	@Story("Story Name: Check SignIn link on HomePage")
	public void clickOnSignInLinkTest() {
		signinpage = homepage.clickOnSigninLink();
	}
	
	@Test(priority=3, description="getting RegistrationPage from HomePage")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: getting RegistrationPage from HomePage test")
	@Story("Story Name: getting RegistrationPage from HomePage")
	public void getRegistrationPageTest() {
		registrationpage = homepage.getRegistrationPage();
	}
	
	@Test(priority=4, description="verifying Contact link on HomePage")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: verifying Contact link on HomePage test")
	@Story("Story Name: Check Contact link on HomePage")
	public void clickOnContactLinkTest() {
		contactpage = homepage.clickOnContactLink();
	}
	
	@Test(priority=5, description="verifying HomePage title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: Verify HomePage title test")
	@Story("Story Name: Check HomePage title")
	public void verifyHomePageTitleTest() {
		String homepageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "My Store");
	}
	
	@Test(priority=6, description="searching item on HomePage ")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: searching item on HomePage test")
	@Story("Story Name: searching item on HomePage title")
	public void searchItemTest() {
		String searchpageTitle = homepage.searchItem();
		Assert.assertEquals(searchpageTitle, "Search - My Store");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
