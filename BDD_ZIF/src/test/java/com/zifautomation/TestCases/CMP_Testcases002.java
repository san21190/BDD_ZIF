package com.zifautomation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.CMPLandingpage;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

public class CMP_Testcases002 extends Base {
	
	// PreRequsite
			PropertiesFileReader obj= new PropertiesFileReader();
			
			Properties properties = null;
			
	

				@Test
				public void cmpHomepage() throws IOException, InterruptedException {

					//Report 
					
					test = extent.createTest("CMP Home Page Valiation");
					test.createNode("CMP Home Page Valiation");
					
					
			//Verify valid UserName and valid Password
			try {
				String UserName = testdata.getTestDataInMap().get("UserName");
				String Password = testdata.getTestDataInMap().get("Password");
				new Loginfunction(driver)
				.Enterthecredentials(UserName, Password);
					
				test.log(Status.PASS,"Valid UserName and Valid Password has been entered and Verified");

				Thread.sleep(2000);
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Valid credentials verification failed");
					
				}
			
			//Verify the all the fields
			try {
			new CMPLandingpage(driver).TotalCustomersTextandValue();
			new CMPLandingpage(driver).InProductionTextandValue();
			new CMPLandingpage(driver).InPOVGTextandValue();
			WebElement ListofCustomer = driver.findElement(By.xpath("//p[contains(text(),'List of Customers')]"));
			ListofCustomer.isDisplayed();
			new CMPLandingpage(driver).Check_all_present_searchboxs();
			test.log(Status.PASS,"Successfully verified CMP Home Page fields ");
			
			} catch (AssertionError | Exception e) {
				test.log(Status.FAIL, "Failed to check the CMP Portal fields ");
				
			}
			
				}
			@Test
			public void cmpHomepagepagination() throws IOException, InterruptedException {
				
				test = extent.createTest("CMP Home Page Pagination test");
				test.createNode("CMP Home Page Pagination test");
				
				//Verify valid UserName and valid Password
				try {
					String UserName = testdata.getTestDataInMap().get("UserName");
					String Password = testdata.getTestDataInMap().get("Password");
					new Loginfunction(driver)
					.Enterthecredentials(UserName, Password);
						
					test.log(Status.PASS,"Valid UserName and Valid Password has been entered and Verified");

					Thread.sleep(2000);
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Valid credentials verification failed");
						
					}
				
			//Verify Pagination in CMP HomePage
			try {
				driver.navigate().refresh();
			new CMPLandingpage(driver).CheckPaginators();
			test.log(Status.PASS,"Successfully verified Paginators in CMP Home Page ");
			} catch (AssertionError | Exception e) {
				test.log(Status.FAIL, "Failed to check the paginators CMP Portal fields ");
				
			}
			}
			
			@Test
			public void addNewcustomerVerifications() throws IOException, InterruptedException {
				
				test = extent.createTest("CMP Home Page Add new customer Verifications");
				test.createNode("CMP Home Page Add new customer Verifications");
				
				//Verify valid UserName and valid Password
				try {
					String UserName = testdata.getTestDataInMap().get("UserName");
					String Password = testdata.getTestDataInMap().get("Password");
					new Loginfunction(driver)
					.Enterthecredentials(UserName, Password);
						
					test.log(Status.PASS,"Valid UserName and Valid Password has been entered and Verified");

					Thread.sleep(2000);
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Valid credentials verification failed");
						
					}
			
			
			
			
			
				//Add new customer 
				
				try {
				 new CMPLandingpage(driver).ClickonAddnewCustomerbtn();
				 Thread.sleep(2000);
				 new CMPLandingpage(driver).VerifyAddNewCustomerfields();
				 Thread.sleep(2000);
				 	String CustomerName = testdata.getTestDataInMap().get("CustomerName");
					String CustomerLocation = testdata.getTestDataInMap().get("CustomerLocation");
					String AccountManager = testdata.getTestDataInMap().get("AccountManager");
					String AMEmail = testdata.getTestDataInMap().get("AMEmail");
					String Implementation = testdata.getTestDataInMap().get("Implementation");
					String ZIFcatalogueEmailID = testdata.getTestDataInMap().get("ZIFcatalogueEmailID");
					String ZIFAdminEmailID = testdata.getTestDataInMap().get("ZIFAdminEmailID");
					
				new CMPLandingpage(driver).EnteralldetailsinAddCustomer(CustomerName, CustomerLocation, AccountManager, AMEmail, Implementation, ZIFcatalogueEmailID, ZIFAdminEmailID);
				WebElement CreateCustomerbtn = driver.findElement(By.xpath("//span[text()='Create Customer']"));
				CreateCustomerbtn.click();
				test.log(Status.PASS,"Successfully created a new customer ");
				} catch (AssertionError | Exception e) {
					
					test.log(Status.FAIL, "Failed in adding new customer side panel ");
				}
				
				
				
				
				//successfully created Customer message
				
				try {
					WebElement customercreatedsuccess = driver.findElement(By.xpath("//span[contains(text(),'Customer has been created successfully')]"));
					
					assertTrue(customercreatedsuccess.isDisplayed());
					test.log(Status.PASS,"Customer has been created successfully messsage is displayed");
					test.addScreenCaptureFromPath(captureScreenShot(driver));
					WebElement Addcustomerclose = driver.findElement(By.xpath("//a[@role='button']//span[1]"));
					Addcustomerclose.click();
				} catch (AssertionError | Exception e) {
				
				test.log(Status.FAIL, "Customer has been created successfully messsage is not displayed ");
				
				}
				
				
				//Verify that the Customer is displayed in the List of Customers
				
				try {
					driver.navigate().refresh();
					Thread.sleep(5000);
			
					String CustomerName = testdata.getTestDataInMap().get("CustomerName");
					String CustomerLocation = testdata.getTestDataInMap().get("CustomerLocation");
					String AccountManager = testdata.getTestDataInMap().get("AccountManager");
					
					
					 String CustomerNameGrid = driver.findElement(By.xpath("(//tbody//tr/td[2])[1]")).getText();
					 String AccountManagerGrid = driver.findElement(By.xpath("(//tbody//tr/td[4])[1]")).getText();
					 String CustomerLocationGrid = driver.findElement(By.xpath("(//tbody//tr/td[5])[1]")).getText();
					 
					 assertEquals(CustomerName, CustomerNameGrid);
					 assertEquals(CustomerLocation, CustomerLocationGrid);
					 assertEquals(AccountManager, AccountManagerGrid);
					 
					 Thread.sleep(2000);
					 test.log(Status.PASS,"Successfully verified the customer details in the list");
					 
				} catch (AssertionError | Exception e) {
					
					test.log(Status.FAIL, "Customer details matching failed ");
					
					
					}
				
			}
			
			@Test(dependsOnMethods = {"addNewcustomerVerifications"})
			public void addexistingcustomerVerifications() throws IOException, InterruptedException {
				
				test = extent.createTest("CMP Home Page Add existing customer Verifications");
				test.createNode("CMP Home Page Add existing customer Verifications");
				
				//Verify valid UserName and valid Password
				try {
					String UserName = testdata.getTestDataInMap().get("UserName");
					String Password = testdata.getTestDataInMap().get("Password");
					new Loginfunction(driver)
					.Enterthecredentials(UserName, Password);
						
					test.log(Status.PASS,"Valid UserName and Valid Password has been entered and Verified");

					Thread.sleep(2000);
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Valid credentials verification failed");
						
					}
			
				//Add existing customer 
				
				try {
				 new CMPLandingpage(driver).ClickonAddnewCustomerbtn();
				 Thread.sleep(2000);
				// new CMPLandingpage(driver).VerifyAddNewCustomerfields();
				 	String CustomerName = testdata.getTestDataInMap().get("CustomerName");
					String CustomerLocation = testdata.getTestDataInMap().get("CustomerLocation");
					String AccountManager = testdata.getTestDataInMap().get("AccountManager");
					String AMEmail = testdata.getTestDataInMap().get("AMEmail");
					String Implementation = testdata.getTestDataInMap().get("Implementation");
					String ZIFcatalogueEmailID = testdata.getTestDataInMap().get("ZIFcatalogueEmailID");
					String ZIFAdminEmailID = testdata.getTestDataInMap().get("ZIFAdminEmailID");
					
				new CMPLandingpage(driver).EnteralldetailsinAddCustomer(CustomerName, CustomerLocation, AccountManager, AMEmail, Implementation, ZIFcatalogueEmailID, ZIFAdminEmailID);
				
				test.log(Status.PASS,"Successfully entered the existing customer details ");
				
				} catch (AssertionError | Exception e) {
					
					test.log(Status.FAIL, "Failed in adding existing customer in side panel ");
				}
		
				//verify the Customer record already exists is displayed
				
				try {
				WebElement CreateCustomerbtn = driver.findElement(By.xpath("//span[text()='Create Customer']"));
				CreateCustomerbtn.click();
				WebElement customerexists = driver.findElement(By.xpath("//span[contains(text(),'Customer record already exists')]"));
				
				assertTrue(customerexists.isDisplayed());
				test.log(Status.PASS,"Successfully Customer record already exists messsage is displayed ");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
				WebElement Addcustomerclose = driver.findElement(By.xpath("//a[@role='button']//span[1]"));
				Addcustomerclose.click();
				} catch (AssertionError | Exception e) {
					
					test.log(Status.FAIL, "Customer record already exists messsage is not displayed");
				}
				
			
			//Click on Logout button
				try {
					Thread.sleep(2000);
					WebElement LogoutCMP = driver.findElement(By.xpath("//span[contains(@class,'cp-user')]"));
					assertTrue(LogoutCMP.isDisplayed());
					LogoutCMP.click();
					test.log(Status.PASS,"Successfully Logged out of CMP Portal ");
					
				} catch (AssertionError | Exception e) {
					
					test.log(Status.FAIL, "Logout failed");
				}
				
				
				
				
				
				
				}			
}
