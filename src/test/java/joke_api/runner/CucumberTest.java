package joke_api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features",
	glue = "joke_api.steps",
	plugin = {
		"pretty",
		"html:build/reports/cucumber/cucumber.html",
		"json:build/reports/cucumber/cucumber.json"
	}
)
public class CucumberTest {
}
