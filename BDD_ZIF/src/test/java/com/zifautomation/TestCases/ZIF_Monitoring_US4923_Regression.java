package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import com.zifautomation.RestAssured.BaseAPI;
import com.zifautomation.Utility.PropertiesFileReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ZIF_Monitoring_US4923_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US4923_Regression() throws IOException {
		test = extent.createTest("User Story 4923: API- GIA for Capacity windows ( Disk and storage ) and polling Engine");
		test.createNode("User Story 4923: API- GIA for Capacity windows ( Disk and storage ) and polling Engine");



		//Buffer reader to read the property file//
		Properties properties = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\testdata-config.properties"));
		properties.load(reader);
		reader.close();

		//Declaration of reuse property//
		String authorization = properties.getProperty("api.authorization");
		String name = properties.getProperty("api.name");
		String reportname = properties.getProperty("api.reportname");
		BaseAPI Baseapist = new BaseAPI();
		Baseapist.preCondition();



//		**Resources** - To be entered in property file and header **
//		fetchAllDiskDetails
//		fetchCPUDetails
//		fetchMemoryDetails
//		fetchStorageDetailsWindows
//		fetchDiskCapacityDetailWindows
//
//		*Read me*
//		Pass the method name in property file and class file
//		Report name should be passed in property file

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);


		//Map object for AllDiskDetails details//
		Map<String, String> allDiskdetails = new HashMap<String, String>();
		allDiskdetails.put("objId", "monitor");
		allDiskdetails.put("machine_name", "200411LTP1157");
		allDiskdetails.put("os_type", "windows");
		allDiskdetails.put("time", "2021-09-16T12:48:01Z");
		allDiskdetails.put("timeTo", "2021-09-16T13:48:01Z");

		//Map object for CPUDetails details//
		Map<String, String> CPUDetails = new HashMap<String, String>();
		CPUDetails.put("objId", "monitor");
		CPUDetails.put("machine_name", "200411LTP1157");
		CPUDetails.put("time", "2021-09-16T12:48:01Z");
		CPUDetails.put("timeTo", "2021-09-16T13:48:01Z");


		//Map object for MemoryDetails details//
		Map<String, String> MemoryDetails = new HashMap<String, String>();
		MemoryDetails.put("objId", "Monitor");
		MemoryDetails.put("machine_name", "200411LTP1157");
		MemoryDetails.put("time", "2021-09-16T12:48:01Z");
		MemoryDetails.put("timeTo", "2021-09-16T13:48:01Z");

		//Map object for StorageDetailsWindows details//
		Map<String, String> StorageDetailsWindows = new HashMap<String, String>();
		StorageDetailsWindows.put("objId", "monitor");
		StorageDetailsWindows.put("machine_name", "200411LTP1157");
		StorageDetailsWindows.put("os_type", "windows");
		StorageDetailsWindows.put("time", "2021-09-16T12:48:01Z");
		StorageDetailsWindows.put("timeTo", "2021-09-16T13:48:01Z");

		//Map object for DiskCapacityDetailWindows details//
		Map<String, String> DiskCapacityDetailWindows = new HashMap<String, String>();
		DiskCapacityDetailWindows.put("objId", "monitor");
		DiskCapacityDetailWindows.put("machine_name", "200411LTP1157");
		DiskCapacityDetailWindows.put("os_type", "windows");
		DiskCapacityDetailWindows.put("time", "2021-09-16T12:48:01Z");
		DiskCapacityDetailWindows.put("timeTo", "2021-09-16T13:48:01Z");

		response = reqSpec.get();
		Response response = RestAssured
				.given()
				.log()
				.all()
				.params(DiskCapacityDetailWindows)
				.headers(allheaders)
				.get();
		System.out.println(response.getStatusCode());
		int statuscodeq = response.getStatusCode();
		String valuej = response.prettyPrint();
		if (statuscodeq == 200) {
			test.log(Status.PASS, reportname +"  "+"value is Successfully retrieved. "+"Status Code:-" +response.getStatusCode() +". "+"\n " +"\n" +"Response:  ");
			test.pass(MarkupHelper.createCodeBlock(valuej, CodeLanguage.JSON));
		} else {
			test.log(Status.FAIL, reportname +"  "+" value retrieval is not successful. "+"Status Code:-" +response.getStatusCode()+".  "+"\n " +"\n" +"Response:  " +valuej);
		}
	}

}