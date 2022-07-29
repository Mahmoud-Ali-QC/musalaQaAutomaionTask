package test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.ConfigFileReader;

public class TestBase {

	ConfigFileReader configFileReader= new ConfigFileReader();
	public static WebDriver driver;
	FirefoxOptions options = new FirefoxOptions();
	
	@BeforeClass
	public void startDriver()
	{
		if (configFileReader.getChromeStatus().equals("TRUE")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ configFileReader.getChromeDriverPath());
		driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ configFileReader.getFirefoxDriverPath() );
	        driver= new FirefoxDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.navigate().to(configFileReader.getApplicationUrl());
	}


	@AfterClass
	public void endDriver()
	{
		driver.quit();
	}

}
