package com.zifautomation.Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import com.zifautomation.Base.Base;

public class ZIFAI_Prediction_ExportToExcel extends Base {
	WebDriver driver;

	public ZIFAI_Prediction_ExportToExcel(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how = How.XPATH, using="//span[contains(@class,'hover_menus')]//span[contains(text(),'OPERATIONS')]")
	private WebElement operationheader;
	
	@FindBy(how = How.XPATH, using="//span[text()='Operations']")
	private WebElement PredictionTitle;

	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[1]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement PRcardexport;
	
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[2]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement CRcardexport;
	
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[3]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement PDcardexport;
	
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[4]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement LTcardexport;
	
	@FindBy(how = How.XPATH, using="((//div[contains(@class,'opp-swimlane')])[5]//div[contains(@class,'opp-card-action opp-card-export')])[1]")
	private WebElement IVcardexport;
	
	
	
	public void OperationOptionisavailable(){

		assertTrue(operationheader.isDisplayed());
	}

	public void PredictionisavailableunderOperations(){

		assertTrue(PredictionTitle.isDisplayed());
	}

	public void clickonexportunderPredictedRiskcard(){

		PRcardexport.click();
		}
	
	public void clickonexportunderCritical(){

		CRcardexport.click();
				
	}

	public void clickonexportunderProcessed(){

		PDcardexport.click();
		
		
	}

	public void clickonexportunderLost(){

		LTcardexport.click();
		
		
	}
	public void clickonexportunderInvalid(){

		IVcardexport.click();
	
	}


 


}
