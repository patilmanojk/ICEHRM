package listerners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.TestSetup;
import utils.ExtentManager;

public class TestListener extends TestSetup implements ITestListener {
	 
    //Extent Report Declarations
	ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/TestReport/ICE-HRM-TestReport.html");
    private static ExtentReports extent = ExtentManager.createInstance();

    
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
 
    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Test Suite started!");
    }
 
    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println((" Test Suite is ending!"));
        extent.flush();
    }
 
    @Override
    public synchronized void onTestStart(ITestResult result) {
    	extent.attachReporter(html);
    	html.config().setAutoCreateRelativePathMedia(true);
    	html.config().setAutoCreateRelativePathMedia(true);
    	html.config().setCSS("css-string");
    	html.config().setDocumentTitle("page title");
    	html.config().setEncoding("utf-8");
    	html.config().setJS("js-string");
    	html.config().setProtocol(Protocol.HTTPS);
    	html.config().setReportName("build name");
    	html.config().setTheme(Theme.DARK);
    	html.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
    	
    	//html.loadXMLConfig(System.getProperty("user.dir") +"/html-config.xml");
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }
 
    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }
 
    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
        
        

		ITestContext context = result.getTestContext();
		WebDriver driver = TestSetup.getDriver();

		String targetLocation = null;

		String testClassName = getClass().getSimpleName();
		SimpleDateFormat DTF = new SimpleDateFormat("yyyy_dd_MM_HH_mm_ss");
		Date dt = new Date();
		//String filename = null ;
		String timeStamp = DTF.format(dt);
		//String timeStamp = Util.getCurrentTimeStamp(); // get timestamp
		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + timeStamp + ".png";
		String fileSeperator = System.getProperty("file.separator");
		String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
				+ "screenshots";
		logger.info("Screen shots reports path - " + reportsPath);
		try {
			File file = new File(reportsPath + fileSeperator + testClassName); // Set
																				// screenshots
																				// folder
			if (!file.exists()) {
				if (file.mkdirs()) {
					logger.info("Directory: " + file.getAbsolutePath() + " is created!");
				} else {
					logger.info("Failed to create directory: " + file.getAbsolutePath());
				}

			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;// define
																											// location
			File targetFile = new File(targetLocation);
			logger.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
			logger.info("Target File location - " + targetFile.getAbsolutePath());
			FileHandler.copy(screenshotFile, targetFile);

		} catch (FileNotFoundException e) {
			logger.info("File not found exception occurred while taking screenshot " + e.getMessage());
		} catch (Exception e) {
			logger.info("An exception occurred while taking screenshot " + e.getCause());
		}

		// attach screenshots to report
		try {
			test.get().fail("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
			//ExtentTestManager.getTest().fail("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (IOException e) {
			logger.info("An exception occured while taking screenshot " + e.getCause());
		}
		//ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		test.get().log(Status.FAIL, "Test Failed");
		
		
    
    }
 
    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
}
