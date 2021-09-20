package com.zifautomation.StepDef;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.zifautomation.Listeners.ExtentReportListener;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFCatalogHomePage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZIFcatalog extends ExtentReportListener{
	PropertiesFileReader obj= new PropertiesFileReader();
	TestDataHandler testdata=new TestDataHandler();
	private WebDriver driver;
	CommonMethods cm=null;
	Loginfunction Login = null;
	Properties properties;




	@Given("Open chrome browser and enter the url")
	public void open_chrome_browser_and_enter_the_url() {
		try {
			properties = obj.getProperty();
			String sheet1="ZIFCatalog";
			String TestCaseId1="ZIFCatalogRegression";
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(properties.getProperty("testdatafilepath"), sheet1, TestCaseId1);
			testdata.setTestDataInMap(TestDataInMap);
		} catch (Exception e) {

			e.printStackTrace();
		}  
		ExtentTest logInfo=null;
		try {

			test = extent.createTest(Feature.class, "ZIF Catalog validation");
			test=test.createNode(Scenario.class, "ZIF Catalog validation");
			logInfo=test.createNode(new GherkinKeyword("Given"), "open_chrome_browser_and_enter_the_url");
			String Browser = testdata.getTestDataInMap().get("Browser");
			String URL = testdata.getTestDataInMap().get("Url");
			driver=BrowserUtility.OpenBrowser(driver, Browser, URL);
			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Given("The user is in ZIF catalog Homepage")
	public void the_user_is_in_ZIF_catalog_Homepage() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Given"), "The_user_is_in_ZIF_catalog_Homepage");
			driver.navigate().refresh();
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			String url = testdata.getTestDataInMap().get("Url");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);

			String currentUrl = driver.getCurrentUrl();

			if(currentUrl.equals(url)) {
				new Loginfunction(driver).Enterthecredentials(UserName, Password);
			}
			logInfo.pass("Successfully user is in ZIF catalog HomePage");
			//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@When("user selects CAPEX Optimization in  business outcomes")
	public void user_selects_CAPEX_Optimization_in_business_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_CAPEX_Optimization_in_business_outcomes");
			driver.navigate().refresh();
			new ZIFCatalogHomePage(driver).UnselectAllBusinessoutcomes();

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='CAPEX Optimization']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			String attribute = CBX.getAttribute("aria-checked");
			System.out.println("check checkbox");
			System.out.println(attribute);
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}


	}

	@Then("verify Correlation, Root Cause Identification are selected in technical outcomes")
	public void verify_Correlation_Root_Cause_Identification_are_selected_in_technical_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "user_selects_CAPEX_Optimization_or_Business_Service_Assurance_in_business_outcomes");
			new ZIFCatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
			logInfo.pass("Successfully verified CAPEX Optimization or Business Service Assurance technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user unselects CAPEX Optimization in  business outcomes")
	public void user_unselects_CAPEX_Optimization_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_unselects_CAPEX_Optimization_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='CAPEX Optimization']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@Then("verify Correlation, Root Cause Identification are unselected in technical outcomes")
	public void verify_Correlation_Root_Cause_Identification_are_unselected_in_technical_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "verify_Correlation_Root_Cause_Identification_are_unselected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).CAPEX_OptimizationtechnicaloutcomesUnselect();
			logInfo.pass("Successfully unselected and verified CAPEX Optimization or Business Service Assurance technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user selects OPEX Optimization in  business outcomes")
	public void user_selects_OPEX_Optimization_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_OPEX_Optimization_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='OPEX Optimization']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Given("user enters enters valid username and password and click on login button")
	public void user_enters_enters_valid_username_and_password() {

		ExtentTest logInfo=null;
		try {

			logInfo=test.createNode(new GherkinKeyword("When"), "Enterthevalidcredentials");
			String UserName = testdata.getTestDataInMap().get("UserName");
			String Password = testdata.getTestDataInMap().get("Password");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);

			logInfo.pass("Valid credential has been entered");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}


	@Then("verify all the fields are displayed in the Home Page")
	public void verify_all_the_fields_are_displayed_in_the_Home_Page() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_all_the_fields_are_displayed_in_the_Home_Page");
			new ZIFCatalogHomePage(driver).VerifyallfieldsInZIFcatalogHomePage();
			logInfo.pass("Successfully verified all the fileds in ZIF catalog Homepage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}


	}

	@Then("logout and Close the browser")
	public void logout_and_Close_the_browser() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "logout_and_Close_the_browser");
			Thread.sleep(2000);

			WebElement Logout = driver.findElement(By.xpath("//span[contains(@class,'cp-user')]"));

			Logout.click();
			Thread.sleep(2000);



			logInfo.pass("Successfully Logged out of CMP Portal");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

			driver.close();
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@Given("user is already on Login Page")
	public void user_is_already_on_Login_Page() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Given"), "user_is_already_on_Login_Page");
			String ExpectedTitle="Zif Catalog";
			String ActualTitle= driver.getTitle();
			System.out.println("ActualTitle:"+ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle,"Identified the element");

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("title of login page is Zif Catalog")
	public void title_of_login_page_is_ZIFcatalog() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "Title_of_login_page_is_ZIFcatalog");
			String ExpectedTitle="Zif Catalog";
			String ActualTitle= driver.getTitle();
			System.out.println("ActualTitle:"+ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle,"Identified the element");
			logInfo.pass("Successfully verified the ZIF catalog login page");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@When("user enters invalid username and password and click on login button")
	public void user_enters_invalid_username_and_password() {

		ExtentTest logInfo=null;
		try {

			logInfo=test.createNode(new GherkinKeyword("And"), "Enterthevalidcredentials");
			String UserName = testdata.getTestDataInMap().get("InvalidUsername");
			String Password = testdata.getTestDataInMap().get("InvalidPassword");
			new Loginfunction(driver).Enterthecredentials(UserName, Password);

			logInfo.pass("Invalid credential has been entered");
			Thread.sleep(2000);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}


	@Then("verify Correlation, Root Cause Identification, Prediction,Intelligent Automation are selected in techical outcomes")
	public void verify_Correlation_Root_Cause_Identification_Prediction_Intelligent_Automation_are_selected_in_techical_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_Correlation_Root_Cause_Identification_Prediction_Intelligent_Automation_are_selected_in_techical_outcomes");
			new ZIFCatalogHomePage(driver).OPEX_Optimizationtechnicaloutcomes();
			logInfo.pass("Successfully verified Opex Optimization technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("user will get the invalid username or password error message")
	public void user_will_get_the_invalid_username_or_password_error_message() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "user_will_get_the_invalid_username_or_password_error_message");
			//String Experrortext="Invalid Username or password";
			WebElement invalidtext = driver.findElement(By.xpath("//span[text()='Invalid Username or password']"));
			assertTrue(invalidtext.isDisplayed());

			logInfo.pass("Successfully invalid username or password error message was displayed");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}



	@When("user unselects OPEX Optimization in  business outcomes")
	public void user_unselects_OPEX_Optimization_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_unselects_OPEX_Optimization_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='OPEX Optimization']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("user should be in the ZIF catalog HomePage")
	public void user_should_be_in_the_ZIF_catalog_HomePage() {


	}

	@Then("verify Correlation, Root Cause Identification, Prediction,Intelligent Automation are unselected in techical outcomes")
	public void verify_Correlation_Root_Cause_Identification_Prediction_Intelligent_Automation_are_unselected_in_techical_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_Correlation_Root_Cause_Identification_Prediction_Intelligent_Automation_are_unselected_in_techical_outcomes");
			new ZIFCatalogHomePage(driver).OPEX_OptimizationtechnicaloutcomesUnselect();
			logInfo.pass("Successfully unselected and verified Opex Optimization technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@When("user selects Blueprinting Enterprise in  business outcomes")
	public void user_selects_Blueprinting_Enterprise_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_Blueprinting_Enterprise_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Blueprinting Enterprise']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@Then("verify Auto Discovery is selected in technical outcomes")
	public void verify_Auto_Discovery_is_selected_in_technical_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_Auto_Discovery_is_selected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Blueprinting_Enterprisetechnicaloutcomes();
			logInfo.pass("Successfully verified Blueprinting Enterprise technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user unselects Blueprinting Enterprise in  business outcomes")
	public void user_unselects_Blueprinting_Enterprise_in_business_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_unselects_Blueprinting_Enterprise_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Blueprinting Enterprise']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}


	}

	@Then("verify Auto Discovery is unselected in technical outcomes")
	public void verify_Auto_Discovery_is_unselected_in_technical_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "verify_Auto_Discovery_is_unselected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Blueprinting_EnterprisetechnicaloutcomesUnselect();
			logInfo.pass("Successfully unselected and verified Blueprinting Enterprise technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user selects Optimization of Compute in  business outcomes")
	public void user_selects_Optimization_of_Compute_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_Optimization_of_Compute_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Compute Utilization & Optimization']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("verify Prediction is selected in technical outcomes")
	public void verify_Prediction_is_selected_in_technical_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_Prediction_is_selected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Optimization_of_Computetechnicaloutcomes();
			logInfo.pass("Successfully verified Prediction technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user unselects Optimization of Compute in  business outcomes")
	public void user_unselects_Optimization_of_Compute_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_unselects_Optimization_of_Compute_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Compute Utilization & Optimization']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("verify Prediction is unselected in technical outcomes")
	public void verify_Prediction_is_unselected_in_technical_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "verify_Prediction_is_unselected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Optimization_of_ComputetechnicaloutcomesUnselect();
			logInfo.pass("Successfully unselected and verified Prediction technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@When("user selects Improvement in User Experience in  business outcomes")
	public void user_selects_Improvement_in_User_Experience_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_Improvement_in_User_Experience_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Improvement in User Experience']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("verify Correlation, Root Cause Identification, Prediction are selected in technical outcomes")
	public void verify_Correlation_Root_Cause_Identification_Prediction_are_selected_in_technical_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_Correlation_Root_Cause_Identification_Prediction_are_selected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Improvement_in_User_Experiencetechnicaloutcomes();
			logInfo.pass("Successfully verified Improvement in User Experience or Improvement in Application Availability technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@When("user unselects Improvement in User Experience in  business outcomes")
	public void user_unselects_Improvement_in_User_Experience_in_business_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_unselects_Improvement_in_User_Experience_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Improvement in User Experience']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@Then("verify Correlation, Root Cause Identification, Prediction are unselected in technical outcomes")
	public void verify_Correlation_Root_Cause_Identification_Prediction_are_unselected_in_technical_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "verify_Correlation_Root_Cause_Identification_Prediction_are_unselected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Improvement_in_User_ExperiencetechnicaloutcomesUnselect();
			logInfo.pass("Successfully unselected and verified Improvement in User Experience or Improvement in Application Availability technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user selects Improvement in Business Service Assurance in  business outcomes")
	public void user_selects_Improvement_in_Business_Service_Assurance_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_Improvement_in_Business_Service_Assurance_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Improvement in Business Service Assurance']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user unselects Improvement in Business Service Assurance in  business outcomes")
	public void user_unselects_Improvement_in_Business_Service_Assurance_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_unselects_Improvement_in_Business_Service_Assurance_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Improvement in Business Service Assurance']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user selects Shift Left in  business outcomes")
	public void user_selects_Shift_Left_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_Shift_Left_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Shift Left']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("verify Intelligent Automation, Intelligent Triaging are selected in technical outcomes")
	public void verify_Intelligent_Automation_Intelligent_Triaging_are_selected_in_technical_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_Intelligent_Automation_Intelligent_Triaging_are_selected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Shift_Lefttechnicaloutcomes();
			logInfo.pass("Successfully verified Shift Left technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user unselects Shift Left in  business outcomes")
	public void user_unselects_Shift_Left_in_business_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_unselects_Shift_Left_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Shift Left']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@Then("verify Intelligent Automation, Intelligent Triaging are unselected in technical outcomes")
	public void verify_Intelligent_Automation_Intelligent_Triaging_are_unselected_in_technical_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "verify_Intelligent_Automation_Intelligent_Triaging_are_unselected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Shift_LefttechnicaloutcomesUnselect();
			logInfo.pass("Successfully unselected and verified Shift Left technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@When("user selects Eliminating Digital Dirt in  business outcomes")
	public void user_selects_Eliminating_Digital_Dirt_in_business_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_Eliminating_Digital_Dirt_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Eliminating Digital Dirt']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@Then("verify Dependency Mapping is selected in technical outcomes")
	public void verify_Dependency_Mapping_is_selected_in_technical_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "verify_Dependency_Mapping_is_selected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Eliminating_Digital_Dirttechnicaloutcomes();
			logInfo.pass("Successfully verified Eliminating Digital Dirt technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("user unselects Eliminating Digital Dirt in  business outcomes")
	public void user_unselects_Eliminating_Digital_Dirt_in_business_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_unselects_Eliminating_Digital_Dirt_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Eliminating Digital Dirt']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("verify Dependency Mapping is unselected in technical outcomes")
	public void verify_Dependency_Mapping_is_unselected_in_technical_outcomes() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "verify_Dependency_Mapping_is_unselected_in_technical_outcomes");
			new ZIFCatalogHomePage(driver).Eliminating_Digital_DirttechnicaloutcomesUnselect();
			logInfo.pass("Successfully unselected and verified Eliminating Digital Dirt technical outcomes in ZIF catalog HomePage");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@When("user selects Improvement in Application Availability in  business outcomes")
	public void user_selects_Improvement_in_Application_Availability_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_Improvement_in_Application_Availability_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Improvement in Application Availability']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@When("user unselects Improvement in Application Availability in  business outcomes")
	public void user_unselects_Improvement_in_Application_Availability_in_business_outcomes() {

		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"), "user_unselects_Improvement_in_Application_Availability_in_business_outcomes");

			WebElement CBX = driver.findElement(By.xpath("//h5[text()='Improvement in Application Availability']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]"));
			CBX.click();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}






}
