package com.zifautomation.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CMPLandingpage {
	WebDriver driver;

	public CMPLandingpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//span[text()='Total Customers']")
	private WebElement totalCustomers;

	@FindBy(how = How.XPATH, using="(//span[@class='cptab-val'])[1]")
	private WebElement totalCustomersvalue;

	@FindBy(how = How.XPATH, using="//span[text()='In Production']")
	private WebElement InProductionText;

	@FindBy(how = How.XPATH, using="(//span[@class='cptab-val'])[2]")
	private WebElement InProductionValue;

	@FindBy(how = How.XPATH, using="//span[text()='In POV']")
	private WebElement InPOV;

	@FindBy(how = How.XPATH, using="(//span[@class='cptab-val'])[3]")
	private WebElement InPOVvalue;

	@FindBy(how = How.XPATH, using="//span[text()='+  Add New Customer']")
	private WebElement addnewcustomerbtn;


	//Searchboxes
	@FindBy(how = How.XPATH, using="//input[@placeholder='Customer ID']")
	private WebElement customerID;

	@FindBy(how = How.XPATH, using="//input[@placeholder='Customer Name']")
	private WebElement customerName;


	@FindBy(how = How.XPATH, using="//input[@placeholder='Type']")
	private WebElement type;

	@FindBy(how = How.XPATH, using="//input[@placeholder='Manager']")
	private WebElement manager;

	@FindBy(how = How.XPATH, using="//input[@placeholder='Location']")
	private WebElement location;

	@FindBy(how = How.XPATH, using="//input[@placeholder='Status']")
	private WebElement status;

	@FindBy(how = How.XPATH, using="(//span[contains(@class,'ui-paginator-icon pi')])[3]")
	private WebElement paginatorforward;

	@FindBy(how = How.XPATH, using="(//span[contains(@class,'ui-paginator-icon pi')])[4]")
	private WebElement paginatorLast;

	@FindBy(how = How.XPATH, using="(//span[contains(@class,'ui-paginator-icon pi')])[1]")
	private WebElement paginatorfirst;

	@FindBy(how = How.XPATH, using="(//span[contains(@class,'ui-paginator-icon pi')])[2]")
	private WebElement paginatorbackward;


	//IN ADD Customer:
	//Text Fields and Headers

	@FindBy(how = How.XPATH, using="//div[text()='Add a New Customer']")
	private WebElement AddnewCustomerheader;

	@FindBy(how = How.XPATH, using="//div[contains(text(),'Customer Name')]")
	private WebElement customerNamefield;

	@FindBy(how = How.XPATH, using="//div[contains(text(),'Customer Location')]")
	private WebElement customerLocationfield;

	@FindBy(how = How.XPATH, using="//div[contains(text(),'Account manager')]")
	private WebElement accountManagerfield;

	@FindBy(how = How.XPATH, using="//div[contains(text(),'Account Manager email')]")
	private WebElement accountManagerEmailfield;

	@FindBy(how = How.XPATH, using="//div[contains(text(),'Type of Implementation')]")
	private WebElement typeOfImplementationfield;

	@FindBy(how = How.XPATH, using="//div[contains(text(),'Email Id to access ZIF catalogue')]")
	private WebElement ZifcatalogueEmailIdfield;

	@FindBy(how = How.XPATH, using="//div[contains(text(),'ZIF Portal Account Admin EmailID')]")
	private WebElement ZifadminEmailIdfield;


	//InPut Fields

	@FindBy(how = How.XPATH, using="//input[@formcontrolname='customerName']")
	private WebElement customer_Name;

	@FindBy(how = How.XPATH, using="//input[@formcontrolname='location']")
	private WebElement customerLocation;

	@FindBy(how = How.XPATH, using="//input[@formcontrolname='manager']")
	private WebElement accountManager;

	@FindBy(how = How.XPATH, using="//input[@formcontrolname='managerEmail']")
	private WebElement accountManagerEmail;

	@FindBy(how = How.XPATH, using="//input[@value='Production']")
	private WebElement productionrbtn;

	@FindBy(how = How.XPATH, using="//input[@value='POV']")
	private WebElement POVrbtn;

	@FindBy(how = How.XPATH, using="//input[@formcontrolname='clientEmail']")
	private WebElement clientEmail;

	@FindBy(how = How.XPATH, using="//input[@type='clientAdminEmail']")
	private WebElement clientAdminEmail;

	@FindBy(how = How.XPATH, using="//span[text()='Create Customer']")
	private WebElement CreateCustomer;























	public void TotalCustomersTextandValue(){

		assertTrue(totalCustomers.isDisplayed());
		assertTrue(totalCustomersvalue.isDisplayed());
	}



	public void InProductionTextandValue(){

		assertTrue(InProductionText.isDisplayed());
		assertTrue(InProductionValue.isDisplayed());

	}

	public void InPOVGTextandValue(){

		assertTrue(InPOV.isDisplayed());
		assertTrue(InPOVvalue.isDisplayed());

	}


	public void Check_all_present_searchboxs(){


		assertTrue(customerID.isDisplayed());
		assertTrue(customerName.isDisplayed());
		assertTrue(type.isDisplayed());
		assertTrue(manager.isDisplayed());
		assertTrue(location.isDisplayed());
		assertTrue(status.isDisplayed());


	}

	public void CheckPaginators(){
		try {

			paginatorforward.click();
			Thread.sleep(2000);
			paginatorLast.click();
			Thread.sleep(2000);
			paginatorbackward.click();
			Thread.sleep(2000);
			paginatorfirst.click();
			Thread.sleep(2000);
		}catch (Exception e) {

		}

	}


	public void ClickonAddnewCustomerbtn(){
		try {
			addnewcustomerbtn.click();
		}catch (Exception e) {

		}

	}

	public void VerifyAddNewCustomerfields(){

		assertTrue(AddnewCustomerheader.isDisplayed());
		assertTrue(customerNamefield.isDisplayed());
		assertTrue(customerLocationfield.isDisplayed());
		assertTrue(accountManagerfield.isDisplayed());
		assertTrue(accountManagerEmailfield.isDisplayed());
		assertTrue(typeOfImplementationfield.isDisplayed());
		assertTrue(ZifcatalogueEmailIdfield.isDisplayed());
		assertTrue(ZifadminEmailIdfield.isDisplayed());
		assertTrue(CreateCustomer.isDisplayed());
	}







	public void CreateCustomerdisabled(){
		try {
			assertTrue(CreateCustomer.isEnabled());
		}catch (Exception e) {

		}


	}

	public void CreateCustomerenabled(){

		assertTrue(CreateCustomer.isEnabled());

	}


	public void EnteralldetailsinAddCustomer(String Cname,String Loc,String Amanger,String AmEmail,String imp,String ZifcEmail,String AdminEmail){
		try {
			customer_Name.clear();
			customerLocation.clear();
			accountManager.clear();
			accountManagerEmail.clear();

			clientEmail.clear();
			clientAdminEmail.clear();

			customer_Name.sendKeys(Cname);
			customerLocation.sendKeys(Loc);
			accountManager.sendKeys(Amanger);
			accountManagerEmail.sendKeys(AmEmail);

			if(imp.contains("pov")) {
				POVrbtn.click();
			}else {
				productionrbtn.click();
			}

			clientEmail.sendKeys(ZifcEmail);
			clientAdminEmail.sendKeys(AdminEmail);
		}catch (Exception e) {

		}}
}
