package com.ar.PageObjects;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ar.testcases.BaseClass;

public class AllUsersPage  extends BaseClass{
	
	WebDriver driver;
	AllUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger = Logger.getLogger("Advanced Reporting");
		PropertyConfigurator.configure("log4j.properties");
	}

	// PageObjects
	@FindBy(how=How.XPATH,using="//button[text()='Create User']")
	public WebElement btnCreateUser;
	@FindBy(how=How.ID,using="user_1")
	WebElement txtLoginName;
	@FindBy(how=How.ID,using="user_2")
	WebElement txtPassword;	
	@FindBy(how=How.ID,using="user_6")
	WebElement cmbUserSecurityRole;
	@FindBy(how=How.ID,using="user_10")
	WebElement cmbUserRole;
	@FindBy(how=How.ID,using="user_14")
	WebElement txtFirstName;
	@FindBy(how=How.ID,using="user_17")
	WebElement cmdUserLanguage;	
	@FindBy(how=How.ID,using="user_18")
	WebElement txtLastName;
	@FindBy(how=How.ID,using="user_19")
	WebElement cmbTimeZone;
	@FindBy(how=How.ID,using="user_21")
	WebElement txtEmail;	
	@FindBy(how=How.ID,using="user_38")
	WebElement chkMobileAccess;	
	@FindBy(how=How.ID,using="CBaddToAudience")
	WebElement chkAddToAudience;
	@FindBy(how=How.NAME,using="submit")
	WebElement btnSave;
	//Action methods
	
	public void clickCreateUser() throws InterruptedException 
	{
		Thread.sleep(5000);
		btnCreateUser.click();
		logger.info("Clicked on the create user button...");
	}
	public void setLoginName(String loginName) 
	{
		txtLoginName.clear();
		logger.info("text got cleared in login name textbox...");
		txtLoginName.sendKeys(loginName);
		logger.info("login name is typed in the login name textbox...");
	}
	public void setPassword(String password) 
	{
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	public void setUserSecurityProfile(String UserSecurityProfile) 
	{
		Select select = new Select(cmbUserSecurityRole);		
		select.selectByValue(UserSecurityProfile);
	}
	public void setUserRole(String userRole) 
	{
		Select select = new Select(cmbUserRole);		
		select.selectByValue(userRole);
	}
	public void setFirstName(String firstname) 
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(firstname);
	}
	public void setUserLanguage(String userLanguage) 
	{
		Select select = new Select(cmdUserLanguage);		
		select.selectByValue(userLanguage);
	}	
	public void setLastName(String lastName) 
	{
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}
	public void setTimeZone(String timezone) 
	{
		Select select = new Select(cmbTimeZone);		
		select.selectByValue(timezone);
	}
	public void setEmail(String email) 
	{
		txtLastName.clear();
		txtLastName.sendKeys(email);
	}
	public void checkMobileAccessChecbox() 
	{
		if(!chkMobileAccess.isSelected())
		{
			chkMobileAccess.click();
		}		
	}
	public void checkAddToAudienceChecbox() 
	{
		if(!chkAddToAudience.isSelected())
		{
			chkAddToAudience.click();
		}		
	}
	public void clickSave() 
	{
		btnSave.click();
	}
	
	
	
	
	
	
	
	
	
	
}
