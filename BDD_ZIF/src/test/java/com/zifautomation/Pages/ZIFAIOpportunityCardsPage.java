package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZIFAIOpportunityCardsPage {
	WebDriver driver;

	public ZIFAIOpportunityCardsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//span[text()='Dashboard']")
	private WebElement dashboardTitle;

	@FindBy(how = How.XPATH, using="//div[@class='zif-ic_logo']")
	private WebElement zifIclogo;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'dashboard_ic')]")
	private WebElement dashboardicon;

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
	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]")
	private WebElement analyzeshovermenu;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'OPERATIONS')]")
	private WebElement operationheader;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//div[contains(text(),'Raw Data')]")
	private WebElement SMrawdata;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//div[contains(text(),'Analytics')]")
	private WebElement SManalytics;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//div[contains(text(),'Predictions')]")
	private WebElement SMpredictions;


	//Opportunity cards details
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Reason:')]")
	private WebElement reason;
	
	
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Reason:')]/following::div[1]")
	private WebElement reasonText;
	
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Business Process')]")
	private WebElement businessprocess;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Services')]")
	private WebElement services;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Application')]")
	private WebElement application;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Devices')]")
	private WebElement devices;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Show Details')]")
	private WebElement showdrivesLink;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'derives-bar ng-star-inserted')]")
	private WebElement showdrivespanel;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Drives/Mount')]")
	private WebElement Drivesheader;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'closeAd drives-close')]")
	private WebElement closeshowdrives;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Save')]")
	private WebElement Saveshowdrives;
	
	
	
	  @FindBy(how = How.XPATH,
	  using="//label[contains(text(),'/dev')]") private WebElement
	  devdrivecbx;
	  
	  @FindBy(how = How.XPATH,
	  using="//label[contains(text(),'/boot')]") private
	  WebElement bootdrivecbx;
	 
	
	
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Root Cause')]")
	private WebElement rootcause;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'CPU')]")
	private WebElement cpu;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Disk')]")
	private WebElement disk;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Memory')]")
	private WebElement memory;

	@FindBy(how = How.XPATH, using="//div[contains(@class,'closeAd')]")
	private WebElement closeAd;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-det-charts')])[1]")
	private WebElement graphone;

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

	public void LogoutClick(){

		logoutIcon.click();
	}
	
	public void clickAppSettings(){
	settingsIcon.click();
	}
	
	public void clickAnalytics(){
		SManalytics.click();
		}
	
	public void CheckallfieldsinOpportunityCards(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		assertTrue(reason.isDisplayed());
		assertTrue(reasonText.isDisplayed());
		assertTrue(businessprocess.isDisplayed());
		assertTrue(services.isDisplayed());
		assertTrue(application.isDisplayed());
		assertTrue(devices.isDisplayed());
		assertTrue(rootcause.isDisplayed());
		assertTrue(cpu.isDisplayed());
		assertTrue(disk.isDisplayed());
		assertTrue(memory.isDisplayed());
		assertTrue(closeAd.isDisplayed());
		WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-det-charts')])[1]")));
		assertTrue(graph.isDisplayed());
	}
	
	public void clickCPU(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		cpu.click();
		WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-det-charts')])[1]")));
		assertTrue(graph.isDisplayed());
		
	}
	public void clickMemory(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		memory.click();
		WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-det-charts')])[1]")));
		assertTrue(graph.isDisplayed());
		
	}
	
	public void clickDisk(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		disk.click();
		WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-det-charts')])[1]")));
		assertTrue(graph.isDisplayed());
		WebElement graph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-det-charts')])[2]")));
		assertTrue(graph1.isDisplayed());
		
		assertTrue(showdrivesLink.isDisplayed());
		showdrivesLink.click();
		assertTrue(showdrivespanel.isDisplayed());
		assertTrue(Drivesheader.isDisplayed());
		assertTrue(closeshowdrives.isDisplayed());
		assertTrue(Saveshowdrives.isDisplayed());
		assertTrue(devdrivecbx.isDisplayed());
		assertTrue(bootdrivecbx.isDisplayed());
		closeshowdrives.click();
		
	}
	
	public void showDiskdrivecheck(){
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		showdrivesLink.click();
		devdrivecbx.click();
		Saveshowdrives.click();
		WebElement graph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-det-charts')])[1]")));
		assertTrue(graph.isDisplayed());	
		
	}
	
	
	public void closeAd(){
		closeAd.click();
		}
}
