package basics.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CssTypes {

	public static void main(String[] args) {
		
		    /*Generic:
			 * 
			 * // css=<HTML tag><#><Value of ID attribute>
			 */
			
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			
			ChromeOptions options=new ChromeOptions();
			
			//to ignore chrome info notifications -like chrome is controlled by automation machine
			
			options.addArguments("disable-infobars");

			WebDriver driver=new ChromeDriver(options);
			
			driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			
			js.executeScript("return document.readyState").toString().equals("complete");
			
			
			driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
			
			//By id ----tag#id
			driver.findElement(By.cssSelector("input#identifierId")).sendKeys("TestUser");
			
			
			//use the class name in element row
			//By class --tag.classname
			//or only classname 
			//when more than one class is cobnied by space then separate it by .
			
			//if class=whsOnd zHQkBf then use like 'whsOnd.zHQkBf'
			
			driver.findElement(By.cssSelector("input.whsOnd.zHQkBf"));
			
			
			//by using attribute
			
			driver.findElement(By.cssSelector("input[id='identifierId']"));
			
			//can use both id and attribute
			
			driver.findElement(By.cssSelector("input#identifierId[name='identifier']"));
			
			//**sub-string
			
			//attribute^=prefix of the string
			
			driver.findElement(By.cssSelector("[name^='id']"));
			
			//attribute$=suffix of the string
			
			driver.findElement(By.cssSelector("[name$='er']"));
			
			//matching any sub-string 
			
			driver.findElement(By.cssSelector("[name*='enti']"));
			
			//**Inner text
			
		//	Inner text (Not supported by WebDriver)
			
			
			
			driver.quit();
			
			

	}

}
