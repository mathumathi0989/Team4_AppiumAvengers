package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/searchChannel.feature",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/CucumberTestReport.html"}
        //tags = "@search"
)
public class TestRunner  extends AbstractTestNGCucumberTests{

	
	
}
