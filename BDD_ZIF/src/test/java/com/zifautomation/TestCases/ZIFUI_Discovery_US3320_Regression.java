package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Discovery_US3320_Regression extends Base {


	@Test
	public void ZIFUI_Discovery_US3320_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("User Story 3320: ZIF Discovery - Discovery Summary");
		test.createNode("User Story 3320: ZIF Discovery - Discovery Summary");
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
		//---------------------------------------End of US---------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3732: Verify Discovery Summary values for a Passed discovery");
		test.createNode("Test Case 3732: Verify Discovery Summary values for a Passed discovery");

		//Discovery details section should be displayed with Discovery ID, Created date,Start date,End date, Recursive discovery, Types of devices discovered//
		try {
			Thread.sleep(3000);
			String Discoverystr =	new ZIFAI_AlertsSettingsPage(driver).DiscoveryID.getText();
			Thread.sleep(3000);
			String Creatdatestr = new ZIFAI_AlertsSettingsPage(driver).CreatedDate.getText();
			Thread.sleep(3000);
			String Startdatestr = new ZIFAI_AlertsSettingsPage(driver).StartDate.getText();
			Thread.sleep(3000);
			String Enddatestr = new ZIFAI_AlertsSettingsPage(driver).EndDate.getText();
			Thread.sleep(3000);
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).Location.getText();
			Thread.sleep(3000);
			System.out.println("Discovery details are "+" DiscoveryID: "+Discoverystr+ " Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.log(Status.PASS, "Discovery details are"+" DiscoveryID: "+Discoverystr+" Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Validate the discovery details");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify number of devices displayed equals the count of the discovered devices from the sum of Types of devices//
		try {
			String Valueu = new ZIFAI_AlertsSettingsPage(driver).Devicecount.getText().replace("(", "").replace(")", "").trim();
			int Valueint = Integer.parseInt(Valueu);
			Thread.sleep(3000);
			System.out.println("Device count " + Valueu);
			String Valuea = new ZIFAI_AlertsSettingsPage(driver).Servertotal.getText();
			int Valueb = Integer.parseInt(Valuea);
			System.out.println(Valueb);
			Thread.sleep(3000);
			String Valueac = new ZIFAI_AlertsSettingsPage(driver).Desktoptotal.getText();
			int Valued = Integer.parseInt(Valueac);
			System.out.println(Valued);
			Thread.sleep(3000);
			String Valuee = new ZIFAI_AlertsSettingsPage(driver).Laptoptotal.getText();
			int Valuef = Integer.parseInt(Valuee);
			System.out.println(Valuef);
			Thread.sleep(3000);
			String Valueg = new ZIFAI_AlertsSettingsPage(driver).Unknowntotal.getText();
			int Valueh = Integer.parseInt(Valueg);
			System.out.println(Valueh);
			Thread.sleep(3000);
			String Valuei = new ZIFAI_AlertsSettingsPage(driver).Wifitotal.getText();
			int Valuej = Integer.parseInt(Valuei);
			System.out.println(Valuei);
			Thread.sleep(3000);
			String Valuek = new ZIFAI_AlertsSettingsPage(driver).IPtotal.getText();
			int Valuel = Integer.parseInt(Valuek);
			System.out.println(Valuel);
			Thread.sleep(3000);
			String Valuem = new ZIFAI_AlertsSettingsPage(driver).L2total.getText();
			int Valuen = Integer.parseInt(Valuem);
			System.out.println(Valuen);
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).rightarrow.click();
			Thread.sleep(3000);
			String Valueo = new ZIFAI_AlertsSettingsPage(driver).Routertotal.getText();
			int Valuep = Integer.parseInt(Valueo);
			System.out.println(Valuep);
			Thread.sleep(3000);
			String Valueq = new ZIFAI_AlertsSettingsPage(driver).Printertoal.getText();
			int Valuer = Integer.parseInt(Valueq);
			System.out.println(Valuer);
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).rightarrow.click();
			Thread.sleep(3000);
			String Valuez = new ZIFAI_AlertsSettingsPage(driver).L3total.getText();
			int Valuex = Integer.parseInt(Valuez);
			System.out.println("L3total " + Valuex);
			Thread.sleep(6000);
			int addvalue = Valueb + Valued + Valuef + Valueh + Valuej + Valuel + Valuen + Valuep + Valuer + Valuex;
			System.out.println("Total of total count " + addvalue);
			if (Valueint == addvalue) {
				test.log(Status.PASS, "Number of devices displayed equals the count of the discovered devices from the sum of Types of devices ");
			} else {
				test.log(Status.FAIL, "Number of devices displayed equal not equal to the count of the discovered devices from the sum of Types of devices ");
			}
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			System.out.println(ex);
			test.log(Status.FAIL, "Unable to verify the Number of devices displayed equal to the count of the discovered devices from the sum of Types of devices " + ex);
		} catch (Exception e) {
			System.out.println(e);
			test.log(Status.FAIL, "Unable to verify the Number of devices displayed equal to the count of the discovered devices from the sum of Types of devices " + e);

		}
		//--------------------------------------------End of US-----------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3271: UI-Verify Discovery details section in details page");
		test.createNode("Test Case 3271: UI-Verify Discovery details section in details page");

		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
			Thread.sleep(3000);
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


		//Discovery details section should be displayed with Discovery ID, Created date,Start date,End date, Recursive discovery, Types of devices discovered//
		try {
			Thread.sleep(3000);
			String Discoverystr =	new ZIFAI_AlertsSettingsPage(driver).DiscoveryID.getText();
			Thread.sleep(3000);
			String Creatdatestr = new ZIFAI_AlertsSettingsPage(driver).CreatedDate.getText();
			Thread.sleep(3000);
			String Startdatestr = new ZIFAI_AlertsSettingsPage(driver).StartDate.getText();
			Thread.sleep(3000);
			String Enddatestr = new ZIFAI_AlertsSettingsPage(driver).EndDate.getText();
			Thread.sleep(3000);
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).Location.getText();
			Thread.sleep(3000);
			System.out.println("Discovery details are "+" DiscoveryID: "+Discoverystr+ " Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.log(Status.PASS, "Discovery details are"+" DiscoveryID: "+Discoverystr+" Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Validate the discovery details");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on Expand view//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Expand.click();
			Thread.sleep(3000);
			String strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Rightpanel.getAttribute("style");
			System.out.println("Right panel width: " +strvalue);
			if(strvalue.contains("100%")){
				test.log(Status.PASS, "Right panel is expanded and list of discovery is hidden");
			}
			else if(!strvalue.contains("100%")) {
				test.log(Status.FAIL, "Right panel is not expanded and list of discovery is not hidden");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on expand");
		}

		//Verifying whether collapsed button is displayed//
		try{
			Thread.sleep(3000);
			Boolean strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Collapse.isDisplayed();
			if(strvalue==true){
				test.log(Status.PASS, "Discovery details panel is expanded and the button has changed to collapse");
			}
			else if(strvalue==false) {
				test.log(Status.FAIL, "Discovery details panel is expanded and the button has not changed to collapse");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to expand button changing to collapse button during expand mode");
		}

		//Click on collapse and verify the discovery title//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Collapse.click();
			Boolean listofdisc = new ZIFAI_AlertsSettingsPage(driver).listofdiscoverytitle.isDisplayed();
			if(listofdisc==true){
				test.log(Status.PASS, "Discovery details panel is collapse and list of discoveries is visible");
			}
			else if(listofdisc==false) {
				test.log(Status.FAIL, "Discovery details panel is not collapsed and list of discoveries is not visible");
			}

			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "User is navigated to View discovery");
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
		}

		//-----------------------------------------End of US-------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3730: UI-Verify Discovery details section - Expand/Collapse discovery Summary section");
		test.createNode("Test Case 3730: UI-Verify Discovery details section - Expand/Collapse discovery Summary section");

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


		//Clicking on Expand view//
		try{
			Thread.sleep(3000);
			Boolean expdnicon = new ZIFAI_AlertsSettingsPage(driver).Expand.isDisplayed();
			if(expdnicon==true){
				test.log(Status.PASS, "Expand icon is displayed");
			}
			else if(expdnicon==false){
				test.log(Status.FAIL, "Expand icon is not displayed");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Expand.click();
			Thread.sleep(3000);
			String strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Rightpanel.getAttribute("style");
			System.out.println("Right panel width: " +strvalue);
			if(strvalue.contains("100%")){
				test.log(Status.PASS, "The summary section and device list section will be expanded");
			}
			else if(!strvalue.contains("100%")) {
				test.log(Status.FAIL, "Right panel is not expanded and list of discovery is not hidden");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on expand");
		}

		//Verifying whether collapsed button is displayed//
		try{
			Thread.sleep(3000);
			Boolean strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Collapse.isDisplayed();
			if(strvalue==true){
				test.log(Status.PASS, "Discovery details panel is expanded and the button has changed to collapse");
			}
			else if(strvalue==false) {
				test.log(Status.FAIL, "Discovery details panel is expanded and the button has not changed to collapse");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to expand button changing to collapse button during expand mode");
		}

		//Click on collapse and verify the discovery title//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Collapse.click();
			Boolean listofdisc = new ZIFAI_AlertsSettingsPage(driver).listofdiscoverytitle.isDisplayed();
			if(listofdisc==true){
				test.log(Status.PASS, "Summary section should be collapsed and arrow icon should be changed to expand");
			}
			else if(listofdisc==false) {
				test.log(Status.FAIL, "Discovery details panel is not collapsed and list of discoveries is not visible");
			}
			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "User is navigated to View discovery");
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
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

		//Clicking on Expand view//
		try{
			Thread.sleep(3000);
			Boolean expdnicon = new ZIFAI_AlertsSettingsPage(driver).Expand.isDisplayed();
			if(expdnicon==true){
				test.log(Status.PASS, "Expand icon is displayed");
			}
			else if(expdnicon==false){
				test.log(Status.FAIL, "Expand icon is not displayed");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Expand.click();
			Thread.sleep(3000);
			String strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Rightpanel.getAttribute("style");
			System.out.println("Right panel width: " +strvalue);
			if(strvalue.contains("100%")){
				test.log(Status.PASS, "Right panel is expanded and list of discovery is hidden");
			}
			else if(!strvalue.contains("100%")) {
				test.log(Status.FAIL, "Right panel is not expanded and list of discovery is not hidden");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on expand");
		}

		//Verifying whether collapsed button is displayed//
		try{
			Thread.sleep(3000);
			Boolean strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Collapse.isDisplayed();
			if(strvalue==true){
				test.log(Status.PASS, "Discovery details panel is expanded and the button has changed to collapse");
			}
			else if(strvalue==false) {
				test.log(Status.FAIL, "Discovery details panel is expanded and the button has not changed to collapse");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to expand button changing to collapse button during expand mode");
		}

		//Click on collapse and verify the discovery title//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Collapse.click();
			Boolean listofdisc = new ZIFAI_AlertsSettingsPage(driver).listofdiscoverytitle.isDisplayed();
			if(listofdisc==true){
				test.log(Status.PASS, "Discovery details panel is collapse and list of discoveries is visible");
			}
			else if(listofdisc==false) {
				test.log(Status.FAIL, "Discovery details panel is not collapsed and list of discoveries is not visible");
			}

			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "User is navigated to View discovery");
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
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

		//Clicking on Expand view//
		try{
			Thread.sleep(3000);
			Boolean expdnicon = new ZIFAI_AlertsSettingsPage(driver).Expand.isDisplayed();
			if(expdnicon==true){
				test.log(Status.PASS, "Expand icon is displayed");
			}
			else if(expdnicon==false){
				test.log(Status.FAIL, "Expand icon is not displayed");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Expand.click();
			Thread.sleep(3000);
			String strvalue= 	new ZIFAI_AlertsSettingsPage(driver).Rightpanel.getAttribute("style");
			System.out.println("Right panel width: " +strvalue);
			if(strvalue.contains("100%")){
				test.log(Status.PASS, "Right panel is expanded and list of discovery is hidden");
			}
			else if(!strvalue.contains("100%")) {
				test.log(Status.FAIL, "Right panel is not expanded and list of discovery is not hidden");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on expand");
		}

		//-----------------------------------------End of US---------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3694: Discovery Summary values for a Recursive discovery");
		test.createNode("Test Case 3694: Discovery Summary values for a Recursive discovery");
		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
			Thread.sleep(3000);
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

		//Discovery details section should be displayed with Discovery ID, Created date,Start date,End date, Recursive discovery, Types of devices discovered//
		try {
			Thread.sleep(3000);
			String Discoverystr =	new ZIFAI_AlertsSettingsPage(driver).DiscoveryID.getText();
			Thread.sleep(3000);
			String Creatdatestr = new ZIFAI_AlertsSettingsPage(driver).CreatedDate.getText();
			Thread.sleep(3000);
			String Startdatestr = new ZIFAI_AlertsSettingsPage(driver).StartDate.getText();
			Thread.sleep(3000);
			String Enddatestr = new ZIFAI_AlertsSettingsPage(driver).EndDate.getText();
			Thread.sleep(3000);
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).Location.getText();
			Thread.sleep(3000);
			System.out.println("Discovery details are "+" DiscoveryID: "+Discoverystr+ " Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.log(Status.PASS, "Discovery details are"+" DiscoveryID: "+Discoverystr+" Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Validate the discovery details");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify Recursive discovery value is mentioned as Enabled for Recursive discovery//

		try{
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).RecursiveDiscovery.getText();
			Thread.sleep(3000);
			System.out.println("Recursive Discovery status: "+Recursivestr);
			if(Recursivestr.equalsIgnoreCase("Enabled")) {
				test.log(Status.PASS, "Recursive Discovery status :"+ Recursivestr);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(!Recursivestr.equalsIgnoreCase("Enabled")){
				test.log(Status.FAIL, "Recursive Discovery status is not enabled");
		}}catch (Exception e){
			test.log(Status.PASS, "Unable to verify Recursive Discovery status");
			}

		//---------------------------------------End of US--------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3730: UI-Verify Discovery details section - Expand/Collapse discovery Summary section");
		test.createNode("Test Case 3730: UI-Verify Discovery details section - Expand/Collapse discovery Summary section");

		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).alertSettingsIcon.click();
			Thread.sleep(3000);
			String valuedisc = new ZIFAI_AlertsSettingsPage(driver).DiscoveryviewID.getText();
			Thread.sleep(3000);
			System.out.println("Recursive status: "+valuedisc);
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys(valuedisc);
			Thread.sleep(3000);
			Boolean Discoverystatus = new ZIFAI_AlertsSettingsPage(driver).Discoveryzid.isDisplayed();
			if (Discoverystatus == true) {
				new ZIFAI_AlertsSettingsPage(driver).Discoveryzid.click();
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

		//Discovery details section should be displayed with Discovery ID, Created date,Start date,End date, Recursive discovery, Types of devices discovered//
		try {
			Thread.sleep(3000);
			String Discoverystr =	new ZIFAI_AlertsSettingsPage(driver).DiscoveryID.getText();
			Thread.sleep(3000);
			String Creatdatestr = new ZIFAI_AlertsSettingsPage(driver).CreatedDate.getText();
			Thread.sleep(3000);
			String Startdatestr = new ZIFAI_AlertsSettingsPage(driver).StartDate.getText();
			Thread.sleep(3000);
			String Enddatestr = new ZIFAI_AlertsSettingsPage(driver).EndDate.getText();
			Thread.sleep(3000);
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).Location.getText();
			Thread.sleep(3000);
			System.out.println("Discovery details are "+" DiscoveryID: "+Discoverystr+ " Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.log(Status.PASS, "Discovery details are"+" DiscoveryID: "+Discoverystr+" Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Validate the discovery details");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify Recursive discovery value is mentioned as Disabled for Recursive discovery//

		try{
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).RecursiveDiscovery.getText();
			Thread.sleep(3000);
			System.out.println("Recursive Discovery status: "+Recursivestr);
			if(Recursivestr.equalsIgnoreCase("Disabled")) {
				test.log(Status.PASS, "Recursive Discovery status :"+ Recursivestr);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(!Recursivestr.equalsIgnoreCase("Enabled")){
				test.log(Status.FAIL, "Recursive Discovery status is not disabled");
			}}catch (Exception e){
			test.log(Status.PASS, "Unable to verify Recursive Discovery status");
		}
		//--------------------------------------End of US--------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3696: Discovery Summary values for a discovery with No devices found");
		test.createNode("Test Case 3696: Discovery Summary values for a discovery with No devices found");

		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).alertSettingsIcon.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("ZIFDICV736");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryzid.click();
			Thread.sleep(5000);
			Boolean Discoverystatus = new ZIFAI_AlertsSettingsPage(driver).Nodevicelist.isDisplayed();
			if (Discoverystatus == true) {
				Thread.sleep(3000);
				test.log(Status.PASS, "No Device found is displayed and validated");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Discoverystatus == false) {
				test.log(Status.FAIL, "Unable to validate no device found");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to load no device list");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Discovery details section should be displayed with Discovery ID, Created date,Start date,End date, Recursive discovery, Types of devices discovered//
		try {
			Thread.sleep(3000);
			String Discoverystr =	new ZIFAI_AlertsSettingsPage(driver).DiscoveryID.getText();
			Thread.sleep(3000);
			String Creatdatestr = new ZIFAI_AlertsSettingsPage(driver).CreatedDate.getText();
			Thread.sleep(3000);
			String Startdatestr = new ZIFAI_AlertsSettingsPage(driver).StartDate.getText();
			Thread.sleep(3000);
			String Enddatestr = new ZIFAI_AlertsSettingsPage(driver).EndDate.getText();
			Thread.sleep(3000);
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).Location.getText();
			Thread.sleep(3000);
			System.out.println("Discovery details are "+" DiscoveryID: "+Discoverystr+ " Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.log(Status.PASS, "Discovery details are"+" DiscoveryID: "+Discoverystr+" Created Date: "+Creatdatestr+" Start Date: "+Startdatestr+" End Date: "+Enddatestr+" Recursive: " +Recursivestr+" ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Validate the discovery details");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//---------------------------------------------End of US--------------------------------------------------------//


	}
	}
