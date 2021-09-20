package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.*;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.PropertiesFileReader;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ZIFUI_AnP_US2073_Regression extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;
	CommonMethods cm = null;


	@Test
	public void ZIFUI_AnP_US2073_Regression() throws IOException, InterruptedException {

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

		//click on the Prediction link from operations hover//
		try {
			new ZIFAIPredictionPage(driver).hoveronAnalyzes();
			new ZIFAI_CaseManagementPage(driver).clickPrediction();
			test.log(Status.PASS, "Predictions link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Predictions link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//click on the Prediction link from operations hover//
		try {
			new ZIFAIPredictionPage(driver).filterIcon.click();
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).filterclear.click();
			Thread.sleep(3000);
			WebElement Filterstat = driver.findElement(By.xpath("(//div[contains(@class,'ui-state-disabled')])[1]"));
			Boolean Filterstatus =	Filterstat.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Filter counter current status: "+Filterstatus);
			if(Filterstatus==true){
				test.log(Status.PASS, "Filter counter is disabled/grayed out by default");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Filterstatus==false){
				test.log(Status.FAIL, "Filter counter is not disabled/grayed out by default");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			WebElement Filterstatp = driver.findElement(By.xpath("(//div[contains(@class,'ui-state-disabled')])[2]"));
			Boolean Filterdrve =	Filterstatp.isDisplayed();
			Thread.sleep(3000);
			System.out.println("Filter drive/mount current status: "+Filterdrve);
			if(Filterdrve==true){
				test.log(Status.PASS, "Filter Drive/Mount is disabled/grayed out by default");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(Filterdrve==false){
				test.log(Status.FAIL, "Filter Drive/Mount is not disabled/grayed out by default");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			new ZIFAIPredictionPage(driver).closefilter.click();
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify grayed out status on Counters and Drive from Filter ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		}
	}

