package stepdefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import pageobjects.ConfigFileReader;
import pageobjects.LoginPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
//import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.sikuli.script.ImagePath;


//import com.applitools.eyes.Eyes;
//import com.applitools.eyes.RectangleSize;
import com.mashape.unirest.http.exceptions.UnirestException;

import api.tuskr;

public class CommonDefinitions {
	
	static WebDriver driver;
	static LoginPage objLoginPage;
	private static boolean initialized = false;
	static String tuskrProject = null;
	//static Eyes eyes;

	
	@BeforeAll
	public static void launchSalesforce() throws FileNotFoundException, IOException {

		try {
			FileUtils.cleanDirectory(new File("test-output/"));
		}catch(Exception e) {
			e.printStackTrace();
		}

		new FileOutputStream("src/test/resources/updateStatus.txt").close();
			
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		if(System.getProperty("headless").toUpperCase().equals("TRUE")) {
			chromeOptions.addArguments("--headless");
		}
		WebDriverManager.chromedriver().setup();
		

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		
		//eyes = new com.applitools.eyes.selenium.Eyes();
       //eyes.setApiKey("9zAaeZPntyZsjsXWUtIlPhBJrQH1t9KQI100r8cbZyLMk110");
      //eyes.open(driver,"NLP","PDF Test",new RectangleSize(800, 600));
        //driver=WebDriverManager.chromedriver().create();
        
      
	//Sikuli ImagePath
	//ImagePath.add(System.getProperty("user.dir"));
	
		String test = System.getProperty("env");
		System.out.println("Environment:"+test);
		
	}
	
	
	@Before
		public void goToHomePage(Scenario scenario) {
		String user = null;
		String pswd=null;
		ConfigFileReader configFileReader;
		configFileReader= new ConfigFileReader();

		if(!scenario.getSourceTagNames().contains("@NoHomePageRedirectionMCC")) {
			switch(System.getProperty("env").toUpperCase()) {
				case "QA":
					driver.get(configFileReader.getQAApplicationUrl());
					user = configFileReader.getQAAdminUserName();
					System.out.println(user);
					pswd = configFileReader.getEpiqapassword();
					break;
					
				case "EPIQA":
					driver.get(configFileReader.getEpiQAApplicationUrl());
					user = configFileReader.getEpiQAAdminUserName();
					pswd = configFileReader.getEpiqapassword();
					break;
				
				case "UAT":
					driver.get(configFileReader.getEpiUATApplicationUrl());  
					user = configFileReader.getEpiUATAdminUserName();
					pswd = configFileReader.getUATpassword();
					break;
					
				case "UAT_PERFORMANCE":
					driver.get(configFileReader.getEpiUATApplicationUrl());  
					user = configFileReader.getUATperformanceUserName(System.getProperty("threadnumber","1"));
					pswd = configFileReader.getUATperformncePassword(System.getProperty("threadnumber","1"));
					break;
				
				default:
					driver.get(configFileReader.getEpiQAApplicationUrl());
					user = configFileReader.getEpiQAAdminUserName();
					pswd = configFileReader.getEpiqapassword();
					break;
			}
			
			if(!initialized) {
				initialized = true;
				
				objLoginPage = new LoginPage(driver);
				objLoginPage.setUserName(user);
				objLoginPage.setPassword(pswd);
				objLoginPage.clickLogIn();
			}
		}
		
	}
	
	@After
	public void save_results(Scenario scenario) throws FileNotFoundException, IOException {
		System.out.println("Status of execution for " + scenario.getName() + " is: "+scenario.getStatus());
	    String testStatus = scenario.getName().split(" - ")[0] + "," + scenario.getStatus() + ";";
	    
		FileOutputStream fos = new FileOutputStream("src/test/resources/updateStatus.txt", true);
		fos.write(testStatus.getBytes());
		fos.close();
		if(tuskrProject == null) {
			if(scenario.getSourceTagNames().contains("@mrr")) {
				tuskrProject = "MRR_Tool";
			}
			else if(scenario.getSourceTagNames().contains("@mcc")) {
				tuskrProject = "MCC";
			}
		}
	}
	
	@AfterAll
	public static void tearDown() throws UnirestException, IOException, InterruptedException {
		//Thread.sleep(10);
		driver.quit();
		if(System.getProperty("updatetuskr").toUpperCase().equals("TRUE")) {
			tuskr.createTestRun(tuskrProject);
			tuskr.updateTestResults();
		}
	}
}
