package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ZIFUI_AnP_US4471_Regression extends Base {


	@Test
	public void ZIFUI_AnP_US4471_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("US 4471 Case Management - Decline Correlation - ML Development");
		test.createNode("US 4471 Case Management - Decline Correlation - ML Development");



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

		//click on the Analytics link
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickAnalytics();
			test.log(Status.PASS, "Analytics is clicked");
		}
		catch (Exception e)
		{
			test.log(Status.FAIL, "Unable to click analytics");
		}


		//Clicking on Preference icon//

		try {
			if(new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
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

		//Clearing the values before validation//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			test.log(Status.PASS, "clearing preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e)
		{
			test.log(Status.FAIL, "clearing preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Disabling Priority option if it is enabled already//
		try {
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.clear();
			Thread.sleep(3000);
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[11]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: "+status);
			Thread.sleep(3000);
			if(status==false) {
				test.log(Status.PASS, "Priority is already disabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			}
			else if (status==true) {
				WebElement valuet =  driver.findElement(By.xpath("//span[text()='Enable Case Prioritization']//..//span[@class='ui-inputswitch-slider']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",valuet);
				Thread.sleep(3000);
				JavascriptExecutor jst = (JavascriptExecutor) driver;
				jst.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				test.log(Status.PASS, "Priority option is disabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			} }catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Priority option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Setting option is selected form case management

		try {
			if (new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Setting icon is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Setting icon is not selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Noise cancellation slider is selected from setting option
		try{
			new ZIFAI_CaseManagementPage(driver).EnableNoiseCancellation();
			test.log(Status.PASS, "Noise Cancellation is enabled");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Noise cancellation toggle is not selected");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Setting option is selected form case management
		try {
			if (new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Setting icon is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Setting icon is not selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Correlation slider is selected from setting option
		try{
			new ZIFAI_CaseManagementPage(driver).EnableCorrelation();
			test.log(Status.PASS, "Correlation is enabled");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Correlation toggle is not selected");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Filter Inprogress cases//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.clear();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.sendKeys("ZIF14904");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter using case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on the first row after applying correlation
		try {
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "First case is selected after applying correlation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to click on first from case management page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

 	//---------------------------------------------End of US------------------------------------------//

		//Report Initialization

		test = extent.createTest("US 4909 Verify Decline correlation is enabled");
		test.createNode("US 4909 Verify Decline correlation is enabled");


		//After clicking on the first row verify Decline correlation is enabled and click on it
		//US 4909
		try {
			new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.isDisplayed();
				Thread.sleep(2000);
				new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.click();
				Thread.sleep(2000);
				test.log(Status.PASS, "Decline Correlation is enabled ");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Decline Correlation is disabled ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//Decline correlation options validation
		//US 4911 -  Device application
		try {
			Boolean DCdevice1 = new ZIFAI_CaseManagementPage(driver).DCdeviceapplication.isDisplayed();
			Thread.sleep(2000);
			test.log(Status.PASS, "Device application is displayed: "+DCdevice1);
		} catch (Exception e) {
			test.log(Status.FAIL, "Device application is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//Decline correlation options validation
		//US 4911 -  Tool name
		try {
			Boolean DCtoolname1 = new ZIFAI_CaseManagementPage(driver).DCtoolname.isDisplayed();
			Thread.sleep(2000);
			test.log(Status.PASS, "Tool name is displayed: "+DCtoolname1);
		} catch (Exception e) {
			test.log(Status.FAIL, "Tool name is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Decline correlation options validation
		//US 4911 -  Description
		try {
			Boolean DCDescription1 = new ZIFAI_CaseManagementPage(driver).DCdescription.isDisplayed();
			Thread.sleep(2000);
			test.log(Status.PASS, "Description is displayed: "+DCDescription1);
		} catch (Exception e) {
			test.log(Status.FAIL, "Description is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Decline correlation options validation
		//US 4911 - Created Date
		try {
			Boolean DCcreateddate = new ZIFAI_CaseManagementPage(driver).DCcreateddate.isDisplayed();
			Thread.sleep(2000);
			test.log(Status.PASS, "Created date is displayed: "+DCcreateddate);
		} catch (Exception e) {
			test.log(Status.FAIL, "Created date is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Decline correlation options validation
		//US 4911 -  Unlearn pattern
		try {
			Boolean DCUnlearnpattern1 = new ZIFAI_CaseManagementPage(driver).DCunlearnpattern.isDisplayed();
			Thread.sleep(2000);
			test.log(Status.PASS, "Unlearn pattern is displayed: "+DCUnlearnpattern1);
		} catch (Exception e) {
			test.log(Status.PASS, "Unlearn pattern is grayed out");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Decline correlation options validation
		//US 4911 -  Cancel button
		try {
			Boolean DCCancelbutton = new ZIFAI_CaseManagementPage(driver).DCcancelbutton.isDisplayed();
			Thread.sleep(2000);
			test.log(Status.PASS, "Cancel button is displayed: "+DCCancelbutton);
		} catch (Exception e) {
			test.log(Status.PASS, "Cancel button is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Decline correlation options validation
		//US 4911 -  Verify checkbox is selected and applied on the alerts
		try {
			Boolean checkboxDC = new ZIFAI_CaseManagementPage(driver).DCcheckbox.isSelected();
			new ZIFAI_CaseManagementPage(driver).DCclosebutton.click();
			Thread.sleep(2000);
			test.log(Status.PASS, "Alert is checked using Checkbox: "+checkboxDC);
		} catch (Exception e) {
			test.log(Status.PASS, "Unable to check the alerts");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//US 5074 - Verify Unlearn Pattern with the checked
		//Alerts in Decline Correlation page of Case Management

		//Verifying alerts with checked/unchecked checkbox as per the count available//

		//Filter case id//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.clear();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.sendKeys("ZIF14904");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter using case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Hovering the Decline correlation tooltip to verify the user//
		try {
			WebElement DChover = new ZIFAI_CaseManagementPage(driver).DeclineCorrelation;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Casestatustooltip = Case_status.getText();
			if (Casestatustooltip.equals("Decline Correlation")) {
				test.log(Status.PASS, "Decline correlation is displayed when hovered");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			System.out.println("Declined correlation before checking alerts: " + Casestatustooltip);
			test.log(Status.PASS, "Declined correlation before checking alerts: "+Casestatustooltip);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to hover the decline correlation tooltip before clicking checkbox");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Filter case id//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.clear();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.sendKeys("ZIF14904");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter using case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating checkbox by selecting it//

		try {
			new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.click();
			Thread.sleep(5000);
			if (driver.findElements(By.xpath("//div[text()='No Data Found']")).size() < 1) {
				Thread.sleep(3000);
				int size = driver.findElements(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])")).size();
				for (int j = 2; j <= size; j++) {
					WebElement checkbox = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[" + j + "]"));
					Boolean property = checkbox.isEnabled();
					System.out.println("Property - " + property);
					if (property == true) {
						Thread.sleep(3000);
						checkbox.click();
						Thread.sleep(3000);
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException | StaleElementReferenceException e) {
			test.log(Status.PASS, e);
			test.log(Status.PASS, "End of case validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, e);
			test.log(Status.PASS, "End of case validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//US 5074 Verify unlearn status//
		try {
			Boolean Dcunlrn = new ZIFAI_CaseManagementPage(driver).DCunlearnpattern.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Unlearn pattern is displayed after clicking on checkbox : " + Dcunlrn);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify unlearn pattern status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//US 4912 Verify User should be able to check/select alerts in Decline Correlation page
			try {
				Thread.sleep(5000);
			if (driver.findElements(By.xpath("//div[text()='No Data Found']")).size() < 1) {
				Thread.sleep(3000);
				int size = driver.findElements(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])")).size();
				for (int j = 2; j <= size; j++) {
					WebElement checkbox = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[" + j + "]"));
					Boolean property = checkbox.isEnabled();
					System.out.println("Property - " + property);
					if (property == true) {
						Thread.sleep(3000);
						checkbox.click();
						Thread.sleep(3000);
					}
				}
			}
			Boolean DCval = new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.isDisplayed();
			System.out.println(DCval);
			test.log(Status.PASS, "End of checkbox validation"+DCval);
			test.log(Status.PASS, "Decline correlation option is displayed "+DCval);
			new ZIFAI_CaseManagementPage(driver).DCclosebutton.click();

		} catch (ArrayIndexOutOfBoundsException | StaleElementReferenceException e) {
			test.log(Status.PASS, e);
			test.log(Status.PASS, "End of case validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, e);
			test.log(Status.PASS, "End of case validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//US 4912 Verify the behavior when Unlearn Pattern button is clicked when no alerts are checked/selected
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.click();
			Thread.sleep(3000);
			Boolean DCstatus1 = new ZIFAI_CaseManagementPage(driver).DCunlearnpattern.isDisplayed();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).DCclosebutton.click();
			test.log(Status.PASS, "Checkbox are unchecked and Unlearnpattern is grayed out:  " +DCstatus1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}
		catch (Exception e)
		{
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to verify Unlearnpattern status ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//		Cancel button should cancel the operation performed by the user in the decline Correlation window

		try {
			new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).DCcancelbutton.click();
			test.log(Status.PASS, "Decline correlation window is opened and clicked on cancel");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e)
		{ test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to click on Decline correlation and verify cancel ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//			Close button should cancel the operation performed by the user in the decline Correlation window

			try {
			new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.click();
				Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).DCclosebutton.click();
			test.log(Status.PASS, "Decline correlation window is opened and clicked on close button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		catch (Exception e)
		{
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to click on Decline correlation and verify close button ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Unique alerts should be displayed in the Decline Correlation page
		//US 5073 //Clicking on the first row after applying correlation

		//Filter ZIF2500 case id//
		new ZIFAI_CaseManagementPage(driver).Filtericon.click();
		Thread.sleep(3000);
		new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.clear();
		Thread.sleep(3000);
		new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.sendKeys("ZIF14904");
		Thread.sleep(4000);
		new ZIFAI_CaseManagementPage(driver).Applybutton.click();
		Thread.sleep(3000);
		SoftAssert softAssert = new SoftAssert();

		// Verify alerts are unique and validate if any duplicated are displayed//
		try {
			new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.click();
			Thread.sleep(2000);
			List<WebElement> Desc = driver.findElements(By.xpath("//div[@tooltipstyleclass='dev_short_box']"));
			List<WebElement> Descsec = driver.findElements(By.xpath("//div[@tooltipstyleclass='dev_short_box']"));
			List<WebElement> Desc_st = driver.findElements(By.xpath("//div[@tooltipstyleclass='dev_short_box']"));
			List<String> Text_List = new ArrayList<String>();
			int size = driver.findElements(By.xpath("//div[contains(@tooltipstyleclass, 'dev_')]")).size();
			for(int i=1; i<=size; i++){
				String text = driver.findElement(By.xpath("(//div[contains(@tooltipstyleclass, 'dev_')])["+i+"]")).getText();
				Boolean condition = Text_List.equals(text);
				softAssert.assertFalse(condition);
				if(condition == true){
					Thread.sleep(2000);
					System.out.println("Duplicate Text - " + text);
					test.log(Status.FAIL, "Duplicate Text - " + text);
				}
				Text_List.add(text);
			}
			System.out.println("Array List - " + Text_List);
		}
		catch (ArrayIndexOutOfBoundsException | StaleElementReferenceException e) {
			test.log(Status.PASS, e);
			test.log(Status.PASS, "End of case validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, e);
			test.log(Status.PASS, "End of case validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Alerts should be displayed in the Decline
		// Correlation page along with the other related details in Correlation US 5073//
		try {
		    Boolean appval1 =	new ZIFAI_CaseManagementPage(driver).DCdeviceapplication.isDisplayed();
			Boolean createdateval1 = new ZIFAI_CaseManagementPage(driver).DCcreateddate.isDisplayed();
			Boolean toolnameval1 = new ZIFAI_CaseManagementPage(driver).DCtoolname.isDisplayed();
			test.log(Status.PASS, "Device/application column is displayed:" +appval1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Created date column is displayed:" +createdateval1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Tool name column is displayed:" +toolnameval1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			new ZIFAI_CaseManagementPage(driver).DCclosebutton.click();

		}
		catch (Exception e)
		{
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to click on Decline correlation and verify close button ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Filter case id//
		try {

			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.clear();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.sendKeys("ZIF14904");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
		}
		catch (Exception e){

			test.log(Status.FAIL, "Unable to filter using case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Hovering the Decline correlation tooltip to verify the user//

		try {
			WebElement DChover = new ZIFAI_CaseManagementPage(driver).DeclineCorrelation;
				Actions action = new Actions(driver);
				Thread.sleep(4000);
				action.moveToElement(DChover).perform();
				Thread.sleep(3000);
				WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
				String Casestatustooltip = Case_status.getText();
				System.out.println("Declined correlation has been applied by: " + Casestatustooltip);
					test.log(Status.PASS, "Declined correlation has been applied by"+Casestatustooltip);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
		catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to hover the tooltip");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//---------------------------------------End-------------------------------------------//

		//Verify warning message is displayed when a alert is left orphan//

		//Filter case id//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.clear();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.sendKeys("ZIF14904");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.click();
			Thread.sleep(3000);
		}
		catch (Exception e){

			test.log(Status.FAIL, "Unable to filter using case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Verify warning message is displayed when an checkbox is left orphan from total (N) checkboxes//
		try{
			WebElement first_chckbx = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[1]"));
			WebElement scnd_chckbx = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[2]"));
			first_chckbx.click();
			Thread.sleep(3000);
			scnd_chckbx.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).DCunlearnpattern.click();
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify left out checkbox warning message");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Verifying the warning message//
		try
		{
			WebElement warningmsg = driver.findElement(By.xpath("//span[@class='ui-message-text ng-star-inserted']"));
			String msg = warningmsg.getText();
			Thread.sleep(3000);
			System.out.println("Message:" + msg);
			String expmsg = "Please select all the alerts and click on unlearn pattern";
			if (msg.equalsIgnoreCase(expmsg)) {
				test.log(Status.PASS, "Warning message is displayed and matching when an checkbox is left alone");
			}
			else{
				test.log(Status.FAIL, "Failed to display warning message.");
			}
			new ZIFAI_CaseManagementPage(driver).DCclosebutton.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify left out checkbox warning");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

	}
}