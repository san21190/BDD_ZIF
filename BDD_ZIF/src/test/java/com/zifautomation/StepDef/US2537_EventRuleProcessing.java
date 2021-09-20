package com.zifautomation.StepDef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.zifautomation.Listeners.ExtentReportListener;
import com.zifautomation.Pages.CMPLandingpage;

import com.zifautomation.Pages.Loginfunction;
import com.zifautomation.Pages.ZIFAI_AlertsSettingsPage;
import com.zifautomation.Utility.BrowserUtility;
import com.zifautomation.Utility.CommonMethods;
import com.zifautomation.Utility.ExcelHandler;
import com.zifautomation.Utility.PropertiesFileReader;
import com.zifautomation.Utility.TestDataHandler;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class US2537_EventRuleProcessing extends ExtentReportListener
{
	PropertiesFileReader obj= new PropertiesFileReader();
	TestDataHandler testdata=new TestDataHandler();
	private WebDriver driver;
	CommonMethods cm=null;
	Loginfunction Login = null;

	Properties properties;

	@Given("Open chrome browser and enter the ZIF UI url for Create new Rule")
	public void open_chrome_browser_and_enter_the_ZIF_UI_url_for_Create_new_Rule() {
	     
	   
	}

	@Given("Login with valid Create new Rule Enabled Email ID and Password")
	public void login_with_valid_Create_new_Rule_Enabled_Email_ID_and_Password() {
	     
	   
	}

	@Given("Navigate to Alerts Page and Click on Alert Settings")
	public void navigate_to_Alerts_Page_and_Click_on_Alert_Settings() {
	     
	   
	}

	@Then("Verify that Create new rule button is enabled")
	public void verify_that_Create_new_rule_button_is_enabled() {
	     
	   
	}

	@When("Click on Create new rule button")
	public void click_on_Create_new_rule_button() {
	     
	   
	}

	@Then("Verify that the slide window for rule creation is opened with Save and Cancel button")
	public void verify_that_the_slide_window_for_rule_creation_is_opened_with_Save_and_Cancel_button() {
	     
	   
	}

	@Then("Verify all the fields in the slide window of rule creation")
	public void verify_all_the_fields_in_the_slide_window_of_rule_creation() {
	     
	   
	}

	@When("click on Tool Name Drop down")
	public void click_on_Tool_Name_Drop_down() {
	     
	   
	}

	@Then("Verify that the Tool Names are displayed from Nifi")
	public void verify_that_the_Tool_Names_are_displayed_from_Nifi() {
	     
	   
	}

	@When("click on Resource Type Drop down")
	public void click_on_Resource_Type_Drop_down() {
	     
	   
	}

	@Then("Verify that the Resource Types are displayed")
	public void verify_that_the_Resource_Types_are_displayed() {
	     
	   
	}

	@When("Enter more than {int} characters in Rule Name")
	public void enter_more_than_characters_in_Rule_Name(Integer int1) {
	     
	   
	}

	@Then("Verify that the Rule Name field does not allow more than {int} characters")
	public void verify_that_the_Rule_Name_field_does_not_allow_more_than_characters(Integer int1) {
	     
	   
	}

	@When("Enter less than {int} characters in Rule Name")
	public void enter_less_than_characters_in_Rule_Name(Integer int1) {
	     
	   
	}

	@Then("Verify that the Rule Name field allows less than {int} characters")
	public void verify_that_the_Rule_Name_field_allows_less_than_characters(Integer int1) {
	     
	   
	}

	@When("Enter more than {int} characters in Rule Description")
	public void enter_more_than_characters_in_Rule_Description(Integer int1) {
	     
	   
	}

	@Then("Verify that the Rule Description field does not allow more than {int} characters")
	public void verify_that_the_Rule_Description_field_does_not_allow_more_than_characters(Integer int1) {
	     
	   
	}

	@When("Enter less than {int} characters in Rule Description")
	public void enter_less_than_characters_in_Rule_Description(Integer int1) {
	     
	   
	}

	@Then("Verify that the Rule Description field allows less than {int} characters")
	public void verify_that_the_Rule_Description_field_allows_less_than_characters(Integer int1) {
	     
	   
	}

	@When("Enter more than {int} characters in Alert Message")
	public void enter_more_than_characters_in_Alert_Message(Integer int1) {
	     
	   
	}

	@Then("Verify that the Alert Message field does not allow more than {int} characters")
	public void verify_that_the_Alert_Message_field_does_not_allow_more_than_characters(Integer int1) {
	     
	   
	}

	@When("Enter less than {int} characters in Alert Message")
	public void enter_less_than_characters_in_Alert_Message(Integer int1) {
	     
	   
	}

	@Then("Verify that the Alert Message field allows less than {int} characters")
	public void verify_that_the_Alert_Message_field_allows_less_than_characters(Integer int1) {
	     
	   
	}

	@When("click on Rule Status Drop down")
	public void click_on_Rule_Status_Drop_down() {
	     
	   
	}

	@Then("Verify that the Rule Status are displayed")
	public void verify_that_the_Rule_Status_are_displayed() {
	     
	   
	}

	@When("click on Alert Priority Drop down")
	public void click_on_Alert_Priority_Drop_down() {
	     
	   
	}

	@Then("Verify that the Alert Priority list is displayed")
	public void verify_that_the_Alert_Priority_list_is_displayed() {
	     
	   
	}

	@When("click on Consecutive Occurrence Drop down")
	public void click_on_Consecutive_Occurrence_Drop_down() {
	     
	   
	}

	@Then("Verify that the Consecutive Occurrence values are displayed")
	public void verify_that_the_Consecutive_Occurrence_values_are_displayed() {
	     
	   
	}

	@Then("Select any Resource Type")
	public void select_any_Resource_Type() {
	     
	   
	}

	@Then("Verify all the fields in Expression")
	public void verify_all_the_fields_in_Expression() {
	     
	   
	}

	@When("Select only the drop down  mandatory fields and click on Validate Rule button")
	public void select_only_the_drop_down_mandatory_fields_and_click_on_Validate_Rule_button() {
	     
	   
	}

	@Then("Verify that the Validation message is displayed")
	public void verify_that_the_Validation_message_is_displayed() {
	     
	   
	}

	@Then("Verify that the Save button is Disabled")
	public void verify_that_the_Save_button_is_Disabled() {
	     
	   
	}

	@When("Click on Cancel button")
	public void click_on_Cancel_button() {
	     
	   
	}

	@Then("verify that the user is in Alert settings page")
	public void verify_that_the_user_is_in_Alert_settings_page() {
	     
	   
	}

	@Then("Verify all the all the previous data is deleted and new page is displayed")
	public void verify_all_the_all_the_previous_data_is_deleted_and_new_page_is_displayed() {
	     
	   
	}

	@When("Enter values only on all the text fields in the page and click on Validate Rule button")
	public void enter_values_only_on_all_the_text_fields_in_the_page_and_click_on_Validate_Rule_button() {
	     
	   
	}

	@When("Enter Invalid details in the page and click on Validate Rule button")
	public void enter_Invalid_details_in_the_page_and_click_on_Validate_Rule_button() {
	     
	   
	}

	@When("Click on Save button")
	public void click_on_Save_button() {
	     
	   
	}

	@Then("Verify user is in Create new rule page with no action")
	public void verify_user_is_in_Create_new_rule_page_with_no_action() {
	     
	   
	}

	@When("Enter valid details on all the mandatory fields in the page and click on Validate Rule button")
	public void enter_valid_details_on_all_the_mandatory_fields_in_the_page_and_click_on_Validate_Rule_button() {
	     
	   
	}

	@Then("Verify that the Validation message is displayed as Please enter Inventory Group or Device Name")
	public void verify_that_the_Validation_message_is_displayed_as_Please_enter_Inventory_Group_or_Device_Name() {
	     
	   
	}

	@When("Select any value from Inventory Group or Device Name and click on Validate Rule button")
	public void select_any_value_from_Inventory_Group_or_Device_Name_and_click_on_Validate_Rule_button() {
	     
	   
	}

	@Then("Verify that the Validation message is displayed for Expression")
	public void verify_that_the_Validation_message_is_displayed_for_Expression() {
	     
	   
	}

	@When("Select any valid Expression and click on Validate Rule button")
	public void select_any_valid_Expression_and_click_on_Validate_Rule_button() {
	     
	   
	}

	@Then("Verify that the Validation success message is displayed")
	public void verify_that_the_Validation_success_message_is_displayed() {
	     
	   
	}

	@Then("Verify that the Save button is Enabled")
	public void verify_that_the_Save_button_is_Enabled() {
	     
	   
	}

	@Then("Verify that the rules is Saved in Settings")
	public void verify_that_the_rules_is_Saved_in_Settings() {
	     
	   
	}

	@When("Enter all the mandatory fields except Expression")
	public void enter_all_the_mandatory_fields_except_Expression() {
	     
	   
	}

	@When("Select any value from counters")
	public void select_any_value_from_counters() {
	     
	   
	}

	@When("Select condition as lesser than")
	public void select_condition_as_lesser_than() {
	     
	   
	}

	@When("Select value as {int}")
	public void select_value_as(Integer int1) {
	     
	   
	}

	@When("Select operator as {string}")
	public void select_operator_as(String string) {
	     
	   
	}

	@When("Click on Add Expression")
	public void click_on_Add_Expression() {
	     
	   
	}

	@When("Select the same value from counters")
	public void select_the_same_value_from_counters() {
	     
	   
	}

	@When("Select condition for second expression as greater than")
	public void select_condition_for_second_expression_as_greater_than() {
	     
	   
	}

	@When("Select value for second expression as {int}")
	public void select_value_for_second_expression_as(Integer int1) {
	     
	   
	}

	@When("Select operator for second expression as {string}")
	public void select_operator_for_second_expression_as(String string) {
	     
	   
	}

	@When("Select the two Expressions checkboxes")
	public void select_the_two_Expressions_checkboxes() {
	     
	   
	}

	@When("click on Validate Rule button")
	public void click_on_Validate_Rule_button() {
	     
	   
	}

	@Then("Verify that the Expression Error message is Displayed")
	public void verify_that_the_Expression_Error_message_is_Displayed() {
	     
	   
	}

	@When("Select condition as Equals")
	public void select_condition_as_Equals() {
	     
	   
	}

	@When("Select condition for second expression as contains")
	public void select_condition_for_second_expression_as_contains() {
	     
	   
	}

	@Then("Verify that the Expression Validation success message is Displayed")
	public void verify_that_the_Expression_Validation_success_message_is_Displayed() {
	     
	   
	}
}

