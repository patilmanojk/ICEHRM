package sprint0;

import testbase.TestSetup;
import utils.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sprint0.login.POM.TravelRequestPOM;

public class TravelRequest extends TestSetup {


	@Test(dataProvider = "dp")
	
	public void TravelRequestTab(String PurposeOfTraveltxt, String transport) throws InterruptedException
	{
		TestSetup.AUTlogin(getDriver());
		TravelRequestPOM.ClickOnTravelRequest(getDriver());
		WebDriverWait  wait= new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(TravelRequestPOM.employeeTravelRecordTableXpath), 0));
		TravelRequestPOM.ClickOnAddNewButton(getDriver());
		TestSetup.waitForJavascript(getDriver());
		TravelRequestPOM.ClickonEmployeeField(getDriver());
		TravelRequestPOM.clickOnEmployeeSearch(getDriver());
		TravelRequestPOM.ModeOfTransport(getDriver(), transport);
		TravelRequestPOM.PurposeOfTravel(getDriver(), PurposeOfTraveltxt);
		
	}
	
	@DataProvider
	public Object[][] dp() {
		  String sheetName = "Travel";
		  String tableName = "TravelRequest";
		  String xlFilePath = constants.Path_TestData+constants.File_TestData;
		  return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}

}
