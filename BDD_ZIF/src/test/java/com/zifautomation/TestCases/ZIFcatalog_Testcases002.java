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
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFCatalogHomePage;
import com.zifautomation.Pages.ZIFQuestionnairePage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

public class ZIFcatalog_Testcases002 extends Base {
	
	// PreRequsite
			PropertiesFileReader obj= new PropertiesFileReader();
			Properties properties = null;
			
	

				@Test(enabled = true)
				public void ZIFcatalogHomepage() throws IOException, InterruptedException {
					

			//Report 
			
			test = extent.createTest("ZIFcatalog Home Page Valiation");
			test.createNode("ZIFcatalog Home Page Valiation");
			
					
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
			//Verify the all the fields in ZIF Catalog Homepage
			try {
		
				new ZIFCatalogHomePage(driver).VerifyallfieldsInZIFcatalogHomePage();
		
				Thread.sleep(2000);
				test.log(Status.PASS,"Successfully verified ZIF Catalog Home Page fields ");
				
			} catch (AssertionError | Exception e) {
				test.log(Status.FAIL, "Failed to check the ZIF Catalog Homepage ");
				
			}
		
			
				}
				
				
				@Test(enabled = true)
			public void zifcatalogBusiness_TechnicalOutcomes() throws IOException, InterruptedException {
				
				test = extent.createTest("ZIFcatalog Home Page Business and Technical outcomes");
				test.createNode("ZIFcatalog Home Page Business and Technical outcomes");
				
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
				
				// Verify CAPEX Optimization in  business outcomes
				try {
					
					new ZIFCatalogHomePage(driver).UnselectAllBusinessoutcomes();
					new ZIFCatalogHomePage(driver).cAPEXOptimizationcbxClick();
					new ZIFCatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
					test.log(Status.PASS,"Successfully verified Capex optimization technical outcomes ");
					new ZIFCatalogHomePage(driver).cAPEXOptimizationcbxClick();
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, e);
				}
				
				// Verify OPEX Optimization in  business outcomes
							try {
								
								new ZIFCatalogHomePage(driver).oPEXOptimizationcbxClick();
								new ZIFCatalogHomePage(driver).OPEX_Optimizationtechnicaloutcomes();
								test.log(Status.PASS,"Successfully verified Opex optimization technical outcomes ");
								new ZIFCatalogHomePage(driver).oPEXOptimizationcbxClick();
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
							
				// Verify Blueprinting Enterprise in business outcomes
							try {
								
								new ZIFCatalogHomePage(driver).blueprintingEnterprisecbxClick();
								new ZIFCatalogHomePage(driver).Blueprinting_Enterprisetechnicaloutcomes();
								test.log(Status.PASS,"Successfully verified Blueprinting Enterprise technical outcomes ");
								new ZIFCatalogHomePage(driver).blueprintingEnterprisecbxClick();
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
							
				// Verify Compute Utilization & Optimization in business outcomes
							try {
								
								new ZIFCatalogHomePage(driver).computeUtilizationcbxClick();
								new ZIFCatalogHomePage(driver).Optimization_of_Computetechnicaloutcomes();
								test.log(Status.PASS,"Successfully verified Compute Utilization & Optimization technical outcomes ");
								new ZIFCatalogHomePage(driver).computeUtilizationcbxClick();
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
							
				// Verify Improvement in User Experience in business outcomes
							try {
								
								new ZIFCatalogHomePage(driver).improvementInUsercbxClick();
								new ZIFCatalogHomePage(driver).Improvement_in_User_Experiencetechnicaloutcomes();
								test.log(Status.PASS,"Successfully verified Improvement in User Experience technical outcomes ");
								new ZIFCatalogHomePage(driver).improvementInUsercbxClick();
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
				// Verify Improvement in Business Service Assurance in business outcomes
							try {
								
								new ZIFCatalogHomePage(driver).improvementInBusinesscbxClick();
								new ZIFCatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
								test.log(Status.PASS,"Successfully verified Improvement in Business Service Assurance technical outcomes ");
								new ZIFCatalogHomePage(driver).improvementInBusinesscbxClick();
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
							
				// Verify Shift Left in business outcomes
							try {
								
								new ZIFCatalogHomePage(driver).improvementInBusinesscbxClick();
								new ZIFCatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
								test.log(Status.PASS,"Successfully verified Shift Left technical outcomes ");
								new ZIFCatalogHomePage(driver).improvementInBusinesscbxClick();
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
							
				// Verify Eliminating Digital Dirt in business outcomes
							try {
								
								new ZIFCatalogHomePage(driver).eliminatingDigitalDirtcbxClick();
								new ZIFCatalogHomePage(driver).Eliminating_Digital_Dirttechnicaloutcomes();
								test.log(Status.PASS,"Successfully verified Eliminating Digital Dirt technical outcomes ");
								new ZIFCatalogHomePage(driver).eliminatingDigitalDirtcbxClick();
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
							
				// Verify Improvement in Application Availability in business outcomes
							try {
								
								new ZIFCatalogHomePage(driver).improvementInApplicationcbxClick();
								new ZIFCatalogHomePage(driver).Improvement_in_Application_Availabilitytechnicaloutcomes();
								test.log(Status.PASS,"Successfully verified Improvement in Application Availability technical outcomes ");
								new ZIFCatalogHomePage(driver).improvementInApplicationcbxClick();
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
				
				
			}
			
				@Test(enabled = true)
			public void zifcatalog_Need_help_panel() throws IOException, InterruptedException {
				
				test = extent.createTest("ZIFcatalog Need help panel Verifications");
				test.createNode("ZIFcatalog Need help panel Verifications");
				
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
			
				//Verify Need help in choosing the right business outcome? panel
				try {
					
					new ZIFCatalogHomePage(driver).Click_on_need_help_link();
					
					test.log(Status.PASS,"Successfully verified Need help panel on clicking 'Need help in choosing the right business outcome?' link in homepage  ");
					
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, e);
				}
				
				//Click on all the options in the Needhelp Panel and click on save button
				
				try {
					
					new ZIFCatalogHomePage(driver).SelectalloptionsinNeedhelp();
					new ZIFCatalogHomePage(driver).needhelpSave();
					
					test.log(Status.PASS,"Successfully selected all the options in 'Need help in choosing the right business outcome?' and Saved  ");
					
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, e);
				}
			
				
			}
			
				@Test(enabled = true)
			public void zifQuestionnairePageVerifications() throws IOException, InterruptedException {
				
				test = extent.createTest("ZIFcatalog ZIF questionnaire page Verifications");
				test.createNode("ZIFcatalog ZIF questionnaire page Verifications");
				
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
			
				// Verify CAPEX Optimization in  business outcomes
				try {
					
					new ZIFCatalogHomePage(driver).UnselectAllBusinessoutcomes();
					new ZIFCatalogHomePage(driver).cAPEXOptimizationcbxClick();
					//new ZIFCatalogHomePage(driver).CAPEX_Optimizationtechnicaloutcomes();
					test.log(Status.PASS,"Successfully Selected Capex optimization in Business outcomes ");
					//new ZIFCatalogHomePage(driver).cAPEXOptimizationcbxClick();
				} catch (AssertionError | Exception e) {
					test.log(Status.FAIL, e);
				}
				
				// Verify OPEX Optimization in  business outcomes
							try {
								
								new ZIFCatalogHomePage(driver).oPEXOptimizationcbxClick();
								//new ZIFCatalogHomePage(driver).OPEX_Optimizationtechnicaloutcomes();
								test.log(Status.PASS,"Successfully Selected Opex optimization in Business outcomes ");
								//new ZIFCatalogHomePage(driver).oPEXOptimizationcbxClick();
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
							//Select Control Cloud Sprawl in business outcomes and click on Proceed button
							try {
							
							new ZIFCatalogHomePage(driver).controlCloudSprawlcbxClick();
							Thread.sleep(2000);
							new ZIFCatalogHomePage(driver).proceedbutton();
							Thread.sleep(3000);
							test.log(Status.PASS,"Successfully Selected Control Cloud Sprawl in business outcomes and click on Proceed button  ");
							
						} catch (AssertionError | Exception e) {
							test.log(Status.FAIL, e);
						}
							
							
							//Enter all the invalid details in ZIF questionnaire page and click on Build Package button
							
							try {
								String tdevices = testdata.getTestDataInMap().get("TextDevices");
								String tapps = testdata.getTestDataInMap().get("TextApplications");
								String ttools = testdata.getTestDataInMap().get("TextTools");
								String talerts = testdata.getTestDataInMap().get("TextAlerts");
								
								new ZIFQuestionnairePage(driver).enterOnRequired(tdevices, tapps, ttools, talerts);
								Thread.sleep(2000);
								new ZIFQuestionnairePage(driver).click_on_BuildPackage();
								Thread.sleep(3000);
								test.log(Status.PASS,"Successfully Entered invalid details in ZIF questionnaire page Verified");
								
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
							}
							
								//Enter all the details in ZIF questionnaire page and click on Build Package button
							
							try {
								String devices = testdata.getTestDataInMap().get("Devices");
								String apps = testdata.getTestDataInMap().get("Applications");
								String tools = testdata.getTestDataInMap().get("Tools");
								String alerts = testdata.getTestDataInMap().get("Alerts");
								
								new ZIFQuestionnairePage(driver).enterOnRequired(devices, apps, tools, alerts);
								Thread.sleep(2000);
								new ZIFQuestionnairePage(driver).click_on_BuildPackage();
								Thread.sleep(3000);
								test.log(Status.PASS,"Successfully Entered all the details in ZIF questionnaire page and click on Build Package button");
								
							} catch (AssertionError | Exception e) {
								test.log(Status.FAIL, e);
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
				
				
				
				
				
				
				}			
}
