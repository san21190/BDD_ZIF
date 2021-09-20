package com.zifautomation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.CMPLandingpage;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

public class US2844_ZIFAI_Tech_Bot extends Base {
	
	// PreRequsite
			PropertiesFileReader obj= new PropertiesFileReader();
			
			Properties properties = null;
			
	

				@Test
				public void US2844_ZIFAI_Tech_Bot() throws IOException, InterruptedException {

					//Report 

					test = extent.createTest("US2844 - Techbot validation");
					test.createNode("US2844 - Techbot validation");


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


					//Clicking on Techbot and verifying whether it is switched on
					try {
						new ZIFAI_CaseManagementPage(driver).techboton();
						test.log(Status.PASS, "Techbot icon is turned on and verfied");
						test.addScreenCaptureFromPath(captureScreenShot(driver));
						Thread.sleep(3000);
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Not able to click the techbot icon");
						test.addScreenCaptureFromPath(captureScreenShot(driver));
					}

					//Clicking on Techbot and verifying whether it is switched off
					try {
						new ZIFAI_CaseManagementPage(driver).techbotoff();
						test.log(Status.PASS, "Techbot icon is turned off and verified");
						Thread.sleep(3000);
						test.addScreenCaptureFromPath(captureScreenShot(driver));
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Techbot icon is still on");
						test.addScreenCaptureFromPath(captureScreenShot(driver));
					}


					//Filtering Inprogress cases in Case management//

					if(new ZIFAI_CaseManagementPage(driver).prefereceIcon.isDisplayed()) {
						Thread.sleep(3000);
						new ZIFAI_CaseManagementPage(driver).prefereceIcon.click();
						Thread.sleep(3000);
						new ZIFAI_CaseManagementPage(driver).clearcasestatus();
						new ZIFAI_CaseManagementPage(driver).Preferences_Ackstatus.clear();
						new ZIFAI_CaseManagementPage(driver).Preferences_Casestatus.sendKeys("Inprogress");
						Thread.sleep(3000);
						new ZIFAI_CaseManagementPage(driver).Applybutton.click();
						Thread.sleep(3000);
					}
					else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()){
						Thread.sleep(3000);
						new ZIFAI_CaseManagementPage(driver).clearcasestatus();
						Thread.sleep(3000);
						new ZIFAI_CaseManagementPage(driver).Preferences_Ackstatus.clear();
						Thread.sleep(3000);
						new ZIFAI_CaseManagementPage(driver).Preferences_Casestatus.sendKeys("Inprogress");
						new ZIFAI_CaseManagementPage(driver).Applybutton.click();
						Thread.sleep(3000);

					}


					//Verifying the techbot acknowledgement

					try
					{
						List<WebElement> casestatus = new ZIFAI_CaseManagementPage(driver).techbotacknowledgment;
						List<WebElement> case_status = new ZIFAI_CaseManagementPage(driver).techbotacknowledgment;
						int i;
						for ( i= 1; i<casestatus.size(); i=i+1) {
							System.out.println(casestatus.size());
							Actions action = new Actions(driver);
							Thread.sleep(2000);
							action.moveToElement(case_status.get(i)).perform();
							WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
							String Casestatustooltip = Case_status.getText();
							System.out.println("Casestatustooltip:" + Casestatustooltip);
								test.log(Status.PASS, "Tech bot acknowledgement is verified and tooltip is: " +Casestatustooltip);
						}
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Acknowledgement Status failed ---");
						test.addScreenCaptureFromPath(captureScreenShot(driver));
					}

				}

				}


