package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver initializeDriver(){
        driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
