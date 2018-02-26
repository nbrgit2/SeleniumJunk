package basics.additional;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {
	
	/*
	 * 1)identity from and to 
	 * 2)create builder instance for Actions class
	 * 3)create Action class instance and assign with builder action(click and hold on *from* then move to *To* then release-->build.
	 * 4)action.perform()
	 */

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		 String URL = "http://sandbox.checklist.com/account/";
		 
		  driver.get(URL);

		  driver.findElement(By.name("j_username")).sendKeys("Username");

		  driver.findElement(By.name("j_password")).sendKeys("Password");

		  driver.findElement(By.name("login")).click();

		  driver.manage().window().maximize();

		  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		  
		  WebElement From = driver.findElement(By.xpath(".//*[@id='userChecklists']/li[1]/a/span"));
		  
		  WebElement To = driver.findElement(By.xpath(".//*[@id='userChecklists']/li[4]/a/span"));
		  
		  Actions builder =new Actions(driver);
		  
		  Action dragAnddrop =builder.clickAndHold(From).moveToElement(To).release().build();
		  
		  dragAnddrop.perform();
		  
		  driver.quit();
		  
	}

}
