package stepdefinitions;

import org.openqa.selenium.WebDriver;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;

import io.cucumber.java.en.Then;
import pageobjects.MCCChartDXOtherChartTabPage;
import pageobjects.MCCChartProjectTabPage;
import pageobjects.MCCHomePage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class MCCChartDXFOtherChartsDefinition {
	
	WebDriver driver = CommonDefinitions.driver;
	MCCChartDXOtherChartTabPage objMCCChartDXOtherChartTabPage = new MCCChartDXOtherChartTabPage(driver);
	MCCHomePage objMCCHomePage = new MCCHomePage(driver);
	
	@Then("click on DX Codes from other charts tab")
	public void click_on_dx_codes_from_other_charts_tab() {
	    // Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getTab_Dxcode().click();
	}
	@Then("validate for {string} and {string} fields")
	public void validate_for_and_fields(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartDXOtherChartTabPage.getDXtab_DOSFrom().isDisplayed());
		 assertEquals(objMCCChartDXOtherChartTabPage.getDXtab_DOSFrom().getText(),string);
		 assertTrue(objMCCChartDXOtherChartTabPage.getDXtab_DOSTo().isDisplayed());
		 assertEquals(objMCCChartDXOtherChartTabPage.getDXtab_DOSTo().getText(),string2);


	}


}
