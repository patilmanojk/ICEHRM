package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import sprint0.login.POM.loginPagePOM;
import utils.constants;

import org.testng.annotations.BeforeSuite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class testBase {
	public static WebDriver driver;
	public static Logger logger;
	
	public testBase() {
		System.setProperty("log4j.configurationFile",constants.Path_LogFile + constants.File_log);
		logger = LogManager.getLogger(testBase.class);
		
	}

	@BeforeSuite
	public void beforeSuite() {
		logger.info("Test Execution started for ICE HRM");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(constants.URL);
		logger.info("Browser lunch succsessful with ICE HRM linkl");
		System.out.println(constants.Path_TestData);
		loginPagePOM.enterUserName(driver, constants.Username);
		loginPagePOM.enterPassWord(driver, constants.Password);
		loginPagePOM.clickLoginButton(driver);
		logger.info("ICE HRM login successful");

	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
		logger.info("Webdriver Quit successful");
	}

}
