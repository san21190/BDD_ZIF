@ZIFcatalog
Feature: ZIFcatalog Portal
	Tesing all the positive and negative Scenarios in ZIFcatalog Portal


Background: Launch the Browser with URL
Given Open chrome browser and enter the url

@Testcase1
Scenario: Login to ZIF catalog portal with invalid and valid credentials

Given user is already on Login Page
When title of login page is Zif Catalog
And user enters invalid username and password and click on login button
And user will get the invalid username or password error message
When user enters enters valid username and password and click on login button
Then user should be in the ZIF catalog HomePage
Then logout and Close the browser

@Testcase2
Scenario: ZIF catalog Field validation

When user enters enters valid username and password and click on login button
Then verify all the fields are displayed in the Home Page
Then logout and Close the browser


@Testcase3
Scenario: ZIF catalog business outcomes and technical outcomes

Given The user is in ZIF catalog Homepage
When user selects CAPEX Optimization in  business outcomes
Then verify Correlation, Root Cause Identification are selected in technical outcomes
When user unselects CAPEX Optimization in  business outcomes
Then verify Correlation, Root Cause Identification are unselected in technical outcomes

When user selects OPEX Optimization in  business outcomes
Then verify Correlation, Root Cause Identification, Prediction,Intelligent Automation are selected in techical outcomes
When user unselects OPEX Optimization in  business outcomes
Then verify Correlation, Root Cause Identification, Prediction,Intelligent Automation are unselected in techical outcomes

When user selects Blueprinting Enterprise in  business outcomes
Then verify Auto Discovery is selected in technical outcomes
When user unselects Blueprinting Enterprise in  business outcomes
Then verify Auto Discovery is unselected in technical outcomes

When user selects Optimization of Compute in  business outcomes
Then verify Prediction is selected in technical outcomes
When user unselects Optimization of Compute in  business outcomes
Then verify Prediction is unselected in technical outcomes

When user selects Improvement in User Experience in  business outcomes
Then verify Correlation, Root Cause Identification, Prediction are selected in technical outcomes
When user unselects Improvement in User Experience in  business outcomes
Then verify Correlation, Root Cause Identification, Prediction are unselected in technical outcomes

When user selects Improvement in Business Service Assurance in  business outcomes
Then verify Correlation, Root Cause Identification are selected in technical outcomes
When user unselects Improvement in Business Service Assurance in  business outcomes
Then verify Correlation, Root Cause Identification are unselected in technical outcomes

When user selects Shift Left in  business outcomes
Then verify Intelligent Automation, Intelligent Triaging are selected in technical outcomes
When user unselects Shift Left in  business outcomes
Then verify Intelligent Automation, Intelligent Triaging are unselected in technical outcomes

When user selects Eliminating Digital Dirt in  business outcomes
Then verify Dependency Mapping is selected in technical outcomes
When user unselects Eliminating Digital Dirt in  business outcomes
Then verify Dependency Mapping is unselected in technical outcomes

When user selects Improvement in Application Availability in  business outcomes
Then verify Correlation, Root Cause Identification, Prediction are selected in technical outcomes
When user unselects Improvement in Application Availability in  business outcomes
Then verify Correlation, Root Cause Identification, Prediction are unselected in technical outcomes

Then logout and Close the browser
