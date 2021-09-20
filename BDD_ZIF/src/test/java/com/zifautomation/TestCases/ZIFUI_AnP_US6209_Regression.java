package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;


public class ZIFUI_AnP_US6209_Regression extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;


	@Test
	public void ZIFUI_AnP_US6209_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("US 6209 - US 6575 - Update INFO/ACTION Flag for Cases");
		test.createNode("US 6209 - US 6575 -  Update INFO/ACTION Flag for Cases");


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

		//click on the Analytics link
		try {
			new ZIFAIDashboardPage(driver).hoveronAnalyzes();
			new ZIFAIDashboardPage(driver).clickAnalytics();
			test.log(Status.PASS, "Analytics is clicked");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to click analytics");
		}

		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
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

		//Disabling Prioritization//

		try {
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.clear();
			Thread.sleep(3000);
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[11]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == false) {
				test.log(Status.PASS, "Priority is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == true) {
				WebElement valuet = driver.findElement(By.xpath("//span[text()='Enable Case Prioritization']//..//span[@class='ui-inputswitch-slider']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", valuet);
				Thread.sleep(3000);
				JavascriptExecutor jst = (JavascriptExecutor) driver;
				jst.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				test.log(Status.PASS, "Priority option is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Priority option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
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

		//Enabling Show only false case from preference//
		try {
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[8]/div[2]/div[1]/div[1]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == true) {
				test.log(Status.PASS, "Show only false cases is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == false) {
				new ZIFAI_CaseManagementPage(driver).Thresholdenablefalse.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Applybutton.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Show only false cases is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on show only false cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


//Setting option is selected form case management

		try {
			if (new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Setting icon is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Setting icon is not selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Noise cancellation slider is selected from setting option
		try{
			new ZIFAI_CaseManagementPage(driver).EnableNoiseCancellation();
			test.log(Status.PASS, "Noise Cancellation is enabled");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Noise cancellation toggle is not selected");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter and preference values before validation//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceHidecase("");
			Thread.sleep(3000);
			test.log(Status.PASS, "Filter and preference values are cleared before validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear preference and filter values");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verify the Pattern based threshold field is updated with dynamic threshold value whose device names are having DT//

		try {
			Actions Threshold = new Actions(driver);
			Threshold.moveToElement(new ZIFAI_CaseManagementPage(driver).PatternbasedHover).perform();
			Thread.sleep(3000);
			WebElement Thresholdst = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Patternbased = Thresholdst.getText();
			System.out.println("When hovered on Pattern Based Threshold:" + Patternbased);
			if (Patternbased.equals("Pattern Based Threshold")) {
				test.log(Status.PASS, "Pattern Based Threshold name is displayed when hovered on the icon");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (!Patternbased.equals("Pattern Based Threshold")) {
				System.out.println("Pattern Based Threshold name is not displayed when hovered on the icon");
				test.log(Status.FAIL, "Pattern Based Threshold name is not displayed when hovered on the icon");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
			Actions Thresholdval = new Actions(driver);
			Thresholdval.moveToElement(new ZIFAI_CaseManagementPage(driver).PatternbasedHovervalue).perform();
			Thread.sleep(3000);
			WebElement Thresholdvl = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Patternbasedval = Thresholdvl.getText();
			System.out.println("When hovered on Pattern Based Threshold value:" + Patternbased);
			if (!Patternbasedval.isEmpty()) {
				test.log(Status.PASS, "Pattern Based Threshold value is displayed when hovered :  " + Patternbasedval);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Patternbasedval.isEmpty()) {
				System.out.println("Pattern Based Threshold value is not displayed when hovered");
				test.log(Status.FAIL, "Pattern Based Threshold value is not displayed when hovered");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Verify the Pattern Based Threshold hover text in case management");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on the first case and verifying the Pattern Based threshold text and value in case details page in expand mode//
		try {
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			Actions detailsthre = new Actions(driver);
			detailsthre.moveToElement(new ZIFAI_CaseManagementPage(driver).PatternbasedHover).perform();
			Thread.sleep(3000);
			WebElement Thresholddetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Patternbaseddetail = Thresholddetails.getText();
			System.out.println("When hovered on Pattern Based Threshold from case detail screen : " + Patternbaseddetail);
			if (Patternbaseddetail.equals("Pattern Based Threshold")) {
				test.log(Status.PASS, "Pattern Based Threshold name is displayed when hovered on the icon from case detail screen");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (!Patternbaseddetail.equals("Pattern Based Threshold")) {
				System.out.println("Pattern Based Threshold name is not displayed when hovered on the icon from case detail screen");
				test.log(Status.FAIL, "Pattern Based Threshold name is not displayed when hovered on the icon from case detail screen");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Actions Thresholddetval = new Actions(driver);
			Thresholddetval.moveToElement(new ZIFAI_CaseManagementPage(driver).Patternbasedvaluehover).perform();
			Thread.sleep(3000);
			WebElement Thresholdvldet = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Patternbaseddetasc = Thresholdvldet.getText();
			System.out.println("When hovered on Pattern Based Threshold value:" + Patternbaseddetasc);
			if (!Patternbaseddetasc.isEmpty()) {
				test.log(Status.PASS, "Pattern Based Threshold value is displayed when hovered :  " + Patternbaseddetasc);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Patternbaseddetasc.isEmpty()) {
				System.out.println("Pattern Based Threshold value is not displayed when hovered");
				test.log(Status.FAIL, "Pattern Based Threshold value is not displayed when hovered");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Verify the Pattern Based Threshold hover text in case detail page with collapse mode");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on the first case and verifying the Pattern Based threshold text and value in case details page in expand mode//
		try {
			new ZIFAI_CaseManagementPage(driver).Expandbutton.click();
			Thread.sleep(3000);
			Actions detailsthre = new Actions(driver);
			detailsthre.moveToElement(new ZIFAI_CaseManagementPage(driver).PatternbasedHover).perform();
			Thread.sleep(3000);
			WebElement Thresholddetails = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Patternbaseddetail = Thresholddetails.getText();
			System.out.println("When hovered on Pattern Based Threshold from case detail screen in expand mode : " + Patternbaseddetail);
			if (Patternbaseddetail.equals("Pattern Based Threshold")) {
				test.log(Status.PASS, "Pattern Based Threshold name is displayed when hovered on the icon from case detail screen in expand mode");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (!Patternbaseddetail.equals("Pattern Based Threshold")) {
				System.out.println("Pattern Based Threshold name is not displayed when hovered on the icon from case detail screen in expand mode");
				test.log(Status.FAIL, "Pattern Based Threshold name is not displayed when hovered on the icon from case detail screen in expand mode");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Actions Thresholddetval = new Actions(driver);
			Thread.sleep(3000);
			Thresholddetval.moveToElement(new ZIFAI_CaseManagementPage(driver).Patternbasedvaluehover).perform();
			Thread.sleep(3000);
			WebElement Thresholdvldet = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Patternbaseddetasc = Thresholdvldet.getText();
			System.out.println("When hovered on Pattern Based Threshold value in expand mode: " + Patternbaseddetasc);
			if (!Patternbaseddetasc.isEmpty()) {
				test.log(Status.PASS, "Pattern Based Threshold value is displayed when hovered in expand mode :  " + Patternbaseddetasc);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Patternbaseddetasc.isEmpty()) {
				System.out.println("Pattern Based Threshold value is not displayed when hovered in expand mode");
				test.log(Status.FAIL, "Pattern Based Threshold value is not displayed when hovered in expand mode");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Verify the Pattern Based Threshold hover text in case detail page with expand mode");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Enabling Prioritization//
		Thread.sleep(3000);
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Preference Tab");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Enabling Priortization option from preference tab.

		try {
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.clear();
			Thread.sleep(3000);
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[11]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == true) {
				test.log(Status.PASS, "Priority is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == false) {
				WebElement valuet = driver.findElement(By.xpath("//span[text()='Enable Case Prioritization']//..//span[@class='ui-inputswitch-slider']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", valuet);
				Thread.sleep(3000);
				JavascriptExecutor jst = (JavascriptExecutor) driver;
				jst.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				test.log(Status.PASS, "Priority option is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Priority option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Hovering on Priority cases with Pattern based threshold//
		try {
			if (new ZIFAI_CaseManagementPage(driver).Prioritynodata.isDisplayed()) {
				test.log(Status.PASS, "Unable to verify as there is no data in priority partition");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				Actions act = new Actions(driver);
				act.moveToElement(new ZIFAI_CaseManagementPage(driver).Prioritythreedots).perform();
				Actions actpt = new Actions(driver);
				actpt.moveToElement(new ZIFAI_CaseManagementPage(driver).Patternbasedpr).perform();
				Actions actptp = new Actions(driver);
				WebElement Priorityval = driver.findElement(By.cssSelector(".ui-tooltip"));
				String Threedotval = Priorityval.getText();
				System.out.println("When hovered on Pattern Based Threshold value using three dots: " + Threedotval);
				if (Threedotval.equals("Pattern Based Threshold")) {
					test.log(Status.PASS, "Pattern Based Threshold value is displayed when hovered using three dots :  " + Threedotval);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else if (!Threedotval.equals("Pattern Based Threshold")) {
					System.out.println("Pattern Based Threshold value is not displayed when hovered using three dots");
					test.log(Status.FAIL, "Pattern Based Threshold value is not displayed when hovered using three dots");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				Actions actptptp = new Actions(driver);
				actptptp.moveToElement(new ZIFAI_CaseManagementPage(driver).Patternbasedvaluepr).perform();
				WebElement Priorityvalt = driver.findElement(By.cssSelector(".ui-tooltip"));
				String Threedotvaltl = Priorityvalt.getText();
				System.out.println("When hovered on Pattern Based Threshold value using three dots: " + Threedotvaltl);
				if (!Threedotvaltl.isEmpty()) {
					test.log(Status.PASS, "Pattern Based Threshold value is displayed when hovered using three dots :  " + Threedotvaltl);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				} else if (Threedotvaltl.isEmpty()) {
					System.out.println("Pattern Based Threshold value is not displayed when hovered using three dots");
					test.log(Status.FAIL, "Pattern Based Threshold value is not displayed when hovered using three dots");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				Thread.sleep(3000);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover three dots and verify Pattern Based Threshold");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Hovering on Other cases with Pattern based threshold//
		try {
			Actions actother = new Actions(driver);
			actother.moveToElement(new ZIFAI_CaseManagementPage(driver).Otherthreedots).perform();
			Thread.sleep(2000);
			Actions actptot = new Actions(driver);
			actptot.moveToElement(new ZIFAI_CaseManagementPage(driver).Patternbasedor).perform();
			Thread.sleep(2000);
			WebElement Otherval = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Otherthreedot = Otherval.getText();
			System.out.println("When hovered on Pattern Based Threshold using three dots in other case: " + Otherthreedot);
			if (Otherthreedot.equals("Pattern Based Threshold")) {
				test.log(Status.PASS, "Pattern Based Threshold  is displayed when hovered using three dots in other case :  " + Otherthreedot);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (!Otherthreedot.equals("Pattern Based Threshold")) {
				System.out.println("Pattern Based Threshold value is not displayed when hovered using three dots in other case");
				test.log(Status.FAIL, "Pattern Based Threshold  is not displayed when hovered using three dots in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Pattern Based Threshold is not displayed when hovered using three dots in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Hovering on Other cases with Pattern based threshold value//
		try {
			Actions actothery = new Actions(driver);
			actothery.moveToElement(new ZIFAI_CaseManagementPage(driver).Otherthreedots).perform();
			Thread.sleep(1000);
			Actions actothervalt = new Actions(driver);
			actothervalt.moveToElement(new ZIFAI_CaseManagementPage(driver).Patternbasedvalueor).perform();
			WebElement Othervalt = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Threedotvaltl = Othervalt.getText();
			System.out.println("When hovered on Pattern Based Threshold value using three dots in other case : " + Threedotvaltl);
			if (!Threedotvaltl.isEmpty()) {
				test.log(Status.PASS, "Pattern Based Threshold value is displayed when hovered using three dots in other case :  " + Threedotvaltl);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (Threedotvaltl.isEmpty()) {
				System.out.println("Pattern Based Threshold value is not displayed when hovered using three dots in other case");
				test.log(Status.FAIL, "Pattern Based Threshold value is not displayed when hovered using three dots in other case");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to mouse hover three dots and verify Pattern Based Threshold value in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-----------------------------------------------------End of US----------------------------------------------------------------------------------------------------------//
		//Report Initialization

		test = extent.createTest("Test Case 6574: - UI - Verify the DT info cases are displayed in Blurred background");
		test.createNode("Test Case 6574: - UI - Verify the DT info cases are displayed in Blurred background");

		//Verify Priority Cases whether grey is highlighted//
		try {
			Thread.sleep(3000);
			String color = driver.findElement(By.xpath("(//div[@class='case-outer-prior case-outer-white-bg'])[1]")).getCssValue("background-color");
			String hex = Color.fromString(color).asHex();
			System.out.println(hex);
			if (hex.equals("#dddddd")) {
				test.log(Status.PASS, "the false case IDs are shown in blurred grey background color which are present in Other cases");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (!hex.equals("#dddddd")) {
				test.log(Status.FAIL, "the false case IDs are not shown in blurred grey background color which are present in Other cases");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			new ZIFAI_CaseManagementPage(driver).Prioritynodata.isDisplayed();
			test.log(Status.PASS, "No data is displayed in priority cases unable to verify with blurred grey background");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Verify Other Cases whether grey is highlighted//
		try {
			Thread.sleep(3000);
			String color = driver.findElement(By.xpath("(//div[@class='case-outer-prior highlt-grey'])[1]")).getCssValue("background-color");
			String hex = Color.fromString(color).asHex();
			System.out.println(hex);
			if (hex.equals("#dddddd")) {
				test.log(Status.PASS, "the false case IDs are shown in blurred grey background color which are present in Other cases");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (!hex.equals("#dddddd")) {
				test.log(Status.FAIL, "the false case IDs are not shown in blurred grey background color which are present in Other cases");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).Othernodata.isDisplayed()) {
				test.log(Status.PASS, "No data is displayed in other cases unable to verify");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify the grey color in other case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
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


		//Enabling Prioritization//

		try {
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.clear();
			Thread.sleep(3000);
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[11]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == false) {
				test.log(Status.PASS, "Priority is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == true) {
				WebElement valuet = driver.findElement(By.xpath("//span[text()='Enable Case Prioritization']//..//span[@class='ui-inputswitch-slider']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", valuet);
				Thread.sleep(3000);
				JavascriptExecutor jst = (JavascriptExecutor) driver;
				jst.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				test.log(Status.PASS, "Priority option is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Priority option");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying the Case management cases are highlighted grey in color//
		try {

			String colort = driver.findElement(By.xpath("(//div[@class='case-outer-1 highlt-grey'])[1]")).getCssValue("background-color");
			String hext = Color.fromString(colort).asHex();
			System.out.println(hext);
			if (hext.equals("#dddddd")) {
				test.log(Status.PASS, "the false case ID is shown in blurred grey background color which are present Case management screen");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (!hext.equals("#dddddd")) {
				test.log(Status.FAIL, "the false case ID is shown in blurred grey background color which are present in Case management screen");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify grey color in Case management screen");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Verifying the Case detail screen cases are highlighted grey in color//
		try {
			new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
			Thread.sleep(3000);
			String colort = driver.findElement(By.xpath("(//div[@class='case-outer-details1 highlt-grey'])[1]")).getCssValue("background-color");
			String hext = Color.fromString(colort).asHex();
			System.out.println(hext);
			if (hext.equals("#dddddd")) {
				test.log(Status.PASS, "the false case ID is shown in blurred grey background color which are present Case management detail screen");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (!hext.equals("#dddddd")) {
				test.log(Status.FAIL, "the false case ID is shown in blurred grey background color which are present in Case management detail screen");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to verify grey color in Case management detail screen");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//------------------------------------End of US---------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 6569:-UI - Verify the Show only false cases and Hide false cases options in case management screen");
		test.createNode("Test Case 6569:- UI - Verify the Show only false cases and Hide false cases options in case management screen");

		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
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

		//Enabling Hide false cases only//

		try {
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[8]/div[2]/div[2]/div[1]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == true) {
				test.log(Status.PASS, "Hide false cases is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == false) {
				new ZIFAI_CaseManagementPage(driver).Thresholdhidefalse.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Applybutton.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Hide false cases is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Hide false cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Getting the count after enabling Hide only false cases//
		try {
			String Case_count1 = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Overall_Case_count:" + Case_count1);
			test.log(Status.PASS, "Total case count in When turning on Hide false cases(Suppression): " + Case_count1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch total case count when turning on Hide False cases(Suppression");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//After enabling Hide false cases filtering out the case id and validating//
		try {
			System.out.println("Dynamic step");
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablingshowonlyfalsecase();
			Thread.sleep(3000);
			String Falsestrval = new ZIFAI_CaseManagementPage(driver).Falsecaseone.getText();
			System.out.println("False case id"  +Falsestrval);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablinghidefalsecase();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid(Falsestrval);
			Thread.sleep(3000);
			if (new ZIFAI_CaseManagementPage(driver).Nodataavailablepr.isDisplayed()) {
				test.log(Status.PASS, "No data is displayed when searching which is hidden false case: " +Falsestrval);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "No data is not displayed when searching which is hidden false case:");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablingshowonlyfalsecase();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch total case count when turning on Hide False cases(Suppression)");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//After enabling Hide false cases filtering out the case id and validating//
		try {
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablingshowonlyfalsecase();
			Thread.sleep(3000);
			String Falsecasetwostr = new ZIFAI_CaseManagementPage(driver).Falsecasetwo.getText();
			System.out.println("False case id "+Falsecasetwostr);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablinghidefalsecase();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid(Falsecasetwostr);
			Thread.sleep(3000);
			if (new ZIFAI_CaseManagementPage(driver).Nodataavailablepr.isDisplayed()) {
				test.log(Status.PASS, "No data is displayed when searching which is hidden false case: " +Falsecasetwostr);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "No data is not displayed when searching which is hidden false case: " +Falsecasetwostr);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablingshowonlyfalsecase();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch total case count when turning on Hide False cases(Suppression)");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//After enabling Hide false cases filtering out the case id and validating//
		try {
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablingshowonlyfalsecase();
			Thread.sleep(3000);
			String Falsecasethreestr = new ZIFAI_CaseManagementPage(driver).Falsecasethree.getText();
			System.out.println("False case id" +Falsecasethreestr);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablinghidefalsecase();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid(Falsecasethreestr);
			Thread.sleep(3000);
			if (new ZIFAI_CaseManagementPage(driver).Nodataavailablepr.isDisplayed()) {
				test.log(Status.PASS, "No data is displayed when searching which is hidden false case: " +Falsecasethreestr);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "No data is not displayed when searching which is hidden false case:");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablingshowonlyfalsecase();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch total case count when turning on Hide False cases(Suppression)");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
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

		//Disabling Hide false cases only//

		try {
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[8]/div[2]/div[2]/div[1]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == false) {
				test.log(Status.PASS, "Hide false cases is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == true) {
				new ZIFAI_CaseManagementPage(driver).Thresholdhidefalse.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Applybutton.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Hide false cases is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to disable Hide false cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing all those values from filter and preference//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "values are cleared after validating those hide false cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to clear after validating those hide false cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Setting option is selected form case management

		try {
			if (new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Setting icon is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "Setting icon is not selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Correlation slider is selected from setting option

		try {
			Thread.sleep(3000);
			Boolean status = driver.findElement(By.xpath("/html/body/app-root/app-home-header/div/div[2]/app-case-mgmt-dash/div[4]/p-dialog/div/div/div[2]/div[2]/div[2]/span[2]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == true) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).warningokbutton.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Warning button is handled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(2000);
				test.log(Status.PASS, "Noise cancellation is already enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == false) {
				new ZIFAI_CaseManagementPage(driver).EnableCorrelation.click();
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).warningokbutton.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Warning button is handled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(2000);
				test.log(Status.PASS, "Noise cancellation toggle is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Enable Noise cancellation toggle is not selected");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
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

		//Enabling Show only false case from preference//
		try {
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[8]/div[2]/div[1]/div[1]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == true) {
				test.log(Status.PASS, "Show only false cases is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == false) {
				new ZIFAI_CaseManagementPage(driver).Thresholdenablefalse.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Applybutton.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Show only false cases is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on show only false cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//After enabling correlation from setting icon and validated whether No data found is displayed//
		try {
			if (new ZIFAI_CaseManagementPage(driver).Nodataavailablepr.isDisplayed()) {
				test.log(Status.PASS, "No data is displayed when enabling correlation from setting icon to verify false cases");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "No data is not displayed when enabling correlation from setting icon");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to verify No data when enabling correlation from setting icon");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
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

		//Enabling Hide false cases only//

		try {
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[8]/div[2]/div[2]/div[1]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == true) {
				test.log(Status.PASS, "Hide false cases is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == false) {
				new ZIFAI_CaseManagementPage(driver).Thresholdhidefalse.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Applybutton.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Hide false cases is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click on Hide false cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Getting the count after enabling Hide only false cases//
		try {
			String Case_count = new ZIFAI_CaseManagementPage(driver).Casecount.getText().replace("(", "").replace(")", "").replace("All", "").trim();
			System.out.println("Overall_Case_count:" + Case_count);
			test.log(Status.PASS, "Total case count in When turning on Hide false cases(Suppression): " + Case_count);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch total case count when turning on Hide False cases(Correlation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//After enabling Hide false cases filtering out the case id and validating//
		try {
			new ZIFAI_CaseManagementPage(driver).Invokesettingicon();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).EnableNoiseCancellation();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablingshowonlyfalsecase();
			Thread.sleep(3000);
			WebElement Elementtr = driver.findElement(By.xpath("(//span[@class='analytics-case'])[1]"));
			String Falsecsestr = Elementtr.getText();
			new ZIFAI_CaseManagementPage(driver).Invokesettingicon();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).EnableCorrelation();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Enablingshowonlyfalsecase();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid(Falsecsestr);
			Thread.sleep(3000);
			if (new ZIFAI_CaseManagementPage(driver).Nodataavailablepr.isDisplayed()) {
				test.log(Status.PASS, "No data is displayed when searching which is hidden false case: " +Falsecsestr);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else {
				test.log(Status.FAIL, "No data is not displayed when searching which is hidden false case: " +Falsecsestr);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to fetch total case count when turning on Hide False cases(Correlation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		//Clicking on preference tab//
		try {
			if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Preference tab is selected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
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

		//Disabling Hide false cases only//

		try {
			Boolean status = driver.findElement(By.xpath("//*[@id=\"bodyScroll\"]/div[8]/div[2]/div[2]/div[1]/p-inputswitch/div/div/input")).isSelected();
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status == false) {
				test.log(Status.PASS, "Hide false cases is already enabled");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);
			} else if (status == true) {
				new ZIFAI_CaseManagementPage(driver).Thresholdhidefalse.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Applybutton.click();
				Thread.sleep(3000);
				test.log(Status.PASS, "Hide false cases is enabled");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				Thread.sleep(3000);


			}
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to disable Hide false cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing all those values from filter and preference//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "values are cleared after validating correlation hide false case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to clear after validating correlation hide false case");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

	}
}