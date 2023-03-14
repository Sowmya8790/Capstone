package base;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;

import static driverManager.DriverManager.getDriver;

import java.time.Duration;


public class TestBase {



   public String getBase64()
   {
       return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
   }
   
   public static void waitvisibility(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitfortitle(WebDriver driver, String title) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public static void clickelement(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
}

