package org.naic.mfl.se.base;

import org.naic.mfl.se.pages.CheckoutPage;
import org.naic.mfl.se.pages.LoginPage;
import org.naic.mfl.se.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class ApplicationController {
	
	public ApplicationController(WebDriver driver) {
		this.driver=driver;
	}
	
	private WebDriver driver;
	private LoginPage loginPage;
	private RegistrationPage signinPage;
	private CheckoutPage checkoutPage;
	
	public LoginPage loginPage() {
		if(loginPage == null)
		{
			loginPage= new LoginPage(driver);
		}return loginPage;
	}
	
	public RegistrationPage signinPage() {
		if(signinPage == null)
		{
			signinPage= new RegistrationPage(driver);
		}return signinPage;
	}
	
	public CheckoutPage checkoutPage() {
		if(checkoutPage == null)
		{
			checkoutPage= new CheckoutPage(driver);
		}return checkoutPage;
	}

}
