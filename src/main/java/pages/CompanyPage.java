package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends PageBase {

	public CompanyPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='menu']/*/*/a[contains(@href,'company')]")
	WebElement companyLink;
	
	@FindBy(className = "company-members")
	public WebElement companyMembers;
	
	@FindBy(id = "wt-cli-accept-all-btn")
	WebElement accept;
	
	@FindBy(xpath= "//span[contains(@class, 'facebook')]")
	WebElement facebookIcon;
	
	//FaceBook-Tab
	@FindBy(xpath="(//a[contains(@href,'https://www.facebook.com/MusalaSoft/photos')])[2]")
	public  WebElement musalaImage;
	
	public String companyUrl;
	public String facebookUrl;
	
	public void openCompanyPage() {
		clickButton(companyLink);
		companyUrl = driver.getCurrentUrl();
	}
	
	public void openFacebookPage() {
		clickButton(accept);
		clickButton(facebookIcon);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		facebookUrl= driver.switchTo().window(tabs2.get(1)).getCurrentUrl();
	}
	
}
