package pageobjects;

import java.io.BufferedReader;
//mport java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.runners.JavaScriptRunner;
//import org.sikuli.script.support.IScriptRunner.Options;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;

import io.github.sukgu.support.ElementFieldDecorator;
//import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class MCCHomePage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='phSearchButton']")
	private WebElement btnSearchHome;

	@FindBy(xpath = "//input[@id='phSearchInput']")
	private WebElement txtSearch;

	@FindBy(xpath = "//*[@id=\"globalHeaderNameMink\"]")
	private WebElement drpdwnHeadername;

	@FindBy(xpath = "//a[@title='Developer Console (New Window)']")
	private WebElement menuDeveloperConsole;

	@FindBy(xpath = "//div/textarea")
	private WebElement apexTextArea;
	
	@FindBy(xpath="//span[contains(@id,'button-1188-btnInnerEl')]")
	private WebElement Execute;

	public WebElement getExecute() {
		return Execute;
	}

	@FindBy(xpath = "//div[@id='chatterTab']//a[@id='moderatorMutton']")
	private WebElement btnmoderator;

	@FindBy(xpath = "//a[@id='USER_DETAIL']")
	private WebElement menuUserDetail;

	@FindBy(xpath = "//td[@id=\"topButtonRow\"]/input[@name='login']")
	private WebElement btnlogin;

	//@FindBy(xpath = "//span[@id='button-1187-btnInnerEl']")
	@FindBy(xpath="//span[contains(@id,'button-11')]")
	private WebElement btnExecute;

	@FindBy(xpath = "//span[@id='userNavLabel']")
	private WebElement menuUserNavigation;

	@FindBy(xpath = "//div[@id=\"userNav-menuItems\"]/a[@title='Logout']")
	private WebElement menuLogOut;

	@FindBy(xpath = "//a[@title='MCC Chart Queue Tab']")
	private WebElement MCC_chq;
	
	@FindBy(xpath="//li[@id='MoreTabs_Tab']")
	private WebElement tabarrow;
	
	@FindBy(xpath="//li[@id='AllTab_Tab']/a")
	private WebElement homepage_plusicon;
	
	@FindBy(xpath="//a[@class='listRelatedObject Custom9Block title']/img[@title='Chart Mover - Beta']")
	private WebElement homepage_chartMoverBeta;
	
	@FindBy(xpath="//input[@id='input-3']")
	private WebElement Chartbeta_chartid;
	
	@FindBy(xpath="//button[@title='Search the Chart']")
	private WebElement Chartbeta_search;
	
	@FindBy(xpath="//label[@id='check-button-label-1-52']")
	private WebElement Chartbeta_selectchart;
	
	@FindBy(xpath="//button[text()='Update Status']")
	private WebElement Update_status;
	
	@FindBy(xpath="//select[@name='selectNewStatusOption1']")
	private WebElement Chartbeta_selectstatus;
	
	@FindBy(xpath="//span[text()='Clear Coder Name & Timestamp']")
	private WebElement Chartbeta_p1_Raw1;
	
	@FindBy(xpath="//span[text()='Clear Auditor Name & Timestamp']")
	private WebElement Chartbeta_p2_Autimestamp;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement chartbeta_Update_final;
	
	@FindBy(xpath="//button[text()='Confirm']")
	private WebElement chartbeta_Update_Confirm;
	
	public WebElement getChartbeta_Update_Confirm() {
		return chartbeta_Update_Confirm;
	}

	public WebElement getChartbeta_Update_final() {
		return chartbeta_Update_final;
	}

	public WebElement getChartbeta_update() {
		return Chartbeta_update;
	}

	public WebElement getChartbeta_p2_Autimestamp() {
		return Chartbeta_p2_Autimestamp;
	}

	@FindBy(xpath="//span[text()='Clear Master Auditor Name & Timestamp']")
	private WebElement Chartbeta_p3_MAtimestamp;
	
	@FindBy(xpath="//span[text()='Clear Dx Data']")
	private WebElement Chartbeta_p3_DXdata;
	
	@FindBy(xpath="//button[@title='Update the changes']")
	private WebElement Chartbeta_update;
	
	
	public WebElement getChartbeta_p1_Raw1() {
		return Chartbeta_p1_Raw1;
	}

	public WebElement getChartbeta_p3_MAtimestamp() {
		return Chartbeta_p3_MAtimestamp;
	}

	public WebElement getChartbeta_p3_DXdata() {
		return Chartbeta_p3_DXdata;
	}

	public WebElement getChartbeta_selectstatus() {
		return Chartbeta_selectstatus;
	}

	public WebElement getUpdate_status() {
		return Update_status;
	}

	public WebElement getChartbeta_selectchart() {
		return Chartbeta_selectchart;
	}

	public WebElement getChartbeta_search() {
		return Chartbeta_search;
	}

	public WebElement getChartbeta_chartid() {
		return Chartbeta_chartid;
	}

	public WebElement getHomepage_chartMoverBeta() {
		return homepage_chartMoverBeta;
	}

	public WebElement getHomepage_plusicon() {
		return homepage_plusicon;
	}

	@FindBy(xpath="//div[@id='userNavButton']/span")
	private WebElement Logout_arrow_qa;
	
	@FindBy(xpath="//a[@id='globalHeaderNameMink']/b")
	private WebElement Logout_arrow_uat;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement Logout;
	
	@FindBy(xpath="//a[text()='Chart Mover (Single)']")
	private WebElement Chartmover;
	
	@FindBy(xpath="//h2[@class='mainTitle']")
	private WebElement Chartheader;
	
	@FindBy(xpath="//select[@id='j_id0:theForm:searchSection:clientSelectList']")
	private WebElement dropdown_client;
	
	@FindBy(xpath="//option[text()='QA Automation']")
	private WebElement dropdownclient_Saas;
	
	@FindBy(xpath="//select[@name='j_id0:theForm:searchSection:j_id37']")
	private WebElement dropdown_project;
	
	@FindBy(xpath="//option[text()='QA Automation']")
	private WebElement dropdownproject_epicoderdemo;
	
	@FindBy(xpath="//input[@placeholder='Chart Id']")
	private WebElement input_chartid;
	
	@FindBy(xpath="//input[@value='Search for Chart']")
	private WebElement button_searchforchart;
	
	@FindBy(xpath="//select[@id='j_id0:theForm:resultsSection:j_id46:0:j_id49']")
	private WebElement dropdown_status;
	
	@FindBy(xpath="//input[@value='Update Chart']")
	private WebElement button_updatechart;
	
	public WebElement getButton_updatechart() {
		return button_updatechart;
	}

	public WebElement getDropdown_status() {
		return dropdown_status;
	}

	public WebElement getButton_searchforchart() {
		return button_searchforchart;
	}

	public WebElement getInput_chartid() {
		return input_chartid;
	}

	public WebElement getDropdown_project() {
		return dropdown_project;
	}

	public WebElement getDropdownproject_epicoderdemo(String text) {
		WebElement project_value = driver.findElement(By.xpath("//select[contains(@name,'j_id0:theForm:searchSection:j_id')]/option[2]"));
		return project_value;
		/*List<WebElement> findElements = driver.findElements(By.xpath("//option[text()='" + text +"']"));
		Select drpCountry = new Select(driver.findElement(By.xpath("//option[text()='" + text +"']")));
		drpCountry.selectByVisibleText("QA Automation");
		//dropdownproject_epicoderdemo=findElements.get(1);
		return dropdownproject_epicoderdemo;*/
	}

	public WebElement getDropdownclient_Saas(String text) {
		List<WebElement> findElements = driver.findElements(By.xpath("//option[text()='"+  text + "']"));
		dropdownclient_Saas=findElements.get(0);
		return dropdownclient_Saas;
	}

	public WebElement getDropdown_client() {
		return dropdown_client;
	}

	public WebElement getChartmover() {
		return Chartmover;
	}

	public WebElement getChartheader() {
		return Chartheader;
	}
	
	public WebElement getLogout_arrow_qa()
	{
		return Logout_arrow_qa;
	}
	
	public WebElement getLogout_arrow_uat() {
		return Logout_arrow_uat;
	}
	public WebElement getLogout() {
		return Logout;
	}

	@FindBy(xpath = "//input[@value='Get Chart']")
	private WebElement getChart;

	@FindBy(xpath = "//tbody[@id='j_id0:j_id2:j_id38:out:tb']//tr//td[2]/a")
	private WebElement chart;
	
	@FindBy(xpath = "//input[@id='j_id0:j_id2:j_id3:j_id35']")
	private WebElement getchart_uat;
	
	public WebElement getGetChart() {
		return getChart;
	}

	public WebElement getGetchart_uat() {
		return getchart_uat;
	}

	public WebElement getSelectchart_uat() {
		return selectchart_uat;
	}

	@FindBy(xpath = "//tbody[@id='j_id0:j_id2:j_id3:out:tb']/tr[1]/td[2]/a")
	private WebElement selectchart_uat;
	
	@FindBy(xpath="//div[contains(text(),'UMID')]")
	private WebElement Flexfield1;
	
	@FindBy(xpath="//i[@class='el-collapse-item__arrow el-icon-arrow-right is-active']")
	private WebElement collapsibleArrow;
	
	@FindBy(xpath="//i[@class='el-collapse-item__arrow el-icon-arrow-right']")
	private WebElement opencollapsibleArrow;
	
	@FindBy(xpath="//div[@id='tab-0' and text()='Custom Fields']")
	private WebElement tab_Customfield;
	
	@FindBy(xpath="//div[@id='tab-1' and text()='Demographics']")
	private WebElement tab_Demographics;
	
	@FindBy(xpath="//div[@id='tab-2' and text()='Chart URL']")
	private WebElement tab_ChartURL;
	
	@FindBy(xpath="//span[@title='workflow']")
	private WebElement tab_WorkFlow;
	
	@FindBy(xpath="//div[@title='Project Details']")
	private WebElement tab_Project;
	
	@FindBy(xpath="//div[@id='tab-5' and text()='Supplemental']")
	private WebElement tab_supplemental;
	
	@FindBy(xpath="//div[@id='tab-6' and text()='Dx Codes from Other Charts']")
	private WebElement tab_Dxcode;
	
	@FindBy(xpath = "//a[@title=\"MCC Chart Queue Tab\"]")
	private WebElement MCC_chartQ;
	
	@FindBy(xpath="//td[text()='My Pending charts']")
	private WebElement MPCtab;
	
	//@FindBy(xpath="//div[contains(text(),'UMID')]")
	@FindBy(xpath="//div[contains(text(),'UMID')]")
	private WebElement UMID;
	
	@FindBy(xpath="//div[contains(text(),'UMID')]/parent::div/following-sibling::div/div/div/input")
	private WebElement custom_textUMID;
	
	@FindBy(xpath="//div[contains(text(),'Coder Name')]/parent::div/following-sibling::div/div/div/input")
	private WebElement custom_textCoderName;
	
	@FindBy(xpath="//div[contains(text(),'Coder Credential')]/parent::div/following-sibling::div/div/div/input")
	private WebElement custom_CoderCredential;
	
	@FindBy(xpath="//div[contains(text(),'Provider Education Required')]/parent::div/following-sibling::div/div/div/div/input")
	private WebElement custom_textProviderEducationRequired;
	
	@FindBy(xpath="//div[contains(text(),'Education Description')]/parent::div/following-sibling::div/div/div/input")
	private WebElement custom_textEducationDescription;
				
	public WebElement getCustom_textUMID() {
		return custom_textUMID;
	}
	public WebElement getCustom_textCoderName() {
		return custom_textCoderName;
	}
	public WebElement getCustom_CoderCredential() {
		return custom_CoderCredential;
	}
	public WebElement getCustom_textProviderEducationRequired() {
		return custom_textProviderEducationRequired;
	}
	public WebElement getCustom_textEducationDescription() {
		return custom_textEducationDescription;
	}

	@FindBy(xpath="//div[contains(text(),'Coder Name')]")
	private WebElement CoderName;
	
	@FindBy(xpath="//div[contains(text(),'Coder Name')]/..//following-sibling::div[1]/div/div/input")
	private WebElement text_CoderName;
	
	

	@FindBy(xpath="//div[contains(text(),'Coder Credential')]")
	private WebElement CoderCredential;
	
	@FindBy(xpath="//div[contains(text(),'Provider Education Required')]")
	private WebElement ProviderEducationRequired;
	
	@FindBy(xpath="//div[@class='workflowtab']/ancestor::div[@style=\"position: relative; top: 10px;\"]/div/div/span/span/div[2]/div/div/input")
	private WebElement flex1_textbox;
	
	@FindBy(xpath="//div[@project='[object Object]']/div/div/div//div/div/div[2]/span/span/div[2]/div/div/div")
	private WebElement flex4_dropdown;
	
	@FindBy(xpath="//li[@class='el-select-dropdown__item selected hover']/span[text()='NO']")
	private WebElement flex4_dropdownNO;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']")
	private WebElement chartId;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']//span[1]")
	private WebElement text_chartid;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']/text()[2]")
	private WebElement PatientName;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']//span[2]")
	private WebElement text_patientname;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']/text()[3]")
	private WebElement DOB;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']//span[3]")
	private WebElement text_DOB;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']/text()[4]")
	private WebElement Gender;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']//span[4]")
	private WebElement text_Gender;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']/text()[5]")
	private WebElement Totalpages;
	
	@FindBy(xpath="//span[@class='coding-ui-chart-title']//span[5]")
	private WebElement text_totalpages;
	
	@FindBy(xpath="//*[@id='globalHeaderNameMink']/span")
	private WebElement chartuser_uat;
	
	@FindBy(name="j_id0:j_id2:j_id3:j_id33")
	private WebElement coder_uat;
	
	@FindBy(xpath="//input[@id='j_id0:j_id2:j_id3:j_id35']")
	private WebElement getchart;
	
	public WebElement getCoder_uat() {
		return coder_uat;
	}

	public WebElement getGetchart() {
		return getchart;
	}

	@FindBy(xpath="//iframe[@name='j_id0']")
	private WebElement iframe_uat;
	
	public WebElement getIframe_uat() {
		return iframe_uat;
	}

	public WebElement getTabarrow() {
		return tabarrow;
	}

	public WebElement getDropdownclient_Saas() {
		return dropdownclient_Saas;
	}

	public WebElement getDropdownproject_epicoderdemo() {
		return dropdownproject_epicoderdemo;
	}

	public WebElement getChartuser_uat() {
		return chartuser_uat;
	}

	public WebElement getText_totalpages() {
		return text_totalpages;
	}

	public WebElement getChartId() {
		return chartId;
	}

	public WebElement getText_chartid() {
		return text_chartid;
	}

	public WebElement getPatientName() {
		return PatientName;
	}

	public WebElement getText_patientname() {
		return text_patientname;
	}

	public WebElement getDOB() {
		return DOB;
	}

	public WebElement getText_DOB() {
		return text_DOB;
	}

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getText_Gender() {
		return text_Gender;
	}

	public WebElement getTotalpages() {
		return Totalpages;
	}

	public WebElement getText_Totalpages() {
		return text_Totalpages;
	}

	@FindBy(xpath="//span[@class='coding-ui-chart-title']//span[4]")
	private WebElement text_Totalpages;

	public WebElement getFlex4_dropdown() {
		return flex4_dropdown;
	}
	public WebElement getFlex4_dropdownNO() {
		return flex4_dropdownNO;
	}
	public WebElement getFlex1_textbox() {
		return flex1_textbox;
	}
	public WebElement checkbox() {
		return checkbox;
	}


	public WebElement getFlex2_textbox() {
		return flex2_textbox;
	}

	@FindBy(xpath="//div[@class='workflowtab']/ancestor::div[@style='position: relative; top: 10px;']/div/div/span/span[2]/div[2]/div/div/input")
	private WebElement flex2_textbox;
	
	@FindBy(xpath="//div[@class='workflowtab']/ancestor::div[@style='position: relative; top: 10px;']/div/div/span/span[3]/div[2]/div/div/input")
	private WebElement flex3_textbox;
	
	public WebElement getFlex3_textbox() {
		return flex3_textbox;
	}

	@FindBy(xpath="//span[@class='el-checkbox__inner']")
	private WebElement checkbox;
	
	@FindBy(xpath="//div[@id=\"divDxDetail\"]//following-sibling::div[1]//div//following-sibling::div[1]/button[2]")
	private WebElement saveall;
	
	//span[contains(text(),'Add New Encounter')]/..//following-sibling::button[1]/span[contains(text(),'Save')]
	//div[@id="divDxDetail"]//following-sibling::div[1]//div//following-sibling::div[1]/button[2]
	//div[@id='divDxDetail']/div[2]/div/div[2]/button[2]/span
	@FindBy(xpath="//*[@id='divDxDetail']/div[8]/div[2]/button[2]/span")
	private WebElement save;
	
	public WebElement getOpencollapsibleArrow() {
		return opencollapsibleArrow;
	}
	public WebElement getCheckbox() {
		return checkbox;
	}
	public WebElement getSave() {
		return save;
	}
	public WebElement getCustom_EducationDescription() {
		return custom_EducationDescription;
	}

	@FindBy(xpath="//span[contains(text(),'OK')]/ancestor::button[@class='el-button el-button--default el-button--small el-button--primary ']")
	private WebElement OK;
	
	@FindBy(xpath="//span[contains(text(),'OK')]/ancestor::button[@class='el-button el-button--default el-button--small el-button--primary ']")
	private WebElement Auditor_ok;

	public WebElement getAuditor_ok() {
		return Auditor_ok;
	}

	//@FindBy(xpath="//p[@class='el-message__content' and text()='Saved Successfully!']")
	@FindBy(xpath="//div[@role='alert' and @class='el-message el-message--success']/p")
	private WebElement save_msg;
	
	@FindBy(xpath="//p[contains(text(),'Please review and fix the chart errors!')]")
	private WebElement flex_errorMsg;
	
	@FindBy(xpath="//div[@title='Chart Details']")
	private WebElement tab_chartdetails;
	
	
	
	public WebElement getTab_chartdetails() {
		return tab_chartdetails;
	}

	public WebElement getFlex_errorMsg() {
		return flex_errorMsg;
	}
	public WebElement getSave_msg() {
		return save_msg;
	}
	public WebElement getOK() {
		return OK;
	}
	public WebElement getSaveall() {
		
		return saveall;
	}
	public WebDriver getDriver() {
		return driver;
	}



	public WebElement getBtnSearchHome() {
		return btnSearchHome;
	}



	public WebElement getTxtSearch() {
		return txtSearch;
	}



	public WebElement getDrpdwnHeadername() {
		return drpdwnHeadername;
	}



	public WebElement getMenuDeveloperConsole() {
		return menuDeveloperConsole;
	}



	public WebElement getApexTextArea() {
		return apexTextArea;
	}



	public WebElement getBtnmoderator() {
		return btnmoderator;
	}



	public WebElement getMenuUserDetail() {
		return menuUserDetail;
	}



	public WebElement getBtnlogin() {
		return btnlogin;
	}



	public WebElement getBtnExecute() {
		return btnExecute;
	}



	public WebElement getMenuUserNavigation() {
		return menuUserNavigation;
	}



	public WebElement getMenuLogOut() {
		return menuLogOut;
	}



	public WebElement getMCC_chq() {
		return MCC_chq;
	}

	public WebElement getChart() {
		return chart;
	}



	public WebElement getFlexfield1() {
		return Flexfield1;
	}



	public WebElement getCollapsibleArrow() {
		return collapsibleArrow;
	}



	public WebElement getTab_Customfield() {
		return tab_Customfield;
	}



	public WebElement getTab_Demographics() {
		return tab_Demographics;
	}



	public WebElement getTab_ChartURL() {
		return tab_ChartURL;
	}



	public WebElement getTab_WorkFlow() {
		return tab_WorkFlow;
	}



	public WebElement getTab_Project() {
		return tab_Project;
	}



	public WebElement getTab_supplemental() {
		return tab_supplemental;
	}



	public WebElement getTab_Dxcode() {
		return tab_Dxcode;
	}



	public WebElement getUMID() {
		return UMID;
	}



	public WebElement getCoderName() {
		return CoderName;
	}



	public WebElement getCoderCredential() {
		return CoderCredential;
	}



	public WebElement getProviderEducationRequired() {
		return ProviderEducationRequired;
	}



	public WebElement getEducationDescription() {
		return custom_EducationDescription;
	}

	@FindBy(xpath="//div[contains(text(),'Education Description')]")
	private WebElement custom_EducationDescription;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	private WebElement wf_savebutton;

	//public String originalHandle1;
	
	
	
	public WebElement getWf_savebutton() {
		return wf_savebutton;
	}
	public void switchMccChart() throws InterruptedException
	{
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		
		for (String window : windows) {
			
			driver.switchTo().window(window);

			//System.out.println(" Window Id :" + window);
			String title1 =driver.getTitle();
			//System.out.println("Title :"+title1);
			String currentUrl = driver.getCurrentUrl();
			//System.out.println("URL :"+ currentUrl);*/
			
			if(currentUrl.contains("MedicalChartCoding")) {
				 driver.switchTo().window(window);
				break;
				
			}
			
		}
		Thread.sleep(1000);
		
		
	}
	
	public void switchToMccChart() throws InterruptedException
	{
		
		Thread.sleep(20000);
		/*String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String window : windowHandles)
		{
			if(window != windowHandle) {
				driver.switchTo().window(window);
				//String title = driver.getTitle();
				String currentUrl = driver.getCurrentUrl();
				if(currentUrl.contains("PDFViewer")) {
					//driver.switchTo().window(window);
					driver.close();
					
				}
				/*if(title!="Charts ~ salesforce.com ~ Salesforce - Unlimited Edition")
				{
					driver.close();
				}*/
				
		Utilities.waitForPageLoaded(driver);
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		
		for (String window : windows) {
			
			driver.switchTo().window(window);

			//System.out.println(" Window Id :" + window);
			String title1 =driver.getTitle();
			//System.out.println("Title :"+title1);
			String currentUrl = driver.getCurrentUrl();
			//System.out.println("URL :"+ currentUrl);*/
			
			if(currentUrl.contains("MedicalChartCoding")) {
				 driver.switchTo().window(window);
				break;
				
			}
			
		}
		Thread.sleep(1000);
		//Set<String> windows = driver.getWindowHandles();
		/*ArrayList<String> win = new ArrayList<>(windows);
		System.out.println(win.size());
		driver.switchTo().window(win.get(2));*/
		
		
		
	
	}
	
	public void switchToMccAllocation() throws InterruptedException
	{
		
						
		//Utilities.waitForPageLoaded(driver);
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());
		
		for (String window : windows) {
			
			driver.switchTo().window(window);

			//System.out.println(" Window Id :" + window);
			String title1 =driver.getTitle();
			//System.out.println("Title :"+title1);
			String currentUrl = driver.getCurrentUrl();
			//System.out.println("URL :"+ currentUrl);*/
			
			if(currentUrl.contains("MccAllocation")) {
				 driver.switchTo().window(window);
				break;
				
			}
			
		}
		
	}
	
	
	public void openChartId(String text) throws InterruptedException {
		//Utilities.waitForPageLoaded(driver);
		switchDefaultContent();
		switchToIframe();
		//switchToNestedIframe();
		WebElement element = driver.findElement(By.xpath("//td/a[contains(text(), '"+ text +"')]"));
		Utilities.clickonElement(element, driver);
		switchDefaultContent();
		//Utilities.waitForPageLoaded(driver);
		//Utilities.waitForNumberOfPagesAvailable(driver, 3);
	}
	
	
	public WebElement getMPCtab() {
		return MPCtab;
	}


	public WebElement getMCC_chartQ() {
		return MCC_chartQ;
	}

	
	public boolean verify_ChartURL()
	{
		tab_ChartURL.click();
		boolean ChartURL = tab_ChartURL.isDisplayed();
		return ChartURL;
	}
	
	public String validate_ChartURL() {
		String actualtext=tab_ChartURL.getText();
		return actualtext;
		
	}
	
	public String validate_WorkFlow() {
		String actualtext=tab_WorkFlow.getText();
		return actualtext;
		}
	public String validate_Project() {
		String actualtext=tab_Project.getText();
		return actualtext;
		}
	public String validate_supplemental() {
		String actualtext=tab_supplemental.getText();
		return actualtext;
		}
	public String validate_Dxcode() {
		String actualtext=tab_Dxcode.getText();
		return actualtext;
		}
	
	
	public boolean verify_WorkFlow()
	{
		tab_WorkFlow.click();
		boolean testtab = tab_WorkFlow.isDisplayed();
		return testtab;
	}
	
	public boolean verify_Project()
	{
		tab_Project.click();
		boolean testtab = tab_Project.isDisplayed();
		return testtab;
	}
	
	public boolean verify_Supplemenal()
	{
		tab_supplemental.click();
		boolean testtab = tab_supplemental.isDisplayed();
		return testtab;
	}
	
	public boolean verify_Dxcode()
	{
		tab_Dxcode.click();
		boolean testtab = tab_Dxcode.isDisplayed();
		return testtab;
	}
	
	public boolean verify_Demographics()
	{
		tab_Demographics.click();
		boolean demographics = tab_Demographics.isDisplayed();
		return demographics;
	}
	
	public String validate_Demographics() {
		
		String actualtext = tab_Demographics.getText();
		return actualtext;
	}
	
	
	public boolean verify_Customfield()
	{
		tab_Customfield.click();
		boolean customfield = tab_Customfield.isDisplayed();
		return customfield;
	}
	
	public String validate_Customfield()
	{
		String actualtext = tab_Customfield.getText();
		return actualtext;
	}
	
	public boolean verify_Flexfield() {
	
		boolean displayed = Flexfield1.isDisplayed();
		System.out.println("displayed =" + displayed);
		return displayed;
	}
	public void Click_chart() throws InterruptedException

	{
		
		//switchToIframe();
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//tbody[@id='j_id0:j_id2:j_id38:out:tb']//tr//td[2]/a"));
		element.click();
		// chart.click();
		switchDefaultContent();
		String parentwindow = driver.getWindowHandle();
		String title = driver.getTitle();
		System.out.println("parentwindow :" + parentwindow +"title:"+ title);
		Thread.sleep(30000);
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			
			driver.switchTo().window(window);

			System.out.println(" Window Id :" + window);
			String title1 =driver.getTitle();
			System.out.println("Title :"+title1);
			String currentUrl = driver.getCurrentUrl();
			System.out.println("URL :"+ currentUrl);
		}
		LinkedList<String> win = new LinkedList<>(windows);
		System.out.println(win.size());
		driver.switchTo().window(win.get(2));
	
		//System.out.println(driver.getTitle());
		//WebElement downarrow = driver.findElement(By.xpath("//i[@class='el-collapse-item__arrow el-icon-arrow-right is-active']"));
        
	}
	
	public void Click_collapsibleArrow() {
		collapsibleArrow.click();
	}
	
	public void Click_opencollapsibleArrow() {
		opencollapsibleArrow.click();
	}


	public void Click_getChart() throws InterruptedException {

		Utilities.waitForPageLoaded(driver);
		WebElement element = driver.findElement(By.xpath("//input[@value='Get Chart']"));
		//switchToIframe();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@value='Get Chart']"))));
		Utilities.clickonElement(element, driver);
		// getChart.click();
		switchDefaultContent();
	}

	public void Click_MCC_chq() throws InterruptedException {
		//tabarrow.click();
		MCC_chq.click();
	}

	public void switchDefaultContent()  {
		driver.switchTo().defaultContent();
		
	}

	public void switchToIframe() {
		//List<WebElement> iframes = driver.findElements(By.xpath("//iframe[contains(@name,'j_id')]"));
		//System.out.println("size "+iframes.size());
		WebElement element = driver.findElement(By.xpath("//iframe[contains(@name,'j_id')]"));
		driver.switchTo().frame(element);
		//driver.switchTo().frame(iframes.get(iframes.size()-1));
	}
	
	public void switchToIframe7() {
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe[contains(@name,'j_id')]"));
		driver.switchTo().frame(iframes.get(iframes.size() - 1));
	}

	public MCCHomePage(WebDriver driver) {
		this.driver = driver;
		ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));
		PageFactory.initElements(decorator, this);
	}

	public boolean isLoggedtoMCCSalesforce() {
		return btnSearchHome.isDisplayed();
	}
	
	

	public void setSearchAndSubmit(String text) {
		Utilities.waitForPageLoaded(driver);
		openSearchBar();
		txtSearch.sendKeys(text);
		txtSearch.sendKeys(Keys.ENTER);
	}

	public void searchInMCCSalesforce(String text) {
		this.setSearchAndSubmit(text);
		Utilities.waitForPageLoaded(driver);
		try {
			driver.findElement(By.cssSelector("a[title='" + text + "']")).click();
		} catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
			driver.findElement(By.xpath("//a[text()='" + text + "']")).click();
		}

	}

	public void openSearchBar() {
		int count = 3;
		while (count > 0) {

			try {
				btnSearchHome.click();
//				Utilities.waitForElementToBeDisplayed(driver, txtSearch, 3);
				Utilities.waitForElementToBeDisplayed(driver, txtSearch);
				break;
			} catch (NoSuchElementException | TimeoutException e) {
				count--;

			}

		}
	}

//	public boolean isUserDetailsButtonDisplayed() {
//		boolean flag = false;
//		try {
//			if(btnmoderator.isDisplayed()) {
//				btnmoderator.click();
//				if(btnUserDetail.isDisplayed()) {
//					flag = true;
//				}
//			} 
//		}catch (NoSuchElementException | StaleElementReferenceException e) {
//			flag = false;	
//		}
//		return flag;
//	}

	public void isUserDetailsButtonDisplayed() {
		Utilities.waitForPageLoaded(driver);
		Actions action = new Actions(driver);
		Utilities.waitForElementToBeDisplayed(driver, btnmoderator);
		action.moveToElement(btnmoderator).click().perform();
		menuUserDetail.click();
	}

	public void ClickLoginButtoninUserDetail() {
		Utilities.waitForPageLoaded(driver);
		Utilities.waitForElementToBeDisplayed(driver, btnlogin);
		btnlogin.click();
	}

	public void ClickOnUserNavigation() {
		Utilities.waitForPageLoaded(driver);
		menuUserNavigation.click();
	}

	public void ClickOnUserLogOutMenu() {
		Utilities.waitForElementToBeDisplayed(driver, menuLogOut);
		menuLogOut.click();
	}

	public void ClickProfileDropdown() {
		drpdwnHeadername.click();
	}

	public boolean isDeveloperConsoleDisplayed() {
		return menuDeveloperConsole.isDisplayed();
	}

	public void ClickOnDeveloperConsole() {
		menuDeveloperConsole.click();
	}
	
	public WebElement getText_CoderName() {
		return text_CoderName;
	}

	public void switchToDevConsole() {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("apex/debug/ApexCSIPage")) {
				System.out.println("Page title is : " + driver.getTitle());
				break;
			}
		}
		driver.findElement(By.xpath("//span[@id=\"debugMenuEntry-btnInnerEl\"]")).click();
		driver.findElement(By.xpath("//span[@id=\"openExecuteAnonymousWindow-textEl\"]")).click();
	}

	public void switchToApexCode() {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains("Enter Apex Code")) {
			
				break;
			}
		}
	}

	public void switchToHomePage() {
		
		//String winHandleBefore = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains("home/home")) {
				break;
			}
		}
	}

	public void RunApexScriptToMoveChart() throws IOException {

		FileReader fr = new FileReader("./src/test/resources/configs/ApexCodeForChartMoveToRaw.txt");
		BufferedReader br = new BufferedReader(fr);
		String str;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='CodeMirror-scroll']/div/div/div//div/pre")));

		List<WebElement> elements = driver.findElements(By.xpath("//div/textarea"));
		
		WebElement element = elements.get(0);
		//Utilities.jsClick(driver,apexTextArea );

				
		String s = Keys.chord(Keys.CONTROL, "a",Keys.DELETE);
		apexTextArea.sendKeys(s);
	
	      // sending DELETE key
		//3			element.sendKeys(Keys.DELETE);
		

		while ((str = br.readLine()) != null) {
		

		
			apexTextArea.sendKeys(str);
			apexTextArea.sendKeys(Keys.ENTER);
		}
		Utilities.clickonElement(Execute, driver);
		br.close();
		
	}

}
