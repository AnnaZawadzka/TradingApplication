package cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/features",
		glue = "src/test/java/cucumber/stepDefinitions",
		plugin = { "pretty", "html:target/cucumber", },
		//TODO: check what is it doing
		publish = true)

public class TestRunner {

}
