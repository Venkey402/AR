package com.ar.testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.ar.PageObjects.AdvancedReporting;
import com.ar.PageObjects.AllUsersPage;


public class ValidateAR extends BaseClass{
	AllUsersPage aup;
	AdvancedReporting ar;
	@Test(priority=1,dataProvider="ReadExcel")
	public void TC_CreateUser_001(String username,String password,String LMRole,String TMRole,String Language,String Timezone) throws IOException, InterruptedException
	{		
		aup=hp.NavigateToAllUsers();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss");  
	    Date date = new Date();  
	    String DateTime=formatter.format(date); 
	    username=username+DateTime;
		aup.clickCreateUser();
		aup.validateAllUsersPageTitle();
		aup.setLoginName(username);
		aup.setPassword(password);
		aup.setUserSecurityProfile(LMRole);
		aup.setFirstName(username);
		aup.setLastName(username);
		aup.setUserRole(TMRole);
		aup.setUserLanguage(Language);
		aup.setTimeZone(Timezone);
		aup.setEmail(username+"@test.com");
		aup.checkMobileAccessChecbox();
		aup.checkAddToAudienceChecbox();
		aup.clickSave(); 
		aup.returntoAllUsers();		
		driver.switchTo().defaultContent();	
		
		//readfromExcel(System.getProperty("user.dir")+"//","Sheet1");
	}
	
	@Test(priority=2)
	public void TC_RunningAReportInAR_002() throws InterruptedException
	{
		ar=hp.NavigateToAdvancedReporting();
	}	
	
	
}
