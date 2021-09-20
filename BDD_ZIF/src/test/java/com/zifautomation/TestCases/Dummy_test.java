package com.zifautomation.TestCases;

import com.mongodb.client.FindIterable;
import com.zifautomation.RestAssured.BaseAPI;
import com.zifautomation.Utility.MongoQueryManager;
import javafx.util.converter.DateStringConverter;
import jxl.write.DateTime;
import org.bson.Document;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Dummy_test extends BaseAPI {

	@Test
	public void ZIF_Monitoring_US8632_Regression() throws IOException, ParseException {
		test = extent.createTest("User Story 8632: API - Multipurpose API to fetch individual and multiple process details.");
		test.createNode("User Story 8632: API - Multipurpose API to fetch individual and multiple process details.");

		//Buffer reader to read the property file//
		Properties properties = new Properties();
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\resources\\testdata-config.properties"));
		properties.load(reader);
		reader.close();

		//Initializing url and name of mongo DB//
		String url = properties.getProperty("db.url");
		String db = properties.getProperty("db.name");

		//Validate add machine details using mongo DB collection//
		MongoQueryManager mongoQueryManager = new MongoQueryManager(url, db);
		Map<String, String> fields = new HashMap<>();

		fields.put("MaintenanceReason","SGT");
		FindIterable<Document> documents = mongoQueryManager.getDocumentsWithFields("device_maintenance", fields);
		for (Document doc : documents) {
	}
	} }