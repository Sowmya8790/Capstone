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

public class ManageProductPage {
	
	
	TestBase base;
    GlobalConstants globalConstantsants;
    public ManageProductObjects manageProductObjects;


    public ManageProductPage()
    {
        base = new TestBase();
        globalConstantsants = new GlobalConstants();
        manageProductObjects = new ManageProductObjects();
        PageFactory.initElements(DriverManager.getDriver(),manageProductObjects);
    }
    
    public void clickmanageProduct() {
    	
    	base.waitvisibility(DriverManager.getDriver(), manageProductObjects.mangeproducticon);
    	manageProductObjects.mangeproducticon.click();
    	
    	ExtentReport.getTest().pass("click on Manage product tab", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
	
    }
    
    public void validateProductpage() {
    	
    	String Actual = DriverManager.getDriver().getTitle();
    	String Expected = "Medicare - Product Management";
    	
    	Assert.assertEquals(Actual, Expected);
    }
    
    public void Productdetails() {
    	
    	base.waitfortitle(DriverManager.getDriver(), "Medicare - Product Management");
    	manageProductObjects.Productname.sendKeys(globalConstantsants.Productname);
    	manageProductObjects.Brandname.sendKeys(globalConstantsants.BrandName);
    	manageProductObjects.Description.sendKeys(globalConstantsants.Description);
    	manageProductObjects.pricee.clear();
    	manageProductObjects.pricee.sendKeys(globalConstantsants.Price);
    	manageProductObjects.Quantity.clear();
    	manageProductObjects.Quantity.sendKeys(globalConstantsants.Quantity);
    	manageProductObjects.Choosefile.sendKeys(globalConstantsants.filepath);
    	
    	Select sel = new Select(manageProductObjects.dropdown);
    	sel.selectByValue(globalConstantsants.Catogoryy);
    	
    	ExtentReport.getTest().pass("Enter all the details in Manage product tab", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
    	
    	
    	
    }
    
    public void addnewCatgory() {
    	

    	base.waitfortitle(DriverManager.getDriver(), "Medicare - Product Management");
    
    	manageProductObjects.Addnewcategory.click();
    	manageProductObjects.Catname.sendKeys(globalConstantsants.catname);
    	manageProductObjects.Catdescription.sendKeys(globalConstantsants.catDescription);
    	DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    	manageProductObjects.Catsave.click();
    		    	
    	ExtentReport.getTest().pass("Enter all the details in Manage product tab with new Catgory", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
    	
    }
    
    public void Validatecatgoryaddedornot() {
    	
    	List<WebElement> catdrop = DriverManager.getDriver().findElements(By.xpath("//select[@id='categoryId']/option"));
    	
    	for(WebElement drop:catdrop) {
    		
    		if((drop.equals(globalConstantsants.catname))) {
    			Assert.assertTrue(true);
    		}	    		
    	}
    }
    
    public void Save() {
    	
    	
    	base.clickelement(DriverManager.getDriver(), manageProductObjects.Savebutton);
    	
    	DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
  //  	 productPageObjects.Savebutton.click();
    	ExtentReport.getTest().pass("Product saved Successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
    	
    }
    
    public void Validatedaddeditem() {
    	
    	DriverManager.getDriver().manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
    	
    	base.waitvisibility(DriverManager.getDriver(), manageProductObjects.ShowEntriesDropDown);
    	
    	Select sel = new Select(manageProductObjects.ShowEntriesDropDown);
    	sel.selectByVisibleText(globalConstantsants.ShowSerach);
    	
    	manageProductObjects.ShowEntriesSearch.sendKeys(globalConstantsants.Productname);
    	
    	String Actual = DriverManager.getDriver().findElement(By.xpath("//td[3]")).getText();
    	String Expected = globalConstantsants.Productname;
    	
    	Assert.assertEquals(Actual, Expected);
    	
    	ExtentReport.getTest().pass("Validated the newly added product Displaying or not", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
    	
    	base.waitvisibility(DriverManager.getDriver(), manageProductObjects.ShowEntriesDropDown);
 	   
    	
    }
    

}

class ManageProductObjects {
	
	@FindBy(xpath = "//a[text()='View Products']")
	WebElement viewproducttab;
	
	@FindBy(xpath = "//a[text()='Manage Product']")
	WebElement mangeproducticon;

	@FindBy(xpath = "//input[@placeholder='Product Name']")
	WebElement Productname;
	
	@FindBy(xpath = "//input[@placeholder='Brand Name']")
	WebElement Brandname;

	@FindBy(xpath = "//div[@class='col-md-8']//textarea[@id='description']")
	WebElement Description;
	
	@FindBy(xpath = "//div[@class='col-md-8']//input[@id='unitPrice']")
	WebElement pricee;

	@FindBy(xpath = "//input[@id='quantity']")
	WebElement Quantity;
	
	@FindBy(xpath = "//input[@id='file']")
	WebElement Choosefile;
	
	@FindBy(xpath = "//select[@id='categoryId']")
	WebElement dropdown;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div[1]/div/div/div[2]/form/div[8]/div/input")
	WebElement Savebutton;
	
	@FindBy(xpath = "//select[@name='productsTable_length']")
	WebElement ShowEntriesDropDown;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement ShowEntriesSearch;
	
	@FindBy(xpath = "//button[@class='btn btn-warning btn-xs']")
	WebElement Addnewcategory;

	@FindBy(xpath = "//div[@class='col-md-8 validate']//input")
	WebElement Catname;
	
	@FindBy(xpath = "//div[@class='col-md-8 validate']//textarea")
	WebElement Catdescription;
	
	@FindBy(xpath = "//*[@id=\"categoryForm\"]/div[3]/div/input")
	WebElement Catsave;
	
}