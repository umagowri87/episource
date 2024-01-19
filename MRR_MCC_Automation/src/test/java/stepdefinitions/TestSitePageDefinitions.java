package stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pageobjects.TestSitePage;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestSitePageDefinitions {
	WebDriver driver = CommonDefinitions.driver;
	TestSitePage objTestSitePage;
	
	@Then("Test Site is displayed")
	public void testSiteIsDisplayed() {
		
		objTestSitePage = new TestSitePage(driver);
		Assert.assertTrue(objTestSitePage.isTestSitePageDisplayed(), "Test Site is not being displayed");
	}
	
	@When("Click on New button for Provider Address section")
	public void clickNewAddress() {
		
		objTestSitePage = new TestSitePage(driver);
		objTestSitePage.clickNewProviderAddress();
	}
	
	@Then("New provider address form is displayed")
	public void isNewAddressFormDisplayed() {
		
		objTestSitePage = new TestSitePage(driver);
		Assert.assertTrue(objTestSitePage.isNewProviderAddressFormDisplayed(), "New Address form is not being displayed");
	}
	
	@When("Click to Cancel button")
	public void clickCancel() {
		
		objTestSitePage = new TestSitePage(driver);
		objTestSitePage.clickCancel();
	}
	
	@Then("Recently viewed provider addresses page is displayed.")
	public void isRecentlyViewedDisplayed() {
		
		objTestSitePage = new TestSitePage(driver);
		Assert.assertTrue(objTestSitePage.isRecentlyViewedPageDisplayed(), "Recently Viewed Page is not being displayed");
	}
	
	@When("Filling provider address form")
	public void fillForm(DataTable dataForm) {
		List<Map<String,String>> data = dataForm.asMaps(String.class,String.class);
		
		objTestSitePage = new TestSitePage(driver);
		objTestSitePage.fillForm(data.get(0).get("facilityName"),
				data.get(0).get("addressType"),
				Boolean.valueOf(data.get(0).get("verified")),
				data.get(0).get("activeFromDate"),
				data.get(0).get("activeToDate"),
				data.get(0).get("searchAddress"));
	}
	
	@When("Validate that an address outside US cannot be entered.")
	public void fillFormAddressOutsideUS(DataTable dataForm) {
		List<Map<String,String>> data = dataForm.asMaps(String.class,String.class);
		
		objTestSitePage = new TestSitePage(driver);
		objTestSitePage.fillFormAddressOutsideUS(data.get(0).get("facilityName"),
				data.get(0).get("addressType"),
				Boolean.valueOf(data.get(0).get("verified")),
				data.get(0).get("activeFromDate"),
				data.get(0).get("activeToDate"),
				data.get(0).get("searchAddress"));
	}
	
	@When("Click to Save button")
	public void clickSave() {
		objTestSitePage = new TestSitePage(driver);
		objTestSitePage.clickSave();
	}
	
	@Then("Validate Provider Address")
	public void validateProviderAddress(DataTable dataForm) {
		List<Map<String,String>> data = dataForm.asMaps(String.class,String.class);
		
		objTestSitePage = new TestSitePage(driver);
		objTestSitePage.validateProviderAddress(data.get(0).get("facilityName"),
				data.get(0).get("addressType"),
				Boolean.valueOf(data.get(0).get("verified")),
				data.get(0).get("activeFromDate"),
				data.get(0).get("activeToDate"),
				data.get(0).get("searchAddress"));
	}
	
	@When("Click to Edit button")
	public void clickEdit() {
		objTestSitePage = new TestSitePage(driver);
		objTestSitePage.clickEdit();
	}
	
	@Then("Validate mandatory field error is displayed")
	public void isErrorLabelDisplayed() {
		objTestSitePage = new TestSitePage(driver);
		Assert.assertTrue(objTestSitePage.isErrorLabelDisplayed(), "Error label is not being displayed");
	}
}
