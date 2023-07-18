package abstract_Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.AdminPage;
import pageObjects.PIMPage;

public class ReusableMethods{

	public WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;

	public ReusableMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//nav[@role='navigation']//li[1]//span")
	WebElement lnk_Admin;
	
	@FindBy(xpath= "//nav[@role='navigation']//li[2]//span")
	WebElement lnk_PIM;

	public void click_Admin() {
		lnk_Admin.click();
	}
	
	public Properties properties(String filePath) throws IOException
	{
		prop = new Properties();
		fis = new FileInputStream(
				new File(System.getProperty("user.dir") + filePath));
		prop.load(fis);
		return prop;
	}
	
	public PIMPage click_PIM()
	{
		lnk_PIM.click();
		return new PIMPage(driver);
	}

}
