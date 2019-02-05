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

public class EmployeeTerminateEmployee extends TestSetup {

	@Test(priority = 1, dataProvider = "EmpFirstNameSearchData"/* , enabled = false */)
	public void testTerminateEmployee(String searchKey) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		SoftAssert softAssertion1 = new SoftAssert();
		String ParentWindowId = getDriver().getWindowHandle();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());	
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), searchKey);
		EmployessEmployeesPagePOM.waitforEmployeeSearchResult(getDriver());
		EmployessEmployeesPagePOM.SelectTerminateEmployee(getDriver(), searchKey);
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().window(ParentWindowId);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.OKConfirmatioButtonXpath)));
		EmployessEmployeesPagePOM.clickOKConfirmationTab(getDriver());

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.OKConfirmatioButtonXpath)));
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), searchKey);
		EmployessEmployeesPagePOM.waitforEmployeeSearchResult(getDriver());

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.deactivatedEmployesTabXpath)));
		EmployessEmployeesPagePOM.clickdeactivatedEmployesTab(getDriver());
		EmployessEmployeesPagePOM.clickTempDeactivatedEmployes(getDriver());
		EmployessEmployeesPagePOM.waitforTerminatedEmployeePageReady(getDriver());
		EmployessEmployeesPagePOM.restoreEmployee(getDriver(), searchKey);
		softAssertion1.assertTrue(EmployessEmployeesPagePOM.restoreEmployeeSuccess(getDriver(), searchKey));
		softAssertion1.assertAll();
		
		

	}
	
	@DataProvider
	public Object[][] EmpFirstNameSearchData() {
		String sheetName = "Employee";
		String tableName = "EmpFirstNameSearch";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}

}
