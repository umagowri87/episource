package pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.testng.Assert;

import io.github.sukgu.support.ElementFieldDecorator;

public class LIDPage{
	
	WebDriver driver;
	@FindBy(xpath = "//*[@slot='primaryField']")
	private WebElement lblLID;
	
	@FindBy(xpath = "//h3[text()='Contact Information']")
	private WebElement headerContactInformation;
	
	@FindBy(xpath = "//font[text()='DO NOT CALL']")
	private WebElement lblDoNotCall;
	
	@FindBy(xpath = "//button[@title='Edit Do Not Call - DNC']")
	private WebElement btnEditDoNotCallCB;
	
	@FindBy(xpath = "//span[text()='Do Not Call - DNC']/../..//input")
	private WebElement cbDoNotCall;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;	
	
	@FindBy(xpath = "//button[text()='Address Finder']")
	private WebElement btnAddressFinder;
	
	@FindBy(xpath = "//b[text()='Search for Address']/../..//input")
	private WebElement txtSearchForAddressAF;
	
	@FindBy(xpath = "//b[text()='Address Line 1']/../..//input")
	private WebElement txtAddressLine1AF;
	
	@FindBy(xpath = "//b[text()='Address Line 2 (Suite, Building, etc...)']/../..//input")
	private WebElement txtAddressLine2AF;
	
	@FindBy(xpath = "//b[text()='City']/../..//input")
	private WebElement txtCityAF;
	
	@FindBy(xpath = "//b[text()='State']/../..//select")
	private WebElement ddStateAF;
	
	@FindBy(xpath = "//b[text()='Zip Code']/../..//input")
	private WebElement txtZipCodeAF;
	
	@FindBy(xpath = "//b[text()='Melissa Ref Key']/../..//input")
	private WebElement txtMelissaRefKeyAF;
	
	@FindBy(id = "page:form:SaveButton")
	private WebElement btnSaveAF;
	
	@FindBy(xpath = "//li[@class = 'ui-menu-item'][1]/a")
	private WebElement melissaApiAddress;
	
	@FindBy(xpath = "//iframe[@name='Location2__c.AddressFinder']")
	private WebElement iframeAF;
	
	@FindBy(xpath = "//textarea")
	private WebElement callLogComments;
	
	@FindBy(xpath = "//select[contains(@name, 'callType')]")
	private WebElement callLogCallType;

	@FindBy(xpath = "//select[contains(@name, 'category')]")
	private WebElement callLogCallCategory;
	
	@FindBy(xpath = "//select[contains(@name, 'outcome')]")
	private WebElement callLogCallOutcome;
	
	@FindBy(xpath = "//input[contains(@name, 'ocfudid')]")
	private WebElement callLogFollowUpDate;

	@FindBy(xpath = "//input[contains(@name, 'ocfunid')]")
	private WebElement callLogFollowUpNote;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement callLogBtnSave;
	
	@FindBy(xpath = "//input[@value='Cancel']")
	private WebElement callLogBtnCancel;
	
	@FindBy(xpath = "//div[@class='oneAlohaPage']//iframe")
	private WebElement callLogIframe;
	
	@FindBy(xpath = "//div[@class='split-right']/section[@class='tabContent active oneConsoleTab']//span[@class = 'slds-path__title' and text()='Schedule']")
	private WebElement stgBarSchedule;
	
	@FindBy(xpath = "//button[text()='Schedule Retrieval']")
	private WebElement btnScheduleRetrieval;
	
	@FindBy(xpath = "//button[@name='progress']")
	private WebElement btnTypeOfAppt;
	
	@FindBy(xpath = "//span[@title='Field Appt']")
	private WebElement btnFieldAppt;
	
	@FindBy(xpath = "//span[@title='Remote Appt']")
	private WebElement btnRemoteAppt;
	
	
	@FindBy(xpath = "//c-appointment-list//iframe")
	private WebElement iframeScheduleRetrieval;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement btnSchRtvlContinue;
	
	@FindBy(xpath = "//a[text()='Begin Scheduling']")
	private WebElement btnSchRtvlBeginScheduling;
	
	@FindBy(xpath = "//button[text()='View Scheduling Details']")
	private WebElement btnSchRtvlViewSchedulingDetails;
	
	@FindBy(xpath = "//a[text()='Save All Appointments']")
	private WebElement btnSchRtvlSaveAllAppts;
	
	@FindBy(xpath = "//button[text()='Save CRS Notes']")
	private WebElement btnSchRtvlSaveCRSnotes;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnSchRtvlCancel;
	
	//Refresh
	@FindBy(xpath = "//p[@title='Workflow Status']/..//lightning-formatted-text")
	private WebElement lblWorkflowStatus;

	@FindBy(xpath = "//*[local-name()='svg'][@data-key='close']")
	private WebElement btnCloseTabInRetrievalConsole;
	
	@FindBy(xpath = "//c-appointment-list//*[local-name()='svg'][@data-key='close']")
	private WebElement btnCloseAppointmentModal;
	
	@FindBy(xpath = "//runtime_platform_actions-actions-ribbon//button/span[text()='Show more actions']/..")
	private WebElement btnShowMoreActions;
	
	@FindBy(xpath = "//runtime_platform_actions-actions-ribbon//span[text()='Provider packet']")
	private WebElement btnProviderPacket;
	
	@FindBy(xpath = "//c-choose-provider-packet//button[text()='Fax']")
	private WebElement btnProviderPacketFax;
	
	@FindBy(xpath = "//c-choose-provider-packet//button[text()='Email']")
	private WebElement btnProviderPacketEmail;

	@FindBy(xpath = "//c-choose-provider-packet//iframe")
	private WebElement iframeProviderPacket;
	
	//inside the iframe
	@FindBy(xpath = "//input[@value='Send Provider Packet']")
	private WebElement btnSendProviderPacket;
	
	//inside the iframe
	@FindBy(xpath = "//input[@value='Generate Provider Packet']")
	private WebElement btnGenerateProviderPacket;
	
	@FindBy(xpath = "//button[@title='Close this window']//*[local-name()='svg'][@data-key='close']")
	private WebElement btnCloseProviderPacketWindow;
	
	@FindBy(xpath = "//button[@title='Create a new Generate Packet']")
	private WebElement btnCreateNewGeneratePacket;
	
	@FindBy(xpath = "//button[@title='Proceed to email']")
	private WebElement btnProceedToEmail;
	
	@FindBy(xpath = "//label[text()='Attn To:']")
	private WebElement lblAttnTo;
	
	@FindBy(xpath = "//c-show-flow-l-w-c//select") //value=MRR_Send_Email_Provider_Portal
	private WebElement selectTemplate;
	
	@FindBy(xpath = "//c-show-flow-l-w-c//button[text()='Next']")
	private WebElement btnProceedToEmailNext;
	
	@FindBy(xpath = "//c-show-flow-l-w-c//button[text()='Yes']")
	private WebElement btnProceedToEmailYes;
	
	@FindBy(xpath = "//c-show-flow-l-w-c//button[text()='No']")
	private WebElement btnProceedToEmailNo;
	
	@FindBy(xpath = "//c-show-flow-l-w-c//button[text()='Finish']")
	private WebElement btnProviderPacketFinish;
	
	public LIDPage(WebDriver driver) {
		this.driver = driver;
		ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
		PageFactory.initElements(decorator, this);
	}
	
	public void isLIDOpen(String text) {
		Assert.assertEquals(lblLID.getText(), text, "LID is not Open");
	}
	
	public void isContactInformationPresent() {
		//Change timeout to 5 seconds temporarily
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Assert.assertTrue(headerContactInformation.isDisplayed(), "Contact Information is displayed and it should not");
		
		//Revert timeout to 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void checkDoNotCall() {
		Utilities.scrollToElement(driver, cbDoNotCall);
		if(!cbDoNotCall.isSelected()) {
			btnEditDoNotCallCB.click();
			Utilities.waitForElementToBeClickable(driver, cbDoNotCall);
			cbDoNotCall.click();
			btnSave.click();
		}
	}
	
	public void uncheckDoNotCall() {
		Utilities.scrollToElement(driver, cbDoNotCall);
		if(cbDoNotCall.isSelected()) {
			btnEditDoNotCallCB.click();
			Utilities.waitForElementToBeClickable(driver, cbDoNotCall);
			cbDoNotCall.click();
			btnSave.click();
		}
	}
	
	public void isDoNotCallPresent() {
		//Change timeout to 5 seconds temporarily
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		try {
			Assert.assertTrue(lblDoNotCall.isDisplayed(), "Do Not Call is not displayed and it should");
		}catch(NoSuchElementException e) {
			Assert.assertTrue(false, "Do Not Call is not displayed and it should");
		}
		//Revert timeout to 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void isDoNotCallNotPresent() {
		//Change timeout to 5 seconds temporarily
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		try {
			Assert.assertTrue(!lblDoNotCall.isDisplayed(), "Do Not Call is displayed and it should not");
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true, "Do Not Call is displayed and it should not");
		}
		
		//Revert timeout to 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void clickAddressFinder() {
		Utilities.waitForPageLoaded(driver);
		btnAddressFinder.click();
	}
	
	public void clickSaveAddressFinder() {
		Utilities.waitForPageLoaded(driver);
		switchDefaultContent();
		switchToIframeAF();
		btnSaveAF.click();
		switchDefaultContent();
	}
	
	public void fillAddressFinderForm(String text) {
		switchDefaultContent();
		switchToIframeAF();
		txtSearchForAddressAF.sendKeys(text);
		melissaApiAddress.click();
		switchDefaultContent();
	}
	
	public void validateFieldsDisabledAF() {
		switchDefaultContent();
		switchToIframeAF();
		
		Assert.assertTrue(!txtAddressLine1AF.isEnabled(), "Address Line 1 is enabled");
		Assert.assertTrue(txtAddressLine2AF.isEnabled(), "Address Line 2 is disabled");
		Assert.assertTrue(!txtCityAF.isEnabled(), "City is enabled");
		Assert.assertTrue(!ddStateAF.isEnabled(), "State is enabled");
		Assert.assertTrue(!txtZipCodeAF.isEnabled(), "Zip Code is enabled");
		Assert.assertTrue(!txtMelissaRefKeyAF.isEnabled(), "Melissa Ref Key is enabled");
		
		switchDefaultContent();
	}
	
	public void fillAddressFinderFormOutsideUS(String text) {
		boolean flag = false;
		switchDefaultContent();
		switchToIframeAF();
		txtSearchForAddressAF.sendKeys(text);
		try {
			if(melissaApiAddress.isDisplayed()) {
				flag = false;
			}
		}catch(NoSuchElementException e) {
			flag = true;
		}
		Assert.assertTrue(flag, "User is ABLE to enter an address outside US");
		switchDefaultContent();
	}
		
	public void switchToIframeAF() {
		driver.switchTo().frame(iframeAF);
	}
	
	public void switchDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public void switchToCallLogIframe() {
		driver.switchTo().frame(callLogIframe);
	}
	
	public void switchToScheduleRetrievalIframe() {
		driver.switchTo().frame(iframeScheduleRetrieval);
	}
	
	public void switchToProviderPacketIframe() {
		driver.switchTo().frame(iframeProviderPacket);
	}
	
	public void selectCallType(String text) {
		switchDefaultContent();
		switchToCallLogIframe();
		Utilities.selectByVisibleText(callLogCallType, text);
		switchDefaultContent();
	}
	
	public void selectCallCategory(String text) {
		switchDefaultContent();
		switchToCallLogIframe();
		Utilities.selectByVisibleText(callLogCallCategory, text);
		switchDefaultContent();
	}
	
	public void selectCallOutcome(String text) {
		switchDefaultContent();
		switchToCallLogIframe();
		Utilities.selectByVisibleText(callLogCallOutcome, text);
		switchDefaultContent();
	}
	
	public void setFollowUpDate(String text) {
		switchDefaultContent();
		switchToCallLogIframe();
		callLogFollowUpDate.clear();
		callLogFollowUpDate.sendKeys(text);
		switchDefaultContent();
	}
	
	public void setFollowUpNote(String text) {
		switchDefaultContent();
		switchToCallLogIframe();
		callLogFollowUpNote.clear();
		callLogFollowUpNote.sendKeys(text);
		switchDefaultContent();
	}
	
	public void setCallLogComments(String text) {
		switchDefaultContent();
		switchToCallLogIframe();
		callLogComments.clear();
		callLogComments.sendKeys(text);
		switchDefaultContent();
	}
	
	public void clickCallLogSaveButton() {
		switchDefaultContent();
		switchToCallLogIframe();
		callLogBtnSave.click();
		switchDefaultContent();
	}
	
	public void clickCallLogCancelButton() {
		switchDefaultContent();
		switchToCallLogIframe();
		callLogBtnCancel.click();
		switchDefaultContent();
	}
	
	public void fillCallLogForm(String callType, String callCategory, String callOutcome, String followUpDate, 
			String followUpNote, String comments) {
		try {
			selectCallType(callType);
			selectCallCategory(callCategory);
			selectCallOutcome(callOutcome);
			setFollowUpDate(followUpDate);
			setFollowUpNote(followUpNote);
			setCallLogComments(comments);
		}catch(Exception e) {
			System.out.println("Value not found");
		}

	}
	
	public void validateCallOutcome(String text) {
		switchDefaultContent();
		switchToCallLogIframe();
		Assert.assertTrue(callLogCallOutcome.getText().contains(text), "Call Outcome value is: " + callLogCallOutcome.getText());
		switchDefaultContent();
	}
	
	public void scheduleFieldAppt() {
		Utilities.waitForPageLoaded(driver);
		Utilities.waitForElementToBeClickable(driver, stgBarSchedule);
		stgBarSchedule.click();
		btnScheduleRetrieval.click();
		btnTypeOfAppt.click();
		btnFieldAppt.click();
		switchDefaultContent();
		switchToScheduleRetrievalIframe();
		btnSchRtvlContinue.click();
		acceptAlert();
		switchDefaultContent();
		switchToScheduleRetrievalIframe();
		btnSchRtvlBeginScheduling.click();
		btnSchRtvlViewSchedulingDetails.click();
		btnSchRtvlSaveAllAppts.click();
		btnSchRtvlSaveCRSnotes.click();
		switchDefaultContent();
		btnCloseAppointmentModal.click();
	}
	
	public void scheduleRemoteAppt() {
		Utilities.waitForPageLoaded(driver);
		Utilities.waitForElementToBeClickable(driver, stgBarSchedule);
		stgBarSchedule.click();
		btnScheduleRetrieval.click();
		btnTypeOfAppt.click();
		btnRemoteAppt.click();
		switchDefaultContent();
		switchToScheduleRetrievalIframe();
		btnSchRtvlContinue.click();
		btnSchRtvlBeginScheduling.click();
		btnSchRtvlViewSchedulingDetails.click();
		btnSchRtvlSaveAllAppts.click();
		btnSchRtvlSaveCRSnotes.click();
		switchDefaultContent();
		btnCloseAppointmentModal.click();
	}
	
	public void validateWorkflowStatus(String text) {
		driver.navigate().refresh();
		Utilities.waitForPageLoaded(driver);
		Assert.assertTrue(lblWorkflowStatus.getText().toUpperCase().contains(text.toUpperCase()), 
				"Workflow Status is displaying " + lblWorkflowStatus.getText() + " and we are expecting " + text);
	}
	
	public void acceptAlert() {
		try {
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	        switchDefaultContent();
	    } catch (NoAlertPresentException e) {
	    	switchDefaultContent();
	    	e.printStackTrace();
	    }
	}
	
	public void providerPacketFaxGenerate() {
		Utilities.waitForPageLoaded(driver);
		btnShowMoreActions.click();
		btnProviderPacket.click();
		btnProviderPacketFax.click();
		switchDefaultContent();
		switchToProviderPacketIframe();
		btnGenerateProviderPacket.click();
		Utilities.waitForNumberOfPagesAvailable(driver, 2);
		Utilities.waitForNumberOfPagesAvailable(driver, 1);
		switchDefaultContent();
		btnCloseProviderPacketWindow.click();		
	}
	
	public void providerPacketFaxSend() {
		Utilities.waitForPageLoaded(driver);
		btnShowMoreActions.click();
		btnProviderPacket.click();
		btnProviderPacketFax.click();
		switchDefaultContent();
		switchToProviderPacketIframe();
		btnSendProviderPacket.click();
		Utilities.waitForNumberOfPagesAvailable(driver, 2);
		Utilities.waitForNumberOfPagesAvailable(driver, 1);
		switchDefaultContent();
		btnCloseProviderPacketWindow.click();		
	}
	
	public void providerPacketEmailGenerate() {
		Utilities.waitForPageLoaded(driver);
		btnShowMoreActions.click();
		btnProviderPacket.click();
		btnProviderPacketEmail.click();
		btnCreateNewGeneratePacket.click();
		Utilities.waitForElementToBeDisplayed(driver, lblAttnTo);
		btnCreateNewGeneratePacket.click();
		Utilities.waitForNumberOfPagesAvailable(driver, 2);
		
		String originalWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle : windowHandles) {
			if(!windowHandle.equals(originalWindowHandle)) {
				driver.switchTo().window(windowHandle);
				driver.close();
				driver.switchTo().window(originalWindowHandle);
				break;
			}
		}
		
		btnCloseProviderPacketWindow.click();		
	}
	
	public void providerPacketEmailSend() {
		Utilities.waitForPageLoaded(driver);
		btnShowMoreActions.click();
		btnProviderPacket.click();
		btnProviderPacketEmail.click();
		btnProceedToEmail.click();
		Utilities.selectByValue(selectTemplate, "MRR_Send_Email_Provider_Portal");
		btnProceedToEmailNext.click();
		btnProceedToEmailYes.click();
		btnProviderPacketFinish.click();
	}
}
