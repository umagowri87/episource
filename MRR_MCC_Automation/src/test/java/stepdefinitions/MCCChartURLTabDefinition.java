package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import io.cucumber.java.en.Then;
import pageobjects.MCCChartURLTabPage;
import pageobjects.MCCDemographicTabPage;
import pageobjects.MCCHomePage;

public class MCCChartURLTabDefinition {
	
	WebDriver driver = CommonDefinitions.driver;
	MCCChartURLTabPage objMCCChartURLTabPage = new MCCChartURLTabPage(driver);
	MCCHomePage objMCCHomePage = new MCCHomePage(driver);
	

@Then("clickon ChartUrl tab")
public void clickon_chart_url_tab() {
    // Write code here that turns the phrase above into concrete actions
	objMCCHomePage.getTab_ChartURL().click();
    
}
@Then("verify for {string}, {string} and {string} fields are present")
public void verify_for_and_fields_are_present(String string, String string2, String string3) {
    // Write code here that turns the phrase above into concrete actions
	
	 assertTrue(objMCCChartURLTabPage.getChartUrl_allowAdobe().isDisplayed());
	 assertTrue(objMCCChartURLTabPage.getChartUrl_TextallowAdobe().isEnabled());
	 assertEquals(objMCCChartURLTabPage.getChartUrl_allowAdobe().getText(), string);
	 assertTrue(objMCCChartURLTabPage.getChartUrl_timestamp().isDisplayed());
	 assertFalse(objMCCChartURLTabPage.getChartUrl_Texttimestamp().isEnabled());
	 assertEquals(objMCCChartURLTabPage.getChartUrl_timestamp().getText(), string2);
	 assertTrue(objMCCChartURLTabPage.getChartUrl_Request().isDisplayed());
	 assertFalse(objMCCChartURLTabPage.getChartUrl_Textrequest().isEnabled());
	 assertEquals(objMCCChartURLTabPage.getChartUrl_Request().getText(), string3);
   }

}
