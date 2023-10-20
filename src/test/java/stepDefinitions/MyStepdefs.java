package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

public class MyStepdefs {
    private WebDriver driver;
    private WebDriverWait wait;
    @Given("I am on the Google page")
    public void iAmOnTheGooglePage() {
        wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.google.com/");
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTxt) {
   //     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alles accepteren']"))).click();
       driver.findElement(By.xpath("//*[text()='Alles accepteren']")).click();
      //  wait.until(ExpectedConditions.elementToBeClickable(By.name("q"))).sendKeys(searchTxt);
        driver.findElement((By.name("q"))).sendKeys(searchTxt);
        driver.findElement((By.name("q"))).sendKeys(Keys.RETURN);
    }

    @Then("the page title should start with {string}")
    public void thePageTitleShouldStartWith(String searchTxt) {
        String title = driver.getTitle().toLowerCase();
        Assert.assertTrue(title.startsWith(searchTxt));
    }
}
