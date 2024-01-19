package stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import pageobjects.LIDPage;
import pageobjects.TestSitePage;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class LIDPageDefinitions {
	WebDriver driver = CommonDefinitions.driver;
	LIDPage objLIDPage;
	
	
	@Then("Validate LID {string} is displayed")
	public void isLIDDisplayed(String text){	
		objLIDPage = new LIDPage(driver);
		objLIDPage.isLIDOpen(text);
	}
	
	@Then("Validate Contact section is not displayed")
	public void isContactInformationDisplayed(){
		objLIDPage = new LIDPage(driver);
		objLIDPage.isContactInformationPresent();
	}
	
	@When("Do No Call checkbox is checked")
	public void doNotCallCheckBoxChecked() {
		objLIDPage = new LIDPage(driver);
		objLIDPage.checkDoNotCall();
	}
	
	@When("Do No Call checkbox is unchecked")
	public void doNotCallCheckBoxUnchecked() {
		objLIDPage = new LIDPage(driver);
		objLIDPage.uncheckDoNotCall();
	}
	
	@Then("Validate Do Not Call label is displayed")
	public void doNotCallLabelDisplayed(){	
		objLIDPage = new LIDPage(driver);
		objLIDPage.isDoNotCallPresent();
	}
	
	@Then("Validate Do Not Call label is not displayed")
	public void doNotCallLabelNotDisplayed(){	
		objLIDPage = new LIDPage(driver);
		objLIDPage.isDoNotCallNotPresent();
	}
	
	@When("Click Address Finder")
	public void clickAddressFinder() {
		objLIDPage = new LIDPage(driver);
		objLIDPage.clickAddressFinder();
	}
	
	@When("Search for Address {string}")
	public void searchForAddress(String text) {
		objLIDPage = new LIDPage(driver);
		objLIDPage.fillAddressFinderForm(text);
	}
	
	@Then("Validate all fields are locked but Address line 2")
	public void validateFieldsDisabledAF(){	
		objLIDPage = new LIDPage(driver);
		objLIDPage.validateFieldsDisabledAF();
	}
	
	@Then("Validate Address {string} outside of US cannot be entered")
	public void validateFieldsDisabledAF(String text){	
		objLIDPage = new LIDPage(driver);
		objLIDPage.fillAddressFinderFormOutsideUS(text);
	}
	
	@When("Fill out the Call Log form")
	public void fillCallLogForm(DataTable dataForm) {
		List<Map<String,String>> data = dataForm.asMaps(String.class,String.class);
		
		objLIDPage = new LIDPage(driver);
		objLIDPage.fillCallLogForm(data.get(0).get("callType"),
				data.get(0).get("callCategory"),
				data.get(0).get("callOutcome"),
				data.get(0).get("followUpDate"),
				data.get(0).get("followUpNote"),
				data.get(0).get("comments"));
	}
	
	@Then("Validate Call Outcome value is {string}")
	public void validateCallOutcome(String text) {
		objLIDPage = new LIDPage(driver);
		objLIDPage.validateCallOutcome(text);
	}
	
	@When("Scheduling a Field appointment")
	public void scheduleFieldAppt() {
		objLIDPage = new LIDPage(driver);
		objLIDPage.scheduleFieldAppt();
	}
	
	@When("Scheduling a Remote appointment")
	public void scheduleRemoteAppt() {
		objLIDPage = new LIDPage(driver);
		objLIDPage.scheduleRemoteAppt();
	}
	
	@Then("Validate Workflow Status is {string}")
	public void validateWorkflowStatus(String text) {
		objLIDPage = new LIDPage(driver);
		objLIDPage.validateWorkflowStatus(text);
	}
	
	@Then("Validate Location bar is displayed")
	public void validateWorkflowStatus() {
		objLIDPage = new LIDPage(driver);
		//objLIDPage.validateWorkflowStatus(text);
	}
	
	@Then("User is able to send Provider Packet via Fax")
	public void sendProviderPacketFax() {
		objLIDPage = new LIDPage(driver);
		objLIDPage.providerPacketFaxSend();
	}
	
	@Then("User is able to send Provider Packet via Email")
	public void sendProviderPacketEmail() {
		objLIDPage = new LIDPage(driver);
		objLIDPage.providerPacketEmailSend();
	}
	
	@Then("User is able to generate Provider Packet via Fax")
	public void generateProviderPacketFax() {
		objLIDPage = new LIDPage(driver);
		objLIDPage.providerPacketFaxGenerate();
	}
	
	@Then("User is able to generate Provider Packet via Email")
	public void generateProviderPacketEmail() {
		objLIDPage = new LIDPage(driver);
		objLIDPage.providerPacketEmailGenerate();
	}
}
