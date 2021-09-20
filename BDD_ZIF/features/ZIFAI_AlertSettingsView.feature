#2536 Alerts - Active User With Access to view Settings Page
@2536_Alerts
Feature: Alerts - Active User With Access to view Settings Page
	Testing all the positive and negative Scenarios in ZIF UI Alerts - Active User With Access to view Settings Page

#Needed Credentials with and without Access to view Settings Page in Alerts

Background: Launch the Browser with ZIF UI URL for Alerts - Active User With Access to view Settings Page
Given Open chrome browser and enter the ZIF UI url for Alerts Active User With Access to view Settings Page



Scenario: Validate Alert Settings Click Enabled Functionalities

Given Login with valid Alert Settings Click Enabled Email ID and Password
When Navigate to Alerts Page
Then Verify that the Alert Settings is Enabled
When Click on Enabled Alert Settings
Then Verify that User is able to click on Alert Settings


Scenario: Validate Alert Settings Click Disabled Functionalities

Given Login with valid Alert Settings Click Disabled Email ID and Password
When Navigate to Alerts Page
Then Verify that the Alert Settings is Disabled
When Click on Disabled Alert Settings
Then Verify that User is not able to click on the Disabled Alert Settings


Scenario: Validate Alert Settings Icon Tooltip 

Given Login with valid Alert Settings Click Enabled Email ID and Password
When Navigate to Alerts Page
And Mouse hover on Alert Settings Icon
Then Verify that User is able see the tooltip as Settings


Scenario: Validate Alert Settings View Enabled Functionalities

Given Login with valid Alert Settings View Enabled Email ID and Password
When Navigate to Alerts Page
And Click on Enabled Alert Settings
Then Verify the user is able to view all the fields in the Alert Settings Page


Scenario: Validate Alert Settings View Disabled Functionalities

Given Login with valid Alert Settings View Disabled Email ID and Password
When Navigate to Alerts Page
And Click on Enabled Alert Settings
Then Verify the user is not able to view all the fields in the Alert Settings Page