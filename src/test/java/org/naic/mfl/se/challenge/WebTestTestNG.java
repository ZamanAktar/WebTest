package org.naic.mfl.se.challenge;

import org.apache.commons.lang.RandomStringUtils;
import org.naic.mfl.se.base.NaicScriptBase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebTestTestNG extends NaicScriptBase{
  
	WebDriverWait wait;
    String existingUserEmail = "mflsqe@naic.org";
    String existingUserPassword = "mflsqe1234";
    private static  String fName;
    private static  String lName;

    @Test(priority=1,description = "Create a new User")
    public void signInTest() {
        fName = "FName_" +  RandomStringUtils.randomAlphanumeric(10);
		lName = "LName_" +  RandomStringUtils.randomAlphanumeric(10);
    	
		appController().signinPage().clickSingIn();
    	appController().signinPage().enterEmailAddress();
    	appController().signinPage().clicksubmitButton();
    	appController().signinPage().selectGenderRadio2();
    	appController().signinPage().enterFirstName(fName);
    	appController().signinPage().enterLastName(lName);
    	appController().signinPage().enterPassword("Qwerty");
    	appController().signinPage().selectDays("1");
    	appController().signinPage().selectMonths("1");
    	appController().signinPage().selectYears("2000");
    	appController().signinPage().enterCompany("Company");
    	appController().signinPage().enterAddrees1("Qwerty", "123 ");
    	appController().signinPage().enterAddrees2("zxcvb");
    	appController().signinPage().enterCity("Qwerty");
    	appController().signinPage().selectStates("Colorado");
    	appController().signinPage().enterPostcode("12345");
    	appController().signinPage().enterOther("Qwerty");
    	appController().signinPage().enterPhone("12345123123");
    	appController().signinPage().enterPhoneMobile("12345123123");
    	appController().signinPage().enterAlias("hf");
    	appController().signinPage().clicksubmitAccount();
    	appController().signinPage().checkPageHeader("MY ACCOUNT");
        appController().signinPage().checkAccount( fName,lName);
        appController().signinPage().checkAccountInfo("Welcome to your account.");
        appController().signinPage().verifyLogout();
        appController().signinPage().checkAccountURL("controller=my-account");
    }

    @Test(priority=2, description = "Log in to the Application")
    public void logInTest() {
        String fullName = "Joe Black";
        appController().signinPage().clickSingIn();
        appController().loginPage().setEmail(existingUserEmail);
        appController().loginPage().setPassword(existingUserPassword);
        appController().loginPage().clickSubmit();
        appController().loginPage().checkPageHeader("MY ACCOUNT");
        appController().loginPage().checkAccountName(fullName);
        appController().signinPage().checkAccountInfo("Welcome to your account.");
        appController().loginPage().verifyLogout();
        appController().loginPage().checkAccountURL("controller=my-account");
    }

    @Test(priority=3, description = "Select a product and Checkout")
    public void checkoutTest() {
    	appController().signinPage().clickSingIn();
        appController().loginPage().setEmail(existingUserEmail);
        appController().loginPage().setPassword(existingUserPassword);
        appController().loginPage().clickSubmit();
        appController().checkoutPage().clickWomen();
        appController().checkoutPage().clickProduct();
        appController().checkoutPage().clickAddCart();
        appController().checkoutPage().clickCheckout();
        appController().checkoutPage().clickCheckout();
        appController().checkoutPage().clickProcessAddress();
        appController().checkoutPage().clickCheckBox();
        appController().checkoutPage().clickProcessCheckOut();
        appController().checkoutPage().clickBankWire();
        appController().checkoutPage().clickConfirmOrder();
        appController().checkoutPage().orderConfirmation(); 
    }
}
