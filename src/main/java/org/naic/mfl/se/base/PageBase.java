package org.naic.mfl.se.base;

import org.naic.mfl.se.utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	private WebDriver driver;
	private WebDriverWait wait;

	/******************************************************************************************
	 * Constructor
	 * 
	 * @param driver
	 */

	public PageBase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, ApplicationController.WEBDRIVER_WAIT_TIMEOUT);
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
		Log.info("Click on : " + element.getText());
		element.click();
	}
	
	public void setText(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Log.info("Enter Text : " + text);
		element.sendKeys(text);
	}
	
	
}
