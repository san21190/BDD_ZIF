package com.zifautomation.RestAssured;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class GetAllInstance extends BaseRequest {

    @Test
    public void GetAllInstance() {
        response = reqSpec.get();
        JsonPath jsonpath = response.jsonPath();
        List<String> lystsysid = jsonpath.getList("result.sys_id");

        //get the first one//
        sys_id = lystsysid.get(0);
        System.out.println(sys_id);


    }

}
