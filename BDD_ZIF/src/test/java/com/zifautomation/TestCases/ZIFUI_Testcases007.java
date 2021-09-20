package com.zifautomation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import com.zifautomation.Pages.CMPLandingpage;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAIOpportunityCardsPage;
import com.zifautomation.Pages.ZIFAIPredictionPage;
import com.zifautomation.Pages.ZIFAIPrediction_DeviceConfigPage;
import com.zifautomation.Pages.ZIFAIPrediction_FilterPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import bsh.Console;

public class ZIFUI_Testcases007 extends Base {

	// PreRequsite
	PropertiesFileReader obj= new PropertiesFileReader();
	Properties properties = null;



	@Test(enabled = true)
	public void ZIFUIPredictions_VerifyFilterOptions() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Filter Option Verification");
		test.createNode("ZIF UI Prediction Filter Option Verification");

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




			//verify Filter option is Displayed
			try {
				Thread.sleep(3000);
				new ZIFAIPrediction_FilterPage(driver).Filteroptiondisplayed();
				test.log(Status.PASS,"Filter icon is present in the Prediction screen");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter icon is not present in the Prediction screen");
			}



			//Click on Filter and Verify the fields
			try {
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifyFilteroptions();
				test.log(Status.PASS,"Filter Popup is displayed with the below options.\r\n" + 
						" - Filter-Title\r\n" + 
						" - Opportunity ID\r\n" + 
						" - Device Name\r\n" + 
						" - Resource Group\r\n" + 
						" - Counters \r\n" + 
						" - Drive / Mount Name\r\n" + 
						"along with Apply and Clear button\r\n" + 
						"X icon\r\n" + 
						"");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter option field validation failed");
			}




			//Verify that the Counter and Driver / Mount drop down is Disabled

			try {
				new ZIFAIPrediction_FilterPage(driver).verifycounterdropdowndisabled();
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
				test.log(Status.PASS,"Counter and Driver / Mount drop down are Disabled");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Counter and Driver / Mount drop down are enabled");
			}





			//Verify the Resource Group dropdown


			try {
				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).verifyResourcedropdownfields();
				test.log(Status.PASS,"Below are the static values displayed in resource group\r\n" + 
						" - cpu\r\n" + 
						" - memory\r\n" + 
						" - disk\r\n" + 
						" - network");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Resource Group drop down field validation failed");
			}





			//Select the Resource Type as "CPU/Memory/Network/Disk" and Verify Drive/Mount Name drop down should be disabled and Counters drop down is enabled

			try {
				new ZIFAIPrediction_FilterPage(driver).selectCPUResource();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled();
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
				test.log(Status.PASS,"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as CPU");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as CPU failed");
			}

			try {

				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectMemoryResource();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled();
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
				test.log(Status.PASS,"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as Memory");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as Memory failed");
			}

			/*
			 * try { new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
			 * new ZIFAIPrediction_FilterPage(driver).selectNetworkResource(); new
			 * ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled(); new
			 * ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
			 * test.log(Status.
			 * PASS,"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as Network"
			 * ); }catch (AssertionError | Exception e) { test.log(Status.FAIL,
			 * "Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as Network failed"
			 * ); }
			 */
			try {
				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selecDiskResource();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled();
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
				test.log(Status.PASS,"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as Disk");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as Disk failed");
			}






			//Enter Device Name and Verify that Drive / Mount Name drop down is enabled
			try {

				String deviceName = testdata.getTestDataInMap().get("ValidDeviceName");
				new ZIFAIPrediction_FilterPage(driver).enterDeviceNamevalue(deviceName);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).verifydrivedropdownenabled();
				test.log(Status.PASS,"Drive / Mount Name drop down is enabled On Entering Device Name for Disk");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Drive / Mount Name drop down is Disabled On Entering Device Name for Disk");
			}


			//Enter Device Name and Verify that Drive / Mount Name drop down is enabled
			try {
				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectCPUResource();
				Thread.sleep(2000);
				String deviceName = testdata.getTestDataInMap().get("ValidDeviceName");
				new ZIFAIPrediction_FilterPage(driver).enterDeviceNamevalue(deviceName);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				new ZIFAIPrediction_FilterPage(driver).VerifyDeviceNameoppCardOnFilter(deviceName);
				test.log(Status.PASS,"Filter is applied successfully for Valid Device Name");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for Valid Device Name or Cards not available");
			}



			//Enter InValid Device Name and click on Apply button and verify the Filter is applied and NO DATA AVAILABLE is Displayed
			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				//new ZIFAIPrediction_FilterPage(driver).clickFilter();//comment on changes----------------------------------------------------------------------------------
				//Thread.sleep(2000);
				String deviceName = testdata.getTestDataInMap().get("InvalidDeviceName");
				new ZIFAIPrediction_FilterPage(driver).enterDeviceNamevalue(deviceName);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				new ZIFAIPrediction_FilterPage(driver).VerifyNoDATAforInvalidFilter();
				test.log(Status.PASS,"Filter is applied successfully for InValid Device Name and NO DATA AVAILABLE is found");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Device Name or Cards are available");
			}






			//Enter Valid OPP ID and click on Apply button and verify the Filter is applied
			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				//new ZIFAIPrediction_FilterPage(driver).clickFilter();//comment on changes----------------------------------------------------------------------------------
				//Thread.sleep(2000);
				String oppId = testdata.getTestDataInMap().get("ValidOppID");
				new ZIFAIPrediction_FilterPage(driver).enterOppcardvalue(oppId);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				new ZIFAIPrediction_FilterPage(driver).VerifyOPPIDoppCardOnFilter(oppId);
				test.log(Status.PASS,"Filter is applied successfully for Valid Opp Card ID");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for Valid Opp ID or Cards not available");
			}

			//Enter InValid OPP ID and click on Apply button and verify the Filter is applied and NO DATA AVAILABLE is Displayed
			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				//new ZIFAIPrediction_FilterPage(driver).clickFilter();//comment on changes----------------------------------------------------------------------------------
				//Thread.sleep(2000);
				String oppId = testdata.getTestDataInMap().get("InvalidOppID");
				new ZIFAIPrediction_FilterPage(driver).enterOppcardvalue(oppId);
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				new ZIFAIPrediction_FilterPage(driver).VerifyNoDATAforInvalidFilter();
				test.log(Status.PASS,"Filter is applied successfully for InValid Opp Card ID and NO DATA AVAILABLE is found");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards are available");
			}


			//Select Resource Group as CPU and any Counters and Click on Apply button

			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				//new ZIFAIPrediction_FilterPage(driver).clickFilter();//comment on changes----------------------------------------------------------------------------------
				//Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectCPUResource();
				Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickCountersdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectCPUcounter();
				Thread.sleep(2000);

				String counter = testdata.getTestDataInMap().get("CPUcounter");

				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).VerifyDeviceNameoppCardOnFilter(counter);

				test.log(Status.PASS,"Filter is applied successfully for CPU and counters and  Valid Opp Card ID are displayed");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
			}



			//Select Resource Group as Memory and any Counters and Click on Apply button

			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				//new ZIFAIPrediction_FilterPage(driver).clickFilter();//comment on changes----------------------------------------------------------------------------------
				//Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectMemoryResource();
				Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickCountersdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectMemorycounter();
				Thread.sleep(2000);

				String counter = testdata.getTestDataInMap().get("Memorycounter");

				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).VerifyDeviceNameoppCardOnFilter(counter);

				test.log(Status.PASS,"Filter is applied successfully for Memory and counters and Valid Opp Card ID are displayed");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
			}


			//Select Resource Group as Disk and any Counters and Click on Apply button

			try {
				new ZIFAIPrediction_FilterPage(driver).clickFilter();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).ClearButton();
				Thread.sleep(2000);
				//new ZIFAIPrediction_FilterPage(driver).clickFilter();//comment on changes----------------------------------------------------------------------------------
				//Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
				new ZIFAIPrediction_FilterPage(driver).selecDiskResource();
				Thread.sleep(2000);

				new ZIFAIPrediction_FilterPage(driver).ClickCountersdropdown();
				new ZIFAIPrediction_FilterPage(driver).selectDiskcounter();
				Thread.sleep(2000);

				String counter = testdata.getTestDataInMap().get("Diskcounter");

				new ZIFAIPrediction_FilterPage(driver).ApplyButton();
				Thread.sleep(2000);
				new ZIFAIPrediction_FilterPage(driver).VerifyDeviceNameoppCardOnFilter(counter);

				test.log(Status.PASS,"Filter is applied successfully for Disk and counters and Valid Opp Card ID are displayed");
			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
			}


			//-------------------------------------------------------------------------------------------------------------------------------------------------
			//-------------------------------------------------------------------------------------------------------------------------------------------------
			//-------------------------------------------------------------------------------------------------------------------------------------------------



			//Logout of Application 
			try { new ZIFAIDashboardPage(driver).LogoutClick();
			test.log(Status.PASS,"Successfully Logged out from Dashboard Page"); }catch
			(AssertionError | Exception e) { test.log(Status.FAIL,
					"Dashboard page Logout failed"); }


		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in Selecting prediction from Analyzes");

		}



	}

}




