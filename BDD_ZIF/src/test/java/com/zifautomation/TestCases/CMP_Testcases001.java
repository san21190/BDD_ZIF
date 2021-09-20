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
import com.zifautomation.Pages.CMPLandingpage;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

public class CMP_Testcases001 extends Base {
	
	// PreRequsite
			PropertiesFileReader obj= new PropertiesFileReader();
		//	TestDataHandler testdata=new TestDataHandler();
			Properties properties = null;
			
	
	@Test(enabled = true)
	public void CMPLoginFieldValidation() throws IOException, InterruptedException {

		
		//Report 
		
		test = extent.createTest("Login Page Field Validation");
		test.createNode("Login Page Field Validation");
	
		
//		//Data sheet 
//		try {
//		String sheet1="CMPPortal";
//		String TestCaseId1="CMP";
//		 
//		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(properties.getProperty("testdatafilepath"), sheet1, TestCaseId1);
//		testdata.setTestDataInMap(TestDataInMap);
//		} catch (Exception e) {
//		
//		e.printStackTrace();
//		}  
		
		//Verify all the fields in Login Page
		
		try {
			new Loginfunction(driver).Check_all_fields_are_present();
			test.log(Status.PASS,"Successfully verified all the fields in Login Page");
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Login page field validation failed");
			
		}
		
	
	}
	@Test(priority = 1,enabled = true)
	public void CMPInvalidLoginTest() throws IOException, InterruptedException {
		
		//Report 
		
				test = extent.createTest("CMP Invalid Login Test");
				test.createNode("CMP Invalid Login Test");
		
		//Verify Invalid UserName and Invalid Password
		try {
			String UserName2 = testdata.getTestDataInMap().get("InvalidUsername");
			String Password2 = testdata.getTestDataInMap().get("InvalidPassword");
			new Loginfunction(driver)
			.Enterthecredentials(UserName2,Password2);
			new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();
			
			test.log(Status.PASS,"Invalid UserName and Invalid Password has been entered and Verified");

			Thread.sleep(2000);
			} catch (AssertionError | Exception e) {
				test.log(Status.FAIL, "Invalid credentials verification failed");
				
			}
		
			
		
		//Verify Invalid UserName and Valid Password
				try {
					String UserName3 = testdata.getTestDataInMap().get("InvalidUsername");
					String Password3 = testdata.getTestDataInMap().get("Password");
					new Loginfunction(driver)
					.Enterthecredentials(UserName3, Password3);
					new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();
					
					test.log(Status.PASS,"Invalid UserName and Valid Password has been entered and Verified");

					Thread.sleep(2000);
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Invalid credentials verification failed");
						
					}
				
				
				//Verify Valid UserName and Invalid Password
				try {
					String UserName4 = testdata.getTestDataInMap().get("UserName");
					String Password4 = testdata.getTestDataInMap().get("InvalidPassword");
					new Loginfunction(driver)
					.Enterthecredentials(UserName4, Password4);
					new Loginfunction(driver).getTextOfInvalidUsernameOrpassword();
					
					test.log(Status.PASS,"Valid UserName and Invalid Password has been entered and Verified");

					Thread.sleep(2000);
					} catch (AssertionError | Exception e) {
						test.log(Status.FAIL, "Invalid credentials verification failed");
						
					}
	}
		
				@Test(priority = 2,enabled = true)
				public void CMPvalidLoginTest() throws IOException, InterruptedException {
					
					//Report 
					
							test = extent.createTest("CMP Valid Login Test");
							test.createNode("CMP Valid Login Test");
					
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
					
					// Verify User is in CMP Home Page
					
					try {
						String ExpectedTitle = "CMP";
						
						String ActualTitle = driver.getTitle();
						
						assertEquals(ExpectedTitle, ActualTitle);
						test.log(Status.PASS,"Successfully logged in and User is in CMP Home Page");

						Thread.sleep(2000);
						} catch (AssertionError | Exception e) {
							test.log(Status.FAIL, "Login failed");
							
						}
					
				}
					
				
				@Test(priority = 3,enabled = true)
				public void CMPGoogleReCaptcha() throws IOException, InterruptedException {
				
					//Report 
					
					test = extent.createTest("CMP Google ReCaptcha Test");
					test.createNode("CMP Google ReCaptcha Test");
			
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
			
			// Verify User is in CMP Home Page
			
			try {
				new CMPLandingpage(driver).TotalCustomersTextandValue();
				new CMPLandingpage(driver).InProductionTextandValue();
				new CMPLandingpage(driver).InPOVGTextandValue();
				test.log(Status.PASS,"Successfully logged in and User is in CMP Home Page");
				Thread.sleep(2000);
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, "Login failed");
					
				}
			try {
				new Loginfunction(driver).getTextOfSuspiciousbehavior();
				test.log(Status.PASS,"Successfully google recaptcha detected automated script");
			}catch (Exception e) {
				test.log(Status.FAIL, "suspicious activity not detected");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			
				}
				
				
				
}


