package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Volumes/Development/SampleSelenium/AutomationPOC/src/test/resources/features"},
		glue = {"stepdefinitions", "hooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				 },
		monochrome = true
		)
public class TestRunner {

}
