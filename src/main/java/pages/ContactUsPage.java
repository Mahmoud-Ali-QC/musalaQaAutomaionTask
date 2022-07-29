package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name= "your-name")
	WebElement name;
	
	@FindBy(name= "your-email")
	WebElement email;
	
	@FindBy(name= "your-subject")
	WebElement subject;
	
	@FindBy(name= "your-message")
	WebElement message;
	
	@FindBy(className= "recaptcha-checkbox-border")
	WebElement reCAPTCHA;
	
	@FindBy(xpath = "//input[@value='Send']")
	WebElement send;
	
	@FindBy(xpath ="//*/section[2]//span[text()='Contact us']")
	WebElement contactUs;
	
	@FindBy(xpath = "//span[text()='The e-mail address entered is invalid.']")
	WebElement returnedError;
	
	public static String getErrorTxt;
	public void openContactUs(){
		clickButton(contactUs);
	}
	
	public void ContactUsView(String yourName,String yourEmail,String yourSubject,String yourMessage) {
		setTextElement(name, yourName);
		setTextElement(email, yourEmail);
		setTextElement(subject, yourSubject);
		setTextElement(message, yourMessage);
		submitButton(send);
		getErrorTxt = getTextValue(returnedError);
	}
}
