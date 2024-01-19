package stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pageobjects.BugReportingPage;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BugReportingPageDefinitions {
	WebDriver driver = CommonDefinitions.driver;
	BugReportingPage objBugReportingPage;
	
	@When("Create a Bug Report")
	public void createBugReport(DataTable dataForm) {
		List<Map<String,String>> data = dataForm.asMaps(String.class,String.class);
		
		objBugReportingPage = new BugReportingPage(driver);
		objBugReportingPage.openBugReportForm();
		objBugReportingPage.fillBugReportForm(data.get(0).get("whichSystem"),
				data.get(0).get("ifOther"), 
				data.get(0).get("numberOfAffected"), 
				data.get(0).get("summary"),
				data.get(0).get("describeTheIssueInDetail"),
				data.get(0).get("whatIsImpact"),
				data.get(0).get("whatAreMembersData"),
				data.get(0).get("whatIsClass"), 
				data.get(0).get("whatIsRisk"));
	}
	
	@Then("Validate values in Bug Report")
	public void validateBugReport(DataTable dataForm) {
		List<Map<String,String>> data = dataForm.asMaps(String.class,String.class);
		
		objBugReportingPage = new BugReportingPage(driver);
		objBugReportingPage.validateBugReport(data.get(0).get("whichSystem"),
				data.get(0).get("ifOther"), 
				data.get(0).get("numberOfAffected"), 
				data.get(0).get("summary"),
				data.get(0).get("describeTheIssueInDetail"),
				data.get(0).get("whatIsImpact"),
				data.get(0).get("whatAreMembersData"),
				data.get(0).get("whatIsClass"), 
				data.get(0).get("whatIsRisk"),
				data.get(0).get("bugPriority"));
	}
	
	@When("Attaching a file to Bug Report")
	public void isNewAddressFormDisplayed() {
		
		objBugReportingPage = new BugReportingPage(driver);
		objBugReportingPage.doAnAttachment();
	}
	
	@Then("File is attached in ticket")
	public void clickCancel() {
		
		objBugReportingPage = new BugReportingPage(driver);
		objBugReportingPage.fileIsAttached();
	}
	
	@Then("Validate If Other, system name field is required")
	public void isRecentlyViewedDisplayed() {
		
		objBugReportingPage = new BugReportingPage(driver);
		objBugReportingPage.ifOtherSystemErrorValidation();
	}
	
	
}
