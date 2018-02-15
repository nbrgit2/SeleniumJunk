package basics.commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownAndMultipleSelect {

	public static void main(String[] args) {
		
		  System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			
			ChromeOptions options=new ChromeOptions();
			
			//to ignore chrome info notifications -like chrome is controlled by automation machine
			
			options.addArguments("disable-infobars");

			WebDriver driver=new ChromeDriver(options);
			
			driver.get("http://toolsqa.wpengine.com/automation-practice-form");
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			
			js.executeScript("return document.readyState").toString().equals("complete");
			
			//drop down
			
			WebElement dropdown=driver.findElement(By.id("continents"));
			
			Select op=new Select(dropdown);
			
			//select 
			op.selectByIndex(1);
		//	op.selectByValue("Asia"); should be value attribute of element
			op.selectByVisibleText("Asia");
			
			//deselect is not available for drop down ( available only for multi slects like listbox)

			
			List<WebElement> elements=op.getAllSelectedOptions();
			WebElement element=op.getFirstSelectedOption();
			List<WebElement> elements2=op.getAllSelectedOptions();
			
			
			WebElement listbox=driver.findElement(By.id("selenium_commands"));
			
			Select opl=new Select(listbox);
			if(opl.isMultiple())
			{
				opl.selectByIndex(1);
				opl.deselectByVisibleText("Wait Commands");
				opl.deselectByIndex(1);
				opl.deselectByVisibleText("Wait Commands");
				opl.deselectAll();
			}
			
			driver.quit();
	}

}
