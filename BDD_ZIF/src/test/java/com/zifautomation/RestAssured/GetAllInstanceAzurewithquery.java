package com.zifautomation.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetAllInstanceAzurewithquery {


    @Test
    public void getIncident() {
        //map object
        Map<String, String> allParam = new HashMap<String, String>();
        allParam.put("id", "9680");
        // step1: Get Endpoint (F3)
        // className.methodName();
        RestAssured.baseURI = "https://artifacts.dev.azure.com/ZIFAI/_apis/symbol/requests/?api-version=6.1-preview.1";
        // step2: Authentication (basic)
        RestAssured.authentication = RestAssured.oauth2("7h3w6rym75wtl4v3zefj72taqkvwiezdtdgceslvcqn6ysqjonra");
        // step3: Reqtuest Type - get (ctrl+2 , l)
        Response response = RestAssured
                .given()
//				 .queryParam("category", "software")
                .queryParams(allParam)
                .get();
        // step4: validate status code - 200
        System.out.println(response.statusCode());
        // step5: print response
        response.prettyPrint();


    }

}
