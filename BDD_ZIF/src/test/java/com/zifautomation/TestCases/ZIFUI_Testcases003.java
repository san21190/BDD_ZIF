package com.zifautomation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;

import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAIPredictionPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

public class ZIFUI_Testcases003 extends Base {

	// PreRequsite
	PropertiesFileReader obj= new PropertiesFileReader();
	Properties properties = null;



	@Test(enabled = true)
	public void ZIFUIPredictionsPageFieldValidation() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Page field validation");
		test.createNode("ZIF UI Prediction Page field validation");

		//Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Login failed");

		}

		// Verify User is in ZIF UI Home Page

		try {
			String ExpectedTitle = "ZIF";
			String ActualTitle = driver.getTitle();
			assertEquals(ExpectedTitle, ActualTitle);
			test.log(Status.PASS,"Successfully logged in and User is in ZIF UI Home Page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");

		}
		
		
		// Verify all fields in ZIF UI Prediction page
		try {
			
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).verifyAnalyzeshovermenufields();
			new ZIFAIDashboardPage(driver).clickPrediction();
			new ZIFAIPredictionPage(driver).CheckallfieldsandImages();
			new ZIFAIPredictionPage(driver).checkallpredictionfields();
			test.log(Status.PASS,"Successfully verified all fields in Prediction page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction page fields");

		}
		
		// Verify all fields in ZIF UI Prediction Swim lane
				try {
					
					
					new ZIFAIPredictionPage(driver).verifySwinlaneFields();
					test.log(Status.PASS,"Successfully verified all fields Prediction swim lane");
					Thread.sleep(2000);
				} catch (AssertionError | Exception e) {
					e.printStackTrace();
					test.log(Status.FAIL, "Failed in verifying prediction swim lane fields");

				}
		
		//Logout of Application
		try {
			new ZIFAIDashboardPage(driver).LogoutClick();
			test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
		}catch (Exception e) {
			test.log(Status.FAIL, "Dashboard page Logout failed");
		}

	}
	
	
	

	@Test(enabled = true)
	public void ZIFUIPredictionSettings_oneAgentDownload() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Settings Page field validation and One Agent Download");
		test.createNode("ZIF UI Prediction Settings Page field validation and One Agent Download");

		//Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Login failed");

		}

		// Verify User is in ZIF UI Home Page

		try {
			String ExpectedTitle = "ZIF";
			String ActualTitle = driver.getTitle();
			assertEquals(ExpectedTitle, ActualTitle);
			test.log(Status.PASS,"Successfully logged in and User is in ZIF UI Home Page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");

		}
		
		
		// Verify all fields in ZIF UI dashboard page
		try {
			
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickPrediction();
			boolean adaptorstatus = new ZIFAIPredictionPage(driver).adaptorstatuscheck();
			if(adaptorstatus==true)
		 {
				 test.log(Status.PASS,"Successfully verified the adaptor status is UP");
				 
				 //Click  on Prediction Settings Icon
					try {
						 new ZIFAIPredictionPage(driver).PredictionSettingsClick();
						 test.log(Status.PASS,"Successfully Clicked on Prediction Settings Icon");
					}catch (Exception e) {
						test.log(Status.FAIL, "Not clicked on Prediction Settings Icon");
					}
				
				
				
					 //Verify all fields in Prediction Settings page
					try {
						 new ZIFAIPredictionPage(driver).PredictionSettingsfieldvalidation();
						 test.log(Status.PASS,"Successfully Verified all the fields in Prediction Settings Page");
					}catch (Exception e) {
						test.log(Status.FAIL, "Prediction Settings Page field validation failed");
					}
					
					
					 //Verify all fields in Prediction Settings page
					try {
						 new ZIFAIPredictionPage(driver).downloadOneAgent();
						 
						 test.log(Status.PASS,"Successfully downloaded one agent and verified");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "One Agent download failed");
					}
					
					
					//close Settings
					
					try {
						 new ZIFAIPredictionPage(driver).closePredictionsettings();
						 
						 test.log(Status.PASS,"Successfully Closed the Prediction settings");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Closing Prediction settings failed");
					}
					
					
					//Logout of Application
					try {
						new ZIFAIDashboardPage(driver).LogoutClick();
						test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
					}catch (Exception e) {
						test.log(Status.FAIL, "Dashboard page Logout failed");
					}
			 }else {
				
			}
			
			
			
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed or Adaptor status is down");

		}
		
		

	}


}
