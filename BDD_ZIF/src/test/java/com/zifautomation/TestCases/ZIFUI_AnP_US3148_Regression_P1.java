package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIAppSettingsPage;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class ZIFUI_AnP_US3148_Regression_P1 extends Base {

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
			Thread.sleep(3000);
			test.log(Status.PASS, "Analytics link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

//		//Test Case 5365 - Case count verification based on the
//		// inputs given under filters or preferences in both sections
		try {
			if(new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()){
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
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

		//----------------------------------------------------------------//

		//Report Initialization
		test = extent.createTest("US - 5361 Verify the display of other Cases in case dashboard screen when enable case prioritization is enabled in preferences");
		test.createNode("US - 5361 Verify the display of other Cases in case dashboard screen when enable case prioritization is enabled in preferences");

		//Verify the display of other Cases in case dashboard screen when enable case prioritization is enabled in preferences other case verification//
		//Priority and other case split up count//

		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).threedoticonor).perform();
			Thread.sleep(3000);
			String Prioritycnt = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText();
			Thread.sleep(3000);
			String othercnt = new ZIFAI_CaseManagementPage(driver).Othercasecount.getText();
			Thread.sleep(3000);
			test.log(Status.PASS, "Priority and other case count split up: "+Prioritycnt +othercnt);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover pattern based threshold detail");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify Bell icon,Severity icon ,Case Status icon , ZIF Case id ,Created Date , Updated Date
		//Closed Date , Correlated alerts count , Three dot icon, Acknowledge ,Export , Notes ,
		//Recommend Solution , Three dot icon.

		try {
			Boolean Belliconval = new ZIFAI_CaseManagementPage(driver).Belliconor.isDisplayed();
			Boolean Severityiconval = new ZIFAI_CaseManagementPage(driver).severityiconor.isDisplayed();
			Boolean Casestatusval = new ZIFAI_CaseManagementPage(driver).Casestatuiconor.isDisplayed();
			Boolean Createdteval = new ZIFAI_CaseManagementPage(driver).createddateor.isDisplayed();
			Boolean Updateval = new ZIFAI_CaseManagementPage(driver).updateddateor.isDisplayed();
			String Crltdcntval = new ZIFAI_CaseManagementPage(driver).correlatedalertor.getText();
			Boolean Threedoticnval = new ZIFAI_CaseManagementPage(driver).threedoticonor.isDisplayed();
			Boolean Acknowledgeval = new ZIFAI_CaseManagementPage(driver).acknowledgeor.isDisplayed();
			Boolean Exportval = new ZIFAI_CaseManagementPage(driver).exportor.isDisplayed();
			Boolean Notesval = new ZIFAI_CaseManagementPage(driver).notesor.isDisplayed();
			Boolean Recommendsolval = new ZIFAI_CaseManagementPage(driver).recommendor.isDisplayed();
			Boolean Threedtval = new ZIFAI_CaseManagementPage(driver).threedotor.isDisplayed();
			test.log(Status.PASS, "Bell icon is displayed for other cases: "+Belliconval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Severity is displayed for other cases: "+Severityiconval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Case status is displayed other case: "+Casestatusval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Create date is displayed for other case: "+Createdteval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Updated date is displayed for other case: "+Updateval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Correlated count is displayed for other case: "+Crltdcntval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Three dot icon is displayed for other case: "+Threedoticnval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Acknowledge is displayed for other case: "+Acknowledgeval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Export is displayed for other case: "+Exportval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Notes is displayed for other case: "+Notesval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Recommend is displayed for other case: "+Recommendsolval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			test.log(Status.PASS, "Three dot value is displayed for other case: "+Threedtval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to validate the values in Prioritisation page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify Servers, Tool Name, Application Name, Avg Estimated to Resolve,
		// Estimated Time to Complete, False Probability, Correlation Accuracy, Pattern Based Threshold
		//is displayed after clicking on the three dots
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
			test.log(Status.PASS, "Three dots is hovered below the bell icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean Serversval = new ZIFAI_CaseManagementPage(driver).Serveror.isDisplayed();
			test.log(Status.PASS, "Server icon is displayed after hovering : "+Serversval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean Toolnameval = new ZIFAI_CaseManagementPage(driver).Toolnameor.isDisplayed();
			test.log(Status.PASS, "Tool icon is displayed after hovering: "+Toolnameval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean Appnameval = new ZIFAI_CaseManagementPage(driver).Appnameor.isDisplayed();
			test.log(Status.PASS, "Application icon is displayed after hovering: "+Appnameval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean Avgestval = new ZIFAI_CaseManagementPage(driver).Avgesttimeor.isDisplayed();
			test.log(Status.PASS, "Avg Estimated to resolve icon is displayed after hovering: "+Avgestval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean etival = new ZIFAI_CaseManagementPage(driver).ETItimeor.isDisplayed();
			test.log(Status.PASS, "Estimated time to complete icon is displayed after hovering:: "+etival);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean falseprbval = new ZIFAI_CaseManagementPage(driver).Falseprbor.isDisplayed();
			test.log(Status.PASS, "Falsepr is displayed: "+falseprbval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean corrlatnval = new ZIFAI_CaseManagementPage(driver).Correlationor.isDisplayed();
			test.log(Status.PASS, "Correlation is displayed: "+corrlatnval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Boolean patternbsdval = new ZIFAI_CaseManagementPage(driver).Patternbasedor.isDisplayed();
			test.log(Status.PASS, "Pattern based is displayed: "+patternbsdval);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (AssertionError|Exception e){
			test.log(Status.FAIL, "Unable to validate the values in Prioritisation page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Mouse hover the recommended solution icon//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).recommendor).perform();
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
			test.log(Status.PASS, "Mouse hovered the recommended solution");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover the recommended solution");
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
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).Casestatuiconor).perform();
			test.log(Status.PASS, "Mouse hovered the other case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover the other case status");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Mouse hover the Created Date//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).createddateor).perform();
			test.log(Status.PASS, "Mouse hovered the create date in other");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover the create date in other");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Mouse hover the updated date//
		try {
			Actions act = new Actions(driver);
			act.moveToElement(new ZIFAI_CaseManagementPage(driver).updateddateor).perform();
			test.log(Status.PASS, "Mouse hovered the other case Updated date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover the updated date in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//----------------------------------------------------------------------//

		//Report Initialization
		test = extent.createTest("US - 5321 Ensure the Display prioritized cases option is present in Preferences");
		test.createNode("US - 5321 Ensure the Display prioritized cases option is present in Preferences");

		//Click the Preferences icon and ensure the Display prioritized cases option is present in Preferences

	      try {
			  if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
			  	Thread.sleep(2000);
				  new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				  Thread.sleep(2000);
				  new ZIFAI_CaseManagementPage(driver).enablepriority.isDisplayed();
				  JavascriptExecutor jste = (JavascriptExecutor)driver;
				  jste.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Prefcancel);
				  test.addScreenCaptureFromPath(captureScreenShot(driver));
				  Thread.sleep(3000);
				  test.log(Status.PASS, "Display prioritized cases option is present in preference");
				  test.addScreenCaptureFromPath(captureScreenShot(driver));
			  }
			else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				  Thread.sleep(2000);
				  new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				  Thread.sleep(2000);
					  new ZIFAI_CaseManagementPage(driver).enablepriority.isDisplayed();
				  Thread.sleep(2000);
				  JavascriptExecutor jste = (JavascriptExecutor)driver;
				  jste.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Prefcancel);
				  test.log(Status.PASS, "Display prioritized cases option is present in preference");
				  test.addScreenCaptureFromPath(captureScreenShot(driver));
				  }
			  } catch(AssertionError | Exception e){
				  test.log(Status.FAIL, "Display prioritized cases option is not present in preference");
				  test.addScreenCaptureFromPath(captureScreenShot(driver));
			  }

	//--------------------------------------US 5321-------------------------------------------//

		//Report Initialization
		test = extent.createTest("US - 5557 Verify the Priority Cases are displayed based on the Ageing days");
		test.createNode("US - 5557 Verify the Priority Cases are displayed based on the Ageing days");

		//Verify the Priority Cases are displayed based on the Ageing days//
		//Enter Ageing value in Ageing text box from platform mangement//

		try {
			new ZIFAIAppSettingsPage(driver).settingsIcon.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).PlatformManagementtab.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Caseprioritization.click();
			Thread.sleep(3000);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			WebElement text = driver.findElement(By.xpath("//input[@type='number']"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='12';", text);
			test.log(Status.PASS, "User is able to enter ageing days value in text box");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			WebElement textsve = driver.findElement(By.xpath("//span[text()='Save']"));
			JavascriptExecutor jst = (JavascriptExecutor)driver;
			jst.executeScript("arguments[0].click();", new ZIFAIAppSettingsPage(driver).savebutton);
			test.log(Status.PASS, "User is able to click save button after entering ageing duration");
			Thread.sleep(3000);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch(AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to enable prioritized cases option in preference with ageing option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Go to Case Management screen and verify the Prioritized
		// cases are displayed as per ageing days defined in the text field


		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			Thread.sleep(3000);
			new ZIFAIDashboardPage(driver).clickAnalytics();
			Thread.sleep(6000);
			String createddatestr = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText();
			test.log(Status.PASS, "After applying ageing verifying the count:" +createddatestr);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the ageing function");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//--------------------------End of US 5557---------------------------------------------//
		//Report Initialization
		test = extent.createTest("US - 5558 Verify the Priority Cases are displayed based on the customer/category drop down present ");
		test.createNode("US - 5558 Verify the Priority Cases are displayed based on the customer/category drop down present ");

		//Click the Case Prioritization menu. Click the "select Customer/category" drop-down to select all option and click the save button

		try {
			new ZIFAIAppSettingsPage(driver).settingsIcon.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).PlatformManagementtab.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Caseprioritization.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).customerdropdwn.click();
			WebElement element = driver.findElement(By.xpath("/html/body/app-root/app-home-header/div/div[2]/app-settings/div[2]/app-platform-management/div/div[2]/div/app-case-prioritisation/div/div[2]/div[1]/div[2]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[1]/li/div/div"));
            JavascriptExecutor jste = (JavascriptExecutor)driver;
			jste.executeScript("arguments[0].click();",element);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			JavascriptExecutor jsted = (JavascriptExecutor)driver;
			jsted.executeScript("arguments[0].click();",new ZIFAIAppSettingsPage(driver).savebutton);
			test.log(Status.PASS, "Selected one checkbox in customer dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch(AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to select checkbox");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Go to Case Management screen and verify the Prioritized
		// cases are displayed as per customer value defined in the text field
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			Thread.sleep(3000);
			new ZIFAIDashboardPage(driver).clickAnalytics();
			Thread.sleep(7000);
			String createddatestr = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText();
			test.log(Status.PASS, "After applying customer value verify the count:" +createddatestr);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Click the Case Prioritization menu. Click the "select Customer/category" drop-down and clear value and the save button
		try {
			new ZIFAIAppSettingsPage(driver).settingsIcon.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).PlatformManagementtab.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Caseprioritization.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).customerdropdwn.click();
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("/html/body/app-root/app-home-header/div/div[2]/app-settings/div[2]/app-platform-management/div/div[2]/div/app-case-prioritisation/div/div[2]/div[1]/div[2]/p-multiselect/div/div[4]/div[1]/div[1]/div[2]"));
			JavascriptExecutor jste = (JavascriptExecutor)driver;
			jste.executeScript("arguments[0].click();",element);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			JavascriptExecutor jsted = (JavascriptExecutor)driver;
			jsted.executeScript("arguments[0].click();",new ZIFAIAppSettingsPage(driver).savebutton);
			test.log(Status.PASS, "Cleared one checkbox in customer dropdown");
			Thread.sleep(3000);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch(AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to select checkbox");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Go to Case Management screen and verify the Prioritized
		// cases are displayed after clearing the values in customer


		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			Thread.sleep(3000);
			new ZIFAIDashboardPage(driver).clickAnalytics();
			Thread.sleep(7000);
			String createddatestr = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText();
			test.log(Status.PASS, "After applying customer value verify the count:" +createddatestr);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------End of US5558-------------------------------------//

		//Report Initialization
		test = extent.createTest("US - 5559 Verify the Priority Cases are displayed based on the Priority based on text in alert description ");
		test.createNode("US - 5559 Verify the Priority Cases are displayed based on the Priority based on text in alert description");

		//Alert description (OH)/(UH)/(CRC)/(DISCARD) in the text box provided in Priority based on text in alert description and click the save button//
		//Special characters are not allowed//
		try {
            new ZIFAIAppSettingsPage(driver).settingsIcon.click();
            Thread.sleep(3000);
            new ZIFAIAppSettingsPage(driver).PlatformManagementtab.click();
            Thread.sleep(3000);
            new ZIFAIAppSettingsPage(driver).Caseprioritization.click();
            Thread.sleep(3000);
            new ZIFAIAppSettingsPage(driver).alertdesc.clear();
            Thread.sleep(3000);
            new ZIFAIAppSettingsPage(driver).alertdesc.sendKeys("Test");
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", new ZIFAIAppSettingsPage(driver).savebutton);
            test.log(Status.PASS, "Alert desc is added in the text box and saved");
            test.addScreenCaptureFromPath(captureScreenShot(driver));
            Thread.sleep(3000);
        }catch(AssertionError | Exception e){
            test.log(Status.FAIL, "Unable to add alert in desc and save");
            test.addScreenCaptureFromPath(captureScreenShot(driver));
        }


		//Go to Case Management screen and verify the Prioritized
		// cases are displayed with description
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			Thread.sleep(3000);
			new ZIFAIDashboardPage(driver).clickAnalytics();
			Thread.sleep(7000);
			String createddatestr = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText();
			test.log(Status.PASS, "After applying customer value verify the count:" +createddatestr);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clear the Alert description (OH)/(UH)/(CRC)/(DISCARD) in the text box provided in Priority based on text in alert description and click the save button//
		try {
			new ZIFAIAppSettingsPage(driver).settingsIcon.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).PlatformManagementtab.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Caseprioritization.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).alertdesc.clear();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).alertdesc.clear();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", new ZIFAIAppSettingsPage(driver).savebutton);
			test.log(Status.PASS, "Alert desc is added in the text box and saved");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}catch(AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to add alert in desc and save");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Go to Case Management screen and verify the Prioritized
		// cases are displayed with description
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			Thread.sleep(3000);
			new ZIFAIDashboardPage(driver).clickAnalytics();
			Thread.sleep(7000);
			String createddatestr = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText();
			test.log(Status.PASS, "After applying customer value verify the count:" +createddatestr);
			Thread.sleep(3000);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//--------------------------End of US 5559--------------------------------------------//
		//Report Initialization
		test = extent.createTest("US - 5560 Verify the Priority Cases are displayed based on the Element Seniority options ");
		test.createNode("US - 5560 Verify the Priority Cases are displayed based on the Element Seniority options");

		//Click the Case Prioritization menu. Click the "select & Verify the Priority Cases are displayed based on the Element Seniority options
		try {
			new ZIFAIAppSettingsPage(driver).settingsIcon.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).PlatformManagementtab.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Caseprioritization.click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement elementu = driver.findElement(By.xpath("/html/body/app-root/app-home-header/div/div[2]/app-settings/div[2]/app-platform-management/div/div[2]/div/app-case-prioritisation/div/div[2]/div[3]/div[2]/p-multiselect/div/div[3]/span"));
			js.executeScript("arguments[0].click();",elementu);
			WebElement element = driver.findElement(By.xpath("/html/body/app-root/app-home-header/div/div[2]/app-settings/div[2]/app-platform-management/div/div[2]/div/app-case-prioritisation/div/div[2]/div[3]/div[2]/p-multiselect/div/div[4]/div[1]/div[1]/div[2]/span"));
			JavascriptExecutor jste = (JavascriptExecutor)driver;
			jste.executeScript("arguments[0].click();",element);
			Thread.sleep(3000);
			JavascriptExecutor jst = (JavascriptExecutor)driver;
			jst.executeScript("arguments[0].click();", new ZIFAIAppSettingsPage(driver).savebutton);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			test.log(Status.PASS, "Element Seniority is added up");
		}catch(AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to select Element Seniority");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Go to Case Management screen and verify the Prioritized
		// cases are displayed as Element Seniority
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			Thread.sleep(3000);
			new ZIFAIDashboardPage(driver).clickAnalytics();
			Thread.sleep(7000);
			String createddatestr = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText();
			test.log(Status.PASS, "After applying customer value verify the count:" +createddatestr);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Click the Case Prioritization menu. Clear the option from Element Seniority and click save button
		try {
			new ZIFAIAppSettingsPage(driver).settingsIcon.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).PlatformManagementtab.click();
			Thread.sleep(3000);
			new ZIFAIAppSettingsPage(driver).Caseprioritization.click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement elementu = driver.findElement(By.xpath("/html/body/app-root/app-home-header/div/div[2]/app-settings/div[2]/app-platform-management/div/div[2]/div/app-case-prioritisation/div/div[2]/div[3]/div[2]/p-multiselect/div/div[3]/span"));
			js.executeScript("arguments[0].click();",elementu);
			WebElement element = driver.findElement(By.xpath("/html/body/app-root/app-home-header/div/div[2]/app-settings/div[2]/app-platform-management/div/div[2]/div/app-case-prioritisation/div/div[2]/div[3]/div[2]/p-multiselect/div/div[4]/div[1]/div[1]/div[2]/span"));
			JavascriptExecutor jste = (JavascriptExecutor)driver;
			jste.executeScript("arguments[0].click();",element);
			Thread.sleep(3000);
			JavascriptExecutor jst = (JavascriptExecutor)driver;
			jst.executeScript("arguments[0].click();", new ZIFAIAppSettingsPage(driver).savebutton);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
			test.log(Status.PASS, "Element Seniority is added up");
		}catch(AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to select Element Seniority");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Go to Case Management screen and verify the Prioritized
		// cases are displayed as per ageing days defined in the text field
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			Thread.sleep(3000);
			new ZIFAIDashboardPage(driver).clickAnalytics();
			Thread.sleep(7000);
			String createddatestr = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText();
			test.log(Status.PASS, "After applying Element Seniority verify the count:" +createddatestr);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the count");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//---------------------------------End of US 5559 --------------------------------//
		//Report Initialization
		test = extent.createTest("US 5561 - Verify the split up screen is matching the design ");
		test.createNode("US - 5561 Verify the split up screen is matching the design");

		//Verify the Priority Case split up //
		try{
			Thread.sleep(6000);
			String prioritysize = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getCssValue("font-size");
			test.log(Status.PASS, "Priority case size" +prioritysize);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the size of Priority");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the other Case split up //
		try{
			Thread.sleep(6000);
			String prioritysize = new ZIFAI_CaseManagementPage(driver).Othercasecount.getCssValue("font-size");
			test.log(Status.PASS, "Other case size" +prioritysize);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify the size of Priority");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//Verify the user is able to enable the Display prioritized cases option in preferences and click save button

		try {
			if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
				JavascriptExecutor jste = (JavascriptExecutor)driver;
				jste.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).enablepriority);
				Thread.sleep(3000);
				JavascriptExecutor jstey = (JavascriptExecutor)driver;
				jstey.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Applybutton);

				test.log(Status.PASS, "Enabled prioritized cases option in preference");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			}
			else if (new ZIFAI_CaseManagementPage(driver).prefereceIcon.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).prefereceIcon.click();
				Thread.sleep(3000);
				JavascriptExecutor jste = (JavascriptExecutor)driver;
				jste.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).enablepriority);
				JavascriptExecutor jstey = (JavascriptExecutor)driver;
				jstey.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(6000);
			}
		} catch(AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to enable prioritized cases option in preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Threshold must not be defined Once enabled the option -US 5321
		// Verify the case management screen - US 5321

		try {
			if (new ZIFAI_CaseManagementPage(driver).prefereceIcon.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).prefereceIcon.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).enablepriority.isDisplayed();
				Thread.sleep(3000);
				Boolean thrholdk = new ZIFAI_CaseManagementPage(driver).Thresholdenablefalse.isDisplayed();
				Thread.sleep(3000);
				Boolean thrhold = new ZIFAI_CaseManagementPage(driver).Thresholdhidefalse.isDisplayed();
				Thread.sleep(3000);
				JavascriptExecutor jste = (JavascriptExecutor)driver;
				jste.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Prefcancel);
				test.log(Status.PASS, "Thresholdenablefalse hide false is disabled:" +thrholdk);
				test.log(Status.PASS, "Thresholdhidefalse hide false is disabled:" +thrhold );
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).enablepriority.isDisplayed();
				Thread.sleep(3000);
				Boolean thrholdk = new ZIFAI_CaseManagementPage(driver).Thresholdenablefalse.isDisplayed();
				Thread.sleep(3000);
				Boolean thrholdfl = new ZIFAI_CaseManagementPage(driver).Thresholdhidefalse.isDisplayed();
				JavascriptExecutor jste = (JavascriptExecutor)driver;
				jste.executeScript("arguments[0].click();",new ZIFAI_CaseManagementPage(driver).Prefcancel);
				test.log(Status.PASS, "Threshold hide false is disabled:" +thrholdk);
				test.log(Status.PASS, "Threshold hide false is disabled:" +thrholdfl);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch(AssertionError | Exception e){
			test.log(Status.FAIL, "Unable to verify threshold option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}







	}
}


