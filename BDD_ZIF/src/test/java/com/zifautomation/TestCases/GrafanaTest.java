package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIPredictionPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Pages.ZIFAI_RawDataPage;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class GrafanaTest extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;
	CommonMethods cm = null;


	@Test
	public void GrafanaTest() throws IOException, InterruptedException {

		//Report Initialization//

		test = extent.createTest("User Story 2073: Filter Options- Counters should be Disabled");
		test.createNode("User Story 2073: Filter Options- Counters should be Disabled");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


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
			new ZIFAI_RawDataPage(driver).hoveronAnalyzes();
			new ZIFAI_RawDataPage(driver).clickRawData();
			test.log(Status.PASS, "Raw data link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Raw data link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try{
			new ZIFAI_RawDataPage(driver).Invoketimedata.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Timedatadropdown.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Timedatasearchinput.sendKeys("UTC");
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Timedatadropdownvalue.click();
			Thread.sleep(3000);
		}catch (Exception e){

		}



		}
	}

