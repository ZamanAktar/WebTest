package org.naic.mfl.se.challenge;

import static org.naic.mfl.se.constants.ApplicationConstant.FILE_PATH;

import java.util.HashMap;

import org.naic.mfl.se.base.NaicScriptBase;
import org.testng.annotations.Test;

public class CheckoutPageTest extends NaicScriptBase {

	String existingUserEmail = "";
	String existingUserPassword = "";

	@Test(description = "Select a product and Checkout")
	public void checkoutTest() {
		HashMap<String, String> vars = readTextFileExternal(FILE_PATH, "LogInTest", "1");
		existingUserEmail = vars.get("UserEmail");
		existingUserPassword = vars.get("UserPassword");
		appController().signinPage().clickSingIn();
		appController().loginPage().setEmail(existingUserEmail);
		appController().loginPage().setPassword(existingUserPassword);
		appController().loginPage().clickSubmit();
		appController().checkoutPage().clickWomen();
		appController().checkoutPage().clickProduct();
		appController().checkoutPage().clickAddCart();
		appController().checkoutPage().clickCheckout();
		appController().checkoutPage().defaultcontent();
		appController().checkoutPage().clickCheckout();
		appController().checkoutPage().clickProcessAddress();
		appController().checkoutPage().clickCheckBox();
		appController().checkoutPage().clickProcessCheckOut();
		appController().checkoutPage().clickBankWire();
		appController().checkoutPage().clickConfirmOrder();
		appController().checkoutPage().orderConfirmation();
	}
}
