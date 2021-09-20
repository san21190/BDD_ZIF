package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mongodb.client.FindIterable;
import com.zifautomation.RestAssured.BaseAPI;
import com.zifautomation.Utility.MongoQueryManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.bson.Document;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ZIF_Monitoring_US6870_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US6870_Regression() throws IOException {
		test = extent.createTest("User Story 6870: API - Update to communicate for PA deployment.");
		test.createNode("User Story 6870: API - Update to communicate for PA deployment.");

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
		BaseAPI Baseapist = new BaseAPI();
		Baseapist.preCondition();

		//Read me//
		//**Resources** - To be entered in property file and header **
		//updateMachineIp - API [POST]
		//machine_details - MongoDB
		//{
		//"machines": [{ "machine_name": "200411LTP1157", "ip_address": "10.36.31.28" }]
		//} - Sample data

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);
		allheaders.put("accept", accept);
		allheaders.put("Content-Type", Contenttype);

		//Get method header - getMachineSpecificInfo//
		Map<String, String> getmachineinfo = new HashMap<String, String>();
		getmachineinfo.put("objId", "monitor");


		response = reqSpec.get();
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(allheaders)
				.body("{\n" +
						"\"machines\": [{ \"machine_name\": \"200411LTP1157\", \"ip_address\": \"10.88.56.77\" }]\n" +
						"}")
				.post();
		System.out.println(response.getStatusCode());
		int code = response.getStatusCode();
		String valuek = response.prettyPrint();
		if ((code == 200) || code == 201 || code == 202) {
			test.log(Status.PASS, reportname + "  " + "value is Successfully posted. " + "Status Code:-" + response.getStatusCode() + ". " + "\n " + "\n" + "\n" + "Response:  ");
			test.pass(MarkupHelper.createCodeBlock(valuek, CodeLanguage.JSON));
		} else {
			test.log(Status.FAIL, reportname + "  " + " value is not successfully posted. " + "Status Code:-" + response.getStatusCode() + ".  " + "\n " + "\n" + "\n" + "Response:  " + valuek);
		}


		//Initializing url and name of mongo DB//
		String url = properties.getProperty("db.url");
		String db = properties.getProperty("db.name");

		//Validate add machine details using mongo DB collection//
		MongoQueryManager mongoQueryManager = new MongoQueryManager(url, db);
		Map<String, String> fields = new HashMap<String, String>();
		fields.put("machine_name", "200411LTP1157");
		FindIterable<Document> documents = mongoQueryManager.getDocumentsWithFields("machine_details", fields);
		for (Document doc : documents) {
			boolean value = doc.isEmpty();
			if (value) {
				test.log(Status.FAIL, "Data records not found for" + reportname + " in MongoDB");
				System.out.println("Value is present in the particular collection" + doc);
			} else {
				test.log(Status.PASS, "Data records found for " + reportname + " in MongoDB");
				System.out.println("Value is present in the particular collection" + doc);
			}
		}
	}
}