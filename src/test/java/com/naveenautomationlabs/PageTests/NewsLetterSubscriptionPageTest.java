package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class NewsLetterSubscriptionPageTest extends TestBase {
	
	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}
   
	@Test
	public void loginAndNewsLetterSubscriptionValidate()
	{
		MyAccountPage myAccountPage =loginPage.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText,"Not matching with My Account text");
		
		NewsletterSubscriptionPage newsletterSubscriptionPage= myAccountPage.newsLetter();
		newsletterSubscriptionPage.newsLetterSubscription();
		String newsLetterAlertBannerText = newsletterSubscriptionPage.getNewsLetterAlertBanner();
		Assert.assertEquals("Success: Your newsletter subscription has been successfully updated!", newsLetterAlertBannerText, "Not matching news letter yes alert banner message");
		
	}
	

	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
}


