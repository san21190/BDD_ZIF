package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.*;
import com.zifautomation.RestAssured.BaseAPI;
import com.zifautomation.Utility.PropertiesFileReader;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;


public class ZIF_Monitoring_UI_US4554_Regression extends Base {


	Properties prop = new Properties();

	@Test
	public void ZIF_Monitoring_UI_US4554_Regression() throws IOException {


		test = extent.createTest("User Story 4554: APi Capacity Details -CPU, Disk and Memory");
		test.createNode("User Story 4554: APi Capacity Details -CPU, Disk and Memory");

		Properties prop1 = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\testdata-config.properties"));
		prop1.load(reader);
		reader.close();

		String Devicename = prop1.getProperty("ui.Devicename");
		System.out.println(Devicename);
		String Fromtime = prop1.getProperty("ui.Fromtime");
		System.out.println(Fromtime);
		String Totime = prop1.getProperty("ui.Totime");
		System.out.println(Totime);

		// Login to the ZIFAI Portal With valid credentials
		try {

			Thread.sleep(4000);
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);
			test.log(Status.PASS, "UI Page has been navigated");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "UI Login failed");

		}

		//click on the analytics link
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickRawData();
			test.log(Status.PASS, "Raw data link is clicked");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Raw data link");
		}


		//Clearing filter and preference values//
		try {
			new ZIFAI_AlertsSettingsPage(driver).inventoryLink.click();
			Thread.sleep(5000);
			new ZIFAI_MonitoringPage(driver).AlertsFilter.click();
			Thread.sleep(5000);
			new ZIFAI_MonitoringPage(driver).Filterdevicename.sendKeys(Devicename);
			Thread.sleep(5000);
			new ZIFAI_MonitoringPage(driver).FilterApply.click();
			Thread.sleep(5000);
			new ZIFAI_MonitoringPage(driver).Deviceviewdetails.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		//Clicking the filter for selecting the date//
		try {
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
			Thread.sleep(2000);
//			if (new ZIFAI_CaseManagementPage(driver).Prevmonth.isDisplayed()) {
//				new ZIFAI_CaseManagementPage(driver).Prevmonth.click();
//			}
			WebElement dateone = driver.findElement(By.xpath("//a[text()=" + Fromtime + "]"));
			WebElement dateonet = driver.findElement(By.xpath("//a[text()=" + Totime + "]"));
			Thread.sleep(2000);
			dateone.click();
			Thread.sleep(2000);
			dateonet.click();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).RawalertsCalendarlink.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to Verify the Date picker is working for all the time selected by the user");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Fetching the memory value from the device using UI and comparing with API//
		SoftAssert softassert = new SoftAssert();
		Properties prop2 = new Properties();
		BufferedReader reader1 = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\Apidata.properties"));
		prop2.load(reader1);
		reader1.close();
		String db = prop2.getProperty("SYS.ID");
		try {
			Thread.sleep(6000);
			String Cmpvalue = new ZIFAI_MonitoringPage(driver).MemoryCapacity.getText().replace("%","").replace("Available","").trim();
			//CPUCapacity -- //MemoryCapacity -- //DiskCapacity
			float num1 =Float.parseFloat(Cmpvalue);
			float num2 = Float.parseFloat(db);
			if(((num2 % 1) < 0.5)) {
				Float convertedval = (float) Math.round(num2);
				System.out.println("Value1 "+ num1+" Value2 "+convertedval);
				System.out.println("Values are less than 0.5");
				Boolean condition1 = num1==convertedval;
				softassert.assertFalse(condition1);
				if (condition1) {
					test.log(Status.PASS, "Values are matching with API and UI " + condition1);
				}
				else if (!condition1) {
						test.log(Status.FAIL, "Values are not matching with API and UI " + condition1);
				}
			}
				if ((num2 % 1) > 0.5) {
					Float converted = (float) Math.round(num2);
					System.out.println("Values are more than 0.5 "+converted);
					Boolean condition2 = num1==converted;
					softassert.assertFalse(condition2);
					{
						if (condition2) {
							test.log(Status.PASS, "Values are matching with API and UI after round off " + condition2);
						}
						else if (!condition2) {
							test.log(Status.FAIL, "Values are not matching with API and UI after round off " + condition2);
						}
					}
				}
			} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}
}