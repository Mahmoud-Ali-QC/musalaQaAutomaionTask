package pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersByLocationPage extends PageBase {

	public CareersByLocationPage(WebDriver driver) {
		super(driver);
	}
	

	
	@FindBy(xpath = "//div[@id='menu']/*/*/a[contains(@href,'careers')]")
	WebElement careers;
	
	@FindBy(xpath = "//button[contains(@class,'contact-label')]//span[1]")
	WebElement joinUs;
	
	@FindBy(id = "get_location")
	WebElement getLocation;
	
	@FindBy(xpath = "//*[@id=\"get_location\"]/option[contains(text(),'Sofia')]")
	WebElement sofiaLocation;
	
	@FindBy(xpath = "//p[text()='Sofia']")
	List<WebElement> sofiaJobs;
	
	@FindBy(xpath = "//p[contains(text(),'Skopje')]")
	List<WebElement> skopjeJobs;
	
	@FindBy(xpath = "//p[text()='Sofia']/..//..//..//../a")
	List<WebElement> sofiaUrl;
	
	@FindBy(xpath = "//p[contains(text(),'Skopje')]/..//..//..//../a")
	List<WebElement> skopjeUrl;
	
	@FindBy(xpath = "//p[text()='Sofia']/../h2")
	List<WebElement> sofiaTxt;
	
	@FindBy(xpath = "//p[contains(text(),'Skopje')]/../h2")
	List<WebElement> skopjeTxt;

	
	
	//Test-run
	public int getSofiaCount;
	public List<String> getSofiaUrls;
	public List<String> getSofiaTxt;
	public int getSkopjeCount;
	public List<String> getSkopjeUrls;
	public List<String> getSkopjeTxt;
	public void openCareersByLocationPage(){
		clickButton(careers);
		clickButton(joinUs);
		clickButton(getLocation);
		clickButton(sofiaLocation);
		getSofiaCount = sofiaJobs.size();
		getSofiaUrls = sofiaUrl.stream().map(element->element.getAttribute("href")).collect(Collectors.toList());
		getSofiaTxt = sofiaTxt.stream().map(element->element.getText()).collect(Collectors.toList());
		getSkopjeCount = skopjeJobs.size();
		getSkopjeUrls = skopjeUrl.stream().map(element->element.getAttribute("href")).collect(Collectors.toList());
		getSkopjeTxt = skopjeTxt.stream().map(element->element.getText()).collect(Collectors.toList());
	}
	public void printJobInfo () {
		System.out.println("Sofia");
		for (int i = 0; i < getSofiaCount; i++) {
			  System.out.println("Position: "+getSofiaTxt.get(i)+"\r\n"+"More info: "+getSofiaUrls.get(i));
			}
		System.out.println("----------------------------");
		System.out.println("Skopje");
		for (int i = 0; i < getSkopjeCount; i++) {
			  System.out.println("Position: "+getSkopjeTxt.get(i)+"\r\n"+"More info: "+getSkopjeUrls.get(i));
			}
}
}
