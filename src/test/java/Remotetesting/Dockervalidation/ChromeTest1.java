package Remotetesting.Dockervalidation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest1 {
	
	
	@BeforeTest
	public void StartDocker() throws IOException, InterruptedException {
		DockerSetup setup = new DockerSetup();
		setup.start();
	}
	
	
	  @AfterTest 
	  public void wrapup() throws IOException, InterruptedException {
	  Dockerwrapup stop = new Dockerwrapup(); stop.stop(); }
	 
	@Test
	public void test1() throws MalformedURLException {
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
