package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class ChangePasswordPageTest extends TestBase {

	
	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	ChangePasswordPage changePasswordPage;
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}
   
	@Test
	public void loginAndAddressBookValidate()
	{
		MyAccountPage myAccountPage =loginPage.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText,"Not matching with My Account text");
		
		ChangePasswordPage changePasswordPage = myAccountPage.clickOnPassword();
		changePasswordPage.changePassword();
		String changePasswordAlertText = myAccountPage.getChangePasswordAlert();
		Assert.assertEquals("Success: Your password has been successfully updated.", changePasswordAlertText,
				"Not matching text");
	}
	

	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
}
