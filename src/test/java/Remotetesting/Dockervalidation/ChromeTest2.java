package Remotetesting.Dockervalidation;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest2 {
	
	@Test
	public void test2() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		//ChromeOptions cap = new ChromeOptions();
		
		//cap.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		
		
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		
		driver.get("https://gmail.com");
		System.out.println(driver.getTitle());

	}

}
