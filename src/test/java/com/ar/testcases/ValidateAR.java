package com.ar.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.ar.PageObjects.AdvancedReporting;
import com.ar.PageObjects.AllUsersPage;


public class ValidateAR extends BaseClass{
	AllUsersPage aup;
	AdvancedReporting ar;
	@Test(priority=1)
	public void TC_CreateUser_001() throws InterruptedException
	{		
		aup=hp.NavigateToAllUsers();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss");  
	    Date date = new Date();  
	    String DateTime=formatter.format(date); 
		aup.clickCreateUser();
		aup.validateAllUsersPageTitle();
		aup.setLoginName("venkat"+DateTime);
		aup.setPassword("p");
		aup.setUserSecurityProfile("System - Administrator");
		aup.setFirstName("venkat"+DateTime);
		aup.setLastName("venkat"+DateTime);
		aup.setUserRole("Administrator");
		aup.setUserLanguage("English (United States)");
		aup.setTimeZone("(UTC+01:00:00) Europe/Amsterdam");
		aup.setEmail("venkat@venkat.com");
		aup.checkMobileAccessChecbox();
		aup.checkAddToAudienceChecbox();
		aup.clickSave(); 
		aup.returntoAllUsers();		
		driver.switchTo().defaultContent();		
	}
	
	@Test(priority=2)
	public void TC_RunningAReportInAR_002() throws InterruptedException
	{
		ar=hp.NavigateToAdvancedReporting();
	}	
}
