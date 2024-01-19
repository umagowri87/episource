package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import pageobjects.MCCChartWorkflowTabPage;
import pageobjects.MCCHomePage;

public class MCCChartCustomFieldTabDefinition {
	
	WebDriver driver = CommonDefinitions.driver;
	// objMCCHomePage;
	LoginPage objLoginPage;

	MCCHomePage objMCCHomePage = new MCCHomePage(driver);
	MCCChartWorkflowTabPage objMCCChartWorkflowTabPage = new MCCChartWorkflowTabPage(driver);
	
	@Given("the user is in home page")
	public void the_user_is_in_home_page() {
		// Write code here that turns the phrase above into concrete actions
		// driver.get("https://episource--qa.sandbox.my.salesforce.com/home/home.jsp?sdtd=1");
		String title = driver.getTitle();
		System.out.println("title :" + title);
		assertEquals(title, "Salesforce - Unlimited Edition");

	}

	@When("click on MCC Chart Queue")
	public void click_on_mcc_chart_queue() {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getMCC_chartQ().click();
	}

	@When("click on {string} tab")
	public void click_on_tab(String string) {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getMPCtab().click();
	}

	@When("user clicks on {string} chart")
	public void user_clicks_on_chart(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.openChartId(string);
		objMCCHomePage.switchToMccChart();
	}

	@Then("verify for the {string} chart")
	public void verify_for_the_chart(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		//Assert.assertTrue(driver.getCurrentUrl().contains("MedicalChartCoding"));
		//Assert.assertTrue(driver.getTitle().contains("A-FMR9K8"));

	}

	@Then("Verify for {string} field is present")
	public void verify_for_field_is_present(String string) {
		// Write code here that turns the phrase above into concrete actions
		try {
			if(objMCCHomePage.getUMID().isDisplayed()) {
				 assertTrue(objMCCHomePage.getUMID().isDisplayed());
				 assertEquals(objMCCHomePage.getUMID().getText(), string);
				 assertTrue(objMCCHomePage.getCustom_textUMID().isEnabled());
				
			}
			
			else {
				objMCCChartWorkflowTabPage.getWf_CustomFields().click();
				 assertTrue(objMCCHomePage.getUMID().isDisplayed());
				 assertEquals(objMCCHomePage.getUMID().getText(), string);
				 assertTrue(objMCCHomePage.getCustom_textUMID().isEnabled());
			}
		}
		catch(NoSuchElementException e)
		{
			objMCCChartWorkflowTabPage.getWf_CustomFields().click();

			 assertTrue(objMCCHomePage.getUMID().isDisplayed());
			 assertEquals(objMCCHomePage.getUMID().getText(), string);
			 assertTrue(objMCCHomePage.getCustom_textUMID().isEnabled());
		
		}

		 assertTrue(objMCCHomePage.getUMID().isDisplayed());
		 assertEquals(objMCCHomePage.getUMID().getText(), string);
		 assertTrue(objMCCHomePage.getCustom_textUMID().isEnabled());
	}

	@Then("verify field {string}")
	public void verify_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getCoderName().isDisplayed());
		 assertEquals(objMCCHomePage.getCoderName().getText(), string);
		 assertTrue(objMCCHomePage.getCustom_textCoderName().isEnabled());
	}

	@Then("validate for {string}")
	public void validate_for(String string) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getCoderCredential().isDisplayed());
		 assertEquals(objMCCHomePage.getCoderCredential().getText(), string);
		 assertTrue(objMCCHomePage.getCustom_CoderCredential().isEnabled());
	}

	@Then("verify for {string} field")
	public void verify_for_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getProviderEducationRequired().isDisplayed());
		 assertEquals(objMCCHomePage.getProviderEducationRequired().getText(), string);
		 assertTrue(objMCCHomePage.getCustom_textProviderEducationRequired().isEnabled());

	}

	@Then("verify for {string} is displayed")
	public void verify_for_is_displayed(String string) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getEducationDescription().isDisplayed());
		 assertEquals(objMCCHomePage.getEducationDescription().getText(), string);
		 assertTrue(objMCCHomePage.getCustom_textEducationDescription().isEnabled());

	}
	
	@Then("click save buttton")
	public void click_save_buttton() {
	    // Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getWf_savebutton().click();
		objMCCHomePage.getOK().click();
	}
	

	

}
