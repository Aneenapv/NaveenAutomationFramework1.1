package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.MyAccountInformationPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class MyAccountInformationPageTest extends TestBase {
	
	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	MyAccountInformationPage editAccountPage;

	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}
   
	@Test
	public void loginAndValidateMyAccountInformation()
	{
		MyAccountPage myAccountPage =loginPage.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText,"Not matching with My Account text");
		
		MyAccountInformationPage editAccountPage =  myAccountPage.clickOnEditAccount();
		editAccountPage.MyAccountInformation();
		String editAccountAlertText =  myAccountPage.getEditAccountSuccessAlert();
		Assert.assertEquals("Success: Your account has been successfully updated.",editAccountAlertText ,"Not matching text");
	}
	

	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}

}
