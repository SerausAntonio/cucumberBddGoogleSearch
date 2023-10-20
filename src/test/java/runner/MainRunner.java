package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue={"stepDefinitions","hook"},
monochrome = false,dryRun = false, plugin = {"pretty","html:target/cucumber.html","json:target/report.json"})
public class MainRunner extends AbstractTestNGCucumberTests {

}
