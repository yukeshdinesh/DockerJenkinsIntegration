package Remotetesting.Dockervalidation;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandaloneTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		URL url = new URL("http://localhost:4444/wd/hub");
		
		//DesiredCapabilities cap = DesiredCapabilities.chrome();
		ChromeOptions cap = new ChromeOptions();
		
		cap.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		
		
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());

	}

}
