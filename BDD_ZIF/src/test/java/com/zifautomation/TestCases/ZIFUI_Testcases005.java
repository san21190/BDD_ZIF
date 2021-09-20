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
import com.zifautomation.Pages.ZIFAIPrediction_DeviceConfigPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import bsh.Console;

public class ZIFUI_Testcases005 extends Base {

	// PreRequsite
	PropertiesFileReader obj= new PropertiesFileReader();
	Properties properties = null;



	@Test(enabled = true)
	public void ZIFUIPredictions_Set_Polling_Interval_FieldValidation() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Settings Page Set Polling Interval Field Validation");
		test.createNode("ZIF UI Prediction Settings Page Set Polling Interval Field Validation");

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
				
				
				
					 //Select Device Configuration in Prediction Settings page
					try {
						 new ZIFAIPredictionPage(driver).Device_Configuration_Tab();
					}catch (Exception e) {
						test.log(Status.FAIL, "Not clicked on Device Configuration");
					}
					
					
					 //Click on Set Polling Interval and Verify all the fields under Set Polling Interval
					try {
						
						new ZIFAIPrediction_DeviceConfigPage(driver).clickSetpollinginterval();
						new ZIFAIPrediction_DeviceConfigPage(driver).setpollingIntervalFields();
						
						 test.log(Status.PASS,"Successfully Verified all fields in Set Polling Interval");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying fields in Set Polling Interval");
					}
					
					 //Select any device and select timings for polling
					try {
						
						 
						 new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
						 new ZIFAIPrediction_DeviceConfigPage(driver).selectpollingInterval();
						 new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
						 test.log(Status.PASS,"Successfully the polling intervals have been set for the selected devices and Verified");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying polling interval for the devices");
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
				 test.log(Status.FAIL, "Adaptor Status is Down");
					//Logout of Application
						try {
							new ZIFAIDashboardPage(driver).LogoutClick();
							test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
						}catch (Exception e) {
							test.log(Status.FAIL, "Dashboard page Logout failed");
						}
			}
			
			
			
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction page fields");

		}
		
		

	}
//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------


	@Test(enabled = true)
	public void ZIFUIPredictions_Threshold_Config() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Settings Page Threshold Configurtion verification");
		test.createNode("ZIF UI Prediction Settings Page hreshold Configurtion verification");

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
				
				
				
					 //Select Device Configuration in Prediction Settings page
					try {
						 new ZIFAIPredictionPage(driver).Device_Configuration_Tab();
					}catch (Exception e) {
						test.log(Status.FAIL, "Not clicked on Device Configuration");
					}
					
					
					 //Click on Set Polling Interval and Verify all the fields under Threshold configuration
					try {
						
						new ZIFAIPrediction_DeviceConfigPage(driver).clickThresholdconfig();
						new ZIFAIPrediction_DeviceConfigPage(driver).thresholdconfigFields();
						
						 test.log(Status.PASS,"Successfully Verified all fields in Threshold configuration");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying fields in Threshold configuration");
					}
					
					 //Select any device and select none for Threshold config
					try {
						
						new ZIFAIPrediction_DeviceConfigPage(driver).uncheckThresholdcheckboxes(); 
						 new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
						 new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
						 test.log(Status.PASS,"Successfully the threshold have been set to none for the selected devices and Verified");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed selecting devices");
					}
					
					//Again select the same device and select all the threshold options and save
					try {
						
						new ZIFAIPrediction_DeviceConfigPage(driver).uncheckThresholdcheckboxes(); 
						 new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
						 new ZIFAIPrediction_DeviceConfigPage(driver).ThresholdcheckboxesClick();
						 new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
						 test.log(Status.PASS,"Successfully the threshold have been set for the selected devices and Verified");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed selecting devices and Threshold limit");
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
				 test.log(Status.FAIL, "Adaptor Status is Down");
					//Logout of Application
						try {
							new ZIFAIDashboardPage(driver).LogoutClick();
							test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
						}catch (Exception e) {
							test.log(Status.FAIL, "Dashboard page Logout failed");
						}
			}
			
			
			
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction page fields");

		}
		
		

	}


}
