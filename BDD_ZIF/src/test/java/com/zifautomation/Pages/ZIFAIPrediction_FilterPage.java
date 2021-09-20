package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zifautomation.Utility.CommonMethods;

public class ZIFAIPrediction_FilterPage {

	WebDriver driver;


	public ZIFAIPrediction_FilterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



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



	@FindBy(how = How.XPATH, using="//div[contains(text(),'OPPORTUNITIES')]")
	private WebElement opportunitiesTitle;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'RESOURCE UTILIZATION')]")
	private WebElement resourceutilizationlink;
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
	private WebElement filterIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'settings')]")
	private WebElement predictionsettingsIcon;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'pref')]")
	private WebElement prefereceIcon;

	//Filter Options
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Filter')]")
	private WebElement Filtertitle;
	@FindBy(how = How.XPATH, using="//a[contains(@class,'titlebar-close')]")
	private WebElement closefilter;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Opportunity ID')]")
	private WebElement oppIDtext;
	@FindBy(how = How.XPATH, using="//input[contains(@formcontrolname,'oppId')]")
	private WebElement oppIDinput;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Device Name')]")
	private WebElement DeviceNametext;
	@FindBy(how = How.XPATH, using="//input[contains(@formcontrolname,'deviceName')]")
	private WebElement DeviceNameinput;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Resource Group')]")
	private WebElement ResourcegrpText;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Counters')]")
	private WebElement counterstext;

	@FindBy(how = How.XPATH, using="//div[contains(text(),'Drive / Mount Name')]")
	private WebElement drivemountText;
	@FindBy(how = How.XPATH, using="//button[contains(@label,'Apply')]")
	private WebElement applybutton;
	@FindBy(how = How.XPATH, using="//button[contains(@label,'Clear')]")
	private WebElement clearbutton;

	//Resource Drop down
	@FindBy(how = How.XPATH, using="//p-dropdown[contains(@formcontrolname,'resource')]")
	private WebElement resourceDD;
	@FindBy(how = How.XPATH, using="//li[contains(@aria-label,'cpu')]")
	private WebElement RsCPU;
	@FindBy(how = How.XPATH, using="//li[contains(@aria-label,'memory')]")
	private WebElement RsMemory;
	@FindBy(how = How.XPATH, using="//li[contains(@aria-label,'network')]")
	private WebElement RsNetwork;
	@FindBy(how = How.XPATH, using="//li[contains(@aria-label,'disk')]")
	private WebElement RsDisk;


	//Counter Drop Down
	@FindBy(how = How.XPATH, using="//p-dropdown[contains(@formcontrolname,'counters')]")
	private WebElement countersDD;
	@FindBy(how = How.XPATH, using="//p-dropdown[contains(@formcontrolname,'counters')]//div")
	private WebElement counterDDenabled;
	@FindBy(how = How.XPATH, using="//p-dropdown[contains(@formcontrolname,'counters')]//div[contains(@class,'disabled')]")
	private WebElement counterDDdisabled;
	@FindBy(how = How.XPATH, using="//li[contains(@aria-label,'processor_processor_time')]")
	private WebElement CPUcounterprocessor_processor_time;
	@FindBy(how = How.XPATH, using="//li[contains(@aria-label,'memory_commited_bytesinuse')]")
	private WebElement Memorycountermemory_commited_bytesinuse;
	@FindBy(how = How.XPATH, using="(//li[contains(@aria-label,'mount_percent_used')])[1]")
	private WebElement Diskcountermount_percent_used;

	//Drive / Mount Drop Down
	@FindBy(how = How.XPATH, using="//p-dropdown[contains(@formcontrolname,'drive')]")
	private WebElement driveDD;
	@FindBy(how = How.XPATH, using="//p-dropdown[contains(@formcontrolname,'drive')]//div")
	private WebElement driveDDEnabled;
	@FindBy(how = How.XPATH, using="//p-dropdown[contains(@formcontrolname,'drive')]//div[contains(@class,'disabled')]")
	private WebElement driveDDdisabled;


	//opportunity cards

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-cards warn-state')][1]")
	private WebElement PRcard1;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'no-data-cls')]")
	private WebElement PRnodataAvailable;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-cards critical-state')][1]")
	private WebElement CRcard1;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'no-data-cls')]")
	private WebElement CRnodataAvailable;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-cards processed-state')][1]")
	private WebElement PDcard1;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'no-data-cls')]")
	private WebElement PDnodataAvailable;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]")
	private WebElement LTcard1;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'no-data-cls')]")
	private WebElement LTnodataAvailable;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-cards invalid-state')][1]")
	private WebElement IVcard1;
	@FindBy(how = How.XPATH, using="(//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'no-data-cls')]")
	private WebElement IVnodataAvailable;




	public void clickFilter() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverWait wait=new WebDriverWait(driver,20);
		//WebElement filterIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'filters')]")));
		WebElement filterIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'filter')]")));
		//filterIcon.isDisplayed();
		filterIcon.click();
	}
	
	public void clickAppliedFilter() {
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement filterIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'filter')]")));
		//filterIcon.isDisplayed();
		filterIcon.click();
	}
	public void Filteroptiondisplayed() {
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement filterIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'filter')]")));
		assertTrue(filterIcon.isDisplayed());
	}
	public void ApplyButton() {
		applybutton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public void ClearButton() {
		
		clearbutton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public void closeFilter() {
		closefilter.click();
	}

	public void ClickResourceGroupdropdown() {
		resourceDD.click();
	}

	public void ClickCountersdropdown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		countersDD.click();
	}

	public void ClickDriveMountdropdown() {
		driveDD.click();
	}


	public void verifyFilteroptions() {

		assertTrue(Filtertitle.isDisplayed());
		assertTrue(closefilter.isDisplayed());
		assertTrue(oppIDtext.isDisplayed());
		assertTrue(DeviceNametext.isDisplayed());
		assertTrue(oppIDinput.isDisplayed());
		assertTrue(DeviceNameinput.isDisplayed());
		assertTrue(ResourcegrpText.isDisplayed());
		assertTrue(counterstext.isDisplayed());
		assertTrue(drivemountText.isDisplayed());

		assertTrue(applybutton.isDisplayed());
		assertTrue(clearbutton.isDisplayed());
	}

	public void verifyResourcedropdownfields() {
		assertTrue(RsCPU.isDisplayed());
		assertTrue(RsMemory.isDisplayed());
		//assertTrue(RsNetwork.isDisplayed());
		assertTrue(RsDisk.isDisplayed());
	}

	public void enterOppcardvalue(String oppId) {
		oppIDinput.clear();
		oppIDinput.sendKeys(oppId);
	}
	public void enterDeviceNamevalue(String DeviceName) {
		DeviceNameinput.clear();
		DeviceNameinput.sendKeys(DeviceName);
	}


	public void selectCPUResource() {
		RsCPU.click();
	}
	public void selectMemoryResource() {
		RsMemory.click();
	}
	public void selecDiskResource() {
		RsDisk.click();
	}
	public void selectNetworkResource() {
		RsNetwork.click();
	}



	public void selectCPUcounter() {
		CPUcounterprocessor_processor_time.click();
	}
	public void selectMemorycounter() {
		Memorycountermemory_commited_bytesinuse.click();
	}
	public void selectDiskcounter() {
		Diskcountermount_percent_used.click();
	}
	public void selectNetworkcounter() {
		//RsNetwork.click();
	}

	public void verifydrivedropdowndisabled() {
		assertTrue(driveDDdisabled.isDisplayed());
	}
	public void verifydrivedropdownenabled() {
		assertTrue(driveDDEnabled.isDisplayed());
	}

	public void verifycounterdropdowndisabled() {
		assertTrue(counterDDdisabled.isDisplayed());
	}
	public void verifycounterdropdownenabled() {
		assertTrue(counterDDenabled.isDisplayed());
	}

	public void VerifyDeviceNameoppCardOnFilter(String DeviceName) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		try {
			Thread.sleep(3000);
			WebElement lostcard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]")));
			if(lostcard.isDisplayed())
			{
				WebElement deviceName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]/child::span/child::div[3]")));
				String Dname = deviceName.getText();
				System.out.println(Dname);		

				assertTrue(Dname.contains(DeviceName));

			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void VerifyOPPIDoppCardOnFilter(String oppID) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		try {
			Thread.sleep(3000);
			WebElement lostcard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]")));
			if(lostcard.isDisplayed())
			{
				WebElement Oppid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-cards lost-state')][1]/child::span/child::div[1]")));
				String OPcardID = Oppid.getText();
				System.out.println(OPcardID);		

				assertTrue(OPcardID.contains(oppID));

			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	public void VerifyNoDATAforInvalidFilter() {
		WebDriverWait wait=new WebDriverWait(driver,20);
		try {
			Thread.sleep(3000);
			
				WebElement NoData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'no-data-cls')]")));

				assertTrue(NoData.isDisplayed());

			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
