package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.github.sukgu.support.ElementFieldDecorator;
import stepdefinitions.CommonDefinitions;

public class MCCChartSupplementalTabPage {
	
	WebDriver driver;
	
	public MCCChartSupplementalTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
			PageFactory.initElements(decorator, this);
		}
	
	@FindBy(xpath="//*[@id='claimsTable']/div[4]/div[1]/table/thead/tr/th[1]/div")
	private WebElement SupplementalTab_DOSFrom;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[4]/div[1]/table/thead/tr/th[2]/div")
	private WebElement SupplementalTab_DOSTo;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[4]/div[1]/table/thead/tr/th[3]/div")
	private WebElement Supplemental_ProviderNumber;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[4]/div")
	private WebElement  Supplemental_DXCode1;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[5]/div")
	private WebElement Supplemental_DXCode2;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[6]/div")
	private WebElement Supplemental_DXCode3;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[7]/div")
	private WebElement Supplemental_DXCode4;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[8]/div")
	private WebElement Supplemental_DXCode5;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[9]/div")
	private WebElement Supplemental_DXCode6;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[10]/div")
	private WebElement Supplemental_DXCode7;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[11]/div")
	private WebElement Supplemental_DXCode8;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[12]/div")
	private WebElement Supplemental_ProviderName;
	
	@FindBy(xpath="//*[@id='claimsTable']/div[2]/table/thead/tr/th[13]/div")
	private WebElement Supplemental_ProviderAddress;	
	
	
	public WebElement getSupplementalTab_DOSFrom() {
		return SupplementalTab_DOSFrom;
	}

	public WebElement getSupplementalTab_DOSTo() {
		return SupplementalTab_DOSTo;
	}

	public WebElement getSupplementalTab_ProviderNumber() {
		return Supplemental_ProviderNumber;
	}

	public WebElement getSupplementalTab_DXCode1() {
		return Supplemental_DXCode1;
	}

	public WebElement getSupplementalTab_DXCode2() {
		return Supplemental_DXCode2;
	}

	public WebElement getSupplementalTab_DXCode3() {
		return Supplemental_DXCode3;
	}

	public WebElement getSupplementalTab_DXCode4() {
		return Supplemental_DXCode4;
	}

	public WebElement getSupplementalTab_DXCode5() {
		return Supplemental_DXCode5;
	}

	public WebElement getSupplementalTab_DXCode6() {
		return Supplemental_DXCode6;
	}

	public WebElement getSupplementalTab_DXCode7() {
		return Supplemental_DXCode7;
	}

	public WebElement getSupplementalTab_DXCode8() {
		return Supplemental_DXCode8;
	}

	public WebElement getSupplementalTab_ProviderName() {
		return Supplemental_ProviderName;
	}

	public WebElement getSupplementalTab_ProviderAddress() {
		return Supplemental_ProviderAddress;
	}


	
	
}
