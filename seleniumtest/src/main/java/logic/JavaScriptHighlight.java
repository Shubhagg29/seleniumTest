package logic;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptHighlight {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
	     
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		Dimension d = new Dimension(300, 400);
		
       driver.manage().window().setSize(d);
		
		WebElement username= driver.findElement(By.id("email"));
		
		JavaScriptDemo javaScriptDemo = new JavaScriptDemo(); 
		
		
		javaScriptDemo.highlightElement(driver, username);
		
		
	}

}
