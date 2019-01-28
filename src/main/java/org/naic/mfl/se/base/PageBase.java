package org.naic.mfl.se.base;

import org.naic.mfl.se.constants.ApplicationConstant;
import org.naic.mfl.se.utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paxovision.execution.reporter.service.ReporterService;

public class PageBase {

	private WebDriver driver;
	private WebDriverWait wait;
	protected ReporterService reporter = ReporterService.reporter();
	/******************************************************************************************
	 * Constructor
	 * 
	 * @param driver
	 */

	public PageBase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, ApplicationConstant.WEBDRIVER_WAIT_TIMEOUT);
	}

	/******************************************************************************************
	 * Define Specific driver to
	 * 
	 * @param driver
	 */
	protected WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		logInfo("Click on" ,element.getText());
		element.click();
	}
	
	public void setText(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		logInfo("Enter Text",text);
		element.sendKeys(text);
	}
	
	public void logInfo(String name, String description) {
		 Log.info(name+" : " , description);
		 reporter.logInfo(name+" : " , description);
	}
	
}
