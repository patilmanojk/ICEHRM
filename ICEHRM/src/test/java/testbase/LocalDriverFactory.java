package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalDriverFactory {
    public static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
      //  browserName = browserName != null ? browserName : "chrome";
        if (browserName.toLowerCase().contains("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("internet")) {
        	WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("chrome")) {
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        }
        return driver;
    }
}
