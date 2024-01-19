package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Key;
//import org.sikuli.script.Match;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
import org.testng.Assert;

//import com.github.mkolisnyk.cucumber.assertions.LazyAssert;

import java.time.Duration;
//import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;

import io.github.sukgu.support.ElementFieldDecorator;
import stepdefinitions.MCCChartQueuePageDefinitions;

public class MCCChartQueuePage{
	
	WebDriver driver;
	static int procount;
	
	@FindBy(xpath = "//td[text()='Get Chart']")
	private WebElement btnGetChartTab;
	
	@FindBy(xpath = "//td[text()='My Pending charts']")
	private WebElement btnMyPendingChartsTab;
	
	@FindBy(xpath = "//iframe[contains(@name,'vfFrameId_')]")
	private WebElement tableIframe;
	
	@FindBy(id = "j_id7")
	private WebElement nestedIframe;
	
	@FindBy(id = "webviewer-1")
	private WebElement pdfViewerIframe;
	
	@FindBy(id = "djHideToolBarButton")
	private WebElement btnHideToolBar;
	
	@FindBy(css = ".pageCountInput")
	private WebElement txtBoxPageCount;
	
	@FindBy(xpath="//input[@max='0']")
	private WebElement txtBoxPageCountPDFNotLoaded;
	
	@FindBy(xpath="//input[@max='19']")
	private WebElement pdf_pgno;
	
	

	public WebElement getTxtBoxPageCountPDFNotLoadedmin() {
		return txtBoxPageCountPDFNotLoadedmin;
	}

	@FindBy(css = ".pageCountInput[min='1']")
	private WebElement txtBoxPageCountPDFNotLoadedmin;
	
	@FindBy(xpath = "//span[text()='Capture']")
	private WebElement btnCapture;
	
	@FindBy(xpath = "//div[contains(@label,'Dx Flex 1')]//input")
	private WebElement txtDxFlexText;
	
	@FindBy(xpath = "//span[text()='L1 Sec Comment']/..//select")
	private WebElement ddL1SecComment;
	
	@FindBy(xpath = "//div[contains(@label,'Enc Test Text')]//input")
	private WebElement txtEncText;
	
	@FindBy(xpath = "//span[text()='Accept']")
	private WebElement btnAccept;
	
	@FindBy(xpath = "//button/span[text()='Cancel']/..")
	private WebElement btnCancel;
	
	@FindBy(css = "#dxTable>div>table>tbody>tr:last-child>td:nth-child(1)>div>div>i")
	private WebElement btnExpandEncDetails;
	
	@FindBy(xpath = "*//td[@rowspan='1' and @class='el-table_3_column_26 is-center ']//div/div/span/div/input")
	private WebElement cellEncText;
	
	@FindBy(xpath = "*//td[@rowspan='1' and @class='el-table_6_column_52  ']//div/div/span/div/input")
	private WebElement cellDxFlexText;
	
	@FindBy(xpath = "*//td[@rowspan='1' and @class='el-table_6_column_57  ']//div//div//div//div//div/div/input")
	private WebElement cellL1Secondary;
	
/**************************************DX Code fields*************************************************************************************/
	
	@FindBy(xpath="//div[text()='Delete']")
	private WebElement dx_Delete;
	
	@FindBy(xpath="//div[text()='Delete / Add']")
	private WebElement dx_Deleteadd;
	
	@FindBy(xpath="//div[text()='DOS Start']")
	private WebElement dx_DOSstart;
	
	@FindBy(xpath="//div[text()='Visit Type']")
	private WebElement dx_Visittype;
	
	@FindBy(xpath="//tr[@class='el-table__row enc-row expanded']/td[9]/div/div/span/div/input")
	private WebElement dx_textVisittype;
	
	@FindAll({
		@FindBy(xpath="//td[@class='el-table_1_column_9 is-center ']/div/div/span/div/input")
	})
	private List<WebElement> dx_textVisittypes;
	
	public List<WebElement> getDx_textVisittypes() {
		return dx_textVisittypes;
	}

	@FindBy(xpath="//td[@class='el-table_1_column_9 is-center ']/div/div/span/div/input")
	private WebElement dx_textVisittype_row3;

	
	public WebElement getDx_textVisittype_row3() {
		return dx_textVisittype_row3;
	}

	@FindBy(xpath="//input[@class='el-checkbox__original']/ancestor::span/label/span")
	private WebElement dx_Enflex2Checkbox;
	
	public WebElement getDx_Enflex2Checkbox() {
		return dx_Enflex2Checkbox;
	}

	public WebElement getDx_textVisittype() {
		return dx_textVisittype;
	}

	@FindBy(xpath="//div[text()='Enc Flex 2']")
	private WebElement dx_flex2;
	
	public WebElement getDx_Visittype() {
		return dx_Visittype;
	}

	public WebElement getDx_flex2() {
		return dx_flex2;
	}

	@FindBy(xpath="//div[text()='DOS End']")
	private WebElement dx_DOSend;
	
	@FindBy(xpath="//*[@id='dxTable']/div[2]/table/thead/tr/th[5]/div")
	private WebElement dx_ProviderName;
	
	@FindBy(xpath="//*[@id='dxTable']/div[2]/table/thead/tr/th[6]/div")
	private WebElement dx_search;
	
	@FindBy(xpath="//div[text()='Provider ID']")
	private WebElement dx_ProviderId;
	
	@FindBy(xpath="//div[text()='Provider NPI']")
	private WebElement dx_ProviderNPI;
	
	@FindBy(xpath="//div[text()='Enc Page Range']")
	private WebElement dx_EncPageRange;
	
	@FindBy(xpath="//div[text()='Enc Flex 1']")
	private WebElement dx_EncFlex1;
	
	@FindBy(xpath="//div[text()='Enc Test Text']")
	private WebElement dx_EncTestText;
	
	@FindBy(xpath="//div[text()='Enc Flex 3']")
	private WebElement dx_EncFlex3;
	
	@FindBy(xpath="//div[text()='Enc Test Dropdown']")
	private WebElement dx_EncTestDropdown;
	
	@FindBy(xpath="//div[text()='Enc Test Date']")
	private WebElement dx_EncTestDate;
	
	@FindBy(xpath="//div[text()='# Coder DXes']")
	private WebElement dx_CoderDX;
	
	@FindBy(xpath="//div[text()='First Page']")
	private WebElement dx_FirstPage;
	
	@FindBy(xpath="//div[text()='Add']")
	private WebElement dx_Add;
	
	@FindBy(xpath="//div[text()='DX Code']")
	private WebElement dx_code;
	
	@FindBy(xpath="//div[text()='HCC']")
	private WebElement dx_HCC;
	
	@FindBy(xpath="//div[text()='Page #']")
	private WebElement dx_page;
	
	@FindBy(xpath="//div[text()='Dx Flex 1']")
	private WebElement dx_Flex1;
	
	@FindBy(xpath="//div[text()='Dx Test Text']")
	private WebElement dx_TestText;
	
	@FindBy(xpath="//div[text()='Dx Flex 3']")
	private WebElement dx_Flex3;
	
	@FindBy(xpath="//div[text()='Dx Test Dropdown']")
	private WebElement dx_TestDropdown;
	
	@FindBy(xpath="//div[text()='Dx Test Date']")
	private WebElement dx_TestDate;
	
	@FindBy(xpath="//div[text()='L1 Secondary']")
	private WebElement dx_L1Secondary;
	
	@FindBy(xpath="//tr[@class='el-table__row']/td[8]/div/div/div/div/div/div/input")
	private WebElement dx_textL2MAprimary;
	
	@FindBy(xpath="//tr[@class='el-table__row']/td[9]/div/div/div/div/div/div/input")
	private WebElement dx_textL2MAmanualcomment;		
			
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[10]/div/div/div/div[2]/div/input")
	private WebElement dx_textL2MAQAComment;
	//*[@id="dxDetailTable"]/div[3]/table/tbody/tr/td[10]/div/div/div/div[2]/div/input
	//tr[@class='el-table__row']/td[8]/div/div/div/div/div/div/input
	
	@FindBy(xpath="//input[@placeholder='Select']")
	private WebElement select_cells;
	
	@FindBy(xpath="//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li")
	private WebElement L1Secondary_valueslist;
	
	public WebElement getSelect_cells() {
		return select_cells;
	}

	public List<WebElement> getL1Secondary_valueslist() {
		List<WebElement> select_values  = driver.findElements(By.xpath("*//div[@class='el-select-dropdown el-popper' and @x-placement='top-start']/div/div/ul/li"));
		return select_values;
	}


	public WebElement getSelect_cells_(int i) {
		List<WebElement> elements  = driver.findElements(By.xpath("//input[@placeholder='Select']"));
		WebElement select_cells = elements.get(i);
		return select_cells;
	}

	
	public WebElement getDx_textL2MAQAComment_MA() {
		List<WebElement> elements  = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[10]/div/div/div[2]/div[2]/div"));
		WebElement dx_textL2MAQAComment_MA = elements.get(0);
		return dx_textL2MAQAComment_MA;
	}
	
	public WebElement getDx_textL2MAQAComment() {
		return dx_textL2MAQAComment;
	}
	
	public WebElement getDx_textL2MAprimary_missed() {
		List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='el-table__row']/td[8]/div/div/div/div/div/div/input"));
		WebElement dx_textL2MAprimary = elements.get(elements.size()-1);
		return dx_textL2MAprimary;
	}

	public List<WebElement> getDx_textL2MAprimary_elements() {
		List<WebElement> dx_textL2MAprimary_elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[*]/td[8]/div/div/div/div[2]/div/div[1]/input"));
		return dx_textL2MAprimary_elements;
	}

	public List<WebElement> getDx_textMAprimary_elements() { 
		List<WebElement> dx_textMAprimary_elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[*]/td[8]/div/div/div[2]/div[2]/div/div[1]/input"));
		return dx_textMAprimary_elements;
	}
	
	public WebElement getDx_textL2MAprimary() {
		return dx_textL2MAprimary;
	}

	public WebElement getDx_textL2MAmanualcomment() {
		return dx_textL2MAmanualcomment;
	}

	public WebElement getDx_textL2MAmanualcomment_MA() {
	List<WebElement> elements  = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[9]/div/div/div[2]/div[2]/div/div/input"));
	WebElement dx_textL2MAmanualcomment_MA = elements.get(0);
	return dx_textL2MAmanualcomment_MA;
	}
	
	
	public WebElement getDx_textL2QAcomment() {
		return dx_textL2QAcomment;
	}

	public WebElement getDx_L2MAprimary() {
		return dx_L2MAprimary;
	}

	public WebElement getDx_L2MAmanualComments() {
		return dx_L2MAmanualComments;
	}

	public WebElement getDx_L2MAQAComments() {
		return dx_L2MAQAComments;
	}
	
	@FindBy(xpath="//span[contains(text(),'Close All Encounters')]")
	private WebElement closeallencounters;

	public WebElement getCloseallencounters() {
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
		List<WebElement> elements;
		try {
			elements = driver.findElements(By.xpath("//span[contains(text(),'Close All Encounters')]"));
			closeallencounters=elements.get(0);
			return closeallencounters;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			elements = driver.findElements(By.xpath("//span[contains(text(),'Close All Encounters')]"));
			w.until(ExpectedConditions.visibilityOfAllElements(elements));
			closeallencounters=elements.get(0);
			return closeallencounters;
		}
	
	}

	@FindBy(xpath="//tr[@class='el-table__row']/td[10]/div/div/div/div/div/input")
	private WebElement dx_textL2QAcomment;
	
	@FindBy(xpath="//div[text()='L2/MA Primary']")
	//@FindBy(xpath="//div[text()='Primary']")
	private WebElement dx_L2MAprimary;
	
	@FindBy(xpath="//div[text()='L2/MA Manual Comments']")
	private WebElement dx_L2MAmanualComments;
	
	@FindBy(xpath="//div[text()='L2/MA QA Comments']")
	private WebElement dx_L2MAQAComments;
	
	@FindBy(xpath="//*[local-name()='svg' and @class='coding-ui-button']")
	private WebElement dx_Deleteicon,dx_Deleteicon5;
	
	public WebElement getDx_Deleteicon() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[local-name()='svg' and @class='coding-ui-button']"));
		WebElement dx_Deleteicon = elements.get(0);
		return dx_Deleteicon;
	}
	
	public WebElement getDx_Deleteicon5() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[local-name()='svg' and @class='coding-ui-button']"));
		WebElement dx_Deleteicon5 = elements.get(9);
		return dx_Deleteicon5;
		
	}
	public WebElement getDx_Deleteicon_last() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[local-name()='svg' and @class='coding-ui-button']"));
		int size = elements.size();
		WebElement dx_Deleteiconlast = elements.get(size-1);
		return dx_Deleteiconlast;
		
	}
	@FindBy(xpath="//input[@placeholder='DOS Start']")
	private WebElement dx_textDOSStart;
	
	@FindBy(xpath="//input[@placeholder='DOS Start']")
	private WebElement dx_textDOSStart2;
	
	@FindBy(xpath="//input[@placeholder='DOS Start']")
	private WebElement dx_textDOSStart3;
	
	@FindBy(xpath="//div[@class='el-picker-panel__body']")
	private WebElement dx_calendar;
	
	public WebElement getDx_calendar() {
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='el-picker-panel__body']"));
		WebElement dx_calendar= elements.get(0);
		return dx_calendar;
	}

	public WebElement getDx_textDOSStart2() {
		List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='DOS Start']"));
		
		WebElement dx_textDOSStart2 = elements.get(0);
		return dx_textDOSStart2;
	}
	public WebElement getDx_textDOSStart3() {
		List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='DOS Start']"));
		
		WebElement dx_textDOSStart3 = elements.get(0);
		return dx_textDOSStart3;
	}
	
	public WebElement getDx_textDOSStart4() {
		List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='DOS Start']"));
		System.out.println("size :"+ elements.size());
		WebElement dx_textDOSStart4 = elements.get(elements.size()-1);
		return dx_textDOSStart4;
	}
	
	public WebElement getDx_textDOSStart5() {
		List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='DOS Start']"));
		
		WebElement dx_textDOSStart5 = elements.get(elements.size()-1);
		return dx_textDOSStart5;
	}

	public WebElement getDx_textDOSStart6() {
		List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='DOS Start']"));
		
		WebElement dx_textDOSStart6 = elements.get(elements.size()-1);
		return dx_textDOSStart6;
	}
	public WebElement getAddNewEncounter() {
		return AddNewEncounter;
	}

	@FindBy(xpath="//div[@class='el-date-picker__header']/button[3]")
	private WebElement dx_date_yearArrow;
	
	@FindBy(xpath="//div[@class='el-date-picker__header']/button[3]")
	private WebElement dx_date_yearArrow4;
	
	@FindBy(xpath="//table[@class='el-date-table']/tbody/tr[3]/td[4]/div/span")
	private WebElement dx_date_date8;
	
	@FindBy(xpath="//table[@class='el-date-table']/tbody/tr[3]/td[5]/div/span")
	private WebElement dx_date_date9;

	public WebElement getDx_date_date9() {
		return dx_date_date9;
	}
	
	@FindBy(xpath = "//div[3]//tbody/tr[1]/td[8]//input")
	private WebElement testObj;

	public WebElement getTestObj() {
		List<WebElement> findElements = driver.findElements(By.xpath("//div[3]//tbody/tr[1]/td[8]//input"));
		WebElement testObj = findElements.get(1);
		return testObj;
	}

	@FindBy(xpath="//input[@class='el-input__inner']/ancestor::div[@class='el-input el-input--mini requiredFlex errorField']")
	private WebElement dx_visittype;
	
	public WebElement getDx_visittype() {
		return dx_visittype;
	}

	public WebElement getDx_date_date8() {
		return dx_date_date8;
	}

	public WebElement getDx_date_yearArrow() {
		return dx_date_yearArrow;
	}
	
	public WebElement getDx_date_yearArrow4() {
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='el-date-picker__header']/button[3]"));
		dx_date_yearArrow4 = elements.get(elements.size()-1);
		return dx_date_yearArrow4;
	}

	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[4]/div/div/div[1]/input")
	private WebElement dx_textDOSEnd;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[5]/div/span/div/input")
	//@FindBy(xpath="//div[@id='el-popover-7330']/..")
	private WebElement dx_textproviderName;
	
	public WebElement getDx_textproviderName() {
		return dx_textproviderName;
	}
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[2]/td[5]/div/span/div/input")
	private WebElement dx_textproviderName2;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[3]/td[5]/div/span/div/input")
	private WebElement dx_textproviderName_row2;
	
	public WebElement getDx_textproviderName_row2() {
		return dx_textproviderName_row2;
	}

	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[3]/td[5]/div/span/div/input")
	private WebElement dx_textproviderName3;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[4]/td[5]/div/span/div/input")
	private WebElement dx_textproviderName4;
	
	public WebElement getDx_textproviderName4() {
		return dx_textproviderName4;
	}

	public WebElement getDx_textproviderName5() {
		
		if (procount == 0) {
		    System.out.println("procount = " + procount);
		    WebElement dx_textproviderName_last = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[5]/td[5]/div/span/div/input"));
		    procount = procount + 1;
		    return dx_textproviderName_last;
		} else {
		    List<WebElement> elements = driver.findElements(By.xpath("//*[@placeholder='Last Name, First Name']"));

		    if (!elements.isEmpty()) {
		        int lastIndex = elements.size() - 1;
		        WebElement dx_textproviderName_last = elements.get(lastIndex);
		        return dx_textproviderName_last;
		    } else {
		        // Handle case when no elements are found
		        return null; // Or throw an exception, or perform other appropriate actions
		    }
		}
	}			
		
		
	  /*  if(procount==0) {
	    	System.out.println("procount ="+ procount);
	    	WebElement dx_textproviderName_last = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr[5]/td[5]/div/span/div/input"));
	    	procount=procount+1; 
	    	return dx_textproviderName_last;
	    }
	    else {
								
		List<WebElement> elements = driver.findElements(By.xpath("//*[@placeholder='Last Name, First Name']"));
		WebElement dx_textproviderName_last = elements.get(size()-1);
		return dx_textproviderName_last;
	    }
		
	}*/
		
	/*private int size() {
		// TODO Auto-generated method stub
		return 0;
	}*/

	public WebElement getDx_textproviderName6() {
		return dx_textproviderName6;
	}
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[6]/td[5]/div/span/div/input")
	private WebElement dx_textproviderName6;

	@FindBy(xpath="//*[@placeholder='Last Name, First Name']")
	private WebElement dx_textproviderName5;
	
	public WebElement getDx_textproviderName3() {
		return dx_textproviderName3;
	}
	
	
	public WebElement getDx_textproviderName2() {
		return dx_textproviderName2;
	}

	@FindBy(xpath="//tr[@class='el-table__row']/td[2]/div")
	private WebElement dx_selectProviderName;
	
	@FindBy(xpath="//input[@name='quickLinkRadio']")
	private WebElement dx_selectproviderradio;
	
	public WebElement getDx_selectproviderradio() {
		return dx_selectproviderradio;
	}

	public WebElement getDx_selectProviderName() {
		return dx_selectProviderName;
	}

	@FindBy(xpath="//span[contains(text(),'Dummy')]")
	private WebElement dx_Dummy;
	
	@FindBy(xpath="//button[contains(text(),'Dummy Date')]")
	private WebElement dx_DummyDate;
	
	@FindBy(xpath="//span[contains(text(),'Add New Encounter')]")
	private WebElement AddNewEncounter;
	
	public WebElement getAddNewWncounter() {
		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Add New Encounter')]"));
		AddNewEncounter = elements.get(0);
		return AddNewEncounter;
	}

	public WebElement getDx_DummyDate() {
		return dx_DummyDate;
	}

	@FindBy(xpath="//*[@id='divDxDetail']/div[2]/div/div[2]/button[2]")
	private WebElement dx_Save;
	
	@FindBy(xpath="//div[@tabindex='-1']/div/div[3]/button[2]")
	private WebElement dx_ok;
	
	public WebElement getDx_ok() {
		return dx_ok;
	}

	public WebElement getDx_Save() {
		return dx_Save;
	}

	public WebElement getDx_Dummy() {
		return dx_Dummy;
	}

	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[7]/div/div/input")
	private WebElement dx_textproviderId;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[8]/div/div/input")
	private WebElement dx_textproviderNPI;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[9]/div/div/div[1]/div/input")
	private WebElement dx_textENCpageRange1;
	 
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[9]/div/div/div[2]/div/input")
	private WebElement dx_textENCpageRange2;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[10]/div/div/span/div/input")
	private WebElement dx_textENCTestText;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[12]/div/div/span/label/span/span")
	private WebElement dx_textENCFlex3;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[13]/div/div/span/div/div[1]/input")
	private WebElement dx_textENCTestDropdown;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[14]/div/div/span/div/input")
	private WebElement dx_textENCTestDate;
	
	@FindBy(xpath="//tr[@class='el-table__row enc-row expanded']/td[11]/div/div/input")
	private WebElement dx_textCoderDXes;
	
	@FindBy(xpath="//tr[@class='el-table__row enc-row expanded']/td[12]/div/div/input")
	private WebElement dx_textFirstPage;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr/td[11]/div/div")
	private WebElement dx_textAdd;

	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[2]/div/div/input")
	private WebElement dx_textdxCode;
	
		
	public WebElement getDx_textdxCode() {
		return dx_textdxCode;
	}
	
	public WebElement dx_textdxcode_row2(int rowcount) throws InterruptedException {
		System.out.println("rowcount :" +rowcount);
		int n = rowcount-1;
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[2]/div/div/input"));
		System.out.println("rowcount after :" +n);
		WebElement	dx_textdxcode_row2 = elements.get(n);
		return dx_textdxcode_row2;
		}
	
	public WebElement dx_textdxcode_row3() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[3]/td[2]/div/div/input"));
		WebElement dx_textdxcode_row3 = elements.get(0);
		return dx_textdxcode_row3;
	}
	
	public WebElement getDx_textdxCode4() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[2]/div/div/input"));
		WebElement dx_textdxCode4 = elements.get(3);
		return dx_textdxCode4;
	}

	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr[2]/td[2]/div/div[1]/input")
	private WebElement dx_textdxCode2;
	
	//@FindBy(xpath="//div[@id='divDxDetail']//following-sibling::div[3]/ul/li")
	@FindBy(xpath="//div[@class='el-col el-col-18']/div/ul/li")
	private WebElement dx_duplicateDxcode;
	
	public WebElement getDx_duplicateDxcode() {
		return dx_duplicateDxcode;
	}

	public WebElement getDx_textdxCode2() {
		return dx_textdxCode2;
	}

	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[3]/div")
	private WebElement dx_textHCC;
	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[4]/div/div/input")
	private WebElement dx_textpage;
	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[5]/div/div/span/div/input")
	private WebElement dx_textDxFlex1;
	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr[1]/td[6]/div/div/span/div/input")
	private WebElement dx_textDxflex2;
	
	public WebElement getDx_textDxflex2() {
		return dx_textDxflex2;
	}
	
	public WebElement getDx_textDxflex1_row2(int rowcount) {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[5]/div/div/span/div/input"));
		int i = rowcount-1;
		WebElement dx_textDxflex1_row1 = elements.get(i);
		return dx_textDxflex1_row1;
	}
	public WebElement getDx_textDxflex1_row3() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[5]/div/div/span/div/input"));
		WebElement dx_textDxflex1_row1 = elements.get(1);
		return dx_textDxflex1_row1;
	}
	
	public WebElement getDx_textDxflex2_row2(int rowcount) {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[6]/div/div/span/div/input"));
		int i = rowcount-1;
		WebElement dx_textDxflex2_row2 = elements.get(i);
		return dx_textDxflex2_row2;
	}

	public WebElement getDx_textDxflex2_row3() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[6]/div/div/span/div/input"));
		WebElement dx_textDxflex2_row3 = elements.get(1);
		return dx_textDxflex2_row3;
	}

	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[6]/div/div/span/div/input")
	private WebElement dx_textDxTestText;
	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[7]/div/div/span/label/span/span")
	private WebElement dx_textDxFlex3;
	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[8]/div/div/span/div/div[1]/input")
	private WebElement dx_textDxTestDropdown;
	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[9]/div/div/span/div/input")
	private WebElement dx_textDxTestDate;
	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[7]/div/div/div[1]/div/div/div[1]/input")
	private WebElement dx_textL1Secondary;

	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr/td[2]")
	private WebElement dx_btnDelete;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr[1]/td[6]/div/span/button")
	private WebElement dx_textSearch;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr/td[1]/div/div/i")
	private WebElement dx_downarrow;
	
	@FindBy(xpath="//*[@id='dxTable']/div[3]/table/tbody/tr/td[1]/div/div/i")
	private WebElement dx_downarrow2;
	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr[1]/td[3]/div")
	private WebElement dx_HccCode;
	
	public List<WebElement> getDx_HccCode() {
		List<WebElement> dx_HccCodes = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[1]/td[3]/div"));
		return dx_HccCodes;

	}

	public WebElement getDx_downarrow2() {
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr/td[1]/div/div/i"));
		WebElement dx_downarrow2 = findElements.get(1);
		return dx_downarrow2;
	}

	@FindBy(xpath="//span[text()='Open All Encounters']")
	private WebElement dx_openEncounters;
	
	public WebElement getDx_openEncounters() {
		List<WebElement> elements = driver.findElements(By.xpath("//span[text()='Open All Encounters']"));
		dx_openEncounters=elements.get(0);
		return dx_openEncounters;
	}

	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[6]/div/div/span/div/input")
	private WebElement dx_textFlex2;
	
	@FindBy(xpath="//i[@class='el-icon-close']")
	private WebElement dx_closeAlertmsg;
	
	@FindBy(xpath="//*[@id='dxDetailTable']/div[3]/table/tbody/tr[1]/td[4]/div/div/input")
	private WebElement dx_textpageno;
	
	public WebElement getDx_textpageno5() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[1]/td[4]/div/div/input"));
		WebElement dx_textpageno5 = elements.get(4);
		return dx_textpageno5;
	}
	
	public WebElement getDx_textpageno() {
		return dx_textpageno;
	}

	public WebElement getDx_closeAlertmsg() {
		return dx_closeAlertmsg;
	}

	public WebElement getDx_textFlex2() {
		return dx_textFlex2;
	}

	public WebElement getDx_Flex2() {
		return dx_Flex2;
	}

	public WebElement getPdf_pgno() {
		return pdf_pgno;
	}
	
	@FindBy(xpath="//button/span[contains(text(),'Save and Continue')]")
	private WebElement dx_SaveContinue;

	@FindBy(xpath="//div[@class='el-date-picker__header']/span")
	private WebElement dx_detepickeryr;
	
	public WebElement getDx_detepickeryr() {
	List<WebElement> elements = driver.findElements(By.xpath("//div[@class='el-date-picker__header']/span"));	
	int size = elements.size();
	dx_detepickeryr=elements.get(size-2);
	return dx_detepickeryr;
	}

	public WebElement getDx_SaveContinue() {
		List<WebElement> findElements = driver.findElements(By.xpath("//span[contains(text(),'Submit')]/.."));
		dx_SaveContinue=findElements.get(0);
		return dx_SaveContinue;
	}

	@FindBy(xpath="//*[@id='dxDetailTable']/div[2]/table/thead/tr/th[6]/div")
	private WebElement dx_Flex2;
	
	public WebElement getDx_textpage() {
		return dx_textpage;
	}

	public WebElement getDx_downarrow() {
		return dx_downarrow;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getBtnGetChartTab() {
		return btnGetChartTab;
	}

	public WebElement getBtnMyPendingChartsTab() {
		return btnMyPendingChartsTab;
	}

	public WebElement getBtnHideToolBar() {
		return btnHideToolBar;
	}

	public WebElement getBtnCapture() {
		return btnCapture;
	}

	public WebElement getDdL1SecComment() {
		return ddL1SecComment;
	}

	public WebElement getBtnAccept() {
		return btnAccept;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getBtnExpandEncDetails() {
		return btnExpandEncDetails;
	}

	public WebElement getCellEncText() {
		return cellEncText;
	}

	public WebElement getCellDxFlexText() {
		return cellDxFlexText;
	}

	public WebElement getCellL1Secondary() {
		return cellL1Secondary;
	}

	public WebElement getDx_textSearch() {
		return dx_textSearch;
	}

	public WebElement getDx_btnDelete() {
		return dx_btnDelete;
	}

	public WebElement getTableIframe() {
		return tableIframe;
	}

	public WebElement getNestedIframe() {
		return nestedIframe;
	}

	public WebElement getPdfViewerIframe() {
		return pdfViewerIframe;
	}

	public WebElement getTxtBoxPageCount() {
		return txtBoxPageCount;
	}

	public WebElement getTxtBoxPageCountPDFNotLoaded() {
		return txtBoxPageCountPDFNotLoaded;
	}

	public WebElement getTxtDxFlexText() {
		return txtDxFlexText;
	}

	public WebElement getTxtEncText() {
		return txtEncText;
	}

	public WebElement getDx_Delete() {
		return dx_Delete;
	}

	public WebElement getDx_Deleteadd() {
		return dx_Deleteadd;
	}

	public WebElement getDx_DOSstart() {
		return dx_DOSstart;
	}

	public WebElement getDx_DOSend() {
		return dx_DOSend;
	}

	public WebElement getDx_ProviderName() {
		return dx_ProviderName;
	}

	public WebElement getDx_search() {
		return dx_search;
	}

	public WebElement getDx_ProviderId() {
		return dx_ProviderId;
	}

	public WebElement getDx_ProviderNPI() {
		return dx_ProviderNPI;
	}

	public WebElement getDx_EncPageRange() {
		return dx_EncPageRange;
	}

	public WebElement getDx_EncFlex1() {
		return dx_EncFlex1;
	}

	public WebElement getDx_EncTestText() {
		return dx_EncTestText;
	}

	public WebElement getDx_EncFlex3() {
		return dx_EncFlex3;
	}

	public WebElement getDx_EncTestDropdown() {
		return dx_EncTestDropdown;
	}

	public WebElement getDx_EncTestDate() {
		return dx_EncTestDate;
	}

	public WebElement getDx_CoderDX() {
		return dx_CoderDX;
	}

	public WebElement getDx_FirstPage() {
		return dx_FirstPage;
	}

	public WebElement getDx_Add() {
		return dx_Add;
	}

	public WebElement getDx_code() {
		return dx_code;
	}

	public WebElement getDx_HCC() {
		return dx_HCC;
	}

	public WebElement getDx_page() {
		return dx_page;
	}

	public WebElement getDx_Flex1() {
		return dx_Flex1;
	}

	public WebElement getDx_TestText() {
		return dx_TestText;
	}

	public WebElement getDx_Flex3() {
		return dx_Flex3;
	}

	public WebElement getDx_TestDropdown() {
		return dx_TestDropdown;
	}

	public WebElement getDx_TestDate() {
		return dx_TestDate;
	}

	public WebElement getDx_L1Secondary() {
			return dx_L1Secondary;
	}
	
	

	public WebElement getDx_textDOSStart() {
		return dx_textDOSStart;
	}

	public WebElement getDx_textDOSEnd() {
		return dx_textDOSEnd;
	}

	public WebElement getDx_textproviderName1(String rownumber) {
		WebElement dx_textproviderName1 = driver.findElement(By.xpath("//*[@id='dxTable']/div[3]/table/tbody/tr['"+rownumber+"']/td[5]/div/span/div/input"));
		return dx_textproviderName1;
	}
	
	

	public WebElement getDx_textproviderId() {
		return dx_textproviderId;
	}

	public WebElement getDx_textproviderNPI() {
		return dx_textproviderNPI;
	}

	public WebElement getDx_textENCpageRange1() {
		return dx_textENCpageRange1;
	}

	public WebElement getDx_textENCpageRange2() {
		return dx_textENCpageRange2;
	}

	public WebElement getDx_textENCTestText() {
		return dx_textENCTestText;
	}

	public WebElement getDx_textENCFlex3() {
		return dx_textENCFlex3;
	}

	public WebElement getDx_textENCTestDropdown() {
		return dx_textENCTestDropdown;
	}

	public WebElement getDx_textENCTestDate() {
		return dx_textENCTestDate;
	}

	public WebElement getDx_textCoderDXes() {
		return dx_textCoderDXes;
	}

	public WebElement getDx_textFirstPage() {
		return dx_textFirstPage;
	}

	public WebElement getDx_textAdd() {
		return dx_textAdd;
	}

	public List<WebElement> getDx_textdxCodes() { 
       List<WebElement> dxcodes = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[2]/div/div/input"));
       return dxcodes;
	}

	public WebElement getDx_textHCC() {
		return dx_textHCC;
	}

	public WebElement getDX_textPage() {
		return dx_textpage;
	}

	public WebElement getDx_textDxFlex1() {
		return dx_textDxFlex1;
	}
	public WebElement getDx_textDxFlex1_row6() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[1]/td[5]/div/div/span/div/input"));
		WebElement dx_textDxFlex1_row6 = elements.get(5);
		return dx_textDxFlex1_row6;
	}
	public WebElement getDx_textDxFlex2_row7() {
		MCCChartQueuePageDefinitions objMCCChartQueuePage1 = new MCCChartQueuePageDefinitions();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));	
		List<WebElement> elements;
		WebElement dx_textDxFlex1_row7=driver.findElement(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[2]/td[6]/div/div/span/div/input"));
		for(int i = 0;i<20;i++) {
		try {
			elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[2]/td[6]/div/div/span/div/input"));
			dx_textDxFlex1_row7 = elements.get(1);
			break;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			/*elements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr[2]/td[6]/div/div/span/div/input"));
			w.until(ExpectedConditions.visibilityOfAllElements(elements));
			System.out.println("Size flex 2 : "+ elements.size());
			MCCChartQueuePageDefinitions objMCCChartQueuePage1 = new MCCChartQueuePageDefinitions();
			objMCCChartQueuePage1.user_click_on_closeall_encounters_button();
			objMCCChartQueuePage1.user_clicks_on_openall_encounters_button();*/
			continue;
			
		}
			
			
		}
		
		return dx_textDxFlex1_row7;

		
	}
	
	public WebElement getDx_textDxTestText() {
		return dx_textDxTestText;
	}

	public WebElement getDx_textDxFlex3() {
		return dx_textDxFlex3;
	}

	public WebElement getDx_textDxTestDropdown() {
		return dx_textDxTestDropdown;
	}

	public WebElement getDx_textDxTestDate() {
		return dx_textDxTestDate;
	}

	public WebElement getDx_textL1Secondary() {
		return dx_textL1Secondary;
	}
	
	//*[@id="dxDetailTable"]/div[3]/table/tbody/tr/td[7]/div/div/div/div/div/div/input
	public WebElement getDx_textL1Secondary_row6()
	{
	List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='dxDetailTable']/div[3]/table/tbody/tr/td[7]/div/div/div[1]/div/div/div[1]/input"));
	WebElement dx_L1Secondary = findElements.get(5);
	return dx_L1Secondary;
	}
	
	@FindBy(xpath="//button[@class='el-button el-button--default el-button--small el-button--primary ']/span")
	private WebElement dx_okay;
	
	public WebElement getDx_okay() {
		return dx_okay;
	}

	public MCCChartQueuePage(WebDriver driver) {
		this.driver = driver;
		ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
		PageFactory.initElements(decorator, this);
	}
	
	public void clickGetChartTab() {
		Utilities.waitForPageLoaded(driver);
		switchDefaultContent();
		switchToIframe();
		btnGetChartTab.click();
		switchDefaultContent();
	}
	
	public void clickMyPendingChartsTab() {
		Utilities.waitForPageLoaded(driver);
		switchDefaultContent();
		switchToIframe();
		btnMyPendingChartsTab.click();
		switchDefaultContent();
	}
	
	public void openChartId(String text) {
		Utilities.waitForPageLoaded(driver);
		switchDefaultContent();
		switchToIframe();
		switchToNestedIframe();
		driver.findElement(By.xpath("//td/a[contains(text(), '"+ text +"')]")).click();
		switchDefaultContent();
		Utilities.waitForPageLoaded(driver);
		Utilities.waitForNumberOfPagesAvailable(driver, 3);
	}
	
	public void switchToIframe() {
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe[contains(@name,'vfFrameId_')]"));	
		driver.switchTo().frame(iframes.get(iframes.size()-1));
	}
	
	public void switchToNestedIframe() {
		driver.switchTo().frame(nestedIframe);
	}
	
	public void switchToPdfViewerIframe() {
		driver.switchTo().frame(pdfViewerIframe);
	}
	
	public void switchDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public void getcurrentWindows() {
		Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through the window handles and get window titles
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            String windowTitle = driver.getTitle();
            String windowurl = driver.getCurrentUrl();
            String windowid= driver.getWindowHandle();
            System.out.println("Window Title: " + windowTitle);
            System.out.println("Window URL: " + windowurl);
            System.out.println("Window ID: " + windowid);
        }
	}
	
	public void closecurrentWindow() {
		
		//int close_count=1;
		
		 String originalHandle = driver.getWindowHandle();
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(originalHandle)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }

	        // Close the new window
	        driver.close();

	        // Switch back to the main window
	        driver.switchTo().window(originalHandle);
	       // System.out.println("close count :"+ close_count);
	       //close_count=close_count+1;
		
		
	/*	Set<String> windows = driver.getWindowHandles();
		System.out.println("Size "+ windows.size());
		//System.out.println("Current url :"+driver.getCurrentUrl());
		int count=0;
		for(String window : windows)
		{
			
			driver.switchTo().window(window);
			String title1 =driver.getTitle();
			String currentUrl = driver.getCurrentUrl();
			System.out.println("Window Id :" + window);
			System.out.println("Current url :" + currentUrl);
			System.out.println("Current title :" + title1);
			
			if(count==0 && driver.getCurrentUrl().contains("MccAllocationPage")) {
				driver.close();
				
			
			}
			count=count+1;
			if(count==2 && driver.getCurrentUrl().contains("MccAllocationPage")){
				driver.switchTo().window(window);
				break;
			}
		}
		
		System.out.println("count =" +count);*/
	}
	
	
	public void switchToPDFViewer() throws InterruptedException {
		//Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Size "+ windows.size());
		System.out.println("Current url :"+driver.getCurrentUrl());
		for(String window : windows)
		{
			driver.switchTo().window(window);
			String title1 =driver.getTitle();
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains("PDFViewer")) {
				driver.switchTo().window(window);
				break;
			}
		}
		//Thread.sleep(1000);
	}
	
	
	public void switchToChartPage() {
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains("MCC|")) {
				break;
			}
		}
	}
	
	public void goToPageInPdf(int page) {
		Utilities.waitForPageLoaded(driver);
		//btnHideToolBar.click();
		//Utilities.waitForElementToBeInvisible(driver, txtBoxPageCountPDFNotLoaded, 30);
		//getPdf_pgno().click();
		Utilities.waitForElementToBeDisplayed(driver, txtBoxPageCountPDFNotLoadedmin);
		txtBoxPageCount.clear();
		txtBoxPageCount.sendKeys(String.valueOf(page));
		txtBoxPageCount.sendKeys(Keys.ENTER);
	}
	
	/*public void clickInPdf(String text, String color) {
		Screen s = new Screen();
		
		try {
			Pattern pattern = new Pattern("src/test/resources/sikuli/"+ text.toLowerCase() + color.toUpperCase() + ".png").similar((float) 0.7);
			s.wait(pattern, 30);
			s.mouseMove(pattern);
			s.click(pattern);
			s.click(pattern);
			for(int i=0;i<5;i++) {
				s.doubleClick();
				
				try {
					Utilities.waitForElementToBeClickable(driver, btnCapture, 5);
					break;
				}catch (TimeoutException e) {
					continue;
				}
				
			}
		}catch(FindFailed e) {
			e.printStackTrace();
		}
	}*/
	
	public void captureMandatoryFields(String dxFlexText, String l1SecComment, String encText) {
		Utilities.waitForElementToBeClickable(driver, btnCapture);
		btnCapture.click();	
		txtDxFlexText.sendKeys(dxFlexText);
		Utilities.selectByVisibleText(ddL1SecComment, l1SecComment);
		//txtEncText.sendKeys(encText);
		btnAccept.click();
		Utilities.waitForElementToBeInvisible(driver, btnAccept, 5);
	}
	
	public void validateDataInCodingScreen(String dxFlexText, String l1SecComment, String encText) {
		switchDefaultContent();
		switchToChartPage();
		Assert.assertTrue(Utilities.jsGetValue(driver, cellEncText).contains(encText), encText);
		btnExpandEncDetails.click();
		Assert.assertTrue(Utilities.jsGetValue(driver, cellDxFlexText).contains(dxFlexText), dxFlexText);
		Assert.assertTrue(Utilities.jsGetValue(driver, cellL1Secondary).contains(l1SecComment), l1SecComment);
	}
	
	public void validateTextHighlightedInPDF(String text, String color) throws InterruptedException {
		switchDefaultContent();
		switchToPDFViewer();
		//Screen s = new Screen();
		
		//Pattern pattern = new Pattern("src/test/resources/sikuli/" + text.toLowerCase() + color.toUpperCase() + ".png").similar((float) 0.7);
		//Match test = s.exists(pattern);
		//Assert.assertTrue(test != null, "Image not displayed in screen");
	}

	public List<WebElement> getDX_L1Secondary_ddvalues() {
		List<WebElement> L1Secondary_ddvalues = driver.findElements(By.xpath("//div[@class='el-select-dropdown el-popper' and @x-placement='bottom-start']/div/div/ul/li"));
		return  L1Secondary_ddvalues;
	}
}
