package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends PageBase {

	public CareersPage(WebDriver driver) {
		super(driver);
	}
	

	
	@FindBy(xpath = "//div[@id='menu']/*/*/a[contains(@href,'careers')]")
	WebElement careers;
	
	@FindBy(xpath = "//button[contains(@class,'contact-label')]//span[1]")
	WebElement joinUs;
	
	@FindBy(id = "get_location")
	WebElement getLocation;
	
	@FindBy(xpath = "//*[@id=\"get_location\"]/option[contains(text(),'Anywhere')]")
	WebElement anyWhere;
	
	@FindBy(xpath = "(//img[@alt='Automation QA Engineer'])[2]")
	WebElement qaAutomation;
	
	@FindBy(xpath = "//h2[text()='General description']")
	WebElement geneDescription;
	
	@FindBy(xpath = "//h2[text()='Requirements']")
	WebElement requirements;
	
	@FindBy(xpath = "//h2[text()='Responsibilities']")
	WebElement responsibilities;
	
	@FindBy(xpath = "//h2[text()='What we offer']")
	WebElement whatWeOffer;
	
	@FindBy(xpath = "//input[@value='Apply']")
	WebElement applyButton;
	
	@FindBy(name = "your-name")
	WebElement name;
	
	@FindBy(name = "your-email")
	WebElement email;
	
	@FindBy(name = "mobile-number")
	WebElement mobileNumber;
	
	@FindBy(name= "your-message")
	WebElement message;
	
	@FindBy(name = "adConsentChx")
	WebElement adConsentChx;
	
	@FindBy(xpath= "//*[@id=\"recaptcha-anchor\"]/div[1]")
	WebElement reCAPTCHA;
	
	@FindBy(xpath = "//input[@value='Send']")
	WebElement send;
	
	@FindBy(name = "uploadtextfield")
	WebElement uploadCV;
	
	@FindBy(xpath = "//div[text()='One or more fields have an error. Please check and try again.']")
	WebElement returnedError;
	
	@FindBy(xpath = "//*/iframe[contains(@title,'reCAPTCHA')]")
	WebElement frame;
	
	@FindBy(className = "close-form")
	WebElement closeButton;
	
	@FindBy(xpath = "//span[text()='The e-mail address entered is invalid.']")
	WebElement invaliedEmail;
	
	@FindBy(xpath = "//span[text()='The field is required.']")
	WebElement requiredField;
	
	
	
	//Test-run
	public String joinUsUrl;
	public boolean getGeneDescription;
	public boolean getRequirements;
	public boolean getResponsibilities;
	public boolean getWhatWeOffer;
	public boolean getApplyButton;
	public void openCareersPage(){
		clickButton(careers);
		clickButton(joinUs);
		joinUsUrl=driver.getCurrentUrl();
	}
	
	public void filterCareersLocation() {
		clickButton(getLocation);
		clickButton(anyWhere);
		clickImage(qaAutomation);
		getGeneDescription = geneDescription.isDisplayed();
		getRequirements = requirements.isDisplayed();
		getResponsibilities = responsibilities.isDisplayed();
		getWhatWeOffer = whatWeOffer.isDisplayed();
		getApplyButton = applyButton.isDisplayed();
	}
	public static String getErrorTxt;
	public static String getInvaliedEmailTxt;
	public static String getRequiredFieldTxt;
	public void applyForQaAutomation (String yourName,String yourEmail,String yourMobileNumber,String yourMessage) {
		clickButton(applyButton);
		setTextElement(name, yourName);
		setTextElement(email, yourEmail);
		setTextElement(mobileNumber, yourMobileNumber);
		setTextElement(message, yourMessage);
		setTextElement(uploadCV, System.getProperty("user.dir")+"/Files/CV.pdf.separator");
		clickButton(adConsentChx);
		driver.switchTo().frame(frame);
		clickButton(reCAPTCHA);
		driver.switchTo().defaultContent();
		clickButton(send);
		getErrorTxt= getTextValue(returnedError);
		clickButton(closeButton);
		getInvaliedEmailTxt = getTextValue(invaliedEmail);
		getRequiredFieldTxt = getTextValue(requiredField);
	}

}
