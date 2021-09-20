package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ZIFUI_AnP_US3868_Regression_without_simulator extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;


	@Test
	public void ZIFUI_AnP_US3868_Regression_without_simulator() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("ZIFUI_AnP_US3868_Regression_without_simulator");
		test.createNode("ZIFUI_AnP_US3868_Regression_without_simulator");

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
			new ZIFAI_CaseManagementPage(driver).hoveronAnalyzes();
			new ZIFAI_CaseManagementPage(driver).clickAnalytics();
			test.log(Status.PASS, "Analytics link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//clear up the filter and preference values//

		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceHidecase("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the filter and preference before validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to clear the filter and preference before validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Taking up the count in case management screen//

		try{
			Thread.sleep(3000);
			String case_count = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("All","").replace("(","").replace(")","").trim();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			System.out.println("Case count from case management screen without simulator " +case_count);
			System.out.println("Time when the count is taken "+formatter.format(date));
			test.log(Status.PASS, "Case management screen without simulator count and the time"+"  "+case_count+"  "+formatter.format(date));
		test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
	}
		catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to fetch case count from case management screen");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//click on the Raw data link
		try {
			new ZIFAI_CaseManagementPage(driver).hoveronAnalyzes();
			new ZIFAI_CaseManagementPage(driver).SMrawdata.click();
			test.log(Status.PASS, "Raw data link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Raw data link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//click on the alerts link and taking up the count//
		try{
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).rawdataalerts.click();
			Thread.sleep(3000);
			String case_count = new ZIFAI_CaseManagementPage(driver).alertscount.getText().replace("All","").replace("(","").replace(")","").trim();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			System.out.println("Count in Alerts screen without simulator "+case_count);
			System.out.println("Time when the count is taken "+formatter.format(date));
			test.log(Status.PASS, "Alerts screen without simulator count and the time"+"  "+case_count+"  "+formatter.format(date));
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}
		catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to fetch case count from alerts screen");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}




	}
}




