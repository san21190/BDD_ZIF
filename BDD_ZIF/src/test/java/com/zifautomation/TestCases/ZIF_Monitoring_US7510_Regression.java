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


public class ZIF_Monitoring_US7510_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US7510_Regression() throws IOException {
		test = extent.createTest("User Story 7510: API - Updates to communicate for PE implementation.");
		test.createNode("User Story 7510: API - Updates to communicate for PE implementation.");

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

		//**Resources** - To be entered in property file and header **
		//updateMachinePollingEngineId - POST(API)
		//getmachineswithcredentials - GET(API)
		//addMachineDetails - POST(API)
		//fetchNonAllocatedMachines - GET(API)

		//*Read me*
		//Pass the method name in property file and class file
		//Report name should be passed in property file.
		//server_credentials - Mongo DB
		//machine_pollingengine_mapping_details - Mongo DB
		//orchestrator_pollingengine_details - Mongo DB
		//Ensure machine and orchestrator are in sync

		//addMachineDetails post//
//		{"machine_name":"251711LTQ7876",
//		"machine_type":"windows",
//		"ip_address":"192.179.4.6",
//		"type":"Physical machine"
//		}

		//updateMachinePollingEngineId//
//		{
//		"machine_id": "ZDGCARE0007",
//		"pollingengine_id": "09b4cec0-4a55-4d2c-9b3d-fd16fd123456",
//		"orchesterator_id": "09b4cec0-4a55-4d2c-9b3d-fd16fd123456",
//		"agent_type": "PE"
//		 }


		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);
		allheaders.put("accept",accept);
		allheaders.put("Content-Type",Contenttype);


		//Map object for  - machineswithcredentials
		Map<String, String> allmachineswithcredentials = new HashMap<String, String>();
		allmachineswithcredentials.put("objId", "monitor");
		allmachineswithcredentials.put("hms_type","Parent");

		//Map object for -  fetchNonAllocatedMachines
		Map<String, String> allfetchNonAllocatedMachines = new HashMap<String, String>();
		allfetchNonAllocatedMachines.put("objId", "monitor");

		RestAssured.baseURI = "http://172.31.28.8:3000/api/monitor/fetchNonAllocatedMachines?/";
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(allheaders)
				.params(allfetchNonAllocatedMachines)
				.get();
		System.out.println(response.getStatusCode());
		int code = response.getStatusCode();
		String valuej = response.prettyPrint();
		if ((code==200)||code==201||code==202) {
			test.log(Status.PASS, reportname +"  "+"value is Successfully posted. "+"Status Code:-" +response.getStatusCode() +". "+"\n " +"\n" +"\n" +"Response:  ");
			test.pass(MarkupHelper.createCodeBlock(valuej, CodeLanguage.JSON));
		}

		else{
			test.log(Status.FAIL, reportname + "  " + " value is not successfully posted. " + "Status Code:-" + response.getStatusCode() + ".  " + "\n " + "\n" + "\n" + "Response:  " + valuej);
		}

		//Initializing url and name of mongo DB//
		String url = properties.getProperty("db.url");
		String db = properties.getProperty("db.name");

		//Validate add machine details using mongo DB collection//
		MongoQueryManager mongoQueryManager = new MongoQueryManager(url, db);
		Map<String, String> fields = new HashMap<String, String>();
		fields.put("username", "azureAPItest");
		FindIterable<Document> documents = mongoQueryManager.getDocumentsWithFields("server_credentials", fields);
		for (Document doc : documents) {
			boolean value = doc.isEmpty();
			if (value) {
				test.log(Status.FAIL, "Data records not found for" +reportname +" in MongoDB");
				System.out.println("Value is present in the particular collection" + doc);
			}  else {
				test.log(Status.PASS, "Data records found for "+reportname +" in MongoDB");
				System.out.println("Value is present in the particular collection" + doc);
			}

		}
	} }