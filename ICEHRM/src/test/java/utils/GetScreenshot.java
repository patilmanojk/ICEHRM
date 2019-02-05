package utils;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import testbase.TestSetup;

public class GetScreenshot {
	//public static Logger logger;
	
	
	public static String getScreenshot(){
		//System.setProperty("log4j.configurationFile", constants.Path_LogFile + constants.File_log);
		//logger = LogManager.getLogger(GetScreenshot.class);
		String FolderPath = System.getProperty("user.dir");
		return FolderPath;
	}

	//String SysPath = System.getProperty("user.dir");
	public static void getScreenshot(WebDriver driver, String Methodname) {
		File ssFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String SysPath = System.getProperty("user.dir");
		SimpleDateFormat DTF = new SimpleDateFormat("yyyy_dd_MM_HH_mm_ss");
		Date dt = new Date();
		//String filename = null ;
		String currntdate = DTF.format(dt);
		//System.out.println(currntdate);
		try {
			FileUtils.copyFile(ssFile, new File(SysPath+"/Screenshots/"+Methodname+currntdate+".png"));
			 //filename = SysPath+"/Screenshots/"+Methodname+currntdate+".png";
			URL filename = new File(SysPath+"/Screenshots/"+Methodname+currntdate+".png").toURI().toURL();
			//System.out.println("Testcase Failure Screenshot saved at : "+ SysPath+"/Screenshots/"+Methodname+currntdate+".png");
			System.out.println("Testcase Failure Screenshot saved at : "+ filename);
			Reporter.log("Testcase Failure Screenshot saved at : "+ filename);
		  //  logger.info("Testcase Failure Screenshot saved at : "+ filename);
			TestSetup.logger.info("Testcase Failure Screenshot saved at : "+ filename);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return filename;
		//return (SysPath+"/Screenshot/"+Methodname+currntdate+".png");
	
	}
	
	public static void getScreenshot(WebDriver driver) {
		File ssFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String SysPath = System.getProperty("user.dir");
		SimpleDateFormat DTF = new SimpleDateFormat("yyyy_dd_MM_HH_mm_ss");
		Date dt = new Date();
		String currntdate = DTF.format(dt);
		System.out.println(currntdate);
		try {
			FileUtils.copyFile(ssFile, new File(SysPath+"/Screenshots/TestFailure"+currntdate+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//File myFile = new File(SysPath+"/Screenshot/TestFailure"+currntdate+".png");
		//URI myUrl = myFile.toURI();

		//return myUrl;

	}


}

