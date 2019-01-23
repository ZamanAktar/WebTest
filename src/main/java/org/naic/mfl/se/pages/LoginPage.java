package org.naic.mfl.se.pages;
import org.naic.mfl.se.base.PageBase;
import org.naic.mfl.se.utilities.Log;
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

    //name
    @FindBy(className = "info-account")
    WebElement accountInfo;

    //Submit Button
    @FindBy(name = "SubmitLogin")
    WebElement submitSigninButton;

    //logout
    @FindBy(name = "logout")
    WebElement logoutButton;

    /*********************************************************************************************************
     * Actions and Validations
     */

    public void setEmail(String emailText) {
        Log.info("Email: " + emailText);
        email.sendKeys(emailText);
    }

    public void setPassword(String passwordText) {
        Log.info("Password: " + passwordText);

        password.sendKeys(passwordText);
    }

    public void checkPageHeader(String heading) {
        WebElement pageHeader = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        Assert.assertEquals(heading, pageHeader.getText());
        Log.info("Page Header: " + pageHeader.getText());
    }

    public void checkAccountName(String accountName) {
        Assert.assertEquals(accountName, account.getText());
    }

    public void checkAccountInfo(String accountInformation) {
        Assert.assertEquals(accountInformation, accountInfo.getText());
    }

    public void checkAccountURL(String containURL) {
        String url = getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains(containURL));
    }

    public void clickSubmit() {
        submitSigninButton.click();
        Log.info("Submit Login Button");
    }

    public void verifyLogout() {
        logoutButton.isDisplayed();
        Log.info(" Logout Button is displayed");
    }

}

