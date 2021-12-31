package com.ar.PageObjects;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ar.testcases.BaseClass;

public class HomePage extends BaseClass {
	
	WebDriver driver;
	
	HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger = Logger.getLogger("Advanced Reporting");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	// Page Objects
	
	@FindBy(how=How.XPATH,using="//span[text()='Administration']")
	WebElement linkAdministation;
	@FindBy(how=How.XPATH,using="//span[text()='All Users']")
	WebElement linkAllUsers;
	@FindBy(how=How.XPATH,using="//button/span[text()='Self']")
	WebElement linkSelf;
	@FindBy(how=How.XPATH,using="//li/span[text()='Reporting']")
	WebElement linkSelf_Reporting;
	@FindBy(how=How.XPATH,using="//a/span[text()='Advanced Reporting']")
	WebElement linkSelf_Reporting_AdvancedReporting;
	
	
	//Action methods
	
	public AllUsersPage NavigateToAllUsers() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		logger.info("Action class is initiated...");
		linkAdministation.click();
		action.moveToElement(linkAllUsers).click(linkAllUsers).build().perform();		
		logger.info("Navigated to Administration_AllUsers...");
		return new AllUsersPage(driver);
	}
	
	public AdvancedReporting NavigateToAdvancedReporting() throws InterruptedException
	{
		Actions action = new Actions(driver);
		linkSelf.click();
		linkSelf_Reporting.click();
		linkSelf_Reporting_AdvancedReporting.click();
		Thread.sleep(5000);
		//action.moveToElement(linkAdministation).click(linkAllUsers).build().perform();		
		return new AdvancedReporting(driver);
	}

}
