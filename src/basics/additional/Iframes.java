package basics.additional;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Iframes {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		 options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		 driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		 
		 /*switching can be done by

		    switchTo.frame(int frameNumber): Pass the frame index and driver will switch to that frame.
		    switchTo.frame(string frameNameOrId): Pass the frame element Name or ID and driver will switch to that frame.
		    switchTo.frame(WebElement frameElement): Pass the frame web element and driver will switch to that frame.
		    */
		 
		  driver.get("http://toolsqa.wpengine.com/iframe-practice-page/");
		  
		  //finding total number of iframes on a web page
		  
		  //1)by using javascript executor
		  
		    JavascriptExecutor exe = (JavascriptExecutor) driver;
			Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
			System.out.println("Number of iframes on the page are " + numberOfFrames);
			
			//2)by finding all the web elements
			
			List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			System.out.println("The total number of iframes are " + iframeElements.size());
			
			
			//switching to iframe by index
			
			driver.switchTo().frame(0);
			
			//switch to frame by ID - ID is id of the element in HTML tag
			
			driver.switchTo().frame("IF1");
			
			//switch by WebElement
			
			driver.switchTo().frame(driver.findElement(By.id("IF1")));
			
			//returning back to main page from i frame
			
			driver.switchTo().frame(0);
			
			driver.switchTo().defaultContent();
		 
	}

}
