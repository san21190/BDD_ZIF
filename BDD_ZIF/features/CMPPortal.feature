@CMPPortal
Feature: CMP Portal
	Tesing all the positive and negative Scenarios in CMP Portal


@smoke
Scenario: Verify Login page
		Given Open Chrome browser with URL
	    Then Verify the Login page fields
	    Then Verify whether the email should have valid domain
		When Login the application
		Then Verify the invalid login
		And Enter the Valid credentials
		Then Verify the login successfully

@Regression
Scenario: Verify CMP Portal HomePage fileds
	Given Open Chrome browser with valid URL
	When Login to the application
	Then Verify the Total number of customers
	Then Verify the Zif in production field
	Then Verify the ZIF in POV field
	Then Verify the List of customers
	Then The headers should be in search format
	And  Click on the pagination and Verify the user traverse to next page
	And Logout of the Application


@Testcase3
Scenario: Add Customers and Verify
	Given Open Chrome browser with valid URL
	When Login to the application
	And  Click on Add New Customer button
	Then Verify all the fields in Add a New Customer side panel
	When User enters Partial data in the panel
	Then Verify that the Create Customer button is disabled
	When User enters all the data 
	Then Verify that the Create Customer buttton is enabled
	When Click on Create Customer button
	Then Verify that the Customer is displayed in the List of Customers
	And  Logout of the Application
	
