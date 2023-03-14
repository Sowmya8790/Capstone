package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.TestBase;
import constants.GlobalConstants;
import driverManager.DriverManager;
import extentManager.ExtentReport;

public class ShippingPage {
	
	GlobalConstants globalConstants;
	TestBase base;
	ShippingPageObject shippingPageObjects;
	
	public ShippingPage() {
		
		base = new TestBase();
        globalConstants = new GlobalConstants();
        shippingPageObjects = new ShippingPageObject();
        PageFactory.initElements(DriverManager.getDriver(),shippingPageObjects);
				
	}
	
	public void Shippingdetails() {
		
		base.waitfortitle(DriverManager.getDriver(), "Medicare - Membership");
		
		shippingPageObjects.Addressline1.sendKeys(globalConstants.Add1);
		shippingPageObjects.Addressline2.sendKeys(globalConstants.Add2);
		shippingPageObjects.city.sendKeys(globalConstants.city);
		shippingPageObjects.Postalcode.sendKeys(globalConstants.postalcode);
		shippingPageObjects.state.sendKeys(globalConstants.State);
		shippingPageObjects.Country.sendKeys(globalConstants.Country);
		
		ExtentReport.getTest().pass("Enter All the details of address", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
	
	public void clickAddaddress() {
		
		base.waitvisibility(DriverManager.getDriver(), shippingPageObjects.AddAddressbutton);
		shippingPageObjects.AddAddressbutton.click();
		ExtentReport.getTest().pass("Clich on Address button", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	}
	
	public void ValidateTabnames() {
		
		String Actual1 = shippingPageObjects.TabletnameParacetamol.getText();
		String Expected1 = "Paracetamol";
		
		Assert.assertEquals(Actual1, Expected1);
		
		String Actual2 = shippingPageObjects.TabletnameCombiflame.getText();
		String Expected2 = "Combiflame";
		
		Assert.assertEquals(Actual2, Expected2);
		
	}
	
	
}

class ShippingPageObject
{
	
	@FindBy(xpath = "//input[@id='addressLineOne']")
	WebElement Addressline1;
	
	@FindBy(xpath = "//input[@id='addressLineTwo']")
	WebElement Addressline2;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@id='postalCode']")
	WebElement Postalcode;
	
	@FindBy(xpath = "//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@id='country']")
	WebElement Country;
	
	@FindBy(xpath = "//button[@name='_eventId_saveAddress']")
	WebElement AddAddressbutton;
	
	@FindBy(xpath = "//h3[text()='Paracetamol']")
	WebElement TabletnameParacetamol;
	
	@FindBy(xpath = "//h3[text()='Combiflame']")
	WebElement TabletnameCombiflame;
	

	
	
	
	
	
	
}