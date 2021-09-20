package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIAppSettingsPage;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ZIFUI_AnP_US1809_Regression extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;
	CommonMethods cm = null;


	@Test
	public void ZIFUI_AnP_US1809_Regression() throws IOException, InterruptedException {

		//Report Initialization
		test = extent.createTest("User Story 1809: Case Management - Suppression - Preferences Options");
		test.createNode("User Story 1809: Case Management - Suppression - Preferences Options");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


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
			new ZIFAIDashboardPage(driver).clickAnalytics();
			test.log(Status.PASS, "Analytics link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the values before validation//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared preference and filter");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter and preference before the validation");
		}

		//Clicking on Preference icon//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Preference Tab");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Disabling Priority option if it is enabled already//
		try {
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.clear();
			Thread.sleep(3000);
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[11]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == false) {
				test.log(Status.PASS, "Priority is already disabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == true) {
				WebElement valuet = driver.findElement(By.xpath("//span[text()='Enable Case Prioritization']//..//span[@class='ui-inputswitch-slider']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", valuet);
				Thread.sleep(3000);
				JavascriptExecutor jst = (JavascriptExecutor) driver;
				jst.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				test.log(Status.PASS, "Priority option is disabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Priority option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//		//Enable Suppression from setting icon//
//		try{
//			new ZIFAI_CaseManagementPage(driver).Invokesettingicon();
//			Thread.sleep(3000);
//			new ZIFAI_CaseManagementPage(driver).EnableNoiseCancellation();
//			Thread.sleep(3000);
//			test.log(Status.PASS, "Suppression is enabled from the setting icon");
//		}
//		catch (AssertionError | Exception e) {
//			test.log(Status.FAIL, "Not able to select Noise cancellation from setting icon" +e);
//		}
		//----------------------------------------End of US-----------------------------------------------//
		test = extent.createTest("Test Case 2239: Functional - Case Management - Suppression - Preferences Case Status & Severity");
		test.createNode("Test Case 2239: Functional - Case Management - Suppression - Preferences Case Status & Severity");
		//Filter segregating "Gcare" Tool name cases//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtertoolname.sendKeys("Gcare");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Tool name is filtered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter Tool name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the tool name hover using first instance//
		try {
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(4000);
			Actions actioncaseto = new Actions(driver);
			Thread.sleep(4000);
			actioncaseto.moveToElement(new ZIFAI_CaseManagementPage(driver).CorrelatedToolnamehover).perform();
			Thread.sleep(4000);
			WebElement ack_knwtp = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknol = ack_knwtp.getText();
			System.out.println("Tool name in first instance: " + acknol);
			if (acknol.equalsIgnoreCase("GCARE")) {
				test.log(Status.PASS, "Tool name is filtered and present in first instance");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Tool name is not filtered and not present in first instance");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(4000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify the tooltip with Tool name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Clearing the values in preference to proceed with next step//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Preference value is cleared for next step");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter new cases using preference to proceed with next step");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Filter segregating "Low" severity cases//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterseverity.sendKeys("Low");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Low severity value has been applied in filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter Low severity using filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying whether low severity has been updated in the case//
		try {
			Thread.sleep(4000);
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class,'first-left-icon-1-tri')])[1]"));
			Actions actioncaset = new Actions(driver);
			actioncaset.moveToElement(case_first).perform();
			Thread.sleep(2000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Severity status after filtering : " + acknowldget);
			if (acknowldget.equalsIgnoreCase("Low"))
			{
				test.log(Status.PASS, "Low severity has been filtered and verified");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "Unable to filter low severity");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify severity after filtering");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the values in preference and filter after severity validation//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceseverity("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the values in preference and filter after severity validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to clear the values in preference and filter after severity validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//-----------------------------------------End of US------------------------------------------------------------//
		test = extent.createTest("Test Case 2233: Functional - Case Management - Suppression - Preferences Case Status");
		test.createNode("Test Case 2233: Functional - Case Management - Suppression - Preferences Case Status");
		//Provide any "Case ID" in filter settings and Click the Save button  Case ID: ZIFXXX//
		try {
			String caseid = new ZIFAI_CaseManagementPage(driver).Caseidcorrelation.getText();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtercaseid.sendKeys(caseid);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
			String caseidtwo = new ZIFAI_CaseManagementPage(driver).Caseidcorrelation.getText();
			if(caseid.equalsIgnoreCase(caseidtwo)) {
				test.log(Status.PASS, "Successfully entered " + caseid + " in Filter case id");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(!caseid.equalsIgnoreCase(caseidtwo)) {
				test.log(Status.FAIL, "Successfully entered " + caseid + " in Filter case id" +"but value is not matching after filter");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to enter case id in filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the filter and preference after case id validation//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceseverity("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the values in preference and filter after case id validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to clear the values in preference and filter after case id validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Provide the case status "exclude:AutoClosed,exclude:New"//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("exclude:AutoClosed,exclude:New");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			actioncaset.moveToElement(case_first).perform();
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			Thread.sleep(2000);
			System.out.println("Case status after excluding New and AutoClosed : " + acknowldget);
			if (acknowldget.equalsIgnoreCase("Closed")||acknowldget.equalsIgnoreCase("InProgress")||(acknowldget.equalsIgnoreCase("Assigned"))) {
				test.log(Status.PASS, "Auto closed and New is excluded");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}else {
				test.log(Status.FAIL, "Closed and New status is not excluded");
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify whether New and closed is excluded");

		}

		//Provide the case status "New , In progress"//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("New,InProgress");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			actioncaset.moveToElement(case_first).perform();
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			Thread.sleep(2000);
			System.out.println("Case status after including New, InProgress : " +acknowldget);
			if (acknowldget.equalsIgnoreCase("New")||acknowldget.equalsIgnoreCase("InProgress")){
				test.log(Status.PASS, "New and InProgress is included");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}else {
				test.log(Status.FAIL, "New and InProgress status is not included");
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify whether New and InProgress is included");

		}

		//Provide the case status "Closed"//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("Closed");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			actioncaset.moveToElement(case_first).perform();
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Case status after including Closed : " + acknowldget);
			if (acknowldget.equalsIgnoreCase("Closed")){
				test.log(Status.PASS, "Closed status is included");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}else {
				test.log(Status.FAIL, "Closed status is not included");
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify whether Closed status is included");

		}

		//Provide the case status : exclude:Assigned"//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("exclude:Assigned");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			Thread.sleep(2000);
			actioncaset.moveToElement(case_first).perform();
			Thread.sleep(2000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Case status after excluding:Assinged: " + acknowldget);
			if (acknowldget.equalsIgnoreCase("New")||acknowldget.equalsIgnoreCase("InProgress")||(acknowldget.equalsIgnoreCase("Closed"))) {
				test.log(Status.PASS, "Assigned status is excluded");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}else {
				test.log(Status.FAIL, "Assigned status is not excluded");
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify whether Assigned status is excluded");

		}

		//Clearing the preference values//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			test.log(Status.PASS, "Clearing the values after executing case status validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to clear the values after executing case status validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-----------------------------------End of US---------------------------------------------//
		test = extent.createTest("Test Case 2241: Functional - Case Management - Suppression - Preferences Acknowledgement Status");
		test.createNode("Test Case 2241: Functional - Case Management - Suppression - Preferences Acknowledgement Status");
		//Applying values to Preference - Unacknowledged//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("Unacknowledged");
			test.log(Status.PASS, "Unacknowledged is applied to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unacknowledged is applied to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying the tooltip with text contains Unacknowledged//
		try {
			WebElement ackst = driver.findElement(By.xpath("(//div[contains(@class,'case-third-img1')])[1]"));
			Actions actioncase = new Actions(driver);
			actioncase.moveToElement(ackst).perform();
			Thread.sleep(2000);
			WebElement ack_knw = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldge = ack_knw.getText();
			System.out.println("Current status :" +acknowldge);
			if (acknowldge.contains("acknowledge")) {
				test.log(Status.PASS, "Case is displayed with unacknowledged icon");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Case is not displayed with unacknowledged icon");
		}

		//Applying values to Preference - Acknowledged//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("Acknowledged");
			test.log(Status.PASS, "Acknowledged is applied to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Acknowledged is applied to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying the tooltip with text contains Acknowledged//
		try {
			WebElement ackst = driver.findElement(By.xpath("(//div[contains(@class,'case-third-img1')])[1]"));
			Actions actioncase = new Actions(driver);
			actioncase.moveToElement(ackst).perform();
			Thread.sleep(2000);
			WebElement ack_knw = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldge = ack_knw.getText();
			System.out.println("Current status :" +acknowldge);
			if (!acknowldge.isEmpty()) {
				test.log(Status.PASS, "Case is displayed with Acknowledged icon "+acknowldge);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Case is not displayed with Acknowledged icon");
		}

		//Applying values to Preference - User//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("santhosh.m@GAVSTECH.COM");
			test.log(Status.PASS, "User is applied to preference "+" santhosh.m@GAVSTECH.COM");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "User is not applied to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying the tooltip with text user santhosh.m@GAVSTECH.COM//
		try {
			WebElement ackst = driver.findElement(By.xpath("(//div[contains(@class,'case-third-img1')])[1]"));
			Actions actioncase = new Actions(driver);
			actioncase.moveToElement(ackst).perform();
			Thread.sleep(2000);
			WebElement ack_knw = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldge = ack_knw.getText();
			System.out.println("Current status :" +acknowldge);
			if (acknowldge.contains("santhosh.m@GAVSTECH.COM")) {
				test.log(Status.PASS, "Case is displayed with acknowledged icon with particular user " +"santhosh.m@GAVSTECH.COM");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Case is not displayed with user");
		}

		//Verify three dots is there in preference option//
		try{
			Thread.sleep(3000);
			Boolean preftcn = new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed();
			if(preftcn==true){
				test.log(Status.PASS, "Verified three dots is applied in preference and cleared the values");
			}
			else if(preftcn==false){
				test.log(Status.FAIL, "Verified three dots is not applied in preference and cleared the values");
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the three dots and clear the preference");
		}

		//-------------------------------------End of US---------------------------------------------//
		test = extent.createTest("Test Case 2232: UI - Case Management - Suppression - Preferences Options");
		test.createNode("Test Case 2232: UI - Case Management - Suppression - Preferences Options");


		//Mouse hover the preference and verify the tool tip//
		try {
			if(new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()){
				Thread.sleep(3000);
				Actions actioncaseto = new Actions(driver);
				Thread.sleep(4000);
				actioncaseto.moveToElement(new ZIFAI_CaseManagementPage(driver).PreferencesTab).perform();
				Thread.sleep(4000);
				WebElement desc_corr = driver.findElement(By.cssSelector(".ui-tooltip"));
				String lrtr = desc_corr.getText();
				System.out.println("When hovered on Preference the text displayed is: " + lrtr);
				if (lrtr.equalsIgnoreCase("Preferences")) {
					test.log(Status.PASS, "Preferences text is matching as when hovered on Preference");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Preferences text is not matching as when hovered on Preference");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				Actions actioncaseto = new Actions(driver);
				Thread.sleep(4000);
				actioncaseto.moveToElement(new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots).perform();
				Thread.sleep(4000);
				WebElement desc_corr = driver.findElement(By.cssSelector(".ui-tooltip"));
				String lrtr = desc_corr.getText();
				System.out.println("When hovered on Preference the text displayed is: " + lrtr);
				if (lrtr.equalsIgnoreCase("Preferences")) {
					test.log(Status.PASS, "Preferences text is matching as when hovered on Preference");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Preferences text is matching as when hovered on Preference");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Preference text is not matching as when hovered on Filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//Clicking on Preference icon for verifying//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.PASS, "Unable to click Preference tab for verification");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Filter Popup should be displayed for the below fields Case ID,Created Date,Severity,Type,Device Name / Application Name,Tool Name,Case Description,Apply and Clear buttons,X icon//
		try{
			Boolean Prefcaseid =  new ZIFAI_CaseManagementPage(driver).PrefCaseID.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference case id status "+Prefcaseid);
			if(Prefcaseid==true){
				test.log(Status.PASS, "Preference case id is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefcaseid==false){
				test.log(Status.FAIL, "Preference case id is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Preferncecase =  new ZIFAI_CaseManagementPage(driver).Preferences_Casestatus.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference case status "+Preferncecase);
			Thread.sleep(3000);
			if(Preferncecase==true){
				test.log(Status.PASS, "Preference case status is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Preferncecase==false){
				test.log(Status.FAIL, "Preference case status is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Prefsevr =  new ZIFAI_CaseManagementPage(driver).PrefSeverity.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference severity status "+Prefsevr);
			Thread.sleep(3000);
			if(Prefsevr==true){
				test.log(Status.PASS, "Preference severity is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefsevr==false){
				test.log(Status.FAIL, "Preference severity is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Prftoolname =  new ZIFAI_CaseManagementPage(driver).PrefToolName.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference tool name status "+Prftoolname);
			Thread.sleep(3000);
			if(Prftoolname==true){
				test.log(Status.PASS, "Preference tool name is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prftoolname==false){
				test.log(Status.FAIL, "Preference tool name is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Prefincidnt =  new ZIFAI_CaseManagementPage(driver).Pref_incident.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference incident ID status "+Prefincidnt);
			Thread.sleep(3000);
			if(Prefincidnt==true){
				test.log(Status.PASS, "Preference incident ID is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefincidnt==false){
				test.log(Status.FAIL, "Preference incident ID is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			Boolean Prefincidntst =  new ZIFAI_CaseManagementPage(driver).Pref_incidentstatus.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference status "+Prefincidntst);
			Thread.sleep(3000);
			if(Prefincidntst==true){
				test.log(Status.PASS, "Preference status is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefincidntst==false){
				test.log(Status.FAIL, "Preference status is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Prefackstatus =  new ZIFAI_CaseManagementPage(driver).Preferences_Ackstatus.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference acknowledgement status "+Prefackstatus);
			Thread.sleep(3000);
			if(Prefackstatus==true){
				test.log(Status.PASS, "Preference acknowledgement status");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefackstatus==false){
				test.log(Status.FAIL, "Preference acknowledgement status is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Thresholdfalse =  new ZIFAI_CaseManagementPage(driver).Thresholdenablefalse.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Show only false cases "+Thresholdfalse);
			Thread.sleep(3000);
			if(Thresholdfalse==true){
				test.log(Status.PASS, "Threshold show only false cases is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Thresholdfalse==false){
				test.log(Status.FAIL, "Threshold show only false cases is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Thresholdhidefalse =  new ZIFAI_CaseManagementPage(driver).Thresholdhidefalse.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Threshold hide false cases "+Thresholdhidefalse);
			Thread.sleep(3000);
			if(Thresholdhidefalse==true){
				test.log(Status.PASS, "Threshold hide false cases is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Thresholdhidefalse==false){
				test.log(Status.FAIL, "Threshold hide false cases is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Hidecasewithtxt =  new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Hide case with text "+Hidecasewithtxt);
			Thread.sleep(3000);
			if(Thresholdhidefalse==true){
				test.log(Status.PASS, "Hide case with text is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Thresholdhidefalse==false){
				test.log(Status.FAIL, "Hide case with text is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Prefncecrtdate =  new ZIFAI_CaseManagementPage(driver).Preferences_createddate.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference created date status "+Prefncecrtdate);
			Thread.sleep(3000);
			if(Prefncecrtdate==true){
				test.log(Status.PASS, "Preference created date is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefncecrtdate==false){
				test.log(Status.FAIL, "Preference created date is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			Boolean Prefnceupddate =  new ZIFAI_CaseManagementPage(driver).Preferences_updateddate.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference updated date status "+Prefnceupddate);
			Thread.sleep(3000);
			if(Prefnceupddate==true){
				test.log(Status.PASS, "Preference updated date is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefnceupddate==false){
				test.log(Status.FAIL, "Preference updated date is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Prefappl =  new ZIFAI_CaseManagementPage(driver).PrefApply.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference apply status "+Prefappl);
			Thread.sleep(3000);
			if(Prefappl==true){
				test.log(Status.PASS, "Preference apply is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefappl==false){
				test.log(Status.FAIL, "Preference apply is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Prefcncl =  new ZIFAI_CaseManagementPage(driver).Prefcancel.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference cancel status "+Prefnceupddate);
			Thread.sleep(3000);
			if(Prefcncl==true){
				test.log(Status.PASS, "Preference cancel is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefcncl==false){
				test.log(Status.FAIL, "Preference cancel is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Prefclose =  new ZIFAI_CaseManagementPage(driver).Preferenceclose.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Preference close icon status "+Prefnceupddate);
			Thread.sleep(3000);
			if(Prefclose==true){
				test.log(Status.PASS, "Preference close icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Prefclose==false){
				test.log(Status.FAIL, "Preference close icon is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the Preferences option presence");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the "I" present next to Case ID text box, verify the case ID format displayed//
		try {
			Thread.sleep(2000);
			Actions actrp = new Actions(driver);
			actrp.moveToElement(new ZIFAI_CaseManagementPage(driver).Preferencecaseidformathover).perform();
			WebElement ack_case = driver.findElement(By.cssSelector(".ui-tooltip"));
			String caseidft = ack_case.getText();
			System.out.println("Case id format hovered text :" +caseidft);
			if (caseidft.equalsIgnoreCase("Case ID format is ZIFXXXXXXXXXX")) {
				test.log(Status.PASS, "Case id format hovered text is matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Case id format hovered text is not matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(2000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Failed to hover case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the "I" present next to Tool Name text box, verify the case ID format displayed
		try {
			Actions actrptln = new Actions(driver);
			Thread.sleep(2000);
			actrptln.moveToElement(new ZIFAI_CaseManagementPage(driver).Preferencetoolnamehover).perform();
			Thread.sleep(2000);
			WebElement ack_tnlme = driver.findElement(By.cssSelector(".ui-tooltip"));
			String toolname = ack_tnlme.getText();
			System.out.println("Tool name hovered text :" +toolname);
			if (toolname.equalsIgnoreCase("Format E.g.- Tool Name 1,Tool Name 2")) {
				test.log(Status.PASS, "Tool name hovered text is matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Tool name hovered text is not matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Failed to hover toolname");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the "I" present next to Hide Case with Text text box, verify the case ID format displayed

		try {
			Actions descprf = new Actions(driver);
			Thread.sleep(2000);
			descprf.moveToElement(new ZIFAI_CaseManagementPage(driver).Preferencedescrhover).perform();
			Thread.sleep(2000);
			WebElement pref_desc = driver.findElement(By.cssSelector(".ui-tooltip"));
			String descprftr = pref_desc.getText();
			System.out.println("Hide cases with text when hovered :" + descprftr);
			if (descprftr.equalsIgnoreCase("Format E.g.- description1;description2")) {
				test.log(Status.PASS, "Hide cases with text hoveredis matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Hide cases with text is not matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} }
		catch (Exception e){
			test.log(Status.FAIL, "Failed to hover Hide cases with text");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the "I" present next to Acknowledgement Status text box, verify the format displayed//
		try {
			Actions prefackhv = new Actions(driver);
			Thread.sleep(2000);
			prefackhv.moveToElement(new ZIFAI_CaseManagementPage(driver).Preferenceackhover).perform();
			Thread.sleep(2000);
			WebElement prefackhvr = driver.findElement(By.cssSelector(".ui-tooltip"));
			String descppr = prefackhvr.getText();
			System.out.println("Acknowledgement Status with text when hovered :" + descppr);
			if (descppr.equalsIgnoreCase("Format E.g.- acknowledged (or) unacknowledged (or) by:XXXX@XXXX.com")) {
				test.log(Status.PASS, "Acknowledgement Status with text when hovered is matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Acknowledgement Status with hovered text is not matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Failed to hover Acknowledgement Status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the "I" present next to Case Status text box, verify the case Status format displayed
		try {
			Actions prefackhv = new Actions(driver);
			Thread.sleep(2000);
			prefackhv.moveToElement(new ZIFAI_CaseManagementPage(driver).Preferencecasesthover).perform();
			Thread.sleep(2000);
			WebElement prefackhvr = driver.findElement(By.cssSelector(".ui-tooltip"));
			String descppr = prefackhvr.getText();
			System.out.println("Case Status with text when hovered :" + descppr);
			if (descppr.equalsIgnoreCase("Format E.g.- exclude:New, exclude:Closed")) {
				test.log(Status.PASS, "Case Status with text when hovered is matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Case Status with hovered text is not matching");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAI_CaseManagementPage(driver).Prefcancel.click();
		}
		catch (Exception e){
			test.log(Status.FAIL, "Failed to hover Case Status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the Preference and filter values at end of the script//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceHidecase("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Successfully cleared filter and preference at end of the script");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to clear filter and preference at end of the script");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-------------------------------------End of US------------------------------------------------//
		//Case Details - Preference Options(No Data Found)//
		test = extent.createTest("Test Case 2247: Functional - Case Management - Suppression - Preferences(No Data Found)");
		test.createNode("Test Case 2247: Functional - Case Management - Suppression - Preferences(No Data Found)");

		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("NNN");
			Thread.sleep(3000);
			test.log(Status.PASS, "Successfully entered invalid case id in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to enter case id in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Getting count after entering invalid case id//
		try {
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after passing invalid case id in preference: " + countdate);
			test.log(Status.PASS, "Count after passing invalid case id in preference" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				Thread.sleep(3000);
				test.log(Status.FAIL, "Invalid case id is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				Thread.sleep(3000);
				test.log(Status.PASS, "Invalid case id is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid description");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Click the Preference icon and enter any invalid data in Case status - XXX//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("XXX");
			test.log(Status.PASS, "Successfully entered invalid case status in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to enter case status in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Getting count after entering invalid case status//
		try {
			Thread.sleep(3000);
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after passing invalid case status in preference: " + countdate);
			test.log(Status.PASS, "Count after passing invalid case status in preference" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				test.log(Status.FAIL, "Invalid case status is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				test.log(Status.PASS, "Invalid case status is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Click the Preference icon and enter any invalid data in Case Severity - JJJ//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceseverity("JJJ");
			test.log(Status.PASS, "Successfully entered invalid severity in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to enter case severity in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Getting count after entering invalid severity//
		try {
			Thread.sleep(3000);
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after passing invalid severity in preference: " + countdate);
			test.log(Status.PASS, "Count after passing invalid severity in preference" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				Thread.sleep(3000);
				test.log(Status.FAIL, "Invalid severity is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				Thread.sleep(3000);
				test.log(Status.PASS, "Invalid severity is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid severity");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Click the Preference icon and enter any invalid data in Tool name - adsd//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencetoolname("adsd");
			Thread.sleep(3000);
			test.log(Status.PASS, "Successfully entered invalid tool name in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to enter tool name in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Getting count after entering invalid tool name//
		try {
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			Thread.sleep(3000);
			System.out.println("Count after passing invalid tool name in preference: " + countdate);
			test.log(Status.PASS, "Count after passing invalid tool name in preference" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				Thread.sleep(3000);
				test.log(Status.FAIL, "Invalid tool name is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				Thread.sleep(3000);
				test.log(Status.PASS, "Invalid tool name is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid tool name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Click the Preference icon and enter any invalid data in Ack status - sdfsdf//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("sdfsdf");
			test.log(Status.PASS, "Successfully entered invalid Ack status in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to enter Ack status in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Getting count after entering invalid Ack status//
		try {
			Thread.sleep(3000);
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after passing invalid Ack status in preference: " + countdate);
			test.log(Status.PASS, "Count after passing invalid Ack status in preference" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				Thread.sleep(3000);
				test.log(Status.FAIL, "Invalid Ack status is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				Thread.sleep(3000);
				test.log(Status.PASS, "Invalid Ack status is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid Ack status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing Preference data//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Successfully cleared values in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear values in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//----------------------------------------End of US-----------------------------------------------//
		test = extent.createTest("Test Case 2243: Functional - Case Management - Suppression - Preferences Sort Case & Hide Cases");
		test.createNode("Test Case 2243: Functional - Case Management - Suppression - Preferences Sort Case & Hide Cases");
		//Enable Created date from preference icon//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablecreateddate();
			Thread.sleep(3000);
			List<String> createddate = new ArrayList<String>();
			int crtde = driver.findElements(By.xpath("//span[@class='case-details analytics_desc']")).size();
			for (int i = 1; i<=crtde; i++) {
				String text = driver.findElement(By.xpath("(//span[@class='case-details analytics_desc'])[" + i + "]")).getText();
				createddate.add(text);
				if(!createddate.isEmpty()){
					System.out.println("Create date is verified ~ Pass " +createddate);
				}
				else if(createddate.isEmpty()){
					System.out.println("Create date is verified and empty ~ Fail " +createddate);
				}
			}
			test.log(Status.PASS, "Created date is enabled");
		}catch (Exception e){
			test.log(Status.FAIL, "Not able to enable created date from preference icon" +e);
		}

		SoftAssert softAssert = new SoftAssert();
		//Method to verify the cases are unique//
		try {
			Thread.sleep(3000);
			List<String> Text_LeftPane = new ArrayList<String>();
			int size_LeftPane = driver.findElements(By.xpath("//span[@class='analytics-case']")).size();
			for (int i = 1; i<=size_LeftPane; i++) {
				String text = driver.findElement(By.xpath("(//span[@class='analytics-case'])[" + i + "]")).getText().replace("ZIF","").trim();
				Text_LeftPane.add(text);
			}
			System.out.println("Cases list after applying create date - " + Text_LeftPane);
			List<String> Text_RightPane = new ArrayList<String>();
			int size_RightPane = driver.findElements(By.xpath("//span[@class='analytics-case']")).size();
			for (int i = 1; i<=size_RightPane; i++) {
				String text = driver.findElement(By.xpath("(//span[@class='analytics-case'])[" + i + "]")).getText().replace("ZIF","").trim();
				Text_RightPane.add(text);
			}
			System.out.println("Cases list after applying create date - " + Text_RightPane);
			for(String item: Text_LeftPane){
				if(Text_RightPane.equals(item)){
					System.out.println("Duplicate Case id - " + item);
					test.log(Status.FAIL, "Case id is same : "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
			test.log(Status.PASS, "Verified cases after applying created date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify cases after applying created date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Enable Updated date from preference icon//
		try {
			new ZIFAI_CaseManagementPage(driver).EnableUpdatedate();
			Thread.sleep(3000);
			List<String> updatedddate = new ArrayList<String>();
			int updde = driver.findElements(By.xpath("//div[@class='analyse_date']")).size();
			for (int i = 1; i<=updde; i++) {
				String text = driver.findElement(By.xpath("(//div[@class='analyse_date'])[" + i + "]")).getText();
				updatedddate.add(text);
				if(!updatedddate.isEmpty()){
					System.out.println("Updated date is verified ~ Pass " +updatedddate);
				}
				else if(updatedddate.isEmpty()){
					System.out.println("Updated date is verified and empty ~ Fail " +updatedddate);
				}
			}
			test.log(Status.PASS, "Updated date is enabled");

		}catch (Exception e){
			test.log(Status.FAIL, "Not able to enable updated date from preference icon" +e);
		}


		//Method to verify the cases are unique//
		try {
			Thread.sleep(3000);
			List<String> Text_LeftPane = new ArrayList<String>();
			int size_LeftPane = driver.findElements(By.xpath("//span[@class='analytics-case']")).size();
			for (int i = 1; i<=size_LeftPane; i++) {
				String text = driver.findElement(By.xpath("(//span[@class='analytics-case'])[" + i + "]")).getText().replace("ZIF","").trim();
				Text_LeftPane.add(text);
			}
			System.out.println("Cases list after applying updated date - " + Text_LeftPane);
			List<String> Text_RightPane = new ArrayList<String>();
			int size_RightPane = driver.findElements(By.xpath("//span[@class='analytics-case']")).size();
			for (int i = 1; i<=size_RightPane; i++) {
				String text = driver.findElement(By.xpath("(//span[@class='analytics-case'])[" + i + "]")).getText().replace("ZIF","").trim();
				Text_RightPane.add(text);
			}
			System.out.println("Cases list after applying updated date - " + Text_RightPane);
			for(String item: Text_LeftPane){
				if(Text_RightPane.equals(item)){
					System.out.println("Duplicate Case id - " + item);
					test.log(Status.FAIL, "Case id is same : "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} }
			test.log(Status.PASS, "Verified cases after applying updated date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}

		catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify cases after applying updated date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Disable Updated date from preference icon//
		try {
			new ZIFAI_CaseManagementPage(driver).DisableUpdatedate();
			Thread.sleep(3000);
			List<String> Text_LeftPane = new ArrayList<String>();
			int size_LeftPane = driver.findElements(By.xpath("//span[@class='analytics-case']")).size();
			for (int i = 1; i<=size_LeftPane; i++) {
				String text = driver.findElement(By.xpath("(//span[@class='analytics-case'])[" + i + "]")).getText().replace("ZIF","").trim();
				Text_LeftPane.add(text);
			}
			System.out.println("Cases list after disabling update date - " + Text_LeftPane);
			List<String> Text_RightPane = new ArrayList<String>();
			int size_RightPane = driver.findElements(By.xpath("//span[@class='analytics-case']")).size();
			for (int i = 1; i<=size_RightPane; i++) {
				String text = driver.findElement(By.xpath("(//span[@class='analytics-case'])[" + i + "]")).getText().replace("ZIF","").trim();
				Text_RightPane.add(text);
			}
			System.out.println("Cases list after disabling update date - " + Text_RightPane);
			for(String item: Text_LeftPane){
				if(Text_RightPane.equals(item)){
					System.out.println("Duplicate Case id - " + item);
					test.log(Status.FAIL, "Case id is same : "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} }
			test.log(Status.PASS, "Verified cases after disabling update date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}
		catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify cases after disabling update date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		// Click the Live feed icon and stop the progress. Select the "updated Date" or "Created date" fields and verify the case ID screen//
		try {
			new ZIFAI_CaseManagementPage(driver).livefeedon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Live feed is turned off");
		}catch (Exception e){
			test.log(Status.FAIL, "Not able to turn of live feed" +e);
		}

		//Verifying created date//
		try {
			List<String> createddate = new ArrayList<String>();
			int crtde = driver.findElements(By.xpath("//span[@class='case-details analytics_desc']")).size();
			for (int i = 1; i <= crtde; i++) {
				String text = driver.findElement(By.xpath("(//span[@class='case-details analytics_desc'])[" + i + "]")).getText();
				createddate.add(text);
				if (!createddate.isEmpty()) {
					System.out.println("Create date is verified after live feed ~ Pass " + createddate);
				} else if (createddate.isEmpty()) {
					System.out.println("Create date is verified and empty after live feed ~ Fail " + createddate);
				}
			}
			test.log(Status.PASS, "Verified Created date after live feed ");
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Not able to verify created date after live feed");
		}
		//Verifying updated date//
		try {
			List<String> updateddatenew = new ArrayList<String>();
			int updateddate = driver.findElements(By.xpath("//div[@class='analyse_date']")).size();
			for (int i = 1; i <= updateddate; i++) {
				String text = driver.findElement(By.xpath("(//div[@class='analyse_date'])[" + i + "]")).getText();
				updateddatenew.add(text);
				if (!updateddatenew.isEmpty()) {
					System.out.println("Create date is verified after live feed ~ Pass " + updateddatenew);
				} else if (updateddatenew.isEmpty()) {
					System.out.println("Create date is verified and empty after live feed ~ Fail " + updateddatenew);
				}
			}
			test.log(Status.PASS, "Verified Update date after live feed ");
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify Update date after live feed ");
		}

		//Click the Live feed icon and turn on after validation//
		try {
			new ZIFAI_CaseManagementPage(driver).livefeedoff.click();
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			test.log(Status.PASS, "Live feed is turned on");
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Not able to turn on live feed " +e);
		}

		//Verifying the description using hide text from preference and validating it//
		try {
			Thread.sleep(4000);
			String Caseone = new ZIFAI_CaseManagementPage(driver).Caseidcorrelation.getText();
			Thread.sleep(4000);
			Actions actioncaset = new Actions(driver);
			actioncaset.moveToElement(new ZIFAI_CaseManagementPage(driver).Descriptionalerts).perform();
			Thread.sleep(4000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String descriptionone = ack_knwt.getText();
			System.out.println("Description in first instance: " + descriptionone);
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceHidecase("");
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.sendKeys(descriptionone);
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).Filtercaseid.sendKeys(Caseone);
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).FilterApply.click();
			Thread.sleep(4000);
			if(new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed()){
				Thread.sleep(4000);
				test.log(Status.PASS, "Hide case text is verified and no data is found");
			}
			else{
				test.log(Status.FAIL, "Hide case text is not verified and no data is not found");
			}
			Thread.sleep(4000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter description");

		}

		//Clearing the values in preference and filter after hide text validation//
		try{
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			String b = Keys.BACK_SPACE.toString();
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b );
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the filter and preference after hide text validation");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear the filter and preference after hide text validation");
		}
		//-----------------------------------End of US---------------------------------------------//
		test = extent.createTest("Test Case 2240: Functional - 1809 Case Management - Suppression - Preferences Incident ID & Status");
		test.createNode("Test Case 2240: Functional - 1809 Case Management - Suppression - Preferences Incident ID & Status");
		//Filter segregating "New" incident//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			new ZIFAI_CaseManagementPage(driver).Pref_incidentstatus.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b );
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Pref_incidentstatus.sendKeys("New");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(3000);
			Actions actioncasetd = new Actions(driver);
			actioncasetd.moveToElement(new ZIFAI_CaseManagementPage(driver).Exporticon).perform();
			Thread.sleep(4000);
			WebElement ack_knwtp = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Exportid = ack_knwtp.getText().substring(0, 20).replace("IncidentID:", "").trim();
			System.out.println("Export Incident id: " + Exportid);
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Pref_incident.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b );
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Pref_incident.sendKeys(Exportid);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(3000);
			Actions resultaction = new Actions(driver);
			resultaction.moveToElement(new ZIFAI_CaseManagementPage(driver).Exporticon).perform();
			Thread.sleep(3000);
			WebElement ack_knwtpt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Exportgetid = ack_knwtpt.getText();
			System.out.println("Case id which has incident id: " +Exportgetid);
			if(Exportgetid.contains(Exportid)){
				test.log(Status.PASS, "Incident has been filtered and verified");
			}
			else{
				test.log(Status.FAIL, "Unable to verify Incident ID");
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to filter and verify Incident ID");
		}

		//Verify "Closed" status in incident status//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Pref_incident.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b );
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Pref_incidentstatus.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b );
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Pref_incidentstatus.sendKeys("Closed");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(3000);
			Actions actioncasetd = new Actions(driver);
			actioncasetd.moveToElement(new ZIFAI_CaseManagementPage(driver).Exporticon).perform();
			Thread.sleep(2000);
			WebElement acktyp_re = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Exportidgetval = acktyp_re.getText();
			Thread.sleep(2000);
			System.out.println("Current value in closed status : "+Exportidgetval);
			if(Exportidgetval.contains("Closed")){
				test.log(Status.PASS, "Incident has been filtered with closed status and verified");
			}
			else{
				test.log(Status.FAIL, "Unable to verify Incident ID with closed status");
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to filter and verify Incident ID with closed status");
		}
		//-------------------------------End of US-----------------------------------------------------//
		test = extent.createTest("Test Case 2242: Functional - Case Management - Suppression - Preferences Cancel button");
		test.createNode("Test Case 2242: Functional - Case Management - Suppression - Preferences Cancel button");


		//Invoke Preference pass value in case status again reopen and enter another value click cancel validate whether the value is restored//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Pref_incident.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b );
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Pref_incidentstatus.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b );
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("New");
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared preference and filter where New status is entered in preference");
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to enter New status in preference after clearing the values");
		}

		//Invoking preference and entering close in case status and cancelling it to validate old value is retained//
		try{
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferences_Casestatus.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b );
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferences_Casestatus.sendKeys("Closed");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Prefcancel.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			String valueofstatus = new ZIFAI_CaseManagementPage(driver).Preferences_Casestatus.getAttribute("value");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Prefcancel.click();
			Thread.sleep(3000);
			if(valueofstatus.equalsIgnoreCase("New")){
				test.log(Status.PASS, "Case status New is retained in preference");
			} else {
				test.log(Status.FAIL, "Case status New is not retained in preference");
			}
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the case status");
		}
		//Clearing the values from Case status in preference//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			test.log(Status.PASS, "Clear the values in preference after case status validation");
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the case status using preference");
		}

		//Invoking Filter and entering close in case status and cancelling it to validate old value is retained//
		try{
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterseverity.sendKeys("Critical");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterseverity.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterseverity.sendKeys("High");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			String valueofstatus = new ZIFAI_CaseManagementPage(driver).Filterseverity.getAttribute("value");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			if(valueofstatus.equalsIgnoreCase("Critical")){
				test.log(Status.PASS, "Severity status Critical is retained in filter");
			} else {
				test.log(Status.FAIL, "Severity status Critical is not retained in filter");
			}
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the case severity in filter");
		}

		//Clearing the filter and preference//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the filter and preference after validated value retained in filter and preference");
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to clear filter and preference after validation");
		}

		//------------------------------------End of US----------------------------------------------------//

	}
	}