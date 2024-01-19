package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.MCCChartQueuePage;

import pageobjects.MCCDemographicTabPage;
import pageobjects.MCCHomePage;

public class MCCChartDemographicTabDefinitions {

	WebDriver driver = CommonDefinitions.driver;
	MCCDemographicTabPage objMCCDemographicTabPage = new MCCDemographicTabPage(driver);
	MCCHomePage objMCCHomePage = new MCCHomePage(driver);

	@Then("click on Demographic tab")
	public void click_on_demographic_tab() {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getTab_Demographics().click();

	}

	@Then("verify for {string} , {string},{string} and {string} fields")
	public void verify_for_and_fields(String string, String string2, String string3, String string4) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(objMCCDemographicTabPage.getMCC_FirstName().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getMCC_FirstName().getText(), string);
		assertFalse(objMCCDemographicTabPage.getDemo_textFN().isEnabled());
		assertTrue(objMCCDemographicTabPage.getDemo_LastName().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_LastName().getText(), string2);
		assertFalse(objMCCDemographicTabPage.getDemo_textLN().isEnabled());
		assertTrue(objMCCDemographicTabPage.getDemo_MemberId().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_MemberId().getText(), string3);
		assertFalse(objMCCDemographicTabPage.getDemo_textMemberId().isEnabled());
		assertTrue(objMCCDemographicTabPage.getDemo_dob().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_dob().getText(), string4);
		assertFalse(objMCCDemographicTabPage.getDemo_textdob().isEnabled());
	}

	@Then("check for {string},{string},{string} and {string} fields")
	public void check_for_and_fields(String string, String string2, String string3, String string4) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(objMCCDemographicTabPage.getDemo_Gender().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_Gender().getText(), string);
		assertFalse(objMCCDemographicTabPage.getDemo_textGender().isEnabled());
		assertTrue(objMCCDemographicTabPage.getDemo_chaseId().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_chaseId().getText(), string2);
		assertFalse(objMCCDemographicTabPage.getDemo_textChaseId().isEnabled());
		assertTrue(objMCCDemographicTabPage.getDemo_chartpages().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_chartpages().getText(), string3);
		assertTrue(objMCCDemographicTabPage.getDemo_textChartpages().isEnabled());
		assertTrue(objMCCDemographicTabPage.getDemo_nlp().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_nlp().getText(), string4);
		assertFalse(objMCCDemographicTabPage.getDemo_textNLP().isEnabled());

	}

	@Then("validate for {string},{string},{string} and {string} fields")
	public void validate_for_and_fields(String string, String string2, String string3, String string4) {
		// Write code here that turns the phrase above into concrete actions
		/*
		 * assertTrue(objMCCDemographicTabPage.getDemo_status().isDisplayed());
		 * assertEquals(objMCCDemographicTabPage.getDemo_status().getText(), string);
		 * assertTrue(objMCCDemographicTabPage.getDemo_textStatus().isEnabled());
		 */
		assertTrue(objMCCDemographicTabPage.getDemo_holdReason().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_holdReason().getText(), string2);
		assertFalse(objMCCDemographicTabPage.getDemo_textHoldReason().isEnabled());

		assertTrue(objMCCDemographicTabPage.getDemo_HoldComments().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_HoldComments().getText(), string3);
		assertTrue(objMCCDemographicTabPage.getDemo_textHoldComment().isEnabled());

		assertTrue(objMCCDemographicTabPage.getDemo_Icd().isDisplayed());
		assertEquals(objMCCDemographicTabPage.getDemo_Icd().getText(), string4);
		assertTrue(objMCCDemographicTabPage.getDemo_textICD().isEnabled());

	}

	/*
	 * @Given("the user is in home page") public void the_user_is_in_home_page() {
	 * // Write code here that turns the phrase above into concrete actions
	 * driver.get(
	 * "https://episource--qa.sandbox.my.salesforce.com/home/home.jsp?sdtd=1");
	 * String title = driver.getTitle(); System.out.println("title");
	 * objMCCCustomFieldTabPage.getMCC_chartQ().click();
	 * 
	 * }
	 * 
	 * @When("click on MCC Chart Queue") public void click_on_mcc_chart_queue() { //
	 * Write code here that turns the phrase above into concrete actions
	 * 
	 * }
	 * 
	 * @When("click on {string} tab") public void click_on_tab(String string) { //
	 * Write code here that turns the phrase above into concrete actions
	 * 
	 * }
	 * 
	 * @When("user clicks on {string} chart") public void
	 * user_clicks_on_chart(String string) { // Write code here that turns the
	 * phrase above into concrete actions
	 * 
	 * }
	 * 
	 * @Then("verify for the {string} chart") public void
	 * verify_for_the_chart(String string) { // Write code here that turns the
	 * phrase above into concrete actions
	 * 
	 * }
	 */
}
