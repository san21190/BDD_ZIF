package com.zifautomation.RestAssured;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsString extends BaseRequest {

	@Test
	public void getInCreateIncidentWithBodyAsStringcident() {
		response = reqSpec.get();
		JsonPath jsonpath = response.jsonPath();
		// step3: Reqtuest Type - post (ctrl+2 , l)
		 Response response = RestAssured
				 .given()
				 .contentType(ContentType.JSON)
				 .body("{ \"short_description\": \"create incident with body as variable\", \"category\": \"hardware\" }")
				 .post();
		// step4: validate status code - 201
		System.out.println(response.statusCode());
		// step5: print response
		response.prettyPrint();
		

	}

}
