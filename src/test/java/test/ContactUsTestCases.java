package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTestCases extends TestBase {

	HomePage homepage = new HomePage(driver);
	ContactUsPage contactUsPage;
	
	@Test (dataProvider = "Excel Data")
	public void TestCase1(String yourName,String yourEmail,String yourSubject,String yourMessage) {  
		contactUsPage= new ContactUsPage(driver);
		contactUsPage.openContactUs();
		contactUsPage.ContactUsView(yourName,yourEmail, yourSubject, yourMessage);
		Assert.assertTrue(ContactUsPage.getErrorTxt.contains("The e-mail address entered is invalid"));
		
	}
}
