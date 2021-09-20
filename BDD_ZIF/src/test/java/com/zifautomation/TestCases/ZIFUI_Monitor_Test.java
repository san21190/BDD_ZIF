package com.zifautomation.TestCases;

import com.aventstack.extentreports.Status;
import com.zifautomation.Base.Base;
import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAIDashboardPage;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.*;
import java.util.concurrent.TimeUnit;


public class ZIFUI_Monitor_Test extends Base {

	//	PropertiesFileReader obj = new PropertiesFileReader();
	//	Properties properties = null;
	//	CommonMethods cm = null;


	@Test
	public void ZIFUI_Monitor_Test() throws IOException, InterruptedException, SQLException, ClassNotFoundException {

		//Report Initialization
		test = extent.createTest("User Story 5100: Configuration Settings - Add WMI Credentials");
		test.createNode("User Story 5100: Configuration Settings - Add WMI Credentials");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



		// Validating through Postgres Database along with UI data//

		// Object of Connection from the Database
		Connection conn = null;
		// Object of Statement. It is used to create a Statement to execute the query
		Statement stmt = null;
		//Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
		ResultSet resultSet = null;
		//DriverManager.registerDriver(new mongodb.jdbc.MongoDriver);

		Class.forName("mongodb.jdbc.MongoDriver");
		String URL = "jdbc:mongo://172.31.28.10:5255/zif-qa";
		Connection jdbcConn = DriverManager.getConnection(URL);
		//Class.forName("com.mysql.jdbc.Driver");
		// Open a connection
		conn = DriverManager.getConnection("mongodb://172.31.28.10:5255,172.31.28.11:5255,172.31.28.12:5255/zif-uat?replicaSet=zifrs&readPreference=secondaryPreferred&maxStalenessSeconds=120&appname=MongoDB%20Compass&ssl=false");
		// Execute a query
		try {
			stmt = jdbcConn.createStatement();
			String query = "db.memoryMetrics.aggregate([{\n" +
					"            $match: {\n" +
					"                \"output_type\": \"memory\",\n" +
					"                \"time\": { \"$gte\": '2021-06-10T13:22:13Z', \"$lte\": '2021-06-10T14:22:13Z' },\n" +
					"                \"machine_name\":'200411LTP0572',\n" +
					"                \"os_type\": \"windows\"\n" +
					"            }\n" +
					"        },\n" +
					"        {\n" +
					"            $group:\n" +
					"            {\n" +
					"                _id: null,\n" +
					"                memoryTotal: { $avg: { $divide: [{ $toDecimal: \"$memory_total_absolute\" }, 1024] } },\n" +
					"                memoryAvailable: { $avg: { $divide: [{ $toDecimal: \"$memory_available_absolute\" }, 1024] } },\n" +
					"            }\n" +
					"        },\n" +
					"        {\n" +
					"            $project: {\n" +
					"                memcapacity: { $multiply: [{ $divide: [\"$memoryAvailable\", \"$memoryTotal\"] }, 100] }\n" +
					"            }\n" +
					"        }])";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {


			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
//-----------------------------------------------End of US-------------------------------------------------//



