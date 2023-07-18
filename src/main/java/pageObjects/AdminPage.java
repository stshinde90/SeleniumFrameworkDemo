package pageObjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Components.ReusableMethods;

public class AdminPage extends ReusableMethods{
	
	public WebDriver driver;
	
	public AdminPage(WebDriver driver) throws IOException
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop=properties("\\src\\main\\java\\dataUtilsPages\\adminPage.properties");
	}
	
	
	@FindBy(xpath= "//div[@class='']//input[@class='oxd-input oxd-input--active']")
	WebElement txtbx_InputValue;
	
	@FindBy(xpath= "//button[@type='submit']")
	WebElement btn_Login;
	
	
			
	public void Admin_Page_Check() throws IOException
	{
		//
		txtbx_InputValue.sendKeys(prop.getProperty("usernameValue"));
		btn_Login.click();
	}
	
	
}
