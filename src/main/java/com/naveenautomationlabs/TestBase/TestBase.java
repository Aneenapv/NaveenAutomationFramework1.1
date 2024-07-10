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
	//enums are constant so that we can call by classnamme.enumvalue
	
	private final Browsers browser = Browsers.CHROME;
	private final String URL="https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	
	public static Logger logger;
	public WebdriverEvents events;
	@SuppressWarnings("deprecation")
	public EventFiringWebDriver eDriver;
	
	
	public void initialise()
	{
		initialiseWebdriver();
		driver.manage().window().maximize();
	   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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


	private void initialiseWebdriver() {
		// open browser from maven
		String browser = System.getProperty("browser", Browsers.CHROME.toString());
		
		//chrome incognito browser
		 // Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Create an instance of ChromeOptions
        ChromeOptions optionsChrome = new ChromeOptions();
        // Add the incognito argument
        optionsChrome.addArguments("--incognito");
        // Initialize the ChromeDriver with the options
        //WebDriver driver = new ChromeDriver(options);
		
        
        //firefox incognito browser
        // Set the path to the geckodriver executable
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        // Create an instance of FirefoxOptions
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        // Add the private argument
        optionsFirefox.addArguments("-private");
        // Initialize the FirefoxDriver with the options
        //WebDriver driver = new FirefoxDriver(options);
        
        
        //edge incognito browser
       // Set the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "path/to/msedgedriver");
        // Create an instance of EdgeOptions
        EdgeOptions optionsEdge = new EdgeOptions();
        // Add the InPrivate argument
        optionsEdge.addArguments("inprivate");
        // Initialize the EdgeDriver with the options
        //WebDriver driver = new EdgeDriver(options);
		
        
        
		switch(Browsers.valueOf(browser))
		//switch(browser)
		//switch(browser.getBrowserNameWithCompanies())
		{
		//case "chrome" : 
		case CHROME:
		//case "Google Chrome":
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsChrome);
			break;
			
		//case "firefox" : 
		case FIREFOX:
		//case "Mozilla Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsFirefox);
			break;
			
		//case "edge" : 
		case EDGE:
		//case "Microsoft Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(optionsEdge);
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
