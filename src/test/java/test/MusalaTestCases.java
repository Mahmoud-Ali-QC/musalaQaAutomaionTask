package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CareersByLocationPage;
import pages.CareersPage;
import pages.CompanyPage;
import pages.ContactUsPage;

public class MusalaTestCases extends TestBase{
	ContactUsPage contactUsPage;
	CompanyPage companyPage;
	CareersPage careersPage;
	CareersByLocationPage careersByLocationPage;
	
	
	//Test-Cases
	@Test (dataProvider = "Excel Data")
	public void TestCase1(String yourName,String yourEmail,String yourSubject,String yourMessage) {  
		contactUsPage= new ContactUsPage(driver);
		contactUsPage.openContactUs();
		contactUsPage.ContactUsView("mom","a@a", "test subject", "test message");
		Assert.assertTrue(ContactUsPage.getErrorTxt.contains("The e-mail address entered is invalid"));
		
	}
	
	@Test
	public void TestCase2() {  
		SoftAssert softAssert = new SoftAssert();
		companyPage= new CompanyPage(driver);
		companyPage.openCompanyPage();
		softAssert.assertTrue(companyPage.companyUrl.contains("www.musala.com/company"));
		softAssert.assertTrue(companyPage.companyMembers.isDisplayed());
		companyPage.openFacebookPage();
		softAssert.assertTrue(companyPage.facebookUrl.contains("www.facebook.com/MusalaSoft?fref=ts"));
		softAssert.assertTrue(companyPage.musalaImage.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test
	public void TestCase3() {  
		SoftAssert softAssert = new SoftAssert();
		careersPage= new CareersPage(driver);
		careersPage.openCareersPage();
		softAssert.assertTrue(careersPage.joinUsUrl.contains("www.musala.com/careers/join-us"));
		softAssert.assertTrue(careersPage.getGeneDescription);
		softAssert.assertTrue(careersPage.getRequirements);
		softAssert.assertTrue(careersPage.getResponsibilities);
		softAssert.assertTrue(careersPage.getWhatWeOffer);
		softAssert.assertTrue(careersPage.getApplyButton);
		softAssert.assertAll();
		careersPage.applyForQaAutomation("mom","a@a", "", "test message");
		softAssert.assertTrue(CareersPage.getErrorTxt.contains("One or more fields have an error. Please check and try again"));
		softAssert.assertTrue(CareersPage.getInvaliedEmailTxt.contains("The e-mail address entered is invalid"));
		softAssert.assertTrue(CareersPage.getRequiredFieldTxt.contains("The field is required"));
		softAssert.assertAll();
	}
	

	@Test
	public void TestCase4() {
		careersByLocationPage= new CareersByLocationPage(driver);
		careersByLocationPage.openCareersByLocationPage();
		careersByLocationPage.printJobInfo();
	}
}
