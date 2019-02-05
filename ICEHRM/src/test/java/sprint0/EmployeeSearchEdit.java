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

public class EmployeeSearchEdit extends TestSetup {
	@Test(priority = 1, dataProvider = "EmpFirstNameSearchData", enabled = true)
	public void testEditEmployeeNote(String searchKey, String notes) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		SoftAssert softAssertion1 = new SoftAssert();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), searchKey);
		EmployessEmployeesPagePOM.waitforEmployeeSearchResult(getDriver());
		EmployessEmployeesPagePOM.SelectViewEmployee(getDriver(), searchKey);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployessEmployeesPagePOM.editInfoButtonXpath)));
		EmployessEmployeesPagePOM.clickEditInfoButton(getDriver());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployessEmployeesPagePOM.notesAddButtonXpath)));
		waitForJavascript(getDriver());
		EmployessEmployeesPagePOM.clickNotesAddButton(getDriver());
		waitForJavascript(getDriver());
		EmployessEmployeesPagePOM.addEmployeeNotes(getDriver(), notes);
		EmployessEmployeesPagePOM.clickNotesDoneButton(getDriver());
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.addNotesTextareaXpath)));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.ConfirmationOkButtonXpath)));
		EmployessEmployeesPagePOM.clickConfirmationOkButton(getDriver());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.notesAreaXpath)));
		String notesloaded = getDriver().findElement(By.xpath(EmployessEmployeesPagePOM.notesAreaXpath)).getText();
		softAssertion1.assertTrue(notesloaded.contains(notes), "Notes populated does not contain expected notes");
		waitForJavascript(getDriver());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployessEmployeesPagePOM.saveButtonXpath)));
		EmployessEmployeesPagePOM.clickSaveButton(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), searchKey);
		EmployessEmployeesPagePOM.waitforEmployeeSearchResult(getDriver());
		EmployessEmployeesPagePOM.SelectViewEmployee(getDriver(), searchKey);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployessEmployeesPagePOM.editInfoButtonXpath)));
		EmployessEmployeesPagePOM.clickEditInfoButton(getDriver());
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.pageLoadingImageXpath)));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.pageLoadingImageXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployessEmployeesPagePOM.deletenote1ButtonXpath)));
		waitForJavascript(getDriver());
		EmployessEmployeesPagePOM.clickdeletenote1Button(getDriver());
		waitForJavascript(getDriver());
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.ConfirmationOkButtonXpath)));
		EmployessEmployeesPagePOM.clickConfirmationOkButton(getDriver());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.ConfirmationOkButtonXpath)));
		List<WebElement> NoOfNotes = getDriver().findElements(By.xpath(EmployessEmployeesPagePOM.notesAreaXpath));
		softAssertion1.assertTrue(NoOfNotes.size() == 0, "Notes are available for this employee");
		EmployessEmployeesPagePOM.clickSaveButton(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		softAssertion1.assertAll();
	}

	@DataProvider
	public Object[][] EmpFirstNameSearchData() {
		String sheetName = "Employee";
		String tableName = "AddNotes";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}
}
