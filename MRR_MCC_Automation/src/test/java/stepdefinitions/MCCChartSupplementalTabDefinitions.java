package stepdefinitions;

import org.openqa.selenium.WebDriver;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import io.cucumber.java.en.Then;
import pageobjects.MCCChartProjectTabPage;
import pageobjects.MCCChartSupplementalTabPage;
import pageobjects.MCCHomePage;

public class MCCChartSupplementalTabDefinitions {

	WebDriver driver = CommonDefinitions.driver;
	MCCChartSupplementalTabPage objMCCChartSupplementalTabPage = new MCCChartSupplementalTabPage(driver);
	MCCHomePage objMCCHomePage = new MCCHomePage(driver);

	@Then("click on supplemental tab")
	public void click_on_supplemental_tab() {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getTab_supplemental().click();
	}

	@Then("validate {string}, {string},{string}, and {string}")
	public void validate_and(String string, String string2, String string3, String string4) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DOSFrom().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DOSFrom().getText(),string);
		
		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DOSTo().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DOSTo().getText(),string2);

		// assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DOSTo().getText(),string2);
		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_ProviderNumber().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_ProviderNumber().getText(),string3);

		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode1().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode1().getText(),string4);

		
	}

	@Then("verify {string},{string},{string},{string},{string},{string},{string}")
	public void verify(String string, String string2, String string3, String string4, String string5, String string6,
			String string7) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode2().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode2().getText(),string);

		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode3().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode3().getText(),string2);

		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode4().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode4().getText(),string3);

		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode5().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode5().getText(),string4);

		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode6().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode6().getText(),string5);

		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode7().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode7().getText(),string6);

		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode8().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_DXCode8().getText(),string7);

		
	}

	@Then("verify {string} and {string}")
	public void verify_and(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_ProviderName().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_ProviderName().getText(),string);

		 assertTrue(objMCCChartSupplementalTabPage.getSupplementalTab_ProviderAddress().isDisplayed());
		 assertEquals(objMCCChartSupplementalTabPage.getSupplementalTab_ProviderAddress().getText(),string2);


	}

}
