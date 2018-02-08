package basics.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class IETestCase {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
		
		InternetExplorerOptions options=new InternetExplorerOptions();
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		//ignore ssl error
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		WebDriver driver=new InternetExplorerDriver(options);
		
		driver.get("https://www.google.com");
		driver.quit();

	}

}
