package trohibo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TrohiboDate {

	  

	@Test
	public static void planVacation() throws InterruptedException, AWTException {

		// System.setProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions option= new ChromeOptions();
		//option.addArguments("--headless");
		//WebDriverManager.chromedriver().setup();
	//	DesiredCapabilities cap= new DesiredCapabilities(); 
		WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver(option);
    		   
		driver.get("//google.com");

		driver.manage().window().maximize();

		Thread.sleep(3000);
		
		
		WebElement element =driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]"));
		//element.click();
		String datev="Wed, 27 Apr 2022";
		selectDate(driver, element, datev);

		
	}

	
	public static void selectDate(WebDriver driver,WebElement element,String dateVal) {
		  System.out.println("TDate completed");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].setAttribute('value','"+dateVal +"');", element);
		
	}
	
 

}