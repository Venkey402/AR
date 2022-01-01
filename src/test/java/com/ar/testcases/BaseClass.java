package com.ar.testcases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public WebDriver driver;
	public static Logger logger;
	@BeforeSuite
	public void setUp()
	{
		logger = Logger.getLogger("Advanced Reporting");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		logger.info("Set the chrome driver location...");
		driver = new ChromeDriver();
		logger.info("Initiated the chrome driver location...");
		driver.get("https://au05sales.sumtotaldevelopment.net/");
		logger.info("Navigated to https://au05sales.sumtotaldevelopment.net/...");
		driver.manage().window().maximize();
		logger.info("Window got maximized...");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logger.info("Implycit wait is set to 30 secs...");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		logger.info("Pageload time out  wait is set to 30 secs...");
	}
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
		logger.info("Driver is quitted...");
	}
	

}
