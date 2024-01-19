package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.github.sukgu.support.ElementFieldDecorator;

public class Member_Provider_Details_tab {

WebDriver driver;
	
	public Member_Provider_Details_tab(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
			PageFactory.initElements(decorator, this);
		}
	
	@FindBy(xpath="//div[contains(text(),'Member & Provider Details')]")
	private WebElement Member_ProviderDetailsTab;
	
	@FindBy(xpath="//span[contains(text(),'Member Details')]")
	private WebElement MPD_MemberDetails;
	
	public WebElement getMPD_MemberDetails() {
		return MPD_MemberDetails;
	}

	@FindBy(xpath="//div[contains(text(),'Member ID :')]")
	private WebElement MPD_MemberID;
	
	@FindBy(xpath="//div[contains(text(),'Member HICN :')]")
	private WebElement MPD_MemberHICN;
	
	@FindBy(xpath="//div[contains(text(),'Member MBI :')]")
	private WebElement MPD_MemberMBI;
	
	@FindBy(xpath="//div[contains(text(),'Chase ID :')]")
	private WebElement MPD_ChaseID;
	
	@FindBy(xpath="//div[contains(text(),'Member Address : ')]")
	private WebElement MPD_MemberAddress;
	
	@FindBy(xpath="//span[contains(text(),'Provider Details')]")
	private WebElement MPD_ProviderDetails;
	
	@FindBy(xpath="//div[contains(text(),'Provider First Name :')]")
	private WebElement MPD_ProviderFirstName;
	
	@FindBy(xpath="//div[contains(text(),'Provider Last Name :')]")
	private WebElement MPD_ProviderLastName;
	
	@FindBy(xpath="//div[contains(text(),'Provider Speciality :')]")
	private WebElement MPD_ProviderSpeciality;
	
	@FindBy(xpath="//div[contains(text(),'Provider ID :')]")
	private WebElement MPD_ProviderID;
	
	public WebElement getMPD_ProviderSpeciality() {
		return MPD_ProviderSpeciality;
	}

	public WebElement getMPD_ProviderID() {
		return MPD_ProviderID;
	}

	@FindBy(xpath="//div[contains(text(),'Provider NPI :')]")
	private WebElement MPD_ProviderNPI;
	
	@FindBy(xpath="//div[contains(text(),'Provider TIN :')]")
	private WebElement MPD_ProviderTIN;
	
	@FindBy(xpath="//div[contains(text(),'Provider Credential ')]")
	private WebElement MPD_ProviderCredential;
	
	@FindBy(xpath="//div[contains(text(),'Provider Address :')]")
	private WebElement MPD_ProviderAddress;

	public WebElement getMember_ProviderDetailsTab() {
		return Member_ProviderDetailsTab;
	}

	public WebElement getMPD_MemberID() {
		return MPD_MemberID;
	}

	public WebElement getMPD_MemberHICN() {
		return MPD_MemberHICN;
	}

	public WebElement getMPD_MemberMBI() {
		return MPD_MemberMBI;
	}

	public WebElement getMPD_ChaseID() {
		return MPD_ChaseID;
	}

	public WebElement getMPD_MemberAddress() {
		return MPD_MemberAddress;
	}

	public WebElement getMPD_ProviderDetails() {
		return MPD_ProviderDetails;
	}

	public WebElement getMPD_ProviderFirstName() {
		return MPD_ProviderFirstName;
	}

	public WebElement getMPD_ProviderLastName() {
		return MPD_ProviderLastName;
	}

	public WebElement getMPD_ProviderNPI() {
		return MPD_ProviderNPI;
	}

	public WebElement getMPD_ProviderTIN() {
		return MPD_ProviderTIN;
	}

	public WebElement getMPD_ProviderCredential() {
		return MPD_ProviderCredential;
	}

	public WebElement getMPD_ProviderAddress() {
		return MPD_ProviderAddress;
	}
	
	

	
}
