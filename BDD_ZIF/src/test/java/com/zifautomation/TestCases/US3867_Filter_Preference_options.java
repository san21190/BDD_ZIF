package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class US3867_Filter_Preference_options extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;


	@Test
	public void US3867_Filter_Preference_options() throws IOException, InterruptedException {

		//Report
		test = extent.createTest("US 3867 Case Details - Filter / Preference options");
		test.createNode("US 3867 Case Details - Filter / Preference options");


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

		//Report
		test = extent.createTest("US 3867 Case count verification based on the inputs given under filters or preferences in Case Details page");
		test.createNode("US 3867 Case count verification based on the inputs given under filters or preferences in Case Details page");

		//Click on the first case from Case Management page and verifying the count and case id from
		//left pane and middle pane.

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

		//Clearing the values before validation//

		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			test.log(Status.PASS, "clearing preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "clearing preference");
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

		//Setting option is selected form case management

//		try {
//			if (new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.isDisplayed()) {
//				Thread.sleep(3000);
//				new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.click();
//				Thread.sleep(3000);
//				test.log(Status.PASS, "Setting icon is selected");
//				test.addScreenCaptureFromPath(captureScreenShot(driver));
//			} else if (new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.isDisplayed()) {
//				test.log(Status.FAIL, "Setting icon is not selected");
//				test.addScreenCaptureFromPath(captureScreenShot(driver));
//			}
//		} catch (Exception e) {
//			test.log(Status.FAIL, e);
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}

		//Correlation slider is selected from setting option
//		try {
//			Thread.sleep(3000);
//			Boolean status = driver.findElement(By.xpath("/html/body/app-root/app-home-header/div/div[2]/app-case-mgmt-dash/div[4]/p-dialog/div/div/div[2]/div[2]/div[2]/span[2]/p-inputswitch/div/div/input")).isSelected();
//			System.out.println("attribute: " + status);
//			Thread.sleep(3000);
//			if (status == true) {
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
//				Thread.sleep(3000);
//				new ZIFAI_CaseManagementPage(driver).warningokbutton.click();
//				Thread.sleep(3000);
//				test.log(Status.PASS, "Warning button is handled");
//				test.addScreenCaptureFromPath(captureScreenShot(driver));
//				Thread.sleep(2000);
//				test.log(Status.PASS, "Correlation is already enabled");
//				test.addScreenCaptureFromPath(captureScreenShot(driver));
//				Thread.sleep(3000);
//			} else if (status == false) {
//				new ZIFAI_CaseManagementPage(driver).EnableCorrelation.click();
//				Thread.sleep(3000);
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
//				Thread.sleep(3000);
//				new ZIFAI_CaseManagementPage(driver).warningokbutton.click();
//				Thread.sleep(3000);
//				test.log(Status.PASS, "Warning button is handled");
//				test.addScreenCaptureFromPath(captureScreenShot(driver));
//				Thread.sleep(2000);
//				test.log(Status.PASS, "Enable Correlation toggle is selected");
//				test.addScreenCaptureFromPath(captureScreenShot(driver));
//
//			}
//		} catch (Exception e) {
//			test.log(Status.FAIL, e);
//			test.log(Status.FAIL, "Enable Correlation toggle is not selected");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}

		//Applying values to Preference//

		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("New");
			test.log(Status.PASS, "New case status is applied to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to apply new status to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Applying new case status and getting the count//
		try {
			String Case_countSizeval = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replaceAll("All", "").replace(")", "").replace("(", "").trim();
			test.log(Status.PASS, "Overall count after filtering new cases is: " + Case_countSizeval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to get the count after applying new case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing values to Preference//

		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			test.log(Status.PASS, "New case status is applied to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to apply new status to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the values in preference and getting the overall count//

		try {
			String Case_countSizeval1 = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replaceAll("All", "").replace(")", "").replace("(", "").trim();
			test.log(Status.PASS, "Overall count after clearing the values: " + Case_countSizeval1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to get the count after clearing preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//----------------------------------------End of US-------------------------------------------//

		//Report
		test = extent.createTest("US 4642  Case Details - Correlation - Preferences Acknowledgement Status");
		test.createNode("US 4642  Case Details - Correlation - Preferences Acknowledgement Status");
		try {
			new ZIFAI_CaseManagementPage(driver).clickingonfirstcase();
			test.log(Status.PASS, "Clicking on the first case from case management page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to click on first case from case management page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

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

		//Verifying the tooltip with text contains acknowledge//
		try {
			Actions actioncase = new Actions(driver);
			Thread.sleep(2000);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).AlertAcknowledge).perform();
			Thread.sleep(2000);
			WebElement ack_knw = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldge = ack_knw.getText();
			System.out.println("status :" +acknowldge);
			if (acknowldge.equals("acknowledge")) {
				test.log(Status.PASS, "First case is displayed with unacknowledged icon");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "First case is not displayed with unacknowledged icon");

		}


		//Applying values to Preference - Unacknowledged//

		try {
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("zifadmin@zif.ai");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).clickingonfirstcase();
			test.log(Status.PASS, "zifadmin@zif.ai is applied to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "zifadmin@zif.ai is applied to preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying the tooltip with text contains acknowledge//
		try {
			Actions actioncase = new Actions(driver);
			Thread.sleep(2000);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).AlertAcknowledge).perform();
			Thread.sleep(2000);
			WebElement ack_knw = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldge = ack_knw.getText();
			System.out.println("status :" + acknowldge);
			if (acknowldge.equals("zifadmin@zif.ai")) {
				test.log(Status.PASS, "First case is displayed with zifadmin@zif.ai icon");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "First case is not displayed with zifadmin@zif.ai icon");

		}

		//Applying values to Preference - Unacknowledged//

		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			test.log(Status.PASS, "Cleared preference values");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear preference values");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//----------------------------------------End of US-------------------------------------------//

		//Case Details - Filter Options(No Data Found)//

		test = extent.createTest("US 4641 Case Details - Filter Options(No Data Found)");
		test.createNode("US 4641 Case Details - Filter Options(No Data Found)");

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

		//Selecting the date from filter//

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

		//Getting the count after applying date range using Filter//
		try {
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after applying date range: " + countdate);
			Thread.sleep(3000);
			test.log(Status.PASS, "Count after applying date range" + countdate);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to Verify the Date picker is working for all the time selected by the user");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the date from filter//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).Filtercloseicon.click();
			Thread.sleep(2000);
			test.log(Status.PASS, "Date range is cleared from filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear the date range");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Getting the count after clearing date range using Filter//
		try {
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			Thread.sleep(3000);
			System.out.println("Count after clearing date range: " + countdate);
			test.log(Status.PASS, "Count after clearing date range: " + countdate);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after clearing date range");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Provide any invalid data in "Case ID" Filter text box and Click the Apply button Case ID - XXX//

		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtercaseid.sendKeys("xxx");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Successfully entered xxx in Filter case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to enter xxx in Filter case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Getting the count after providing invalid case id in filter//
		try {
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after passing invalid caseid: " + countdate);
			test.log(Status.PASS, "Count after passing invalid caseid" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				test.log(Status.FAIL, "Invalid case id is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				test.log(Status.PASS, "Invalid case id is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid caseid");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Provide any invalid data in "Severity" Filter text box and Click the Apply button Case ID - XXX//

		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterseverity.sendKeys("JJJ");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Successfully entered JJJ in Filter severity");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to enter xxx in Filter severity");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Getting the count after providing invalid severity input in filter//
		try {
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after passing invalid severity input: " + countdate);
			test.log(Status.PASS, "Count after passing invalid severity input" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				test.log(Status.FAIL, "Invalid severity is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				test.log(Status.PASS, "Invalid severity is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid severity input");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Provide any invalid data in "Device name" Filter text box and Click the Apply button Device name - NNN//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterdevicename.sendKeys("NNN");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Successfully entered NNN in Filter device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to enter xxx in Filter device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Getting the count after providing invalid device name input in filter//
		try {
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after passing invalid device name: " + countdate);
			test.log(Status.PASS, "Count after passing invalid device name" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				test.log(Status.FAIL, "Invalid device name is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				test.log(Status.PASS, "Invalid device is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Provide any invalid data in "Tool name" Filter text box and Click the Apply button Tool Name - JJJ//

		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtertoolname.sendKeys("JJJ");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Successfully entered JJJ in Filter tool name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to enter JJJ in Filter tool name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Getting the count after providing invalid tool name input in filter//
		try {
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after passing invalid tool name: " + countdate);
			test.log(Status.PASS, "Count after passing invalid tool name" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				test.log(Status.FAIL, "Invalid tool name is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				test.log(Status.PASS, "Invalid device is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid tool name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Provide any invalid data in "Description" Filter text box and Click the Apply button Description -  dghrthyrty//

		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtercasedescription.sendKeys("dghrthyrty");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Successfully entered dghrthyrty in Filter description");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to enter dghrthyrty in Filter description");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Getting the count after providing invalid description input in filter//
		try {
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after passing invalid description: " + countdate);
			test.log(Status.PASS, "Count after passing description" + countdate);
			Boolean Result = new ZIFAI_CaseManagementPage(driver).Nodatafound.isDisplayed();
			if (Result == false) {
				test.log(Status.FAIL, "Invalid description is entered and no data found is not displayed Count: " + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Result == true) {
				test.log(Status.PASS, "Invalid description is entered and no data found is displayed. Count:" + countdate);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after passing invalid description");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//clearing the filter//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			test.log(Status.PASS, "Successfully cleared the values in filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear values in filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Getting the count after providing invalid description input in filter//
		try {
			Thread.sleep(3000);
			String countdate = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after clearing filter: " + countdate);
			test.log(Status.PASS, "Count after clearing filter" + countdate);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to get the count after clearing filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-----------------------------------End of US---------------------------------------------//

		//Case Details - Preference Options(No Data Found)//

		test = extent.createTest("US 3867 Case Details - Case Management - Case Details - Preferences(No Data Found)");
		test.createNode("US 3867 Case Details - Case Management - Case Details - Preferences(No Data Found)");
		// Click the Preference icon and enter any invalid data in Case ID - NNN//
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


		// Clearing Preference data//
		try {
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceackstatus("");
			test.log(Status.PASS, "Successfully cleared values in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear values in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//--------------------------------End of US-------------------------------------------------//

		test = extent.createTest("Test Case 4644: Functional - Preferences Sort Case & Hide Cases");
		test.createNode("Test Case 4644: Functional - Preferences Sort Case & Hide Cases");
		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(2000);
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to click the preference option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on Create Date checkbox//
		try {
			WebElement checkbox = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[1]"));
			Boolean property = checkbox.isDisplayed();
			System.out.println(property);
			if (property == false) {
				Thread.sleep(3000);
				checkbox.click();
				new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			} else if (property == true) {
				Thread.sleep(3000);
				System.out.println("Create Date is already enabled: " + property);
				new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			}

			Thread.sleep(3000);
			test.log(Status.PASS, "Clicked on create date checkbox");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Click on create date checkbox");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Details of the first case after applying created date//
		try {
			Actions actioncase = new Actions(driver);
			Thread.sleep(2000);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).Createdatecorrelation).perform();
			Thread.sleep(2000);
			WebElement ack_knw = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldge = ack_knw.getText();
			System.out.println("Created :" + acknowldge);
			test.log(Status.PASS, "Created date : " + acknowldge);
			Actions actioncaset = new Actions(driver);
			Thread.sleep(2000);
			actioncaset.moveToElement(new ZIFAI_CaseManagementPage(driver).Caseidcorrelation).perform();
			Thread.sleep(2000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Case id : " + acknowldget);
			test.log(Status.PASS, "Case id after applying create date option" + acknowldget);
		} catch (Exception e) {
			test.log(Status.FAIL, "First case is not displayed with case id and created date");

		}

		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(2000);
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to click the preference option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on Updated Date checkbox//
		try {

			WebElement checkboxt = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[2]"));
			WebElement checkboxtv = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[2]"));
			Boolean property = checkboxt.isDisplayed();
			System.out.println("Updated date:" + property);
			if (property == false) {
				Thread.sleep(3000);
				checkboxt.click();
				new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			} else if (property == true) {
				Thread.sleep(3000);
				checkboxtv.click();
				System.out.println("Updated Date is already enabled: " + property);
				new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			}

			Thread.sleep(3000);
			test.log(Status.PASS, "Clicked on Updated date checkbox");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Click on Updated date checkbox");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Details of the first case after applying updated date//
		try {
			Actions actioncase = new Actions(driver);
			Thread.sleep(2000);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).Updateddatecorrelation).perform();
			Thread.sleep(2000);
			WebElement ack_knwv = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldgets = ack_knwv.getText();
			System.out.println("updated :" + acknowldgets);
			test.log(Status.PASS, "updated date : " + acknowldgets);
			Actions actioncaset = new Actions(driver);
			Thread.sleep(2000);
			actioncaset.moveToElement(new ZIFAI_CaseManagementPage(driver).Caseidcorrelation).perform();
			Thread.sleep(2000);
			WebElement ack_knwtp = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldgete = ack_knwtp.getText();
			System.out.println("Case id : " + acknowldgete);
			test.log(Status.PASS, "Case id after applying updated date option" + acknowldgete);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "First case is not displayed with case id and updated date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Pause Live feed icon//
		try {
			Boolean valuesp = new ZIFAI_CaseManagementPage(driver).livefeedon.isDisplayed();
			System.out.println("Live feed status: " + valuesp);
			if (valuesp == true) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).livefeedon.click();
				Thread.sleep(5000);
			} else if (valuesp == false) {
				System.out.println("Already livefeed is turned off");
			}
			test.log(Status.PASS, "Live feed is turned paused");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to pause live feed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(2000);
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to click the preference option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing Updated Date checkbox//
		try {

			WebElement checkboxt = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[2]"));
			WebElement checkboxtv = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[2]"));
			Boolean property = checkboxt.isDisplayed();
			System.out.println("Updated date:" + property);
			if (property == true) {
				Thread.sleep(3000);
				checkboxt.click();
				new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			} else if (property == false) {
				Thread.sleep(3000);
				System.out.println("Updated Date is already enabled: " + property);
				new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			}

			Thread.sleep(3000);
			test.log(Status.PASS, "Clicked on Updated date checkbox");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Click on Updated date checkbox");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Details of the first case after pausing live feed//
		try {
			Actions actioncase = new Actions(driver);
			Thread.sleep(2000);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).Createdatecorrelation).perform();
			Thread.sleep(2000);
			WebElement ack_knwv = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldgetst = ack_knwv.getText();
			System.out.println("Create date after pausing live feed :" + acknowldgetst);
			test.log(Status.PASS, "Create date after pausing live feed : " + acknowldgetst);
			Actions actioncaset = new Actions(driver);
			Thread.sleep(2000);
			actioncaset.moveToElement(new ZIFAI_CaseManagementPage(driver).Caseidcorrelation).perform();
			Thread.sleep(2000);
			WebElement ack_knwtp = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldgete = ack_knwtp.getText();
			System.out.println("Case id : " + acknowldgete);
			test.log(Status.PASS, "Case id after pausing live feed " + acknowldgete);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);

		} catch (Exception e) {
			test.log(Status.FAIL, "First case is not displayed with case id and updated date after live feed pause");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Filter the appropriate case for description//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtercaseid.sendKeys("14517");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
			System.out.println("Check");
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CorrelatedAlerts.click();
			Thread.sleep(5000);

		test.log(Status.PASS, "Filtering case id for 14517");
		test.addScreenCaptureFromPath(captureScreenShot(driver));
	} catch (Exception e){
			test.log(Status.FAIL, "Unable to filter case id 14517");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Get the description and case id from the case management and verify hide case using text//

		try{
			WebElement desc = driver.findElement(By.xpath("(//div[@tooltipstyleclass='dev_short_box'])[1]"));
			WebElement idcase = driver.findElement(By.xpath("//div[@class='case-id ng-star-inserted']"));
			Thread.sleep(2000);
			String valueid = idcase.getText();
			String valueded = desc.getText();
			System.out.println("Relevant case id: " +valueid);
			System.out.println("Relevant desc for hide text: "+valueded);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(2000);
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(2000);
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
			}
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.sendKeys(valueded);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtercaseid.sendKeys(valueid);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Successfully entered the value in Hide text box and filtering the case id" +valueid);
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to enter value in Hide text box");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying the count after applying the relevant hide text case id//

		try {
			String case_count = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All", "").replace("(", "").replace(")", "").trim();
			System.out.println("Count after applying case id relevant to hide text " +case_count);
			if (case_count.contains("0")) {
				test.log(Status.PASS, "Successfully verified the hide text and count is" +case_count);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Count is more the zero " + case_count);
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the count of hide case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the Preference and filter values//
		try {

			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Successfully cleared filter and preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to clear filter and preference after hide case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
//-------------------------------------------------End of US4644--------------------------------------//

		//Report//
		test = extent.createTest("Test Case 4646: Case Management - Case Details - Preferences Case Status");
		test.createNode("Test Case 4646: Case Management - Case Details - Preferences Case Status");

		//Provide the case status "exclude:AutoClosed,exclude:New"//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("exclude:Closed, exclude:New");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			actioncaset.moveToElement(case_first).perform();
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			Thread.sleep(2000);
			System.out.println("Case status after excluding New and Closed : " + acknowldget);
			if (!acknowldget.equalsIgnoreCase("Closed")) {
				test.log(Status.PASS, "Closed status is excluded");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}else {
				test.log(Status.FAIL, "Closed status is not excluded");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if (!acknowldget.equalsIgnoreCase("New"))
			{
				test.log(Status.PASS, "New status is excluded");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else
			{
				test.log(Status.FAIL, "New status is not excluded");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify whether New and closed is excluded");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}


		//Provide the case status "New , In progress"//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("New, In Progress");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			Thread.sleep(2000);
			actioncaset.moveToElement(case_first).perform();
			Thread.sleep(2000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Case status after including New, In Progress : " + acknowldget);
			if (acknowldget.equalsIgnoreCase("New"))
			{
				test.log(Status.PASS, "New case status is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "New case status is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
		}

		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify whether New and Inprogress is included");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Provide the case status "Closed"//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("Closed");
			WebElement case_first = driver.findElement(By.xpath("(//span[contains(@class, 'case-first-left-icon-2')])[1]"));
			Thread.sleep(3000);
			Actions actioncaset = new Actions(driver);
			Thread.sleep(2000);
			actioncaset.moveToElement(case_first).perform();
			Thread.sleep(2000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String acknowldget = ack_knwt.getText();
			System.out.println("Case status after including Closed : " + acknowldget);
			if (acknowldget.equalsIgnoreCase("Closed"))
			{
				test.log(Status.PASS, "Closed case status is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "Closed status is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
		}

		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify whether closed status is displayed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Provide the case status : exclude:Assigned"//
		try {
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
			if (!acknowldget.equalsIgnoreCase("Assigned"))
			{
				test.log(Status.PASS, "Assigned case status is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "Assigned status is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
		}

		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify whether Assigned is excluded");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Clearing the preference values//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			test.log(Status.PASS, "Clearing the values after executing US 4646");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to clear the values after executing US 4646");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//-------------------------------------End of US 4646----------------------------------------//
		//Report//
		test = extent.createTest("Test Case 4645: Functional - Case Details - Preferences Cancel button");
		test.createNode("Test Case 4645: Functional - Case Details - Preferences Cancel button");
		//Preference segregating "New" cases//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("New");
			test.log(Status.PASS, "New status has been filtered using preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter new cases using preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying after entering value in preference again previously entered value should remain constant//
		try {
			new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).clearcasestatus();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferences_Casestatus.sendKeys("Closed");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Prefcancel.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
			Thread.sleep(3000);
			String status_valuepr = new ZIFAI_CaseManagementPage(driver).Preferences_Casestatus.getAttribute("value");
			System.out.println("Current value in case status:" +status_valuepr);
			Thread.sleep(3000);
			if(status_valuepr.equalsIgnoreCase("New")){
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
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
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


		//----------------------------------------End of US 4645-------------------------------------//
		//Report//
		test = extent.createTest("Test Case 4647: Case Management - Case Details - Verify the Filter Options");
		test.createNode("Test Case 4647: Case Management - Case Details - Verify the Filter Options");


		//Filter segregating "USRACIPA429" device name cases//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filterdevicename.sendKeys("ZDGCARE0007");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Device name is filtered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(4000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to filter device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the device name hover using first instance//
		try {
			WebElement dvcnme = driver.findElement(By.xpath("(//div[@tooltipstyleclass='dev_short_box'])[1]"));
			Actions actioncaset = new Actions(driver);
			Thread.sleep(4000);
			actioncaset.moveToElement(dvcnme).perform();
			Thread.sleep(4000);
			WebElement ack_knwt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String ackno = ack_knwt.getText();
			System.out.println("Device name in first instance: " + ackno);
			if (ackno.contains("USRACIPA429")) {
				test.log(Status.PASS, "Device name is filtered and present in first instance");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Device name is not filtered and not present in first instance");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(4000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify the tooltip with device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Filter segregating "Gcare" Tool name cases//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtertoolname.sendKeys("Monitoring");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
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
			if (acknol.contains("Monitoring")) {
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

		//Filter segregating "TESTING || BWLGB_SDD41-USBW_DAILY" description//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtercasedescription.sendKeys("TEST");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Description with provided data is filtered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to case with mentioned description");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the tool name hover using first instance//
		try {
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).CorrelatedALerts.click();
			Thread.sleep(4000);
			Actions actioncaseto = new Actions(driver);
			Thread.sleep(4000);
			actioncaseto.moveToElement(new ZIFAI_CaseManagementPage(driver).correlateddescription).perform();
			Thread.sleep(4000);
			WebElement desc_corr = driver.findElement(By.cssSelector(".ui-tooltip"));
			String corr = desc_corr.getText();
			System.out.println("Description matching in first instance: " + corr);
			if (corr.equalsIgnoreCase("TEST")) {
				test.log(Status.PASS, "Description matching case is filtered and present in first instance");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Description matching case is not filtered and not present in first instance");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(4000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Not able to verify the tooltip with matching description");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Clearing the filter and verifying the textbox whether it is cleared//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			String fltrdvcnme = new ZIFAI_CaseManagementPage(driver).Filterdevicename.getAttribute("value");
			Thread.sleep(3000);
			if(fltrdvcnme.isEmpty()){
				test.log(Status.PASS, "Filter device name is cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
			else{
				test.log(Status.FAIL, "Filter device name is not cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			String crtdate = new ZIFAI_CaseManagementPage(driver).Filtercreatedate.getAttribute("value");
			if(crtdate.isEmpty()){
				test.log(Status.PASS, "Filter create date is cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
			else{
				test.log(Status.FAIL, "Filter create date is not cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			String  Filtersvr = new ZIFAI_CaseManagementPage(driver).Filterseverity.getAttribute("value");
			Thread.sleep(3000);
			if(Filtersvr.isEmpty()){
				test.log(Status.PASS, "Filter severity is cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
			else{
				test.log(Status.FAIL, "Filter severity is not cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			String toolnme = new ZIFAI_CaseManagementPage(driver).Filtertoolname.getAttribute("value");
			Thread.sleep(3000);
			if(toolnme.isEmpty()){
				test.log(Status.PASS, "Filter tool name is cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
			else{
				test.log(Status.FAIL, "Filter tool name is not cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			}
			Thread.sleep(3000);
			String filterdesc = new ZIFAI_CaseManagementPage(driver).Filtercasedescription.getAttribute("value");
			Thread.sleep(3000);
			if(filterdesc.isEmpty()){
				test.log(Status.PASS, "Filter description is cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
			else{
				test.log(Status.FAIL, "Filter description is not cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			String Filtercseid = new ZIFAI_CaseManagementPage(driver).Filtercaseid.getAttribute("value");
			Thread.sleep(3000);
			if(Filtercseid.isEmpty()){
				test.log(Status.PASS, "Filter case id is cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
			else{
				test.log(Status.FAIL, "Filter case id is not cleared");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			}

			new ZIFAI_CaseManagementPage(driver).Filtercloseicon.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Successfully cleared and validated filter input box");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to clear filter and verify input box");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//--------------------------------------End of US 4647--------------------------------------//
		//Report//
		test = extent.createTest("Test Case 4650: UI - Case Management - Case Details - Filter Options");
		test.createNode("Test Case 4650: UI - Case Management - Case Details - Filter Options");

		//Mouse hover the filter and verify the tool tip//
		try{
			Thread.sleep(3000);
			Actions actioncaseto = new Actions(driver);
			actioncaseto.moveToElement(new ZIFAI_CaseManagementPage(driver).prefereceIcon).perform();
			WebElement desc_corr = driver.findElement(By.cssSelector(".ui-tooltip"));
			String corr = desc_corr.getText();
			Thread.sleep(3000);
			System.out.println("When hovered on filter the text displayed is: " + corr);
			if (corr.equalsIgnoreCase("Filter")) {
				test.log(Status.PASS, "Filter text is matching as when hovered on Filter");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Filter text is not matching as when hovered on Filter");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Filter text is not matching as when hovered on Filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Filter Popup should be displayed for the below fields Case ID,Created Date,Severity,Type,Device Name / Application Name,Tool Name,Case Description,Apply and Clear buttons,X icon//

		try{
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			Boolean Fildev =  new ZIFAI_CaseManagementPage(driver).Filterdevicename.isDisplayed();
			System.out.println("Filter device name status "+Fildev);
			if(Fildev==true){
				test.log(Status.PASS, "Filter device name is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Fildev==false){
				test.log(Status.FAIL, "Filter device name is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Filcrdte =  new ZIFAI_CaseManagementPage(driver).Filtercreatedate.isDisplayed();
			System.out.println("Filter create date status "+Fildev);
			Thread.sleep(3000);
			if(Filcrdte==true){
				test.log(Status.PASS, "Filter created date is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Filcrdte==false){
				test.log(Status.FAIL, "Filter created date is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Filsevy =  new ZIFAI_CaseManagementPage(driver).Filterseverity.isDisplayed();
			System.out.println("Filter severity status"+Fildev);
			Thread.sleep(3000);
			if(Filsevy==true){
				test.log(Status.PASS, "Filter severity is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Filsevy==false){
				test.log(Status.FAIL, "Filter severity is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean Ftrtlnme =  new ZIFAI_CaseManagementPage(driver).Filtertoolname.isDisplayed();
			System.out.println("Filter tool name status "+Fildev);
			Thread.sleep(3000);
			if(Ftrtlnme==true){
				test.log(Status.PASS, "Filter tool name is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Ftrtlnme==false){
				test.log(Status.FAIL, "Filter tool name is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean filydescr =  new ZIFAI_CaseManagementPage(driver).Filtercasedescription.isDisplayed();
			System.out.println("Filter description "+Fildev);
			Thread.sleep(3000);
			if(filydescr==true){
				test.log(Status.PASS, "Filter description is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(filydescr==false){
				test.log(Status.FAIL, "Filter description is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			Boolean filtrcsid =  new ZIFAI_CaseManagementPage(driver).Filtercaseid.isDisplayed();
			System.out.println("Filter case id "+Fildev);
			Thread.sleep(3000);
			if(filtrcsid==true){
				test.log(Status.PASS, "Filter case id is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(filtrcsid==false){
				test.log(Status.FAIL, "Filter case id is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean filyapp =  new ZIFAI_CaseManagementPage(driver).Applybutton.isDisplayed();
			System.out.println("Filter apply button is present but grayed out "+filyapp);
			Thread.sleep(3000);
			if(filyapp==true){
				test.log(Status.PASS, "Filter apply button is present but grayed out");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(filyapp==false){
				test.log(Status.FAIL, "Filter apply button is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean clearfily =  new ZIFAI_CaseManagementPage(driver).FilterClear.isDisplayed();
			System.out.println("Filter clear button "+clearfily);
			Thread.sleep(3000);
			if(clearfily==true){
				test.log(Status.PASS, "Filter clear button is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(clearfily==false){
				test.log(Status.FAIL, "Filter clear button is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean filyclose =  new ZIFAI_CaseManagementPage(driver).Filtercloseicon.isDisplayed();
			System.out.println("Filter close button "+filyclose);
			Thread.sleep(3000);
			if(filtrcsid==true){
				test.log(Status.PASS, "Filter close button is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(filtrcsid==false){
				test.log(Status.FAIL, "Filter close button is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtercloseicon.click();
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the filter option presence");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//-----------------------------------------End of US4650----------------------------------------------//
		//Report//
		test = extent.createTest("Test Case 4649: UI - Case Management - Case Details - Preferences Option");
		test.createNode("Test Case 4649: UI - Case Management - Case Details - Preferences Option");

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
			}
		}
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

		//----------------------------------End of US ---------------------------------------------//



	}
}


