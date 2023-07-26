package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Components.ReusableMethods;

public class LeavePage extends ReusableMethods {
	
	public WebDriver driver;
	
	public LeavePage(WebDriver driver) throws IOException
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop=properties("\\src\\main\\java\\dataUtilsPages\\PIMPage.properties");
	}
	
	
	@FindBy(xpath= "//nav[@role='navigation']//li[2]//span")
	private WebElement lnk_PIM;
	
	@FindBy(xpath= "//input[@placeholder='Type for hints...']")
	private WebElement txtbx_InputValue;
	
	@FindBy(xpath= "//button[@type='submit']")
	private WebElement btn_Login;
			
	public void leave_Page_Check(String userInput) throws IOException, InterruptedException
	{
		//
		txtbx_InputValue.sendKeys(userInput);
		Thread.sleep(3000);
		btn_Login.click();
	}
	
	
}
