package com.zifautomation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;

import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAIPredictionPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

public class ZIFUI_Testcases002 extends Base {

	// PreRequsite
	PropertiesFileReader obj= new PropertiesFileReader();
	Properties properties = null;



	@Test(enabled = true)
	public void ZIFUIDashboardFieldValidation() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Dashboard field validation");
		test.createNode("ZIF UI Dashboard field validation");

		//Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			test.log(Status.PASS,"Valid UserName and Valid Password has been entered and Verified");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Valid credentials verification failed");

		}

		// Verify User is in ZIF UI Home Page

		try {
			String ExpectedTitle = "ZIF";

			String ActualTitle = driver.getTitle();

			assertEquals(ExpectedTitle, ActualTitle);
			test.log(Status.PASS,"Successfully logged in and User is in ZIF UI Home Page");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");

		}
		
		
		// Verify all fields in ZIF UI dashboard page
		try {
			
			new ZIFAIDashboardPage(driver).CheckallfieldsandImages();
			test.log(Status.PASS,"Successfully verified all the fields in the Dashboard Page");

			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Dashboard page field validdation failed");

		}
		
		//Logout of Application
		try {
			new ZIFAIDashboardPage(driver).LogoutClick();
			test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
		}catch (Exception e) {
			test.log(Status.FAIL, "Dashboard page Logout failed");
		}

	}
	
	
	@Test(enabled = true,priority = 1)
	public void ZIFUIAnalyzeshoverVerification() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Analyzes Hover Verification");
		test.createNode("ZIF UI Analyzes Hover Verification");

		//Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Login failed");

		}

		// Verify User is in ZIF UI Home Page

		try {
			String ExpectedTitle = "ZIF";
			String ActualTitle = driver.getTitle();
			assertEquals(ExpectedTitle, ActualTitle);
			test.log(Status.PASS,"Successfully logged in and User is in ZIF UI Home Page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");

		}
		
		
		// Verify all fields in ZIF UI dashboard page
		try {
			
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			test.log(Status.PASS,"Successfully the hover menu is displayed for the Analyzes");
			Thread.sleep(2000);
			new ZIFAIDashboardPage(driver).verifyAnalyzeshovermenufields();
			test.log(Status.PASS,"Successfully verified the fields in the hover menu displayed for Analyzes");
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in hover menu of Analyzes");

		}
		
		//Logout of Application
		try {
			new ZIFAIDashboardPage(driver).LogoutClick();
			test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
		}catch (Exception e) {
			test.log(Status.FAIL, "Dashboard page Logout failed");
		}

	}

	@Test(enabled = true, priority = 2)
	public void ZIFUINavigateToPredictions() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Navigate To Predictions");
		test.createNode("ZIF UI Navigate To Predictions");

		//Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Login failed");

		}

		// Verify User is in ZIF UI Home Page

		try {
			String ExpectedTitle = "ZIF";
			String ActualTitle = driver.getTitle();
			assertEquals(ExpectedTitle, ActualTitle);
			test.log(Status.PASS,"Successfully logged in and User is in ZIF UI Home Page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");

		}
		
		
		// Verify all fields in ZIF UI Prediction page
		try {
			
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).verifyAnalyzeshovermenufields();
			new ZIFAIDashboardPage(driver).clickPrediction();
			
			new ZIFAIPredictionPage(driver).checkuserinPredictionPage();
			test.log(Status.PASS,"Successfully the user is in Prediction page");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in selecting prediction from Analyzes");

		}
		
		//Logout of Application
		try {
			new ZIFAIPredictionPage(driver).LogoutClick();
			test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
		}catch (Exception e) {
			test.log(Status.FAIL, "Dashboard page Logout failed");
		}

	}

}
