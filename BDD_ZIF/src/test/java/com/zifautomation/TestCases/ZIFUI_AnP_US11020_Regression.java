package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.mongodb.client.FindIterable;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIPredictionPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelVerification;
import com.zifautomation.Utility.MongoQueryManager;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class ZIFUI_AnP_US11020_Regression extends Base {

	CommonMethods cm = null;

	@Test
	public void ZIFUI_AnP_US11020_Regression() throws IOException, InterruptedException, Exception {

		//Report Initialization//
		test = extent.createTest("User Story 11020: NTT Req - Part 2 - Feature to turn ON / OFF prediction resource groups");
		test.createNode("User Story 11020: NTT Req - Part 2 - Feature to turn ON / OFF prediction resource groups");
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


		//Navigating to Prediction Resource Group//
		try {
			new ZIFAIPredictionPage(driver).settingsIcon.click();
			Thread.sleep(5000);
			new ZIFAIPredictionPage(driver).Platformmanagement.click();
			Thread.sleep(5000);
			new ZIFAIPredictionPage(driver).Predictionresourcegrp.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Predictions resource group has been clicked and navigated");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to navigate Prediction resource group");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Report Initialization//
		test = extent.createTest("Test Case 11379: Functional - 11020 - When prediction resource types are disabled in platform management - check the prediction module filter and cards");
		test.createNode("Test Case 11379: Functional - 11020 - When prediction resource types are disabled in platform management - check the prediction module filter and cards");
		//Validating CPU radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).cpupredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of cpu " + valuenew);
			if (valuenew.equals("false")) {
				System.out.println("CPU : Already disabled");
			} else if (valuenew.equals("true")) {
				new ZIFAIPredictionPage(driver).cpupredictionenable.click();
			}
			test.log(Status.PASS, "CPU radio button is disabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to disable CPU radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validating Memory radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).memorypredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of memory " + valuenew);
			if (valuenew.equals("true")) {
				System.out.println("Memory :Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).memorypredictionenable.click();
			}
			test.log(Status.PASS, "Memory radio button is enabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enable Memory radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validating CPU radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).diskpredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of disk " + valuenew);
			if (valuenew.equals("true")) {
				System.out.println("Disk: Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).diskpredictionenable.click();
			}
			test.log(Status.PASS, "Prediction radio button is enabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enabled prediction radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating CPU radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).networkpredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of network " + valuenew);
			if (valuenew.equals("true")) {
				System.out.println("Network: Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).networkpredictionenable.click();
			}
			test.log(Status.PASS, "Network radio button is enabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enable network radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating Application radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).applicationpredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of application " + valuenew);
			if (valuenew.equals("Application: true")) {
				System.out.println("Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).applicationpredictionenable.click();
				Thread.sleep(6000);
			}
			test.log(Status.PASS, "Application radio button is enabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enabled application radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validating Hardware radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).hardwarepredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of hardware " + valuenew);
			if (valuenew.equals("Hardware: true")) {
				System.out.println("Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).hardwarepredictionenable.click();
				Thread.sleep(6000);
			}
			new ZIFAIPredictionPage(driver).Savebutton.click();
			Thread.sleep(8000);
			test.log(Status.PASS, "Hardware radio button is enabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enabled hardware radio button");
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

		//Click on Filter and verify cpu resource group is not displayed in filter//
		try {
			Thread.sleep(6000);
			new ZIFAIPredictionPage(driver).filterIcon.click();
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).Resourcefltr.click();
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).Predictionfiltertextbox.sendKeys("cpu");
			Thread.sleep(3000);
			Boolean filterresult = new ZIFAIPredictionPage(driver).Filternoresultfound.isDisplayed();
			if(filterresult){
				test.log(Status.PASS, "cpu resource is hidden from the filter");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "cpu resource is not hidden from the filter after disabling it");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIPredictionPage(driver).Filterclosebutton.click();
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to select network from resource group using settings");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on Filter and Select Network from Resource Group and click apply//
		try {
			Thread.sleep(6000);
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

		//-----------Predicted Risk OP Card - Validation----------------------------------//
		//Clicking on the Predicted Risk OP card after navigating to currently at risk to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).PRcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("memory") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in PR OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "CPU tab is enabled in Risk OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel " +item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Predicted Risk : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}

		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Predicted Risk : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//----------------------------------End of PR Cards-------------------------------------------//

		//-----------Currently at Risk OP Card - Validation----------------------------------//
		//Clicking on the Currently at Risk OP card after navigating to Currently at Risk to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).CARcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("memory") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in CR OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "CPU tab is enabled in Currently at Risk OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Currently at Risk : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}
		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Currently at Risk : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//----------------------------------End of CR Cards-------------------------------------------//
		//-----------Processed OP Card - Validation----------------------------------//
		//Clicking on the Processed OP card after navigating to Processed to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).PDcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("memory") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in Processed OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "CPU tab is enabled in Processed OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Processed : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}
		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Processed : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//----------------------------------End of Processed Cards-------------------------------------------//
		//------------------------------Lost OP Card - Validation----------------------------------//
		//Clicking on the Lost OP card after navigating to Processed to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).LTcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("memory") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in Lost OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "CPU tab is enabled in Lost OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Lost : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}
		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Lost : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------End of Lost OP-----------------------------------------//

		//-----------Inapplicable Now OP Card - Validation----------------------------------//
		//Clicking on the Inapplicable Now OP card after navigating to Processed to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).IVcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("memory") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in Inapplicable Now OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "CPU tab is enabled in Inapplicable Now OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Inapplicable Now : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}
		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Inapplicable Now : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------End of Inapplicable Now OP-----------------------------------------//
		//----------------------------------------End of US11379-------------------------------------------//
		//Report Initialization//
		test = extent.createTest("Test Case 11421: Functional - 11020 - When prediction resource types are enabled in platform management - check the prediction module filter and cards");
		test.createNode("Test Case 11421: Functional - 11020 - When prediction resource types are enabled in platform management - check the prediction module filter and cards");


		//Navigating to Prediction Resource Group//
		try {
			new ZIFAIPredictionPage(driver).settingsIcon.click();
			Thread.sleep(5000);
			new ZIFAIPredictionPage(driver).Platformmanagement.click();
			Thread.sleep(5000);
			new ZIFAIPredictionPage(driver).Predictionresourcegrp.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Predictions resource group has been clicked and navigated");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to navigate Prediction resource group");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating CPU radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).cpupredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of cpu " + valuenew);
			if (valuenew.equals("true")) {
				System.out.println("CPU : Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).cpupredictionenable.click();
			}
			test.log(Status.PASS, "CPU radio button is disabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to disable CPU radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validating Memory radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).memorypredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of memory " + valuenew);
			if (valuenew.equals("false")) {
				System.out.println("Memory :Already disabled");
			} else if (valuenew.equals("true")) {
				new ZIFAIPredictionPage(driver).memorypredictionenable.click();
			}
			test.log(Status.PASS, "Memory radio button is disabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enable Memory radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validating CPU radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).diskpredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of disk " + valuenew);
			if (valuenew.equals("true")) {
				System.out.println("Disk: Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).diskpredictionenable.click();
			}
			test.log(Status.PASS, "Prediction radio button is enabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enabled prediction radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating CPU radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).networkpredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of network " + valuenew);
			if (valuenew.equals("true")) {
				System.out.println("Network: Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).networkpredictionenable.click();
			}
			test.log(Status.PASS, "Network radio button is enabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enable network radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating Application radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).applicationpredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of application " + valuenew);
			if (valuenew.equals("Application: true")) {
				System.out.println("Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).applicationpredictionenable.click();
				Thread.sleep(6000);
			}
			test.log(Status.PASS, "Application radio button is enabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enabled application radio button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validating Hardware radio button and disabling it//
		try {
			String valuenew = new ZIFAIPredictionPage(driver).hardwarepredictionstate.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the radio button of hardware " + valuenew);
			if (valuenew.equals("Hardware: true")) {
				System.out.println("Already enabled");
			} else if (valuenew.equals("false")) {
				new ZIFAIPredictionPage(driver).hardwarepredictionenable.click();
				Thread.sleep(6000);
			}
			new ZIFAIPredictionPage(driver).Savebutton.click();
			Thread.sleep(8000);
			test.log(Status.PASS, "Hardware radio button is enabled");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to enabled hardware radio button");
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

		//Click on Filter and verify memory resource group is not displayed in filter//
		try {
			Thread.sleep(6000);
			new ZIFAIPredictionPage(driver).filterIcon.click();
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).Resourcefltr.click();
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).Predictionfiltertextbox.sendKeys("memory");
			Thread.sleep(3000);
			Boolean filterresult = new ZIFAIPredictionPage(driver).Filternoresultfound.isDisplayed();
			if(filterresult){
				test.log(Status.PASS, "memory resource is hidden from the filter");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "memory resource is not hidden from the filter after disabling it");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIPredictionPage(driver).Filterclosebutton.click();
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify memory from resource group using settings");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on Filter and Select Network from Resource Group and click apply//
		try {
			Thread.sleep(6000);
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

		//-----------Predicted Risk OP Card - Validation----------------------------------//
		//Clicking on the Predicted Risk OP card after navigating to currently at risk to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).PRcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("cpu") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in PR OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "memory tab is enabled in Risk OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel " +item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Predicted Risk : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}

		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Predicted Risk : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//----------------------------------End of PR Cards-------------------------------------------//

		//-----------Currently at Risk OP Card - Validation----------------------------------//
		//Clicking on the Currently at Risk OP card after navigating to Currently at Risk to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).CARcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("cpu") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in CR OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "memory tab is enabled in Currently at Risk OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Currently at Risk : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}
		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Currently at Risk : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//----------------------------------End of CR Cards-------------------------------------------//
		//-----------Processed OP Card - Validation----------------------------------//
		//Clicking on the Processed OP card after navigating to Processed to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).PDcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("cpu") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in Processed OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "memory tab is enabled in Processed OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Processed : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}
		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Processed : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//----------------------------------End of Processed Cards-------------------------------------------//
		//------------------------------Lost OP Card - Validation----------------------------------//
		//Clicking on the Lost OP card after navigating to Processed to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).LTcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("cpu") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in Lost OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "memory tab is enabled in Lost OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Lost : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}
		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Lost : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------End of Lost OP-----------------------------------------//

		//-----------Inapplicable Now OP Card - Validation----------------------------------//
		//Clicking on the Inapplicable Now OP card after navigating to Processed to validate resource group
		// and excel export
		cm.deleteAllFilesInFolder(System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads");
		try {
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).IVcardvalfirst.click();
			Thread.sleep(5000);
			List<String> oppcard = new ArrayList<String>();
			int size_Oppcard = driver.findElements(By.xpath("//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')]")).size();
			for (int i = 1; i < size_Oppcard; i++) {
				String text = driver.findElement(By.xpath("(//div[contains(@class,'highlight-card')]//..//div[contains(@class,'opp-list-id')])[" + i + "]")).getText().replace("Opp", "").trim();
				oppcard.add(text);
			}
			System.out.println("Text Present in Opp Card - " + oppcard);
			Thread.sleep(3000);
			int size = new ZIFAIPredictionPage(driver).Predictionbuttonlist.size();
			for (int i = 0; i < size; i++) {
				Thread.sleep(3000);
				String value = new ZIFAIPredictionPage(driver).Predictionbuttonlist.get(i).getText();
				System.out.println("Available button tabs in prediction: " + value);
				if (value.equals("cpu") || value.equals("disk") || value.equals("network") || value.equals("application") || value.equals("hardware")) {
					System.out.println("Current status of tabs in Inapplicable Now OP: " + value);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				} else {
					test.log(Status.FAIL, "memory tab is enabled in Inapplicable Now OP");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					Thread.sleep(3000);
				}
			}
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(25000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			for (String item : oppcard) {
				if (excel.contains(item)) {
					test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel "+item);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else {
					test.log(Status.FAIL, "Unable to filter new case and verify though excel");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				System.out.println("Read Excel" + excel);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Inapplicable Now : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Validating the network keyword in description of OP cards//
		try {
			WebElement DChover = new ZIFAIPredictionPage(driver).Oppcardspredetails;
			Actions action = new Actions(driver);
			Thread.sleep(4000);
			action.moveToElement(DChover).perform();
			Thread.sleep(3000);
			WebElement predetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String predetailshover = predetails.getText();
			System.out.println("Pre details :" + predetailshover);
			if(predetailshover.contains("Network")||predetailshover.contains("network")){
				test.log(Status.PASS, "Pre details consist of Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			else{
				test.log(Status.FAIL, "Pre details does not consist Network keyword "+predetailshover);
				test.addScreenCaptureFromPath(captureScreenShot(driver)); }
			Thread.sleep(3000);
			new ZIFAIPredictionPage(driver).closeAd.click();
		}
		catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Inapplicable Now : No data is available to validate");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//----------------------------------------End of US11421---------------------------------------------------//



	}
}