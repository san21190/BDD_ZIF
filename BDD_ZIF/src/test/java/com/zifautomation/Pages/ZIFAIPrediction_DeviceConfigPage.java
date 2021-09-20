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
import org.openqa.selenium.support.ui.Select;

import com.zifautomation.Utility.CommonMethods;

public class ZIFAIPrediction_DeviceConfigPage {
	WebDriver driver;

	public ZIFAIPrediction_DeviceConfigPage(WebDriver driver)
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



	//Installation and Activation of ZIF One Agent
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Installation and Activation of ZIF One Agent')]")
	private WebElement InstallationandActivationHeader;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Device Configuration')]")
	private WebElement DeviceConfig;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Integration')]")
	private WebElement Integration;
	@FindBy(how = How.XPATH, using="//div[contains(@class,'closeAd')]")
	private WebElement closeAd;


	//Device Configuration


	@FindBy(how = How.XPATH, using="//span[contains(text(),'Select by Device')]")
	private WebElement selectdevice;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Select by Category')]")
	private WebElement selectcategory;



	//Tabs
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Counter Configuration')]")
	private WebElement counterconfig;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Set Polling Interval')]")
	private WebElement setpollinginterval;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Threshold Configuration')]")
	private WebElement thresholdconfig;

	//Counter Cobnfiguration

	@FindBy(how = How.XPATH, using="//span[contains(text(),'CPU')]")
	private WebElement counterCPU;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Disk')]")
	private WebElement counterDisk;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Memory')]")
	private WebElement counterMemory;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Network')]")
	private WebElement counterNetwork;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'List of Counters')]")
	private WebElement listOfCounters;
	@FindBy(how = How.XPATH, using="//input[contains(@placeholder,'Search')]")
	private WebElement searchbox;


	// CPU counters
	@FindBy(how = How.XPATH, using="//span[contains(text(),'cpu_count')]//parent::div")
	private WebElement cpucount;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'cpu_time_idle')]//parent::div")
	private WebElement cputimeidle;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'processor_processor_time')]//parent::div")
	private WebElement processorprocessortime;

	//Disk

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Windows')]")
	private WebElement windowslink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Linux')]")
	private WebElement linuxlink;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'AIX')]")
	private WebElement aixlink;

	//disk counters
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Mounts')]")
	private WebElement mountstext;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'/home')]//parent::div")
	private WebElement homecounter;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'/boot')]//parent::div")
	private WebElement bootcounter;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'/dev')]//parent::div")
	private WebElement devcounter;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'mount_name')]//parent::div")
	private WebElement mount_name;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'mount_percent_used')]//parent::div")
	private WebElement mount_percent_used;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'mount_total_size')]//parent::div")
	private WebElement mount_total_size;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'mount_used_space')]//parent::div")
	private WebElement mount_used_space;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'mount_avail_space')]//parent::div")
	private WebElement mount_avail_space;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'file_system')]//parent::div")
	private WebElement file_system;


	//Memory Counters
	@FindBy(how = How.XPATH, using="//span[contains(text(),'memory_total')]//parent::div")
	private WebElement memory_total;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'memory_available_mbytes')]//parent::div")
	private WebElement memory_available_mbytes;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'memory_free_systempagetableentries')]//parent::div")
	private WebElement memory_free_systempagetableentries;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'total_swap_memory')]//parent::div")
	private WebElement total_swap_memory;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'total_swap_memory_free')]//parent::div")
	private WebElement total_swap_memory_free;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'total_swap_memory_used')]//parent::div")
	private WebElement total_swap_memory_used;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'total_swap_memory_percent')]//parent::div")
	private WebElement total_swap_memory_percent;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'memory_commited_bytesinuse')]//parent::div")
	private WebElement memory_commited_bytesinuse;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'memory_available_absolute')]//parent::div")
	private WebElement memory_available_absolute;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'memory_total_absolute')]//parent::div")
	private WebElement memory_total_absolute;


	//Selected counters
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Selected :')]")
	private WebElement selected;
	@FindBy(how = How.XPATH, using="//span[contains(text(),' Counters : ')]")
	private WebElement selectedcounters;
	@FindBy(how = How.XPATH, using="//span[contains(@class,'delete-counters')]")
	private WebElement deletecounters;
	@FindBy(how = How.XPATH, using="(//span[contains(@class,'breadcrumb-countr-count')])[2]")
	private WebElement countervalue;


	//savebutton
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Save')]")
	private WebElement Savebtn;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Please select atleast one device')]")
	private WebElement SaveError;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Data Saved Successfully')]")
	private WebElement SaveSuccessMsg;



	//Set Polling Interval
	@FindBy(how = How.XPATH, using="//span[contains(text(),'CPU')]")
	private WebElement pollingcpu;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Disk')]")
	private WebElement poolingdisk;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Memory')]")
	private WebElement pollingMemory;

	//Polling DropDowns
	//CPU
	@FindBy(how = How.XPATH, using="//span[contains(text(),'CPU')]//following-sibling::span[1]//select[contains(@class,'polltime-dropdown')]")
	private WebElement cpupollingtime1;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'CPU')]//following-sibling::span[2]//select[contains(@class,'polltime-dropdown')]")
	private WebElement cpupollingtime2;


	//Disk
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Disk')]//following-sibling::span[1]//select[contains(@class,'polltime-dropdown')]")
	private WebElement diskpollingtime1;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Disk')]//following-sibling::span[2]//select[contains(@class,'polltime-dropdown')]")
	private WebElement diskpollingtime2;

	//Memory
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Memory')]//following-sibling::span[1]//select[contains(@class,'polltime-dropdown')]")
	private WebElement memorypollingtime1;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Memory')]//following-sibling::span[2]//select[contains(@class,'polltime-dropdown')]")
	private WebElement memorypollingtime2;



	//Threshold Configuration
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Type of Threshold')]")
	private WebElement typeOfThreshold;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Static')]")
	private WebElement staticThreshold;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Dynamic')]")
	private WebElement dynamicThreshold;


	//CPU DISK And Memory
	@FindBy(how = How.XPATH, using="//span[contains(text(),'CPU')]")
	private WebElement cpuThreshold;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Disk')]")
	private WebElement diskThreshold;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Memory')]")
	private WebElement MemoryThreshold;

	//CPU Disk And Memory Checkboxes
	@FindBy(how = How.XPATH, using="//span[contains(text(),'CPU')]//parent::div//div[@role='checkbox']")
	private WebElement cpuThresholdCBX;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Disk')]//parent::div//div[@role='checkbox']")
	private WebElement diskThresholdCBX;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Memory')]//parent::div//div[@role='checkbox']")
	private WebElement MemoryThresholdCBX;

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
	public void clickRawdata(){

		SMrawdata.click();
	}
	public void clickanalytics(){

		SManalytics.click();
	}

	public void clickCounterconfig(){

		counterconfig.click();
	}
	public void clickSetpollinginterval(){

		setpollinginterval.click();
	}
	public void clickThresholdconfig(){

		thresholdconfig.click();
	}

	public void selectdevicecheck() {

		List<WebElement> alldevice = new ArrayList<WebElement>();
		alldevice = driver.findElements(By.xpath("//div[contains(@class,'checkbox-vals')]//label"));

		int count =alldevice.size();

		for(int i=1;i<=count;i++) {

			try {
				WebElement devicenames = driver.findElement(By.xpath("(//div[contains(@class,'checkbox-vals')]//label)["+i+"]"));
				if(devicenames.isDisplayed())
				{
					new CommonMethods(driver).highLighterMethod(driver, devicenames);
				}
			}catch(Exception e) {
				continue;
			}}	
	}


	public void selectfirstTwodeviceCheckboxs() throws InterruptedException {

		for(int i=1;i<=2;i++) {			
			try {
				//WebElement devicecbx = driver.findElement(By.xpath("(//div[contains(@class,'checkbox-vals')])["+i+"]"));
				WebElement devicecbx = driver.findElement(By.xpath("(//div[contains(@class,'accordian-list')]//div[@role='checkbox'])["+i+"]"));
				
				if(devicecbx.isDisplayed())
				{
					//new CommonMethods(driver).highLighterMethod(driver, devicecbx);
					devicecbx.click();
				}
			}catch(Exception e) {
				continue;
			}
			Thread.sleep(2000);
		}
	}


	public void clickcounterCPU() {
		counterCPU.click();
	}
	public void clickcounterDisk() {
		counterDisk.click();
	}
	public void clickcounterMemory() {
		counterMemory.click();
	}
	public void clickcounterNetwork() {
		counterNetwork.click();
	}

	public String getcountervalue() {
		String value = countervalue.getText();
		return value;
	}

	public void Counterconfig_CommonFieldValidation() {
		assertTrue(selectdevice.isDisplayed());
		assertTrue(selectcategory.isDisplayed());
		assertTrue(counterconfig.isDisplayed());
		assertTrue(setpollinginterval.isDisplayed());
		assertTrue(thresholdconfig.isDisplayed());
		assertTrue(closeAd.isDisplayed());
	}
	public void Counterconfig_FieldValidation() {
		assertTrue(counterCPU.isDisplayed());
		assertTrue(counterDisk.isDisplayed());
		assertTrue(counterMemory.isDisplayed());
		assertTrue(counterNetwork.isDisplayed());
		assertTrue(listOfCounters.isDisplayed());
		assertTrue(searchbox.isDisplayed());
		assertTrue(Savebtn.isDisplayed());
	}

	public void CounterconfigCPU_FieldValidation() {
		counterCPU.click();
		assertTrue(cpucount.isDisplayed());		
		assertTrue(cputimeidle.isDisplayed());		
		assertTrue(processorprocessortime.isDisplayed());

	}

	public void CounterconfigDisk_FieldValidation() {
		counterDisk.click();
		assertTrue(windowslink.isDisplayed());
		assertTrue(linuxlink.isDisplayed());
		assertTrue(aixlink.isDisplayed());
		assertTrue(mountstext.isDisplayed());
		assertTrue(listOfCounters.isDisplayed());
		//AS now linux is default

		assertTrue(homecounter.isDisplayed());
		assertTrue(bootcounter.isDisplayed());
		assertTrue(devcounter.isDisplayed());
		assertTrue(mount_name.isDisplayed());
		assertTrue(mount_percent_used.isDisplayed());
		assertTrue(mount_total_size.isDisplayed());
		assertTrue(mount_used_space.isDisplayed());
		assertTrue(mount_avail_space.isDisplayed());
		assertTrue(file_system.isDisplayed());
		assertTrue(Savebtn.isDisplayed());
	}

	public void CounterconfigMemory_FieldValidation() {
		counterMemory.click();

		assertTrue(listOfCounters.isDisplayed());

		assertTrue(memory_total.isDisplayed());
		assertTrue(memory_available_mbytes.isDisplayed());
		assertTrue(memory_free_systempagetableentries.isDisplayed());
		assertTrue(total_swap_memory.isDisplayed());
		assertTrue(total_swap_memory_free.isDisplayed());
		assertTrue(total_swap_memory_used.isDisplayed());
		assertTrue(total_swap_memory_percent.isDisplayed());
		assertTrue(memory_commited_bytesinuse.isDisplayed());
		assertTrue(memory_available_absolute.isDisplayed());
		assertTrue(memory_total_absolute.isDisplayed());
		assertTrue(Savebtn.isDisplayed());
	}

	public void VerifyCPUSelectedCounters() {
		counterCPU.click();
		assertTrue(selected.isDisplayed());
		assertTrue(selectedcounters.isDisplayed());
		assertTrue(deletecounters.isDisplayed());
		assertTrue(countervalue.isDisplayed());

	}
	public void VerifyDISKSelectedCounters() {
		counterDisk.click();
		assertTrue(selected.isDisplayed());
		assertTrue(selectedcounters.isDisplayed());
		assertTrue(deletecounters.isDisplayed());
		assertTrue(countervalue.isDisplayed());

	}
	public void VerifyMemorySelectedCounters() {
		counterMemory.click();
		assertTrue(selected.isDisplayed());
		assertTrue(selectedcounters.isDisplayed());
		assertTrue(deletecounters.isDisplayed());
		assertTrue(countervalue.isDisplayed());

	}
	public void VerifydeleteSelectedCounters() {
		counterCPU.click();

		assertTrue(deletecounters.isDisplayed());
		deletecounters.click();
		String getcountervalue = new ZIFAIPrediction_DeviceConfigPage(driver).getcountervalue();
		if(getcountervalue=="0") {
			counterDisk.click();
			deletecounters.click();
			String getcountervalue1 = new ZIFAIPrediction_DeviceConfigPage(driver).getcountervalue();
			if(getcountervalue1=="0") {
				counterMemory.click();
				deletecounters.click();
				String getcountervalue2 = new ZIFAIPrediction_DeviceConfigPage(driver).getcountervalue();
				if(getcountervalue2=="0") {
					counterCPU.click();
				}
			}

		}
	}


	public void Entersearchtext(String searchtext) {
		searchbox.clear();
		searchbox.sendKeys(searchtext);

	}

	public void ClearSearchbox() {
		searchbox.clear();
	}
	public void SaveErrorMessage() {
		Savebtn.click();
		assertTrue(SaveError.isDisplayed());
	}

	public void ClickSave() {
		Savebtn.click();

	}

	public void SaveSuccessMessage() {
		Savebtn.click();
		assertTrue(SaveSuccessMsg.isDisplayed());
	}

	public void CPUPoolingvalidation() {

		String[] exp = {" 0m "," 1m ","Mrs","Miss","Ms","Dr","Prof"};
		WebElement dropdown = driver.findElement(By.xpath("//span[contains(text(),'CPU')]//following-sibling::span//select[contains(@class,'polltime-dropdown')]"));  
		Select select = new Select(dropdown);  

		List<WebElement> options = select.getOptions();  
		for(WebElement we:options)  
		{  
			boolean match = false;
			for (int i=0; i<exp.length; i++){
				if (we.getText().equals(exp[i])){
					match = true;
				}
			}
			Assert.assertTrue(match);
		}  
	}


	public void setpollingIntervalFields() {
		assertTrue(pollingcpu.isDisplayed());
		assertTrue(poolingdisk.isDisplayed());
		assertTrue(pollingMemory.isDisplayed());
		assertTrue(cpupollingtime1.isDisplayed());
		assertTrue(cpupollingtime2.isDisplayed());
		assertTrue(diskpollingtime1.isDisplayed());
		assertTrue(diskpollingtime2.isDisplayed());
		assertTrue(memorypollingtime1.isDisplayed());
		assertTrue(memorypollingtime2.isDisplayed());
		assertTrue(Savebtn.isDisplayed());
	}

	public void selectpollingInterval() {
		Select selectcpuhrs =new Select(cpupollingtime1);
		selectcpuhrs.selectByVisibleText(" 1hr ");
		Select selectcpumin =new Select(cpupollingtime2);
		selectcpumin.selectByVisibleText(" 3m ");

		Select selectDiskhrs =new Select(diskpollingtime1);
		selectDiskhrs.selectByVisibleText(" 3hr ");
		Select selectDiskmin =new Select(diskpollingtime2);
		selectDiskmin.selectByVisibleText(" 15m ");

		Select selectmemoryhrs =new Select(memorypollingtime1);
		selectmemoryhrs.selectByVisibleText(" 5hr ");
		Select selectmemorymin =new Select(memorypollingtime2);
		selectmemorymin.selectByVisibleText(" 50m ");
	}


	public void selectpollingIntervalSetdefault() {
		Select selectcpuhrs =new Select(cpupollingtime1);
		selectcpuhrs.selectByVisibleText(" 0hr ");
		Select selectcpumin =new Select(cpupollingtime2);
		selectcpumin.selectByVisibleText(" 10m ");

		Select selectDiskhrs =new Select(diskpollingtime1);
		selectDiskhrs.selectByVisibleText(" 1hr ");
		Select selectDiskmin =new Select(diskpollingtime2);
		selectDiskmin.selectByVisibleText(" 25m ");

		Select selectmemoryhrs =new Select(memorypollingtime1);
		selectmemoryhrs.selectByVisibleText(" 4hr ");
		Select selectmemorymin =new Select(memorypollingtime2);
		selectmemorymin.selectByVisibleText(" 3m ");

		Savebtn.click();
	}

	public void thresholdconfigFields() {
		assertTrue(typeOfThreshold.isDisplayed());
		assertTrue(staticThreshold.isDisplayed());
		assertTrue(dynamicThreshold.isDisplayed());
		assertTrue(cpuThreshold.isDisplayed());
		assertTrue(diskThreshold.isDisplayed());
		assertTrue(MemoryThreshold.isDisplayed());
		assertTrue(cpuThresholdCBX.isDisplayed());
		assertTrue(diskThresholdCBX.isDisplayed());
		assertTrue(MemoryThresholdCBX.isDisplayed());
		assertTrue(Savebtn.isDisplayed());
	}

	public void uncheckThresholdcheckboxes() {
		List<WebElement> checkboxes = new ArrayList<WebElement>();
		checkboxes=driver.findElements(By.xpath("//div[@role='checkbox']"));

		int count =checkboxes.size();


		for(int i =1;i<=count;i++) {

			try {
				WebElement selected = driver.findElement(By.xpath("(//div[@role='checkbox'])["+i+"]"));
				String checked = selected.getAttribute("aria-checked");
				if(checked.contains("false")) {
					selected.getAttribute("aria-checked");
				}else
				{
					selected.click();
				}

			}catch(Exception e) {
				continue;
			}

		}
	}
	public void ThresholdcheckboxesClick() {
		cpuThresholdCBX.click();
		diskThresholdCBX.click();
		MemoryThresholdCBX.click();
	}


}
