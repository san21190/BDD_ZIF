package com.zifautomation.Pages;

import com.zifautomation.Utility.CommonMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ZIFAI_MonitoringPage {

	WebDriver driver;


	public ZIFAI_MonitoringPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Disk Capacity')]/span")
	public WebElement DiskCapacity;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Memory Capacity')]/span")
	public WebElement MemoryCapacity;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'CPU Capacity')]/span")
	public WebElement CPUCapacity;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tab-filters')]")
	public WebElement AlertsFilter;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='dev_name']")
	public WebElement Filterdevicename;

	@FindBy(how = How.XPATH, using = "//input[@value='Apply']")
	public WebElement FilterApply;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='View Details']")
	public WebElement Deviceviewdetails;



}
