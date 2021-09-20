package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.zifautomation.RestAssured.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ZIF_Monitoring_US7340_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US7340_Regression() throws IOException {
		test = extent.createTest("User Story 7340: Polling interval config for the infra metrics data.");
		test.createNode("User Story 7340: Polling interval config for the infra metrics data.");

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

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);
		allheaders.put("accept", accept);
		allheaders.put("Content-Type", Contenttype);


		//**Read me**
		//1.Change module in property file
		//2.Change argument in header using script file
		//3.If needed change the test data - Machine name , From , to ...

		//Methods//
		//getResources - API(Params)
		//fetchCountersByMachineId/ZDGCARE0007 - API(Path)
		//fetchMachinesPollingEngineByID/e2673948-f334-47c2-88aa-cadb55bf6b20 - API(Path)
		//fetchMachinesPollingEngineByID
		//machine_user_counters - Mongo DB
		//infraMetrics - Mongo DB
		//machine_pollingengine_mapping_details - MongoDB


		//map object for getResources//
		Map<String, String> allgetresources = new HashMap<String, String>();
		allgetresources.put("machine_id", "200411LTP1157");
		allgetresources.put("version_id", "monitor");



		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(allheaders)
				.params(allgetresources)
				.get();
		System.out.println(response.getStatusCode());
		int statuscodeq = response.getStatusCode();
		String valuej = response.prettyPrint();
		if(statuscodeq==200){
			test.log(Status.PASS, reportname+" value is Successfully retrieved "+response.getStatusCode());
			test.pass(MarkupHelper.createCodeBlock(valuej, CodeLanguage.JSON));
		}
		else {
			test.log(Status.FAIL, reportname+" Value retrieval is not successful "+response.getStatusCode());
		}
	}
}
