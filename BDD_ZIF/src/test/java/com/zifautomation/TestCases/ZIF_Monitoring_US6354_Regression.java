package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mongodb.client.FindIterable;
import com.zifautomation.RestAssured.BaseAPI;
import com.zifautomation.Utility.MongoQueryManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.xpath.operations.Bool;
import org.bson.Document;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ZIF_Monitoring_US6354_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US6354_Regression() throws IOException {
		test = extent.createTest("User Story 6354: API - Adding machine to device inventory.");
		test.createNode("User Story 6354: API - Adding machine to device inventory.");

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
		//addMachineDetails - API
		//machine_details - MongoDB

		//*Read me*
		//Pass the method name in property file and class file
		//Report name should be passed in property file
		//1.Posting machine details with IP. - Successfully added
		//2.Posting same machine details with IP. - Machine added already
		//3.Posting same machine details with different IP. - Successfully added
		//4.To Validate in mongo DB that changes has been reflected after the API call//


		//Sample API addmachinedetails//

		//{"machine_name":"251711LTQ7876",
		//"machine_type":"windows",
		//"ip_address":"192.179.4.6",
		//"type":"Physical machine"
		//}

		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);
		allheaders.put("accept",accept);
		allheaders.put("Content-Type",Contenttype);


		response = reqSpec.get();
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(allheaders)
				.body("{\n" +
						"\"machine_name\":\"200411LTP1259\",\n" +
						"\"machine_type\":\"windows\",\n" +
						"\"ip_address\":\"192.179.4.6\",\n" +
						"\"type\":\"Physical machine\"\n" +
						"}")
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
		fields.put("machine_name", "200411LTP1259");
		fields.put("ip_address","192.179.4.6");
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
	} }