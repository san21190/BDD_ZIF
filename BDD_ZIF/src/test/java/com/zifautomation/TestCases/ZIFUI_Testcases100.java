package com.zifautomation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.CMPLandingpage;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAIOpportunityCardsPage;
import com.zifautomation.Pages.ZIFAIPredictionPage;
import com.zifautomation.Pages.ZIFAIPrediction_DeviceConfigPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import bsh.Console;

public class ZIFUI_Testcases100 extends Base {

	// PreRequsite
	PropertiesFileReader obj= new PropertiesFileReader();
	Properties properties = null;
	WebDriverWait wait1=null;


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
			
			driver.navigate().refresh();
			Thread.sleep(2000);
			
			  //Predicted Risk (Warning) opportunity cards 
			try { 
				wait1= new WebDriverWait(driver, 5);
				WebElement Card1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-cards warn-state')][1]")));
				//WebElement Card1 =driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-cards warn-state')][1]"));
				if(Card1.isDisplayed()) 
				{ 
				  test.log(Status.PASS,"Predicted Risk (Warning) opportunity cards are displayed");
				  
			  new ZIFAIPredictionPage(driver).verifyWarningOppcardDetails();
			  Thread.sleep(2000);
			  test.log(Status.PASS,"Predicted Risk (Warning) opportunity cards fields are verified");
			  
			  WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);
			  
				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
			  test.log(Status.PASS,"Successfuly verified Predicted Risk (Warning) opportunity cards data flow");
			  
			  } }catch (Exception e) { 
				  test.log(Status.SKIP,"Predicted Risk (Warning) opportunity cards are Not available"); 
				  }
			  
			  try {
				  WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'no-data-cls')]")); 
			  if(Nodata1.isDisplayed()) 
			  { 
				  test.log(Status.PASS,"No Data available is displayed in Predicted Risk (Warning)"); } }catch
			  (Exception e) { }
			  
			  
			  //Currently at Risk (Critical) opportunity cards 
			  try {
				  wait1= new WebDriverWait(driver, 5);
				  WebElement Card2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-cards critical-state')][1]")));
				  //WebElement Card2 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-cards critical-state')][1]"));
			  if(Card2.isDisplayed()) 
			  { 
				  test.log(Status.
			  PASS,"Currently at Risk (Critical) opportunity cards are displayed");
			  
			  new ZIFAIPredictionPage(driver).verifyCriticalOppcardDetails();
			  Thread.sleep(2000);
			  test.log(Status.
			  PASS,"Currently at Risk (Critical) opportunity cards fields are verified");
			  
			  WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);
			  
				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
			  test.log(Status.PASS,"Successfuly verified Currently at Risk (Critical) opportunity cards data flow");
			  } 
			  }catch (Exception e) { 
				  test.log(Status.SKIP,"Currently at Risk (Critical) opportunity cards are Not available"); 
			  }
			  
			  try { 
				  WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'no-data-cls')]")); 
			  if(Nodata1.isDisplayed()) 
			  { 
				  test.log(Status.PASS,"No Data available is displayed in Currently at Risk (Critical)");
			  }
			  }catch (Exception e) { }
			  
			  
			  //Processsed opportunity cards 
			  try { 
				  wait1= new WebDriverWait(driver, 5);
				  WebElement Card3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-cards processed-state')][1]")));
				  // WebElement Card3 =driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-cards processed-state')][1]"));

				  if(Card3.isDisplayed()) {
					  test.log(Status.PASS,"Processed opportunity cards are displayed");

					  new ZIFAIPredictionPage(driver).verifyProcessedOppcardDetails();

					  test.log(Status.PASS,"Processed opportunity cards fields are verified");


			 
			  
			  WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-list-id')])[1]"));
				Cardnumber.click();
				Thread.sleep(2000);
				
				new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickCPU();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickMemory();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).clickDisk();
				Thread.sleep(3000);
				new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
				Thread.sleep(2000);
				new ZIFAIOpportunityCardsPage(driver).closeAd();
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfuly verified Processed opportunity cards data flow"); }
				  }catch
			  (Exception e) { 
				  test.log(Status.SKIP,"Processed opportunity cards are Not available"); 
				  }
			  
			  try { 
				  WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'no-data-cls')]"));
			  
			  if(Nodata1.isDisplayed()) 
			  {
			  test.log(Status.PASS,"No Data available is displayed in Processed"); 
			  }
			  }catch(Exception e) { }
			 
			
			//Lost opportunity cards
			try {
				wait1= new WebDriverWait(driver, 5);
				WebElement Card4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]")));
				//WebElement Card4 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]"));
				if(Card4.isDisplayed())
				{
					test.log(Status.PASS,"Lost opportunity cards are displayed");

					new ZIFAIPredictionPage(driver).verifyLostOppcardDetails();
					
					Thread.sleep(2000);
					test.log(Status.PASS,"Lost opportunity cards fields are verified");
					//driver.navigate().refresh();
					Thread.sleep(2000);
					WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-list-id')])[1]"));
					Cardnumber.click();
					Thread.sleep(2000);
					
					new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
					Thread.sleep(2000);
					new ZIFAIOpportunityCardsPage(driver).clickCPU();
					Thread.sleep(2000);
					new ZIFAIOpportunityCardsPage(driver).clickMemory();
					Thread.sleep(2000);
					new ZIFAIOpportunityCardsPage(driver).clickDisk();
					Thread.sleep(3000);
					new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
					Thread.sleep(2000);
					new ZIFAIOpportunityCardsPage(driver).closeAd();
					Thread.sleep(2000);
					test.log(Status.PASS,"Successfuly verified Lost opportunity cards data flow");
				}
			}catch (Exception e) {
				test.log(Status.SKIP, "Lost opportunity cards are Not available");
			}

			try {					
				WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'no-data-cls')]"));
				if(Nodata1.isDisplayed())
				{
					test.log(Status.PASS,"No Data available is displayed in Lost");
				}
			}catch (Exception e) {
			}
			
			
			
			//Invalid opportunity cards
			try {
				wait1= new WebDriverWait(driver, 5);
				WebElement Card5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-cards invalid-state')][1]")));
				//WebElement Card5 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-cards invalid-state')][1]"));
				if(Card5.isDisplayed())
				{
					test.log(Status.PASS,"Invalid opportunity cards are displayed");

					new ZIFAIPredictionPage(driver).verifyInvalidOppcardDetails();
					Thread.sleep(2000);
					test.log(Status.PASS,"Invalid opportunity cards fields are verified");
					//driver.navigate().refresh();
					Thread.sleep(2000);
					WebElement Cardnumber = driver.findElement(By.xpath("((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-list-id')])[1]"));
					Cardnumber.click();
					Thread.sleep(2000);
					
					new ZIFAIOpportunityCardsPage(driver).CheckallfieldsinOpportunityCards();
					Thread.sleep(2000);
					new ZIFAIOpportunityCardsPage(driver).clickCPU();
					Thread.sleep(2000);
					new ZIFAIOpportunityCardsPage(driver).clickMemory();
					Thread.sleep(2000);
					new ZIFAIOpportunityCardsPage(driver).clickDisk();
					Thread.sleep(3000);
					new ZIFAIOpportunityCardsPage(driver).showDiskdrivecheck();
					Thread.sleep(2000);
					new ZIFAIOpportunityCardsPage(driver).closeAd();
					Thread.sleep(2000);
					
					test.log(Status.PASS,"Successfuly verified Invalid opportunity cards data flow");
				}
			}catch (Exception e) {
				test.log(Status.SKIP, "Invalid opportunity cards are Not available");
			}

			try {					
				WebElement Nodata1 = driver.findElement(By.xpath("(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'no-data-cls')]"));
				if(Nodata1.isDisplayed())
				{
					test.log(Status.PASS,"No Data available is displayed in Invalid");
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




