package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import io.github.sukgu.support.ElementFieldDecorator;
import io.github.sukgu.support.FindElementBy;

public class HomePage{
	
	WebDriver driver;
	
	@FindBy(css = ".search-button")
	private WebElement btnSearch;
	
	@FindElementBy(xpath = "//div[@class='forceSearchAssistantDialog']//input[@type='search']")
	private WebElement txtSearch;
	
	@FindBy(xpath = "//div[@class='slds-icon-waffle']/..")
	private WebElement btnWaffleIcon;
	
	//Shadow Element
	@FindElementBy(css = "input.slds-input[placeholder='Search apps and items...']")
	private WebElement txtSearchAppsItems;
	
	@FindBy(css = "div[title='User Detail']")
	private WebElement btnUserDetails;
	
	@FindBy(css = "input[name='login']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//iframe[contains(@name,'vfFrameId_')]")
	private WebElement formIframe;
	
	@FindBy(xpath = "//a[contains(text(),'Log out as ')]")
	private WebElement btnLogOutAsUser;
	
	@FindBy(xpath = "//span[contains(text(),'This page has an error. You might just need to refresh it')]")
	private WebElement popUpSorryToInterrupt;
	
	@FindBy(xpath = "//h1[text()='Salesforce User Active']")
	private WebElement headerSalesforceUserActive;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
		PageFactory.initElements(decorator, this);
	}

	public void setSearchAndSubmit(String text) {
		Utilities.waitForPageLoaded(driver);
		openSearchBar();
		txtSearch.sendKeys(text);
		txtSearch.sendKeys(Keys.ENTER);
	}
	
	public void clickWaffleIcon() {
		btnWaffleIcon.click();
	}
	
	public void setSearchAppsAndSubmit(String text) {
		Utilities.waitForElementToBeDisplayed(driver, txtSearchAppsItems);
		txtSearchAppsItems.click();
		txtSearchAppsItems.sendKeys(text);
		txtSearchAppsItems.sendKeys(Keys.ENTER);
		Utilities.waitForPageLoaded(driver);
		isAppAlreadyOpen(text);
	}
	
	public void setSearchAppsAndSubmitNoAccess(String text) {
		Utilities.waitForElementToBeDisplayed(driver, txtSearchAppsItems);
		txtSearchAppsItems.click();
		txtSearchAppsItems.sendKeys(text);
		txtSearchAppsItems.sendKeys(Keys.ENTER);
		Utilities.waitForPageLoaded(driver);
		Assert.assertTrue(!isAppAlreadyOpen(text), "User should not have access to " + text);
	}
	
	public void searchInSalesforce (String text) {
		this.setSearchAndSubmit(text);
		Utilities.waitForPageLoaded(driver);
		if(driver.getTitle().contains("Search")){
			try {
				driver.findElement(By.cssSelector("a[title='" + text + "']")).click();
			}catch (NoSuchElementException | TimeoutException e){
				driver.findElement(By.xpath("//a[text()='" + text + "']")).click();
			}
		}
		
	}
	
	public void searchAccountInSalesforce (String text) {
		this.setSearchAndSubmit(text);
		Utilities.waitForPageLoaded(driver);
		driver.findElement(By.cssSelector("h2>a[data-refid='recordId']")).click();
	}
	
	public boolean isLoggedtoSalesforce() {
		return btnSearch.isDisplayed();
	}
	
	public boolean isAppAlreadyOpen(String text) {
		Utilities.waitForPageLoaded(driver);
		try {
			Utilities.waitForElementToBeDisplayed(driver, driver.findElement(By.xpath("//div[contains(@class,'appName')]/span[text()='" + text + "']")), 2);
			return true;
		}catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
		
	}
	
	public void openSearchBar() {
		int count = 3;
		while(count > 0) {
			
			try{
				btnSearch.click();
				Utilities.waitForElementToBeDisplayed(driver, txtSearch, 2);
				break;
			} catch (NoSuchElementException | TimeoutException e){
				count--;
			
			}
			
		}
	}
	
	public boolean isUserDetailsButtonDisplayed() {
		boolean flag = false;
		
		try {
			Utilities.waitForElementToBeClickable(driver, btnUserDetails, 5);
			flag = true;
			
		}catch (NoSuchElementException | StaleElementReferenceException e) {
			flag = false;	
		}
		return flag;
	}


	
	public void clickUserDetails() {
		btnUserDetails.click();
	}
	
	public void clickLogin() {
		switchDefaultContent();
		switchToIframe();
		Utilities.scrollToElement(driver, btnLogin);
		btnLogin.click();
		switchDefaultContent();
	}
	
	public void switchToIframe() {
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe[contains(@name,'vfFrameId_')]"));	
		driver.switchTo().frame(iframes.get(iframes.size()-1));
	}
	
	public void switchDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public void logOutAsUser() {
		btnLogOutAsUser.click();
	}
	
	public void closeAllRetrievalConsoleTabs() {
		try {
		      List<WebElement> elements = driver.findElements(By.xpath("//*[local-name()='svg'][@data-key='close']"));
		      for(WebElement element: elements){
		         element.click();
		      }
		}catch(Exception e){
			System.out.println("No tabs to close");
		}
	}
}
