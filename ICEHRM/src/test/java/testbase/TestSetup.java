package testbase;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import sprint0.login.POM.HomePagePOM;
import sprint0.login.POM.loginPagePOM;
import utils.ExcelUtil;
import utils.GetScreenshot;
import utils.constants;

public class TestSetup {
	static WebDriver driver;
	public static Logger logger;
	static ExtentTest test;

	public TestSetup() {
		System.setProperty("log4j.configurationFile", constants.Path_LogFile + constants.File_log);
		logger = LogManager.getLogger(testBase.class);

	}

	public static void tearDown(WebDriver driver, ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		if (result.isSuccess() == false) {
			GetScreenshot.getScreenshot(driver, methodname);
		}
		driver.quit();

	}

	public static void chromeBrowserSetup() {
		WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
	}

	public static void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(pageLoadCondition);
	} 

	public static WebDriver invokeBrowseraAndAUT( String runMode) {
			if( runMode.contains("hidden" ) )
		{
        ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("disable-gpu");
		options.addArguments("window-size=1200,1100");
		
		
		String downloadFilepath = System.getProperty("user.dir") + "/Download/";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		//ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);


		driver = new ChromeDriver(options); }
			else {
		ChromeOptions options = new ChromeOptions();
		String downloadFilepath = System.getProperty("user.dir") + "/Download/";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		//ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);}
		driver.get(constants.URL);
		driver.manage().window().fullscreen();
		return driver;
	}

	public static void AUTlogin(WebDriver driver) {
		loginPagePOM.enterUserName(driver, constants.Username);
		loginPagePOM.enterPassWord(driver, constants.Password);
		loginPagePOM.clickLoginButton(driver);
		HomePagePOM.clickadminMenu(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePagePOM.appLanguageOptionsXpath)));
		HomePagePOM.clickappLanguageOptions(driver);
		HomePagePOM.clickAppEngLanguageSelect(driver);
	}
	
	public static void waitForJavascript(WebDriver driver) {
		int maxWaitMillis = 10000;
		int pollDelimiter = 500;
		
	    double startTime = System.currentTimeMillis();
	    while (System.currentTimeMillis() < startTime + maxWaitMillis) {
	        String prevState = driver.getPageSource();
	        try {
				Thread.sleep(pollDelimiter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // <-- would need to wrap in a try catch
	        if (prevState.equals(driver.getPageSource())) {
	            return;
	        }
	    }
	}


	public static Object[][] DataProviderRead(String xlFilePath, String sheetName, String tableName) {
		Object[][] Excelldata = null;

		try {
			Excelldata = ExcelUtil.getDataTableCellValues(xlFilePath, sheetName, tableName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Excelldata;
	};

	public static WebDriver getDriver() {
		return TestSetup.driver;
	}

	@BeforeTest
	public void beforeTest() {
		/*-------------"BeforeTest method chromeBrowserSetup started "-----------------------*/
		TestSetup.chromeBrowserSetup();

		/*-------------"BeforeTest method chromeBrowserSetup completed "-----------------------*/
	}

	@BeforeMethod
	@Parameters({"runMode"})
	public void beforeMethod(Method method, @Optional("browser") String runMode) {
		
		/*-------------"beforeTest Method - invokeBrowseraAndAUT Started"-----------------------*/
		//if you want to get the class name in before method
	      String classname = getClass().getSimpleName();
	   //IF you want to get the method name in the before method 
	      String methodName = method.getName() ;
	      logger.info("Test Execution started for ClassName : " + classname + " Method Name: "+ methodName);
		  driver = invokeBrowseraAndAUT(runMode);
		/*-------------"beforeTest Method - invokeBrowseraAndAUT completed"-----------------------*/

	}

	@AfterMethod
	public void afterTest(ITestResult result, Method method) {
		/*-------------"AfterTest Method - tearDown Started"-----------------------*/
		String testresult;
		//if you want to get the class name in before method
	      String classname = getClass().getSimpleName();
	    //IF you want to get the method name in the before method 
	     String methodName = method.getName() ;
	     TestSetup.tearDown(driver, result);
		if (result.isSuccess() == false) {
			logger.info("---------------------------Error Thrown---------------------------------------"					
					+ result.getThrowable().getMessage()   );
			
		}
		
		if (result.isSuccess() == true) {
			testresult = "Passed";
			
		}
		else {
			testresult = "failed";
		}
		logger.info("Test Execution completed for ClassName : " + classname + " Method Name: "+ methodName + " TestResult: " + testresult);
		/*-------------"AfterTest Method - tearDown completed"-----------------------*/
	}

	@AfterTest
	public void afterTest() {
		/*-------------"After Test - No action to be performed"-----------------------*/
	}
	
	@BeforeSuite
	public void beforeSuite() {
		logger.info("Test Execution started for ICE HRM");
	}

	@AfterSuite
	public void afterSuite() {
		logger.info("Webdriver Quit successful");
		/*Not neeeded on MAC***
		 * 
		 * try {
			Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM Chrome.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}


}
