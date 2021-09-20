package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//US 2922 - This User Story is based on Suppression/Correlation functionality on Case management Page

public class Enable_Virtualization extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;


	@Test
	public void ZIFUI_AnP_US2922_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("Case Management - Correlation - Base Screen and Actions");
		test.createNode("Case Management - Correlation - Base Screen and Actions");

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

		//click on the analytics link
		try {
			new ZIFAIDashboardPage(driver).clickAppSettings();
			Thread.sleep(5000);
			new ZIFAI_CaseManagementPage(driver).Userdropdown.click();
			Thread.sleep(10000);
			new ZIFAI_CaseManagementPage(driver).Useroption.click();
			Thread.sleep(10000);
			test.log(Status.PASS, "Analytics link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//click on the analytics link
		try {
			new ZIFAI_CaseManagementPage(driver).Searchtext.sendKeys("Operator");
			Thread.sleep(10000);
			new ZIFAI_CaseManagementPage(driver).Editicon.click();
			Thread.sleep(10000);
			test.log(Status.PASS, "Analytics link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		try{
			String valuenew = new ZIFAI_CaseManagementPage(driver).InventoryAccordion.getAttribute("aria-hidden");
			Thread.sleep(3000);
			System.out.println("Plus sign in Inventory status "+valuenew);
			if(valuenew.equals("false")){
				new ZIFAI_CaseManagementPage(driver).Inventoryplussign.click();
			}
			else if(valuenew.equals("true")){
				System.out.println("Plus sign in Inventory is already enabled");
			}
			Thread.sleep(3000);
		}
		catch (Exception e){

		}

		try {
			String valuenew = new ZIFAI_CaseManagementPage(driver).Enablevirtual.getAttribute("aria-checked");
			Thread.sleep(3000);
			System.out.println("Current status of the rodio button of Virtualization "+valuenew);
			if(valuenew.equals("true")){
				System.out.println("Already enabled");

			}
			else if(valuenew.equals("false")){
				new ZIFAI_CaseManagementPage(driver).Clickvirtual.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Updateaccessgroup.click();
			}
			test.log(Status.PASS, "Analytics link is clicked");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		}
	}