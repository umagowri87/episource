package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.sukgu.support.ElementFieldDecorator;

public class TestSitePage {

	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Provider Addresses']/../../../..//div[text()='New']")
	private WebElement btnNewProviderAddress;
	
	@FindBy(css = "input[value='Cancel']")
	private WebElement btnCancel;
	
	@FindBy(id = "page:form:PageBlock:Mainpbs:j_id2")
	private WebElement txtFacilityName;
	
	@FindBy(id = "page:form:PageBlock:Mainpbs:j_id3")
	private WebElement ddAddressType;
	
	@FindBy(id = "page:form:PageBlock:Mainpbs:j_id5")
	private WebElement cbVerified;
	
	@FindBy(id = "page:form:PageBlock:Mainpbs:ActiveFromDate")
	private WebElement dpActiveFromDate;
	
	@FindBy(id = "page:form:PageBlock:Mainpbs:ActiveToDate")
	private WebElement dpActiveToDate;
	
	@FindBy(id = "page:form:PageBlock:Mainpbs:pbs:addressField")
	private WebElement txtSearchAddress;
	
	@FindBy(xpath = "//span[text()='Recently Viewed']")
	private WebElement lblRecentlyViewed;
	
	@FindBy(id = "page:form:PageBlock:SaveButton")
	private WebElement btnSave;
	
	@FindBy(css = ".errorMsg")
	private WebElement lblError;
	
	@FindBy(xpath = "//iframe[contains(@name,'vfFrameId_')]")
	private WebElement formIframe;
	
	@FindBy(xpath = "//li[@class = 'ui-menu-item'][1]/a")
	private WebElement melissaApiAddress;
	
	@FindBy(xpath = "//div/span[text()='Facility Name']/../..//span[@class='uiOutputText']")
	private WebElement lblFacilityName;
	
	@FindBy(xpath = "//div/div/span[text()='Address Type']/../..//span[contains(@class,'test-id__field-value')]/span")
	private WebElement lblAddressType;
	
	@FindBy(xpath = "//div/span[text()='Active from Date']/../..//span[contains(@class,'test-id__field-value')]/span")
	private WebElement lblActiveFromDate;
	
	@FindBy(xpath = "//div/span[text()='Active to Date']/../..//span[contains(@class,'test-id__field-value')]/span")
	private WebElement lblActiveToDate;
	
	@FindBy(xpath = "//div/span[text()='Address']/../..//span/a")
	private WebElement lblAddress;
	
	@FindBy(xpath = "//div/span[text()='Verified']/../..//span[contains(@class,'test-id__field-value')]/span/img")
	private WebElement cbIsVerified;
	
	@FindBy(css = "div[title='Edit']")
	private WebElement btnEdit;
	
	public TestSitePage(WebDriver driver) {
		this.driver = driver;
		ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
		PageFactory.initElements(decorator, this);
	}
	
	public void clickNewProviderAddress() {
		btnNewProviderAddress.click();
		Utilities.waitForPageLoaded(driver);
	}
	
	public void clickCancel() {
		switchDefaultContent();
		switchToIframe();
		btnCancel.click();
		switchDefaultContent();
	}
	
	public void clickSave() {
		switchDefaultContent();
		switchToIframe();
		btnSave.click();
		switchDefaultContent();
	}
	
	public void clickEdit() {
		btnEdit.click();
	}
	
	public boolean isRecentlyViewedPageDisplayed() {
		return lblRecentlyViewed.isDisplayed();
	}
	
	public boolean isTestSitePageDisplayed() {
		Utilities.waitForPageLoaded(driver);
		return btnNewProviderAddress.isDisplayed();
	}
	
	public boolean isErrorLabelDisplayed() {
		switchDefaultContent();
		switchToIframe();
		boolean flag = lblError.isDisplayed();
		switchDefaultContent();
		return flag;
	}
	
	public boolean isNewProviderAddressFormDisplayed() {
		Utilities.waitForFrameToBeAvailable(driver, formIframe);
		switchDefaultContent();
		switchToIframe();
		boolean flag = btnCancel.isDisplayed();
		switchDefaultContent();
		return flag;
	}
	
	public void fillForm(String facilityName, String addressType, Boolean verified, String activeFromDate,
			String activeToDate, String searchAddress) {
		switchDefaultContent();
		switchToIframe();
		txtFacilityName.clear();
		txtFacilityName.sendKeys(facilityName);
		Utilities.selectByVisibleText(ddAddressType, addressType);
		if(verified) {
			if(!cbVerified.isSelected()){
				cbVerified.click();
			}	
		}else {
			if(cbVerified.isSelected()){
				cbVerified.click();
			}	
		}
		dpActiveFromDate.clear();
		dpActiveFromDate.sendKeys(activeFromDate);
		dpActiveToDate.clear();
		dpActiveToDate.sendKeys(activeToDate);
		txtSearchAddress.clear();
		txtSearchAddress.sendKeys(searchAddress);
		melissaApiAddress.click();
		switchDefaultContent();
	}
	
	public void fillFormAddressOutsideUS(String facilityName, String addressType, Boolean verified, String activeFromDate,
			String activeToDate, String searchAddress) {
		boolean flag = false;
		switchDefaultContent();
		switchToIframe();
		txtFacilityName.clear();
		txtFacilityName.sendKeys(facilityName);
		Utilities.selectByVisibleText(ddAddressType, addressType);
		if(verified) {
			if(!cbVerified.isSelected()){
				cbVerified.click();
			}	
		}else {
			if(cbVerified.isSelected()){
				cbVerified.click();
			}	
		}
		dpActiveFromDate.clear();
		dpActiveFromDate.sendKeys(activeFromDate);
		dpActiveToDate.clear();
		dpActiveToDate.sendKeys(activeToDate);
		txtSearchAddress.clear();
		txtSearchAddress.sendKeys(searchAddress);
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
	
	public void validateProviderAddress(String facilityName, String addressType, Boolean verified, String activeFromDate,
			String activeToDate, String searchAddress) {
		Utilities.waitForElementToBeDisplayed(driver, lblFacilityName);
		driver.navigate().refresh();
		Utilities.waitForElementToBeDisplayed(driver, lblFacilityName);
		Assert.assertTrue(lblFacilityName.getText().equals(facilityName),"Facility Name is NOT as expected");
		Assert.assertTrue(lblAddressType.getText().equals(addressType),"Address Type is NOT as expected");
		Assert.assertTrue(Boolean.valueOf(cbIsVerified.getAttribute("Alt")).equals(verified),"Verified checkbox is NOT as expected");
		Assert.assertTrue(lblActiveFromDate.getText().equals(activeFromDate),"Active from Date is NOT as expected");
		Assert.assertTrue(lblActiveToDate.getText().equals(activeToDate),"Active to Date is NOT as expected");
		for(String i : searchAddress.split(",")) {
			Assert.assertTrue(lblAddress.getAttribute("title").toUpperCase().contains(i.trim().toUpperCase()),"Address is NOT as expected");
		}
	}
	
	public void switchToIframe() {
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe[contains(@name,'vfFrameId_')]"));	
		driver.switchTo().frame(iframes.get(iframes.size()-1));
	}
	
	public void switchDefaultContent() {
		driver.switchTo().defaultContent();
	}
}
