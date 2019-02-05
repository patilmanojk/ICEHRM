package sprint0;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sprint0.login.POM.EmployeeDeactivePOM;
import sprint0.login.POM.EmployessEmployeesPagePOM;
import sprint0.login.POM.HomePagePOM;
import testbase.TestSetup;
import utils.constants;

public class DeactivatedEmployeeFilter extends TestSetup {
	@Test(priority = 1, dataProvider = "SearchJobTitleData"/* , enabled = false */)
	public void testTerminateEmployee(String searchKey) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		SoftAssert softAssertion1 = new SoftAssert();
		//String ParentWindowId = getDriver().getWindowHandle();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());	
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.deactivatedEmployesTabXpath)));
		EmployessEmployeesPagePOM.clickdeactivatedEmployesTab(getDriver());
		EmployessEmployeesPagePOM.clickTempDeactivatedEmployes(getDriver());
		//EmployessEmployeesPagePOM.waitforTerminatedEmployeePageReady(getDriver());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployeeDeactivePOM.filterButton)));
		int noOfRecordsbeforeFilter = EmployeeDeactivePOM.noOfRecordsDisplayed(getDriver());
		EmployeeDeactivePOM.clickFilter(getDriver());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployeeDeactivePOM.filterButtonOnForm)));
		EmployeeDeactivePOM.searchJobTitleFilter(getDriver(), searchKey);
		EmployeeDeactivePOM.clickFilterButtonOnForm(getDriver());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployeeDeactivePOM.filterButtonOnForm)));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployeeDeactivePOM.filterButton)));
		int noOfRecordsAfterFilter = EmployeeDeactivePOM.noOfRecordsDisplayed(getDriver());
		EmployeeDeactivePOM.clickResetFilter(getDriver());
		System.out.println(noOfRecordsbeforeFilter+"tEst"+noOfRecordsAfterFilter);
		//EmployessEmployeesPagePOM.waitforTerminatedEmployeePageReady(getDriver());

		softAssertion1.assertTrue(noOfRecordsbeforeFilter >= noOfRecordsAfterFilter );
		softAssertion1.assertAll();
	}
	
	@DataProvider
	public Object[][] SearchJobTitleData() {
		String sheetName = "Employee";
		String tableName = "SearchJobTitle";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}

	@DataProvider
	public Object[][] SearchDepartmentData() {
		String sheetName = "Employee";
		String tableName = "SearchDepartment";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}

	@DataProvider
	public Object[][] SearchSupervisorData() {
		String sheetName = "Employee";
		String tableName = "SearchSupervisor";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}
}
