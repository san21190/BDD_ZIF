package com.zifautomation.RestAssured;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsFileUsingDP {

	@DataProvider(name = "fetchData")
	public Object[] getData() {
		//				[No of Files][each file path]
		String[] data =  new String[2];
		//1st row
		data[0] = System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\CreateIncident1.json";
		//2nd row
		data[1] = System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\CreateIncident2.json";
		return data;
	}


	@Test(dataProvider="fetchData")
	public void getIncident(String path) {//> ./data/CreateIncident1.json

		//		File file = new File("./data/CreateIncident.json");

		// step1: Get Endpoint (F3)
		// className.methodName();
		RestAssured.baseURI = "https://dev78262.service-now.com/api/now/table/incident";
		// step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "0qrpdFhZ5AOW");
		// step3: Reqtuest Type - post (ctrl+2 , l)
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				//				 .body(file)
				.body(new File(path))
				.post();
		// step4: validate status code - 201
		System.out.println(response.statusCode());
		// step5: print response
		response.prettyPrint();


	}

}
