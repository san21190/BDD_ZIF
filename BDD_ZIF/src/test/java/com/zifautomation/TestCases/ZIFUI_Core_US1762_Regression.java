package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.*;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.PropertiesFileReader;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Core_US1762_Regression extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;
	CommonMethods cm = null;


	@Test
	public void ZIFUI_AnP_US1762_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("User Story 1762: Alerts - Preferences for raw alerts");
		test.createNode("User Story 1762: Alerts - Preferences for raw alerts");
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

		//click on the analytics link
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickRawData();
			test.log(Status.PASS, "Raw data link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Raw data link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clearing filter and preference values//
		try{
			new ZIFAI_AlertsSettingsPage(driver).alertsLink.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceToolname("");
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the values in Preference and Filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to clear values in filter and preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Report Initialization
		test = extent.createTest("Test Case 2361: UI - 1762 - Verify the presence of Preferences icon in Raw Alerts screen");
		test.createNode("Test Case 2361: UI - 1762 - Verify the presence of Preferences icon in Raw Alerts screen");

		//Mouse hover the filter and verify the tool tip//
		try{
			Thread.sleep(3000);
			Actions actioncaseto = new Actions(driver);
			actioncaseto.moveToElement(new ZIFAI_AlertsSettingsPage(driver).prefereceIcon).perform();
			Thread.sleep(4000);
			WebElement desc_corr = driver.findElement(By.cssSelector(".ui-tooltip"));
			String corr = desc_corr.getText();
			System.out.println("When hovered on Preferences the text displayed is: " + corr);
			if (corr.equalsIgnoreCase("Preferences")) {
				test.log(Status.PASS, "Preferences text is matching as when hovered on Preferences tooltip");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Preferences text is not matching as when hovered on tooltip");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover on preferences tooltip");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click the Preferences icon and ensure the "i" is denoted in the tool name name options
		try{
			new ZIFAI_AlertsSettingsPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			Actions actioncaseto = new Actions(driver);
			actioncaseto.moveToElement(new ZIFAI_AlertsSettingsPage(driver).Toolnameihover).perform();
			Thread.sleep(4000);
			WebElement desc_corr = driver.findElement(By.cssSelector(".ui-tooltip"));
			String corr = desc_corr.getText();
			System.out.println("When hovered on Tool name the text displayed is: " + corr);
			if (corr.equalsIgnoreCase("Format E.g.- Tool Name 1,Tool Name 2")) {
				test.log(Status.PASS, "Format E.g.- Tool Name 1,Tool Name 2 is denoted in the tool name (i) options");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Tool name (i) is not matching in the preference");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover on tool name (i)");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click the Preferences icon and ensure the "i" is denoted in device name options
		try{
			new ZIFAI_AlertsSettingsPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			Actions actioncaseto = new Actions(driver);
			actioncaseto.moveToElement(new ZIFAI_AlertsSettingsPage(driver).Devicenameihover).perform();
			Thread.sleep(4000);
			WebElement desc_corr = driver.findElement(By.cssSelector(".ui-tooltip"));
			String corr = desc_corr.getText();
			System.out.println("When hovered on Device name the text displayed is: " + corr);
			if (corr.equalsIgnoreCase("Format E.g.- Device Name 1,Device Name 2")) {
				test.log(Status.PASS, "Format E.g.- Device Name 1,Device Name 2 is denoted in the Device name (i) options");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Device name (i) is not matching in the preference");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAI_AlertsSettingsPage(driver).Prefcancel.click();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover on tool name (i)");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-----------------------------------------End of US------------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 2362: Functional - 1762 - Verify the Preferences options by applying the valid inputs");
		test.createNode("Test Case 2362: Functional - 1762 - Verify the Preferences options by applying the valid inputs");
		//Provide any "Tool Name" in filter settings and Click Apply button
		//Apply single or more than one tool by comma separation
		try{
			String tlname = new ZIFAI_AlertsSettingsPage(driver).Toolnametext.getText();
			Thread.sleep(3000);
			System.out.println("Tool name which is extracted from the list before filter "+tlname);
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceToolname(tlname);
			Thread.sleep(3000);
			String tlnameend = new ZIFAI_AlertsSettingsPage(driver).Toolnametext.getText();
			Thread.sleep(3000);
			String Srchcntd = new ZIFAI_AlertsSettingsPage(driver).Searchcount.getText().replace("(","").replace(")","").replace("All","").trim();
			System.out.println("Tool name which is extracted from the list after filter "+ tlname + Srchcntd);
			if(tlname.equalsIgnoreCase(tlnameend)){
				test.log(Status.PASS, "Tool name is filtered appropriately and verified with the count "+Srchcntd);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(!tlname.equalsIgnoreCase(tlnameend)){
				test.log(Status.FAIL, "Tool name is not filtered appropriately");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		Boolean prefval = new ZIFAI_AlertsSettingsPage(driver).prefereceIconwithdots.isDisplayed();
			if(prefval==true){
				test.log(Status.PASS, "Verified that indication mark is displayed on the preference icon after applying tool name");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(prefval==false){
				test.log(Status.FAIL, "Verified that indication mark is not displayed on the preference icon after applying tool name");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to filter tool name and validate " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Provide any Device Name and press Apply
		//Apply single or more than one tool by comma separation
		try{
			String Dname = new ZIFAI_AlertsSettingsPage(driver).Devicenametext.getText();
			Thread.sleep(3000);
			System.out.println("Device name which is extracted from the list before filter "+Dname);
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceDevicename(Dname);
			Thread.sleep(3000);
			String Dnameend = new ZIFAI_AlertsSettingsPage(driver).Devicenametext.getText();
			Thread.sleep(3000);
			String Srchcnt = new ZIFAI_AlertsSettingsPage(driver).Searchcount.getText().replace("(","").replace(")","").replace("All","").trim();
			System.out.println("Device name which is extracted from the list after filter "+ Dname + Srchcnt);
			if(Dname.equalsIgnoreCase(Dnameend)){
				test.log(Status.PASS, "Device name is filtered appropriately and verified with the count "+Srchcnt);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(!Dname.equalsIgnoreCase(Dnameend)){
				test.log(Status.FAIL, "Device name is not filtered appropriately");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean prefvald = new ZIFAI_AlertsSettingsPage(driver).prefereceIconwithdots.isDisplayed();
			if(prefvald==true){
				test.log(Status.PASS, "Verified that indication mark is displayed on the preference icon after applying Device name");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(prefvald==false){
				test.log(Status.FAIL, "Verified that indication mark is not displayed on the preference icon after applying Device name");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to filter Device name and validate " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Provide any Device Name and press Apply
		//Apply single or more than one tool by comma separation
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceSeverityname("Critical");
			Thread.sleep(3000);
			Boolean Severityval = new ZIFAI_AlertsSettingsPage(driver).Severitytext.isDisplayed();
			Thread.sleep(3000);
			String Srchcnt = new ZIFAI_AlertsSettingsPage(driver).Searchcount.getText().replace("(","").replace(")","").replace("All","").trim();
			System.out.println("Severity is displayed after filter "+ Severityval + Srchcnt);
			if(Severityval==true){
				test.log(Status.PASS, "Critical severity is filtered appropriately and verified with the count "+Srchcnt);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(!Severityval==false){
				test.log(Status.FAIL, "Critical severity is not filtered appropriately");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean prefvald = new ZIFAI_AlertsSettingsPage(driver).prefereceIconwithdots.isDisplayed();
			if(prefvald==true){
				test.log(Status.PASS, "Verified that indication mark is displayed on the preference icon after applying severity");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(prefvald==false){
				test.log(Status.FAIL, "Verified that indication mark is not displayed on the preference icon after applying severity");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to filter Critical severity and validate " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click the Cancel button
		//The given search details should not be saved and Search results should reload and display the previous results along with the count.
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceSeverityname("");
			Thread.sleep(7000);
			new ZIFAI_AlertsSettingsPage(driver).inventoryLink.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).alertsLink.click();
			Thread.sleep(5000);
			String Srchcntfirst = new ZIFAI_AlertsSettingsPage(driver).Searchcount.getText().replace("(","").replace(")","").replace("All","").trim();
			Thread.sleep(3000);
			System.out.println("Search count before validation " +Srchcntfirst);
			new ZIFAI_AlertsSettingsPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).PrefAlertseverity.sendKeys("High");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Prefcancel.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			String status_valuepr = new ZIFAI_AlertsSettingsPage(driver).PrefAlertseverity.getAttribute("value");
			if(status_valuepr.isEmpty()){
				test.log(Status.PASS, "Clicking cancel doesn't retain the value when reopened");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "Clicking cancel retain the value when reopened");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAI_AlertsSettingsPage(driver).Prefcancel.click();
			Thread.sleep(3000);
			String Srchcntsecond = new ZIFAI_AlertsSettingsPage(driver).Searchcount.getText().replace("(","").replace(")","").replace("All","").trim();
			System.out.println("Search count after validation " +Srchcntsecond);
			if(Srchcntfirst.equals(Srchcntsecond)){
				test.log(Status.PASS, "Search count remains same during the validation");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(!Srchcntfirst.equals(Srchcntsecond)){
				test.log(Status.FAIL, "Search count doesn't remain same during the validation");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify after cancel operation and search count " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Logout the application, re-login and Ensure the preferences set by the user is not removed.
		//Navigate to other menus and Ensure the preferences set by the user is not removed once back to the raw alerts screen
		try{
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceSeverityname("High");
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Logout.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Successfully entered value in severity and loggedout");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to enter value in severity and logout " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Login to the ZIFAI Portal With valid credentials//

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

		//click on the analytics link
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickRawData();
			test.log(Status.PASS, "Raw data link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Raw data link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clearing filter and preference values//
		try {
			new ZIFAI_AlertsSettingsPage(driver).alertsLink.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			String status_valueprd = new ZIFAI_AlertsSettingsPage(driver).PrefAlertseverity.getAttribute("value");
			if (status_valueprd.equalsIgnoreCase("High")) {
				test.log(Status.PASS, "Severity references set by the user is not removed once back to the raw alerts screen");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "preferences set by the user is removed once back to the raw alerts screen");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAI_AlertsSettingsPage(driver).Prefcancel.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the preference set by the user after logout");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-----------------------------------End of US------------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 2363: Functional - 1762 - Verify the Preferences options by applying the invalid inputs");
		test.createNode("Test Case 2363: Functional - 1762 - Verify the Preferences options by applying the invalid inputs");

		//Screen should reload and "No Data Found" message should be displayed when providing invalid data in preference//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceSeverityname("");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceToolname("jjjjjjjj");
			Thread.sleep(3000);
			Boolean bldta = new ZIFAI_AlertsSettingsPage(driver).Nodatafound.isDisplayed();
			String Srchcntd = new ZIFAI_AlertsSettingsPage(driver).Searchcount.getText().replace("(","").replace(")","").replace("All","").trim();
			System.out.println("Status of Nodatafound : " +bldta);
			System.out.println("Total count of toolname " +Srchcntd);
			if(bldta==true){
				test.log(Status.PASS, "When invalid data is provided in Tool name no data found is displayed and the count is "+Srchcntd);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(bldta==false){
				test.log(Status.FAIL, "Nodata found is not displayed when invalid data is provided in toolname");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify nodatafound when invalid tool name is provided " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceDevicename("tlvljk");
			Thread.sleep(3000);
			Boolean dbdta = new ZIFAI_AlertsSettingsPage(driver).Nodatafound.isDisplayed();
			String Srchcntd = new ZIFAI_AlertsSettingsPage(driver).Searchcount.getText().replace("(","").replace(")","").replace("All","").trim();
			System.out.println("Status of Nodatafound : " +dbdta);
			System.out.println("Total count of device name " +Srchcntd);
			if(dbdta==true){
				test.log(Status.PASS, "When invalid data is provided in Device name no data found is displayed and the count is "+Srchcntd);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(dbdta==false){
				test.log(Status.FAIL, "Nodata found is not displayed when invalid data is provided in device name");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify nodatafound when invalid device name is provided " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		try{
			new ZIFAI_AlertsSettingsPage(driver).ClearPreferenceSeverityname("asddjjk");
			Thread.sleep(3000);
			Thread.sleep(3000);
			Boolean svdtat = new ZIFAI_AlertsSettingsPage(driver).Nodatafound.isDisplayed();
			String Srchcntd = new ZIFAI_AlertsSettingsPage(driver).Searchcount.getText().replace("(","").replace(")","").replace("All","").trim();
			System.out.println("Status of Nodatafound : " +svdtat);
			System.out.println("Total count of severity " +Srchcntd);
			if(svdtat==true){
				test.log(Status.PASS, "When invalid data is provided in severity no data found is displayed and the count is "+Srchcntd);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(svdtat==false){
				test.log(Status.FAIL, "Nodata found is not displayed when invalid data is provided in severity");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify nodatafound when invalid severity is provided " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//---------------------------------------End of US-------------------------------------------------------------//




	}
	}