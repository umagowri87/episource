package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.MCCChartURLTabPage;
import pageobjects.MCCChartWorkflowTabPage;
import pageobjects.MCCHomePage;
import pageobjects.Utilities;

public class MCCChartWorkflowDefinition {
	
	WebDriver driver = CommonDefinitions.driver;
	MCCChartWorkflowTabPage objMCCChartWorkflowTabPage = new MCCChartWorkflowTabPage(driver);
	MCCHomePage objMCCHomePage = new MCCHomePage(driver);

	@Then("click on Workflow tab")
	public void click_on_workflow_tab() {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getTab_WorkFlow().click();

	}

	@Then("check for {string},{string},{string} fields are present")
	public void check_for_fields_are_present(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartWorkflowTabPage.getWorkflow_Username().isDisplayed());
		 assertFalse(objMCCChartWorkflowTabPage.getWorkflow_L1User().isEnabled());
		 assertEquals(objMCCChartWorkflowTabPage.getWorkflow_Username().getText(), string);

		 assertTrue(objMCCChartWorkflowTabPage.getWorkflow_Starttime().isDisplayed());
		 assertFalse(objMCCChartWorkflowTabPage.getWorkflow_L1StartTime().isEnabled());
		 assertEquals(objMCCChartWorkflowTabPage.getWorkflow_Starttime().getText(), string2);

		 assertTrue(objMCCChartWorkflowTabPage.getWorkflow_Finishtime().isDisplayed());
		 assertFalse(objMCCChartWorkflowTabPage.getWorkflow_L1FinishTime().isEnabled());
		 assertEquals(objMCCChartWorkflowTabPage.getWorkflow_Finishtime().getText(), string3);
	    System.out.println("Executed");
	}

	@When("click on workflow tab")
	public void click_on_workflow_tab1() {
	    // Write code here that turns the phrase above into concrete actions
	    objMCCHomePage.getTab_WorkFlow().click();
	}
	

	@Then("check for {string},{string},{string},{string} fields are present")
	public void check_for_fields_are_present(String string, String string2, String string3, String string4) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartWorkflowTabPage.getDemo_status().isDisplayed());
		 assertEquals(objMCCChartWorkflowTabPage.getDemo_status().getText(), string);
		 assertTrue(objMCCChartWorkflowTabPage.getDemo_textStatus().isEnabled());
		
		 assertTrue(objMCCChartWorkflowTabPage.getWf_NLP().isDisplayed());
		 assertEquals(objMCCChartWorkflowTabPage.getWf_NLP().getText(), string2);
		 assertFalse(objMCCChartWorkflowTabPage.getWf_checkboxNLP().isEnabled());
		
		 assertTrue(objMCCChartWorkflowTabPage.getWf_NLPOutcome().isDisplayed());
		 assertEquals(objMCCChartWorkflowTabPage.getWf_NLPOutcome().getText(),string3);
		 assertFalse(objMCCChartWorkflowTabPage.getWf_textNLPOutcome().isEnabled());
		
		 assertTrue(objMCCChartWorkflowTabPage.getWf_TotalPages().isDisplayed());
		 assertEquals(objMCCChartWorkflowTabPage.getWf_TotalPages().getText(),string4);
		 assertTrue(objMCCChartWorkflowTabPage.getWf_textTotalPages().isEnabled());
		
		
		
	}
    
	@Then("verify for Status drop down values {string},{string},{string}")
	public void verify_for_status_drop_down_values(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
	
		String[] select_values= {string,string2,string3};
		objMCCChartWorkflowTabPage.getDemo_textStatus().click();
	
		List<WebElement> status = objMCCChartWorkflowTabPage.getWf_statusvalues();
		
		for (int i=0;i<status.size();i++) {
			WebElement element = status.get(i);
			Actions action = new Actions(driver);

			//Performing the mouse hover action on the target element.
			action.moveToElement(element).perform();
			
     		String attribute=element.getText();
     		//System.out.println("Attribute :"+attribute);
     		//System.out.println("Given string :"+select_values[i]);
     		 assertEquals(attribute,select_values[i]);
			//System.out.println("Values of dropdown :"+attribute);
		}
		objMCCChartWorkflowTabPage.getDemo_status().click();
	
	}
	
	@Then("verify and click on {string} button")
	public void verify_and_click_on_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartWorkflowTabPage.getWf_PDFViewAccesss().isDisplayed());
		 assertEquals(objMCCChartWorkflowTabPage.getWf_PDFViewAccesss().getText(), string);
		objMCCChartWorkflowTabPage.getWf_PDFViewAccesss().click();
	}
	@Then("verify for {string} , {string} and {string} button")
	public void verify_for_and_button(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
		
		 assertTrue(objMCCChartWorkflowTabPage.getWf_PDFAccessReason().isDisplayed());
		 assertEquals(objMCCChartWorkflowTabPage.getWf_PDFAccessReason().getText(), string);
		 assertTrue(objMCCChartWorkflowTabPage.getWf_txtPDFAccessReason().isEnabled());
		
		 assertTrue(objMCCChartWorkflowTabPage.getWf_Timestamp().isDisplayed());
		 assertEquals(objMCCChartWorkflowTabPage.getWf_Timestamp().getText(), string2);
		 assertFalse(objMCCChartWorkflowTabPage.getWf_textTimestamp().isEnabled());
		
		 assertTrue(objMCCChartWorkflowTabPage.getWf_SubmitReason().isDisplayed());
		 assertEquals(objMCCChartWorkflowTabPage.getWf_SubmitReason().getText(), string3);
		// assertTrue(objMCCChartWorkflowTabPage.getWf_textTimestamp().isEnabled());
	
		
	
	}
	
	@Then("verify for dropdown PDF Access Reason values {string},{string},{string} and {string}")
	public void verify_for_dropdown_pdf_access_reason_values_and(String string, String string2, String string3, String string4) {
	    // Write code here that turns the phrase above into concrete actions
		String[] select_values= {string,string2,string3,string4};
		objMCCChartWorkflowTabPage.getWf_txtPDFAccessReason().click();
		 List<WebElement> status = objMCCChartWorkflowTabPage.getWf_PDFAccessReasonvalues();
			//System.out.println("size :"+status.size());
			for (int i=0;i<status.size();i++) {
				WebElement element = status.get(i);
				Actions action = new Actions(driver);

				//Performing the mouse hover action on the target element.
				action.moveToElement(element).perform();
				
	     		String attribute=element.getText();
	     		//System.out.println("Attribute :"+attribute);
	     		//System.out.println("Given string :"+select_values[i]);
	     		 assertEquals(attribute,select_values[i]);
				//System.out.println("Values of dropdown :"+attribute);
			}
			objMCCChartWorkflowTabPage.getWf_imageissue().click();
	}
	
	@And("check for {string} button and click on it")
	public void check_for_button_and_click_on_it(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartWorkflowTabPage.getWf_CustomFields().isEnabled());
		 assertTrue(objMCCChartWorkflowTabPage.getWf_CustomFields().isDisplayed());
		// assertEquals(objMCCChartWorkflowTabPage.getWf_CustomFields().getText(), string);
		//Utilities.clickonElement(objMCCChartWorkflowTabPage.getWf_CustomFields());
		//objMCCChartWorkflowTabPage.getWf_CustomFields().click();
		Actions action = new Actions(driver); 
		action.moveToElement(objMCCChartWorkflowTabPage.getWf_CustomFields()).click();
	}


}
