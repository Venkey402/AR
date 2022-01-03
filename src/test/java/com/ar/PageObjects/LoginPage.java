package com.ar.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.ar.testcases.BaseClass;

public class LoginPage extends BaseClass{
	
	WebDriver driver;
	//Logger logger;
	
	// Constrcutor..
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Objects 
	
	@FindBy(how=How.ID,using = "BodyContent_MainContent_MainContentPlaceHolder_UserName")
	WebElement txtUsername;
	@FindBy(how=How.ID,using = "BodyContent_MainContent_MainContentPlaceHolder_Password")
	WebElement txtPassword;
	@FindBy(how=How.ID,using = "BodyContent_MainContent_MainContentPlaceHolder_LoginButton")
	WebElement btnSignIn;
	
	// Action methods 
	
	public void validateLoginPageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "Sign In");
		logger.info("Login Page title is matched...");
	}
	
	public void setUsername(String username)
	{		
		txtUsername.clear();
		logger.info("Cleared the text in username textbox...");
		txtUsername.sendKeys(username);
		logger.info("'"+username+"'"+" is typed in the username textbox...");
	}
	public void setPassword(String password)
	{
		txtPassword.clear();
		logger.info("Cleared the text in password textbox...");
		txtPassword.sendKeys(password);
		logger.info("'"+password+"'"+" is typed in the password textbox...");
	}
	public HomePage clickLogin()
	{
		btnSignIn.click();	
		logger.info("SignIn button clicked...");
		return new HomePage(driver);
	}
	
}
