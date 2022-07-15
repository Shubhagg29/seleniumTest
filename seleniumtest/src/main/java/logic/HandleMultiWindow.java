package logic;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultiWindow {

	public static void main(String[] args) throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver", "chromedriver");
	
		 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
       
		
	
		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");

		String parent = driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.xpath("//*[@id=\"post-body-6170641642826198246\"]/a[1]")).click();

	Set<String> allWindows = driver.getWindowHandles();
	

		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				driver.findElement(By.name("q")).sendKeys("GOD");

				Thread.sleep(3000);

				driver.close();

			}
		}

		driver.switchTo().window(parent);

		System.out.println(driver.getTitle());

		driver.close();
	}

	@Test
	public void handleWindowPopups() throws Exception {

		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");

		String parent = driver.getWindowHandle();
		System.out.println(parent);
		//driver.findElement(By.xpath("//*[@id=\"post-body-6170641642826198246\"]/a[1]")).click();

		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				System.out.println( "Window title is :: " + driver.getTitle());
				Thread.sleep(3000);

				driver.close();

			}
		}

		driver.switchTo().window(parent);

		System.out.println(driver.getTitle());

		driver.close();
		
		
	//Actions ac = new Actions(driver);
	
	
		
	}
}
