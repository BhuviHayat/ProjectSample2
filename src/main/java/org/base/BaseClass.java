package org.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void chromeLaunch() {
WebDriverManager.chromedriver().setup();
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
options.addArguments("--disable notifications");
DesiredCapabilities cp= new DesiredCapabilities();
cp.setCapability(ChromeOptions.CAPABILITY, options);
options.merge(cp);
driver = new ChromeDriver(options);


}
	
	public static void browserLaunch(String browsername) {
		switch(browsername) {
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case"edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		}

	}
	public static void urlLaunch(String url) {
		driver.get(url);

	}
	public static void quit() {
		driver.quit();
			}
	public static void impWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}
	
	public static void sendKeys(WebElement e, String data) {
		e.sendKeys(data);
		
	}
	
	
	
	public static void click(WebElement e) {
		e.click();

	}
	public static String getCurrentUrl() {
String url = driver.getCurrentUrl();
return url;
	}
	public static String getAttribute(WebElement e) {
	return e.getAttribute("value");


	}
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions a = new Actions(driver);
a.dragAndDrop(from, to).perform();
	}
	 public static void moveToElement(WebElement target) {
		 Actions a = new Actions(driver);
a.moveToElement(target).perform();
	}
	 public static void contextClick(WebElement target) {
		 Actions a = new Actions(driver);
a.contextClick(target).perform();
	}
	 public static void doubleClick(WebElement target) {
		 Actions a = new Actions(driver);
a.doubleClick(target).perform();
	}
	
	public static void simpleAlert() {
Alert a = driver.switchTo().alert();
a.accept();

	}
	public static void screenShot(String filename) throws IOException {
TakesScreenshot ts = (TakesScreenshot)driver;
File from = ts.getScreenshotAs(OutputType.FILE);
File to =new File(System.getProperty("user.dir")+"\\src\\test\\resources"+filename+".png");
FileUtils.copyFile(from, to);
	}
	
	public static void jsSendkeys(WebElement e, String data) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+data+"')", e);

	}
	
	public static void jsGetAttribute(WebElement e) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
js.executeScript("return arguments[0].getAttribute('value')", e);
	}
	
	public static void jsClick(WebElement e) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
js.executeScript("arguments[0].click()", e);
	}
	public static void jsScrollup(WebElement e) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(false)", e);
	}
	
	public static void jsScrolldown(WebElement e) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
			}
	public static void intoFramesindex(int index) {
driver.switchTo().frame(index);
	}
	public static void intoFramesname(String nameOrId ) {
driver.switchTo().frame(nameOrId);
	} 
	public static void intoframesRefname(WebElement frameElement ) {
driver.switchTo().frame(frameElement);
	}
	
	public static void refresh() {
driver.navigate().refresh();
	}
	
	public static void forward() {
driver.navigate().forward();
	}
	public static void navigateTo(String url) {
driver.navigate().to(url);
	}
	public static void back() {
driver.navigate().back();
	}
	
	public static boolean isDisplayed(WebElement e) {
return e.isDisplayed();
	}
	
	public static boolean isEnabled(WebElement e) {
return e.isEnabled();
	}
	
	public static boolean isSelected(WebElement e) {
return e.isSelected();
	}
	public static void dropdownByindex(WebElement e,int index) {
Select s = new Select(e);
s.selectByIndex(index);
	}
	public static void dropdownByvalue(WebElement e,String value) {
		Select s = new Select(e);
		s.selectByValue(value);
	}	
	public static void dropdownBytext(WebElement e, String text) {
		Select s = new Select(e);
s.selectByVisibleText(text);
	}
	public static String getText(WebElement e) {
return e.getText();
	}
	
	

}
