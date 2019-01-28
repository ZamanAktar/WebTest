package org.naic.mfl.se.challenge;

import org.apache.commons.lang.RandomStringUtils;
import org.naic.mfl.se.base.NaicScriptBase;
import org.testng.annotations.Test;

public class RegistrationPageTest extends NaicScriptBase{
	
	private static String name = "";
	private static String surname = "";
	
	@Test(description = "Create a new User")
	    public void signInTest() {
	    	
	        name = "Ak" +  RandomStringUtils.randomAlphabetic(10);
	        surname = "Za" +  RandomStringUtils.randomAlphabetic(10);
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
	        appController().signinPage().checkAccount(name,surname);
	        appController().signinPage().checkAccountInfo("Welcome to your account.");
	        appController().signinPage().verifyLogout();
	        appController().signinPage().checkAccountURL("controller=my-account");
	    }


}
