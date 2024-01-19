package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.github.sukgu.support.ElementFieldDecorator;

public class MCCChartProjectTabPage {
	
	WebDriver driver;
	
	public MCCChartProjectTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
			PageFactory.initElements(decorator, this);
		}
	
	@FindBy(xpath="//div[contains(text(),'Project Name')]")
	private WebElement projectName;
	
	@FindBy(xpath="//div[contains(text(),' DOS Capture')]")
	private WebElement DOSFrom;
	
	@FindBy(xpath="//div[contains(text(),' DOS Capture')]/../following-sibling::div/div/span")
	private WebElement text_DOSFrom;

	@FindBy(xpath="//div[contains(text(),' DOS Capture')]/../following-sibling::div/div/span[2]")
	private WebElement text_DOSTo;

	public WebElement getText_DOSTo() {
		return text_DOSTo;
	}

	@FindBy(xpath="//div[contains(text(),'To')]")
	private WebElement DosTo;
	
	@FindBy(xpath="//div[contains(text(),' Review Type')]")
	private WebElement ReviewType;
	
	@FindBy(xpath="//div[contains(text(),'DX Capture Type')]")
	private WebElement  DXcapturetype;
	
	@FindBy(xpath="//div[contains(text(),'Coding Type')]")
	private WebElement CodingType;
	
	@FindBy(id="project_name")
	private WebElement text_ProjectName;
	
	@FindBy(id="project_dos_capture")
	private WebElement text_dosCapture;
	
	@FindBy(id="project_dos_capture_to")
	private WebElement text_doscaptureto;
	
	@FindBy(id="project_type")
	private WebElement text_reviewtype;
	
	@FindBy(id="project_dx_capture_type")
	private WebElement text_DXcapturetype;
	
	@FindBy(id="project_coding_type")
	private WebElement text_codingtype;
	
	
	public WebElement getText_DOSFrom() {
		return text_DOSFrom;
	}

	public WebElement getCodingType() {
		return CodingType;
	}
	
	

	public WebElement getText_ProjectName() {
		return text_ProjectName;
	}

	public WebElement getText_dosCapture() {
		return text_dosCapture;
	}

	public WebElement getText_doscaptureto() {
		return text_doscaptureto;
	}

	public WebElement getText_reviewtype() {
		return text_reviewtype;
	}

	public WebElement getText_DXcapturetype() {
		return text_DXcapturetype;
	}

	public WebElement getText_codingtype() {
		return text_codingtype;
	}

	public WebElement getProjectName() {
		return projectName;
	}

	public WebElement getDOSFrom() {
		return DOSFrom;
	}

	public WebElement getDosTo() {
		return DosTo;
	}

	public WebElement getReviewType() {
		return ReviewType;
	}

	public WebElement getDXcapturetype() {
		return DXcapturetype;
	}

	public WebElement getCodinType() {
		return CodingType;
	}
	
}
