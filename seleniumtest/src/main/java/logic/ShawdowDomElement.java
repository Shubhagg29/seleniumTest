package logic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShawdowDomElement {
	
	WebDriver driver;
	
	//@Test
	public void handleShawdowElement() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver= new ChromeDriver();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.switchTo().frame("pact");
		//document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		WebElement ele=(WebElement)js.executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#tea')");
		
		
		//
		
		  //document.querySelector("#snacktime").shadowRoot.querySelector("#app2").shadowRoot.querySelector("#pizza")
		js.executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(2000);
		
		String jse ="arguments[0].setAttribute('value','GingerTea')";
		js.executeScript(jse, ele);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//
	
	@Test
	public void handlePsuedoElements() throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		 driver.get("https://monica-official.github.io/Pseudo-Elements/sample-pseudo-element.html");
		 
	        // Maximize the browser
	        driver.manage().window().maximize();
	 
	        // Scroll down the webpage by 5000 pixels
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        String text = js.executeScript(
	                "return window.getComputedStyle(document.querySelector('.submitButton'),'::before').getPropertyValue('content')")
	                .toString();
	 
	        System.out.print(text);
	 
	       // status = "passed";
	        Thread.sleep(150);
		
	}

}
