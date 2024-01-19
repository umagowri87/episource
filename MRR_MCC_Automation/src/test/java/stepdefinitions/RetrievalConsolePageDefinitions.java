package stepdefinitions;

import io.cucumber.java.en.When;

import pageobjects.MRRPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class RetrievalConsolePageDefinitions {
	WebDriver driver = CommonDefinitions.driver;
	MRRPage objMRRPage;
	
	/*
	@When("Open New Epi Location form")
	public void openNewEpiLocationForm(){
		
		objMRRPage = new MRRPage(driver);
		objMRRPage.clickNewEpiLocation();
		objMRRPage.selectEpiLocation();
	}
	
	@When("Select Copy Service Type as {string}")
	public void selectCopyServiceType(String text){
		
		objMRRPage = new MRRPage(driver);
		objMRRPage.selectCopyServiceType(text);	
	}
	
	@When("Validate that values available in Copy Service field are correct")
	public void validateCopyServiceValues() throws IOException{
		objMRRPage = new MRRPage(driver);
		objMRRPage.validateCopyService();
		objMRRPage.clickCancel();
	}*/
}
