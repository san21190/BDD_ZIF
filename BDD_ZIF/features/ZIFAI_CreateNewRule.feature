#2537 Alerts-> Settings-> Event Rule Processing-> User With Access to Create new Rule
@2537_Alerts
Feature: Alerts - Active User With Access to Create new Rule
	Testing all the positive and negative Scenarios in ZIF UI Alerts - Active User With Access to Create new Rule
	
#Prerequisite
#User must have access to click on Settings in Alerts page
#Needed Credentials with Access to Create new Rule in Alerts

Background: Launch the Browser with ZIF UI URL
Given Open chrome browser and enter the ZIF UI url for Create new Rule



Scenario: Validate Create new Rule Page Access and Fields

Given Login with valid Create new Rule Enabled Email ID and Password
And Navigate to Alerts Page and Click on Alert Settings
Then Verify that Create new rule button is enabled
When Click on Create new rule button
Then Verify that the slide window for rule creation is opened with Save and Cancel button
And Verify all the fields in the slide window of rule creation


Scenario: Validate all mandatory fields values in Create new rules

Given Login with valid Create new Rule Enabled Email ID and Password
And Navigate to Alerts Page and Click on Alert Settings
When Click on Create new rule button
And click on Tool Name Drop down
Then Verify that the Tool Names are displayed from Nifi
When click on Resource Type Drop down
Then Verify that the Resource Types are displayed
When Enter more than 10 characters in Rule Name
Then Verify that the Rule Name field does not allow more than 10 characters
When Enter less than 10 characters in Rule Name
Then Verify that the Rule Name field allows less than 10 characters
When Enter more than 100 characters in Rule Description
Then Verify that the Rule Description field does not allow more than 100 characters
When Enter less than 100 characters in Rule Description
Then Verify that the Rule Description field allows less than 100 characters
When Enter more than 50 characters in Alert Message
Then Verify that the Alert Message field does not allow more than 50 characters
When Enter less than 50 characters in Alert Message
Then Verify that the Alert Message field allows less than 50 characters
When click on Rule Status Drop down
Then Verify that the Rule Status are displayed
When click on Alert Priority Drop down
Then Verify that the Alert Priority list is displayed
When click on Consecutive Occurrence Drop down
Then Verify that the Consecutive Occurrence values are displayed
When click on Resource Type Drop down
Then Select any Resource Type
Then Verify all the fields in Expression




@Positive
Scenario: Validate the functionality of Validate Save and Cancel button

Given Login with valid Create new Rule Enabled Email ID and Password
And Navigate to Alerts Page and Click on Alert Settings
When Click on Create new rule button
And Select only the drop down  mandatory fields and click on Validate Rule button
Then Verify that the Validation message is displayed
And Verify that the Save button is Disabled
When Click on Cancel button
Then verify that the user is in Alert settings page
When Click on Create new rule button
Then Verify all the all the previous data is deleted and new page is displayed
When Enter values only on all the text fields in the page and click on Validate Rule button
Then Verify that the Validation message is displayed
And Verify that the Save button is Disabled
When Click on Save button
Then Verify user is in Create new rule page with no action
When Enter valid details on all the mandatory fields in the page and click on Validate Rule button
Then Verify that the Validation message is displayed as Please enter Inventory Group or Device Name
And Verify that the Save button is Disabled
When Select any value from Inventory Group or Device Name and click on Validate Rule button
Then Verify that the Validation message is displayed for Expression
When Select any valid Expression and click on Validate Rule button
Then Verify that the Validation success message is displayed
And Verify that the Save button is Enabled
When Click on Save button
Then Verify that the rules is Saved in Settings






@Positive
Scenario: Validate Rules Expression with And operator

Given Login with valid Create new Rule Enabled Email ID and Password
And Navigate to Alerts Page and Click on Alert Settings
When Click on Create new rule button
And Enter all the mandatory fields except Expression
And Select any value from counters
And Select condition as lesser than
And Select value as 20
And Select operator as "And"
And Click on Add Expression
And Select the same value from counters
And Select condition for second expression as greater than
And Select value for second expression as 20
And Select operator for second expression as "And"
And Select the two Expressions checkboxes
And click on Validate Rule button
Then Verify that the Expression Error message is Displayed
When Select condition as Equals
And Select value as 20
And Select operator as "And"
And Select condition for second expression as contains
And Select value for second expression as 30
And Select operator for second expression as "And"
And Select the two Expressions checkboxes
And click on Validate Rule button
Then Verify that the Expression Error message is Displayed
When Select condition as lesser than
And Select value as 20
And Select operator as "And"
And Select condition for second expression as contains
And Select value for second expression as 15
And Select operator for second expression as "And"
And Select the two Expressions checkboxes
And click on Validate Rule button
Then Verify that the Expression Validation success message is Displayed



Scenario: Validate Rules Expression with OR operator

Given Login with valid Create new Rule Enabled Email ID and Password
And Navigate to Alerts Page and Click on Alert Settings
When Click on Create new rule button
And Enter all the mandatory fields except Expression
And Select any value from counters
And Select condition as lesser than
And Select value as 20
And Select operator as "OR"
And Click on Add Expression
And Select the same value from counters
And Select condition for second expression as greater than
And Select value for second expression as 20
And Select operator for second expression as "OR"
And Select the two Expressions checkboxes
And click on Validate Rule button
Then Verify that the Expression Validation success message is Displayed
When Select condition as Equals
And Select value as 20
And Select operator as "OR"
And Select condition for second expression as contains
And Select value for second expression as 30
And Select operator for second expression as "OR"
And Select the two Expressions checkboxes
And click on Validate Rule button
Then Verify that the Expression Validation success message is Displayed
When Select condition as lesser than
And Select value as 20
And Select operator as "OR"
And Select condition for second expression as contains
And Select value for second expression as 15
And Select operator for second expression as "OR"
And Select the two Expressions checkboxes
And click on Validate Rule button
Then Verify that the Expression Validation success message is Displayed




