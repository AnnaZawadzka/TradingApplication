package cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/features" },
		glue = { "src/test/java/stepDefinitions" },
		plugin = { "pretty", "html:target/cucumber", })

public class TestRunner {

}
