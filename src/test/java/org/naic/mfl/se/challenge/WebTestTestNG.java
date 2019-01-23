package org.naic.mfl.se.challenge;

import org.naic.mfl.se.base.ScriptBase;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebTestTestNG extends ScriptBase{
  
	WebDriverWait wait;
    String existingUserEmail = "mflsqe@naic.org";
    String existingUserPassword = "mflsqe1234";

    @Test
    public void signInTest() {
    	String name = "Firstname";
        String surname = "Lastname";
    	appController().signinPage().clickSingIn();
    	appController().signinPage().enterEmailAddress();
    	appController().signinPage().clicksubmitButton();
    	appController().signinPage().selectGenderRadio2();
    	appController().signinPage().enterFirstName(name);
    	appController().signinPage().enterLastName(surname);
    	appController().signinPage().enterPassword("Qwerty");
    	appController().signinPage().selectDays("1");
    	appController().signinPage().selectMonths("1");
    	appController().signinPage().selectYears("2000");
    	appController().signinPage().enterCompany("Company");
    	appController().signinPage().enterAddrees1("Qwerty", "123");
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
        appController().signinPage().checkAccount(name,surname);
        appController().signinPage().checkAccountInfo("Welcome to your account.");
        appController().signinPage().verifyLogout();
        appController().signinPage().checkAccountURL("controller=my-account");
    }

    @Test
    public void logInTest() {
        String fullName = "Joe Black";
        appController().signinPage().clickSingIn();
        appController().loginPage().setEmail(existingUserEmail);
        appController().loginPage().setPassword(existingUserPassword);
        appController().loginPage().clickSubmit();
        appController().loginPage().checkPageHeader("MY ACCOUNT");
        appController().loginPage().checkAccountName(fullName);
        appController().loginPage().checkAccountInfo("Welcome to your account.");
        appController().loginPage().verifyLogout();
        appController().loginPage().checkAccountURL("controller=my-account");
    }

    @Test
    public void checkoutTest() {
    	appController().signinPage().clickSingIn();
        appController().loginPage().setEmail(existingUserEmail);
        appController().loginPage().setPassword(existingUserPassword);
        appController().loginPage().clickSubmit();
        appController().checkoutPage().clickWomen();
        appController().checkoutPage().clickProduct();
        appController().checkoutPage().clickSubmitButton();
        appController().checkoutPage().clickCheckout();
        appController().checkoutPage().clickCheckout();
        appController().checkoutPage().clickAddress();
        appController().checkoutPage().clickUniform();
        appController().checkoutPage().clickProcess();
        appController().checkoutPage().clickBank();
        appController().checkoutPage().clickCart();
        appController().checkoutPage().orderConfirmation(); 
    }
}
