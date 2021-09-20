package com.zifautomation.TestCases;
import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAI_RawDataPage;
import com.zifautomation.Utility.PropertiesFileReader;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Time_Feature extends Base {

	// PreRequsite
	PropertiesFileReader obj = new PropertiesFileReader();

	Properties properties = null;

	public static String currentime;
	public static String differencecurrenttime;
	public static String fromtime;
	public static String fromtimecorrection;
	public static String totime;

	//Time Zone//
	public static String TimeZone1 = "UTC";
	public static String TimeZone2 = "Asia/Singapore";
	public static String TimeZone3 = "America/New_York";
	public static String TimeZone4 = "America/Los_Angeles";
	public static String TimeZone5 = "America/Denver";
	public static String TimeZone6 = "Asia/Kolkata";
	public static String TimeZone7 = "Pacific/Honolulu";
	public static String TimeZone8 = "Asia/Dubai";
	public static String TimeZone9 = "America/Chicago";
	public static String TimeZone10 = "America/Anchorage";

	//Machine name//
	public static String Machinename = "200411LTP1157";


	@Test
	public void Time_Feature() throws IOException, InterruptedException {

		//Report Initialization

		test = extent.createTest("Case Management - Correlation - Base Screen and Actions");
		test.createNode("Case Management - Correlation - Base Screen and Actions");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


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
			new ZIFAI_RawDataPage(driver).hoveronAnalyzes();
			new ZIFAI_RawDataPage(driver).clickRawData();
			test.log(Status.PASS, "Raw data link is clicked");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			test.log(Status.FAIL, "Not able to click the Raw data link");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Selecting the timeZone//
		try{
			new ZIFAI_RawDataPage(driver).Timezoneselector(TimeZone1);
			test.log(Status.PASS, TimeZone1 +" is selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, TimeZone1 +" is not selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter//
		try {
			new ZIFAI_RawDataPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Filterdevicename.sendKeys(Machinename);
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Deviceviewdetails.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared Filter and "+Machinename +" is entered in Device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Current time of  time zone//
		try {
			Date date = new Date();
			DateFormat dd = new SimpleDateFormat("dd");
			DateFormat MM = new SimpleDateFormat("MM");
			DateFormat YYYY = new SimpleDateFormat("yyyy");
			DateFormat hh = new SimpleDateFormat("kk");
			DateFormat mm = new SimpleDateFormat("mm");
			// Use Madrid's time zone to format the date in
			dd.setTimeZone(TimeZone.getTimeZone(TimeZone1));
			String ddc = dd.format(date);
			MM.setTimeZone(TimeZone.getTimeZone(TimeZone1));
			String MMc = MM.format(date);
			YYYY.setTimeZone(TimeZone.getTimeZone(TimeZone1));
			String YYYYc = YYYY.format(date);
			hh.setTimeZone(TimeZone.getTimeZone(TimeZone1));
			int modifyt = Integer.parseInt(hh.format(date));
			int subtractoneone = modifyt-1;
			String strI = Integer.toString(subtractoneone);
			String hhc = hh.format(date);
			mm.setTimeZone(TimeZone.getTimeZone(TimeZone1));
			String mmc = mm.format(date);
			currentime = ddc + "-" + MMc + "-" + YYYYc + " " + hhc + ":" + mmc;
			System.out.println("Current time------> "+currentime);
			int Changeofminutes=Integer.parseInt(strI);
			if (Changeofminutes<12){
				String str = Integer.toString(Changeofminutes);
				String newmin = "0"+str;
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + newmin + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone1+" is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + strI + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone1+" for validation is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to fetch current time of "+TimeZone1);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Converting month string into integer From Date//
		try {
			String Frmmonth  = new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(3,7).trim();
			String Frmdate 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(8,10);
			String Frmdyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Frmmonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				fromtime = Frmdate + "-" + strnew + "-" + Frmdyearandtime;
				System.out.println("From Date for device List-----> "+Frmdate + "-" + strnew + "-" + Frmdyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("From Date for device List-----> "+Frmdate + "-" + monthInt + "-" + Frmdyearandtime);
				fromtimecorrection = Frmdate + "-" + monthInt + "-" + Frmdyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: From Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Converting month string into integer To Date//
		try {
			String Tomonth  = new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(3,7).trim();
			String Todate 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(8,10);
			String Todyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Tomonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				totime = Todate + "-" + strnew + "-" + Todyearandtime;
				System.out.println("To Date for device List-----> "+Todate + "-" + strnew + "-" + Todyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("To Date for device List-----> "+Todate + "-" + monthInt + "-" + Todyearandtime);
				totime = Todate + "-" + monthInt + "-" + Todyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: To Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validate whether the From time and To time are set by the current timezone//
		try{
			if(differencecurrenttime.equals(fromtime)){
				System.out.println("The time is matching for From");
				test.log(Status.PASS, "Current Time from :"+TimeZone1+" - is matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			else {
				System.out.println("The time is not matching for From");
				test.log(Status.FAIL, "Current Time from :"+TimeZone1+" - is not matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(currentime.equals(totime)){
				System.out.println("The time is matching for To");
				test.log(Status.PASS, "Current Time from :"+TimeZone1+" - is matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				System.out.println("The time is not matching for To");
				test.log(Status.FAIL, "Current Time from :"+TimeZone1+" - is not matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate current time and time displayed in details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the device details page//
		try{
			new ZIFAI_RawDataPage(driver).Closebutton.click();
			test.log(Status.PASS, "Device details page is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Device details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------------End of TimeZone--------------------------------------------------------//


		//Selecting the timeZone//
		try{
			new ZIFAI_RawDataPage(driver).Timezoneselector(TimeZone2);
			test.log(Status.PASS, TimeZone2 +" is selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, TimeZone2 +" is not selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter//
		try {
			new ZIFAI_RawDataPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Filterdevicename.sendKeys(Machinename);
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Deviceviewdetails.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared Filter and "+Machinename +" is entered in Device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Current time of  time zone//
		try {
			Date date = new Date();
			DateFormat dd = new SimpleDateFormat("dd");
			DateFormat MM = new SimpleDateFormat("MM");
			DateFormat YYYY = new SimpleDateFormat("yyyy");
			DateFormat hh = new SimpleDateFormat("kk");
			DateFormat mm = new SimpleDateFormat("mm");
			// Use Madrid's time zone to format the date in
			dd.setTimeZone(TimeZone.getTimeZone(TimeZone2));
			String ddc = dd.format(date);
			MM.setTimeZone(TimeZone.getTimeZone(TimeZone2));
			String MMc = MM.format(date);
			YYYY.setTimeZone(TimeZone.getTimeZone(TimeZone2));
			String YYYYc = YYYY.format(date);
			hh.setTimeZone(TimeZone.getTimeZone(TimeZone2));
			int modifyt = Integer.parseInt(hh.format(date));
			int subtractoneone = modifyt-1;
			String strI = Integer.toString(subtractoneone);
			String hhc = hh.format(date);
			mm.setTimeZone(TimeZone.getTimeZone(TimeZone2));
			String mmc = mm.format(date);
			currentime = ddc + "-" + MMc + "-" + YYYYc + " " + hhc + ":" + mmc;
			System.out.println("Current time------> "+currentime);
			int Changeofminutes=Integer.parseInt(strI);
			if (Changeofminutes<12){
				String str = Integer.toString(Changeofminutes);
				String newmin = "0"+str;
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + newmin + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone2+" is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + strI + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone2+" for validation is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to fetch current time of "+TimeZone2);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Converting month string into integer From Date//
		try {
			String Frmmonth  = new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(3,7).trim();
			String Frmdate 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(8,10);
			String Frmdyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Frmmonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				fromtime = Frmdate + "-" + strnew + "-" + Frmdyearandtime;
				System.out.println("From Date for device List-----> "+Frmdate + "-" + strnew + "-" + Frmdyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("From Date for device List-----> "+Frmdate + "-" + monthInt + "-" + Frmdyearandtime);
				fromtimecorrection = Frmdate + "-" + monthInt + "-" + Frmdyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: From Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Converting month string into integer To Date//
		try {
			String Tomonth  = new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(3,7).trim();
			String Todate 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(8,10);
			String Todyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Tomonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				totime = Todate + "-" + strnew + "-" + Todyearandtime;
				System.out.println("To Date for device List-----> "+Todate + "-" + strnew + "-" + Todyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("To Date for device List-----> "+Todate + "-" + monthInt + "-" + Todyearandtime);
				totime = Todate + "-" + monthInt + "-" + Todyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: To Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validate whether the From time and To time are set by the current timezone//
		try{
			if(differencecurrenttime.equals(fromtime)){
				System.out.println("The time is matching for From");
				test.log(Status.PASS, "Current Time from :"+TimeZone2+" - is matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			else {
				System.out.println("The time is not matching for From");
				test.log(Status.FAIL, "Current Time from :"+TimeZone2+" - is not matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(currentime.equals(totime)){
				System.out.println("The time is matching for To");
				test.log(Status.PASS, "Current Time from :"+TimeZone2+" - is matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				System.out.println("The time is not matching for To");
				test.log(Status.FAIL, "Current Time from :"+TimeZone2+" - is not matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate current time and time displayed in details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the device details page//
		try{
			new ZIFAI_RawDataPage(driver).Closebutton.click();
			test.log(Status.PASS, "Device details page is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Device details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------------End of TimeZone--------------------------------------------------------//

		//Selecting the timeZone//
		try{
			new ZIFAI_RawDataPage(driver).Timezoneselector(TimeZone3);
			test.log(Status.PASS, TimeZone3 +" is selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, TimeZone3 +" is not selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter//
		try {
			new ZIFAI_RawDataPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Filterdevicename.sendKeys(Machinename);
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Deviceviewdetails.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared Filter and "+Machinename +" is entered in Device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Current time of  time zone//
		try {
			Date date = new Date();
			DateFormat dd = new SimpleDateFormat("dd");
			DateFormat MM = new SimpleDateFormat("MM");
			DateFormat YYYY = new SimpleDateFormat("yyyy");
			DateFormat hh = new SimpleDateFormat("kk");
			DateFormat mm = new SimpleDateFormat("mm");
			// Use Madrid's time zone to format the date in
			dd.setTimeZone(TimeZone.getTimeZone(TimeZone3));
			String ddc = dd.format(date);
			MM.setTimeZone(TimeZone.getTimeZone(TimeZone3));
			String MMc = MM.format(date);
			YYYY.setTimeZone(TimeZone.getTimeZone(TimeZone3));
			String YYYYc = YYYY.format(date);
			hh.setTimeZone(TimeZone.getTimeZone(TimeZone3));
			int modifyt = Integer.parseInt(hh.format(date));
			int subtractoneone = modifyt-1;
			String strI = Integer.toString(subtractoneone);
			String hhc = hh.format(date);
			mm.setTimeZone(TimeZone.getTimeZone(TimeZone3));
			String mmc = mm.format(date);
			currentime = ddc + "-" + MMc + "-" + YYYYc + " " + hhc + ":" + mmc;
			System.out.println("Current time------> "+currentime);
			int Changeofminutes=Integer.parseInt(strI);
			if (Changeofminutes<12){
				String str = Integer.toString(Changeofminutes);
				String newmin = "0"+str;
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + newmin + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone3+" is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + strI + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone3+" for validation is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to fetch current time of "+TimeZone3);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Converting month string into integer From Date//
		try {
			String Frmmonth  = new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(3,7).trim();
			String Frmdate 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(8,10);
			String Frmdyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Frmmonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				fromtime = Frmdate + "-" + strnew + "-" + Frmdyearandtime;
				System.out.println("From Date for device List-----> "+Frmdate + "-" + strnew + "-" + Frmdyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("From Date for device List-----> "+Frmdate + "-" + monthInt + "-" + Frmdyearandtime);
				fromtimecorrection = Frmdate + "-" + monthInt + "-" + Frmdyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: From Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Converting month string into integer To Date//
		try {
			String Tomonth  = new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(3,7).trim();
			String Todate 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(8,10);
			String Todyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Tomonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				totime = Todate + "-" + strnew + "-" + Todyearandtime;
				System.out.println("To Date for device List-----> "+Todate + "-" + strnew + "-" + Todyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("To Date for device List-----> "+Todate + "-" + monthInt + "-" + Todyearandtime);
				totime = Todate + "-" + monthInt + "-" + Todyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: To Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validate whether the From time and To time are set by the current timezone//
		try{
			if(differencecurrenttime.equals(fromtime)){
				System.out.println("The time is matching for From");
				test.log(Status.PASS, "Current Time from :"+TimeZone3+" - is matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			else {
				System.out.println("The time is not matching for From");
				test.log(Status.FAIL, "Current Time from :"+TimeZone3+" - is not matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(currentime.equals(totime)){
				System.out.println("The time is matching for To");
				test.log(Status.PASS, "Current Time from :"+TimeZone3+" - is matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				System.out.println("The time is not matching for To");
				test.log(Status.FAIL, "Current Time from :"+TimeZone3+" - is not matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate current time and time displayed in details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the device details page//
		try{
			new ZIFAI_RawDataPage(driver).Closebutton.click();
			test.log(Status.PASS, "Device details page is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Device details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------------End of TimeZone--------------------------------------------------------//


		//Selecting the timeZone//
		try{
			new ZIFAI_RawDataPage(driver).Timezoneselector(TimeZone4);
			test.log(Status.PASS, TimeZone4 +" is selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, TimeZone4 +" is not selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter//
		try {
			new ZIFAI_RawDataPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Filterdevicename.sendKeys(Machinename);
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Deviceviewdetails.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared Filter and "+Machinename +" is entered in Device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Current time of  time zone//
		try {
			Date date = new Date();
			DateFormat dd = new SimpleDateFormat("dd");
			DateFormat MM = new SimpleDateFormat("MM");
			DateFormat YYYY = new SimpleDateFormat("yyyy");
			DateFormat hh = new SimpleDateFormat("kk");
			DateFormat mm = new SimpleDateFormat("mm");
			// Use Madrid's time zone to format the date in
			dd.setTimeZone(TimeZone.getTimeZone(TimeZone4));
			String ddc = dd.format(date);
			MM.setTimeZone(TimeZone.getTimeZone(TimeZone4));
			String MMc = MM.format(date);
			YYYY.setTimeZone(TimeZone.getTimeZone(TimeZone4));
			String YYYYc = YYYY.format(date);
			hh.setTimeZone(TimeZone.getTimeZone(TimeZone4));
			int modifyt = Integer.parseInt(hh.format(date));
			int subtractoneone = modifyt-1;
			String strI = Integer.toString(subtractoneone);
			String hhc = hh.format(date);
			mm.setTimeZone(TimeZone.getTimeZone(TimeZone4));
			String mmc = mm.format(date);
			currentime = ddc + "-" + MMc + "-" + YYYYc + " " + hhc + ":" + mmc;
			System.out.println("Current time------> "+currentime);
			int Changeofminutes=Integer.parseInt(strI);
			if (Changeofminutes<12){
				String str = Integer.toString(Changeofminutes);
				String newmin = "0"+str;
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + newmin + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone4+" is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + strI + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone4+" for validation is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to fetch current time of "+TimeZone4);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Converting month string into integer From Date//
		try {
			String Frmmonth  = new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(3,7).trim();
			String Frmdate 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(8,10);
			String Frmdyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Frmmonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				fromtime = Frmdate + "-" + strnew + "-" + Frmdyearandtime;
				System.out.println("From Date for device List-----> "+Frmdate + "-" + strnew + "-" + Frmdyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("From Date for device List-----> "+Frmdate + "-" + monthInt + "-" + Frmdyearandtime);
				fromtimecorrection = Frmdate + "-" + monthInt + "-" + Frmdyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: From Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Converting month string into integer To Date//
		try {
			String Tomonth  = new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(3,7).trim();
			String Todate 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(8,10);
			String Todyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Tomonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				totime = Todate + "-" + strnew + "-" + Todyearandtime;
				System.out.println("To Date for device List-----> "+Todate + "-" + strnew + "-" + Todyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("To Date for device List-----> "+Todate + "-" + monthInt + "-" + Todyearandtime);
				totime = Todate + "-" + monthInt + "-" + Todyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: To Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validate whether the From time and To time are set by the current timezone//
		try{
			if(differencecurrenttime.equals(fromtime)){
				System.out.println("The time is matching for From");
				test.log(Status.PASS, "Current Time from :"+TimeZone4+" - is matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			else {
				System.out.println("The time is not matching for From");
				test.log(Status.FAIL, "Current Time from :"+TimeZone4+" - is not matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(currentime.equals(totime)){
				System.out.println("The time is matching for To");
				test.log(Status.PASS, "Current Time from :"+TimeZone4+" - is matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				System.out.println("The time is not matching for To");
				test.log(Status.FAIL, "Current Time from :"+TimeZone4+" - is not matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate current time and time displayed in details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the device details page//
		try{
			new ZIFAI_RawDataPage(driver).Closebutton.click();
			test.log(Status.PASS, "Device details page is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Device details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------------End of TimeZone--------------------------------------------------------//



		//Selecting the timeZone//
		try{
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Timezoneselector(TimeZone5);
			test.log(Status.PASS, TimeZone5 +" is selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, TimeZone5 +" is not selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter//
		try {
			new ZIFAI_RawDataPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Filterdevicename.sendKeys(Machinename);
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Deviceviewdetails.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared Filter and "+Machinename +" is entered in Device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Current time of  time zone//
		try {
			Date date = new Date();
			DateFormat dd = new SimpleDateFormat("dd");
			DateFormat MM = new SimpleDateFormat("MM");
			DateFormat YYYY = new SimpleDateFormat("yyyy");
			DateFormat hh = new SimpleDateFormat("kk");
			DateFormat mm = new SimpleDateFormat("mm");
			// Use Madrid's time zone to format the date in
			dd.setTimeZone(TimeZone.getTimeZone(TimeZone5));
			String ddc = dd.format(date);
			MM.setTimeZone(TimeZone.getTimeZone(TimeZone5));
			String MMc = MM.format(date);
			YYYY.setTimeZone(TimeZone.getTimeZone(TimeZone5));
			String YYYYc = YYYY.format(date);
			hh.setTimeZone(TimeZone.getTimeZone(TimeZone5));
			int modifyt = Integer.parseInt(hh.format(date));
			int subtractoneone = modifyt-1;
			String strI = Integer.toString(subtractoneone);
			String hhc = hh.format(date);
			mm.setTimeZone(TimeZone.getTimeZone(TimeZone5));
			String mmc = mm.format(date);
			currentime = ddc + "-" + MMc + "-" + YYYYc + " " + hhc + ":" + mmc;
			System.out.println("Current time------> "+currentime);
			int Changeofminutes=Integer.parseInt(strI);
			if (Changeofminutes<12){
				String str = Integer.toString(Changeofminutes);
				String newmin = "0"+str;
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + newmin + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone5+" is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + strI + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone5+" for validation is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to fetch current time of "+TimeZone5);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Converting month string into integer From Date//
		try {
			String Frmmonth  = new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(3,7).trim();
			String Frmdate 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(8,10);
			String Frmdyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Frmmonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				fromtime = Frmdate + "-" + strnew + "-" + Frmdyearandtime;
				System.out.println("From Date for device List-----> "+Frmdate + "-" + strnew + "-" + Frmdyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("From Date for device List-----> "+Frmdate + "-" + monthInt + "-" + Frmdyearandtime);
				fromtimecorrection = Frmdate + "-" + monthInt + "-" + Frmdyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: From Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Converting month string into integer To Date//
		try {
			String Tomonth  = new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(3,7).trim();
			String Todate 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(8,10);
			String Todyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Tomonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				totime = Todate + "-" + strnew + "-" + Todyearandtime;
				System.out.println("To Date for device List-----> "+Todate + "-" + strnew + "-" + Todyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("To Date for device List-----> "+Todate + "-" + monthInt + "-" + Todyearandtime);
				totime = Todate + "-" + monthInt + "-" + Todyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: To Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validate whether the From time and To time are set by the current timezone//
		try{
			if(differencecurrenttime.equals(fromtime)){
				System.out.println("The time is matching for From");
				test.log(Status.PASS, "Current Time from :"+TimeZone5+" - is matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			else {
				System.out.println("The time is not matching for From");
				test.log(Status.FAIL, "Current Time from :"+TimeZone5+" - is not matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(currentime.equals(totime)){
				System.out.println("The time is matching for To");
				test.log(Status.PASS, "Current Time from :"+TimeZone5+" - is matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				System.out.println("The time is not matching for To");
				test.log(Status.FAIL, "Current Time from :"+TimeZone5+" - is not matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate current time and time displayed in details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the device details page//
		try{
			new ZIFAI_RawDataPage(driver).Closebutton.click();
			test.log(Status.PASS, "Device details page is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Device details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------------End of TimeZone--------------------------------------------------------//

		//Selecting the timeZone//
		try{
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Timezoneselector(TimeZone6);
			test.log(Status.PASS, TimeZone6 +" is selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, TimeZone6 +" is not selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter//
		try {
			new ZIFAI_RawDataPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Filterdevicename.sendKeys(Machinename);
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Deviceviewdetails.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared Filter and "+Machinename +" is entered in Device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Current time of  time zone//
		try {
			Date date = new Date();
			DateFormat dd = new SimpleDateFormat("dd");
			DateFormat MM = new SimpleDateFormat("MM");
			DateFormat YYYY = new SimpleDateFormat("yyyy");
			DateFormat hh = new SimpleDateFormat("kk");
			DateFormat mm = new SimpleDateFormat("mm");
			// Use Madrid's time zone to format the date in
			dd.setTimeZone(TimeZone.getTimeZone(TimeZone6));
			String ddc = dd.format(date);
			MM.setTimeZone(TimeZone.getTimeZone(TimeZone6));
			String MMc = MM.format(date);
			YYYY.setTimeZone(TimeZone.getTimeZone(TimeZone6));
			String YYYYc = YYYY.format(date);
			hh.setTimeZone(TimeZone.getTimeZone(TimeZone6));
			int modifyt = Integer.parseInt(hh.format(date));
			int subtractoneone = modifyt-1;
			String strI = Integer.toString(subtractoneone);
			String hhc = hh.format(date);
			mm.setTimeZone(TimeZone.getTimeZone(TimeZone6));
			String mmc = mm.format(date);
			currentime = ddc + "-" + MMc + "-" + YYYYc + " " + hhc + ":" + mmc;
			System.out.println("Current time------> "+currentime);
			int Changeofminutes=Integer.parseInt(strI);
			if (Changeofminutes<12){
				String str = Integer.toString(Changeofminutes);
				String newmin = "0"+str;
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + newmin + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone6+" is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + strI + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone6+" for validation is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to fetch current time of "+TimeZone6);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Converting month string into integer From Date//
		try {
			String Frmmonth  = new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(3,7).trim();
			String Frmdate 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(8,10);
			String Frmdyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Frmmonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				fromtime = Frmdate + "-" + strnew + "-" + Frmdyearandtime;
				System.out.println("From Date for device List-----> "+Frmdate + "-" + strnew + "-" + Frmdyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("From Date for device List-----> "+Frmdate + "-" + monthInt + "-" + Frmdyearandtime);
				fromtimecorrection = Frmdate + "-" + monthInt + "-" + Frmdyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: From Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Converting month string into integer To Date//
		try {
			String Tomonth  = new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(3,7).trim();
			String Todate 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(8,10);
			String Todyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Tomonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				totime = Todate + "-" + strnew + "-" + Todyearandtime;
				System.out.println("To Date for device List-----> "+Todate + "-" + strnew + "-" + Todyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("To Date for device List-----> "+Todate + "-" + monthInt + "-" + Todyearandtime);
				totime = Todate + "-" + monthInt + "-" + Todyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: To Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validate whether the From time and To time are set by the current timezone//
		try{
			if(differencecurrenttime.equals(fromtime)){
				System.out.println("The time is matching for From");
				test.log(Status.PASS, "Current Time from :"+TimeZone6+" - is matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			else {
				System.out.println("The time is not matching for From");
				test.log(Status.FAIL, "Current Time from :"+TimeZone6+" - is not matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(currentime.equals(totime)){
				System.out.println("The time is matching for To");
				test.log(Status.PASS, "Current Time from :"+TimeZone6+" - is matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				System.out.println("The time is not matching for To");
				test.log(Status.FAIL, "Current Time from :"+TimeZone6+" - is not matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate current time and time displayed in details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the device details page//
		try{
			new ZIFAI_RawDataPage(driver).Closebutton.click();
			test.log(Status.PASS, "Device details page is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Device details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//------------------------------------------End of TimeZone--------------------------------------------------------//

		//Selecting the timeZone//
		try{
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Timezoneselector(TimeZone8);
			test.log(Status.PASS, TimeZone8 +" is selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, TimeZone8 +" is not selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter//
		try {
			new ZIFAI_RawDataPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Filterdevicename.sendKeys(Machinename);
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Deviceviewdetails.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared Filter and "+Machinename +" is entered in Device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Current time of  time zone//
		try {
			Date date = new Date();
			DateFormat dd = new SimpleDateFormat("dd");
			DateFormat MM = new SimpleDateFormat("MM");
			DateFormat YYYY = new SimpleDateFormat("yyyy");
			DateFormat hh = new SimpleDateFormat("kk");
			DateFormat mm = new SimpleDateFormat("mm");
			// Use Madrid's time zone to format the date in
			dd.setTimeZone(TimeZone.getTimeZone(TimeZone8));
			String ddc = dd.format(date);
			MM.setTimeZone(TimeZone.getTimeZone(TimeZone8));
			String MMc = MM.format(date);
			YYYY.setTimeZone(TimeZone.getTimeZone(TimeZone8));
			String YYYYc = YYYY.format(date);
			hh.setTimeZone(TimeZone.getTimeZone(TimeZone8));
			int modifyt = Integer.parseInt(hh.format(date));
			int subtractoneone = modifyt-1;
			String strI = Integer.toString(subtractoneone);
			String hhc = hh.format(date);
			mm.setTimeZone(TimeZone.getTimeZone(TimeZone8));
			String mmc = mm.format(date);
			currentime = ddc + "-" + MMc + "-" + YYYYc + " " + hhc + ":" + mmc;
			System.out.println("Current time------> "+currentime);
			int Changeofminutes=Integer.parseInt(strI);
			if (Changeofminutes<12){
				String str = Integer.toString(Changeofminutes);
				String newmin = "0"+str;
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + newmin + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone8+" is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + strI + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone8+" for validation is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to fetch current time of "+TimeZone8);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Converting month string into integer From Date//
		try {
			String Frmmonth  = new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(3,7).trim();
			String Frmdate 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(8,10);
			String Frmdyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Frmmonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				fromtime = Frmdate + "-" + strnew + "-" + Frmdyearandtime;
				System.out.println("From Date for device List-----> "+Frmdate + "-" + strnew + "-" + Frmdyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("From Date for device List-----> "+Frmdate + "-" + monthInt + "-" + Frmdyearandtime);
				fromtimecorrection = Frmdate + "-" + monthInt + "-" + Frmdyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: From Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Converting month string into integer To Date//
		try {
			String Tomonth  = new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(3,7).trim();
			String Todate 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(8,10);
			String Todyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Tomonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				totime = Todate + "-" + strnew + "-" + Todyearandtime;
				System.out.println("To Date for device List-----> "+Todate + "-" + strnew + "-" + Todyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("To Date for device List-----> "+Todate + "-" + monthInt + "-" + Todyearandtime);
				totime = Todate + "-" + monthInt + "-" + Todyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: To Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validate whether the From time and To time are set by the current timezone//
		try{
			if(differencecurrenttime.equals(fromtime)){
				System.out.println("The time is matching for From");
				test.log(Status.PASS, "Current Time from :"+TimeZone8+" - is matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			else {
				System.out.println("The time is not matching for From");
				test.log(Status.FAIL, "Current Time from :"+TimeZone8+" - is not matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(currentime.equals(totime)){
				System.out.println("The time is matching for To");
				test.log(Status.PASS, "Current Time from :"+TimeZone8+" - is matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				System.out.println("The time is not matching for To");
				test.log(Status.FAIL, "Current Time from :"+TimeZone8+" - is not matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate current time and time displayed in details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the device details page//
		try{
			new ZIFAI_RawDataPage(driver).Closebutton.click();
			test.log(Status.PASS, "Device details page is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Device details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//-----------------------------------End of TimeZone---------------------------------------------//



		//Selecting the timeZone//
		try{
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Timezoneselector(TimeZone9);
			test.log(Status.PASS, TimeZone9 +" is selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, TimeZone9 +" is not selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter//
		try {
			new ZIFAI_RawDataPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Filterdevicename.sendKeys(Machinename);
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Deviceviewdetails.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared Filter and "+Machinename +" is entered in Device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Current time of  time zone//
		try {
			Date date = new Date();
			DateFormat dd = new SimpleDateFormat("dd");
			DateFormat MM = new SimpleDateFormat("MM");
			DateFormat YYYY = new SimpleDateFormat("yyyy");
			DateFormat hh = new SimpleDateFormat("kk");
			DateFormat mm = new SimpleDateFormat("mm");
			// Use Madrid's time zone to format the date in
			dd.setTimeZone(TimeZone.getTimeZone(TimeZone9));
			String ddc = dd.format(date);
			MM.setTimeZone(TimeZone.getTimeZone(TimeZone9));
			String MMc = MM.format(date);
			YYYY.setTimeZone(TimeZone.getTimeZone(TimeZone9));
			String YYYYc = YYYY.format(date);
			hh.setTimeZone(TimeZone.getTimeZone(TimeZone9));
			int modifyt = Integer.parseInt(hh.format(date));
			int subtractoneone = modifyt-1;
			String strI = Integer.toString(subtractoneone);
			String hhc = hh.format(date);
			mm.setTimeZone(TimeZone.getTimeZone(TimeZone9));
			String mmc = mm.format(date);
			currentime = ddc + "-" + MMc + "-" + YYYYc + " " + hhc + ":" + mmc;
			System.out.println("Current time------> "+currentime);
			int Changeofminutes=Integer.parseInt(strI);
			if (Changeofminutes<12){
				String str = Integer.toString(Changeofminutes);
				String newmin = "0"+str;
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + newmin + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone9+" is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + strI + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone9+" for validation is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to fetch current time of "+TimeZone9);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Converting month string into integer From Date//
		try {
			String Frmmonth  = new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(3,7).trim();
			String Frmdate 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(8,10);
			String Frmdyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Frmmonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				fromtime = Frmdate + "-" + strnew + "-" + Frmdyearandtime;
				System.out.println("From Date for device List-----> "+Frmdate + "-" + strnew + "-" + Frmdyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("From Date for device List-----> "+Frmdate + "-" + monthInt + "-" + Frmdyearandtime);
				fromtimecorrection = Frmdate + "-" + monthInt + "-" + Frmdyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: From Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Converting month string into integer To Date//
		try {
			String Tomonth  = new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(3,7).trim();
			String Todate 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(8,10);
			String Todyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Tomonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				totime = Todate + "-" + strnew + "-" + Todyearandtime;
				System.out.println("To Date for device List-----> "+Todate + "-" + strnew + "-" + Todyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("To Date for device List-----> "+Todate + "-" + monthInt + "-" + Todyearandtime);
				totime = Todate + "-" + monthInt + "-" + Todyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: To Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validate whether the From time and To time are set by the current timezone//
		try{
			if(differencecurrenttime.equals(fromtime)){
				System.out.println("The time is matching for From");
				test.log(Status.PASS, "Current Time from :"+TimeZone9+" - is matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			else {
				System.out.println("The time is not matching for From");
				test.log(Status.FAIL, "Current Time from :"+TimeZone9+" - is not matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(currentime.equals(totime)){
				System.out.println("The time is matching for To");
				test.log(Status.PASS, "Current Time from :"+TimeZone9+" - is matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				System.out.println("The time is not matching for To");
				test.log(Status.FAIL, "Current Time from :"+TimeZone9+" - is not matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate current time and time displayed in details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the device details page//
		try{
			new ZIFAI_RawDataPage(driver).Closebutton.click();
			test.log(Status.PASS, "Device details page is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Device details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//--------------------------------End of TimeZone----------------------------------------------//

		//Selecting the timeZone//
		try{
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Timezoneselector(TimeZone10);
			test.log(Status.PASS, TimeZone10 +" is selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}catch (Exception e){
			test.log(Status.FAIL, TimeZone10 +" is not selected from Timezone dropdown");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Clear Filter//
		try {
			new ZIFAI_RawDataPage(driver).Filtericon.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterClear.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Filterdevicename.sendKeys(Machinename);
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).FilterApply.click();
			Thread.sleep(3000);
			new ZIFAI_RawDataPage(driver).Deviceviewdetails.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Cleared Filter and "+Machinename +" is entered in Device name");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to clear filter "+e);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Current time of  time zone//
		try {
			Date date = new Date();
			DateFormat dd = new SimpleDateFormat("dd");
			DateFormat MM = new SimpleDateFormat("MM");
			DateFormat YYYY = new SimpleDateFormat("yyyy");
			DateFormat hh = new SimpleDateFormat("kk");
			DateFormat mm = new SimpleDateFormat("mm");
			// Use Madrid's time zone to format the date in
			dd.setTimeZone(TimeZone.getTimeZone(TimeZone10));
			String ddc = dd.format(date);
			MM.setTimeZone(TimeZone.getTimeZone(TimeZone10));
			String MMc = MM.format(date);
			YYYY.setTimeZone(TimeZone.getTimeZone(TimeZone10));
			String YYYYc = YYYY.format(date);
			hh.setTimeZone(TimeZone.getTimeZone(TimeZone10));
			int modifyt = Integer.parseInt(hh.format(date));
			int subtractoneone = modifyt-1;
			String strI = Integer.toString(subtractoneone);
			String hhc = hh.format(date);
			mm.setTimeZone(TimeZone.getTimeZone(TimeZone10));
			String mmc = mm.format(date);
			currentime = ddc + "-" + MMc + "-" + YYYYc + " " + hhc + ":" + mmc;
			System.out.println("Current time------> "+currentime);
			int Changeofminutes=Integer.parseInt(strI);
			if (Changeofminutes<12){
				String str = Integer.toString(Changeofminutes);
				String newmin = "0"+str;
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + newmin + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone10+" is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				differencecurrenttime = ddc + "-" + MMc + "-" + YYYYc + " " + strI + ":" + mmc;
				System.out.println("Difference in Current Time-----> "+differencecurrenttime);
				test.log(Status.PASS, "Current Time "+TimeZone10+" for validation is fetched");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to fetch current time of "+TimeZone10);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}

		//Converting month string into integer From Date//
		try {
			String Frmmonth  = new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(3,7).trim();
			String Frmdate 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(8,10);
			String Frmdyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceFromdate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Frmmonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				fromtime = Frmdate + "-" + strnew + "-" + Frmdyearandtime;
				System.out.println("From Date for device List-----> "+Frmdate + "-" + strnew + "-" + Frmdyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("From Date for device List-----> "+Frmdate + "-" + monthInt + "-" + Frmdyearandtime);
				fromtimecorrection = Frmdate + "-" + monthInt + "-" + Frmdyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: From Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: From Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Converting month string into integer To Date//
		try {
			String Tomonth  = new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(3,7).trim();
			String Todate 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(8,10);
			String Todyearandtime 	= new ZIFAI_RawDataPage(driver).DeviceTodate.getText().substring(11,21);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("MMM").parse(Tomonth));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			if (monthInt<12){
				String str = Integer.toString(monthInt);
				String strnew = "0"+str;
				totime = Todate + "-" + strnew + "-" + Todyearandtime;
				System.out.println("To Date for device List-----> "+Todate + "-" + strnew + "-" + Todyearandtime);
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else{
				System.out.println("To Date for device List-----> "+Todate + "-" + monthInt + "-" + Todyearandtime);
				totime = Todate + "-" + monthInt + "-" + Todyearandtime;
				test.log(Status.PASS, "Converted Month String into integer: To Date");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to convert Month String into integer: To Date");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}


		//Validate whether the From time and To time are set by the current timezone//
		try{
			if(differencecurrenttime.equals(fromtime)){
				System.out.println("The time is matching for From");
				test.log(Status.PASS, "Current Time from :"+TimeZone10+" - is matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}

			else {
				System.out.println("The time is not matching for From");
				test.log(Status.FAIL, "Current Time from :"+TimeZone10+" - is not matching the From Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			if(currentime.equals(totime)){
				System.out.println("The time is matching for To");
				test.log(Status.PASS, "Current Time from :"+TimeZone10+" - is matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			else {
				System.out.println("The time is not matching for To");
				test.log(Status.FAIL, "Current Time from :"+TimeZone10+" - is not matching the To Date in device details page");
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
		}catch (Exception e){
			test.log(Status.FAIL, "Unable to validate current time and time displayed in details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));

		}

		//Closing the device details page//
		try{
			new ZIFAI_RawDataPage(driver).Closebutton.click();
			test.log(Status.PASS, "Device details page is closed");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		catch (Exception e){
			test.log(Status.FAIL, "Unable to close Device details page");
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
		//--------------------------------End of TimeZone----------------------------------------------//





	}
}


