package sprint0;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sprint0.login.POM.EmployessEmployeesPagePOM;
import sprint0.login.POM.HomePagePOM;
import testbase.TestSetup;
import utils.constants;

public class TerminatedEmployeeData extends TestSetup {
	
	@Test(priority = 1, dataProvider = "ArchieveEmpDataDelete"/* , enabled = false */)
	public void testTerminateEmployeeDelete(String searchKey) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		SoftAssert softAssertion1 = new SoftAssert();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());	
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.deactivatedEmployesTabXpath)));
		//EmployessEmployeesPagePOM.clickdeactivatedEmployesTab(getDriver());
		//EmployessEmployeesPagePOM.clickTempDeactivatedEmployes(getDriver());
		//EmployessEmployeesPagePOM.waitforTerminatedEmployeePageReady(getDriver());
		//EmployessEmployeesPagePOM.archieveEmployee(getDriver(), searchKey);
		EmployessEmployeesPagePOM.clickdeactivatedEmployesTab(getDriver());
		EmployessEmployeesPagePOM.clickTerminatedEmployeeDataMenu(getDriver());
		EmployessEmployeesPagePOM.waitforArchivedEmployeeTableXpathPageReady(getDriver());
		int  beforeDeletion = EmployessEmployeesPagePOM.numberofArchivedEmployees(getDriver());
		EmployessEmployeesPagePOM.SelectEmployeeArchieveDelete(getDriver(), searchKey);
		softAssertion1.assertTrue( EmployessEmployeesPagePOM.archieveEmployeeSuccess(getDriver(), searchKey),"Employee Archive failed for Employee"+searchKey );
		TestSetup.waitForJavascript(getDriver());
		int  afterDeletion = EmployessEmployeesPagePOM.numberofArchivedEmployees(getDriver());
		softAssertion1.assertTrue(afterDeletion < beforeDeletion, "condition afterDeletion < beforeDeletion failed" );
		softAssertion1.assertAll();
	}
	
	
	@DataProvider
	public Object[][] ArchieveEmpDataDelete() {
		String sheetName = "Employee";
		String tableName = "ArchieveEmpDataDelete";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}

}
