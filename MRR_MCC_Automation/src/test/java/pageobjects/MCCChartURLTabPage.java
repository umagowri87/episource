package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.github.sukgu.support.ElementFieldDecorator;

public class MCCChartURLTabPage {
	WebDriver driver;
	
	public MCCChartURLTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
			PageFactory.initElements(decorator, this);
		}
	
	@FindBy(xpath = "//div[contains(text(),'Allow Adobe')]")
	private WebElement chartUrl_allowAdobe;
	
	@FindBy(xpath="//*[@id='AllowAdobe']")
	private WebElement chartUrl_TextallowAdobe;
	
	@FindBy(xpath="//div[contains(text(),'Timestamp')]")
	private WebElement chartUrl_timestamp;
	
	@FindBy(xpath="//*[@id='AllowAdobeTimestamp']")
	private WebElement chartUrl_Texttimestamp;
	
	@FindBy(xpath="//*[@id='AllowAdobeRequestedUserName']")
	private WebElement chartUrl_Textrequest;
	
	@FindBy(xpath="//div[contains(text(),'Requested By')]")
	private WebElement chartUrl_Request;

	public WebElement getChartUrl_allowAdobe() {
		return chartUrl_allowAdobe;
	}

	public WebElement getChartUrl_TextallowAdobe() {
		return chartUrl_TextallowAdobe;
	}

	public WebElement getChartUrl_Texttimestamp() {
		return chartUrl_Texttimestamp;
	}

	public WebElement getChartUrl_Textrequest() {
		return chartUrl_Textrequest;
	}

	public WebElement getChartUrl_timestamp() {
		return chartUrl_timestamp;
	}

	public WebElement getChartUrl_Request() {
		return chartUrl_Request;
	}

}
