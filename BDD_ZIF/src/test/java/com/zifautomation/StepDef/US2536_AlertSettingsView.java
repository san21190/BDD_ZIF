package com.zifautomation.StepDef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.zifautomation.Listeners.ExtentReportListener;
import com.zifautomation.Pages.CMPLandingpage;

import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
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

public class US2536_AlertSettingsView extends ExtentReportListener
{
	PropertiesFileReader obj= new PropertiesFileReader();
	TestDataHandler testdata=new TestDataHandler();
	private WebDriver driver;
	CommonMethods cm=null;
	Loginfunction Login = null;

	Properties properties;

	
}

