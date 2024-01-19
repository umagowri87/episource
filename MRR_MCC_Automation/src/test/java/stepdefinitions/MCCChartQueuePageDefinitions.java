package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import javassist.bytecode.analysis.Util;
import pageobjects.ConfigFileReader;
import pageobjects.LoginPage;
import pageobjects.MCCChartQueuePage;
import pageobjects.MCCHomePage;
import pageobjects.Utilities;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;

public class MCCChartQueuePageDefinitions {
	WebDriver driver = CommonDefinitions.driver;
	MCCChartQueuePage objMCCChartQueuePage = new MCCChartQueuePage(driver);
	MCCHomePage objMCCHomePage = new MCCHomePage(driver);
	MCCHomePageDefinitions objMccHomePageDefinitions = new MCCHomePageDefinitions();
	CommonDefinitions objCommonDefinitions = new CommonDefinitions();
	 static Map<Integer,String> map;
	static  Map<Integer,String> map2;
	static  Map<Integer,String> map3;
	static  Map<Integer,String> map4;
	 public int rowno;

	@When("Open My Pending charts")
	public void myPendingCharts() {

		// objMCCChartQueuePage = new MCCChartQueuePage(driver);
		objMCCChartQueuePage.clickMyPendingChartsTab();

	}

	@When("Open {string} chart")
	public void openChartId(String text) {

		// objMCCChartQueuePage = new MCCChartQueuePage(driver);
		objMCCChartQueuePage.openChartId(text);
	}

	@When("user switch to pdf")
	public void user_switch_to_pdf() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// driver.get(null);
		objMCCChartQueuePage.switchToPDFViewer();
	}

	@Then("Validate PDF viewer is opened")
	public void validatePDFviewerIsOpen() throws InterruptedException {
		// objMCCChartQueuePage = new MCCChartQueuePage(driver);

		 assertTrue(driver.getCurrentUrl().contains("PDFViewer"));
	}

	@When("Go to page {int} and click at {string} highlighted in {string}")
	public void clickInPDF(int page, String text, String color) {
		// objMCCChartQueuePage = new MCCChartQueuePage(driver);
		objMCCChartQueuePage.goToPageInPdf(page);
		//objMCCChartQueuePage.clickInPdf(text, "red");
	}

	@When("Capture mandatory fields")
	public void captureMandatoryFields(DataTable dataForm) {
		List<Map<String, String>> data = dataForm.asMaps(String.class, String.class);

		// objMCCChartQueuePage = new MCCChartQueuePage(driver);
		objMCCChartQueuePage.captureMandatoryFields(data.get(0).get("dxFlexText"), data.get(0).get("l1SecComment"),
				data.get(0).get("encText"));
	}

	@Then("Validate data in Coding screen")
	public void validateDataInCodingScreen(DataTable dataForm) {
		List<Map<String, String>> data = dataForm.asMaps(String.class, String.class);

		 objMCCChartQueuePage = new MCCChartQueuePage(driver);
		objMCCChartQueuePage.validateDataInCodingScreen(data.get(0).get("dxFlexText"),
		 data.get(0).get("l1SecComment"),
		 data.get(0).get("encText"));
	}

	@Then("Validate {string} is highlighted in {string}")
	public void validateTextHighlightedInPDF(String text, String color) throws InterruptedException {
		 objMCCChartQueuePage = new MCCChartQueuePage(driver);
		objMCCChartQueuePage.validateTextHighlightedInPDF(text, color);
	}

	@Then("verify {string},{string},{string},{string},{string},{string}")
	public void verify(String string, String string2, String string3, String string4, String string5, String string6)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.switchMccChart();
		 assertTrue(objMCCChartQueuePage.getDx_Delete().isDisplayed());
		 assertEquals(string, objMCCChartQueuePage.getDx_Delete().getText());
		 assertTrue(objMCCChartQueuePage.getDx_btnDelete().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_DOSstart().isDisplayed());
		 assertEquals(string2, objMCCChartQueuePage.getDx_DOSstart().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDOSStart().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_DOSend().isDisplayed());
		 assertEquals(string3, objMCCChartQueuePage.getDx_DOSend().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDOSEnd().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_ProviderName().isDisplayed());
		 assertEquals(string4, objMCCChartQueuePage.getDx_ProviderName().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textproviderName().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_search().isDisplayed());
		 assertEquals(string5, objMCCChartQueuePage.getDx_search().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textSearch().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_ProviderId().isDisplayed());
		 assertEquals(string6, objMCCChartQueuePage.getDx_ProviderId().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textproviderId().isEnabled());

	}

	@Then("validate for field {string}")
	public void validate_for_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartQueuePage.getDx_ProviderNPI().isDisplayed());
		 assertEquals(string, objMCCChartQueuePage.getDx_ProviderNPI().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textproviderNPI().isEnabled());

		/*
		 *  assertTrue(objMCCChartQueuePage.getDx_EncPageRange().isDisplayed()
		 * );  assertEquals(string2,
		 * objMCCChartQueuePage.getDx_EncPageRange().getText());
		 *  assertTrue(objMCCChartQueuePage.getDx_textENCpageRange1().
		 * isEnabled());
		 *  assertTrue(objMCCChartQueuePage.getDx_textENCpageRange2().
		 * isEnabled());
		 * 
		 *  assertTrue(objMCCChartQueuePage.getDx_EncFlex1().isDisplayed());
		 *  assertEquals(string3,
		 * objMCCChartQueuePage.getDx_EncFlex1().getText());
		 *  assertTrue(objMCCChartQueuePage.getDx_textDxFlex1().isEnabled());
		 * 
		 *  assertTrue(objMCCChartQueuePage.getDx_EncTestText().isDisplayed())
		 * ;  assertEquals(string4,
		 * objMCCChartQueuePage.getDx_EncTestText().getText());
		 *  assertTrue(objMCCChartQueuePage.getDx_textENCTestText().isEnabled(
		 * ));
		 * 
		 *  assertTrue(objMCCChartQueuePage.getDx_EncFlex3().isDisplayed());
		 *  assertEquals(string5,
		 * objMCCChartQueuePage.getDx_EncFlex3().getText());
		 *  assertTrue(objMCCChartQueuePage.getDx_textENCFlex3().isEnabled());
		 */

	}

	@Then("check for {string},{string},{string}")
	public void check_for(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
		/*
		 *  assertTrue(objMCCChartQueuePage.getDx_EncTestDropdown().
		 * isDisplayed());  assertEquals(string,
		 * objMCCChartQueuePage.getDx_EncTestDropdown().getText());
		 *  assertTrue(objMCCChartQueuePage.getDx_textENCTestDropdown().
		 * isEnabled());
		 * 
		 *  assertTrue(objMCCChartQueuePage.getDx_EncTestDate().isDisplayed())
		 * ;  assertEquals(string2,
		 * objMCCChartQueuePage.getDx_EncTestDate().getText());
		 *  assertTrue(objMCCChartQueuePage.getDx_textENCTestDate().isEnabled(
		 * ));
		 */

		 assertTrue(objMCCChartQueuePage.getDx_CoderDX().isDisplayed());
		 assertEquals(string, objMCCChartQueuePage.getDx_CoderDX().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textCoderDXes().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_FirstPage().isDisplayed());
		 assertEquals(string2, objMCCChartQueuePage.getDx_FirstPage().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textFirstPage().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_Add().isDisplayed());
		 assertEquals(string3, objMCCChartQueuePage.getDx_Add().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textAdd().isEnabled());

		objMCCChartQueuePage.getDx_downarrow().click();
	}

	@Then("also verify {string},{string},{string},{string},{string},{string} and {string}")
	public void also_verify_and(String string, String string2, String string3, String string4, String string5,
			String string6, String string7) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartQueuePage.getDx_Deleteadd().isDisplayed());
		 assertEquals(string, objMCCChartQueuePage.getDx_Deleteadd().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textAdd().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_code().isDisplayed());
		 assertEquals(string2, objMCCChartQueuePage.getDx_code().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textdxCode().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_HCC().isDisplayed());
		 assertEquals(string3, objMCCChartQueuePage.getDx_HCC().getText());
		//  assertFalse(objMCCChartQueuePage.getDx_textHCC().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_page().isDisplayed());
		 assertEquals(string4, objMCCChartQueuePage.getDx_page().getText());
		 assertTrue(objMCCChartQueuePage.getDX_textPage().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_Flex1().isDisplayed());
		 assertEquals(string5, objMCCChartQueuePage.getDx_Flex1().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDxFlex1().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_Flex2().isDisplayed());
		 assertEquals(string6, objMCCChartQueuePage.getDx_Flex2().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textFlex2().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_L1Secondary().isDisplayed());
		 assertEquals(string7, objMCCChartQueuePage.getDx_L1Secondary().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textL1Secondary().isEnabled());

	}

	@Then("also validate for {string},{string},{string} and {string}")
	public void also_validate_for_and(String string, String string2, String string3, String string4) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartQueuePage.getDx_Flex3().isDisplayed());
		 assertEquals(string, objMCCChartQueuePage.getDx_Flex3().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDxFlex3().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_TestDropdown().isDisplayed());
		 assertEquals(string2, objMCCChartQueuePage.getDx_TestDropdown().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDxTestDropdown().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_TestDate().isDisplayed());
		 assertEquals(string3, objMCCChartQueuePage.getDx_TestDate().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDxTestDate().isEnabled());

	}

	@When("user enters valid provider name")
	public void user_enters_valid_provider_name() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// objMCCChartQueuePage.getDx_closeAlertmsg().click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getAddNewWncounter()));
			objMCCChartQueuePage.getAddNewWncounter().click();

		} catch (ElementClickInterceptedException e) {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getAddNewWncounter()));
			objMCCChartQueuePage.getAddNewWncounter().click();
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart()));
		objMCCChartQueuePage.getDx_textDOSStart().click();

		wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_DummyDate()));
		objMCCChartQueuePage.getDx_DummyDate().click();
		objMCCChartQueuePage.getDx_textproviderName().click();
		objMCCChartQueuePage.getDx_textproviderName().sendKeys("test");
		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Dummy')]"));
		try {
			WebElement element = elements.get(0);
			element.click();
		} catch (ElementNotInteractableException e) {

			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
			w.until(ExpectedConditions.visibilityOf(elements.get(0)));
			WebElement element = elements.get(0);
			element.click();
		}
		objMCCChartQueuePage.getDx_downarrow().click();

	}

	@When("user enters invalid {string}")
	public void user_enters_invalid(String string) {
		// Write code here that turns the phrase above into concrete actions
		objMCCChartQueuePage.getDx_textdxCode().click();
		objMCCChartQueuePage.getDx_textdxCode().sendKeys(string);
	}

	@When("user enters invalid numeric DX code")
	public void user_enters_invalid_numeric_dx_code() throws AWTException {
		// Write code here that turns the phrase above into concrete actions
		//Utilities.clickonElement(objMCCChartQueuePage.getDx_downarrow(), driver);
		//objMCCChartQueuePage.getDx_downarrow().click();
		objMCCChartQueuePage.getDx_textdxCode().click();
		objMCCChartQueuePage.getDx_textdxCode().sendKeys("123");
		Robot robot = new Robot(); 
	    robot.keyPress(KeyEvent.VK_TAB); 
	    robot.keyRelease(KeyEvent.VK_TAB); 
	}

	@When("clicks on save button")
	public void clicks_on_save_button() throws InterruptedException {

		// Write code here that turns the phrase above into concrete actions
		//Thread.sleep(3000);
		Utilities.waitForPageLoaded(driver);
		try {
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
			w.until(ExpectedConditions.elementToBeClickable(objMCCChartQueuePage.getDx_Save())).click();
			Utilities.clickonElement(objMCCChartQueuePage.getDx_Save(), driver);

		} catch (ElementClickInterceptedException e) {
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
			w.until(ExpectedConditions.elementToBeClickable(objMCCChartQueuePage.getDx_Save())).click();
			Utilities.clickonElement(objMCCChartQueuePage.getDx_Save(), driver);
		}catch (TimeoutException e) {
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(100));
			w.until(ExpectedConditions.elementToBeClickable(objMCCChartQueuePage.getDx_Save())).click();
			Utilities.clickonElement(objMCCChartQueuePage.getDx_Save(), driver);
		}
		
		try {
			objMCCChartQueuePage.getDx_ok().click();
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
			w.until(ExpectedConditions.elementToBeClickable(objMCCChartQueuePage.getDx_ok()));
			objMCCChartQueuePage.getDx_ok().click();
		}
		Utilities.waitForPageLoaded(driver);
		// Thread.sleep(3000);

		// objMCCChartQueuePage.getDx_Save().click();

		// objMCCChartQueuePage.getDx_ok().click();

	}
	
	@When("click on open new encounter")
	public void click_on_open_new_encounter() {
	    // Write code here that turns the phrase above into concrete actions
	
		try {
			System.out.println("I am in try block");
			Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_openEncounters(), 300);
			System.out.println("I am displayed");
			Utilities.waitForElementToBeClickable(driver, objMCCChartQueuePage.getDx_openEncounters());
			System.out.println("I am clickable");
			Utilities.mouseHoverToTheElemnet(objMCCChartQueuePage.getDx_openEncounters(), driver);
			System.out.println("I am mousehovered");
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_openEncounters()));
			//objMCCChartQueuePage.getDx_openEncounters().click();
			Utilities.clickUsingActions(objMCCChartQueuePage.getDx_openEncounters(), driver);
			//Thread.sleep(3000);
			Utilities.jsClick(driver, objMCCChartQueuePage.getDx_openEncounters());
			System.out.println("clicked in try block");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			/*wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_downarrow()));
			objMCCChartQueuePage.getDx_downarrow().click();*/
			//new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(ElementClickInterceptedException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr/td[1]/div/div/i")));
			//driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr/td[1]/div/div/i")).click();
			System.out.println("i am in catch block");

			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();",objMCCChartQueuePage.getDx_downarrow() );
			//Utilities.clickonElement(objMCCChartQueuePage.getDx_openEncounters(), driver);
			Utilities.clickUsingActions(objMCCChartQueuePage.getDx_openEncounters(), driver);
			System.out.println("clicked in catch block");

		}
	
	
	}
	@When("Click on Add New encounter")
	public void click_on_add_new_encounter() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("verifys for valid error message {string} and {string}")
	public void verifys_for_valid_error_message_and(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		String[] select_values = { string, string2 };
		List<WebElement> status = driver.findElements(
				By.xpath("//div[contains(@id,'el-popover') and @aria-hidden='false']/div/div/div[2]/div/ul/li"));
		System.out.println("size :" + status.size());
		for (int i = 0; i < status.size() - 1; i++) {
			WebElement element = status.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element);

			String attribute = element.getText();
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + select_values[i]);
			 assertEquals(attribute, select_values[i]);
			// System.out.println("Values of dropdown :"+attribute);
		}
		// objMCCChartWorkflowTabPage.getWf_txtPDFAccessReason().click();
		try {
			objMCCChartQueuePage.getDx_Deleteicon().click();

		} catch (ElementClickInterceptedException e) {
			Utilities.clickonElement(objMCCChartQueuePage.getDx_Deleteicon(), driver);
			//objMCCChartQueuePage.getDx_Deleteicon().click();
		}

		objMCCChartQueuePage.getDx_okay().click();
		// Thread.sleep(3000);

	}

	@Then("verifys for valid error message {string},{string} and {string}")
	public void verifys_for_valid_error_message_and(String string, String string2, String string3)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		String[] select_values = { string, string2, string3 };
		// objMCCChartWorkflowTabPage.getWf_txtPDFAccessReason().click();

		List<WebElement> status = driver.findElements(
				By.xpath("//div[contains(@id,'el-popover') and @aria-hidden='false']/div/div/div[2]/div/ul/li"));
		System.out.println("size :" + status.size());
		for (int i = 0; i < status.size() - 1; i++) {
			WebElement element = status.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element);

			String attribute = element.getText();
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + select_values[i]);
			 assertEquals(attribute, select_values[i]);
			// System.out.println("Values of dropdown :"+attribute);
		}
		// objMCCChartWorkflowTabPage.getWf_txtPDFAccessReason().click();
		try {
			objMCCChartQueuePage.getDx_Deleteicon().click();

		} catch (ElementClickInterceptedException e) {
			objMCCChartQueuePage.getDx_Deleteicon().click();
		}

		objMCCChartQueuePage.getDx_okay().click();
		// Thread.sleep(3000);

		// objMCCChartQueuePage.getDx_textDOSStart().clear();
	}

	@When("user clicks on workflow tab")
	public void user_clicks_on_workflow_tab() {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getTab_WorkFlow().click();
	}

	@When("user clicks on chart details tab")
	public void user_clicks_on_chart_details_tab() {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getTab_chartdetails().click();
	}
	

	@When("user enters valid date, {int} , {string} and {string}")
	public void user_enters_valid_date_and(Integer int1, String string, String string2)  throws AWTException {
    // Write code here that turns the phrase above into concrete actions
	
		
	objMCCChartQueuePage.getDx_textDOSStart().click();
	objMCCChartQueuePage.getDx_date_yearArrow().click();
	objMCCChartQueuePage.getDx_date_date8().click();
	
	//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
	
	WebElement dx_textproviderName = objMCCChartQueuePage.getDx_textproviderName1(string2);
	dx_textproviderName.click();
	
	objMCCChartQueuePage.getDx_textproviderName().sendKeys(string2);
	WebElement element2 = driver.findElement(By.xpath("//div[contains(text(),'"+string2+"')]"));
	Utilities.clickonElement(element2, driver);
	/*List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Dummy')]"));
	try {
		WebElement element = elements.get(0);
		Utilities.clickonElement(element, driver);
	}

		catch(ElementNotInteractableException e)
		{
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
			WebElement element = elements.get(0);
			element.click();

		}*/
	//objMCCChartQueuePage.getDx_textproviderName().sendKeys(Keys.TAB);
	//objMCCChartQueuePage.getDx_textproviderName().sendKeys(Keys.TAB);
	
	WebElement dx_visittype = objMCCChartQueuePage.getDx_visittype();
	//dx_visittype.click();
	try {
	WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr['"+string+"']/td[9]/div/div/span/div/input"));
	JavascriptExecutor j = (JavascriptExecutor) driver;
    j.executeScript("arguments[0].value=\'" + string2 + "\';", l); 
	//j.executeScript("arguments[0].click();", l);
	l.sendKeys("vp");
	}
	catch(ElementNotInteractableException e) {
		WebElement l = driver.findElement(By.xpath("//*[@id=\"dxTable\"]/div[3]/table/tbody/tr['"+string+"']/td[9]/div/div/span/div/input"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", l);
		Robot robot = new Robot(); 
	     
		robot.keyPress(KeyEvent.VK_Q); 
	    robot.keyRelease(KeyEvent.VK_Q); 
	
	}
	
	
}
@When("user enters valid {string}")
public void user_enters_valid(String string) {
    // Write code here that turns the phrase above into concrete actions
}
@When("enters {string} and {string}")
public void enters_and(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
}


	@When("user click on Add New Encounter")
	public void user_click_on_add_new_encounter() {
		// Write code here that turns the phrase above into concrete actions
		// WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		// w.until(ExpectedConditions.elementToBeClickable(objMCCChartQueuePage.getAddNewWncounter())).click();;
		// objMCCChartQueuePage.getAddNewWncounter().click();
		// driver.navigate().refresh();
		try {

			objMCCChartQueuePage.getAddNewWncounter().click();

		} catch (ElementClickInterceptedException e) {
			//Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getAddNewWncounter()));
			System.out.println("i am in catch block");
			//Utilities.clickonElement(objMCCChartQueuePage.getAddNewWncounter(),driver);
			Utilities.jsClick(driver, objMCCChartQueuePage.getAddNewWncounter());
		}

	}

	@When("user enters valid date and provider name")
	public void user_enters_valid_date_and_provider_name() throws AWTException {
		// Write code here that turns the phrase above into concrete actions
		
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.alertIsPresent());

			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("Alert not present");
		}

		try {
			objMCCChartQueuePage.getDx_textDOSStart().isDisplayed();
		} catch (NoSuchElementException e) {
			driver.navigate().refresh();
			objMCCChartQueuePage.getAddNewWncounter().click();
		}
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250)");
		
		objMCCChartQueuePage.getDx_textDOSStart().click();
		String year = objMCCChartQueuePage.getDx_detepickeryr().getText();
		System.out.println(year);
		if(year.equals("2019"))
		{
		objMCCChartQueuePage.getDx_date_yearArrow().click();
		objMCCChartQueuePage.getDx_date_date8().click();
		}
		else {
			Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(), driver);
			//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart(),"01/08/2021", driver);
			//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
			Robot robot = new Robot(); 
		     
			robot.keyPress(KeyEvent.VK_TAB); 
		    robot.keyRelease(KeyEvent.VK_TAB); 
		}
	
		//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart(),"01/08/2021", driver);
		// objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
		
		WebElement dx_textproviderName = objMCCChartQueuePage.getDx_textproviderName();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOf(dx_textproviderName));
		
		try {
			Utilities.clickonElement(dx_textproviderName, driver);
		} catch (ElementClickInterceptedException e1) {
			// TODO Auto-generated catch block
			Utilities.clickonElement(dx_textproviderName, driver);
		}
		// objMCCChartQueuePage.getDx_textproviderName().sendKeys("test");
		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Dummy')]"));
		try {
			WebElement element = elements.get(0);
			element.click();
		}

		catch (ElementNotInteractableException e) {

			// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
			WebElement element = elements.get(0);
			element.click();

		}
		
		WebElement dx_visittype = objMCCChartQueuePage.getDx_visittype();
		//dx_visittype.click();
		try {
		WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[9]/div/div/span/div/input"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("arguments[0].value='Test';", l); 
		//j.executeScript("arguments[0].click();", l);
		l.sendKeys("vp");
		}
		catch(ElementNotInteractableException e) {
			WebElement l = driver.findElement(By.xpath("//*[@id=\"dxTable\"]/div[3]/table/tbody/tr[1]/td[9]/div/div/span/div/input"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", l);
			Robot robot1= new Robot(); 
		     
			robot1.keyPress(KeyEvent.VK_Q); 
		    robot1.keyRelease(KeyEvent.VK_Q); 

		}

		

	}
	
	@When("user click on open all encounter")
	public void user_click_on_open_all_encounter() {
	    // Write code here that turns the phrase above into concrete actions

		try {
			System.out.println("Iam in try block");
			Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_openEncounters(), 300);
			System.out.println("I am displayed");
			Utilities.waitForElementToBeClickable(driver, objMCCChartQueuePage.getDx_openEncounters());
			System.out.println("I am clickable");
			Utilities.mouseHoverToTheElemnet(objMCCChartQueuePage.getDx_openEncounters(), driver);
			System.out.println("I am mousehovered");
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_openEncounters()));
			//objMCCChartQueuePage.getDx_openEncounters().click();
			Utilities.clickUsingActions(objMCCChartQueuePage.getDx_openEncounters(), driver);
			//Thread.sleep(3000);
			//Utilities.jsClick(driver, objMCCChartQueuePage.getDx_openEncounters());
			System.out.println("clicked in try block");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			/*wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_downarrow()));
			objMCCChartQueuePage.getDx_downarrow().click();*/
			//new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(ElementClickInterceptedException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr/td[1]/div/div/i")));
			//driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr/td[1]/div/div/i")).click();
			System.out.println("i am in catch block");

			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();",objMCCChartQueuePage.getDx_downarrow() );
			//Utilities.clickonElement(objMCCChartQueuePage.getDx_openEncounters(), driver);
			Utilities.clickUsingActions(objMCCChartQueuePage.getDx_openEncounters(), driver);
			System.out.println("clicked in catch block");

		}
	
	}

	@When("enter the value as {string}")
	public void enter_the_value_as(String string) {
		// Write code here that turns the phrase above into concrete actions
		objMCCChartQueuePage.getDx_visittype().click();
		objMCCChartQueuePage.getDx_visittype().sendKeys(string);
	}

	@When("user enters valid DX Code {string}")
	public void user_enters_valid_dx_code(String string) throws AWTException {
		// Write code here that turns the phrase above into concrete actions
		objMCCChartQueuePage.getDx_textdxCode().click();
		objMCCChartQueuePage.getDx_textdxCode().clear();
		objMCCChartQueuePage.getDx_textdxCode().sendKeys(string);
		objMCCChartQueuePage.getDx_textdxCode().sendKeys(Keys.TAB);
	}
	/*
	 * @When("user enters valid {string}") public void user_enters_valid(String
	 * string) throws AWTException { // Write code here that turns the phrase above
	 * into concrete actions objMCCChartQueuePage.getDx_textdxCode().click();
	 * objMCCChartQueuePage.getDx_textdxCode().sendKeys("i30");
	 * objMCCChartQueuePage.getDx_textdxCode().sendKeys(Keys.TAB);
	 * 
	 * }
	 */

	@When("enters page no, slects {string} as L1 primary comment")
	public void enters_page_no_slects_as_l1_primary_comment(String string) throws AWTException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		//objMCCChartQueuePage.getDx_textpageno().click();
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textpageno(), driver);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_3);
		robot.keyRelease(KeyEvent.VK_3);
		// robot.keyRelease(KeyEvent.VK_TAB);
		List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
		System.out.println("size" + select.size());
		select.get(2).click();
		List<WebElement> select_values = driver.findElements(
				By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
		System.out.println("size " + select_values.size());

		for (int i = 0; i < select_values.size(); i++) {
			WebElement element = select_values.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element);

			String attribute = element.getText();
			String value = string;
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + value);
			if (attribute.equalsIgnoreCase(value)) {
				 assertEquals(attribute, value);
				element.click();
				break;
			}

			// System.out.println("Values of dropdown :"+attribute);
		}
		Thread.sleep(5000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,250)");
		
	}

	@When("clicks on save and continue button")
	public void clicks_on_save_and_continue_button() {
		// Write code here that turns the phrase above into concrete actions
		//objMCCChartQueuePage.getDx_SaveContinue().click();
		Utilities.waitForPageLoaded(driver);
		Utilities.clickonElement(objMCCChartQueuePage.getDx_SaveContinue(), driver);
		objMCCChartQueuePage.getDx_ok().click();
		Utilities.waitForPageLoaded(driver);
	}
	
	@Then("save the given values and click on submit button")
	public void save_the_given_values_and_click_on_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		
		List<WebElement> elements=objMCCChartQueuePage.getDx_textMAprimary_elements();
		int i;
		int length = elements.size();
		map = new LinkedHashMap<Integer,String>();
	
		for(i=0;i<length;i++) {
			if(i==4 || i==9) {
				//i=i+1;
				WebElement element = elements.get(i);
				String jsGetValue = Utilities.jsGetValue(driver, element);
				
				System.out.println("Jsvalue :" + jsGetValue+i);
			}
			else {
			WebElement element = elements.get(i);
			String jsGetValue = Utilities.jsGetValue(driver, element);
			map.put(i, jsGetValue);
		
			System.out.println("Jsvalue :" + jsGetValue+i);
			// assertEquals(string, jsGetValue);
			}
		
		}
	
		System.out.println(map);
		System.out.println(map.size());
	
	
	 
	}
	
	@Then("again open the chart and save the given values")
	public void again_open_the_chart_and_save_the_given_values() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		/******************************open the chart******************************************/
		objMCCChartQueuePage.closecurrentWindow();
		 Set<String> windowHandles = driver.getWindowHandles();
		String firstWindowHandle = windowHandles.iterator().next();
        driver.switchTo().window(firstWindowHandle);
		//objMCCChartQueuePage.getcurrentWindows();
		// String originalHandle = driver.getWindowHandle();
		//driver.switchTo().window(objMccHomePageDefinitions.originalHandle1);
		/* System.out.println("current window :"+objMccHomePageDefinitions.originalHandle1);
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(objMccHomePageDefinitions.originalHandle1)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }*/
		 //driver.close();
	     objMCCHomePage.switchToIframe();
		WebElement element = driver.findElement(By.xpath("//td/a[contains(text(), 'A-FMR9K8')]"));
		Utilities.clickonElement(element, driver);
		objMCCHomePage.switchToMccChart();
		
		user_clicks_on_openall_encounters_button();
		//Utilities.tkScreenshot(driver);
		//objMCCHomePage.openChartId("A-FMR9K8");
		/*************************************save the L2/MA primary comment***********************************/
		
		List<WebElement> elements=objMCCChartQueuePage.getDx_textL2MAprimary_elements();
		int i;
		int length = elements.size();
		map = new LinkedHashMap<Integer,String>();
			
			
		for(i=0;i<length;i++) {
			/*if(i==4 || i==8 || i==9) {
				//i=i+1;
				WebElement element = elements.get(i);
				String jsGetValue = Utilities.jsGetValue(driver, element);
				
				System.out.println("Jsvalue :" + jsGetValue+i);
			}
			else {*/
			WebElement element1 = elements.get(i);
			String jsGetValue = Utilities.jsGetValue(driver, element1);
			map.put(i, jsGetValue);
		
			System.out.println("Jsvalue :" + jsGetValue+i);
			// assertEquals(string, jsGetValue);
			//}
		
		}
	
		System.out.println(map);
		System.out.println(map.size());
		// assertFalse(bodyText.contains("Spam Virus"), "Spam Message Text Is Not Present");
		// assertEquals(string, objMCCChartQueuePage.getDx_textL2MAprimary().getAttribute("innerHTML"));
		//objMCCChartQueuePage.closecurrentWindow();
		driver.close();

		objMCCHomePage.switchToMccAllocation();
	}

	@When("clicks on Add row")
	public void clicks_on_add_row() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(500);
		/*
		 * List<WebElement> elements = driver.findElements(By.
		 * xpath("//div[@class='dx-detail-action-btns coding-ui-button']/*[local-name()='svg']"
		 * )); System.out.println(elements.size()); elements.get(1).click();
		 */
		WebElement element = driver.findElement(By.xpath(
				"//div[@class='dx-detail-action-btns coding-ui-button']//*[local-name()='svg']//*[local-name()='path' and @d='M11.8334 6.83329H6.83335V11.8333H5.16669V6.83329H0.166687V5.16663H5.16669V0.166626H6.83335V5.16663H11.8334V6.83329Z']"));
		if (element.isDisplayed()) {
			element.isEnabled();
		} else {
			Utilities.jsClick(driver, element);
			// element.click();
		}
	}

	@When("user enters another DX code as {string}")
	public void user_enters_another_dx_code_as(String string) throws AWTException {
		// Write code here that turns the phrase above into concrete actions
		try {
			objMCCChartQueuePage.getDx_textdxCode2().click();
		} catch (ElementClickInterceptedException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textdxCode2()));

			objMCCChartQueuePage.getDx_textdxCode2().click();
		}
		objMCCChartQueuePage.getDx_textdxCode2().clear();
		objMCCChartQueuePage.getDx_textdxCode2().sendKeys(string);
		objMCCChartQueuePage.getDx_textdxCode2().sendKeys(Keys.TAB);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_3);
		robot.keyRelease(KeyEvent.VK_3);
		// robot.keyRelease(KeyEvent.VK_TAB);
		List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder=\"Select\"]"));
		System.out.println("size" + select.size());
		select.get(2).click();
		List<WebElement> select_values = driver.findElements(By
				.xpath("//div[@class=\"el-select-dropdown el-popper\" and @x-placement=\"top-start\"]/div/div/ul/li"));
		System.out.println("size " + select_values.size());

		for (int i = 0; i < select_values.size(); i++) {
			WebElement element = select_values.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element);

			String attribute = element.getText();
			String value = "Add";
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + value);
			if (attribute.equalsIgnoreCase(value)) {
				 assertEquals(attribute, value);
				element.click();
			}

			// System.out.println("Values of dropdown :"+attribute);
		}

	}

	/*
	 * @When("user again enters same {string}") public void
	 * user_again_enters_same(String string) throws AWTException { // Write code
	 * here that turns the phrase above into concrete actions
	 * objMCCChartQueuePage.getDx_textdxCode2().click();
	 * objMCCChartQueuePage.getDx_textdxCode2().sendKeys("i30");
	 * objMCCChartQueuePage.getDx_textdxCode2().sendKeys(Keys.TAB); Robot robot =
	 * new Robot(); robot.keyPress(KeyEvent.VK_3); robot.keyRelease(KeyEvent.VK_3);
	 * //robot.keyRelease(KeyEvent.VK_TAB); List<WebElement> select =
	 * driver.findElements(By.xpath("//input[@placeholder=\"Select\"]"));
	 * System.out.println("size"+select.size()); select.get(2).click();
	 * List<WebElement> select_values = driver.findElements(By.
	 * xpath("//div[@class=\"el-select-dropdown el-popper\" and @x-placement=\"top-start\"]/div/div/ul/li"
	 * )); System.out.println("size "+select_values.size());
	 * 
	 * for (int i=0;i<select_values.size();i++) { WebElement element =
	 * select_values.get(i); Actions action = new Actions(driver);
	 * 
	 * //Performing the mouse hover action on the target element.
	 * action.moveToElement(element);
	 * 
	 * String attribute=element.getText(); String value="Add";
	 * System.out.println("Attribute :"+attribute);
	 * System.out.println("Given string :"+value);
	 * if(attribute.equalsIgnoreCase(value)) {
	 *  assertEquals(attribute,value); element.click(); }
	 * 
	 * //System.out.println("Values of dropdown :"+attribute); } }
	 */

	@Then("verify for No ICD error mesage {string}")
	public void verify_for_no_icd_error_mesage(String string) {
		// Write code here that turns the phrase above into concrete actions
	
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='el-col el-col-18']/div/ul/li")));
			String text = objMCCChartQueuePage.getDx_duplicateDxcode().getText();
			System.out.println(text);
			 assertEquals(string, text);

	}

	@Then("verifys for valid error message {string}")
	public void verifys_for_valid_error_message(String string) {
		// Write code here that turns the phrase above into concrete actions
		String text = objMCCChartQueuePage.getDx_duplicateDxcode().getText();
		 System.out.println(text);
		//  assertEquals(text.contains(string),string);
		// String fetch = Driver.findelement(By.xpath("").getText();
		 assertTrue( text.contains(string));
		/*
		 * if(text.contains("\"000\" and a valid DX Code cannot exist together ")) {
		 *  assertTrue(true); } else {
		 * 
		 *  assertFalse(false); }
		 */
		System.out.println("****THE END***********");

		try {
			objMCCChartQueuePage.getDx_Deleteicon().click();

		} catch (ElementClickInterceptedException e) {
			objMCCChartQueuePage.getDx_Deleteicon().click();
		}

		objMCCChartQueuePage.getDx_okay().click();

	}

	@Then("verify for valid error message {string}")
	public void verify_for_valid_error_message(String string) {
		// Write code here that turns the phrase above into concrete actions
		try {
			WebElement element = driver.findElement(By.xpath("//div[@class='el-col el-col-18']/div/ul/li"));
			String actual = element.getText();
			System.out.println(actual);
			 assertEquals(actual, string);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Error message not displayed for 000 with HCC");
		}
		
		
	}

	@When("user Delete the encounter")
	public void user_delete_the_encounter() {
		// Write code here that turns the phrase above into concrete actions
		try {
			Utilities.clickonElement(objMCCChartQueuePage.getDx_Deleteicon(), driver);

		}
		catch (ElementClickInterceptedException e) {
			Utilities.clickonElement(objMCCChartQueuePage.getDx_Deleteicon(), driver);
		}
		catch(StaleElementReferenceException e)
		{
			Utilities.clickonElement(objMCCChartQueuePage.getDx_Deleteicon(), driver);

		}
		Utilities.clickonElement(objMCCChartQueuePage.getDx_okay(),driver);
		//objMCCChartQueuePage.getDx_okay().click();

	}

	@When("user Add New encounter")
	public void user_add_new_encounter() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		try {

			objMCCChartQueuePage.getAddNewWncounter().click();

		} catch (ElementClickInterceptedException e) {
			//Thread.sleep(500);
			Utilities.clickonElement(objMCCChartQueuePage.getAddNewWncounter(),driver);
			//objMCCChartQueuePage.getAddNewWncounter().click();
		}

	}

	@When("user refreshs the page")
	public void user_refreshs_the_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.navigate().refresh();
		// driver.switchTo().alert().accept();
	}

	@When("user refresh the page")
	public void user_refresh_the_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.navigate().refresh();
		driver.switchTo().alert().accept();
	}

	@When("user gives DOS Start and DOS End date")
	public void user_gives_dos_start_and_dos_end_date() {
		// Write code here that turns the phrase above into concrete actions
		objMCCChartQueuePage.getDx_textDOSStart().click();
		objMCCChartQueuePage.getDx_date_yearArrow().click();
		objMCCChartQueuePage.getDx_date_date8().click();
		// objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
	}

	@When("user clear the values in coder name field")
	public void user_clear_the_values_in_coder_name_field() {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getText_CoderName().click();
		objMCCHomePage.getText_CoderName().clear();
		objMCCHomePage.getText_CoderName().click();
		objMCCHomePage.getText_CoderName().sendKeys("c");
		objMCCHomePage.getText_CoderName().sendKeys(Keys.BACK_SPACE);

	}

	@When("user clicks on down arrow")
	public void user_clicks_on_down_arrow() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// WebElement element =
		// driver.findElement(By.xpath("//iframe[contains(@name,'j_id6')]"));
		// driver.switchTo().frame(element);
		//objMCCHomePage.Click_MCC_chq();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)");
		
		Utilities.waitForPageLoaded(driver);
		objMCCHomePage.switchToIframe();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(objMCCHomePage.getChartheader()));
		driver.switchTo().defaultContent();
		
		/*objMCCHomePage.switchToIframe();
		Utilities.waitForElementToBeDisplayed(driver, objMCCHomePage.getChartheader());
		driver.switchTo().defaultContent();*/
		// Thread.sleep(500);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (driver.getCurrentUrl().contains("epiuat"))
		{
						
		try {
			Thread.sleep(500);
			Utilities.mouseHoverToTheElemnet(objMCCHomePage.getLogout_arrow_uat(), driver);
			Utilities.jsClick(driver, objMCCHomePage.getLogout_arrow_uat());
		} catch (NoSuchElementException e) {
			Utilities.mouseHoverToTheElemnet(objMCCHomePage.getLogout_arrow_uat(), driver);
			Utilities.jsClick(driver, objMCCHomePage.getLogout_arrow_uat());
		}
		}
		else {
			try {
				Thread.sleep(500);
				Utilities.mouseHoverToTheElemnet(objMCCHomePage.getLogout_arrow_qa(), driver);
				Utilities.jsClick(driver, objMCCHomePage.getLogout_arrow_qa());
			} catch (NoSuchElementException e) {
				Utilities.mouseHoverToTheElemnet(objMCCHomePage.getLogout_arrow_qa(), driver);
				Utilities.jsClick(driver, objMCCHomePage.getLogout_arrow_qa());
			}
		}
		
	
		// Utilities.mouseClickToTheElemnet(objMCCHomePage.getLogout_arrow(), driver);
	}

	@When("selects Logout option")
	public void selects_logout_option() {
		// Write code here that turns the phrase above into concrete actions
		try {
			try {
				Utilities.clickonElement(objMCCHomePage.getLogout(), driver);
			} catch (StaleElementReferenceException e) {
				Utilities.clickUsingActions(objMCCHomePage.getLogout(), driver);
			}
			catch(ElementClickInterceptedException e1 ) {
				Utilities.clickUsingActions(objMCCHomePage.getLogout(), driver);

			}
		} catch (UnhandledAlertException f) {
			    try {
			        Alert alert = driver.switchTo().alert();
			        String alertText = alert.getText();
			        System.out.println("Alert data: " + alertText);
			        alert.accept();
			    } catch (NoAlertPresentException e) {
			        e.printStackTrace();
			    }
			}
		
	}

	@Then("verifies for Login page")
	public void verifies_for_login_page() {
		// Write code here that turns the phrase above into concrete actions
		try {
			Utilities.waitForPageLoaded(driver);
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        //System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}
	}

	@When("user get the title of page and log in as salesforce as classic")
	public void user_get_the_title_of_page_and_log_in_as_salesforce_as_classic() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String title = driver.getTitle();
		System.out.println("title :" +title);
		//title :Salesforce - Unlimited Edition

		//title :title :Login | Salesforce | Salesforce
		if(title.contains("Login"))
		{
			String user = null;
			String pswd=null;
			ConfigFileReader configFileReader;
			configFileReader= new ConfigFileReader();
			 user = configFileReader.getEpiUATAdminUserName();
		    pswd = configFileReader.getUATpassword();
		
			//objCommonDefinitions.goToHomePage(Scenario);
		     LoginPage objLoginPage;
		    
		    objLoginPage = new LoginPage(driver);
			objLoginPage.setUserName(user);
			objLoginPage.setPassword(pswd);
			//objLoginPage.setPassword(configFileReader.getAdminPassword());
			objLoginPage.clickLogIn();
		}
		else {
			
			
			// log_in_as_in_mcc_and_click_on_single_chart_mover("Test Automation");
			 
			 
		}
	}
	
	
	@When("login as Admin")
	public void login_as_admin() {
		// Write code here that turns the phrase above into concrete actions
		//Utilities.waitForPageLoaded(driver);
		
		LoginPage objLoginPage = new LoginPage(driver);
		ConfigFileReader configFileReader;
		configFileReader = new ConfigFileReader();
		//String user = configFileReader.getQAAdminUserName();
		String user = configFileReader.getEpiUATAdminUserName();
		try {
			objLoginPage.setUserName(user);
		} catch (UnhandledAlertException f1) {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
		}
		objLoginPage.setPassword(configFileReader.getAdminPassword());
		objLoginPage.clickLogIn();
		}
	
	public void search_for_user(String string)
	{
		objMCCHomePage = new MCCHomePage(driver);
		Utilities.clickonElement(objMCCHomePage.getTxtSearch(), driver);
		Utilities.clickonElement(objMCCHomePage.getBtnSearchHome(), driver);
		objMCCHomePage.getTxtSearch().sendKeys(string);
		objMCCHomePage.getTxtSearch().sendKeys(Keys.ENTER);

		try {
			driver.findElement(By.cssSelector("a[title='" + string + "']")).click();

		} catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
			driver.findElement(By.xpath("//a[text()='" + string + "']")).click();
		}
	}
	
	@When("Log in as {string} in MCC	and click on Single chart mover")
	public void log_in_as_in_mcc_and_click_on_single_chart_mover(String string) {
		// Write code here that turns the phrase above into concrete actions
		String currentUrl = driver.getCurrentUrl();
		System.out.println("currentUrl :" +currentUrl);
		String title = driver.getTitle();
		System.out.println("PAGE TITLE :"+title);
		if (driver.getCurrentUrl().contains("epiuat") && driver.getTitle().contains("Coder Automation_mcc"))
		 
		{		
			search_for_user("Test Automation_mcc");
			
		
		}
		else {
						
			LoginPage objLoginPage = new LoginPage(driver);
			ConfigFileReader configFileReader;
			configFileReader = new ConfigFileReader();
			//String user = configFileReader.getQAAdminUserName();
			String user = configFileReader.getQAAdminUserName();
			String psd = configFileReader.getUATpassword();
			try {
				objLoginPage.login(user, psd);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block

				objMCCHomePage = new MCCHomePage(driver);
				Assert.assertTrue(objMCCHomePage.isLoggedtoMCCSalesforce(), "User is not logged in to Salesforce-Classic");
				
				search_for_user("Test Automation");
			}
			/*try {
				objLoginPage.setUserName(user);
			} catch (UnhandledAlertException f1) {
			    try {
			        Alert alert = driver.switchTo().alert();
			        String alertText = alert.getText();
			        System.out.println("Alert data: " + alertText);
			        alert.accept();
			    } catch (NoAlertPresentException e) {
			        e.printStackTrace();
			    }
			}
			objLoginPage.setPassword(configFileReader.getEpiqapassword());
			objLoginPage.clickLogIn();*/
			
			
		}

		// objMCCHomePage.searchInMCCSalesforce(text);
		Utilities.clickonElement(objMCCHomePage.getChartmover(), driver);
		

	}

	@Then("user get the chart and verify status of chart is {string}")
	public void user_get_the_chart_and_verify_status_of_chart_is(String string) {
		// Write code here that turns the phrase above into concrete actions
		
		Utilities.waitForPageLoaded(driver);
		String title = driver.getCurrentUrl();
		System.out.println(title);
		if(title.contains("uat"))
		{
	
		Utilities.mouseHoverToTheElemnet(objMCCHomePage.getDropdown_client(), driver);
		Utilities.clickonElement(objMCCHomePage.getDropdownclient_Saas("QA Automation"), driver);
		Utilities.mouseHoverToTheElemnet(objMCCHomePage.getDropdown_project(), driver);
		Utilities.clickonElement(objMCCHomePage.getDropdownproject_epicoderdemo("QA Automation"), driver);
		Utilities.clickonElement(objMCCHomePage.getInput_chartid(), driver);
		Utilities.sendKeysUsingActions(objMCCHomePage.getInput_chartid(), "A-FMR9K8", driver);
		Utilities.clickonElement(objMCCHomePage.getButton_searchforchart(), driver);
		Select select = new Select(objMCCHomePage.getDropdown_status());
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		// String text = objMCCHomePage.getDropdown_status().getText();
		System.out.println("value :" + text);
		 assertTrue(text.contains(string));
		}
		else {
			
			Utilities.mouseHoverToTheElemnet(objMCCHomePage.getDropdown_client(), driver);
			Utilities.clickonElement(objMCCHomePage.getDropdownclient_Saas("SaaS Products Demo"), driver);
			Utilities.mouseHoverToTheElemnet(objMCCHomePage.getDropdown_project(), driver);
			Utilities.clickonElement(objMCCHomePage.getDropdownproject_epicoderdemo("epiCoder Demo"), driver);
			Utilities.clickonElement(objMCCHomePage.getInput_chartid(), driver);
			Utilities.sendKeysUsingActions(objMCCHomePage.getInput_chartid(), "A-FMR9K8", driver);
			Utilities.clickonElement(objMCCHomePage.getButton_searchforchart(), driver);
			Select select = new Select(objMCCHomePage.getDropdown_status());
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			String text = firstSelectedOption.getText();
			// String text = objMCCHomePage.getDropdown_status().getText();
			System.out.println("value :" + text);
			 assertTrue(text.contains(string));
		}

	}

	@Then("update the chart status as {string}")
	public void update_the_chart_status_as(String string) {
		// Write code here that turns the phrase above into concrete actions
		Select select = new Select(objMCCHomePage.getDropdown_status());
		select.selectByVisibleText(string);
		Utilities.clickonElement(objMCCHomePage.getButton_updatechart(), driver);
	}

	@Then("validate {string},{string}, {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string} fields")
	public void validate_and_fields(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string30, String string11,
			String string12) {
		// Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCChartQueuePage.getDx_Delete().isDisplayed());
		 assertEquals(string, objMCCChartQueuePage.getDx_Delete().getText());
		 assertTrue(objMCCChartQueuePage.getDx_Deleteicon().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_DOSstart().isDisplayed());
		 assertEquals(string2, objMCCChartQueuePage.getDx_DOSstart().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDOSStart().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_DOSend().isDisplayed());
		 assertEquals(string3, objMCCChartQueuePage.getDx_DOSend().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDOSEnd().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_ProviderName().isDisplayed());
		 assertEquals(string4, objMCCChartQueuePage.getDx_ProviderName().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textproviderName().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_search().isDisplayed());
		 assertEquals(string5, objMCCChartQueuePage.getDx_search().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textSearch().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_ProviderId().isDisplayed());
		 assertEquals(string6, objMCCChartQueuePage.getDx_ProviderId().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textproviderId().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_ProviderNPI().isDisplayed());
		 assertEquals(string7, objMCCChartQueuePage.getDx_ProviderNPI().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textproviderNPI().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_Visittype().isDisplayed());
		 assertEquals(string8, objMCCChartQueuePage.getDx_Visittype().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textVisittype().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_flex2().isDisplayed());
		 assertEquals(string9, objMCCChartQueuePage.getDx_flex2().getText());
		//  assertFalse(objMCCChartQueuePage.getDx_textfl().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_CoderDX().isDisplayed());
		 assertEquals(string30, objMCCChartQueuePage.getDx_CoderDX().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textCoderDXes().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_FirstPage().isDisplayed());
		 assertEquals(string11, objMCCChartQueuePage.getDx_FirstPage().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textFirstPage().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_Add().isDisplayed());
		 assertEquals(string12, objMCCChartQueuePage.getDx_Add().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textAdd().isEnabled());

	}

	@Then("verify for {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void verify_for(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string30) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		 assertTrue(objMCCChartQueuePage.getDx_Deleteadd().isDisplayed());
		 assertEquals(string, objMCCChartQueuePage.getDx_Deleteadd().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textAdd().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_code().isDisplayed());
		 assertEquals(string2, objMCCChartQueuePage.getDx_code().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textdxCode().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_HCC().isDisplayed());
		 assertEquals(string3, objMCCChartQueuePage.getDx_HCC().getText());
		//  assertFalse(objMCCChartQueuePage.getDx_textHCC().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_page().isDisplayed());
		 assertEquals(string4, objMCCChartQueuePage.getDx_page().getText());
		 assertTrue(objMCCChartQueuePage.getDX_textPage().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_Flex1().isDisplayed());
		 assertEquals(string5, objMCCChartQueuePage.getDx_Flex1().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDxFlex1().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_Flex2().isDisplayed());
		 assertEquals(string6, objMCCChartQueuePage.getDx_Flex2().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textFlex2().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_L1Secondary().isDisplayed());
		 assertEquals(string7, objMCCChartQueuePage.getDx_L1Secondary().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textL1Secondary().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_L2MAprimary().isDisplayed());
		 assertEquals(string8, objMCCChartQueuePage.getDx_L2MAprimary().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textL2MAprimary().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_L2MAmanualComments().isDisplayed());
		 assertEquals(string9, objMCCChartQueuePage.getDx_L2MAmanualComments().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textL2MAmanualcomment().isEnabled());
		
		//Thread.sleep(10000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(3000, 0)");
		
		//WebElement element = driver.findElement(By.xpath("//div[@class='el-table__body-wrapper is-scrolling-right']"));
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]"));
		WebElement element = elements.get(0);
				
		jse.executeScript("arguments[0].scrollIntoView(true);", element);


		 assertTrue(objMCCChartQueuePage.getDx_L2MAQAComments().isDisplayed());
		 assertEquals(string30, objMCCChartQueuePage.getDx_L2MAQAComments().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textL2MAQAComment().isEnabled());

	}

	

	@Then("verify for {string},{string},{string},{string},{string},{string},{string},{string} in Master Auditor")
	public void verify_for_in_master_auditor(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
    // Write code here that turns the phrase above into concrete actions

		 assertTrue(objMCCChartQueuePage.getDx_Deleteadd().isDisplayed());
		 assertEquals(string, objMCCChartQueuePage.getDx_Deleteadd().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textAdd().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_code().isDisplayed());
		 assertEquals(string2, objMCCChartQueuePage.getDx_code().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textdxCode().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_HCC().isDisplayed());
		 assertEquals(string3, objMCCChartQueuePage.getDx_HCC().getText());
		//  assertFalse(objMCCChartQueuePage.getDx_textHCC().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_page().isDisplayed());
		 assertEquals(string4, objMCCChartQueuePage.getDx_page().getText());
		 assertTrue(objMCCChartQueuePage.getDX_textPage().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_Flex1().isDisplayed());
		 assertEquals(string5, objMCCChartQueuePage.getDx_Flex1().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textDxFlex1().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_Flex2().isDisplayed());
		 assertEquals(string6, objMCCChartQueuePage.getDx_Flex2().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textFlex2().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_L1Secondary().isDisplayed());
		 assertEquals(string7, objMCCChartQueuePage.getDx_L1Secondary().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textL1Secondary().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_L2MAprimary().isDisplayed());
		 assertEquals(string8, objMCCChartQueuePage.getDx_L2MAprimary().getText());
		 assertFalse(objMCCChartQueuePage.getDx_textL2MAprimary().isEnabled());
	}
	@Then("verify for {string},{string} in Master Auditor")
	public void verify_for_in_master_auditor(String string, String string2) {
		
		 assertTrue(objMCCChartQueuePage.getDx_L2MAmanualComments().isDisplayed());
		 assertEquals(string, objMCCChartQueuePage.getDx_L2MAmanualComments().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textL2MAmanualcomment_MA().isEnabled());

		 assertTrue(objMCCChartQueuePage.getDx_L2MAQAComments().isDisplayed());
		 assertEquals(string2, objMCCChartQueuePage.getDx_L2MAQAComments().getText());
		 assertTrue(objMCCChartQueuePage.getDx_textL2MAQAComment_MA().isEnabled());
   
	}
	

	
	@Then("verify L2MA Primary Comment {string}")
	public void verify_l2ma_primary_comment(String string) throws InterruptedException {
// Write code here that turns the phrase above into concrete actions
		Thread.sleep(500);
		List<WebElement> elements=objMCCChartQueuePage.getDx_textL2MAprimary_elements();
		int i;
		int length = elements.size();
		map = new LinkedHashMap<Integer,String>();
			
			
		for(i=0;i<length;i++) {
			if(i==4 || i==8 || i==9) {
				//i=i+1;
				WebElement element = elements.get(i);
				String jsGetValue = Utilities.jsGetValue(driver, element);
				
				System.out.println("Jsvalue :" + jsGetValue+i);
			}
			else {
			WebElement element = elements.get(i);
			String jsGetValue = Utilities.jsGetValue(driver, element);
			map.put(i, jsGetValue);
		
			System.out.println("Jsvalue :" + jsGetValue+i);
			 assertEquals(string, jsGetValue);
			}
		
		}
	
		System.out.println(map);
		System.out.println(map.size());
		// assertFalse(bodyText.contains("Spam Virus"), "Spam Message Text Is Not Present");
		// assertEquals(string, objMCCChartQueuePage.getDx_textL2MAprimary().getAttribute("innerHTML"));
		
	}
	
	
	@Then("verify MA Primary Comment {string}")
	public void verify_ma_primary_comment(String string) {
	    // Write code here that turns the phrase above into concrete actions

		List<WebElement> elements=objMCCChartQueuePage.getDx_textMAprimary_elements();
		int i;
		int length = elements.size();
		map = new LinkedHashMap<Integer,String>();
	
		for(i=0;i<length;i++) {
			if(i==4 || i==8 || i==9) {
				//i=i+1;
				WebElement element = elements.get(i);
				String jsGetValue = Utilities.jsGetValue(driver, element);
				
				System.out.println("Jsvalue :" + jsGetValue+i);
			}
			else {
			WebElement element = elements.get(i);
			String jsGetValue = Utilities.jsGetValue(driver, element);
			map.put(i, jsGetValue);
		
			System.out.println("Jsvalue :" + jsGetValue+i);
			 assertEquals(string, jsGetValue);
			}
		
		}
	
		System.out.println(map);
		System.out.println(map.size());
	
	
	}
	
	
	
	
	
	@Then("verify for L2MA Primary Comment given by Auditor")
	public void verify_for_l2ma_primary_comment_given_by_auditor() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.tkScreenshot(driver);
		List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='el-table__row']/td[8]/div/div/div/div/div/div/input"));
		map2 = new LinkedHashMap<Integer,String>();
		map3 = new LinkedHashMap<Integer,String>();
		int i;
		int j=0;
		int length = elements.size();
		for(i=0;i<length;i++) {
			WebElement element = elements.get(i);
			String jsGetValue = Utilities.jsGetValue(driver, element);
			map2.put(i, jsGetValue);
			System.out.println("Primary Comment Displayed in Auditor Screen :" + jsGetValue+i);
			
			if(i>0)
			{
				if (i%2==0)   {
					
					map3.put(j,jsGetValue);
					j++;
					
				}
				else {
					continue;
				}
				
			}
			else {
				map3.put(j,jsGetValue);
				j++;
			}
			//map.get(i);
			//System.out.println("Primary Comment given by Auditor :" + jsGetValue+i);
		}
		System.out.println("Map1 size"+map.size());
		System.out.println("Primary Comment given by Auditor :" + map);
		
		System.out.println("Map2 size" + map2.size());
		System.out.println("Primary Comment given by Auditor :" + map2);
				
		
		System.out.println("Map3 size"+map3.size());
		System.out.println("Primary Comment displayed in MA Screen :" + map3);
		
		boolean equals = map.equals(map3);
		System.out.println("Map comparison :"+equals);
		 assertEquals(map,map3);
	}
	
	
	@Then("verify for the MA comment {string}")
	public void verify_for_the_ma_comment(String string) {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='el-table__row']/td[8]/div/div/div/div/div/div/input"));
		map4 = new LinkedHashMap<Integer,String>();
		int length = elements.size();
		System.out.println("Elements size :"+length);
		int i;
		int j=0;
		for(i=0;i<length;i++) {
			
			
			WebElement element = elements.get(i);
			String jsGetValue = Utilities.jsGetValue(driver, element);
			System.out.println("stringup :  "+string+"  jsvalueup :"+jsGetValue);
			
			if(i>0)
			{
				if (i%2!=0)   {
					
					map4.put(j,jsGetValue);
					j++;
					 assertEquals(string, jsGetValue);
							}
				else {
					continue;
				}
			}
			else {
				j++;
			}
			// assertEquals(string, jsGetValue);
			System.out.println("string :  "+string+"  jsvalue :"+jsGetValue );
		}
		System.out.println("Map4 size"+map4.size());
		System.out.println("Primary Comment displayed in MA Screen :" + map4);
		
		
	}
	
	
	@When("Auditor edit the existing date in row1")
	public void auditor_edit_the_existing_date_in_row1() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart(), driver);
			//objMCCChartQueuePage.getDx_date_yearArrow().click();
			Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date9(), driver);
		} catch ( ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart()));
			Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart(), driver);
			Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date9(), driver);
			}
		catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart()));
			Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart(), driver);
			Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date9(), driver);
				
		}
	}
	
	@When("Auditor edit Provider name field in row2")
	public void auditor_edit_provider_name_field_in_row2() throws AWTException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName_row2(),driver);
		//WebElement dx_textproviderName = objMCCChartQueuePage.getDx_textproviderName_row2();
		
		//dx_textproviderName.clear();
		Utilities.keypress_Backspace(5);
    
		objMCCChartQueuePage.getDx_textproviderName_row2().sendKeys("test2");
		
		Robot robot = new Robot(); 
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
		
		Utilities.keypress_tab(2);
     
	}
	
	@When("Auditor edit visit type in row3")
	public void auditor_edit_visit_type_in_row3() {
	    // Write code here that turns the phrase above into concrete actions
		
		List<WebElement> dx_textVisittypes = objMCCChartQueuePage.getDx_textVisittypes();
		WebElement textVisittype = dx_textVisittypes.get(2);
		Utilities.clickonElement(textVisittype, driver);
		//WebElement dx_textVisittype = objMCCChartQueuePage.getDx_textVisittype_row3();
		textVisittype.clear();
		textVisittype.sendKeys("Visittype3");
	
	}
	
	@When("user edit the dx code in row4")
	public void user_edit_the_dx_code_in_row4() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement element = objMCCChartQueuePage.getDx_textdxCode4();
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textdxCode4(), driver);
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys("A0103");
	}
	
	@When("user edit page number in row5")
	public void user_edit_page_number_in_row5() throws AWTException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement element = objMCCChartQueuePage.getDx_textpageno5();
		Utilities.clickonElement(element,driver);
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys("10");
		
	}
	@When("user edit flex field in row6")
	public void user_edit_flex_field_in_row6() throws AWTException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	
		/************************ Flex Field 1 EDIT****************************************/
		
		/*WebElement element2 = driver.findElement(By.xpath("//*[text()='flexone']"));
		Utilities.clickonElement(element2, driver);
		//element2.sendKeys("flexnew1");
		Utilities.sendKeysUsingActions(element2,"flexnew1", driver);
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);*/
		
		objMCCChartQueuePage.getDx_textDxFlex1_row6().click();
		objMCCChartQueuePage.getDx_textDxFlex1_row6().clear();
		//objMCCChartQueuePage.getDx_textDxFlex1_row6().sendKeys(Keys.CONTROL + "a");
		//objMCCChartQueuePage.getDx_textDxFlex1_row6().sendKeys(Keys.DELETE);
		objMCCChartQueuePage.getDx_textDxFlex1_row6().sendKeys("flexnew1");
		/*Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);*/
		
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);*/
		
	}
	
	@When("user edit flex field in row7")
	public void user_edit_flex_field_in_row7() throws AWTException, InterruptedException {
		
		
		/************************ Flex Field 2 EDIT****************************************/
		objMCCChartQueuePage.getDx_textDxFlex2_row7().clear();
		objMCCChartQueuePage.getDx_textDxFlex2_row7().click();
		for(int i = 0;i<20;i++) {

		try {
			objMCCChartQueuePage.getDx_textDxFlex2_row7().sendKeys(Keys.CONTROL + "a");
			objMCCChartQueuePage.getDx_textDxFlex2_row7().sendKeys(Keys.DELETE);
			objMCCChartQueuePage.getDx_textDxFlex2_row7().sendKeys("flexnew2");
		
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			MCCChartQueuePageDefinitions objMCCChartQueuePage1 = new MCCChartQueuePageDefinitions();
			objMCCChartQueuePage1.user_click_on_closeall_encounters_button();
			objMCCChartQueuePage1.user_clicks_on_openall_encounters_button();
			continue;
			
		}
		//Thread.sleep(10000);
		}
	}
	

@When("user edit L1 secondary comment in row8 as {string}")
public void user_edit_l1_secondary_comment_in_row8_as(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions

		/*List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
		System.out.println("size" + select.size());
		int j=rowno+1;
		System.out.println("J value"  + j);*/
		//Thread.sleep(5000);
	MCCChartQueuePageDefinitions objMCCChartQueuePage1 = new MCCChartQueuePageDefinitions();

	for(int i = 0;i<5;i++) {
		objMCCChartQueuePage1.user_click_on_closeall_encounters_button();
		objMCCChartQueuePage1.user_clicks_on_openall_encounters_button();
		try {
			   WebElement webElement1 = driver.findElement(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[3]/td[7]/div/div/div/div/div/div/input"));
			    Utilities.waitforElementVisibility(webElement1, driver);
				Utilities.clickUsingActions(webElement1, driver);
			    WebElement webElement = objMCCChartQueuePage.getSelect_cells_(8);
				List<WebElement> select_values = objMCCChartQueuePage.getL1Secondary_valueslist();
				System.out.println("size " + select_values.size());
				int size=select_values.size();
				for (int i1 = 0; i1 < size; i1++) {
					WebElement element = select_values.get(i1);
					Actions action = new Actions(driver);

					// Performing the mouse hover action on the target element.
					action.moveToElement(element).build().perform();
					
					String attribute = element.getText();
					String value = string;
					System.out.println("Attribute :" + attribute);
					System.out.println("Given string :" + value);
					if (attribute.equalsIgnoreCase(value)) {
						Utilities.clickonElement(element, driver);
						//Utilities.clickonElement(element, driver);
						 assertEquals(attribute, value);
						//element.click();
						i1=size;
						break;
					}
				  
				}
			    
			break;
		}catch(Exception e) {
			continue;
		}
	}
		
		
		
	 
	    
	   /* while(webElement.getText().equalsIgnoreCase(string)) {
	    	String text = webElement.getText();
	    	System.out.println(text);*/
	   
		Thread.sleep(30000);
		/*String s = Keys.chord(Keys.CONTROL, "a");
		webElement.sendKeys(s);
		webElement.sendKeys(Keys.DELETE);*/
		/*List<WebElement> select_values = objMCCChartQueuePage.getL1Secondary_valueslist();
		System.out.println("size " + select_values.size());
		//Thread.sleep(30000);
				
		objMCCChartQueuePage1.user_click_on_closeall_encounters_button();
		objMCCChartQueuePage1.user_clicks_on_openall_encounters_button();
		int size=select_values.size();
		for (int i = 0; i < size; i++) {
			WebElement element = select_values.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element).build().perform();
			
			String attribute = element.getText();
			String value = string;
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + value);
			if (attribute.equalsIgnoreCase(value)) {
				Utilities.clickonElement(element, driver);
				//Utilities.clickonElement(element, driver);
				 assertEquals(attribute, value);
				//element.click();
				i=size;
				break;
			}
		  
		}
	    }*/
		Utilities.waitForPageLoaded(driver);
		//Utilities.keypress_tab(3);
	
	
	}


@When("Master Auditor edit the existing date in row1")
public void master_auditor_edit_the_existing_date_in_row1() {
    // Write code here that turns the phrase above into concrete actions
	try {
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart(), driver);
		//objMCCChartQueuePage.getDx_date_yearArrow().click();
		Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(), driver);
		} catch ( ElementClickInterceptedException e) {
		// TODO Auto-generated catch block
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart()));
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart(), driver);
		Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(), driver);
		}
		catch (ElementNotInteractableException e) {
		// TODO Auto-generated catch block
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart()));
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart(), driver);
		Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(), driver);
		}

}
@When("Master Auditor edit Provider name field in row2")
public void master_auditor_edit_provider_name_field_in_row2() throws AWTException {
    // Write code here that turns the phrase above into concrete actions
	Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName_row2(),driver);
	//WebElement dx_textproviderName = objMCCChartQueuePage.getDx_textproviderName_row2();
	//dx_textproviderName.clear();
	Utilities.keypress_Backspace(5);
	objMCCChartQueuePage.getDx_textproviderName_row2().sendKeys("testMA2");
	Robot robot = new Robot(); 
	robot.keyPress(KeyEvent.VK_ENTER); 
	robot.keyRelease(KeyEvent.VK_ENTER); 
	Utilities.keypress_tab(2);

}
@When("Master Auditor edit visit type in row3")
public void master_auditor_edit_visit_type_in_row3() {
    // Write code here that turns the phrase above into concrete actions
	
	List<WebElement> dx_textVisittypes = objMCCChartQueuePage.getDx_textVisittypes();
	WebElement textVisittype = dx_textVisittypes.get(2);
	Utilities.clickonElement(textVisittype, driver);
	//WebElement dx_textVisittype = objMCCChartQueuePage.getDx_textVisittype_row3();
	textVisittype.clear();
	textVisittype.sendKeys("VisittypeMA3");

	
}
@When("Master Auditor edit the dx code in row4")
public void master_auditor_edit_the_dx_code_in_row4() {
    // Write code here that turns the phrase above into concrete actions
	
	WebElement element = objMCCChartQueuePage.getDx_textdxCode4();
	Utilities.clickonElement(objMCCChartQueuePage.getDx_textdxCode4(), driver);
	element.sendKeys(Keys.CONTROL + "a");
	element.sendKeys(Keys.DELETE);
	element.sendKeys("A0104");

}
@When("Master Auditor edit page number in row5")
public void master_auditor_edit_page_number_in_row5() {
    // Write code here that turns the phrase above into concrete actions
	WebElement element = objMCCChartQueuePage.getDx_textpageno5();
	Utilities.clickonElement(element,driver);
	element.sendKeys(Keys.CONTROL + "a");
	element.sendKeys(Keys.DELETE);
	element.sendKeys("12");

	
}
@When("Master Auditor  edit flex field in row6")
public void master_auditor_edit_flex_field_in_row6() {
    // Write code here that turns the phrase above into concrete actions
	
	objMCCChartQueuePage.getDx_textDxFlex1_row6().click();
	objMCCChartQueuePage.getDx_textDxFlex1_row6().clear();
	//objMCCChartQueuePage.getDx_textDxFlex1_row6().sendKeys(Keys.CONTROL + "a");
	//objMCCChartQueuePage.getDx_textDxFlex1_row6().sendKeys(Keys.DELETE);
	objMCCChartQueuePage.getDx_textDxFlex1_row6().sendKeys("flexnew1");

	
}
@When("Master Auditor  edit flex field in row7")
public void master_auditor_edit_flex_field_in_row7() {
    // Write code here that turns the phrase above into concrete actions
	/************************ Flex Field 2 EDIT****************************************/
	objMCCChartQueuePage.getDx_textDxFlex2_row7().clear();
	objMCCChartQueuePage.getDx_textDxFlex2_row7().click();
	for(int i = 0;i<20;i++) {
	try {
	objMCCChartQueuePage.getDx_textDxFlex2_row7().sendKeys(Keys.CONTROL + "a");
	objMCCChartQueuePage.getDx_textDxFlex2_row7().sendKeys(Keys.DELETE);
	objMCCChartQueuePage.getDx_textDxFlex2_row7().sendKeys("flexnew2");
	break;
	} catch (Exception e) {
	// TODO Auto-generated catch block
	MCCChartQueuePageDefinitions objMCCChartQueuePage1 = new MCCChartQueuePageDefinitions();
	objMCCChartQueuePage1.user_click_on_closeall_encounters_button();
	objMCCChartQueuePage1.user_clicks_on_openall_encounters_button();
	continue;
	}
	//Thread.sleep(10000);
	}

}
@When("Master Auditor  edit L1 secondary comment in row8 as {string}")
public void master_auditor_edit_l1_secondary_comment_in_row8_as(String string) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	
	MCCChartQueuePageDefinitions objMCCChartQueuePage1 = new MCCChartQueuePageDefinitions();
	for(int i = 0;i<5;i++) {
	objMCCChartQueuePage1.user_click_on_closeall_encounters_button();
	objMCCChartQueuePage1.user_clicks_on_openall_encounters_button();
	try {
	WebElement webElement1 = driver.findElement(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[3]/td[7]/div/div/div/div/div/div/input"));
	Utilities.waitforElementVisibility(webElement1, driver);
	Utilities.clickUsingActions(webElement1, driver);
	WebElement webElement = objMCCChartQueuePage.getSelect_cells_(8);
	List<WebElement> select_values = objMCCChartQueuePage.getL1Secondary_valueslist();
	System.out.println("size " + select_values.size());
	int size=select_values.size();
	for (int i1 = 0; i1 < size; i1++) {
	WebElement element = select_values.get(i1);
	Actions action = new Actions(driver);
	// Performing the mouse hover action on the target element.
	action.moveToElement(element).build().perform();
	String attribute = element.getText();
	String value = string;
	System.out.println("Attribute :" + attribute);
	System.out.println("Given string :" + value);
	if (attribute.equalsIgnoreCase(value)) {
	Utilities.clickonElement(element, driver);
	//Utilities.clickonElement(element, driver);
	 assertEquals(attribute, value);
	//element.click();
	i1=size;
	break;
	}
	}
	break;
	}catch(Exception e) {
	continue;
	}
	}
	/* while(webElement.getText().equalsIgnoreCase(string)) {
	String text = webElement.getText();
	System.out.println(text);*/
	Thread.sleep(30000);
	/*String s = Keys.chord(Keys.CONTROL, "a");
	webElement.sendKeys(s);
	webElement.sendKeys(Keys.DELETE);*/
	/*List<WebElement> select_values = objMCCChartQueuePage.getL1Secondary_valueslist();
	System.out.println("size " + select_values.size());
	//Thread.sleep(30000);
	objMCCChartQueuePage1.user_click_on_closeall_encounters_button();
	objMCCChartQueuePage1.user_clicks_on_openall_encounters_button();
	int size=select_values.size();
	for (int i = 0; i < size; i++) {
	WebElement element = select_values.get(i);
	Actions action = new Actions(driver);
	// Performing the mouse hover action on the target element.
	action.moveToElement(element).build().perform();
	String attribute = element.getText();
	String value = string;
	System.out.println("Attribute :" + attribute);
	System.out.println("Given string :" + value);
	if (attribute.equalsIgnoreCase(value)) {
	Utilities.clickonElement(element, driver);
	//Utilities.clickonElement(element, driver);
	 assertEquals(attribute, value);
	//element.click();
	i=size;
	break;
	}
	}
	}*/
	Utilities.waitForPageLoaded(driver);

}

	
	@When("user click on delete icon of row5")
	public void user_click_on_delete_icon_of_row5() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement element = objMCCChartQueuePage.getDx_Deleteicon5();
		Utilities.clickonElement(element,driver);
	}
	@When("Master Auditor click on delete icon of Dxcode F323")
	public void master_auditor_click_on_delete_icon_of_dxcode_f323() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement element = objMCCChartQueuePage.getDx_Deleteicon_last();
		Utilities.clickonElement(element,driver);
	}
	
	@When("user give confirmation to delete")
	public void user_give_confirmation_to_delete() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			objMCCChartQueuePage.getDx_ok().click();
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
			w.until(ExpectedConditions.elementToBeClickable(objMCCChartQueuePage.getDx_ok()));
			objMCCChartQueuePage.getDx_ok().click();
		}
		Utilities.waitForPageLoaded(driver);
	}
	

	@Then("verify the respective Dx code is deleted")
	public void verify_the_respective_dx_code_is_deleted() throws Exception {
    // Write code here that turns the phrase above into concrete actions
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
		w.until(ExpectedConditions.invisibilityOf(objMCCChartQueuePage.getDx_Deleteicon5()));
		try {
			objMCCChartQueuePage.getDx_Deleteicon5().isDisplayed();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			boolean assertvalue = false;
			 assertFalse(assertvalue);
		}
		
	}
	
	
	@Then("verify for missed comment")
	public void verify_for_missed_comment() {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement dx_textL2MAprimary_missed = objMCCChartQueuePage.getDx_textL2MAprimary_missed();
	    String getValue = Utilities.jsGetValue(driver, dx_textL2MAprimary_missed);
		 assertEquals("Missed",getValue);
	
	}
	
	
	@When("user edit L1 secondary comment in row5")
	public void user_edit_l1_secondary_comment_in_row5() {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textL1Secondary(), driver);
		
		List<WebElement> status = objMCCChartQueuePage.getDX_L1Secondary_ddvalues();
		
	
			WebElement element = status.get(2);
			Utilities.clickUsingActions(element, driver);

		
	
		
		/*List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
		System.out.println("size" + select.size());
		int size = select.size();
		select.get(size-6).click();
		List<WebElement> select_values = driver.findElements(
				By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
		System.out.println("size " + select_values.size());
		
		WebElement element = select_values.get(0);
		//WebElement element1 = driver.findElement(By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='bottom-start']/div/div/ul/li"));
		Utilities.clickonElement(element, driver);*/
			
		
	}
	
	
	@Then("auditor clicks save and continue button")
	public void auditor_clicks_save_and_continue_button() {
		
	
	Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
	Utilities.clickonElement(objMCCHomePage.getAuditor_ok(), driver);	
	}
	
	

	@When("user click on closeall encounters button")
	public void user_click_on_closeall_encounters_button() {
	    // Write code here that turns the phrase above into concrete actions
	
		WebElement closeallencounters = objMCCChartQueuePage.getCloseallencounters();
		//Utilities.clickonElement(closeallencounters, driver);
		Utilities.jsClick(driver, closeallencounters);
		
	}
	
	@When("user clicks on downarrow of row1")
	public void user_clicks_on_downarrow_of_row1() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.waitForPageLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		
			try {
				
				wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_downarrow()));
				Utilities.clickonElement(objMCCChartQueuePage.getDx_downarrow(), driver);
			} catch (ElementClickInterceptedException e) {
				// TODO Auto-generated catch block
				WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(50));
				wait1.until(ExpectedConditions.invisibilityOf(objMCCHomePage.getSave_msg()));
				Utilities.clickonElement(objMCCChartQueuePage.getDx_downarrow(), driver);
			}
		
			wait.until(ExpectedConditions.elementToBeClickable(objMCCChartQueuePage.getDx_textDOSStart()));
	}

	@When("Auditor edit the dx code fields and verify for {string} option")
	public void auditor_edit_the_dx_code_fields_and_verify_for_option(String string) throws AWTException, InterruptedException{
		// Write code here that turns the phrase above into concrete actions
		try {
			objMCCChartQueuePage.getDx_textDOSStart().click();
			//objMCCChartQueuePage.getDx_date_yearArrow().click();
			objMCCChartQueuePage.getDx_date_date9().click();
		} catch ( ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart()));
			objMCCChartQueuePage.getDx_textDOSStart().click();
			objMCCChartQueuePage.getDx_date_date9().click();
			}
		catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart()));
			objMCCChartQueuePage.getDx_textDOSStart().click();
			objMCCChartQueuePage.getDx_date_date9().click();
				
		}
		//Thread.sleep(200);
	
		Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		//jse.executeScript("scroll(250, 0)"); // if the element is on top.

		jse.executeScript("scroll(0, 250)");
		try {
			System.out.println("Iam in try block");
			Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_openEncounters(), 300);
			System.out.println("I am displayed");
			Utilities.waitForElementToBeClickable(driver, objMCCChartQueuePage.getDx_openEncounters());
			System.out.println("I am clickable");
			Utilities.mouseHoverToTheElemnet(objMCCChartQueuePage.getDx_openEncounters(), driver);
			System.out.println("I am mousehovered");
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_openEncounters()));
			//objMCCChartQueuePage.getDx_openEncounters().click();
			//Utilities.clickUsingActions(objMCCChartQueuePage.getDx_openEncounters(), driver);
			Thread.sleep(3000);
			WebElement et = driver.findElement(By.xpath("//*[@id='pagination']/div[1]/div/button"));
			Utilities.jsClick(driver,et);
			Thread.sleep(3000);
			Utilities.jsClick(driver, objMCCChartQueuePage.getDx_openEncounters());
			System.out.println("clicked in try block");
			//Utilities.clickonElement(objMCCChartQueuePage.getDx_downarrow(), driver);
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			//wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_downarrow()));
			//objMCCChartQueuePage.getDx_downarrow().click();*/
			//new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(ElementClickInterceptedException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr/td[1]/div/div/i")));
			//driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr/td[1]/div/div/i")).click();
			System.out.println("i am in catch block");
			//Utilities.clickonElement(objMCCChartQueuePage.getDx_downarrow(), driver);

			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();",objMCCChartQueuePage.getDx_downarrow() );
			//Utilities.clickonElement(objMCCChartQueuePage.getDx_openEncounters(), driver);
			Utilities.clickUsingActions(objMCCChartQueuePage.getDx_openEncounters(), driver);
			System.out.println("clicked in catch block");

		}
		//Thread.sleep(300);
		/*try {
			Utilities.clickonElement(objMCCChartQueuePage.getDx_openEncounters(), driver);
		} catch (ElementClickInterceptedException e1) {
			// TODO Auto-generated catch block
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_openEncounters()));
			objMCCChartQueuePage.getDx_openEncounters().click();
		}*/

		/*List<WebElement> findtabels = driver.findElements(By.xpath("//table[@class='el-table__body']"));
		WebElement table = findtabels.get(2);
		WebElement row = table.findElements(By.tagName("tr")).get(0);
		WebElement cell = row.findElements(By.tagName("td")).get(7);
		String cellText = cell.getText();
		String test = Utilities.jsGetValue(driver, objMCCChartQueuePage.getTestObj());
		System.out.println("Text=" +test);
		System.out.println("Text=" +cellText);
		String nowtext = objMCCChartQueuePage.getTestObj().getText();
		System.out.println("nowtext =" + nowtext);*/
		
		//String input = null;
		//WebElement table = null;
		//List<WebElement> findtabels1 = driver.findElements(By.xpath("//div[@id='dxDetailTable']//table[@class='el-table__body']"));
		//WebElement table1 = findtabels.get(1);
		
		WebElement table1= driver.findElement(By.xpath("//div[@id='dxDetailTable']//table[@class='el-table__body']"));
		WebElement element = Utilities.getElementInsideTable(table1, 1, 8, "input");
		String text = element.getText();
		System.out.println("Cell value is :"+ text);
		try {
			Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSEnd(), driver);
			objMCCChartQueuePage.getDx_date_date9().click();
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			
			Robot robot = new Robot(); 
		    robot.keyPress(KeyEvent.VK_ENTER); 
		    robot.keyRelease(KeyEvent.VK_ENTER);
			
		}
		
		
		catch (ElementNotInteractableException  e) {
			// TODO Auto-generated catch block
			Robot robot = new Robot(); 
		    robot.keyPress(KeyEvent.VK_ENTER); 
		    robot.keyRelease(KeyEvent.VK_ENTER); 
		}
		    catch(StaleElementReferenceException e){
		    	Robot robot = new Robot(); 
			    robot.keyPress(KeyEvent.VK_ENTER); 
			    robot.keyRelease(KeyEvent.VK_ENTER); 
		    }
		    
		
		
	   
		    
/***************************************************************************/
			/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSEnd()));
			objMCCChartQueuePage.getDx_textDOSEnd().click();
			try {
				objMCCChartQueuePage.getDx_date_date9().click();
				
			} catch (ElementNotInteractableException e1) {
				// TODO Auto-generated catch block
				//wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_date_date9()));*/
			
				/*objMCCChartQueuePage.getDx_textDOSEnd().click();
				Thread.sleep(3000);
				Utilities.mouseHoverToTheElemnet(objMCCChartQueuePage.getDx_date_date9(), driver);
				Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date9(),driver);*/
			//}
		
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);*/
		
		//WebElement dx_textproviderName = objMCCChartQueuePage.getDx_textproviderName();
		//dx_textproviderName.click();
		/***********************PROVIDER NAME EDIT**************************************/
		
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName(),driver);
		objMCCChartQueuePage.getDx_textproviderName().clear();
		Robot robot = new Robot(); 
	     
		robot.keyPress(KeyEvent.VK_BACK_SPACE); 
	    robot.keyRelease(KeyEvent.VK_BACK_SPACE); 
	    robot.keyPress(KeyEvent.VK_BACK_SPACE); 
	    robot.keyRelease(KeyEvent.VK_BACK_SPACE); 
	    robot.keyPress(KeyEvent.VK_BACK_SPACE); 
	    robot.keyRelease(KeyEvent.VK_BACK_SPACE); 
	    robot.keyPress(KeyEvent.VK_BACK_SPACE); 
	    robot.keyRelease(KeyEvent.VK_BACK_SPACE); 
		
		objMCCChartQueuePage.getDx_textproviderName().sendKeys("test");
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);*/
		/*try {
			objMCCChartQueuePage.getDx_selectProviderName().click();
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_selectProviderName()));
			objMCCChartQueuePage.getDx_selectProviderName().click();
			objMCCChartQueuePage.getDx_selectproviderradio().click();
		}*/
	/************************VISIT TYPE EDIT****************************************/
		objMCCChartQueuePage.getDx_textVisittype().click();
		objMCCChartQueuePage.getDx_textVisittype().sendKeys("e");
		
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);*/
	/************************ENC FLEX2 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_Enflex2Checkbox().click();
		
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);*/
	/************************DXCODE EDIT****************************************/	
		objMCCChartQueuePage.getDx_textdxCode().click();
		objMCCChartQueuePage.getDx_textdxCode().clear();
		objMCCChartQueuePage.getDx_textdxCode().sendKeys("e118");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);*/
		/************************PAGE NUMBER EDIT****************************************/
		
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.keyPress(KeyEvent.VK_5);
		robot.keyRelease(KeyEvent.VK_5);
		
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);*/
		/************************ Flex Field 1 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_textDxFlex1().click();
		objMCCChartQueuePage.getDx_textDxFlex1().sendKeys("flex1");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);*/
		/************************ Flex Field 2 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_textDxflex2().clear();
		objMCCChartQueuePage.getDx_textDxflex2().click();
		objMCCChartQueuePage.getDx_textFlex2().sendKeys("flex2");
		
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		Utilities.waitForPageLoaded(driver);*/
		
		List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
		System.out.println("size" + select.size());
		select.get(2).click();
		List<WebElement> select_values = driver.findElements(
				By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
		System.out.println("size " + select_values.size());

		for (int i = 0; i < select_values.size(); i++) {
			WebElement element1 = select_values.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element);

			String attribute = element.getText();
			String value = "Code Not Supported";
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + value);
			if (attribute.equalsIgnoreCase(value)) {
				 assertEquals(attribute, value);
				element.click();
				break;
			}

			// System.out.println("Values of dropdown :"+attribute);
		}
		//Thread.sleep(5000);
		
		/*for(int i = 0; i<5; i++) {
		
			objMCCChartQueuePage.getDx_SaveContinue().click();
			try {
				Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_SaveContinue(), 5);
				break;
			}
		catch(Exception e) {
			continue;
		}
	}*/
		Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		Utilities.clickonElement(objMCCHomePage.getAuditor_ok(), driver);	
				
		/*Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		objMCCHomePage.getOK().click();
		//Utilities.waitForPageLoaded(driver);
		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Save and Continue')]"));
		WebElement webElement = elements.get(0);
		Utilities.clickonElement(webElement,driver);
		Utilities.clickonElement(webElement,driver);
		Utilities.clickonElement(objMCCChartQueuePage.getDx_ok(),driver);
		//objMCCChartQueuePage.getDx_ok().click();
		Utilities.waitForPageLoaded(driver);*/
		/*Utilities.clickonElement(objMCCChartQueuePage.getDx_SaveContinue(), driver);
		Thread.sleep(3000);
		Utilities.clickonElement(objMCCChartQueuePage.getDx_SaveContinue(), driver);
		objMCCChartQueuePage.getDx_ok().click();
		Utilities.waitForPageLoaded(driver);*/
	}
	
	@When("Master Auditor edit the dx code fields and verify for {string} option")
	public void master_auditor_edit_the_dx_code_fields_and_verify_for_option(String string) throws AWTException, InterruptedException   {
	    // Write code here that turns the phrase above into concrete actions
		try {
			objMCCChartQueuePage.getDx_textDOSStart().click();
			//objMCCChartQueuePage.getDx_date_yearArrow().click();
			objMCCChartQueuePage.getDx_date_date8().click();
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart()));
			objMCCChartQueuePage.getDx_textDOSStart().click();
			objMCCChartQueuePage.getDx_date_date8().click();
		}
		Thread.sleep(500);
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
		try {
			Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSEnd(), driver);
			objMCCChartQueuePage.getDx_date_date8().click();
		} catch (ElementNotInteractableException  e) {
			// TODO Auto-generated catch block
			Robot robot = new Robot(); 
		    robot.keyPress(KeyEvent.VK_ENTER); 
		    robot.keyRelease(KeyEvent.VK_ENTER); 
			/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSEnd()));
			objMCCChartQueuePage.getDx_textDOSEnd().click();
			try {
				objMCCChartQueuePage.getDx_date_date9().click();
				
			} catch (ElementNotInteractableException e1) {
				// TODO Auto-generated catch block
				//wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_date_date9()));*/
			
				/*objMCCChartQueuePage.getDx_textDOSEnd().click();
				Thread.sleep(3000);
				Utilities.mouseHoverToTheElemnet(objMCCChartQueuePage.getDx_date_date9(), driver);
				Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date9(),driver);*/
			}
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
		//WebElement dx_textproviderName = objMCCChartQueuePage.getDx_textproviderName();
		//dx_textproviderName.click();
		/***********************PROVIDER NAME EDIT**************************************/
		
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName(),driver);
		objMCCChartQueuePage.getDx_textproviderName().clear();
		Robot robot = new Robot(); 
	     
		robot.keyPress(KeyEvent.VK_BACK_SPACE); 
	    robot.keyRelease(KeyEvent.VK_BACK_SPACE); 
	    robot.keyPress(KeyEvent.VK_BACK_SPACE); 
	    robot.keyRelease(KeyEvent.VK_BACK_SPACE); 
	    robot.keyPress(KeyEvent.VK_BACK_SPACE); 
	    robot.keyRelease(KeyEvent.VK_BACK_SPACE); 
	    robot.keyPress(KeyEvent.VK_BACK_SPACE); 
	    robot.keyRelease(KeyEvent.VK_BACK_SPACE); 
		
		objMCCChartQueuePage.getDx_textproviderName().sendKeys("testMA");
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
		/*try {
			objMCCChartQueuePage.getDx_selectProviderName().click();
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_selectProviderName()));
			objMCCChartQueuePage.getDx_selectProviderName().click();
			objMCCChartQueuePage.getDx_selectproviderradio().click();
		}*/
	/************************VISIT TYPE EDIT****************************************/
		objMCCChartQueuePage.getDx_textVisittype().click();
		objMCCChartQueuePage.getDx_textVisittype().sendKeys("eMA");
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
	/************************ENC FLEX2 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_Enflex2Checkbox().click();
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
	/************************DXCODE EDIT****************************************/	
		objMCCChartQueuePage.getDx_textdxCode().click();
		objMCCChartQueuePage.getDx_textdxCode().clear();
		objMCCChartQueuePage.getDx_textdxCode().sendKeys("j449");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
		/************************PAGE NUMBER EDIT****************************************/
		
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.keyPress(KeyEvent.VK_7);
		robot.keyRelease(KeyEvent.VK_7);
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		/************************ Flex Field 1 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_textDxFlex1().click();
		objMCCChartQueuePage.getDx_textDxFlex1().clear();
		objMCCChartQueuePage.getDx_textDxFlex1().sendKeys("flex11");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
		/************************ Flex Field 2 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_textDxflex2().clear();
		objMCCChartQueuePage.getDx_textDxflex2().click();
		objMCCChartQueuePage.getDx_textFlex2().sendKeys("flex21");
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
		List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
		System.out.println("size" + select.size());
		select.get(2).click();
		List<WebElement> select_values = driver.findElements(
				By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
		System.out.println("size " + select_values.size());

		for (int i = 0; i < select_values.size(); i++) {
			WebElement element = select_values.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element);

			String attribute = element.getText();
			String value = "Patient name or identifiers lacking";
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + value);
			if (attribute.equalsIgnoreCase(value)) {
				 assertEquals(attribute, value);
				element.click();
				break;
			}

			// System.out.println("Values of dropdown :"+attribute);
		}
		//Thread.sleep(5000);
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		//Utilities.waitForPageLoaded(driver);
		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Save and Continue')]"));
		WebElement webElement = elements.get(0);
		Utilities.clickonElement(webElement,driver);
		Utilities.clickonElement(objMCCChartQueuePage.getDx_ok(),driver);
		//objMCCChartQueuePage.getDx_ok().click();
		Utilities.waitForPageLoaded(driver);
		/*Utilities.clickonElement(objMCCChartQueuePage.getDx_SaveContinue(), driver);
		Thread.sleep(3000);
		Utilities.clickonElement(objMCCChartQueuePage.getDx_SaveContinue(), driver);
		objMCCChartQueuePage.getDx_ok().click();
		Utilities.waitForPageLoaded(driver);*/
	
	}
	
	@When("user enters valid date and provider name in row2")
	public void user_enters_valid_date_and_provider_name_in_row2() throws AWTException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250)");
		
			
		/*objMCCChartQueuePage.getDx_textDOSStart2().click();
		String year = objMCCChartQueuePage.getDx_detepickeryr().getText();
		System.out.println(year);
		if(year.equals("2019"))
		{
		objMCCChartQueuePage.getDx_date_yearArrow().click();
		objMCCChartQueuePage.getDx_date_date8().click();
		}
		else {
			Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(), driver);
			//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart(),"01/08/2021", driver);
			//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
			Robot robot = new Robot(); 
		     
			robot.keyPress(KeyEvent.VK_TAB); 
		    robot.keyRelease(KeyEvent.VK_TAB); 
		}
	
		//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart(),"01/08/2021", driver);
		// objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");

		WebElement dx_textproviderName = objMCCChartQueuePage.getDx_textproviderName2();
		try {
			Utilities.clickonElement(dx_textproviderName, driver);
		} catch (ElementClickInterceptedException e1) {
			// TODO Auto-generated catch block
			Utilities.clickonElement(dx_textproviderName, driver);
		}
		
		objMCCChartQueuePage.getDx_textproviderName2().sendKeys("testMA");
		Robot robot = new Robot(); 
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		*/
		/**************************************************************************/
		try {
			objMCCChartQueuePage.getDx_textDOSStart2().click();
			Thread.sleep(1000);
			Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart2(),"01/08/2020", driver);
			Thread.sleep(1000);

		} catch (ElementClickInterceptedException e) {
			
			// TODO Auto-generated catch block
			//List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='DOS Start']"));
			
			WebElement dx_textDOSStart2 =driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[2]/td[3]/div/div/div/input"));
			dx_textDOSStart2.isDisplayed();
			Utilities.mouseHoverToTheElemnet(dx_textDOSStart2, driver);
			Utilities.clickonElement(dx_textDOSStart2, driver);
			Thread.sleep(1000);
			Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart2(),"01/08/2020", driver);
			
			//WebDriverWait driverWait = new WebDriverWait( new SystemClock(), Driver, TimeSpan.FromSeconds( 20 ), TimeSpan.FromSeconds( 3 ) );
			
		}

		//objMCCChartQueuePage.getDx_date_yearArrow().click();
		//objMCCChartQueuePage.getDx_date_date8().click();
		
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName2(),driver);
		//objMCCChartQueuePage.getDx_textproviderName2().clear();
		
		objMCCChartQueuePage.getDx_textproviderName2().sendKeys("testMA");
		Robot robot = new Robot(); 
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
	
}
	
	@When("user enters visit type in row2")
	public void user_enters_visit_type_in_row2() throws AWTException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[2]/td[9]/div/div/span/div/input"));
			//JavascriptExecutor j = (JavascriptExecutor) driver;
		    //j.executeScript("arguments[0].value='Test';", l); 
			//j.executeScript("arguments[0].click();", l);
			l.sendKeys("vp");
			
			//Utilities.clickonElement(objMCCChartQueuePage.getDx_downarrow2(), driver);
		
			}
			catch(ElementNotInteractableException e) {
				WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[2]/td[9]/div/div/span/div/input"));
				JavascriptExecutor j = (JavascriptExecutor) driver;
				j.executeScript("arguments[0].click();", l);
				Thread.sleep(10000);
				Robot robot = new Robot(); 
			     
				robot.keyPress(KeyEvent.VK_Q); 
			    robot.keyRelease(KeyEvent.VK_Q); 
				//Utilities.clickonElement(objMCCChartQueuePage.getDx_downarrow2(), driver);
		
			}


	
	
	}
	@When("user enters valid DX Code {string} in row2")
	public void user_enters_valid_dx_code_in_row2(String string) throws AWTException {
	    // Write code here that turns the phrase above into concrete actions

		Utilities.clickonElement(objMCCChartQueuePage.getDx_textdxCode(), driver);
		//objMCCChartQueuePage.getDx_textdxCode().clear();
		objMCCChartQueuePage.getDx_textdxCode().sendKeys(string);
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
	}
	@When("enters page no, slects {string} as L1 primary comment in row2")
	public void enters_page_no_slects_as_l1_primary_comment_in_row2(String string) throws AWTException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		/************************PAGE NUMBER EDIT****************************************/
		Robot robot = new Robot(); 

		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.keyPress(KeyEvent.VK_7);
		robot.keyRelease(KeyEvent.VK_7);
		
		/************************ Flex Field 1 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_textDxFlex1().click();
		//objMCCChartQueuePage.getDx_textDxFlex1().clear();
		objMCCChartQueuePage.getDx_textDxFlex1().sendKeys("flex11");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
		/************************ Flex Field 2 EDIT****************************************/
		
		//objMCCChartQueuePage.getDx_textDxflex2().clear();
		objMCCChartQueuePage.getDx_textDxflex2().click();
		objMCCChartQueuePage.getDx_textFlex2().sendKeys("flex21");
		
		/************************ L1 Secondary drop down****************************************/
		
		List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
		System.out.println("size" + select.size());
		select.get(2).click();
		List<WebElement> select_values = driver.findElements(
				By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
		System.out.println("size " + select_values.size());

		for (int i = 0; i < select_values.size(); i++) {
			WebElement element = select_values.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element);

			String attribute = element.getText();
			String value = string;
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + value);
			if (attribute.equalsIgnoreCase(value)) {
				 assertEquals(attribute, value);
				element.click();
				break;
			}

			// System.out.println("Values of dropdown :"+attribute);
		}
		Thread.sleep(10000);
	}
	
 /***************************************ROW 3*************************************/
	
	
	@When("user enters valid date and provider name in row3")
	public void user_enters_valid_date_and_provider_name_in_row3() throws AWTException {
	    // Write code here that turns the phrase above into concrete actions
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("scroll(0, 250)");
		
		try {
			//objMCCChartQueuePage.getDx_textDOSStart3().click();
			objMCCChartQueuePage.getDx_textDOSStart3().click();
			//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart3(),"01/08/2020", driver);
		} catch (ElementClickInterceptedException e) {
			
			// TODO Auto-generated catch block
			//List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='DOS Start']"));
			
			WebElement dx_textDOSStart3 =driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[3]/td[3]/div/div/div/input"));
			dx_textDOSStart3.isDisplayed();
			Utilities.mouseHoverToTheElemnet(dx_textDOSStart3, driver);
			Utilities.clickonElement(dx_textDOSStart3, driver);
			//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart3(),"01/08/2020", driver);
			
		}
		
		Utilities.clickonElement(objMCCChartQueuePage.getDx_date_yearArrow(), driver);
		Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(),driver);
		
		
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName3(),driver);
		//objMCCChartQueuePage.getDx_textproviderName3().clear();
		
		objMCCChartQueuePage.getDx_textproviderName3().sendKeys("test3");
		Robot robot = new Robot(); 
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
	
}
	
	@When("user enters visit type in row3")
	public void user_enters_visit_type_in_row3() throws AWTException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[3]/td[9]/div/div/span/div/input"));
			//JavascriptExecutor j = (JavascriptExecutor) driver;
		    //j.executeScript("arguments[0].value='Test';", l); 
			//j.executeScript("arguments[0].click();", l);
			l.sendKeys("vp");
			}
			catch(ElementNotInteractableException e) {
				WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[3]/td[9]/div/div/span/div/input"));
				JavascriptExecutor j = (JavascriptExecutor) driver;
				j.executeScript("arguments[0].click();", l);
				Robot robot = new Robot(); 
			     
				robot.keyPress(KeyEvent.VK_Q); 
			    robot.keyRelease(KeyEvent.VK_Q); 

			}
	}
	@When("user enters valid DX Code {string} in row3")
	public void user_enters_valid_dx_code_in_row3(String string) throws AWTException {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textdxCode(), driver);
		//objMCCChartQueuePage.getDx_textdxCode().clear();
		objMCCChartQueuePage.getDx_textdxCode().sendKeys(string);
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
	}
	@When("enters page no, slects {string} as L1 primary comment in row3")
	public void enters_page_no_slects_as_l1_primary_comment_in_row3(String string) throws AWTException {
	    // Write code here that turns the phrase above into concrete actions
		/************************PAGE NUMBER EDIT****************************************/
		Robot robot = new Robot(); 

		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.keyPress(KeyEvent.VK_7);
		robot.keyRelease(KeyEvent.VK_7);
		
		/************************ Flex Field 1 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_textDxFlex1().click();
		//objMCCChartQueuePage.getDx_textDxFlex1().clear();
		objMCCChartQueuePage.getDx_textDxFlex1().sendKeys("flex11");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
		/************************ Flex Field 2 EDIT****************************************/
		
		//objMCCChartQueuePage.getDx_textDxflex2().clear();
		objMCCChartQueuePage.getDx_textDxflex2().click();
		objMCCChartQueuePage.getDx_textFlex2().sendKeys("flex21");
		
		/************************ L1 Secondary drop down****************************************/
		
		List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
		System.out.println("size" + select.size());
		select.get(2).click();
		List<WebElement> select_values = driver.findElements(
				By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
		System.out.println("size " + select_values.size());

		for (int i = 0; i < select_values.size(); i++) {
			WebElement element = select_values.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element);

			String attribute = element.getText();
			String value = string;
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + value);
			if (attribute.equalsIgnoreCase(value)) {
				 assertEquals(attribute, value);
				element.click();
				break;
			}

			// System.out.println("Values of dropdown :"+attribute);
		}
				
	}
	
	@When("user enters valid date and provider name in row4")
	public void user_enters_valid_date_and_provider_name_in_row4() throws AWTException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 350)");
		
		wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart4()));
		try {
			objMCCChartQueuePage.getDx_textDOSStart4().isDisplayed();
		} catch (NoSuchElementException e) {
			
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart4()));
			objMCCChartQueuePage.getDx_textDOSStart4().isDisplayed();
		}*/
		
		try {
			WebElement dx_textDOSStart4 = objMCCChartQueuePage.getDx_textDOSStart4();
			
			//Utilities.clickonElement(dx_textDOSStart4, driver);
			//Utilities.jsClick(driver, dx_textDOSStart4);
			
		

				for(int i = 0;i<5;i++) {
						Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart4(), driver);
						
					
						try {
							Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_detepickeryr(), 5);
							break;
						}catch(Exception e) {
							continue;
						}
					}
			JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("scroll(0, 250)");
					//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart4(),"01/08/2020", driver);
		}
			catch (ElementClickInterceptedException e1) {
			// TODO Auto-generated catch block
				wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart4()));
				WebElement dx_textDOSStart4 = objMCCChartQueuePage.getDx_textDOSStart4();
				Utilities.mouseHoverToTheElemnet(dx_textDOSStart4, driver);
				Utilities.clickonElement(dx_textDOSStart4, driver);
		
				}
		catch (StaleElementReferenceException e1) {
			// TODO Auto-generated catch block
				wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart4()));
				WebElement dx_textDOSStart4 = objMCCChartQueuePage.getDx_textDOSStart4();
				Utilities.mouseHoverToTheElemnet(dx_textDOSStart4, driver);
				Utilities.clickonElement(dx_textDOSStart4, driver);
		
				}
		
		
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait1.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_DummyDate()));
		
		String year = objMCCChartQueuePage.getDx_detepickeryr().getText();
		System.out.println(year);
				
		if(year.equals("2019"))
		{
		objMCCChartQueuePage.getDx_date_yearArrow4().click();
		wait1.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_date_date8()));
		Utilities.clickUsingActions(objMCCChartQueuePage.getDx_date_date8(), driver);
		}
		else {
			//Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(), driver);
			Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart4(),"01/08/2020", driver);
			//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
			Utilities.keypress_tab(2);
			
		}
		
		
		//jse.executeScript("scroll(250, 0)"); // if the element is on top.

		//jse.executeScript("scroll(0, 250)"); //scroll : element in bottom.
	
		
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName4(),driver);
		//objMCCChartQueuePage.getDx_textproviderName2().clear();
		
		objMCCChartQueuePage.getDx_textproviderName4().sendKeys("testMA4");

		Robot robot = new Robot(); 
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
		Utilities.keypress_tab(2);
				
		/*try {
			objMCCChartQueuePage.getDx_textDOSStart4().click();
			Thread.sleep(10000);
			Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart4(),"01/08/2020", driver);
			Thread.sleep(10000);

		} catch (ElementClickInterceptedException e) {
			
			// TODO Auto-generated catch block
			//List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='DOS Start']"));
			
			WebElement dx_textDOSStart4 =driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[2]/td[3]/div/div/div/input"));
			dx_textDOSStart4.isDisplayed();
			Utilities.mouseHoverToTheElemnet(dx_textDOSStart4, driver);
			Utilities.clickonElement(dx_textDOSStart4, driver);
			Thread.sleep(10000);
			Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart4(),"01/08/2020", driver);
			
			//WebDriverWait driverWait = new WebDriverWait( new SystemClock(), Driver, TimeSpan.FromSeconds( 20 ), TimeSpan.FromSeconds( 3 ) );
			
		}

		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName4(),driver);
		//objMCCChartQueuePage.getDx_textproviderName2().clear();
		
		objMCCChartQueuePage.getDx_textproviderName4().sendKeys("testMA4");
		Robot robot = new Robot(); 
		
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB); */
		
	
	
	
	}
	@When("user enters visit type in row4")
	public void user_enters_visit_type_in_row4() throws AWTException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	
		try {
			WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[4]/td[9]/div/div/span/div/input"));
			//JavascriptExecutor j = (JavascriptExecutor) driver;
		    //j.executeScript("arguments[0].value='Test';", l); 
			//j.executeScript("arguments[0].click();", l);
			l.sendKeys("vp");
			}
			catch(ElementNotInteractableException e) {
				WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[4]/td[9]/div/div/span/div/input"));
				JavascriptExecutor j = (JavascriptExecutor) driver;
				j.executeScript("arguments[0].click();", l);
				Thread.sleep(10000);
				Robot robot = new Robot(); 
			     
				robot.keyPress(KeyEvent.VK_Q); 
			    robot.keyRelease(KeyEvent.VK_Q); 

			}
		Thread.sleep(10000);
		
	}
	@When("user enters valid DX Code {string} in row4")
	public void user_enters_valid_dx_code_in_row4(String string) throws AWTException {
	    // Write code here that turns the phrase above into concrete actions
	   
		try {
			Utilities.keypress_tab(3);
			Thread.sleep(10000);
			Utilities.clickonElement(objMCCChartQueuePage.getDx_textdxCode(), driver);
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			//Utilities.keypress_tab(3);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textdxCode()));
			Utilities.clickUsingActions(objMCCChartQueuePage.getDx_textdxCode(), driver);
		}

		//objMCCChartQueuePage.getDx_textdxCode().clear();
		objMCCChartQueuePage.getDx_textdxCode().sendKeys(string);
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
	}
	@When("enters page no, slects {string} as L1 primary comment in row4")
	public void enters_page_no_slects_as_l1_primary_comment_in_row4(String string) throws AWTException {
	    // Write code here that turns the phrase above into concrete actions
		/************************PAGE NUMBER EDIT****************************************/
		Robot robot = new Robot(); 

		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.keyPress(KeyEvent.VK_7);
		robot.keyRelease(KeyEvent.VK_7);
		
		/************************ Flex Field 1 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_textDxFlex1().click();
		objMCCChartQueuePage.getDx_textDxFlex1().clear();
		objMCCChartQueuePage.getDx_textDxFlex1().sendKeys("flex11");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
		//objMCCHomePage.getOK().click();
		
		/************************ Flex Field 2 EDIT****************************************/
		
		objMCCChartQueuePage.getDx_textDxflex2().clear();
		objMCCChartQueuePage.getDx_textDxflex2().click();
		objMCCChartQueuePage.getDx_textFlex2().sendKeys("flex21");
		
		/************************ L1 Secondary drop down****************************************/
		
		List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
		System.out.println("size" + select.size());
		select.get(2).click();
		List<WebElement> select_values = driver.findElements(
				By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
		System.out.println("size " + select_values.size());

		for (int i = 0; i < select_values.size(); i++) {
			WebElement element = select_values.get(i);
			Actions action = new Actions(driver);

			// Performing the mouse hover action on the target element.
			action.moveToElement(element);

			String attribute = element.getText();
			String value = string;
			System.out.println("Attribute :" + attribute);
			System.out.println("Given string :" + value);
			if (attribute.equalsIgnoreCase(value)) {
				 assertEquals(attribute, value);
				element.click();
				break;
			}

			// System.out.println("Values of dropdown :"+attribute);
		}
	
	}
	
	

@When("user enters valid date and provider name in row5")
public void user_enters_valid_date_and_provider_name_in_row5() throws AWTException {
    // Write code here that turns the phrase above into concrete actions
	

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	
	try {
		WebElement dx_textDOSStart5 = objMCCChartQueuePage.getDx_textDOSStart5();
		
		//Utilities.clickonElement(dx_textDOSStart4, driver);
		//Utilities.jsClick(driver, dx_textDOSStart4);
		
	

			for(int i = 0;i<5;i++) {
					try {
						Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart5(), driver);
					} catch (ElementClickInterceptedException e) {
						
						Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_textDOSStart5(), 10);
						Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart5(), driver);
					}
							
					try {
						Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_detepickeryr(), 5);
						break;
					}catch(Exception e) {
						continue;
					}
				}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)");
				//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart4(),"01/08/2020", driver);
	}
		catch (ElementClickInterceptedException e1) {
		// TODO Auto-generated catch block
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart5()));
			WebElement dx_textDOSStart5 = objMCCChartQueuePage.getDx_textDOSStart5();
			Utilities.mouseHoverToTheElemnet(dx_textDOSStart5, driver);
			Utilities.clickonElement(dx_textDOSStart5, driver);
	
			}
	catch (StaleElementReferenceException e1) {
		// TODO Auto-generated catch block
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart5()));
			WebElement dx_textDOSStart5 = objMCCChartQueuePage.getDx_textDOSStart5();
			Utilities.mouseHoverToTheElemnet(dx_textDOSStart5, driver);
			Utilities.clickonElement(dx_textDOSStart5, driver);
	
			}
	
	
	
	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(100));
	//wait1.until(ExpectedConditions.element(objMCCChartQueuePage.getDx_DummyDate()));
	
	String year = objMCCChartQueuePage.getDx_detepickeryr().getText();
	System.out.println(year);
			
	if(year.equals("2019"))
	{
		/*Utilities.clickonElement(objMCCChartQueuePage.getDx_date_yearArrow(), driver);
		wait1.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_date_date8()));
	Utilities.clickUsingActions(objMCCChartQueuePage.getDx_date_date8(), driver);*/
		
		Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart5(),"01/08/2020", driver);
		//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
		Utilities.keypress_tab(2);
	}
	else {
		//Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(), driver);
		Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart5(),"01/08/2020", driver);
		//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
		Utilities.keypress_tab(2);
		
	}
	
	
	//jse.executeScript("scroll(250, 0)"); // if the element is on top.

	//jse.executeScript("scroll(0, 250)"); //scroll : element in bottom.

	
	try {
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName5(),driver);
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		wait1.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textproviderName5()));
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName5(),driver);
	}
	//objMCCChartQueuePage.getDx_textproviderName2().clear();
	
	objMCCChartQueuePage.getDx_textproviderName5().sendKeys("testMA5");

	Robot robot = new Robot(); 
	
	robot.keyPress(KeyEvent.VK_ENTER); 
	robot.keyRelease(KeyEvent.VK_ENTER); 
	Utilities.keypress_tab(2);
	
	
	

	/*JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0, 250)");
	
	try {
		
		objMCCChartQueuePage.getDx_textDOSStart5().click();
		
	} catch (ElementClickInterceptedException e) {
		
		// TODO Auto-generated catch block
		//List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='DOS Start']"));
		
		WebElement dx_textDOSStart5 =driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[5]/td[3]/div/div/div/input"));
		dx_textDOSStart5.isDisplayed();
		Utilities.mouseHoverToTheElemnet(dx_textDOSStart5, driver);
		Utilities.clickonElement(dx_textDOSStart5, driver);
		
	}
	//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart4(),"01/08/2020", driver);
	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(100));
	wait1.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_DummyDate()));
	
	
	String year = objMCCChartQueuePage.getDx_detepickeryr().getText();
	System.out.println(year);

	if(year.equals("2019"))
	{
	objMCCChartQueuePage.getDx_date_yearArrow().click();
	objMCCChartQueuePage.getDx_date_date8().click();

	}
	else {
		//Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(), driver);
		Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart5(),"01/08/2020", driver);
		//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
		Utilities.keypress_tab(2);
		;
				
		
		
	}
	
	
	//jse.executeScript("scroll(250, 0)"); // if the element is on top.

	//jse.executeScript("scroll(0, 250)"); //scroll : element in bottom.

	
	Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName5(),driver);
	//objMCCChartQueuePage.getDx_textproviderName2().clear();
	
	objMCCChartQueuePage.getDx_textproviderName5().sendKeys("testMA4");

	Robot robot = new Robot(); 
	
	robot.keyPress(KeyEvent.VK_ENTER); 
	robot.keyRelease(KeyEvent.VK_ENTER); 
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);*/
	/*wait1.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_detepickeryr()));
	Utilities.clickonElement(objMCCChartQueuePage.getDx_date_yearArrow(), driver);
	//objMCCChartQueuePage.getDx_date_yearArrow().click();
	objMCCChartQueuePage.getDx_date_date8().click();

	Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName5(),driver);
	//objMCCChartQueuePage.getDx_textproviderName4().clear();
	
	objMCCChartQueuePage.getDx_textproviderName5().sendKeys("test5");
	Robot robot = new Robot(); 
	
	robot.keyPress(KeyEvent.VK_ENTER); 
	robot.keyRelease(KeyEvent.VK_ENTER); 
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);*/
	
}
@When("user enters visit type in row5")
public void user_enters_visit_type_in_row5() throws AWTException {
    // Write code here that turns the phrase above into concrete actions
	
	try {
								
		WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[5]/td[9]/div/div/span/div/input"));
		//JavascriptExecutor j = (JavascriptExecutor) driver;
	    //j.executeScript("arguments[0].value='Test';", l); 
		//j.executeScript("arguments[0].click();", l);
		l.sendKeys("vp");
		}
		catch(ElementNotInteractableException e) {
			WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[6]/td[9]/div/div/span/div/input"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", l);
			Robot robot = new Robot(); 
		     
			robot.keyPress(KeyEvent.VK_Q); 
		    robot.keyRelease(KeyEvent.VK_Q); 

		}
		
}
@When("user enters valid DX Code {string} in row5")
public void user_enters_valid_dx_code_in_row5(String string) throws AWTException {
    // Write code here that turns the phrase above into concrete actions
	
	
	Utilities.clickonElement(objMCCChartQueuePage.getDx_textdxCode(), driver);
	//objMCCChartQueuePage.getDx_textdxCode().click();
	//objMCCChartQueuePage.getDx_textdxCode().clear();
	objMCCChartQueuePage.getDx_textdxCode().sendKeys(string);
	Robot robot = new Robot(); 
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
}
@When("enters page no, slects {string} as L1 primary comment in row5")
public void enters_page_no_slects_as_l1_primary_comment_in_row5(String string) throws AWTException {
    // Write code here that turns the phrase above into concrete actions
	
	/************************PAGE NUMBER EDIT************************************
	 * 						
	 * 				7	
	 */
	//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
	//objMCCHomePage.getOK().click();
	
	Robot robot = new Robot(); 

	robot.keyPress(KeyEvent.VK_DELETE);
	robot.keyRelease(KeyEvent.VK_DELETE);
	robot.keyPress(KeyEvent.VK_7);
	robot.keyRelease(KeyEvent.VK_7);
	
	/************************ Flex Field 2 EDIT****************************************/
	
	objMCCChartQueuePage.getDx_textDxflex2().clear();
	objMCCChartQueuePage.getDx_textDxflex2().click();
	objMCCChartQueuePage.getDx_textFlex2().sendKeys("flex21");
	
	/************************ L1 Secondary drop down****************************************/
	
	List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
	System.out.println("size" + select.size());
	select.get(2).click();
	List<WebElement> select_values = driver.findElements(
			By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
	System.out.println("size " + select_values.size());

	for (int i = 0; i < select_values.size(); i++) {
		WebElement element1 = select_values.get(i);
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(element1);

		String attribute = element1.getText();
		String value = string;
		System.out.println("Attribute :" + attribute);
		System.out.println("Given string :" + value);
		if (attribute.equalsIgnoreCase(value)) {
			 assertEquals(attribute, value);
			element1.click();
			break;
		}

		// System.out.println("Values of dropdown :"+attribute);
	}
	
	
}


@When("user enters valid date and provider name {string} in row6")
public void user_enters_valid_date_and_provider_name_in_row6(String string)  throws AWTException {
    // Write code here that turns the phrase above into concrete actions
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	
	try {
		WebElement dx_textDOSStart6 = objMCCChartQueuePage.getDx_textDOSStart6();
		
		//Utilities.clickonElement(dx_textDOSStart4, driver);
		//Utilities.jsClick(driver, dx_textDOSStart4);
		
	

			for(int i = 0;i<5;i++) {
					try {
						Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart6(), driver);
					} catch (ElementClickInterceptedException e) {
						
						Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_textDOSStart6(), 10);
						Utilities.clickonElement(objMCCChartQueuePage.getDx_textDOSStart5(), driver);
					}
							
					try {
						Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_detepickeryr(), 5);
						break;
					}catch(Exception e) {
						continue;
					}
				}
		JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)");
				//Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart4(),"01/08/2020", driver);
	}
		catch (ElementClickInterceptedException e1) {
		// TODO Auto-generated catch block
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart6()));
			WebElement dx_textDOSStart6 = objMCCChartQueuePage.getDx_textDOSStart6();
			Utilities.mouseHoverToTheElemnet(dx_textDOSStart6, driver);
			Utilities.clickonElement(dx_textDOSStart6, driver);
	
			}
	catch (StaleElementReferenceException e1) {
		// TODO Auto-generated catch block
			wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textDOSStart6()));
			WebElement dx_textDOSStart6 = objMCCChartQueuePage.getDx_textDOSStart6();
			Utilities.mouseHoverToTheElemnet(dx_textDOSStart6, driver);
			Utilities.clickonElement(dx_textDOSStart6, driver);
	
			}
	
	
	
	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(100));
	//wait1.until(ExpectedConditions.element(objMCCChartQueuePage.getDx_DummyDate()));
	
	String year = objMCCChartQueuePage.getDx_detepickeryr().getText();
	System.out.println(year);
			
	if(year.equals("2019"))
	{
		/*Utilities.clickonElement(objMCCChartQueuePage.getDx_date_yearArrow(), driver);
		wait1.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_date_date8()));
	Utilities.clickUsingActions(objMCCChartQueuePage.getDx_date_date8(), driver);*/
		
		Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart6(),"01/08/2020", driver);
		//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
		Utilities.keypress_tab(2);
	}
	else {
		//Utilities.clickonElement(objMCCChartQueuePage.getDx_date_date8(), driver);
		Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart6(),"01/08/2020", driver);
		//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
		Utilities.keypress_tab(2);
		
	}
	
	
	//jse.executeScript("scroll(250, 0)"); // if the element is on top.

	//jse.executeScript("scroll(0, 250)"); //scroll : element in bottom.

	
	try {
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName6(),driver);
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		wait1.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_textproviderName6()));
		Utilities.clickonElement(objMCCChartQueuePage.getDx_textproviderName6(),driver);
	}
	//objMCCChartQueuePage.getDx_textproviderName2().clear();
	
	objMCCChartQueuePage.getDx_textproviderName6().sendKeys(string);

	Robot robot = new Robot(); 
	
	robot.keyPress(KeyEvent.VK_ENTER); 
	robot.keyRelease(KeyEvent.VK_ENTER); 
	Utilities.keypress_tab(2);

}
@When("user enters visit type in row6")
public void user_enters_visit_type_in_row6() throws AWTException {
    // Write code here that turns the phrase above into concrete actions
	try {
		WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[5]/td[9]/div/div/span/div/input"));
		//JavascriptExecutor j = (JavascriptExecutor) driver;
	    //j.executeScript("arguments[0].value='Test';", l); 
		//j.executeScript("arguments[0].click();", l);
		l.sendKeys("vp");
		}
		catch(ElementNotInteractableException e) {
			WebElement l = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[5]/td[9]/div/div/span/div/input"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", l);
			Robot robot = new Robot(); 
		     
			robot.keyPress(KeyEvent.VK_Q); 
		    robot.keyRelease(KeyEvent.VK_Q); 

		}
		
  
}
@When("user enters valid DX Code {string} in row6")
public void user_enters_valid_dx_code_in_row6(String string) throws AWTException {
    // Write code here that turns the phrase above into concrete actions
	Utilities.clickonElement(objMCCChartQueuePage.getDx_textdxCode(), driver);
	//objMCCChartQueuePage.getDx_textdxCode().click();
	//objMCCChartQueuePage.getDx_textdxCode().clear();
	objMCCChartQueuePage.getDx_textdxCode().sendKeys(string);
	Robot robot = new Robot(); 
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
}
@When("enters page no, slects {string} as L1 primary comment in row6")
public void enters_page_no_slects_as_l1_primary_comment_in_row6(String string) throws AWTException, InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	/************************PAGE NUMBER EDIT****************************************/
	Robot robot = new Robot(); 

	robot.keyPress(KeyEvent.VK_DELETE);
	robot.keyRelease(KeyEvent.VK_DELETE);
	robot.keyPress(KeyEvent.VK_7);
	robot.keyRelease(KeyEvent.VK_7);
	
	/************************ Flex Field 1 EDIT****************************************/
	
	objMCCChartQueuePage.getDx_textDxFlex1().click();
	//objMCCChartQueuePage.getDx_textDxFlex1().clear();
	objMCCChartQueuePage.getDx_textDxFlex1().sendKeys("flex11");
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	
	//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
	//objMCCHomePage.getOK().click();
	
	/************************ Flex Field 2 EDIT****************************************/
	
	//objMCCChartQueuePage.getDx_textDxflex2().clear();
	objMCCChartQueuePage.getDx_textDxflex2().click();
	objMCCChartQueuePage.getDx_textFlex2().sendKeys("flex21");
	
	/************************ L1 Secondary drop down****************************************/
	
	List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
	System.out.println("size" + select.size());
	select.get(2).click();
	List<WebElement> select_values = driver.findElements(
			By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
	System.out.println("size " + select_values.size());

	for (int i = 0; i < select_values.size(); i++) {
		WebElement element = select_values.get(i);
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(element);

		String attribute = element.getText();
		String value = string;
		System.out.println("Attribute :" + attribute);
		System.out.println("Given string :" + value);
		if (attribute.equalsIgnoreCase(value)) {
			 assertEquals(attribute, value);
			element.click();
			break;
		}
	}
	
	Utilities.keypress_tab(3);
	
	Thread.sleep(5000);

   
}



@When("user enters another DX code {string}, page no,flexi fields and select {string} as L1 primary comment in row6")
public void user_enters_another_dx_code_page_no_flexi_fields_and_select_as_l1_primary_comment_in_row6(String string, String string2) throws AWTException, InterruptedException {
   // Write code here that turns the phrase above into concrete actions
	System.out.println("STRING :"+ string);
	
			if(string.equalsIgnoreCase("S48119A")) {
				System.out.println("STRING :"+ string);
		rowno=2;
	
	}
	else if(string.equalsIgnoreCase("Z992")) {
		rowno=3;
	}
	for(int i=0;i<30;i++) {
		 
		try {
			System.out.println(rowno);
			
			Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.dx_textdxcode_row2(rowno), 100);
			objMCCChartQueuePage.dx_textdxcode_row2(rowno).click();
			break;
		}catch(Exception e) {
			System.out.println(rowno);
			System.out.println("Exception occured");
			Thread.sleep(500);
			
			/*Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.dx_textdxcode_row2(rowno), 500);
			objMCCChartQueuePage.dx_textdxcode_row2(rowno).click();*/
			continue;
		}
	}
	//Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.dx_textdxcode_row2(),100);
	Utilities.sendKeysUsingActions(objMCCChartQueuePage.dx_textdxcode_row2(rowno), string, driver);
	Utilities.keypress_tab(0);
	/************************PAGE NUMBER EDIT****************************************/
	Robot robot = new Robot(); 

	robot.keyPress(KeyEvent.VK_DELETE);
	robot.keyRelease(KeyEvent.VK_DELETE);
	robot.keyPress(KeyEvent.VK_7);
	robot.keyRelease(KeyEvent.VK_7);
	
	
	/************************ Flex Field 1 EDIT****************************************/
	
	objMCCChartQueuePage.getDx_textDxflex1_row2(rowno).click();
	//objMCCChartQueuePage.getDx_textDxFlex1().clear();
	objMCCChartQueuePage.getDx_textDxflex1_row2(rowno).sendKeys("flexone");
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_TAB);
	
	//Utilities.clickonElement(objMCCHomePage.getWf_savebutton(), driver);
	//objMCCHomePage.getOK().click();
	
	/************************ Flex Field 2 EDIT****************************************/
	
	//objMCCChartQueuePage.getDx_textDxflex2().clear();
	objMCCChartQueuePage.getDx_textDxflex2_row2(rowno).click();
	objMCCChartQueuePage.getDx_textDxflex2_row2(rowno).sendKeys("flex221");
	
	/************************ L1 Secondary drop down****************************************/
	
	List<WebElement> select = driver.findElements(By.xpath("//input[@placeholder='Select']"));
	System.out.println("size" + select.size());
	int j=rowno+1;
	System.out.println("J value"  + j);
	WebElement webElement = select.get(j);
	Utilities.waitforElementVisibility(webElement, driver);
	Utilities.clickonElement(webElement, driver);
	List<WebElement> select_values = driver.findElements(By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
	System.out.println("size " + select_values.size());

	for (int i = 0; i < select_values.size(); i++) {
		WebElement element = select_values.get(i);
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(element);

		String attribute = element.getText();
		String value = string2;
		System.out.println("Attribute :" + attribute);
		System.out.println("Given string :" + value);
		if (attribute.equalsIgnoreCase(value)) {
			Utilities.clickonElement(element, driver);
			//Utilities.clickonElement(element, driver);
			 assertEquals(attribute, value);
			//element.click();
			break;
		}
		
	}
	Utilities.waitForPageLoaded(driver);
	//Utilities.keypress_tab(3);
	
}


@Then("user verify for HCC code populated")
public void user_verify_for_hcc_code_populated() {
    // Write code here that turns the phrase above into concrete actions
    List<WebElement> dx_HccCode = objMCCChartQueuePage.getDx_HccCode();
   int size = dx_HccCode.size();
   System.out.println("Size :"+size);
  for(int i=0;i<size;i++) {
	  
	  String hccCode = Utilities.jsGetValue(driver, dx_HccCode.get(i));
	   System.out.println("HCC code :" + hccCode);
	   String text = dx_HccCode.get(i).getText();
	   System.out.println("HCC code text :" + text);
  }
	   
	    //String text = element.getText();
	   // 
	 
	   //  assertNotNull(text);
	   
}





@When("user clicks on openall encounters button")
public void user_clicks_on_openall_encounters_button() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Iam in try block");
	Utilities.waitForElementToBeDisplayed(driver, objMCCChartQueuePage.getDx_openEncounters(), 300);
	System.out.println("I am displayed");
	Utilities.waitForElementToBeClickable(driver, objMCCChartQueuePage.getDx_openEncounters());
	System.out.println("I am clickable");
	Utilities.mouseHoverToTheElemnet(objMCCChartQueuePage.getDx_openEncounters(), driver);
	System.out.println("I am mousehovered");
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(objMCCChartQueuePage.getDx_openEncounters()));
	//objMCCChartQueuePage.getDx_openEncounters().click();
	//Utilities.clickUsingActions(objMCCChartQueuePage.getDx_openEncounters(), driver);
	//Thread.sleep(3000);
	List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Open All Encounters')]"));
	WebElement et=elements.get(0);
	Utilities.jsClick(driver,et);

}





@Then("user verify for the given DX Code {string},{string},{string},{string},{string},{string},{string},{string}")
public void user_verify_for_the_given_dx_code(String string, String string2, String string3, String string4, String string5, String string6, String string7,String string8) throws IOException {
    // Write code here that turns the phrase above into concrete actions
	//Utilities.tkScreenshot(driver);
	String[] givendxcodes= {string,string2,string3,string4,string5,string6,string7,string8};
	List<WebElement> dxcodes = objMCCChartQueuePage.getDx_textdxCodes();
	for(int i=0;i<dxcodes.size();i++) {
		String dxcode = Utilities.jsGetValue(driver, dxcodes.get(i)	);
		String expectedDxcode = givendxcodes[i];
		System.out.println(dxcode);
		 assertEquals("dxcode verification pass" , expectedDxcode,dxcode );
	}
	//objMCCChartQueuePage.getDx_textCoderDXes();
	//objMCCChartQueuePage.getDx_openEncounters().click();
	//Utilities.clickUsingActions(objMCCChartQueuePage.getDx_openEncounters(), driver);
	//Thread.sleep(3000);
	//WebElement et = driver.findElement(By.xpath("//*[@id='pagination']/div[1]/div/button"));
	//Utilities.jsClick(driver,et);

}
	
	
}



	


