package com.zifautomation.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CreateBugInAzureWithFile_test {

	@Test
	public void CreateBugInAzureWithFile_test() throws UnsupportedEncodingException {
		
//		File file = new File("./data/CreateIncident.json");
		// step1: Get Endpoint (F3)
		// className.methodName();
		RestAssured.baseURI = "https://dev.azure.com/ZIFAI/ZIF%204.0/_apis/wit/workitems?";
		// step2: Authentication (basic)
		//RestAssured.authentication = RestAssured.basic("", "r2rjowenitdxle2bzga7rpcqth5dvqoahmxwglbpwcvm3gnf6gfa");
		// step3: Reqtuest Type - post (ctrl+2 , l)
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
				//.param("Authorization","Basic OnIycmpvd2VuaXRkeGxlMmJ6Z2E3cnBjcXRoNWR2cW9haG14d2dsYnB3Y3ZtM2duZjZnZmE=")
				.param("ids","9677")
				.param("api-version","6.0")
				.headers(headers)
				.get();
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		

	}

}
