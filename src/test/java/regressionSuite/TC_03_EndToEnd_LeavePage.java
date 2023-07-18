package regressionSuite;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LeavePage;
import test_Components.BaseTest;

public class TC_03_EndToEnd_LeavePage extends BaseTest {

	@Test
	public void tc_01_EndToEnd() throws IOException, InterruptedException {
		LandingPage landingPage = new LandingPage(getDriver());
		Properties prop = properties("\\src\\test\\java\\dataUtils\\data.properties");
		landingPage.login_To_Application(prop.getProperty("username"), prop.getProperty("password"));
		LeavePage leavePage = new LeavePage(getDriver());
		leavePage.click_Leave();
		leavePage.leave_Page_Check();
		

	}

}
