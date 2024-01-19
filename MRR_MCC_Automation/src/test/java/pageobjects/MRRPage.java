package pageobjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.testng.Assert;

import io.github.sukgu.support.ElementFieldDecorator;

public class MRRPage{
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='More']")
	private WebElement btnMore;
	
	@FindBy(xpath = "//span[text()='Epi Locations']/../..//a/lightning-icon")
	private WebElement btnEpiLocationsMenu;
	
	@FindBy(xpath = "//span[text()='New Epi Location']")
	private WebElement btnNewEpiLocation;
	
	@FindBy(xpath = "//span[text()='Epi Location']/../../div/input")
	private WebElement rbEpiLocation;
	
	@FindBy(xpath = "//span[text()='Humana Location']/../../div/input")
	private WebElement rbHumanaLocation;
	
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement btnNext;
	
	@FindBy(xpath = "//label[text()='Copy Service Type']/..//button")
	private WebElement ddCopyServiceType;
	
	@FindBy(xpath = "//label[text()='Copy Service']/../div//button")
	private WebElement ddCopyService;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;
	
	
	
	public MRRPage(WebDriver driver) {
		this.driver = driver;
		ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
		PageFactory.initElements(decorator, this);
	}
	
	public void clickNewEpiLocation() {
		Utilities.waitForElementToBeDisplayed(driver, btnEpiLocationsMenu, 5);
		for(int i = 0; i<5; i++) {
			btnEpiLocationsMenu.click();
			try {
				Utilities.waitForElementToBeClickable(driver, btnNewEpiLocation, 5);
				Utilities.jsClick(driver, btnNewEpiLocation);
				break;
			}catch(Exception e) {
				continue;
			}
		}
		
	}
	
	public void selectEpiLocation() {
		Utilities.waitForElementToBeDisplayed(driver, rbEpiLocation, 5);
		Utilities.jsClick(driver, rbEpiLocation);
		btnNext.click();
	}
	
	public void selectHumanaLocation() {
		Utilities.waitForElementToBeDisplayed(driver, rbHumanaLocation, 5);
		rbHumanaLocation.click();
		btnNext.click();
	}
	
	public void selectCopyServiceType(String text) {
		Utilities.scrollToElement(driver, ddCopyServiceType);
		ddCopyServiceType.click();
		driver.findElement(By.xpath("//span[@title='" + text + "']")).click();
	}
	
	public void validateCopyService() throws IOException {
		Utilities.scrollToElement(driver, ddCopyService);
		ddCopyService.click();
		boolean foundElement = true;
		String error = "";
		String[] list = Utilities.readFileAsString("src/test/resources/data/CopyService.txt").split(";");
		WebElement element;
		for(String i:list) {
			try{
				element = driver.findElement(By.xpath("//span[@title=\"" + i + "\"]"));
				Utilities.waitForElementToBeDisplayed(driver, element, 5);
			}catch(NoSuchElementException e) {
				foundElement = false;
				error = error + i + ";";
			}
		}
		
		error = error + " and these are Elements found that should not appear: ";
		list = Utilities.readFileAsString("src/test/resources/data/ExcludedCopyService.txt").split(";");
		
		//Change timeout to 1 second temporarily
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		for(String i:list) {
			try{
				element = driver.findElement(By.xpath("//span[@title=\"" + i + "\"]"));
				Utilities.waitForElementToBeDisplayed(driver, element, 1);
				error = error + i + ";";
				foundElement = false;
			}catch(NoSuchElementException e) {
				continue;
			}
		}
		
		//Revert timeout to 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Assert.assertTrue(foundElement, "Elements not found: " + error);
	}
	
	public void clickCancel() {
		Utilities.waitForElementToBeDisplayed(driver, btnCancel, 5);
		btnCancel.click();
	}
}
