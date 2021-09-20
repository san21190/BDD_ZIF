package com.zifautomation.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

public class Base {

	public WebDriver driver;
	public ExtentHtmlReporter report;
	public ExtentReports extent;
	public ExtentTest test;
	public TestDataHandler testdata = new TestDataHandler();
	public PropertiesFileReader obj = new PropertiesFileReader();
	public Properties properties = null;
//	public WebDriverWait wait=new WebDriverWait(driver,20);

	public WebDriver getDriver() {
		return driver;
	}


	private void setDriver(String browserType, String appURL) throws InterruptedException {
		switch (browserType) {
		case "Chrome":
			driver = initChromeDriver(appURL);
			break;
		case "Firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "IE":
			driver = initIEDriver(appURL);
			break;
		case "headless":
			driver = initChromeDriverheadless(appURL);
			break;
		case "Edge":
			driver = initEdgeDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Chrome as browser of choice..");
			driver = initChromeDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) throws InterruptedException {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");


		String downloadFilepath = System.getProperty("user.dir") + "\\resources\\Datatables\\Downloads";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(cap);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		Thread.sleep(5000);
		return driver;
	}

	private static WebDriver initChromeDriverheadless(String appURL) throws InterruptedException {
		System.out.println("Launching google chrome headless with new profile..");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		Thread.sleep(5000);
		return driver;
	}
	private static WebDriver initFirefoxDriver(String appURL) throws InterruptedException {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		Thread.sleep(5000);
		return driver;
	}
	
	private static WebDriver initEdgeDriver(String appURL) throws InterruptedException {
		System.out.println("Launching Microsoft Edge with new profile..");
		System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		Thread.sleep(5000);
		return driver;
	}
	private static WebDriver initIEDriver(String appURL) throws InterruptedException {
		System.out.println("Launching IE browser..");
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability("ignoreZoomSetting", true);
		capabilities.setCapability("requireWindowFocus", true);// to move mouse manually
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		Thread.sleep(5000);
		return driver;
	}

	@Parameters({ "DatasheetName" })
	@BeforeMethod
	public void initializeTestBaseSetup(String SheetName) {
		try {

			try {
				properties = obj.getProperty();
			} catch (IOException e) {

				e.printStackTrace();
			}

			try {
				switch (SheetName) {
				case "CMPPortal": {

					String TestCaseId = "CMP";

					Map<String, String> TestDataInMap = ExcelHandler
							.getTestDataInMap(properties.getProperty("testdatafilepath"), SheetName, TestCaseId);
					testdata.setTestDataInMap(TestDataInMap);
					String browserType = testdata.getTestDataInMap().get("Browser");
					String appURL = testdata.getTestDataInMap().get("Url");
					setDriver(browserType, appURL);
				}
				break;
				case "ZIFCatalog": {

					String TestCaseId = "ZIFCatalogRegression";

					Map<String, String> TestDataInMap = ExcelHandler
							.getTestDataInMap(properties.getProperty("testdatafilepath"), SheetName, TestCaseId);
					testdata.setTestDataInMap(TestDataInMap);
					String browserType = testdata.getTestDataInMap().get("Browser");
					String appURL = testdata.getTestDataInMap().get("Url");
					setDriver(browserType, appURL);
				}
				break;
				case "ZIFAIPortal": {

					String TestCaseId = "ZIFAI";

					Map<String, String> TestDataInMap = ExcelHandler
							.getTestDataInMap(properties.getProperty("testdatafilepath"), SheetName, TestCaseId);
					testdata.setTestDataInMap(TestDataInMap);
					String browserType = testdata.getTestDataInMap().get("Browser");
					String appURL = testdata.getTestDataInMap().get("Url");
					setDriver(browserType, appURL);
				}
				break;
				}

			} catch (Exception e) {
				System.out.println("Error....." + e.getStackTrace());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

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
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		//driver.quit();
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

	@BeforeTest
	public void extentReportSetup() {
		String reportLocation = System.getProperty("user.dir") + "\\Reports\\" + Setreportname() + ".html";
		// System.getProperty("user.dir") + "target/html_reports/screenshots"+
		// getcurrentdateandtime() + ".png";
		report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
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

	public static String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		// String dest =
		// "D:\\Updated\\SeleniumCucumberTestNGFramework-master\\SeleniumCucumberBDDFramework\\Reports\\Screenshots\\"
		// + getcurrentdateandtime() + ".png";
		String dest = System.getProperty("user.dir") + "/Reports/Screenshots/" + getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = "TestResults" + str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
		}
		return str;
	}

	public String Setreportname() {
		String str = null;
		try {
			String Class_Name = this.getClass().getName();
			String ClassFileName = Class_Name.replaceAll("com.zifautomation.TestCases.", "").trim();
			System.out.println("Class_Name:" + ClassFileName);
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy/HH:mm");
			Date date = new Date();
			str = dateFormat.format(date).replace("", "").replaceAll("/", "_").replaceAll(":", "");
			str = ClassFileName + "_Automation_Report_" + str;
		} catch (Exception e) {
		}
		return str;
	}

}
