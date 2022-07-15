package logic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		 
		 //String myUrl="http://seleniumpractise.blogspot.com/2016/11/";
		 
		 
		 driver.get("https://www.google.com/");
	List<WebElement>list= driver.findElements(By.tagName("a"));
		 
		System.out.println("Total Link are :" +list.size()); 
		
		for(WebElement anchorList: list) {
			
			
		String myUrl =	anchorList.getAttribute("href");
		verifyLink(myUrl);
		
		}
	
		 
		driver.quit();
		 
	}

	
	
//Verify Broken Links
	public static void verifyLink(String link) throws IOException {
		
		URL url = new URL(link);
		
	
//	HttpURLConnection httpURLConnect=	(HttpURLConnection) url.openConnection();
//	httpURLConnect.connect();
//	
//	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_OK) {
//		System.out.println(link +"::" +httpURLConnect.getResponseMessage() );
//		
//	}
		
		RequestSpecification request=	RestAssured.given();
		Response response =request.get(url);
		
	int statusCode=	response.getStatusCode();
	if(statusCode==200) {
		System.out.println("Link : " + url +" OK " );
	}
	else {
		System.out.println("Link  " + url +" It is a Broken Link " );
	}
	
		
	}
}
