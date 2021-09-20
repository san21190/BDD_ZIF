package com.zifautomation.Pages;

import com.aventstack.extentreports.ExtentTest;

import junit.framework.Assert;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.zifautomation.Listeners.ExtentReportListener.captureScreenShot;
import static org.testng.Assert.assertTrue;

public class ZIFQuestionnairePage
{
	WebDriver driver;

	public ZIFQuestionnairePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//span[contains(text(),'ZIF Questionnaire')]")
	private WebElement ZIF_QuestionnaireHeader;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'(Before we build your package we need some additional information)')]")
	private WebElement ZIF_QuestionnaireNote;

	@FindBy(how = How.XPATH, using="(//input[@placeholder='Required'])[1]")
	private WebElement numberofDevices;
	@FindBy(how = How.XPATH, using="(//input[@placeholder='Required'])[2]")
	private WebElement numberofApplications;
	@FindBy(how = How.XPATH, using="(//input[@placeholder='Required'])[3]")
	private WebElement numberofmonitoringTools;
	@FindBy(how = How.XPATH, using="(//input[@placeholder='Required'])[4]")
	private WebElement numberofAlerts;



	@FindBy(how = How.XPATH, using="//span[text()='(includes physical/virtual servers & network devices)']")
	private WebElement numberofDevicesNote;
	@FindBy(how = How.XPATH, using="//span[text()='(includes other devices like printers, scanners etc.,)']")
	private WebElement numberofApplicationsNote;
	@FindBy(how = How.XPATH, using="//span[text()='(includes monitoring tools, that are used to monitor different layers of IT infrastructure) ']")
	private WebElement numberofmonitoringToolsNote;
	@FindBy(how = How.XPATH, using="//span[text()='(total number of alerts generated across all severity per month)']")
	private WebElement numberofAlertsNote;


	@FindBy(how = How.XPATH, using="//div[contains(text(),'No of Devices')]")
	private WebElement numberofDevicestext;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'No of Applications')]")
	private WebElement numberofApplicationstext;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'No of Monitoring Tools')]")
	private WebElement numberofmonitoringToolstext;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'No of Alerts per month')]")
	private WebElement numberofAlertstext;

	@FindBy(how = How.XPATH, using="//button[@role='switch']")
	private WebElement deploymentinBTN;

	@FindBy(how = How.XPATH, using="//span[text()='Build Package']")
	private WebElement buildpackageBtn;



	@FindBy(how = How.XPATH, using="//div[@class='img-download-counter']")
	private WebElement builddownloadedimg;



	public void enterOnRequired(String Ndevices,String NApps,String Ntools,String Nalerts) throws IOException {
		numberofDevices.clear();
		numberofDevices.sendKeys(Ndevices);

		numberofApplications.clear();
		numberofApplications.sendKeys(NApps);

		numberofmonitoringTools.clear();
		numberofmonitoringTools.sendKeys(Ntools);

		numberofAlerts.clear();
		numberofAlerts.sendKeys(Nalerts);

	}

	public void verify_all_fields() 
	{
		ZIF_QuestionnaireHeader.isDisplayed();
		ZIF_QuestionnaireNote.isDisplayed();
		numberofDevicestext.isDisplayed();
		numberofApplicationstext.isDisplayed();
		numberofmonitoringToolstext.isDisplayed();
		numberofAlertstext.isDisplayed();
		numberofDevicesNote.isDisplayed();
		numberofApplicationsNote.isDisplayed();
		numberofmonitoringToolsNote.isDisplayed();
		numberofmonitoringToolsNote.isDisplayed();
	}

	public void selectdeployment(String deploymentType) {
		String attribute = deploymentinBTN.getAttribute("aria-checked");
		if(deploymentType.contains("Onprem") && attribute.contains("true"))
		{
			deploymentinBTN.getAttribute("aria-checked");
		}else if (deploymentType.contains("SaaS") && attribute.contains("true")) {
			deploymentinBTN.click();
		}else if (deploymentType.contains("Onprem") && attribute.contains("false")) {
			deploymentinBTN.click();
		}else {
			deploymentinBTN.getAttribute("aria-checked");
		}
	}

	public void click_on_BuildPackage() {
		buildpackageBtn.isDisplayed();
		buildpackageBtn.click();
	}

	public void downloadedImg() {
		assertTrue(builddownloadedimg.isDisplayed());
	}


}


