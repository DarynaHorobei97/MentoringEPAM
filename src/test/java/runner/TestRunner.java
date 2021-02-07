package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "stepDefs",
        plugin = ("json:target/cucumber-reports/CucumberTestReport.json"),
        tags = "@Regression"
)



public class TestRunner {

}

//glue = "stepDefs",
//        plugin = {"pretty","html:target/cucumber-report"},