package extentManager;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager {

    private ExtentManager(){}

    private static ThreadLocal<ExtentTest> test =new ThreadLocal<>();

    public static ExtentTest getExtentTest()
    {
        return test.get();
    }
    public static void setExtentTest(ExtentTest testRef)
    {
        if(Objects.nonNull(testRef))
        {
            test.set(testRef);
        }
    }
    public static void unload()
    {
        test.remove();
    }
}
