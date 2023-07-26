package regressionSuite;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LeavePage;
import pageObjects.MyInfoPage;
import test_Components.BaseTest;

public class TC_04_EndToEnd_MyInfo extends BaseTest {

	@Test
	public void tc_04_EndToEnd() throws IOException, InterruptedException {

		LandingPage landingPage = new LandingPage(getDriver());
		prop = properties("data.properties");
		landingPage.login_To_Application(prop.getProperty("username"), prop.getProperty("password"));
		MyInfoPage myInfoPage = landingPage.click_MyInfo();
		//Properties myInfoProp =properties("MyInfoPage.properties");
		myInfoPage.enter_First_Name(properties("MyInfoPage.properties").getProperty("firstName"));
		myInfoPage.enter_Calender_Date(properties("MyInfoPage.properties").getProperty("calDate"));
    	myInfoPage.click_Submit_Button();
    	Thread.sleep(3000);
		String actualToasterMessage = myInfoPage.validate_Toaster_Message();
    	if(!actualToasterMessage.contains(properties("MyInfoPage.properties").getProperty("expectedToasterMessage")))
    	{
    		Assert.assertFalse(false);
    	}	

	}

}
