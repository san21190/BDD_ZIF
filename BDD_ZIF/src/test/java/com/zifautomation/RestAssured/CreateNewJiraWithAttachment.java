package com.zifautomation.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateNewJiraWithAttachment {

	@Test
	public void CreateNewJiraWithAttachment() {

			RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
			RestAssured.authentication = RestAssured.preemptive().basic("Hari.radhakrishnan@testleaf.com",
					"ODWNgjWGBWQ6PLeMtv2W4C66");
			Response response = RestAssured.given().contentType(ContentType.JSON).get("16012");
			JsonPath jsonPath = response.jsonPath();
			Object descr = jsonPath.get("fields.description");
			Object summary = jsonPath.get("fields.summary");
			System.out.println(descr);
			System.out.println(summary);

		}
		}

