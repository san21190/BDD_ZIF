package com.zifautomation.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ZIFAI_ToolSeverityMappingPage {

	WebDriver driver;
	
	
	public ZIFAI_ToolSeverityMappingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//span[contains(@class,'settings_ic')]")
	private WebElement settingsIcon;
	
	@FindBy(how = How.XPATH, using="//span[contains(text(), 'PLATFORM MANAGEMENT')]")
	private WebElement PLATFORMMANAGEMENT;
	
	@FindBy(how = How.XPATH, using="//div[contains(text(), 'Severity Mapping')]")
	private WebElement SeverityMapping;

	@FindBy(how = How.XPATH, using="//label[contains(text(), 'Select Tool Name')]")
	private WebElement SelectToolName;

	@FindBy(how = How.XPATH, using="(//span[contains(@class, 'pi-chevron-down')])[1]")
	private WebElement ToolNamelist;
	
	
	
	@FindBy(how = How.XPATH, using="(//*[contains(@class,'dropdown-items')]//span)[1]")
	private WebElement ToolNamevalue1;
	
	@FindBy(how = How.XPATH, using="(//*[contains(@class,'dropdown-items')]//span)[2]")
	private WebElement ToolNamevalue2;

	@FindBy(how = How.XPATH, using="(//*[contains(@class,'dropdown-items')]//span)[3]")
	private WebElement ToolNamevalue3;
	
	@FindBy(how = How.XPATH, using="(//*[contains(@class,'dropdown-items')]//span)[4]")
	private WebElement ToolNamevalue4;

	@FindBy(how = How.XPATH, using="(//*[contains(@class,'dropdown-items')]//span)[5]")
	private WebElement ToolNamevalue5;

	@FindBy(how = How.XPATH, using="(//*[contains(@class,'dropdown-items')]//span)[6]")
	private WebElement ToolNamevalue6;

	@FindBy(how = How.XPATH, using="(//*[contains(@class,'dropdown-items')]//span)[7]")
	private WebElement ToolNamevalue7;

	@FindBy(how = How.XPATH, using="(//*[contains(@class,'dropdown-items')]//span)[8]")
	private WebElement ToolNamevalue8;
	
	@FindBy(how = How.XPATH, using="(//span[contains(@class,'gavel')])[1]")
	private WebElement ToolSeverity1;
	
	@FindBy(how = How.XPATH, using="//*[contains(text(),' CRITICAL')]")
	private WebElement ToolSeverityCRITICAL;

	@FindBy(how = How.XPATH, using="//*[contains(text(),' MEDIUM')]")
	private WebElement ToolSeverityMEDIUM;

	@FindBy(how = How.XPATH, using="//*[contains(text(),' HIGH')]")
	private WebElement ToolSeverityHIGH;

	@FindBy(how = How.XPATH, using="//*[contains(text(),' LOW')]")
	private WebElement ToolSeverityLOW;

	@FindBy(how = How.XPATH, using="//label[contains(text(), 'Critical')]")
	private WebElement ZIFSeverityCritical;

	@FindBy(how = How.XPATH, using="//label[contains(text(), 'High')]")
	private WebElement ZIFSeverityHigh;
	
	@FindBy(how = How.XPATH, using="//label[contains(text(), 'Medium')]")
	private WebElement ZIFSeverityMedium;

	@FindBy(how = How.XPATH, using="//label[contains(text(), 'Low')]")
	private WebElement ZIFSeverityLow;

	@FindBy(how = How.XPATH, using="//label[contains(text(), 'Warning')]")
	private WebElement ZIFSeverityWarning;

	@FindBy(how = How.XPATH, using="//label[contains(text(), 'Information')]")
	private WebElement ZIFSeverityInformation;

	@FindBy(how = How.XPATH, using="//label[contains(text(), 'Reverse')]")
	private WebElement ZIFSeverityReverse;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Save')]")
	private WebElement Savebutton;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Cancel')]")
	private WebElement Cancelbutton;



	public void clickSetingsIcon() {				
		try {
			settingsIcon.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}

	
	public void clickplarformmanagemnet() {				
		try {
			PLATFORMMANAGEMENT.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}

	
	public void CheckSeverityMapping() {		
		assertTrue(SeverityMapping.isDisplayed());	
		}

	
	public void clickSeverityMapping() {				
		try {
			SeverityMapping.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	
	
	public void CheckToolname() {		
		assertTrue(SelectToolName.isDisplayed());	
		}

	
	public void clickToolname() {				
		try {
			SelectToolName.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	
	
	public void CheckToolNamelist() {		
		assertTrue(ToolNamelist.isDisplayed());	
		}

	
	public void clickToolNamelist() {				
		try {
			ToolNamelist.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}

	public void CheckToolNamevalue1() {		
		assertTrue(ToolNamevalue1.isDisplayed());	
		}

	
	public void clickToolNamevalue1() {				
		try {
			//ToolNamevalue1.click();
			
		    WebElement Tool1 = driver.findElement(By.xpath("(//*[contains(@class,'dropdown-items')]//span)[1]"));
		    Tool1.isDisplayed();
		        JavascriptExecutor executor = (JavascriptExecutor)driver;
		        executor.executeScript("arguments[0].click();", Tool1);
		        
			
			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}
	
	public void clickToolNamevalue2() {				
		try {
			ToolNamevalue2.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		}


	public void CheckToolSeverity1() {		
		assertTrue(ToolSeverity1.isDisplayed());	
		}

	
	public void CheckToolSeverityCRITICAL() {		
		assertTrue(ToolSeverityCRITICAL.isDisplayed());	
		}

	public void CheckToolSeverityMEDIUM() {		
		assertTrue(ToolSeverityMEDIUM.isDisplayed());	
		}
	
	public void CheckToolSeverityLOW() {		
		assertTrue(ToolSeverityLOW.isDisplayed());
		}
	
	
	public void CheckToolSeverityHIGH() {		
		assertTrue(ToolSeverityHIGH.isDisplayed());
		}

	public void CheckZIFSeverityCritical() {		
		assertTrue(ZIFSeverityCritical.isDisplayed());
		}

	public void CheckZIFSeverityHigh() {		
		assertTrue(ZIFSeverityHigh.isDisplayed());
		}

	public void CheckZIFSeverityMedium() {		
		assertTrue(ZIFSeverityMedium.isDisplayed());
		}
	
		public void CheckZIFSeverityLow() {		
		assertTrue(ZIFSeverityLow.isDisplayed());
		}

		public void CheckZIFSeverityWarning() {		
			assertTrue(ZIFSeverityWarning.isDisplayed());
			}
		
		public void CheckZIFSeverityInformation() {		
			assertTrue(ZIFSeverityInformation.isDisplayed());
			}
		
		public void CheckZIFSeverityReverse() {		
			assertTrue(ZIFSeverityReverse.isDisplayed());
			}
		
		
}
