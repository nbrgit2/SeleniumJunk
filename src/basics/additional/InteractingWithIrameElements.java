package basics.additional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InteractingWithIrameElements {

	public static void main(String[] args) {
		/*
		 * switch to iframe .then find elements using normal techniques -->perform op and switch back -->swicth back 
		 */
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		 driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		 
		 driver.switchTo().frame(0);
		 
			WebElement firstName = driver.findElement(By.xpath("//*[@id='content']/form/fieldset/div[1]/p[3]/input"));
	 
			/* now find the Last name field */
			WebElement lastName = driver.findElement(By.xpath("//*[@id='content']/form/fieldset/div[1]/p[4]/input"));
			
			firstName.sendKeys("test");
			lastName.sendKeys("test");
			
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame(1);
			
			/*
			 * NosuchEmelemnt Exception
			 * NoSuchFrame Exception
			 */

	}

}
