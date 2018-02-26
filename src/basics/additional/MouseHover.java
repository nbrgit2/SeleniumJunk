package basics.additional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		 driver.get("http://www.onlinestore.toolsqa.wpengine.com");
		 
	     WebElement element = driver.findElement(By.linkText("Product Category"));
	     
	     Actions builder=new Actions(driver);
	     
	     builder.moveToElement(element).build().perform();
	     
	     driver.quit();

	}

}
