package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"},
        features = "src/test/resources/features/",
        glue = "step_definitions",
        tags = "@apt"

)
public class CucumberRunner {
}
