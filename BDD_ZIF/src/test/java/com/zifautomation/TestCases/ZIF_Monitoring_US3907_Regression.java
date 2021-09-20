package com.zifautomation.TestCases;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.zifautomation.RestAssured.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static com.zifautomation.Base.Base.captureScreenShot;


public class ZIF_Monitoring_US3907_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US3907_Regression() throws IOException {
		test = extent.createTest("User Story 3907: API -CPU and Memory details for GIA");
		test.createNode("User Story 3907: API -CPU and Memory details for GIA");

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
		//fetchCPUDetails
		//fetchMemoryDetails

		//map object for CPU params//
		Map<String, String> allCPU = new HashMap<String, String>();
		allCPU.put("objId", "monitor");
		allCPU.put("machine_name", "200411LTP1157");
		allCPU.put("time", "2021-09-16T10:16:15Z");
		allCPU.put("timeTo", "2021-09-16T11:16:15Z");

		//map object for Memory params//
		Map<String, String> allMemory = new HashMap<String, String>();
		allMemory.put("objId", "monitor");
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
		if(statuscodeq==200){
			test.log(Status.PASS, reportname+" value is Successfully retrieved "+response.getStatusCode());
			test.pass(MarkupHelper.createCodeBlock(valuej, CodeLanguage.JSON));
		}
		else {
			test.log(Status.FAIL, reportname+" Value retrieval is not successful "+response.getStatusCode());
		}



	}

}
