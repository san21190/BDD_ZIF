package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Utility.MongoQueryManager;
import com.zifautomation.Utility.PostgresConnectionManager;
import com.zifautomation.Utility.PostgresQueryManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import com.zifautomation.Utility.PostgresConnectionManager.*;
import com.zifautomation.Utility.PostgresQueryManager.*;


public class ZIFUI_Discovery_US5100_Regression extends Base {

	//	PropertiesFileReader obj = new PropertiesFileReader();
	//	Properties properties = null;
	//	CommonMethods cm = null;


	@Test
	public void ZIFUI_Discovery_US5100_Regression() throws IOException, InterruptedException, SQLException, ClassNotFoundException {

		//Report Initialization
		test = extent.createTest("User Story 5100: Configuration Settings - Add WMI Credentials");
		test.createNode("User Story 5100: Configuration Settings - Add WMI Credentials");
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

		//Clicking on Configuration setting page//
		try {
			new ZIFAI_AlertsSettingsPage(driver).alertSettingsIcon.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on WMI add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on WMI add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the WMI which is created already//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteWMIconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared all the WMI configuration which is created by automation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear the WMI configuration");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//------------------------------------------End of US--------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4605: Verify Add WMI Credentials with IP Type as Individual IP with invalid IP Address");
		test.createNode("Test Case 4605: Verify Add WMI Credentials with IP Type as Individual IP with invalid IP Address");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on WMI add icon for Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on WMI add icon for Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Enter invalid IP Address and alert should be displayed
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIRangestart.sendKeys("10.0.8.256");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIUsername.sendKeys("Autouser");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIPassword.sendKeys("BetaIP");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIDomain.sendKeys("Gavs.com");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).WMIPasswordvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of WMI communal string value " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "WMI communal string value is masked after entering Individual IP");
			}
			else{
				test.log(Status.FAIL, "WMI communal string value is not masked after entering Individual IP");
			}
			Thread.sleep(6000);
			String statdpld =new ZIFAI_AlertsSettingsPage(driver).WMIIPstartinvalid.getText();
			System.out.println("Alert message in IP start "+statdpld);
			if(statdpld.equalsIgnoreCase("Enter valid IP")) {
				Thread.sleep(3000);
				test.log(Status.PASS, "IP start range shows alert message when entering invalid IP");
			}
			else if(!statdpld.equalsIgnoreCase("Enter valid IP")){
				test.log(Status.FAIL, "IP start range does no show alert message when entering invalid IP");
			}
			Thread.sleep(5000);
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to Configure WMI with Individual IP" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the WMI configuration with IP range//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteWMIconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure WMI with Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to Configure WMI with Individual IP" +e);
		}

		//Closing the configuration Discovery configuration close//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed Configure WMI with Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure WMI with Individual IP" +e);
		}
		//-----------------------------------------End of US------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4599: Verify Add WMI Credentials with IP Type as Individual IP and Version WMI 2C");
		test.createNode("Test Case 4599: Verify Add WMI Credentials with IP Type as Individual IP and Version WMI 2C");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).WMIaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on WMI add icon for subnet Individual IP IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on WMI add icon subnet Individual IP IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Selecting Values from WMI location dropdown and Type dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption3.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIRangestart.sendKeys("10.1.0.5");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIRangeend.sendKeys("10.1.0.25");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIUsername.sendKeys("Autoend");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIPassword.sendKeys("Autopass");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).WMIDomain.sendKeys("Gavstech.com");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).WMIPasswordvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of WMI community string value for IP Type as Default " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "WMI community string value is masked for Type as Individual IP");
			}
			else{
				test.log(Status.FAIL, "WMI community string value is not masked for Type as Individual IP");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);
			Boolean statdpl =new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if(statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration WMI is successful after selecting Type as Individual IP");
			}
			else if(!statdpl){
				test.log(Status.FAIL, "Configuration WMI is not successful after selecting Type as Individual IP");
			}
			Thread.sleep(5000);
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to Configure WMI with Subnet Mask and Type as Individual IP " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Validating through Postgres Database along with UI data//

		// Object of Connection from the Database
		Connection conn = null;
		// Object of Statement. It is used to create a Statement to execute the query
		Statement stmt = null;
		//Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
		ResultSet resultSet = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
		//Class.forName("com.mysql.jdbc.Driver");
		// Open a connection
		conn = DriverManager.getConnection("jdbc:postgresql://172.31.28.14:5432/zif", "zif", "ZIF@@123");
		// Execute a query
		try {
			stmt = conn.createStatement();
			String queryq = "*";
			String query = "Select" +queryq +"from dicv_wmi_settings";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String namecreated = rs.getString("username");

				if (namecreated.equalsIgnoreCase("Autoend")) {
					System.out.println("The name which is created in WMI "+namecreated);
					test.log(Status.PASS, "The name in the UI and Database matches " + namecreated);
				} else {
					test.log(Status.PASS, "The name in the UI and Database does not match/doesn't exist" + namecreated);
				}
			}
		}catch (SQLException e) {
			System.out.println(e);
		}

		//Clearing the WMI configuration with IP range//
		try{
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).DeleteWMIconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure WMI with Subnet Mask and Type as Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear WMI with Subnet Mask and Type as Individual IP" +e);
		}

		//Closing the configuration Discovery configuration//
		try{
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed Configure WMI with Subnet Mask and Type as Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure WMI Subnet Mask and Type as Individual IP" +e);
		}
	}
}
//-----------------------------------------------End of US-------------------------------------------------//



