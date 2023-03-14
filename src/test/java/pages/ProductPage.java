package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.TestBase;
import constants.GlobalConstants;
import driverManager.DriverManager;
import extentManager.ExtentReport;

public class ProductPage {
	
	  TestBase base;
	    GlobalConstants globalConstantsants;
	    public ProductPageObjects productPageObjects;


	    public ProductPage()
	    {
	        base = new TestBase();
	        globalConstantsants = new GlobalConstants();
	        productPageObjects = new ProductPageObjects();
	        PageFactory.initElements(DriverManager.getDriver(),productPageObjects);
	    }
	    
	    public void clickviewproduct() {
	    	
	    	base.waitvisibility(DriverManager.getDriver(), productPageObjects.viewproducttab);
	    	productPageObjects.viewproducttab.click();
	    	ExtentReport.getTest().pass("Clich on viewproduct tab", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
	    }
	    
	    public void oneitemaddtocart() {
	    	
	    	base.waitvisibility(DriverManager.getDriver(), productPageObjects.clickoncartone);
	    	productPageObjects.clickoncartone.click();
	    	
	    	ExtentReport.getTest().pass("Echeck weather the count added successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
	    	
	}
	    
	    
	    public void continueshoppingicon() {
	    	
	    	base.waitvisibility(DriverManager.getDriver(), productPageObjects.continueshopping);
	    	productPageObjects.continueshopping.click();
	    	ExtentReport.getTest().pass("Click on contyinue shopping icom", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	    	
	    }
	    public void seconditemaddtocart() {
	    	
	    	productPageObjects.clickoncarttwo.click();
	    
	    		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    		
	    			String[] minmax = {"1","2","3"};
	    			Boolean flag = false;
	    			
	    			for(WebElement quantity:productPageObjects.givecountone) {
	    				
	    					for(int i=0;i<3;i++){
	    			    		
	    			    		if(quantity.equals(minmax[i])){
			
	    			    				quantity.clear();
		    			    			quantity.sendKeys(globalConstantsants.count);
		    			    			flag = true;
	    			    				    			    			
	    			    	}
	    			    		else if(flag = false){
	    			    			System.out.println("Enter the count with range of 1 to 3");
	    			    		}	    					
	    				}	    			
	    			}
	    	    	
	    	
	    	ExtentReport.getTest().pass("Echeck weather the count added successfully for item 2", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());

	    }
	    
	    public void checkouticon() {
	    	base.waitvisibility(DriverManager.getDriver(), productPageObjects.checkoutbutton);
	    	productPageObjects.checkoutbutton.click();
	    	
	    	ExtentReport.getTest().pass("click on checkout icon", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
    	
	    }
	    
	    public void validateshippingpage() {
	    	base.waitvisibility(DriverManager.getDriver(), productPageObjects.ShippingIcon);
	    	Assert.assertTrue(productPageObjects.ShippingIcon.isDisplayed());	    	
	    }
	    		

}
class ProductPageObjects
{
	@FindBy(xpath = "//a[text()='View Products']")
	WebElement viewproducttab;
	
	@FindBy(xpath = "//tr[1]//a[@class='btn btn-success']")
	WebElement clickoncartone;
	
	@FindBy(xpath = "//tr[2]//a[@class='btn btn-success']")
	WebElement clickoncarttwo;
	
	@FindBy(xpath = "//a[@class='btn btn-warning']")
	WebElement continueshopping;
	
	@FindBy(xpath = "//input[@type='number']")
	List<WebElement> givecountone;
	

	@FindBy(xpath = "//a[@class='btn btn-success btn-block']")
	WebElement checkoutbutton;
	
	
	@FindBy(xpath = "//h4[text()='Select Shipping Address']")
	WebElement ShippingIcon;
	

}
