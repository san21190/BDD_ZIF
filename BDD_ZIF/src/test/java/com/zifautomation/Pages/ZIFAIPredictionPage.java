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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zifautomation.Base.Base;

import java.util.List;

public class ZIFAIPredictionPage extends Base{
	WebDriver driver;

	public ZIFAIPredictionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//span[text()='Operations']")
	private WebElement PredictionTitle;

	@FindBy(how = How.XPATH, using="//div[@class='zif-ic_logo']")
	private WebElement zifIclogo;

	@FindBy(how = How.XPATH, using="//span[text()='PLATFORM MANAGEMENT']")
	public WebElement Platformmanagement;

	@FindBy(how = How.XPATH, using="//div[text()='Prediction Resource Group']")
	public WebElement Predictionresourcegrp;

	@FindBy(how = How.XPATH, using="//li[text()='No results found']")
	public WebElement Filternoresultfound;

	@FindBy(how = How.XPATH, using="//input[@role='textbox']")
	public WebElement Predictionfiltertextbox;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'dashboard_ic')]")
	private WebElement dashboardicon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'analyze_ic')]")
	public WebElement analyzeIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'analyze_ic')]//following-sibling::span")
	private WebElement analyzesubmenuIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'settings_ic')]")
	public WebElement settingsIcon;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'cpu')]//..//input")
	public WebElement cpupredictionstate;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'memory')]//..//input")
	public WebElement memorypredictionstate;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'disk')]//..//input")
	public WebElement diskpredictionstate;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'network')]//..//input")
	public WebElement networkpredictionstate;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'application')]//..//input")
	public WebElement applicationpredictionstate;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'hardware')]//..//input")
	public WebElement hardwarepredictionstate;

	@FindBy(how = How.XPATH, using="//button[@label='Save']")
	public WebElement Savebutton;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'cpu')]//..//div[contains(@class,'ui-inputswitch')]")
	public WebElement cpupredictionenable;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'memory')]//..//div[contains(@class,'ui-inputswitch')]")
	public WebElement memorypredictionenable;

	@FindBy(how = How.XPATH, using="(//span[contains(@class,'pi-times')])[1]")
	public WebElement Filterclosebutton;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'disk')]//..//div[contains(@class,'ui-inputswitch')]")
	public WebElement diskpredictionenable;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'network')]//..//div[contains(@class,'ui-inputswitch')]")
	public WebElement networkpredictionenable;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'application')]//..//div[contains(@class,'ui-inputswitch')]")
	public WebElement applicationpredictionenable;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'hardware')]//..//div[contains(@class,'ui-inputswitch')]")
	public WebElement hardwarepredictionenable;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'button-tabs-name')]")
	public List <WebElement> Predictionbuttonlist;

	@FindBy(how = How.XPATH, using="//div[@class='opp-list-id']")
	public List <WebElement> PredictionoppList;

	@FindBy(how = How.XPATH, using="//div[@tooltipstyleclass='preddetails']")
	public WebElement Oppcardspredetails;


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

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'RawData')]")
	private WebElement SMrawdata;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'Analytics')]")
	private WebElement SManalytics;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'Predictions')]")
	private WebElement SMpredictions;


	@FindBy(how = How.XPATH, using="//div[contains(text(),'OPPORTUNITIES')]")
	public WebElement opportunitiesTitle;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'RESOURCE UTILIZATION')]")
	public WebElement resourceutilizationlink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'USER EXPERIENCE')]")
	private WebElement userexperiencelink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'TRANSACTION UTILIZATION')]")
	private WebElement transactionutilizationlink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'SECURITY')]")
	private WebElement securitylink;

	//adaptor status
	@FindBy(how = How.XPATH, using="//span[contains(text(),'ZIF Adapter Status')]")
	private WebElement adaptorstatustext;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-status')]")
	private WebElement adaptorhealthstatus;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-up')]")
	private WebElement adaptorhealthstatusup;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-down')]")
	private WebElement adaptorhealthstatusdown;

	@FindBy(how = How.XPATH, using="//div[contains(@class,'filters')]")
	public WebElement filterIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-apply_filter')]")
	public WebElement filterthreedots;
	@FindBy(how = How.XPATH, using="//*[contains(@class,'close')]")
	public WebElement closefilter;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'settings')]")
	private WebElement predictionsettingsIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'pref')]")
	private WebElement prefereceIcon;
	@FindBy(how = How.XPATH, using="//*[contains(text(),'Clear')]")
	public WebElement filterclear;
	@FindBy(how = How.XPATH, using = "//*[contains(@formcontrolname,'resource')]")
	public WebElement Resourcefltr;
	@FindBy(how = How.XPATH, using="//*[contains(@aria-label,'network')]")
	public WebElement filternetwork;
	@FindBy(how = How.XPATH, using="//*[contains(@aria-label,'application')]")
	public WebElement filterapplication;
	@FindBy(how = How.XPATH, using="//span[contains(normalize-space(),'Apply')]")
	public WebElement filterapply;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'ui-dropdown-trigger')])[3]")
	public WebElement Filtercounters;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'ui-dropdown-trigger')])[4]")
	public WebElement Filterdrive;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'ui-dropdown-trigger')])[2]")
	public WebElement FilterResourcedropdown;
	@FindBy(how = How.XPATH, using="//li[@aria-label='cpu']")
	public WebElement Filterresourcecpu;



	//SwinLanes

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[1]//div[contains(text(),'Predicted Risk (Warning)')]")
	private WebElement Predictedrisk;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(text(),'Currently at Risk (Critical)')]")
	private WebElement currentlyAtrisk;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(text(),'(Impact <= 60 mins)')]")
	private WebElement currentlyAtriskImpact;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[3]//div[contains(text(),'Processed')]")
	private WebElement processed;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[4]//div[contains(text(),'Lost')]")
	private WebElement lost;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[5]//div[contains(text(),'Invalid')]")
	private WebElement invalid;




	//Predict Risk Lane Opportunity cards
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards warn-state ng-star-inserted')]")
	public WebElement PRcardval;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards warn-state ng-star-inserted')][1]")
	public WebElement PRcardvalfirst;
	@FindBy(how = How.CSS, using="div[class='opp-cards highlight-card warn-state ng-star-inserted'] div[class='opp-list-id']")
	public WebElement PRcardvalLHS;
	@FindBy(how = How.CSS, using="span[class='det-opp-id ng-star-inserted']")
	public WebElement PRcardvalRHS;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement PRcard1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement PRcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-box')])[1]")
	private WebElement PRcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement PRcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement PRcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement PRcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement PRcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	public WebElement PRcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	public WebElement PRcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	public WebElement PRcardack;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	public WebElement PRcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	public WebElement PRcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	public WebElement PRcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	public WebElement PRcarddecline;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'no-data-cls')]")
	public WebElement PRnodataAvailable;

	//Currently at Risk (Critical) Lane Opportunity cards
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards critical-state ng-star-inserted')]")
	public WebElement CARcardval;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards critical-state ng-star-inserted')][1]")
	public WebElement CARcardvalfirst;
	@FindBy(how = How.CSS, using="div[class='opp-cards highlight-card critical-state ng-star-inserted'] div[class='opp-list-id']")
	public WebElement CARcardvalLHS;
	@FindBy(how = How.CSS, using="span[class='det-opp-id ng-star-inserted']")
	public WebElement CARcardvalRHS;
	//@FindBy(how = How.CSS, using="//div[@class='opp-cards critical-state ng-star-inserted']//div[@class='opp-card-action opp-card-unack']")
	//public WebElement CARunackdmsg;
	//@FindBy(how = How.CSS, using="//div[@class='opp-cards critical-state ng-star-inserted']//div[@class='opp-card-action ic_ack']")
	//public WebElement CARackdmsg;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement CRcard1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement CRcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-box')])[1]")
	private WebElement CRcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement CRcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement CRcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement CRcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement CRcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	public WebElement CRcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	public WebElement CRcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	public WebElement CRcardack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	public WebElement CRcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	public WebElement CRcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	public WebElement CRcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	public WebElement CRcarddecline;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'no-data-cls')]")
	public WebElement CRnodataAvailable;
	@FindBy(how = How.XPATH, using="//span[@class='button-tabs-name name-width-resize ng-star-inserted' and contains(text(), 'Root Cause')]")
	public WebElement Rootcausegrp;
	@FindBy(how = How.XPATH, using="//span[@class='button-tabs-name name-width-resize ng-star-inserted' and contains(text(), 'CPU')]")
	public WebElement CPUgrp;
	@FindBy(how = How.XPATH, using="//span[@class='button-tabs-name name-width-resize ng-star-inserted' and contains(text(), 'Application')]")
	public WebElement Applicationgrp;
	@FindBy(how = How.XPATH, using="//span[@class='button-tabs-name name-width-resize ng-star-inserted' and contains(text(), 'Disk')]")
	public WebElement Diskgrp;
	@FindBy(how = How.XPATH, using="//span[@class='button-tabs-name name-width-resize ng-star-inserted' and contains(text(), 'Memory')]")
	public WebElement Memorygrp;
	@FindBy(how = How.XPATH, using="//span[@class='button-tabs-name name-width-resize ng-star-inserted' and contains(text(), 'Network')]")
	public WebElement Networkgrp;
	@FindBy(how = How.CSS, using="div[dashboard div.dashb-mainpage app-predictions.ng-star-inserted:nth-child(3) div.component-body.ng-star-inserted:nth-child(1) app-prediction-details.ng-star-inserted div.outer-pred-det div.pred-det-right div.charts-pane div.opp-det-charts.ng-star-inserted:nth-child(2) div.opp-det-chart-h1.ng-star-inserted span.ng-star-inserted highcharts-chart.line_charts_pred div.highcharts-container svg.highcharts-root g.highcharts-range-selector-group:nth-child(22) g.highcharts-range-selector-buttons g.highcharts-button.highcharts-button-hover:nth-child(3) > text:nth-child(2)]")
	public WebElement chart1d;
	@FindBy(how = How.CSS, using="div[dashboard div.dashb-mainpage app-predictions.ng-star-inserted:nth-child(3) div.component-body.ng-star-inserted:nth-child(1) app-prediction-details.ng-star-inserted div.outer-pred-det div.pred-det-right div.charts-pane div.opp-det-charts.ng-star-inserted:nth-child(2) div.opp-det-chart-h1.ng-star-inserted span.ng-star-inserted highcharts-chart.line_charts_pred div.highcharts-container svg.highcharts-root g.highcharts-range-selector-group:nth-child(22) g.highcharts-range-selector-buttons g.highcharts-button.highcharts-button-hover:nth-child(4) > text:nth-child(2)]")
	public WebElement chart1m;
	@FindBy(how = How.CSS, using="div[dashboard div.dashb-mainpage app-predictions.ng-star-inserted:nth-child(3) div.component-body.ng-star-inserted:nth-child(1) app-prediction-details.ng-star-inserted div.outer-pred-det div.pred-det-right div.charts-pane div.opp-det-charts.ng-star-inserted:nth-child(2) div.opp-det-chart-h1.ng-star-inserted span.ng-star-inserted highcharts-chart.line_charts_pred div.highcharts-container svg.highcharts-root g.highcharts-range-selector-group:nth-child(22) g.highcharts-range-selector-buttons g.highcharts-button.highcharts-button-hover:nth-child(5) > text:nth-child(2)]")
	public WebElement chartall;



	//Processed Lane Opportunity cards
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement PDcard1;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards processed-state ng-star-inserted')]")
	public WebElement PDcardval;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards processed-state ng-star-inserted')][1]")
	public WebElement PDcardvalfirst;
	@FindBy(how = How.CSS, using="div[class='opp-cards highlight-card processed-state ng-star-inserted'] div[class='opp-list-id']")
	public WebElement PDcardvalLHS;
	@FindBy(how = How.CSS, using="span[class='det-opp-id ng-star-inserted']")
	public WebElement PDcardvalRHS;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement PDcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-box')])[1]")
	private WebElement PDcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement PDcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement PDcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement PDcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement PDcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	private WebElement PDcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	public WebElement PDcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	public WebElement PDcardack;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	public WebElement PDcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	public WebElement PDcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	public WebElement PDcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	public WebElement PDcarddecline;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'no-data-cls')]")
	public WebElement PDnodataAvailable;

	//Lost Lane Opportunity cards
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement LTcard1;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards lost-state ng-star-inserted')]")
	public WebElement LTcardval;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards lost-state ng-star-inserted')][1]")
	public WebElement LTcardvalfirst;
	@FindBy(how = How.CSS, using="div[class='opp-cards highlight-card lost-state ng-star-inserted'] div[class='opp-list-id']")
	public WebElement LTcardvalLHS;
	@FindBy(how = How.CSS, using="span[class='det-opp-id ng-star-inserted']")
	public WebElement LTcardvalRHS;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement LTcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-box')])[1]")
	private WebElement LTcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement LTcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement LTcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement LTcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement LTcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	private WebElement LTcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	public WebElement LTcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	public WebElement LTcardack;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	public WebElement LTcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	public WebElement LTcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	public WebElement LTcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	public WebElement LTcarddecline;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'no-data-cls')]")
	public WebElement LTnodataAvailable;



	//Invalid Lane Opportunity cards
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-cards lost-state')][1]")
	public WebElement IVcard1;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards invalid-state ng-star-inserted')]")
	public WebElement IVcardval;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards invalid-state ng-star-inserted')][1]")
	public WebElement IVcardvalfirst;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'opp-cards invalid-state ng-star-inserted')]")
	public List<WebElement> IVcardvallist;

	@FindBy(how = How.CSS, using="div[class='opp-cards highlight-card invalid-state ng-star-inserted'] div[class='opp-list-id']")
	public WebElement IVcardvalLHS;
	@FindBy(how = How.CSS, using="span[class='det-opp-id ng-star-inserted']")
	public WebElement IVcardvalRHS;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-list-more')])[1]")
	private WebElement IVcardlistmore;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-box')])[1]")
	private WebElement IVcardlistmorehovermenu;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Business Process')])[1]")
	private WebElement IVcardhoverop1;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Services')])[1]")
	private WebElement IVcardhoverop2;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Applications')])[1]")
	private WebElement IVcardhoverop3;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'more-info-subs')]//span[contains(text(),'Devices')])[1]")
	private WebElement IVcardhoverop4;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//span[contains(@ptooltip,'Est. Time to Impact')])[1]")
	private WebElement IVcardEstTimetoImpact;

	//Acknowledge Option 
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-unack')])[1]")
	public WebElement IVcardunack;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action ic_ack')])[1]")
	public WebElement IVcardack;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	public WebElement IVcardexport;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-notes')])[1]")
	public WebElement IVcardnotes;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-reso')])[1]")
	public WebElement IVcardreso;
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-decline')])[1]")
	public WebElement IVcarddecline;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'no-data-cls')]")
	public WebElement IVnodataAvailable;
	@FindBy(how = How.XPATH, using="//div[@class='opp-etidetails ng-star-inserted']")
	public WebElement ETItime;









	
	












	//Installation and Activation of ZIF One Agent
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Installation and Activation of ZIF One Agent')]")
	private WebElement InstallationandActivationHeader;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Device Configuration')]")
	private WebElement DeviceConfig;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Integration')]")
	private WebElement Integration;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'closeAd')]")
	public WebElement closeAd;

	//Integration
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Integrate with existing monitoring tool')]")
	private WebElement Intergratelink;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Download ZIF One Agent')]")
	private WebElement DownloadoneAgent;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Download is in progress')]")
	private WebElement downloadProgress;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Download is complete')]")
	private WebElement downloadcomplete;

	//Device Configuration


	@FindBy(how = How.XPATH, using="//span[contains(text(),'Select by Device')]")
	private WebElement selectdevice;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Select by Category')]")
	private WebElement selectcategory;




	public void checkuserinPredictionPage(){

		assertTrue(PredictionTitle.isDisplayed());
	}


	public void CheckallfieldsandImages(){

		assertTrue(zifIclogo.isDisplayed());
		assertTrue(PredictionTitle.isDisplayed());
		assertTrue(opportunitiesTitle.isDisplayed());
		assertTrue(dashboardicon.isDisplayed());
		assertTrue(analyzeIcon.isDisplayed());
		assertTrue(analyzesubmenuIcon.isDisplayed());
		assertTrue(settingsIcon.isDisplayed());
		assertTrue(qwaitIcon.isDisplayed());
		assertTrue(searchcommonIcon.isDisplayed());
		assertTrue(logoutIcon.isDisplayed());

	}

	public void checkallpredictionfields(){

		assertTrue(resourceutilizationlink.isDisplayed());
		assertTrue(transactionutilizationlink.isDisplayed());
		assertTrue(userexperiencelink.isDisplayed());
		assertTrue(securitylink.isDisplayed());
		assertTrue(adaptorstatustext.isDisplayed());
		assertTrue(adaptorhealthstatus.isDisplayed());
		assertTrue(filterIcon.isDisplayed());
		assertTrue(predictionsettingsIcon.isDisplayed());
		assertTrue(prefereceIcon.isDisplayed());

	}

	public void verifySwinlaneFields(){
		assertTrue(Predictedrisk.isDisplayed());
		assertTrue(currentlyAtrisk.isDisplayed());
		assertTrue(currentlyAtriskImpact.isDisplayed());
		assertTrue(processed.isDisplayed());
		assertTrue(lost.isDisplayed());
		assertTrue(invalid.isDisplayed());		
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

	public boolean adaptorstatuscheck() {
		try {
			adaptorhealthstatusup.isDisplayed();
			return true;
		}catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}}

	public void PredictionSettingsClick(){

		predictionsettingsIcon.click();

	}

	public void PredictionSettingsfieldvalidation(){
		assertTrue(InstallationandActivationHeader.isDisplayed());
		assertTrue(Integration.isDisplayed());
		assertTrue(DeviceConfig.isDisplayed());
		assertTrue(closeAd.isDisplayed());
		assertTrue(Intergratelink.isDisplayed());
		assertTrue(DownloadoneAgent.isDisplayed());
	}

	public void downloadOneAgent() {
		WebDriverWait wait=new WebDriverWait(driver,20);
		DownloadoneAgent.click();
		WebElement downloadinprogress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Download is in progress')]")));
		downloadinprogress.isDisplayed();

		WebElement downloadcompleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Download is complete')]")));
		downloadcompleted.isDisplayed();
	}

	public void closePredictionsettings() {
		closeAd.click();
	}

	public void Integration_Tab() {
		Integration.click();
	}

	public void Device_Configuration_Tab() {
		DeviceConfig.click();
	}

	public void verifyWarningOppcardDetails() {
	
	assertTrue(PRcardlistmore.isDisplayed());
	assertTrue(PRcardEstTimetoImpact.isDisplayed());
	assertTrue(PRcardexport.isDisplayed());
	assertTrue(PRcardnotes.isDisplayed());
	assertTrue(PRcardreso.isDisplayed());
	assertTrue(PRcarddecline.isDisplayed());


	Actions act = new Actions(driver);
	act.moveToElement(PRcardlistmore).perform();
	assertTrue(PRcardlistmorehovermenu.isDisplayed());
	assertTrue(PRcardhoverop1.isDisplayed());
	assertTrue(PRcardhoverop2.isDisplayed());
	assertTrue(PRcardhoverop3.isDisplayed());
	assertTrue(PRcardhoverop4.isDisplayed());
	
	}
	
	public void verifyCriticalOppcardDetails() {
	assertTrue(CRcardlistmore.isDisplayed());
	assertTrue(CRcardEstTimetoImpact.isDisplayed());
	assertTrue(CRcardexport.isDisplayed());
	assertTrue(CRcardnotes.isDisplayed());
	assertTrue(CRcardreso.isDisplayed());
	assertTrue(CRcarddecline.isDisplayed());


	Actions act = new Actions(driver);
	act.moveToElement(CRcardlistmore).perform();
	assertTrue(CRcardlistmorehovermenu.isDisplayed());
	assertTrue(CRcardhoverop1.isDisplayed());
	assertTrue(CRcardhoverop2.isDisplayed());
	assertTrue(CRcardhoverop3.isDisplayed());
	assertTrue(CRcardhoverop4.isDisplayed());
	
	}
	
	public void verifyProcessedOppcardDetails() {
	assertTrue(PDcardlistmore.isDisplayed());
	assertTrue(PDcardEstTimetoImpact.isDisplayed());
	assertTrue(PDcardexport.isDisplayed());
	assertTrue(PDcardnotes.isDisplayed());
	assertTrue(PDcardreso.isDisplayed());
	assertTrue(PDcarddecline.isDisplayed());


	Actions act = new Actions(driver);
	act.moveToElement(PDcardlistmore).perform();
	assertTrue(PDcardlistmorehovermenu.isDisplayed());
	assertTrue(PDcardhoverop1.isDisplayed());
	assertTrue(PDcardhoverop2.isDisplayed());
	assertTrue(PDcardhoverop3.isDisplayed());
	assertTrue(PDcardhoverop4.isDisplayed());
	}
	
	public void verifyLostOppcardDetails() {

		assertTrue(LTcardlistmore.isDisplayed());
		assertTrue(LTcardEstTimetoImpact.isDisplayed());
		assertTrue(LTcardexport.isDisplayed());
		assertTrue(LTcardnotes.isDisplayed());
		assertTrue(LTcardreso.isDisplayed());
		assertTrue(LTcarddecline.isDisplayed());


		Actions act = new Actions(driver);
		act.moveToElement(LTcardlistmore).perform();
		assertTrue(LTcardlistmorehovermenu.isDisplayed());
		assertTrue(LTcardhoverop1.isDisplayed());
		assertTrue(LTcardhoverop2.isDisplayed());
		assertTrue(LTcardhoverop3.isDisplayed());
		assertTrue(LTcardhoverop4.isDisplayed());

	}

	public void verifyInvalidOppcardDetails() {

		assertTrue(IVcardlistmore.isDisplayed());
		assertTrue(IVcardEstTimetoImpact.isDisplayed());
		assertTrue(IVcardexport.isDisplayed());
		assertTrue(IVcardnotes.isDisplayed());
		assertTrue(IVcardreso.isDisplayed());
		assertTrue(IVcarddecline.isDisplayed());


		Actions act = new Actions(driver);
		act.moveToElement(IVcardlistmore).perform();
		assertTrue(IVcardlistmorehovermenu.isDisplayed());
		assertTrue(IVcardhoverop1.isDisplayed());
		assertTrue(IVcardhoverop2.isDisplayed());
		assertTrue(IVcardhoverop3.isDisplayed());
		assertTrue(IVcardhoverop4.isDisplayed());

	}
}
