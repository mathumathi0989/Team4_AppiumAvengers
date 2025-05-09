package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/CucumberTestReport.html",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
        		"rerun:target/failed_scenarios.txt"}
     
)
public class TestRunner  extends AbstractTestNGCucumberTests{

	
	
}
