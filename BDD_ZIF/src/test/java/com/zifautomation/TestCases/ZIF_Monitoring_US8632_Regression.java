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


public class ZIF_Monitoring_US8632_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US8632_Regression() throws IOException {
		test = extent.createTest("User Story 8632: API - Multipurpose API to fetch individual and multiple process details.");
		test.createNode("User Story 8632: API - Multipurpose API to fetch individual and multiple process details.");

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
		//single-process-details - API [POST]
		//Inframeterics - MongoDB
		//getMachineSpecificInfo - API [GET]

		//*Read me*
		//Pass the method name in property file and class file
		//Report name should be passed in property file
		//1.POST the single process details - This will retrieve the values in the process matching with mongoDB.
		//2.GetMachineSpecificInfo - This will get the machine specific details.

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);
		allheaders.put("accept",accept);
		allheaders.put("Content-Type",Contenttype);

		//Get method header - getMachineSpecificInfo//
		Map<String, String> getmachineinfo = new HashMap<String, String>();
		getmachineinfo.put("objId","monitor");
		getmachineinfo.put("machine_id","200411LTP1157");


		response = reqSpec.get();
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(allheaders)
				.body("{\n" +
						"  \"machine_name\": \"200411LTP1157\",\n" +
						"  \"pi_Name\":[\"Teams\"],\n" +
						"  \"time\": \"2021-09-17T07:14:19Z\",\n" +
						"\"timeTo\": \"2021-09-17T08:14:19Z\",\n" +
						"  \"os_type\": \"windows\",\n" +
						"  \"output_type\": \"process\"\n" +
						"}")
				.post();
		System.out.println(response.getStatusCode());
		int code = response.getStatusCode();
		String valuek = response.prettyPrint();
		if ((code==200)||code==201||code==202) {
			test.log(Status.PASS, reportname +"  "+"value is Successfully posted. "+"Status Code:-" +response.getStatusCode() +". "+"\n " +"\n" +"\n" +"Response:  ");
			test.pass(MarkupHelper.createCodeBlock(valuek, CodeLanguage.JSON));
		}
		else{
			test.log(Status.FAIL, reportname + "  " + " value is not successfully posted. " + "Status Code:-" + response.getStatusCode() + ".  " + "\n " + "\n" + "\n" + "Response:  " + valuek);
		}
	} }