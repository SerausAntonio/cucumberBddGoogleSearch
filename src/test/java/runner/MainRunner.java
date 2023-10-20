package runner;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(features = {"classpath:features"}, glue={"stepDefinitions","hook"},
snippets=CAMELCASE ,monochrome = false,dryRun = false, plugin = {"pretty","html:target/cucumber.html","json:target/report.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
@Override
@DataProvider(parallel = false)
   public Object[][] scenarios(){
       return super.scenarios();
   }
}
