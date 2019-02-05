package sprint0;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class DeactivateEmployee  extends TestSetup {
	@Test(priority = 1, dataProvider = "TerminateEmpData" , enabled = true )
	public void testDeactivateEmployee(String searchKey, String ChangedKey) {
		new WebDriverWait(getDriver(), 30);
		new SoftAssert();
		getDriver().getWindowHandle();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		EmployeeDeactivePOM.terminateEmployee(getDriver(), searchKey);

		
	}
	
	@Test(priority = 2, dataProvider = "TerminateEmpData", enabled = true )
	public void testEditDeactivateEmployee(String searchKey, String ChangedKey) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		SoftAssert softAssertion1 = new SoftAssert();
		getDriver().getWindowHandle();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		List<WebElement> adminSubMenus = getDriver().findElements(By.xpath(HomePagePOM.adminSubMenusXpath));
		int noofAdminSubmenus = adminSubMenus.size();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HomePagePOM.adminMenuDownArrowXpath)));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HomePagePOM.AdminSubMenuXpath+"[" + noofAdminSubmenus + "]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePagePOM.employeeMenuXpath)));
		getDriver().findElement(By.xpath(HomePagePOM.employeeMenuXpath)).click();
		getDriver().findElement(By.xpath(HomePagePOM.employeeSubmenuXpath)).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.deactivatedEmployesTabXpath)));
		EmployessEmployeesPagePOM.clickdeactivatedEmployesTab(getDriver());
		EmployessEmployeesPagePOM.clickTempDeactivatedEmployes(getDriver());
		EmployessEmployeesPagePOM.waitforTerminatedEmployeePageReady(getDriver());
		EmployeeDeactivePOM.editEmployee(getDriver(), searchKey);
		TestSetup.waitForJavascript(getDriver());
		
		if (searchKey.contentEquals("Carl")) {
			EmployessEmployeesPagePOM.enterLastNameTextbox(getDriver(), ChangedKey);			
		}
		else if (searchKey.contentEquals( "Sandra")) {
			EmployessEmployeesPagePOM.enterBirthdayTextbox(getDriver(), ChangedKey);			
		}
		else if (searchKey.contentEquals( "Jose")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployessEmployeesPagePOM.ddMaritalStatusXpath)));
			EmployessEmployeesPagePOM.selectMaritalStatusDropdown(getDriver(), ChangedKey);			
		}
		else if (searchKey.contentEquals( "Nancy")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='s2id_employment_status']/a")));
			EmployessEmployeesPagePOM.selectEditEmploymentStatusDropdown(getDriver(), ChangedKey);			
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployessEmployeesPagePOM.saveButtonXpath)));
		EmployessEmployeesPagePOM.clickSaveButton(getDriver());
		EmployessEmployeesPagePOM.waitforTerminatedEmployeePageReady(getDriver());
		EmployeeDeactivePOM.editEmployee(getDriver(), searchKey);
		TestSetup.waitForJavascript(getDriver());
		if (searchKey.contentEquals("Carl")) {
			String ActualValue = 	getDriver().findElement(By.xpath(EmployessEmployeesPagePOM.lastNameTextboxXpath)).getAttribute("value");	
			softAssertion1.assertEquals(ActualValue, ChangedKey);
		}
		else if (searchKey.contentEquals("Sandra")) {
			String ActualValue = 	getDriver().findElement(By.xpath(EmployessEmployeesPagePOM.ddBirthdayXpath)).getAttribute("value");	
			softAssertion1.assertEquals(ActualValue, "1970-10-10");		
		}
		else if (searchKey.contentEquals("Jose")) {
			String ActualValue = 	getDriver().findElement(By.xpath(EmployessEmployeesPagePOM.ddMaritalStatusXpath)).getAttribute("value");	
			softAssertion1.assertEquals(ActualValue, ChangedKey);			
		}
		else if (searchKey.contentEquals( "Nancy")) {
			String ActualValue = 	getDriver().findElement(By.xpath("//*[@id='s2id_employment_status']/a")).getAttribute("text");	
			softAssertion1.assertEquals(ActualValue.trim(), ChangedKey);		
		}		
		softAssertion1.assertAll();		
	}
	
	@Test(priority = 3, dataProvider = "TerminateEmpData" , enabled = true )
	public void testSearchName(String searchKey, String ChangedKey) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		SoftAssert softAssertion2 = new SoftAssert();
		getDriver().getWindowHandle();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		List<WebElement> adminSubMenus = getDriver().findElements(By.xpath(HomePagePOM.adminSubMenusXpath));
		int noofAdminSubmenus = adminSubMenus.size();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HomePagePOM.adminMenuDownArrowXpath)));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HomePagePOM.AdminSubMenuXpath+"[" + noofAdminSubmenus + "]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePagePOM.employeeMenuXpath)));
		getDriver().findElement(By.xpath(HomePagePOM.employeeMenuXpath)).click();
		getDriver().findElement(By.xpath(HomePagePOM.employeeSubmenuXpath)).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.deactivatedEmployesTabXpath)));
		EmployessEmployeesPagePOM.clickdeactivatedEmployesTab(getDriver());
		EmployessEmployeesPagePOM.clickTempDeactivatedEmployes(getDriver());
		EmployessEmployeesPagePOM.waitforTerminatedEmployeePageReady(getDriver());
		
		EmployeeDeactivePOM.searchEmployee(getDriver(), searchKey);
		EmployessEmployeesPagePOM.waitforTerminatedEmployeePageReady(getDriver());
		TestSetup.waitForJavascript(getDriver());	

		
		List<WebElement> recordsloaded = getDriver().findElements(By.xpath(EmployeeDeactivePOM.firstNameColumnTerminatedEmployeeResultTableXpath));
		for (WebElement rec : recordsloaded ) {
			if (rec.getText().contains(searchKey)) {
			softAssertion2.assertTrue(rec.getText().contains(searchKey),"Assert1: Matching Data is not found");
			break;
			}
		}
		softAssertion2.assertAll();
	}
	
	@Test(priority = 4, dataProvider = "TerminateEmpData" , enabled = true, dependsOnMethods = {"testDeactivateEmployee"} )
	public void testRestoreEmployee(String searchKey, String ChangedKey) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		SoftAssert softAssertion3 = new SoftAssert();
		getDriver().getWindowHandle();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		List<WebElement> adminSubMenus = getDriver().findElements(By.xpath(HomePagePOM.adminSubMenusXpath));
		int noofAdminSubmenus = adminSubMenus.size();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HomePagePOM.adminMenuDownArrowXpath)));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HomePagePOM.AdminSubMenuXpath+"[" + noofAdminSubmenus + "]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePagePOM.employeeMenuXpath)));
		getDriver().findElement(By.xpath(HomePagePOM.employeeMenuXpath)).click();
		getDriver().findElement(By.xpath(HomePagePOM.employeeSubmenuXpath)).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.deactivatedEmployesTabXpath)));
		EmployessEmployeesPagePOM.clickdeactivatedEmployesTab(getDriver());
		EmployessEmployeesPagePOM.clickTempDeactivatedEmployes(getDriver());
		EmployessEmployeesPagePOM.waitforTerminatedEmployeePageReady(getDriver());
		EmployeeDeactivePOM.restoreEmployee(getDriver(), searchKey);
		TestSetup.waitForJavascript(getDriver());		
		softAssertion3.assertTrue(!EmployeeDeactivePOM.findEmployee(getDriver(), searchKey),"Employee restoe not sucessful");	
		softAssertion3.assertAll();		
	}
	
	
	
	@DataProvider
	public Object[][] TerminateEmpData() {
		String sheetName = "Employee";
		String tableName = "TerminateEmpData";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}


}
