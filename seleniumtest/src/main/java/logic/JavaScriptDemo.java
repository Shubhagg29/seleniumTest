package logic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptDemo {
	
	
	 public static WebDriver driver;
	 
 
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
     
		driver = new ChromeDriver();
		  

		driver.get("https://www.google.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("alert('hello')");
		
		Alert alert = driver.switchTo().alert();	
		alert.accept();
		
		
		

	}
	
	
    public  void highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
	     
		//driver = new ChromeDriver();
		
		//driver.get("https://jqueryui.com/");
	//	Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("scroll(0,800)");
		
		
		//Scroll into view *till any element*
	//	js.executeScript("arguments[0].scrollIntoView(true);",element);
		
		//Highlight any Element
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;')",element);
	}

}
