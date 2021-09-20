package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.oracle.jrockit.jfr.Transition.From;

//US 4167 - This User Story is based on Drag and Drop Functionality from Dashboard.

public class ZIFUI_AnP_US4167_Regression extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;



	@Test
	public void ZIFUI_AnP_US4167_Regression() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("CMP Home Page Valiation");
		test.createNode("CMP Home Page Valiation");

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

		//click on the Dashboard
		try {
			new ZIFAIDashboardPage(driver).Dashboardnavigation();
			test.log(Status.PASS, "Navigated to Dashboard menu and added a Dashboard");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Analytics link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Click on the Addwidgetbutton button
			try {
				if(new ZIFAIDashboardPage(driver).DashboardAddwidget.isDisplayed())
				{
					new ZIFAIDashboardPage(driver).DashboardAddwidget.click();
					new ZIFAIDashboardPage(driver).selectwidgetoptions();
					test.log(Status.PASS, "Add widget button is clicked");
				} else{
					test.log(Status.FAIL, "Not able to click the Add widget button");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
		} catch(Exception e){
			test.log(Status.FAIL, "Error occured to click the Add widget button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Click on the Addwidgetoptions
		try {
			new ZIFAIDashboardPage(driver).selectwidgetoptions();
			test.log(Status.PASS, "Widget options are selected");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch(Exception e){
			test.log(Status.FAIL, "Error occured to click the Add widget options");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on the apply button
		try {
			if(new ZIFAIDashboardPage(driver).ClickApply.isDisplayed())
			{
				Thread.sleep(2000);
				new ZIFAIDashboardPage(driver).ClickApply.click();
				Thread.sleep(4000);
				test.log(Status.PASS, "Apply button is clicked");
			} else{
				test.log(Status.FAIL, "Not able to click the Apply button");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch(Exception e){
			test.log(Status.FAIL, "Error occured to click the Apply button");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Drag and Drop Widget

		//try {
		//	if(new ZIFAIDashboardPage(driver).Unassignedwidget.isDisplayed())
		//	{
		//		Thread.sleep(2000);
				//Using Action class for drag and drop.
		//		Thread.sleep(2000);
		//		WebElement To = driver.findElement(By.xpath("//div[@class='item-content'][contains(normalize-space(),'Unassigned')]"));
		//		WebElement From = driver.findElement(By.xpath("//div[@class='item-content'][contains(normalize-space(),'Critical')]"));
		//		Actions builder = new Actions(driver);
		//		Action dragAndDrop = builder.clickAndHold(From).moveByOffset(-1, -1).moveToElement(To).release(To).build();
		//		Thread.sleep(2000);
		//		dragAndDrop.perform();
				//Drag and Drop by Pixel.
				//actdrg1.build().perform();
				//actdrg1.clickAndHold(From).build().perform();
				//you need to release the control from the test
				//actdrg1.moveToElement(To).release();

	//			Thread.sleep(4000);
	//			test.log(Status.PASS, "Apply button is clicked");
	//		} else{
	//			test.log(Status.FAIL, "Not able to click the Apply button");
	//			test.addScreenCaptureFromPath(captureScreenShot(driver));
	//		}
	//	} catch(Exception e){
		//	test.log(Status.FAIL, "Error occured to click the Apply button");
		//	test.addScreenCaptureFromPath(captureScreenShot(driver));
		//}

		try {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		//Actions class method to drag and drop


		WebElement from = driver.findElement(By.xpath("//div[@class='item-content'][contains(normalize-space(),'Critical')]"));
		WebElement to = driver.findElement(By.xpath("//div[@class='item-content'][contains(normalize-space(),'Unassigned')]"));
		//Action dragAndDrop = builder.clickAndHold(from).moveByOffset(133, 297).moveToElement(to).release(to).build();
		Thread.sleep(2000);
			Actions builder = new Actions(driver);
		//dragAndDrop.perform();
			builder.dragAndDrop(from, to);
			Thread.sleep(2000);
			builder.dragAndDropBy(from,  297, 193);
			Thread.sleep(2000);
			test.log(Status.PASS, "Widget options are moved");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}
		catch(Exception e){
			test.log(Status.FAIL, "Widget options are not moved");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


	}
}

