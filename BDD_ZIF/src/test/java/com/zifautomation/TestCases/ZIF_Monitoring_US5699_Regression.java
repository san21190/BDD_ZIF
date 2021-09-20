package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.zifautomation.RestAssured.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ZIF_Monitoring_US5699_Regression extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US5699_Regression() throws IOException {
		test = extent.createTest("User Story 5699: API-GIA for Process CPU , Process Memory , Events and Services for the Details page");
		test.createNode("User Story 5699: API-GIA for Process CPU , Process Memory , Events and Services for the Details page");

		//Buffer reader to read the property file//
		Properties properties = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\testdata-config.properties"));
		properties.load(reader);
		reader.close();

		//Declaration of reuse property//
		String authorization = properties.getProperty("api.authorization");
		String name = properties.getProperty("api.name");
		String reportname = properties.getProperty("api.reportname");
		String accept = properties.getProperty("api.accept");
		String Contenttype = properties.getProperty("api.Content-Type");
		BaseAPI Baseapist = new BaseAPI();
		Baseapist.preCondition();

		//**Resources** - To be entered in property file and header **
		//1) fetchServiceDetails - API
		//2) fetchProcessDetails - API
		//3) fetchEventDetails - API
		//4) fetchProcessMemCpu - API
		//5) InfraMetrics - MongoDB


		//*Read me*
		//Pass the method name in property file and class file
		//Report name should be passed in property file
		//1) fetchServiceDetails - service
		//2) fetchProcessDetails - process
		//3) fetchEventDetails - event
		//4) fetchProcessMemCpu - process


		//Map object for headers//
		Map<String, String> allheaders = new HashMap<String, String>();
		allheaders.put("Authorization", authorization);
		allheaders.put("username", name);
		allheaders.put("accept",accept);
		allheaders.put("Content-Type",Contenttype);

		//Map object for ServiceDetails//
		Map<String, String> allService = new HashMap<String, String>();
		allService.put("objId", "monitor");
		allService.put("machine_name", "200411LTP1157");
		allService.put("os_type","windows");
		allService.put("output_type","service");
		allService.put("time", "2021-09-16T12:48:01Z");
		allService.put("timeTo", "2021-09-16T13:48:01Z");
		allService.put("limit","2");
		allService.put("offset","2");


		//Map object for ProcessDetails//
		Map<String, String> allProcess = new HashMap<String, String>();
		allProcess.put("objId", "Monitor");
		allProcess.put("machine_name", "200411LTP1157");
		allProcess.put("os_type","windows");
		allProcess.put("output_type","process");
		allProcess.put("time", "2021-09-16T12:48:01Z");
		allProcess.put("timeTo", "2021-09-16T13:48:01Z");


		//Map object for EventDetails//
		Map<String, String> allEvent = new HashMap<String, String>();
		allEvent.put("objId", "Monitor");
		allEvent.put("machine_name", "200411LTP1157");
		allEvent.put("os_type","windows");
		allEvent.put("output_type","event");
		allEvent.put("time", "2021-09-16T12:48:01Z");
		allEvent.put("timeTo", "2021-09-16T13:48:01Z");
		allEvent.put("limit","2");
		allEvent.put("offset","2");


		//Map object for ProcessMemCpu//
		Map<String, String> allProcessMemCpu = new HashMap<String, String>();
		allProcessMemCpu.put("objId", "Monitor");
		allProcessMemCpu.put("machine_name", "200411LTP1157");
		allProcessMemCpu.put("os_type","windows");
		allProcessMemCpu.put("output_type","process");
		allProcessMemCpu.put("time", "2021-09-16T12:48:01Z");
		allProcessMemCpu.put("timeTo", "2021-09-16T13:48:01Z");


		response = reqSpec.get();
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(allheaders)
				.params(allProcessMemCpu)
				.get();
		System.out.println(response.getStatusCode());
		int code = response.getStatusCode();
		String valuek = response.prettyPrint();
		if ((code==200)||code==201||code==202) {
			test.log(Status.PASS, reportname +"  "+"value is Successfully posted. "+"Status Code:-" +response.getStatusCode() +". "+"\n " +"\n" +"\n" +"Response:  ");
			test.pass(MarkupHelper.createCodeBlock(valuek, CodeLanguage.JSON));
		}
		else{
			test.log(Status.FAIL, reportname + "  " + " value is not successfully posted. " + "Status Code:-" + response.getStatusCode() + ".  " + "\n " + "\n" + "\n" + "Response:  " + valuek);
		}
	} }