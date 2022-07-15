package trohibo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TauLearn {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver");

		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");

		//WebElement keyPress = driver.findElement(By.linkText("Key Presses"));

		//keyPress.click();

		
		
		//WebElement word = driver.findElement(By.id("target"));
		//word.sendKeys(Keys.chord(Keys.ALT, "p") + "=3.14");
		
//	String text =	verifyText();
	//Assert.assertEquals(verifyText(),"You entered: 4","Entered incorrect");
	


	}

	
	public static void ContextMenu() {
		
		driver.findElement(By.linkText("Context Menu")).click();
		Actions act =new Actions(driver);
		
		act.contextClick(driver.findElement(By.id("hot-spot"))).perform();
		
		String message= getAlertText();
		Assert.assertEquals(message,"You selected a context menu", "Popup message incorrect");
		System.out.println("Mesage Verifed ");
		driver.switchTo().alert().accept();
		
		driver.quit();
	}
	
	public static String getAlertText() {
		
	return	driver.switchTo().alert().getText();
	
	}
	
	
	public static String verifyText() {

		return  driver.findElement(By.id("result")).getText();

		

	}
}
