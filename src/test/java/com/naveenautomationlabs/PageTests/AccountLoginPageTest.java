package com.naveenautomationlabs.PageTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AccountRegisterPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.Pages.MyAccountInformationPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.Pages.YourAffliateInformationPage;
import com.naveenautomationlabs.TestBase.TestBase;
import com.naveenautomationlabs.Utils.ExcelUtils;

public class AccountLoginPageTest extends TestBase{
	
	
	AccountLoginPage loginPage;
	ForgotYourPasswordPage pwdPage;
	MyAccountPage myAccountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	AddressBookPage addressBookPage;
	ChangePasswordPage changePasswordPage;
	MyAccountInformationPage editAccountPage;
	YourAffliateInformationPage yourAffliateInformationPage;
	AccountRegisterPage accountRegisterPage;
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}
	
	
	//@Test(dataProvider = "Book1")
	public void validateLoginWithValidCredentials(String email, String pwd) {
		myAccountPage = loginPage.loginToMyAccount(email, pwd);
		//String getMyAccountText = myAccountPage.getMyAccountText();
		//Assert.assertEquals("My Account", getMyAccountText);
	}
	
	
	//@DataProvider(name ="Book1")
	private String[][] loginInfoProvider() throws IOException {
		String filePath = "C:\\Users\\johng\\OneDrive\\Desktop\\Book1.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
	
	
	@Test
	public void validateLoginWithValidCredentials()
	{
		MyAccountPage myAccountPage = loginPage.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText,"Not matching with My Account text");
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
	
	@Test
	public void validateNewCustomerRegisterAccount()
	{
		accountRegisterPage = loginPage.newCustomerContinueButton();
		String getRegisterAccountPageHeading = accountRegisterPage.getRegisterAccountHeading();
		Assert.assertEquals("Register Account",getRegisterAccountPageHeading,"Not match with Heading");
	}
	
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
	

}
