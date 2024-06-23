package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class MyAccountPage extends TestBase{
	
	//initialize the page elements using constructor
	public MyAccountPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="#content h2:first-of-type")
	WebElement myAccountText;
	public String getMyAccountText()
	{
		return myAccountText.getText().trim();
	}
	
	
	@FindBy(css="#column-right div a:last-of-type")
	WebElement logout;
	public void logout()
	{
		logout.click();
	}
	
	@FindBy(css="#column-right div a:nth-of-type(12)")
	WebElement newsLetter;
	
	public NewsletterSubscriptionPage newsLetter()
	{
		newsLetter.click();
		return new NewsletterSubscriptionPage();
	}
	

	@FindBy(css="#column-right div a:nth-of-type(4)")
	WebElement clickOnAddressBook;
	
	public AddressBookPage clickOnAddressBook()
	{
		 clickOnAddressBook.click();
		 return new AddressBookPage();
	}
	
	
	@FindBy(css="#column-right div a:nth-of-type(3)")
	WebElement clickOnPassword;
	
	public ChangePasswordPage clickOnPassword()
	{
		clickOnPassword.click();
		return new ChangePasswordPage();
	}
	
	@FindBy(css="div.alert.alert-success.alert-dismissible")
	WebElement changePasswordAlert;
	
	public String getChangePasswordAlert()
	{
	return changePasswordAlert.getText().trim();
	}
	
	@FindBy(css="#column-right div a:nth-of-type(2)")
	WebElement clickOnEditAccount;
	
	public MyAccountInformationPage clickOnEditAccount()
	{
		clickOnEditAccount.click();
		return new MyAccountInformationPage();
	}
	
	@FindBy(css="div.alert.alert-success")
	WebElement editAccountSuccess;
	
	public String getEditAccountSuccessAlert()
	{
	return editAccountSuccess.getText().trim();
	}
	
	@FindBy(xpath="//a[text()='Edit your affiliate information']")
	WebElement clickOnAffliateAccount;
	
	public YourAffliateInformationPage  clickOnAffliateAccount()
	{
		 clickOnAffliateAccount.click();
		 return new YourAffliateInformationPage();
	}
	
	@FindBy(css="div.alert")
	WebElement affliateAccountSuccess;
	
	public String getaffliateAccountSuccessAlert()
	{
	return affliateAccountSuccess.getText().trim();
	}
	
	
	
	@FindBy(xpath="//a[text()='Components']")
	WebElement clickOnComponents;
	
	public void  clickOnComponents()
	{
		 clickOnComponents.click();
	}
	
	@FindBy(xpath="//a[text()='Monitors (2)']")
	WebElement clickOnMonitors;
	
	public void clickOnMonitors()
	{
		clickOnMonitors.click();
	}
	
	public MonitorsPage componentsAndMonitor()
	{
		clickOnComponents();
		clickOnMonitors();
		return new MonitorsPage();
	}
	
	@FindBy(css="div.list-group a:nth-of-type(5)")
	WebElement clickOnWishList;
	
	public WishListPage clickOnWishList()
	{
		clickOnWishList.click();
		return new WishListPage();
	}


}
