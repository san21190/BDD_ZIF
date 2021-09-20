package com.zifautomation.StepDef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.zifautomation.Listeners.ExtentReportListener;
import com.zifautomation.Pages.CMPLandingpage;

import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class CMPHomePage extends ExtentReportListener
{
	PropertiesFileReader obj= new PropertiesFileReader();
	TestDataHandler testdata=new TestDataHandler();
	private WebDriver driver;
	CommonMethods cm=null;
	Loginfunction Login = null;

	Properties properties;

	@Given("^Open Chrome browser with valid URL$")
	public void open_Chrome_browser_with_valid_URL() throws Throwable
	{
		try {
			properties = obj.getProperty();
			String SheetName="CMPPortal";
			String TestcaseID="CMP";
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(properties.getProperty("testdatafilepath"), SheetName, TestcaseID);
			testdata.setTestDataInMap(TestDataInMap);
		} catch (Exception e) {

			e.printStackTrace();
		}  
		ExtentTest logInfo=null;
		try {

			test = extent.createTest(Feature.class, "Home Page validation");
			test=test.createNode(Scenario.class, "Home Page validation");
			logInfo=test.createNode(new GherkinKeyword("Given"), "open_Chrome_browser_with_URL");
			//Properties properties=obj.getProperty();
			String Browser = testdata.getTestDataInMap().get("Browser");
			String URL = testdata.getTestDataInMap().get("Url");
			driver=BrowserUtility.OpenBrowser(driver, Browser, URL);
			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}


	@When("^Login to the application$")
	public void Enterthevalidcredentials() throws Throwable
	{
		ExtentTest logInfo=null;
		try {

			logInfo=test.createNode(new GherkinKeyword("And"), "Enterthevalidcredentials");
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);

			logInfo.pass("Valid credential has been entered");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}


	}

	@Then("^Verify the Total number of customers$")
	public void Verify_the_Total_number_of_customers() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify_the_Total_number_of_customers");
			new CMPLandingpage(driver).TotalCustomersTextandValue();

			logInfo.pass("Successfully verified Total number of customers");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@Then("^Verify the Zif in production field$")
	public void Verify_the_Zif_in_production_field() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify_the_Zif_in_production_field");
			new CMPLandingpage(driver).InProductionTextandValue();

			logInfo.pass("Successfully verified Zif in production field");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@Then("^Verify the ZIF in POV field$")
	public void Verify_the_ZIF_in_POV_field() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify_the_ZIF_in_POV_field");
			new CMPLandingpage(driver).InPOVGTextandValue();

			logInfo.pass("Successfully verified  ZIF in POV field");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}


	@Then("^Verify the List of customers$")
	public void Verify_the_List_of_customers() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify_the_List_of_customers");
			assertTrue(isElementPresent(By.xpath("//p[contains(text(),'List of Customers')]")));

			logInfo.pass("Successfully verified the List of customer header");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}



	@Then("^The headers should be in search format$")
	public void The_headers_should_be_in_search_format() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "The_headers_should_be_in_search_format");
			new CMPLandingpage(driver).Check_all_present_searchboxs();

			logInfo.pass("Successfully verified the headers are in search format");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@And("^Click on the pagination and Verify the user traverse to next page$")
	public void Click_on_pagination_and_verify_the_user_traverse_to_next_page() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("And"), "Click_on_pagination_and_verify_the_user_traverse_to_next_page");
			new CMPLandingpage(driver).CheckPaginators();

			logInfo.pass("Successfully verified Pagnition traverse");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@And("Click on Add New Customer button")
	public void click_on_Add_New_Customer_button() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("And"), "click_on_Add_New_Customer_button");
			new CMPLandingpage(driver).ClickonAddnewCustomerbtn();

			logInfo.pass("Successfully Clicked on Add New Customer button");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@Then("Verify all the fields in Add a New Customer side panel")
	public void Verify_all_the_fields_in_Add_a_New_Customer_side_panel() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify_all_the_fields_in_Add_a_New_Customer_side_panel");
			new CMPLandingpage(driver).VerifyAddNewCustomerfields();
			logInfo.pass("Successfully verified Add New Customer fields");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("User enters Partial data in the panel")
	public void user_enters_Partial_data_in_the_panel()  {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_enters_Partial_data_in_the_panel");

			String CustomerName = testdata.getTestDataInMap().get("CustomerName");
			String AMEmail = testdata.getTestDataInMap().get("AMEmail");
			String ZIFAdminEmailID = testdata.getTestDataInMap().get("ZIFAdminEmailID");
			WebElement CustomerNametextbox = driver.findElement(By.xpath("//input[@formcontrolname='customerName']"));
			WebElement AMEmailtextbox = driver.findElement(By.xpath("//input[@formcontrolname='managerEmail']"));
			WebElement ZIFAdminEmailIDtextbox = driver.findElement(By.xpath("//input[@type='clientAdminEmail']"));
			CustomerNametextbox.sendKeys(CustomerName);
			AMEmailtextbox.sendKeys(AMEmail);
			ZIFAdminEmailIDtextbox.sendKeys(ZIFAdminEmailID);

			logInfo.pass("Successfully entered Partial data in the side panel");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("Verify that the Create Customer button is disabled")
	public void verify_that_the_Create_Customer_button_is_disabled() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_that_the_Create_Customer_button_is_disabled");

			//WebElement CreateCustomerbtn = driver.findElement(By.xpath("//span[text()='Create Customer']"));
			//JavascriptExecutor js = (JavascriptExecutor) driver;  
			//Boolean disabled = (Boolean) js.executeScript("return arguments[0].hasAttribute(\"disabled\");", CreateCustomerbtn);

			new CMPLandingpage(driver).CreateCustomerdisabled();

			logInfo.pass("Successfully verified that the Create Customer button was disabled");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("User enters all the data")
	public void user_enters_all_the_data() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_enters_all_the_data");



			String CustomerName = testdata.getTestDataInMap().get("CustomerName");
			String CustomerLocation = testdata.getTestDataInMap().get("CustomerLocation");
			String AccountManager = testdata.getTestDataInMap().get("AccountManager");
			String AMEmail = testdata.getTestDataInMap().get("AMEmail");
			String Implementation = testdata.getTestDataInMap().get("Implementation");
			String ZIFcatalogueEmailID = testdata.getTestDataInMap().get("ZIFcatalogueEmailID");
			String ZIFAdminEmailID = testdata.getTestDataInMap().get("ZIFAdminEmailID");

			new CMPLandingpage(driver).EnteralldetailsinAddCustomer(CustomerName, CustomerLocation, AccountManager, AMEmail, Implementation, ZIFcatalogueEmailID, ZIFAdminEmailID);

			logInfo.pass("Successfully entered all the valid data");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("Verify that the Create Customer buttton is enabled")
	public void verify_that_the_Create_Customer_buttton_is_enabled() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_that_the_Create_Customer_buttton_is_enabled");


			new CMPLandingpage(driver).CreateCustomerenabled();

			logInfo.pass("Successfully verified that the Create Customer button was enabled");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("Click on Create Customer button")
	public void click_on_Create_Customer_button() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "click_on_Create_Customer_button");

			WebElement CreateCustomerbtn = driver.findElement(By.xpath("//span[text()='Create Customer']"));
			CreateCustomerbtn.click();


			logInfo.pass("Successfully Clicked on Create Customer button");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("Verify that the Customer has been created successfully span is displayed")
	public void Customer_has_been_created_successfully() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Customer_has_been_created_successfully");

			WebElement customercreatedsuccess = driver.findElement(By.xpath("//span[contains(text(),'Customer has been created successfully')]"));

			customercreatedsuccess.isDisplayed();


			logInfo.pass("Successfully verified the Customer has been created successfully span");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}



	@Then("Verify that the Customer record already exists span is displayed")
	public void Customer_record_already_exists() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Customer_record_already_exists");

			WebElement customercreatedsuccess = driver.findElement(By.xpath("//span[contains(text(),'Customer record already exists')]"));

			customercreatedsuccess.isDisplayed();


			logInfo.pass("Successfully verified the Customer record already exists span");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}


	@When("Close the side panel")
	public void Close_the_side_panel() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "Close_the_side_panel");

			//Close the side Panel


			WebElement Addcustomerclose = driver.findElement(By.xpath("//a[@role='button']//span[1]"));
			Addcustomerclose.click();


			logInfo.pass("Successfully closed the side panel");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}





	@Then("Verify that the Customer is displayed in the List of Customers")
	public void verify_that_the_Customer_is_displayed_in_the_List_of_Customers() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_that_the_Customer_is_displayed_in_the_List_of_Customers");
			driver.navigate().refresh();
			Thread.sleep(5000);

			String CustomerName = testdata.getTestDataInMap().get("CustomerName");
			String CustomerLocation = testdata.getTestDataInMap().get("CustomerLocation");
			String AccountManager = testdata.getTestDataInMap().get("AccountManager");


			String CustomerNameGrid = driver.findElement(By.xpath("(//tbody//tr/td[2])[1]")).getText();
			String AccountManagerGrid = driver.findElement(By.xpath("(//tbody//tr/td[4])[1]")).getText();
			String CustomerLocationGrid = driver.findElement(By.xpath("(//tbody//tr/td[5])[1]")).getText();

			assertEquals(CustomerName, CustomerNameGrid);
			assertEquals(CustomerLocation, CustomerLocationGrid);
			assertEquals(AccountManager, AccountManagerGrid);

			Thread.sleep(2000);

			logInfo.pass("Successfully Verified the Customer detail is displayed in the Grid");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));


		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("Logout of the Application")
	public void logout_of_the_Application() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "logout_of_the_Application");
			Thread.sleep(2000);

			WebElement LogoutCMP = driver.findElement(By.xpath("//span[@class='cp-user']"));
			LogoutCMP.click();
			Thread.sleep(2000);



			logInfo.pass("Successfully Logged out of CMP Portal");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

			driver.close();
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElements(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
//span[contains(text(),'Customer has been created successfully')]
//Customer has been created successfully
//*[@id="bodyscroll"]/div/div[1]/span/p-message/div/span[2]
