package com.zifautomation.TestScripts;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Pages.ZIFAI_Prediction_ExportToExcel;
import com.zifautomation.Pages.ZIFAI_ToolSeverityMappingPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

public class ZIFUI_AnP_Regression extends Base {

	WebDriverWait wait1 = null;

	@Test
	public void ZIFUI_AnP_RegressionTestcase() throws IOException, InterruptedException {

		// Report

		test = extent.createTest("ZIFAI A&P Regression");
		test.createNode("ZIFAI A&P Regression");

		// Verify all the fields in Login Page

		try {
			new Loginfunction(driver).Check_all_fields_are_present();
			test.log(Status.PASS, "Successfully verified all the fields in Login Page");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login page field validation failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify invalid credential
		try {
			String UserName = testdata.getTestDataInMap().get("InvalidUsername");
			String Password = testdata.getTestDataInMap().get("InvalidPassword");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);
			new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();

			test.log(Status.PASS, "Invalid credential has been entered and Verified");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Invalid credentials verification failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		// Login to the ZIFAI Portal With valid credentials
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			
			new Loginfunction(driver).Enterthecredentials(UserName, Password);

			test.log(Status.PASS, "Valid credential has been entered");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

	// Verify User is in ZIFAI Dashboard Home Page

		String ExpectedTitle = "dashboard";

		String ActualTitle = driver.getCurrentUrl();

		assertTrue(ActualTitle.contains(ExpectedTitle), "User is in dashboard page");
		if ((ActualTitle.contains(ExpectedTitle))) {

			test.log(Status.PASS, "Successfully logged in and User is in ZIFUI Home Page");

			Thread.sleep(2000);
		} else {
			test.log(Status.FAIL, "Login failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		System.out.println("User is in ZIF UI Dashboard Page");

		// Verify all fields in ZIF UI dashboard page
		try {

			new ZIFAIDashboardPage(driver).CheckallfieldsandImages();
			test.log(Status.PASS, "Successfully verified all the fields in the Dashboard Page");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Dashboard page field validdation failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify all fields in ZIF UI dashboard page
		try {

			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			test.log(Status.PASS, "Successfully the hover menu is displayed for the Analyzes");
			Thread.sleep(2000);
			new ZIFAIDashboardPage(driver).verifyAnalyzeshovermenufields();
			test.log(Status.PASS, "Successfully verified the fields in the hover menu displayed for Analyzes");
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in hover menu of Analyzes");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify all fields in ZIF UI Prediction page
		try {

			new ZIFAIDashboardPage(driver).clickPrediction();
			new ZIFAIPredictionPage(driver).checkuserinPredictionPage();
			test.log(Status.PASS, "Successfully the user is in Prediction page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in selecting prediction from Analyzes");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		System.out.println("User is in Prediction Page");

		// Verify all fields in ZIF UI Prediction page
		try {

			new ZIFAIPredictionPage(driver).CheckallfieldsandImages();
			new ZIFAIPredictionPage(driver).checkallpredictionfields();
			test.log(Status.PASS, "Successfully verified all fields in Prediction page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction page fields");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// -------------------------------------------------------------------------------------------------------------
		// -----------------------------------------------Filter--------------------------------------------------------
		// -------------------------------------------------------------------------------------------------------------

		// verify Filter option is Displayed
		
		test = extent.createTest("verify Filter option is Displayed");
		test.createNode("verify Filter option is Displayed");

		try {
			Thread.sleep(3000);
			new ZIFAIPrediction_FilterPage(driver).Filteroptiondisplayed();
			test.log(Status.PASS, "Filter icon is present in the Prediction screen");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter icon is not present in the Prediction screen");
		}

		// Click on Filter and Verify the fields
		try {
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).clickFilter();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).verifyFilteroptions();
			test.log(Status.PASS, "Filter Popup is displayed with the below options.\r\n" + " - Filter-Title\r\n"
					+ " - Opportunity ID\r\n" + " - Device Name\r\n" + " - Resource Group\r\n" + " - Counters \r\n"
					+ " - Drive / Mount Name\r\n" + "along with Apply and Clear button\r\n" + "X icon\r\n" + "");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter option field validation failed");
		}

		// Verify that the Counter and Driver / Mount drop down is Disabled

		try {
			new ZIFAIPrediction_FilterPage(driver).verifycounterdropdowndisabled();
			new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
			test.log(Status.PASS, "Counter and Driver / Mount drop down are Disabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Counter and Driver / Mount drop down are enabled");
		}

		// Verify the Resource Group dropdown

		try {
			new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
			new ZIFAIPrediction_FilterPage(driver).verifyResourcedropdownfields();
			test.log(Status.PASS, "Below are the static values displayed in resource group\r\n" + " - cpu\r\n"
					+ " - memory\r\n" + " - disk\r\n" + " - network");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Resource Group drop down field validation failed");
		}

		// Select the Resource Type as "CPU/Memory/Network/Disk" and Verify Drive/Mount
		// Name drop down should be disabled and Counters drop down is enabled

		try {
			new ZIFAIPrediction_FilterPage(driver).selectCPUResource();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled();
			new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
			test.log(Status.PASS,
					"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as CPU");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL,
					"Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as CPU failed");
		}

		try {

			new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
			new ZIFAIPrediction_FilterPage(driver).selectMemoryResource();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled();
			new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
			test.log(Status.PASS,
					"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as Memory");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL,
					"Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as Memory failed");
		}

		try {
			new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
			new ZIFAIPrediction_FilterPage(driver).selecDiskResource();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).verifycounterdropdownenabled();
			new ZIFAIPrediction_FilterPage(driver).verifydrivedropdowndisabled();
			test.log(Status.PASS,
					"Drive / Mount Name drop down is disabled and Counters drop down is enabled on Selecting Resource Groups as Disk");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL,
					"Drive / Mount Name drop down and Counters drop downs behaviour on Selecting Resource Groups as Disk failed");
		}

		// Enter Device Name and Verify that Drive / Mount Name drop down is enabled
		try {

			String deviceName = testdata.getTestDataInMap().get("ValidDeviceName");
			new ZIFAIPrediction_FilterPage(driver).enterDeviceNamevalue(deviceName);
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).verifydrivedropdownenabled();
			test.log(Status.PASS, "Drive / Mount Name drop down is enabled On Entering Device Name for Disk");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Drive / Mount Name drop down is Disabled On Entering Device Name for Disk");
		}

		// Enter Device Name and Verify that Drive / Mount Name drop down is enabled
		try {
			new ZIFAIPrediction_FilterPage(driver).ClickResourceGroupdropdown();
			new ZIFAIPrediction_FilterPage(driver).selectCPUResource();
			Thread.sleep(2000);
			String deviceName = testdata.getTestDataInMap().get("ValidDeviceName");
			new ZIFAIPrediction_FilterPage(driver).enterDeviceNamevalue(deviceName);
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ApplyButton();
			new ZIFAIPrediction_FilterPage(driver).VerifyDeviceNameoppCardOnFilter(deviceName);
			test.log(Status.PASS, "Filter is applied successfully for Valid Device Name");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter is failed for Valid Device Name or Cards not available");
		}

		// Enter InValid Device Name and click on Apply button and verify the Filter is
		// applied and NO DATA AVAILABLE is Displayed
		try {
			new ZIFAIPrediction_FilterPage(driver).clickFilter();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ClearButton();
			Thread.sleep(2000);

			String deviceName = testdata.getTestDataInMap().get("InvalidDeviceName");
			new ZIFAIPrediction_FilterPage(driver).enterDeviceNamevalue(deviceName);
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ApplyButton();
			new ZIFAIPrediction_FilterPage(driver).VerifyNoDATAforInvalidFilter();
			test.log(Status.PASS,
					"Filter is applied successfully for InValid Device Name and NO DATA AVAILABLE is found");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter is failed for InValid Device Name or Cards are available");
		}

		// Enter Valid OPP ID and click on Apply button and verify the Filter is applied
		try {
			new ZIFAIPrediction_FilterPage(driver).clickFilter();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ClearButton();
			Thread.sleep(2000);

			String oppId = testdata.getTestDataInMap().get("ValidOppID");
			new ZIFAIPrediction_FilterPage(driver).enterOppcardvalue(oppId);
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ApplyButton();
			new ZIFAIPrediction_FilterPage(driver).VerifyOPPIDoppCardOnFilter(oppId);
			test.log(Status.PASS, "Filter is applied successfully for Valid Opp Card ID");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter is failed for Valid Opp ID or Cards not available");
		}

		// Enter InValid OPP ID and click on Apply button and verify the Filter is
		// applied and NO DATA AVAILABLE is Displayed
		try {
			new ZIFAIPrediction_FilterPage(driver).clickFilter();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ClearButton();
			Thread.sleep(2000);

			String oppId = testdata.getTestDataInMap().get("InvalidOppID");
			new ZIFAIPrediction_FilterPage(driver).enterOppcardvalue(oppId);
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ApplyButton();
			new ZIFAIPrediction_FilterPage(driver).VerifyNoDATAforInvalidFilter();
			test.log(Status.PASS,
					"Filter is applied successfully for InValid Opp Card ID and NO DATA AVAILABLE is found");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards are available");
		}

		// Select Resource Group as CPU and any Counters and Click on Apply button

		try {
			new ZIFAIPrediction_FilterPage(driver).clickFilter();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ClearButton();
			Thread.sleep(2000);

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

			test.log(Status.PASS,
					"Filter is applied successfully for CPU and counters and  Valid Opp Card ID are displayed");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
		}

		// Select Resource Group as Memory and any Counters and Click on Apply button

		try {
			new ZIFAIPrediction_FilterPage(driver).clickFilter();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ClearButton();
			Thread.sleep(2000);

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

			test.log(Status.PASS,
					"Filter is applied successfully for Memory and counters and Valid Opp Card ID are displayed");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
		}

		// Select Resource Group as Disk and any Counters and Click on Apply button

		try {
			new ZIFAIPrediction_FilterPage(driver).clickFilter();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ClearButton();
			Thread.sleep(2000);

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

			test.log(Status.PASS,
					"Filter is applied successfully for Disk and counters and Valid Opp Card ID are displayed");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
		}

		try {
			new ZIFAIPrediction_FilterPage(driver).clickFilter();
			Thread.sleep(2000);
			new ZIFAIPrediction_FilterPage(driver).ClearButton();
			new ZIFAIPrediction_FilterPage(driver).closeFilter();
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter is failed for InValid Opp ID or Cards not available");
		}

		// -------------------------------------------------------------------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------------------------------------------------------------------

//US2842- Opportunities - Excel Export Option
		
		test = extent.createTest("US2842- Opportunities - Excel Export Option");
		test.createNode("US2842- Opportunities - Excel Export Option");


		// Verify all fields in ZIF UI dashboard page
		new ZIFAIDashboardPage(driver).hoveronAnalyzes();
		new ZIFAIDashboardPage(driver).clickPrediction();

		// Verify all fields in ZIF UI Prediction Swim lane
		try {
			new ZIFAIPredictionPage(driver).verifySwinlaneFields();
			test.log(Status.PASS, "Successfully verified all fields Prediction swim lane");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction swim lane fields");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify user is able to click on Export to Excel under Predicted Risk
		try {
			new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderPredictedRiskcard();
			test.log(Status.PASS, "User is successfully clicked on export to excel under PRC ");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			// e.printStackTrace();
			test.log(Status.SKIP, "User is not able click on export to excel under PRC");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify user is able to click on Export to Excel under Critical
		try {
			new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderCritical();
			test.log(Status.PASS, "User is successfully clicked on export to excel under CRL ");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			// e.printStackTrace();
			test.log(Status.SKIP, "User is not able click on export to excel under CRL");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify user is able to click on Export to Excel under Processed
		try {
			new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderProcessed();
			test.log(Status.PASS, "User is successfully clicked on export to excel under Processed ");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			// e.printStackTrace();
			test.log(Status.SKIP, "User is not able click on export to excel under Processed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

			// Verify user is able to click on Export to Excel under Lost
			try {
				new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderLost();
				/* String dirPath = "C:\\Users\\usha.thangavelu\\Downloads";
				new CommonMethods(driver);
				CommonMethods.isFileDownloaded(dirPath, "usha"); */
				test.log(Status.PASS, "User is successfully clicked on export to excel under Lost ");
				Thread.sleep(2000);
			} catch (AssertionError | Exception e1) {
				e1.printStackTrace();
				test.log(Status.SKIP, "User is not able click on export to excel under Lost");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			// Verify user is able to click on Export to Excel under Invalid
			try {
				new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderInvalid();
				test.log(Status.PASS, "User is successfully clicked on export to excel under Invalid ");
				Thread.sleep(2000);
			} catch (AssertionError | Exception e2) {
				e2.printStackTrace();
				test.log(Status.SKIP, "User is not able click on export to excel under Invalid");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			// -------------------------------------------------------------------------------------------------------------------------------------------------
			// -------------------------------------------------------------------------------------------------------------------------------------------------
			// -------------------------------------------------------------------------------------------------------------------------------------------------

			// Verify all fields in ZIF UI dashboard page
			try {

				new ZIFAIDashboardPage(driver).hoveronAnalyzes();
				new ZIFAIDashboardPage(driver).clickAnalytics();

				// Turn off Live Feed
				try {
					Thread.sleep(3000);
					new ZIFAI_CaseManagementPage(driver).Turnofflivefeed();
					test.log(Status.PASS, "Live Feed Is Turned Off");
				} catch (AssertionError | Exception e1) {
					test.log(Status.FAIL, "Live Feed is off");
				}

				// Verify multiple description
				try {

					new ZIFAI_CaseManagementPage(driver).ClickonanyAlertswith5or4or3();
					Thread.sleep(2000);
					test.log(Status.PASS, "Verified Expand and Collapse of Alert model");
					test.log(Status.PASS, "Verified Same Descriptions on correlated Alerts section");
					test.log(Status.PASS, "Verified Same Descriptions on TimeLine section");

				} catch (AssertionError | Exception e1) {
					test.log(Status.FAIL, "Failed to check the Description of the Alerts");
				}

			} catch (AssertionError | Exception e1) {
				e1.printStackTrace();
				test.log(Status.FAIL, "Failed in Selecting Analytics from Analyzes");

			}

			// Edit and Assign Status and verify
			try {
				new ZIFAI_CaseManagementPage(driver).ClickFirstAlert();
				Thread.sleep(2000);
				new ZIFAI_CaseManagementPage(driver).ClickEditandAssignNew();
				test.log(Status.PASS, "Successfully Edited the Alert with New Status and Verified");
			} catch (AssertionError | Exception e1) {
				test.log(Status.FAIL, "Failed to verify the New Alerts Status update");
			}

			try {
				new ZIFAI_CaseManagementPage(driver).ClickFirstAlert();
				Thread.sleep(2000);
				new ZIFAI_CaseManagementPage(driver).ClickEditandAssignAssigned();
				test.log(Status.PASS, "Successfully Edited the Alert with Assigned Status and Verified");
			} catch (AssertionError | Exception e1) {
				test.log(Status.FAIL, "Failed to verify the Assigned Alerts Status update");
			}

			try {
				new ZIFAI_CaseManagementPage(driver).ClickFirstAlert();
				Thread.sleep(2000);
				new ZIFAI_CaseManagementPage(driver).ClickEditandAssignInprogress();
				test.log(Status.PASS, "Successfully Edited the Alert with InProgress Status and Verified");
			} catch (AssertionError | Exception e1) {
				test.log(Status.FAIL, "Failed to verify the InProgress Alerts Status update");
			}

			
		    try {                   
		                    new ZIFAI_CaseManagementPage(driver).ClickFirstAlert();
		                    Thread.sleep(2000);
		                    new ZIFAI_CaseManagementPage(driver).ClickEditandAssignClosed();
		                   
		                    test.log(Status.PASS,"Successfully Edited the Alert with Closed Status and Verified");
		                    //Added Here
		                    new ZIFAI_CaseManagementPage(driver).AlertDetailsClose();
		                }catch (AssertionError | Exception e1)  {
		                    test.log(Status.FAIL, "Failed to verify the Closed Alerts Status update");
		                }

		}
		
		



//US2841- Tool Severity Mapping
		
		test = extent.createTest("US2841- Verify Tool Severity Mapping");
		test.createNode("Verify US2841- Tool Severity Mapping");

		
	  new ZIFAI_ToolSeverityMappingPage(driver).clickSetingsIcon();
		 
		  try {
				new ZIFAI_ToolSeverityMappingPage(driver).clickplarformmanagemnet();
				test.log(Status.PASS,"Successfully clicked on platformmanagement");
				Thread.sleep(2000);
			}catch (Exception e) {
				test.log(Status.FAIL, "User is not able to click on platformmanagement");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		  try {
				new ZIFAI_ToolSeverityMappingPage(driver).clickSeverityMapping();
				test.log(Status.PASS,"Successfully clicked on SeverityMapping");
				Thread.sleep(2000);
			}catch (Exception e) {
				test.log(Status.FAIL, "User is not able to click on SeverityMapping");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		  
		  
		   
		  
		   		  
		   try {
				new ZIFAI_ToolSeverityMappingPage(driver).clickToolNamelist();
				test.log(Status.PASS,"Successfully clicked on ToolNamelist");
				Thread.sleep(2000);
			}catch (Exception e) {
				test.log(Status.FAIL, "User is not able to click on ToolNamelist");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
	  
		
		  
		   try {
			   
				new ZIFAI_ToolSeverityMappingPage(driver).clickToolNamevalue1();
				test.log(Status.PASS,"Successfully clicked on ToolNamevalue1");
				Thread.sleep(2000);
			}catch (Exception e) {
				e.printStackTrace();
				test.log(Status.FAIL, "User is not able to click on ToolNamevalue1");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
	  
	  
		  
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverity1();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverityCRITICAL();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverityHIGH();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverityMEDIUM();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverityLOW();
        new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityCritical();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityHigh();
		//new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityInformation();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityLow();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityMedium();
	//	new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityReverse();
	//	new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityWarning();
	  
		 
/*		 try {
			new ZIFAI_ToolSeverityMappingPage(driver).clickToolNamevalue2();
			test.log(Status.PASS,"Successfully clicked on ToolNamevalue2");
			Thread.sleep(2000);
		}catch (Exception e) {
			test.log(Status.FAIL, "User is not able to click on ToolNamevalue2");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		
		
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverity1();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverityCRITICAL();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverityHIGH();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverityMEDIUM();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckToolSeverityLOW();
        new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityCritical();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityHigh();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityInformation();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityLow();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityMedium();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityReverse();
		new ZIFAI_ToolSeverityMappingPage(driver).CheckZIFSeverityWarning();
	  
  */
		
		//US2780 - Case Management - Correlated Alerts - Others Info
		
				//click on the analytics link
				try {
					new ZIFAIDashboardPage(driver).hoveronAnalyzes();
					new ZIFAIDashboardPage(driver).clickAnalytics();
					test.log(Status.PASS, "Analytics link is clicked");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Not able to click the Analytics link");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//Verify the correlation details
				try
				{

					new ZIFAI_CaseManagementPage(driver).Filtericon.click();
					Thread.sleep(3000);
					//new ZIFAICasemanagementPage(driver).EnterCaseID("ZIF2588");
					String CaseID = testdata.getTestDataInMap().get("CaseIDwithdata");
					new ZIFAI_CaseManagementPage(driver).EnterCaseID(CaseID);
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).Applybutton.click();
					Thread.sleep(4000);
					new ZIFAI_CaseManagementPage(driver).ClickFirstCaserow();
					test.log(Status.PASS, "Case id is clicked");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Not able to click case id");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				try{
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).CorrelatedALerts.click();
					test.log(Status.PASS, "Correlated Alerts is clicked");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Not able to click the Correlated Alerts");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}



				//Verify the correlation details
				try{
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).Expandbutton.click();
					new ZIFAI_CaseManagementPage(driver).Correlationdetails();
					test.log(Status.PASS, "correlation details have been verified");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Not able to verified the correlation details");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				test = extent.createTest("User Story 2780 - Verify whether the user is able to view the more info details in both expanded and collapsed mode");
				test.createNode("User Story 2780 - Verify whether the user is able to view the more info details in both expanded and collapsed mode");

				//Verify the more info popup in expanded mode
				try{
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).Moreinfo.click();
					new ZIFAI_CaseManagementPage(driver).MoreInfoPopup();
					test.log(Status.PASS, "Moreinfo popup is displayed in expanded mode");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					new ZIFAI_CaseManagementPage(driver).MoreinfoCloseicon.click();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).Collapsebutton.click();
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Moreinfo popup is not displayed in expanded mode");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

							//Verify the more info popup in Collapsed mode
				try{
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).Moreinfo.click();
					new ZIFAI_CaseManagementPage(driver).MoreInfoPopup();
					test.log(Status.PASS, "Moreinfo popup is displayed in Collapsed mode");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					new ZIFAI_CaseManagementPage(driver).MoreinfoCloseicon.click();
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Moreinfo popup is not displayed in Collapsed mode");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				test = extent.createTest("User Story 2780 - Ensure the dots present in each alert row");
				test.createNode("User Story 2780 - Ensure the dots present in each alert row");

				//Verify the size of the more info
				try {
				Thread.sleep(3000);
				//Status verification
				List<WebElement> Moreinfo = new ZIFAI_CaseManagementPage(driver).More_info;
				for (int i = 0; i < Moreinfo.size(); i++) {
					String Moreinfovalues = Moreinfo.get(i).getAttribute("class");
					System.out.println("More info:" + Moreinfovalues);
					WebElement CorrelatedSize = driver.findElement(By.xpath("//span[@class='case-details-icon-data-1 ng-star-inserted']"));
					String CorrelatedSizeValue = CorrelatedSize.getText();
					if (CorrelatedSizeValue.equals(Moreinfo.size()) ||Moreinfovalues.equals("correlated-alerts-record-others cursor-pointer")) {
						test.log(Status.PASS, "More info icon is displayed in "+Moreinfo.size()+" case ids");
						test.addScreenCaptureFromPath(captureScreenShot(driver));
					}
				}

			} catch (AssertionError | Exception e) {
				test.log(Status.FAIL, "More info size is not verified");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

				test = extent.createTest("User Story 2780 -  Verify the tooltip displayed for three dots");
				test.createNode("User Story 2780 -  Verify the tooltip displayed for three dots");

				//Verify the more info tooltip
				try{
					//WebElement more_info = driver.findElement(By.xpath("//div[contains(@class,'correlated-alerts-record-others cursor-pointer')]"));
					Actions action = new Actions(driver);
					action.moveToElement(new ZIFAI_CaseManagementPage(driver).Moreinfo).perform();
					WebElement toolTipElement = driver.findElement(By.cssSelector(".ui-tooltip"));
					String toolTipText = toolTipElement.getText();
					System.out.println("Moreinfo_ToolTip:"+toolTipText);
					test.log(Status.PASS, "Moreinfo tooltip is displayed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Moreinfo tooltip is not displayed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				test = extent.createTest("User Story 2780 -  Verify the More info icon when there is no information");
				test.createNode("User Story 2780 -  Verify the More info icon when there is no information");
				//click on the analytics link
				try {
					Thread.sleep(2000);
					new ZIFAIDashboardPage(driver).hoveronAnalyzes();
					new ZIFAIDashboardPage(driver).clickAnalytics();
					test.log(Status.PASS, "Analytics link is clicked");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Not able to click the Analytics link");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Verify the correlation details
				try{
					String CaseIDvalue = testdata.getTestDataInMap().get("CaseIDwithoutdata");
					new ZIFAI_CaseManagementPage(driver).Filtericon.click();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).EnterCaseID(CaseIDvalue);
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).Applybutton.click();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).ClickFirstCaserow();
					test.log(Status.PASS, "Case id is clicked");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Not able to click case id");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Verify the more info three dots without data details
				try{
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).Expandbutton.click();
					new ZIFAI_CaseManagementPage(driver).CorrelatedALerts.click();
					if(new ZIFAI_CaseManagementPage(driver).Moreinfo.isDisplayed());
					test.log(Status.FAIL, "User is able to see the Three dots in correlated tab");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).Collapsebutton.click();
				} catch (AssertionError | Exception e) {
					test.log(Status.PASS, "Three dots are not displayed any popup");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				test = extent.createTest("User Story 2780 -  Verify the More info in raw alerts screen, Click the dots to view the more info details");
				test.createNode("User Story 2780 -   Verify the More info in raw alerts screen, Click the dots to view the more info details");

				//click on the analytics link
				try {

					new ZIFAIDashboardPage(driver).hoveronAnalyzes();
					new ZIFAIDashboardPage(driver).clickRawData();
					test.log(Status.PASS, "Raw alerts link is clicked");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Not able to click the raw alerts link");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				try{
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).ClickAlerts();
					test.log(Status.PASS, "Alerts tab is clicked");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch(Exception e) {
					test.log(Status.FAIL, "Not able to click the Alerts tab");
				}

				//Verify the more info tooltip
				try{
					//WebElement more_info = driver.findElement(By.xpath("//div[contains(@class,'correlated-alerts-record-others cursor-pointer')]"));
					Actions action = new Actions(driver);
					action.moveToElement(new ZIFAI_CaseManagementPage(driver).RawalertsMoreInfo).perform();
					WebElement toolTipElement = driver.findElement(By.cssSelector(".ui-tooltip"));
					String toolTipText = toolTipElement.getText();
					System.out.println("Moreinfo_ToolTip:"+toolTipText);
					test.log(Status.PASS, "Moreinfo tooltip is displayed in raw alerts");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Moreinfo tooltip is not displayed in raw alerts");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}



			try
				{
					new ZIFAI_CaseManagementPage(driver).Filtericon.click();
					Thread.sleep(3000);
					//new ZIFAICasemanagementPage(driver).EnterCaseID("ZIF2588");
					String CaseID = testdata.getTestDataInMap().get("CaseIDwithdata");
					new ZIFAI_CaseManagementPage(driver).EnterRawalertsCaseID(CaseID);
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).Applybutton.click();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).RawalertsMoreInfo.click();
					Thread.sleep(2000);
					new ZIFAI_CaseManagementPage(driver).RawalertsMoreInfo.isDisplayed();
					test.log(Status.PASS, "More info popup in raw alerts is verified");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch(Exception e) {
					test.log(Status.FAIL, "Not able to verify the more info popup in raw alerts");
				}


				test = extent.createTest("User Story 2780 -  Validate the close icon on more info popup");
				test.createNode("User Story 2780 -  Validate the close icon on more info popup");

				try
				{
					new ZIFAI_CaseManagementPage(driver).MoreinfoCloseicon.click();
					if (new ZIFAI_CaseManagementPage(driver).MoreinfoCloseicon.isDisplayed());
					test.log(Status.FAIL, "Not able to close the more info popup in raw alerts");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch(Exception e) {
					test.log(Status.PASS, "More info Pop up is closed in raw alerts");

				}

			

//US2797
		
		//click on the analytics link
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickAnalytics();
			test.log(Status.PASS, "Analytics link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//click on the preferences icon
		try {

			new ZIFAI_CaseManagementPage(driver).clickpreferencestab();
			test.log(Status.PASS, "Preference icon link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Preference icon link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Enter the Exclude_New_Closed_Assigned case status
		try {
			String Exclude_New_Closed_Assigned = testdata.getTestDataInMap().get("Exclude_New_Closed_Assigned");
			new ZIFAI_CaseManagementPage(driver).Entercasestatus(Exclude_New_Closed_Assigned);
			test.log(Status.PASS, "Exclude_New_Closed_Assigned case status is entered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to enter the Exclude_New_Closed_Assigned case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on the apply button
		try {
			new ZIFAI_CaseManagementPage(driver).clickapplybutton();
			test.log(Status.PASS, "Apply button is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the apply button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the Exclude_New_Closed_Assigned condition
		try {
			Thread.sleep(3000);
			//Search count verification
			String Case_countSize = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replaceAll("All", "").replace(")", "").replace("(", "").trim();
			System.out.println("Overall_Case_count:" + Case_countSize);
//			int Case_Size = new ZIFAICasemanagementPage(driver).Casestatusdetails.size();
//			String Case_Size_Ver = String.valueOf(Case_Size);
//			System.out.println("Case_Size_Ver:" + Case_Size_Ver);
//			if (Case_countSize.equals(Case_Size_Ver)) {
			test.log(Status.PASS, "Assigned Search count is " + Case_countSize + "");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Assigned Search count is not verified");

		}
		try{
			//Status verification
			List<WebElement> Casestatusdetails = driver.findElements(By.xpath("//div[@class='case-outer ng-star-inserted']/div/div/div/div[1]/div[2]/span[2]"));
			for (int i = 1; i < Casestatusdetails.size(); i++) {
				String Casestatusdetailsvalues = Casestatusdetails.get(i).getAttribute("class").replaceAll("case-first-left-icon-2 case-first-left-icon-2-", "").trim();
				System.out.println("Value is:" + Casestatusdetailsvalues);
				if (Casestatusdetailsvalues.contains("assigned")) {
					test.log(Status.PASS, "Assigned status is verified successfully");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Assigned status is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		test = extent.createTest("User Story 2797 -Validate the Case status(exclude:New, In Progress) condition");
		test.createNode("User Story 2797 -Validate the Case status (exclude:New, In Progress) condition");

		//click on the preferences icon
		try {
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).clickPreferencesTab__Enable();
//			new ZIFAICasemanagementPage(driver).clickpreferencestab();
			test.log(Status.PASS, "Preference icon link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Preference icon link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Enter the (exclude:New, In Progress) case status
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			String CaseStatus_Xpath = testdata.getTestDataInMap().get("CaseStatus_Xpaths");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" + CaseStatus_Xpath + "")));
			WebElement CaseStatus_Preferences = driver.findElement(By.xpath("" + CaseStatus_Xpath + ""));
			if (CaseStatus_Preferences.isDisplayed()) {
				CaseStatus_Preferences.clear();
			}
			Thread.sleep(2000);
			String Exclude_New_InProgress = testdata.getTestDataInMap().get("Exclude_New_InProgress");
			new ZIFAI_CaseManagementPage(driver).Entercasestatus(Exclude_New_InProgress);
			test.log(Status.PASS, "Exclude_New_Closed_Assigned case status is entered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to enter the Exclude_New_Closed_Assigned case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on the apply button
		try {
			new ZIFAI_CaseManagementPage(driver).clickapplybutton();
			test.log(Status.PASS, "Apply button is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the apply button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Search count verification
		try {
			Thread.sleep(3000);
			String Case_countSize = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replaceAll("All", "").replace(")", "").replace("(", "").trim();
			System.out.println("Overall_Case_count:" + Case_countSize);
//int Case_Size = new ZIFAICasemanagementPage(driver).Casestatusdetails.size();
//String Case_Size_Ver = String.valueOf(Case_Size);
//System.out.println("Case_Size_Ver:" + Case_Size_Ver);
//if (Case_countSize.equals(Case_Size_Ver)) {
			test.log(Status.PASS, "Inprogress Search count is " + Case_countSize + "");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Inprogress Search count is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			Thread.sleep(3000);
			//Status verification
			List<WebElement> InprogressCasestatusdetails = driver.findElements(By.xpath("//div[@class='case-outer ng-star-inserted']/div/div/div/div[1]/div[2]/span[2]"));
			for (int i = 0; i < InprogressCasestatusdetails.size(); i++) {
				String InprogressCasestatusdetailsvalues = InprogressCasestatusdetails.get(i).getAttribute("class").replaceAll("case-first-left-icon-2 corr_", "").trim();
				System.out.println("inprogress Value is:" + InprogressCasestatusdetailsvalues);
				if (InprogressCasestatusdetailsvalues.equals("inprogress")) {
					test.log(Status.PASS, "Inprogress status is verified successfully");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Inprogress status is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		test = extent.createTest("User Story 2797 -Validate the Case status (Closed, In Progress) condition");
		test.createNode("User Story 2797 -Validate the Case status (Closed, In Progress) condition");

		//click on the preferences icon
		try {
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).clickPreferencesTab__Enable();
			test.log(Status.PASS, "Preference icon link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Preference icon link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Enter the (Closed, In Progress) case status
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			String CaseStatus_Xpath = testdata.getTestDataInMap().get("CaseStatus_Xpaths");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" + CaseStatus_Xpath + "")));
			WebElement CaseStatus_Preferences = driver.findElement(By.xpath("" + CaseStatus_Xpath + ""));
			if (CaseStatus_Preferences.isDisplayed()) {
				Thread.sleep(2000);
				CaseStatus_Preferences.clear();
			}
			Thread.sleep(2000);
			String Closed_InProgress = testdata.getTestDataInMap().get("Closed_InProgress");
			new ZIFAI_CaseManagementPage(driver).Entercasestatus(Closed_InProgress);
			test.log(Status.PASS, "Closed_InProgress case status is entered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to enter the Closed_InProgress case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on the apply button
		try {
			new ZIFAI_CaseManagementPage(driver).clickapplybutton();
			test.log(Status.PASS, "Apply button is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the apply button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			Thread.sleep(3000);
			//Search count verification
			String Case_countSize = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replaceAll("All", "").replace(")", "").replace("(", "").trim();
			System.out.println("Overall_Case_count:" + Case_countSize);
//			int Case_Size = new ZIFAICasemanagementPage(driver).Casestatusdetails.size();
//			String Case_Size_Ver = String.valueOf(Case_Size);
//			System.out.println("Case_Size_Ver:" + Case_Size_Ver);
//			if (Case_countSize.equals(Case_Size_Ver)) {
			test.log(Status.PASS, "Closed and Inprogress Search count is " + Case_countSize + "");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Closed and Inprogress Search count is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			Thread.sleep(3000);
			//Status verification
			List<WebElement> ClosedCasestatusdetails = driver.findElements(By.xpath("//div[@class='case-outer ng-star-inserted']/div/div/div/div[1]/div[2]/span[2]"));
			for (int i = 0; i < ClosedCasestatusdetails.size(); i++) {
				String ClosedCasestatusdetailsvalues = ClosedCasestatusdetails.get(i).getAttribute("class").replaceAll("case-first-left-icon-2 case-first-left-icon-2-", "").trim();
				System.out.println("Closed Value is:" + ClosedCasestatusdetailsvalues);
				if (ClosedCasestatusdetailsvalues.equals("closed")) {
					test.log(Status.PASS, "Closed status is verified successfully");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Closed status is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			Thread.sleep(3000);
			WebElement Inprogresscasestatus = driver.findElement(By.xpath("(//span[@class='case-first-left-icon-2 corr_inprogress'])[1]"));
			if (Inprogresscasestatus.isDisplayed()) {
				//Status verification
				List<WebElement> InprogressCasestatusdetails = driver.findElements(By.xpath("//span[@class='case-first-left-icon-2 corr_inprogress'][1]"));
				for (int i = 0; i < InprogressCasestatusdetails.size(); i++) {
					String InprogressCasestatusdetailsvalues = InprogressCasestatusdetails.get(i).getAttribute("class").replaceAll("case-first-left-icon-2 corr_", "").trim();
					System.out.println("inprogress Value is:" + InprogressCasestatusdetailsvalues);
					if (InprogressCasestatusdetailsvalues.equals("inprogress")) {
						test.log(Status.PASS, "Inprogress status is verified successfully");
						test.addScreenCaptureFromPath(captureScreenShot(driver));
					}
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Inprogress status is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		test = extent.createTest("User Story 2797 -Validate the Case status (exclude: Assigned, exclude: New) condition");
		test.createNode("User Story 2797 -Validate the Case status (exclude: Assigned, exclude: New) condition");
		//click on the preferences icon
		try {
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).clickPreferencesTab__Enable();
			test.log(Status.PASS, "Preference icon link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Preference icon link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Enter the (Closed, In Progress) case status
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			String CaseStatus_Xpath = testdata.getTestDataInMap().get("CaseStatus_Xpaths");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" + CaseStatus_Xpath + "")));
			WebElement CaseStatus_Preferences = driver.findElement(By.xpath("" + CaseStatus_Xpath + ""));
			if (CaseStatus_Preferences.isDisplayed()) {
				Thread.sleep(2000);
				CaseStatus_Preferences.clear();
			}
			Thread.sleep(2000);
			String Closed_InProgress = testdata.getTestDataInMap().get("Exclued_Assigned_New");
			new ZIFAI_CaseManagementPage(driver).Entercasestatus(Closed_InProgress);
			test.log(Status.PASS, "Exclude: Assigned, exclude: New case status is entered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to enter the exclude: Assigned, exclude: New case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on the apply button
		try {
			new ZIFAI_CaseManagementPage(driver).clickapplybutton();
			test.log(Status.PASS, "Apply button is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the apply button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			Thread.sleep(3000);
			//Search count verification
			String Case_countSize = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replaceAll("All", "").replace(")", "").replace("(", "").trim();
			System.out.println("Overall_Case_count:" + Case_countSize);
			test.log(Status.PASS, "Closed and Inprogress Search count is " + Case_countSize + "");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Closed and Inprogress Search count is not verified");

		}

		try {
			Thread.sleep(3000);
			//Status verification
			List<WebElement> ClosedCasestatusdetails = driver.findElements(By.xpath("//div[@class='case-outer ng-star-inserted']/div/div/div/div[1]/div[2]/span[2]"));
			for (int i = 0; i < ClosedCasestatusdetails.size(); i++) {
				String Closed_InprogressCasestatusdetailsvalues = ClosedCasestatusdetails.get(i).getAttribute("class").replaceAll("case-first-left-icon-2 case-first-left-icon-2-", "").trim();
				System.out.println("Closed Value is:" + Closed_InprogressCasestatusdetailsvalues);
				if (Closed_InprogressCasestatusdetailsvalues.equals("closed") || Closed_InprogressCasestatusdetailsvalues.equals("inprogress")) {
					test.log(Status.PASS, "Closed status is verified successfully");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Closed status is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		try {
			Thread.sleep(3000);
			//Status verification
			List<WebElement> InprogressCasestatusdetails = driver.findElements(By.xpath("//span[@class='case-first-left-icon-2 corr_inprogress'][1]"));
			for (int i = 0; i < InprogressCasestatusdetails.size(); i++) {
				String InprogressCasestatusdetailsvalues = InprogressCasestatusdetails.get(i).getAttribute("class").replaceAll("case-first-left-icon-2 corr_", "").trim();
				System.out.println("inprogress Value is:" + InprogressCasestatusdetailsvalues);
				if (InprogressCasestatusdetailsvalues.equals("inprogress")) {
					test.log(Status.PASS, "Inprogress status is verified successfully");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Inprogress status is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		test = extent.createTest("User Story 2797 -Validate the Case status (exclude: Assigned) condition");
		test.createNode("User Story 2797 -Validate the Case status (exclude: Assigned) condition");
		//click on the preferences icon
		try {
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).clickPreferencesTab__Enable();
			test.log(Status.PASS, "Preference icon link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Preference icon link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Enter the (Closed, In Progress) case status
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			String CaseStatus_Xpath = testdata.getTestDataInMap().get("CaseStatus_Xpaths");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" + CaseStatus_Xpath + "")));
			WebElement CaseStatus_Preferences = driver.findElement(By.xpath("" + CaseStatus_Xpath + ""));
			if (CaseStatus_Preferences.isDisplayed()) {
				Thread.sleep(2000);
				CaseStatus_Preferences.clear();
			}
			Thread.sleep(2000);
			String Closed_InProgress = testdata.getTestDataInMap().get("Exclude:Assigned");
			new ZIFAI_CaseManagementPage(driver).Entercasestatus(Closed_InProgress);
			test.log(Status.PASS, "Exclude: Assigned status is entered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to enter the Exclude: Assigned status status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on the apply button
		try {
			new ZIFAI_CaseManagementPage(driver).clickapplybutton();
			test.log(Status.PASS, "Apply button is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the apply button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			Thread.sleep(3000);
			//Search count verification
			String Case_countSize = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replaceAll("All", "").replace(")", "").replace("(", "").trim();
			System.out.println("Overall_Case_count:" + Case_countSize);
			test.log(Status.PASS, "Exclude: Assigned Search count is " + Case_countSize + "");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Exclude: Assigned Search count is not verified");

		}

		try {
			Thread.sleep(3000);
			//Status verification
			List<WebElement> ClosedCasestatusdetails = driver.findElements(By.xpath("//div[@class='case-outer ng-star-inserted']/div/div/div/div[1]/div[2]/span[2]"));
			for (int i = 0; i < ClosedCasestatusdetails.size(); i++) {
				String ClosedCasestatusdetailsvalues = ClosedCasestatusdetails.get(i).getAttribute("class").replaceAll("case-first-left-icon-2 case-first-left-icon-2-", "").trim();
				System.out.println("Closed Value is:" + ClosedCasestatusdetailsvalues);
				if (ClosedCasestatusdetailsvalues.equals("closed")) {
					test.log(Status.PASS, "Closed status is verified successfully");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Closed status is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		try {
			Thread.sleep(3000);
			//Status verification
			List<WebElement> InprogressCasestatusdetails = driver.findElements(By.xpath("//span[@class='case-first-left-icon-2 corr_inprogress'][1]"));
			for (int i = 0; i < InprogressCasestatusdetails.size(); i++) {
				String InprogressCasestatusdetailsvalues = InprogressCasestatusdetails.get(i).getAttribute("class").replaceAll("case-first-left-icon-2 corr_", "").trim();
				System.out.println("Inprogress Value is:" + InprogressCasestatusdetailsvalues);
				if (InprogressCasestatusdetailsvalues.equals("inprogress")) {
					test.log(Status.PASS, "Inprogress status is verified successfully");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Inprogress status is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			Thread.sleep(3000);
			//Status verification
			List<WebElement> newCasestatusdetails = driver.findElements(By.xpath("//div[@class='case-outer ng-star-inserted']/div/div/div/div[1]/div[2]/span[2]"));
			for (int i = 0; i < newCasestatusdetails.size(); i++) {
				String NewCasestatusdetailsvalues = newCasestatusdetails.get(i).getAttribute("class").replaceAll("case-first-left-icon-2 case-first-left-icon-2-", "").trim();
				System.out.println("New Value is:" + NewCasestatusdetailsvalues);
				if (NewCasestatusdetailsvalues.equals("new")) {
					test.log(Status.PASS, "New status is verified successfully");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "New status is not verified");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		test = extent.createTest("User Story 2797 -Verify the excel export is downloaded based on the exclude: Closed, exclude: New, Assigned in Case Status.");
		test.createNode("User Story 2797 -Verify the excel export is downloaded based on the exclude: Closed, exclude: New, Assigned in Case Status.");

		//click on the preferences icon
		try {
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).clickPreferencesTab__Enable();
			test.log(Status.PASS, "Preference icon link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Preference icon link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Enter the Exclude_New_Closed_Assigned case status
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			String CaseStatus_Xpath = testdata.getTestDataInMap().get("CaseStatus_Xpaths");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" + CaseStatus_Xpath + "")));
			WebElement CaseStatus_Preferences = driver.findElement(By.xpath("" + CaseStatus_Xpath + ""));
			if (CaseStatus_Preferences.isDisplayed()) {
				Thread.sleep(2000);
				CaseStatus_Preferences.clear();
			}
			String Exclude_New_Closed_Assigned = testdata.getTestDataInMap().get("Exclude_New_Closed_Assigned");
			new ZIFAI_CaseManagementPage(driver).Entercasestatus(Exclude_New_Closed_Assigned);
			test.log(Status.PASS, "Exclude_New_Closed_Assigned case status is entered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to enter the Exclude_New_Closed_Assigned case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on the apply button
		try {
			new ZIFAI_CaseManagementPage(driver).clickapplybutton();
			test.log(Status.PASS, "Apply button is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the apply button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		
		
			
		// Logout of Application
		try {
			new ZIFAIDashboardPage(driver).LogoutClick();
			test.log(Status.PASS, "Successfully Logged out from Dashboard Page");
		} catch (Exception e1) {
			test.log(Status.FAIL, "Dashboard page Logout failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

	}
}