package pageobjects;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.testng.Assert;

import io.github.sukgu.support.ElementFieldDecorator;

public class BugReportingPage{
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@title='New']")
	private WebElement btnNew;
	
	@FindBy(xpath = "//span[text()='Bug Report']/../..//input/../span")
	private WebElement rbBugReport;
	
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement btnNext;

	@FindBy(xpath = "//div[@class='inlineFooter']//button/span[text()='Cancel']")
	private WebElement btnCancel;
	
	@FindBy(xpath = "//label[text()='Which system is affected?']/..//button")
	private WebElement ddWhichSystem;
	
	@FindBy(xpath = "//label[text()='If Other, name of system']/..//input")
	private WebElement txtOtherSystem;
	
	@FindBy(xpath = "//label[text()='Number of affected users']/..//input")
	private WebElement txtNumberAffectedUsers;
	
	@FindBy(xpath = "//label[text()='Summary']/..//textarea")
	private WebElement txtSummary;
		
	@FindBy(xpath = "//label[text()='Describe the issue in detail']/..//textarea")
	private WebElement txtDescribeIssueInDetail;
	
	@FindBy(xpath = "//label[text()='What is the impact?']/..//button")
	private WebElement ddWhatIsTheImpact;	
	
	@FindBy(xpath = "//label[text()='What are the Members/Data affected?']/..//button")
	private WebElement ddWhatAreMembersAffected;
	
	@FindBy(xpath = "//label[text()='What is the class of the bug?']/..//button")
	private WebElement ddWhatClassOfBug;
	
	@FindBy(xpath = "//label[text()='What is the risk of this bug?']/..//button")
	private WebElement ddWhatIsRiskOfBug;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;
	
	@FindBy(xpath = "//button[text()='Save & New']")
	private WebElement btnSaveNew;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancelBug;
	
	@FindBy(xpath = "//div[text()='System Name is required when Other is selected']")
	private WebElement lblIfOtherError;
	
	
	@FindBy(xpath = "//span[text()='Which system is affected?']/../..//lightning-formatted-text")
	private WebElement infoWhichSystem;
	
	@FindBy(xpath = "//span[text()='If Other, name of system']/../..//lightning-formatted-text")
	private WebElement infoOtherSystem;
	
	@FindBy(xpath = "//span[text()='Number of affected users']/../..//lightning-formatted-number")
	private WebElement infoNumberAffectedUsers;
	
	@FindBy(xpath = "//span[text()='Summary']/../..//lightning-formatted-text")
	private WebElement infoSummary;
	
	@FindBy(xpath = "//span[text()='Describe the issue in detail']/../..//lightning-formatted-text")
	private WebElement infoDescribeIssueInDetail;
	
	@FindBy(xpath = "//span[text()='What is the impact?']/../..//lightning-formatted-text")
	private WebElement infoWhatIsTheImpact;
	
	@FindBy(xpath = "//span[text()='What are the Members/Data affected?']/../..//lightning-formatted-text")
	private WebElement infoWhatAreMembersAffected;
	
	@FindBy(xpath = "//span[text()='What is the class of the bug?']/../..//lightning-formatted-text")
	private WebElement infoWhatClassOfBug;
	
	@FindBy(xpath = "//span[text()='What is the risk of this bug?']/../..//lightning-formatted-text")
	private WebElement infoWhatIsRiskOfBug;
	
	@FindBy(xpath = "//span[text()='Bug Priority']/../..//lightning-formatted-number")
	private WebElement infoBugPriority;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement btnUploadFile;
	
	@FindBy(xpath = "//span[text()='Upload of testFileToUpload.png complete']")
	private WebElement iconUploadCompleted;
	
	@FindBy(xpath = "//span[text()='Done']/..")
	private WebElement btnDone;
	
	@FindBy(xpath = "//span[@title='testFileToUpload']")
	private WebElement fileUploaded;
	
	public BugReportingPage(WebDriver driver) {
		this.driver = driver;
		ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
		PageFactory.initElements(decorator, this);
	}

	public void openBugReportForm() {
		Utilities.waitForPageLoaded(driver);
		btnNew.click();
		Utilities.waitForElementToBeClickable(driver, rbBugReport);
		rbBugReport.click();
		btnNext.click();
	}
	
	public void fillBugReportForm(String whichSystem, String ifOther, String numberOfAffected, String summary, 
			String describeTheIssueInDetail, String whatIsImpact, String whatAreMembersData, String whatIsClass, String whatIsRisk) {
		ddWhichSystem.click();
		driver.findElement(By.xpath("//label[text()='Which system is affected?']/..//button/../..//lightning-base-combobox-item//span[text()='" + whichSystem + "']")).click();
		txtOtherSystem.clear();
		if(ifOther!=null)
			txtOtherSystem.sendKeys(ifOther);
		txtNumberAffectedUsers.clear();
		txtNumberAffectedUsers.sendKeys(numberOfAffected);
		txtSummary.clear();
		txtSummary.sendKeys(summary);
		txtDescribeIssueInDetail.clear();
		txtDescribeIssueInDetail.sendKeys(describeTheIssueInDetail);
		Utilities.scrollToElement(driver, ddWhatIsTheImpact);
		ddWhatIsTheImpact.click();
		driver.findElement(By.xpath("//label[text()='What is the impact?']/..//button/../..//lightning-base-combobox-item//span[text()='" + whatIsImpact + "']")).click();
		ddWhatAreMembersAffected.click();
		driver.findElement(By.xpath("//label[text()='What are the Members/Data affected?']/..//button/../..//lightning-base-combobox-item//span[text()='" + whatAreMembersData + "']")).click();
		ddWhatClassOfBug.click();
		driver.findElement(By.xpath("//label[text()='What is the class of the bug?']/..//button/../..//lightning-base-combobox-item//span[text()='" + whatIsClass + "']")).click();
		ddWhatIsRiskOfBug.click();
		driver.findElement(By.xpath("//label[text()='What is the risk of this bug?']/..//button/../..//lightning-base-combobox-item//span[text()='" + whatIsRisk + "']")).click();
		btnSave.click();
	}
	
	public void ifOtherSystemErrorValidation() {
		Utilities.scrollToElement(driver, txtOtherSystem);
		Assert.assertTrue(lblIfOtherError.isDisplayed(), "Blank value at 'If Other, name of system' field is not throwing an error");
		btnCancelBug.click();
	}
	
	public void validateBugReport(String whichSystem, String ifOther, String numberOfAffected, String summary, 
			String describeTheIssueInDetail, String whatIsImpact, String whatAreMembersData, String whatIsClass, String whatIsRisk,
			String bugPriority) {
		Assert.assertTrue(infoWhichSystem.getText().contains(whichSystem), "Info displayed at 'Which system is affected?' field is not matching");
		if(ifOther!=null)
			Assert.assertTrue(infoOtherSystem.getText().contains(ifOther), "Info displayed at 'If Other, name of system' field is not matching");
		Assert.assertTrue(infoNumberAffectedUsers.getText().contains(numberOfAffected), "Info displayed at 'Number of affected users' field is not matching");
		Assert.assertTrue(infoSummary.getText().contains(summary), "Info displayed at 'Summary' field is not matching");
		Assert.assertTrue(infoDescribeIssueInDetail.getText().contains(describeTheIssueInDetail), "Info displayed at 'Describe the issue in detail' field is not matching");
		Assert.assertTrue(infoWhatIsTheImpact.getText().contains(whatIsImpact), "Info displayed at 'What is the impact?' field is not matching");
		Assert.assertTrue(infoWhatAreMembersAffected.getText().contains(whatAreMembersData), "Info displayed at 'What are the Members/Data affected?' field is not matching");
		Assert.assertTrue(infoWhatClassOfBug.getText().contains(whatIsClass), "Info displayed at 'What is the class of the bug?' field is not matching");
		Assert.assertTrue(infoWhatIsRiskOfBug.getText().contains(whatIsRisk), "Info displayed at 'What is the risk of this bug?' field is not matching");
		Assert.assertTrue(infoBugPriority.getText().contains(bugPriority), "Info displayed at 'Bug Priority' field is not matching");
	}
	
	public void doAnAttachment() {
		File file = new File("src/test/resources/testFileToUpload.png");
		btnUploadFile.sendKeys(file.getAbsolutePath());
		Utilities.waitForElementToBeDisplayed(driver, iconUploadCompleted);
		btnDone.click();
	}
	
	public void fileIsAttached() {
		Assert.assertTrue(fileUploaded.isDisplayed(), "File was not uploaded");
	}
}
