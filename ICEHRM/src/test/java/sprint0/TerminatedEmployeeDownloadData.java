package sprint0;


import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sprint0.login.POM.EmployessEmployeesPagePOM;
import sprint0.login.POM.HomePagePOM;
import testbase.TestSetup;
import utils.FileDownload;
import utils.constants;

public class TerminatedEmployeeDownloadData extends TestSetup {
	
	@Test(priority = 1, dataProvider = "EmployeeDataDownLoad"/* , enabled = false */)
	public void testTerminateEmployeeDataDownLoad(String searchKey, String FileName) throws AWTException, InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		SoftAssert softAssertion1 = new SoftAssert();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());	
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.deactivatedEmployesTabXpath)));
		EmployessEmployeesPagePOM.clickdeactivatedEmployesTab(getDriver());
		EmployessEmployeesPagePOM.clickTerminatedEmployeeDataMenu(getDriver());
		EmployessEmployeesPagePOM.waitforArchivedEmployeeTableXpathPageReady(getDriver());
		int  beforeDeletion = EmployessEmployeesPagePOM.numberofArchivedEmployees(getDriver());
		FileDownload.DeleteExistingFile(FileName);
		EmployessEmployeesPagePOM.SelectEmployeeArchieveDataDownload(getDriver(), searchKey);	
		FileDownload.WaitforFileDownLoad(FileName);
		softAssertion1.assertEquals(FileDownload.DeleteExistingFile(FileName), "File already exist" );	
		int  afterDeletion = EmployessEmployeesPagePOM.numberofArchivedEmployees(getDriver());
		softAssertion1.assertTrue(afterDeletion == beforeDeletion );
		softAssertion1.assertAll();
	}
	
	
	@DataProvider
	public Object[][] EmployeeDataDownLoad() {
		String sheetName = "Employee";
		String tableName = "EmployeeDataDownLoad";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}

}

