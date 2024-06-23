package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class ForgotYourPasswordPageTest extends TestBase{
	
	AccountLoginPage loginPage;
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}

	
	@Test
	public void validateLoginWithValidCredentialsForForgotPassword()
	{
		// why we using like this, its bcoz first we initialize with pagefactory before using any elements on page  
		ForgotYourPasswordPage pwdPage = loginPage.clickForgotPassword();
		// if we forget to initialize the object of page to open, then we get null pointer exception. 
		//to avoid these issues we using page chaining method
		
		//ForgotYourPasswordPage pwdPage = new ForgotYourPasswordPage();
		
		//page chaining - when we click on any element-- link or button on webpage , 
		//it will open up another page , that method will return the object of the page class that about to open
		
		pwdPage.submitForgetPwdRequest("cent@gmail.com");
		String alertBannerText = pwdPage.getAlertBanner().trim();
		Assert.assertEquals("Warning: The E-Mail Address was not found in our records, please try again!",alertBannerText,"Not matching alert banner message");
	}
	
	
	

	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
}
