package basics.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementCommands {

	public static void main(String[] args) {
		
	    System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://www.google.com");
		
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.id("lst-ib"));
		
		element.clear();
		
		element.sendKeys("Automation tesing");
		
		if(driver.findElement(By.name("btnK")).isDisplayed() & driver.findElement(By.name("btnK")).isEnabled())
		driver.findElement(By.name("btnK")).click();
		
		System.out.println(driver.findElement(By.name("btnK")).getText());
		
		System.out.println(driver.findElement(By.name("btnK")).getTagName());
		
		System.out.println(driver.findElement(By.name("btnK")).getCssValue("background-color"));
		
		System.out.println(driver.findElement(By.name("btnK")).getAttribute("name"));
		
		System.out.println(driver.findElement(By.name("btnK")).getSize());
		
		System.out.println(driver.findElement(By.name("btnK")).getLocation());
		
		//isselected,submit, to be covered
		

	}

}
