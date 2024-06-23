package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.Pages.MyAccountInformationPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.Pages.YourAffliateInformationPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class AccountLoginPageTest extends TestBase{
	
	
	AccountLoginPage loginPage;
	ForgotYourPasswordPage pwdPage;
	MyAccountPage myAccountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	AddressBookPage addressBookPage;
	ChangePasswordPage changePasswordPage;
	MyAccountInformationPage editAccountPage;
	YourAffliateInformationPage yourAffliateInformationPage;
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}
	
	@Test
	public void validateLoginWithValidCredentials()
	{
		MyAccountPage myAccountPage = loginPage.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText,"Not matching with My Account text");
		
		
//		NewsletterSubscriptionPage newsletterSubscriptionPage= myAccountPage.newsLetter();
//		newsletterSubscriptionPage.newsLetterSubscription();
//		String newsLetterAlertBannerText = newsletterSubscriptionPage.getNewsLetterAlertBanner();
//		Assert.assertEquals("Success: Your newsletter subscription has been successfully updated!", newsLetterAlertBannerText, "Not matching news letter yes alert banner message");
//		
//		AddressBookPage addressBookPage = myAccountPage.clickOnAddressBook();
//		addressBookPage.formElementsOnAddressBook();
//		String addressBookAlertSuccessBannerText = addressBookPage.addressBookSuccessAlertBanner();
//		Assert.assertEquals("Your address has been successfully added", addressBookAlertSuccessBannerText,"Not matching text on address book page");
		
		
		//ChangePasswordPage changePasswordPage =  myAccountPage.clickOnPassword();
		//changePasswordPage.changePassword();
		//String changePasswordAlertText =  myAccountPage.getChangePasswordAlert();
		//Assert.assertEquals("Success: Your password has been successfully updated.",changePasswordAlertText ,"Not matching text");
		
//		MyAccountInformationPage editAccountPage =  myAccountPage.clickOnEditAccount();
//		editAccountPage.MyAccountInformation();
//		String editAccountAlertText =  myAccountPage.getEditAccountSuccessAlert();
//		Assert.assertEquals("Success: Your account has been successfully updated.",editAccountAlertText ,"Not matching text");
//		
//		YourAffliateInformationPage yourAffliateInformationPage = myAccountPage.clickOnAffliateAccount();
//		yourAffliateInformationPage.affliateAccount();
//		String affliateAccountAlertText =  myAccountPage.getaffliateAccountSuccessAlert();
//		Assert.assertEquals("Success: Your account has been successfully updated.",affliateAccountAlertText ,"Not matching text");
//		
	
		
		
		myAccountPage.logout();
		
		//Assert.assertEquals("My Account",driver.getTitle());
	}
	
	@Test
	public void validateLoginWithInvalidCredentials()
	{
		loginPage.loginToMyAccount("cent@gmail.com","Password");
		String alertBannerText = loginPage.getTextFromAlertBanner().trim();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", alertBannerText);
	}
	
	@Test
	public void validateForgotYourPasswordFunctionality()
	{
		pwdPage = loginPage.clickForgotPassword();
		loginPage = pwdPage.submitForgetPwdRequest("centanvin68@gmail.com");
		
		//lazy loading concept - when we required the element it will bring right at that moment
				
		//pwdPage = new ForgotYourPasswordPage();
		//pwdPage.submitForgetPwdRequest("centanvin68@gmail.com");
		
		//pwdPage.inputEmail("centanvin68@gmail.com");
		//pwdPage.clickContinueButton();
		
		String alertSuccessBannerText = loginPage.getTextFromAlertSuccessBanner().trim();
		Assert.assertEquals("An email with a confirmation link has been sent your email address.",alertSuccessBannerText);	
		
	}
	
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
	
	

}
