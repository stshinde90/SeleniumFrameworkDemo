package regressionSuite;

import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.LandingPage;
import pageObjects.PIMPage;
import test_Components.BaseTest;

public class TC_01_EndToEnd extends BaseTest {

	@Test
	public void tc_01_EndToEnd() {
		LandingPage landingPage = new LandingPage(getDriver());
		landingPage.login_To_Application("Admin", "admin123");
		AdminPage adminPage = new AdminPage(getDriver());
		adminPage.click_Admin();
		adminPage.Admin_Page_Check();
		PIMPage pimPage = adminPage.click_PIM();
		pimPage.PIM_Page_Check();
	}

}
