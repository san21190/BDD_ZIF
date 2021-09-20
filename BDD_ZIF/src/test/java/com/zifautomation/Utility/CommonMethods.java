package com.zifautomation.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonMethods {
	WebDriver driver = null;

	public CommonMethods(WebDriver webdriver) {
		driver = webdriver;
	}

	public static String componentName;

	//    public static void ScrollUp()
	//    {
	//        ((JavascriptExecutor) getWebDriver()).executeScript("scroll(0,-250)","");
	//    }

	public static void deleteOldArtifact(String filePath) {
		try {
			FileUtils.deleteDirectory(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteAllFilesInFolder(String filePath) {
		try {
			FileUtils.cleanDirectory(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String currentWorkingFolder() {
		String workingFolder = System.getProperty("user.dir");
		return workingFolder;
	}

	public static void createNewFolder(String filePath) {
		File theDir = new File(filePath);
		if (!theDir.exists()) {
			try {
				theDir.mkdir();
			} catch (SecurityException se) {
				se.printStackTrace();
			}
		}
	}

	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
			 System.out.println(fileName + " is present");
		}

		return flag;
	}

	public static boolean isFileDownloadedExt(String dirPath, String ext) {
		boolean flag = false;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().contains(ext)) {
				flag = true;
			}
		}
		return flag;
	}

	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return date != null;
	}

	public static boolean isThisDateValid(String dateToValidate, String dateFormat){

		if(dateToValidate == null){
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);

		try {

			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (ParseException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static String generateRandomNumber(int length) {
		String sKey = "";
		Random random = new Random();
		long r1 = random.nextLong();

		r1 = Math.abs(r1);
		sKey = String.valueOf(r1);
		if (sKey.length() > length) {
			sKey = sKey.substring(0, length);
		} else if (sKey.length() < length) {
			sKey = sKey + sKey;
			sKey = sKey.substring(0, length);
		}

		return sKey.toString();

	}


	public String  generateRandomChar() {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		String sKey = "";
		int length=7;
		Random random = new Random();
		char[] text =new char[length];

		for(int i=0;i<length;i++)
		{
			text[i]=chars.charAt(random.nextInt(chars.length()));
		}
		for(int i=0;i< text.length;i++) {
			sKey += text[i];
		}
		return sKey;

	}
	/**
	 * Function to check broken the links
	 * 
	 * @param Url
	 */
	public void brokenLinkValidator(String Url) {
		try 
		{
			URL Linkurl = new URL(Url);

			HttpURLConnection httpURLConnect=(HttpURLConnection)Linkurl.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if(httpURLConnect.getResponseCode()==200)
			{
				System.out.println(Url+" - "+httpURLConnect.getResponseMessage());
			}
			if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
			{
				System.out.println(Url+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}

	public void highLighterMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}

	public void MovetoElement(WebElement element){
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

	public void filenamechange() throws Exception {
		boolean bool = false;

		try {
			File Filename = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Cases-Correlation  .csv");
			File FilenameSupression = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Cases-Suppression  .csv");
			File FilenameAlerts = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Alerts.csv");
			File FilenameDiscovery = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\GTMDICV500.csv");
			File FilenamePrediction = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\OpportunitiesList .csv");

			bool = FilenameDiscovery.exists();

			if (bool) {
				String FilenameDiscoveryverification = Filename.getName().replaceAll("GTMDICV500", "").replaceAll(".csv", "").trim();
				System.out.println("FilenameDiscoveryverification:" + FilenameDiscoveryverification);
				File oldName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\GTMDICV500.csv");
				File newName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Cases  .csv");
				oldName.renameTo(newName);
			}


			bool = FilenamePrediction.exists();

			if (bool) {
				String FilenamePredictionverification = Filename.getName().replaceAll("OpportunitiesList ", "").replaceAll(".csv", "").trim();
				System.out.println("FilenamePredictionverification:" + FilenamePredictionverification);
				File oldName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\OpportunitiesList .csv");
				File newName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Cases  .csv");
				oldName.renameTo(newName);
			}


			bool = Filename.exists();

			if (bool) {
				String Filenameverification = Filename.getName().replaceAll("Cases-", "").replaceAll(".csv", "").trim();
				System.out.println("Filenameverification:" + Filenameverification);
				File oldName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Cases-Correlation  .csv");
				File newName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Cases  .csv");
				oldName.renameTo(newName);
			}

			bool = FilenameSupression.exists();

			if (bool) {
				String FilenameSupressionverification = FilenameSupression.getName().replaceAll("Cases-", "").replaceAll(".csv", "").trim();
				System.out.println("FilenameSupressionverification:" + FilenameSupressionverification);
				File oldName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Cases-Suppression  .csv");
				File newName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Cases  .csv");
				oldName.renameTo(newName);
			}


			bool = FilenameAlerts.exists();

			if (bool) {
				String Filenameverification = FilenameAlerts.getName().replaceAll(".csv", "").trim();
				System.out.println("Filenameverification:" + Filenameverification);
				File oldName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Alerts.csv");
				File newName = new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\Cases.csv");
				oldName.renameTo(newName);
			}

		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}


	@SuppressWarnings({ "deprecation", "resource" })
	public void ConnectMangoDB(){
		try{   
			//Connecting to the mongoDB instance
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

			//Selecting the database
			DB db = mongoClient.getDB("dbName");

			//Selecting the collection
			DBCollection dbCollection = db.getCollection("collectionName");

			//Setting search query with the required key-value pair
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("key", "value");

			//DBCursor with the find query result
			DBCursor cursor = dbCollection.find(searchQuery);

			//Fetching the response
			String response = null; 
			try {
				while(cursor.hasNext()) {
					response = response.concat(cursor.next().toString());
				}
			} 
			finally { 
				cursor.close();
			}

			//Asserting the fetched response with expected value
			Assert.assertTrue(response.contains("ExpectedValue"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}




	}

	
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


