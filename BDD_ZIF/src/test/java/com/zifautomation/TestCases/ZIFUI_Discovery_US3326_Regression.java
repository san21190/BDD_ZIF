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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Discovery_US3326_Regression extends Base {

	//	PropertiesFileReader obj = new PropertiesFileReader();
	//	Properties properties = null;
	//	CommonMethods cm = null;


	@Test
	public void ZIFUI_Discovery_US3326_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("User Story 3326: ZIF Discovery - Topology Device Interface List");
		test.createNode("User Story 3326: ZIF Discovery - Topology Device Interface List");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


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
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("ZIFDICV829");
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
		//---------------------------------------End of US---------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3781: Verify User is able to navigate to Interface List in Collapsed mode");
		test.createNode("Test Case 3781: Verify User is able to navigate to Interface List in Collapsed mode");




		//Database Validation for Threshold Dynamic/ Status in Network Optimization
		String url = properties.getProperty("db.url");
		String db = properties.getProperty("db.name");

		//Validate total number of records for Dynamic in Threshold//
		String value1 = "dicv_id";
		String value2 = "ZIFDICV829";
		String value3 = "if_index";
		String value4 = new ZIFAI_AlertsSettingsPage(driver).Interfacelinkvalue.getText();
		MongoQueryManager mongoQueryManager = new MongoQueryManager(url, db);
		Map<String, String> fields = new HashMap<String, String>();
		fields.put(value1, value2);
		fields.put(value3, value4);
		FindIterable<Document> documents = mongoQueryManager.getDocumentsWithFields("discovery_interface_details", fields);
		for (Document doc : documents) {
			if(!doc.isEmpty()){
				test.log(Status.PASS, "UI discovery interface record is matching with Mongo Database");
				System.out.println("Value is present in the particular collection" +doc);
			}
			else if (doc.isEmpty()){
				test.log(Status.FAIL, "UI discovery interface record is not matching with Mongo Database");
				System.out.println("Value is not present in the particular collection" +doc);
			}

		}
		//Getting the value from interface list and validating the size in collapse mode//
		try{

			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			int sizet = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String s=Integer.toString(sizet);
			Thread.sleep(6000);
		String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces","").replace("(","").replace(")","").trim();
		System.out.println("Value in overall count "+sizet+".value of the size "+sizempre);
		if(s.contains(sizempre)){
			System.out.println("The value is matching with overall and list");
		}else {
			System.out.println("The value is not matching with overall and list");
		}
		Thread.sleep(3000);
		new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
		Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Backtodiscoverylist.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode"+e);
		}
		//-------------------------------------------End of US---------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3782: Verify User is able to navigate to Interface List in expanded mode");
		test.createNode("Test Case 3782: Verify User is able to navigate to Interface List in expanded mode");


		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("ZIFDICV829");
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


		//Database Validation for Threshold Dynamic/ Status in Network Optimization
		String urlt = properties.getProperty("db.url");
		String dbt = properties.getProperty("db.name");

		//Validate total number of records for Dynamic in Threshold//
		String value1t = "dicv_id";
		String value2t = "ZIFDICV829";
		String value3t = "if_index";
		String value4t = new ZIFAI_AlertsSettingsPage(driver).Interfacelinkvalue.getText();
		MongoQueryManager mongoQueryManagert = new MongoQueryManager(urlt, dbt);
		Map<String, String> fieldst = new HashMap<String, String>();
		fieldst.put(value1t, value2t);
		fieldst.put(value3t, value4t);
		FindIterable<Document> documentst = mongoQueryManagert.getDocumentsWithFields("discovery_interface_details", fields);
		for (Document doc : documentst) {
			if(!doc.isEmpty()){
				test.log(Status.PASS, "UI discovery interface record is matching with Mongo Database");
				System.out.println("Value is present in the particular collection" +doc);
			}
			else if (doc.isEmpty()){
				test.log(Status.FAIL, "UI discovery interface record is not matching with Mongo Database");
				System.out.println("Value is not present in the particular collection" +doc);
			}

		}
		//Getting the value from interface list and validating the size in collapse mode//
		try{

			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			int sizet = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String s=Integer.toString(sizet);
			Thread.sleep(6000);
			String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces","").replace("(","").replace(")","").trim();
			System.out.println("Value in overall count "+sizet+".value of the size "+sizempre);
			if(s.contains(sizempre)){
				System.out.println("The value is matching with overall and list");
			}else {
				System.out.println("The value is not matching with overall and list");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode");
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
			new ZIFAI_AlertsSettingsPage(driver).Backtodiscoverylist.click();
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
		}
		//-----------------------------------------End of US--------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3783: Verify Interface UI when expanded");
		test.createNode("Test Case 3783: Verify Interface UI when expanded");


		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("ZIFDICV829");
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


		//Getting the value from interface list and validating the size in collapse mode//
		try{

			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			int sizet = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String s=Integer.toString(sizet);
			Thread.sleep(6000);
			String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces","").replace("(","").replace(")","").trim();
			System.out.println("Value in overall count "+sizet+".value of the size "+sizempre);
			if(s.contains(sizempre)){
				System.out.println("The value is matching with overall and list");
			}else {
				System.out.println("The value is not matching with overall and list");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode");
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
			new ZIFAI_AlertsSettingsPage(driver).Backtodiscoverylist.click();
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
		}
		//--------------------------------------------End of US-------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3784: Verify Interface List values with Database in Expanded mode");
		test.createNode("Test Case 3784: Verify Interface List values with Database in Expanded mode");


		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("ZIFDICV829");
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


		//Database Validation for Threshold Dynamic/ Status in Network Optimization
		String urltu = properties.getProperty("db.url");
		String dbtu = properties.getProperty("db.name");

		//Validate total number of records for Dynamic in Threshold//
		String value1tu = "dicv_id";
		String value2tu = "ZIFDICV829";
		String value3tu = "if_index";
		String value4tu = new ZIFAI_AlertsSettingsPage(driver).Interfacelinkvalue.getText();
		MongoQueryManager mongoQueryManagertu = new MongoQueryManager(urltu, dbtu);
		Map<String, String> fieldstu = new HashMap<String, String>();
		fieldstu.put(value1tu, value2tu);
		fieldstu.put(value3tu, value4tu);
		FindIterable<Document> documentstu = mongoQueryManagertu.getDocumentsWithFields("discovery_interface_details", fields);
		for (Document doc : documentstu) {
			if(!doc.isEmpty()){
				test.log(Status.PASS, "UI discovery interface record is matching with Mongo Database");
				System.out.println("Value is present in the particular collection" +doc);
			}
			else if (doc.isEmpty()){
				test.log(Status.FAIL, "UI discovery interface record is not matching with Mongo Database");
				System.out.println("Value is not present in the particular collection" +doc);
			}

		}
		//Getting the value from interface list and validating the size in collapse mode//
		try{

			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			int sizet = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String s=Integer.toString(sizet);
			Thread.sleep(6000);
			String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces","").replace("(","").replace(")","").trim();
			System.out.println("Value in overall count "+sizet+".value of the size "+sizempre);
			if(s.contains(sizempre)){
				System.out.println("The value is matching with overall and list");
			}else {
				System.out.println("The value is not matching with overall and list");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode");
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
			new ZIFAI_AlertsSettingsPage(driver).Backtodiscoverylist.click();
			Thread.sleep(3000);
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
		}
		//---------------------------------------End of US-----------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3787: Verify Interface List values with Database in Collapsed mode");
		test.createNode("Test Case 3787: Verify Interface List values with Database in Collapsed mode");

		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("ZIFDICV829");
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


		//Database Validation for Threshold Dynamic/ Status in Network Optimization
		String urlq = properties.getProperty("db.url");
		String dbq = properties.getProperty("db.name");

		//Validate total number of records for Dynamic in Threshold//
		String value1q = "dicv_id";
		String value2q = "ZIFDICV829";
		String value3q = "if_index";
		String value4q = new ZIFAI_AlertsSettingsPage(driver).Interfacelinkvalue.getText();
		MongoQueryManager mongoQueryManagerq = new MongoQueryManager(urlq, dbq);
		Map<String, String> fieldsq = new HashMap<String, String>();
		fieldsq.put(value1q, value2q);
		fieldsq.put(value3q, value4q);
		FindIterable<Document> documentsq = mongoQueryManagerq.getDocumentsWithFields("discovery_interface_details", fields);
		for (Document doc : documentsq) {
			if(!doc.isEmpty()){
				test.log(Status.PASS, "UI discovery interface record is matching with Mongo Database in collapse mode");
				System.out.println("Value is present in the particular collection" +doc);
			}
			else if (doc.isEmpty()){
				test.log(Status.FAIL, "UI discovery interface record is not matching with Mongo Database in collapse mode");
				System.out.println("Value is not present in the particular collection" +doc);
			}

		}
		//Getting the value from interface list and validating the size in collapse mode//
		try{

			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			int sizet = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String s=Integer.toString(sizet);
			Thread.sleep(6000);
			String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces","").replace("(","").replace(")","").trim();
			System.out.println("Value in overall count "+sizet+".value of the size "+sizempre);
			if(s.contains(sizempre)){
				System.out.println("The value is matching with overall and list");
			}else {
				System.out.println("The value is not matching with overall and list");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Backtodiscoverylist.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode"+e);
		}
		//----------------------------------------------End of US-----------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3788: Verify Interface List values with Database in Expanded mode");
		test.createNode("Test Case 3788: Verify Interface List values with Database in Expanded mode");


		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("ZIFDICV829");
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


		//Database Validation for Threshold Dynamic/ Status in Network Optimization
		String urltq = properties.getProperty("db.url");
		String dbtq = properties.getProperty("db.name");

		//Validate total number of records for Dynamic in Threshold//
		String value1tq = "dicv_id";
		String value2tq = "ZIFDICV829";
		String value3tq = "if_index";
		String value4tq = new ZIFAI_AlertsSettingsPage(driver).Interfacelinkvalue.getText();
		MongoQueryManager mongoQueryManagertq = new MongoQueryManager(urltq, dbtq);
		Map<String, String> fieldstq = new HashMap<String, String>();
		fieldstq.put(value1tq, value2tq);
		fieldstq.put(value3tq, value4tq);
		FindIterable<Document> documentstq = mongoQueryManagertq.getDocumentsWithFields("discovery_interface_details", fields);
		for (Document doc : documentstq) {
			if(!doc.isEmpty()){
				test.log(Status.PASS, "UI discovery interface record is matching with Mongo Database");
				System.out.println("Value is present in the particular collection" +doc);
			}
			else if (doc.isEmpty()){
				test.log(Status.FAIL, "UI discovery interface record is not matching with Mongo Database");
				System.out.println("Value is not present in the particular collection" +doc);
			}

		}
		//Getting the value from interface list and validating the size in collapse mode//
		try{

			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			int sizet = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String s=Integer.toString(sizet);
			Thread.sleep(6000);
			String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces","").replace("(","").replace(")","").trim();
			System.out.println("Value in overall count "+sizet+".value of the size "+sizempre);
			if(s.contains(sizempre)){
				System.out.println("The value is matching with overall and list");
			}else {
				System.out.println("The value is not matching with overall and list");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode");
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
			new ZIFAI_AlertsSettingsPage(driver).Backtodiscoverylist.click();
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
		}

		//-----------------------------------------End of US---------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 3790: Verify Interface UI when collapsed");
		test.createNode("Test Case 3790: Verify Interface UI when collapsed");


		//Clicking on the setting icon and filtering discovery id and clicking on it//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys("ZIFDICV829");
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


		//Getting the value from interface list and validating the size in collapse mode//
		try{

			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			int sizet = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String s=Integer.toString(sizet);
			Thread.sleep(6000);
			String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces","").replace("(","").replace(")","").trim();
			System.out.println("Value in overall count "+sizet+".value of the size "+sizempre);
			if(s.contains(sizempre)){
				System.out.println("The value is matching with overall and list");
			}else {
				System.out.println("The value is not matching with overall and list");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode");
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
			new ZIFAI_AlertsSettingsPage(driver).Backtodiscoverylist.click();
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify device list LHS after clicking on LHS");
		}
		//-------------------------------------------End of US--------------------------------------------------------//

	}
	}

