package stepsDefinitions;

import base.TestBase;
import driverManager.Driver;
import driverManager.DriverManager;
import extentManager.ExtentReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hook {

    public static String scenarioName;
    TestBase base = new TestBase();

    @Before
    public void before(Scenario scenario)  {

        Driver.initDriver();
        scenarioName = scenario.getName();
        ExtentReport.createTest(scenarioName);
   
    }

    @After
    public void after(Scenario scenario) {
    	

        if (scenario.isFailed()) {
            System.out.println("driver::" + DriverManager.getDriver());
            try {
                final byte[] screenshot =
                        ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName() + " is failed , Please check log output for more details");

            } catch (Exception e) {
                e.getMessage();
            }
        }

    }

}
