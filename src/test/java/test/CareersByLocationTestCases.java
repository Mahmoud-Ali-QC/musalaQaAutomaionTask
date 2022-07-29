package test;

import org.testng.annotations.Test;
import pages.CareersByLocationPage;
import pages.HomePage;

public class CareersByLocationTestCases extends TestBase {
	HomePage homepage = new HomePage(driver);
	CareersByLocationPage careersByLocationPage;


	@Test
	public void TestCase4() {
		careersByLocationPage= new CareersByLocationPage(driver);
		careersByLocationPage.openCareersByLocationPage();
		careersByLocationPage.printJobInfo();
	}
}
