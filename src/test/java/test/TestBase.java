package test;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import data.ExcelReader;
import pages.ConfigFileReader;

public class TestBase {

	ConfigFileReader configFileReader= new ConfigFileReader();
	public static WebDriver driver;
	FirefoxOptions options = new FirefoxOptions();
	
	@DataProvider(name = "Excel Data")
	public Object [] [] userRegisterData() throws IOException
	{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	
	@BeforeMethod
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


	@AfterMethod
	public void endDriver()
	{
		driver.quit();
	}

}
