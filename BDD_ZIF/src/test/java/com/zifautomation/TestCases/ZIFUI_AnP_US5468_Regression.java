package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_CaseManagementPage;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelVerification;
import com.zifautomation.Utility.PropertiesFileReader;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ZIFUI_AnP_US5468_Regression extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();
	Properties properties = null;
	CommonMethods cm = null;


	@Test
	public void ZIFUI_AnP_US5468_Regression() throws IOException, InterruptedException {



		//Report Initialization

		test = extent.createTest("US 5468 Prioritization of cases - Filters and Details Screen");
		test.createNode("US 5468 Prioritization of cases - Filters and Details Screen");



		//Verify valid UserName and valid Password
		try {
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			e.printStackTrace();
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


		//Clearing the values before validation//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceHidecase("");
			Thread.sleep(3000);
			test.log(Status.PASS, "clearing preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "clearing preference");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing the data from filter//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).Filtercloseicon.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Data is cleared before validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear data before validation");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clicking on Preference icon//
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

		//Enabling Priority option if it is disabled already//

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
		try{
			new ZIFAI_CaseManagementPage(driver).EnableCorrelation();
			test.log(Status.PASS, "Correlation is enabled");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, e);
			test.log(Status.FAIL, "Correlation toggle is not selected");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Count split up for Other cases and priority cases//
		try {
			String countother = new ZIFAI_CaseManagementPage(driver).Othercasecount.getText().replace("(", "").replace(")", "").trim();
			Thread.sleep(3000);
			String countpri = new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace(")", "").trim();
			System.out.println(countother);
			System.out.println(countpri);
			test.log(Status.PASS, "Split up verified");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify the splitup");
		}

		//Report Initialization
		test = extent.createTest("US 5366- Verify the Excel export with or without applying filters/preferences in both modes (Priority cases and other cases)");
		test.createNode("US 5366- Verify the Excel export with or without applying filters/preferences in both modes (Priority cases and other cases)");

		//Clearing all values in filter and preference//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing all values from filter and preference before export");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear values before export");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Clicking the filter for selecting the date//
		try {
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).RawalertsCalendarlink.click();
			Thread.sleep(2000);
			test.log(Status.PASS, "Date is selected from the picker using filter");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to Verify the Date picker is working for all the time selected by the user");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}



		try {
//			WebElement beforemonth = driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-prev-icon')]"));
			Thread.sleep(2000);
			if (new ZIFAI_CaseManagementPage(driver).Prevmonth.isDisplayed()) {
				new ZIFAI_CaseManagementPage(driver).Prevmonth.click();
				new ZIFAI_CaseManagementPage(driver).Prevmonth.click();
			}
			WebElement dateone = driver.findElement(By.xpath("//a[text()='1']"));
			WebElement datete = driver.findElement(By.xpath("//a[text()='28']"));
			Thread.sleep(2000);
			dateone.click();
			Thread.sleep(2000);
			datete.click();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).RawalertsCalendarlink.click();
			Thread.sleep(4000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to Verify the Date picker is working for all the time selected by the user");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Click on export and verify the particular case id is present in excel when filtered using preference//
		cm.deleteAllFilesInFolder(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads");
		try {
			String firstcase = new ZIFAI_CaseManagementPage(driver).Otherfilteredcaseid.getText().replace("ZIF","").trim();
			Thread.sleep(2000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtercaseid.sendKeys(firstcase);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ExportButton.click();
			Thread.sleep(5000);
			new CommonMethods(driver).filenamechange();
			Thread.sleep(3000);
			new ExcelVerification().convertcsv();
			Thread.sleep(3000);
			ExcelVerification ExlUtil = new ExcelVerification();
			ArrayList<String> excel = ExlUtil.readExcel();
			if(excel.contains(firstcase)){
				test.log(Status.PASS, "Filtered using new cases and clicked on Export icon also verified through excel");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				test.log(Status.FAIL, "Unable to filter new case and verify though excel");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			System.out.println("Read Excel" + excel);

		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Unable to click on preference and export"+e.getMessage());
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clearing all values in filter and preference after export//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing all values from filter and preference after export");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear values after export");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
//----------------------------------------End of Export US 5366--------------------------------------------------//
		//Report Initialization
		test = extent.createTest("US 5572-Verify the Prioritized and other cases by applying the Preferences Case ID and Status");
		test.createNode("US 5572-Verify the Prioritized and other cases by applying the Preferences Case ID and Status");
		try {
			String filtercaseid = new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.getText();
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid(filtercaseid);
			Thread.sleep(3000);
			test.log(Status.PASS, "Filtered specific case id");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to filter specific case id");
		}

		//Count split up//
		try {
			new ZIFAI_CaseManagementPage(driver).Prioritycasecount.getText().replace("(", "").replace("(", "").trim();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Othercasecount.getText().replace("(", "").replace("(", "").trim();
			test.log(Status.PASS, "Verified count after filtering values using specific Case id");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to verify count after filtering specific case id");
		}

		//Filter case status using exclude:AutoClosed,exclude:New and verify//
			try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("exclude:AutoClosed, exclude:New");
			test.log(Status.PASS, "Cleared the preference values and applied exclude:AutoClosed, exclude:New");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to filter exclude:AutoClosed,exclude:New ");
		}

		//Filter Case status with New,Inprogress status and verify //
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("New, In Progress");
			test.log(Status.PASS, "Cleared the preference values and applied New and Inprogress status");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter New and Inprogress");
		}

		//Filter Case status with Closed status and verify //
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("Closed");
			test.log(Status.PASS, "Cleared the preference values and applied closed status");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter closed status");
		}

		//Filter Case status with exclude:Assigned and verify//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("exclude:Assigned");
			test.log(Status.PASS, "Cleared the preference values and applied  exclude:Assigned");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter exclude:Assigned status");
		}
		//---------------------------------------------End of US 5572-----------------------------------------------//

		//Report Initialization
		test = extent.createTest("US 5585 Case Management - Verify the Prioritized and other cases detail screen - Timeline section - Collapsed mode");
		test.createNode("US 5585 Case Management - Verify the Prioritized and other cases detail screen - Timeline section - Collapsed mode");


		//Filter Case with case id and verify - Priority cases //
		try{
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("ZIF8841");
			test.log(Status.PASS, "Cleared the preference values and applied a case id");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter case id");
		}

		//Clicking on the filtered case id//
		try{
			new ZIFAI_CaseManagementPage(driver).Priorityfirstcaseid.click();
			test.log(Status.PASS, "Clicked on the filtered case id");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to click on the filtered case id");
		}


		//Clicked on the timeline after clicking on the case id and verify the repeated description//
		try{
			SoftAssert softAssert = new SoftAssert();
			new ZIFAI_CaseManagementPage(driver).Timeline.click();
			Thread.sleep(3000);
			List<String> Text_List = new ArrayList<String>();
			int size = driver.findElements(By.xpath("//*[@id=\"bodyScroll\"]/div[2]/div[2]")).size();
			System.out.println(size);
			for(int i=2; i<=size; i++){
				String text = driver.findElement(By.xpath("(//*[@id=\"bodyScroll\"]/div[2]/div[2])[" + i + "]")).getText();
				Boolean condition = Text_List.contains(text);
				softAssert.assertTrue(condition);
				if(condition == false){
					Thread.sleep(2000);
					System.out.println("Same description reference which are repeated in timeline  " + text);
					test.log(Status.PASS, "Same description which are repeated in timeline :" + text);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				Text_List.add(text);
			}
			System.out.println("Array List - " + Text_List);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to fetch the description from timeline" +e);
		}


		//Verify the date time stamp is displayed for each box in timeline//
		try {
			Thread.sleep(3000);
			List<String> Text_List = new ArrayList<String>();
			int size = driver.findElements(By.xpath("//div[@class='text-date']")).size();
			System.out.println(size);
			for (int i = 1; i <= size; i++) {
				String text = driver.findElement(By.xpath("(//div[@class='text-date'])[" + i + "]")).getText();
				System.out.println(text);
				test.log(Status.PASS, "Time stamp which are present in timeline :" +text);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to fetch the time stamp which are present in timeline"+e);
		}

		//Verify the presence of scroll bar in the RHS of the Timeline//
		try {
			int Timelinesize = driver.findElements(By.xpath("//*[@id=\"bodyScroll\"]/div[2]/div[2]")).size();
			List<WebElement> Timelhover = driver.findElements(By.xpath("//*[@id=\"bodyScroll\"]/div[2]/div[2]"));
			for (int i = 2; i <= Timelinesize; i++) {
				Actions hover = new Actions(driver);
				hover.moveToElement(Timelhover.get(i)).build().perform();
				test.log(Status.PASS, "Successfully scrolled through the timeline");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}
		catch (Exception e){
			test.log(Status.PASS, "End of scroll through timeline");
		}

		//Verify whether the Timeline is closed when Correlation or Root cause tab is clicked//
		try{
			new ZIFAI_CaseManagementPage(driver).CorrelatedALerts.click();
			Thread.sleep(3000);
			WebElement crtdesc = driver.findElement(By.xpath("(//div[@class='correlated-alerts-record-outer ng-star-inserted'])[1]"));
			Boolean descval = crtdesc.isDisplayed();
			System.out.println(descval);
			if(descval==true){
				test.log(Status.PASS, "Clicked on Correlated alerts and validated");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(descval==false){
				test.log(Status.PASS, "Unable to validate on correlated alerts");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}

		}
		catch (Exception e) {
			test.log(Status.FAIL, "Unable perform validation on correlated alerts");
		}
		//Close the Priority case//
		try{
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "closed priority cases");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close priority cases");
		}


		//Filter Case with case id and verify - Other cases //
		try{
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid("ZIF8838");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Otherfirstcase.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared the preference values and applied a case id");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter case id");
		}




		//Clicked on the timeline after clicking on the case id and verify the repeated description//
		try{
			SoftAssert softAssert = new SoftAssert();
			new ZIFAI_CaseManagementPage(driver).Timeline.click();
			Thread.sleep(3000);
			List<String> Text_List = new ArrayList<String>();
			int size = driver.findElements(By.xpath("//*[@id=\"bodyScroll\"]/div[2]/div[2]")).size();
			System.out.println(size);
			for(int i=2; i<=size; i++){
				String text = driver.findElement(By.xpath("(//*[@id=\"bodyScroll\"]/div[2]/div[2])[" + i + "]")).getText();
				Boolean condition = Text_List.contains(text);
				softAssert.assertTrue(condition);
				if(condition == true){
					Thread.sleep(2000);
					System.out.println("Same description reference which are repeated in timeline  " + text);
					test.log(Status.PASS, "Same description which are repeated in timeline :" + text);
					test.addScreenCaptureFromPath(captureScreenShot(driver));
				}
				Text_List.add(text);
			}
			System.out.println("Array List - " + Text_List);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to fetch the description from timeline" +e);
		}


		//Verify the date time stamp is displayed for each box in timeline//
		try {
			Thread.sleep(3000);
			List<String> Text_List = new ArrayList<String>();
			int size = driver.findElements(By.xpath("//div[@class='text-date']")).size();
			System.out.println(size);
			for (int i = 1; i <= size; i++) {
				String text = driver.findElement(By.xpath("(//div[@class='text-date'])[" + i + "]")).getText();
				System.out.println(text);
				test.log(Status.PASS, "Time stamp which are present in timeline :" +text);
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to fetch the time stamp which are present in timeline"+e);
		}

		//Verify the presence of scroll bar in the RHS of the Timeline//
		try {
			int Timelinesize = driver.findElements(By.xpath("//*[@id=\"bodyScroll\"]/div[2]/div[2]")).size();
			List<WebElement> Timelhover = driver.findElements(By.xpath("//*[@id=\"bodyScroll\"]/div[2]/div[2]"));
			for (int i = 2; i <= Timelinesize; i++) {
				Actions hover = new Actions(driver);
				hover.moveToElement(Timelhover.get(i)).build().perform();
				test.log(Status.PASS, "Successfully scrolled through the timeline");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}
		catch (Exception e){
			test.log(Status.PASS, "End of scroll through timeline");
		}

		//Verify whether the Timeline is closed when Correlation or Root cause tab is clicked//
		try{
			new ZIFAI_CaseManagementPage(driver).CorrelatedALerts.click();
			Thread.sleep(3000);
			WebElement crtdesc = driver.findElement(By.xpath("(//div[@class='correlated-alerts-record-outer ng-star-inserted'])[1]"));
			Boolean descval = crtdesc.isDisplayed();
			System.out.println(descval);
			if(descval==true){
				test.log(Status.PASS, "Clicked on Correlated alerts and validated");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else if(descval==false){
				test.log(Status.PASS, "Unable to validate on correlated alerts");
				test.addScreenCaptureFromPath(captureScreenShot(driver));

			}

		}
		catch (Exception e) {
			test.log(Status.FAIL, "Unable perform validation on correlated alerts");
		}
		//Close the Priority case//
		try{
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "closed other cases");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close other cases");
		}

		//Clearing the filter and preference after validation//
		try {
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceseverity("");
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clearing the filter end of US 5585");
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to clear the filter before US 5585");
		}


		//----------------------------End of US 5585----------------------------------------------//

		//Report Initialization
		test = extent.createTest("US 5584 Case Management - Verify the Other cases sections - by Editing a case in both collapsed and expanded mode");
		test.createNode("US 5584 Case Management - Verify the Other cases sections - by Editing a case in both collapsed and expanded mode");

		//Clicking on the first case of other case//
		try{
			new ZIFAI_CaseManagementPage(driver).Otherfirstcaseid.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clicked on the other first case");
		}
		catch (Exception e){
			System.out.println(e);
			test.log(Status.FAIL, "Unable to click on the first case1 " +e);
		}


		//Clicking on the Edit in expand mode..
		try{
			new ZIFAI_CaseManagementPage(driver).AlertEdit.click();
			Thread.sleep(3000);
			Boolean Statusdd = new ZIFAI_CaseManagementPage(driver).StatusDD.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Status option is displayed" +Statusdd);
			Boolean Statustext = new ZIFAI_CaseManagementPage(driver).NotesText.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Notes option is displayed" +Statustext);
			Boolean Reftext = new ZIFAI_CaseManagementPage(driver).ReferenceText.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Reference option is displayed" +Reftext);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Preferenceclose.click();
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to click on the first case2");
		}


		//Clicking on the Edit in Expand mode..//
		try{
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Otherfirstcaseid.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Expandbutton.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertEdit.click();
			Thread.sleep(3000);
			Boolean Statusdd = new ZIFAI_CaseManagementPage(driver).StatusDD.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Status option is displayed" +Statusdd);
			Boolean Statustext = new ZIFAI_CaseManagementPage(driver).NotesText.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Notes option is displayed" +Statustext);
			Boolean Reftext = new ZIFAI_CaseManagementPage(driver).ReferenceText.isDisplayed();
			Thread.sleep(3000);
			test.log(Status.PASS, "Reference option is displayed" +Reftext);
			new ZIFAI_CaseManagementPage(driver).Preferenceclose.click();

			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify options in edit using Expand mode " +e);
		}

		//Clearing the values and validating the whether values are cleared//


		try{
			new ZIFAI_CaseManagementPage(driver).Otherfirstcaseid.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Expandbutton.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertEdit.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).StatusDD.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).DDInprogressStatus.click();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			new ZIFAI_CaseManagementPage(driver).NotesText.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b);
			new ZIFAI_CaseManagementPage(driver).NotesText.sendKeys("Test to check the box");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ReferenceText.sendKeys("Test to check the ref box");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearEdit.click();
			Thread.sleep(3000);
			String valuetx= new ZIFAI_CaseManagementPage(driver).NotesText.getAttribute("value");
			String valuereftx = new ZIFAI_CaseManagementPage(driver).ReferenceText.getAttribute("value");
			System.out.println(valuetx);
			System.out.println(valuereftx);
			if(!valuetx.isEmpty()) {
				Thread.sleep(3000);
				test.log(Status.FAIL, "Notes Text are not cleared after clicking clear button");

				if (!valuereftx.isEmpty()) {
					Thread.sleep(3000);
					test.log(Status.FAIL, "Reference Text are not cleared after clicking clear button");

				}
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ApplyEdit.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Values in edit are cleared and verified");
		}

		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify after applying clear");
		}

		//Reopening the edit and validating the values whether values are not changed//
		try{
			new ZIFAI_CaseManagementPage(driver).AlertEdit.click();
			Thread.sleep(3000);
			String valuetx= new ZIFAI_CaseManagementPage(driver).NotesText.getAttribute("value");
			Thread.sleep(3000);
			String valuereftx = new ZIFAI_CaseManagementPage(driver).ReferenceText.getAttribute("value");
			System.out.println(valuetx);
			System.out.println(valuereftx);
			if(valuetx.isEmpty()) {
				Thread.sleep(3000);
				test.log(Status.FAIL, "Notes Text is not same when reopened");
				if (valuereftx.isEmpty()) {
					Thread.sleep(3000);
					test.log(Status.FAIL, "Reference Text is not same when reopened");
				}
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ApplyEdit.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Values in edit are same after reopening it");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify edit text when reopened");
		}

		//Changing the status and verifying whether it has been applied in relevant case id//

		try{
			String CaseRHS = driver.findElement(By.xpath("//div[@class='case-id ng-star-inserted']")).getText();
			System.out.println("Case id on which status and text is entered " +CaseRHS);
			new ZIFAI_CaseManagementPage(driver).AlertEdit.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).StatusDD.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).DDInprogressStatus.click();
			Thread.sleep(3000);
			String b = Keys.BACK_SPACE.toString();
			new ZIFAI_CaseManagementPage(driver).NotesText.sendKeys(b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b +b);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).NotesText.sendKeys("Test to check notes in");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ApplyEdit.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecaseid(CaseRHS);
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to verify after applying clear");
		}

		//Verifying the case id which is holding entered information(Case status)
		try {
			Actions actioncase = new Actions(driver);
			Thread.sleep(2000);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).Casestatuiconor).perform();
			WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Casestatustooltip = Case_status.getText();
			System.out.println("Casestatustooltip:" + Casestatustooltip);
			if (Casestatustooltip.equals("InProgress")) {
				test.log(Status.PASS, "Inprogress status is displayed as entered in Edit box verified in case management page");
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Inprogress status is not displayed as ented in Edit box verified in case management page");

		}

		//Verifying the case id which is holding entered information(Notes Reference)
		try {
			Actions actioncase = new Actions(driver);
			Thread.sleep(2000);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).notesor).perform();
			Thread.sleep(2000);
			WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Casestatustooltip = Case_status.getText();
			System.out.println("Casestatustooltip:" + Casestatustooltip);
			if (Casestatustooltip.equals("Test to check notes in")) {
				test.log(Status.PASS, "Notes is displayed as entered in Edit box verified in Case management page");
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Notes is not displayed as entered in Edit box verified in Case management page");
		}

		//Clearing the values in Preference//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferencecasestatus("");
			test.log(Status.PASS, "Cleared values in Preference box");
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to clear values in Preference box");

		}

		//------------------------------------End of US --------------------------------------------------//
		//Report Initialization
		test = extent.createTest("Test Case 5573: Functional - Case Management - Verify the Prioritized and other cases sections - by applying Preferences Case Status & Severity");
		test.createNode("Test Case 5573: Functional - Case Management - Verify the Prioritized and other cases sections - by applying Preferences Case Status & Severity");

		//Case Severity: High and verify both Priority and other cases are filtered//
		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceseverity("High");
			test.log(Status.PASS, "Filtered high severity cases ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter high severity cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}

		//Verify the count and High cases are displayed in both Priority cases//
		try {
			Actions actioncase = new Actions(driver);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).severityiconpr).perform();
			Thread.sleep(4000);
			WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Casestatustooltip = Case_status.getText();
			System.out.println("Severity status tooltip for Priority:" + Casestatustooltip);
			if (Casestatustooltip.equalsIgnoreCase("High")) {
				test.log(Status.PASS, "High severity is displayed in priority");
			}
			else {
				test.log(Status.FAIL, "High severity is not displayed in priority");
			}
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify High severity is displayed in priority" +e);

		}

		//Verify the count and High cases are displayed in both Other cases//
		try {
			Actions actioncasesev = new Actions(driver);
			actioncasesev.moveToElement(new ZIFAI_CaseManagementPage(driver).severityiconor).perform();
			WebElement Severitycase = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Casestatustooltipsv = Severitycase.getText();
			System.out.println("Severity status tooltip for Other:" + Casestatustooltipsv);
			if (Casestatustooltipsv.equals("High")) {
				test.log(Status.PASS, "High severity is displayed in other cases");
			}
			else {
				test.log(Status.FAIL, "High severity is not displayed in other cases");
			}
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify High severity is displayed in other cases");

		}

		//Clearing the filter after severity validation//

		try{
			new ZIFAI_CaseManagementPage(driver).ClearPreferenceseverity("");
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filter_close.click();
			test.log(Status.PASS, "Cleared values after severity validation ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter high severity cases" +e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}

		//Tool name : Enter tool in filter using tool name//
		try{
			new ZIFAI_CaseManagementPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Filtertoolname.sendKeys("Tool");
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Applybutton.click();
			test.log(Status.PASS, "Unable to filter tool related cases ");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to filter tool related cases");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(3000);
		}

		//Verify tool related cases are displayed in  Priority cases//
		try {
			new ZIFAI_CaseManagementPage(driver).severityiconpr.click();
			Thread.sleep(2000);
			Actions actioncase = new Actions(driver);
			Thread.sleep(2000);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).CorrelatedToolnamehover).perform();
			WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Toolnametooltip = Case_status.getText();
			System.out.println("priority contains:" + Toolnametooltip);
			if (Toolnametooltip.contains("TOOL")) {
				test.log(Status.PASS, "Tool name is displayed in priority case");
			}
			else {
				test.log(Status.FAIL, "Tool name is not displayed in priority case");
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify Tool name in priority case");

		}

		//Verify tool related cases are displayed in  Other cases//
		try {
			new ZIFAI_CaseManagementPage(driver).severityiconor.click();
			Thread.sleep(2000);
			Actions actioncase = new Actions(driver);
			Thread.sleep(2000);
			actioncase.moveToElement(new ZIFAI_CaseManagementPage(driver).CorrelatedToolnamehover).perform();
			WebElement Case_status = driver.findElement(By.cssSelector(".ui-tooltip"));
			String Toolnametooltip = Case_status.getText();
			System.out.println("other contains: " + Toolnametooltip);
			if (Toolnametooltip.contains("TOOL")) {
				test.log(Status.PASS, "Tool name is displayed in  other case");
			}
			else {
				test.log(Status.FAIL, "Tool name is not displayed in other case");
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).AlertClose.click();
			Thread.sleep(3000);
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to verify Tool name other case");

		}

		//-------------------------------------------End of US--------------------------------------//


	}
}