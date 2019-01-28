package org.naic.mfl.se.pages;

import org.naic.mfl.se.base.PageBase;
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
    @FindBy(xpath = "//*[@name='Submit']/span")
    WebElement addCart;

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
        click(women);
 
    }
    public void clickProduct() {
        click(product);
     
    }

    public void clickAddCart() {
    	WebElement frame = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("fancybox-iframe")));
    	getDriver().switchTo().frame(frame);	
       click(addCart);
    
    }

    public void clickCheckout() {
    	click(checkoutButton);
    }

    public void clickProcessAddress() {
    	click(address);
    }

    public void clickCheckBox() {
    	click(uniform);
    }

    public void clickProcessCheckOut() {
       click(processCarrier);
       
    }
    public void clickBankWire() {
    	click(bank);
        
    }

    public void clickConfirmOrder() {
    	click(cart);
    }

    public void orderConfirmation() {
        WebElement heading = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        Assert.assertEquals("ORDER CONFIRMATION", heading.getText());
        Assert.assertTrue(getDriver().findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete."));
        Assert.assertTrue(getDriver().getCurrentUrl().contains("controller=order-confirmation"));
    }
    
    public void defaultcontent() {
    	getDriver().switchTo().defaultContent();
    }
}
