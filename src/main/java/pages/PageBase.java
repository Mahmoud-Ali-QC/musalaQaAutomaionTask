package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	protected static WebDriver driver;
	public PageBase(WebDriver driver) {
		PageBase.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton(WebElement button){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", button);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		button.click();
	}
	
	protected static void submitButton(WebElement button) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", button);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		button.submit();
	}
	
	protected static void setTextElement(WebElement textElement , String value) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", textElement);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		textElement.sendKeys(value);
	}
	
	protected static void clickImage(WebElement button){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", button);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		jse.executeScript("arguments[0].click()", button);
	}
	
	protected static String getTextValue(WebElement textElement){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", textElement);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return textElement.getText();
	}
}
