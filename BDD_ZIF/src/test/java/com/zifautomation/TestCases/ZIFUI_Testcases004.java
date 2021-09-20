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

public class ZIFUI_Testcases004 extends Base {

	// PreRequsite
	PropertiesFileReader obj= new PropertiesFileReader();
	Properties properties = null;



	@Test(enabled = true)
	public void ZIFUIPredictionsDevice_Configuration_FieldValidation() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Settings Page Device Configuration field validation");
		test.createNode("ZIF UI Prediction Settings Page Device Configuration field validation");

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
						 test.log(Status.PASS,"Successfully clicked on Device Configuration in Prediction Settings Page");
					}catch (Exception e) {
						test.log(Status.FAIL, "Not clicked on Device Configuration");
					}
					
					
					 //Verify all fields in Prediction Settings Device configuration page
					try {
						 new ZIFAIPrediction_DeviceConfigPage(driver).selectdevicecheck();
						 new ZIFAIPrediction_DeviceConfigPage(driver).Counterconfig_CommonFieldValidation();
						 
						 test.log(Status.PASS,"Successfully Verified all the fields in the Device configuration page ");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying the fields in Device configuration page");
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

	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------------------

	@Test(enabled = true,priority = 1)
	public void ZIFUIPredictions_Counter_ConfigurationFieldValidation() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Settings Page Counter Configuration Field Validation");
		test.createNode("ZIF UI Prediction Settings Page Counter Configuration Field Validation");

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
					
					
					 //Verify all fields in Prediction Settings Counter configuration 
					try {
						 new ZIFAIPrediction_DeviceConfigPage(driver).Counterconfig_FieldValidation();
						 
						 test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying the fields in Counter configuration");
					}
					
					 //Verify all fields in Prediction Settings Counter configuration-CPU
					try {
						 new ZIFAIPrediction_DeviceConfigPage(driver).CounterconfigCPU_FieldValidation();
						 
						 test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration-CPU");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying the fields in Counter configuration-CPU");
					}
					
					//Verify all fields in Prediction Settings Counter configuration-DISK
					try {
						 new ZIFAIPrediction_DeviceConfigPage(driver).CounterconfigDisk_FieldValidation();
						 
						 test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration-DISK");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying the fields in Counter configuration-DISK");
					}
					
					
					//Verify all fields in Prediction Settings Counter configuration-Memory
					try {
						 new ZIFAIPrediction_DeviceConfigPage(driver).CounterconfigMemory_FieldValidation();
						 
						 test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration-Memory");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying the fields in Counter configuration-Memory");
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
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------

	@Test(enabled = true,priority = 2)
	public void ZIFUIPredictions_Counter_Configuration_SearchAndSave() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Settings Page Counter Configuration Search and Save Functionality");
		test.createNode("ZIF UI Prediction Settings Page Counter Configuration Search and Save Functionality");

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
					
					
					 //Verify Valid and Invalid search functionality in Counter configuration-CPU
					try {
						String vaildcputext=testdata.getTestDataInMap().get("VaildCPUSearch");
						 new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterCPU();
						 new ZIFAIPrediction_DeviceConfigPage(driver).Entersearchtext(vaildcputext);
						 
						 test.log(Status.PASS,"Successfully Verified Valid Search Functionality in Counter configuration-CPU");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying Valid Search Functionality in Counter configuration-CPU");
					}
					
					 
					try {
						String invaildcputext=testdata.getTestDataInMap().get("InvaildCPUSearch");
						 
						 new ZIFAIPrediction_DeviceConfigPage(driver).Entersearchtext(invaildcputext);
						 
						 test.log(Status.PASS,"Successfully Verified InValid Search Functionality in Counter configuration-CPU");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying InValid Search Functionality in Counter configuration-CPU");
					}
					
					//Verify Valid and Invalid search functionality in Counter configuration-Disk
					try {
						String vaildcputext1=testdata.getTestDataInMap().get("VaildDISKSearch");
						 new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterDisk();
						 new ZIFAIPrediction_DeviceConfigPage(driver).Entersearchtext(vaildcputext1);
						 
						 test.log(Status.PASS,"Successfully Verified Valid Search Functionality in Counter configuration-DISK");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying Valid Search Functionality in Counter configuration-DISK");
					}
					
					 
					try {
						String invaildcputext1=testdata.getTestDataInMap().get("InvaildDISKSearch");
						 
						 new ZIFAIPrediction_DeviceConfigPage(driver).Entersearchtext(invaildcputext1);
						 
						 test.log(Status.PASS,"Successfully Verified InValid Search Functionality in Counter configuration-DISK");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying InValid Search Functionality in Counter configuration-DISK");
					}
					
					//Verify Valid and Invalid search functionality in Counter configuration-Memory
					try {
						String vaildcputext2=testdata.getTestDataInMap().get("VaildMemorySearch");
						 new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterMemory();
						 new ZIFAIPrediction_DeviceConfigPage(driver).Entersearchtext(vaildcputext2);
						 
						 test.log(Status.PASS,"Successfully Verified Valid Search Functionality in Counter configuration-Memory");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying Valid Search Functionality in Counter configuration-Memory");
					}
					
					 
					try {
						String invaildcputext2=testdata.getTestDataInMap().get("InvaildMemorySearch");
						 
						 new ZIFAIPrediction_DeviceConfigPage(driver).Entersearchtext(invaildcputext2);
						 
						 test.log(Status.PASS,"Successfully Verified InValid Search Functionality in Counter configuration-Memory");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying InValid Search Functionality in Counter configuration-Memory");
					}
				
					
					
					//Click and Save button and Verify the error message In Counter configuration-Memory
					try {
						
						 
						 new ZIFAIPrediction_DeviceConfigPage(driver).ClearSearchbox();
						 new ZIFAIPrediction_DeviceConfigPage(driver).SaveErrorMessage();
						 
						 test.log(Status.PASS,"Successfully Verified 'Please select atleast one device' Error message in Counter configuration-Memory");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying 'Please select atleast one device' Error message in Counter configuration-Memory");
					}
				
					//Click and Save button and Verify the error message In Counter configuration-Disk
					try {
						
						 
						 new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterDisk();
						 new ZIFAIPrediction_DeviceConfigPage(driver).SaveErrorMessage();
						 
						 test.log(Status.PASS,"Successfully Verified 'Please select atleast one device' Error message in Counter configuration-Disk");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying 'Please select atleast one device' Error message in Counter configuration-Disk");
					}
					
					//Click and Save button and Verify the error message In Counter configuration-CPU
					try {
						
						 
						 new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterCPU();
						 new ZIFAIPrediction_DeviceConfigPage(driver).SaveErrorMessage();
						 
						 test.log(Status.PASS,"Successfully Verified 'Please select atleast one device' Error message in Counter configuration-CPU");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying 'Please select atleast one device' Error message in Counter configuration-CPU");
					}
					
					
					//select any device and click on save to verify the Data Saved Successfully message
					
					
					//Click and Save button and Verify the success message In Counter configuration-CPU
					try {
						
						 new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
						 new ZIFAIPrediction_DeviceConfigPage(driver).SaveSuccessMessage();
						 
						 test.log(Status.PASS,"Successfully Verified 'Data Saved Successfully' message in Counter configuration-CPU");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying 'Data Saved Successfully' message in Counter configuration-CPU");
					}
					
					
					//Click and Save button and Verify the success message In Counter configuration-Disk
					try {
	 
						 new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterDisk();
						 new ZIFAIPrediction_DeviceConfigPage(driver).SaveErrorMessage();
						 
						 test.log(Status.PASS,"Successfully Verified 'Data Saved Successfully' message in Counter configuration-Disk");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying 'Data Saved Successfully' message in Counter configuration-Disk");
					}
					
					//Click and Save button and Verify the success message In Counter configuration-Memory
					try {
	 
						 new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterMemory();
						 new ZIFAIPrediction_DeviceConfigPage(driver).SaveErrorMessage();
						 
						 test.log(Status.PASS,"Successfully Verified 'Data Saved Successfully' message in Counter configuration-Memory");
						 Thread.sleep(2000);
					}catch (Exception e) {
						test.log(Status.FAIL, "Failed verifying 'Data Saved Successfully' message in Counter configuration-Memory");
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
