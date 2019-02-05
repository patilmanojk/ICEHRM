package sprint0;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sprint0.login.POM.EmployessEmployeesPagePOM;
import sprint0.login.POM.HomePagePOM;
import testbase.TestSetup;
import utils.constants;

public class EmployeeLoginAs extends TestSetup {

	@Test(priority = 1, dataProvider = "EmpFirstNameSearchData" , enabled = true )
	public void testLoginAsValid(String searchKey) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		List<WebElement> adminSubMenus = getDriver().findElements(By.xpath(HomePagePOM.adminSubMenusXpath));
		int noofAdminSubmenus = adminSubMenus.size();
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());	
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), searchKey);
		EmployessEmployeesPagePOM.waitforEmployeeSearchResult(getDriver());
		EmployessEmployeesPagePOM.SelectLoginAsUser(getDriver(), searchKey);
		String changedLoginName = getDriver().findElement(By.xpath(HomePagePOM.LoginAsUserXpath)).getText();
		SoftAssert softAssertion1 = new SoftAssert();
		
		softAssertion1.assertTrue(changedLoginName.contains(searchKey),"Employee login as has failed");
		waitForJavascript(getDriver());
		HomePagePOM.clickLoginAsUserRemoveButton(getDriver());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HomePagePOM.adminMenuDownArrowXpath)));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HomePagePOM.AdminSubMenuXpath+"[" + noofAdminSubmenus + "]")));
		waitForJavascript(getDriver());
		List<WebElement> sidebarUsersLoaded = getDriver().findElements(By.xpath(HomePagePOM.UserSidebarXpath));
		
		softAssertion1.assertTrue(sidebarUsersLoaded.size() == 1, "More than one employee is logged in");
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
