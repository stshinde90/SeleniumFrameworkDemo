package test_Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public DesiredCapabilities cap;
	public static String browserName;

	// ====== Thread Local for parallel Execution ================//
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
	}

	public static void unload() {
		dr.remove();
	}
	
	// ==============================================================
   
	public static String getBrowserName() throws IOException
	{
		prop = new Properties();
		fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\dataUtils\\data.properties"));
		prop.load(fis);

		browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		return browserName;
		
	}
	
	public Properties properties(String filePath) throws IOException
	{
		prop = new Properties();
		fis = new FileInputStream(
				new File(System.getProperty("user.dir") + filePath));
		prop.load(fis);
		return prop;
	}
	//"\\src\\test\\java\\dataUtils\\data.properties"
	
	public WebDriver initializeDriver() throws IOException {
		
		if (getBrowserName().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			setDriver(driver);
			//
		} else if (getBrowserName().contains("remote")) {
			cap = DesiredCapabilities.chrome();
			URL url = new URL("http://localhost:4444/wd/hub");
			driver = new RemoteWebDriver(url, cap);
			setDriver(driver);
		}

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, destinationFile);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	@BeforeSuite
	public void configureDocker() throws IOException, InterruptedException {
		
		if (getBrowserName().contains("remote")) {

			File fi = new File("output.txt");
			if (fi.delete()) {
				System.out.println("File Deleted Successfully");
			}

			StartDocker st = new StartDocker();
			st.startBatFile();
		}
	}

	@AfterSuite
	public void unloadDocker() throws IOException, InterruptedException {
		if (getBrowserName().contains("remote")) {

			StopDocker sp = new StopDocker();
			sp.stopBatFile();
		}
	}

	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		getDriver().get(prop.getProperty("webAdress"));

	}

	@AfterTest
	public void tearDown() {
		getDriver().close();
		unload();
	}

}
