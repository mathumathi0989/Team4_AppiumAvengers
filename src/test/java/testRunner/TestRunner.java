package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty", "json:target/cucumber-reports/CucumberTestReport.json"}
)
public class TestRunner  extends AbstractTestNGCucumberTests{

}
