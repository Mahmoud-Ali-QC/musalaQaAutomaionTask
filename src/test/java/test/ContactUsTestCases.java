package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTestCases extends TestBase {

	HomePage homepage = new HomePage(driver);
	ContactUsPage contactUsPage;
	
	@Test
	public void TestCase1() {  
		contactUsPage= new ContactUsPage(driver);
		contactUsPage.openContactUs();
		contactUsPage.ContactUsView("mom","a@a", "test subject", "test message");
		Assert.assertTrue(ContactUsPage.getErrorTxt.contains("The e-mail address entered is invalid"));
		
	}
}
