package com.autoprac.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.qa.base.TestBase;

import io.qameta.allure.Step;

public class HomePage extends TestBase{
	
	@FindBy(id="header_logo")
	WebElement logo;
	
	@FindBy(id="contact-link")
	WebElement contactLink;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInLink;
	
	@FindBy(xpath="//a[contains(@title,'View my shopping cart')]")
	WebElement cartLink;
	
	@FindBy(xpath="//input[@id= 'search_query_top']")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
	WebElement searchBtn;
	
	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement customerName;
	
	// Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions (methods)
	@Step("verifying logo of HomePage is displayed step.....")
	public boolean verifyLogoIsDisplayed() {
			return logo.isDisplayed();
	}
	@Step("verifying Contact link on HomePage step.....")
	public ContactUsPage clickOnContactLink() {
		contactLink.click();
		return new ContactUsPage();
	}
	@Step("verifying SignIn link on HomePage step.....")
	public SignInPage clickOnSigninLink() {
		signInLink.click();
		return new SignInPage();
		
		
	}
	@Step("getting RegistrationPage from HomePage step.....")
	public RegistrationPage getRegistrationPage() {
		signInLink.click();
		return new RegistrationPage();
		
	}
	@Step("verifying Cart link on HomePage step.....")
	public CartPage clickOnCartLink() {
		cartLink.click();
		return new CartPage();
	}
	
	@Step("verifying HomePage title step.....")
	public String verifyHomePageTitle()  {
		return driver.getTitle();
	}
	
	@Step("searching item on HomePage step.....")
	public String searchItem() {
		searchBox.sendKeys("T-shirts");
		searchBtn.click();
		return driver.getTitle();
			
	}
	@Step("getting HomePage customer name step.....")
	public String checkCustomerName() {
		return customerName.getText();
		
	}
	
	
}
