package com.zifautomation.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class CreateNewJira {

	@Test
	public void CreateNewJira() {

			RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
			RestAssured.authentication = RestAssured.preemptive().basic("Hari.radhakrishnan@testleaf.com",
					"ODWNgjWGBWQ6PLeMtv2W4C66");
			Response response = RestAssured
					.given()
					.log()
					.all()
					.get();

		long responseTime1 = response.getTime();
		System.out.println("Response time in ms using getTime():"+responseTime1);


		System.out.println(response.getStatusCode());
			response.prettyPrint();

		}
		

	}

