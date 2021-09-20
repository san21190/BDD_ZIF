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


public class ZIF_Monitoring_US6951_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US6951_Regression() throws IOException {
		test = extent.createTest("User Story 6951: API - Encryption and decryption of credentials.");
		test.createNode("User Story 6951: API - Encryption and decryption of credentials.");

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
		//1) Encryption :
		//addcredentials - API(Post)
		//addOrUpdateOrchestratorPolling - updatecredentials  - API(Post)
		//2) Decryption :
		//Below APIs decrypts the password and displays it in outpus json.
		//allcredentials - API(Get)
		//fetchNonAllocatedMachines - API(Get)
		//fetchMachinesPollingEngine - API(Get)
		//fetchMachinesPollingEngineByID - API(Get)
		//fetchCountersByMachineId - API (Get)
		//getmachineswithcredentials - API (Get)

		//*Read me*
		//Pass the method name in property file and class file
		//Report name should be passed in property file
		//type=updatecredentials - Update credentials need to update in property file.
		//server_credentials - Mongo DB

		//Addcredentials post//
//		{
//			"credentials": [
//			{
//				"os_type": "windows",
//					"service_account": "service",
//					"username": "azuredevops",
//					"password": "devopstring",
//					"ssh_key": "zif@@",
//					"domain_name": "gavs"
//			}
//  ]
//		}
		//Updatecredentials post//
//		[
//		{"_id":9,"os_type":"windows",
//				"service_account":"SERVICE",
//				"username":"Autotest3",
//				"password":"TESTING@12345",
//				"domain_name":"qa"}
//		]

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);
		allheaders.put("accept",accept);
		allheaders.put("Content-Type",Contenttype);


		//Map object for -  fetchNonAllocatedMachines// machine_pollingengine_mapping_details - MongoDB
		Map<String, String> fetchNonAllocatedMachines = new HashMap<String, String>();
		fetchNonAllocatedMachines.put("objId", "Monitor");
		fetchNonAllocatedMachines.put("agent_type", "PA");

		//Map object for -  fetchMachinesPollingEngineByID// machine_pollingengine_mapping_details - MongoDB
		// fetchMachinesPollingEngineByID/95fc4473-229a-485f-9772-4952675596d8

		//Map object for -  fetchCountersByMachineId// machine_pollingengine_mapping_details - MongoDB - ZDGCARE0007?(Path)
		Map<String, String> fetchCountersByMachineId = new HashMap<String, String>();
		fetchCountersByMachineId.put("objId", "Monitor");
		fetchCountersByMachineId.put("agent_type", "PA");

		RestAssured.baseURI = "http://172.31.28.8:3000/api/monitor/addcredentials/";
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(allheaders)
				.body("\t\t{\n" +
						"\t\t\t\"credentials\": [\n" +
						"\t\t\t{\n" +
						"\t\t\t\t\"os_type\": \"windows\",\n" +
						"\t\t\t\t\t\"service_account\": \"service\",\n" +
						"\t\t\t\t\t\"username\": \"azureAPIServicesQA\",\n" +
						"\t\t\t\t\t\"password\": \"devopstring\",\n" +
						"\t\t\t\t\t\"ssh_key\": \"zif@@\",\n" +
						"\t\t\t\t\t\"domain_name\": \"gavs\"\n" +
						"\t\t\t}\n" +
						"  ]\n" +
						"\t\t}")
				.post();
		System.out.println(response.getStatusCode());
		int code = response.getStatusCode();
		String valuej = response.prettyPrint();
		if ((code==200)||code==201||code==202) {
			test.log(Status.PASS, reportname +"  "+"value is Successfully posted. "+"Status Code:-" +response.getStatusCode() +". "+"\n " +"\n" +"\n" +"Response:  "+valuej);
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
		fields.put("username", "azureAPIServicesQA");
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