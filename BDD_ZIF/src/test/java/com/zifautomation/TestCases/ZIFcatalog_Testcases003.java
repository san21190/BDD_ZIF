package com.zifautomation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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

import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFCatalogHomePage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

public class ZIFcatalog_Testcases003 extends Base {
	
			// PreRequsite
			PropertiesFileReader obj= new PropertiesFileReader();
			Properties properties = null;
			
	

			@Test(enabled = true)
				public void ZIFcatalogLogoutTest() throws IOException, InterruptedException {
				
					//Report 
					
					test = extent.createTest("ZIFcatalog Logout Test");
					test.createNode("ZIFcatalog Logout Test");
					
					
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
			
				
			//Click on Logout button
				try {
					Thread.sleep(2000);
					WebElement LogoutZIFcatalog = driver.findElement(By.xpath("//span[contains(@class,'cp-user')]"));
					assertTrue(LogoutZIFcatalog.isDisplayed());
					LogoutZIFcatalog.click();
					test.log(Status.PASS,"Successfully Logged out of ZIFcatalog Portal ");
					
				} catch (AssertionError | Exception e) {
					
					test.log(Status.FAIL, "Logout failed");
				}
				
			//Click Backward and check user is not in Home page
				try {
					Thread.sleep(2000);
					driver.navigate().back();
					driver.navigate().refresh();
					new Loginfunction(driver).Check_all_fields_are_present();
					test.log(Status.PASS,"Verified the user is in Login Page after Logout of Application and click on Backward");
					
				} catch (AssertionError | Exception e) {
					
					test.log(Status.FAIL, "Backward flow failed");
				}
					
				}
				
				@Test(enabled = true)
				public void forwardBackward_Test() throws IOException, InterruptedException {
					//Report 
					
					test = extent.createTest("ZIFcatalog Forward Backward Logout Test");
					test.createNode("ZIFcatalog Forward Backward Logout Test");
					
					//Verify valid UserName and valid Password
					try {
						String UserName = testdata.getTestDataInMap().get("UserName");
						String Password = testdata.getTestDataInMap().get("Password");
						new Loginfunction(driver)
						.Enterthecredentials(UserName, Password);
							Thread.sleep(2000);
						test.log(Status.PASS,"Valid UserName and Valid Password has been entered and Verified");

						Thread.sleep(2000);
						} catch (AssertionError | Exception e) {
							test.log(Status.FAIL, "Valid credentials verification failed");
							
						}
					
					//Click Backward and check 
					try {
						Thread.sleep(2000);
						driver.navigate().back();
						driver.navigate().refresh();
						new ZIFCatalogHomePage(driver).VerifyallfieldsInZIFcatalogHomePage();
						test.log(Status.PASS,"Verified the user is in Home Page after clicked on Back button");
						
					} catch (AssertionError | Exception e) {
						
						test.log(Status.FAIL, "Backward flow failed");
					}
					
					
					//Click Forward and check 
					try {
						Thread.sleep(2000);
						driver.navigate().forward();
						driver.navigate().refresh();
						new ZIFCatalogHomePage(driver).VerifyallfieldsInZIFcatalogHomePage();
						test.log(Status.PASS,"Verified the user is in Home Page after clicked on forward button");
						
					} catch (AssertionError | Exception e) {
						
						test.log(Status.FAIL, "Backward flow failed");
					}
					
				}
				
				@Test(enabled = true)
				public void openNewTabTest() throws IOException, InterruptedException {
					//Report 
					
					test = extent.createTest("ZIFcatalog Open new tab with same URL");
					test.createNode("ZIFcatalog Open new tab with same URL");
					
					
					//Verify valid UserName and valid Password
					try {
						String UserName = testdata.getTestDataInMap().get("UserName");
						String Password = testdata.getTestDataInMap().get("Password");
						new Loginfunction(driver)
						.Enterthecredentials(UserName, Password);
							Thread.sleep(2000);
						test.log(Status.PASS,"Valid UserName and Valid Password has been entered and Verified");

						Thread.sleep(2000);
						} catch (AssertionError | Exception e) {
							test.log(Status.FAIL, "Valid credentials verification failed");
							
						}
					
					//Open New tab and verify
					try {
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_T);
						robot.keyRelease(KeyEvent.VK_CONTROL);
						robot.keyRelease(KeyEvent.VK_T);
						ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
						driver.switchTo().window(tabs.get(1));
						String url1 = testdata.getTestDataInMap().get("Url");
						driver.get(url1);
					Thread.sleep(2000);
					
					new ZIFCatalogHomePage(driver).VerifyallfieldsInZIFcatalogHomePage();
					
					test.log(Status.PASS,"Verified the User is active on the other session of the tab of the same browser with same URL ");
					
					} catch (AssertionError | Exception e) {
						
						test.log(Status.FAIL, "Open another session faied");
					}
}
}
