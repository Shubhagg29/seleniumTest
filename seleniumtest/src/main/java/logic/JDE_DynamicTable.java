package logic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JDE_DynamicTable {

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver", "chromedriver");
	
		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new ChromeDriver();
		driver.get("https://158.101.112.182:8001/jde/E1Menu.maf");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(By.id("User")).sendKeys("JS8888888");
		driver.findElement(By.id("Password")).sendKeys("JS88888880");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

		// drop_mainmenu
		driver.findElement(By.id("drop_mainmenu")).click();
		WebElement Fastpath = driver.findElement(By.xpath("//input[@id='TE_FAST_PATH_BOX']"));
		Fastpath.sendKeys("P4310");
		Fastpath.sendKeys(Keys.ENTER);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		 driver.switchTo().frame(9);
		// driver.findElement(By.id("hc_Find")).click();
		 List<WebElement> Row = driver.findElements(By.xpath("//table[@id='WebMenuBar']/tbody/tr"));
		
		System.out.println("Total No of Rows are : " + Row.size());
		
		List<WebElement> col = driver.findElements(By.xpath("//table[@id='WebMenuBar']/tbody/tr[1]/td"));
		System.out.println("Total No of columns are : " + col.size());

		
		int columns_count = col.size();
		
		for (int i = 1; i <=Row.size(); i++) {
		for (int j = 1; j < columns_count; j++) {
				

				 
	WebElement Ele = driver.findElement(By.xpath("//table[@id='WebMenuBar']/tbody/tr[" + i + "]/td["+j+"]"));
     String value =	Ele.getAttribute("title");		
		
		System.out.println(value);
		}
}
	}
		}