package com.zifautomation.TestCases;
import com.aventstack.extentreports.Status;
import com.mongodb.client.FindIterable;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.*;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.MongoQueryManager;
import com.zifautomation.Utility.PropertiesFileReader;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;




public class ZIFUI_AnP_US3324_Regression extends Base {

	//	PropertiesFileReader obj = new PropertiesFileReader();
//	Properties properties = null;
//	CommonMethods cm = null;


	@Test
	public void ZIFUI_AnP_US3324_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("User Story 3324: ZIF Discovery - Topology Device List");
		test.createNode("User Story 3324: ZIF Discovery - Topology Device List");
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

		//--------------------------------End of US------------------------------------------------//

		//Report Initialization
		test = extent.createTest("Test Case 3270: UI-Verify Device details List");
		test.createNode("Test Case 3270: UI-Verify Device details List");


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

		//Verify the Device name list has been listed in discovery page//
		try {
			By mySelector = By.xpath("//div[contains(@class,'dev-link')]//..//span[contains(@class,'ng-star-inserted')]");
			List<WebElement> myElements = driver.findElements(mySelector);
			for (WebElement e : myElements) {
				String valueinfo = e.getText();
				System.out.println(e.getText());
				if (!valueinfo.isEmpty()) {
					test.log(Status.PASS, "Device name" + valueinfo + " is displayed");
				} else if (valueinfo.isEmpty()) {
					test.log(Status.FAIL, "Device name" + valueinfo + " is not displayed");
				} }
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify the device names from the list");
		}

		//Validating the columns with device list//
		try{
		Boolean devstatus = 	new ZIFAI_AlertsSettingsPage(driver).devicename.isDisplayed();
		if(devstatus==true){
			test.log(Status.PASS, "Device name column is displayed");
		}
		else if(devstatus==false){
			test.log(Status.FAIL, "Device name column is not displayed");
		}
			Boolean devtypestatus = 	new ZIFAI_AlertsSettingsPage(driver).devicetype.isDisplayed();
			if(devtypestatus==true){
				test.log(Status.PASS, "Device type column is displayed");
			}
			else if(devtypestatus==false){
				test.log(Status.FAIL, "Device type column is not displayed");
			}
			Boolean devceipaddr = 	new ZIFAI_AlertsSettingsPage(driver).deviceipaddr.isDisplayed();
			if(devceipaddr==true){
				test.log(Status.PASS, "Device IP address column is displayed");
			}
			else if(devceipaddr==false){
				test.log(Status.FAIL, "Device IP address column is not displayed");
			}
			Boolean demanname = 	new ZIFAI_AlertsSettingsPage(driver).devicemanfname.isDisplayed();
			if(demanname==true){
				test.log(Status.PASS, "Device manufacturer column is displayed");
			}
			else if(demanname==false){
				test.log(Status.FAIL, "Device manufacturer column is not displayed");
			}
			Boolean devmodlestatus = 	new ZIFAI_AlertsSettingsPage(driver).devicemodelname.isDisplayed();
			if(devmodlestatus==true){
				test.log(Status.PASS, "Device model column is displayed");
			}
			else if(devmodlestatus==false){
				test.log(Status.FAIL, "Device model column is not displayed");
			}
			Boolean devintrfce = 	new ZIFAI_AlertsSettingsPage(driver).deviceinterface.isDisplayed();
			if(devintrfce==true){
				test.log(Status.PASS, "Device interface column is displayed");
			}
			else if(devintrfce==false){
				test.log(Status.FAIL, "Device interface column is not displayed");
			}
			Boolean devdescp = 	new ZIFAI_AlertsSettingsPage(driver).devicedescription.isDisplayed();
			if(devdescp==true){
				test.log(Status.PASS, "Device description column is displayed");
			}
			else if(devdescp==false){
				test.log(Status.FAIL, "Device description column is not displayed");
			}
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", new ZIFAI_AlertsSettingsPage(driver).devicesubtype);
			Thread.sleep(3000);
			Boolean devstatusupd = 	new ZIFAI_AlertsSettingsPage(driver).devicestatus.isDisplayed();
			if(devstatusupd==true){
				test.log(Status.PASS, "Device status column is displayed");
			}
			else if(devstatusupd==false){
				test.log(Status.FAIL, "Device status column is not displayed");
			}
			Boolean devpopmethd = 	new ZIFAI_AlertsSettingsPage(driver).devicepopmethod.isDisplayed();
			if(devpopmethd==true){
				test.log(Status.PASS, "Device populate column is displayed");
			}
			else if(devpopmethd==false){
				test.log(Status.FAIL, "Device populate column is not displayed");
			}
			Boolean devmacaddr = 	new ZIFAI_AlertsSettingsPage(driver).deviceprimarymacaddr.isDisplayed();
			if(devmacaddr==true){
				test.log(Status.PASS, "Device mac address column is displayed");
			}
			else if(devmacaddr==false){
				test.log(Status.FAIL, "Device mac address column is not displayed");
			}
			Boolean devsubtype = 	new ZIFAI_AlertsSettingsPage(driver).devicesubtype.isDisplayed();
			if(devsubtype==true){
				test.log(Status.PASS, "Device sub type column is displayed");
			}
			else if(devsubtype==false){
				test.log(Status.FAIL, "Device sub type column is not displayed");
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the Device listed columns");
		}


		//Database Validation for Device name//
		String url = properties.getProperty("db.url");
		String db = properties.getProperty("db.name");
		MongoQueryManager mongoQueryManager = new MongoQueryManager(url, db);
		Map<String, String> fields = new HashMap<String, String>();
		fields.put("dicv_id", "GTMDICV500");
		FindIterable<Document> documents = mongoQueryManager.getDocumentsWithFields("discovery_dev_details", fields);
		for (Document doc : documents) {
			//access documents e.g. doc.get()
			doc.get("dicv_id").toString();
			if (documents == null) {
				test.log(Status.FAIL, "No data records found for Dynamic");
			} else if (documents != null) {
				test.log(Status.PASS, "data records found for" + doc.get("dicv_id").toString());

			}

		}
		//---------------------------------------End of US-------------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3740: UI-Verify Device details List- Display of status and Interfaces");
		test.createNode("Test Case 3740: UI-Verify Device details List- Display of status and Interfaces");

		//Closing the device list page and again entering the discovery id and navigating to details page//
		try {
			Thread.sleep(3000);
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

		//Verify the Device name list has been listed in discovery page//
		try {
			Thread.sleep(3000);
			By mySelector = By.xpath("//div[contains(@class,'dev-link')]//..//span[contains(@class,'ng-star-inserted')]");
			List<WebElement> myElements = driver.findElements(mySelector);
			for (WebElement e : myElements) {
				String valueinfo = e.getText();
				System.out.println(e.getText());
				if (!valueinfo.isEmpty()) {
					test.log(Status.PASS, "Device name" + valueinfo + " is displayed after reopening the device detail page");
				} else if (valueinfo.isEmpty()) {
					test.log(Status.FAIL, "Device name" + valueinfo + " is not displayed after reopening the device detail page");
				} }
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify the device names from the list after reopening the device detail page");
		}

		//Color code for Active status : #36ad49 //
		//Verifying the color code with active status//
		try {
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", new ZIFAI_AlertsSettingsPage(driver).devicestatus);
			Thread.sleep(3000);
			String color = driver.findElement(By.xpath("(//div[contains(@class,'device-active')])[1]")).getCssValue("color");
			String hex = Color.fromString(color).asHex();
			System.out.println(hex);
			if(hex.equals("#36ad49")){
				test.log(Status.PASS, "Color code matches with Active status");
			}
			else if(!hex.equals("#36ad49")){
					test.log(Status.FAIL, "Color code does not matches with Active status");
			}
		} catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the Active status color code");
		}


		//Interfaces should be displayed as a link for devices with blue underlined
		//color code for interface:#4e4ab7
		try {
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", new ZIFAI_AlertsSettingsPage(driver).deviceinterface);
			Thread.sleep(3000);
			String color = driver.findElement(By.xpath("(//div[contains(@class,'dev-interface')])[1]")).getCssValue("color");
			String hex = Color.fromString(color).asHex();
			System.out.println(hex);
			String decoration = driver.findElement(By.xpath("(//div[contains(@class,'dev-interface')])[1]")).getCssValue("text-decoration");
			System.out.println(decoration);
			if(hex.equals("#4e4ab7")){
				test.log(Status.PASS, "Color code matches with Interface link");
			}
			else if(!hex.equals("#4e4ab7")){
				test.log(Status.FAIL, "Color code does not matches with Interface link");
			}

			if(decoration.contains("underline")){
				test.log(Status.PASS, "Underline is verified in the link interface and also the click using hyperlink");
			}
			else if(!decoration.contains("underline")){
				test.log(Status.FAIL, "Underline is not verified in the link interface and also the click using hyperlink");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			Boolean landing = new ZIFAI_AlertsSettingsPage(driver).Interfacelinklanding.isDisplayed();
			if(landing==true){
				test.log(Status.PASS, "Interface link is clicked and verified");
			}
			else if(landing==false){
				test.log(Status.FAIL, "Interface link cannot be clicked/verified");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
			Thread.sleep(3000);
		} catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the Interface color and underline style");
		}

		//---------------------------------------End of US---------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3736: Verify Device List in Collapsed View");
		test.createNode("Test Case 3736: Verify Device List in Collapsed View");

		//Closing the device list page and again entering the discovery id and navigating to details page//
		try {
			Thread.sleep(3000);
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
				test.log(Status.PASS, "Clicked on setting icon for loading discovery page for Collapsed View");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Discoverystatus == false) {
				test.log(Status.FAIL, "Unable to load discovery page by clicking on setting icon for Collapsed View");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to load discovery page for Collapsed View");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on Expand and Collapsed view//

		try{
			new ZIFAI_AlertsSettingsPage(driver).Expand.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Collapse.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Changed from expand to collapse mode");
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to Change from expand to collapse mode");
		}

		//Verify device list is updated with the total number of devices//
		try{
			Thread.sleep(3000);
			String countstr =new ZIFAI_AlertsSettingsPage(driver).Devicecount.getText();

			System.out.println("Total device count is " +countstr);
			if(!countstr.isEmpty()){
				test.log(Status.PASS, "Total device count is " +countstr);
			}
			else{
				test.log(Status.FAIL, "Unable to fetch the total device count");
			}
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.PASS, "Unable to verify the device count "+e);
		}

		//Device list should update the devices when  scroll down//
		try {
			Thread.sleep(3000);
			List<WebElement> casestatus = driver.findElements(By.xpath("//div[contains(@class,'dev-link')]"));
			List<WebElement> case_status = driver.findElements(By.xpath("//div[contains(@class,'dev-link')]"));
			int i;
			for ( i= 0; i<casestatus.size(); i=i+1) {
				System.out.println(casestatus.size());
				Actions action = new Actions(driver);
				Thread.sleep(2000);
				action.moveToElement(case_status.get(i)).perform();
				//WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
				String Casestatustooltip = case_status.get(i).getText();
				System.out.println("Casestatustooltip:" + Casestatustooltip);
				if (!Casestatustooltip.isEmpty()) {
					test.log(Status.PASS, "Device list verified and scrolled : " +Casestatustooltip);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} }
		} catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Unable to verify Device List");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, "End of Verification for Device List");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------End of US-----------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3719: Verify Device List in Expanded View");
		test.createNode("Test Case 3719: Verify Device List in Expanded View");

		//Closing the device list page and again entering the discovery id and navigating to details page//
		try {
			Thread.sleep(3000);
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
				test.log(Status.PASS, "Clicked on setting icon for loading discovery page for Expanded View");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Discoverystatus == false) {
				test.log(Status.FAIL, "Unable to load discovery page by clicking on setting icon for Expanded View");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to load discovery page for Expanded View");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on Expand view//

		try{
			new ZIFAI_AlertsSettingsPage(driver).Expand.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clicked on expand button");
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to click on expand button");
		}

		//Verify device list is updated with the total number of devices//
		try{
			Thread.sleep(3000);
			String countstr =new ZIFAI_AlertsSettingsPage(driver).Devicecount.getText();

			System.out.println("Total device count is " +countstr);
			if(!countstr.isEmpty()){
				test.log(Status.PASS, "Total device count is " +countstr + "in expand mode");
			}
			else{
				test.log(Status.FAIL, "Unable to fetch the total device count in expand mode");
			}
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.PASS, "Unable to verify the device count in expand mode "+e);
		}

		//Device list should update the devices when scroll down//
		try {
			Thread.sleep(3000);
			List<WebElement> casestatus = driver.findElements(By.xpath("//div[contains(@class,'dev-link')]"));
			List<WebElement> case_status = driver.findElements(By.xpath("//div[contains(@class,'dev-link')]"));
			int i;
			for ( i= 0; i<casestatus.size(); i=i+1) {
				System.out.println(casestatus.size());
				Actions action = new Actions(driver);
				Thread.sleep(2000);
				action.moveToElement(case_status.get(i)).perform();
				//WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
				String Casestatustooltip = case_status.get(i).getText();
				System.out.println("Casestatustooltip:" + Casestatustooltip);
				if (!Casestatustooltip.isEmpty()) {
					test.log(Status.PASS, "Device list verified and scrolled in expand mode : " +Casestatustooltip);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} }
		} catch (Error e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, " Unable to verify Device List in expand mode ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, " End of Verification for Device List in expand mode ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
	//--------------------------------------------End of US------------------------------------------//

	}
	}
