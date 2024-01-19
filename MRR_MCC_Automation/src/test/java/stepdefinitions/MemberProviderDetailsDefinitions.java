package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;

import io.cucumber.java.en.Then;
import pageobjects.Member_Provider_Details_tab;

public class MemberProviderDetailsDefinitions {
	
	WebDriver driver = CommonDefinitions.driver;
	Member_Provider_Details_tab MPD = new Member_Provider_Details_tab(driver);

	@Then("click on tab {string}")
	public void click_on_tab(String string) {
	    // Write code here that turns the phrase above into concrete actions
	     MPD.getMember_ProviderDetailsTab().click();
	}
	@Then("verify for {string},{string},{string},{string},{string},{string}")
	public void verify_for(String string, String string2, String string3, String string4, String string5, String string6) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(MPD.getMPD_MemberDetails().isDisplayed());
		 assertEquals(MPD.getMPD_MemberDetails().getText(), string);
		 assertTrue(MPD.getMPD_MemberDetails().isEnabled());
		
		 assertTrue(MPD.getMPD_MemberID().isDisplayed());
		 assertEquals(MPD.getMPD_MemberID().getText(), string2);
		 assertTrue(MPD.getMPD_MemberID().isEnabled());
		
		 assertTrue(MPD.getMPD_MemberHICN().isDisplayed());
		 assertEquals(MPD.getMPD_MemberHICN().getText(), string3);
		 assertTrue(MPD.getMPD_MemberHICN().isEnabled());
		
		 assertTrue(MPD.getMPD_MemberMBI().isDisplayed());
		 assertEquals(MPD.getMPD_MemberMBI().getText(), string4);
		 assertTrue(MPD.getMPD_MemberMBI().isEnabled());
		
		 assertTrue(MPD.getMPD_ChaseID().isDisplayed());
		 assertEquals(MPD.getMPD_ChaseID().getText(), string5);
		 assertTrue(MPD.getMPD_ChaseID().isEnabled());
		
		 assertTrue(MPD.getMPD_MemberAddress().isDisplayed());
		 assertEquals(MPD.getMPD_MemberAddress().getText(), string6);
		 assertTrue(MPD.getMPD_MemberAddress().isEnabled());
	}
	@Then("check for {string},{string},{string},{string},{string}")
	public void check_for(String string, String string2, String string3, String string4, String string5) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(MPD.getMPD_ProviderDetails().isDisplayed());
		 assertEquals(MPD.getMPD_ProviderDetails().getText(), string);
		 assertTrue(MPD.getMPD_ProviderDetails().isEnabled());
		
		 assertTrue(MPD.getMPD_ProviderFirstName().isDisplayed());
		 assertEquals(MPD.getMPD_ProviderFirstName().getText(), string2);
		 assertTrue(MPD.getMPD_ProviderFirstName().isEnabled());
		
		 assertTrue(MPD.getMPD_ProviderLastName().isDisplayed());
		 assertEquals(MPD.getMPD_ProviderLastName().getText(), string3);
		 assertTrue(MPD.getMPD_ProviderLastName().isEnabled());
		
		 assertTrue(MPD.getMPD_ProviderID().isDisplayed());
		 assertEquals(MPD.getMPD_ProviderID().getText(), string4);
		 assertTrue(MPD.getMPD_ProviderID().isEnabled());
		
		 assertTrue(MPD.getMPD_ProviderNPI().isDisplayed());
		 assertEquals(MPD.getMPD_ProviderNPI().getText(), string5);
		 assertTrue(MPD.getMPD_ProviderNPI().isEnabled());
		  
	}
	@Then("validate for {string},{string},{string},{string}")
	public void validate_for(String string, String string2, String string3, String string4) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(MPD.getMPD_ProviderTIN().isDisplayed());
		 assertEquals(MPD.getMPD_ProviderTIN().getText(), string);
		 assertTrue(MPD.getMPD_ProviderTIN().isEnabled());
		
		 assertTrue(MPD.getMPD_ProviderSpeciality().isDisplayed());
		 assertEquals(MPD.getMPD_ProviderSpeciality().getText(), string2);
		 assertTrue(MPD.getMPD_ProviderSpeciality().isEnabled());
		
		 assertTrue(MPD.getMPD_ProviderCredential().isDisplayed());
		 assertEquals(MPD.getMPD_ProviderCredential().getText(), string3);
		 assertTrue(MPD.getMPD_ProviderCredential().isEnabled());
		
		 assertTrue(MPD.getMPD_ProviderAddress().isDisplayed());
		 assertEquals(MPD.getMPD_ProviderAddress().getText(), string4);
		 assertTrue(MPD.getMPD_ProviderAddress().isEnabled());
		
	}


		
	
	
	
}
