package stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.HomePage;
import pageobjects.Utilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class HomePageDefinitions {
	WebDriver driver = CommonDefinitions.driver;
	HomePage objHomePage;
	
	@Given("I am logged in at Salesforce")
	public void isLoggedToSalesforce() {
		
		objHomePage = new HomePage(driver);
		Assert.assertTrue(objHomePage.isLoggedtoSalesforce(), "User is not logged to Salesforce");
	}
	
	@When("Open {string} app")
	public void openApp(String text)                                                   {
		
		objHomePage = new HomePage(driver);
		if(!objHomePage.isAppAlreadyOpen(text)) {
			objHomePage.clickWaffleIcon();
			objHomePage.setSearchAppsAndSubmit(text);
		}
		if(text.toUpperCase().contains("RETRIEVAL CONSOLE")) {
			objHomePage.closeAllRetrievalConsoleTabs();
		}
		
	}
	
	@When("Search for {string}")
	public void search(String text) {
		
		objHomePage = new HomePage(driver);
		objHomePage.searchInSalesforce(text);
	}
	
	@When("Search for Account {string}")
	public void searchAccount(String text) {
		
		objHomePage = new HomePage(driver);
		objHomePage.searchAccountInSalesforce(text);
	}
	
	@When("Log in as {string}")
	public void logInAs(String text) {
		
		objHomePage = new HomePage(driver);
		objHomePage.searchInSalesforce(text);
		if(objHomePage.isUserDetailsButtonDisplayed()) {
			objHomePage.clickUserDetails();
			Utilities.pageLoadTime(driver, "userDetails");
		}
		objHomePage.clickLogin();
		Utilities.pageLoadTime(driver, "LoginAsUser");
	}
	
	@Then("Log out as User")
	public void logOutAsUser(){
		objHomePage = new HomePage(driver);
		objHomePage.logOutAsUser();
		Utilities.pageLoadTime(driver, "LogOutAsUser");
	}
	
	@Then("User is unable to open {string} app")
	public void unableToOpenApp(String text) {
		
		if(!objHomePage.isAppAlreadyOpen(text)) {
			objHomePage.clickWaffleIcon();
			objHomePage.setSearchAppsAndSubmitNoAccess(text);
		}else {
			Assert.assertTrue(false, "User should not have access to " + text + " app");
		}
	}
}
