package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIAppSettingsPage;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Remediate_US1502_Regression extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;
	CommonMethods cm = null;


	@Test
	public void ZIFUI_AnP_US1502_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("User Story 1502: Secured upload of BOT- Hashing & Comparison - UI");
		test.createNode("User Story 1502: Secured upload of BOT- Hashing & Comparison - UI");

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


		//Report Initialization
		test = extent.createTest("Test Case 4532: Verify Admin user can upload package in Bots screen");
		test.createNode("Test Case 4532: Verify Admin user can upload package in Bots screen");

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
			if(new ZIFAIAppSettingsPage(driver).Fileuploadsuccessmessage.isDisplayed()){
				test.log(Status.PASS, "Successfully uploaded file password and packaged file");
				Thread.sleep(3000);
			}
			else{
				test.log(Status.FAIL, "Unable to upload secured file");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to upload file operation " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//---------------------------------End of US--------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4536: Verify Admin user can search any package in Bots screen");
		test.createNode("Test Case 4536: Verify Admin user can search any package in Bots screen");
		try{
			new ZIFAIAppSettingsPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFQA");
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
			if(resultstr.equalsIgnoreCase("ZIFQA")){
				test.log(Status.PASS, "Exact Bot name is filtered as per the filter search");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				test.log(Status.FAIL, "Unable to get the search result as per the input");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//---------------------------------End of US--------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4535: Verify Admin user can delete any package in Bots screen");
		test.createNode("Test Case 4535: Verify Admin user can delete any package in Bots screen");
		try{
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
				test.log(Status.PASS, "Exact Bot name is filtered and deleted");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				test.log(Status.FAIL, "Unable to get the search result as per the input for deleting it");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation for search" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try{
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
				test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
				test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try{
			new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Clear.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the filter after verification");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//--------------------------------End of US----------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4534: Verify Admin user can download package in Bots screen");
		test.createNode("Test Case 4534: Verify Admin user can download package in Bots screen");

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
		test = extent.createTest("Test Case 4537: Verify Admin user cannot upload other than package in Bots screen");
		test.createNode("Test Case 4537: Verify Admin user cannot upload other than package in Bots screen");

		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\helloworld.zip");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFQA");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			if(new ZIFAIAppSettingsPage(driver).Fileuploadinvalidmessage.isDisplayed()){
				test.log(Status.PASS, "Successfully verified only password protected files can be uploaded");
				Thread.sleep(3000);
			}
			else{
				test.log(Status.FAIL, "Able to upload ZIF unprotected file");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify user can upload secure file only " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\helloworld.ps1");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFQA");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			if(new ZIFAIAppSettingsPage(driver).Fileuploadinvalidfileformat.isDisplayed()){
				test.log(Status.PASS, "Successfully verified only package files can be uploaded");
				Thread.sleep(3000);
			}
			else{
				test.log(Status.FAIL, "Able to upload ZIF unpacked file");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify user can upload packaged file only " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-----------------------------------------End of US-----------------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 4672: Verify all GAVS developed Shell Scripts/Python Scripts should be compressed with the secret key or password");
		test.createNode("Test Case 4672: Verify all GAVS developed Shell Scripts/Python Scripts should be compressed with the secret key or password");

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
			if(new ZIFAIAppSettingsPage(driver).Fileuploadsuccessmessage.isDisplayed()){
				test.log(Status.PASS, "Successfully uploaded GAVS developed Shell Scripts/Python Scripts compressed file with password");
				Thread.sleep(3000);
			}
			else{
				test.log(Status.FAIL, "Unable to upload GAVS developed Shell Scripts/Python Scripts compressed file with password");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to upload file operation with GAVS developed shell script " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

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

		//------------------------------------End of US---------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4550: Verify authenticate users while uploading a file in Bots screen");
		test.createNode("Test Case 4550: Verify authenticate users while uploading a file in Bots screen");


		try{
			Thread.sleep(3000);
			String username = new ZIFAIAppSettingsPage(driver).Usernameverification.getText();
			if(username.contains("@GAVSTECH.COM") || username.contains("zifadmin@zif.ai" )) {
				System.out.println("Authenticated user who has accessed Bots screen: " + username);
				test.log(Status.PASS, "Authenticated user with admin access as clicked on bots screen  :" + username);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}else{
				test.log(Status.FAIL, "Unauthenticated user with admin access as clicked on bots screen  :" +username);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify authenticated user who has clicked on Bots screen " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------------End of US---------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4531: Verify Bots screen should display set of all bots");
		test.createNode("Test Case 4531: Verify Bots screen should display set of all bots");

		try{
			int botlist = new ZIFAIAppSettingsPage(driver).Botnamelist.size();
			int i=1;
			for (i=1;i<botlist;i++){
			String valuelist = 	new ZIFAIAppSettingsPage(driver).Botnamelist.get(i).getText();
			System.out.println("Bot name: " +valuelist);
				test.log(Status.PASS, "Bot name : "+valuelist);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the bot name from the table" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//---------------------------------End of US----------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 5076: Verify Package Name should have a maximum file size validation should be present in the BOTS screen");
		test.createNode("Test Case 5076: Verify Package Name should have a maximum file size validation should be present in the BOTS screen");

		//if Fails then due to defect id 7905//

		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\Web_9mb.zip");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("Maximumsizefile");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Boolean report = new ZIFAIAppSettingsPage(driver).Fileuploadmaxsize.isDisplayed();
			if(report){
				test.log(Status.PASS, "Bot upload maximum size error message is displayed");
				Thread.sleep(3000);
			}
			else{
				test.log(Status.FAIL, "Accepts more than the upload limitation size(4mb)");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to upload file operation with GAVS developed shell script " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//----------------------------------------End of US---------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 5075: Verify Package Name should have a maximum name length validation should be present in the BOTS screen");
		test.createNode("Test Case 5075: Verify Package Name should have a maximum name length validation should be present in the BOTS screen");


		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\PasswordProtected.zip");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			if(new ZIFAIAppSettingsPage(driver).Fileuploadmaxname.isDisplayed()){
				test.log(Status.PASS, "Bot name does not accept more than 35 characters long");
				Thread.sleep(3000);
			}
			else{
				test.log(Status.FAIL, "Bot name accepts more than 35 characters long");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify characters size in Bot name " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//------------------------------------End of US-------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4551: Verify set a maximum name length and maximum file size while uploading a file in Bots screen");
		test.createNode("Test Case 4551: Verify set a maximum name length and maximum file size while uploading a file in Bots screen");

		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\Web_9mb.zip");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Maximum File size and maximum characters");
			Thread.sleep(4000);
			Boolean report = new ZIFAIAppSettingsPage(driver).Fileuploadmaxname.isDisplayed();
			if(report){
				test.log(Status.PASS, "Successfully verified maximum file size and maximum characters cannot be done");
				Thread.sleep(3000);
			}
			else {
				test.log(Status.FAIL, "Unable to verify the file which is been uploaded maximum size and maximum characters in bot name length");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify the maximum size and length of characters in bot name " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//----------------------------End of US-----------------------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 4585: Verify simple error messages are displaying for file upload errors in Bots screen");
		test.createNode("Test Case 4585: Verify simple error messages are displaying for file upload errors in Bots screen");

		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\helloworld.ps1");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFQA");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			if(new ZIFAIAppSettingsPage(driver).Fileuploadinvalidfileformat.isDisplayed()){
				test.log(Status.PASS, "Successfully verified simple error message");
				Thread.sleep(3000);
			}
			else{
				test.log(Status.FAIL, "Unable to verify the simple error message");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify the simple error message " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



//		try{
//			new ZIFAIAppSettingsPage(driver).Filtericon.click();
//			Thread.sleep(3000);
//			new ZIFAIAppSettingsPage(driver).Clear.click();
//			Thread.sleep(3000);
//			test.log(Status.PASS, "Clearing the filter after verification");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}	catch (AssertionError | Exception e) {
//			test.log(Status.FAIL, "Not able to verify after deleting bot name" +e);
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}

		//-------------------------------------End of US----------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4530: Verify the following fields are present in the Bots screen");
		test.createNode("Test Case 4530: Verify the following fields are present in the Bots screen");

		try{
			boolean Botclmn = new ZIFAIAppSettingsPage(driver).botcolumn.isDisplayed();
			boolean Bottime = new ZIFAIAppSettingsPage(driver).bottime.isDisplayed();
			boolean Botpld = new ZIFAIAppSettingsPage(driver).uploadedby.isDisplayed();
			boolean Botcatego = new ZIFAIAppSettingsPage(driver).botcategory.isDisplayed();
			boolean Botuplodicn = new ZIFAIAppSettingsPage(driver).botuploadicon.isDisplayed();
			boolean Botfltric = new ZIFAIAppSettingsPage(driver).Filtericon.isDisplayed();
			boolean Botdown = new ZIFAIAppSettingsPage(driver).Botdownload.isDisplayed();
			boolean Botdel = new ZIFAIAppSettingsPage(driver).Botdelete.isDisplayed();
			if(Botclmn==true){
				test.log(Status.PASS, "Bot package name column is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if((Botclmn==false)){
				test.log(Status.FAIL, "Bot package name column is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Bottime==true){
				test.log(Status.PASS, "Bot Uploaded Date and Time column is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if((Bottime==false)){
				test.log(Status.FAIL, "Bot Uploaded Date and Time column is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Botpld==true){
				test.log(Status.PASS, "Bot uploaded by column is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if((Botpld==false)){
				test.log(Status.FAIL, "Bot uploaded by column is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Botcatego==true){
				test.log(Status.PASS, "Bot Category column is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if((Botcatego==false)){
				test.log(Status.FAIL, "Bot Category column is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Botuplodicn==true){
				test.log(Status.PASS, "Bot upload package icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if((Botuplodicn==false)){
				test.log(Status.FAIL, "Bot upload package icon is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Botfltric==true){
				test.log(Status.PASS, "Bot filter icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if((Botfltric==false)){
				test.log(Status.FAIL, "Bot filter icon is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Botdown==true){
				test.log(Status.PASS, "Bot download icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if((Botdown==false)){
				test.log(Status.FAIL, "Bot download icon is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(Botdel==true){
				test.log(Status.PASS, "Bot delete icon is displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if((Botdel==false)){
				test.log(Status.FAIL, "Bot delete icon is not displayed");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

		}catch (Exception e){
			test.log(Status.FAIL, "Not able to verify fields are present in the Bots screen " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//-------------------------------------End of US---------------------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 4540: Verify uploading a file in Bots screen should be in compressed format (ZIP)");
		test.createNode("Test Case 4540: Verify uploading a file in Bots screen should be in compressed format (ZIP)");

		//Click on Upload ZIF Bots icon//
		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\PasswordProtected.zip");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("ZIFTestQA");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			if(new ZIFAIAppSettingsPage(driver).Fileuploadsuccessmessage.isDisplayed()){
				test.log(Status.PASS, "Successfully uploaded compressed format (ZIP)");
				Thread.sleep(3000);
			}
			else{
				test.log(Status.FAIL, "unsuccessful in uploading compressed format (ZIP)");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to upload compressed file " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try{
			new ZIFAIAppSettingsPage(driver).Filtericon.click();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFTestQA");
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			String resultstr = new ZIFAIAppSettingsPage(driver).Searchresultbot.getText();
			if(resultstr.equalsIgnoreCase("ZIFTestQA")){
				Thread.sleep(3000);
				new ZIFAIAppSettingsPage(driver).Botdelete.click();
				test.log(Status.PASS, "Exact Bot name is filtered and deleted after compress upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				test.log(Status.FAIL, "Unable to get the search result as per the input for compress upload");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to perform search operation for search after compress upload" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try{
			new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Filterbotname.sendKeys("ZIFTestQA");
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Thread.sleep(3000);
			if(new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
				test.log(Status.PASS, "ZIFQA bot name is deleted and successfully verified");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(!new ZIFAIAppSettingsPage(driver).Nodatafound.isDisplayed()){
				test.log(Status.FAIL, "Verification failed after deleting ZIFQA bot");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try{
			new ZIFAIAppSettingsPage(driver).Filtericonthreedots.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Clear.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the filter after verification");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}	catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify after deleting bot name" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-------------------------------------End of US-----------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 4541: Verify uploading a file in Bots screen should not in executable format (.exe)");
		test.createNode("Test Case 4541: Verify uploading a file in Bots screen should not in executable format (.exe)");

		try{
			new ZIFAIAppSettingsPage(driver).UploadZIF.click();
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).fileupload.sendKeys(System.getProperty("user.dir")+"\\resources\\Datatables\\BotUpload\\npp.7.Installer.x64.exe");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botname.sendKeys("Exe file upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Botdescription.sendKeys("Automation to test File upload");
			Thread.sleep(4000);
			new ZIFAIAppSettingsPage(driver).Apply.click();
			Boolean report = new ZIFAIAppSettingsPage(driver).Fileuploadfileinvalidmessage.isDisplayed();
			if(report==true){
				test.log(Status.PASS, "Successfully verified exe file cannot be uploaded");
				Thread.sleep(3000);
			}
			else if(report==false){
				test.log(Status.FAIL, "Unable to verify the whether.exe file can be uploaded");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAIAppSettingsPage(driver).Filterclose.click();
			Thread.sleep(3000);
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to upload and verify .exe file " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//--------------------------------------------End of US--------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 5077: Verify user have edit option present for every package in the BOTS screen");
		test.createNode("Test Case 5077: Verify user have edit option present for every package in the BOTS screen");
		try{
			Thread.sleep(3000);
			int size = driver.findElements(By.xpath("(//em[@class='edit-icon'])")).size();
			System.out.println("No of edit icon available: " +size);
			for (int j = 1; j <= size; j++) {
				WebElement Listbox = driver.findElement(By.xpath("(//em[@class='edit-icon'])[" + j + "]"));
				Boolean status = Listbox.isDisplayed();
				System.out.println("Edit icon status: " +status);

			}
			test.log(Status.PASS, "Edit icon is verified in the list of Bot package");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the edit icon in the list" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-----------------------------------------End of US------------------------------------------------------------//


	}
	}