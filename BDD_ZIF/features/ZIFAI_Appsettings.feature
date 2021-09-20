@ZIFAIAppSettings
Feature: ZIF UI App Settings Portal
	Testing all the positive and negative Scenarios in ZIF UI App Settings Portal


Background: Launch the Browser with URL
Given Open chrome browser and enter the url


@UserAccess
Scenario: ZIF UI App Settings User Management Page Field Validation

Given The user is in ZIF UI Dashboard Page
When User clicks on App Settings Icon
Then Verify user is in App Settings Page
And Verify all the fields in the App settings User Management Page
Then Click on logout and Close the browser


@UserAccess
Scenario: ZIF UI App Settings User Management Page Add New User

Given The user is in ZIF UI Dashboard Page
When User clicks on App Settings Icon
Then Verify user is in App Settings Page
When User Clicks on Add New User button
Then Verify that the Add New User Side Panel is displayed with all details
When User Enters Less than five characters in Name Textbox
And Clicks on Save button
Then Verify that the error message "Name must be at least 5 characters long" is displayed under Name field
When User Enters Numbers in Name Textbox
And Clicks on Save button
Then Verify that the error message "Name is invalid" is displayed under Name field
When User Enters "zifui" in Email Textbox
And Clicks on Save button
Then Verify that the error message "Email is invalid" is displayed under Name field
When User clicks on Status drop down
Then Verify that the dropdown list displays Active and Inactive as fields
When User Enters all the valid details in Add New User
And Clicks on Save button
Then Verify that the success message is displayed
Then Click on logout and Close the browser

@UserAccess
Scenario: ZIF UI App Settings User Management Page Pagination and Filter List

Given The user is in ZIF UI Dashboard Page
When User clicks on App Settings Icon
Then Verify user is in App Settings Page
And Verify the pagination at the bottom of the page
When user selects 6 from the filter list
Then Verify rows less than or equal to 6 is displayed
When user selects 20 from the filter list
Then Verify rows less than or equal to 20 is displayed
When user selects 50 from the filter list
Then Verify rows less than or equal to 50 is displayed
Then Click on logout and Close the browser


@UserAccess
Scenario: ZIF UI App Settings User Management Page Edit User

Given The user is in ZIF UI Dashboard Page
When User clicks on App Settings Icon
Then Verify user is in App Settings Page
When User Clicks on edit button for any user
Then Verify that the side panel is displayed with update button
When User updates the Status as Inactive
And Clicks on Update button
Then Verify that the updated successfully message is displayed
When User close the Side Panel
Then Verify that the inactive status is updated
When Update the user as active and save
And User close the Side Panel
Then Click on logout and Close the browser


@UserAccess
Scenario: ZIF UI App Settings User Management Page Search box verification

Given The user is in ZIF UI Dashboard Page
When User clicks on App Settings Icon
Then Verify user is in App Settings Page
When User Enters random texts in the search box
Then Verify that the no user row is displayed in the page
When User Enters valid search text in the search box
Then Verify that the user row is getting displayed
Then Click on logout and Close the browser


@AccessGroup
Scenario: ZIF UI App Settings User Management Page Group Access Field Validation

Given The user is in ZIF UI Dashboard Page
When User clicks on App Settings Icon
Then Verify user is in App Settings Page
When User clicks on the User Management drop down
Then Verify User Access and Group Access list is displayed
When User clicks on Group Access
Then Verify that the user is in Access Groups page
And Verify all the fields in the Access Groups page
Then Click on logout and Close the browser

@AccessGroup
Scenario: ZIF UI App Settings User Management Page Group Access Create Access Group

Given The user is in App Settings Page
And User is Navigated to Access Groups page
When Clicks on Create Access Group button
Then Verify that the Create Access Group Side Panel is displayed with Save button
When User Enters the Valid Name and Selects the Status as Active
Then Verify that the user is able to Select and unselect all the options in Select Screens to Access
When User Selects Dashboard
Then Verify Access Related to dashboard are displayed
When User Selects Raw Alerts
Then Verify Access Related to Raw Alerts are displayed
When User Selects Analytics
Then Verify Access Related to Analytics are displayed
When User Selects Predictions
Then Verify Access Related to Predictions are displayed
When Select Specific functions and Click on Save button
Then Verify that the success message is displayed
And Close the Side Panel
Then Click on logout and Close the browser

@AccessGroup
Scenario: ZIF UI App Settings User Management Page Group Access Pagination and Filter List

Given The user is in App Settings Page
And User is Navigated to Access Groups page
Then Verify user is in App Settings Group Access Page
And Verify the pagination at the bottom of the page
When user selects 8 from the filter list
Then Verify rows less than or equal to 8 is displayed
When user selects 20 from the filter list
Then Verify rows less than or equal to 20 is displayed
When user selects 50 from the filter list
Then Verify rows less than or equal to 50 is displayed
Then Click on logout and Close the browser


@AccessGroup
Scenario: ZIF UI App Settings Group Access Page Edit Group

Given The user is in App Settings Page
And User is Navigated to Access Groups page
When User Clicks on edit button for any group
Then Verify that the side panel is displayed with update button
When User updates the Status of group as Inactive
And Clicks on Update button
Then Verify that the updated successfully message is displayed
When User close the Side Panel
Then Verify that the inactive status is updated for the group
When Update the user as active and save
And User close the Side Panel
Then Click on logout and Close the browser


@AccessGroup
Scenario: ZIF UI App Settings Group Access Page Search box verification

Given The user is in App Settings Page
And User is Navigated to Access Groups page
When User Enters random texts in the Group Access search box
Then Verify that the no group row is displayed in the page
When User Enters valid search text in the Group Access search box
Then Verify that the group row is getting displayed
Then Click on logout and Close the browser