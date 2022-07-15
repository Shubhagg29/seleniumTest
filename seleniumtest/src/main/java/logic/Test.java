package logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Test {

	 static WebDriver driver;
	
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("//www.google.com/");

		driver.manage().window().maximize();
	}
}
