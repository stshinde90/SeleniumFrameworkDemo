package regressionSuite;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.LandingPage;
import pageObjects.PIMPage;
import test_Components.BaseTest;

public class TC_02_EndToEnd extends BaseTest {

	@Test
	public void tc_02_EndToEnd() throws IOException, InterruptedException {
		LandingPage landingPage = new LandingPage(getDriver());
	    Properties prop = properties("\\src\\test\\java\\dataUtils\\data.properties");
		landingPage.login_To_Application(prop.getProperty("username"), prop.getProperty("password"));
		AdminPage adminPage = new AdminPage(getDriver());
		Thread.sleep(1500);
		adminPage.click_Admin();
		adminPage.Admin_Page_Check();
		PIMPage pimPage = adminPage.click_PIM();
		pimPage.PIM_Page_Check();
	}

}
