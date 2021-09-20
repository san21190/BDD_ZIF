package com.zifautomation.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CreateBugInAzureWithFile {

	@Test
	public void CreateBugInAzureWithFile() {
		
//		File file = new File("./data/CreateIncident.json");
		// step1: Get Endpoint (F3)
		// className.methodName();

		RestAssured.baseURI = "https://dev.azure.com/ZIFAI/ZIF%204.0/_apis/wit/workitems/$Bug?api-version=6.0";
		// step2: Authentication (basic)
		//RestAssured.authentication = RestAssured.basic("", "r2rjowenitdxle2bzga7rpcqth5dvqoahmxwglbpwcvm3gnf6gfa");
		// step3: Reqtuest Type - post (ctrl+2 , l)
		List<Header> allHeaders = new ArrayList<Header>();
		allHeaders.add(new Header("Accept-Encoding", "gzip,deflate,br"));
		allHeaders.add(new Header("Accept", "*/*"));
		allHeaders.add(new Header("Content-Type", "application/json-patch+json"));
		Headers headers = new Headers(allHeaders);

		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(headers)
				.body(new File(System.getProperty("user.dir")+"\\resources\\Datatables\\Downloads\\CreateBug.json"))
				.post();

		System.out.println(response.getStatusCode());
		response.prettyPrint();
		

	}

}
