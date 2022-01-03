package com.ar.testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ar.PageObjects.AdvancedReporting;
import com.ar.PageObjects.AllUsersPage;
import com.ar.utilities.XLUtils;


public class TC_ValidateAdvancedReporting_001 extends BaseClass{
	AllUsersPage aup;
	AdvancedReporting ar;
	@Test(priority=1,dataProvider="CreateUser_TestData",groups= {"sanity","regression"})
	public void CreateUser(String username,String password,String LMRole,String TMRole,String Language,String Timezone) throws IOException, InterruptedException
	{		
		aup=hp.NavigateToAllUsers();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss");  
	    Date date = new Date();  
	    String DateTime=formatter.format(date); 
	    username=username+"_"+DateTime;
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
	}
	
	@Test(priority=2,groups= {"regression"})
	public void RunningAReportInAR() throws InterruptedException
	{
		ar=hp.NavigateToAdvancedReporting();
	}	
	
	@DataProvider(name = "CreateUser_TestData")
	public Object[][] readfromExcel() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		XLUtils xlutil = new XLUtils();
		String testdatapath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\ar\\testdata\\ValidateAR.xlsx";
		String SheetName = "Sheet1";		
		return xlutil.readfromExcel(testdatapath,SheetName);
	}
}
