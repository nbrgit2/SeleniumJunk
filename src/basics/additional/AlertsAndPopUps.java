package basics.additional;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertsAndPopUps {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		 driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		 
		 /*
		  * Main 4 actions
		  * getText
		  *  sendKeys
		  * accept
		  * dismiss
		  */
		 
		 //simple alert
		 driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();
		 
		 Alert sal=driver.switchTo().alert();
		 
		 System.out.println(sal.getText());
		 
		 sal.accept();
		 
		 //confirmation alert
		 
			WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[11]/button"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
			
			Alert cal=driver.switchTo().alert();
			cal.dismiss();
			
			//prompt alerts
			
			WebElement element2 = driver.findElement(By.xpath("//*[@id='content']/p[16]/button"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", element2);
			
			Alert pal=driver.switchTo().alert();
			pal.sendKeys("Test");
			pal.accept(); 

	}

}
