package com.autoprac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.qa.base.TestBase;

import io.qameta.allure.Step;

public class SignInPage extends TestBase{
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailBox;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement passwordBox;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitBtn;
	
	@FindBy(linkText= "Forgot your password?")
	WebElement forgotPasswdLink;
	
	@FindBy(id = "email_create")
	WebElement createEmailBox;
	
	@FindBy(id = "SubmitCreate")
	WebElement submitEmailBox;
	
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	@Step("getting SignInPage title step....")
	public String validateTitleOfSignInPage() {
		return driver.getTitle();
	}
	@Step("registering with email: {0} step....")
	public RegistrationPage createAccount(String registrationEmail) {
		createEmailBox.sendKeys(registrationEmail);
		submitEmailBox.click();
		return new RegistrationPage();
	}
	@Step("signin with email: {0} and password: {1} step....")
	public void SignIn(String email, String passwd) {
		emailBox.sendKeys(email);
		passwordBox.sendKeys(passwd);
		submitBtn.click();
	}
	@Step("verifying forgot password link on SignInPage step.....")
	public forgotPasswordPage clickOnForgotPasswdLink() {
		forgotPasswdLink.click();
		return new forgotPasswordPage();
	}
	
	
}


