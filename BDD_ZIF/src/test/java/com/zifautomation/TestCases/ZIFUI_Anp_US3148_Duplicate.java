package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.mongodb.client.FindIterable;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.*;
import com.zifautomation.Utility.MongoQueryManager;
import com.zifautomation.Utility.PropertiesFileReader;
import org.bson.Document;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ZIFUI_Anp_US3148_Duplicate extends Base {

    //PreRequsite
    PropertiesFileReader obj = new PropertiesFileReader();

    Properties properties = null;


    @Test
    public void ZIFUI_Anp_US3148_Duplicate() throws IOException, InterruptedException {

        //Report Initialization

        test = extent.createTest("Prioritization of cases - Case Management");
        test.createNode("Prioritization of cases - Case Management");

        // Login to the ZIFAI Portal With valid credentials
        try {
            String UserName = testdata.getTestDataInMap().get("UserName");
            String Password = testdata.getTestDataInMap().get("Password");

            new Loginfunction(driver).Enterthecredentials(UserName, Password);

            test.log(Status.PASS, "Valid credential has been entered");

            Thread.sleep(2000);
        } catch (AssertionError | Exception e) {
            test.log(Status.FAIL, "Login failed");
            test.addScreenCaptureFromPath(captureScreenShot(driver));

        }

        //click on the analytics link
        try {
            new ZIFAIDashboardPage(driver).hoveronAnalyzes();
            new ZIFAIDashboardPage(driver).clickAnalytics();
            test.log(Status.PASS, "Analytics link is clicked");
            test.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (AssertionError | Exception e) {
            test.log(Status.FAIL, "Not able to click the Analytics link");
            test.addScreenCaptureFromPath(captureScreenShot(driver));
        }


        //Clicking on the first row after applying correlation
        try {
            new ZIFAI_CaseManagementPage(driver).FirstCaserow.click();
            Thread.sleep(3000);
            test.log(Status.PASS, "First case is selected after applying correlation");
            test.addScreenCaptureFromPath(captureScreenShot(driver));

        } catch (Exception e) {
            test.log(Status.FAIL, "Unable to click on first from case management page");
            test.addScreenCaptureFromPath(captureScreenShot(driver));
        }


        //Filter case id//
        try {

            new ZIFAI_CaseManagementPage(driver).Filtericon.click();
            Thread.sleep(3000);
            new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.clear();
            Thread.sleep(3000);
            new ZIFAI_CaseManagementPage(driver).CaseIdTextbox.sendKeys("ZIF30");
            Thread.sleep(3000);
            new ZIFAI_CaseManagementPage(driver).Applybutton.click();
            Thread.sleep(3000);
        }
        catch (Exception e){

            test.log(Status.FAIL, "Unable to filter using case id");
            test.addScreenCaptureFromPath(captureScreenShot(driver));

        }

        try {
//			List<WebElement> casestatus = new ZIFAI_CaseManagementPage(driver).CaseStatuslist;
//			List<WebElement> case_status = new ZIFAI_CaseManagementPage(driver).CaseStatuslist;
//			int i;
//			for (i = 0; i < casestatus.size(); i++) {
//				Thread.sleep(3000);
//				case_status.get(i).click();
//				Thread.sleep(4000);
            Thread.sleep(5000);
            new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.click();
//			}
            if (driver.findElements(By.xpath("//div[text()='No Data Found']")).size() < 1) {
                Thread.sleep(3000);
                int size = driver.findElements(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])")).size();
                for (int j = 1; j <= size-33; j++) {
                    //WebElement clickcheckbox = driver.findElement(By.xpath("//div[text()='No Data Found']"));
                    WebElement checkbox = driver.findElement(By.xpath("(//div[contains(@class, 'ui-chkbox-box')])[" + j + "]"));
                    //String property = checkbox.getAttribute("aria-checked");
                    Boolean property = checkbox.isEnabled();
                    System.out.println("Property - " + property);
                    if (property == true) {
                        Thread.sleep(3000);
                        checkbox.click();
                        Thread.sleep(3000);
                    }
                }
            }
            Boolean DCval = new ZIFAI_CaseManagementPage(driver).DeclineCorrelation.isDisplayed();
            System.out.println(DCval);
            test.log(Status.PASS, "End of checkbox validation"+DCval);
            test.log(Status.PASS, "Decline correlation option is displayed "+DCval);
            new ZIFAI_CaseManagementPage(driver).DCclosebutton.click();

        } catch (ArrayIndexOutOfBoundsException | StaleElementReferenceException e) {
            test.log(Status.PASS, e);
            test.log(Status.PASS, "End of case validation");
            test.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (IndexOutOfBoundsException e) {
            test.log(Status.PASS, e);
            test.log(Status.PASS, "End of case validation");
            test.addScreenCaptureFromPath(captureScreenShot(driver));
        } catch (Exception e) {
            test.log(Status.FAIL, e);
            test.addScreenCaptureFromPath(captureScreenShot(driver));
        }




    }








    }
