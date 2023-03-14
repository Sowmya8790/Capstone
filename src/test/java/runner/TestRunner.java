package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        features = "features",
        glue = "stepsDefinitions",
       // tags = {"@user", "admin"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,

        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber-reports/cucumber-report.html",
                "json:target/cucumber-reports/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failedrerun.txt",
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

  /*      @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
*/
}
