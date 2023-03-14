package extentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extent;
    private ExtentReport(){}

    public static void initReport()
    {
        if(Objects.isNull(extent))
        {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extent.html");
            extent.attachReporter(spark);
            spark.config().setReportName("Selenium Automation");
            spark.config().setDocumentTitle("Assessent project3");
            spark.config().setTheme(Theme.STANDARD);
        }

    }

    public static void closeReport()
    {
        if(Objects.nonNull(extent))
        {
            extent.flush();
        }

    }

    public static void createTest(String testcasename) {
        ExtentManager.setExtentTest(extent.createTest(testcasename));
    }

    public static ExtentTest getTest()
    {
        return ExtentManager.getExtentTest();
    }

}
