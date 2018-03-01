package basics.tips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindAllLinks {

	public static void main(String[] args) {
		
		
		//use find element by tag name -a
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://toolsqa.wpengine.com/");
		 
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
 
		System.out.println(links.size());
 
		for (int i = 1; i<=links.size(); i=i+1)
 
		{
 
			System.out.println(links.get(i).getText());
 
		}
		
	}

}
