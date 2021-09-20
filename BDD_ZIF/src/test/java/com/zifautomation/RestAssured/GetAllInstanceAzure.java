package com.zifautomation.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetAllInstanceAzure {

    @Test
    public void GetAllInstanceAzure() {
        // step1: Get Endpoint (F3)
        // className.methodName();
        RestAssured.baseURI = "GET https://dev.azure.com/ZIFAI//_apis/wit/queries/{query}?api-version=4.1";
        // step2: Authentication (basic)
        RestAssured.authentication = RestAssured.preemptive().basic("santhosh.m@gavstech.com","7h3w6rym75wtl4v3zefj72taqkvwiezdtdgceslvcqn6ysqjonra");
        // step3: Reqtuest Type - get (ctrl+2 , l)
        Response response = RestAssured.get();
        // step4: validate status code - 200
        System.out.println(response.statusCode());
        // step5: print response
        response.prettyPrint();


    }

}
