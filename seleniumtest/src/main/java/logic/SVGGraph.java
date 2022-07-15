package logic;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class SVGGraph {
	
	  static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//
		System.setProperty("webdriver.chrome.driver", "chromedriver");
	
		
		//WebDriverManager.chromedriver().setup();
		
		
		WebDriverManager.firefoxdriver().setup();
		
		driver = new ChromeDriver();
//driver= new FirefoxDriver();
		driver.get("https://emicalculator.net/");
		Dimension d = new Dimension(50, 50);
		driver.manage().window().setSize(d);
		//driver.manage().window().maximize();
		String barPath="//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
	   String tooTip="//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";
		
		List<WebElement>barList=	driver.findElements(By.xpath(barPath));
	System.out.println("Bar List: " + barList.size() );
	
	Actions act = new Actions(driver);
	for(WebElement e:barList ) {
		act.moveToElement(e).perform();
	String textYear=	driver.findElement(By.xpath(tooTip)).getText();
	System.out.println("FInal : " + textYear);
	}
 driver.close();
	}

}
