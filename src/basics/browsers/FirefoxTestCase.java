package basics.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxTestCase {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		//will close the current window
		driver.close();

	}

}
