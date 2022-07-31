package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CompanyPage;
import pages.HomePage;

public class CompanyTestCases extends TestBase {

	HomePage homepage = new HomePage(driver);
	CompanyPage companyPage;

	@Test
	public void TestCase2() {  
		SoftAssert softAssert = new SoftAssert();
		companyPage= new CompanyPage(driver);
		companyPage.openCompanyPage();
		softAssert.assertTrue(companyPage.companyUrl.contains(configFileReader.getApplicationUrl()));
		softAssert.assertTrue(companyPage.companyMembers.isDisplayed());
		companyPage.openFacebookPage();
		softAssert.assertTrue(companyPage.facebookUrl.contains(configFileReader.getMusalaFbUrl()));
		softAssert.assertTrue(companyPage.musalaImage.isDisplayed());
		softAssert.assertAll();
	}
}
