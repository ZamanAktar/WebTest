package org.naic.mfl.se.base;

import org.naic.mfl.se.pages.CheckoutPage;
import org.naic.mfl.se.pages.LoginPage;
import org.naic.mfl.se.pages.SignInPage;
import org.openqa.selenium.WebDriver;

public class ApplicationController {
	
	public ApplicationController(WebDriver driver) {
		this.driver=driver;
	}

	// Webdriver Time Out
	public static final int WEBDRIVER_WAIT_TIMEOUT = 30;
	private WebDriver driver;
	private LoginPage loginPage;
	private SignInPage signinPage;
	private CheckoutPage checkoutPage;
	
	public LoginPage loginPage() {
		if(loginPage == null)
		{
			loginPage= new LoginPage(driver);
		}return loginPage;
	}
	
	public SignInPage signinPage() {
		if(signinPage == null)
		{
			signinPage= new SignInPage(driver);
		}return signinPage;
	}
	
	public CheckoutPage checkoutPage() {
		if(checkoutPage == null)
		{
			checkoutPage= new CheckoutPage(driver);
		}return checkoutPage;
	}

}
