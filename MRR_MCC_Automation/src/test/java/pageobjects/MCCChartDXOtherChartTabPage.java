package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.github.sukgu.support.ElementFieldDecorator;

public class MCCChartDXOtherChartTabPage {
	
WebDriver driver;
	
	public MCCChartDXOtherChartTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));	
			PageFactory.initElements(decorator, this);
		}

		@FindBy(xpath="//*[@id='dxCodesFromOtherTable']/div[4]/div[1]/table/thead/tr/th[1]/div")
		private WebElement DXtab_DOSFrom;
		
		@FindBy(xpath="//*[@id='dxCodesFromOtherTable']/div[4]/div[1]/table/thead/tr/th[2]/div")
		private WebElement DXtab_DOSTo;

		public WebElement getDXtab_DOSFrom() {
			return DXtab_DOSFrom;
		}

		public WebElement getDXtab_DOSTo() {
			return DXtab_DOSTo;
		}
		
		
}
