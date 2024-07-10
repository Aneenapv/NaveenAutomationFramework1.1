package com.naveenautomationlabs.TestBase;

import java.time.Duration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.Browsers.Browsers;
import com.naveenautomationlabs.listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	//private final String browser = "chrome";
	
	// introduced enum.. browsers is class name for enums. 
	//enums are constant so that we can call by classname.enumvalue
	
	private Browsers BROWSER;   //= Browsers.CHROME;
	private final String URL="https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	
	public static Logger logger;
	public WebdriverEvents events;
	@SuppressWarnings("deprecation")
	public EventFiringWebDriver eDriver;
	
	
	public void initialise()
	{
		setBrowser();
		initialiseWebdriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		
	}
	
	@BeforeClass
	public void setUpLogger()
	{
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	private void setBrowser(){
		
		String browser = System.getProperty("browser","CHROME").toUpperCase();
		try
		{
		  BROWSER = Browsers.valueOf(browser);
		}
		catch(IllegalArgumentException e)
		{
			throw new InvalidArgumentException("Enter correct browser name");
		}
	}
	
	private void setBrowserOptions(Object options)
	{
		if(System.getProperty("incognito","false").equals("true"))
		{
			if(options instanceof ChromeOptions)
			{
				((ChromeOptions)options).addArguments("--incognito");
			}
			else if(options instanceof FirefoxOptions)
			{
				((FirefoxOptions)options).addArguments("-private");
			}
			else if(options instanceof EdgeOptions)
			{
				((EdgeOptions)options).addArguments("inprivate");
			}
		}
	}
	
	
	private void initialiseWebdriver() {
		
		//switch(Browsers.valueOf(browser))
		switch(BROWSER)
		//switch(browser.getBrowserNameWithCompanies())
		{
		//case "chrome" : 
		case CHROME:
		//case "Google Chrome":
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions ChromeOptions = new ChromeOptions();
			setBrowserOptions(ChromeOptions);
			driver = new ChromeDriver(ChromeOptions);
			break;
			
		//case "firefox" : 
		case FIREFOX:
		//case "Mozilla Firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions FirefoxOptions = new FirefoxOptions();
			setBrowserOptions(FirefoxOptions);
			driver = new FirefoxDriver(FirefoxOptions);
			break;
			
		//case "edge" : 
		case EDGE:
		//case "Microsoft Edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions EdgeOptions = new EdgeOptions();
			setBrowserOptions(EdgeOptions);
			driver = new EdgeDriver(EdgeOptions);
			break;
			
			default: 
				throw new InvalidArgumentException("enter correct browser name");
		}
		
		// initializing event firing web driver and web driver event
		eDriver = new EventFiringWebDriver(driver);
		
		events = new WebdriverEvents();
		
		//register the event
		eDriver.register(events);
		driver = eDriver;
		
	}
	
	
	
	public void selectDropdown(WebElement element,String value,String text)
	{
	Select select = new Select(element);
	try
	{
		select.selectByValue(value);
	}
	catch(Exception e)
	{
		select.selectByVisibleText(text);
	}
	
	}
	
	public void fillTransferForm(WebElement element,String text)
	{
		element.clear();
		element.sendKeys(text);
	}


public void tearDown()
{
	driver.quit();
}
	
	

}
