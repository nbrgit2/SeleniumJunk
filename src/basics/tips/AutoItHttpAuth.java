package basics.tips;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoItHttpAuth {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");
		
		WebDriver driver=new ChromeDriver(options);	
		
		driver.get("http://www.example.com");
		
		Runtime.getRuntime().exec("lib/HttpAuth.exe");
		
		Thread.sleep(2000);
		
		driver.close();
		
		//Note: if code didn't work then call auto it script before opening the url

	}

}
