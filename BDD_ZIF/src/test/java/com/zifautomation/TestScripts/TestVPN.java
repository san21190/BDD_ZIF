package com.zifautomation.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class TestVPN {

	@Test
	public void run() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.out.println("Chrome Browser Launched.........");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		System.out.println("W3Schools Url is Launched...........");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		
		driver.findElementByXPath("//button[text()='Try it']").click();
		Alert newalert = driver.switchTo().alert();
		System.out.println("Switched to Alert............");
		
		newalert.sendKeys("PrasanthvbTestVPN");
		newalert.accept();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='iframewrapper']/iframe)")));
		String trytext = driver.findElementById("demo").getText();
		if (trytext.contains("TestVPN")) {
		System.out.println(trytext);							
		}
		driver.close();
	}

}
