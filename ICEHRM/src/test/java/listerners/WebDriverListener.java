package listerners;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import testbase.LocalDriverFactory;
import testbase.LocalDriverManager;
import utils.constants;
 
public class WebDriverListener implements IInvokedMethodListener {
 

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver = LocalDriverFactory.createInstance(browserName);
            LocalDriverManager.setWebDriver(driver);
            System.out.println("Thread id = " + Thread.currentThread().getId());
            System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
            LocalDriverManager.getDriver().get(constants.URL);
            driver.manage().window().fullscreen();
           
        }
    }
 

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = LocalDriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
