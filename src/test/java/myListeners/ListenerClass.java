package myListeners;

import base.TestBase;
import com.aventstack.extentreports.MediaEntityBuilder;
import driverManager.Driver;
import extentManager.ExtentReport;
import org.testng.*;

public class ListenerClass implements ITestListener, ISuiteListener {

    TestBase base=new TestBase();
    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        ExtentReport.closeReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        Driver.closeDriver();

    }

    @Override
    public void onTestFailure(ITestResult result) {
      //  ITestListener.super.onTestFailure(result);
        ExtentReport.getTest().fail(result.getMethod().getMethodName()+ " is failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
        Driver.closeDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        Driver.closeDriver();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        Driver.closeDriver();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        Driver.closeDriver();
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        Driver.closeDriver();
    }
}
