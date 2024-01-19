package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "username")
	private WebElement txtUserName;
	
	@FindBy(id = "password")
	private WebElement txtPassword;
	
	@FindBy(id = "Login")
	private WebElement btnLogIn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String userName) {
		txtUserName.sendKeys(userName);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogIn() {
		btnLogIn.click();
	}
	
	public void login(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.clickLogIn();
		
	}
}
