package basics.additional;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwitchCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		 driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		 
		 String handle=driver.getWindowHandle();
		 
		 System.out.println(handle);
		 
		 driver.findElement(By.name("New Message Window")).click();
		 
		 Set handles=driver.getWindowHandles();
		 
		 
		 System.out.println(handles);
		 
		 for(String h:driver.getWindowHandles())
		 {
			 System.out.println(h);

	        	driver.switchTo().window(h);
		 }
		
		 driver.quit();
	
	}

}
