package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import pageobjects.MCCChartQueuePage;
import pageobjects.MCCChartWorkflowTabPage;
import pageobjects.MCCHomePage;
import pageobjects.Utilities;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class MCCHomePageDefinitions {
	//public static String winHandleBefore;
	WebDriver driver = CommonDefinitions.driver;
	// objMCCHomePage;
	LoginPage objLoginPage;
	static int count=0;

	MCCHomePage objMCCHomePage = new MCCHomePage(driver);
	MCCChartQueuePage objMCCChartQueuePage = new MCCChartQueuePage(driver);
	MCCChartWorkflowTabPage objMCCChartWorkflowTabPage = new MCCChartWorkflowTabPage(driver);
	

	@Then("Log in as Admin User")
	public void LogInasAdminUser() {
		objLoginPage = new LoginPage(driver);
		objLoginPage.login("testautomation@episource.com.qa", "Test@123");
	}

	@Given("I am logged in at Salesforce Classic")
	public void isLoggedToMCCSalesforce() {
		String title = driver.getTitle();
		System.out.println("title :" +title);

		objMCCHomePage = new MCCHomePage(driver);
		Assert.assertTrue(objMCCHomePage.isLoggedtoMCCSalesforce(), "User is not logged in to Salesforce-Classic");
	}
	
	@Given("user Navigate to Chart Mover Beta")
	public void user_navigate_to_chart_mover_beta() {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.clickonElement(objMCCHomePage.getHomepage_plusicon(), driver);
		Utilities.scrollToElement(driver, objMCCHomePage.getHomepage_chartMoverBeta());
		Utilities.clickUsingActions(objMCCHomePage.getHomepage_chartMoverBeta(), driver);

	   
	}
	@When("user enters the Chart ID in the search field and clicks on search button")
	public void user_enters_the_chart_id_in_the_search_field_and_clicks_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.clickonElement(objMCCHomePage.getChartbeta_chartid(), driver);
		Utilities.sendKeysUsingActions(objMCCHomePage.getChartbeta_chartid(), "A-FMR9K8", driver);
		Utilities.clickonElement(objMCCHomePage.getChartbeta_search(),driver);
	
	}
	
	@When("user select the chart and click on Update Status button")
	public void user_select_the_chart_and_click_on_update_status_button() {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.clickonElement(objMCCHomePage.getChartbeta_selectchart(), driver);
		Utilities.clickonElement(objMCCHomePage.getUpdate_status(), driver);
		Select dropdown = new Select(objMCCHomePage.getChartbeta_selectstatus());
		dropdown.selectByVisibleText("1 - Raw");
	    
	}
	@When("selects status as {string} and then Additional Parameters")
	public void selects_status_as_and_then_additional_parameters(String string) {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.clickonElement(objMCCHomePage.getChartbeta_p1_Raw1(),driver);
		Utilities.clickonElement(objMCCHomePage.getChartbeta_p2_Autimestamp(),driver);
		Utilities.clickonElement(objMCCHomePage.getChartbeta_p3_MAtimestamp(),driver);
		Utilities.clickonElement(objMCCHomePage.getChartbeta_p3_DXdata(), driver);
		Utilities.clickonElement(objMCCHomePage.getChartbeta_Update_final(), driver);
		Utilities.clickonElement(objMCCHomePage.getChartbeta_Update_Confirm(), driver);
	}

	@When("Log in as {string} in MCC")
	public void logInAs(String text1) throws InterruptedException {

		objMCCHomePage = new MCCHomePage(driver);
		Utilities.clickonElement(objMCCHomePage.getTxtSearch(), driver);
		Utilities.clickonElement(objMCCHomePage.getBtnSearchHome(), driver);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		//String text=null;
		//Strin`gBuilder text = new StringBuilder();
		if (driver.getCurrentUrl().contains("uat"))
		{
			System.out.println("count before="+count);
			count=count+1;
			String text = userIndentificationUAT();
			System.out.println("user Identification :"+text);
			objMCCHomePage.getTxtSearch().sendKeys(text);
			objMCCHomePage.getTxtSearch().sendKeys(Keys.ENTER);
			System.out.println("count after="+count);
			try {
				driver.findElement(By.cssSelector("a[title='" + text + "']")).click();
				Thread.sleep(500);
			} catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
				driver.findElement(By.xpath("//a[contains(text(),'" + text + "')]")).click();
			}
			Thread.sleep(500);
			//objMCCHomePage.searchInMCCSalesforce(text);
			//Utilities.clickonElement(objMCCHomePage.getChartmover(), driver);
			objMCCHomePage.isUserDetailsButtonDisplayed();
			objMCCHomePage.ClickLoginButtoninUserDetail();
		}
		else {
			//String text;
			count=count+1;
			System.out.println(count);
			String text = userIndentificationQA(count);
			System.out.println("user : "+text);
			//text="Coder Automation";
			objMCCHomePage.getTxtSearch().sendKeys(text);
			objMCCHomePage.getTxtSearch().sendKeys(Keys.ENTER);
			
			try {
				driver.findElement(By.cssSelector("a[title='" + text + "']")).click();
				Thread.sleep(500);
			} catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
				driver.findElement(By.xpath("//a[contains(text(),'" + text + "')]")).click();
			}
			Thread.sleep(500);
			//objMCCHomePage.searchInMCCSalesforce(text);
			//Utilities.clickonElement(objMCCHomePage.getChartmover(), driver);
			objMCCHomePage.isUserDetailsButtonDisplayed();
			objMCCHomePage.ClickLoginButtoninUserDetail();
			//count=count++;
		}
		
		Thread.sleep(500);
		
		

		
	}
	
	
	public String userIndentificationUAT() {
		String text = null;
		if(count==1) 
		{
		 text = "Coder Automation_mcc";
			}
		else if(count==2) 
		{
			 text = "Auditor Automation_mcc";
				}
		else if(count==3) 
		{
			 text = "Master Auditor Automation_mcc";
				}
	
	return text;
	}
	
	
	public String userIndentificationQA(int count) {
		
		/*WebElement element = driver.findElement(By.xpath("//a[@id='globalHeaderNameMink']/span/span"));
		//Utilities.clickonElement(element, driver); 
		String user= element.getText();
		StringBuilder m = new StringBuilder(text1);*/
		String text = null;
		if(count==1) 
		{
		 text = "Coder Automation";
			}
		else if(count==2) 
		{
			 text = "Auditor Automation";
				}
		/*else if (user.contains("Auditor")) {
			
			m.replace(text1.indexOf(0),text1.length()-1, user);
			System.out.println("qaauditor :"+ m);
			return (m);
		}
		//return (m);*/
		return text;
		
			
	}
	

	@And("Log out as L1 User")
	public void logOutAsUser() {

		objMCCHomePage = new MCCHomePage(driver);
		objMCCHomePage.ClickOnUserNavigation();
		objMCCHomePage.ClickOnUserLogOutMenu();
	}

	@When("Login as Admin User & Verify the Developer Console menu is Displayed")
	public void MoveTheTestChartToRaw() {

		objMCCHomePage = new MCCHomePage(driver);

		objMCCHomePage.ClickProfileDropdown();
		Assert.assertTrue(objMCCHomePage.isDeveloperConsoleDisplayed(),
				"Admin User is not logged in to Salesforce-Classic");
	}

	@And("Click on Developer Console Menu in Profile Dropdown")
	public void ClickOnDeveloperConsole() {
		objMCCHomePage = new MCCHomePage(driver);
		objMCCHomePage.ClickOnDeveloperConsole();
		objMCCHomePage.switchToDevConsole();
		objMCCHomePage.switchToApexCode();
	}

	@And("Open Apex Code Window & Run the script")
	public void OpenApexCodeandRunScript() throws IOException {
		objMCCHomePage = new MCCHomePage(driver);
		objMCCHomePage.switchToApexCode();
		objMCCHomePage.RunApexScriptToMoveChart();
		driver.close();

	}

	@Then("Switch to Home Page")
	public void SwitchToHomePage() throws IOException {
		objMCCHomePage = new MCCHomePage(driver);
		objMCCHomePage.switchToHomePage();
	}

	@And("open MCC Chart Queue and Get {string} Test Chart")
	public  void open_mcc_chart_queue_and_and_get_test_chart(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
	
		
		objMCCHomePage.Click_MCC_chq();
		// WebElement element = driver.findElement(By.id("Login"));

		objMCCHomePage.Click_getChart();
		System.out.println("string :" + string);
		Thread.sleep(2000);
		objMCCHomePage.openChartId(string);
		System.out.println("string :" + string);
		objMCCHomePage.switchToMccChart();
		objMCCHomePage.Click_collapsibleArrow();
	}
	
	@When("open MCC Chart Queue, select {string} project and Get {string} Test Chart")
	public void open_mcc_chart_queue_select_project_and_get_test_chart(String string, String string2) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		objMCCHomePage.Click_MCC_chq();
		Utilities.waitForPageLoaded(driver);
		String title = driver.getCurrentUrl();
		System.out.println(title);
		if(title.contains("epiuat"))
		{
			//WebElement chart_user = driver.findElement(By.xpath("//*[@id='globalHeaderNameMink']/span"));
			String text = objMCCHomePage.getChartuser_uat().getText();
			System.out.println("User Login :" + text);
			//WebElement iframe = driver.findElement(By.xpath("//iframe[@name='j_id0']"));
			driver.switchTo().frame(objMCCHomePage.getIframe_uat());

			switch(text) {
			case "Coder Automation_mcc":
				//WebElement element = driver.findElement(By.name("j_id0:j_id2:j_id3:j_id33"));
				Select drpdownvalue = new Select(objMCCHomePage.getCoder_uat());
				drpdownvalue.selectByVisibleText("MMC: L1");
				break;
				
			case "Auditor Automation_mcc":
				//WebElement usergroup = objMCCHomePage.getIframe_uat();
				//Utilities.clickonElement(usergroup, driver);
				//WebElement element2 = driver.findElement(By.name("j_id0:j_id2:j_id3:j_id33"));
				Select drpdownvalue2 = new Select(objMCCHomePage.getCoder_uat());
				drpdownvalue2.selectByVisibleText("MMC: L2");
				break;
			case "Master Auditor Automa...":
				
				Select drpdownvalue3 = new Select(objMCCHomePage.getCoder_uat());
				drpdownvalue3.selectByVisibleText("MMC: L3");
				break;
			}
			
			Utilities.clickonElement(objMCCHomePage.getGetchart_uat(),driver);
			
			/*WebElement getchart = driver.findElement(By.xpath("//input[@id='j_id0:j_id2:j_id3:j_id35']"));
			getchart.click();
			
			WebElement chart = driver.findElement(By.xpath("//tbody[@id='j_id0:j_id2:j_id3:out:tb']/tr[1]/td[2]/a"));
			chart.click();*/
			Utilities.clickonElement(objMCCHomePage.getSelectchart_uat(),driver);

			objMCCHomePage.switchToMccChart();
		}
		else {
		objMCCHomePage.switchToIframe();
		// WebElement element = driver.findElement(By.id("Login"));
		WebElement projectname = driver.findElement(By.xpath("//select[@name='j_id0:j_id2:j_id29:j_id31']"));
		projectname.click();
		
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(projectname).perform();
		projectname.click();
		Utilities.waitForPageLoaded(driver);
		objMCCHomePage.Click_getChart();
		System.out.println("string :" + string);
		Thread.sleep(2000);
		objMCCHomePage.openChartId(string2);
		System.out.println("string :" + string2);
		objMCCHomePage.switchToMccChart();
		//objMCCHomePage.Click_collapsibleArrow();
		}
	}
	

	@Then("verify collapsible header is hided")
	public void verify_collapsible_header_is_hided() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		 assertFalse(objMCCHomePage.verify_Flexfield());
		Thread.sleep(1000);
		//driver.navigate().refresh();

		/*Set<String> windows = driver.getWindowHandles();
		//System.out.println(windows.size());
		
		for (String window : windows) {
			driver.switchTo().window(window);
			String title1 =driver.getTitle();
			String currentUrl = driver.getCurrentUrl();
						
			if(currentUrl.contains("MedicalChartCoding")) {
				 driver.close();
				
			}
			if(currentUrl.contains("PDFViewer")) {
				
				driver.close();
				
			}
			driver.switchTo().window(winHandleBefore);
		}*/
		
		
	}

	@Then("close the old windows")
	public void close_the_windows() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			Set<String> windows = driver.getWindowHandles();
			System.out.println(windows.size());
			
			for (String window : windows) 
			{
				driver.switchTo().window(window);
				String title1 =driver.getTitle();
				String currentUrl = driver.getCurrentUrl();
							
				if(currentUrl.contains("MccAllocationPage") || currentUrl.contains("PDFViewer"))
				{
					 driver.close();
			                      // driver.switchTo().defaultContent();
				}
				if(currentUrl.contains("MedicalChartCoding"))
				{
					driver.switchTo().window(window);
				}
			}
			
		} /*catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println("I am in catch block");
			String windowId = driver.getWindowHandle();
			driver.switchTo().window(windowId);
		}*/
		finally {
			System.out.println("I am in final block");
			//String windowId = driver.getWindowHandle();
			//driver.switchTo().window(windowId);
			//driver.navigate().refresh();
			Thread.sleep(1000);
		}
		
	}
	
	@Given("Coder is in MCC Chart Queue and Get {string} Test Chart")
	public void coder_is_in_mcc_chart_queue_and_get_test_chart(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getMCC_chartQ().click();
		objMCCHomePage.Click_getChart();
		
		
		objMCCHomePage.getMPCtab().click();
		objMCCHomePage.openChartId(string);
		objMCCHomePage.switchToMccChart();
		//System.out.println("here");
	}

	@Given("Coder will open MCC Chart Queue and Get {string} Test Chart")

	public void coder_will_open_mcc_chart_queue_and_get_test_chart(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		/*
		 * driver.get(
		 * "https://episource--qa--c.sandbox.vf.force.com/apex/MedicalChartCoding?id=a1K6t0000006lXe"
		 * ); String parentwindow = driver.getWindowHandle(); String title =
		 * driver.getTitle(); System.out.println("parentwindow :" + parentwindow +
		 * "title:" + title); Thread.sleep(30000); Set<String> windows =
		 * driver.getWindowHandles(); ArrayList<String> win = new ArrayList<>(windows);
		 * System.out.println(win.size()); driver.switchTo().window(win.get(2));
		 */
		// objMCCHomePage.Click_collapsibleArrow();
		objMCCHomePage.getMCC_chartQ().click();
		objMCCHomePage.Click_getChart();
		objMCCHomePage.getMPCtab().click();
		objMCCHomePage.openChartId(string);
	}

	@Then("verify for {string} tab")
	public void verify_for_tab(String string) {
		// Write code here that turns the phrase above into concrete actions
		//objMCCHomePage.Click_opencollapsibleArrow();
		assertTrue(objMCCHomePage.verify_Customfield());
		assertEquals(objMCCHomePage.validate_Customfield(), string);

	}

	@Then("validate {string} tab")
	public void validate_tab(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(objMCCHomePage.verify_Demographics());
		assertEquals(objMCCHomePage.validate_Demographics(), string);

	}

	@Then("check for {string} tab")
	public void check_for_tab(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(objMCCHomePage.verify_ChartURL());
		assertEquals(objMCCHomePage.validate_ChartURL(), string);
	}

	@Then("view for {string} tab")
	public void view_for_tab(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(objMCCHomePage.verify_WorkFlow());
		assertEquals(objMCCHomePage.validate_WorkFlow(), string);

	}

	@Then("look for {string} tab")
	public void look_for_tab(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(objMCCHomePage.verify_Project());
		assertEquals(objMCCHomePage.validate_Project(), string);
	}

	@Then("validate for {string} tab")
	public void validate_for_tab(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(objMCCHomePage.verify_Supplemenal());
		assertEquals(objMCCHomePage.validate_supplemental(), string);

	}

	@Then("view {string} tab")
	public void view_tab(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(objMCCHomePage.verify_Dxcode());
		assertEquals(objMCCHomePage.validate_Dxcode(), string);

	}
	@Then("navigate to custom fields tab")
	public void navigate_to_custom_fields_tab() {
	    // Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getTab_Customfield().click();
	    
	}
	/***************************** ----- ************************************/




	/**	 * @throws InterruptedException ***************************************************************/

	@Then("enter text in {string} UMID field")
	public void enter_text_in_UMID_field(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		try {
			if(objMCCHomePage.getUMID().isDisplayed()) {
				try {
					objMCCHomePage.getCustom_textUMID().click();
				} catch (ElementClickInterceptedException e) {
					// TODO Auto-generated catch block
					objMCCHomePage.getCustom_textUMID().click();
				}
				objMCCHomePage.getFlex1_textbox().clear();
				objMCCHomePage.getFlex1_textbox().sendKeys(string);
				objMCCHomePage.getFlex1_textbox().sendKeys(Keys.TAB);	
			}
			
			else {
				//objMCCChartWorkflowTabPage.getWf_CustomFields().click();
				try {
					objMCCHomePage.getCustom_textUMID().click();
				} catch (ElementClickInterceptedException e) {
					// TODO Auto-generated catch block
					objMCCHomePage.getCustom_textUMID().click();
				}
				objMCCHomePage.getFlex1_textbox().clear();
				objMCCHomePage.getFlex1_textbox().sendKeys(string);
				objMCCHomePage.getFlex1_textbox().sendKeys(Keys.TAB);
			}
		}
		catch(NoSuchElementException e)
		{
			objMCCChartWorkflowTabPage.getWf_CustomFields().click();
			objMCCHomePage.getFlex1_textbox().sendKeys(string);
			objMCCHomePage.getFlex1_textbox().sendKeys(Keys.TAB);
		}

		 
	}
	
	@Then("enter values in {string} and {string} field")
	public void enter_values_in_and_field(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getFlex2_textbox().sendKeys(Keys.DELETE);
		objMCCHomePage.getFlex2_textbox().sendKeys(string);
		objMCCHomePage.getFlex2_textbox().sendKeys(Keys.TAB);
	  
		objMCCHomePage.getFlex3_textbox().sendKeys(Keys.DELETE);
		objMCCHomePage.getFlex3_textbox().sendKeys(string2);
		objMCCHomePage.getFlex3_textbox().sendKeys(Keys.TAB);
	}
	

	@When("user enters valid date, provider name and visit type")
	public void user_enters_valid_date_provider_name_and_visit_type() throws AWTException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			driver.navigate().refresh();	
			driver.switchTo().alert().accept();
			//objMCCChartWorkflowTabPage.getWf_CustomFields().click();
			objMCCChartQueuePage.getAddNewWncounter().click();
			}
			catch(Exception e) {
				
			driver.navigate().refresh();	

			//objMCCChartWorkflowTabPage.getWf_CustomFields().click();
			objMCCChartQueuePage.getAddNewWncounter().click();	
			}    	
		objMCCChartQueuePage.getDx_textDOSStart().click();
		Utilities.sendKeysUsingActions(objMCCChartQueuePage.getDx_textDOSStart(),"01/08/2020", driver);
		
	
		//objMCCChartQueuePage.getDx_date_yearArrow().click();
		//objMCCChartQueuePage.getDx_date_date8().click();
		
		//objMCCChartQueuePage.getDx_DOSstart().sendKeys("01/08/2021");
		
		WebElement dx_textproviderName = objMCCChartQueuePage.getDx_textproviderName();
		dx_textproviderName.click();
		
		//objMCCChartQueuePage.getDx_textproviderName().sendKeys("test");
		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Dummy')]"));
		try {
			WebElement element = elements.get(0);
			Utilities.clickonElement(element, driver);
		}

			catch(ElementNotInteractableException e)
			{
				
				WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
				wait1.until(ExpectedConditions.visibilityOf(elements.get(0)));
				WebElement element = elements.get(0);
				element.click();

			}
		//objMCCChartQueuePage.getDx_textproviderName().sendKeys(Keys.TAB);
		//objMCCChartQueuePage.getDx_textproviderName().sendKeys(Keys.TAB);
		
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
			Robot robot = new Robot(); 
		     
			robot.keyPress(KeyEvent.VK_Q); 
		    robot.keyRelease(KeyEvent.VK_Q); 

		}

		
		
	}
	
	
	@Then("select the {string} field")
	public void select_the_field(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		try {
			objMCCHomePage.getFlex4_dropdown().click();
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			Utilities.clickonElement(objMCCHomePage.getFlex4_dropdown(), driver);
		}
		WebElement ele = driver.findElement(By.xpath("//span[text()='NO']"));

		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		ele.click();
		//Thread.sleep(6000);
		/*List<WebElement> status = driver.findElements(By.xpath("//div[10]/div[1]/div[1]/ul/li/span"));
		System.out.println("size :"+status.size());
		for (int i=0;i<status.size();i++) {
			WebElement element = status.get(i);
     		String attribute=element.getText();
     		System.out.println("Values of dropdown :"+attribute);
     		if(attribute.equals("No")){
     			
     			element.click();
     			break;
     			
     		}
     		// assertEquals(attribute,select_values[i]);
			//System.out.println("Values of dropdown :"+attribute);
		}
		//objMCCHomePage.getFlex4_dropdownNO().click();*/
		
		
		 
	}

	@Then("clear all the values in custom fields tab")
	public void clear_all_the_values_in_custom_fields_tab() {
	    // Write code here that turns the phrase above into concrete actions
		
		objMCCHomePage.getFlex1_textbox().sendKeys(Keys.DELETE);
		objMCCHomePage.getFlex1_textbox().sendKeys(Keys.TAB);
		
		objMCCHomePage.getFlex2_textbox().sendKeys(Keys.DELETE);
		objMCCHomePage.getFlex2_textbox().sendKeys(Keys.TAB);
	  
		objMCCHomePage.getFlex3_textbox().sendKeys(Keys.DELETE);
		objMCCHomePage.getFlex3_textbox().sendKeys(Keys.TAB);
	    
	}
	
	@When("performs click action on save button")
	public void performs_click_action_on_save_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(objMCCHomePage.getSaveall())); 
	
		 //JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		// jse2.executeScript("arguments[0].scrollIntoView()", objMCCHomePage.getSaveall());
	
		 //jse2.executeScript("arguments[0].click();", objMCCHomePage.getSaveall());
		 objMCCHomePage.getSaveall().click();
		 
		 wait.until(ExpectedConditions.visibilityOf(objMCCHomePage.getOK())); 
		 //objMCCHomePage.getOK().click();
		//driver.switchTo().alert().accept();
		}
		catch(NoSuchElementException e) {
			 Thread.sleep(100);
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.visibilityOf(objMCCHomePage.getSaveall())); 
			 objMCCHomePage.getSaveall().click();
			
		}
	    
	}


	@Then("click save button")
	public void click_save_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		
		/*Utilities.waitForPageLoaded(driver);
		Utilities.waitForElementToBeDisplayed(driver,objMCCHomePage.getSaveall());
		objMCCHomePage.getSaveall().click();*/
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(objMCCHomePage.getSaveall())); 
	
	 
		 //WebElement myelement = driver.findElement(By.xpath(objMCCHomePage.getSaveall()));
		 JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		 jse2.executeScript("arguments[0].scrollIntoView()", objMCCHomePage.getSaveall());
		 Utilities.clickonElement(objMCCHomePage.getSaveall(),driver);
		 System.out.println("save clicked");
		 
		wait.until(ExpectedConditions.visibilityOf(objMCCHomePage.getOK())); 
		objMCCHomePage.getOK().click();
		//driver.switchTo().alert().accept();
		Thread.sleep(300);
		
		//String text = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(objMCCHomePage.getFlex_errorMsg())).getText();
		
	}

	@Then("verify for success message")
	public void verify_for_success_message() throws InterruptedException {
		
		Utilities.waitForPageLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(objMCCHomePage.getSave_msg()));
		String text = objMCCHomePage.getSave_msg().getText();
		//System.out.println(text);
		//String text= objMCCChartQueuePage.getDx_duplicateDxcode().getText();
		//Thread.sleep(1000);
		 assertEquals(text, "Saved Successfully!");
		System.out.println("verified save message");
		Utilities.waitForPageLoaded(driver);
		wait.until(ExpectedConditions.invisibilityOf(objMCCHomePage.getSave_msg())); 

	
	}
	
	@Then("clear the values in {string} field")
	public void clear_the_values_in_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
		objMCCHomePage.getFlex2_textbox().sendKeys(Keys.DELETE);
		objMCCHomePage.getFlex2_textbox().sendKeys(Keys.TAB);
	    
	}
	@Then("verify for mandatory validation error message")
	public void verify_for_mandatory_validation_error_message() {
	    // Write code here that turns the phrase above into concrete actions
		Utilities.waitForElementToBeDisplayed(driver,objMCCHomePage.getFlex_errorMsg());
		String text = objMCCHomePage.getFlex_errorMsg().getText();
		System.out.println(text);
		 assertEquals(text, "No ICDs field should be TRUE, if there are no valid Dx Codes");
		
	   
	}
	
	@Then("verify for {string} text is displayed")
	public void verify_for_text_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		// assertTrue(objMCCHomePage.getChartId().isDisplayed());
		String text = objMCCHomePage.getChartId().getText();
		System.out.println("Text are :"+ text);
		 assertEquals("Chart details is displayed",string,text);
		
		String[] chartdetails=text.split("  ");
		int length = chartdetails.length;
		System.out.println(length);
		for(int i=0;i<length;i++) {

			//System.out.println("chardetail "+ chartdetails[i]);
			
			String word = chartdetails[i];
			System.out.println("split" + word);
			
			String[] splitt = word.split(":");
			int length2 = splitt.length;
			for(int j=0;j<length2;j++) {
			//System.out.println(j);
			System.out.println("split2 "+ splitt[j]);
			System.out.println(text);
			if(j==0) {
			 assertTrue(text.contains(splitt[j]));
			}else {
				 assertFalse(splitt[j].isEmpty());
			}
			
			}
		}
	}
	
	@Then("verify for {string} field is displayed")
	public void verify_for_field_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getChartId().isDisplayed());
		String text = objMCCHomePage.getChartId().getText();
		System.out.println("Text are :"+ text);
		
			
		String[] chartdetails=text.split("  ");
		int length = chartdetails.length;
		System.out.println(length);
		for(int i=0;i<length;i++) {

			System.out.println("chardetail "+ chartdetails[i]);
			
			String word = chartdetails[i];
				
			System.out.println("split" + word);
			
			String[] splitt = word.split(":");
			int length2 = splitt.length;
			for(int j=0;j<length2;j++) {
			//System.out.println(j);
			System.out.println("split2"+splitt[j]);
			System.out.println(text);
			 assertTrue(text.contains(splitt[j]));
			}
		}
		
		// assertEquals(objMCCHomePage.getChartId().getText(), string);
		
	}
	@Then("verify for Chart Id field value {string}")
	public void verify_for_chart_id_field_value(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getText_chartid().isDisplayed());
		 assertTrue(objMCCHomePage.getText_chartid().getText()!=null);
	}
	@Then("verify for {string} field is diplayed")
	public void verify_for_field_is_diplayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getPatientName().isDisplayed());
		 assertEquals(objMCCHomePage.getPatientName().getText(), string);
	}
	@Then("verify for the patient name field  contains value")
	public void verify_for_the_patient_name_field_contains_value() {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getText_patientname().isDisplayed());
		 assertTrue(objMCCHomePage.getText_patientname().getText()!=null);
	}
	@Then("verify for DOB field contains value")
	public void verify_for_dob_field_contains_value() {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getText_chartid().isDisplayed());
		 assertTrue(objMCCHomePage.getText_chartid().getText()!=null);
	}
	@Then("verify for {string} field is getting displayed")
	public void verify_for_field_is_getting_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getDOB().isDisplayed());
		 assertEquals(objMCCHomePage.getDOB().getText(), string);
		}
	@Then("verify for {string} field is displayed  properly")
	public void verify_for_field_is_displayed_properly(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getGender().isDisplayed());
		 assertEquals(objMCCHomePage.getGender().getText(), string);
	}
	@Then("validate that {string} field is displayed")
	public void validate_that_field_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getText_totalpages().isDisplayed());
		 assertEquals(objMCCHomePage.getText_totalpages().getText(), string);
	}
	
	@Then("verify for Gender field contains value")
	public void verify_for_gender_field_contains_value() {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getText_Gender().isDisplayed());
		 assertTrue(objMCCHomePage.getText_Gender().getText()!=null);
	}
	@Then("verify for Total Pages field contains value")
	public void verify_for_total_pages_field_contains_value() {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(objMCCHomePage.getText_chartid().isDisplayed());
		 assertTrue(objMCCHomePage.getText_chartid().getText()!=null);

	}


}
