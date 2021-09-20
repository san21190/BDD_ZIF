package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.mongodb.client.FindIterable;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.MongoQueryManager;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Discovery_US3321_Regression extends Base {

	//	PropertiesFileReader obj = new PropertiesFileReader();
	//	Properties properties = null;
	//	CommonMethods cm = null;


	@Test
	public void ZIFUI_Discovery_US3321_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("User Story 3321: ZIF Discovery - List Discovery - Expand/Collapse");
		test.createNode("User Story 3321: ZIF Discovery - List Discovery - Expand/Collapse");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


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

		//click on the Raw data link
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickRawData();
			test.log(Status.PASS, "Raw data link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Raw data link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).alertSettingsIcon.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("GTMDICV500");
			Thread.sleep(3000);
			Boolean Discoverystatus = new ZIFAI_AlertsSettingsPage(driver).Discoverygid.isDisplayed();
			if (Discoverystatus == true) {
				new ZIFAI_AlertsSettingsPage(driver).Discoverygid.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clicked on setting icon for loading discovery page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Discoverystatus == false) {
				test.log(Status.FAIL, "Unable to load discovery page by clicking on setting icon");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to load discovery page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//---------------------------------------End of US---------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3269: UI-Verify Expand/Collapse Discovery Details");
		test.createNode("Test Case 3269: UI-Verify Expand/Collapse Discovery Details");

		//Device list LHS should update the devices when  scroll down//
		try {
			Thread.sleep(3000);
			List<WebElement> Device_stat = new ZIFAI_AlertsSettingsPage(driver).listofdiscoveryLHS;
			List<WebElement> Device_status = new ZIFAI_AlertsSettingsPage(driver).listofdiscoveryLHS;
			int i;
			for ( i= 0; i<Device_stat.size(); i=i+1) {
				String devicedetail = Device_status.get(i).getText();
				System.out.println("Device list LHS:" + devicedetail);
				if (!devicedetail.isEmpty()) {
					System.out.println("Device list LHS verified and scrolled : " +devicedetail);
				} }
			test.log(Status.PASS, "Device list LHS verified and scrolled ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to verify Device List in LHS");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, "End of Verification for Device List in LHS");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Device detail list RHS should update the devices when  scroll down//
		try {
			Thread.sleep(3000);
			List<WebElement> casestatus = driver.findElements(By.xpath("//div[contains(@class,'dev-link')]"));
			List<WebElement> case_status = driver.findElements(By.xpath("//div[contains(@class,'dev-link')]"));
			int i;
			for ( i= 0; i<casestatus.size(); i=i+1) {
				System.out.println(casestatus.size());
				Actions action = new Actions(driver);
				Thread.sleep(2000);
				action.moveToElement(case_status.get(i)).perform();
				String Casestatustooltip = case_status.get(i).getText();
				System.out.println("Device detail list: " + Casestatustooltip);
				if (!Casestatustooltip.isEmpty()) {
					System.out.println("Device list verified and scrolled in RHS : " +Casestatustooltip);

				} }
			test.log(Status.PASS, "Device list verified and scrolled in RHS ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to verify Device List in RHS");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, "End of Verification for Device List in RHS");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on Expand view//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Expand.click();
			Thread.sleep(3000);
			String strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Rightpanel.getAttribute("style");
			System.out.println("Right panel width: " +strvalue);
			if(strvalue.contains("100%")){
				test.log(Status.PASS, "Right panel is expanded and list of discovery is hidden");
			}
			else if(!strvalue.contains("100%")) {
				test.log(Status.FAIL, "Right panel is not expanded and list of discovery is not hidden");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on expand");
		}

		//Verifying whether collapsed button is displayed//
		try{
			Thread.sleep(3000);
			Boolean strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Collapse.isDisplayed();
			if(strvalue==true){
				test.log(Status.PASS, "Discovery details panel is expanded and the button has changed to collapse");
			}
			else if(strvalue==false) {
				test.log(Status.FAIL, "Discovery details panel is expanded and the button has not changed to collapse");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to expand button changing to collapse button during expand mode");
		}

		//Click on collapse and verify the discovery title//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Collapse.click();
			Boolean listofdisc = new ZIFAI_AlertsSettingsPage(driver).listofdiscoverytitle.isDisplayed();
			if(listofdisc==true){
				test.log(Status.PASS, "Discovery details panel is collapse and list of discoveries is visible");
			}
			else if(listofdisc==false) {
				test.log(Status.FAIL, "Discovery details panel is not collapsed and list of discoveries is not visible");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
		}

		//Device list LHS should update the devices when scroll down after clicking on collapse button//
		try {
			Thread.sleep(3000);
			List<WebElement> Device_stat = new ZIFAI_AlertsSettingsPage(driver).listofdiscoveryLHS;
			List<WebElement> Device_status = new ZIFAI_AlertsSettingsPage(driver).listofdiscoveryLHS;
			int i;
			for ( i= 0; i<Device_stat.size(); i=i+1) {
				String devicedetail = Device_status.get(i).getText();
				System.out.println("Device list LHS:" + devicedetail);
				if (!devicedetail.isEmpty()) {
					System.out.println("Device list LHS verified and scrolled after collapse mode : " +devicedetail);
				} }
			test.log(Status.PASS, "Device list LHS verified and scrolled after collapse mode ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to verify Device List in LHS after collapse mode");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, "End of Verification for Device List in LHS after collapse mode");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify close icon is displayed after clicking on collapse icon//
		try{
			Thread.sleep(3000);
			Boolean Backtodiscovery = new ZIFAI_AlertsSettingsPage(driver).Backtodiscoverylist.isDisplayed();

			if(Backtodiscovery==true){
				test.log(Status.PASS, "Close icon is displayed reverting back to collapsed mode");
			}
			else if(Backtodiscovery==false) {
				test.log(Status.FAIL, "Close icon is not displayed reverting back to collapsed mode");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify close icon after clicking on collapse mode");
		}

		//Signing out to verify another test case//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
		Thread.sleep(3000);
		new ZIFAI_AlertsSettingsPage(driver).Logout.click();
		Thread.sleep(3000);
		test.log(Status.PASS, "Close icon is clicked and successfully signed out");
		}
	catch (Exception e) {
		test.log(Status.FAIL, "Unable to sign out for another scenario");
		}

		//--------------------------------------------End of US-----------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3735: UI-Discovery Expand/Collapse -Verify close icon");
		test.createNode("Test Case 3735: UI-Discovery Expand/Collapse -Verify close icon");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


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

		//click on the Raw data link
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickRawData();
			test.log(Status.PASS, "Raw data link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Raw data link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).alertSettingsIcon.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("GTMDICV500");
			Thread.sleep(3000);
			Boolean Discoverystatus = new ZIFAI_AlertsSettingsPage(driver).Discoverygid.isDisplayed();
			if (Discoverystatus == true) {
				new ZIFAI_AlertsSettingsPage(driver).Discoverygid.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clicked on setting icon for loading discovery page for another scenario");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Discoverystatus == false) {
				test.log(Status.FAIL, "Unable to load discovery page by clicking on setting icon for another scenario");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to load discovery page for another scenario");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Device list LHS should update the devices when  scroll down//
		try {
			Thread.sleep(3000);
			List<WebElement> Device_stat = new ZIFAI_AlertsSettingsPage(driver).listofdiscoveryLHS;
			List<WebElement> Device_status = new ZIFAI_AlertsSettingsPage(driver).listofdiscoveryLHS;
			int i;
			for ( i= 0; i<Device_stat.size(); i=i+1) {
				String devicedetail = Device_status.get(i).getText();
				System.out.println("Device list LHS:" + devicedetail);
				if (!devicedetail.isEmpty()) {
					System.out.println("Device list in LHS verified and scrolled : " +devicedetail);
				} }
			test.log(Status.PASS, "Device list in LHS verified and scrolled ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to verify Device List in LHS");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, "End of Verification for Device List in LHS");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Device detail list RHS should update the devices when  scroll down//
		try {
			Thread.sleep(3000);
			List<WebElement> casestatus = driver.findElements(By.xpath("//div[contains(@class,'dev-link')]"));
			List<WebElement> case_status = driver.findElements(By.xpath("//div[contains(@class,'dev-link')]"));
			int i;
			for ( i= 0; i<casestatus.size(); i=i+1) {
				System.out.println(casestatus.size());
				Actions action = new Actions(driver);
				Thread.sleep(2000);
				action.moveToElement(case_status.get(i)).perform();
				String Casestatustooltip = case_status.get(i).getText();
				System.out.println("Device detail list: " + Casestatustooltip);
				if (!Casestatustooltip.isEmpty()) {
					System.out.println("Device list verified and scrolled in RHS : " +Casestatustooltip);

				} }
			test.log(Status.PASS, "Device list verified and scrolled in RHS ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to verify Device List in RHS");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, "End of Verification for Device List in RHS");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on Expand view//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Expand.click();
			Thread.sleep(3000);
			String strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Rightpanel.getAttribute("style");
			System.out.println("Right panel width: " +strvalue);
			if(strvalue.contains("100%")){
				test.log(Status.PASS, "Right panel is expanded and list of discovery is hidden");
			}
			else if(!strvalue.contains("100%")) {
				test.log(Status.FAIL, "Right panel is not expanded and list of discovery is not hidden");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on expand");
		}

		//Verifying whether collapsed button is displayed//
		try{
			Thread.sleep(3000);
			Boolean strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Collapse.isDisplayed();
			if(strvalue==true){
				test.log(Status.PASS, "Discovery details panel is expanded and the button has changed to collapse");
			}
			else if(strvalue==false) {
				test.log(Status.FAIL, "Discovery details panel is expanded and the button has not changed to collapse");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to expand button changing to collapse button during expand mode");
		}

		//Click on collapse and verify the discovery title//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Collapse.click();
			Boolean listofdisc = new ZIFAI_AlertsSettingsPage(driver).listofdiscoverytitle.isDisplayed();
			if(listofdisc==true){
				test.log(Status.PASS, "Discovery details panel is collapse and list of discoveries is visible");
			}
			else if(listofdisc==false) {
				test.log(Status.FAIL, "Discovery details panel is not collapsed and list of discoveries is not visible");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
		}
		//--------------------------------------------End of US------------------------------------------//

	}
	}
