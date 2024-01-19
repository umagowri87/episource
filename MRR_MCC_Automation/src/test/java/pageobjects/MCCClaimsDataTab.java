package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.github.sukgu.support.ElementFieldDecorator;

public class MCCClaimsDataTab {
	
	
WebDriver driver;
	
	public MCCClaimsDataTab(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
			PageFactory.initElements(decorator, this);
		}
	
	@FindBy(xpath="//div[contains(text(),'Claims Data')]")
	private WebElement ClaimsDataTab;
   
	@FindBy(xpath="//*[@id=\"claimsTable\"]/div[4]/div[1]/table/thead/tr/th[1]/div")
	private WebElement DOSFrom;
	
	@FindBy(xpath="//*[@id=\"claimsTable\"]/div[4]/div[1]/table/thead/tr/th[2]/div")
	private WebElement DOSTo;
	
	@FindBy(xpath="//*[@id=\"claimsTable\"]/div[4]/div[1]/table/thead/tr/th[3]/div")
	private WebElement ProviderName;
	
	@FindBy(xpath="//*[@id=\"claimsTable\"]/div[4]/div[1]/table/thead/tr/th[4]/div")
	private WebElement ProviderID;
	
	@FindBy(xpath="//*[@id=\"claimsTable\"]/div[4]/div[1]/table/thead/tr/th[5]/div")
	private WebElement ProviderNPI;
	
	@FindBy(xpath="//*[@id=\"claimsTable\"]/div[2]/table/thead/tr/th[6]/div")
	private WebElement DXCode;
	
	@FindBy(xpath="//*[@id=\"claimsTable\"]/div[2]/table/thead/tr/th[7]/div")
	private WebElement ClaimId;
	
	@FindBy(xpath="//*[@id=\"claimsTable\"]/div[2]/table/thead/tr/th[8]/div")
	private WebElement ProviderAddress;
	
	
	public WebElement getDOSFrom() {
		return DOSFrom;
	}

	public WebElement getDOSTo() {
		return DOSTo;
	}

	public WebElement getProviderName() {
		return ProviderName;
	}

	public WebElement getProviderID() {
		return ProviderID;
	}

	public WebElement getProviderNPI() {
		return ProviderNPI;
	}

	public WebElement getDXCode() {
		return DXCode;
	}

	public WebElement getClaimId() {
		return ClaimId;
	}

	public WebElement getProviderAddress() {
		return ProviderAddress;
	}

	public WebElement getClaimsDataTab() {
		return ClaimsDataTab;
	}
	

}
