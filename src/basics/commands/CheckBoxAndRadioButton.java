package basics.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxAndRadioButton {

	public static void main(String[] args) {
		
		   System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			
			ChromeOptions options=new ChromeOptions();
			
			//to ignore chrome info notifications -like chrome is controlled by automation machine
			
			options.addArguments("disable-infobars");

			WebDriver driver=new ChromeDriver(options);
			
			driver.get("http://toolsqa.wpengine.com/automation-practice-form");
			
			
			//checkbox
			if (!driver.findElement(By.id("profession-0")).isSelected())
				driver.findElement(By.id("profession-0")).click();
			
			//radio button
			
			if(!driver.findElement(By.id("exp-0")).isSelected())
				driver.findElement(By.id("exp-0")).click();
			
			driver.quit();

	}

}
