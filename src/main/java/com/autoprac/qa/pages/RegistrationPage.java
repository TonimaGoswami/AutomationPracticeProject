package com.autoprac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.qa.base.TestBase;

import io.qameta.allure.Step;

public class RegistrationPage extends TestBase{
	
	
	@FindBy(id = "email_create")
	@CacheLookup
	WebElement createEmailBox;
	
	@FindBy(id = "SubmitCreate")
	@CacheLookup
	WebElement submitCreateBox;
	
	@FindBy(id = "uniform-id_gender1")
	@CacheLookup
	WebElement maleRadioBtn;
	
	@FindBy(id = "uniform-id_gender2")
	@CacheLookup
	WebElement femaleRadioBtn;
	
	@FindBy(id = "customer_firstname")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(id = "customer_lastname")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(id = "passwd")
	@CacheLookup
	WebElement passWord;
	
	@FindBy(id = "address1")
	@CacheLookup
	WebElement addressBox;
	
	@FindBy(id = "city")
	@CacheLookup
	WebElement cityBox;
	
	@FindBy(id="id_state")
	@CacheLookup
	WebElement stateBox;
	
	@FindBy(id="postcode")
	@CacheLookup
	WebElement postcodeBox;
	
	@FindBy(id="id_country")
	@CacheLookup
	WebElement countryBox;
	
	@FindBy(id="phone_mobile")
	@CacheLookup
	WebElement mobileBox;
	
	@FindBy(id="alias")
	@CacheLookup
	WebElement aliasBox;
	
	@FindBy(id = "submitAccount")
	WebElement submitAccountBtn;


	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("registering in with firstname: {0} and lastname: {1} step....")
	public HomePage validateRegistration(String fname, String lname, 
			String passwd, String adrs,String city,String state,CharSequence postcode,
			String country, CharSequence phoneNo, String aliasAdrs ) {
		
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		passWord.sendKeys(passwd);
		addressBox.sendKeys(adrs);
		cityBox.sendKeys(city);
		stateBox.sendKeys(state);
		
		postcodeBox.sendKeys(postcode);
		countryBox.sendKeys(country);
		mobileBox.sendKeys(phoneNo);
		aliasBox.sendKeys(aliasAdrs);
		submitAccountBtn.click();
		return new HomePage();
	}


	
	
	
	
}
