package com.zifautomation.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class BaseRequest {

    public static String sys_id ="";
    public static RequestSpecification reqSpec;
    public static Response response;

    @BeforeSuite

    public void init (){
        RestAssured.baseURI ="https://dev78262.service-now.com/api/now/table/incident";
        RestAssured.authentication = RestAssured.basic("admin","0qrpdFhZ5AOW");
        reqSpec = RestAssured.given().log().all();
    }

    @AfterMethod
    public void afterEachTests(){
        response.then().log().all();
    }
}
