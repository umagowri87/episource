package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.github.sukgu.support.ElementFieldDecorator;

public class MCCChartWorkflowTabPage {
	
WebDriver driver;
	
	public MCCChartWorkflowTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
			PageFactory.initElements(decorator, this);
		}
	
	@FindBy(xpath = "//div[contains(text(),'         L1 Username')]")
	private WebElement workflow_Username;
	
	@FindBy(xpath="//div[contains(text(),'L1 Start Time')]")
	private WebElement workflow_Starttime;
	
	@FindBy(xpath="//div[contains(text(),'L1 Finish Time')]")
	private WebElement workflow_Finishtime;
	
	@FindBy(xpath="//input[@id='L1User']")
	private WebElement workflow_L1User;
	
	@FindBy(id="L1StartTimeStamp")
	private WebElement workflow_L1StartTime;
	
	@FindBy(id="L1FinishTimeStamp")
	private WebElement workflow_L1FinishTime;
	
	@FindBy(xpath="//div[contains(text(),'NLP Outcome')]")
	private WebElement wf_NLPOutcome;
	
	@FindBy(xpath="//div[contains(text(),'Status')]")
	private WebElement demo_status;

	@FindBy(xpath="//input[@id='Status']")
	private WebElement demo_textStatus;

	public WebElement getWf_textNLPOutcome() {
		return wf_textNLPOutcome;
	}

	public WebElement getWf_TotalPages() {
		return wf_TotalPages;
	}

	public WebElement getWf_textTotalPages() {
		return wf_textTotalPages;
	}

	@FindBy(xpath="//input[@id='nlpoutcome']")
	private WebElement wf_textNLPOutcome;
	
	@FindBy(xpath ="//div[contains(text(),'Processed By NLP')]")
	private WebElement wf_NLP;
	
	public WebElement getWf_NLP() {
		return wf_NLP;
	}

	public WebElement getWf_checkboxNLP() {
		return wf_checkboxNLP;
	}

	@FindBy(xpath="//label[@id='ProcessedbyNLP']/span/input")
	private WebElement wf_checkboxNLP;
	
	@FindBy(xpath="//div[contains(text(),'Total Pages')]")
	private WebElement wf_TotalPages;
	
	@FindBy(xpath="//div[@id='TotalChartPages']/div/input")
	private WebElement wf_textTotalPages;
	
	@FindBy(xpath="//span[@title='PDF View Access']")
	private WebElement wf_PDFViewAccesss;
	
	@FindBy(xpath = "//div[contains(text(),'PDF Access Reason')]")
	private WebElement wf_PDFAccessReason;
	
	@FindBy(xpath="//input[@id='AllowAdobe']")
	private WebElement wf_txtPDFAccessReason;
	
	@FindBy(xpath="//div[contains(@x-placement,'-start') and @class='el-select-dropdown el-popper']/div/div/ul/li")
	private WebElement wf_PDFAccessReasonvalues;
	
	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getWf_PDFAccessReasonvalues() {
		
		List<WebElement> status = driver.findElements(By.xpath("//div[contains(@x-placement,'-start') and @class='el-select-dropdown el-popper']/div/div/ul/li"));
		return  status;
	}

	@FindBy(xpath="//span[contains(text(),'Image issue')]")
	private WebElement wf_imageissue;
	
	@FindBy(xpath="//div[@class='el-col el-col-5']/div[1]/div[1]//ul[@class='el-scrollbar__view el-select-dropdown__list']/li/span")
	private WebElement workflow_statusvalues;
	
	public List<WebElement> getWf_statusvalues() {
				
		List<WebElement> workflow_statusvalues = driver.findElements(By.xpath("//div[contains(@x-placement,'-start') and @class='el-select-dropdown el-popper']/div/div/ul/li"));
		return  workflow_statusvalues;
	}

	public WebElement getWf_imageissue() {
		return wf_imageissue;
	}

	@FindBy(xpath="//div[contains(text(),'Timestamp')]")
	private WebElement wf_Timestamp;

	@FindBy(xpath ="//input[@id='AllowAdobeTimestamp']")
	private WebElement wf_textTimestamp;
	
	@FindBy(xpath ="//span[contains(text(),'Submit Reason')]")
	private WebElement wf_SubmitReason;
	
	@FindBy(xpath ="//span[@title='Custom Fields']")
	private WebElement wf_CustomFields;
	
	
	public WebElement getWf_CustomFields() {
		return wf_CustomFields;
	}

	public WebElement getWf_PDFAccessReason() {
		return wf_PDFAccessReason;
	}

	public WebElement getWf_txtPDFAccessReason() {
		return wf_txtPDFAccessReason;
	}

	public WebElement getWf_Timestamp() {
		return wf_Timestamp;
	}

	public WebElement getWf_textTimestamp() {
		return wf_textTimestamp;
	}

	public WebElement getWf_SubmitReason() {
		return wf_SubmitReason;
	}

	public WebElement getDemo_status() {
		return demo_status;
	}

	public WebElement getWf_PDFViewAccesss() {
		return wf_PDFViewAccesss;
	}

	public WebElement getWf_NLPOutcome() {
		return wf_NLPOutcome;
	}

	public WebElement getDemo_textStatus() {
		return demo_textStatus;
	}
	

	
	public WebElement getWorkflow_L1StartTime() {
		return workflow_L1StartTime;
	}

	public WebElement getWorkflow_L1FinishTime() {
		return workflow_L1FinishTime;
	}

	public WebElement getWorkflow_L1User() {
		return workflow_L1User;
	}

	public WebElement getWorkflow_Username() {
		return workflow_Username;
	}

	public WebElement getWorkflow_Starttime() {
		return workflow_Starttime;
	}

	public WebElement getWorkflow_Finishtime() {
		return workflow_Finishtime;
	}
	
	
	

}
