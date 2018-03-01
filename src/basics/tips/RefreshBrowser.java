package basics.tips;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RefreshBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://toolsqa.wpengine.com/");
		
		//using the refresh command
		
		driver.navigate().refresh();
		
		//using SendKeys
		
		driver.findElement(By.name("s")).sendKeys(Keys.F5);
		
		//using get command
		
		driver.get(driver.getCurrentUrl());
		
		//using To command
		
		driver.navigate().to(driver.getCurrentUrl());

	}

}
