package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zifautomation.Utility.CommonMethods;

public class ZIFAI_AlertsSettingsPage {

	WebDriver driver;


	public ZIFAI_AlertsSettingsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//US6450
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Create new Discovery')]")
	public WebElement Createnewdiscovery;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='recursive_dicv']")
	public WebElement EnableRecursiveDiscovery;
	@FindBy(how = How.XPATH, using="(//span[@class='input-val'])[2]")
	public WebElement Discoveryinputinfo;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'discovery-info-icon')]")
	public WebElement Discoveryinputdetails;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'create-dis-info-icon')]")
	public WebElement Recursivediscoveryinfo;
	@FindBy(how = How.XPATH, using="(//span[contains(@style,'server.png')])[2]//..//div")
	public WebElement Devicetypeidentification;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='discovery_name']")
	public WebElement Discoveryname;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'alert-txt-1')]")
	public WebElement Invaliddiscoverynamealert;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='ip_range_start']")
	public WebElement IPrangestart;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='ip_range_end']")
	public WebElement IPrangeend;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Select Range ')]//..//p-dropdown[contains(@class,'ng-untouched ng-pristine ng-valid')]")
	public WebElement Selectrangedropdown;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'alert-txt-1')]")
	public WebElement Invalidiprangestart;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'ui-multiselect-trigger-icon')]")
	public WebElement Devicetypestrigger;
	@FindBy(how = How.XPATH, using="(//div[contains(@class, 'ui-chkbox-box')])[1]")
	public WebElement Devicetypecheckbox;
	@FindBy(how = How.XPATH, using="//input[contains(@class,'ui-inputtext')]")
	public WebElement Devicetypetextbox;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Create Discovery')]")
	public WebElement Creatediscoverybutton;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'ui-confirmdialog-message')]")
	public WebElement Discoverysuccessmessage;
	@FindBy(how = How.XPATH, using="//button[contains(@class,'full-view-btn')]")
	public WebElement Discoveryfullview;




	@FindBy(how = How.XPATH, using="//div[@class='zif-ic_logo']")
	private WebElement zifIclogo;

	@FindBy(how = How.XPATH, using="//div[contains(@class,'completed')]//..//span")
	public WebElement Discoverycompletedstatus;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'dashboard_ic')]")
	private WebElement dashboardicon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'analyze_ic')]")
	private WebElement analyzeIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'analyze_ic')]//following-sibling::span")
	private WebElement analyzesubmenuIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'settings_ic')]")
	private WebElement settingsIcon;


	//analyzes hover
	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]")
	private WebElement analyzeshovermenu;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'Operations')]")
	private WebElement operationheader;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'RawData')]")
	private WebElement SMrawdata;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'Analytics')]")
	private WebElement SManalytics;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'Predictions')]")
	private WebElement SMpredictions;

	//US1885//
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Configuration Settings')]")
	public WebElement ConfigurationSetting;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Name')]//..//input[contains(@class,'ng-untouched ng-pristine')]")
	public WebElement DisabledSNMPname;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Name')]//..//input[contains(@class,'ng-untouched ng-pristine')]")
	public List <WebElement> DisabledSNMPnameList;
	@FindBy(how = How.XPATH, using="(//span[@class='alert-txt'])[1]")
	public WebElement IPstartinvalid;
	@FindBy(how = How.XPATH, using="(//span[@class='alert-txt'])[2]")
	public WebElement IPendinvalid;
	@FindBy(how = How.XPATH, using="(//span[@class='alert-txt-1'])[1]")
	public WebElement WMIIPstartinvalid;
	@FindBy(how = How.XPATH, using="(//span[@class='alert-txt-1'])[2]")
	public WebElement WMIIPendinvalid;
	@FindBy(how = How.XPATH, using="(//span[@class='alert-txt-2'])[1]")
	public WebElement SSHstartinvalid;
	@FindBy(how = How.XPATH, using="(//span[@class='alert-txt-2'])[2]")
	public WebElement SSHPendinvalid;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Yes')]")
	public WebElement Deleteconfirmation;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'SNMP Details')]//..//span[contains(@class,'action-icon-delete')]")
	public List <WebElement> SNMPdelete;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'WMI Details')]//..//span[contains(@class,'action-icon-delete')]")
	public List <WebElement> WMIdelete;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'SSH Details')]//..//span[contains(@class,'action-icon-delete')]")
	public List <WebElement> SSHdelete;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Location')]//..//p-dropdown[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement LocationDropdown;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Type')]//..//p-dropdown[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement TypeDropdown;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Subnet Mask')]//..//p-dropdown[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SubnetMaskdropdown;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'SNMP Version')]//..//p-dropdown[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SNMPVersionDropdown;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Authentication Type ')]//..//p-dropdown[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement AuthenticationtypeDropdown;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Encryption Type')]//..//p-dropdown[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement EncryptiontypeDropdown;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Security Level')]//..//p-dropdown[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SecurityleveDropdown;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='snmp_range_start']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SNMPRangestart;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='wmi_range_start']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement WMIRangestart;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='ssh_range_start']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SSHRangestart;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='ssh_range_end']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SSHRangeend;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='snmp_range_end']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SNMPRangeend;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='wmi_range_end']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement WMIRangeend;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='auth_password']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SNMPAuthPassword;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='enc_password']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SNMPEncryptPassword;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='username']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SNMPUsername;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='engine_id']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SNMPEngineID;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'SNMP Details')]//..//span[@class='plus']")
	public WebElement SNMPaddicon;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'WMI Details')]//..//span[@class='plus']")
	public WebElement WMIaddicon;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'SSH Details')]//..//span[@class='plus']")
	public WebElement SSHaddicon;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='snmp_community_string']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SNMPCommunitystring;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='password']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement WMIPassword;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='username']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement WMIUsername;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='domain_name']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement WMIDomain;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='password']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SSHPassword;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='username']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SSHUsername;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='domain_name']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SSHDomain;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='snmp_community_string']//..//input[contains(@class,'ng-touched')]")
	public WebElement SNMPCommunitystringvalue;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='password']//..//input[contains(@class,'ng-touched')]")
	public WebElement WMIPasswordvalue;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='password']//..//input[contains(@class,'ng-touched')]")
	public WebElement SSHPasswordvalue;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='auth_password']//..//input[contains(@class,'ng-valid ng-touched')]")
	public WebElement SNMPAuthPasswordvalue;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='enc_password']//..//input[contains(@class,'ng-valid ng-touched')]")
	public WebElement SNMPEncryptPasswordvalue;
	@FindBy(how = How.XPATH, using="//div[@class='close-button']")
	public WebElement Discoveryconfigurationclose;
	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'pi-times')])[1]")
	public WebElement Close;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='region']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SNMPname;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='region']//..//input[contains(@class,'ng-untouched ng-pristine ng-invalid')]")
	public WebElement SSHname;
	@FindBy(how = How.XPATH, using="//input[@formcontrolname='region']//..//input[contains(@class,'g-valid ng-touched')]")
	public WebElement SSHnamevalue;
	@FindBy(how = How.XPATH, using="(//li[contains(@role,'option')])[1]")
	public WebElement Locationoption;
	@FindBy(how = How.XPATH, using="(//li[contains(@role,'option')])[1]")
	public WebElement Dropdownoption1;
	@FindBy(how = How.XPATH, using="(//li[contains(@role,'option')])[2]")
	public WebElement Dropdownoption2;
	@FindBy(how = How.XPATH, using="(//li[contains(@role,'option')])[3]")
	public WebElement Dropdownoption3;
	@FindBy(how = How.XPATH, using="(//li[contains(@role,'option')])[4]")
	public WebElement Dropdownoption4;
	@FindBy(how = How.XPATH, using="(//li[contains(@role,'option')])[17]")
	public WebElement Dropdownoption17;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'saved successfully')]")
	public WebElement ConfigurationSuccess;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Done')]")
	public WebElement ConfigurationDone;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Add New')]")
	public WebElement ConfigurationAddNew;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Save')]")
	public WebElement Savebutton;



	@FindBy(how = How.XPATH, using="//div[contains(text(),'Operations')]")
	private WebElement operationsTitle;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'RAWDATA')]")
	private WebElement rawdataTitle;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'ALERTS')]")
	public WebElement alertsLink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'INVENTORY')]")
	public WebElement inventoryLink;

	//Discovery//
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'p-text-nowrap')]//..//span[contains(@class,'ng-star')])[1]")
	public WebElement DiscoveryviewID;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'no-device')]")
	public WebElement Nodevicelist;
	@FindBy(how = How.XPATH, using="(//div[@class='value'])[1]")
	public WebElement DiscoveryID;
	@FindBy(how = How.XPATH, using="(//div[@class='value'])[2]")
	public WebElement CreatedDate;
	@FindBy(how = How.XPATH, using="(//div[@class='value'])[3]")
	public WebElement StartDate;
	@FindBy(how = How.XPATH, using="(//div[@class='value'])[4]")
	public WebElement EndDate;
	@FindBy(how = How.XPATH, using="(//div[@class='value'])[5]")
	public WebElement Location;
	@FindBy(how = How.XPATH, using="(//div[@class='value'])[6]")
	public WebElement RecursiveDiscovery;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'detail-close')]")
	public WebElement Backtodiscoverylist;
	@FindBy(how = How.XPATH, using="//div[@class='fs-14 title']")
	public WebElement listofdiscoverytitle;
	@FindBy(how = How.XPATH, using="//div[@class='right-panel']")
	public WebElement Rightpanel;
	@FindBy(how = How.XPATH, using="//div[@class='dis-name']")
	public List <WebElement> listofdiscoveryLHS;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'dev-interface')])[1]")
	public WebElement Interfacelink;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'dev-interface')]//..//span[@class='ng-star-inserted'])[1]")
	public WebElement Interfacelinkvalue;
	@FindBy(how = How.XPATH, using="//span[@class='export-icon']")
	public WebElement Export;
	@FindBy(how = How.XPATH, using="//button[normalize-space()='Expand']")
	public WebElement Expand;
	@FindBy(how = How.XPATH, using="//button[normalize-space()='Collapse']")
	public WebElement Collapse;
	@FindBy(how = How.XPATH, using="//span[@class='d-title']")
	public WebElement Devicetitlelink;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'p-text-truncate')])[1]")
	public WebElement Interfacelinklanding;
	@FindBy(how = How.XPATH, using="//span[@class='close-button']")
	public WebElement Closebutton;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'logout_ic')]")
	public WebElement Logout;
	@FindBy(how = How.XPATH, using="(//span[contains(text(),'ZIF')])[1]")
	public WebElement Discoveryzid;
	@FindBy(how = How.XPATH, using="//*[@id=\"ui-tabpanel-0\"]/div/app-interface-list/div/app-zif-table/p-table/div/div/div/div[2]/table/tbody/tr/td[1]/div/span")
	public  List <WebElement> Interfacevalue;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'interfaces-name')]")
	public  WebElement Interfacecount;
	@FindBy(how = How.XPATH, using="(//span[contains(text(),'GTM')])[1]")
	public WebElement Discoverygid;
	@FindBy(how = How.XPATH, using="//input[@placeholder='Search']")
	public WebElement Discoverysearch;
	@FindBy(how = How.XPATH, using="//span[@class='d-count']")
	public WebElement Devicecount;
	@FindBy(how = How.XPATH, using="//span[@ptooltip='Total']")
	public List <WebElement> Devicetotalcount;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[1]")
	public WebElement Servertotal;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[2]")
	public WebElement Desktoptotal;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[3]")
	public WebElement Laptoptotal;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[4]")
	public WebElement Unknowntotal;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[5]")
	public WebElement Wifitotal;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[6]")
	public WebElement IPtotal;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[7]")
	public WebElement L2total;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[8]")
	public WebElement Routertotal;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[9]")
	public WebElement Printertoal;
	@FindBy(how = How.XPATH, using="(//span[@ptooltip='Total'])[10]")
	public WebElement L3total;
	@FindBy(how = How.XPATH, using="//span[@class='ui-carousel-next-icon pi pi-chevron-right']")
	public WebElement rightarrow;
	@FindBy(how = How.XPATH, using="//th[@id='dev_name']")
	public WebElement devicename;
	@FindBy(how = How.XPATH, using="//th[@id='dev_type']")
	public WebElement devicetype;
	@FindBy(how = How.XPATH, using="//th[@id='dev_prim_ip_addr']")
	public WebElement deviceipaddr;
	@FindBy(how = How.XPATH, using="//th[@id='dev_manf_name']")
	public WebElement devicemanfname;
	@FindBy(how = How.XPATH, using="//th[@id='dev_model_name']")
	public WebElement devicemodelname;
	@FindBy(how = How.XPATH, using="//th[@id='if_count']")
	public WebElement deviceinterface;
	@FindBy(how = How.XPATH, using="//th[@id='dev_long_desc']")
	public WebElement devicedescription;
	@FindBy(how = How.XPATH, using="//th[@id='dev_status']")
	public WebElement devicestatus;
	@FindBy(how = How.XPATH, using="//th[@id='dev_pop_method']")
	public WebElement devicepopmethod;
	@FindBy(how = How.XPATH, using="//th[@id='dev_prim_mac_addr']")
	public WebElement deviceprimarymacaddr;
	@FindBy(how = How.XPATH, using="//th[@id='dev_sub_type']")
	public WebElement devicesubtype;

	//adaptor status
	@FindBy(how = How.XPATH, using="//span[contains(text(),'ZIF Adapter Status')]")
	private WebElement adaptorstatustext;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-status')]")
	private WebElement adaptorhealthstatus;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-up')]")
	private WebElement adaptorhealthstatusup;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'zif-health-down')]")
	private WebElement adaptorhealthstatusdown;

	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-livefeed')]")
	private WebElement LivefeedIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-export')]")
	private WebElement expoertIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'pref')]")
	public WebElement prefereceIcon;
	@FindBy(how = How.XPATH, using="//span[@class='alert-num']")
	public WebElement Searchcount;

	
	//AlertSettings
//	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-cntrl-discovery')]")
//	public WebElement alertSettingsIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@routerlink,'/home/discovery')]")
	public WebElement alertSettingsIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-settings enable-menu')]")
	private WebElement alertSettingsIconenabled;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'tab-settings disabled-menu')]")
	private WebElement alertSettingsIconDisabled;
	@FindBy(how = How.XPATH, using="")
	private WebElement alertSettingsTooltip;
	
	
	@FindBy(how = How.XPATH, using="//div[contains(@class,'filter')]")
	private WebElement alertFilterIcon;

	
	
	//Alert Settings Page
	@FindBy(how = How.XPATH, using="//strong[contains(text(),'Settings')]")
	private WebElement SettingsHeader;
	@FindBy(how = How.XPATH, using="//em[contains(@class,'close-icon')]")
	private WebElement Settingsclose;
	@FindBy(how = How.XPATH, using="//strong[contains(text(),'Event Rule Processing')]")
	private WebElement EventRuleProcessingHeader;
	
	@FindBy(how = How.XPATH, using="")
	private WebElement AllRules;
	@FindBy(how = How.XPATH, using="")
	private WebElement ConfigureRulestoGenerateAlerts;
	@FindBy(how = How.XPATH, using="")
	private WebElement CreateNewRuleBTN;

	//Rule in Settings Page
	@FindBy(how = How.XPATH, using="")
	private WebElement CreatedRule;
	
	
	
	//Create New Rule
	@FindBy(how = How.XPATH, using="")
	private WebElement CreatenewRuleheader;
	@FindBy(how = How.XPATH, using="")
	private WebElement ToolName;
	@FindBy(how = How.XPATH, using="")
	private WebElement ResourceType;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleName;
	@FindBy(how = How.XPATH, using="")
	private WebElement InventoryGrp;
	@FindBy(how = How.XPATH, using="")
	private WebElement DeviceName;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleStatus;
	@FindBy(how = How.XPATH, using="")
	private WebElement Alertpriority;
	@FindBy(how = How.XPATH, using="")
	private WebElement ConsecutiveLimit;
	@FindBy(how = How.XPATH, using="")
	private WebElement AlertMessage;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleDescription;
	
	@FindBy(how = How.XPATH, using="")
	private WebElement ValidateRuleBTN;
	@FindBy(how = How.XPATH, using="")
	private WebElement SaveBTN;
	@FindBy(how = How.XPATH, using="")
	private WebElement SaveBTNenabled;
	@FindBy(how = How.XPATH, using="")
	private WebElement SaveBTNdisabled;
	@FindBy(how = How.XPATH, using="")
	private WebElement CancelBTN;
	
	@FindBy(how = How.XPATH, using="")
	private WebElement ToolNameDD;

	
	@FindBy(how = How.XPATH, using="")
	private WebElement ResourceTypeDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleNameTxtbx;
	@FindBy(how = How.XPATH, using="")
	private WebElement InventoryGrpDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement DeviceNameDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleStatusDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement AlertpriorityDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement ConsecutiveLimitDD;
	@FindBy(how = How.XPATH, using="")
	private WebElement AlertMessageTxtbx;
	@FindBy(how = How.XPATH, using="")
	private WebElement RuleDescriptionTxtbx;
	@FindBy(how = How.XPATH, using="")
	private WebElement ExpressionCountersDD;

	
	//Tool Name Select Value
	@FindBy(how = How.XPATH, using="")
	private WebElement ToolNameValue;
	
	//Resource Type values
	@FindBy(how = How.XPATH, using="")
	private WebElement CPU;
	@FindBy(how = How.XPATH, using="")
	private WebElement Memory;
	@FindBy(how = How.XPATH, using="")
	private WebElement Disk;
	@FindBy(how = How.XPATH, using="")
	private WebElement Network;
	@FindBy(how = How.XPATH, using="")
	private WebElement Syslog;
	@FindBy(how = How.XPATH, using="")
	private WebElement Eventlog;
	@FindBy(how = How.XPATH, using="")
	private WebElement SNMP;
	
	//Inventory Group Value
	@FindBy(how = How.XPATH, using="")
	private WebElement InventoryGRPval1;
	@FindBy(how = How.XPATH, using="")
	private WebElement InventoryGRPval2;
	
	
	//Device Name Value
	@FindBy(how = How.XPATH, using="")
	private WebElement DeviceNameVal1;
	@FindBy(how = How.XPATH, using="")
	private WebElement DeviceNameVal2;
		
	//Rule Status  Value
	@FindBy(how = How.XPATH, using="")
	private WebElement Activestatus;
	@FindBy(how = How.XPATH, using="")
	private WebElement Inactivestatus;
	
	//Alert Priority values
	@FindBy(how = How.XPATH, using="")
	private WebElement Critical;
	@FindBy(how = How.XPATH, using="")
	private WebElement High;
	@FindBy(how = How.XPATH, using="")
	private WebElement Medium;
	@FindBy(how = How.XPATH, using="")
	private WebElement Low;
	@FindBy(how = How.XPATH, using="")
	private WebElement Warning;
	@FindBy(how = How.XPATH, using="")
	private WebElement Information;
	
	
	
	
	//Consecutive Limit values
		@FindBy(how = How.XPATH, using="")
		private WebElement CL1;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL2;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL3;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL4;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL5;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL6;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL7;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL8;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL9;
		@FindBy(how = How.XPATH, using="")
		private WebElement CL10;
		
		
		
		//Expression Values
		@FindBy(how = How.XPATH, using="")
		private WebElement Expression;
		@FindBy(how = How.XPATH, using="")
		private WebElement Condition;
		@FindBy(how = How.XPATH, using="")
		private WebElement Value;
		@FindBy(how = How.XPATH, using="")
		private WebElement operator;
		@FindBy(how = How.XPATH, using="")
		private WebElement addExpression;
		@FindBy(how = How.XPATH, using="")
		private WebElement Removeexpression;
		@FindBy(how = How.XPATH, using="")
		private WebElement counterDD;
		@FindBy(how = How.XPATH, using="")
		private WebElement ConditionDD;
		@FindBy(how = How.XPATH, using="")
		private WebElement ValueDD;
		@FindBy(how = How.XPATH, using="")
		private WebElement OperatorDD;
		@FindBy(how = How.XPATH, using="")
		private WebElement FirstExpressionCheckbox;
		@FindBy(how = How.XPATH, using="")
		private WebElement SecondExpressionCheckbox;
	
		
		//Counters value 
		@FindBy(how = How.XPATH, using="")
		private WebElement CPUvalue;
		@FindBy(how = How.XPATH, using="")
		private WebElement MemoryValue;
		@FindBy(how = How.XPATH, using="")
		private WebElement Diskvalue;
		
		
		//Condition Value
		@FindBy(how = How.XPATH, using="")
		private WebElement lessthan;
		@FindBy(how = How.XPATH, using="")
		private WebElement greaterthan;
		@FindBy(how = How.XPATH, using="")
		private WebElement equal;
		
		//Value
		
		//Pass the random value to Xpath after taking or in the Script
		@FindBy(how = How.XPATH, using="")
		private WebElement valueonetoten;
		
		
		//Operator value
		@FindBy(how = How.XPATH, using="")
		private WebElement And;
		@FindBy(how = How.XPATH, using="")
		private WebElement OR;
		
		
		
	//Validation Message
		@FindBy(how = How.XPATH, using="")
		private WebElement partialdatavalidationmessage;
		@FindBy(how = How.XPATH, using="")
		private WebElement missingOptionalvalidationmsg;
		@FindBy(how = How.XPATH, using="")
		private WebElement validatedsuccessmsg;
		@FindBy(how = How.XPATH, using="")
		private WebElement InvalidExpressionmsg;

		//US 1762//
		@FindBy(how = How.XPATH, using="(//div[@tooltipstyleclass='left-arw-preference'])[1]")
		public WebElement Toolnameihover;
		@FindBy(how = How.XPATH, using="(//div[@tooltipstyleclass='left-arw-preference'])[2]")
		public WebElement Devicenameihover;
		@FindBy(how = How.XPATH, using = "//*[contains(text(),'Cancel')]")
		public WebElement Prefcancel;
		@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname,'toolName')]")
		public WebElement PrefToolname;
		@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname,'deviceName')]")
		public WebElement PrefDevicename;
		@FindBy(how = How.XPATH, using = "//input[contains(@formcontrolname,'alertSeverity')]")
		public WebElement PrefAlertseverity;
		@FindBy(how = How.XPATH, using = "//div[@ptooltip='Preferences']")
		public WebElement PreferencesTab;
		@FindBy(how = How.XPATH, using = "//*[contains(text(),'Save')]")
		public WebElement PrefSave;
		@FindBy(how = How.XPATH, using = "//div[contains(@class,'tab-apply_pref')]")
		public WebElement prefereceIconwithdots;
		@FindBy(how = How.XPATH, using = "(//div[contains(@class,'devName')])[1]")
		public WebElement Devicenametext;
		@FindBy(how = How.XPATH, using = "(//div[contains(@class,'tool_name')])[1]")
		public WebElement Toolnametext;
		@FindBy(how = How.XPATH, using = "//div[contains(@class,'tab-apply_pref')]")
		public WebElement Severitytext;
		@FindBy(how = How.XPATH, using = "(//div[contains(@class,'case_cri_img')])[1]")
		public WebElement Criticalval;
		@FindBy(how = How.XPATH, using = "(//div[contains(@class,'case_high_img')])[1]")
		public WebElement Highval;
		@FindBy(how = How.XPATH, using = "//*[contains(text(),'No Data Found')]")
		public WebElement Nodatafound;

		
		
		
		
		
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

	public void ClearPreferenceToolname(CharSequence Value) {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				PreferencesTab.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefDevicename.sendKeys(b + b +  b +b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefToolname.sendKeys(b + b +  b +b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefToolname.sendKeys(Value);
				Thread.sleep(2000);
				PrefDevicename.sendKeys(b + b + b + b + b +b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefAlertseverity.sendKeys(b +b + b + b +b + b + b + b + b + b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefSave.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefDevicename.sendKeys(b + b +  b +b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefToolname.sendKeys(b + b +  b +b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefToolname.sendKeys(Value);
				Thread.sleep(2000);
				PrefDevicename.sendKeys(b + b + b + b + b +b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefAlertseverity.sendKeys(b +b + b + b +b + b + b + b + b + b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefSave.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}
	}

	public void ClearPreferenceDevicename(CharSequence Value) {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				PreferencesTab.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefToolname.sendKeys(b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefDevicename.sendKeys(b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefDevicename.sendKeys(Value);
				Thread.sleep(3000);
				PrefAlertseverity.sendKeys(b +b + b + b + b + b + b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefSave.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefToolname.sendKeys(b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefDevicename.sendKeys(b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefDevicename.sendKeys(Value);
				Thread.sleep(3000);
				PrefAlertseverity.sendKeys(b +b +b + b + b + b + b + b + b + b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefSave.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}
	}

	public void ClearPreferenceSeverityname(CharSequence Value) {
		try {
			if (PreferencesTab.isDisplayed()) {
				Thread.sleep(3000);
				PreferencesTab.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefToolname.sendKeys(b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefDevicename.sendKeys(b +b +b + b + b + b + b + b + b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefAlertseverity.sendKeys(b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefAlertseverity.sendKeys(Value);
				Thread.sleep(2000);
				PrefSave.click();
				Thread.sleep(2000);
			} else if (prefereceIconwithdots.isDisplayed()) {
				Thread.sleep(3000);
				prefereceIconwithdots.click();
				Thread.sleep(3000);
				String b = Keys.BACK_SPACE.toString();
				PrefToolname.sendKeys(b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(2000);
				PrefDevicename.sendKeys(b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefAlertseverity.sendKeys(b +b +b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b + b);
				Thread.sleep(3000);
				PrefAlertseverity.sendKeys(Value);
				Thread.sleep(2000);
				PrefSave.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

		}
	}


	public void clickPrediction(){

		SMpredictions.click();
	}
	public void clickRawdata(){

		SMrawdata.click();
	}
	public void clickanalytics(){

		SManalytics.click();
	}
	
	public void clickalertlink(){

		alertsLink.click();
	}
	
	public void clickSettings() {
		try {
			alertSettingsIcon.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void NavigatetoAlertpage() {
		new CommonMethods(driver).MovetoElement(analyzeIcon);
		SMrawdata.click();
	}


//	public void DeleteSNMPconfigdetails() throws InterruptedException {
//		try {
//			int notsze = SNMPdelete.size();
//			for (int i = 1; i <notsze; i++) {
//				Thread.sleep(3000);
//				Boolean value = SNMPdelete.get(i).isDisplayed();
//				if (value) {
//					Thread.sleep(3000);
//					SNMPdelete.get(i).click();
//					Deleteconfirmation.click();
//					Thread.sleep(3000);
//				}
//				else if(!value){
//					System.out.println("SNMP instance is less than 1");
//				}
//			}
//			Thread.sleep(3000);
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("Exception " + e);
//		} catch (Exception e) {
//			System.out.println("Exception " + e);
//		}
//	}


	public void DeleteSNMPconfigdetails() throws InterruptedException {
		try {
			int size = new ZIFAI_AlertsSettingsPage(driver).DisabledSNMPnameList.size();
			List<WebElement> Listcombo = new ZIFAI_AlertsSettingsPage(driver).DisabledSNMPnameList;
			for (int i = 0; i < size; i++) {
				String snmp = Listcombo.get(i).getAttribute("value");
				System.out.println("Value from the configuration disabled text box:" + snmp);
				if (snmp.contains("Automode")) {
					new ZIFAI_AlertsSettingsPage(driver).SNMPdelete.get(i).click();
					Thread.sleep(3000);
					new ZIFAI_AlertsSettingsPage(driver).Deleteconfirmation.click();
					Thread.sleep(3000);
				} else {
					System.out.println("Automation created configuration is not available " + snmp);
				}
			}
		} catch (IndexOutOfBoundsException e) {

		} catch (Exception e) {

		}
	}

	public void DeleteWMIconfigdetails() throws InterruptedException {
		try {
			int size = new ZIFAI_AlertsSettingsPage(driver).DisabledSNMPnameList.size();
			List<WebElement> Listcombo = new ZIFAI_AlertsSettingsPage(driver).DisabledSNMPnameList;
			for (int i = 0; i < size; i++) {
				String snmp = Listcombo.get(i).getAttribute("value");
				System.out.println("Value from the configuration disabled text box:" + snmp);
				if (snmp.contains("Automode")) {
					new ZIFAI_AlertsSettingsPage(driver).WMIdelete.get(i).click();
					Thread.sleep(3000);
					new ZIFAI_AlertsSettingsPage(driver).Deleteconfirmation.click();
					Thread.sleep(3000);
				} else {
					System.out.println("Automation created configuration is not available " + snmp);
				}
			}
		} catch (IndexOutOfBoundsException e) {

		} catch (Exception e) {

		}
	}

	public void DeleteSSHconfigdetails() throws InterruptedException {
		try {
			int size = new ZIFAI_AlertsSettingsPage(driver).DisabledSNMPnameList.size();
			List<WebElement> Listcombo = new ZIFAI_AlertsSettingsPage(driver).DisabledSNMPnameList;
			for (int i = 0; i < size; i++) {
				String snmp = Listcombo.get(i).getAttribute("value");
				System.out.println("Value from the configuration disabled text box:" + snmp);
				if (snmp.contains("Automode")) {
					new ZIFAI_AlertsSettingsPage(driver).SSHdelete.get(i).click();
					Thread.sleep(3000);
					new ZIFAI_AlertsSettingsPage(driver).Deleteconfirmation.click();
					Thread.sleep(3000);
				} else {
					System.out.println("Automation created configuration is not available " + snmp);
				}
			}
		} catch (IndexOutOfBoundsException e) {

		} catch (Exception e) {

		}
	}
	
	public void settingstooltip() {
		new CommonMethods(driver).MovetoElement(alertSettingsIcon);
		assertTrue(alertSettingsTooltip.isDisplayed());
	}
	
	public void alertSettingsEnabled() {
		assertTrue(alertSettingsIconenabled.isDisplayed());
	}
	public void alertSettingsdisabled() {
		assertTrue(alertSettingsIconDisabled.isDisplayed());
	}
	
	//Settings Page enabled view
	public void Verifyviewsettingspageaccess() {
		assertTrue(SettingsHeader.isDisplayed());
		assertTrue(Settingsclose.isDisplayed());
		assertTrue(EventRuleProcessingHeader.isDisplayed());
	}
	//Settings page Disabled view
	public void Verifyviewsettingspageaccessdisabled() {
		assertTrue(SettingsHeader.isDisplayed());
		assertTrue(Settingsclose.isDisplayed());
		try {
		assertFalse(EventRuleProcessingHeader.isDisplayed());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void createnewRuleBtnEnabled() {
		assertTrue(CreateNewRuleBTN.isDisplayed());
	}
	public void createnewRuleBtnNotavailable() {
		try {
		assertFalse(CreateNewRuleBTN.isDisplayed());
		}
		catch (Exception e) {
		}
	}
	
	public void CreateNewRuleClick() {
		try {
		if(CreateNewRuleBTN.isDisplayed())
		{
			CreateNewRuleBTN.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void verifyslidewindowFields() {
		assertTrue(CreatenewRuleheader.isDisplayed());
		assertTrue(ToolName.isDisplayed());
		assertTrue(ToolNameDD.isDisplayed());
		assertTrue(ResourceType.isDisplayed());
		assertTrue(ResourceTypeDD.isDisplayed());
		assertTrue(RuleName.isDisplayed());
		assertTrue(RuleNameTxtbx.isDisplayed());
		assertTrue(InventoryGrp.isDisplayed());
		assertTrue(InventoryGrpDD.isDisplayed());
		assertTrue(ConsecutiveLimit.isDisplayed());
		assertTrue(ConsecutiveLimitDD.isDisplayed());
		assertTrue(AlertMessage.isDisplayed());
		assertTrue(AlertMessageTxtbx.isDisplayed());
		assertTrue(RuleDescription.isDisplayed());
		assertTrue(RuleDescriptionTxtbx.isDisplayed());
		assertTrue(Expression.isDisplayed());
		assertTrue(ExpressionCountersDD.isDisplayed());
		
		
		assertTrue(ValidateRuleBTN.isDisplayed());
		assertTrue(SaveBTN.isDisplayed());
		assertTrue(CancelBTN.isDisplayed());
	}
	
	public void ClickonToolNameDropdown() {
		try {
		if(ToolNameDD.isDisplayed())
		{
			ToolNameDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyToolNameDropdownValues() {
		assertTrue(ToolNameValue.isDisplayed());
	}
	
	public void ClickonResourceTypeDropdown() {
		try {
		if(ResourceTypeDD.isDisplayed())
		{
			ResourceTypeDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifyResourceTypeDropdownValues() {
		assertTrue(CPU.isDisplayed());
		assertTrue(Memory.isDisplayed());
		assertTrue(Disk.isDisplayed());
		assertTrue(Network.isDisplayed());
		assertTrue(Syslog.isDisplayed());
		assertTrue(Eventlog.isDisplayed());
		assertTrue(SNMP.isDisplayed());
	}
	
	public void SelectanyResourceType() {
		CPU.click();
	}
	
	
	public void EnterValueinRuleName(String RuleName) {
		
		RuleNameTxtbx.sendKeys(RuleName);
	}
	
	public int GetValueinRuleName() {
		
		String rulename=RuleNameTxtbx.getText();
		int count = 0;    
        
        //Counts each character except space    
        for(int i = 0; i < rulename.length(); i++) {    
            if(rulename.charAt(i) != ' ')    
                count++;    
        }    
		return count;
	}
	
	
	public void EnterValueinRuleDescription(String RuleName) {
		
		RuleDescriptionTxtbx.sendKeys(RuleName);
	}
	
	public int GetValueinRuleDescription() {
		
		String ruleDesc=RuleDescriptionTxtbx.getText();
		int count = 0;    
        
        //Counts each character except space    
        for(int i = 0; i < ruleDesc.length(); i++) {    
            if(ruleDesc.charAt(i) != ' ')    
                count++;    
        }    
		return count;
	}
	
	public void EnterValueinAlertMessage(String RuleName) {
		
		AlertMessageTxtbx.sendKeys(RuleName);
	}
	
	public int GetValueinAlertMessage() {
		
		String ruleDesc=AlertMessageTxtbx.getText();
		int count = 0;    
        
        //Counts each character except space    
        for(int i = 0; i < ruleDesc.length(); i++) {    
            if(ruleDesc.charAt(i) != ' ')    
                count++;    
        }    
		return count;
	}
	
	public void ClickonruleStatusDropdown() {
		try {
		if(RuleStatusDD.isDisplayed())
		{
			RuleStatusDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifyruleStatusDropdownValues() {
		assertTrue(Activestatus.isDisplayed());
		assertTrue(Inactivestatus.isDisplayed());
		
	}
	
	public void clickonAlertprioritydropdown() {
		try {
		if(AlertpriorityDD.isDisplayed())
		{
			AlertpriorityDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifyAlertprioritydropdownValues() {
		assertTrue(Critical.isDisplayed());
		assertTrue(High.isDisplayed());
		assertTrue(Medium.isDisplayed());
		assertTrue(Low.isDisplayed());
		assertTrue(Warning.isDisplayed());
		assertTrue(Information.isDisplayed());
	}
	
	public void clickonConsecutiveOccdropdown() {
		try {
		if(ConsecutiveLimitDD.isDisplayed())
		{
			ConsecutiveLimitDD.click();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifyConsecutiveOccdropdownValues() {
		assertTrue(CL1.isDisplayed());
		assertTrue(CL2.isDisplayed());
		assertTrue(CL3.isDisplayed());
		assertTrue(CL4.isDisplayed());
		assertTrue(CL5.isDisplayed());
		assertTrue(CL6.isDisplayed());
		assertTrue(CL7.isDisplayed());
		assertTrue(CL8.isDisplayed());
		assertTrue(CL9.isDisplayed());
		assertTrue(CL10.isDisplayed());
		
	}
	
	
	public void selectallmandatorydropdownsAndValidate() {
		try {
			ToolNameDD.click();
			ToolNameValue.click();
		}catch (Exception e) {
		}
		try {
			ResourceTypeDD.click();
			CPU.click();
		}catch (Exception e) {
		}
		
		try {
			RuleStatusDD.click();
			Activestatus.click();
		}catch (Exception e) {
		}
		try {
			AlertpriorityDD.click();
			High.click();
		}catch (Exception e) {
		}
		try {
			ConsecutiveLimitDD.click();
			CL9.click();
		}catch (Exception e) {
		}
		
		try {
			Thread.sleep(2000);
			ValidateRuleBTN.click();
		} catch (Exception e) {
		}
		
	}
	
	public void EnterallmandatorytextboxAndValidate() {
		RuleNameTxtbx.clear();
		RuleNameTxtbx.sendKeys("Validate");
		RuleNameTxtbx.clear();
		AlertMessageTxtbx.sendKeys("Validate the Alert Message");
		RuleDescriptionTxtbx.clear();
		RuleDescriptionTxtbx.sendKeys("Validate the Rule Description");
		try {
			Thread.sleep(2000);
			ValidateRuleBTN.click();
		} catch (Exception e) {
		}
	}
	
	public void SelectallfieldsexceptOptional() {
		try {
			ToolNameDD.click();
			ToolNameValue.click();
		}catch (Exception e) {
		}
		try {
			ResourceTypeDD.click();
			CPU.click();
		}catch (Exception e) {
		}
		
		try {
			RuleStatusDD.click();
			Activestatus.click();
		}catch (Exception e) {
		}
		try {
			AlertpriorityDD.click();
			High.click();
		}catch (Exception e) {
		}
		try {
			ConsecutiveLimitDD.click();
			CL9.click();
		}catch (Exception e) {
		}
		RuleNameTxtbx.clear();
		RuleNameTxtbx.sendKeys("Validate");
		RuleNameTxtbx.clear();
		AlertMessageTxtbx.sendKeys("Validate the Alert Message");
		RuleDescriptionTxtbx.clear();
		RuleDescriptionTxtbx.sendKeys("Validate the Rule Description");
		
	}
	
	public void SelectbetweenOptional() {
		String[] arr = {"I", "D"};
        int randIdx = ThreadLocalRandom.current().nextInt(arr.length);
        String randomElem = arr[randIdx];
        
        if(randomElem=="I") {
        	InventoryGrpDD.click();
        	InventoryGRPval1.click();
        }else {
			DeviceNameDD.click();
			DeviceNameVal1.click();
		}
        
        try {
			Thread.sleep(2000);
			ValidateRuleBTN.click();
		} catch (Exception e) {
		}
	}
	
	
	public void PartialvalidationErrormessage() {		
	assertTrue(partialdatavalidationmessage.isDisplayed());	
	}	
	public void missingoptionalvalidationErrormessage() {
		assertTrue(missingOptionalvalidationmsg.isDisplayed());
	}	
	public void InvalidExpressionErrormessage() {
		assertTrue(InvalidExpressionmsg.isDisplayed());
	}
	public void validationsuccessrmessage() {
		assertTrue(validatedsuccessmsg.isDisplayed());
	}
	public void ChecksavebtnDisabled() {		
		assertTrue(SaveBTNdisabled.isDisplayed());	
		}
	public void Checksavebtnenabled() {		
		assertTrue(SaveBTNenabled.isDisplayed());	
		}
	public void clickCancelBtn() {				
		try {
			CancelBTN.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	public void clickSaveBtn() {				
		try {
			SaveBTN.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
public void clickValidatRuleeBtn() {		
		try {
			ValidateRuleBTN.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	
	public void selectvalidExpression() {	
		System.out.println("Need To update the Expression Part per code");
	}
	public void VerifyRuleinSettingspage() {		
		System.out.println("Need To update the Expression Part per code");
	}
	
	public void SelectcountervalueExpression() {
		try {
			counterDD.click();
			Thread.sleep(2000);
			CPUvalue.click();
		}catch (Exception e) {			
		}	
	}
	public void selectGreaterthan() {
		try {
			ConditionDD.click();
			Thread.sleep(2000);
			greaterthan.click();
		}catch (Exception e) {	
		}	
	}
	public void selectLessthan() {
		try {
			ConditionDD.click();
			Thread.sleep(2000);
			lessthan.click();
		}catch (Exception e) {	
		}	
	}
	public void selectequal() {
		try {
			ConditionDD.click();
			Thread.sleep(2000);
			equal.click();
		}catch (Exception e) {	
		}	
	}
	public void selectAndoperator() {
		try {
			OperatorDD.click();
			Thread.sleep(2000);
			And.click();
		}catch (Exception e) {	
		}	
	}
	public void selectORoperator() {
		try {
			OperatorDD.click();
			Thread.sleep(2000);
			OR.click();
		}catch (Exception e) {	
		}	}

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
		
	
		public void Settingsclose() {
			try {
				Settingsclose.click();
				Thread.sleep(2000);
				}catch (Exception e) {	
			}	}
		
			}

	
