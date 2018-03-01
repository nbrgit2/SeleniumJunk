package basics.tips;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoItImageUpload {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		 
	    driver.findElement(By.id("photo")).click();
	    
	    Runtime.getRuntime().exec("lib/UploadImage.exe");
	    
	    Thread.sleep(2000);
	    
	    driver.quit();
		

	}

}
