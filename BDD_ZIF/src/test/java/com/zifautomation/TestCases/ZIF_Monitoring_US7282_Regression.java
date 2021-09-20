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


public class ZIF_Monitoring_US7282_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US7282_Regression() throws IOException {
		test = extent.createTest("User Story 7282: API - Install, uninstall and update feature enablement changes.");
		test.createNode("User Story 7282: API - Install, uninstall and update feature enablement changes.");

		//Buffer reader to read the property file//
		Properties properties = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\testdata-config.properties"));
		properties.load(reader);
		reader.close();

		//Declaration of reuse property//
		String authorization = properties.getProperty("api.authorization");
		String name = properties.getProperty("api.name");
		String reportname = properties.getProperty("api.reportname");

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);

		//Map object for allcredentials//
		Map<String, String> allcredentials = new HashMap<String, String>();
		String atype = "hms_type";
		String btype =  "Child";
		allcredentials.put("objId", "monitor");
		allcredentials.put(atype, btype);
		allcredentials.put("hms_id","e217f107-3959-4832-af93-fa2c40db9dc8");


		//**Read me**
		//1.Change module in property file
		//2.Change argument in header using script file
		//getmachineswithcredentials - API
		//hms_relationship_details - Mongo DB
		//machine_details - Mongo DB
		//machine_pollingengine_mapping_details - Mongo DB
		//hms_type - Parent/Child - Parameter
		//Parent and child relationship maps the hms_type with machine id/name


		BaseAPI Baseapist = new BaseAPI();
		Baseapist.preCondition();
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(allheaders)
				.params(allcredentials)
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
	}}