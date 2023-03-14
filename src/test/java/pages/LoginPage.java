package pages;

import base.TestBase;
import com.aventstack.extentreports.MediaEntityBuilder;

import constants.GlobalConstants;

import driverManager.DriverManager;
import extentManager.ExtentReport;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class LoginPage {

    TestBase base;
    GlobalConstants globalConstantsants;
    public LoginObjects loginObjects;
    HashMap<Integer, String> map = new HashMap<Integer,String>();


    public LoginPage()
    {
        base = new TestBase();
        globalConstantsants = new GlobalConstants();
        loginObjects = new LoginObjects();
        PageFactory.initElements(DriverManager.getDriver(),loginObjects);
    }


	public void launchapplixation() {
		
		DriverManager.getDriver().get(globalConstantsants.appURL);
		base.waitvisibility(DriverManager.getDriver(), loginObjects.medicarelogo);
		DriverManager.getDriver().manage().window().maximize();
		 ExtentReport.getTest().pass("User launch the URL.",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
		
	}
	
	public void validatelogo() {
		
		base.waitvisibility(DriverManager.getDriver(), loginObjects.medicarelogo);
		Assert.assertTrue(loginObjects.medicarelogo.isDisplayed());
		
	}
	
	public void clickonlogin() {
		
		base.waitvisibility(DriverManager.getDriver(), loginObjects.loginclcik);
		 ExtentReport.getTest().pass("Click on login.",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
		loginObjects.loginclcik.click();
	}
	
	public void setusername(String user,String pass) {
		
		base.waitvisibility(DriverManager.getDriver(), loginObjects.username);
		loginObjects.username.sendKeys(user);
		loginObjects.password.sendKeys(pass);
		 ExtentReport.getTest().pass("Enter the user and password",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
	}
	
	public void login() {
		
		 ExtentReport.getTest().pass("Click on login button",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
		base.waitvisibility(DriverManager.getDriver(), loginObjects.loginbutton);
		loginObjects.loginbutton.click();
		
	//	Alert al = DriverManager.getDriver().switchTo().alert();
	//	al.accept();
		
	}
	
	public void Validateafterlogin() {
		
		String expected = DriverManager.getDriver().getTitle();
		String actual = "Medicare - Home";
		
		base.waitfortitle(DriverManager.getDriver(), "Medicare - Home");
		Assert.assertEquals(expected,actual );
		 ExtentReport.getTest().pass("Logged into application",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
		 
		 int i=1;
	    	for(WebElement product:loginObjects.MoreProducts) {
	    		
	    		System.out.println(product.getText());
	    		map.put(i, product.getText());	    		
	    		i++;	    		
	    	}
	    	
	    	System.out.println(map);
	}	
}

class LoginObjects{
	

	 @FindBy(xpath ="//table[@id='productListTable']//td[2]")
	 List<WebElement> MoreProducts;
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement medicarelogo;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginclcik;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement loginbutton;
}
