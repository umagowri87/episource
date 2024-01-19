package stepdefinitions;

import io.cucumber.java.en.When;

import pageobjects.MCCPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class MCCPageDefinitions {
	WebDriver driver = CommonDefinitions.driver;
	MCCPage objMCCPage;
	
	
	@When("Open MCC Chart Queue")
	public void openMCCChartQueue()                                                   {
		
		objMCCPage = new MCCPage(driver);
		objMCCPage.clickCharQueueTab();
		
	}
	
}
