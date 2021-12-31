package com.ar.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ar.PageObjects.AdvancedReporting;
import com.ar.PageObjects.AllUsersPage;
import com.ar.PageObjects.HomePage;
import com.ar.PageObjects.LoginPage;

public class TC_CreateUser_001 extends BaseClass{
	LoginPage lp;
	HomePage hp ;
	AllUsersPage aup;
	AdvancedReporting ar;
	@Test
	public void createUser() throws InterruptedException
	{
		lp = new LoginPage(driver);
		
		lp.setUsername("Admin");
		lp.setPassword("Vervet^Fitch");
		hp =lp.clickLogin();
		aup=hp.NavigateToAllUsers();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		aup.clickCreateUser();
		aup.setLoginName("venkat");
		aup.setPassword("p");
		aup.setUserSecurityProfile("System - Administrator");
		aup.setFirstName("venkat");
		aup.setLastName("venkat");
		aup.setUserRole("Administrator");
		aup.setUserLanguage("English (United States)");
		aup.setTimeZone("(UTC+01:00:00) Europe/Amsterdam");
		aup.setEmail("venkat@venkat.com");
		aup.checkMobileAccessChecbox();
		aup.checkAddToAudienceChecbox();
		aup.clickSave(); 
		
		ar=hp.NavigateToAdvancedReporting();
	}
	
}
