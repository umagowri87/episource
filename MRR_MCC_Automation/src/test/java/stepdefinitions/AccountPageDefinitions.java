package stepdefinitions;

import io.cucumber.java.en.Then;
import pageobjects.AccountPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class AccountPageDefinitions {
	WebDriver driver = CommonDefinitions.driver;
	AccountPage objAccountPage;
	
	@Then("Validate Account {string} is displayed")
	public void isLoggedToSalesforce(String text) {
		
		objAccountPage = new AccountPage(driver);
		Assert.assertTrue(objAccountPage.isAccountPageDisplayed(text), "Account Page is not displayed");
	}
	
	
}
