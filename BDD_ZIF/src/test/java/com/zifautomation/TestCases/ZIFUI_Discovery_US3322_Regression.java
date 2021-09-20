package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.mongodb.client.FindIterable;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelVerification;
import com.zifautomation.Utility.MongoQueryManager;
import cucumber.api.java.an.E;
import org.apache.poi.poifs.filesystem.Entry;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class ZIFUI_Discovery_US3322_Regression extends Base {

	//*PropertiesFileReader obj = new PropertiesFileReader();
	//Properties properties = null;
	//CommonMethods cm = null;*//


	@Test
	public void ZIFUI_Discovery_US3322_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("User Story 3322: ZIF Discovery - Export Device list to CSV");
		test.createNode("User Story 3322: ZIF Discovery - Export Device list to CSV");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CommonMethods cm = null;

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

		//--------------------------------End of US------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3263: UI-Verify Exported Discovery list");
		test.createNode("Test Case 3263: UI-Verify Exported Discovery list");
		cm.deleteAllFilesInFolder(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(5000);
			String Valueu = new ZIFAI_AlertsSettingsPage(driver).Devicecount.getText().replace("(", "").replace(")", "").trim();
			int Valueint = Integer.parseInt(Valueu);
			new ZIFAI_AlertsSettingsPage(driver).Export.click();
			Thread.sleep(5000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			int count =0;
			for(int i=0;i<excel.size();i++){
				String text = excel.get(i).toString();
				if (text.contains("GTM6")) {
					count = count + 1;
				}
				System.out.println("Total count of devices from the excel exported: "+count);
				}
			if(Valueint==count){
				test.log(Status.PASS, "The device count and exported device list count is same."+" Validation: UI Device count "+" "+Valueint+" & Excel Device list count "+" "+count);
			}
			else {
				test.log(Status.FAIL, "The device count and exported device list count is not same");
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the devices exported through csv/excel" +e);
		}
		//--------------------------------------------End of US------------------------------------------//

		}
	}
