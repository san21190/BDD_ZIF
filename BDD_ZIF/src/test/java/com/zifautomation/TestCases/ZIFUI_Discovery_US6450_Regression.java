package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.mongodb.client.FindIterable;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.MongoQueryManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.bson.Document;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Discovery_US6450_Regression extends Base {


	@Test
	public void ZIFUI_Discovery_US6450_Regression() throws IOException, InterruptedException, SQLException, ClassNotFoundException {

		//Report Initialization
		test = extent.createTest("User Story 6450: Create Discovery - Server (SSH)");
		test.createNode("User Story 6450: Create Discovery - Server (SSH)");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Properties prop = new Properties();
		FileOutputStream fis = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\Uidata.properties");


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

		//Clicking on Configuration setting page//
		try {
			new ZIFAI_AlertsSettingsPage(driver).alertSettingsIcon.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SSH add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SSH add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clearing the SSH which is created already//
		try {
			new ZIFAI_AlertsSettingsPage(driver).DeleteSSHconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared all the SSH configuration which is created by automation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear the SSH configuration");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}


		//------------------------------------------End of US--------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 7793: Verify user is able to discover CentOs device with Individual IP and Non Recursive Discovery");
		test.createNode("Test Case 7793: Verify user is able to discover CentOs device with Individual IP and Non Recursive Discovery");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SSH add icon for Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SSH add icon for Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Entering details with SSH using Add new Popup//
		//Selecting Values from SSH location dropdown and Type dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHRangestart.sendKeys("172.31.28.7");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHUsername.sendKeys("azureuser");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHPassword.sendKeys("Neptune@!8520");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SSHname.sendKeys("AutomodeSSH23RT");
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SSHPasswordvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SSH community string value for IP Type as Default " + passrd);
			if (passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SSH community string value is masked for Type as Individual IP");
			} else {
				test.log(Status.FAIL, "SSH community string value is not masked for Type as Individual IP");
			}

			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);

			Boolean statdpl = new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if (statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration Add new is clicked for verified another scenario");
			} else if (!statdpl) {
				test.log(Status.FAIL, "Configuration Add new is not clicked for validate another scenario");
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to click on add new  Configure SSH with Subnet Mask and Type as Individual IP " + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		// Validating through Postgres Database along with UI data//
		Thread.sleep(3000);
		// Object of Connection from the Database
		Connection conn = null;
		// Object of Statement. It is used to create a Statement to execute the query
		Statement stmt = null;
		//Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
		ResultSet resultSet = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//Class.forName("com.mysql.jdbc.Driver");
		// Open a connection
		conn = DriverManager.getConnection("jdbc:postgresql://172.31.28.8:5432/zif", "zif", "ZIF@@123");
		// Execute a query
		try {
			stmt = conn.createStatement();
			String queryq = "*";
			String query = "Select" + queryq + "from dicv_ssh_settings";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String namecreated = rs.getString("credential_name");

				if (namecreated.equalsIgnoreCase("AutomodeSSH23RT")) {
					System.out.println("The name which is created in SSH: " + namecreated);
					test.log(Status.PASS, "The name in the UI and Database matches: " + namecreated);
				} else {
					System.out.println("The database value "+namecreated);
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		//Clicking on Create Discovery//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Createnewdiscovery.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed configuration and created new discovery");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to close and create new discovery");
		}

		//Validating the create discovery name with invalid input//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryname.sendKeys("Automode&12%");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			String invalidtext = new ZIFAI_AlertsSettingsPage(driver).Invaliddiscoverynamealert.getText();
			if (invalidtext.contains("Enter Valid Discovery Name")) {
				test.log(Status.PASS, "Invalid message has been displayed when entering invalid discovery name");
			} else {
				test.log(Status.FAIL, "Invalid message is not displayed entering invalid discovery name");
			}
		} catch (Exception e) {

		}


		//Validating the IP range start with invalid input//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryname.clear();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryname.sendKeys("AutomodeSSH");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).IPrangestart.sendKeys("11.10.76.90.90");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Selectrangedropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			String invalidip = new ZIFAI_AlertsSettingsPage(driver).Invalidiprangestart.getText();
			if (invalidip.contains("Enter valid IP")) {
				test.log(Status.PASS, "Invalid message has been displayed when entering invalid IP value");
			} else {
				test.log(Status.FAIL, "Invalid message has not been displayed when entering invalid IP value");
			}
		} catch (Exception e) {

		}

		//Selecting the value from Device types dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Devicetypestrigger.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetypecheckbox.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetypetextbox.sendKeys("Server");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetypecheckbox.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Server has been selected from the device list for non recursive discovery");
		} catch (Exception e) {
			test.log(Status.FAIL, "Server has not been selected from the device list for non recursive discovery");
		}

		//Clicking on Create Discovery Button//
		try {
			new ZIFAI_AlertsSettingsPage(driver).IPrangestart.clear();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).IPrangestart.sendKeys("172.31.28.7");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Creatediscoverybutton.click();
			Thread.sleep(40000);
			String discvvaluet = new ZIFAI_AlertsSettingsPage(driver).Discoverysuccessmessage.getText().replace("Discovery", "").replace("created", "").replace("successfully", "").replace("-", "").trim();
			Thread.sleep(6000);
			prop.setProperty("Discovery.Namea", (discvvaluet));
			prop.store(fis, null);
			System.out.println("Newly created discovery " + discvvaluet);
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(6000);
			test.log(Status.PASS, "Successfully created Discovery " + discvvaluet);
		} catch (Exception e) {
			test.log(Status.FAIL, "Server has not been selected from the device list for non recursive discovery");
		}

		//Validating the discovery which is created//
		try {
			Thread.sleep(3000);
			String Discoveryidt = prop.getProperty("Discovery.Namea");
			Thread.sleep(6000);
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys(Discoveryidt);
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryzid.click();
			Thread.sleep(6000);
			test.log(Status.PASS, "Entered the discovery id which is created through automation");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to enter the discovery which is created through automation");
		}


		//Database Validation for Threshold Dynamic/ Status in Network Optimization
		String urltq = properties.getProperty("db.url");
		String dbtq = properties.getProperty("db.name");
		String Discoveryidt = prop.getProperty("Discovery.Namea");
		//Validate total number of records for Dynamic in Threshold//
		String value1tq = "dicv_id";
		String value2tq = Discoveryidt;
		String value3tq = "if_index";
		Thread.sleep(3000);
		new ZIFAI_AlertsSettingsPage(driver).Discoveryfullview.click();
		Thread.sleep(3000);
		new ZIFAI_AlertsSettingsPage(driver).Discoveryfullview.click();
		Thread.sleep(3000);
		String value4tq = new ZIFAI_AlertsSettingsPage(driver).Interfacelinkvalue.getText();
		MongoQueryManager mongoQueryManagertq = new MongoQueryManager(urltq, dbtq);
		Map<String, String> fieldstq = new HashMap<String, String>();
		fieldstq.put(value1tq, value2tq);
		fieldstq.put(value3tq, value4tq);
		FindIterable<Document> documentstq = mongoQueryManagertq.getDocumentsWithFields("discovery_interface_details", fieldstq);
		for (Document doc : documentstq) {
			if (!doc.isEmpty()) {
				test.log(Status.PASS, "UI discovery interface record is matching with Mongo Database");
				System.out.println("Value is present in the particular collection" + doc);
			} else if (doc.isEmpty()) {
				test.log(Status.FAIL, "UI discovery interface record is not matching with Mongo Database");
				System.out.println("Value is not present in the particular collection" + doc);
			}

		}
		//Getting the value from interface list and validating the size in collapse mode//
		try {

			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			int sizet = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String s = Integer.toString(sizet);
			Thread.sleep(3000);
			String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces", "").replace("(", "").replace(")", "").trim();
			System.out.println("Value in overall count " + sizet + ".value of the size " + sizempre);
			if (s.contains(sizempre)) {
				System.out.println("The value is matching with overall and list");
			} else {
				System.out.println("The value is not matching with overall and list");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode");
		}

		//Discovery details section should be displayed with Discovery ID, Created date,Start date,End date, Recursive discovery, Types of devices discovered//
		try {
			Thread.sleep(3000);
			String Discoverystr = new ZIFAI_AlertsSettingsPage(driver).DiscoveryID.getText();
			Thread.sleep(3000);
			String Creatdatestr = new ZIFAI_AlertsSettingsPage(driver).CreatedDate.getText();
			Thread.sleep(3000);
			String Startdatestr = new ZIFAI_AlertsSettingsPage(driver).StartDate.getText();
			Thread.sleep(3000);
			String Enddatestr = new ZIFAI_AlertsSettingsPage(driver).EndDate.getText();
			Thread.sleep(3000);
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).Location.getText();
			Thread.sleep(3000);
			System.out.println("Discovery details are " + " DiscoveryID: " + Discoverystr + " Created Date: " + Creatdatestr + " Start Date: " + Startdatestr + " End Date: " + Enddatestr + " Recursive: " + Recursivestr + " ");
			test.log(Status.PASS, "Discovery details are" + " DiscoveryID: " + Discoverystr + " Created Date: " + Creatdatestr + " Start Date: " + Startdatestr + " End Date: " + Enddatestr + " Recursive: " + Recursivestr + " ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Validate the discovery details");

		}

		//Discovery input information//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryinputdetails.click();
			Thread.sleep(3000);
			String inputdetails = new ZIFAI_AlertsSettingsPage(driver).Discoveryinputinfo.getText();
			System.out.println(inputdetails);
			if (inputdetails.contains("172.31.28.5")||inputdetails.contains("172.31.28.7")) {
				test.log(Status.PASS, "IP range matching with the input details");
			} else {
				test.log(Status.FAIL, "IP range not matching with the input details");
			}
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to validate the input details");
		}


		//Discovery input information//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Recursivediscoveryinfo.click();
			Thread.sleep(3000);
			String inputdetails = new ZIFAI_AlertsSettingsPage(driver).Devicetypeidentification.getText();
			System.out.println(inputdetails);
			if (inputdetails.contains("Server")) {
				test.log(Status.PASS, "Configured Server is displayed");
			} else {
				test.log(Status.FAIL, "Configured Server is not displayed");
			}
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to validate the recursive details");
		}
		//-----------------------------------------------End of US-------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 7792: Verify user is able to discover CentOs device with Individual IP and Recursive Discovery");
		test.createNode("Test Case 7792: Verify user is able to discover CentOs device with Individual IP and Recursive Discovery");

		//Clicking on Configuration setting page//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
			Thread.sleep(4000);
			new ZIFAI_AlertsSettingsPage(driver).alertSettingsIcon.click();
			Thread.sleep(4000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(4000);
			new ZIFAI_AlertsSettingsPage(driver).SSHaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SSH add icon for Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SSH add icon for Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Entering details with SSH using Add new Popup//
		//Selecting Values from SSH location dropdown and Type dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHRangestart.sendKeys("172.31.28.7");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHUsername.sendKeys("azureuser");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHPassword.sendKeys("Neptune@!8520");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SSHname.sendKeys("AutomodeSSH33QT");
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SSHPasswordvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SSH community string value for IP Type as Default " + passrd);
			if (passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SSH community string value is masked for Type as Individual IP");
			} else {
				test.log(Status.FAIL, "SSH community string value is not masked for Type as Individual IP");
			}

			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);

			Boolean statdpl = new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if (statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration Add new is clicked for verified another scenario");
			} else if (!statdpl) {
				test.log(Status.FAIL, "Configuration Add new is not clicked for validate another scenario");
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to click on add new  Configure SSH with Subnet Mask and Type as Individual IP " + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		// Validating through Postgres Database along with UI data//
		Thread.sleep(3000);
		// Object of Connection from the Database
		Connection connt = null;
		// Object of Statement. It is used to create a Statement to execute the query
		Statement stmtt = null;
		//Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
		ResultSet resultSett = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//Class.forName("com.mysql.jdbc.Driver");
		// Open a connection
		conn = DriverManager.getConnection("jdbc:postgresql://172.31.28.8:5432/zif", "zif", "ZIF@@123");
		// Execute a query
		try {
			stmt = conn.createStatement();
			String queryq = "*";
			String query = "Select" + queryq + "from dicv_ssh_settings";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String namecreated = rs.getString("credential_name");

				if (namecreated.equalsIgnoreCase("AutomodeSSH33QT")) {
					System.out.println("The name which is created in SSH: " + namecreated);
					test.log(Status.PASS, "The name in the UI and Database matches: " + namecreated);
				} else {
					System.out.println("The database value "+namecreated);
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		//Clicking on Create Discovery//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Createnewdiscovery.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed configuration and created new discovery");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to close and create new discovery");
		}

		//Validating the create discovery name with invalid input//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryname.sendKeys("Automode&12%");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			String invalidtext = new ZIFAI_AlertsSettingsPage(driver).Invaliddiscoverynamealert.getText();
			if (invalidtext.contains("Enter Valid Discovery Name")) {
				test.log(Status.PASS, "Invalid message has been displayed when entering invalid discovery name");
			} else {
				test.log(Status.FAIL, "Invalid message is not displayed entering invalid discovery name");
			}
		} catch (Exception e) {

		}


		//Validating the IP range start with invalid input//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryname.clear();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryname.sendKeys("AutomodeSSH2K");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).IPrangestart.sendKeys("11.10.76.90.90");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Selectrangedropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			String invalidip = new ZIFAI_AlertsSettingsPage(driver).Invalidiprangestart.getText();
			if (invalidip.contains("Enter valid IP")) {
				test.log(Status.PASS, "Invalid message has been displayed when entering invalid IP value");
			} else {
				test.log(Status.FAIL, "Invalid message has not been displayed when entering invalid IP value");
			}
		} catch (Exception e) {

		}

		//Selecting the value from Device types dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Devicetypestrigger.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetypecheckbox.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetypetextbox.sendKeys("Server");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetypecheckbox.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Server has been selected from the device list for non recursive discovery");
		} catch (Exception e) {
			test.log(Status.FAIL, "Server has not been selected from the device list for non recursive discovery");
		}

		//Clicking on Create Discovery Button//
		Properties props = null;
		try {

			new ZIFAI_AlertsSettingsPage(driver).IPrangestart.clear();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).IPrangestart.sendKeys("172.31.28.7");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).EnableRecursiveDiscovery.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Creatediscoverybutton.click();
			Thread.sleep(40000);
			String discvvalueqv = new ZIFAI_AlertsSettingsPage(driver).Discoverysuccessmessage.getText().replace("Discovery", "").replace("created", "").replace("successfully", "").replace("-", "").trim();
			Thread.sleep(6000);
			props = new Properties();
			FileOutputStream fistq = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\Uidata.properties");
			props.setProperty("Discovery.Nameb", (discvvalueqv));
			props.store(fistq, null);
			System.out.println("Newly created discovery " + discvvalueqv);
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
			String Discoveryidtqt = props.getProperty("Discovery.Nameb");
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys(Discoveryidtqt);
			Thread.sleep(6000);
			test.log(Status.PASS, "Successfully created Discovery " + discvvalueqv);
		} catch (Exception e) {
			test.log(Status.FAIL, "Server has not been selected from the device list for non recursive discovery");
		}

		//Validating the discovery which is created//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryzid.click();
			Thread.sleep(10000);
			test.log(Status.PASS, "Entered the discovery id which is created through automation");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to enter the discovery which is created through automation");
		}


		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryfullview.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryfullview.click();
			Thread.sleep(3000);
			String value4tqt = new ZIFAI_AlertsSettingsPage(driver).Interfacelinkvalue.getText();
			if (!value4tqt.isEmpty()) {
				test.log(Status.PASS, "Clicked on Interface and the value is" + value4tqt);
				System.out.println("The interface link value " + value4tqt);
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the value in interface");
		}
		//Getting the value from interface list and validating the size in collapse mode//
		try {

			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(7000);
			int sizet = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String st = Integer.toString(sizet);
			Thread.sleep(3000);
			String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces", "").replace("(", "").replace(")", "").trim();
			System.out.println("Value in overall count " + st + ".value of the size " + sizempre);
			if (st.contains(sizempre)) {
				System.out.println("The value is matching with overall and list");
			} else {
				System.out.println("The value is not matching with overall and list");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode");
		}

		//Discovery details section should be displayed with Discovery ID, Created date,Start date,End date, Recursive discovery, Types of devices discovered//
		try {
			Thread.sleep(3000);
			String Discoverystr = new ZIFAI_AlertsSettingsPage(driver).DiscoveryID.getText();
			Thread.sleep(3000);
			String Creatdatestr = new ZIFAI_AlertsSettingsPage(driver).CreatedDate.getText();
			Thread.sleep(3000);
			String Startdatestr = new ZIFAI_AlertsSettingsPage(driver).StartDate.getText();
			Thread.sleep(3000);
			String Enddatestr = new ZIFAI_AlertsSettingsPage(driver).EndDate.getText();
			Thread.sleep(3000);
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).Location.getText();
			Thread.sleep(3000);
			System.out.println("Discovery details are " + " DiscoveryID: " + Discoverystr + " Created Date: " + Creatdatestr + " Start Date: " + Startdatestr + " End Date: " + Enddatestr + " Recursive: " + Recursivestr + " ");
			test.log(Status.PASS, "Discovery details are" + " DiscoveryID: " + Discoverystr + " Created Date: " + Creatdatestr + " Start Date: " + Startdatestr + " End Date: " + Enddatestr + " Recursive: " + Recursivestr + " ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Validate the discovery details");

		}

		//Discovery input information//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryinputdetails.click();
			Thread.sleep(3000);
			String inputdetails = new ZIFAI_AlertsSettingsPage(driver).Discoveryinputinfo.getText();
			System.out.println(inputdetails);
			if (inputdetails.contains("172.31.28.5")||inputdetails.contains("172.31.28.7")) {
				test.log(Status.PASS, "IP range matching with the input details");
			} else {
				test.log(Status.FAIL, "IP range not matching with the input details");
			}
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to validate the input detals");
		}


		//Discovery input information//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Recursivediscoveryinfo.click();
			Thread.sleep(3000);
			String inputdetails = new ZIFAI_AlertsSettingsPage(driver).Devicetypeidentification.getText();
			System.out.println(inputdetails);
			if (inputdetails.contains("Server")) {
				test.log(Status.PASS, "Configured Server is displayed");
			} else {
				test.log(Status.FAIL, "Configured Server is not displayed");
			}
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to validate the recursive details");
		}

		//------------------------------------------End of US---------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 7794: Verify user is able to discover CentOs device with IP Range and Recursive Discovery");
		test.createNode("Test Case 7794: Verify user is able to discover CentOs device with IP Range and Recursive Discovery");

		//Clicking on Configuration setting page//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Closebutton.click();
			Thread.sleep(4000);
			new ZIFAI_AlertsSettingsPage(driver).alertSettingsIcon.click();
			Thread.sleep(4000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(4000);
			new ZIFAI_AlertsSettingsPage(driver).SSHaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SSH add icon for Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SSH add icon for Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Entering details with SSH using Add new Popup//
		//Selecting Values from SSH location dropdown and Type dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHRangestart.sendKeys("172.31.28.7");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHUsername.sendKeys("azureuser");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHPassword.sendKeys("Neptune@!8520");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SSHname.sendKeys("AutomodeSSH66MU");
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SSHPasswordvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SSH community string value for IP Type as Default " + passrd);
			if (passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SSH community string value is masked for Type as Individual IP");
			} else {
				test.log(Status.FAIL, "SSH community string value is not masked for Type as Individual IP");
			}

			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);

			Boolean statdpl = new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if (statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration Add new is clicked for verified another scenario");
			} else if (!statdpl) {
				test.log(Status.FAIL, "Configuration Add new is not clicked for validate another scenario");
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to click on add new  Configure SSH with Subnet Mask and Type as Individual IP " + e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		// Validating through Postgres Database along with UI data//
		Thread.sleep(3000);
		// Object of Connection from the Database
		Connection conntq = null;
		// Object of Statement. It is used to create a Statement to execute the query
		Statement stmttq = null;
		//Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
		ResultSet resultSettq = null;
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		//Class.forName("com.mysql.jdbc.Driver");
		// Open a connection
		conn = DriverManager.getConnection("jdbc:postgresql://172.31.28.8:5432/zif", "zif", "ZIF@@123");
		// Execute a query
		try {
			stmt = conn.createStatement();
			String queryq = "*";
			String query = "Select" + queryq + "from dicv_ssh_settings";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String namecreated = rs.getString("credential_name");

				if (namecreated.equalsIgnoreCase("AutomodeSSH66MU")) {
					System.out.println("The name which is created in SSH: " + namecreated);
					test.log(Status.PASS, "The name in the UI and Database matches: " + namecreated);
				} else {
					System.out.println("The database value "+namecreated);
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		//Clicking on Create Discovery//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Createnewdiscovery.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed configuration and created new discovery");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to close and create new discovery");
		}

		//Validating the create discovery name with invalid input//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryname.sendKeys("Automode&12%");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			String invalidtext = new ZIFAI_AlertsSettingsPage(driver).Invaliddiscoverynamealert.getText();
			if (invalidtext.contains("Enter Valid Discovery Name")) {
				test.log(Status.PASS, "Invalid message has been displayed when entering invalid discovery name");
			} else {
				test.log(Status.FAIL, "Invalid message is not displayed entering invalid discovery name");
			}
		} catch (Exception e) {

		}


		//Validating the IP range start with invalid input//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryname.clear();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryname.sendKeys("AutomodeSSH4K");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).IPrangestart.sendKeys("11.10.76.90.90");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Selectrangedropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			String invalidip = new ZIFAI_AlertsSettingsPage(driver).Invalidiprangestart.getText();
			if (invalidip.contains("Enter valid IP")) {
				test.log(Status.PASS, "Invalid message has been displayed when entering invalid IP value");
			} else {
				test.log(Status.FAIL, "Invalid message has not been displayed when entering invalid IP value");
			}
		} catch (Exception e) {

		}

		//Selecting the value from Device types dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Devicetypestrigger.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetypecheckbox.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetypetextbox.sendKeys("Server");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetypecheckbox.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Server has been selected from the device list for non recursive discovery");
		} catch (Exception e) {
			test.log(Status.FAIL, "Server has not been selected from the device list for non recursive discovery");
		}

		//Clicking on Create Discovery Button//
		Properties propg = null;
		try {

			new ZIFAI_AlertsSettingsPage(driver).IPrangestart.clear();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).IPrangestart.sendKeys("172.31.28.7");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).EnableRecursiveDiscovery.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Creatediscoverybutton.click();
			Thread.sleep(40000);
			String discvvalueqqa = new ZIFAI_AlertsSettingsPage(driver).Discoverysuccessmessage.getText().replace("Discovery", "").replace("created", "").replace("successfully", "").replace("-", "").trim();
			Thread.sleep(6000);
			propg = new Properties();
			FileOutputStream fisltsp = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\Uidata.properties");
			propg.setProperty("Discovery.Namec", (discvvalueqqa));
			propg.store(fisltsp, null);
			System.out.println("Newly created discovery " + discvvalueqqa);
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(4000);
			String Discoveryidtyp = propg.getProperty("Discovery.Namec");
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).Discoverysearch.sendKeys(Discoveryidtyp);
			Thread.sleep(6000);
			test.log(Status.PASS, "Successfully created Discovery " + discvvalueqqa);
		} catch (Exception e) {
			test.log(Status.FAIL, "Server has not been selected from the device list for non recursive discovery");
		}

		//Validating the discovery which is created//
		try {
			Thread.sleep(10000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryzid.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Entered the discovery id which is created through automation");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to enter the discovery which is created through automation");
		}

		//Validation for Interface//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Discoveryfullview.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryfullview.click();
			Thread.sleep(3000);
			String value4tqtm = new ZIFAI_AlertsSettingsPage(driver).Interfacelinkvalue.getText();
			if (!value4tqtm.isEmpty()) {
				test.log(Status.PASS, "Clicked on Interface and the value is" + value4tqtm);
				System.out.println("The interface link value " + value4tqtm);
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify the value in interface");
		}
		//Getting the value from interface list and validating the size in collapse mode//
		try {
			new ZIFAI_AlertsSettingsPage(driver).Interfacelink.click();
			Thread.sleep(3000);
			int sizeteq = new ZIFAI_AlertsSettingsPage(driver).Interfacevalue.size();
			String sqe = Integer.toString(sizeteq);
			Thread.sleep(3000);
			String sizempre = new ZIFAI_AlertsSettingsPage(driver).Interfacecount.getText().replace("Interfaces", "").replace("(", "").replace(")", "").trim();
			System.out.println("Value in overall count " + sqe + ".value of the size " + sizempre);
			if (sqe.contains(sizempre)) {
				System.out.println("The value is matching with overall and list");
			} else {
				System.out.println("The value is not matching with overall and list");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Devicetitlelink.click();
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to validate the interface list and size in collapse mode");
		}

		//Discovery details section should be displayed with Discovery ID, Created date,Start date,End date, Recursive discovery, Types of devices discovered//
		try {
			Thread.sleep(3000);
			String Discoverystr = new ZIFAI_AlertsSettingsPage(driver).DiscoveryID.getText();
			Thread.sleep(3000);
			String Creatdatestr = new ZIFAI_AlertsSettingsPage(driver).CreatedDate.getText();
			Thread.sleep(3000);
			String Startdatestr = new ZIFAI_AlertsSettingsPage(driver).StartDate.getText();
			Thread.sleep(3000);
			String Enddatestr = new ZIFAI_AlertsSettingsPage(driver).EndDate.getText();
			Thread.sleep(3000);
			String Recursivestr = new ZIFAI_AlertsSettingsPage(driver).Location.getText();
			Thread.sleep(3000);
			System.out.println("Discovery details are " + " DiscoveryID: " + Discoverystr + " Created Date: " + Creatdatestr + " Start Date: " + Startdatestr + " End Date: " + Enddatestr + " Recursive: " + Recursivestr + " ");
			test.log(Status.PASS, "Discovery details are" + " DiscoveryID: " + Discoverystr + " Created Date: " + Creatdatestr + " Start Date: " + Startdatestr + " End Date: " + Enddatestr + " Recursive: " + Recursivestr + " ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Validate the discovery details");

		}

		//Discovery input information//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryinputdetails.click();
			Thread.sleep(3000);
			String inputdetails = new ZIFAI_AlertsSettingsPage(driver).Discoveryinputinfo.getText();
			System.out.println(inputdetails);
			if (inputdetails.contains("172.31.28.5")||inputdetails.contains("172.31.28.7")) {
				test.log(Status.PASS, "IP range matching with the input details");
			} else {
				test.log(Status.FAIL, "IP range not matching with the input details");
			}
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to validate the input detals");
		}


		//Discovery input information//
		try {
			Thread.sleep(4000);
			new ZIFAI_AlertsSettingsPage(driver).Recursivediscoveryinfo.click();
			Thread.sleep(4000);
			String inputdetails = new ZIFAI_AlertsSettingsPage(driver).Devicetypeidentification.getText();
			System.out.println(inputdetails);
			if (inputdetails.contains("Server")) {
				test.log(Status.PASS, "Configured Server is displayed");
			} else {
				test.log(Status.FAIL, "Configured Server is not displayed");
			}
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to validate the recursive details");
		}
		//----------------------------------------End of US--------------------------------------------------//

	}
}