package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Components.ReusableMethods;

public class MyInfoPage extends ReusableMethods {
	
	public WebDriver driver;
	
	public MyInfoPage(WebDriver driver) throws IOException
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop=properties("\\src\\main\\java\\dataUtilsPages\\PIMPage.properties");
	}	
	
	@FindBy(xpath= "//label[contains(text(), 'License Expiry Date')]//parent::div//following-sibling::div//input")
	WebElement txtbx_license_Exp_Calender;
	
	@FindBy(id= "oxd-toaster_1")
	WebElement txt_toasterMessage;

	@FindBy(name= "firstName")
	WebElement txtbx_firstName;
	
	@FindBy(xpath= "//button[@type='submit']")
	List<WebElement> btn_Login;
	
	public void enter_First_Name(String firstName) throws InterruptedException
	{
		System.out.println("The value in the text box is"+txtbx_firstName.getAttribute("class"));
		
		txtbx_firstName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		while(!txtbx_firstName.getAttribute("class").contains("error")) {
			txtbx_firstName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
			System.out.println("Backspace clicked");
			if(txtbx_firstName.getAttribute("class").contains("error")) {
				System.out.println("No Value in textbox");
				break;
			}
			
			 
		}
		Thread.sleep(1000);
		txtbx_firstName.sendKeys(firstName);
	}
	
	public void enter_Calender_Date(String calDate) throws InterruptedException
	{
		txtbx_license_Exp_Calender.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Thread.sleep(1000);
		txtbx_license_Exp_Calender.sendKeys(calDate);
	}
	
	public void click_Submit_Button()
	{
		scrollIntoView(btn_Login.get(0));
		waitForElementClickable(btn_Login.get(0));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", btn_Login.get(0));
		//btn_Login.get(0).click();
	}
	
	public String validate_Toaster_Message()
	{
	  String actualToasterMessage = txt_toasterMessage.getText();
	  return actualToasterMessage;
	}
			
	
	
	
}
