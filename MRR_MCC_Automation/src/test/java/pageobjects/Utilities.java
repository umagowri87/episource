package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public abstract class Utilities {
	
	private static WebDriverWait w;

	public static void waitForElementToBeDisplayed(WebDriver driver, WebElement element) {
		w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOf(element));
			}
	public static void waitforElementVisibility(WebElement element,WebDriver driver) {
		try {
		 w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException();

		}
		}
	
	 public static void clickonElement(WebElement element,WebDriver driver) {
	        try {
	            waitforElementVisibility(element,driver);
	            if ( elementIsDisplayed(element)   && elementIsEnabled(element)) {
	                try {
						//element.clear();
						element.click();
					} catch (ElementClickInterceptedException e1) {
						// TODO: handle exception
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
						wait.until(ExpectedConditions.visibilityOf(element));
						element.click();
				
					}
	                catch(StaleElementReferenceException e2) {
	                	
	                	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
						wait.until(ExpectedConditions.visibilityOf(element));
		
						element.click();
	                	
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 public static boolean elementIsDisplayed(WebElement element) {

			try {
			// WebElement element = driver.findElement(By.id(""));
			boolean displayed = element.isDisplayed();
			return displayed;
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
			}
			}

			public static boolean elementIsEnabled(WebElement element) {
			try {
			boolean enabled = element.isEnabled();
			return enabled;
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

			}
			}

	
	public static void waitForElementToBeDisplayed(WebDriver driver, WebElement element, int timeInSeconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeInSeconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
		w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void waitForElementToBeInvisible(WebDriver driver, WebElement element, int timeInSeconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		w.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void waitForFrameToBeAvailable(WebDriver driver, WebElement element) {
		w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public static void waitForFrameToBeAvailable(WebDriver driver, WebElement element, int timeInSeconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public static void waitForNumberOfPagesAvailable(WebDriver driver, int numberOfWindows) {
		w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
	}
	
	public static void waitForNumberOfPagesAvailable(WebDriver driver, int numberOfWindows, int timeInSeconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		w.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
	}
	
	public static void waitForElementRefreshed(WebDriver driver, WebElement element) {
		w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
	}
	
	public static void waitForElementRefreshed(WebDriver driver, WebElement element, int timeInSeconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		w.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}
	
	public static void waitForElementProperty(WebDriver driver, int numberOfWindows) {
		w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
	}
	
	public static void waitForElementProperty(WebDriver driver, WebElement element, int timeInSeconds) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		w.until(ExpectedConditions.attributeToBe(element, "max", ""));
	}
	
    /*public static void waitForPageLoaded(WebDriver driver) {
    	w = new WebDriverWait(driver, Duration.ofSeconds(50));
    	ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        w.until(pageLoadCondition);
    }*/
	
	public static void waitForPageLoaded(WebDriver driver) {
		w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
		w.until((WebDriver drv) -> ((JavascriptExecutor) drv)
				.executeScript("return (typeof xhrCount === 'undefined' || xhrCount === 0);"));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//lightning-spinner")));
	}
    
    public static void scrollToElement(WebDriver driver, WebElement element) {
    	waitForElementToBeDisplayed(driver, element);
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public static void jsClick(WebDriver driver, WebElement element) {
    	waitForElementToBeClickable(driver, element);
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", element);
    }
    
    public static String jsGetValue(WebDriver driver, WebElement element) {
    	waitForElementToBeDisplayed(driver, element);
    	JavascriptExecutor js = (JavascriptExecutor)driver;
		return (String) js.executeScript("return arguments[0].value", element);
    }

    public static void selectByVisibleText(WebElement element, String text) {
    	Select objSelect = new Select(element);
    	objSelect.selectByVisibleText(text);
    }
    
    public static void selectByIndex(WebElement element, int index) {
    	Select objSelect = new Select(element);
    	objSelect.selectByIndex(index);
    }
    
    public static void selectByValue(WebElement element, String text) {
    	Select objSelect = new Select(element);
    	objSelect.selectByValue(text);
    }
    
    public static String readFileAsString(String fileName) throws IOException {
    	String data = null;
    	data = new String(Files.readAllBytes(Paths.get(fileName)));
    	return data;
    }

    public static void scrollbyUsingElement(WebElement element,WebDriver driver) {
    	try {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView()", element);
    	} catch (Exception e) {
    	throw new RuntimeException("Unable to Scroll");
    	}
    	}
    	public static void scrollbyCoordinates(int height, int width,WebDriver driver) {
    	try {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("windows.scrollBy("+width+","+height+")");
    	} catch (Exception e) {
    	throw new RuntimeException("Unable to Scroll");
    	}
    	}
    	public static void sendKeysUsingActions(WebElement element, String value,WebDriver driver) {
    	try {
    	Actions ac = new Actions(driver);
    	ac.sendKeys(element,value).build().perform();;
    	} catch (Exception e) {
    	throw new RuntimeException("Unable to sendKeysUsingActions");
    	}
    	}
    	public static void clickUsingActions(WebElement element,WebDriver driver) {
    	try {
    	Actions ac = new Actions(driver);
    	ac.click(element).build().perform();
    	} catch (Exception e) {
    	throw new RuntimeException("Unable to sendKeysUsingActions");
    	}
    	}

    	public static void dragAndDropUsingActions(WebElement src, WebElement tar,WebDriver driver) {
    	try {
    	Actions ac = new Actions(driver);
    	ac.dragAndDrop(src, tar).build().perform();
    	} catch (Exception e) {
    	e.printStackTrace();
    	throw new RuntimeException("Unable to drag and Drop");
    	}
    	}
    	public static void tkScreenshot(WebDriver driver) throws IOException {
    	try {
    	File dest = new File(System.getProperty("user.dir"+"/Selenium/Screenshots"));
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File temp = ts.getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(temp, dest);
    	} catch (WebDriverException e) {
    	e.printStackTrace();
    	throw new RuntimeException();
    	}
    	}

public static void mouseHoverToTheElemnet(WebElement element,WebDriver driver) {
try {
waitforElementVisibility(element,driver);
Actions ac = new Actions(driver);
ac.moveToElement(element).build().perform();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
throw new RuntimeException();
}
}
public static void keypress_tab(int no_of_times) throws AWTException {
	
	Robot robot = new Robot(); 

	try {
		for(int i=0;i<=no_of_times;i++)
		{
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static boolean verifyElementPresent(WebElement element,WebDriver driver) throws Exception {

    	boolean displayed = element.isDisplayed();
    	if(displayed==true) {
        System.out.println("Element Present");
    	}
    	else {
    		  System.out.println("Element not Present");
    	}
        return displayed;
      }
    
    public static WebElement getElementInsideTable(WebElement table, int rowNumber, int columnNumber, String elementType) {
    	WebElement row = table.findElements(By.xpath("//tr")).get(rowNumber);
    	WebElement cell = row.findElements(By.xpath("//td")).get(columnNumber);
    	WebElement element = null;
    	switch(elementType) {
    		case "input":
    			element = cell.findElement(By.xpath("//input"));
    			break;
    		case "span":
    			element = cell.findElement(By.xpath("//span"));
    			break;
    		default:
    			element = cell;
    	}
    	return element;
    }
    
    public static void pageLoadTime(WebDriver driver, String nameOfStep) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        long loadTime = (Long) jsExecutor.executeScript(
            "return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;");
        System.out.println("Page load time: " + loadTime + " milliseconds - " + nameOfStep);
    }
	
	public static void keypress_Backspace(int no_of_times) throws AWTException {
		
		Robot robot = new Robot(); 

		try {
			for(int i=0;i<=no_of_times;i++)
			{
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}


}