package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.github.sukgu.support.ElementFieldDecorator;

public class MCCDemographicTabPage {
	WebDriver driver;
	
	public MCCDemographicTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
			PageFactory.initElements(decorator, this);
		}

	@FindBy(xpath = "//div[contains(text(),'        First Name')]")
	private WebElement demo_FirstName;
	
	@FindBy(xpath="//div[contains(text(),'       Last Name')]")
	private WebElement demo_LastName;
	
	@FindBy(xpath="//div[contains(text(),'        Member Id')]")
	private WebElement demo_MemberId;
	
	@FindBy(xpath="//div[contains(text(),'       DOB')]")
	private WebElement demo_dob;
	
	@FindBy(xpath="//div[contains(text(),'        Gender')]")
	private WebElement demo_Gender;
	
	@FindBy(xpath="//div[contains(text(),'        Chase Id')]")
	private WebElement demo_chaseId;
	
	@FindBy(xpath="//div[contains(text(),'       # Chart Pages')]")
	private WebElement demo_chartpages;
	
	@FindBy(xpath="//div[contains(text(),'       Processed By NLP')]")
	private WebElement demo_nlp;
	

	
	@FindBy(xpath="//div[contains(text(),'       Hold Reason')]")
	private WebElement demo_holdReason;
	
	@FindBy(xpath="//div[contains(text(),'      Hold Comments')]")
	private WebElement demo_HoldComments;
	
	@FindBy(xpath="//div[contains(text(),'No ICDs')]")
	private WebElement demo_Icd;
	
	@FindBy(xpath="*//input[@id='FirstName']")
	private WebElement demo_textFN;
	
	@FindBy(xpath="*//input[@id='LastName']")
	private WebElement demo_textLN;
	
	@FindBy(xpath="*//input[@id='MemberId']")
	private WebElement demo_textMemberId;
	
	@FindBy(xpath="*//input[@id='Gender']")
	private WebElement demo_textGender;
	
	@FindBy(xpath="*//input[@id='ChaseId']")
	private WebElement demo_textChaseId;
	
	@FindBy(xpath="//*[@id='TotalChartPages']/div/input")
	private WebElement demo_textChartpages;
	

	
	@FindBy(xpath="//*[@id='HoldReason']")
	private WebElement demo_textHoldReason;
	
	@FindBy(xpath="//*[@id='DOB']")
	private WebElement demo_textdob;
	
	@FindBy(xpath="//*[@id='ProcessedbyNLP']/span/input")
	private WebElement demo_textNLP;
	
	@FindBy(xpath="//*[@id='NoICD9s']/span/input")
	private WebElement demo_textICD;
	
	public WebElement getDemo_textICD() {
		return demo_textICD;
	}

	public WebElement getDemo_textNLP() {
		return demo_textNLP;
	}

	public WebElement getDemo_textdob() {
		return demo_textdob;
	}

	public WebElement getDemo_FirstName() {
		return demo_FirstName;
	}

	public WebElement getDemo_textFN() {
		return demo_textFN;
	}

	public WebElement getDemo_textLN() {
		return demo_textLN;
	}

	public WebElement getDemo_textMemberId() {
		return demo_textMemberId;
	}

	public WebElement getDemo_textGender() {
		return demo_textGender;
	}

	public WebElement getDemo_textChaseId() {
		return demo_textChaseId;
	}

	public WebElement getDemo_textChartpages() {
		return demo_textChartpages;
	}



	public WebElement getDemo_textHoldReason() {
		return demo_textHoldReason;
	}

	public WebElement getDemo_textHoldComment() {
		return demo_textHoldComment;
	}

	@FindBy(xpath="//*[@id='HoldComment']")
	private WebElement demo_textHoldComment;
	

	public WebElement getDemo_LastName() {
		return demo_LastName;
	}

	public WebElement getDemo_MemberId() {
		return demo_MemberId;
	}

	public WebElement getDemo_dob() {
		return demo_dob;
	}

	public WebElement getDemo_Gender() {
		return demo_Gender;
	}

	public WebElement getDemo_chaseId() {
		return demo_chaseId;
	}

	public WebElement getDemo_chartpages() {
		return demo_chartpages;
	}

	public WebElement getDemo_nlp() {
		return demo_nlp;
	}



	public WebElement getDemo_holdReason() {
		return demo_holdReason;
	}

	public WebElement getDemo_HoldComments() {
		return demo_HoldComments;
	}

	public WebElement getDemo_Icd() {
		return demo_Icd;
	}

	public WebElement getMCC_FirstName() {
		return demo_FirstName;
	}

}
