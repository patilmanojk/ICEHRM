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

public class EmployeeSearch extends TestSetup {


	@Test(priority = 1, dataProvider = "EmpFirstNameSearchData",  enabled = true)
	public void testSearchName(String FirstName) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());		
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), FirstName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.queryProcessingTextXpath)));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.queryProcessingTextXpath)));
		
		List<WebElement> recordsloaded = getDriver().findElements(By.xpath(EmployessEmployeesPagePOM.firstNameColumnResultTableXpath));
		SoftAssert softAssertion1= new SoftAssert();
		for (WebElement rec : recordsloaded ) {
			System.out.println(rec.getText());
			softAssertion1.assertTrue(rec.getText().contains(FirstName),"Assert1: Matching Data is not found");
		}
		softAssertion1.assertAll();
	}
	
	@Test(priority = 2,dataProvider = "EmpLastNameSearchData",  enabled = true)
	public void testSearchLastname(String LastName) {
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());		
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), LastName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.queryProcessingTextXpath)));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.queryProcessingTextXpath)));
		
		List<WebElement> recordsloaded = getDriver().findElements(By.xpath(EmployessEmployeesPagePOM.lastNameColumnResultTableXpath));
		SoftAssert softAssertion2= new SoftAssert();
		for (WebElement rec : recordsloaded ) {
			System.out.println(rec.getText());
			softAssertion2.assertTrue(rec.getText().contains(LastName),"Assert1: Matching Data is not found");
		}
		softAssertion2.assertAll();
	}
	
	@Test(priority = 3, dataProvider = "EmpInvalidSearchData",  enabled = true)
	public void testSearchInvalid(String SearchKey) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());		
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), SearchKey);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.queryProcessingTextXpath)));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.queryProcessingTextXpath)));
		
		List<WebElement> recordsloaded = getDriver().findElements(By.xpath(EmployessEmployeesPagePOM.employeeIdDisplayTableXpath));
		SoftAssert softAssertion3= new SoftAssert();
		for (WebElement rec : recordsloaded ) {
			System.out.println(rec.getText());
			softAssertion3.assertTrue(rec.getText().contains("No matching records found"),"Assert1: Matching Data is not found");
		}
		softAssertion3.assertAll();
		
	}
	
	
	@DataProvider
	public Object[][] EmpFirstNameSearchData() {
		String sheetName = "Employee";
		String tableName = "EmpFirstNameSearch";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}
	
	@DataProvider
	public Object[][] EmpLastNameSearchData() {
		String sheetName = "Employee";
		String tableName = "EmpLastNameSearch";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}
	
	@DataProvider
	public Object[][] EmpInvalidSearchData() {
		String sheetName = "Employee";
		String tableName = "EmpInvalidSearch";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}

}
