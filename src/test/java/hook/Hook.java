package hook;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hook {
    private WebDriver driver;
    @Before
    public void setUp(Scenario scenario){
        System.out.println(scenario.getName());
        driver = DriverFactory.initializeDriver();
        driver.manage().window().maximize();
    }
    @AfterStep
    public void afterStep(Scenario scenario){
           if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
           }
    }
    @After
    public void tearDown (Scenario scenario){
        System.out.println(scenario.getStatus());
        driver.quit();
    }
}
