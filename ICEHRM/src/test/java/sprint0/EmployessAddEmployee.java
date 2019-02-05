package sprint0;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sprint0.login.POM.EmployessEmployeesPagePOM;
import sprint0.login.POM.HomePagePOM;
import testbase.TestSetup;
import utils.constants;

public class EmployessAddEmployee extends TestSetup {
	
	@Test(priority = 1, dataProvider = "EmployeeData", enabled = true)
	public void testAddUserValid(String EmployeeNumber, String FirstName, String LastName, String Nationality,
			String DateofBirth, String Gender, String MaritalStatus, String EmploymentStatus, String JobTitle,
			String Country, String JoinedDate, String Department, String IndirectSupervisors, String MiddleName,
			String Ethnicity, String ImmigrationStatus, String SSN, String NIC, String OtherID, String DrivingLicenseNo,
			String PayGrade, String WorkStationId, String AddressLine1, String AddressLine2, String City,
			String Province, String Postal, String HomePhone, String MobilePhone, String WorkPhone, String WorkEmail,
			String PrivateEmail, String ConfirmationDate, String TerminationDate, String Supervisor,
			String FirstLevelApprover, String SecondLevelApprover, String ThirdLevelApprover)
			throws InterruptedException {
		TestSetup.AUTlogin(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		HomePagePOM.openEmployeeTab(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		EmployessEmployeesPagePOM.clickAddNewButton(getDriver());
		EmployessEmployeesPagePOM.enterEmployeeIdTextbox(getDriver(), EmployeeNumber);
		EmployessEmployeesPagePOM.enterFirstNameTextbox(getDriver(), FirstName);
		EmployessEmployeesPagePOM.enterLastNameTextbox(getDriver(), LastName);
		EmployessEmployeesPagePOM.selectNationalityDropdown(getDriver(), Nationality);
		EmployessEmployeesPagePOM.enterBirthdayTextbox(getDriver(), DateofBirth);
		EmployessEmployeesPagePOM.selectGenderDropdown(getDriver(), Gender);
		EmployessEmployeesPagePOM.selectMaritalStatusDropdown(getDriver(), MaritalStatus);
		EmployessEmployeesPagePOM.selectEmploymentStatusDropdown(getDriver(), EmploymentStatus);
		EmployessEmployeesPagePOM.selectJobTitleDropdown(getDriver(), JobTitle);
		EmployessEmployeesPagePOM.selectCountryDropdown(getDriver(), Country);
		EmployessEmployeesPagePOM.enterJoinedDateTextbox(getDriver(), JoinedDate);
		EmployessEmployeesPagePOM.selectDepartmentDropdown(getDriver(), Department);
		EmployessEmployeesPagePOM.selectIndirectSupervisorsDropdown(getDriver(), IndirectSupervisors);
		EmployessEmployeesPagePOM.selectSupervisorDropdown(getDriver(), Supervisor);
		EmployessEmployeesPagePOM.clickSaveButton(getDriver());
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.createUserConfirmationYesBtnXpath)));
		EmployessEmployeesPagePOM.clickUserConfirmationYesBtn(getDriver());
	}

	@Test(priority = 2, dataProvider = "EmployeeDuplicateData", enabled = true)
	public void testAddUserDuplicate(String EmployeeNumber, String FirstName, String LastName, String Nationality,
			String DateofBirth, String Gender, String MaritalStatus, String EmploymentStatus, String JobTitle,
			String Country, String JoinedDate, String Department, String IndirectSupervisors, String MiddleName,
			String Ethnicity, String ImmigrationStatus, String SSN, String NIC, String OtherID, String DrivingLicenseNo,
			String PayGrade, String WorkStationId, String AddressLine1, String AddressLine2, String City,
			String Province, String Postal, String HomePhone, String MobilePhone, String WorkPhone, String WorkEmail,
			String PrivateEmail, String ConfirmationDate, String TerminationDate, String Supervisor,
			String FirstLevelApprover, String SecondLevelApprover, String ThirdLevelApprover)
			throws InterruptedException {
		TestSetup.AUTlogin(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		
		HomePagePOM.openEmployeeTab(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		EmployessEmployeesPagePOM.clickAddNewButton(getDriver());
		EmployessEmployeesPagePOM.enterEmployeeIdTextbox(getDriver(), EmployeeNumber);
		EmployessEmployeesPagePOM.enterFirstNameTextbox(getDriver(), FirstName);
		EmployessEmployeesPagePOM.enterLastNameTextbox(getDriver(), LastName);
		EmployessEmployeesPagePOM.selectNationalityDropdown(getDriver(), Nationality);
		EmployessEmployeesPagePOM.enterBirthdayTextbox(getDriver(), DateofBirth);
		EmployessEmployeesPagePOM.selectGenderDropdown(getDriver(), Gender);
		EmployessEmployeesPagePOM.selectMaritalStatusDropdown(getDriver(), MaritalStatus);
		EmployessEmployeesPagePOM.selectEmploymentStatusDropdown(getDriver(), EmploymentStatus);
		EmployessEmployeesPagePOM.selectJobTitleDropdown(getDriver(), JobTitle);
		EmployessEmployeesPagePOM.selectCountryDropdown(getDriver(), Country);
		EmployessEmployeesPagePOM.enterJoinedDateTextbox(getDriver(), JoinedDate);
		EmployessEmployeesPagePOM.selectDepartmentDropdown(getDriver(), Department);
		EmployessEmployeesPagePOM.selectIndirectSupervisorsDropdown(getDriver(), IndirectSupervisors);
		EmployessEmployeesPagePOM.selectSupervisorDropdown(getDriver(), Supervisor);
		EmployessEmployeesPagePOM.clickSaveButton(getDriver());
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.duplicateentryMessageXpath)));
		System.out.println(EmployessEmployeesPagePOM.duplicateEnteryMessageText(getDriver()));
		Assert.assertTrue(EmployessEmployeesPagePOM.duplicateEnteryMessageText(getDriver()).contains(EmployeeNumber));

	}

	@Test(priority = 3, dataProvider = "EmployeeInvalidData" , enabled = true)
	public void testAddUserInvalidData(String EmployeeNumber, String FirstName, String LastName, String Nationality,
			String DateofBirth, String Gender, String MaritalStatus, String EmploymentStatus, String JobTitle,
			String Country, String JoinedDate, String Department, String IndirectSupervisors, String MiddleName,
			String Ethnicity, String ImmigrationStatus, String SSN, String NIC, String OtherID, String DrivingLicenseNo,
			String PayGrade, String WorkStationId, String AddressLine1, String AddressLine2, String City,
			String Province, String Postal, String HomePhone, String MobilePhone, String WorkPhone, String WorkEmail,
			String PrivateEmail, String ConfirmationDate, String TerminationDate, String Supervisor,
			String FirstLevelApprover, String SecondLevelApprover, String ThirdLevelApprover)
			throws InterruptedException {
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		EmployessEmployeesPagePOM.clickAddNewButton(getDriver());	
		EmployessEmployeesPagePOM.enterEmployeeIdTextbox(getDriver(), EmployeeNumber);
		EmployessEmployeesPagePOM.enterFirstNameTextbox(getDriver(), FirstName);
		EmployessEmployeesPagePOM.enterLastNameTextbox(getDriver(), LastName);
		EmployessEmployeesPagePOM.selectNationalityDropdown(getDriver(), Nationality);
		EmployessEmployeesPagePOM.enterBirthdayTextbox(getDriver(), DateofBirth);
		EmployessEmployeesPagePOM.selectGenderDropdown(getDriver(), Gender);
		EmployessEmployeesPagePOM.selectMaritalStatusDropdown(getDriver(), MaritalStatus);
		EmployessEmployeesPagePOM.selectEmploymentStatusDropdown(getDriver(), EmploymentStatus);
		EmployessEmployeesPagePOM.selectJobTitleDropdown(getDriver(), JobTitle);
		EmployessEmployeesPagePOM.selectCountryDropdown(getDriver(), Country);
		EmployessEmployeesPagePOM.enterJoinedDateTextbox(getDriver(), JoinedDate);
		EmployessEmployeesPagePOM.selectDepartmentDropdown(getDriver(), Department);
		EmployessEmployeesPagePOM.selectIndirectSupervisorsDropdown(getDriver(), IndirectSupervisors);
		EmployessEmployeesPagePOM.clickSaveButton(getDriver());
		Assert.assertTrue(!getDriver()
				.findElement(By.xpath(EmployessEmployeesPagePOM.createUserConfirmationYesBtnXpath)).isDisplayed());
	}

	@DataProvider
	public Object[][] EmployeeData() {
		String sheetName = "Employee";
		String tableName = "EmployeeData";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}
	
	@DataProvider
	public Object[][] EmployeeDuplicateData() {
		String sheetName = "Employee";
		String tableName = "EmployeeDuplicateData";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}

	@DataProvider
	public Object[][] EmployeeInvalidData() {
		String sheetName = "Employee";
		String tableName = "EmployeeInvalidData";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}

}
