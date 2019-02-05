package listerners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
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
        try {
			test.get().fail("details",MediaEntityBuilder.createScreenCaptureFromPath(result.getMethod().getMethodName() ).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
