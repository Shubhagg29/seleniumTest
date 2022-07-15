package logic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SelectFromDropDown {

	
	WebDriver driver =null;
	@Test
	public void bootStrapDropdown() throws Exception {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		 driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.xpath("//*[@id=\"menu1\"]"));

		Thread.sleep(3000);
		
		
		List<String>itemNew = new ArrayList<String>();
		List<WebElement> menulist = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
		//System.out.println(menulist);
		for (WebElement item : menulist) {

			String innerElement = item.getAttribute("innerHTML");

			//System.out.println("Items in the list are ::" + innerElement);

			itemNew.add(innerElement);
		}
		
		System.out.println("Printed ::" +itemNew);
		
		List<String>Eel1 = new ArrayList<String>();
		
		Eel1.add("HTML");
		Eel1.add("CSS");
		Eel1.add("JavaScript");
		Eel1.add("About Us");
		
	//	System.out.println(Eel1);
		
		
		//Assert.assertTrue(Eel1.equals(itemNew));
		
		//driver.quit();
		WebElement el =driver.findElement(By.id(""));
		Select sc = new Select(el);
		
		
		
		
		
	}
	@Test
	public void check() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		HiddenWebElement tb = new HiddenWebElement();
		tb.captureScreeshot(driver," 2");
		

	
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		
		driver.quit();
	}

}
