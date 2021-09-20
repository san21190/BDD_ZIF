package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelVerification;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ZIFUI_AnP_US6417_Regression extends Base {

	 //PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;
	CommonMethods cm = null;


	@Test
	public void ZIFUI_AnP_US6417_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("US 6417 - Prioritization of cases - Correlation Module");
		test.createNode("US 6417 - Prioritization of cases - Correlation Module");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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


		Thread.sleep(3000);
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Preference Tab");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.clear();
			Thread.sleep(3000);
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[11]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == true) {
				test.log(Status.PASS, "Priority is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == false) {
				WebElement valuet = driver.findElement(By.xpath("//span[text()='Enable Case Prioritization']//..//span[@class='ui-inputswitch-slider']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", valuet);
				Thread.sleep(3000);
				JavascriptExecutor jst = (JavascriptExecutor) driver;
				jst.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				test.log(Status.PASS, "Priority option is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Priority option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Selecting correlation from setting icon//
		try{
			new ZIFAI_CaseManagementPage(driver).Invokesettingicon();
			new ZIFAI_CaseManagementPage(driver).EnableCorrelation();
			test.log(Status.PASS, "Correlation is enabled");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Setting");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Report Initialization
		test = extent.createTest("Test Case 6625: Functional - 6417 - Case Management - Verify the Live Feed is applied to both Priority cases and other cases");
		test.createNode("Test Case 6625: Functional - 6417 - Case Management - Verify the Live Feed is applied to both Priority cases and other cases");


		try {
			if (new ZIFAI_CaseManagementPage(driver).livefeedon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).livefeedon.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Live Feed is paused");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).livefeedoff.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).livefeedoff.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).livefeedon.click();
				test.log(Status.PASS, "Live Feed is paused");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to Pause the feed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover bell icon for count in priority//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Bellcountpriority).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = Hoverbellicon.getText();
			System.out.println("Count of bell icon:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of bell icon before live feed is turned pause");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover Bell icon count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Hover on three dots priority//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
			test.log(Status.PASS, "Three dots icon is hovered in priority cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover three dots icon in priority cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the Device icon count//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Devicecountpriority).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = new ZIFAI_CaseManagementPage(driver).Devicecountpriority.getText();
			System.out.println("Count of Device icon:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of device icon before live feed is turned pause");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover device icon count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the Tool count//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolcountpriority).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = new ZIFAI_CaseManagementPage(driver).Toolcountpriority.getText();
			System.out.println("Count of Tool icon:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of tool icon before live feed is turned pause");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool icon count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover bell icon for count in other//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Bellcountother).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = Hoverbellicon.getText();
			System.out.println("Count of bell icon in other case:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of bell icon in other case before live feed is turned pause");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover Bell icon count in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Hover on three dots priority//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Othercasethreedots).perform();
			test.log(Status.PASS, "Three dots icon is hovered in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover three dots icon in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the Device icon count//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Devicecountother).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = new ZIFAI_CaseManagementPage(driver).Devicecountother.getText();
			System.out.println("Count of Device icon in other case:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of device icon in other case before live feed is turned pause");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover device icon count in other");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the Tool count//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolcountother).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = new ZIFAI_CaseManagementPage(driver).Toolcountother.getText();
			System.out.println("Count of Tool icon in other case:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of tool icon in other case before live feed is turned pause");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool icon count in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}




		try{
			new ZIFAI_CaseManagementPage(driver).livefeedoff.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "live feed is turned on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to switch on the live feed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover bell icon for count in priority//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Bellcountpriority).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = Hoverbellicon.getText();
			System.out.println("Count of bell icon:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of bell icon before live feed is turned on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover Bell icon count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Hover on three dots priority//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
			test.log(Status.PASS, "Three dots icon is hovered in priority cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover three dots icon in priority cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the Device icon count//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Devicecountpriority).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = new ZIFAI_CaseManagementPage(driver).Devicecountpriority.getText();
			System.out.println("Count of Device icon:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of device icon before live feed is turned on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover device icon count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the Tool count//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolcountpriority).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = new ZIFAI_CaseManagementPage(driver).Toolcountpriority.getText();
			System.out.println("Count of Tool icon:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of tool icon before live feed is turned on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool icon count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover bell icon for count in other//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Bellcountother).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = Hoverbellicon.getText();
			System.out.println("Count of bell icon in other case:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of bell icon in other case before live feed is turned on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover Bell icon count in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Hover on three dots priority//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Othercasethreedots).perform();
			test.log(Status.PASS, "Three dots icon is hovered in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover three dots icon in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the Device icon count//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Devicecountother).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = new ZIFAI_CaseManagementPage(driver).Devicecountother.getText();
			System.out.println("Count of Device icon in other case:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of device icon in other case before live feed is turned on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover device icon count in other");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the Tool count//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolcountother).perform();
			WebElement Hoverbellicon = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Hoverbelltooltip = new ZIFAI_CaseManagementPage(driver).Toolcountother.getText();
			System.out.println("Count of Tool icon in other case:" + Hoverbelltooltip);
			test.log(Status.PASS, "Count of tool icon in other case before live feed is turned on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool icon count in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Report Initialization
		test = extent.createTest("Test Case 6639: Functional - 6417 - Case Management - Verify the Prioritized and other cases by applying the Preferences Case ID and Status");
		test.createNode("Test Case 6639: Functional - 6417 - Case Management - Verify the Prioritized and other cases by applying the Preferences Case ID and Status");

		//Provide any "Case ID" in filter settings and Click the Save button Case ID: ZIFXXX - Priority Case"//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			String caseidpri = new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.getText();
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid(caseidpri);
			Thread.sleep(3000);
			String caseidprifirst = new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.getText();
			Thread.sleep(3000);
			System.out.println("Case status after filtering case id from priority : " + caseidprifirst);
			if (caseidprifirst.equals(caseidpri)) {
				test.log(Status.PASS, "Case id is displayed as filtered from preference in priority: " + caseidprifirst);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Case id is not displayed as filtered from preference in priority:");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify filtering case id in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clearing preference for other case filter validation//

		try {

			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared preference and filter for other case filter Scenario");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable clear preference and filter for other case Scenario");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Provide any "Case ID" in filter settings and Click the Save button Case ID: ZIFXXX - Other Case//
		try {
			String caseidothert = new ZIFAI_CaseManagementPage(driver).Otherfirstcaseid.getText();
			System.out.println("Other case id which is filtered" +caseidothert);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid(caseidothert);
			Thread.sleep(3000);
			String caseidothfirstt = new ZIFAI_CaseManagementPage(driver).Otherfilteredcaseid.getText();
			Thread.sleep(3000);
			System.out.println("Other case id after filtering" +caseidothfirstt);
			System.out.println("Case status after filtering case id from other case : " + caseidothfirstt);
			if (caseidothert.equals(caseidothfirstt)) {
				test.log(Status.PASS, "Case id is displayed as filtered from preference in other: " + caseidothfirstt);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if(!caseidothert.equals(caseidothfirstt)) {
				test.log(Status.FAIL, "Case id is not displayed as filtered from preference in other:");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify filtering case id in other" + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Provide the case status "exclude:Closed,exclude:New"//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("exclude:Closed, exclude:New");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			Thread.sleep(2000);
			actioncaset.moveToElement(case_first).perform();
			Thread.sleep(2000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Case status after excluding New and Closed : " + acknowldget);
			if (!acknowldget.equalsIgnoreCase("Closed")) {
				test.log(Status.PASS, "Closed status is excluded");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(!acknowldget.equalsIgnoreCase("New")){
				test.log(Status.PASS, "New status is excluded");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to verify whether New and closed is excluded " + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}


		//Provide the case status "New , In progress"//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("New,InProgress");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			actioncaset.moveToElement(case_first).perform();
			Thread.sleep(2000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Case status after including New, In Progress : " + acknowldget);
			if (acknowldget.equalsIgnoreCase("New")) {
				test.log(Status.PASS, "New case status is displayed");
			} else if(new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed()) {
				test.log(Status.FAIL, "No data is found");
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to verify whether New and Inprogress is included"+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Provide the case status "Closed"//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("Closed");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			actioncaset.moveToElement(case_first).perform();
			Thread.sleep(2000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Case status after including Closed : " + acknowldget);
			if (acknowldget.equalsIgnoreCase("Closed")) {
				test.log(Status.PASS, "Closed case status is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Closed status is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to verify whether closed status is displayed"+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Provide the case status : exclude:Assigned"//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("exclude:Assigned");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			actioncaset.moveToElement(case_first).perform();
			Thread.sleep(2000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Case status after excluding:Assinged: " + acknowldget);
			if (!acknowldget.equalsIgnoreCase("Assigned")) {
				test.log(Status.PASS, "Assigned case status is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Assigned status is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to verify whether Assigned is excluded");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Clearing the preference values//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			test.log(Status.PASS, "Clearing the values after executing US 4646");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to clear the values after executing US 4646");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Report Initialization
		test = extent.createTest("Test Case 6640: Functional - Case Management - Verify the Prioritized and other cases sections - by applying Preferences Case Status & Severity");
		test.createNode("Test Case 6640: Functional - Case Management - Verify the Prioritized and other cases sections - by applying Preferences Case Status & Severity");

		//Filter segregating "Gcare" Tool name cases//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtertoolname.sendKeys("Gcare");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Tool name is filtered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter Tool name" + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the tool name hover using first instance in priority//
		try {
			Thread.sleep(3000);
			if (new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed()) {
				test.log(Status.PASS, "No data in the Priority cases");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} if (!new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed()) {
					new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.click();
					Thread.sleep(4000);
					Actions actioncaseto = new Actions(driver);
					actioncaseto.moveToElement(new ZIFAI_CaseManagementPage(driver).CorrelatedToolnamehover).perform();
					Thread.sleep(4000);
					WebElement ack_knwtp = driver.findElement(By.cssSelector(".ui-tooltip"));
					String acknol = ack_knwtp.getText();
					System.out.println("Tool name in first instance of Priority case: " + acknol);
					if (acknol.contains("GCARE")) {
						test.log(Status.PASS, "Tool name is filtered and present in first instance of priority case");
						test.addScreenCaptureFromPath(captureScreenShot(driver));
					} else {
						test.log(Status.FAIL, "Tool name is not filtered and not present in first instance of priority case");
						test.addScreenCaptureFromPath(captureScreenShot(driver));
					}
					Thread.sleep(4000);
					new ZIFAI_CaseManagementPage(driver).AlertClose.click();
					Thread.sleep(3000);
				}
			}
		catch (Exception e) {
				test.log(Status.FAIL, "Not able to verify the tooltip with Tool name with priority case" + e);
				test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Verify the tool name hover using first instance in other case//
		try {
			new ZIFAI_CaseManagementPage(driver).Otherfirstcase.click();
			Thread.sleep(4000);
			Actions actioncaseto = new Actions(driver);
			Thread.sleep(4000);
			actioncaseto.moveToElement(new ZIFAI_CaseManagementPage(driver).CorrelatedToolnamehover).perform();
			Thread.sleep(4000);
			WebElement ack_knwtp = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknol = ack_knwtp.getText();
			System.out.println("Tool name in first instance of other case: " + acknol);
			if (acknol.equalsIgnoreCase("GCARE")) {
				test.log(Status.PASS, "Tool name is filtered and present in first instance of other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Tool name is not filtered and not present in first instance of other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify the tooltip with Tool name with other case"+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}


		//To verify when providing low in case severity in filter- Priority//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceseverity("Low");
			Thread.sleep(3000);
			if (new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed()) {
				test.log(Status.PASS, "No data in the Priority cases");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}  if (!new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed()) {

				Boolean lowval = new ZIFAI_CaseManagementPage(driver).Lowseverity.isDisplayed();
				System.out.println("Current value in case status for other:" + lowval);
				Thread.sleep(3000);
				if (lowval == true) {
					test.log(Status.PASS, "Low severity is displayed in Priority case");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else if (lowval == false) {
					test.log(Status.FAIL, "Low severity is not displayed in Priority case");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				Thread.sleep(3000);
			}
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to verify priority case with low severity"+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//To verify when providing low in case severity in filter- Other//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceseverity("Low");
			Thread.sleep(3000);
			Boolean lowval =	new ZIFAI_CaseManagementPage(driver).Lowseverity.isDisplayed();
			System.out.println("Current value in case status for other:" +lowval);
			Thread.sleep(3000);
			if(lowval==true){
				test.log(Status.PASS, "Low severity is displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(lowval==false){
				test.log(Status.FAIL, "Low severity is not displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to verify other case with low severity"+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Report Initialization
		test = extent.createTest("Test Case 6641: Functional - 6417 - Case Management - Verify the priority and other cases sections by cancelling the inputs in preferences");
		test.createNode("Test Case 6641: Functional - 6417 - Case Management - Verify the priority and other cases sections by cancelling the inputs in preferences");

		try {
			new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferences_Severity.sendKeys("High");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Prefcancel.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
			Thread.sleep(3000);
			String status_valuepr = new ZIFAI_CaseManagementPage(driver).Preferences_Severity.getAttribute("value");
			System.out.println("Current value in case status:" +status_valuepr);
			Thread.sleep(3000);
			if(status_valuepr.equalsIgnoreCase("Low")){
				test.log(Status.PASS, "New status remains same when closed value is entered and cancelled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "New status is not same when value is entered and cancelled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAI_CaseManagementPage(driver).Prefcancel.click();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to verify preference when entering and hitting cancel button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the values in preference to proceed with next step//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceseverity("");
			Thread.sleep(3000);
			test.log(Status.PASS, "Preference value is cleared for next step");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter new cases using preference to proceed with next step");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Filter segregating "High" severity cases//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterseverity.sendKeys("High");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "High severity value has been applied in filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter high severity using filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying after entering value in preference again previously entered value should remain constant//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterseverity.clear();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterseverity.sendKeys("low");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			String status_valuepr = new ZIFAI_CaseManagementPage(driver).Filterseverity.getAttribute("value");
			System.out.println("Current value in case status:" +status_valuepr);
			Thread.sleep(3000);
			if(status_valuepr.equalsIgnoreCase("High")){
				test.log(Status.PASS, "High severity remains same when low value is entered and closed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "High severity is not same when value is entered and cancelled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to verify preference when entering and hitting closed button in filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the values in preference to proceed with next step//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			Thread.sleep(3000);
			test.log(Status.PASS, "Preference value is cleared for next step US 6642");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter new cases using preference to proceed with next step in US 6642");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Report Initialization
		test = extent.createTest("Test Case 6642: Functional - 6417 - Other cases - Verify the detail screen content and tooltip display");
		test.createNode("Test Case 6642: Functional - 6417 - Other cases - Verify the detail screen content and tooltip display");


		//Verifying after entering value in preference again previously entered value should remain constant//
		try {
			List<WebElement> casestatus = new ZIFAI_CaseManagementPage(driver).RHSiconhover;
			List<WebElement> case_status = new ZIFAI_CaseManagementPage(driver).RHSiconhover;
			new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.click();
			Thread.sleep(3000);
			int i;
			for (i = 1; i < casestatus.size() - 9; i = i + 1) {
				System.out.println(casestatus.size());
				Actions action = new Actions(driver);
				Thread.sleep(2000);
				action.moveToElement(case_status.get(i)).perform();
				WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
				String iconpanel = Case_status.getText();
				System.out.println("Icon panel icon are checked whether it is displayed : "+iconpanel);
				test.log(Status.PASS, "Icon panel icons are verified whether it is displayed : "+iconpanel);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			int j;
			for (j = 9; j < casestatus.size(); j = j + 1) {
				System.out.println(casestatus.size());
				String iconpanelcount = case_status.get(j).getText();
				System.out.println("Icon panel count are checked whether count is displayed to the respective icon : "+iconpanelcount );
				test.log(Status.PASS, "Icon panel icons aer verified whether count is displayed to the respective icon : "+iconpanelcount);
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
		}
		catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to hover icon on the RHS icon panel");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Case ID label, acknowledge, Export, Edit, Expand, up arrow, close
		try{
			Boolean Caseidstatus = new ZIFAI_CaseManagementPage(driver).CaseidRHS.isDisplayed();
			Boolean Exportstatus = new ZIFAI_CaseManagementPage(driver).AlertExport.isDisplayed();
			Boolean Editstatus = new ZIFAI_CaseManagementPage(driver).AlertEdit.isDisplayed();
			Boolean Expand =new ZIFAI_CaseManagementPage(driver).AlertExport.isDisplayed();
			Boolean Acknowledge = new ZIFAI_CaseManagementPage(driver).AlertAcknowledge.isDisplayed();
			Boolean Alertclose = new ZIFAI_CaseManagementPage(driver).AlertClose.isDisplayed();
			if(Acknowledge==true) {
				test.log(Status.PASS, "Acknowledge label is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Acknowledge==false){
				test.log(Status.PASS, "Acknowledge label is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Caseidstatus==true) {
				test.log(Status.PASS, "Case id label is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Caseidstatus==false){
				test.log(Status.PASS, "Case id label is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Exportstatus==true) {
				test.log(Status.PASS, "Export label is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Exportstatus==false){
				test.log(Status.PASS, "Export label is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Editstatus==true) {
				test.log(Status.PASS, "Edit label is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Editstatus==false){
				test.log(Status.PASS, "Edit label is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Expand==true) {
				test.log(Status.PASS, "Expand label is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Expand==false){
				test.log(Status.PASS, "Expand label is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Alertclose==true) {
				test.log(Status.PASS, "Close label is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Alertclose==false){
				test.log(Status.PASS, "Close label is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the RHS options case id,acknoledge,export,expand"+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify acknowledge icon hovers the user who has acknowledged it//
		try{
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("zifadmin@zif.ai");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.click();
			Thread.sleep(3000);
			Actions actothervalt = new Actions(driver);
			actothervalt.moveToElement(new ZIFAI_CaseManagementPage(driver).Acknowledgehoverdetail).perform();
			WebElement Othervalt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Threedotvaltl = Othervalt.getText();
			System.out.println("Acknowledge icon is hovered and the user who did it is : " + Threedotvaltl);
			if (Threedotvaltl.contains("zifadmin@zif.ai")) {
				test.log(Status.PASS, "Acknowledged icon is hovered and the user who acknowledged is :  " + Threedotvaltl);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Threedotvaltl.contains("zifadmin@zif.ai")) {
				System.out.println("Acknowledged icon is hovered and the user who acknowledged is unable to verify");
				test.log(Status.FAIL, "Acknowledged icon is hovered and the user who acknowledged is unable to verify");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CorrelatedALerts.click();
		}
		catch (Exception e){
			System.out.println(e);
			test.log(Status.FAIL, "Unable to verify the acknowledge icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify Correlated alerts,Timeline and Root cause//
		try {
			Thread.sleep(3000);
		Boolean costatus =	new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (costatus) {
				test.log(Status.PASS, "No data is displayed in correlated alerts");
				test.addScreenCaptureFromPath(captureScreenShot(driver));}
			if (!costatus) {
					Thread.sleep(3000);
					Actions action = new Actions(driver);
					action.moveToElement(new ZIFAI_CaseManagementPage(driver).correlatedalertscountfirst).perform();
					WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
					String iconpanel = Case_status.getText();
					System.out.println("Device name: " + iconpanel);
					test.log(Status.PASS, "Device name: " + iconpanel);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
					Actions actionval = new Actions(driver);
					actionval.moveToElement(new ZIFAI_CaseManagementPage(driver).correlatedalertscountvaluesecond).perform();
					WebElement actionvall = driver.findElement(By.cssSelector(".ui-tooltip"));
					String actionvle = actionvall.getText();
					System.out.println("Type name " + actionvle);
					test.log(Status.PASS, "Type name: " + actionvle);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
					Actions Descval = new Actions(driver);
					Descval.moveToElement(new ZIFAI_CaseManagementPage(driver).correlatedalertscountvaluesthird).perform();
					WebElement Descvalo = driver.findElement(By.cssSelector(".ui-tooltip"));
					String Descicon = Descvalo.getText();
					System.out.println("Tool name: " + Descicon);
					test.log(Status.PASS, "Tool name: " + Descicon);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
					new ZIFAI_CaseManagementPage(driver).Timeline.click();
				}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify correlated alerts columns "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover on the Case id , Severity , Status in LHS hover values//

		try {
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.moveToElement(new ZIFAI_CaseManagementPage(driver).Caseidcorrelation).perform();
			WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
			String iconpanel = Case_status.getText();
			System.out.println("Case id in LHS: " +iconpanel);
			test.log(Status.PASS, "Case id in LHS: " +iconpanel);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			Actions actionval = new Actions(driver);
			actionval.moveToElement(new ZIFAI_CaseManagementPage(driver).Severitcorrelate).perform();
			WebElement actionvall = driver.findElement(By.cssSelector(".ui-tooltip"));
			String actionvle = actionvall.getText();
			System.out.println("Severity in LHS: " +actionvle);
			test.log(Status.PASS, "Severity in LHS: " +actionvle);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			Actions Descval = new Actions(driver);
			Descval.moveToElement(new ZIFAI_CaseManagementPage(driver).Casestatuscorrelate).perform();
			WebElement Descvalo = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Descicon = Descvalo.getText();
			System.out.println("Case status in LHS: " +Descicon);
			test.log(Status.PASS, "Case status in LHS: " +Descicon);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			new ZIFAI_CaseManagementPage(driver).Otherfirstcaseid.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify correlated alerts columns2"+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating options in other cases with RHS and LHS//

		try {
			List<WebElement> casestatus = new ZIFAI_CaseManagementPage(driver).RHSiconhover;
			List<WebElement> case_status = new ZIFAI_CaseManagementPage(driver).RHSiconhover;
			Thread.sleep(3000);
			int i;
			for (i = 1; i < casestatus.size() - 9; i = i + 1) {
				System.out.println(casestatus.size());
				Actions action = new Actions(driver);
				Thread.sleep(2000);
				action.moveToElement(case_status.get(i)).perform();
				WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
				String iconpanel = Case_status.getText();
				System.out.println("Icon panel icon are checked whether it is displayed in other case : "+iconpanel);
				test.log(Status.PASS, "Icon panel icons are verified whether it is displayed in other case : "+iconpanel);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			int j;
			for (j = 9; j < casestatus.size(); j = j + 1) {
				System.out.println(casestatus.size());
				String iconpanelcount = case_status.get(j).getText();
				System.out.println("Icon panel count are checked whether count is displayed to the respective icon : "+iconpanelcount );
				test.log(Status.PASS, "Icon panel icons aer verified whether count is displayed to the respective icon : "+iconpanelcount);
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
		}
		catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to hover icon on the RHS icon panel of other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Case ID label, acknowledge, Export, Edit, Expand, up arrow, close
		try{
			Boolean Caseidstatus = new ZIFAI_CaseManagementPage(driver).CaseidRHS.isDisplayed();
			Boolean Exportstatus = new ZIFAI_CaseManagementPage(driver).AlertExport.isDisplayed();
			Boolean Editstatus = new ZIFAI_CaseManagementPage(driver).AlertEdit.isDisplayed();
			Boolean Expand =new ZIFAI_CaseManagementPage(driver).AlertExport.isDisplayed();
			Boolean Acknowledge = new ZIFAI_CaseManagementPage(driver).AlertAcknowledge.isDisplayed();
			Boolean Alertclose = new ZIFAI_CaseManagementPage(driver).AlertClose.isDisplayed();
			if(Acknowledge==true) {
				test.log(Status.PASS, "Acknowledge label is displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Acknowledge==false){
				test.log(Status.PASS, "Acknowledge label is not displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Caseidstatus==true) {
				test.log(Status.PASS, "Case id label is displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Caseidstatus==false){
				test.log(Status.PASS, "Case id label is not displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Exportstatus==true) {
				test.log(Status.PASS, "Export label is displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Exportstatus==false){
				test.log(Status.PASS, "Export label is not displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Editstatus==true) {
				test.log(Status.PASS, "Edit label is displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Editstatus==false){
				test.log(Status.PASS, "Edit label is not displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Expand==true) {
				test.log(Status.PASS, "Expand label is displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Expand==false){
				test.log(Status.PASS, "Expand label is not displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Alertclose==true) {
				test.log(Status.PASS, "Close label is displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Alertclose==false){
				test.log(Status.PASS, "Close label is not displayed in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the RHS options case id,acknoledge,export,expand " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify acknowledge icon hovers the user who has acknowledged it//
		try{
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("zifadmin@zif.ai");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Otherfirstcaseid.click();
			Thread.sleep(3000);
			Actions actothervalt = new Actions(driver);
			actothervalt.moveToElement(new ZIFAI_CaseManagementPage(driver).Acknowledgehoverdetail).perform();
			WebElement Othervalt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Threedotvaltl = Othervalt.getText();
			System.out.println("When hovered on Acknowledgment icon and user who acknowledged it: " + Threedotvaltl);
			if (Threedotvaltl.contains("zifadmin@zif.ai")) {
				test.log(Status.PASS, "Acknowledged icon is hovered and the user who acknowledged is :  " + Threedotvaltl);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Threedotvaltl.contains("zifadmin@zif.ai")) {
				System.out.println("Acknowledged icon is hovered and the user who acknowledged is unable to verify");
				test.log(Status.FAIL, "Acknowledged icon is hovered and the user who acknowledged is unable to verify");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Otherfirstcaseid.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CorrelatedALerts.click();
		}
		catch (Exception e){
			System.out.println(e);
			test.log(Status.FAIL, "Unable to verify the acknowledge icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify Correlated alerts,Timeline and Root cause//
		try {
			Thread.sleep(3000);
					Actions action = new Actions(driver);
					action.moveToElement(new ZIFAI_CaseManagementPage(driver).correlatedalertscountfirst).perform();
					WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
					String iconpanel = Case_status.getText();
					System.out.println("Device name: " + iconpanel);
					test.log(Status.PASS, "Device name: " + iconpanel);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
					Actions actionval = new Actions(driver);
					actionval.moveToElement(new ZIFAI_CaseManagementPage(driver).correlatedalertscountvaluesecond).perform();
					WebElement actionvall = driver.findElement(By.cssSelector(".ui-tooltip"));
					String actionvle = actionvall.getText();
					System.out.println("Type name " + actionvle);
					test.log(Status.PASS, "Type name: " + actionvle);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
					Actions Descval = new Actions(driver);
					Descval.moveToElement(new ZIFAI_CaseManagementPage(driver).correlatedalertscountvaluesthird).perform();
					WebElement Descvalo = driver.findElement(By.cssSelector(".ui-tooltip"));
					String Descicon = Descvalo.getText();
					System.out.println("Tool name: " + Descicon);
					test.log(Status.PASS, "Tool name: " + Descicon);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
					new ZIFAI_CaseManagementPage(driver).Timeline.click();


		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify correlated alerts columns3"+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover on the Case id , Severity , Status in LHS hover values//

		try {
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.moveToElement(new ZIFAI_CaseManagementPage(driver).Caseidcorrelation).perform();
			WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
			String iconpanel = Case_status.getText();
			System.out.println("Case id in LHS: " +iconpanel);
			test.log(Status.PASS, "Case id in LHS: " +iconpanel);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			Actions actionval = new Actions(driver);
			actionval.moveToElement(new ZIFAI_CaseManagementPage(driver).Severitcorrelate).perform();
			WebElement actionvall = driver.findElement(By.cssSelector(".ui-tooltip"));
			String actionvle = actionvall.getText();
			System.out.println("Severity in LHS: " +actionvle);
			test.log(Status.PASS, "Severity in LHS: " +actionvle);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			Actions Descval = new Actions(driver);
			Descval.moveToElement(new ZIFAI_CaseManagementPage(driver).Casestatuscorrelate).perform();
			WebElement Descvalo = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Descicon = Descvalo.getText();
			System.out.println("Case status in LHS: " +Descicon);
			test.log(Status.PASS, "Case status in LHS: " +Descicon);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify correlated alerts columns4"+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//-------------------------------End of US 6642------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6627: Functional - 6417 - Priority Cases - Verify the options available in three dot icon present next to bell icon count");
		test.createNode("Test Case 6627: Functional - 6417 - Priority Cases - Verify the options available in three dot icon present next to bell icon count");

		//Test Case 6627: Functional - 6417 - Priority Cases - Verify the options available in three dot icon present next to bell icon count//

		//Mouse hover the bell icon and verify the count after clicking on three dots .
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Belliconpr).perform();
			test.log(Status.PASS, "Bell icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover bell icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Mouse hover below the bell icon for count and verify the count after clicking on three dots .
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Bellcountpr).perform();
			test.log(Status.PASS, "Bell icon count is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover bell icon count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the three dot icon present next to bell icon count and verify the server icon.
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
			test.log(Status.PASS, "Three dots icon is hovered in priority cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover three dots icon in priority cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the server icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Serverpr).perform();
			test.log(Status.PASS, "server icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover server icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the server names//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Servernamepr).perform();
			test.log(Status.PASS, "server name is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover server name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the tool icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolpr).perform();
			test.log(Status.PASS, "tool icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the tool names//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolnamepr).perform();
			test.log(Status.PASS, "tool name is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the application icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Appnpr).perform();
			test.log(Status.PASS, "application icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover application icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the application names//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Appnamepr).perform();
			test.log(Status.PASS, "application name is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover application name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the avg est time icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Avgesttimepr).perform();
			test.log(Status.PASS, "avg est time icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover avg est time icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}




		//Mouse hover the est time to complete icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).ETItimepr).perform();
			test.log(Status.PASS, "est time to complete icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover est time to complete icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the false probability icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Falseprbpr).perform();
			test.log(Status.PASS, "false probability icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover false probability icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the correlation accuracy icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Correlationpr).perform();
			test.log(Status.PASS, "correlation accuracy icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover correlation accuracy icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}




		//Mouse hover the pattern based threshold icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Patternbasedpr).perform();
			test.log(Status.PASS, "pattern based threshold icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover correlation accuracy icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}




		//-------------------------------End of US 6627------------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 6626: Functional - 6417 - Priority Cases - Verify the options available in three dot icon present next to bell icon count");
		test.createNode("Test Case 6626: Functional - 6417 - Priority Cases - Verify the options available in three dot icon present next to bell icon count");

		//Test Case 6626: Functional - 6417 - Other Cases - Verify the options available in three dot icon present next to bell icon count//

		//Mouse hover the bell icon and verify the count after clicking on three dots .
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Belliconor).perform();
			test.log(Status.PASS, "Bell icon is mouse hovered in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover bell icon in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Mouse hover below the bell icon for count and verify the count after clicking on three dots .
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Bellcountother).perform();
			test.log(Status.PASS, "Bell icon count is mouse hovered in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover bell icon count in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the three dot icon present next to bell icon count and verify the server icon.
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Otherthreedots).perform();
			test.log(Status.PASS, "Three dots icon is hovered in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover three dots icon in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the server icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Serveror).perform();
			test.log(Status.PASS, "server icon is mouse hovered  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover server icon  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the server names//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Servernameor).perform();
			test.log(Status.PASS, "server name is mouse hovered  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover server name  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the tool icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolor).perform();
			test.log(Status.PASS, "tool icon is mouse hovered  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool icon  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the tool names//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolnameor).perform();
			test.log(Status.PASS, "tool name is mouse hovered  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool name  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the application icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Appnor).perform();
			test.log(Status.PASS, "application icon is mouse hovered  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover application icon  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the application names//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Appnameor).perform();
			test.log(Status.PASS, "application name is mouse hovered  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover application name  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the avg est time icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Avgesttimeor).perform();
			test.log(Status.PASS, "avg est time icon is mouse hovered  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover avg est time icon  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}




		//Mouse hover the est time to complete icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).ETItimeor).perform();
			test.log(Status.PASS, "est time to complete icon is mouse hovered  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover est time to complete icon  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the false probability icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Falseprbor).perform();
			test.log(Status.PASS, "false probability icon is mouse hovered in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover false probability icon  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the correlation accuracy icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Correlationor).perform();
			test.log(Status.PASS, "correlation accuracy icon is mouse hovered in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover correlation accuracy icon in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}




		//Mouse hover the pattern based threshold icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Patternbasedor).perform();
			test.log(Status.PASS, "pattern based threshold icon is mouse hovered  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover correlation accuracy icon  in other cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//--------------------------------------End of US 6626-----------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6643: Functional - 6417 - Verify the Case Acknowledgement in both modes (Priority and Other cases)");
		test.createNode("Test Case 6643: Functional - 6417 - Verify the Case Acknowledgement in both modes (Priority and Other cases)");


		//Click the Acknowledgement icon and Verify the tooltip after the acknowledgement action
		try {
			new ZIFAI_CaseManagementPage(driver).CaseUnacknowledgeFilter();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.click();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).Alertmanualunack.click();
			Thread.sleep(2000);
			test.log(Status.PASS, " Clicked on the Acknowledgement icon and Verified acknowledgement action in priority case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to click the acknowledgement icon and verify the acknowledgement action in priority case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Ensure the acknowledgement icon is disabled for the user's action once it is acknowledged//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseacknowledgeFilter();
			new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.click();
			Thread.sleep(3000);
			Actions cqseacknowl = new Actions(driver);
			cqseacknowl.moveToElement(new ZIFAI_CaseManagementPage(driver).Acknowledgehoverdetail).perform();
			WebElement Ackzif = driver.findElement(By.cssSelector(".ui-tooltip"));
			Thread.sleep(2000);
			String Acknledgestatus = Ackzif.getText();
			System.out.println("Acknowledgement is already done and user who has done it and icon is disabled in priority case: " +Acknledgestatus);
			test.log(Status.PASS, "Acknowledgement is already done and user who has done it and icon is disabled in priority case:  " +Acknledgestatus);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify if acknowledgement icon is disabled");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click the Acknowledgement icon and Verify the tooltip after the acknowledgement action(other cases)
		try {
			new ZIFAI_CaseManagementPage(driver).CaseUnacknowledgeFilter();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Otherfirstcaseid.click();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).Alertmanualunack.click();
			Thread.sleep(2000);
			test.log(Status.PASS, " Clicked on the Acknowledgement icon and Verified  acknowledgement action in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to click the acknowledgement icon and verifythe acknowledgement  action in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Ensure the acknowledgement icon is disabled for the user's action once it is acknowledged//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CaseacknowledgeFilter();
			new ZIFAI_CaseManagementPage(driver).Otherfirstcaseid.click();
			Thread.sleep(3000);
			Actions cqseacknowl = new Actions(driver);
			cqseacknowl.moveToElement(new ZIFAI_CaseManagementPage(driver).Acknowledgehoverdetail).perform();
			WebElement Ackzif = driver.findElement(By.cssSelector(".ui-tooltip"));
			Thread.sleep(2000);
			String Acknledgestatus = Ackzif.getText();
			System.out.println("Acknowledgement is already done and user who has done it and icon is disabled in other case: " +Acknledgestatus);
			test.log(Status.PASS, "Acknowledgement is already done and user who has done it and icon is disabled in other case:  " +Acknledgestatus);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify if acknowledgement icon is disabled in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//------------------------------------End of US 6643-------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 6628: Functional - 6417 - Verify the Case total count of Priority and Other cases in case management screen");
		test.createNode("Test Case 6628: Functional - 6417 - Verify the Case total count of Priority and Other cases in case management screen");


		//Verify the Case total count of Priority and Other cases in case management screen//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(","").replace(")","").replace("All","").trim();
			Thread.sleep(3000);
			System.out.println("Priority Overall_Case_count:" + Case_count1);
			test.log(Status.PASS, "Priority Total case count: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the Priority case count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Count of other cases US 5364 //

		try {
			Thread.sleep(2000);
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Othercasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Other cases section overall_Case_count:" + Case_count1);
			test.log(Status.PASS, "Other cases section overall_Case_count: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the other cases section case count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Ensure the Case (N) total count is getting updated on every new
		//case ID in  Other cases section
		try {
			Thread.sleep(10000);
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Othercasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Count of other cases section after new case is pushed:" + Case_count1);
			test.log(Status.PASS, "Count of other cases section after new case is pushed: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the other cases section case count after new case is pushed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Ensure the Case (N) total count is getting updated on every new
		//case ID in  Priority cases section

		try {
			Thread.sleep(10000);
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Count of priority cases section after new case is pushed:" + Case_count1);
			test.log(Status.PASS, "Count of priority cases section after new case is pushed: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the priority cases section case count after new case is pushed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Ensure the count is displayed in tooltip without any decimal value in other section//
		try {
			//Instantiate Action Class
			Actions actions = new Actions(driver);
			WebElement toolTip = driver.findElement(By.xpath("//span[@class='prior-first' and contains(text(),'Other')]"));
			Thread.sleep(3000);
			// Using the action class to mimic mouse hover
			actions.moveToElement(toolTip).perform();
			test.log(Status.PASS, "Other Case count is hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover the other count tooltip");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Ensure the count is displayed in tooltip without any decimal value in Priority section//
		try {
			//Instantiate Action Class
			Actions actions = new Actions(driver);
			WebElement toolTip = driver.findElement(By.xpath("//span[@class='prior-first' and contains(text(),'Priority')]"));
			Thread.sleep(2000);
			// Using the action class to mimic mouse hover
			actions.moveToElement(toolTip).perform();
			test.log(Status.PASS, "Priority Case status is hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover the Priority count tooltip");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-----------------------------------------End of US 6628------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6629: Functional - 6417 - Verify the cases displayed in Priority and Other cases are mutually exclusive");
		test.createNode("Test Case 6629: Functional - 6417 - Verify the cases displayed in Priority and Other cases are mutually exclusive");

		try {
			Thread.sleep(3000);
			String Case_countst = new ZIFAI_CaseManagementPage(driver).Othercasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			String Case_countsty = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Count of other cases section after new case is pushed:" + Case_countst);
			test.log(Status.PASS, "Count of other cases section after new case is pushed: " + Case_countst);
			System.out.println("Count of other cases section after new case is pushed:" + Case_countsty);
			test.log(Status.PASS, "Count of other cases section after new case is pushed: " + Case_countsty);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the other and priority cases section case count after new case is pushed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		SoftAssert softAssert = new SoftAssert();
		//Method to Verify the cases present in Other section are not displayed in Priority cases section
		try {
			Thread.sleep(3000);
			List<String> Text_LeftPane = new ArrayList<String>();
			int size_LeftPane = driver.findElements(By.xpath("//ngx-smart-loader[@identifier='priorityLoader']//..//div[@class='case-outer ng-star-inserted']")).size();
			for (int i = 1; i<=size_LeftPane; i++) {
				String text = driver.findElement(By.xpath("(//ngx-smart-loader[@identifier='priorityLoader']//..//div[@class='case-outer ng-star-inserted'])[" + i + "]")).getText().substring(0, 9).replace("|", "").replace("2020", "").replace("2021", "").trim();
				Text_LeftPane.add(text);
			}
			System.out.println("Text Present in Left Pane - " + Text_LeftPane);

			List<String> Text_RightPane = new ArrayList<String>();
			int size_RightPane = driver.findElements(By.xpath("//*[@class=\"cases-full-outer-prior-ryt\"]/div")).size();
			for (int i = 1; i<=size_RightPane; i++) {
				String text = driver.findElement(By.xpath("(//*[@class=\"cases-full-outer-prior-ryt\"]/div)[" + i + "]")).getText().substring(0, 9).replace("|", "").replace("2020", "").replace("2021", "").trim();
				Text_RightPane.add(text);
			}
			System.out.println("Text Present in Right Pane - " + Text_RightPane);

			for(String item: Text_LeftPane){
				if(Text_RightPane.contains(item)){
					System.out.println("Duplicate Case id - " + item);
					test.log(Status.FAIL, "Both Priority and other case id is same"+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}



			test.log(Status.PASS, "verified priority cases whether any duplicate cases are displayed and case id's are unique");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify priority cases whether any duplicate cases are displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//------------------------------------------End of US 6629----------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 6638: Functional - 6417 - Case Management - Verify the Excel export with or without applying filters/preferences in both modes (Priority cases and other cases)");
		test.createNode("Test Case 6638: Functional - 6417 - Case Management - Verify the Excel export with or without applying filters/preferences in both modes (Priority cases and other cases)");


		//Clearing all values in filter and preference//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing all values from filter and preference before export");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear values before export");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clicking the filter for selecting the date//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).RawalertsCalendarlink.click();
			Thread.sleep(2000);
			test.log(Status.PASS, "Date is selected from the picker using filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to Verify the Date picker is working for all the time selected by the user");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		try {
//			WebElement beforemonth = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-prev-icon')]"));
			Thread.sleep(2000);
			if (new ZIFAI_CaseManagementPage(driver).Prevmonth.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).Prevmonth.click();
			}
			WebElement dateone = driver.findElement(By.xpath("//a[text()='1']"));
			WebElement datete = driver.findElement(By.xpath("//a[text()='28']"));
			Thread.sleep(2000);
			dateone.click();
			Thread.sleep(2000);
			datete.click();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).RawalertsCalendarlink.click();
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to Verify the Date picker is working for all the time selected by the user");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on export and verify the particular case id is present in excel when filtered using preference//
		cm.deleteAllFilesInFolder(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(4000);
			String firstcase = new ZIFAI_CaseManagementPage(driver).Otherfilteredcaseid.getText().replace("ZIF","").trim();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtercaseid.sendKeys(firstcase);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(5000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			if(excel.contains(firstcase)){
				test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "Unable to filter new case and verify though excel");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			System.out.println("Read Excel" + excel);

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to click on preference and export"+e.getMessage());
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing all values in filter and preference after export//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing all values from filter and preference after export");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear values after export");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//----------------------------------End of US-----------------------------------------------------------//







	}
}


