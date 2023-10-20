package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Locale;

public class MyStepdefs {
    WebDriver driver;
    @Given("I am on the Google page")
    public void iAmOnTheGooglePage() {
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.google.com/");
    }

    @When("I search for {string}")
    public void iSearchFor(String arg0) {
        driver.findElement(By.xpath("//*[text()='Alles accepteren']")).click();
        driver.findElement(By.name("q")).sendKeys(arg0);
        driver.findElement((By.name("q"))).sendKeys(Keys.RETURN);
    }

    @Then("the page title should start with {string}")
    public void thePageTitleShouldStartWith(String arg0) {
        String title = driver.getTitle().toLowerCase();
        Assert.assertTrue(title.startsWith(arg0));
    }
}