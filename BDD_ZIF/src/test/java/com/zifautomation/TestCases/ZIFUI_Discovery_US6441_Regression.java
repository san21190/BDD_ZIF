package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Discovery_US6441_Regression extends Base {

	//	PropertiesFileReader obj = new PropertiesFileReader();
	//	Properties properties = null;
	//	CommonMethods cm = null;


	@Test
	public void ZIFUI_Discovery_US6441_Regression() throws IOException, InterruptedException, SQLException, ClassNotFoundException {

		//Report Initialization
		test = extent.createTest("User Story 6441: Configuration Settings - Add SSH Credentials");
		test.createNode("User Story 6441: Configuration Settings - Add SSH Credentials");
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
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SSH add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SSH add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SSH which is created already//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSSHconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared all the SSH configuration which is created by automation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear the SSH configuration");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//------------------------------------------End of US--------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6949: Verify Add SSH details with Invalid details");
		test.createNode("Test Case 6949: Verify Add SSH details with Invalid details");

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
			new ZIFAI_AlertsSettingsPage(driver).SSHRangestart.sendKeys("10.21.8.256");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHUsername.sendKeys("SSHAuto");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHPassword.sendKeys("SSHIP");
			Thread.sleep(3000);

			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SSHname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SSHPasswordvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SSH communal string value " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SSH communal string value is masked after entering Individual IP");
			}
			else{
				test.log(Status.FAIL, "SSH communal string value is not masked after entering Individual IP");
			}
			Thread.sleep(6000);
			String statdpld =new ZIFAI_AlertsSettingsPage(driver).SSHstartinvalid.getText();
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
			test.log(Status.FAIL, "Unable to Configure SSH with Individual IP" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SSH configuration with IP range//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSSHconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure SSH with Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to Configure SSH with Individual IP" +e);
		}

		//Closing the configuration Discovery configuration close//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed Configure SSH with Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SSH with Individual IP" +e);
		}
		//-----------------------------------------End of US------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6950: Verify Add SSH details with Valid details");
		test.createNode("Test Case 6950: Verify Add SSH details with Valid details");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).SSHaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SSH add icon for subnet Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SSH add icon subnet Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Selecting Values from SSH location dropdown and Type dropdown//
		try {
			int size = new ZIFAI_AlertsSettingsPage(driver).DisabledSNMPnameList.size();
			List<WebElement> Listcombo = new ZIFAI_AlertsSettingsPage(driver).DisabledSNMPnameList;
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", new ZIFAI_AlertsSettingsPage(driver).LocationDropdown);
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption3.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHRangestart.sendKeys("10.1.0.5");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHRangeend.sendKeys("10.1.0.25");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHUsername.sendKeys("AutoSSH");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHPassword.sendKeys("Autopass");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SSHname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String addnewval = new ZIFAI_AlertsSettingsPage(driver).SSHnamevalue.getAttribute("value");
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SSHPasswordvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SSH community string value for IP Type as Default " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SSH community string value is masked for Type as Individual IP");
			}
			else{
				test.log(Status.FAIL, "SSH community string value is not masked for Type as Individual IP");
			}
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);
			Boolean statdpl =new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if(statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationAddNew.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration Add new is clicked for verifying another scenario");
			}
			else if(!statdpl){
				test.log(Status.FAIL, "Configuration Add new is not clicked for verifying another scenario");
			}
			Thread.sleep(5000);
			for (int i = 0; i < size; i++) {
				String snmp = Listcombo.get(i).getAttribute("value");
				System.out.println("Value from the configuration previously created text box:" + snmp);
				if (snmp.contains(addnewval)) {
					Thread.sleep(3000);
					System.out.println("Previously created SNMP configuration is saved "+addnewval);
					test.log(Status.PASS, "Previously created SNMP configuration is saved successfully");

				} else {
					test.log(Status.FAIL, "Previously created SNMP configuration is not saved successfully");
					System.out.println("Automation created configuration is not available " + snmp);
				}
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to click on add new  Configure SSH with Subnet Mask and Type as Individual IP " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SSH configuration with IP range//
		try{
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).DeleteSSHconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure SSH with Subnet Mask and Type as Subnet mask");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear SSH with Subnet Mask and Type as Subnet mask" +e);
		}

		//--------------------------------------End of US-----------------------------------------------//
			//Report Initialization
			test = extent.createTest("Test Case 6948: Verify Add SSH details with Valid details through Add New Popup");
			test.createNode("Test Case 6948: Verify Add SSH details with Valid details through Add New Popup");

			//Entering details with SSH using Add new Popup//
			//Selecting Values from SSH location dropdown and Type dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption2.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SubnetMaskdropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption2.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHRangestart.sendKeys("10.15.0.5");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHUsername.sendKeys("AutoSSH");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SSHPassword.sendKeys("Autopass");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SSHname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SSHPasswordvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SSH community string value for IP Type as Default " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SSH community string value is masked for Type as Individual IP");
			}
			else{
				test.log(Status.FAIL, "SSH community string value is not masked for Type as Individual IP");
			}

			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);

			Boolean statdpl =new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if(statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration Add new is clicked for verified another scenario");
			}
			else if(!statdpl){
				test.log(Status.FAIL, "Configuration Add new is not clicked for validate another scenario");
			}
			Thread.sleep(5000);
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to click on add new  Configure SSH with Subnet Mask and Type as Individual IP " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		// Validating through Postgres Database//

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
			String query = "Select" +queryq +"from dicv_ssh_settings";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String namecreated = rs.getString("username");

				if (namecreated.equalsIgnoreCase("AutoSSH")) {
					System.out.println("The name which is created in SSH "+namecreated);
					test.log(Status.PASS, "The name in the UI and Database matches " + namecreated);
				} else {
					test.log(Status.PASS, "The name in the UI and Database does not match/doesn't exist" + namecreated);
				}
			}
		}catch (SQLException e) {
			System.out.println(e);
		}


		//Clearing the SSH configuration with IP range//
		try{
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).DeleteSSHconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure SSH with Subnet Mask and Type as Subnet mask");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear SSH with Subnet Mask and Type as Subnet mask" +e);
		}

		//Closing the configuration Discovery configuration//
		try{
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed Configure SSH with Subnet Mask and Type as Subnet mask IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SSH Subnet Mask and Type as Subnet mask" +e);
		}
	}
}
//-----------------------------------------------End of US-------------------------------------------------//



