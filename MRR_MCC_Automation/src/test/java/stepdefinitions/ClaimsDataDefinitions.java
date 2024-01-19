package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;

import io.cucumber.java.en.Then;
import pageobjects.MCCClaimsDataTab;

public class ClaimsDataDefinitions {

	WebDriver driver = CommonDefinitions.driver;
	MCCClaimsDataTab ClaimsData = new MCCClaimsDataTab(driver);
	
	
	
	@Then("click on Claims Data tab")
	public void click_on_claims_data_tab() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Claims Data");
		try {
		ClaimsData.getClaimsDataTab().click();
		}
		catch(ElementClickInterceptedException e) {
			
			ClaimsData.getClaimsDataTab().click();
		}
	   
	}
	@Then("validate {string}, {string},{string},{string},{string},{string} {string} and {string} fields")
	public void validate_and_fields(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8)  {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(ClaimsData.getDOSFrom().isDisplayed());
		 assertEquals(ClaimsData.getDOSFrom().getText(),string);
		// assertTrue(MPD.getMPD_MemberDetails().isEnabled());
		
		 assertTrue(ClaimsData.getDOSTo().isDisplayed());
		 assertEquals(ClaimsData.getDOSTo().getText(),string2);
		
		 assertTrue(ClaimsData.getProviderName().isDisplayed());
		 assertEquals(ClaimsData.getProviderName().getText(),string3);
		
		 assertTrue(ClaimsData.getProviderID().isDisplayed());
		 assertEquals(ClaimsData.getProviderID().getText(),string4);
		
		 assertTrue(ClaimsData.getProviderNPI().isDisplayed());
		 assertEquals(ClaimsData.getProviderNPI().getText(),string5);
		
		 assertTrue(ClaimsData.getDXCode().isDisplayed());
		 assertEquals(ClaimsData.getDXCode().getText(),string6);
		
		 assertTrue(ClaimsData.getClaimId().isDisplayed());
		 assertEquals(ClaimsData.getClaimId().getText(),string7);
		
		 assertTrue(ClaimsData.getProviderAddress().isDisplayed());
		 assertEquals(ClaimsData.getProviderAddress().getText(),string8);
		
	}
	

	
}

