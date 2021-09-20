package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.aventstack.extentreports.Status;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZIFAIDashboardPage {
	WebDriver driver;

	public ZIFAIDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//span[text()='Dashboard']")
	private WebElement dashboardTitle;

	@FindBy(how = How.XPATH, using="//span[text()='ZIF BOTS']")
	public WebElement ZIFBots;

	@FindBy(how = How.XPATH, using="//div[@class='zif-ic_logo']")
	private WebElement zifIclogo;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'dashboard_ic')]")
	private WebElement dashboardicon;

	@FindBy(how = How.XPATH, using = "//span[@class='newtab_icon ng-star-inserted']")
	private WebElement Adddashboardtab;

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private WebElement Adddashboardname;

	@FindBy(how = How.XPATH, using = "//div[@class='add-widget ng-star-inserted']")
	public WebElement DashboardAddwidget;

	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(),'Save')]")
	private WebElement Savedashboardname;

	@FindBy(how = How.XPATH, using="(//span[@class='ui-button-text ui-clickable'])[1]")
	public WebElement ClickApply;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'analyze_ic')]")
	private WebElement analyzeIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'analyze_ic')]//following-sibling::span")
	private WebElement analyzesubmenuIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'settings_ic')]")
	private WebElement settingsIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'await_ic')]")
	private WebElement qwaitIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'search_common_ic')]")
	private WebElement searchcommonIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'logout_ic')]")
	private WebElement logoutIcon;

	//analyzes hover
	@FindBy(how = How.XPATH, using="//*[contains(@class,'hover_menus')]")
	private WebElement analyzeshovermenu;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'OPERATIONS')]")
	private WebElement operationheader;

	@FindBy(how = How.XPATH, using="//*[contains(@class,'hover_menus')]//*[contains(text(),'Raw Data')]")
	public WebElement SMrawdata;

	@FindBy(how = How.XPATH, using="//div[normalize-space()='Analytics']")
	private WebElement SManalytics;

	@FindBy(how = How.XPATH, using="//*[contains(@class,'hover_menus')]//*[contains(text(),'Predictions')]")
	private WebElement SMpredictions;

	@FindBy(how = How.XPATH, using="//div[@class='item-content'][contains(normalize-space(),'Unassigned')]")
	public WebElement Unassignedwidget;

	@FindBy(how = How.XPATH, using="//div[@class='item-content'][contains(normalize-space(),'Critical')]")
	public WebElement Criticalwidget;

	@FindBy(how = How.XPATH, using="//div[@class='item-content'][contains(normalize-space(),'Infra')]")
	public WebElement Infrawidget;


	@FindBy(how = How.XPATH, using="//div[@class='item-content'][contains(normalize-space(),'Topten10')]")
	public WebElement Top10widget;





	public void CheckallfieldsandImages(){

		assertTrue(zifIclogo.isDisplayed());
		assertTrue(dashboardTitle.isDisplayed());
		assertTrue(dashboardicon.isDisplayed());
		assertTrue(analyzeIcon.isDisplayed());
		assertTrue(analyzesubmenuIcon.isDisplayed());
		assertTrue(settingsIcon.isDisplayed());
		assertTrue(qwaitIcon.isDisplayed());
		assertTrue(searchcommonIcon.isDisplayed());
		assertTrue(logoutIcon.isDisplayed());

	}

	public void hoveronAnalyzes(){

		Actions act = new Actions(driver);
		act.moveToElement(analyzeIcon).perform();
		assertTrue(analyzeshovermenu.isDisplayed());
	}


	public void verifyAnalyzeshovermenufields(){

		assertTrue(operationheader.isDisplayed());
		assertTrue(SMrawdata.isDisplayed());
		assertTrue(SManalytics.isDisplayed());
		assertTrue(SMpredictions.isDisplayed());
	}


	public void clickPrediction(){

		SMpredictions.click();
	}
	
	public void clickRawData(){

		SMrawdata.click();
	}

	public void LogoutClick(){

		logoutIcon.click();
	}

	public void Dashboardnavigation() {
		try {
			dashboardTitle.isDisplayed();
			Thread.sleep(2000);
			dashboardicon.click();
			Thread.sleep(2000);
			Adddashboardtab.click();
			Thread.sleep(2000);
			Adddashboardname.sendKeys("Autodash");
			Thread.sleep(2000);
			Savedashboardname.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void selectwidgetoptions() {
		try {
			//Select all the checkboxes present in Add Widget popup
			List<WebElement> checkbox_AllSize = driver.findElements(By.cssSelector("span[class='ui-inputswitch-slider']"));
			//Select all checkboxes present in Add Widget popup
			for (int a = 0; a < checkbox_AllSize.size(); a++) {
				checkbox_AllSize.get(a).click();
				Thread.sleep(1000);
			}

		} catch (Exception e) {

		}
	}





	public void clickAppSettings(){
	settingsIcon.click();
	}
	
	public void clickAnalytics(){
		SManalytics.click();
		}
}
