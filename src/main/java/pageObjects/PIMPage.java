package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Components.ReusableMethods;

public class PIMPage extends ReusableMethods {
	
	public WebDriver driver;
	
	public PIMPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath= "//nav[@role='navigation']//li[2]//span")
	WebElement lnk_PIM;
	
	@FindBy(xpath= "//input[@placeholder='Type for hints...']")
	WebElement txtbx_InputValue;
	
	@FindBy(xpath= "//button[@type='submit']")
	WebElement btn_Login;
	
			
	public void PIM_Page_Check()
	{
		txtbx_InputValue.sendKeys("12345");
		btn_Login.click();
	}
	
	
}
