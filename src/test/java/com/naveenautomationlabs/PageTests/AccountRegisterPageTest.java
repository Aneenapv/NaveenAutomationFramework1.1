package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AccountRegisterPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class AccountRegisterPageTest extends TestBase {
	

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	AddressBookPage addressBookPage;
	AccountRegisterPage accountRegisterPage;
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}
   
	@Test
	public void validateRegisterFormDetails()
	{
		accountRegisterPage = loginPage.newCustomerContinueButton();
		String getRegisterAccountPageHeading = accountRegisterPage.getRegisterAccountHeading();
		Assert.assertEquals("Register Account",getRegisterAccountPageHeading,"Not match with Heading");
		accountRegisterPage.RegisterFormDetails();	
	}
	
	

	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}

}
	


