package basics.additional;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxWait {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://www.google.com");
		
		WebDriverWait wt=new WebDriverWait(driver,10);
		
		Function<WebDriver,Boolean> waitCondition=new Function<WebDriver,Boolean> ()
		{
			
			public Boolean apply(WebDriver driver)
			{
				Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
				if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
				return isJqueryCallDone;
			}
			
		};
		
		wt.until(waitCondition); 
		
		//or directly send function
		
		wt.until( (d) ->
		{
		Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
		if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
		return isJqueryCallDone;
		});
		
			
	}

}
