package abstract_Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.MyInfoPage;
import pageObjects.PIMPage;

public class ReusableMethods {

	public WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public WebDriverWait wait;

	public ReusableMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//nav[@role='navigation']//li[1]//span")
	private WebElement lnk_Admin;

	@FindBy(xpath = "//nav[@role='navigation']//li[2]//span")
	private WebElement lnk_PIM;

	@FindBy(xpath = "//nav[@role='navigation']//li[3]//span")
	private List<WebElement> lnk_Leave;
	
	@FindBy(xpath = "//nav[@role='navigation']//li[6]//span")
	private WebElement lnk_MyInfo;
	
	@FindBy(xpath= "//button[@type='submit']")
	private WebElement btn_Login;
	
	public void click_Submit_Button()
	{
		btn_Login.click();
	}
	

	public void click_Admin() {
		//waitForElementClickable(lnk_Admin);
		lnk_Admin.click();
	}
	
	public MyInfoPage click_MyInfo() throws IOException {
		lnk_MyInfo.click();
		return new MyInfoPage(driver);
	}
	
	public void scrollIntoView(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void waitForElementClickable(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void click_Leave() {
		lnk_Leave.get(0).click();
	}

	public Properties properties(String filePath) throws IOException {
		prop = new Properties();
		fis = new FileInputStream(new File(System.getProperty("user.dir") + filePath));
		prop.load(fis);
		return prop;
	}

	public PIMPage click_PIM() throws IOException {
		lnk_PIM.click();
		return new PIMPage(driver);
	}

}
