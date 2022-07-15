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


public class TrohiboVacation {

	WebDriver driver;

	@Test
	public void planVacation() throws InterruptedException, AWTException {

		 System.setProperty("webdriver.chrome.driver", "chromedriver");
		//ChromeOptions option= new ChromeOptions();
		//option.addArguments("--headless");
		//WebDriverManager.chromedriver().setup();
	//	DesiredCapabilities cap= new DesiredCapabilities(); 
		
       
		driver= new ChromeDriver();
		driver.get("https://www.triphobo.com/");

		driver.manage().window().maximize();

		WebElement planTrip = driver.findElement(By.id("plan-my-trip"));
		
		
		planTrip.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement location = driver.findElement(By.xpath("//*[@placeholder='Where do you want to go?']"));
		// location.click();

		js.executeScript("arguments[0].click()", location);

		location.sendKeys("hou");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> citylist = driver.findElements(By.xpath("//ul[@class='city-list-collection']/li"));

		System.out.println("Auto Suggest List ::" + citylist.size());
		for (WebElement item : citylist) {

			if (item.getText().equalsIgnoreCase("Houston, Texas, United States")) {

				item.click();

			}

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement startDate = driver.findElement(By.xpath("(//input[@class='input-control hasDatepicker'])[1]"));
		startDate.click();

		List<WebElement> date = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

		System.out.println("Auto Suggest List ::" + date.size());

		for (int i = 0; i < date.size(); i++) {
			int flag = 0;
			if (date.get(i).getText().equalsIgnoreCase("13"))

			{

				date.get(i).click();
				flag = 1;
				break;
			}

			if (flag == 1)
				break;
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement endDate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='end-date-control']")));

		endDate.click();

		List<WebElement> eDate = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td"));

		System.out.println("EndDate List ::" + eDate.size());

		for (int i = 0; i < eDate.size(); i++) {

			int flag = 0;
			if (eDate.get(i).getText().equalsIgnoreCase("17"))

			{
				eDate.get(i).click();
				flag = 1;
				break;
			}

			if (flag == 1)
				break;
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement startButton = driver
				.findElement(By.xpath("//span[@class='button p-color full-width start-planning']"));

		startButton.click();

		WebElement next = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("js_city_next_step_title")));

		next.click();

		
	}

	
   public void tearDown() {
	   
	   System.out.println("Test Case completed");
	   driver.close();
}

}