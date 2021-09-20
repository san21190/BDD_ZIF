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


public class ZIF_Monitoring_US6532_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US6532_Regression() throws IOException {
		test = extent.createTest("User Story 6532: API - APM Card/List view - Machine level - To show the list of Apps & its key metrics. Drill down leads to APM Detail");
		test.createNode("User Story 6532: API - APM Card/List view - Machine level - To show the list of Apps & its key metrics. Drill down leads to APM Detail");

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
		//getAllDetails/getUEIDetails - API
		//getUEIJson/getUEIDetails - API
		//getExceptionDetails/getUEIDetails - API
		//appInfo
		//APM01(Topology) - Mongo DB - This explains the iKey , Databasetype , Timefrom , Timeto

		//map object for getUEIDetails params//
		Map<String, String> allUEIdetails = new HashMap<String, String>();
		allUEIdetails.put("objId", "monitor");
		allUEIdetails.put("iKey", "hdfc058b-89pd-50pv-gaa1-70e1f892191g");
		allUEIdetails.put("time", "2021-09-16T12:48:01Z");
		allUEIdetails.put("timeTo", "2021-09-16T13:48:01Z");
		allUEIdetails.put("data_baseType", "ExceptionData");

		//map object for appInfo params//
		Map<String, String> appInfo = new HashMap<String, String>();
		appInfo.put("objId", "monitor");


		Response response = RestAssured
				.given()
				.log()
				.all()
				.params(allUEIdetails)
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
