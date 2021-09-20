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
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;


public class ZIFUI_Core_Regression extends Base{

	WebDriverWait wait1=null;


	@Test
	public void ZIFUI_Core_RegressionTestcase() throws IOException, InterruptedException {


		//Report 

		test = extent.createTest("ZIFAI Core  Regression");
		test.createNode("ZIFAI Core Regression");


		//Verify all the fields in Login Page

		try {
			new Loginfunction(driver).Check_all_fields_are_present();
			test.log(Status.PASS,"Successfully verified all the fields in Login Page");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login page field validation failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Verify invalid credential
		try {
			String UserName = testdata.getTestDataInMap().get("InvalidUsername");
			String Password = testdata.getTestDataInMap().get("InvalidPassword");
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();

			test.log(Status.PASS,"Invalid credential has been entered and Verified");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Invalid credentials verification failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}


		// Login to the ZIFAI Portal With valid credentials
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);

			test.log(Status.PASS,"Valid credential has been entered");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}


		// Verify User is in ZIFAI Dashboard Home Page


		String ExpectedTitle = "dashboard";

		String ActualTitle = driver.getCurrentUrl();

		assertTrue(ActualTitle.contains(ExpectedTitle), "User is in dashboard page");
		if((ActualTitle.contains(ExpectedTitle))){

			test.log(Status.PASS,"Successfully logged in and User is in ZIFUI Home Page");

			Thread.sleep(2000);
		}else
		{
			test.log(Status.FAIL, "Login failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		System.out.println("User is in ZIF UI Dashboard Page");

		// Verify all fields in ZIF UI dashboard page
		try {

			new ZIFAIDashboardPage(driver).CheckallfieldsandImages();
			test.log(Status.PASS,"Successfully verified all the fields in the Dashboard Page");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Dashboard page field validdation failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Verify all fields in ZIF UI dashboard page
		try {

			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			test.log(Status.PASS,"Successfully the hover menu is displayed for the Analyzes");
			Thread.sleep(2000);
			new ZIFAIDashboardPage(driver).verifyAnalyzeshovermenufields();
			test.log(Status.PASS,"Successfully verified the fields in the hover menu displayed for Analyzes");
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in hover menu of Analyzes");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		// Verify all fields in ZIF UI Prediction page
		try {

			new ZIFAIDashboardPage(driver).clickPrediction();
			new ZIFAIPredictionPage(driver).checkuserinPredictionPage();
			test.log(Status.PASS,"Successfully the user is in Prediction page");
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
			test.log(Status.PASS,"Successfully verified all fields in Prediction page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction page fields");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		// Verify all fields in ZIF UI Prediction Swim lane
		try {
			new ZIFAIPredictionPage(driver).verifySwinlaneFields();
			test.log(Status.PASS,"Successfully verified all fields Prediction swim lane");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction swim lane fields");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Available Cards in QA Environment

		driver.navigate().refresh();
		Thread.sleep(2000);

		//Predicted Risk (Warning) opportunity cards 
		try { 
			wait1= new WebDriverWait(driver, 5);
			WebElement Card1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-cards warn-state')][1]")));
			if(Card1.isDisplayed()) 
			{ 
				test.log(Status.PASS,"Predicted Risk (Warning) opportunity cards are displayed");

				new ZIFAIPredictionPage(driver).verifyWarningOppcardDetails();
				Thread.sleep(2000);
				test.log(Status.PASS,"Predicted Risk (Warning) opportunity cards fields are verified");

				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfuly verified Predicted Risk (Warning) opportunity cards data flow");

			} }catch (Exception e) { 
				test.log(Status.SKIP,"Predicted Risk (Warning) opportunity cards are Not available"); 
			}

		try {
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'no-data-cls')]")); 
			if(Nodata1.isDisplayed()) 
			{ 
				test.log(Status.PASS,"No Data available is displayed in Predicted Risk (Warning)"); } }catch
		(Exception e) { }


		//Currently at Risk (Critical) opportunity cards 
		try {
			wait1= new WebDriverWait(driver, 5);
			WebElement Card2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-cards critical-state')][1]")));	
			if(Card2.isDisplayed()) 
			{ 
				test.log(Status.
						PASS,"Currently at Risk (Critical) opportunity cards are displayed");

				new ZIFAIPredictionPage(driver).verifyCriticalOppcardDetails();
				Thread.sleep(2000);
				test.log(Status.
						PASS,"Currently at Risk (Critical) opportunity cards fields are verified");

				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfuly verified Currently at Risk (Critical) opportunity cards data flow");
			} 
		}catch (Exception e) { 
			test.log(Status.SKIP,"Currently at Risk (Critical) opportunity cards are Not available"); 
		}

		try { 
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'no-data-cls')]")); 
			if(Nodata1.isDisplayed()) 
			{ 
				test.log(Status.PASS,"No Data available is displayed in Currently at Risk (Critical)");
			}
		}catch (Exception e) { }


		//Processsed opportunity cards 
		try { 
			wait1= new WebDriverWait(driver, 5);
			WebElement Card3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-cards processed-state')][1]")));
			if(Card3.isDisplayed()) {
				test.log(Status.PASS,"Processed opportunity cards are displayed");

				new ZIFAIPredictionPage(driver).verifyProcessedOppcardDetails();

				test.log(Status.PASS,"Processed opportunity cards fields are verified");

				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfuly verified Processed opportunity cards data flow"); }
		}catch
		(Exception e) { 
			test.log(Status.SKIP,"Processed opportunity cards are Not available"); 
		}

		try { 
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'no-data-cls')]"));

			if(Nodata1.isDisplayed()) 
			{
				test.log(Status.PASS,"No Data available is displayed in Processed"); 
			}
		}catch(Exception e) { }


		//Lost opportunity cards
		try {
			wait1= new WebDriverWait(driver, 5);
			WebElement Card4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]")));			
			if(Card4.isDisplayed())
			{
				test.log(Status.PASS,"Lost opportunity cards are displayed");
				new ZIFAIPredictionPage(driver).verifyLostOppcardDetails();
				Thread.sleep(2000);
				test.log(Status.PASS,"Lost opportunity cards fields are verified");
				//driver.navigate().refresh();
				Thread.sleep(2000);
				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfuly verified Lost opportunity cards data flow");
			}
		}catch (Exception e) {
			test.log(Status.SKIP, "Lost opportunity cards are Not available");
		}

		try {					
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'no-data-cls')]"));
			if(Nodata1.isDisplayed())
			{
				test.log(Status.PASS,"No Data available is displayed in Lost");
			}
		}catch (Exception e) {
		}



		//Invalid opportunity cards
		try {
			wait1= new WebDriverWait(driver, 5);
			WebElement Card5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-cards invalid-state')][1]")));
			if(Card5.isDisplayed())
			{
				test.log(Status.PASS,"Invalid opportunity cards are displayed");

				new ZIFAIPredictionPage(driver).verifyInvalidOppcardDetails();
				Thread.sleep(2000);
				test.log(Status.PASS,"Invalid opportunity cards fields are verified");
				//driver.navigate().refresh();
				Thread.sleep(2000);
				WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);

				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);

				test.log(Status.PASS,"Successfuly verified Invalid opportunity cards data flow");
			}
		}catch (Exception e) {
			test.log(Status.SKIP, "Invalid opportunity cards are Not available");
		}

		try {					
			WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'no-data-cls')]"));
			if(Nodata1.isDisplayed())
			{
				test.log(Status.PASS,"No Data available is displayed in Invalid");
			}
		}catch (Exception e) {
		}



		try {
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
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}



				//Verify all fields in Prediction Settings page
				try {
					new ZIFAIPredictionPage(driver).PredictionSettingsfieldvalidation();
					test.log(Status.PASS,"Successfully Verified all the fields in Prediction Settings Page");
				}catch (Exception e) {
					test.log(Status.FAIL, "Prediction Settings Page field validation failed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Verify all fields in Prediction Settings page
				try {
					new ZIFAIPredictionPage(driver).downloadOneAgent();

					test.log(Status.PASS,"Successfully downloaded one agent and verified");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "One Agent download failed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//Select Device Configuration in Prediction Settings page
				try {
					new ZIFAIPredictionPage(driver).Device_Configuration_Tab();
					test.log(Status.PASS,"Successfully clicked on Device Configuration in Prediction Settings Page");
				}catch (Exception e) {
					test.log(Status.FAIL, "Not clicked on Device Configuration");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Verify all fields in Prediction Settings Device configuration page
				try {
					//new ZIFAIPrediction_DeviceConfigPage(driver).selectdevicecheck();
					new ZIFAIPrediction_DeviceConfigPage(driver).Counterconfig_CommonFieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Device configuration page ");
					Thread.sleep(2000);

				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Device configuration page");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				System.out.println("User is in Device config settings page");
				//Verify all fields in Prediction Settings Counter configuration 
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).Counterconfig_FieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Counter configuration");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//Verify all fields in Prediction Settings Counter configuration-CPU
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).CounterconfigCPU_FieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration-CPU");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Counter configuration-CPU");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//Verify all fields in Prediction Settings Counter configuration-DISK
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).CounterconfigDisk_FieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration-DISK");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Counter configuration-DISK");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Verify all fields in Prediction Settings Counter configuration-Memory
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).CounterconfigMemory_FieldValidation();

					test.log(Status.PASS,"Successfully Verified all the fields in the Counter configuration-Memory");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying the fields in Counter configuration-Memory");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Select any device and Save the Selected counters for CPU DISK and Memory

				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterCPU();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully selected devices and saved in Counter configuration-CPU");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed in saving Counter configuration-CPU");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				try {
					//new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterDisk();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully selected devices and saved in Counter configuration-Disk");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed in saving Counter configuration-Disk");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				try {
					//new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).clickcounterMemory();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully selected devices and saved in Counter configuration-Memory");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed in saving Counter configuration-Memory");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}




				//Click on Set Polling Interval and Verify all the fields under Set Polling Interval
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).clickSetpollinginterval();
					new ZIFAIPrediction_DeviceConfigPage(driver).setpollingIntervalFields();

					test.log(Status.PASS,"Successfully Verified all fields in Set Polling Interval");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying fields in Set Polling Interval");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


				//Select any device and select timings for polling
				try {
					//new ZIFAIPrediction_DeviceConfigPage(driver).selectfirstTwodeviceCheckboxs();
					new ZIFAIPrediction_DeviceConfigPage(driver).selectpollingInterval();
					new ZIFAIPrediction_DeviceConfigPage(driver).ClickSave();
					test.log(Status.PASS,"Successfully the polling intervals have been set for the selected devices and Verified");
					Thread.sleep(2000);
					new ZIFAIPrediction_DeviceConfigPage(driver).selectpollingIntervalSetdefault(); 
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying polling interval for the devices");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}



				//Click on Set Polling Interval and Verify all the fields under Threshold configuration
				try {
					new ZIFAIPrediction_DeviceConfigPage(driver).clickThresholdconfig();
					new ZIFAIPrediction_DeviceConfigPage(driver).thresholdconfigFields();

					test.log(Status.PASS,"Successfully Verified all fields in Threshold configuration");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Failed verifying fields in Threshold configuration");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
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
					test.addScreenCaptureFromPath(captureScreenShot(driver));
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
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				//close Settings

				try {
					new ZIFAIPredictionPage(driver).closePredictionsettings();

					test.log(Status.PASS,"Successfully Closed the Prediction settings");
					Thread.sleep(2000);
				}catch (Exception e) {
					test.log(Status.FAIL, "Closing Prediction settings failed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


			}else {
				test.log(Status.FAIL, "Adaptor status is down");
				System.out.println("Adaptor status is down");
			}

		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.WARNING, "Failed or Adaptor status is down");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}



		// Verify Alerts Settings Page
		try {

			new ZIFAI_AlertsSettingsPage(driver).hoveronAnalyzes();
			new ZIFAI_AlertsSettingsPage(driver).clickRawdata();
			new ZIFAI_AlertsSettingsPage(driver).clickalertlink();

			test.log(Status.PASS,"Successfully User is Navigated to Alerts Page");

			//Settings Icon Enabled
			try {
				new ZIFAI_AlertsSettingsPage(driver).alertSettingsEnabled();
				test.log(Status.PASS,"Successfully verified the Alert Settings is Enabled");

				//Click Settings 
				try {						
					new ZIFAI_AlertsSettingsPage(driver).clickSettings();
					test.log(Status.PASS,"Successfully Clicked on the Alert Settings Icon");						
				}catch (AssertionError | Exception e)  {
					test.log(Status.FAIL, "Failed to click settings Icon");
				}

				//Verify fields in Settings page
				try {						
					new ZIFAI_AlertsSettingsPage(driver).Verifyviewsettingspageaccess();
					test.log(Status.PASS,"Successfully Verified all the fields in the Alert Settings Page");
					new ZIFAI_AlertsSettingsPage(driver).Settingsclose();

				}catch (AssertionError | Exception e)  {
					test.log(Status.FAIL, "Failed verifying the fields in Alerts Settings Page");
				}


			}catch (AssertionError | Exception e)  {
				test.log(Status.FAIL, "Settings is Disabled");
			}




		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in Selecting Analytics from Analyzes");

		}
		

//US2537-Alerts-> Settings-> Event Rule Processing-> User With Access to Create new Rule

		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='submenu_ic']")));
			WebElement Hover = driver.findElement(By.xpath("//span[@class='submenu_ic']"));
			Actions actions = new Actions(driver);
			//Mouse hover menuOption 'Example'
			actions.moveToElement(Hover).perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='RawData']")));
			WebElement ClickRawalerts = driver.findElement(By.xpath("//span[text()='RawData']"));
			if (ClickRawalerts.isDisplayed()) {
				Thread.sleep(1000);
				ClickRawalerts.click();
				test.log(Status.PASS, "Rawalerts link is clicked");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Not able to click the Rawalerts link");
			}


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ALERTS']")));
			WebElement Alertstab = driver.findElement(By.xpath("//span[text()='ALERTS']"));
			if (Alertstab.isDisplayed()) {
				Thread.sleep(1000);
				Alertstab.click();
				test.log(Status.PASS, "Alerts tab is clicked");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Not able to click the Alerts tab");
			}


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@ptooltip='Settings']")));
			WebElement Settings = driver.findElement(By.xpath("//div[@ptooltip='Settings']"));
			if (Settings.isDisplayed()) {
				Thread.sleep(1000);
				Settings.click();
				test.log(Status.PASS, "Settings icon is clicked");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Not able to click the Settings icon");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Create new rule'])[1]")));
			WebElement Createrule = driver.findElement(By.xpath("(//span[text()='Create new rule'])[1]"));
			if (Createrule.isDisplayed()) {
				Thread.sleep(1000);
				Createrule.click();
				test.log(Status.PASS, "Create rule icon is clicked");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Not able to click the Create rule icon");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ui-dialog-content ui-widget-content ng-tns-c113-0'])[1]")));
			WebElement Createrulewindow = driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content ng-tns-c113-0'])[1]"));
			if (Createrulewindow.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Create rule window is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Create rule window is not displayed");
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the create rule window");

		}
		try {

			test = extent.createTest("Test Case 3260 - Verify the list of fields are available for the new rule creation");
			test.createNode("Verify the list of fields are available for the new rule creation");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-tns-c123-1 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")));
			WebElement ToolName = driver.findElement(By.xpath("//label[@class='ng-tns-c123-1 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']"));
			if (ToolName.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Tool Name is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Tool Nameis not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-tns-c123-2 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")));
			WebElement ResourceType = driver.findElement(By.xpath("//label[@class='ng-tns-c123-2 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']"));
			if (ResourceType.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Resource Type is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Resource Type is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
			WebElement Rulename = driver.findElement(By.xpath("//input[@id='name']"));
			if (Rulename.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Rule name is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Rule name is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-multiselect-label ui-corner-all ng-tns-c129-3']")));
			WebElement Inventorytype = driver.findElement(By.xpath("//span[@class='ui-multiselect-label ui-corner-all ng-tns-c129-3']"));
			if (Inventorytype.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Inventory type is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Inventory type is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-multiselect-label ui-corner-all ng-tns-c129-4']")));
			WebElement Devicename = driver.findElement(By.xpath("//span[@class='ui-multiselect-label ui-corner-all ng-tns-c129-4']"));
			if (Devicename.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Device name is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Device name is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-tns-c123-5 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")));
			WebElement Rulestatus = driver.findElement(By.xpath("//label[@class='ng-tns-c123-5 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']"));
			if (Rulestatus.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Rule status is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Rule status is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-tns-c123-6 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")));
			WebElement AlertPriority = driver.findElement(By.xpath("//label[@class='ng-tns-c123-6 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']"));
			if (AlertPriority.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Alert Priority is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Alert Priority is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-tns-c123-7 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")));
			WebElement ConsecutiveLimit = driver.findElement(By.xpath("//label[@class='ng-tns-c123-7 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']"));
			if (ConsecutiveLimit.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Consecutive Limit is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Consecutive Limit is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='message']")));
			WebElement Alertmessage = driver.findElement(By.xpath("//textarea[@id='message']"));
			if (Alertmessage.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Alert message is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Alert message is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
			WebElement Ruledescription = driver.findElement(By.xpath("//textarea[@id='description']"));
			if (Ruledescription.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Rule description is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Rule description is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-tns-c123-8 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ui-dropdown-label-empty ng-star-inserted']")));
			WebElement Expression = driver.findElement(By.xpath("//label[@class='ng-tns-c123-8 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ui-dropdown-label-empty ng-star-inserted']"));
			if (Expression.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Expression is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Expression is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-tns-c123-9 ui-dropdown-label ui-inputtext ui-corner-all ui-dropdown-label-empty ng-star-inserted']")));
			WebElement Operator = driver.findElement(By.xpath("//label[@class='ng-tns-c123-9 ui-dropdown-label ui-inputtext ui-corner-all ui-dropdown-label-empty ng-star-inserted']"));
			if (Operator.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Operator is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Operator is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-tns-c123-10 ui-dropdown-label ui-inputtext ui-corner-all ui-dropdown-label-empty ng-star-inserted']")));
			WebElement Value = driver.findElement(By.xpath("//label[@class='ng-tns-c123-10 ui-dropdown-label ui-inputtext ui-corner-all ui-dropdown-label-empty ng-star-inserted']"));
			if (Value.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Value is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Value is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-tns-c123-11 ui-dropdown-label ui-inputtext ui-corner-all ui-dropdown-label-empty ng-star-inserted']")));
			WebElement Logicaloperator = driver.findElement(By.xpath("//label[@class='ng-tns-c123-11 ui-dropdown-label ui-inputtext ui-corner-all ui-dropdown-label-empty ng-star-inserted']"));
			if (Logicaloperator.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Logical operator is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Logical operator is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Validate Rule']")));
			WebElement Validaterule = driver.findElement(By.xpath("//span[text()='Validate Rule']"));
			if (Validaterule.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Validate rule button is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Validate rule button is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save']")));
			WebElement Save = driver.findElement(By.xpath("//span[text()='Save']"));
			if (Save.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Save button is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Save button is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Cancel']")));
			WebElement Cancel = driver.findElement(By.xpath("//span[text()='Cancel']"));
			if (Cancel.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Cancel button is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Cancel button is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Create new rule']")));
			WebElement Createnewrule = driver.findElement(By.xpath("//span[text()='Create new rule']"));
			if (Createnewrule.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Create new rule header is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Create new rule header is not displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-tns-c113-0 pi pi-times']")));
			WebElement Closeicon = driver.findElement(By.xpath("//span[@class='ng-tns-c113-0 pi pi-times']"));
			if (Closeicon.isDisplayed()) {
				Thread.sleep(1000);
				test.log(Status.PASS, "Close icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Close icon is not displayed");
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the create rule window grids");

		}

//			Test Case 3672
		try {
			test = extent.createTest("Test Case 3672 - Verify whether the user is able to see the Resource types under Resource type drop down");
			test.createNode("Verify whether the user is able to see the Resource types under Resource type drop down");

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='--Resource Type--']")));
			WebElement Resourcedropdown = driver.findElement(By.xpath("//label[text()='--Resource Type--']"));
			Thread.sleep(1000);
			Resourcedropdown.click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p-dropdownitem[@class='ng-tns-c123-2 ng-star-inserted']/li")));
			List<WebElement> Resource_Type = driver.findElements(By.xpath("//p-dropdownitem[@class='ng-tns-c123-2 ng-star-inserted']/li"));
			String Cpu = "cpu";
			String Disk = "disk";
			String Memory = "memory";
			String Network = "network";
			System.out.println("Number of elements:" + Resource_Type.size());

			for (int i = 0; i < Resource_Type.size(); i++) {
				String ResourceTypevalues = Resource_Type.get(i).getAttribute("aria-label");
				System.out.println("Resource Type value is:" + ResourceTypevalues);
				if (ResourceTypevalues.equals(Cpu) || ResourceTypevalues.equals(Disk) || ResourceTypevalues.equals(Memory) || ResourceTypevalues.equals(Network)) {
					test.log(Status.PASS, "ResourceType" + "\t" + ResourceTypevalues + "\t" + "is displayed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "ResourceType" + "\t" + ResourceTypevalues + "\t" + "is not displayed");
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the resource types");

		}

//				Test Case 3767
		try {
			test = extent.createTest("Test Case 3767 - Verify whether the user is able to see the rule status under rule status drop down");
			test.createNode("Verify whether the user is able to see the rule status under rule status drop down");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='--Rule Status--']")));
			WebElement Rulestatusdropdown = driver.findElement(By.xpath("//label[text()='--Rule Status--']"));
			Thread.sleep(1000);
			Rulestatusdropdown.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p-dropdownitem[@class='ng-tns-c123-5 ng-star-inserted']/li")));
			List<WebElement> Rule_status = driver.findElements(By.xpath("//p-dropdownitem[@class='ng-tns-c123-5 ng-star-inserted']/li"));
			String Active = "Active";
			String Inactive = "InActive";

			System.out.println("Number of elements:" + Rule_status.size());

			for (int i = 0; i < Rule_status.size(); i++) {
				String Rulestatusvalues = Rule_status.get(i).getAttribute("aria-label");
				System.out.println("Rule status is:" + Rulestatusvalues);
				if (Rulestatusvalues.equals(Active) || Rulestatusvalues.equals(Inactive)) {
					test.log(Status.PASS, "Rule status" + "\t" + Rulestatusvalues + "\t" + "is displayed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Rule status" + "\t" + Rulestatusvalues + "\t" + "is not displayed");
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the rule status");

		}
//				Test Case 3768
		try {
			test = extent.createTest("Test Case 3768 - Verify whether the user is able to see the alert priorities under alert priority drop down");
			test.createNode("Verify whether the user is able to see the alert priorities under alert priority drop down");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='--Alert Priority--']")));
			WebElement alertprioritydropdown = driver.findElement(By.xpath("//label[text()='--Alert Priority--']"));
			Thread.sleep(1000);
			alertprioritydropdown.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p-dropdownitem[@class='ng-tns-c123-6 ng-star-inserted']/li")));
			List<WebElement> alertpriority = driver.findElements(By.xpath("//p-dropdownitem[@class='ng-tns-c123-6 ng-star-inserted']/li"));
			String Critical = "Critical";
			String High = "High";
			String Medium = "Medium";
			String Low = "Low";
			System.out.println("Number of elements:" + alertpriority.size());

			for (int i = 0; i < alertpriority.size(); i++) {
				String alertpriorityvalues = alertpriority.get(i).getAttribute("aria-label");
				System.out.println("Alert priority value is:" + alertpriorityvalues);
				if (alertpriorityvalues.equals(Critical) || alertpriorityvalues.equals(High) || alertpriorityvalues.equals(Medium) || alertpriorityvalues.equals(Low)) {
					test.log(Status.PASS, "Alert priority" + "\t" + alertpriorityvalues + "\t" + "is displayed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Alert priority" + "\t" + alertpriorityvalues + "\t" + "is not displayed");
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the Alert priority");

		}

//				Test Case 3769
		try {
			test = extent.createTest("Test Case 3769 - Verify whether the user is able to see the consecutive limits under consecutive limit drop down");
			test.createNode("Verify whether the user is able to see the consecutive limits under consecutive limit drop down");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='--Consecutive Limit--']")));
			WebElement alertpriority_dropdown = driver.findElement(By.xpath("//label[text()='--Consecutive Limit--']"));
			Thread.sleep(1000);
			alertpriority_dropdown.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p-dropdownitem[@class='ng-tns-c123-7 ng-star-inserted']/li")));
			List<WebElement> consecutivelimit = driver.findElements(By.xpath("//p-dropdownitem[@class='ng-tns-c123-7 ng-star-inserted']/li"));
			String consecutivelimitone = "1";
			String consecutivelimittwo = "2";
			String consecutivelimitthree = "3";
			String consecutivelimitfour = "4";
			String consecutivelimitfive = "5";
			String consecutivelimitsix = "6";
			String consecutivelimitseven = "7";
			String consecutivelimiteight = "8";
			String consecutivelimitnine = "9";
			String consecutivelimitten = "10";
			System.out.println("Number of elements:" + consecutivelimit.size());

			for (int i = 0; i < consecutivelimit.size(); i++) {
				String consecutivelimitvalues = consecutivelimit.get(i).getAttribute("aria-label");
				System.out.println("consecutive limit value is:" + consecutivelimitvalues);
				if (consecutivelimitvalues.equals(consecutivelimitone) || consecutivelimitvalues.equals(consecutivelimittwo) || consecutivelimitvalues.equals(consecutivelimitthree) || consecutivelimitvalues.equals(consecutivelimitfour) || consecutivelimitvalues.equals(consecutivelimitfive) || consecutivelimitvalues.equals(consecutivelimitsix) || consecutivelimitvalues.equals(consecutivelimitseven) || consecutivelimitvalues.equals(consecutivelimiteight) || consecutivelimitvalues.equals(consecutivelimitnine) || consecutivelimitvalues.equals(consecutivelimitten)) {
					test.log(Status.PASS, "consecutive limit" + "\t" + consecutivelimitvalues + "\t" + "is displayed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "consecutive limit" + "\t" + consecutivelimitvalues + "\t" + "is not displayed");
				}
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the consecutive limit");

		}
try{
	test = extent.createTest("Test Case 3771 - Verify whether the user is able to see the operators under operators drop down");
	test.createNode("Verify whether the user is able to see the operators under operators drop down");
	WebDriverWait wait = new WebDriverWait(driver, 20);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-dropdown-label-container ng-tns-c123-9']")));
	WebElement Operatorsdropdown = driver.findElement(By.xpath("//div[@class='ui-dropdown-label-container ng-tns-c123-9']"));
	Thread.sleep(1000);
	Operatorsdropdown.click();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p-dropdownitem[@class='ng-tns-c123-9 ng-star-inserted']/li")));
	List<WebElement> Operators= driver.findElements(By.xpath("//p-dropdownitem[@class='ng-tns-c123-9 ng-star-inserted']/li"));
	String Lessthan = "Less than";
	String Greaterthan = "Greater than";
	String Equalt = "Equalt";

	System.out.println("Number of elements:" +Operators.size());

	for (int i=1; i<Operators.size();i++){
		String Operatorsvalues = Operators.get(i).getAttribute("aria-label");
		System.out.println("Operators value is:"+Operatorsvalues);
		if(Operatorsvalues.equals(Lessthan) || Operatorsvalues.equals(Greaterthan) || Operatorsvalues.equals(Equalt) )
		{
			test.log(Status.PASS, "Operators" +"\t"+Operatorsvalues+"\t"+ "is displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} else {
			test.log(Status.FAIL, "Operators" +"\t"+Operatorsvalues+"\t"+ "is not displayed");
		}
	}
} catch (AssertionError | Exception e) {
	test.log(Status.FAIL, "Unable to verify the operators");

}

try{
	test = extent.createTest("Test Case 3774 - Verify whether the user is able to see the values under value drop down");
	test.createNode("Verify whether the user is able to see the values under value drop down");
	WebDriverWait wait = new WebDriverWait(driver, 20);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-dropdown-label-container ng-tns-c123-10']")));
	WebElement Valuedropdown = driver.findElement(By.xpath("//div[@class='ui-dropdown-label-container ng-tns-c123-10']"));
	Thread.sleep(1000);
	Valuedropdown.click();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p-dropdownitem[@class='ng-tns-c123-10 ng-star-inserted']/li")));
	List<WebElement> Valuedropdownvalue= driver.findElements(By.xpath("//p-dropdownitem[@class='ng-tns-c123-10 ng-star-inserted']/li"));
	String Value10 = "10";
	String Value20= "20";
	String Value30= "30";
	String Value40="40";
	String Value50="50";
	String Value60="60";
	String Value70 ="70";
	String Value80= "80";
	String Value90 ="90";
	String Value100 ="100";
	System.out.println("Number of elements:" +Valuedropdownvalue.size());

	for (int i=1; i<Valuedropdownvalue.size();i++){
		String Valuedropdownvaluevalues = Valuedropdownvalue.get(i).getAttribute("aria-label");
		System.out.println("Value is:"+Valuedropdownvaluevalues);
		if(Valuedropdownvaluevalues.equals(Value10) || Valuedropdownvaluevalues.equals(Value20) || Valuedropdownvaluevalues.equals(Value30) || Valuedropdownvaluevalues.equals(Value40) || Valuedropdownvaluevalues.equals(Value50) || Valuedropdownvaluevalues.equals(Value60) || Valuedropdownvaluevalues.equals(Value70) || Valuedropdownvaluevalues.equals(Value80) || Valuedropdownvaluevalues.equals(Value90) || Valuedropdownvaluevalues.equals(Value100))
		{
			test.log(Status.PASS, "Value" +"\t"+Valuedropdownvaluevalues+"\t"+ "is displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} else {
			test.log(Status.FAIL, "Value" +"\t"+Valuedropdownvaluevalues+"\t"+ "is not displayed");
		}
	}
} catch (AssertionError | Exception e) {
	test.log(Status.FAIL, "Unable to verify the Values");

}
try{
	test = extent.createTest("Test Case 3776 - Validate whether the user is able to add one or more expression fields");
	test.createNode("Validate whether the user is able to add one or more expression fields");
	WebDriverWait wait = new WebDriverWait(driver, 20);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='p-button-icon pi pi-plus']")));
	WebElement Expressionplusicon = driver.findElement(By.xpath("//i[@class='p-button-icon pi pi-plus']"));
	Thread.sleep(1000);
	Expressionplusicon.click();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='add-1']")));
	WebElement Additionalexpressionfield = driver.findElement(By.xpath("//button[@id='add-1']"));

	if (Additionalexpressionfield.isDisplayed()) {
		Thread.sleep(1000);
		test.log(Status.PASS, "Additional expression field is displayed");
		test.addScreenCaptureFromPath(captureScreenShot(driver));
	} else {
		test.log(Status.FAIL, "Additional expression field is not displayed");
	}

} catch (AssertionError | Exception e) {
	test.log(Status.FAIL, "Unable to verify the expression plus icon");

}
try{
	test = extent.createTest("Test Case 3800 - Verify whether the user is able to see the invalid logic applied in create new rule screen");
	test.createNode("Verify whether the user is able to see the invalid logic applied in create new rule screen");
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Validate Rule']")));
	WebElement Validate_rule = driver.findElement(By.xpath("//span[text()='Validate Rule']"));
	if (Validate_rule.isDisplayed()) {
		Thread.sleep(2000);
		Validate_rule.click();
		System.out.println("Displayed");
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid logic applied']")));
	WebElement Errormessage = driver.findElement(By.xpath("//span[text()='Invalid logic applied']"));
	if (Errormessage.isDisplayed()) {
		Thread.sleep(2000);
		test.log(Status.PASS, "Invalid logic applied error message is displayed");
		test.addScreenCaptureFromPath(captureScreenShot(driver));
	} else {
		test.log(Status.FAIL, "Invalid logic applied error message is not displayed");
	}
} catch (AssertionError | Exception e) {
	test.log(Status.FAIL, "unable to validate the error message");
	test.addScreenCaptureFromPath(captureScreenShot(driver));

}

	

		//------------------------------------------------------------



		//Logout of Application
		try {
			new ZIFAIDashboardPage(driver).LogoutClick();
			test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
		}catch (Exception e) {
			test.log(Status.FAIL, "Dashboard page Logout failed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


	}}

