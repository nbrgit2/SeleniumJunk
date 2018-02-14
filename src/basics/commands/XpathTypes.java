package basics.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathTypes {

	public static void main(String[] args) {
		
		/*Generic:
		 * 
		 * // tagname[@attribute-name=’value’]
		 */
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("return document.readyState").toString().equals("complete");
		
		//basic syntax -single attribute
		
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("TestUser");
		
		//multiple attribute
		
		driver.findElement(By.xpath("//input[@id='identifierId'][@name='identifier']")).sendKeys("TestUser");
		
		
		//using 'and; and 'or' with the attributes
		
		//and
		driver.findElement(By.xpath("//input[@id='identifierId' and @name='identifier']")).sendKeys("TestUser");
		
		//'or
		driver.findElement(By.xpath("//input[@id='identifierId' or  @name='identifier']")).sendKeys("TestUser");
		
		///contains
		
		driver.findElement(By.xpath("//input[contains(@aria-label ,'Email')]")).clear();
		
		//starts-with
		
		driver.findElement(By.xpath("//input[starts-with(@aria-label ,'Email')]")).clear();
		
		//text
		driver.findElement(By.xpath("//p/[text()='to continue to Gmail']"));
		
		//last
		driver.findElement(By.xpath("//input[@type='text'])[last()]"));
		
		driver.findElement(By.xpath("//input[@type='text][last()-1]"));
		//position
		
		driver.findElement(By.xpath("//input[@type='text'])[position()=2]"));
		
		//or
		driver.findElement(By.xpath("//input[@type='text'])[	2]"));
		
		//index
		
		driver.findElement(By.xpath("//label[2]"));
		
		//following
		
		driver.findElement(By.xpath("//input[@id='FirstName]/following::input[@type='text']"));
		
		//preceding
		
		driver.findElement(By.xpath("//input[@id='FirstName]/preceding::input[@type='text']"));
		
		driver.quit();
		

	}

}
