package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.mongodb.client.FindIterable;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.*;
import com.zifautomation.Utility.MongoQueryManager;
import com.zifautomation.Utility.PropertiesFileReader;
import org.bson.Document;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;


public class ZIFUI_AnP_US3148_Regression extends Base {

	 //PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;


	@Test
	public void ZIFUI_AnP_US3148_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("Prioritization of cases - Case Management");
		test.createNode("Prioritization of cases - Case Management");

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

		//click on the analytics link
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickAnalytics();
			test.log(Status.PASS, "Analytics link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//		//Test Case 5365 - Case count verification based on the
//		// inputs given under filters or preferences in both sections
		Thread.sleep(3000);
		try {
			if(new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()){
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Preference Tab");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try {
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.clear();
			Thread.sleep(3000);
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[11]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: "+status);
			Thread.sleep(3000);
			if(status==true) {
				test.log(Status.PASS, "Priority is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			}
			else if (status==false) {
				WebElement valuet =  driver.findElement(By.xpath("//span[text()='Enable Case Prioritization']//..//span[@class='ui-inputswitch-slider']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",valuet);
				Thread.sleep(3000);
				JavascriptExecutor jst = (JavascriptExecutor) driver;
				jst.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				test.log(Status.PASS, "Priority option is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			} }catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Priority option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Report Initialization
		test = extent.createTest("US - 5365 Case count verification based on the inputs given under preferences in both sections");
		test.createNode("US - 5365 Case count verification based on the inputs given under preferences in both sections");

		//User must select any Search Filters before selecting the Export icon.
		//Device Name, Tool name, Severity, Alert Description, Created On, Case ID, Application Name
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("New");
			test.log(Status.PASS, "Clicked on Preference Tab and entered New as case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Preference Tab");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the Case count after applying filter preference//
		try {
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			Thread.sleep(3000);
			System.out.println("Overall_Case_count:" + Case_count1);
			test.log(Status.PASS, "Total case count: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the case count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//US 5365 Clear the values in preference and click apply//

		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			test.log(Status.PASS, "Clicked on Preference Tab and cleared values");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Preference Tab and clear values");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the case count after clearing the filter value//
		try {
			Thread.sleep(2000);
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Overall_Case_count:" + Case_count1);
			test.log(Status.PASS, "Updated Total case count: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the case count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Livefeed is paused // US 5363
		//Both Priority cases and Other cases : New Alerts flow should be
		// stopped and the user should not be seeing the new alerts flowing in.

		//Report Initialization
		test = extent.createTest("US - 5363 Verify the Live Feed is applied to both Priority cases and other cases");
		test.createNode("US - 5365 Verify the Live Feed is applied to both Priority cases and other cases");

		try {
			if (new ZIFAI_CaseManagementPage(driver).livefeedon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).livefeedon.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Live Feed is paused");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).livefeedoff.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).livefeedoff.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).livefeedon.click();
				test.log(Status.PASS, "Live Feed is paused");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to Pause the feed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the Case count after pausing the live feed//
		try {
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			Thread.sleep(3000);
			System.out.println("Overall_Case_count:" + Case_count1);
			test.log(Status.PASS, "Total case count: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the case count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Livefeed is turned on // US 5363
		//Both Priority cases and Other cases : New Alerts flow should be
		// flow and the user should see the new alerts flowing in.

		try {

			new ZIFAI_CaseManagementPage(driver).livefeedoff.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "live feed is turned on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to switch on the live feed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the Case count after turning on the live feed//
		try {
			Thread.sleep(3000);
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Overall_Case_count:" + Case_count1);
			test.log(Status.PASS, "Total case count after turning live feed on: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the case count after turning live feed on");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Report Initialization
		test = extent.createTest("US - 5364 Verify the Case total count of Priority and Other cases in case management screen");
		test.createNode("US - 5364 Verify the Case total count of Priority and Other cases in case management screen");


		//Verify the Case total count of Priority and Other cases in case management screen//
		//Count of Priority US 5364 //
		try {
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(","").replace(")","").replace("All","").trim();
			Thread.sleep(3000);
			System.out.println("Priority Overall_Case_count:" + Case_count1);
			test.log(Status.PASS, "Priority Total case count: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the Priority case count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Count of other cases US 5364 //

		try {
			Thread.sleep(2000);
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Othercasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Other cases section overall_Case_count:" + Case_count1);
			test.log(Status.PASS, "Other cases section overall_Case_count: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the other cases section case count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Ensure the Case (N) total count is getting updated on every new
		//case ID in  Other cases section

		try {
			Thread.sleep(10000);
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Othercasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Count of other cases section after new case is pushed:" + Case_count1);
			test.log(Status.PASS, "Count of other cases section after new case is pushed: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the other cases section case count after new case is pushed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Ensure the Case (N) total count is getting updated on every new
		//case ID in  Priority cases section

		try {
			Thread.sleep(10000);
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Count of priority cases section after new case is pushed:" + Case_count1);
			test.log(Status.PASS, "Count of priority cases section after new case is pushed: " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the priority cases section case count after new case is pushed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Ensure the count is displayed in tooltip without any decimal value in other section//
		try {
			//Instantiate Action Class
			Actions actions = new Actions(driver);
			WebElement toolTip = driver.findElement(By.xpath("//span[@class='prior-first' and contains(text(),'Other')]"));
			Thread.sleep(3000);
			// Using the action class to mimic mouse hover
			actions.moveToElement(toolTip).perform();
			test.log(Status.PASS, "Other Case count is hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover the other count toolip");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//		//Ensure the count is displayed in tooltip without any decimal value in Priority section//
		try {
			//Instantiate Action Class
			Actions actions = new Actions(driver);
			WebElement toolTip = driver.findElement(By.xpath("//span[@class='prior-first' and contains(text(),'Priority')]"));
			Thread.sleep(2000);
			// Using the action class to mimic mouse hover
			actions.moveToElement(toolTip).perform();
			test.log(Status.PASS, "Priority Case status is hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover the Priority count toolip");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Report Initialization
		test = extent.createTest("US - 5362 Verify the cases displayed in Priority and Other cases are mutually exclusive");
		test.createNode("US - 5362 Verify the cases displayed in Priority and Other cases are mutually exclusive");

		try {
			Thread.sleep(10000);
			String Case_countst = new ZIFAI_CaseManagementPage(driver).Othercasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			String Case_countsty = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Count of other cases section after new case is pushed:" + Case_countst);
			test.log(Status.PASS, "Count of other cases section after new case is pushed: " + Case_countst);
			System.out.println("Count of other cases section after new case is pushed:" + Case_countsty);
			test.log(Status.PASS, "Count of other cases section after new case is pushed: " + Case_countsty);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch the other and priority cases section case count after new case is pushed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}




		//Verify the cases present in Other section are not displayed in Priority cases section
		try {
            List<WebElement> elementList = driver.findElements(By.xpath("//ngx-smart-loader[@identifier='rawAlertLoader']//..//div[@class='case-outer ng-star-inserted']"));
            Thread.sleep(2000);
            for (WebElement we : elementList) {
                String wee = we.getText().substring(0, 9).replace("|", "").replace("2020", "").trim();
                test.log(Status.PASS, "Priority cases id:" + wee);
                Thread.sleep(2000);
            }
		}
			catch (AssertionError | Exception e) {
				test.log(Status.PASS, "verified priority cases");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			try {
				List<WebElement> elementListp = driver.findElements(By.xpath("//*[@class=\"cases-full-outer-prior-ryt\"]/div"));
				Thread.sleep(2000);
				for (WebElement wep : elementListp) {
					String weept = wep.getText().substring(0, 9).replace("|", "").replace("2020", "").trim();
					test.log(Status.PASS, "Other cases id: " + weept);
				}
			}
			catch(AssertionError | Exception e){
					test.log(Status.PASS, "Verified other cases");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}


		//Report Initialization
		test = extent.createTest("US - 5555 Verify the options available in three dot icon present next to bell icon count");
		test.createNode("US - 5555 Verify the options available in three dot icon present next to bell icon count");

		//US 5555 & US 5556- Verify the options available in three dot icon present next to bell icon count

		//Mouse hover the bell icon and verify the count after clicking on three dots .
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Belliconpr).perform();
			test.log(Status.PASS, "Bell icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover bell icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Mouse hover below the bell icon for count and verify the count after clicking on three dots .
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Bellcountpr).perform();
			test.log(Status.PASS, "Bell icon count is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover bell icon count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the three dot icon present next to bell icon count and verify the server icon.
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
			test.log(Status.PASS, "Three dots icon is hovered in priority cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to hover three dots icon in priority cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the server icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Serverpr).perform();
			test.log(Status.PASS, "server icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover server icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the server names//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Servernamepr).perform();
			test.log(Status.PASS, "server name is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover server name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the tool icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolpr).perform();
			test.log(Status.PASS, "tool icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the tool names//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Toolnamepr).perform();
			test.log(Status.PASS, "tool name is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover tool name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the application icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Appnpr).perform();
			test.log(Status.PASS, "application icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover application icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the application names//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Appnamepr).perform();
			test.log(Status.PASS, "application name is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover application name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the avg est time icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Avgesttimepr).perform();
			test.log(Status.PASS, "avg est time icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover avg est time icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


//		//Mouse hover the avg est time detail//
//		try {
//			Actions act = new Actions(driver);
//			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
//			test.log(Status.PASS, "avg est time detail is mouse hovered");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//			Thread.sleep(2000);
//		} catch (AssertionError | Exception e) {
//			test.log(Status.FAIL, "Unable to mouse hover avg est time detail");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}


		//Mouse hover the est time to complete icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).ETItimepr).perform();
			test.log(Status.PASS, "est time to complete icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover est time to complete icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


//		//Mouse hover the est time to complete detail//
//		try {
//			Actions act = new Actions(driver);
//			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
//			test.log(Status.PASS, "est time to complete detail is mouse hovered");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		} catch (AssertionError | Exception e) {
//			test.log(Status.FAIL, "Unable to mouse hover est time to complete detail");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}



		//Mouse hover the false probability icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Falseprbpr).perform();
			test.log(Status.PASS, "false probability icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover false probability icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


//		//Mouse hover the false probability detail//
//		try {
//			Actions act = new Actions(driver);
//			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
//			test.log(Status.PASS, "false probability detail is mouse hovered");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		} catch (AssertionError | Exception e) {
//			test.log(Status.FAIL, "Unable to mouse hover false probability detail");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}

		//Mouse hover the correlation accuracy icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Correlationpr).perform();
			test.log(Status.PASS, "correlation accuracy icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover correlation accuracy icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


//		//Mouse hover the correlation accuracy detail//
//		try {
//			Actions act = new Actions(driver);
//			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
//			test.log(Status.PASS, "correlation accuracy detail is mouse hovered");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		} catch (AssertionError | Exception e) {
//			test.log(Status.FAIL, "Unable to mouse hover correlation accuracy detail");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}


		//Mouse hover the pattern based threshold icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Patternbasedpr).perform();
			test.log(Status.PASS, "pattern based threshold icon is mouse hovered");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover correlation accuracy icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//
//		//Mouse hover the pattern based threshold detail//
//		try {
//			Actions act = new Actions(driver);
//			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
//			test.log(Status.PASS, "pattern based threshold detail is mouse hovered");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		} catch (AssertionError | Exception e) {
//			test.log(Status.FAIL, "Unable to mouse hover pattern based threshold detail");
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}

		//Report Initialization
		test = extent.createTest("US - 5360 Verify the display of Priority Cases in case dashboard screen when enable case prioritization is enabled in preferences");
		test.createNode("US - 5360 Verify the display of Priority Cases in case dashboard screen when enable case prioritization is enabled in preferences");

		//Verify the display of Priority Cases in case dashboard screen when enable case prioritization is enabled in preferences
		//-------Priority case verification----------//

		//Priority and other case split up count//

		try {
			String Prioritycnt = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText();
			Thread.sleep(2000);
			String othercnt = new ZIFAI_CaseManagementPage(driver).Othercasecount.getText();
			test.log(Status.PASS, "Priority and other case count split up: "+Prioritycnt +othercnt);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover pattern based threshold detail");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify Bell icon,Severity icon ,Case Status icon , ZIF Case id ,Created Date , Updated Date
		//Closed Date , Correlated alerts count , Three dot icon, Acknowledge ,Export , Notes ,
		//Recommend Solution , Three dot icon.

		try {
			Boolean Belliconval = new ZIFAI_CaseManagementPage(driver).Belliconpr.isDisplayed();
			Thread.sleep(2000);
			Boolean Severityiconval = new ZIFAI_CaseManagementPage(driver).severityiconpr.isDisplayed();
			Thread.sleep(2000);
			Boolean Casestatusval = new ZIFAI_CaseManagementPage(driver).Casestatuiconpr.isDisplayed();
			Thread.sleep(2000);
			Boolean Createdteval = new ZIFAI_CaseManagementPage(driver).createddatepr.isDisplayed();
			Thread.sleep(2000);
			Boolean Updateval = new ZIFAI_CaseManagementPage(driver).updateddatepr.isDisplayed();
			Thread.sleep(2000);
			String Crltdcntval = new ZIFAI_CaseManagementPage(driver).correlatedalertpr.getText();
			Thread.sleep(2000);
			Boolean Threedoticnval = new ZIFAI_CaseManagementPage(driver).threedoticonpr.isDisplayed();
			Thread.sleep(2000);
			Boolean Acknowledgeval = new ZIFAI_CaseManagementPage(driver).acknowledgepr.isDisplayed();
			Thread.sleep(2000);
			Boolean Exportval = new ZIFAI_CaseManagementPage(driver).exportpr.isDisplayed();
			Thread.sleep(2000);
			Boolean Notesval = new ZIFAI_CaseManagementPage(driver).notespr.isDisplayed();
			Thread.sleep(2000);
			Boolean Recommendsolval = new ZIFAI_CaseManagementPage(driver).recommendpr.isDisplayed();
			Thread.sleep(2000);
			Boolean Threedtval = new ZIFAI_CaseManagementPage(driver).threedotpr.isDisplayed();
			Thread.sleep(2000);
			test.log(Status.PASS, "Bell icon is displayed: "+Belliconval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Severity icon is displayed: "+Severityiconval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Case status is displayed: "+Casestatusval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Create date is displayed: "+Createdteval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Updated date is displayed: "+Updateval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Correlation is displayed: "+Crltdcntval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Three dot is displayed: "+Threedoticnval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Acknowledge is displayed: "+Acknowledgeval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Export is displayed: "+Exportval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Notes is displayed: "+Notesval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Recommend is displayed: "+Recommendsolval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Three dot is displayed: "+Threedtval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to validate the values in Priority case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify Servers, Tool Name, Application Name, Avg Estimated to Resolve,
		// Estimated Time to Complete, False Probability, Correlation Accuracy, Pattern Based Threshold
		//is displayed after clicking on the three dots
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
			test.log(Status.PASS, "Three dots is hovered below the bell icon");
			Thread.sleep(3000);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean Serversval = new ZIFAI_CaseManagementPage(driver).Serverpr.isDisplayed();
			test.log(Status.PASS, "Server icon is displayed after hovering : "+Serversval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean Toolnameval = new ZIFAI_CaseManagementPage(driver).Toolnamepr.isDisplayed();
			test.log(Status.PASS, "Tool icon is displayed after hovering: "+Toolnameval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean Appnameval = new ZIFAI_CaseManagementPage(driver).Appnamepr.isDisplayed();
			test.log(Status.PASS, "Application icon is displayed after hovering: "+Appnameval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean Avgestval = new ZIFAI_CaseManagementPage(driver).Avgesttimepr.isDisplayed();
			test.log(Status.PASS, "Avg Estimated to resolve icon is displayed after hovering: "+Avgestval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean etival = new ZIFAI_CaseManagementPage(driver).ETItimepr.isDisplayed();
			test.log(Status.PASS, "Estimated time to complete icon is displayed after hovering:: "+etival);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean falseprbval = new ZIFAI_CaseManagementPage(driver).Falseprbpr.isDisplayed();
			test.log(Status.PASS, "False probability is displayed "+falseprbval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean corrlatnval = new ZIFAI_CaseManagementPage(driver).Correlationpr.isDisplayed();
			test.log(Status.PASS, "correlated is displayed: "+corrlatnval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean patternbsdval = new ZIFAI_CaseManagementPage(driver).Patternbasedpr.isDisplayed();
			test.log(Status.PASS, "Pattern is displayed: "+patternbsdval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (AssertionError|Exception e){
			test.log(Status.FAIL, "Unable to validate the values in Prioritisation page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Mouse hover the recommended solution icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).recommendpr).perform();
			test.log(Status.PASS, "Mouse hovered the recommended solution");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover the recommended solution");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the total cases in priority//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritycasecount).perform();
			test.log(Status.PASS, "Mouse hovered over total cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover the total cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Mouse hover the severity indication//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).severityiconpr).perform();
			test.log(Status.PASS, "Mouse hovered the recommended solution");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover the recommended solution");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the case status//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Casestatuiconpr).perform();
			test.log(Status.PASS, "Mouse hovered the priority case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover the priority case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the Created Date//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).createddatepr).perform();
			test.log(Status.PASS, "Mouse hovered create date in Priority");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover Priority case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the updated date//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).updateddatepr).perform();
			test.log(Status.PASS, "Mouse hovered the updated date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover the updated date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Scroll down the case ID's via scroll bar and verify the all the case ID's are displayed//


		try {
			List<WebElement> casestatus = new ZIFAI_CaseManagementPage(driver).CaseStatuslist;
			List<WebElement> case_status = new ZIFAI_CaseManagementPage(driver).CaseStatuslist;
			for (int i = 0; i < casestatus.size(); i++) {
				System.out.println(casestatus.size());
				Actions action = new Actions(driver);
				Thread.sleep(2000);
				action.moveToElement(case_status.get(i)).perform();
				WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
				String Casestatustooltip = Case_status.getText();
				System.out.println("Casestatustooltip:" + Casestatustooltip);
					test.log(Status.PASS, "Scroll down towards the cases");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
		} catch (ArrayIndexOutOfBoundsException e) {
			test.log(Status.PASS, "End of Scroll");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (IndexOutOfBoundsException e) {
			test.log(Status.PASS, "End of Scroll");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (StaleElementReferenceException e) {
			test.log(Status.PASS, "End of Scroll");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.PASS, e);
			test.log(Status.PASS, "End of Scroll");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//----------------------------------------------------------------//







	}
}


