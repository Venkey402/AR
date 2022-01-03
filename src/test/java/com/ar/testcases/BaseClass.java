package com.ar.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
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
	@Parameters("HeadlessFlag")
	public void setUp(String HeadlessFlag) throws IOException
	{
		logger = Logger.getLogger("Advanced Reporting");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		logger.info("Set the chrome driver location...");
		rc = new ReadConfig();
		baseUrl = rc.getBaseUrl();
		logger.info("Read the base url "+baseUrl+" from the config.properties file...");
		username = rc.getUsername();
		logger.info("Read the username "+username+" from the config.properties file...");
		password = rc.getPassword();		
		logger.info("Read the password "+password+" from the config.properties file...");
		
		if(HeadlessFlag.equalsIgnoreCase("Yes"))
		{		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("Headless");		
			driver = new ChromeDriver(options); 
		}
		else
		{
			driver = new ChromeDriver();
		}
		logger.info("Initiated the chrome driver location...");
		driver.get(baseUrl);
		logger.info("Navigated to "+baseUrl+"...");
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
	@DataProvider(name = "ReadExcel")
	public Object[][] readfromExcel() throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\ar\\testdata\\ValidateAR.xlsx");		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s =wb.getSheet("Sheet1");
		int rownum = s.getLastRowNum();
		int Columnnum = s.getRow(0).getLastCellNum();
		Object[][] testdata = new Object[rownum][Columnnum] ;
		for(int i=0;i<rownum;i++)
			for(int j=0;j<Columnnum;j++)
			{			
				testdata[i][j]=s.getRow(i).getCell(j).getStringCellValue();
			}
		return testdata;
	}
	
}
