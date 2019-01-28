package org.naic.mfl.se.pages;

import java.util.Date;

import org.naic.mfl.se.base.PageBase;
import org.naic.mfl.se.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage extends PageBase {

	// Login Button
	@FindBy(className = "login")
	WebElement loginButton;

	// Create Email Address
	@FindBy(id = "email_create")
	WebElement creatEmailAdd;
	
	// Click Submit Button
	@FindBy(id = "SubmitCreate")
	WebElement submitButton;
	
	// Gender Radio Button
	@FindBy(id = "id_gender2")
	WebElement genderRadio2;

	@FindBy(id = "customer_firstname")
	private WebElement firstName;

	@FindBy(id = "customer_lastname")
	private WebElement lastName;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "days")
	private WebElement days;
	
	@FindBy(id = "months")
	private WebElement months;
	
	@FindBy(id = "years")
	private WebElement years;

	@FindBy(id = "company")
	private WebElement company;

	@FindBy(id = "address1")
	private WebElement address1;
	
	@FindBy(id = "address2")
	private WebElement address2;

	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "id_state")
	private WebElement idState;
	
	@FindBy(id = "postcode")
	private WebElement postcode;
	
	@FindBy(id = "other")
	private WebElement other;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "phone_mobile")
	private WebElement phoneMobile;
	
	@FindBy(id = "alias")
	private WebElement alias;
	
	@FindBy(id = "submitAccount")
	private WebElement submitAccount;
	
	 @FindBy(className = "info-account")
	 private  WebElement accountInfo;

	//logout
    @FindBy(className = "logout")
    WebElement logoutButton;

	/*********************************************************************************************************
	 * 
	 * @param driver Constructor
	 */
	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*********************************************************************************************************
	 * Actions and Validations
	 * 
	 * 
	 */

	public void clickSingIn() {
		click(loginButton);
	}
	
	public void enterEmailAddress() {
		String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        setText(creatEmailAdd,email);
	}
	
	public void clicksubmitButton() {
		click(submitButton);
	}
	
	public void selectGenderRadio2() {
		getWait().until(ExpectedConditions.elementToBeClickable(genderRadio2));
		genderRadio2.click();
	}
	
	public void enterFirstName(String name) {
		setText(firstName,name);
	}
	
	public void enterLastName(String sureName) {
		setText(lastName,sureName);
	}
	
	public void enterPassword(String pward) {
		setText(password,pward);
	}
	
	public void selectDays(String value) {
		Select select = new Select(days);
		select.selectByValue(value);
	}
	
	public void selectMonths(String value) {
		Select select = new Select(months);
		select.selectByValue(value);
	}
	
	public void selectYears(String value) {
		Select select = new Select(years);
		select.selectByValue(value);
	}
	
	public void enterCompany(String comp) {
		setText(company, comp);
	}
	
	public void enterAddrees1(String add1, String add2) {
		String add = add1+", "+ add2;
		setText(address1, add);
	}
	
	public void enterAddrees2(String add) {
		setText(address1, add);
	}
	
	public void enterCity(String text) {
		setText(city, text);
	}
	
	public void selectStates(String value) {
		Select select = new Select(idState);
		select.selectByVisibleText(value);
	}
	
	public void enterPostcode(String text) {
		setText(postcode, text);
	}
	
	public void enterOther(String text) {
		setText(other, text);
	}
	
	public void enterPhone(String text) {
		setText(phone, text);
	}
	
	public void enterPhoneMobile(String text) {
		setText(phoneMobile, text);
	}
	
	public void enterAlias(String text) {
		setText(alias, text);
	}
	
	public void clicksubmitAccount() {
		click(submitAccount);
	}
	
	public void checkPageHeader(String heading) {
        WebElement pageHeader = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        Assert.assertEquals(heading, pageHeader.getText());
        Log.info("Page Header: " + pageHeader.getText());
    }	  
	
	public void checkAccountURL(String containURL) {
	     String url = getDriver().getCurrentUrl();
	     Assert.assertTrue(url.contains(containURL));
	}

	public void verifyLogout() {
	      logoutButton.isDisplayed();
	      Log.info(" Logout Button is displayed");
	 }
	
	 public void checkAccountInfo(String accountInformation) {
		 String account = accountInfo.getText(); 
		 String splitAccount = account.split("\\.")[0]+".";
		 Assert.assertEquals(splitAccount, accountInformation);
	    }
    
	 public void checkAccount(String name, String surname) {
		 Assert.assertEquals(getDriver().findElement(By.className("account")).getText(), name + " " + surname);
	 }
	
	
}
