package CucumberImplement;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = "./src/test/java/CucumberImplement/Login.feature",
        glue = {"CucumberImplement"},
        plugin = {
        "pretty","html:CucumberReports/LoginBDD.html"
        },
        monochrome = true
)

@RunWith(Cucumber.class)
public class Runner {
}
