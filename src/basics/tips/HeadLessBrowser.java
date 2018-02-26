package basics.tips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadLessBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		//to ignore chrome info notifications -like chrome is controlled by automation machine
		
		options.addArguments("disable-infobars");

		WebDriver driver=new ChromeDriver(options);
		
		//Selenium supports headless testing using its class called HtmlUnitDriver.
		
		HtmlUnitDriver hdriver=new HtmlUnitDriver();
		
		hdriver.get("http://google.com");

		System.out.println("Title of the page is -> " + hdriver.getTitle());

		// find the search edit box on the google page
		WebElement searchBox = hdriver.findElement(By.name("q"));

		// type in Selenium
		searchBox.sendKeys("Selenium");

		// find the search button
		WebElement button = hdriver.findElement(By.name("gbqfba"));

		// Click the button
		button.click();

		System.out.println("Title of the page is -> " + hdriver.getTitle());
		
		/* JavaScript Support*/
		
		hdriver.setJavascriptEnabled(true);
		
		hdriver.get("http://google.com");
		String domainName = (String) hdriver.executeScript("return document.domain");
		System.out.println("Domain name is " + domainName);

	}

}
