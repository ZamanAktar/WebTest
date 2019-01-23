package org.naic.mfl.se.base;

import java.util.concurrent.TimeUnit;

import org.naic.mfl.se.utilities.ScreenShotUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class ScriptBase {

	private ApplicationController appController;
	private WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) throws Exception {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.marionette", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}

		else {

			throw new Exception("Browser is not found");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		
		appController = new ApplicationController(driver);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShotUtility.captureScreenshot(driver, result.getMethod().getMethodName());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public ApplicationController appController() {
		return appController;
	}

}
