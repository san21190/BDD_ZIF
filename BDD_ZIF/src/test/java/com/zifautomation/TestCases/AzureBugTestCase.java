package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.RestAssured.CreateBugInAzureWithBody;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.zifautomation.RestAssured.CreateBugInAzureWithFile_test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class AzureBugTestCase extends Base {

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
			Actions cqseacknowl = new Actions(driver);
			cqseacknowl.moveToElement(new ZIFAI_CaseManagementPage(driver).prefereceIcon).perform();
			WebElement Ackzif = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Acknledgestatus = Ackzif.getText();
			System.out.println("The preference icon"+Acknledgestatus);
			if(Acknledgestatus.contains("Prefeences")){
				test.log(Status.PASS, "Matches the preference name");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				test.log(Status.FAIL, "Doesn't Match the preference name");
				CreateBugInAzureWithBody testapi = new CreateBugInAzureWithBody();
				testapi.CreateBugInAzureWithBody();
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		}
	}