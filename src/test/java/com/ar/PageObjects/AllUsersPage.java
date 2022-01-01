package com.ar.PageObjects;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ar.testcases.BaseClass;

public class AllUsersPage  extends BaseClass{
	
	WebDriver driver;
	AllUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	@FindBy(how=How.XPATH,using="//span[text()='Return to User List']")
	WebElement btnReturnToUsersList;
	
	
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
		logger.info("text got cleared in password textbox...");
		txtPassword.sendKeys(password);
		logger.info("login name is typed in the password textbox...");
	}
	public void setUserSecurityProfile(String UserSecurityProfile) 
	{
		Select select = new Select(cmbUserSecurityRole);		
		select.selectByVisibleText(UserSecurityProfile);
		logger.info("User security profile selected...");
	}
	public void setUserRole(String userRole) 
	{
		Select select = new Select(cmbUserRole);		
		select.selectByVisibleText(userRole);
		logger.info("User role selected...");
	}
	public void setFirstName(String firstname) 
	{
		txtFirstName.clear();
		logger.info("text got cleared in firstname textbox...");
		txtFirstName.sendKeys(firstname);
		logger.info("firstname is typed in the firstname textbox...");
	}
	public void setUserLanguage(String userLanguage) 
	{
		Select select = new Select(cmdUserLanguage);		
		select.selectByVisibleText(userLanguage);
		logger.info("User language is selected...");
	}	
	public void setLastName(String lastName) 
	{
		txtLastName.clear();
		logger.info("text got cleared in firstname textbox...");
		txtLastName.sendKeys(lastName);
		logger.info("lastname is typed in the lastname textbox...");
	}
	public void setTimeZone(String timezone) 
	{
		Select select = new Select(cmbTimeZone);		
		select.selectByVisibleText(timezone);
		logger.info("timezone is selected...");
	}
	public void setEmail(String email) 
	{
		txtEmail.clear();
		logger.info("text got cleared in email textbox...");
		txtEmail.sendKeys(email);
		logger.info("email is typed in the email textbox...");
	}
	public void checkMobileAccessChecbox() 
	{
		if(!chkMobileAccess.isSelected())
		{
			chkMobileAccess.click();
			logger.info("Mobile access checkbox is checked...");
		}
		else
		{
			logger.info("Mobile access checkbox is already checked hence skipped it...");
		}
	}
	public void checkAddToAudienceChecbox() 
	{
		if(!chkAddToAudience.isSelected())
		{
			chkAddToAudience.click();
			logger.info("Add to Audience checkbox is checked");
		}	
		else
		{
			logger.info("Add to Audience checkbox is already checked hence skipped it...");
		}
	}
	public void clickSave() 
	{
		btnSave.click();
		logger.info("Save button is clicked...");
	}
	public void validateAllUsersPageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "All Users - Administration - SumTotal");
		logger.info("All users Page title is matched...");
	}
	public void returntoAllUsers()
	{
		btnReturnToUsersList.click();
		logger.info("Clicked on the return to users list button...");
	}
	
}
