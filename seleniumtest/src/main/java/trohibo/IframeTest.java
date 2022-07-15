package trohibo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTest {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver");

		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("WYSIWYG Editor")).click();

		IframeTest ifm = new IframeTest();
		ifm.switchFrame();
	}

	public void switchFrame() {
		driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

		WebElement editor = driver.findElement(By.id("tinymce"));
		editor.clear();
		editor.sendKeys("Hello");

		driver.switchTo().parentFrame();

		WebElement bt = driver.findElement(By.xpath("//div[@title='formatting']/child::button[@title='Bold']"));

		bt.click();

		driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

		editor.sendKeys(" World");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
