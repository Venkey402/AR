package com.ar.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.ar.PageObjects.HomePage;
import com.ar.PageObjects.LoginPage;
import com.ar.utilities.ReadConfig;

public class BaseClass {
	
	public WebDriver driver;
	public static Logger logger;
	LoginPage lp;
	HomePage hp ;
	ReadConfig rc;
	String baseUrl;
	String username;
	String password;
	
	@BeforeSuite
	@Parameters({"HeadlessFlag","Browser"})
	public void setUp(String HeadlessFlag,String Browser) throws IOException
	{
		logger = Logger.getLogger("Advanced Reporting");
		PropertyConfigurator.configure("log4j.properties");
		rc = new ReadConfig();
		baseUrl = rc.getBaseUrl();
		logger.info("Read the base url '"+baseUrl+"' from the config.properties file...");
		username = rc.getUsername();
		logger.info("Read the username '"+username+"' from the config.properties file...");
		password = rc.getPassword();		
		logger.info("Read the password '"+password+"' from the config.properties file...");
		
		if(HeadlessFlag.equalsIgnoreCase("Yes"))
		{	
			if(Browser.equalsIgnoreCase("safari"))
			{
				SafariOptions options = new SafariOptions();
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
				driver = new SafariDriver(options); 
				
			}
			else if(Browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("Headless");		
				driver = new ChromeDriver(options); 
			}
			else if(Browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("Headless");		
				driver = new FirefoxDriver(options); 
			}
			logger.info(Browser+" browser is opened in Headless mode... ");
		}
		else
		{
			if(Browser.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else if(Browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(Browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
				driver = new FirefoxDriver();
			}
			logger.info(Browser+" browser is opened in normal mode... ");
		}
		logger.info("Initiated the chrome driver location...");
		driver.get(baseUrl);
		logger.info("Navigated to '"+baseUrl+"'...");
		driver.manage().window().maximize();
		logger.info("Window got maximized...");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		logger.info("Implycit wait is set to 60 secs...");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		logger.info("Pageload time out  wait is set to 30 secs...");
	}
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
		logger.info("Driver is quitted...");
	}
	
	@BeforeMethod
	public void login()
	{
		lp = new LoginPage(driver);
		driver.get(baseUrl);
		lp.validateLoginPageTitle();		
		lp.setUsername(username);
		lp.setPassword(password);
		hp =lp.clickLogin();
		hp.validateHomePageTitle();		
	}
	
	@AfterMethod
	public void signout()
	{
		lp=hp.SignOut();
	}	
	
}
