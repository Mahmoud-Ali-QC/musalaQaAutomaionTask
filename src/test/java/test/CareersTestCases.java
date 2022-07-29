package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CareersPage;
import pages.HomePage;

public class CareersTestCases extends TestBase {
	HomePage homepage = new HomePage(driver);
	CareersPage careersPage;

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
}
