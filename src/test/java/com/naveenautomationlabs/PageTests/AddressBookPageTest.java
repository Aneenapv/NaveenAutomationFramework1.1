package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class AddressBookPageTest extends TestBase {
	
	
		
		AccountLoginPage loginPage;
		MyAccountPage myAccountPage;
		AddressBookPage addressBookPage;
		
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
			
			AddressBookPage addressBookPage = myAccountPage.clickOnAddressBook();
			addressBookPage.formElementsOnAddressBook();
			String addressBookAlertSuccessBannerText = addressBookPage.addressBookSuccessAlertBanner();
			Assert.assertEquals("Your address has been successfully added", addressBookAlertSuccessBannerText,"Not matching text on address book page");	
		}
		

		@AfterMethod
		public void closeBrowser()
		{
			tearDown();
		}

}
