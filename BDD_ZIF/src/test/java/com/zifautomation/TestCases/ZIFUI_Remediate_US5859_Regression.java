package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIAppSettingsPage;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Remediate_US5859_Regression extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;
	CommonMethods cm = null;


	@Test
	public void ZIFUI_Remediate_US5859_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("User Story 5859: File upload BOT UI & API changes");
		test.createNode("User Story 5859: File upload BOT UI & API changes");

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

		//click on the ZIF Bots from setting icon//
		try {
			new ZIFAIDashboardPage(driver).clickAppSettings();
			Thread.sleep(3000);
			new ZIFAIDashboardPage(driver).ZIFBots.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clicked on ZIF Bots");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the ZIF Bots from setting icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//--------------------------------End of US----------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6109: Verify the download functionality is working in the BOTS screen");
		test.createNode("Test Case 6109: Verify the download functionality is working in the BOTS screen");

		try{
			new ZIFAIAppSettingsPage(driver).Filtericon.click();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ServiceNow Attachment Download");
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Filtering specific Bot name for download");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to filter for download" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//Click on Download and verify the file is present//
		cm.deleteAllFilesInFolder(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads");
		try{
			new ZIFAIAppSettingsPage(driver).Botdownload.click();
			Thread.sleep(6000);
			new ZIFAIAppSettingsPage(driver).isFileDownloaded(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads","helloworld.ps1");
			test.log(Status.PASS, "Clicked on Download and verified the file has been downloaded");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
	}catch (AssertionError | Exception e) {
		test.log(Status.FAIL, "Unable to download the file" +e);
		test.addScreenCaptureFromPath(captureScreenShot(driver));
	}

		//Clearing the filter after download and verification//
		try{
			new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Clear.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the filter after download and verification");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after download" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//---------------------------------------End of US------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6106: Verify filter functionality is working in the BOTS screen");
		test.createNode("Test Case 6106: Verify filter functionality is working in the BOTS screen");

		try{
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ServiceNow Attachment Download");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				System.out.println(resultstr);
				if(resultstr.equalsIgnoreCase("ServiceNow Attachment Download")){
					Thread.sleep(3000);
					test.log(Status.PASS, "Bot name is filtered as per the input provided in filter");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to Filter bot name");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

			}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation using Bot name" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the filter after download and verification//
		try{
			new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Clear.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the filter after bot name filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after bot name filter" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try{
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filtercategorydrpdown.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filtercategoryserver.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			String resultstr = new ZIFAIAppSettingsPage(driver).Filtercategoryverification.getText();
			System.out.println(resultstr);
			if(resultstr.equalsIgnoreCase("Servers")){
				Thread.sleep(3000);
				test.log(Status.PASS, "Server name is filtered as per the input in filter");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				test.log(Status.FAIL, "Unable to Filter Server from list");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation using Server " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the filter after download and verification//
		try{
			new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Clear.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the filter after server name filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after bot server filter" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try{
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filtericon.click();
			String b = Keys.BACK_SPACE.toString();
			new ZIFAIAppSettingsPage(driver).Filteruploadedby.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filteruploadedby.sendKeys("zifadmin@zif.ai");
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			String resultstr = new ZIFAIAppSettingsPage(driver).Filteruploadedbyverification.getText();
			System.out.println(resultstr);
			if(resultstr.equalsIgnoreCase("zifadmin@zif.ai")){
				Thread.sleep(3000);
				test.log(Status.PASS, "List is filtered as per the uploaded by user name");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				test.log(Status.FAIL, "Unable to Filter uploaded by");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation using uploaded by" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the filter after download and verification//
		try{
			new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Clear.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the filter after uploaded by filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after uploaded by filter" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//-----------------------------------------End of US------------------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 6113: Verify the script verified flag functionality is working in the BOTS screen");
		test.createNode("Test Case 6113: Verify the script verified flag functionality is working in the BOTS screen");

		try{
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filtericon.click();
			String b = Keys.BACK_SPACE.toString();
			new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ServiceNow Attachment Download");
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			Actions cqseacknowl = new Actions(driver);
			cqseacknowl.moveToElement(new ZIFAIAppSettingsPage(driver).Zifcertifiedhover).perform();
			Thread.sleep(3000);
			Boolean resultstr = new ZIFAIAppSettingsPage(driver).Zifcertified.isDisplayed();
			System.out.println(resultstr);
			if(resultstr==true){
				Thread.sleep(3000);
				test.log(Status.PASS, "ZIF certified is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(resultstr==false) {
				test.log(Status.FAIL, "ZIF certified is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify ZIF certified option from ZIF Bots " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the filter after download and verification//
		try{
			new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Clear.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the filter after bot name filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after bot name filter" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//-------------------------------------End of US------------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6112: Verify the bot tool tip functionality is working in the BOTS screen");
		test.createNode("Test Case 6112: Verify the bot tool tip functionality is working in the BOTS screen");

		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\PasswordProtected.zip");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFQA");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
			Actions cqseacknowl = new Actions(driver);
			cqseacknowl.moveToElement(new ZIFAIAppSettingsPage(driver).Botnamehover).perform();
			WebElement Ackzif = driver.findElement(By.cssSelector(".ui-tooltip"));
			Thread.sleep(3000);
			String Acknledgestatus = Ackzif.getText();
			if(Acknledgestatus.equalsIgnoreCase("Automation to test File upload")){
			System.out.println("Bot description displayed when hovered on Zif bot: " +Acknledgestatus);
			test.log(Status.PASS, "Bot description is displayed when hovered on Zif bot : " +Acknledgestatus);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}else if(!Acknledgestatus.equalsIgnoreCase("Automation to test File upload")){
			test.log(Status.FAIL, "Bot description is not matching when hovered on ZIF bot : " +Acknledgestatus);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		}catch (AssertionError | Exception e){
				test.log(Status.FAIL, "Bot description is not displayed when hovered on Zif bot" + e);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}


		//Deleting the ZIF bot which is created//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				if(resultstr.equalsIgnoreCase("ZIFQA")){
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Botdelete.click();
					test.log(Status.PASS, "Exact Bot name is filtered and deleted after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to get the search result as per the input for deleting it after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				if(resultstr.equalsIgnoreCase("ZIFQA")){
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Botdelete.click();
					test.log(Status.PASS, "Exact Bot name is filtered and deleted after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to get the search result as per the input for deleting it after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}	}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation for search after compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Verifying whether QA Bot is displayed//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				if(new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()){
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				if(new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

			}	}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name after compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clearing the values after upload//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Clear.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clearing the filter after verification of compressed file upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Clear.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clearing the filter after verification of compressed file upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name of compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//---------------------------------End of US--------------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6110: Verify the delete functionality is working in the BOTS screen");
		test.createNode("Test Case 6110: Verify the delete functionality is working in the BOTS screen");

		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\PasswordProtected.zip");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFQA");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
			Actions cqseacknowl = new Actions(driver);
			cqseacknowl.moveToElement(new ZIFAIAppSettingsPage(driver).Botnamehover).perform();
			WebElement Ackzif = driver.findElement(By.cssSelector(".ui-tooltip"));
			Thread.sleep(3000);
			String Acknledgestatus = Ackzif.getText();
			if(Acknledgestatus.equalsIgnoreCase("Automation to test File upload")){
				System.out.println("Bot description displayed when hovered on Zif bot: " +Acknledgestatus);
				test.log(Status.PASS, "Bot description is displayed when hovered on Zif bot : " +Acknledgestatus);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}else if(!Acknledgestatus.equalsIgnoreCase("Automation to test File upload")){
				test.log(Status.FAIL, "Bot description is not matching when hovered on ZIF bot : " +Acknledgestatus);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (AssertionError | Exception e){
			test.log(Status.FAIL, "Bot description is not displayed when hovered on Zif bot" + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Deleting the ZIF bot which is created//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				if(resultstr.equalsIgnoreCase("ZIFQA")){
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Botdelete.click();
					test.log(Status.PASS, "Successfully deleted the bot after uploading it");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to get the search result as per the input for deleting it after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				if(resultstr.equalsIgnoreCase("ZIFQA")){
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Botdelete.click();
					test.log(Status.PASS, "Exact Bot name is filtered and deleted after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to get the search result as per the input for deleting it after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}	}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation for search after compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Verifying whether QA Bot is displayed//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				if(new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()){
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				if(new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

			}	}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name after compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clearing the values after upload//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Clear.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clearing the filter after verification of compressed file upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Clear.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clearing the filter after verification of compressed file upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name of compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//--------------------------------------End of US-------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6111: Verify the edit functionality is working in the BOTS screen");
		test.createNode("Test Case 6111: Verify the edit functionality is working in the BOTS screen");

		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\PasswordProtected.zip");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFQA");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Successfully uploaded the file ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to upload the file" + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on edit and verifying user can edit it//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				if(resultstr.equalsIgnoreCase("ZIFQA")){
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Botedit.click();
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Filtereditbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Filtereditbotname.sendKeys("ZIFeditedQA");
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Apply.click();
					Thread.sleep(4000);
					test.log(Status.PASS, "Successfully edited the bot after uploading it");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to edit the bot after editing it");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}}catch (AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to edit the ZIF Bot" + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Deleting the ZIF bot which is created//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFeditedQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				if(resultstr.equalsIgnoreCase("ZIFeditedQA")){
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Botdelete.click();
					test.log(Status.PASS, "Successfully deleted the bot after editing it");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to get the search result as per the input for deleting it after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFeditedQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				if(resultstr.equalsIgnoreCase("ZIFeditedQA")){
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Botdelete.click();
					test.log(Status.PASS, "Exact Bot name is filtered and deleted after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to get the search result as per the input for deleting it after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}	}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation for search after compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Verifying whether QA Bot is displayed//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFeditedQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				if(new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()){
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFeditedQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				if(new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

			}	}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name after compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clearing the values after upload//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Clear.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clearing the filter after verification of compressed file upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Clear.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clearing the filter after verification of compressed file upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name of compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//---------------------------------------End of US----------------------------------------------//
		//Test Case 6107: Verify sorting functionality is working in the BOTS screen//

		//Report Initialization
		test = extent.createTest("Test Case 6107: Verify sorting functionality is working in the BOTS screen");
		test.createNode("Test Case 6107: Verify sorting functionality is working in the BOTS screen");

		//click on the regular sort icon to enable descending sort in BOT name//
		try {
			new ZIFAIAppSettingsPage(driver).Botsortregular.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Botdesc.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clicked on ZIF Bots");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the ZIF Bots from setting icon" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clicking on the Asc button on the bot name column and verifying it

		try {
			Thread.sleep(3000);
			//Method to Verify the cases present in Other section are not displayed in Priority cases section//
			new ZIFAIAppSettingsPage(driver).Botascending();
			test.log(Status.PASS, "Verified Bot name is sorted in ascending order");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}catch (AssertionError | Exception e) {
			test.log(Status.PASS, "Verified Bot name is sorted in ascending order");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on the Desc button on the bot name column and verifying it

		try {
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Botasc.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Botdescending();
			test.log(Status.PASS, "Verified Bot name is sorted in descending order");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify bot name is sorted in descending order");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//---------------------------------------End of US------------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6104: Verify the following fields should be present in the modified BOTS screen");
		test.createNode("Test Case 6104: Verify the following fields should be present in the modified BOTS screen");

		try{
			Boolean botclmst = new ZIFAIAppSettingsPage(driver).botcolumn.isDisplayed();
			Thread.sleep(3000);
			if(botclmst==true){
				test.log(Status.PASS, "Bot name field is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(botclmst==false){
				test.log(Status.FAIL, "Unable to verify Bot name field");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean botctgst = new ZIFAIAppSettingsPage(driver).botcategory.isDisplayed();
			Thread.sleep(3000);
			if(botctgst==true){
				test.log(Status.PASS, "Bot category field is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(botctgst==false){
				test.log(Status.FAIL, "Unable to verify Bot category field");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean botimest = new ZIFAIAppSettingsPage(driver).bottime.isDisplayed();
			Thread.sleep(3000);
			if(botimest==true){
				test.log(Status.PASS, "Bot time field is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(botimest==false){
				test.log(Status.FAIL, "Unable to verify Bot time field");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean botupldst = new ZIFAIAppSettingsPage(driver).uploadedby.isDisplayed();
			Thread.sleep(3000);
			if(botupldst==true){
				test.log(Status.PASS, "Bot uploaded by field is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(botupldst==false){
				test.log(Status.FAIL, "Unable to verify Bot uploaded by field");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean botdwnld = new ZIFAIAppSettingsPage(driver).Botdownload.isDisplayed();
			Thread.sleep(3000);
			if(botdwnld==true){
				test.log(Status.PASS, "Bot download icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(botdwnld==false){
				test.log(Status.FAIL, "Unable to verify Bot download icon");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean botdlte = new ZIFAIAppSettingsPage(driver).Botdelete.isDisplayed();
			Thread.sleep(3000);
			if(botdlte==true){
				test.log(Status.PASS, "Bot delete icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(botdlte==false){
				test.log(Status.FAIL, "Bot delete icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Boolean boteditst = new ZIFAIAppSettingsPage(driver).Botedit.isDisplayed();
			Thread.sleep(3000);
			if(boteditst==true){
				test.log(Status.PASS, "Bot edit icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(boteditst==false){
				test.log(Status.FAIL, "Bot edit icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Actions action = new Actions(driver);
			Thread.sleep(2000);
			action.moveToElement(new ZIFAIAppSettingsPage(driver).Bottooltip).perform();
			WebElement bottip = driver.findElement(By.cssSelector(".ui-tooltip"));
			String bottooltip = bottip.getText();
			System.out.println("Tooltip: " + bottooltip);
			if (!bottooltip.isEmpty()) {
				test.log(Status.PASS, "Bot tooltip is verified");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if (bottooltip.isEmpty()) {
				test.log(Status.FAIL, "Unable to verify tooltp");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Actions actionst = new Actions(driver);
			Thread.sleep(2000);
			actionst.moveToElement(new ZIFAIAppSettingsPage(driver).Zifcertifiedhover).perform();
			WebElement certified = driver.findElement(By.cssSelector(".ui-tooltip"));
			String certifiedhover = certified.getText();
			System.out.println("ZIF certified icon when hovered:" + certifiedhover);
			if (certifiedhover.equals("ZIF Certified")) {
				test.log(Status.PASS, "ZIF Certified text is displayed when hovered on ZIF Certified icon ");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if (!certifiedhover.equals("ZIF Certified")) {
				test.log(Status.FAIL, "ZIF Certified text is not displayed when hovered on ZIF Certified icon ");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify field in the modified BOTS screen");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------------End of US-----------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 6108: Verify the upload BOT functionality is working in the BOTS screen");
		test.createNode("Test Case 6108: Verify the upload BOT functionality is working in the BOTS screen");

		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\PasswordProtected.zip");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFQA");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
			Actions cqseacknowl = new Actions(driver);
			cqseacknowl.moveToElement(new ZIFAIAppSettingsPage(driver).Botnamehover).perform();
			WebElement Ackzif = driver.findElement(By.cssSelector(".ui-tooltip"));
			Thread.sleep(3000);
			String Acknledgestatus = Ackzif.getText();
			if(Acknledgestatus.equalsIgnoreCase("Automation to test File upload")){
				System.out.println("Bot description displayed when hovered on Zif bot: " +Acknledgestatus);
				test.log(Status.PASS, "Bot description is displayed when hovered on Zif bot : " +Acknledgestatus);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}else if(!Acknledgestatus.equalsIgnoreCase("Automation to test File upload")){
				test.log(Status.FAIL, "Bot description is not matching when hovered on ZIF bot : " +Acknledgestatus);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (AssertionError | Exception e){
			test.log(Status.FAIL, "Bot description is not displayed when hovered on Zif bot" + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Deleting the ZIF bot which is created//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				if(resultstr.equalsIgnoreCase("ZIFQA")){
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Botdelete.click();
					test.log(Status.PASS, "Exact Bot name is filtered and deleted after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to get the search result as per the input for deleting it after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
				if(resultstr.equalsIgnoreCase("ZIFQA")){
					Thread.sleep(3000);
					new ZIFAIAppSettingsPage(driver).Botdelete.click();
					test.log(Status.PASS, "Exact Bot name is filtered and deleted after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else {
					test.log(Status.FAIL, "Unable to get the search result as per the input for deleting it after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}	}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation for search after compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Verifying whether QA Bot is displayed//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				if(new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()){
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Apply.click();
				Thread.sleep(3000);
				if(new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified after compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
					test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot compressed file upload");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}

			}	}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name after compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clearing the values after upload//
		try{
			if(new ZIFAIAppSettingsPage(driver).Filtericonthreedots.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Clear.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clearing the filter after verification of compressed file upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Filtericon.click();
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Clear.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Clearing the filter after verification of compressed file upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name of compressed file upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

	}
	}