package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Pages.ZIFAI_MonitoringPage;
import com.zifautomation.RestAssured.BaseAPI;
import com.zifautomation.Utility.PropertiesFileReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ZIF_Monitoring_US4554_Regression extends BaseAPI {

	PropertiesFileReader obj = new PropertiesFileReader();
	Properties prop = new Properties();
	@Test
	public void ZIF_Monitoring_US4554_Regression() throws IOException {
		test = extent.createTest("User Story 4554: APi Capacity Details -CPU, Disk and Memory");
		test.createNode("User Story 4554: APi Capacity Details -CPU, Disk and Memory");


		//Buffer reader to read the property file//
		Properties properties = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\testdata-config.properties"));
		properties.load(reader);
		reader.close();

		//Declaration of reuse property//
		String authorization = properties.getProperty("api.authorization");
		String name = properties.getProperty("api.name");
		String reportname = properties.getProperty("api.reportname");

		FileOutputStream fis = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\Apidata.properties");


		BaseAPI Baseapist = new BaseAPI();
		Baseapist.preCondition();

		//**Resources - To be entered in property file and header**//
		//	-	fetchDiskCapacityDetailWindows
		//  -	fetchCpuCapacityDetails
		//  - 	fetchMemoryCapacityDetails

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);


		//Map object for CPU capactity details//
		Map<String, String> allCPU = new HashMap<String, String>();
		allCPU.put("objId", "Monitor");
		allCPU.put("machine_name", "200411LTP1157");
		allCPU.put("time", "2021-09-16T10:16:15Z");
		allCPU.put("timeTo", "2021-09-16T11:16:15Z");

		//map object for Disk capacity details//
		Map<String, String> allDisk = new HashMap<String, String>();
		allDisk.put("objId", "monitor");
		allDisk.put("machine_name", "200411LTP1157");
		allDisk.put("os_type", "Windows");
		allDisk.put("time", "2021-09-16T10:16:15Z");
		allDisk.put("timeTo", "2021-09-16T11:16:15Z");


		//map object for Memory capacity details//
		Map<String, String> allMemory = new HashMap<String, String>();
		allMemory.put("objId", "Monitor");
		allMemory.put("machine_name", "200411LTP1157");
		allMemory.put("time", "2021-09-16T10:16:15Z");
		allMemory.put("timeTo", "2021-09-16T11:16:15Z");


		Response response = RestAssured
				.given()
				.log()
				.all()
				.params(allMemory)
				.headers(allheaders)
				.get();
		System.out.println(response.getStatusCode());
		int statuscodeq = response.getStatusCode();
		String valuej = response.prettyPrint();
		if (statuscodeq == 200) {
			test.log(Status.PASS, reportname+" value is Successfully retrieved " + response.getStatusCode());
			test.pass(MarkupHelper.createCodeBlock(valuej, CodeLanguage.JSON));
		} else {
			test.log(Status.FAIL, reportname+" Value retrieval is not successful " + response.getStatusCode());
		}

		ArrayList<String> statuscode = new ArrayList<>();
		String valuejk = response.prettyPrint();
		String Xpathone = valuejk.substring(32, valuej.length() - 8).replace(":","").trim();
		System.out.println("Xpath:"+Xpathone);
		statuscode.add(valuej);
		prop.setProperty("SYS.ID", String.valueOf(Xpathone));
		prop.store(fis, null);

	}

}