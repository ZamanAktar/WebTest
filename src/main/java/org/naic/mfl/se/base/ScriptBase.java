package org.naic.mfl.se.base;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.naic.mfl.se.utilities.ScreenShotUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.paxovision.execution.reporter.service.ReporterService;

@Listeners({ReporterTestListener.class})
public class ScriptBase {

	protected WebDriver driver = null;
	protected ReporterService reporter = ReporterService.reporter();
	
	@BeforeClass
	public void beforeClass() {
		reporter.setReportPath(System.getProperty("user.dir")+"/test-output/htmlReport/");
        reporter.setReportName("NAIC HTML Report");
        reporter.setReportTitle("NAIC Test");
        reporter.setCreateUniqueFileName(false);
        
	}
	
	@BeforeMethod(alwaysRun = true)
	public synchronized void setUp(String browser) throws MalformedURLException{

		if (browser.equalsIgnoreCase("chrome")) {
			createChromeDriver();
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
			createChromeDriver();
			//throw new Exception("Browser is not found");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShotUtility.captureScreenshot(driver, result.getMethod().getMethodName());
		}
		
		driver.close();
		driver.quit();
		driver = null;
	}
	
	public void createChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	

}
