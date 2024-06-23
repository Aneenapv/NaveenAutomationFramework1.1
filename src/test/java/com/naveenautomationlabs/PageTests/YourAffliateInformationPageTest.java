package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.YourAffliateInformationPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class YourAffliateInformationPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	YourAffliateInformationPage yourAffliateInformationPage;
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}
   
	@Test(priority=1)
	public void loginAndValidateAffliateAccount()
	{
		MyAccountPage myAccountPage =loginPage.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText,"Not matching with My Account text");
		
		YourAffliateInformationPage yourAffliateInformationPage = myAccountPage.clickOnAffliateAccount();
		yourAffliateInformationPage.affliateAccount();
		String affliateAccountAlertText =  myAccountPage.getaffliateAccountSuccessAlert();
		Assert.assertEquals("Success: Your account has been successfully updated.",affliateAccountAlertText ,"Not matching text");
	}
	
	

	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
}
