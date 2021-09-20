package com.zifautomation.Pages;

import com.aventstack.extentreports.ExtentTest;

import junit.framework.Assert;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.zifautomation.Listeners.ExtentReportListener.captureScreenShot;
import static org.testng.Assert.assertTrue;

public class Loginfunction
{
	WebDriver driver;

	public Loginfunction(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how= How.XPATH,using="//input[@type='email']")
	public WebElement UserName;

	@FindBy(how=How.XPATH,using="//input[@type='password']")
	public WebElement Password;

	@FindBy(how=How.XPATH,using="//span[text()='Login']")
	public WebElement LoginButton;

	@FindBy(how=How.XPATH,using="//span[text()='Forgot your password?']")
	public WebElement Forgotpassworlink;

	@FindBy(how=How.XPATH,using="//span[text()='Experience']")
	public WebElement Experience;

	@FindBy(how=How.XPATH,using="//span[text()='ZIF']")
	public WebElement ZIF;

	@FindBy(how = How.XPATH, using="//span[text()='Invalid username or password !!']")
	private WebElement invalidUsernameOrpassword;

	@FindBy(how = How.XPATH, using="//span[contains(text(),'Suspicious behavior detected')]")
	private WebElement suspiciousbehavior;

	public Loginfunction getTitle() {
		driver.getTitle();
		return this;
	}

	public void EnterInvalidcredentials(String username,String password) throws IOException {

		UserName.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
	}

	public void Enterthecredentials(String username,String password) throws IOException, InterruptedException {
		//driver.navigate().refresh();
		UserName.clear();
		UserName.sendKeys(username);
		Password.clear();
		Password.sendKeys(password);
		Thread.sleep(2000);
		LoginButton.click();

	}

	public boolean getTextOfInvalidUsernameOrpassword(){

		try {
			invalidUsernameOrpassword.isDisplayed();
			return true;
		}catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}

	public boolean getTextOfSuspiciousbehavior(){

		try {
			suspiciousbehavior.isDisplayed();
			return true;
		}catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}

	public boolean getExperirnceZIFtext(){

		try {
			Experience.isDisplayed();
			ZIF.isDisplayed();
			return true;
		}catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}}

	public void NavigatetoForgetpasswordpage() {

		try {
			Forgotpassworlink.isDisplayed();
			Forgotpassworlink.click();
			Thread.sleep(3000);

		} catch (Exception e) {

		}}

	public void Check_all_fields_are_present(){


		assertTrue(UserName.isDisplayed());
		assertTrue(Password.isDisplayed());
		assertTrue(LoginButton.isDisplayed());
		assertTrue(Forgotpassworlink.isDisplayed());
		assertTrue(Experience.isDisplayed());
		assertTrue(ZIF.isDisplayed());


	}


}


