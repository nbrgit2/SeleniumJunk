package basics.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class FindElementAndElements {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://toolsqa.wpengine.com/Automation-practice-form/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("return document.readyState").toString().equals("complete");
		
		WebElement submit;
		By locator=By.id("submit");
		
		submit=driver.findElement(locator);
		
		driver.findElement(By.name("firstname")).sendKeys("Test User");
		
		driver.findElement(By.className("button"));
		
		driver.findElement(By.tagName("button"));
		
		driver.findElement(By.linkText("Link Test"));
		
		driver.findElement(By.partialLinkText("Partial"));
		
		String text=driver.findElement(By.xpath("//div[@class='control-group']/input[@name='firstname'] ")).getText();
		
		System.out.println(text);
		
		driver.quit();
		
		
	}

}
