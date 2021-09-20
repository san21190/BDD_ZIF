package com.zifautomation.TestCases;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;

import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

public class ZIFcatalog_Testcases001 extends Base {
	
	// PreRequsite
			PropertiesFileReader obj= new PropertiesFileReader();
			Properties properties = null;
			
	
	@Test
	public void ZIFcatalogLoginFieldValidation() throws IOException, InterruptedException {
		
		//Report 
		
		test = extent.createTest("Login Page Field Validation");
		test.createNode("Login Page Field Validation");
	
		
		//Verify all the fields in Login Page
		
		try {
			new Loginfunction(driver).Check_all_fields_are_present();
			test.log(Status.PASS,"Successfully verified all the fields in Login Page");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login page field validation failed");
			
		}
		
	
	}
	@Test
	public void ZIFcatalogInvalidLoginTest() throws IOException, InterruptedException {
		
		//Report 
		
				test = extent.createTest("ZIFcatalog Invalid Login Test");
				test.createNode("ZIFcatalog Invalid Login Test");
		
		//Verify Invalid UserName and Invalid Password
		try {
			String UserName = testdata.getTestDataInMap().get("InvalidUsername");
			String Password = testdata.getTestDataInMap().get("InvalidPassword");
			new Loginfunction(driver)
			.Enterthecredentials(UserName, Password);
			new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();
			
			test.log(Status.PASS,"Invalid UserName and Invalid Password has been entered and Verified");

			Thread.sleep(2000);
			} catch (AssertionError | Exception e) {
				test.log(Status.FAIL, "Invalid credentials verification failed");
				
			}
		
			
		
		//Verify Invalid UserName and Valid Password
				try {
					String UserName = testdata.getTestDataInMap().get("InvalidUsername");
					String Password = testdata.getTestDataInMap().get("Password");
					new Loginfunction(driver)
					.Enterthecredentials(UserName, Password);
					new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();
					
					test.log(Status.PASS,"Invalid UserName and Valid Password has been entered and Verified");

					Thread.sleep(2000);
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Invalid credentials verification failed");
						
					}
				
				
				//Verify Valid UserName and Invalid Password
				try {
					String UserName = testdata.getTestDataInMap().get("UserName");
					String Password = testdata.getTestDataInMap().get("InvalidPassword");
					new Loginfunction(driver)
					.Enterthecredentials(UserName, Password);
					new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();
					
					test.log(Status.PASS,"Valid UserName and Invalid Password has been entered and Verified");

					Thread.sleep(2000);
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Invalid credentials verification failed");
						
					}
	}
		
				@Test
				public void ZIFcatalogvalidLoginTest() throws IOException, InterruptedException {
					
					//Report 
					
							test = extent.createTest("ZIFcatalog Valid Login Test");
							test.createNode("ZIFcatalog Valid Login Test");
					
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
					
					// Verify User is in ZIFcatalog Home Page
					
					try {
						String ExpectedTitle = "ZIF Catalog";
						
						String ActualTitle = driver.getTitle();
						
						assertEquals(ExpectedTitle, ActualTitle);
						test.log(Status.PASS,"Successfully logged in and User is in ZIFcatalog Home Page");

						Thread.sleep(2000);
						} catch (AssertionError | Exception e) {
							test.log(Status.FAIL, "Login failed");
							
						}
					
				}
						

}
