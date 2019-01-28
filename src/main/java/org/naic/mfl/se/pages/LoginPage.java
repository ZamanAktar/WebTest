package org.naic.mfl.se.pages;
import static org.testng.Assert.assertTrue;

import org.naic.mfl.se.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;



public class LoginPage extends PageBase{
	
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*********************************************************************************************************
     * Locators  */

    // email
    @FindBy(name = "email")
    WebElement email;

    // password
    @FindBy(name = "passwd")
    WebElement password;

    //name
    @FindBy(className = "account")
    WebElement account;

    //Submit Button
    @FindBy(name = "SubmitLogin")
    WebElement submitSigninButton;

    //logout
    @FindBy(className  = "logout")
    WebElement logoutButton;

    /*********************************************************************************************************
     * Actions and Validations
     */

    public LoginPage setEmail(String emailText) {
    	logInfo("Enter Email Address",emailText);
        email.sendKeys(emailText);
        return this;
    }
    
   
    public LoginPage setPassword(String passwordText) {
        logInfo("Password",passwordText);
        password.sendKeys(passwordText);
        return this;
    }

    public LoginPage checkPageHeader(String heading) {
        WebElement pageHeader = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        Assert.assertEquals(heading, pageHeader.getText());
        logInfo("Page Header",pageHeader.getText());
        return this;
    }

    public LoginPage checkAccountName(String accountName) {
        Assert.assertEquals(accountName, account.getText());
        return this;
    }

    public LoginPage checkAccountURL(String containURL) {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains(containURL));
        return this;
    }

    public LoginPage clickSubmit() {
        submitSigninButton.click();
        return this;
    }

    public LoginPage verifyLogout() {
    	assertTrue(logoutButton.isDisplayed());
    	return this;
        
    }
}

