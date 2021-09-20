package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.mongodb.client.FindIterable;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.*;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.MongoQueryManager;
import com.zifautomation.Utility.PropertiesFileReader;
import org.apache.poi.hssf.record.formula.functions.If;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class ZIFUI_AnP_US4326_Regression extends Base {

	//PropertiesFileReader obj = new PropertiesFileReader();

	//Properties properties = null;

	//Network Card In Predictions US 4977//

	@Test
	public void ZIFUI_AnP_US4326_Regression() throws IOException, InterruptedException {

		//Report Initialization//

		test = extent.createTest("Network Card In Prediction.");
		test.createNode("Network Card In Predictions.");

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

		//Click on Filter and Select Network from Resource Group and click apply//
		try {
			Thread.sleep(5000);
			new ZIFAIPredictionPage(driver).filterIcon.click();
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).filterclear.click();
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).Resourcefltr.click();
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).filternetwork.click();
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).filterapply.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Network has been selected from Resource Group after clicking on filter icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to select network from resource group using settings");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		// Predicted Risk- Opportunity Cards verification test steps:
		//Verify Predicted Risk (Warning) opportunity cards : This works when cards are available//
		try {
			Thread.sleep(3000);
			if (driver.findElement(By.xpath("//div[contains(@class,'opp-cards warn-state ng-star-inserted')]")).isDisplayed()) {
				List<WebElement> records = driver.findElements(By.xpath("//div[contains(@class,'opp-cards warn-state ng-star-inserted')]"));
				List<WebElement> records1 = driver.findElements(By.xpath("//div[contains(@class,'opp-cards warn-state ng-star-inserted')]"));
				int i;
				for ( i= 1; i<records.size(); i=i+1) {
					boolean oppstrcar1 = records1.get(i).isDisplayed();
					Thread.sleep(3000);
					test.log(Status.PASS, "PR card is displayed: " + oppstrcar1);
					String oppstrcar2 = records1.get(i).getText();
					Thread.sleep(3000);
					test.log(Status.PASS, "PR opportunity id and description: " + oppstrcar2);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (Exception e) {
			//new ZIFAIPredictionPage(driver).PRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "PR : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Acknowledging the message if it is not pre-acknowledged//

		try {
			if (new ZIFAIPredictionPage(driver).PRcardunack.isDisplayed()) {
				new ZIFAIPredictionPage(driver).PRcardunack.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "PR Acknowledge is verified");
			} else if (new ZIFAIPredictionPage(driver).PRcardack.isDisplayed()) {
				test.log(Status.PASS, "PR Pre Acknowledged is verified");
			}
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "PR No Data is available");
			Thread.sleep(3000);
		}


		try {
			boolean oppstr120 = new ZIFAIPredictionPage(driver).PRcardexport.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "PR Export option is displayed: " + oppstr120);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr121 = new ZIFAIPredictionPage(driver).PRcardnotes.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "PR Transaction option is displayed: " + oppstr121);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr122 = new ZIFAIPredictionPage(driver).PRcarddecline.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "PR Decline option is displayed: " + oppstr122);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			new ZIFAIPredictionPage(driver).PRcardvalfirst.click();
			test.log(Status.PASS, "Clicked on PR Cards");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "PR : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//ETI time and the current time is taken and compared to provide the time difference(greater than one hour)//
		//Verify the warning portlet is displayed with Network opportunity cards with ETI greater than one hour//
		try {
			Thread.sleep(3000);
			String ETIval = new ZIFAIPredictionPage(driver).ETItime.getText();
			Thread.sleep(3000);
			System.out.println(ETIval);
			final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			f.setTimeZone(TimeZone.getTimeZone("UTC"));
			String Datefrmt = f.format(new Date());
			String Datefrmt1 = Datefrmt.replace("UTC", "").trim();
			System.out.println(Datefrmt1);
			String time2 = ETIval;
			String time1 = Datefrmt1;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = format.parse(time1);
			Date date2 = format.parse(time2);
			long difference = date1.getTime() - date2.getTime();
			System.out.println(difference);
			long difference1 = TimeUnit.MILLISECONDS.toMinutes(difference);
			long milliseconds = 1000000;
			System.out.format("%d Milliseconds = %d minutes\n", milliseconds, difference1);
			if (difference1 <= 60)
				test.log(Status.FAIL, "Total minutes is lesser or equal to 60 minutes: " + difference1);
			else {
				test.log(Status.PASS, "Total minutes is more than 60 minutes:" + difference1);
			}
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "PR :No data is available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Predicted Risk - RHS should reflect the Opportunity details - Root cause, CPU, Memory, Disk, Network
		try {

			new ZIFAIPredictionPage(driver).Applicationgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "PR applcation graph is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			new ZIFAIPredictionPage(driver).Diskgrp.click();
			test.log(Status.PASS, "PR Disk graph is clicked");
			Thread.sleep(4000);
			new ZIFAIPredictionPage(driver).Memorygrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "PR Memory graph is clicked");
			new ZIFAIPredictionPage(driver).Networkgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "PR Network graph is clicked");

		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "PR No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Click on Close Ad and verify the functionality

		try {
			new ZIFAIPredictionPage(driver).closeAd.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "PR CloseAd is clicked and detail window is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "PR : No Data Available");
			Thread.sleep(2000);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//---------------------------End of Predicted Risk Script-----------------------------------//

		//Verify Currently at Risk OP is displayed//

		// Currently at Risk- Opportunity Cards verification test steps:
		//Verify currently Risk (Warning) opportunity cards : This works when cards are available//
		try {
			if (driver.findElement(By.xpath("//div[contains(@class,'opp-cards critical-state ng-star-inserted')]")).isDisplayed()) {
				List<WebElement> records = driver.findElements(By.xpath("//div[contains(@class,'opp-cards critical-state ng-star-inserted')]"));
				List<WebElement> records1 = driver.findElements(By.xpath("//div[contains(@class,'opp-cards critical-state ng-star-inserted')]"));
				for (int i = 1; i < records.size(); i++) {
					boolean oppstrcar = records1.get(i).isDisplayed();
					Thread.sleep(3000);
					test.log(Status.PASS, "CR card is displayed: " + oppstrcar);
					String oppstrcar1 = records1.get(i).getText();
					Thread.sleep(3000);
					test.log(Status.PASS, "CR opportunity id and description: " + oppstrcar1);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (Exception e) {
			//new ZIFAIPredictionPage(driver).CRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "CR :No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Acknowledging the message if it is not pre-acknowledged//

		try {
			if (new ZIFAIPredictionPage(driver).CRcardunack.isDisplayed()) {
				new ZIFAIPredictionPage(driver).CRcardunack.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "CR Acknowledge is verified");
			} else if (new ZIFAIPredictionPage(driver).CRcardack.isDisplayed()) {
				test.log(Status.PASS, "CR Pre Acknowledged is verified");
			}
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).CRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "CR : No Data is available");
			Thread.sleep(3000);
		}


		try {
			boolean oppstr6 = new ZIFAIPredictionPage(driver).CRcardexport.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "CR Export option is displayed: " + oppstr6);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr7 = new ZIFAIPredictionPage(driver).CRcardnotes.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "CR Transaction option is displayed: " + oppstr7);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr9 = new ZIFAIPredictionPage(driver).CRcarddecline.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "CR Decline option is displayed: " + oppstr9);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).CRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "CR : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clicking on the Currently at Risk OP card
		try {
			new ZIFAIPredictionPage(driver).CARcardvalfirst.click();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			String strLHS = new ZIFAIPredictionPage(driver).CARcardvalRHS.getText();
			String strRHS = new ZIFAIPredictionPage(driver).CARcardvalLHS.getText();
			System.out.println("The values are" +strLHS +strRHS);
			//boolean retval2 = strLHS.contentEquals(strRHS);
			test.log(Status.PASS, "CR LHS id and RHS id is equal " +strLHS.equalsIgnoreCase(strRHS));
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).CRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "CR : No data is available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//ETI time and the current time is taken and compared to provide the time difference(greater than one hour)//
		//Verify the warning portlet is displayed with Network opportunity cards with ETI greater than one hour//
		try {
			String ETIval = new ZIFAIPredictionPage(driver).ETItime.getText();
			Thread.sleep(3000);
			System.out.println(ETIval);
			final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			f.setTimeZone(TimeZone.getTimeZone("UTC"));
			String Datefrmt = f.format(new Date());
			String Datefrmt1 = Datefrmt.replace("UTC", "").trim();
			System.out.println(Datefrmt1);
			String time2 = ETIval;
			String time1 = Datefrmt1;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = format.parse(time1);
			Date date2 = format.parse(time2);
			long difference = date2.getTime() - date1.getTime();
			System.out.println(difference);
			long difference1 = TimeUnit.MILLISECONDS.toMinutes(difference);
			long milliseconds = 1000000;
			System.out.format("%d Milliseconds = %d minutes\n", milliseconds, difference1);
			if (difference1 <= 60)
				test.log(Status.PASS, "Total minutes is lesser or equal to 60 minutes: " + difference1);
			else {
				test.log(Status.FAIL, "Total minutes is more than 60 minutes: " + difference1);
			}
		} catch   (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).CRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "CR : No data is available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Critical Risk - RHS should reflect the Opportunity details - Root cause, CPU, Memory, Disk, Network
		try {

			new ZIFAIPredictionPage(driver).Diskgrp.click();
			test.log(Status.PASS, "CR Disk graph is clicked");
			Thread.sleep(4000);
			new ZIFAIPredictionPage(driver).Memorygrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "CR Memory graph is clicked");
			new ZIFAIPredictionPage(driver).Networkgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "CR Network graph is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			new ZIFAIPredictionPage(driver).Applicationgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "CR Application graph is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).CRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "CR : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Click on Close Ad and verify the functionality

		try {
			new ZIFAIPredictionPage(driver).closeAd.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "CR CloseAd is clicked and detail window is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).CRnodataAvailable.isDisplayed();
			test.log(Status.PASS, "CR : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//------------------------End of Currently at risk script------------------------------- //

		// Processed - Opportunity Cards verification test steps//

		//Verify Currently at Processed OP is displayed//
		try {
			if (driver.findElement(By.xpath("//div[contains(@class,'opp-cards processed-state ng-star-inserted')]")).isDisplayed()) {
				List<WebElement> records = driver.findElements(By.xpath("//div[contains(@class,'opp-cards processed-state ng-star-inserted')]"));
				List<WebElement> records1 = driver.findElements(By.xpath("//div[contains(@class,'opp-cards processed-state ng-star-inserted')]"));
				for (int i = 1; i < records.size(); i++) {
					boolean oppstrcar = records1.get(i).isDisplayed();
					Thread.sleep(3000);
					test.log(Status.PASS, "Processed card is displayed: " + oppstrcar);
					String oppstrcar1 = records1.get(i).getText();
					Thread.sleep(3000);
					test.log(Status.PASS, "Processed opportunity id and description: " + oppstrcar1);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (Exception e) {
			//new ZIFAIPredictionPage(driver).PDnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Processed :No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Acknowledging the message if it is not pre-acknowledged//

		try {
			driver.findElement(By.xpath("//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")).isDisplayed();
			new ZIFAIPredictionPage(driver).PDcardunack.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Acknowledge is verified");
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PDnodataAvailable.isDisplayed();
			test.log(Status.PASS, "PD : No Data is available");
			Thread.sleep(3000);
		}

		//Verifying Export , transaction and decline option//

		try {
			boolean oppstr6 = new ZIFAIPredictionPage(driver).PDcardexport.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Processed Export option is displayed: " + oppstr6);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr7 = new ZIFAIPredictionPage(driver).PDcardnotes.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Processed Transaction option is displayed: " + oppstr7);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr9 = new ZIFAIPredictionPage(driver).PDcarddecline.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Processed Decline option is displayed: " + oppstr9);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PDnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Processed : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clicking on the Processed OP card
		try {
			new ZIFAIPredictionPage(driver).PDcardvalfirst.click();
			Thread.sleep(3000);
			String strLHS = new ZIFAIPredictionPage(driver).PDcardvalRHS.getText();
			String strRHS = new ZIFAIPredictionPage(driver).PDcardvalLHS.getText();
			System.out.println("The values are" +strLHS +strRHS);
			//boolean retval2 = strLHS.contentEquals(strRHS);
			test.log(Status.PASS, "PR LHS id and RHS id is equal " +strRHS.equalsIgnoreCase(strLHS));
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PDnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Processed : No data is available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Processed - RHS should reflect the Opportunity details - Root cause, CPU, Memory, Disk, Network
		try {
			new ZIFAIPredictionPage(driver).Diskgrp.click();
			test.log(Status.PASS, "Processed Disk graph is clicked");
			Thread.sleep(4000);
			new ZIFAIPredictionPage(driver).Memorygrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Processed Memory graph is clicked");
			new ZIFAIPredictionPage(driver).Networkgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Processed Network graph is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			new ZIFAIPredictionPage(driver).Applicationgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Processed Application graph is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PDnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Processed : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Click on Close Ad and verify the functionality

		try {
			new ZIFAIPredictionPage(driver).closeAd.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Processed CloseAd is clicked and detail window is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).PDnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Processed : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-------------------------------End of Processed script------------------------------//

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		//Verify the Lost OP card script//

		//Verify Currently at Lost OP is displayed//
		try {
			if (driver.findElement(By.xpath("//div[contains(@class,'opp-cards lost-state ng-star-inserted')]")).isDisplayed()) {
				List<WebElement> records = driver.findElements(By.xpath("//div[contains(@class,'opp-cards lost-state ng-star-inserted')]"));
				List<WebElement> recordsct = driver.findElements(By.xpath("//div[contains(@class,'opp-cards lost-state ng-star-inserted')]"));
				int i;
				for ( i= 1; i<records.size(); i=i+1) {
					boolean oppstrcar = recordsct.get(i).isDisplayed();
					Thread.sleep(3000);
					test.log(Status.PASS, "Lost card is displayed: " + oppstrcar);
					String oppstrcar1 = recordsct.get(i).getText();
					Thread.sleep(3000);
					test.log(Status.PASS, "Lost opportunity id and description: " + oppstrcar1);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (Exception e) {
			//new ZIFAIPredictionPage(driver).LTnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Lost :No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Acknowledging the message if it is not pre-acknowledged//

		try {
			if (new ZIFAIPredictionPage(driver).LTcardunack.isDisplayed()) {
				new ZIFAIPredictionPage(driver).LTcardunack.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "LT Acknowledge is verified");
			} else if (new ZIFAIPredictionPage(driver).LTcardack.isDisplayed()) {
				test.log(Status.PASS, "LT Pre Acknowledged is verified");
			}
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).LTnodataAvailable.isDisplayed();
			test.log(Status.PASS, "LT : No Data is available");
			Thread.sleep(3000);
		}

		//Verifying Export , transaction and decline option//

		try {
			boolean oppstr6 = new ZIFAIPredictionPage(driver).LTcardexport.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Lost Export option is displayed: " + oppstr6);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr7 = new ZIFAIPredictionPage(driver).LTcardnotes.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Lost Transaction option is displayed: " + oppstr7);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr9 = new ZIFAIPredictionPage(driver).LTcarddecline.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Lost Decline option is displayed: " + oppstr9);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).LTnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Lost : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clicking on the Lost OP card
		try {
			new ZIFAIPredictionPage(driver).LTcardvalfirst.click();
			String strLHS = new ZIFAIPredictionPage(driver).LTcardvalRHS.getText();
			Thread.sleep(3000);
			String strRHS = new ZIFAIPredictionPage(driver).LTcardvalLHS.getText();
			System.out.println("The values are" +strLHS +strRHS);
			//boolean retval29 = strRHS.contentEquals(strLHS);
			test.log(Status.PASS, "Lost LHS id and RHS id is equal " +strRHS.equalsIgnoreCase(strLHS));
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).LTnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Lost : No data is available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//ETI time and the current time is taken and compared to provide the time difference(greater than one hour)//
		//Verify the warning portlet is displayed with Network opportunity cards with ETI greater than one hour//
		try {
			String ETIval = new ZIFAIPredictionPage(driver).ETItime.getText();
			Thread.sleep(3000);
			System.out.println(ETIval);
			final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			f.setTimeZone(TimeZone.getTimeZone("UTC"));
			String Datefrmt = f.format(new Date());
			String Datefrmt1 = Datefrmt.replace("UTC", "").trim();
			System.out.println(Datefrmt1);
			String time2 = ETIval;
			String time1 = Datefrmt1;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = format.parse(time1);
			Date date2 = format.parse(time2);
			long difference = date2.getTime() - date1.getTime();
			System.out.println(difference);
			long difference1 = TimeUnit.MILLISECONDS.toMinutes(difference);
			long milliseconds = 1000000;
			System.out.format("%d Milliseconds = %d minutes\n", milliseconds, difference1);
			if (difference1 < 120)
				test.log(Status.FAIL, "Total duration is lesser than 2hours: " + difference1);
			else if(difference1 >120) {
				test.log(Status.PASS, "Total duration is more than 2 hours: " + difference1);
			}
		} catch   (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).LTnodataAvailable.isDisplayed();
			test.log(Status.PASS, "CR : No data is available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Lost - RHS should reflect the Opportunity details - Root cause, CPU, Memory, Disk, Network
		try {

			new ZIFAIPredictionPage(driver).Applicationgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Lost Application graph is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			new ZIFAIPredictionPage(driver).Diskgrp.click();
			test.log(Status.PASS, "Lost Disk graph is clicked");
			Thread.sleep(4000);
			new ZIFAIPredictionPage(driver).Memorygrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Lost Memory graph is clicked");
			new ZIFAIPredictionPage(driver).Networkgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Lost Network graph is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).LTnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Lost : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Click on Close Ad and verify the functionality

		try {
			new ZIFAIPredictionPage(driver).closeAd.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Lost CloseAd is clicked and detail window is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).LTnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Lost : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------End of Lost OP script-----------------------------------------//

		//Verify the Inapplicable Now OP card script//
		//Verify Currently at Inapplicable Now OP is displayed//
		try {
			if (driver.findElement(By.xpath("//div[contains(@class,'opp-cards invalid-state ng-star-inserted')]")).isDisplayed()) {
				List<WebElement> records = driver.findElements(By.xpath("//div[contains(@class,'opp-cards invalid-state ng-star-inserted')]"));
				List<WebElement> records1 = driver.findElements(By.xpath("//div[contains(@class,'opp-cards invalid-state ng-star-inserted')]"));
				for (int i = 1; i < records.size(); i++) {
					boolean oppstrcar = records1.get(i).isDisplayed();
					Thread.sleep(3000);
					test.log(Status.PASS, "Inapplicable Now card is displayed: " + oppstrcar);
					String oppstrcar1 = records1.get(i).getText();
					Thread.sleep(3000);
					test.log(Status.PASS, "Inapplicable Now opportunity id and description: " + oppstrcar1);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
		} catch (Exception e) {
			//new ZIFAIPredictionPage(driver).IVnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Inapplicable Now :No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Acknowledging the message if it is not pre-acknowledged//

		try {
			if (new ZIFAIPredictionPage(driver).IVcardunack.isDisplayed()) {
				new ZIFAIPredictionPage(driver).IVcardunack.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "IV Acknowledge is verified");
			} else if (new ZIFAIPredictionPage(driver).LTcardack.isDisplayed()) {
				test.log(Status.PASS, "IV Pre Acknowledged is verified");
			}
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).IVnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Inapplicable Now : No Data is available");
			Thread.sleep(3000);
		}

		//Verifying Export , transaction and decline option//

		try {
			boolean oppstr6 = new ZIFAIPredictionPage(driver).IVcardexport.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "IV Export option is displayed: " + oppstr6);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr7 = new ZIFAIPredictionPage(driver).IVcardnotes.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "IV Transaction option is displayed: " + oppstr7);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			boolean oppstr9 = new ZIFAIPredictionPage(driver).IVcarddecline.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "IV Decline option is displayed: " + oppstr9);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			new ZIFAIPredictionPage(driver).IVcardvalfirst.click();
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "IV opp is clicked");
			Thread.sleep(1000);
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).IVnodataAvailable.isDisplayed();
			test.log(Status.PASS, "IV : No Data Available");

		}


		//Clicking on the Inapplicable Now OP card
		try {
			String strLHS = new ZIFAIPredictionPage(driver).IVcardvalRHS.getText();
			Thread.sleep(3000);
			String strRHS = new ZIFAIPredictionPage(driver).IVcardvalLHS.getText();
			System.out.println("The value is:" +strLHS +strRHS);
			//boolean retval2 = strRHS.contentEquals(strLHS);
			test.log(Status.PASS, "IV LHS id and RHS id is equal " +strLHS.equalsIgnoreCase(strRHS));
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).IVnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Inapplicable Now : No data is available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Inapplicable Now - RHS should reflect the Opportunity details - Root cause, CPU, Memory, Disk, Network
		try {
			new ZIFAIPredictionPage(driver).Applicationgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Inapplicable Now Application graph is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			new ZIFAIPredictionPage(driver).Diskgrp.click();
			test.log(Status.PASS, "Inapplicable Now Disk graph is clicked");
			Thread.sleep(4000);
			new ZIFAIPredictionPage(driver).Memorygrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Inapplicable Now Memory graph is clicked");
			new ZIFAIPredictionPage(driver).Networkgrp.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Inapplicable Now Network graph is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).IVnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Inapplicable Now : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Click on Close Ad and verify the functionality
		try {
			new ZIFAIPredictionPage(driver).closeAd.click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Inapplicable Now CloseAd is clicked and detail window is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			//new ZIFAIPredictionPage(driver).IVnodataAvailable.isDisplayed();
			test.log(Status.PASS, "Inapplicable Now : No Data Available");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//---------------------------------End of Inapplicable Now op scripts------------------------------------------//

		//Database Validation for Threshold Dynamic/ Status in Network Optimization

		String url = properties.getProperty("db.url");
		String db = properties.getProperty("db.name");

		//Validate total number of records for Dynamic in Threshold//
		MongoQueryManager mongoQueryManager = new MongoQueryManager(url, db);
		Map<String, String> fields = new HashMap<String, String>();
		fields.put("THRESHOLD_TYPE", "Dynamic");
		FindIterable<Document> documents = mongoQueryManager.getDocumentsWithFields("NETWORK_Prediction", fields);
		for (Document doc : documents) {
			//access documents e.g. doc.get()
			doc.get("THRESHOLD_TYPE").toString();
			if (documents == null) {
				test.log(Status.FAIL, "No data records found for Dynamic");
			} else if (documents != null){
				test.log(Status.PASS, "data records found for" + doc.get("THRESHOLD_TYPE").toString());

			}

		}

		//Validate total number of records for Static in Threshold//
		MongoQueryManager mongoQueryManagers = new MongoQueryManager(url, db);
		Map<String, String> fieldst = new HashMap<String, String>();
		fieldst.put("THRESHOLD_TYPE", "Static");
		FindIterable<Document> documentst = mongoQueryManagers.getDocumentsWithFields("network_prediction", fields);
		for (Document doc : documentst) {
			//access documents e.g. doc.get()
			doc.get("THRESHOLD_TYPE").toString();
			if (documentst == null) {
				test.log(Status.FAIL, "No data records found for Static");
			} else if (documentst != null){
				test.log(Status.PASS, "data records found for " + doc.get("THRESHOLD_TYPE").toString());

			}

		}



	}
}