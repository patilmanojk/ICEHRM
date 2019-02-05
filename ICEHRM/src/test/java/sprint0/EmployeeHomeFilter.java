package sprint0;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sprint0.login.POM.EmployessEmployeesPagePOM;
import sprint0.login.POM.HomePagePOM;
import testbase.TestSetup;
import utils.constants;

public class EmployeeHomeFilter extends TestSetup {

	@Test(priority = 1, dataProvider = "SearchJobTitleData", enabled = true )
	public void testFilterJobTitle(String SearchKey) {
		// WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());

		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		int noOfRecordsloaded = EmployessEmployeesPagePOM.getNoOfEmployeeSearchResults(getDriver());
		EmployessEmployeesPagePOM.applyJobTitleFilter(getDriver(), SearchKey);
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		int recordsloadedAfterFilter = EmployessEmployeesPagePOM.getNoOfEmployeeSearchResults(getDriver());
		SoftAssert softAssertion1 = new SoftAssert();
		softAssertion1.assertTrue(recordsloadedAfterFilter > 0);
		EmployessEmployeesPagePOM.clickResetEmployeeFilter(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		int noOfRecordsWithoutFilter = EmployessEmployeesPagePOM.getNoOfEmployeeSearchResults(getDriver());
		softAssertion1.assertEquals(noOfRecordsWithoutFilter, noOfRecordsloaded);

		softAssertion1.assertAll();

	}

	@Test(priority = 2, dataProvider = "SearchDepartmentData", enabled = true )
	public void testFilterDepartment(String SearchKey) {
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		int noOfRecordsloaded = EmployessEmployeesPagePOM.getNoOfEmployeeSearchResults(getDriver());

		EmployessEmployeesPagePOM.applydepartmentFilter(getDriver(), SearchKey);
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());

		List<WebElement> recordsloadedAfterFilter = getDriver()
				.findElements(By.xpath(EmployessEmployeesPagePOM.DepartmentColumnResultTableXpath));
		SoftAssert softAssertion2 = new SoftAssert();
		for (WebElement rec : recordsloadedAfterFilter) {
			softAssertion2.assertTrue(rec.getText().contains(SearchKey));
		}
		EmployessEmployeesPagePOM.clickResetEmployeeFilter(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		int noOfRecordsWithoutFilter = EmployessEmployeesPagePOM.getNoOfEmployeeSearchResults(getDriver());
		softAssertion2.assertEquals(noOfRecordsWithoutFilter, noOfRecordsloaded);

		softAssertion2.assertAll();
	}

	@Test(priority = 3, dataProvider = "SearchSupervisorData", enabled = true )
	public void testFilterSupervisor(String SearchKey) {
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		int noOfRecordsloaded = EmployessEmployeesPagePOM.getNoOfEmployeeSearchResults(getDriver());
		EmployessEmployeesPagePOM.applysupervisorFilter(getDriver(), SearchKey);
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		List<WebElement> recordsloadedAfterFilter = getDriver()
				.findElements(By.xpath(EmployessEmployeesPagePOM.supervisorColumnResultTableXpath));
		SoftAssert softAssertion3 = new SoftAssert();
		softAssertion3.assertTrue(recordsloadedAfterFilter.size() > 0);
		for (WebElement rec : recordsloadedAfterFilter) {
			softAssertion3.assertTrue(rec.getText().contains(SearchKey));
		}
		EmployessEmployeesPagePOM.clickResetEmployeeFilter(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		int noOfRecordsWithoutFilter = EmployessEmployeesPagePOM.getNoOfEmployeeSearchResults(getDriver());
		softAssertion3.assertEquals(noOfRecordsWithoutFilter, noOfRecordsloaded);

		softAssertion3.assertAll();
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
