package cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "classpath:/features" },
		glue = { "classpath:/stepDefinitions" },
		plugin = { "pretty", "html:target/cucumber",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"json:target/allure-report/cucumber-report.json"
		})

public class TestRunner {

}
