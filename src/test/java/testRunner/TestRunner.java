package testRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features/02_subscribe.feature",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/CucumberTestReport.html",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
        		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        		"rerun:target/failed_scenarios.txt"}
    
)

public class TestRunner  extends AbstractTestNGCucumberTests{

	
}
