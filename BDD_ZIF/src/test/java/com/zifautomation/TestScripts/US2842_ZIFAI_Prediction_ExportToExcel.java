package com.zifautomation.TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAIPredictionPage;
import com.zifautomation.Pages.ZIFAI_Prediction_ExportToExcel;
import com.zifautomation.Utility.CommonMethods;

public class US2842_ZIFAI_Prediction_ExportToExcel extends Base {
	
	
	WebDriverWait wait1=null;


	@Test
	public void ZIFUIRegressionTestcase() throws IOException, InterruptedException {


		//Report 

		test = extent.createTest("US2842_Prediction_ClickOnExportToExcel");
		test.createNode("US2842_Prediction_ClickOnExportToExcel");

		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");

			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Login failed");

		}

		// Verify User is in ZIF UI Home Page

		try {
			String ExpectedTitle = "ZIF";
			String ActualTitle = driver.getTitle();
			assertEquals(ExpectedTitle, ActualTitle);
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");

		}


		// Verify all fields in ZIF UI dashboard page
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickPrediction();

		// Verify all fields in ZIF UI Prediction Swim lane
		try {
			new ZIFAIPredictionPage(driver).verifySwinlaneFields();
			test.log(Status.PASS,"Successfully verified all fields Prediction swim lane");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in verifying prediction swim lane fields");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		

//Verify user is able to click on Export to Excel under Predicted Risk
	/*try {
			new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderPredictedRiskcard();
			test.log(Status.PASS,"User is successfully clicked on export to excel under PRC ");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			//e.printStackTrace();
			test.log(Status.FAIL, "User is not able click on export to excel under PRC");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		

//Verify user is able to click on Export to Excel under Critical
		try {
			new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderCritical();
			test.log(Status.PASS,"User is successfully clicked on export to excel under CRL ");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			//e.printStackTrace();
			test.log(Status.FAIL, "User is not able click on export to excel under CRL");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//Verify user is able to click on Export to Excel under Processed
				try {
					new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderProcessed();
					test.log(Status.PASS,"User is successfully clicked on export to excel under Processed ");
					Thread.sleep(2000);
				} catch (AssertionError | Exception e) {
					//e.printStackTrace();
					test.log(Status.FAIL, "User is not able click on export to excel under Processed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
			
*/
		
		
		
		//Verify user is able to click on Export to Excel under Lost
				try {
					new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderLost();
					String dirPath = "C:\\Users\\usha.thangavelu\\Downloads";
					new CommonMethods(driver);
					CommonMethods.isFileDownloaded(dirPath,"usha");
					test.log(Status.PASS,"User is successfully clicked on export to excel under Lost ");
					Thread.sleep(2000);
				} 
				catch (AssertionError | Exception e1) {
					e1.printStackTrace();
					test.log(Status.FAIL, "User is not able click on export to excel under Lost");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

//Verify user is able to click on Export to Excel under Invalid
				try {
					new ZIFAI_Prediction_ExportToExcel(driver).clickonexportunderInvalid();
					test.log(Status.PASS,"User is successfully clicked on export to excel under Invalid ");
					Thread.sleep(2000);
				} 
				catch (AssertionError | Exception e2)
				{
					e2.printStackTrace();
					test.log(Status.FAIL, "User is not able click on export to excel under Invalid");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

				} }
	

			

		

		
	
		
	

		


