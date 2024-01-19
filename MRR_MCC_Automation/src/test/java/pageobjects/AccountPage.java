package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.github.sukgu.support.ElementFieldDecorator;

public class AccountPage {
	
	WebDriver driver;
	//name Account.View_Active_Lists
	//c-view-active-list-cmp//table//th[@aria-label='Location ID']
	//c-view-active-list-cmp//table//th[@aria-label='Workflow Status']
	//c-view-active-list-cmp//table//th[@aria-label='Project Name']
	//c-view-active-list-cmp//table//th[@aria-label='Site']
	
	//flexipage-component2//table//th[@aria-label='Location ID']
	//flexipage-component2//table//th[@aria-label='Workflow Status']
	//flexipage-component2//table//th[@aria-label='Project Name']
	//flexipage-component2//table//th[@aria-label='Site']
	
	@FindBy(xpath = "//span[text()='Provider Addresses']/../../../..//div[text()='New']")
	private WebElement btnNewProviderAddress;
	
	@FindBy(css = "input[value='Cancel']")
	private WebElement btnCancel;
	
	@FindBy(id = "page:form:PageBlock:Mainpbs:j_id2")
	private WebElement txtFacilityName;
	
	@FindBy(id = "page:form:PageBlock:Mainpbs:j_id3")
	private WebElement ddAddressType;
	
	@FindBy(id = "page:form:PageBlock:Mainpbs:j_id5")
	private WebElement cbVerified;
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
		PageFactory.initElements(decorator, this);
	}
	
	public boolean isAccountPageDisplayed(String text) {
		Utilities.waitForPageLoaded(driver);
		if(text.substring(0, 2).toUpperCase().equals("G-") || text.substring(0, 2).toUpperCase().equals("S-")) {
			return driver.findElement(By.xpath("//a[text()='" + text + "']")).isDisplayed();
		}else {
			return driver.findElement(By.xpath("//lightning-formatted-text[text()='" + text + "']")).isDisplayed();
		}
		
	}
	
	
}
