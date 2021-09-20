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


public class ZIF_Monitoring_US8096_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US8096_Regression() throws IOException {
		test = extent.createTest("User Story 8096: API - High availability API changes.");
		test.createNode("User Story 8096: API - High availability API changes.");

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

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);


		//**Read me**
		//1.Change module in property file
		//2.Change argument in header using script file
		//3.If needed change the test data - Machine name , From , to ...

		//Methods//
		//fetchCountersByMachineId - API
		//all-hms-details - API
		//topology-details - API
		//APM01(Topology) - Mongo DB - This explains the number of API hits has been made from the user side.

		//map object for Counter params//
		Map<String, String> allcounters = new HashMap<String, String>();
		allcounters.put("objId", "monitor");
		allcounters.put("machine_id", "200411LTP1157");
		allcounters.put("agent_type", "PA");

		//map object for hms params//
		Map<String, String> allhms = new HashMap<String, String>();
		allhms.put("objId", "monitor");

		//map object for topology-details params//
		Map<String, String> alltopology = new HashMap<String, String>();
		alltopology.put("objId", "monitor");
		alltopology.put("iKey", "hdfc058b-89pd-50pv-gaa1-70e1f892191g");
		alltopology.put("time", "2021-01-03T09:40:41.41Z");
		alltopology.put("timeTo", "2021-01-06T09:40:41.41Z");


		Response response = RestAssured
				.given()
				.log()
				.all()
				.params(allcounters)
				.headers(allheaders)
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
