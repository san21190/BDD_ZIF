package com.zifautomation.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CreateBugInAzureWithBody {

	@Test
	public void CreateBugInAzureWithBody() throws UnsupportedEncodingException {
		
//		File file = new File("./data/CreateIncident.json");
		// step1: Get Endpoint (F3)
		// className.methodName();
		RestAssured.baseURI = "https://dev.azure.com/ZIFAI/ZIF%204.0/_apis/wit/workitems/$Bug?";
		List<Header> allHeaders = new ArrayList<Header>();
		allHeaders.add(new Header("Authorization", "Basic OnIycmpvd2VuaXRkeGxlMmJ6Z2E3cnBjcXRoNWR2cW9haG14d2dsYnB3Y3ZtM2duZjZnZmE="));
		allHeaders.add(new Header("Accept-Encoding", "gzip,deflate,br"));
		allHeaders.add(new Header("Accept", "*/*"));
		allHeaders.add(new Header("Content-Type", "application/json-patch+json"));
		Headers headers = new Headers(allHeaders);
		Response response = RestAssured
				.given()
				.log()
				.all()
				.queryParam("api-version","6.0")
				.headers(headers)
				.body(new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\CreateBug.json"))
				.post();
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		

	}

}
