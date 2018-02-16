package basics.additional;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCommands {

	private static final TimeUnit SECONDS = null;

	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://www.google.com");
		
		//pageLoadTimeout -set timeout to wait for page load
		
		driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
		
		//setScriptTimeout -Sets the amount of time to wait for an asynchronous script to finish execution before throwing an error
		
		driver.manage().timeouts().setScriptTimeout(10, SECONDS);
		
		//Sleep 
		
		Thread.sleep(10);
		
		//implicit wait - to tell webDriver to wait for certain amount time before throwing exception - it will applies to all operations we do
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("firstname"));
		
		Wait<WebDriver> wt=new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		
		//FluentWait --FluentWait instance defines the maximum amount of time to wait for a condition, 
		//as well as the frequency with which to check the condition
		
       WebElement elemt= wt.until(new Function<WebDriver,WebElement>() {
    	   
			public WebElement  apply(WebDriver driver) {
				
				return driver.findElement(By.name("firstname"));
			}

    	   });
       
     //explicit wait --wait for specific condition to meet for specified amount of time 
       WebDriverWait  wait=new WebDriverWait(driver,10);
       
       wait.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
       	
		driver.quit();
		
	}

}
