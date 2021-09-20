package com.zifautomation.TestCases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.apache.poi.hssf.record.formula.functions.If;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

//US 2922 - This User Story is based on Suppression/Correlation functionality on Case management Page

public class ZIFUI_AnP_US2922_Regression extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;


	@Test
	public void ZIFUI_AnP_US2922_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("Case Management - Correlation - Base Screen and Actions");
		test.createNode("Case Management - Correlation - Base Screen and Actions");

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
			new ZIFAIDashboardPage(driver).clickAnalytics();
			test.log(Status.PASS, "Analytics link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
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

		//Clicking on preference tab//
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

		//Disabling Prioritization//
		try {
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.clear();
			Thread.sleep(3000);
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[11]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: "+status);
			Thread.sleep(3000);
			if(status==false) {
				test.log(Status.PASS, "Priority is already enabled");
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
				test.log(Status.PASS, "Priority option is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} }catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Priority option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the filter and preference values//
		try{
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceHidecase("");
			Thread.sleep(3000);
		}
		catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to clear filter and preference before validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Verify first row is clicked after clicking Suppression icon from Case management page
		try {
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "First Case row is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click First Case row");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Verify the Case id which is selected from Case management page
		try {
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("(","").replace(")","").replace("All","").trim();
			String Case_id = new ZIFAI_CaseManagementPage(driver).Caseidcorrelation.getText();
			System.out.println("Overall_Case_count:" + Case_count1);
			System.out.println("Selected case id:" + Case_id);
			test.log(Status.PASS, "Case id which is clicked:" + Case_id);
			test.log(Status.PASS, "Total case count in Correlation: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to click on Suppression Toggle");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Ensure case IDs are sorted by default
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Casesortval();
			test.log(Status.PASS, "Case id is sorted by default");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the sorted case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the unique status displayed from case management page
		try {
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).UniquestatusNew();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			Boolean uniquenewt = new ZIFAI_CaseManagementPage(driver).CaseStatusfirst.isDisplayed();
			test.log(Status.PASS, "Unique status 'New' is displayed: " +uniquenewt);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unique status 'New' is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Ensure the Created Date is displayed
		try {
			new ZIFAI_CaseManagementPage(driver).Createddatetimeval();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Createddatetimevaltext();
			Thread.sleep(3000);
			String createupdte = new ZIFAI_CaseManagementPage(driver).Createdatecorrelation.getText();
			test.log(Status.PASS, "Verify updated date is displayed: " +createupdte);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify updated date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the unique status displayed from case management page
		try {
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).UniquestatusAssigned();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='case-outer-details1 case-outer-details-color2']//span[contains(@class,'case-first-left-icon-2')]")));
			Boolean uniquenassigned1 = new ZIFAI_CaseManagementPage(driver).CaseStatusfirst.isDisplayed();
			test.log(Status.PASS, "Unique status 'Assigned' is displayed: " +uniquenassigned1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unique status assigned is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the unique status displayed from case management page//
		try {
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).UniquestatusInprogress();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='case-outer-details1 case-outer-details-color2']//span[contains(@class,'case-first-left-icon-2')]")));
			Boolean uniqueinprogress = new ZIFAI_CaseManagementPage(driver).CaseStatusfirst.isDisplayed();
			test.log(Status.PASS, "Unique status 'Inprogress' is displayed: " +uniqueinprogress);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unique status inprogress is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the unique status displayed from case management page//
		try {
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).UniquestatusClosed();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			Boolean uniqueclosed = new ZIFAI_CaseManagementPage(driver).CaseStatusfirst.isDisplayed();
			test.log(Status.PASS, "Unique status 'Closed' is displayed: " +uniqueclosed);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unique status closed is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Ensure the Created Date is in UTC format
		try {
			String createupdte2 = new ZIFAI_CaseManagementPage(driver).Createdatecorrelation.getText();
			new ZIFAI_CaseManagementPage(driver).TimeStampValid(createupdte2);
			test.log(Status.PASS, "Verified and Created date is in UTC format: " +true);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify Create date: " + false);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Ensure the Update Date is displayed
		try {
			new ZIFAI_CaseManagementPage(driver).Updatetimeval();
			new ZIFAI_CaseManagementPage(driver).Updatetimevaltext();
			String updtdate1 = new ZIFAI_CaseManagementPage(driver).Updateddatecorrelation.getText();
			test.log(Status.PASS, "Update date is displayed : " +updtdate1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Update Date is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Ensure the Updated Date is in UTC format
		try {
			String updateddate2 = new ZIFAI_CaseManagementPage(driver).Updateddatecorrelation.getText();
			new ZIFAI_CaseManagementPage(driver).TimeStampValid(updateddate2);
			test.log(Status.PASS, "Verified and Updated date is in UTC format: " +true);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify Updated date: " + false);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify Severity is displayed
		try {
			Boolean StrSeverity = new ZIFAI_CaseManagementPage(driver).SeverityStatusfirst.isDisplayed();
			test.log(Status.PASS, "Severity is displayed:" +StrSeverity);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Severity is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the case status from case management page

		try {
			Boolean StrCaseStatus = new ZIFAI_CaseManagementPage(driver).CaseStatusfirst.isDisplayed();
			test.log(Status.PASS, "Case Status is displayed:" +StrCaseStatus);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Case Status is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



			//Ensure the correlated count of the case id's are displayed in the bell icon column
		try {
			new ZIFAI_CaseManagementPage(driver).correlatedalertaction();
			Thread.sleep(3000);
			String alertcountstr = new ZIFAI_CaseManagementPage(driver).CorrelatedAlertshover.getText();
			test.log(Status.PASS, "Alert is displayed: " +alertcountstr);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Alert is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//		//Ensure the Device count is displayed in Devices field represented with icon
		try {
			new ZIFAI_CaseManagementPage(driver).correlationserveraction();
			Thread.sleep(3000);
			String servercountstr = new ZIFAI_CaseManagementPage(driver).CorrelatedServershover.getText();
			test.log(Status.PASS, "Server count is displayed: " +servercountstr);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Server count is not displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


//		//Ensure the required tooltip is displayed across the case management screen
		try {
			new ZIFAI_CaseManagementPage(driver).Casestatushover();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Severitystatushover();
			Thread.sleep(3000);
			test.log(Status.PASS, " Casestatus and Severity is hovered successfully");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to Hover");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click the Acknowledgement icon and Verify the tooltip after the acknowledgement action
		try {
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseUnacknowledgeFilter();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).Alertmanualunack.click();
			Thread.sleep(2000);
			test.log(Status.PASS, " Clicked on the Acknowledgement icon and Verified  acknowledgement action");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to click the acknowledgement icon and verifythe acknowledgement  action");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Ensure the acknowledgement icon is disabled for the user's action once it is acknowledged//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseacknowledgeFilter();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			Actions cqseacknowl = new Actions(driver);
			cqseacknowl.moveToElement(new ZIFAI_CaseManagementPage(driver).Acknowledgehoverdetail).perform();
			WebElement Ackzif = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Acknledgestatus = Ackzif.getText();
			System.out.println("Acknowledgement is already done and user who has done it: " +Acknledgestatus);
			test.log(Status.PASS, "Acknowledgement is already done and user who has done it:  " +Acknledgestatus);
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify if acknowledgement icon is disabled");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Live Feed Pause

		try {
			new ZIFAI_CaseManagementPage(driver).SupressionLivefeedpause();
			Thread.sleep(3000);
			test.log(Status.PASS, " Live Feed is paused");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to pause the live feed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Ensure Live Feed is turned on
		try {
			new ZIFAI_CaseManagementPage(driver).SupressionLivefeedon();
			Thread.sleep(3000);
			test.log(Status.PASS, "Live feed is turned on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to turn on Live Feed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify whether the scroll bar is working properly
		//Verify No Severity mapping is displayed
		try {
			List<WebElement> casestatus = new ZIFAI_CaseManagementPage(driver).CaseStatuslist;
			List<WebElement> case_status = new ZIFAI_CaseManagementPage(driver).CaseStatuslist;
			int i;
			for ( i= 1; i<casestatus.size(); i=i+1) {
				System.out.println(casestatus.size());
				Actions action = new Actions(driver);
				Thread.sleep(2000);
				action.moveToElement(case_status.get(i)).perform();
				WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
				String Casestatustooltip = Case_status.getText();
				System.out.println("Casestatustooltip:" + Casestatustooltip);
				if (Casestatustooltip.equals("No Severity Mapped")) {
					test.log(Status.PASS, "No Severity Status is displayed and verified");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		}
		catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to verify No Severity Status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, "End of Verification for No Severity Status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		}
	}