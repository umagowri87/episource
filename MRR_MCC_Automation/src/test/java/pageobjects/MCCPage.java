package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.TimeoutException;

import io.github.sukgu.support.ElementFieldDecorator;

public class MCCPage{
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='More']")
	private WebElement btnMore;
	
	@FindBy(xpath = "//span[text()='MCC Chart Queue']")
	private WebElement btnChartQueue;
	
	@FindBy(xpath = "//one-app-nav-bar-menu-item//span[contains(.,'MCC Chart Queue')]")
	private WebElement btnMoreChartQueue;
	
	
	
	public MCCPage(WebDriver driver) {
		this.driver = driver;
		ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
		PageFactory.initElements(decorator, this);
	}
	
	public void clickCharQueueTab() {
		Utilities.waitForPageLoaded(driver);
		try {
			Utilities.waitForElementToBeDisplayed(driver, btnChartQueue, 5);
			Utilities.jsClick(driver, btnChartQueue);
		}catch (TimeoutException e) {
			btnMore.click();
			Utilities.jsClick(driver, btnMoreChartQueue);
		}
	}
	

}
