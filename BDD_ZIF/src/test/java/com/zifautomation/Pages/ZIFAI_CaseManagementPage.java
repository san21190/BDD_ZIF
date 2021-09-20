package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZIFAI_CaseManagementPage {
	WebDriver driver;

	public ZIFAI_CaseManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Dashboard']")
	private WebElement dashboardTitle;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'ui-dropdown-trigger')])[2]")
	public WebElement Userdropdown;

	@FindBy(how = How.XPATH, using = "//span[text()='Update']")
	public WebElement Updateaccessgroup;

	@FindBy(how = How.XPATH, using = "//div[@id=\"ui-accordiontab-5-content\"]")
	public WebElement InventoryAccordion;

	@FindBy(how = How.XPATH, using = "//span[text()=' Inventory(Raw data) ']//..//span[contains(@class,'pi-plus')]")
	public WebElement Inventoryplussign;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Allow to add Virtualization')]//..//*[@id=\"i\"]/div/div/input")
	public WebElement Enablevirtual;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Allow to add Virtualization')]//..//div[contains(@class,'ui-inputswitch')]")
	public WebElement Clickvirtual;

	@FindBy(how = How.XPATH, using = "(//li[@aria-label])[2]")
	public WebElement Useroption;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	public WebElement Searchtext;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'pi-pencil')]")
	public WebElement Editicon;

	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div[4]/div")
	public WebElement Descriptionalerts;

	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'ui-chkbox')])[1]")
	public WebElement Createddateclick;

	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'ui-chkbox')])[2]")
	public WebElement Updateddateclick;

	@FindBy(how = How.XPATH, using = "//div[@class='zif-ic_logo']")
	private WebElement zifIclogo;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'dashboard_ic')]")
	private WebElement dashboardicon;

	@FindBy(how = How.XPATH, using = "//span[@class='newtab_icon ng-star-inserted']")
	private WebElement Adddashboardtab;

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private WebElement Adddashboardname;

	@FindBy(how = How.XPATH, using = "//div[@class='add-widget ng-star-inserted']")
	private WebElement DashboardAddwidget;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'ui-button-text ui-clickable']")
	private WebElement Savedashboardname;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'analyze_ic')]")
	public WebElement analyzeIcon;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'analyze_ic')]//following-sibling::span")
	private WebElement analyzesubmenuIcon;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'settings_ic')]")
	private WebElement settingsIcon;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'await_ic')]")
	private WebElement qwaitIcon;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'search_common_ic')]")
	private WebElement searchcommonIcon;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'logout_ic')]")
	private WebElement logoutIcon;

	//analyzes hover
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'hover_menus')]")
	public WebElement analyzeshovermenu;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'ALERTS')]")
	public WebElement rawdataalerts;
	@FindBy(how = How.XPATH, using = "//span[@class='alert-num']")
	public WebElement alertscount;

	//@FindBy(how = How.XPATH, using="//span[text()=' OPERATIONS :']")
	//private WebElement operationheader;

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'hover_menus')]//*[contains(text(),'Operations')]")
	private WebElement operationheader;

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'hover_menus')]//*[contains(text(),'Raw Data')]")
	public WebElement SMrawdata;

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'hover_menus')]//*[contains(text(),'Analytics')]")
	public WebElement SManalytics;

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'hover_menus')]//*[contains(text(),'Predictions')]")
	private WebElement SMpredictions;


	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Operations')]")
	private WebElement OperationsTitle;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'ANALYTICS :')]")
	private WebElement ANALYTICShdr;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'CASE MANAGEMENT')]")
	private WebElement caseManagementLink;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'INCIDENT ANALYTICS')]")
	private WebElement incidentAnalyticsLink;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'SECURITY')]")
	private WebElement securitylink;


	//Suppression 

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'supp_img_h')]")
	private WebElement supressionicon;
	@FindBy(how = How.XPATH, using = "//span[text()='Enable Noise Cancellation']//..//span[@class='ui-inputswitch-slider']")
	public WebElement EnableNoiseCancellation;

	@FindBy(how = How.XPATH, using = "//div[contains(@ptooltip,'Suppression')]")
	private WebElement supressionTooltip;

	//Correlation

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'gtm_img_n')]")
	private WebElement Correlationicon;
	@FindBy(how = How.XPATH, using = "//div[contains(@ptooltip,'Correlation')]")
	private WebElement CorrelationTooltip;
	@FindBy(how = How.XPATH, using = "//span[text()='Apply']//..//span[@class='ui-button-text ui-clickable']")
	public WebElement Applybuttonstng;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div[1]/div[2]/div")
	public WebElement correlatedalertscountfirst;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div[2]/div")
	public WebElement correlatedalertscountvaluesecond;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div[3]/div")
	public WebElement correlatedalertscountvaluesthird;

	//Warning ok Button

	@FindBy(how = How.CSS, using = "button[class='ok-btn ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'] span[class='ui-button-text ui-clickable']")
	public WebElement warningokbutton;

	//adaptor status
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'ZIF Adapter Status')]")
	private WebElement adaptorstatustext;
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'zif-health-status')]")
	private WebElement adaptorhealthstatus;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'zif-health-up')]")
	private WebElement adaptorhealthstatusup;
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'zif-health-down')]")
	private WebElement adaptorhealthstatusdown;

	//live feed 
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'enable-menu tab-livefeed')]")
	public WebElement livefeedon;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'enable-menu tab-pausefeed')]")
	public WebElement livefeedoff;

	//Tech Bot
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'enable-menu techbot-activate')]")
	private WebElement techboton;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'enable-menu techbot-deactivate')]")
	private WebElement techbotoff;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'ic_ack techBot_Ack')])")
	public List<WebElement> techbotacknowledgment;

	//Filter
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'filters')]")
	private WebElement filterIcon;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'filter')]")
	private WebElement filterIconwithdots;

	//Export
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tab-export')]")
	public WebElement ExportrIcon;
	@FindBy(how = How.XPATH, using = "//div[contains(@ptooltip,'Export')]")
	private WebElement ExportTooltip;

	//Preference 
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tab-pref')]")
	public WebElement prefereceIcon;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tab-apply_pref')]")
	public WebElement prefereceIconwithdots;
	@FindBy(how = How.XPATH, using = "//div[contains(@ptooltip,'Preferences')]")
	private WebElement prefereceIconTooltip;
	// Case Management Settings Icon
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'settings')]")
	public WebElement alertSettingsIcon;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tab-settings enable-menu')]")
	private WebElement alertSettingsIconenabled;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tab-settings disabled-menu')]")
	private WebElement alertSettingsIconDisabled;
	@FindBy(how = How.XPATH, using = "//*[contains(@ptooltip,'Settings')]")
	private WebElement alertSettingsTooltip;
	@FindBy(how = How.XPATH, using = "//div[contains(@tooltipstyleclass,'alrt_desc')]")
	public List <WebElement> correlatedlalertscolumn;



	//Alert with 2 - 5 same Description

	@FindBy(how = How.XPATH, using = "(//*[@class='case-second-txt padding-bell' and text()='2'])[1]")
	private WebElement Alertwith2;
	@FindBy(how = How.XPATH, using = "(//*[@class='case-second-txt padding-bell' and text()='3'])[1]")
	private WebElement Alertwith3;
	@FindBy(how = How.XPATH, using = "(//*[@class='case-second-txt padding-bell' and text()='4'])[1]")
	private WebElement Alertwith4;
	@FindBy(how = How.XPATH, using = "(//*[@class='case-second-txt padding-bell' and text()='5'])[1]")
	private WebElement Alertwith5;


	//Inside Alert

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Acknowledge')]")
	public WebElement AlertAcknowledge;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Export')]")
	public WebElement AlertExport;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Edit')]")
	public WebElement AlertEdit;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Expand')]")
	private WebElement AlertExpand;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Collapse')]")
	private WebElement AlertCollapse;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'closeAd')]")
	public WebElement AlertClose;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Root cause')]")
	private WebElement AlertRootcause;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Correlated Alerts')]")
	public WebElement CorrelatedAlerts;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Timeline')]")
	public WebElement Timeline;


	// First Alerts ID and its Status

	@FindBy(how = How.XPATH, using = "(//*[@class='analytics_id'])[1]")
	private WebElement FirtsAlertID;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'case-first-left-icon-2-new')])[1]")
	private WebElement FirtsAlertNewStatus;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'case-first-left-icon-2-assigned')])[1]")
	private WebElement FirtsAlertAssignedStatus;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'case-first-left-icon-2 corr_inprogress')])[1]")
	private WebElement FirtsAlertInprogressStatus;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'case-first-left-icon-2-closed')])[1]")
	private WebElement FirtsAlertClosedStatus;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'case-first-left-icon-1 case-first-left-icon-1-no')])[1]")
	private WebElement FirstAlertNoserveritymapped;


	// Edit Alerts Status 
	@FindBy(how = How.XPATH, using = "//*[contains(@formcontrolname,'status')]")
	public WebElement StatusDD;
	@FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'New')]")
	public WebElement DDNewStatus;
	@FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Assigned')]")
	public WebElement DDAssignedStatus;
	@FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'InProgress')]")
	public WebElement DDInprogressStatus;
	@FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Closed')]")
	public WebElement DDClosedStatus;

	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Notes')]/following::*//textarea)[1]")
	public WebElement NotesText;
	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Reference')]/following::*//textarea)[1]")
	public WebElement ReferenceText;

	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(),'Apply')]")
	public WebElement ApplyEdit;
	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(),'Clear')]")
	public WebElement ClearEdit;


	// Total Alert cases available
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'case-heading-outer')]//div")
	private WebElement TotalCasescount;
	@FindBy(how = How.XPATH, using = "//i[@class='pi pi-clock']")
	public WebElement piclock;
	@FindBy(how = How.XPATH, using = "//input[contains(@class,'ui-dropdown-filter')]")
	public WebElement filtersearch;
	@FindBy(how = How.XPATH, using = "//li[@class='ui-dropdown-item ui-corner-all']")
	public WebElement Timezone;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ui-dropdown-trigger')]")
	public WebElement Clockdropdown;






	//No data found
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'No Data Found')]")
	public WebElement Nodatafound;

	// Preferences and Filter Same columns
	//Preferences
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='caseId']")
	public WebElement PrefCaseID;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='status']")
	private WebElement PrefStatus;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='severity']")
	public WebElement PrefSeverity;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='toolName']")
	public WebElement PrefToolName;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='ACK_FLAG']")
	private WebElement PrefAckStatus;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='caseDescription']")
	public WebElement Hidecaseswithtext;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Apply')]")
	public WebElement PrefApply;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Cancel')]")
	public WebElement Prefcancel;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'ui-dialog-titlebar-close')]")
	private WebElement Prefclose;


	//Filter
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='caseIdfl']")
	private WebElement FilterCaseID;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='caseseverity']")
	private WebElement FilterSeverity;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='casetoolName']")
	private WebElement FilterToolName;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Apply')]")
	public WebElement FilterApply;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Clear')]")
	public WebElement FilterClear;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'ui-dialog-titlebar-close')]")
	private WebElement Filterclose;


	@FindBy(how = How.XPATH, using = "//div[@ptooltip='Preferences']")
	public WebElement PreferencesTab;

	@FindBy(how = How.XPATH, using = "//div[@class='tab-cntrl tab-cntrl-icons enable-menu tab-apply_preference']")
	public WebElement PreferencesTab__Enable;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='status']")
	public WebElement Preferences_Casestatus;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='severity']")
	public WebElement Preferences_Severity;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='ACK_FLAG']")
	public WebElement Preferences_Ackstatus;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class, 'ui-chkbox-box')])[1]")
	public WebElement Preferences_createddate;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class, 'ui-chkbox-box')])[1]")
	public WebElement Preferences_updateddate;

	@FindBy(how = How.XPATH, using = "//span[text()='Apply']")
	public WebElement Applybutton;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'pi-times')]")
	public WebElement Preferenceclose;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'pi-times')]")
	public WebElement Filtercloseicon;

	@FindBy(how = How.XPATH, using = "//div[contains(@ptooltip,'Case ID')]")
	public WebElement Preferencecaseidformathover;

	@FindBy(how = How.XPATH, using = "//div[contains(@ptooltip,'Tool Name')]")
	public WebElement Preferencetoolnamehover;

	@FindBy(how = How.XPATH, using = "//div[contains(@ptooltip,'description')]")
	public WebElement Preferencedescrhover;

	@FindBy(how = How.XPATH, using = "//div[contains(@ptooltip,'acknowledged')]")
	public WebElement Preferenceackhover;

	@FindBy(how = How.XPATH, using = "(//div[contains(@ptooltip,'exclude:New')])[1]")
	public WebElement Preferencecasesthover;


	@FindBy(how = How.XPATH, using = "//div[@class='case-heading-text-left' and contains(text(),'All')]")
	public WebElement Casecount;

	@FindBy(how = How.XPATH, using = "//div[@class='case-outer ng-star-inserted']/div/div/div/div[1]/div[2]/span[2]")
	public List<WebElement> Casestatusdetails;

	@FindBy(how = How.XPATH, using = "(//span[@class='case-first-left-icon-2 corr_inprogress'])[1]")
	public WebElement Inprogresscasestatus;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'case-first-left-icon-1')]")
	public List<WebElement> CaseStatuslist;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'case-first-left-icon-1')]")
	public WebElement CaseStatus;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'case-first-left-icon-2)']")
	public WebElement SeverityStatus;

	@FindBy(how = How.XPATH, using = "(//div[@ptooltip='Export'])[1]")
	public WebElement ExportButton;

	@FindBy(how = How.XPATH, using = "//div[@class='case-outer-details1 case-outer-details-color2']//span[contains(@class,'case-first-left-icon-2')]")
	public WebElement CaseStatusfirst;

	@FindBy(how = How.XPATH, using = "//div[@class='case-outer-details1 case-outer-details-color2']//span[contains(@class,'case-first-left-icon-1')]")
	public WebElement SeverityStatusfirst;


	//US2780 - Case Management - Correlated Alerts - Others Info

	@FindBy(how = How.XPATH, using = "(//span[@class='seperator'])[1]")
	public WebElement FirstCaserow;
	@FindBy(how = How.XPATH, using = "(//span[@class='seperator'])[2]")
	public WebElement SecondCaserow;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'correlated-alerts-record-devicename-severity')]")
	public WebElement Severityicon;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'correlated-alerts-record-devicename-dname')]")
	public WebElement Device_ApplicationName;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'correlated-alerts-record-type')])[1]")
	public WebElement Type;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'correlated-alerts-record-tool')])[1]")
	public WebElement Tool;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'correlated-alerts-record-desc')])[1]")
	public WebElement Description;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'correlated-alerts-record-time')])[1]")
	public WebElement CreatedDate;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'correlated-alerts-record-time')])[3]")
	public WebElement ReceivedDate;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'correlated-alerts-record-others cursor-pointer')]")
	public WebElement Moreinfo;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'correlated-alerts-record-others cursor-pointer')]")
	public List<WebElement> More_info;
	@FindBy(how = How.XPATH, using = "//span[text()='Correlated Alerts']")
	public WebElement CorrelatedALerts;
	@FindBy(how = How.XPATH, using = "//span[@class='inner_popup']")
	public WebElement MoreInfoPopup;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'More info')]")
	public WebElement MoreInfoTooltip;
	@FindBy(how = How.XPATH, using = "//span[@id='close_moreinfo']")
	public WebElement MoreinfoCloseicon;
	@FindBy(how = How.XPATH, using = "//div[@class='expand-icon']")
	public WebElement Expandbutton;
	@FindBy(how = How.XPATH, using = "//span[text()='Collapse']")
	public WebElement Collapsebutton;
	@FindBy(how = How.XPATH, using = "//span[text()='ZIF2768']")
	public WebElement Casewithoutcorrdata;
	@FindBy(how = How.XPATH, using = "//span[text()='ALERTS']")
	public WebElement AlertsTab;
	@FindBy(how = How.XPATH, using = "(//div[@class='others_id_alert'])[1]")
	public WebElement RawalertsMoreInfo;
	@FindBy(how = How.XPATH, using = "//span[@class='alerts_inner_popup']")
	public WebElement RawalertsMoreInfoPopup;
	@FindBy(how = How.XPATH, using = "//div[@ptooltip='Filter']")
	public WebElement Filtericon;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='caseIdfl']")
	public WebElement CaseIdTextbox;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='caseId']")
	public WebElement RawAlertsCaseIdTextbox;
	@FindBy(how = How.XPATH, using = "//span[@class='ui-button-icon-left ui-clickable pi pi-calendar']")
	public WebElement RawalertsCalendarlink;
	@FindBy(how = How.XPATH, using = "//td[@class='ng-tns-c109-1 ui-datepicker-today ng-star-inserted']")
	public WebElement TodayDateRawalerts;
	@FindBy(how = How.XPATH, using = "//a[@class='ui-datepicker-prev ui-corner-all ng-tns-c109-1 ng-star-inserted']")
	public WebElement Previousmonthicon;
	@FindBy(how = How.XPATH, using = "//a[text()='1']")
	public WebElement LastMonthDate;
	@FindBy(how = How.XPATH, using = "//a[@class='ui-datepicker-next ui-corner-all ng-tns-c109-1 ng-star-inserted']")
	public WebElement Nextmonthicon;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'case-third-img2-exported')])[1]")
	public WebElement Exporticon;


	//Correlation Case Management US2922
	@FindBy(how = How.XPATH, using = "(//span[@class='analytics-case'])[1]")
	public WebElement Caseidcorrelation;
	@FindBy(how = How.XPATH, using = "(//span[@class='case-details analytics_desc'])[1]")
	public WebElement Createdatecorrelation;
	@FindBy(how = How.XPATH, using = "//span[@class='case-details analytics_desc']")
	public WebElement Createdatecorrelationlist;
	@FindBy(how = How.XPATH, using = "//div[@class='analyse_date']")
	public WebElement Updatedatecorrelationlist;
	@FindBy(how = How.XPATH, using = "(//span[@class='date_created'])[1]")
	public WebElement CreatedateHover;
	@FindBy(how = How.XPATH, using = "(//div[@class='analyse_date'])[1]")
	public WebElement Updateddatecorrelation;
	@FindBy(how = How.XPATH, using = "(//div[@class='date_updated date_img_cls'])[1]")
	public WebElement Updatedatehover;
	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'case-first-left-icon-1'])[1]")
	public WebElement Severitycorrelation;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div/div[2]/span[2]")
	public WebElement Casestatuscorrelate;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div/div[2]/span[1]")
	public WebElement Severitcorrelate;

	@FindBy(how = How.XPATH, using = "(//div[@class='case-first-right-outer-bottom'])[1]")
	public WebElement CaseStatuscorrelation;
	@FindBy(how = How.XPATH, using = "(//span[@ptooltip='Correlated Alerts'])[2]")
	public WebElement CorrelatedAlertscount;
	@FindBy(how = How.XPATH, using = "(//span[@class='case-detail-icon1 ng-star-inserted'])")
	public WebElement CorrelatedAlertshover;
	@FindBy(how = How.XPATH, using = "((//div[@class='correlated-alerts-record-outer ng-star-inserted'])[1]")
	public WebElement CorrelatedAlertsdesc;
	@FindBy(how = How.XPATH, using = "(//span[@ptooltip='Servers'])[1]")
	public WebElement CorrelatedServers;
	@FindBy(how = How.XPATH, using = "(//span[@class='case-details-icon-data-1 case-details-dev ng-star-inserted'])")
	public WebElement CorrelatedServershover;
	@FindBy(how = How.XPATH, using = "(//span[@ptooltip='Tool Name'])[1]")
	public WebElement CorrelatedToolname;
	@FindBy(how = How.XPATH, using = "(//span[@class='case-details-icon-data-1 case-details-tool ng-star-inserted'])")
	public WebElement CorrelatedToolnamehover;
	@FindBy(how = How.XPATH, using = "(//span[@ptooltip='Application Name'])[1]")
	public WebElement CorrelatedApplicationname;
	@FindBy(how = How.XPATH, using = "(//span[@class='case-details-icon-data-1 case-details-app ng-star-inserted'])")
	public WebElement CorrelatedApplicationnamehover;
	@FindBy(how = How.XPATH, using = "(//span[@ptooltip='Avg.Estimated time to Resolve'])[1]")
	public WebElement CorrelatedAveragetime;
	@FindBy(how = How.XPATH, using = "(//span[@ptooltip='Estimated time to Complete'])[1]")
	public WebElement CorrelatedEstimated;
	@FindBy(how = How.XPATH, using = "(//span[contains(normalize-space(),'InProgress')]")
	public WebElement CorrelatedEditdropdown;
	@FindBy(how = How.XPATH, using = "//span[@class='acknowledge-icon1 icon cursor-pointer ng-star-inserted acknowledge-icon-img techBot_Ack']")
	public WebElement Alerttechbotack;
	@FindBy(how = How.XPATH, using = "//span[@class='acknowledge-icon1 icon cursor-pointer ng-star-inserted acknowledge-icon-img']")
	public WebElement Alertmanualack;
	@FindBy(how = How.XPATH, using = "//span[@class='acknowledge-icon1 icon cursor-pointer unacknowledge-icon-img ng-star-inserted']")
	public WebElement Alertmanualunack;
	@FindBy(how = How.XPATH, using = "//span[contains(normalize-space(),'Correlated Alerts')]")
	public WebElement casecorrelatedalert;
	@FindBy(how = How.XPATH, using = "(//div[@class='correlated-alerts-record-devicename-dname'])")
	public WebElement correlateddevicename;
	@FindBy(how = How.XPATH, using = " (//div[@class='correlated-alerts-record-devicename-appname'])")
	public WebElement correlatedappname;
	@FindBy(how = How.XPATH, using = "(//div[@tooltipstyleclass='dev_short_box'])[1]")
	public WebElement correlateddescription;

	//US 4470
	@FindBy(how = How.XPATH, using = "//span[text()='Decline Correlation']")
	public WebElement DeclineCorrelation;
	@FindBy(how = How.XPATH, using = "//span[text()='Enable Correlation']//..//span[@class='ui-inputswitch-slider']")
	public WebElement EnableCorrelation;
	@FindBy(how = How.XPATH, using = "//div[text()='DEVICE/APPLICATION']")
	public WebElement DCdeviceapplication;
	@FindBy(how = How.XPATH, using = "//div[text()='TOOL NAME']")
	public WebElement DCtoolname;
	@FindBy(how = How.XPATH, using = "//div[text()='DESCRIPTION']")
	public WebElement DCdescription;
	@FindBy(how = How.XPATH, using = "//div[text()='CREATED DATE']")
	public WebElement DCcreateddate;
	@FindBy(how = How.XPATH, using = "//span[text()='Unlearn Pattern']")
	public WebElement DCunlearnpattern;
	@FindBy(how = How.XPATH, using = "//span[text()='OK']")
	public WebElement DCokbutton;
	@FindBy(how = How.XPATH, using = "//span[text()='Cancel']")
	public WebElement DCcancelbutton;
	@FindBy(how = How.XPATH, using = "//span[text()='Decline Correlation']")
	public List<WebElement> declinecorrelationlst;
	@FindBy(how = How.XPATH, using = "//span[@class='popup-close']")
	public WebElement DCclosebutton;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	public WebElement DCcheckbox;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	public List<WebElement> DCcheckboxlist;
	@FindBy(how = How.XPATH, using = "")
	public List<WebElement> DCdescriptionlist;

	//US 4982

	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]")
	public WebElement Prioritythreedots;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2])[2]")
	public WebElement Othercasethreedots;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[1])[1]")
	public WebElement Bellcountpriority;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[1])[2]")
	public WebElement Bellcountother;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[2]/span[1]/div)[1]")
	public WebElement Devicecountpriority;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[2]/span[2]/div)[1]")
	public WebElement Toolcountpriority;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[2]/span[1]/div)[2]")
	public WebElement Devicecountother;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[2]/span[2]/div)[2]")
	public WebElement Toolcountother;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2])[2]")
	public WebElement Otherthreedots;
	@FindBy(how = How.XPATH, using = "//span[text()='Enable Case Prioritization']//..//span[@class='ui-inputswitch-slider']")
	public WebElement enablepriority;
	@FindBy(how = How.XPATH, using = "//div[text()=' Show only false cases ']//..//span[@class='ui-inputswitch-slider']")
	public WebElement Thresholdenablefalse;
	@FindBy(how = How.XPATH, using = "//div[text()=' Hide false cases ']//..//span[@class='ui-inputswitch-slider']")
	public WebElement Thresholdhidefalse;
	@FindBy(how = How.XPATH, using = "(//span[@class='analytics-case'])[1]")
	public WebElement Falsecaseone;
	@FindBy(how = How.XPATH, using = "(//span[@class='analytics-case'])[2]")
	public WebElement Falsecasetwo;
	@FindBy(how = How.XPATH, using = "(//span[@class='analytics-case'])[3]")
	public WebElement Falsecasethree;
	@FindBy(how = How.XPATH, using = "//div[@class='case-id ng-star-inserted']")
	public WebElement CaseidRHS;



	@FindBy(how = How.XPATH, using = "//div[@class='noDataFoundAlert ng-star-inserted']")
	public WebElement Nodataavailablepr;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Priority Cases')]//..//span[@tooltipposition='bottom']")
	public WebElement Prioritycasecount;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Other Cases')]//..//span[@tooltipposition='bottom']")
	public WebElement Othercasecount;
	//Priority No data found
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'noData-padding')])[1]")
	public WebElement Prioritynodata;
	//Other No data found
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'noData-padding')])[2]")
	public WebElement Othernodata;

	@FindBy(how = How.XPATH, using = "//ngx-smart-loader[@identifier='rawAlertLoader']//..//div[@class='case-outer ng-star-inserted'][1]")
	public WebElement Priorityfirstcase;
	@FindBy(how = How.XPATH, using = "//*[@class=\"cases-full-outer-prior-ryt\"]/div[1]")
	public WebElement Otherfirstcase;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/div[1]/div[3]/div[1]/span[1])[1]")
	public WebElement Priorityfirstcaseid;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/div[1]/div[3]/div[1]/span[1])[2]")
	public WebElement Otherfirstcaseid;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div/div/div/div/div/div[1]/div[3]/div[1]/span[1])[1]")
	public WebElement Otherfilteredcaseid;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div/div/div/div/div/div[1]/div[3]/div[1]/span[1])[1]")
	public WebElement Priorityfilteredcaseid;


	@FindBy(how = How.XPATH, using = "//span[@class='case-bell case-bell-prior']")
	public WebElement Belliconpr;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")
	public WebElement Bellcountpr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//span[1]")
	public WebElement severityiconpr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//span[2]")
	public WebElement Casestatuiconpr;
	@FindBy(how = How.XPATH, using = "//span[@class='analytics-case' and contains(@xpath, '1')]")
	public WebElement ZIFcaseidpr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[3]//div[1]//span[4]")
	public WebElement createddatepr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[3]//div[2]//div[2]")
	public WebElement updateddatepr;
	@FindBy(how = How.XPATH, using = "//div[@class='analyse_date' and contains(@xpath, '1')]")
	public WebElement closeddatepr;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")
	public WebElement correlatedalertpr;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/span[1]")
	public WebElement threedoticonpr;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
	public WebElement acknowledgepr;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")
	public WebElement exportpr;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]")
	public WebElement notespr;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]")
	public WebElement recommendpr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[5]")
	public WebElement threedotpr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[1]//div[1]//span[1]")
	public WebElement Serverpr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[2]//span[1]//div[1]")
	public WebElement Servernamepr;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[2]/span[1]/div")
	public WebElement Servernameor;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[1]//div[1]//span[2]")
	public WebElement Toolpr;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[2]")
	public WebElement Toolor;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[2]//span[2]//div[1]")
	public WebElement Toolnamepr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[1]//div[1]//span[3]")
	public WebElement Appnpr;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[3]")
	public WebElement Appnor;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[2]//span[3]//div[1]")
	public WebElement Appnamepr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[1]//div[1]//span[4]")
	public WebElement Avgesttimepr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[1]//div[1]//span[5]")
	public WebElement ETItimepr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[1]//div[1]//span[6]")
	public WebElement Falseprbpr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[1]//div[1]//span[7]")
	public WebElement Correlationpr;
	@FindBy(how = How.XPATH, using = "//div[@class='component-body scroll-body']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//span[2]//div[2]//div[1]//div[1]//span[8]")
	public WebElement Patternbasedpr;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[2]/span[8]")
	public WebElement Patternbasedvaluepr;
	@FindBy(how = How.XPATH, using = "//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[2]/span[8]")
	public WebElement Patternbasedvalueor;
	@FindBy(how = How.XPATH, using = "//span[@class='case-bell']")
	public WebElement Belliconor;
	@FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-home-header[1]/div[1]/div[2]/app-case-mgmt-dash[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]")
	public WebElement severityiconor;
	@FindBy(how = How.XPATH, using = "//div[@class='ng-star-inserted']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//span[2]")
	public WebElement Casestatuiconor;
	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'case-first-left-icon-1-tri')])[1]")
	public WebElement Lowseverity;
	@FindBy(how = How.XPATH, using = "")
	public WebElement ZIFcaseidor;
	@FindBy(how = How.XPATH, using = "//div[@class='ng-star-inserted']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[3]//div[1]//span[4]")
	public WebElement createddateor;
	@FindBy(how = How.XPATH, using = "//div[@class='ng-star-inserted']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[3]//div[2]//div[2]")
	public WebElement updateddateor;
	@FindBy(how = How.XPATH, using = "//div[@class='ng-star-inserted']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[3]//div[2]//div[3]")
	public WebElement closeddateor;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")
	public WebElement correlatedalertor;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]")
	public WebElement threedoticonor;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
	public WebElement acknowledgeor;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")
	public WebElement exportor;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]")
	public WebElement notesor;
	@FindBy(how = How.XPATH, using = "//body/app-root/app-home-header[@class='ng-star-inserted']/div[@class='dashboard']/div[@class='dashb-mainpage']/app-case-mgmt-dash[@class='ng-star-inserted']/div[@class='component-body scroll-body']/div[@class='ng-star-inserted']/div[@class='two_seg']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]")
	public WebElement recommendor;
	@FindBy(how = How.XPATH, using = "//div[@class='ng-star-inserted']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[5]")
	public WebElement threedotor;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[1])[2]")
	public WebElement Serveror;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[2])[2]")
	public WebElement Toolnameor;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[3])[2]")
	public WebElement Appnameor;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[4])[2]")
	public WebElement Avgesttimeor;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[5])[2]")
	public WebElement ETItimeor;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[6])[2]")
	public WebElement Falseprbor;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[7])[2]")
	public WebElement Correlationor;
	@FindBy(how = How.XPATH, using = "(//*[@id=\"bodyScroll_prior\"]/div[1]/div/div/div/div/span[2]/div[2]/div[1]/div/span[8])[2]")
	public WebElement Patternbasedor;
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'case-details-icon')]")
	public List <WebElement> RHSiconhover;
	//Export Userstory

	@FindBy(how = How.XPATH, using = "(//div[contains(@class, 'case-third-img2-exported ng-star-inserted')])[1]")
	public WebElement Exportclicked;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'case-third-img2 ng-star-inserted')])[1]")
	public WebElement Suppression_Export;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'case-third-img2 ng-star-inserted')]")
	public List<WebElement> Suppression_ExportSize;
	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'analytics-case')])[1]")
	public WebElement Exportcaseid;
	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Export')])[1]")
	public WebElement Exportpopup;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ui-dropdown-label-container ng-tns-c80-9')]")
	public WebElement Suppression_Toolname;
	@FindBy(how = How.XPATH, using = "//li[contains(@role,'option')]")
	public WebElement Toolnameoption;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Priority')]//following::div[1]")
	public WebElement priority;
	@FindBy(how = How.XPATH, using = "(//li[contains(@role,'option')])[1]")
	public WebElement priorityoption;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Service')]//following::div[1]")
	public WebElement service;
	@FindBy(how = How.XPATH, using = "(//li[contains(@role,'option')])[2]")
	public WebElement serviceoption;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Category')]//following::div[1]")
	public WebElement category;
	@FindBy(how = How.XPATH, using = "(//li[contains(@role,'option')])[3]")
	public WebElement categoryoption;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Subcategory')]//following::div[1]")
	public WebElement subcategory;
	@FindBy(how = How.XPATH, using = "(//li[contains(@role,'option')])[1]")
	public WebElement subcategoryoption;
	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Export')])[2]")
	public WebElement Exportbutton;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Clear')]")
	public WebElement Clear;
	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname,'caseIdfl')]")
	public WebElement Filtercaseid;
	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname,'caseseverity')]")
	public WebElement Filterseverity;
	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname,'casetoolName')]")
	public WebElement Filtertoolname;
	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname,'casedeviceName')]")
	public WebElement Filterdevicename;
	@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname,'casedescription')]")
	public WebElement Filtercasedescription;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Please select a date range']")
	public WebElement Filtercreatedate;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'ng-tns-c72-8 pi pi-times')]")
	public WebElement closebutton;
	@FindBy(how = How.XPATH, using = "//div[contains(@ptooltip,'Filter')]")
	public WebElement export_Filter;
	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'ui-button-text ui-clickable')])[2]")
	public WebElement efilter_apply;
	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'ui-button-text ui-clickable')])[3]")
	public WebElement efilter_clear;
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'tabs-name-list tabs-name-sel tabs-state-active ng-star-inserted')]")
	public WebElement casemanagement;
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'case-first-left-icon-2')]")
	public WebElement exstatus;


	//cherwell
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'username')]")
	public WebElement cherwellun;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'password')]")
	public WebElement cherwellpwd;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'submit.SignIn')]")
	public WebElement cherwellsub;
	@FindBy(how = How.XPATH, using = "//input[contains(@class,'k-input searchMenuMru')]")
	public WebElement cherwellquickserach;
	@FindBy(how = How.XPATH, using = "//a[contains(@id, 'searchGo-button')]")
	public WebElement cherwellquickserachbutton;
	@FindBy(how = How.XPATH, using = "//h5[contains(@class,'ui-widget')]")
	public WebElement cherwellincidentidlink;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Next')]")
	public WebElement cherwellNextlink;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'window-content')])[1]")
	public WebElement confirmationwindow;
	@FindBy(how = How.XPATH, using = "//button[contains(@id,'SubmitButton')]")
	public WebElement okbutton;
	@FindBy(how = How.XPATH, using = "//span[text()='Please select a Cause Code:']")
	public WebElement Causecodewindow;
	@FindBy(how = How.XPATH, using = "(//span[text()='Please select a Cause Code:']//following::span[contains(@class,'k-icon k-i-arrow-60-down')])[1]")
	public WebElement Causecodedropdown;
	@FindBy(how = How.XPATH, using = "//a[text()='Save']")
	public WebElement Savebutton;
	@FindBy(how = How.XPATH, using = "(//div[contains(@id,'Text')])[15]")
	public WebElement status;
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'case-card-unack')])[1]")
	public WebElement Acknowledgedcase;
	@FindBy(how = How.XPATH, using = "//a[contains(@id,'LoginUserName')]")
	public WebElement Cherwellusernamelink;
	@FindBy(how = How.XPATH, using = "//a[contains(@id,'Logout')]")
	public WebElement Cherwelllogoutlink;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click here to login')]")
	public WebElement Clickheretologinlink;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='ACK_FLAG']")
	public WebElement Ackprefer;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'ui-dialog-titlebar-close')]")
	public WebElement Filter_close;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='IncidentID']")
	public WebElement Pref_incident;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='ticketStatus']")
	public WebElement Pref_incidentstatus;
	@FindBy(how = How.XPATH, using = "//td[contains(@class,'ui-datepicker-today')]//..//td[1]")
	public WebElement YesterDayDateRawalerts;
	@FindBy(how = How.XPATH, using = "//td[contains(@class,'ui-datepicker-today')]//..//td[3]")
	public WebElement PreviousDateRawalerts;
	@FindBy(how = How.XPATH, using = "//td[contains(@class,'ui-datepicker-today')]//..//td[4]")
	public WebElement CurrentDateRawalerts;
	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'pi pi-chevron-down')])[1]")
	public WebElement Hourdownicon;
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'ui-datepicker-prev-icon')]")
	public WebElement Prevmonth;
	@FindBy(how = How.XPATH, using = "(//span[@ptooltip='Pattern Based Threshold'])[2]")
	public WebElement PatternbasedHover;
	@FindBy(how = How.XPATH, using = "(//span[@class='case-second-txt ng-star-inserted'])[1]")
	public WebElement PatternbasedHovervalue;
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'case-details-patn ng-star-inserted')]")
	public WebElement Patternbasedvaluehover;
	@FindBy(how = How.XPATH, using = "//span[@tooltipstyleclass='ack_desc_long']")
	public WebElement Acknowledgehoverdetail;






	//--------------------------------End Of Locators-------------------------------
	//--------------------------------Methods----------------------------------------


	public void CheckallfieldsandImages() {

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

	public void hoveronAnalyzes() {

		Actions act = new Actions(driver);
		act.moveToElement(analyzeIcon).perform();
		assertTrue(analyzeshovermenu.isDisplayed());
	}

	public void hoveronrawdata() {

		Actions act = new Actions(driver);
		act.moveToElement(SMrawdata).perform();
		assertTrue(SMrawdata.isDisplayed());
	}


	public void verifyAnalyzeshovermenufields() {

		assertTrue(operationheader.isDisplayed());
		assertTrue(SMrawdata.isDisplayed());
		assertTrue(SManalytics.isDisplayed());
		assertTrue(SMpredictions.isDisplayed());
	}


	public void clickPrediction() {

		SMpredictions.click();
	}

	public void clickRawData() {

		SMrawdata.click();
	}

	public void LogoutClick() {

		logoutIcon.click();
	}

	public void clickAppSettings() {
		settingsIcon.click();
	}

	public void clickAnalytics() {
		SManalytics.click();
	}


	public void Turnofflivefeed() {
		try {
			if (livefeedon.isDisplayed()) {
				livefeedon.click();
				Thread.sleep(2000);
				assertTrue(livefeedoff.isDisplayed());
			}
		} catch (Exception e) {
		}
	}

	public void techbotoff() {
		try {
			if (techboton.isDisplayed()) {
				techboton.click();
				Thread.sleep(2000);
				assertTrue(techbotoff.isDisplayed());
			}
		} catch (Exception e) {
		}
	}

	public void techboton() {
		try {
			if (techbotoff.isDisplayed()) {
				techbotoff.click();
				Thread.sleep(2000);
				assertTrue(techboton.isDisplayed());
			}
		} catch (Exception e) {
		}
	}


	public boolean NoSeverityval() throws InterruptedException {


		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ElementNoSeverity = FirstAlertNoserveritymapped;
		js.executeScript("arguments[0].scrollIntoView();", ElementNoSeverity);
		Thread.sleep(4000);
		Actions acttechbotval21 = new Actions(driver);
		Thread.sleep(4000);
		acttechbotval21.moveToElement(ElementNoSeverity).perform();
		Thread.sleep(4000);
		boolean Elementnoseverityval = ElementNoSeverity.isDisplayed();
		return Elementnoseverityval;
	}


	public void supressiontoggle() {
		try {
			if (supressionTooltip.isDisplayed()) {
				supressionicon.click();
				Thread.sleep(2000);

			}
		} catch (Exception e) {
		}
	}
	//Enable Created date from preference icon//
	public void Enablecreateddate() {

		try {
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.sendKeys("");
			WebElement checkboxcrdte = driver.findElement(By.xpath("(//div[@role='checkbox'])[1]"));
			String crtdte = checkboxcrdte.getAttribute("aria-checked");
			System.out.println("Current status of create date:  "+crtdte);
			if(crtdte.equalsIgnoreCase(String.valueOf(true))){
				System.out.println("Already checked off created date");
			}
			else if(crtdte.equalsIgnoreCase(String.valueOf(false))){
				Thread.sleep(3000);
				checkboxcrdte.click();
				Thread.sleep(3000);

			}
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(3000);
		}catch (Exception e){
		}
	}

	//Enable updated date//
	public void EnableUpdatedate() {
		try {
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.sendKeys("");
			WebElement checkboxcrdte = driver.findElement(By.xpath("(//div[@role='checkbox'])[2]"));
			String crtdte = checkboxcrdte.getAttribute("aria-checked");
			System.out.println("Current status of updated date: "+crtdte);
			if(crtdte.equalsIgnoreCase(String.valueOf(false))){
				Thread.sleep(3000);
				checkboxcrdte.click();
				Thread.sleep(3000);
			}
			else if(crtdte.equalsIgnoreCase(String.valueOf(true))){
				System.out.println("Already checked off updated date");
			}
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(3000);
		}catch (Exception e){
		}
	}

	//Disable Updated date from preference icon//
	public void DisableUpdatedate() {
		try {
			new ZIFAI_CaseManagementPage(driver).Preferencetabinvoke();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Hidecaseswithtext.sendKeys("");
			WebElement checkboxcrdte = driver.findElement(By.xpath("(//div[@role='checkbox'])[2]"));
			String crtdte = checkboxcrdte.getAttribute("aria-checked");
			System.out.println("Current status of updated date: "+crtdte);
			if(crtdte.equalsIgnoreCase(String.valueOf(true))){
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Updateddateclick.click();
				Thread.sleep(3000);
			}
			else if(crtdte.equalsIgnoreCase(String.valueOf(false))){
				System.out.println("Already checked off updated date");
			}
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).PrefApply.click();
			Thread.sleep(3000);
		}catch (Exception e){

		}
	}

	public void correlationtoggle() {
		try {
			if (CorrelationTooltip.isDisplayed()) {
				Correlationicon.click();
				Thread.sleep(2000);

			}
		} catch (Exception e) {
		}
	}


	public void SuppressionAcknowledgementhover() throws InterruptedException {
		try {

			Actions actionsalrt1 = new Actions(driver);
			actionsalrt1.moveToElement(AlertAcknowledge).perform();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}

	public void SuppressionAlertExpandCollapse() throws InterruptedException {
		try {
			prefereceIcon.click();
			Thread.sleep(3000);
			Preferences_Casestatus.sendKeys("Inprogress");
			Preferences_Ackstatus.sendKeys("Acknowledged");
			Thread.sleep(3000);
			Applybutton.click();
			Thread.sleep(3000);
			SuppressionAcknowledgementhover();
			Thread.sleep(3000);
			Expandbutton.click();
			Thread.sleep(3000);
			AlertEdit.click();
			StatusDD.click();
			Thread.sleep(2000);
			DDAssignedStatus.click();
			Thread.sleep(2000);
			//ClearEdit.click();//Uncomment when issue is resolved in the application using Expand
			ReferenceText.sendKeys("Inprogress Status Verification");
			NotesText.sendKeys("Inprogress Status Verification");
			Thread.sleep(2000);
			ApplyEdit.click();
			Thread.sleep(2000);
			Collapsebutton.click();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}


	public void SupressionLivefeedpause() throws InterruptedException {
		try {
			if (livefeedoff.isDisplayed()) {
				livefeedon.click();
				livefeedoff.click();
				Thread.sleep(5000);
				assertTrue(livefeedoff.isDisplayed());
			} else {
				livefeedoff.click();
			}
		} catch (Exception e) {
		}
	}

	public void SupressionLivefeedon() throws InterruptedException {
		try {
			livefeedoff.isDisplayed();
			livefeedon.click();

		} catch (Exception e) {
		}
	}


	public void correlatedalertaction() throws InterruptedException {
		try {
			Actions actionsalrt1 = new Actions(driver);
			actionsalrt1.moveToElement(CorrelatedAlertshover).perform();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}

	public void correlationserveraction() throws InterruptedException {
		try {
			Actions actionsrv1 = new Actions(driver);
			actionsrv1.moveToElement(CorrelatedServershover).perform();
			Thread.sleep(4000);
		} catch (Exception e) {

		}
	}

	public void Correlationtoolaction() throws InterruptedException {
		Actions actionsrv2 = new Actions(driver);
		actionsrv2.moveToElement(CorrelatedToolnamehover).perform();
		Thread.sleep(4000);
	}

	public void Correlationapplicationaction() throws InterruptedException {
		Actions actionsrv3 = new Actions(driver);
		actionsrv3.moveToElement(CorrelatedApplicationnamehover).perform();
		Thread.sleep(4000);
	}


	public void AlertsExpandandCollapse() {
		try {
			AlertExpand.click();
			Thread.sleep(2000);
			assertTrue(AlertCollapse.isDisplayed());
			AlertCollapse.click();
			assertTrue(AlertExpand.isDisplayed());
			AlertExpand.click();
			Thread.sleep(2000);

		} catch (Exception e) {
		}
	}

	public void AlertsDescriptionTitles() {
		try {
			assertTrue(AlertRootcause.isDisplayed());
			assertTrue(CorrelatedAlerts.isDisplayed());
			assertTrue(Timeline.isDisplayed());
		} catch (Exception e) {
		}
	}


	public void ClickonanyAlertswith5or4or3() {
		try {
			if (Alertwith5.isDisplayed()) {
				Alertwith5.click();
				Thread.sleep(2000);
				//Alert Expand and collapse verified
				AlertsExpandandCollapse();
				AlertsDescriptionTitles();
				CorrelatedAlerts.click();

				//Verify 5 records with same description in Correlated Alerts
				List<WebElement> records = driver.findElements(By.xpath("//*[contains(@class,'correlated-alerts-record-outer')]"));
				int size = records.size();
				if (size == 5) {
					for (int i = 2; i <= 5; i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[" + i + "]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
				}

				//Verify 5 records with same description in Timeline
				Timeline.click();
				List<WebElement> Trecord = driver.findElements(By.xpath("//*[contains(@class,'timeline-panel')]"));
				int size1 = Trecord.size();
				if (size1 == 5) {
					for (int i = 2; i <= 5; i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'timeline-desc')]//following::div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("//*[contains(@class,'timeline-desc')]//following::div[1])[" + i + "]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
					AlertClose.click();
				}
			} else if (Alertwith4.isDisplayed()) {
				Alertwith4.click();
				Thread.sleep(2000);
				//Alert Expand and collapse verified
				AlertsExpandandCollapse();
				AlertsDescriptionTitles();
				CorrelatedAlerts.click();

				//Verify 4 records with same description in Correlated Alerts
				List<WebElement> records = driver.findElements(By.xpath("//*[contains(@class,'correlated-alerts-record-outer')]"));
				int size = records.size();
				if (size == 4) {
					for (int i = 2; i <= 4; i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[" + i + "]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
				}

				//Verify 5 records with same description in Timeline
				Timeline.click();
				List<WebElement> Trecord = driver.findElements(By.xpath("//*[contains(@class,'timeline-panel')]"));
				int size1 = Trecord.size();
				if (size1 == 4) {
					for (int i = 2; i <= 4; i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'timeline-desc')]//following::div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("//*[contains(@class,'timeline-desc')]//following::div[1])[" + i + "]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
					AlertClose.click();
				}
			} else if (Alertwith3.isDisplayed()) {
				Alertwith3.click();
				Thread.sleep(2000);
				//Alert Expand and collapse verified
				AlertsExpandandCollapse();
				AlertsDescriptionTitles();
				CorrelatedAlerts.click();

				//Verify 3 records with same description in Correlated Alerts
				List<WebElement> records = driver.findElements(By.xpath("//*[contains(@class,'correlated-alerts-record-outer')]"));
				int size = records.size();
				if (size == 3) {
					for (int i = 2; i <= 3; i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[" + i + "]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
				}

				//Verify 3 records with same description in Timeline
				Timeline.click();
				List<WebElement> Trecord = driver.findElements(By.xpath("//*[contains(@class,'timeline-panel')]"));
				int size1 = Trecord.size();
				if (size1 == 3) {
					for (int i = 2; i <= 3; i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'timeline-desc')]//following::div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("//*[contains(@class,'timeline-desc')]//following::div[1])[" + i + "]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
					AlertClose.click();
				}
			} else if (Alertwith2.isDisplayed()) {
				Alertwith2.click();
				Thread.sleep(2000);
				//Alert Expand and collapse verified
				AlertsExpandandCollapse();
				AlertsDescriptionTitles();
				CorrelatedAlerts.click();

				//Verify 2 records with same description in Correlated Alerts
				List<WebElement> records = driver.findElements(By.xpath("//*[contains(@class,'correlated-alerts-record-outer')]"));
				int size = records.size();
				if (size == 2) {
					for (int i = 2; i <= 2; i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("(//*[contains(@class,'correlated-alerts-record-desc')]//div[1])[" + i + "]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
				}

				//Verify 2 records with same description in Timeline
				Timeline.click();
				List<WebElement> Trecord = driver.findElements(By.xpath("//*[contains(@class,'timeline-panel')]"));
				int size1 = Trecord.size();
				if (size1 == 2) {
					for (int i = 2; i <= 2; i++) {
						WebElement FirstDesc = driver.findElement(By.xpath("(//*[contains(@class,'timeline-desc')]//following::div[1])[1]"));
						String Desc1 = FirstDesc.getText();
						WebElement nextdesc = driver.findElement(By.xpath("//*[contains(@class,'timeline-desc')]//following::div[1])[" + i + "]"));
						String Next = nextdesc.getText();
						assertTrue(Next.equals(Desc1));
					}
					AlertClose.click();
				}
			}

		} catch (Exception e) {
		}
	}

	public void AlertDetailsClose() {
		try {
			assertTrue(AlertClose.isDisplayed());
			AlertClose.click();
		} catch (Exception e) {
		}
	}

	public void ClickFirstAlert() {
		try {
			assertTrue(FirtsAlertID.isDisplayed());
			FirtsAlertID.click();
		} catch (Exception e) {
		}
	}

	public void ClickEditandAssignNew() {
		try {
			assertTrue(AlertEdit.isDisplayed());
			AlertEdit.click();
			ClearEdit.click();
			StatusDD.click();
			Thread.sleep(2000);
			DDNewStatus.click();
			ReferenceText.sendKeys("New Status Verification");
			NotesText.sendKeys("New Status Verification");
			ApplyEdit.click();
			Thread.sleep(2000);
			assertTrue(FirtsAlertNewStatus.isDisplayed());
		} catch (Exception e) {
		}
	}

	public void ClickEditandAssignAssigned() {
		try {
			assertTrue(AlertEdit.isDisplayed());
			AlertEdit.click();
			ClearEdit.click();
			StatusDD.click();
			Thread.sleep(2000);
			DDAssignedStatus.click();
			ReferenceText.sendKeys("Assigned Status Verification");
			NotesText.sendKeys("Assigned Status Verification");
			ApplyEdit.click();
			Thread.sleep(2000);
			assertTrue(FirtsAlertAssignedStatus.isDisplayed());
		} catch (Exception e) {
		}
	}

	public void ClickEditandAssignInprogress() {
		try {
			assertTrue(AlertEdit.isDisplayed());
			AlertEdit.click();
			ClearEdit.click();
			StatusDD.click();
			Thread.sleep(2000);
			DDInprogressStatus.click();
			ReferenceText.sendKeys("Inprogress Status Verification");
			NotesText.sendKeys("Inprogress Status Verification");
			ApplyEdit.click();
			Thread.sleep(2000);
			assertTrue(FirtsAlertInprogressStatus.isDisplayed());
		} catch (Exception e) {
		}
	}

	public void ClickEditandAssignClosed() {
		try {
			assertTrue(AlertEdit.isDisplayed());
			AlertEdit.click();
			ClearEdit.click();
			StatusDD.click();
			Thread.sleep(2000);
			DDClosedStatus.click();
			ReferenceText.sendKeys("Closed Status Verification");
			NotesText.sendKeys("Closed Status Verification");
			ApplyEdit.click();
			Thread.sleep(2000);
			assertTrue(FirtsAlertClosedStatus.isDisplayed());
		} catch (Exception e) {
		}
	}

	public void Selectingtimezone(String Timezone) {
		try {
			new ZIFAI_CaseManagementPage(driver).piclock.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Clockdropdown.click();
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).filtersearch.sendKeys(Timezone);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).Timezone.click();
			Thread.sleep(3000);
		} catch (AssertionError | Exception e) {
			System.out.println(e);
		}
	}

	public String GetTotalAlertCount() {
		String Totalcount = TotalCasescount.getText();
		return Totalcount;
	}

	public void ClearFilterandPreference() {
		try {
			prefereceIcon.click();
			PrefCaseID.clear();
			PrefSeverity.clear();
			PrefToolName.clear();
			PrefApply.click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
	}

	public void ClearPreferencecasestatus(CharSequence Value) {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				PreferencesTab.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefAckStatus.sendKeys(b +b+ b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(Value);
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(Value);
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}
	}

	public void ClearPreferenceackstatus(CharSequence Value) {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				PreferencesTab.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefAckStatus.sendKeys(b + b+b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b +b +b);
				Thread.sleep(2000);
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefAckStatus.sendKeys(Value);
				PrefApply.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefAckStatus.sendKeys(Value);
				PrefApply.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}
	}

	public void ClearPreferencetoolname(CharSequence Value) {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				PreferencesTab.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefAckStatus.sendKeys(b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefToolName.sendKeys(Value);
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefToolName.sendKeys(Value);
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}
	}

	public void ClearPreferenceHidecase(CharSequence Value) {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				PreferencesTab.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefAckStatus.sendKeys(b + b+b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				Hidecaseswithtext.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				Hidecaseswithtext.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}
	}

	public void ClearPreferenceseverity(CharSequence Value) {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				PreferencesTab.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefAckStatus.sendKeys(b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefSeverity.sendKeys(Value);
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				;
				Thread.sleep(2000);
				PrefSeverity.sendKeys(Value);
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}
	}

	public void ClearPreferencecaseid(CharSequence Value) {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				PreferencesTab.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefAckStatus.sendKeys(b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				PrefCaseID.sendKeys(Value);
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefCaseID.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				clearcasestatus();
				Thread.sleep(3000);
				PrefSeverity.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefToolName.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Pref_incident.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				Preferences_Ackstatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				PrefCaseID.sendKeys(Value);
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}
	}

	public void NewCaseStatusPreference() {
		try {
			prefereceIcon.click();
			Preferences_Casestatus.isDisplayed();
			Preferences_Casestatus.clear();
			Preferences_Casestatus.sendKeys("New");
			PrefApply.click();
			Thread.sleep(8000);
		} catch (Exception e) {

		}
	}

	public void InprogressCaseStatusPreference() {
		try {
			prefereceIcon.click();
			Preferences_Casestatus.isDisplayed();
			Preferences_Casestatus.clear();
			Preferences_Casestatus.sendKeys("Inprogress");
			PrefApply.click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
	}

	public void clickingonfirstcase() {
		try {
			FirstCaserow.isDisplayed();
			FirstCaserow.click();
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	}

	public void ClosedCaseStatusPreference() {
		try {
			prefereceIcon.click();
			Preferences_Casestatus.isDisplayed();
			Preferences_Casestatus.clear();
			Preferences_Casestatus.sendKeys("Closed");
			PrefApply.click();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
	}


	public void CheckSeverityviaPreftoFilter() {
		try {
			String getTotalAlertCount = GetTotalAlertCount();
			assertTrue(prefereceIcon.isDisplayed());
			prefereceIcon.click();
			PrefSeverity.clear();
			PrefSeverity.sendKeys("Low");
			PrefApply.click();
			Thread.sleep(2000);
			String changecountofPref = GetTotalAlertCount();
			assertFalse(getTotalAlertCount.equalsIgnoreCase(changecountofPref));

			filterIcon.click();
			FilterSeverity.clear();
			FilterSeverity.sendKeys("Low");
			FilterApply.click();
			Thread.sleep(2000);
			String changecountofBoth = GetTotalAlertCount();
			assertTrue(changecountofPref.equalsIgnoreCase(changecountofBoth));

			filterIcon.click();
			FilterSeverity.clear();
			FilterSeverity.sendKeys("High");
			FilterApply.click();
			Thread.sleep(2000);
			assertTrue(Nodatafound.isDisplayed());


		} catch (Exception e) {
		}
	}

	public void CheckSeverityviaFiltertoPref() {
		try {
			assertTrue(prefereceIcon.isDisplayed());
			FirtsAlertID.click();
		} catch (Exception e) {
		}
	}

	public void clicExporticon() {
		ExportButton.click();

	}

	public void clickpreferencestab() {
		PreferencesTab.click();

	}

	public void Entercasestatus(String status) {
		Preferences_Casestatus.sendKeys(status);

	}

	public void clickapplybutton() {
		Applybutton.click();

	}

	public String Casestatusdetails() {

		for (int i = 1; i < Casestatusdetails.size(); i++) {
			String Casestatusdetailsvalues = Casestatusdetails.get(i).getAttribute("class");
			System.out.println("Value is:" + Casestatusdetailsvalues.replaceAll("case-first-left-icon-2 case-first-left-icon-2-", ""));
		}

		return null;
	}

	public void clickPreferencesTab__Enable() {
		PreferencesTab__Enable.click();

	}

	public void Identifyinprogressstatus() {

		Inprogresscasestatus.isDisplayed();
	}

	public WebElement Casecount() {
		assertTrue(Casecount.isDisplayed());

		return null;
	}


	public void Correlationdetails() throws InterruptedException {
		Assert.assertTrue(Severityicon.isDisplayed());
		Assert.assertTrue(Device_ApplicationName.isDisplayed());
		Assert.assertTrue(Type.isDisplayed());
		Assert.assertTrue(Tool.isDisplayed());
		Assert.assertTrue(Description.isDisplayed());
		Assert.assertTrue(CreatedDate.isDisplayed());
		Assert.assertTrue(ReceivedDate.isDisplayed());
		Assert.assertTrue(Moreinfo.isDisplayed());
	}

	// public void MoreInfowithoutdata() {
	//
//	    if(Moreinfo.isDisplayed());
	// }
	public void MoreInfoPopup() {
		Assert.assertTrue(MoreInfoPopup.isDisplayed());
	}

	public void ClickFirstCaserow() {
		Assert.assertTrue(FirstCaserow.isDisplayed());
		FirstCaserow.click();
	}

	public void ClickAlerts() {

		Assert.assertTrue(AlertsTab.isDisplayed());
		{
			AlertsTab.click();
		}
	}


	public void EnterCaseID(String CaseID) throws IOException, InterruptedException {
		//driver.navigate().refresh();
		CaseIdTextbox.clear();
		CaseIdTextbox.sendKeys(CaseID);
	}

	public void EnterRawalertsCaseID(String CaseID) throws IOException, InterruptedException {
		//driver.navigate().refresh();
		RawAlertsCaseIdTextbox.clear();
		RawAlertsCaseIdTextbox.sendKeys(CaseID);
	}

	public void SetFromToDate() throws InterruptedException {
		RawalertsCalendarlink.click();
		Thread.sleep(3000);
		Previousmonthicon.click();
		Thread.sleep(3000);
		LastMonthDate.click();
		Thread.sleep(3000);
		Nextmonthicon.click();
		Thread.sleep(3000);
		TodayDateRawalerts.click();
		Thread.sleep(3000);
		RawalertsCalendarlink.click();
		Thread.sleep(3000);
		Applybutton.click();
	}

	public void Createddatetimeval() throws InterruptedException {
		Actions actionsval12 = new Actions(driver);
		actionsval12.moveToElement(Createdatecorrelation).perform();
		Thread.sleep(4000);
	}

	public void Createddatetimevaltext() throws InterruptedException {
		Actions actionsvalt15 = new Actions(driver);
		actionsvalt15.moveToElement(CreatedateHover).perform();
		Thread.sleep(4000);
	}

	public void Updatetimevaltext() throws InterruptedException {
		Actions actionsval1 = new Actions(driver);
		actionsval1.moveToElement(Updatedatehover).perform();
		Thread.sleep(4000);
	}

	public void Updatetimeval() throws InterruptedException {
		Actions actionsval1 = new Actions(driver);
		actionsval1.moveToElement(Updateddatecorrelation).perform();
		Thread.sleep(4000);
	}

	public void Casestatushover() throws InterruptedException {
		Actions casestatushover19 = new Actions(driver);
		casestatushover19.moveToElement(CaseStatusfirst).perform();
		Thread.sleep(3000);
	}

	public void Severitystatushover() throws InterruptedException {
		Actions severitystatushover19 = new Actions(driver);
		severitystatushover19.moveToElement(SeverityStatusfirst).perform();
		Thread.sleep(3000);
	}

	public void UniquestatusInprogress() {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(2000);
				PreferencesTab.click();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				Preferences_Ackstatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys("Inprogress");
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(2000);
				prefereceIconwithdots.click();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				Preferences_Ackstatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys("Inprogress");
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);

			}

		} catch (Exception e) {

		}

	}

	public void UniquestatusClosed() {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(2000);
				PreferencesTab.click();
				Thread.sleep(2000);
				Preferences_Ackstatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.isDisplayed();
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys("Closed");
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(2000);
				prefereceIconwithdots.click();
				Thread.sleep(2000);
				Preferences_Ackstatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.isDisplayed();
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys("Closed");
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			}

		} catch (Exception e) {

		}

	}

	public void UniquestatusAssigned() {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(2000);
				PreferencesTab.click();
				Thread.sleep(2000);
				Preferences_Ackstatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.isDisplayed();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys("Assigned");
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(2000);
				prefereceIconwithdots.click();
				Thread.sleep(2000);
				Preferences_Ackstatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.isDisplayed();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys("Assigned");
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}

	}


	public void CaseUnacknowledgeFilter() {

		try {
			if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(2000);
				String b = Keys.BACK_SPACE.toString();
				PrefAckStatus.sendKeys(b + b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefAckStatus.sendKeys("Unacknowledged");
				Thread.sleep(2000);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", PrefApply);
				Thread.sleep(3000);
			} else if (prefereceIcon.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(2000);
				String b = Keys.BACK_SPACE.toString();
				PrefAckStatus.sendKeys(b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys(b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefAckStatus.sendKeys("Unacknowledged");
				Thread.sleep(2000);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", PrefApply);
				Thread.sleep(3000);
			}
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}



	public void CaseacknowledgeFilter() {
		try {
			prefereceIconwithdots.click();
			Thread.sleep(2000);
			PrefAckStatus.isDisplayed();
			Thread.sleep(2000);
			Preferences_Casestatus.clear();
			PrefAckStatus.clear();
			Thread.sleep(2000);
			PrefAckStatus.sendKeys("zifadmin@zif.ai");
			Thread.sleep(2000);
			PrefApply.click();
			Thread.sleep(2000);
			if (Alerttechbotack.isDisplayed()) {
				Thread.sleep(2000);
				Alerttechbotack.click();
				Thread.sleep(2000);
			} else if (Alertmanualack.isDisplayed()) {
				Thread.sleep(2000);
				Alertmanualack.click();

			}

		} catch (Exception e) {

		}
	}


	public void DashboardAddWidget() {
		DashboardAddwidget.click();


	}

	public void Casesortval() throws InterruptedException {
		ArrayList<String> obtainedList = new ArrayList<>();
		Thread.sleep(2000);
		List<WebElement> elementList = driver.findElements(By.xpath("//span[@class='analytics-case']"));
		Thread.sleep(2000);
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
			System.out.println("Sorted Case list --> " + obtainedList);
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
			Thread.sleep(2000);
		}
		Collections.sort(sortedList);
		Thread.sleep(2000);
		Collections.reverse(sortedList);
		Thread.sleep(2000);
		Assert.assertTrue(sortedList.equals(obtainedList));
	}

	public void createdatesortval() throws InterruptedException {

	}

	public void updateddatesortval() throws InterruptedException {
		ArrayList<String> obtainedList = new ArrayList<>();
		Thread.sleep(2000);
		List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='analyse_date']"));
		Thread.sleep(2000);
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
			System.out.println("Sorted Updated date list --> " + obtainedList);
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
			Thread.sleep(2000);
		}
		Collections.sort(sortedList);
		Thread.sleep(2000);
		Collections.reverse(sortedList);
		Thread.sleep(2000);
		Assert.assertTrue(sortedList.equals(obtainedList));
	}


	public boolean TimeStampValid(String inputString) {
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			format.parse(inputString);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	//Invoking Setting icon from case management//
	public void Invokesettingicon() throws InterruptedException {
		try {
			new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.isDisplayed();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).alertSettingsIcon.click();
				Thread.sleep(3000);
		} catch (Exception e) {

		}
		}

		//Selecting Correlation from Setting option//
		//Correlation slider is selected from setting option
		public void EnableCorrelation () throws InterruptedException {
		try {
		Thread.sleep(3000);
		String status = driver.findElement(By.xpath("//span[contains(text(),'Enable Correlation')]//..//input")).getAttribute("aria-checked");
		System.out.println("attribute: " + status);
		Thread.sleep(3000);
		if (status.equals("true")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).warningokbutton.click();
			Thread.sleep(3000);
		} else if (status.equals("false")) {
			new ZIFAI_CaseManagementPage(driver).EnableCorrelation.click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
			Thread.sleep(3000);
			new ZIFAI_CaseManagementPage(driver).warningokbutton.click();
			Thread.sleep(3000);
			Thread.sleep(2000);
		}
	} catch(Exception e){
		}
	}

	public void EnableNoiseCancellation () throws InterruptedException {
		try {
			Thread.sleep(3000);
			String status = driver.findElement(By.xpath("//span[contains(text(),'Enable Noise Cancellation')]//..//input")).getAttribute("aria-checked");
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status.equals("true")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).warningokbutton.click();
				Thread.sleep(3000);
			} else if (status.equals("false")) {
				new ZIFAI_CaseManagementPage(driver).EnableCorrelation.click();
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Applybutton);
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).warningokbutton.click();
				Thread.sleep(3000);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
		}
	}




	public String Falsecaseidone() {
		String Falsecaseone = null;
		try {
			Thread.sleep(3000);
			WebElement Elementone = driver.findElement(By.xpath("(//span[@class='analytics-case'])[1]"));
			Falsecaseone = Elementone.getText();
			System.out.println(Falsecaseone);
		} catch (Exception e) {
		}
	return Falsecaseone;
	}

	public String Falsecaseidtwo() {
		String Falsecasetwo = null;
		try {
			Thread.sleep(3000);
			WebElement Elementtwo = driver.findElement(By.xpath("(//span[@class='analytics-case'])[2]"));
			Falsecasetwo = Elementtwo.getText();
			System.out.println(Falsecasetwo);

		} catch (Exception e) {
		}
		return Falsecasetwo;
	}

	public String Falsecaseidthree() {
		String Falsecasethree = null;
		try {
			Thread.sleep(3000);
		WebElement Elementthree = driver.findElement(By.xpath("(//span[@class='analytics-case'])[3]"));
		Falsecasethree = Elementthree.getText();
			System.out.println(Falsecasethree);

		} catch (Exception e) {
		}
		return Falsecasethree;
	}

	//Clear the case status preferences
	public void clearcasestatus() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='status']")));
		WebElement CaseStatus_Preferences = driver.findElement(By.xpath("//input[@formcontrolname='status']"));
		if (CaseStatus_Preferences.isDisplayed()) {
			Thread.sleep(2000);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);

		}
	}

	//Export Userstory
	public void clickexport() {
		Suppression_Export.click();

	}

	public void clickpriorityoption() {
		priorityoption.click();

	}
	public void clickserviceoption() {
		serviceoption.click();

	}
	public void clickcategoryoption() {
		categoryoption.click();

	}

	public void clicksubcategoryoption() {
		subcategoryoption.click();

	}

	public void clickExportbutton() {
		Exportbutton.click();

	}

	//Clicking on preference tab//

		public void Preferencetabinvoke() throws InterruptedException {
			try {
				if (new ZIFAI_CaseManagementPage(driver).PreferencesTab.isDisplayed()) {
					Thread.sleep(3000);
					new ZIFAI_CaseManagementPage(driver).PreferencesTab.click();
					Thread.sleep(3000);
				} else if (new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.isDisplayed()) {
					Thread.sleep(3000);
					new ZIFAI_CaseManagementPage(driver).prefereceIconwithdots.click();
					Thread.sleep(3000);
				}
			} catch (AssertionError | Exception e) {
			}
		}



	//Enabling Show only false case from preference//
	public void Enablingshowonlyfalsecase() throws InterruptedException {
		try {
			String status = driver.findElement(By.xpath("//div[contains(text(),' Show only false cases ')]//..//input")).getAttribute("aria-checked");
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status.equals("true")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
			} else if (status.equals("false")) {
				new ZIFAI_CaseManagementPage(driver).Thresholdenablefalse.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Applybutton.click();
				Thread.sleep(3000);
				Thread.sleep(3000);


			}
		} catch (AssertionError | Exception e) {

		}
	}

	//Disable Show only false case from preference//
	public void Disableshowonlyfalsecase() throws InterruptedException {
			try {
				String status = driver.findElement(By.xpath("//div[contains(text(),' Show only false cases ')]//..//input")).getAttribute("aria-checked");
				System.out.println("attribute: " + status);
				Thread.sleep(3000);
				if (status.equals("false")) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
					Thread.sleep(3000);
				} else if (status.equals("true")) {
					new ZIFAI_CaseManagementPage(driver).Thresholdenablefalse.click();
					Thread.sleep(3000);
					new ZIFAI_CaseManagementPage(driver).Applybutton.click();
					Thread.sleep(3000);
					Thread.sleep(3000);
				}
			} catch (AssertionError | Exception e) {
			}
		}

	//Disabling Hide false cases only//
	public void Disablehidefalsecase() throws InterruptedException {
			try {
				String status = driver.findElement(By.xpath("//div[contains(text(),' Hide false cases ')]//..//input")).getAttribute("aria-checked");
				System.out.println("attribute: " + status);
				Thread.sleep(3000);
				if (status.equals("false")) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
					Thread.sleep(3000);
					Thread.sleep(3000);
				} else if (status.equals("true")) {
					new ZIFAI_CaseManagementPage(driver).Thresholdhidefalse.click();
					Thread.sleep(3000);
					new ZIFAI_CaseManagementPage(driver).Applybutton.click();
					Thread.sleep(3000);
					Thread.sleep(3000);
				}
			} catch (AssertionError | Exception e) {
			}
		}

	//Enabling Hide false cases only//
	public void Enablinghidefalsecase() throws InterruptedException {
		try {
			String status = driver.findElement(By.xpath("//div[contains(text(),' Hide false cases ')]//..//input")).getAttribute("aria-checked");
			System.out.println("attribute: " + status);
			Thread.sleep(3000);
			if (status.equals("true")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new ZIFAI_CaseManagementPage(driver).Prefcancel);
				Thread.sleep(3000);
				Thread.sleep(3000);
			} else if (status.equals("false")) {
				new ZIFAI_CaseManagementPage(driver).Thresholdhidefalse.click();
				Thread.sleep(3000);
				new ZIFAI_CaseManagementPage(driver).Applybutton.click();
				Thread.sleep(3000);
				Thread.sleep(3000);
			}
		} catch (AssertionError | Exception e) {
		}
	}


	public void clearAck_pre() throws InterruptedException {
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='ACK_FLAG']")));
		WebElement CaseStatus_Preferences = driver.findElement(By.xpath("//input[@formcontrolname='ACK_FLAG']"));
		if (CaseStatus_Preferences.isDisplayed()) {
			Thread.sleep(2000);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);
			CaseStatus_Preferences.sendKeys(Keys.BACK_SPACE);

		}
	}



	public void UniquestatusNew() throws InterruptedException {
			if (PreferencesTab.isDisplayed())
			{
				PreferencesTab.click();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
				Thread.sleep(2000);
				Preferences_Ackstatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys("New");
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);
			} else
				{ prefereceIconwithdots.isDisplayed();
					prefereceIconwithdots.click();
				Thread.sleep(2000);
				Preferences_Casestatus.clear();
					Thread.sleep(2000);
				Preferences_Ackstatus.clear();
				Thread.sleep(2000);
				Preferences_Casestatus.sendKeys("New");
				Thread.sleep(2000);
				PrefApply.click();
				Thread.sleep(2000);

			}

		}



	}

