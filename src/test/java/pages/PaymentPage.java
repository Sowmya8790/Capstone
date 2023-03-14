package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.TestBase;
import constants.GlobalConstants;
import driverManager.DriverManager;
import extentManager.ExtentReport;

public class PaymentPage {
	
	TestBase base;
    GlobalConstants globalConstantsants;
    public PaymentPageObjects paymentPageObjects;


    public PaymentPage()
    {
        base = new TestBase();
        globalConstantsants = new GlobalConstants();
        paymentPageObjects = new PaymentPageObjects();
        PageFactory.initElements(DriverManager.getDriver(),paymentPageObjects);
    }
    
    public void credicarddetails() {
    	
    	base.waitvisibility(DriverManager.getDriver(),  paymentPageObjects.cardnumber);
    	paymentPageObjects.cardnumber.sendKeys(globalConstantsants.cardnum);
    	paymentPageObjects.expmonth.sendKeys(globalConstantsants.month);
    	paymentPageObjects.expyear.sendKeys(globalConstantsants.year);
    	paymentPageObjects.CVV.sendKeys(globalConstantsants.cvvcode);
    	
    	ExtentReport.getTest().pass("Enter All the details of credit card", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

    	
    }
    
    public void clickbutton() {
    	
    	base.waitvisibility(DriverManager.getDriver(),  paymentPageObjects.paybutton);
    	
    	paymentPageObjects.paybutton.click();
    	
    	ExtentReport.getTest().pass("Click on pay button", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

    }
    
    public void VaildateOrderconfirm() {
    	
    	base.waitvisibility(DriverManager.getDriver(),  paymentPageObjects.confrimedmessage);
    	
    	String Actual = paymentPageObjects.confrimedmessage.getText();
    	String Expected = "Your Order is Confirmed!!";
    	
    	Assert.assertEquals(Actual,Expected);
    	Assert.assertEquals(DriverManager.getDriver().getTitle(), "Medicare - Membership");
    	
    	ExtentReport.getTest().pass("Order confirmed should display", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

    	
    }
    
    public void ValidateTablets() {
    	
    	base.waitvisibility(DriverManager.getDriver(),  paymentPageObjects.Tabone);
    	
    	String actualtab = paymentPageObjects.Tabone.getText();
    	String Exptab = globalConstantsants.Selectedtab1;
    	
    	Assert.assertEquals(actualtab,Exptab);
    	
    	String actualtab2 = paymentPageObjects.Tabtwo.getText();
    	String Exptab2 = globalConstantsants.Selectedtab2;
    	
    	Assert.assertEquals(actualtab2,Exptab2);
    	
    	ExtentReport.getTest().pass("The final order summary", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

    }
    
    public void ValidateQuantity() {
    	
    	String actualq = paymentPageObjects.tabonequantity.getText();
    	String Expq = globalConstantsants.count;
    	
    	Assert.assertEquals(actualq,Expq);
    	
    	String actualq2 = paymentPageObjects.tabonequantity.getText();
    	String Expq2 = globalConstantsants.count;
    	
    	Assert.assertEquals(actualq2,Expq2);
    }

}
class PaymentPageObjects{
	
	@FindBy(xpath = "//input[@id='cardNumber']")
	WebElement cardnumber;
	
	@FindBy(xpath = "//input[@id='expityMonth']")
	WebElement expmonth;
	
	@FindBy(xpath = "//input[@id='expityYear']")
	WebElement expyear;
	
	@FindBy(xpath = "//input[@id='cvCode']")
	WebElement CVV;
	
	@FindBy(xpath = "//a[text()='Pay']")
	WebElement paybutton;
	
	@FindBy(xpath = "//h3[text()='Your Order is Confirmed!!']")
	WebElement confrimedmessage;
	
	@FindBy(xpath = "//tr[2]//preceding::tr[1]/td[1]")
	WebElement Tabone;
	
	@FindBy(xpath = "//tr[2]//preceding::tr[1]/td[3]")
	WebElement tabonequantity;
	
	@FindBy(xpath = "//tr[2]/td[1]")
	WebElement Tabtwo;
	
	@FindBy(xpath = "//tr[2]/td[3]")
	WebElement tabtwoquantity;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}