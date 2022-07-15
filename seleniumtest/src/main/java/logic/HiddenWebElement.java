package logic;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HiddenWebElement {
	
	
	public void captureScreeshot(WebDriver driver, String name) throws IOException {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File Fr=	screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Fr, new File("./screeshot/ "+ name +".png"));
		
		
	}

	@Test
	public void hiddenWebElement() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		
	WebElement ele=	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@id='male'])[2]")));
	ele.click();
	
	//drir.findElement(By.id("male")).click();
		
		
	
	
	
	
	}
	
	
}
