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
import com.zifautomation.Pages.CMPLandingpage;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAIPredictionPage;
import com.zifautomation.Pages.ZIFAIPrediction_DeviceConfigPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import bsh.Console;

public class ZIFUI_Testcases006 extends Base {

	// PreRequsite
	PropertiesFileReader obj= new PropertiesFileReader();
	Properties properties = null;



	@Test(enabled = true)
	public void ZIFUIPredictions_VerifyOpportunityCards() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Opportunity Cards in all Swim Lane verification");
		test.createNode("ZIF UI Prediction Opportunity Cards in all Swim Lane verification");

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
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");

		}


		// Verify all fields in ZIF UI dashboard page
		try {

			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickPrediction();

			//Predicted Risk opportunity cards
			try {
				WebElement Card1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-cards lost-state')][1]"));
				if(Card1.isDisplayed())
				{
					test.log(Status.PASS,"Predicted Risk opportunity cards are displayed");
				}
			}catch (Exception e) {
				test.log(Status.FAIL, "Predicted Risk opportunity cards are Not available");
			}
			try {					
				WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'no-data-cls')]"));
				if(Nodata1.isDisplayed())
				{
					test.log(Status.PASS,"No Data available is displayed");
				}}catch (Exception e) {
				}



			//Currently at Risk opportunity cards
			try {
				WebElement Card2 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-cards lost-state')][1]"));
				if(Card2.isDisplayed())
				{
					test.log(Status.PASS,"Currently at Risk opportunity cards are displayed");
				}
			}catch (Exception e) {
				test.log(Status.FAIL, "Currently at Risk opportunity cards are Not available");
			}

			try {					
				WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'no-data-cls')]"));
				if(Nodata1.isDisplayed())
				{
					test.log(Status.PASS,"No Data available is displayed");
				}
			}catch (Exception e) {
			}


			//Processed opportunity cards
			try {
				WebElement Card3 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-cards lost-state')][1]"));
				if(Card3.isDisplayed())
				{
					test.log(Status.PASS,"Processed opportunity cards are displayed");
				}
			}catch (Exception e) {
				test.log(Status.FAIL, "Processed opportunity cards are Not available");
			}

			try {					
				WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'no-data-cls')]"));
				if(Nodata1.isDisplayed())
				{
					test.log(Status.PASS,"No Data available is displayed");
				}
			}catch (Exception e) {
			}


			//Lost opportunity cards
			try {
				WebElement Card3 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]"));
				if(Card3.isDisplayed())
				{
					test.log(Status.PASS,"Lost opportunity cards are displayed");
				}
			}catch (Exception e) {
				test.log(Status.FAIL, "Lost opportunity cards are Not available");
			}

			try {					
				WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'no-data-cls')]"));
				if(Nodata1.isDisplayed())
				{
					test.log(Status.PASS,"No Data available is displayed");
				}
			}catch (Exception e) {
			}

			//Invalid opportunity cards
			try {
				WebElement Card3 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-cards invalid-state')][1"));
				if(Card3.isDisplayed())
				{
					test.log(Status.PASS,"Invalid opportunity cards are displayed");
				}
			}catch (Exception e) {
				test.log(Status.FAIL, "Invalid opportunity cards are Not available");
			}

			try {					
				WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'no-data-cls')]"));
				if(Nodata1.isDisplayed())
				{
					test.log(Status.PASS,"No Data available is displayed");
				}
			}catch (Exception e) {
			}

			//Logout of Application
			try {
				new ZIFAIDashboardPage(driver).LogoutClick();
				test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
			}catch (Exception e) {
				test.log(Status.FAIL, "Dashboard page Logout failed");
			}


		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in Selecting  prediction from Analyzes");

		}



	}




	//-----------------------------------------------------------------------------------------------------


	@Test(enabled = true)
	public void ZIFUIPredictions_VerifyOpportunityCardsfields() throws IOException, InterruptedException {

		//Report 

		test = extent.createTest("ZIF UI Prediction Opportunity Cards fields verification");
		test.createNode("ZIF UI Prediction Opportunity Cards fields verification");

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
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login failed");

		}


		// Verify all fields in ZIF UI dashboard page
		try {

			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickPrediction();


			//Lost opportunity cards
			try {
				WebElement Card3 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]"));
				if(Card3.isDisplayed())
				{
					test.log(Status.PASS,"Lost opportunity cards are displayed");


					new ZIFAIPredictionPage(driver).verifyLostOppcardDetails();

					test.log(Status.PASS,"Lost opportunity cards fields are verified");

				}
			}catch (Exception e) {
				test.log(Status.FAIL, "Lost opportunity cards are Not available");
			}

			try {					
				WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'no-data-cls')]"));
				if(Nodata1.isDisplayed())
				{
					test.log(Status.PASS,"No Data available is displayed");
				}
			}catch (Exception e) {
			}


			//Invalid opportunity cards
			try {
				WebElement Card3 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-cards invalid-state')][1]"));
				if(Card3.isDisplayed())
				{
					test.log(Status.PASS,"Invalid opportunity cards are displayed");

					new ZIFAIPredictionPage(driver).verifyInvalidOppcardDetails();

					test.log(Status.PASS,"Invalid opportunity cards fields are verified");

				}
			}catch (Exception e) {
				test.log(Status.FAIL, "Invalid opportunity cards are Not available");
			}

			try {					
				WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'no-data-cls')]"));
				if(Nodata1.isDisplayed())
				{
					test.log(Status.PASS,"No Data available is displayed");
				}
			}catch (Exception e) {
			}

			//Logout of Application
			try {
				new ZIFAIDashboardPage(driver).LogoutClick();
				test.log(Status.PASS,"Successfully Logged out from Dashboard Page");
			}catch (Exception e) {
				test.log(Status.FAIL, "Dashboard page Logout failed");
			}


		} catch (AssertionError | Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Failed in Selecting  prediction from Analyzes");

		}



	}


}




