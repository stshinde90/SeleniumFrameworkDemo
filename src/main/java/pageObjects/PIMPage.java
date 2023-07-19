package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Components.ReusableMethods;

public class PIMPage extends ReusableMethods {
	
	public WebDriver driver;
	
	public PIMPage(WebDriver driver) throws IOException
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
			
	public void PIM_Page_Check(String userInput) throws IOException, InterruptedException
	{
		//
		txtbx_InputValue.sendKeys(userInput);
		Thread.sleep(3000);
		btn_Login.click();
	}
	
	
}
