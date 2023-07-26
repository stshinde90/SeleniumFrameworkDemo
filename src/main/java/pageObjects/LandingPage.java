package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Components.ReusableMethods;

public class LandingPage extends ReusableMethods {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement txtbx_userName;

	@FindBy(name = "password")
	private WebElement txtbx_password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn_Login;

	public void login_To_Application(String username, String password) throws InterruptedException {
		
		txtbx_userName.sendKeys(username);
		txtbx_password.sendKeys(password);
		btn_Login.click();
		Thread.sleep(1500);
	}

}
