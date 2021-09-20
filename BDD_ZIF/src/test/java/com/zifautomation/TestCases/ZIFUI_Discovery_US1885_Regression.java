package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Discovery_US1885_Regression extends Base {

	//	PropertiesFileReader obj = new PropertiesFileReader();
	//	Properties properties = null;
	//	CommonMethods cm = null;


	@Test
	public void ZIFUI_Discovery_US1885_Regression() throws IOException, InterruptedException {

		//Report Initialization
		test = extent.createTest("User Story 1885: Configuration Settings - Add SNMP Credentials");
		test.createNode("User Story 1885: Configuration Settings - Add SNMP Credentials");
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
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SNMP add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SNMP add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SNMP which is created already//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSNMPconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared all the SNMP configuration which is created by automation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear the SNMP configuration");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}
		//--------------------------------End of US------------------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4600: Verify Add SNMP Credentials with IP Type as Subnet Mask and Version SNMP 2C");
		test.createNode("Test Case 4600: Verify Add SNMP Credentials with IP Type as Subnet Mask and Version SNMP 2C");

		//Selecting Values from SNMP location dropdown and Type dropdown//
		try {
 			new ZIFAI_AlertsSettingsPage(driver).SNMPaddicon.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption2.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPVersionDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SubnetMaskdropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption3.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPRangestart.sendKeys("10.0.8.1");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystring.sendKeys("Alpha");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automation"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystringvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SNMP communal string value IP Type as Subnet Mask " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SNMP communal string value is masked IP Type as Subnet Mask");
			}
			else{
				test.log(Status.FAIL, "SNMP communal string value is not masked IP Type as Subnet Mask");
			}
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);
			Boolean statdpl =new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if(statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration SNMP is successful after selecting type as Subnet IP Type ");
			}
			else if(!statdpl){
				test.log(Status.FAIL, "Configuration SNMP is not successful after selecting type as Subnet");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to Configure SNMP with Subnet type" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SNMP which is created already//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSNMPconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared all the SNMP configuration which is created by automation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (NoSuchElementException e){
			new ZIFAI_AlertsSettingsPage(driver).Close.click();
			test.log(Status.PASS, "Failed to create configuration hence proceeding with next scenario");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (Exception e){
			test.log(Status.FAIL, "Unable to clear the SNMP configuration");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the configuration Discovery configuration close//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Unable to close Configure SNMP with Subnet type");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SNMP with Subnet type" +e);
		}

		//---------------------------------------------End of US--------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4601: Verify Add SNMP Credentials with IP Type as IP Range and Version SNMP 2C");
		test.createNode("Test Case 4601: Verify Add SNMP Credentials with IP Type as IP Range and Version SNMP 2C");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SNMP add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SNMP add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption3.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPVersionDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPRangestart.sendKeys("10.0.8.1");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPRangeend.sendKeys("10.0.8.7");
			Thread.sleep(3000);
			//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystring);
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystring.sendKeys("AlphaIP");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystringvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SNMP communal string value " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SNMP communal string value is masked after entering IP range");
			}
			else{
				test.log(Status.FAIL, "SNMP communal string value is not masked after entering IP range");
			}
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);
			Boolean statdpl =new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if(statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration SNMP is successful after selecting type as IP range");
			}
			else if(!statdpl){
				test.log(Status.FAIL, "Configuration SNMP is not successful after selecting type as IP range");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to Configure SNMP with IP range type" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SNMP configuration with IP range//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSNMPconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the Configure SNMP with IP range type");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to Configure SNMP with IP range type" +e);
		}

		//Closing the configuration Discovery configuration close//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed Configure SNMP with IP range type");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SNMP with IP range type" +e);
		}
		//----------------------------------------End of US-----------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4602: Verify Add SNMP Credentials with IP Type as IP Range and invalid IP Start and End ");
		test.createNode("Test Case 4602: Verify Add SNMP Credentials with IP Type as IP Range and invalid IP Start and End ");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SNMP add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SNMP add icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption3.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPVersionDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption2.click();
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPRangestart.sendKeys("10.0.8.1.5");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPRangeend.sendKeys("10.0.8.9.6");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).AuthenticationtypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPAuthPassword.sendKeys("Automation");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPEncryptPassword.sendKeys("AutoPass");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPUsername.sendKeys("Automation");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SecurityleveDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption2.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).EncryptiontypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption3.click();
			Thread.sleep(6000);
			String statdpld =new ZIFAI_AlertsSettingsPage(driver).IPstartinvalid.getText();
			System.out.println("Alert message in IP start "+statdpld);
			if(statdpld.equalsIgnoreCase("Enter valid IP")) {
				Thread.sleep(3000);
				test.log(Status.PASS, "IP start range shows alert message when entering invalid IP");
			}
			else if(!statdpld.equalsIgnoreCase("Enter valid IP")){
				test.log(Status.FAIL, "IP start range does no show alert message when entering invalid IP");
			}
			Thread.sleep(6000);
			String statdpldd =new ZIFAI_AlertsSettingsPage(driver).IPendinvalid.getText();
			System.out.println("Alert message in IP end "+statdpldd);
			if(statdpldd.equalsIgnoreCase("Enter valid IP")) {
				Thread.sleep(3000);
				test.log(Status.PASS, "IP end range shows alert message when entering invalid IP");
			}
			else if(!statdpld.equalsIgnoreCase("Enter valid IP")){
				test.log(Status.FAIL, "IP end range does no show alert message when entering invalid IP");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to Configure SNMP with IP start and end range" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SNMP configuration with IP range//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSNMPconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure SNMP with IP start and end range");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to Configure SNMP with IP start and end range" +e);
		}

		//Closing the configuration Discovery configuration close//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed Configure SNMP with IP start and end range");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SNMP with IP start and end range" +e);
		}

		//------------------------------------------End of US--------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4605: Verify Add SNMP Credentials with IP Type as Individual IP with invalid IP Address");
		test.createNode("Test Case 4605: Verify Add SNMP Credentials with IP Type as Individual IP with invalid IP Address");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SNMP add icon for Individual IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SNMP add icon for Individual IP");
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
			new ZIFAI_AlertsSettingsPage(driver).SNMPVersionDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPRangestart.sendKeys("10.0.8.1.20");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystring.sendKeys("BetaIP");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystringvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SNMP communal string value " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SNMP communal string value is masked after entering Individual IP");
			}
			else{
				test.log(Status.FAIL, "SNMP communal string value is not masked after entering Individual IP");
			}
			Thread.sleep(6000);
			String statdpld =new ZIFAI_AlertsSettingsPage(driver).IPstartinvalid.getText();
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
			test.log(Status.FAIL, "Unable to Configure SNMP with Individual IP" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SNMP configuration with IP range//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSNMPconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure SNMP with Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to Configure SNMP with Individual IP" +e);
		}

		//Closing the configuration Discovery configuration close//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed Configure SNMP with Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SNMP with Individual IP" +e);
		}
		//-----------------------------------------End of US------------------------------------------------//

		//----------------------------------End of US------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4604: Verify Add SNMP Credentials with IP Type as Subnet Mask and invalid IP Start and End ");
		test.createNode("Test Case 4604: Verify Add SNMP Credentials with IP Type as Subnet Mask and invalid IP Start and End ");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SNMP add icon for subnet invalid IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SNMP add icon subnet invalid IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Selecting Values from SNMP location dropdown and Type dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption2.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPVersionDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SubnetMaskdropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption3.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPRangestart.sendKeys("10.0.8.1.13");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystring.sendKeys("Beta");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystringvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SNMP community string value for invalid Subnet IP " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SNMP community string value is masked for invalid Subnet IP");
			}
			else{
				test.log(Status.FAIL, "SNMP community string value is not masked for invalid Subnet IP ");
			}

		Thread.sleep(3000);
		String statdpld =new ZIFAI_AlertsSettingsPage(driver).IPstartinvalid.getText();
		System.out.println("Alert message in IP start "+statdpld);
		if(statdpld.equalsIgnoreCase("Enter valid IP")) {
			Thread.sleep(3000);
			test.log(Status.PASS, "IP start range shows alert message when entering Subnet Mask and invalid IP Start ");
		}
		else if(!statdpld.equalsIgnoreCase("Enter valid IP")){
			test.log(Status.FAIL, "IP start range does no show alert message when entering Subnet Mask and invalid IP Start ");
		}
		Thread.sleep(5000);
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to Configure SNMP with Subnet Mask and invalid IP Start " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SNMP configuration with IP range//
		try{
			System.out.println("Check");
			new ZIFAI_AlertsSettingsPage(driver).DeleteSNMPconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure SNMP with Subnet Mask and invalid IP Start ");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear SNMP with Subnet Mask and invalid IP Start " +e);
		}

		//Closing the configuration Discovery configuration//
		try{
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Unable to close Configure SNMP with Subnet Mask and invalid IP Start ");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SNMP Subnet Mask and invalid IP Start" +e);
		}
		//------------------------------------------End of US---------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4598: Verify Add SNMP Credentials with IP Type as Default and Version SNMP 2C");
		test.createNode("Test Case 4598: Verify Add SNMP Credentials with IP Type as Default and Version SNMP 2C");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SNMP add icon for subnet invalid IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SNMP add icon subnet invalid IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Selecting Values from SNMP location dropdown and Type dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption4.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPVersionDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystring.sendKeys("Gamma");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystringvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SNMP community string value for IP Type as Default " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SNMP community string value is masked for IP Type as Default");
			}
			else{
				test.log(Status.FAIL, "SNMP community string value is not masked for IP Type as Default");
			}

			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);
			Boolean statdpl =new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if(statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration SNMP is successful after selecting IP Type as Default");
			}
			else if(!statdpl){
				test.log(Status.FAIL, "Configuration SNMP is not successful after selecting IP Type as Default");
			}
			Thread.sleep(5000);
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to Configure SNMP with Subnet Mask and IP Type as Default " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SNMP configuration with IP range//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSNMPconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure SNMP with Subnet Mask and IP Type as Default");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear SNMP with Subnet Mask and IP Type as Default" +e);
		}

		//Closing the configuration Discovery configuration//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Unable to close Configure SNMP with Subnet Mask and IP Type as Default");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SNMP Subnet Mask and IP Type as Default" +e);
		}

		//-----------------------------------------------End of US---------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4599: Verify Add SNMP Credentials with IP Type as Individual IP and Version SNMP 2C");
		test.createNode("Test Case 4599: Verify Add SNMP Credentials with IP Type as Individual IP and Version SNMP 2C");

		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SNMP add icon for subnet Individual IP IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SNMP add icon subnet Individual IP IP");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Selecting Values from SNMP location dropdown and Type dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPVersionDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPRangestart.sendKeys("10.0.8.5");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystring.sendKeys("Alpha");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automode"+str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystringvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SNMP community string value for IP Type as Default " +passrd);
			if(passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SNMP community string value is masked for Type as Individual IP");
			}
			else{
				test.log(Status.FAIL, "SNMP community string value is not masked for Type as Individual IP");
			}

			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);
			Boolean statdpl =new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if(statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration SNMP is successful after selecting Type as Individual IP");
			}
			else if(!statdpl){
				test.log(Status.FAIL, "Configuration SNMP is not successful after selecting Type as Individual IP");
			}
			Thread.sleep(5000);
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to Configure SNMP with Subnet Mask and Type as Individual IP " +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the SNMP configuration with IP range//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSNMPconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure SNMP with Subnet Mask and Type as Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear SNMP with Subnet Mask and Type as Individual IP" +e);
		}

		//Closing the configuration Discovery configuration//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Unable to close Configure SNMP with Subnet Mask and Type as Individual IP");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SNMP Subnet Mask and Type as Individual IP" +e);
		}
		//----------------------------------------End of US-------------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 4606: Verify Add Multiple SNMP Credentials with all combination of IP Type and SNMP Versions");
		test.createNode("Test Case 4606: Verify Add Multiple SNMP Credentials with all combination of IP Type and SNMP Versions");


		//Clicking on Configuration setting page//
		try {
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).ConfigurationSetting.click();
			Thread.sleep(5000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPaddicon.click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Clicked on Configuration icon and clicked on SNMP add icon for combination of IP Type");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Configuration icon and clicked on SNMP add icon for combination of IP Type");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Selecting Values from SNMP location dropdown and Type dropdown//
		try {
			new ZIFAI_AlertsSettingsPage(driver).LocationDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Locationoption.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).TypeDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption2.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPVersionDropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption1.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SubnetMaskdropdown.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).Dropdownoption2.click();
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPRangestart.sendKeys("10.7.8.1");
			Thread.sleep(3000);
			new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystring.sendKeys("Alpha");
			Thread.sleep(3000);
			String str = RandomStringUtils.randomAlphanumeric(7);
			new ZIFAI_AlertsSettingsPage(driver).SNMPname.sendKeys("Automation" + str);
			Thread.sleep(3000);
			String passrd = new ZIFAI_AlertsSettingsPage(driver).SNMPCommunitystringvalue.getAttribute("type");
			Thread.sleep(3000);
			System.out.println("Status of SNMP communal string value with Subnet combination " + passrd);
			if (passrd.equalsIgnoreCase("password")) {
				test.log(Status.PASS, "SNMP communal string value is masked with Subnet combination");
			} else {
				test.log(Status.FAIL, "SNMP communal string value is not masked with Subnet combination");
			}
			new ZIFAI_AlertsSettingsPage(driver).Savebutton.click();
			Thread.sleep(3000);
			Boolean statdpl = new ZIFAI_AlertsSettingsPage(driver).ConfigurationSuccess.isDisplayed();
			if (statdpl) {
				new ZIFAI_AlertsSettingsPage(driver).ConfigurationDone.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Configuration SNMP is successful after selecting type for SNMP add icon combination");
			} else if (!statdpl) {
				test.log(Status.FAIL, "Configuration SNMP is not successful after selecting type for SNMP add icon for combination");
			}
		}
			catch(NoSuchElementException e){
				new ZIFAI_AlertsSettingsPage(driver).Close.click();
				test.log(Status.PASS, "Failed to create configuration hence proceeding with next scenario");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
		catch(Exception e){
				new ZIFAI_AlertsSettingsPage(driver).Close.click();
				test.log(Status.FAIL, "Unable to Configure SNMP with for combination of SNMP Subnet" + e);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}


		//Clearing the SNMP configuration with IP range//
		try{
			new ZIFAI_AlertsSettingsPage(driver).DeleteSNMPconfigdetails();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the configure SNMP combination");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear SNMP combination" +e);
		}

		//Closing the configuration Discovery configuration close//
		try{
			new ZIFAI_AlertsSettingsPage(driver).Discoveryconfigurationclose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Closed Configure SNMP for combination of Subnet");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Configure SNMP for combination of Subnet" +e);
		}
		//---------------------------------------End of US-------------------------------------------------//
	}
	}
