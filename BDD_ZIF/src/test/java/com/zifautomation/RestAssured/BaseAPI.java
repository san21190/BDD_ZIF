package com.zifautomation.RestAssured;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ConfigurableReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zifautomation.Base.Base.getcurrentdateandtime;

public class BaseAPI {

    public WebDriver driver;
    public ExtentHtmlReporter report;
    public ExtentReports extent;
    public ExtentTest test;
    public TestDataHandler testdata = new TestDataHandler();
    public PropertiesFileReader obj = new PropertiesFileReader();

    public static RequestSpecification reqSpec;
    public static Response response;
    @BeforeMethod
    public void preCondition() throws IOException {

        Properties properties = new Properties();

        //Buffer reader to read the property file//
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\testdata-config.properties"));
        properties.load(reader);
        reader.close();

        String uri = properties.getProperty("api.uri");
        String authorization = properties.getProperty("api.authorization");
        String name = properties.getProperty("api.name");
        String module = properties.getProperty("api.module");
        RestAssured.baseURI = uri+module;
        RestAssured.authentication = RestAssured.basic(authorization,name);
        reqSpec = RestAssured.given().log().all();

    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            // MarkupHelper is used to display the output in different colors
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - API Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable() + " - API Test Case Failed", ExtentColor.RED));

            // To capture screenshot path and store the path of the screenshot in the string
            // "screenshotPath"
            // We do pass the path captured by this method in to the extent reports using
            // "logger.addScreenCapture" method.

            // String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            String screenshotPath = TakeScreenshot(driver, result.getName());
            // To add it in the extent report

            test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));

        } else if (result.getStatus() == ITestResult.SKIP) {
            // logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            test.log(Status.SKIP,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "API Test Case PASSED", ExtentColor.GREEN));
        }
    }
    @BeforeTest
    public void extentReportSetup() {
        String reportLocation = System.getProperty("user.dir") + "\\Reports\\" + Setreportname() + ".html";
        // System.getProperty("user.dir") + "target/html_reports/screenshots"+
        // getcurrentdateandtime() + ".png";
        report = new ExtentHtmlReporter(reportLocation);
        report.config().setDocumentTitle("API Automation Test Report");
        report.config().setReportName("API Automation Test Report");
        report.config().setTheme(Theme.STANDARD);
        System.out.println("Extent Report location initialized . . .");
        report.start();


        extent = new ExtentReports(); extent.attachReporter(report);
        extent.setSystemInfo("Application", "ZIF");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        /*
         * String reportLocationxml = System.getProperty("user.dir") +
         * "\\Reports\\" + Setreportname() + ".xml"; //extent.loadConfig(new
         * File(reportLocationxml)); //report.loadXMLConfig(reportLocationxml);
         * FileInputStream xmlreportlocation; try { xmlreportlocation = new
         * FileInputStream(new File(reportLocationxml));
         * report.loadConfig(xmlreportlocation); } catch (FileNotFoundException e) { //
         * TODO Auto-generated catch block e.printStackTrace(); }
         */

        System.out.println("System Info. set in Extent Report");

    }
    @AfterTest
    public void endReport() {
        extent.flush();
    }

    public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        // String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots" under src
        // folder
        String destination = System.getProperty("user.dir") + "\\Reports\\Screenshots\\" + getcurrentdateandtime()
                + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public String Setreportname() {
        String str = null;
        try {
            String Class_Name = this.getClass().getName();
            String ClassFileName = Class_Name.replaceAll("com.zifautomation.TestCases.", "").trim();
            System.out.println("Class_Name:" + ClassFileName);
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyyHH:mm");
            Date date = new Date();
            str = dateFormat.format(date).replace("", "").replaceAll("/", "_").replaceAll(":", "");

            str = ClassFileName + "_API_Automation_Report_" + str;
        } catch (Exception e) {
        }
        return str;
    }
}
