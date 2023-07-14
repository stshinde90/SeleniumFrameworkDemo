package abstract_Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.AdminPage;
import pageObjects.PIMPage;

public class ReusableMethods{

	public WebDriver driver;

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
	
	public PIMPage click_PIM()
	{
		lnk_PIM.click();
		return new PIMPage(driver);
	}

}
