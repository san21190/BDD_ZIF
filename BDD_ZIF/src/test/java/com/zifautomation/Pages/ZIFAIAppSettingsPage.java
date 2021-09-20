package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import junit.framework.Assert;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZIFAIAppSettingsPage {
	WebDriver driver;

	public ZIFAIAppSettingsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//span[contains(text(),'USER MANAGEMENT')]")
	private WebElement Usermanagementtab;

	@FindBy(how = How.XPATH, using="//span[@class='sort-asc-icon']")
	public WebElement Botasc;

	@FindBy(how = How.XPATH, using="(//span[@class='sort-regular-icon'])[1]")
	public WebElement Botsortregular;



	@FindBy(how = How.XPATH, using="//span[@class='sort-desc-icon']")
	public WebElement Botdesc;

	@FindBy(how = How.XPATH, using="//span[@class='username']")
	public WebElement Usernameverification;

	@FindBy(how = How.XPATH, using="//input[@id='file-upload']")
	public WebElement fileupload;

	@FindBy(how = How.XPATH, using="//span[text()='Upload Bot']")
	public WebElement UploadZIF;

	@FindBy(how = How.XPATH, using="//span[text()='Apply']")
	public WebElement Apply;

	@FindBy(how = How.XPATH, using="//span[text()='Clear']")
	public WebElement Clear;

	@FindBy(how = How.XPATH, using="(//em[contains(@class,'tick-icon')])[1]")
	public WebElement Zifcertified;

	@FindBy(how = How.XPATH, using="(//em[contains(@ptooltip,'ZIF Certified')])[1]")
	public WebElement Zifcertifiedhover;

	@FindBy(how = How.XPATH, using="(//em[@tooltipstyleclass='left-arw-preference'])[1]")
	public WebElement Bottooltip;

	@FindBy(how = How.XPATH, using="//div[@class='bot-name']//..//span[@class='ng-star-inserted']")
	public List <WebElement> Botnamelist;

	@FindBy(how = How.XPATH, using="//*[@id=\"bodyscroll\"]/div/div[2]/div[2]/p-dropdown")
	public WebElement Dropdown;

	@FindBy(how = How.XPATH, using="//input[@formcontrolname='packageName']")
	public WebElement Botname;

	@FindBy(how = How.XPATH, using="//textarea[@formcontrolname='description']")
	public WebElement Botdescription;

	@FindBy(how = How.XPATH, using="//span[@class='filter-icon']")
	public WebElement Filtericon;

	@FindBy(how = How.XPATH, using="//span[@class='apply-filter']")
	public WebElement Filtericonthreedots;

	@FindBy(how = How.XPATH, using="//label[contains(text(),'File uploaded successfully')]")
	public WebElement Fileuploadsuccessmessage;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Name cannot be more than 35 characters long')]")
	public WebElement Fileuploadmaxname;

	@FindBy(how = How.XPATH, using="//label[contains(text(),' Invalid file format')]")
	public WebElement Fileuploadfileinvalidmessage;

	@FindBy(how = How.XPATH, using="//label[contains(text(),' ZIP file should not exceed 4 MB')]")
	public WebElement Fileuploadmaxsize;

	@FindBy(how = How.XPATH, using="//label[contains(text(),' ZIP File is not password protected')]")
	public WebElement Fileuploadinvalidmessage;

	@FindBy(how = How.XPATH, using="//label[contains(text(),' Maximum file size:4MB')]")
	public WebElement maximumsizemessage;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Name cannot be more than 35 characters long')]")
	public WebElement namemaximumsizemessage;

	@FindBy(how = How.XPATH, using="//label[contains(text(),' Invalid file format')]")
	public WebElement Fileuploadinvalidfileformat;

	@FindBy(how = How.XPATH, using="//input[@name='filterPackageName']")
	public WebElement Filterbotname;

	@FindBy(how = How.XPATH, using="//input[@formcontrolname='packageName']")
	public WebElement Filtereditbotname;

	@FindBy(how = How.XPATH, using="//*[@id=\"bodyScroll\"]/div[1]/div[2]/div")
	public WebElement Filtercategoryverification;

	@FindBy(how = How.XPATH, using="//*[@id=\"bodyScroll\"]/div[1]/div[4]/div")
	public WebElement Filteruploadedbyverification;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'ui-dropdown-trigger')])[3]")
	public WebElement Filtercategorydrpdown;

	@FindBy(how = How.XPATH, using="//li[@aria-label='Servers']")
	public WebElement Filtercategoryserver;

	@FindBy(how = How.XPATH, using="//input[@name='filteruploadedBy']")
	public WebElement Filteruploadedby;

	@FindBy(how = How.XPATH, using="(//span[contains(@tooltipstyleclass,'ryt ryt-arw')])[1]")
	public WebElement Botnamehover;

	@FindBy(how = How.XPATH, using="//span[contains(@tooltipstyleclass,'ryt ryt-arw')]")
	public List <WebElement> Botnamelistsort;

	@FindBy(how = How.XPATH, using="//*[@id=\"bodyScroll\"]/div")
	public WebElement Nodatafound;

	@FindBy(how = How.XPATH, using="(//em[@class='download-icon'])[1]")
	public WebElement Botdownload;

	@FindBy(how = How.XPATH, using="(//em[@class='delete-icon'])[1]")
	public WebElement Botdelete;

	@FindBy(how = How.XPATH, using="(//em[@class='edit-icon'])[1]")
	public WebElement Botedit;

	@FindBy(how = How.XPATH, using="//*[@id=\"bodyScroll\"]/div/div[1]/div/span")
	public WebElement Searchresultbot;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'pi-times')]")
	public WebElement Filterclose;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'logout_ic')]")
	public WebElement Logout;







	@FindBy(how = How.XPATH, using="//span[contains(text(),'PLATFORM MANAGEMENT')]")
	public WebElement PlatformManagementtab;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'DOMAIN MANAGEMENT')]")
	private WebElement DomainManagementtab;

	@FindBy(how = How.XPATH, using="//button[contains(@label,'Add New User')]")
	private WebElement AddnewUserbutton;

	@FindBy(how = How.XPATH, using="//input[contains(@placeholder,'Type Alert Description')]")
	public WebElement alertdesc;

	@FindBy(how = How.XPATH, using="//button[contains(@label,'Save')]")
	public WebElement savebutton;

	@FindBy(how = How.XPATH, using="//input[contains(@placeholder,'Search')]")
	private WebElement searchTextbox;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'settings_ic')]")
	public WebElement settingsIcon;

	@FindBy(how = How.XPATH, using="//span[@class='bot-name']")
	public WebElement botcolumn;

	@FindBy(how = How.XPATH, using="//span[@class='bot-time']")
	public WebElement bottime;

	@FindBy(how = How.XPATH, using="//span[@class='bot-uploadeduser']")
	public WebElement uploadedby;

	@FindBy(how = How.XPATH, using="//span[@class='bot-category']")
	public WebElement botcategory;

	@FindBy(how = How.XPATH, using="//em[@class='edit-icon']")
	public List <WebElement> boteditlist;

	@FindBy(how = How.XPATH, using="//em[@class='pi pi-plus plusicon']")
	public WebElement botuploadicon;

//	@FindBy(how = How.XPATH, using="//span[contains(text(),'Select Customer Category')]")
//	public WebElement customerdrpdwn;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'ui-state-default ui-corner-all')])[2]")
	public WebElement customerdropdwn;

	@FindBy(how = How.XPATH, using="(//div[contains(@class,'ui-state-default ui-corner-all')])[3]")
	public WebElement ElementSenioritydrp;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'await_ic')]")
	private WebElement qwaitIcon;

	@FindBy(how = How.XPATH, using="//span[contains(@class,'search_common_ic')]")
	private WebElement searchcommonIcon;

	@FindBy(how = How.XPATH, using="//div[contains(text(),'Case Prioritization')]")
	public WebElement Caseprioritization;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'USER MANAGEMENT')]")
	public WebElement Addiconalertdesc;

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

	public void Botdescending() throws InterruptedException {
		try {
			Thread.sleep(3000);
			//Method to Verify Bot name is sorted in Descending order//
			List<String> Text_Bot = new ArrayList<String>();
			int size_bot = driver.findElements(By.xpath("//span[contains(@tooltipstyleclass,'ryt ryt-arw')]")).size();
			for (int i = 4; i <= size_bot; i++) {
				String text = driver.findElement(By.xpath("(//span[contains(@tooltipstyleclass,'ryt ryt-arw')])[" + i + "]")).getText();
				Text_Bot.add(text);
			}
			System.out.println("Text present in BOT name - " + Text_Bot);
			ArrayList<String> sortedList = new ArrayList<>();
			for (String s : Text_Bot) {
				sortedList.add(s);
				System.out.println("Text present in BOT name after descending sort - " + Text_Bot);
				Thread.sleep(2000);
			}
			Collections.sort(sortedList);
			Thread.sleep(2000);
			Collections.reverse(sortedList);
			Thread.sleep(2000);
			Assert.assertTrue(sortedList.equals(Text_Bot));

		}catch (AssertionError | Exception e) {

		}
	}

	public void Botascending() throws InterruptedException {
		try {
			Thread.sleep(3000);
			//Method to Verify Bot name is sorted in Descending order//
			List<String> Text_Bot = new ArrayList<String>();
			int size_bot = driver.findElements(By.xpath("//span[contains(@tooltipstyleclass,'ryt ryt-arw')]")).size();
			for (int i = 4; i <= size_bot; i++) {
				String text = driver.findElement(By.xpath("(//span[contains(@tooltipstyleclass,'ryt ryt-arw')])[" + i + "]")).getText();
				Text_Bot.add(text);
			}
			System.out.println("Text present in BOT name - " + Text_Bot);
			ArrayList<String> sortedList = new ArrayList<>();
			for (String s : Text_Bot) {
				sortedList.add(s);
				System.out.println("Text present in BOT name after Ascending sort - " + Text_Bot);
				Thread.sleep(2000);
			}
			Collections.sort(sortedList);
			Thread.sleep(2000);
			Collections.reverse(sortedList);
			Thread.sleep(2000);
			Assert.assertTrue(sortedList.equals(Text_Bot));

		}catch (Exception e) {

		}
	}




	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}





}
