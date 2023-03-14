package driverManager;



import constants.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.Objects;




public class Driver {

    public static void initDriver() {
        GlobalConstants globalConstants = new GlobalConstants();
        if (Objects.isNull(DriverManager.getDriver())) {
            if (globalConstants.browser.equalsIgnoreCase("chrome")) {

            	WebDriverManager.chromedriver().setup();
                //driver = new EdgeDriver();
                DriverManager.setDriver(new ChromeDriver());
               
            } else if (globalConstants.browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                //driver = new EdgeDriver();
                DriverManager.setDriver(new EdgeDriver());
            } else if (globalConstants.browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                // driver = new FirefoxDriver();

                DriverManager.setDriver(new FirefoxDriver());
            } else if (globalConstants.browser.equalsIgnoreCase("ie")) {
                WebDriverManager.iedriver().setup();
                //driver = new InternetExplorerDriver();

                DriverManager.setDriver(new InternetExplorerDriver());
            }
            
            //   driver.manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        }
    }

    public static void closeDriver() {

        if(Objects.nonNull(DriverManager.getDriver()))
        {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
