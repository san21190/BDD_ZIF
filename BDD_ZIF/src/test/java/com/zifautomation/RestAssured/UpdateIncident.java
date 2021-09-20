package com.zifautomation.RestAssured;

import java.io.File;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident extends BaseRequest {

	@Test
	public void UpdateIncident() {
		response = reqSpec.get();
		JsonPath jsonpath = response.jsonPath();
		// step3: Reqtuest Type - 
		 Response response = RestAssured
				 .given()
				 .contentType(ContentType.JSON)
				 .body(new File(System.getProperty("user.dir")+"\\resources\\Downloads\\CreateIncident3.json"))
				 .patch("f8bc7c7b2f983010d171af5df699b665");
		 //.put("1222cca72f503010a99d857cf699b65c");
		// step4: validate status code - 201
		System.out.println(response.statusCode());
		// step5: print response
		response.prettyPrint();
		

	}

}
