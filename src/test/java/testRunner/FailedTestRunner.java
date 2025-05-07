package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "@target/failed_scenarios.txt", // Run only failed scenarios
	    glue = {"stepDefinitions", "hooks"},
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/RerunTestReport.html"
	    }
	)
public class FailedTestRunner  extends AbstractTestNGCucumberTests{

}
