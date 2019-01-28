package org.naic.mfl.se.challenge;

import java.util.HashMap;
import org.naic.mfl.se.base.NaicScriptBase;
import org.testng.annotations.Test;
import static org.naic.mfl.se.constants.ApplicationConstant.*;

public class LoginPageTest extends NaicScriptBase{
	
    String existingUserEmail = "";
    String existingUserPassword = "";
    String fullName = "";

	 @Test(description = "Log in to the Application")
	    public void logInTest() {
		 
		 HashMap<String , String > vars = readTextFileExternal(FILE_PATH, "LogInTest", "1");
		 existingUserEmail = vars.get("UserEmail");
		 existingUserPassword =  vars.get("UserPassword");
		 fullName = vars.get("UserFullName");
		 
		 appController().signinPage().clickSingIn();
		 appController().loginPage().setEmail(existingUserEmail)
	        						.setPassword(existingUserPassword)
	        						.clickSubmit()
	        						.checkPageHeader("MY ACCOUNT")
	        						.checkAccountName(fullName);
		 appController().signinPage().checkAccountInfo("Welcome to your account.");
		 appController().loginPage().verifyLogout()
	        						.checkAccountURL("controller=my-account");
	   
	    }

}
