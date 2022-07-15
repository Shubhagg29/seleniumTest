package trohibo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class JSSelectOption {

	static WebDriver driver;
	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "chromedriver");

		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Dropdown")).click();
		MultiOption();
	}	
	
	
      public static void MultiOption() {
	
    	  
    	List<WebElement> optionlist= new ArrayList<WebElement>();
       WebElement dropdown= driver.findElement(By.id("dropdown"));
       
       String script="arguments[0].setAttribute('multiple','')";
       
       JavascriptExecutor js= (JavascriptExecutor)driver;
       
       Select select = new Select(dropdown);
       
       js.executeScript(script, select);
       
       select.selectByIndex(1);
       select.selectByIndex(2);
      
Actions action = new Actions(driver);
       
      //Get Selected Option 
       
    List< WebElement> optn= select.getAllSelectedOptions();
    
    for(WebElement scoption: optn) {
    	
    	optionlist.add(scoption);
    }
    
    System.out.println(optionlist.size());
	}

}
