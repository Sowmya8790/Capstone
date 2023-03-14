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

public class RegisterPage {
	
	GlobalConstants globalConstants;
	TestBase base;
	RegisterPageObject registerPageObjects;
	
	public RegisterPage() {
		
		base = new TestBase();
        globalConstants = new GlobalConstants();
        registerPageObjects = new RegisterPageObject();
        PageFactory.initElements(DriverManager.getDriver(),registerPageObjects);
				
	}
	
	public void registerhere() {
		
		base.waitvisibility(DriverManager.getDriver(), registerPageObjects.Registerherelink);
		
		registerPageObjects.Registerherelink.click();
		
		ExtentReport.getTest().pass("Click on registerhere", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
	
	public void Personaldetails() {
		
		base.waitvisibility(DriverManager.getDriver(), registerPageObjects.Firstname);
		
		
		registerPageObjects.Firstname.sendKeys(globalConstants.regfirstname);
		registerPageObjects.Lastname.sendKeys(globalConstants.regLastname);
		registerPageObjects.email.sendKeys(globalConstants.email);
		registerPageObjects.contactnum.sendKeys(globalConstants.regContact);
		registerPageObjects.Password.sendKeys(globalConstants.regPassword);
		registerPageObjects.ReTypePassword.sendKeys(globalConstants.regPassword);
		
		ExtentReport.getTest().pass("Enter All the personal details", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
	
	public void Selectuser() {
		
		base.waitvisibility(DriverManager.getDriver(), registerPageObjects.Roleuser);
		
		registerPageObjects.Roleuser.click();
		
		ExtentReport.getTest().pass("Select on User role", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
	
	public void nextbilling() {
		
		base.waitvisibility(DriverManager.getDriver(), registerPageObjects.NextBilling);
		
		Assert.assertTrue(registerPageObjects.NextBilling.isEnabled());
		registerPageObjects.NextBilling.click();
		
		ExtentReport.getTest().pass("Click on nextbilling", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
	
	public void AddressDetails() {
		
		base.waitvisibility(DriverManager.getDriver(), registerPageObjects.Addressline1);
		
		registerPageObjects.Addressline1.sendKeys(globalConstants.regAddress1);
		registerPageObjects.Addressline2.sendKeys(globalConstants.regAddress2);
		registerPageObjects.City.sendKeys(globalConstants.regCity);
		registerPageObjects.PostalCode.sendKeys(globalConstants.regPostalcode);
		registerPageObjects.State.sendKeys(globalConstants.regState);
		registerPageObjects.Country.sendKeys(globalConstants.Country);
		
		ExtentReport.getTest().pass("Enter All the details of address", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

		
	}
	
	public void clicknext() {
		
		base.waitvisibility(DriverManager.getDriver(), registerPageObjects.NextButton);
		
		Assert.assertTrue(registerPageObjects.BackButton.isEnabled());
		registerPageObjects.NextButton.click();
		
		ExtentReport.getTest().pass("Click on nextbutton", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

		base.waitvisibility(DriverManager.getDriver(), registerPageObjects.Confirmbutton);
		
		registerPageObjects.Confirmbutton.click();
		
		ExtentReport.getTest().pass("Validate Welcome Page", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
	
	public void Valiatewelcomepage() {
		
		base.waitvisibility(DriverManager.getDriver(), registerPageObjects.Clickloginhere);
		
		Assert.assertTrue(registerPageObjects.Welcometext.isDisplayed());
		registerPageObjects.Clickloginhere.click();
		
		ExtentReport.getTest().pass("Click on loginhere", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
	
	public void credentials() {
		
		base.waitvisibility(DriverManager.getDriver(), registerPageObjects.username);
		
		registerPageObjects.username.sendKeys(globalConstants.email);
		registerPageObjects.regpassword.sendKeys(globalConstants.regPassword);
		
		ExtentReport.getTest().pass("Enter credentials", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
	
	public void Validateuser() {
		
		base.waitfortitle(DriverManager.getDriver(), "Medicare - Home");
		
		Assert.assertEquals(DriverManager.getDriver().getTitle(), "Medicare - Home");
		
		ExtentReport.getTest().pass("Home Page", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
		

}

class RegisterPageObject{
	
	@FindBy(xpath = "//a[text()='Register Here']")
	WebElement Registerherelink;
	
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement Firstname;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement Lastname;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='contactNumber']")
	WebElement contactnum;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement ReTypePassword;
	
	
	@FindBy(xpath = "//input[@id='role1']")
	WebElement Roleuser;
	
	@FindBy(xpath = "//button[@name='_eventId_billing']")
	WebElement NextBilling;
	
	@FindBy(xpath = "//input[@id='addressLineOne']")
	WebElement Addressline1;
	
	@FindBy(xpath = "//input[@id='addressLineTwo']")
	WebElement Addressline2;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement City;
	
	@FindBy(xpath = "//input[@id='postalCode']")
	WebElement PostalCode;
	
	@FindBy(xpath = "//input[@id='state']")
	WebElement State;
	
	@FindBy(xpath = "//input[@id='country']")
	WebElement Country;
	
	@FindBy(xpath = "//button[@name='_eventId_personal']")
	WebElement BackButton;
	
	@FindBy(xpath = "//button[@name='_eventId_confirm']")
	WebElement NextButton;
	
	@FindBy(xpath = "//a[text()='Confirm']")
	WebElement Confirmbutton;
	
	@FindBy(xpath = "//h1[text()='Welcome!']")
	WebElement Welcometext;
	
	@FindBy(xpath = "//a[text()='Login Here']")
	WebElement Clickloginhere;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement regpassword;
	
	@FindBy(xpath = "//a[@class='btn btn-default dropdown-toggle']")
	WebElement ValidateUsername;
	
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbutton;
	
	
	
	
}