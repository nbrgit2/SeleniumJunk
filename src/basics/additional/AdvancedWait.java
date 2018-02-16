package basics.additional;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import com.google.common.base.Predicate;




public class AdvancedWait {

	public static void main(String[] args) {
		
		//FluentWait with 2types
		//1)Function as parameter -covered in WaitCommands
		//2)predicate as Parameter 
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://www.google.com");
		
	   	Wait<WebDriver> wt=new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		
		//predicate - is similar to function but always returns bolean value
	   	
	   	
	   	  Predicate<WebDriver> predicate= new Predicate<WebDriver>()
	      {
    	   	public boolean apply(WebDriver driver)
    	   	{
    	   		return false;
    	   	}
		  };
		
         // wt.until((predicate);	//predicate is not longer supported i guess
           
           
           driver.quit();
	}

}
