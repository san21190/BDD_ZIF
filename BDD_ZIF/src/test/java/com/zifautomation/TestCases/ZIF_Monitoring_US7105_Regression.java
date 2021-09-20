package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mongodb.client.FindIterable;
import com.zifautomation.RestAssured.BaseAPI;
import com.zifautomation.Utility.MongoQueryManager;
import com.zifautomation.Utility.PropertiesFileReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.bson.Document;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ZIF_Monitoring_US7105_Regression extends BaseAPI {

	PropertiesFileReader obj = new PropertiesFileReader();
	Properties prop = new Properties();
	@Test
	public void ZIF_Monitoring_US7105_Regression() throws IOException {
		test = extent.createTest("User Story 7105: API - Count inclusion for process calculations and add machine API changes for persistent and non-persistent machine.");
		test.createNode("User Story 7105: API - Count inclusion for process calculations and add machine API changes for persistent and non-persistent machine.");


		//Buffer reader to read the property file//
		Properties properties = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\testdata-config.properties"));
		properties.load(reader);
		reader.close();

		//Declaration of reuse property//
		String authorization = properties.getProperty("api.authorization");
		String name = properties.getProperty("api.name");
		String reportname = properties.getProperty("api.reportname");
		String accept = properties.getProperty("api.accept");
		String Contenttype = properties.getProperty("api.Content-Type");

		FileOutputStream fis = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\Apidata.properties");


		BaseAPI Baseapist = new BaseAPI();
		Baseapist.preCondition();

		//**Resources - To be entered in property file and header**//
		//	-	fetchProcessMemCpu - GET
		//  -	addMachineDetails - POST


		//Sample API for addMachineDetails
		//{
		//    "machine_name": "251711LTQ7875",
		//    "machine_type": "windows",
		//    "ip_address": "192.179.4.6",
		//    "type": "Physical machine"
		//}

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);
		allheaders.put("accept",accept);
		allheaders.put("Content-Type",Contenttype);


		//Map object for fetchProcessMemCpu details//
		Map<String, String> allprocessmemcpu = new HashMap<String, String>();
		allprocessmemcpu.put("objId", "monitor");
		allprocessmemcpu.put("machine_name", "200411LTP1157");
		allprocessmemcpu.put("os_type", "windows");
		allprocessmemcpu.put("output_type", "process");
		allprocessmemcpu.put("time", "2021-08-06T10:50:43Z");
		allprocessmemcpu.put("timeTo", "2021-08-06T11:50:43Z");


		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(allheaders)
				.body("{\n" +
				"\"machine_name\":\"251711PTY7876\",\n" +
				"\"machine_type\":\"windows\",\n" +
				"\"ip_address\":\"192.179.4.7\",\n" +
				"\"type\":\"Physical machine\"\n" +
				"}")
				.post();
		System.out.println(response.getStatusCode());
		int statuscodeq = response.getStatusCode();
		String valuej = response.prettyPrint();
		if (statuscodeq == 200) {
			test.log(Status.PASS, reportname+" value is Successfully retrieved " + response.getStatusCode());
			test.pass(MarkupHelper.createCodeBlock(valuej, CodeLanguage.JSON));
		} else {
			test.log(Status.FAIL, reportname+" Value retrieval is not successful " + response.getStatusCode());
		}


		//Initializing url and name of mongo DB//
		String url = properties.getProperty("db.url");
		String db = properties.getProperty("db.name");

		//Validate add machine details using mongo DB collection//
		MongoQueryManager mongoQueryManager = new MongoQueryManager(url, db);
		Map<String, String> fields = new HashMap<String, String>();
		fields.put("machine_name", "251711PTY7876");
		fields.put("ip_address","192.179.4.7");
		FindIterable<Document> documents = mongoQueryManager.getDocumentsWithFields("machine_details", fields);
		for (Document doc : documents) {
			boolean value = doc.isEmpty();
			if (value) {
				test.log(Status.FAIL, "Data records found for add machine details");
				System.out.println("Value is present in the particular collection" + doc);
			}  else {
				test.log(Status.PASS, "Data records found for add machine details in mongo DB");
				System.out.println("Value is present in the particular collection" + doc);
			}

		}
	}

}