package com.zifautomation.Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zifautomation.Listeners.ExtentReportListener;

public class ZIFCatalogHomePage extends ExtentReportListener{

	WebDriver driver;



	public ZIFCatalogHomePage(WebDriver driver)

	{

		this.driver=driver;

		PageFactory.initElements(driver, this);

	}



	@FindBy(how = How.XPATH, using="//span[text()='ZIF Catalog -']")

	private WebElement zIFCatalogPremier;





	@FindBy(how = How.XPATH, using="//span[text()='Business Outcomes']")

	private WebElement businessOutcomes;





	@FindBy(how = How.XPATH, using="//span[text()='Technical Outcomes']")

	private WebElement technicalOutcomes;





	@FindBy(how = How.LINK_TEXT, using="Need help in choosing the right business outcome?")

	private WebElement needHelpIn;

	@FindBy(how = How.XPATH, using="//h4[text()='Need help in choosing the right business outcome?']")

	private WebElement needHelppanelheader;



	@FindBy(how = How.XPATH, using="//h5[text()='CAPEX Optimization']")

	private WebElement cAPEXOptimization;

	@FindBy(how = How.XPATH, using="//h5[text()='CAPEX Optimization']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement cAPEXOptimizationcbx;



	@FindBy(how = How.XPATH, using="//h5[text()='OPEX Optimization']")

	private WebElement oPEXOptimization;

	@FindBy(how = How.XPATH, using="//h5[text()='OPEX Optimization']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement oPEXOptimizationcbx;





	@FindBy(how = How.XPATH, using="//h5[text()='Blueprinting Enterprise']")

	private WebElement blueprintingEnterprise;

	@FindBy(how = How.XPATH, using="//h5[text()='Blueprinting Enterprise']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement blueprintingEnterprisecbx;





	@FindBy(how = How.XPATH, using="//h5[text()='Compute Utilization & Optimization']")

	private WebElement computeUtilization;

	@FindBy(how = How.XPATH, using="//h5[text()='Compute Utilization & Optimization']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement computeUtilizationcbx;



	@FindBy(how = How.XPATH, using="//h5[text()='Control Cloud Sprawl']")

	private WebElement controlCloudSprawl;

	@FindBy(how = How.XPATH, using="//h5[text()='Control Cloud Sprawl']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement controlCloudSprawlcbx;





	@FindBy(how = How.XPATH, using="//h5[text()='Improvement in Business Service Assurance']")

	private WebElement improvementInBusiness;

	@FindBy(how = How.XPATH, using="//h5[text()='Improvement in Business Service Assurance']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement improvementInBusinesscbx;



	@FindBy(how = How.XPATH, using="//h5[text()='Shift Left']")

	private WebElement shiftLeft;

	@FindBy(how = How.XPATH, using="//h5[text()='Shift Left']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement shiftLeftcbx;



	@FindBy(how = How.XPATH, using="//h5[text()='Eliminating Digital Dirt']")

	private WebElement eliminatingDigitalDirt;

	@FindBy(how = How.XPATH, using="//h5[text()='Eliminating Digital Dirt']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement eliminatingDigitalDirtcbx;



	@FindBy(how = How.XPATH, using="//h5[text()='Improvement in Application Availability']")

	private WebElement improvementInApplication;

	@FindBy(how = How.XPATH, using="//h5[text()='Improvement in Application Availability']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement improvementInApplicationcbx;



	@FindBy(how = How.XPATH, using="//h5[text()='Improvement in User Experience']")

	private WebElement improvementInUser;

	@FindBy(how = How.XPATH, using="//h5[text()='Improvement in User Experience']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement improvementInUsercbx;



	@FindBy(how = How.XPATH, using="//h4[text()='Correlation']")

	private WebElement correlation;

	@FindBy(how = How.XPATH, using="//h4[text()='Correlation']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement correlationcbx;



	@FindBy(how = How.XPATH, using="//h4[text()='Intelligent Automation']")

	private WebElement intelligentAutomation;
	@FindBy(how = How.XPATH, using="//h4[text()='Intelligent Automation']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement intelligentAutomationcbx;




	@FindBy(how = How.XPATH, using="//h4[text()='Auto Discovery']")

	private WebElement autoDiscovery;
	@FindBy(how = How.XPATH, using="//h4[text()='Auto Discovery']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement autoDiscoverycbx;



	@FindBy(how = How.XPATH, using="//h4[text()='Prediction']")

	private WebElement prediction;
	@FindBy(how = How.XPATH, using="//h4[text()='Prediction']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement predictioncbx;




	@FindBy(how = How.XPATH, using="//h4[text()='Root Cause Identification']")

	private WebElement rootCauseIdentification;
	@FindBy(how = How.XPATH, using="//h4[text()='Root Cause Identification']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement rootCauseIdentificationcbx;





	@FindBy(how = How.XPATH, using="//h4[text()='Intelligent Triaging']")

	private WebElement intelligentTriaging;
	@FindBy(how = How.XPATH, using="//h4[text()='Intelligent Triaging']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement intelligentTriagingcbx;






	@FindBy(how = How.XPATH, using="//h4[text()='Dependency Mapping']")

	private WebElement dependencyMapping;
	@FindBy(how = How.XPATH, using="//h4[text()='Dependency Mapping']//parent::div//preceding-sibling::div//p-checkbox//div//div[2]")

	private WebElement dependencyMappingcbx;


	@FindBy(how = How.XPATH, using="//span[text()='Proceed']")

	private WebElement proceed;

	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Reduce the number of Priority 1 & Priority 2 incidents reported by end user’s?')]//parent::div//following-sibling::div//button")

	private WebElement reducenumberofpriority;
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Predict potential failures/degradation of devices/applications?')]//parent::div//following-sibling::div//button")

	private WebElement predictpotential;
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Reduce the number of monitoring tools in the enterprise?')]//parent::div//following-sibling::div//button")

	private WebElement reducemonitoringtool;


	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Eliminate silo monitoring, and bring in unified monitoring?')]//parent::div//following-sibling::div//button")

	private WebElement eliminatesilomonitoring;
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Discover all the devices in the enterprise?')]//parent::div//following-sibling::div//button")

	private WebElement discoveralldevice;
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Automate IT processes?')]//parent::div//following-sibling::div//button")

	private WebElement automateITprocess;


	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Reduce operations cost for NOC or Command Center?')]//parent::div//following-sibling::div//button")

	private WebElement reduceoperationcost;
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Want to monitor your business services?')]//parent::div//following-sibling::div//button")

	private WebElement wanttomonitor;
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Want to optimise the compute (CPU, Memory & Disk) utilisation across your data centres?')]//parent::div//following-sibling::div//button")

	private WebElement wanttooptimise;


	@FindBy(how = How.XPATH, using="//span[text()='Cancel']")

	private WebElement needhelpCancel;
	@FindBy(how = How.XPATH, using="//span[text()='Save']")

	private WebElement needhelpSave;


	public void UnselectAllBusinessoutcomes() {

		List<WebElement> checkboxes = new ArrayList<WebElement>();
		checkboxes=driver.findElements(By.xpath("//div[@role='checkbox']"));

		int count =checkboxes.size();
		//System.out.println(count);

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

	public void CAPEX_Optimizationtechnicaloutcomes() throws InterruptedException {
		try {

			Thread.sleep(2000);

			String selection1 = correlationcbx.getAttribute("aria-checked");
			String selection2 = rootCauseIdentificationcbx.getAttribute("aria-checked");
			assertEquals(selection1,"CORRELATION");
			assertEquals(selection2,"ROOT_CAUSE");
		}
		catch (Exception e) {

		}
	}

	public void CAPEX_OptimizationtechnicaloutcomesUnselect() throws InterruptedException {
		try {

			Thread.sleep(2000);

			String selection1 = correlationcbx.getAttribute("aria-checked");
			String selection2 = rootCauseIdentificationcbx.getAttribute("aria-checked");

			assertEquals(selection1,"false");
			assertEquals(selection2,"false");
		}
		catch (Exception e) {

		}
	}

	public void OPEX_Optimizationtechnicaloutcomes() {
		try {

			Thread.sleep(2000);
			String selection1 = correlationcbx.getAttribute("aria-checked");
			String selection2 = rootCauseIdentificationcbx.getAttribute("aria-checked");
			String selection3 = predictioncbx.getAttribute("aria-checked");
			String selection4 = intelligentAutomationcbx.getAttribute("aria-checked");

			assertEquals(selection1,"CORRELATION");
			assertEquals(selection2,"ROOT_CAUSE");
			assertEquals(selection3,"PREDICTION");
			assertEquals(selection4,"INTELLIGENT_AUTOMATION");

		}
		catch (Exception e) {

		}
	}

	public void OPEX_OptimizationtechnicaloutcomesUnselect() {
		try {

			Thread.sleep(2000);
			String selection1 = correlationcbx.getAttribute("aria-checked");
			String selection2 = rootCauseIdentificationcbx.getAttribute("aria-checked");
			String selection3 = predictioncbx.getAttribute("aria-checked");
			String selection4 = intelligentAutomationcbx.getAttribute("aria-checked");
			assertEquals(selection1,"false");
			assertEquals(selection2,"false");
			assertEquals(selection3,"false");
			assertEquals(selection4,"false");

		}
		catch (Exception e) {

		}
	}



	public void Blueprinting_Enterprisetechnicaloutcomes() {
		try {
			;
			Thread.sleep(2000);
			String selection1 = autoDiscoverycbx.getAttribute("aria-checked");
			assertEquals(selection1,"AUTO_DISCOVERY");


		}
		catch (Exception e) {

		}
	}

	public void Blueprinting_EnterprisetechnicaloutcomesUnselect() {
		try {

			Thread.sleep(2000);
			String selection1 = autoDiscoverycbx.getAttribute("aria-checked");
			assertEquals(selection1,"false");

		}
		catch (Exception e) {

		}
	}


	public void Optimization_of_Computetechnicaloutcomes() {
		try {

			Thread.sleep(2000);
			String selection1 = predictioncbx.getAttribute("aria-checked");
			assertEquals(selection1,"PREDICTION");

		}
		catch (Exception e) {

		}
	}

	public void Optimization_of_ComputetechnicaloutcomesUnselect() {
		try {

			Thread.sleep(2000);
			String selection1 = predictioncbx.getAttribute("aria-checked");
			assertEquals(selection1,"false");

		}
		catch (Exception e) {

		}
	}


	public void Eliminating_Digital_Dirttechnicaloutcomes() {
		try {

			Thread.sleep(2000);
			String selection1 = dependencyMappingcbx.getAttribute("aria-checked");
			assertEquals(selection1,"DEPENDENCY_MAPPING");

		}
		catch (Exception e) {

		}
	}

	public void Eliminating_Digital_DirttechnicaloutcomesUnselect() {
		try {

			Thread.sleep(2000);
			String selection1 = dependencyMappingcbx.getAttribute("aria-checked");
			assertEquals(selection1,"false");

		}
		catch (Exception e) {

		}
	}


	public void Improvement_in_User_Experiencetechnicaloutcomes() {
		try {

			Thread.sleep(2000);
			String selection1 = correlationcbx.getAttribute("aria-checked");
			String selection2 = rootCauseIdentificationcbx.getAttribute("aria-checked");
			String selection3 = predictioncbx.getAttribute("aria-checked");

			assertEquals(selection1,"CORRELATION");
			assertEquals(selection2,"ROOT_CAUSE");
			assertEquals(selection3,"PREDICTION");

		}
		catch (Exception e) {

		}
	}

	public void Improvement_in_User_ExperiencetechnicaloutcomesUnselect() {
		try {

			Thread.sleep(2000);
			String selection1 = correlationcbx.getAttribute("aria-checked");
			String selection2 = rootCauseIdentificationcbx.getAttribute("aria-checked");
			String selection3 = predictioncbx.getAttribute("aria-checked");

			assertEquals(selection1,"false");
			assertEquals(selection2,"false");
			assertEquals(selection3,"false");


		}
		catch (Exception e) {

		}
	}


	public void Improvement_in_Application_Availabilitytechnicaloutcomes() {
		try {

			Thread.sleep(2000);
			String selection1 = correlationcbx.getAttribute("aria-checked");
			String selection2 = rootCauseIdentificationcbx.getAttribute("aria-checked");


			assertEquals(selection1,"CORRELATION");
			assertEquals(selection2,"ROOT_CAUSE");


		}
		catch (Exception e) {

		}
	}

	public void Improvement_in_Application_AvailabilitytechnicaloutcomesUnselect() {
		try {

			Thread.sleep(2000);
			String selection1 = correlationcbx.getAttribute("aria-checked");
			String selection2 = rootCauseIdentificationcbx.getAttribute("aria-checked");


			assertEquals(selection1,"false");
			assertEquals(selection2,"false");


		}
		catch (Exception e) {

		}
	}


	public void Shift_Lefttechnicaloutcomes() {
		try {

			Thread.sleep(2000);
			String selection1 = intelligentAutomationcbx.getAttribute("aria-checked");
			String selection2 = intelligentTriagingcbx.getAttribute("aria-checked");


			assertEquals(selection1,"INTELLIGENT_AUTOMATION");
			assertEquals(selection2,"INTELLIGENT_TRIAGING");


		}
		catch (Exception e) {

		}
	}

	public void Shift_LefttechnicaloutcomesUnselect() {
		try {

			Thread.sleep(2000);
			String selection1 = intelligentAutomationcbx.getAttribute("aria-checked");
			String selection2 = intelligentTriagingcbx.getAttribute("aria-checked");


			assertEquals(selection1,"false");
			assertEquals(selection2,"false");


		}
		catch (Exception e) {

		}
	}
	public void VerifyallfieldsInZIFcatalogHomePage(){

		assertTrue(businessOutcomes.isDisplayed());
		assertTrue(technicalOutcomes.isDisplayed());
		assertTrue(needHelpIn.isDisplayed());
		assertTrue(cAPEXOptimization.isDisplayed());
		assertTrue(oPEXOptimization.isDisplayed());
		assertTrue(blueprintingEnterprise.isDisplayed());
		assertTrue(computeUtilization.isDisplayed());
		assertTrue(controlCloudSprawl.isDisplayed());
		assertTrue(improvementInBusiness.isDisplayed());
		assertTrue(shiftLeft.isDisplayed());
		assertTrue(eliminatingDigitalDirt.isDisplayed());
		assertTrue(improvementInApplication.isDisplayed());
		assertTrue(improvementInUser.isDisplayed());


		assertTrue(correlation.isDisplayed());
		assertTrue(intelligentAutomation.isDisplayed());
		assertTrue(autoDiscovery.isDisplayed());
		assertTrue(prediction.isDisplayed());
		assertTrue(rootCauseIdentification.isDisplayed());
		assertTrue(intelligentTriaging.isDisplayed());
		assertTrue(dependencyMapping.isDisplayed());
		assertTrue(proceed.isDisplayed());

	}


	public void Click_on_need_help_link() throws InterruptedException
	{
		needHelpIn.click();
		Thread.sleep(2000);
		assertTrue(needHelppanelheader.isDisplayed());
	}

	public void cAPEXOptimizationcbxClick()
	{
		cAPEXOptimizationcbx.click();
	}
	public void oPEXOptimizationcbxClick()
	{
		oPEXOptimizationcbx.click();
	}
	public void blueprintingEnterprisecbxClick()
	{
		blueprintingEnterprisecbx.click();
	}
	public void computeUtilizationcbxClick()
	{
		computeUtilizationcbx.click();
	}
	public void controlCloudSprawlcbxClick()
	{
		controlCloudSprawlcbx.click();
	}
	public void improvementInBusinesscbxClick()
	{
		improvementInBusinesscbx.click();
	}
	public void shiftLeftcbxClick()
	{
		shiftLeftcbx.click();
	}
	public void eliminatingDigitalDirtcbxClick()
	{
		eliminatingDigitalDirtcbx.click();
	}
	public void improvementInApplicationcbxClick()
	{
		improvementInApplicationcbx.click();
	}
	public void improvementInUsercbxClick()
	{
		improvementInUsercbx.click();
	}





	public void SelectalloptionsinNeedhelp()
	{
		reducenumberofpriority.click();
		predictpotential.click();
		reducemonitoringtool.click();
		eliminatesilomonitoring.click();
		discoveralldevice.click();
		automateITprocess.click();
		reduceoperationcost.click();
		wanttomonitor.click();
		wanttooptimise.click();
		improvementInUsercbx.click();
	}
	public void needhelpSave()
	{
		needhelpSave.click();
	}

	public void needhelpCancel()
	{
		needhelpCancel.click();
	}
	public void proceedbutton()
	{
		try{
			assertTrue(proceed.isEnabled());
			proceed.click();
		}catch (Exception e) {

		}
	}

}
