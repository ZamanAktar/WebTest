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

public class CheckoutPage extends PageBase {

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*********************************************************************************************************
     * Locators  */

    // women
    @FindBy(linkText = "Women")
    WebElement women;

    // product
    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement product;

    //submit
    @FindBy(name = "Submit")
    WebElement submitButton;

    //checkout
    @FindBy(linkText = "Proceed to checkout")
    WebElement checkoutButton;

    //Address
    @FindBy(name = "processAddress")
    WebElement address;

    @FindBy(id = "uniform-cgv")
    WebElement uniform;

    @FindBy(className = "bankwire")
    WebElement bank;

    @FindBy(name = "processCarrier")
    WebElement processCarrier;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    WebElement cart;

    /*********************************************************************************************************
     * Actions and Validations
     */

    public void clickWomen() {
        women.click();
        Log.info("Click Women link");
    }
    public void clickProduct() {
        product.click();
        Log.info("Click product");
    }

    public void clickSubmitButton() {
        getWait().until(ExpectedConditions.visibilityOf(submitButton)).click();
        Log.info("Click Submit Button");
    }

    public void clickCheckout() {
    	getWait().until(ExpectedConditions.visibilityOf(checkoutButton)).click();
        Log.info("Click checkout Button");
    }

    public void clickAddress() {
    	getWait().until(ExpectedConditions.visibilityOf(address)).click();
        Log.info("Click Address");
    }

    public void clickUniform() {
    	getWait().until(ExpectedConditions.visibilityOf(uniform)).click();
        Log.info("Click Uniform");
    }

    public void clickProcess() {
       processCarrier.click();
        Log.info("Click process Carrier");
    }
    public void clickBank() {
    	getWait().until(ExpectedConditions.visibilityOf(bank)).click();
        Log.info("Click Bank");
    }

    public void clickCart() {
    	getWait().until(ExpectedConditions.visibilityOf(cart)).click();
        Log.info("Click Cart");
    }

    public void orderConfirmation() {
        WebElement heading = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        Assert.assertEquals("ORDER CONFIRMATION", heading.getText());
        Assert.assertTrue(getDriver().findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete."));
        Assert.assertTrue(getDriver().getCurrentUrl().contains("controller=order-confirmation"));
    }
}
