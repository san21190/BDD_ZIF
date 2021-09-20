package com.zifautomation.StepDef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.zifautomation.Listeners.ExtentReportListener;

import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.PropertiesFileReader;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

import static junit.framework.Assert.assertTrue;

public class LoginScenario extends ExtentReportListener
{
	PropertiesFileReader obj= new PropertiesFileReader();
	private WebDriver driver;
	CommonMethods cm=null;
	Loginfunction Login = null;

	@Given("^Open Chrome browser with URL$")
	public void open_Chrome_browser_with_URL() throws Throwable
	{
		ExtentTest logInfo=null;
		try {

			test = extent.createTest(Feature.class, "Login Page validation");
			test=test.createNode(Scenario.class, "Login Page validation");
			logInfo=test.createNode(new GherkinKeyword("Given"), "open_Chrome_browser_with_URL");
			Properties properties=obj.getProperty();
			driver=BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("^Verify the Login page fields$")
	public void Verify_the_loginpage_fields() throws IOException {
		{
			ExtentTest logInfo = null;
			try {
				logInfo = test.createNode(new GherkinKeyword("Then"), "Verify_the_loginpage_fields");


				new Loginfunction(driver).Check_all_fields_are_present();

				logInfo.pass("Successfully verified the Login page field");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL", driver, logInfo, e);
			}
		}
	}




	@Then("^Verify whether the email should have valid domain$")
	public void Verifytheinvaliddomain() throws Throwable
	{
		ExtentTest logInfo=null;
		try {

			logInfo=test.createNode(new GherkinKeyword("And"), "Verifytheinvalidbutton");
			new Loginfunction(driver).Enterthecredentials("zifadminzif.ai", "Zee4F@431");
			logInfo.pass("Invalid domain has been verified");
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}


	}

	@When("^Login the application$")
	public void Entertheinvalidcredentials() throws Throwable
	{
		ExtentTest logInfo=null;
		try {

			logInfo=test.createNode(new GherkinKeyword("When"), "Entertheinvalidcredentials");
//			driver.navigate().refresh();
			new Loginfunction(driver).Enterthecredentials("zifadmin@zif.ai", "Zee4F41");
			logInfo.pass("Invalid credentials entered");


		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}


	@Then("^Verify the invalid login$")
	public void validate_Invalid_Login() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "validate_Invalid_Login");
			String ExpectedTitle="CMP";
			String ActualTitle=driver.getTitle();
			System.out.println("ActualTitle:"+ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle,"Identified the element");
			logInfo.pass("Successfully logged the application");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}

	}

	@And("^Enter the Valid credentials$")
	public void Enterthevalidcredentials() throws Throwable
	{
		ExtentTest logInfo=null;
		try {

			logInfo=test.createNode(new GherkinKeyword("And"), "Enterthevalidcredentials");
			new Loginfunction(driver).Enterthecredentials("zifadmin@zif.ai", "Zee4F@431");
			logInfo.pass("Valid credential has been entered");
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}


	}

	@Then("^Verify the login successfully$")
	public void validate_valid_Login() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "validate_valid_Login");
			String ExpectedTitle="CMP";
			String ActualTitle= driver.getTitle();
			System.out.println("ActualTitle:"+ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle,"Identified the element");
			logInfo.pass("Successfully logged the application");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			driver.quit();

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
