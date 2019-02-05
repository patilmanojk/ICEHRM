package sprint0.login.POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployessEmployeesPagePOM {
	public static WebDriver driver;
	
	public static String employeeTabXpath = "//a[@id='tabEmployee']";
	public static String addNewButtonXpath = "//div[@id='Employee']//div/button[1]";
	public static String filterButtonXpath = "//div[@class = 'col-xs-12']/button[2]";
	public static String employeeIdTextboxXpath = "//input[@id= 'employee_id']";
	public static String firstNameTextboxXpath = "//input[@id= 'first_name']";
	public static String secondNameTextboxXpath = "//input[@id= 'middle_name']";
	public static String lastNameTextboxXpath = "//input[@id= 'last_name']";
	public static String ssnNumberTextboxXpath = "//input[@id= 'ssn_num']";
	public static String nicNumberTextboxXpath = "//input[@id= 'nic_num']";
	public static String enterOtherIdTextboxXpath = "//input[@id= 'other_id']";
	public static String enterDrivingLicenceTextboxXpath = "//input[@id= 'driving_license']";
	public static String enterWorkStationIdTextboxXpath = "//input[@id= 'work_station_id']";
	public static String enterAddress1TextboxXpath = "//input[@id= 'address1']";
	public static String enterAddress2TextboxXpath = "//input[@id= 'address2']";
	public static String enterCityTextboxXpath = "//input[@id= 'city']";
	public static String enterPostalCodeTextboxXpath = "//input[@id= 'postal_code']";
	public static String enterPhoneTextboxXpath = "//input[@id= 'home_phone']";
	public static String enterMobilePhoneTextboxXpath = "//input[@id= 'mobile_phone']";
	public static String enterWorkPhoneTextboxXpath = "//input[@id= 'work_phone']";
	public static String enterWorkEmailTextboxXpath = "//input[@id= 'work_email']";
	public static String enterPrivateEmailTextboxXpath = "//input[@id= 'private_email']";
	public static String notesAddButtonXpath = "//button[@id = 'notes_add']";
	public static String notesResetButtonXpath = "//button[@id = 'notes_reset']";
	public static String saveButtonXpath = "//button[contains(@class,'saveBtn')  | text() = ' Save' ]";
	public static String cancelButtonXpath = "//button[contains(@class,'saveBtn')  | text() = ' Save' ]/following-sibling::button[1]";
	public static String ddNationalityDropdwonXpath = "//div[@id = 's2id_nationality']";
	public static String ddNationalityInputXpath = "//input[@id = 's2id_autogen2_search']";
	public static String ddGenderXpath = "//select[@id = 'gender']";
	public static String ddMaritalStatusXpath = "//select[@id = 'marital_status']";
	public static String ddImmigrationStatusXpath = "//div[@id='s2id_immigration_status' ]";
	public static String ddImmigrationStatusInputXpath = "//input[@id = 's2id_autogen4_search']";
	public static String ddEthnicityXpath = "//div[@id='s2id_ethnicity' ]";
	public static String ddEthnicityInputXpath = "//input[@id = 's2id_autogen3_search']";
	public static String ddEmploymentStatusXpath = "//div[@id='s2id_employment_status' ]";
	public static String ddEmploymentStatusInputXpath = "//input[@id = 's2id_autogen5_search']";
	public static String ddEditEmploymentStatusInputXpath = "//input[@id = 's2id_autogen3_search']";
	public static String ddJobTitleXpath = "//div[@id='s2id_job_title' ]";
	public static String ddJobTitleInputXpath = "//input[@id = 's2id_autogen6_search']";
	public static String ddPayGradeXpath = "//div[@id='s2id_pay_grade' ]";
	public static String ddPayGradeInputXpath = "//input[@id = 's2id_autogen7_search']";
	public static String ddCountryXpath = "//div[@id='s2id_country' ]";
	public static String ddCountryInputXpath = "//input[@id = 's2id_autogen8_search']";
	public static String ddProvinceXpath = "//div[@id='s2id_province' ]";
	public static String ddProvinceInputXpath = "//input[@id = 's2id_autogen9_search']";
	public static String ddDepartmentXpath = "//div[@id='s2id_department' ]";
	public static String ddDepartmentInputXpath = "//input[@id = 's2id_autogen10_search']";
	public static String ddSupervisorXpath = "//div[@id='s2id_supervisor' ]";
	public static String ddSupervisorInputXpath = "//input[@id = 's2id_autogen11_search']";
	public static String ddApprover1Xpath = "//div[@id='s2id_approver1' ]";
	public static String ddApprover1InputXpath = "//input[@id = 's2id_autogen12_search']";
	public static String ddApprover2Xpath = "//div[@id='s2id_approver2' ]";
	public static String ddApprover2InputXpath = "//input[@id = 's2id_autogen13_search']";
	public static String ddApprover3Xpath = "//div[@id='s2id_approver3' ]";
	public static String ddApprover3InputXpath = "//input[@id = 's2id_autogen14_search']";
	public static String ddBirthdayXpath = "//input[@id = 'birthday']";
	public static String ddJoinedDateXpath = "//input[@id = 'joined_date']";
	public static String ddIndirectSupervisorsXpath = "//div[@id='s2id_indirect_supervisors' ]";
	public static String ddIndirectSupervisorsInputXpath = "//input[@id='s2id_autogen15' ]";
	public static String ddConfirmationDateXpath = "//input[@id = 'confirmation_date']";
	public static String ddTerminationDateXpath = "//input[@id = 'termination_date']";
	public static String createUserConfirmationYesBtnXpath =  "//button[ @onclick = 'modJs.createUser();' ]";
	public static String createUserConfirmationNoBtnXpath =  "//button[ @onclick = 'modJs.closeCreateUser();' ]";
	public static String employeeTabId = "tabEmployee";
	public static String employeeIdDisplayTableXpath = "//table[@id='grid']//tbody/tr/td[1]";
	public static String terminatedEmployeeIdDisplayTableXpath ="//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr/td[4]";
	public static String archivedEmployeeTableXpath = "//div[@id = 'ArchivedEmployee']//table[@id = 'grid']/tbody/tr/td[3]";
	public static String duplicateentryMessageXpath = "//p[@id = 'messageModelBody']";
	public static String closeMessageWindowBtnXpath = "//button[@onclick = 'modJs.closeMessage();']";
	public static String searchTextboxXpath = "//input[@class = 'form-control' and @placeholder = 'Search']";
	public static String queryProcessingTextXpath = "//div[@id='grid_processing']";
	public static String firstNameColumnResultTableXpath = "//table[@id='grid']//tbody/tr/td[3]";
	public static String lastNameColumnResultTableXpath = "//table[@id='grid']//tbody/tr/td[4]";
	public static String DepartmentColumnResultTableXpath = "//table[@id='grid']//tbody/tr/td[6]";
	public static String supervisorColumnResultTableXpath = "//table[@id='grid']//tbody/tr/td[8]";
	public static String resetEmployeeFilterButtonXpath = "//button[@id = 'Employee_resetFilters']";
	public static String jobTitleFilterDDXpath = "//div[@id='s2id_job_title']";
	public static String jobTitleFilterInputXpath = "//input[@id='s2id_autogen2_search']";
	public static String departmentFilterDDXpath = "//div[@id='s2id_department']";
	public static String departmentFilterInputXpath = "//input[@id='s2id_autogen3_search']";
	public static String supervisorFilterDDXpath = "//div[@id='s2id_supervisor']";
	public static String supervisorFilterInputXpath = "//input[@id='s2id_autogen4_search']";
	public static String applyFilterButton = "//div[@class='control-group row']/div/button[contains(@class ,'filterBtn')]";
	public static String OKConfirmatioButtonXpath = "//*[@id=\"messageModel\"]/div/div/div[3]/button";
	public static String empTerminationSuccessMessageXpath = "//div[@class = 'modal-content']//h3[@id='messageModelLabel']";
	public static String deactivatedEmployesTabXpath = "//*[@id='terminatedEmployeeMenu']";
	public static String tempDeactivatedEmployesXpath = "//*[@id='tabTerminatedEmployee']";
	public static String pageLoadingImageXpath= "//*[@id='iceloader']";
	public static String viewEmployeeEmployeeNameXpath = "//div[@id = 'Employee']//*[@id='name']";
	public static String viewEmployeeProfileImageXpath = "//div[@id = 'Employee']//img[contains(@id,'profile_image')]";
	public static String viewEmployeeUploadImageBtnXpath = "//*[@id='employeeUploadProfileImage']";
	public static String uploadImageWindowXpath = "//*[@id='uploadModelLabel']";
	public static String chooseFileBtnXpath = "//input[@id='file']";
	public static String deleteProfileImageButtonXpath = "//button[@id='employeeDeleteProfileImage']";
	public static String editInfoButtonXpath = "//button[@id = 'employeeProfileEditInfo']";
	public static String notesPopupXpath = "//form[@id = 'Employee_field_notes']";
	public static String addNotesTextareaXpath = "//form[@id = 'Employee_field_notes']/div/div[2]/div/textarea";
	public static String addNotesDoneButtonXpath= "//form[@id = 'Employee_field_notes']/div/div[3]/div/button";
	public static String ConfirmationOkButtonXpath=  "//div[@id = 'messageModel']/div/div/div[3]/button";
	public static String notesAreaXpath = "//div[@id = 'notes_div']/div/div[1]";
	public static String deletenote1ButtonXpath = "//div[@id = 'notes_div']//div[@id = 'notes_1']//a[@id = 'notes_1_delete']";
	public static String terminatedEmployeeDataMenuXpath = "//a[@id = 'tabArchivedEmployee']";
	public static String deleteButtonArchieveWindowXpath = "//div[@id = 'deleteModel']//button[@onclick = 'modJs.confirmDelete();']";
	
	
	public static void addEmployeeNotes(WebDriver driver, String notes) {
		driver.findElement(By.xpath(addNotesTextareaXpath)).clear();
		driver.findElement(By.xpath(addNotesTextareaXpath)).sendKeys(notes);
	}
	
	public static void clickTerminatedEmployeeDataMenu(WebDriver driver) {
		driver.findElement(By.xpath(terminatedEmployeeDataMenuXpath)).click();
	}
	
	public static void clickNotesDoneButton(WebDriver driver) {
		driver.findElement(By.xpath(addNotesDoneButtonXpath)).click();
	}
	
	public static void clickdeletenote1Button(WebDriver driver) {
		driver.findElement(By.xpath(deletenote1ButtonXpath)).click();
	}
	
	public static void clickConfirmationOkButton(WebDriver driver) {
		driver.findElement(By.xpath(ConfirmationOkButtonXpath)).click();
	}
	
	
	
	public static void clickDeleteProfileImageButton(WebDriver driver) {
		driver.findElement(By.xpath(deleteProfileImageButtonXpath)).click();
	}
	
	public static void clickEditInfoButton(WebDriver driver) {
		driver.findElement(By.xpath(editInfoButtonXpath)).click();
	}
	
	public static void uploadFile(WebDriver driver, String filepath) {
		driver.findElement(By.xpath(chooseFileBtnXpath)).sendKeys(filepath);
	}
	
	public static void clickemployeeTab(WebDriver driver) {
		driver.findElement(By.xpath(employeeTabXpath)).click();
	}
	
	public static void clickUploadImageBtn(WebDriver driver) {
		driver.findElement(By.xpath(viewEmployeeUploadImageBtnXpath)).click();
	}
	
	public static void clickTempDeactivatedEmployes(WebDriver driver) {
		driver.findElement(By.xpath(tempDeactivatedEmployesXpath)).click();
	}
	
	public static void clickdeactivatedEmployesTab(WebDriver driver) {
		driver.findElement(By.xpath(deactivatedEmployesTabXpath)).click();
	}
	
	public static void clickOKConfirmationTab(WebDriver driver) {
		driver.findElement(By.xpath(OKConfirmatioButtonXpath)).click();
	}
	
	public static void clickResetEmployeeFilter(WebDriver driver) {
		driver.findElement(By.xpath(resetEmployeeFilterButtonXpath)).click();
	}
	
	public static void clickAddNewButton(WebDriver driver) {
		driver.findElement(By.xpath(addNewButtonXpath)).click();
	}
	
	public static void clickFilterButton(WebDriver driver) {
		driver.findElement(By.xpath(filterButtonXpath)).click();
	}
	
	public static void searchEmployee(WebDriver driver, String searchKey) {
		driver.findElement(By.xpath(searchTextboxXpath)).clear();
		driver.findElement(By.xpath(searchTextboxXpath)).sendKeys(searchKey,  Keys.ENTER);
	}
	
	public static void enterEmployeeIdTextbox(WebDriver driver, String EmployeeId) {
		driver.findElement(By.xpath(employeeIdTextboxXpath)).clear();
		driver.findElement(By.xpath(employeeIdTextboxXpath)).sendKeys(EmployeeId);
	}
	
	public static void enterFirstNameTextbox(WebDriver driver, String FirstName) {
		driver.findElement(By.xpath(firstNameTextboxXpath)).clear();
		driver.findElement(By.xpath(firstNameTextboxXpath)).sendKeys(FirstName);
	}
	
	public static void enterSecondNameTextbox(WebDriver driver, String SecondName) {
		driver.findElement(By.xpath(secondNameTextboxXpath)).clear();
		driver.findElement(By.xpath(secondNameTextboxXpath)).sendKeys(SecondName);
	}
	
	public static void enterLastNameTextbox(WebDriver driver, String LastName) {
		driver.findElement(By.xpath(lastNameTextboxXpath)).clear();
		driver.findElement(By.xpath(lastNameTextboxXpath)).sendKeys(LastName);
	}
	
	public static void enterssnNumberTextbox(WebDriver driver, String ssnNumber) {
		driver.findElement(By.xpath(ssnNumberTextboxXpath)).clear();
		driver.findElement(By.xpath(ssnNumberTextboxXpath)).sendKeys(ssnNumber);
	}
	
	public static void enterNicNumberTextbox(WebDriver driver, String NicNumber) {
		driver.findElement(By.xpath(nicNumberTextboxXpath)).clear();
		driver.findElement(By.xpath(nicNumberTextboxXpath)).sendKeys(NicNumber);
	}
	
	public static void enterOtherIdTextbox(WebDriver driver, String OtherId) {
		driver.findElement(By.xpath(enterOtherIdTextboxXpath)).clear();
		driver.findElement(By.xpath(enterOtherIdTextboxXpath)).sendKeys(OtherId);
	}
	
	public static void enterDrivingLicenceTextbox(WebDriver driver, String DrivingLicence) {
		driver.findElement(By.xpath(enterDrivingLicenceTextboxXpath)).clear();
		driver.findElement(By.xpath(enterDrivingLicenceTextboxXpath)).sendKeys(DrivingLicence);
	}
	
	public static void enterWorkStationIdTextbox(WebDriver driver, String WorkStationId) {
		driver.findElement(By.xpath(enterWorkStationIdTextboxXpath)).clear();
		driver.findElement(By.xpath(enterWorkStationIdTextboxXpath)).sendKeys(WorkStationId);
	}
	
	public static void enterAddress1Textbox(WebDriver driver, String Address1) {
		driver.findElement(By.xpath(enterAddress1TextboxXpath)).clear();
		driver.findElement(By.xpath(enterAddress1TextboxXpath)).sendKeys(Address1);
	}
	
	public static void enterAddress2Textbox(WebDriver driver, String Address2) {
		driver.findElement(By.xpath(enterAddress2TextboxXpath)).clear();
		driver.findElement(By.xpath(enterAddress2TextboxXpath)).sendKeys(Address2);
	}
	
	public static void enterCityTextbox(WebDriver driver, String City) {
		driver.findElement(By.xpath(enterCityTextboxXpath)).clear();
		driver.findElement(By.xpath(enterCityTextboxXpath)).sendKeys(City);
	}
	
	public static void enterPostalCodeTextbox(WebDriver driver, String PostalCode) {
		driver.findElement(By.xpath(enterPostalCodeTextboxXpath)).clear();
		driver.findElement(By.xpath(enterPostalCodeTextboxXpath)).sendKeys(PostalCode);
	}
	
	public static void enterPhoneTextbox(WebDriver driver, String Phone) {
		driver.findElement(By.xpath(enterPhoneTextboxXpath)).clear();
		driver.findElement(By.xpath(enterPhoneTextboxXpath)).sendKeys(Phone);
	}
	
	public static void enterMobilePhoneTextbox(WebDriver driver, String MobilePhone) {
		driver.findElement(By.xpath(enterMobilePhoneTextboxXpath)).clear();
		driver.findElement(By.xpath(enterMobilePhoneTextboxXpath)).sendKeys(MobilePhone);
	}
	
	public static void enterWorkPhoneTextbox(WebDriver driver, String WorkPhone) {
		driver.findElement(By.xpath(enterWorkPhoneTextboxXpath)).clear();
		driver.findElement(By.xpath(enterWorkPhoneTextboxXpath)).sendKeys(WorkPhone);
	}
	
	public static void enterWorkEmailTextbox(WebDriver driver, String WorkEmail) {
		driver.findElement(By.xpath(enterWorkEmailTextboxXpath)).clear();
		driver.findElement(By.xpath(enterWorkEmailTextboxXpath)).sendKeys(WorkEmail);
	}
	
	public static void enterPrivateEmailTextbox(WebDriver driver, String PrivateEmail) {
		driver.findElement(By.xpath(enterPrivateEmailTextboxXpath)).clear();
		driver.findElement(By.xpath(enterPrivateEmailTextboxXpath)).sendKeys(PrivateEmail);
	}
	
	public static void clickNotesAddButton(WebDriver driver) {
		driver.findElement(By.xpath(notesAddButtonXpath)).click();
	}
	
	public static void clickNotesResetButton(WebDriver driver) {
		driver.findElement(By.xpath(notesResetButtonXpath)).click();
	}
	
	public static void clickSaveButton(WebDriver driver) {
		driver.findElement(By.xpath(saveButtonXpath)).click();
	}
	
	public static void cancelSaveButton(WebDriver driver) {
		driver.findElement(By.xpath(cancelButtonXpath)).click();
	}
	
	public static void selectNationalityDropdown(WebDriver driver, String nationality) {
		driver.findElement(By.xpath(ddNationalityDropdwonXpath)).click();
		driver.findElement(By.xpath(ddNationalityInputXpath)).sendKeys(nationality, Keys.ENTER);
	}
	
	public static void selectGenderDropdown(WebDriver driver, String gender) {
		Select genderdd = new Select(driver.findElement(By.xpath(ddGenderXpath)));
		genderdd.selectByVisibleText(gender);
	}
	
	public static void selectMaritalStatusDropdown(WebDriver driver, String MaritalStatus) {
		Select maritalStatusdd = new Select(driver.findElement(By.xpath(ddMaritalStatusXpath)));
		maritalStatusdd.selectByVisibleText(MaritalStatus);
	}
	
	public static void selectImmigrationStatusDropdown(WebDriver driver, String ImmigrationStatus) {
		driver.findElement(By.xpath(ddImmigrationStatusXpath)).click();
		driver.findElement(By.xpath(ddImmigrationStatusInputXpath)).sendKeys(ImmigrationStatus, Keys.ENTER);
	}
	
	public static void selectEthnicityDropdown(WebDriver driver, String Ethnicity) {
		driver.findElement(By.xpath(ddEthnicityXpath)).click();
		driver.findElement(By.xpath(ddEthnicityInputXpath)).sendKeys(Ethnicity, Keys.ENTER);
	}
	
	public static void selectJobTitleDropdown(WebDriver driver, String JobTitle) {
		driver.findElement(By.xpath(ddJobTitleXpath)).click();
		driver.findElement(By.xpath(ddJobTitleInputXpath)).sendKeys(JobTitle, Keys.ENTER);
	}
	
	public static void selectPayGradeDropdown(WebDriver driver, String PayGrade) {
		driver.findElement(By.xpath(ddPayGradeXpath)).click();
		driver.findElement(By.xpath(ddPayGradeInputXpath)).sendKeys(PayGrade, Keys.ENTER);
	}
	
	public static void selectCountryDropdown(WebDriver driver, String Country) {
		driver.findElement(By.xpath(ddCountryXpath)).click();
		driver.findElement(By.xpath(ddCountryInputXpath)).sendKeys(Country, Keys.ENTER);
	}
	
	public static void selectEmploymentStatusDropdown(WebDriver driver, String EmploymentStatus) {
		driver.findElement(By.xpath(ddEmploymentStatusXpath)).click();
		driver.findElement(By.xpath(ddEmploymentStatusInputXpath)).sendKeys(EmploymentStatus, Keys.ENTER);
	}
	
	public static void selectEditEmploymentStatusDropdown(WebDriver driver, String EmploymentStatus) {
		driver.findElement(By.xpath("//*[@id='s2id_employment_status']/a")).click();
		driver.findElement(By.xpath(ddEditEmploymentStatusInputXpath)).sendKeys(EmploymentStatus, Keys.ENTER);
	}
	
	public static void selectProvinceDropdown(WebDriver driver, String Province) {
		driver.findElement(By.xpath(ddProvinceXpath)).click();
		driver.findElement(By.xpath(ddProvinceInputXpath)).sendKeys(Province, Keys.ENTER);
	}
	
	public static void selectSupervisorDropdown(WebDriver driver, String Supervisor) {
		driver.findElement(By.xpath(ddSupervisorXpath)).click();
		driver.findElement(By.xpath(ddSupervisorInputXpath)).sendKeys(Supervisor, Keys.ENTER);
	}

	public static void selectDepartmentDropdown(WebDriver driver, String Department) {
		driver.findElement(By.xpath(ddDepartmentXpath)).click();
		driver.findElement(By.xpath(ddDepartmentInputXpath)).sendKeys(Department, Keys.ENTER);
	}
	
	public static void selectApprover1Dropdown(WebDriver driver, String Approver1) {
		driver.findElement(By.xpath(ddApprover1Xpath)).click();
		driver.findElement(By.xpath(ddApprover1InputXpath)).sendKeys(Approver1, Keys.ENTER);
	}
	
	public static void selectApprover2Dropdown(WebDriver driver, String Approver2) {
		driver.findElement(By.xpath(ddApprover2Xpath)).click();
		driver.findElement(By.xpath(ddApprover2InputXpath)).sendKeys(Approver2, Keys.ENTER);
	}
	
	public static void selectApprover3Dropdown(WebDriver driver, String Approver3) {
		driver.findElement(By.xpath(ddApprover3Xpath)).click();
		driver.findElement(By.xpath(ddApprover3InputXpath)).sendKeys(Approver3, Keys.ENTER);
	}
	
	public static void selectIndirectSupervisorsDropdown(WebDriver driver, String IndirectSupervisors) {
		driver.findElement(By.xpath(ddIndirectSupervisorsXpath)).click();
		driver.findElement(By.xpath(ddIndirectSupervisorsInputXpath)).sendKeys(IndirectSupervisors, Keys.ENTER);
	}
	
	public static void enterBirthdayTextbox(WebDriver driver, String Birthday) {
		driver.findElement(By.xpath(ddBirthdayXpath)).clear();
		driver.findElement(By.xpath(ddBirthdayXpath)).sendKeys(Birthday);
	}
	
	public static void enterJoinedDateTextbox(WebDriver driver, String JoinedDate) {
		driver.findElement(By.xpath(ddJoinedDateXpath)).clear();
		driver.findElement(By.xpath(ddJoinedDateXpath)).sendKeys(JoinedDate);
	}
	
	public static void enterConfirmationDateTextbox(WebDriver driver, String ConfirmationDate) {
		driver.findElement(By.xpath(ddConfirmationDateXpath)).clear();
		driver.findElement(By.xpath(ddConfirmationDateXpath)).sendKeys(ConfirmationDate);
	}
	
	public static void enterTerminationDateTextbox(WebDriver driver, String TerminationDate) {
		driver.findElement(By.xpath(ddTerminationDateXpath)).clear();
		driver.findElement(By.xpath(ddTerminationDateXpath)).sendKeys(TerminationDate);
	}
	
	public static void clickUserConfirmationYesBtn(WebDriver driver) {
		driver.findElement(By.xpath(createUserConfirmationYesBtnXpath)).click();
	}
	
	public static void clickUserConfirmationNoBtn(WebDriver driver) {
		driver.findElement(By.xpath(createUserConfirmationNoBtnXpath)).click();
	}
	
	public static void clickTabEmployee(WebDriver driver) {
		driver.findElement(By.id(employeeTabId)).click();
	}

	public static void ClickUserConfirmationYesBtnButton(WebDriver driver) {
		driver.findElement(By.xpath(createUserConfirmationYesBtnXpath)).click();
	}

	public static void ClickUserConfirmationNoBtnButton(WebDriver driver) {
		driver.findElement(By.xpath(createUserConfirmationNoBtnXpath)).click();
	}
	
	
	public static String duplicateEnteryMessageText(WebDriver driver) {
		return driver.findElement(By.xpath(duplicateentryMessageXpath)).getAttribute("innerHTML");
	}
	
	public static void clickCloseMessageWindowBt(WebDriver driver) {
		driver.findElement(By.xpath(closeMessageWindowBtnXpath)).click();
	}
	
	public static void waitforEmployeeHomePageReady(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployessEmployeesPagePOM.employeeIdDisplayTableXpath), 0));
	}
	
	public static void waitforTerminatedEmployeePageReady(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployessEmployeesPagePOM.terminatedEmployeeIdDisplayTableXpath), 0));
	}
	
	public static void waitforArchivedEmployeeTableXpathPageReady(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployessEmployeesPagePOM.archivedEmployeeTableXpath), 0));
	}	
	
	public static void waitforTerminatedEmployeeDataPageReady(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployessEmployeesPagePOM.terminatedEmployeeIdDisplayTableXpath), 0));
	}
	
	public static void waitforEmployeeSearchResult(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid_processing']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='grid_processing']")));
	}
	
	public static int getNoOfEmployeeSearchResults(WebDriver driver) {
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.employeeIdDisplayTableXpath));
		return recordsloaded.size();
	}
	
	public static void applyJobTitleFilter(WebDriver driver, String jobTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath(filterButtonXpath)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(jobTitleFilterDDXpath)));
		driver.findElement(By.xpath(jobTitleFilterDDXpath)).click();
		driver.findElement(By.xpath(jobTitleFilterInputXpath)).sendKeys(jobTitle, Keys.ENTER);
		driver.findElement(By.xpath(applyFilterButton)).click();
	}
	
	public static void applydepartmentFilter(WebDriver driver, String  department) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath(filterButtonXpath)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath( departmentFilterDDXpath)));
		driver.findElement(By.xpath( departmentFilterDDXpath)).click();
		driver.findElement(By.xpath( departmentFilterInputXpath)).sendKeys( department, Keys.ENTER);
		driver.findElement(By.xpath(applyFilterButton)).click();
	}
	
	public static void applysupervisorFilter(WebDriver driver, String  supervisor) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath(filterButtonXpath)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath( supervisorFilterDDXpath)));
		driver.findElement(By.xpath( supervisorFilterDDXpath)).click();
		driver.findElement(By.xpath( supervisorFilterInputXpath)).sendKeys( supervisor, Keys.ENTER);
		driver.findElement(By.xpath(applyFilterButton)).click();
	}
	
	public static void SelectLoginAsUser(WebDriver driver, String  UserID) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.firstNameColumnResultTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//table[@id='grid']//tbody/tr[" + i + "]/td[3]")).getText()
					.contentEquals(UserID)) {
				driver.findElement(By.xpath("//table[@id='grid']//tbody/tr[" + i
						+ "]/td[9]/div/img[contains(@title,'Login as this Employee')]")).click();

			}
		}
		wait.until(ExpectedConditions
				.numberOfElementsToBeMoreThan(By.xpath(HomePagePOM.LoginAsUserXpath), 0));
	}
	
	
	public static void SelectTerminateEmployee(WebDriver driver, String  UserID) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.firstNameColumnResultTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//table[@id='grid']//tbody/tr[" + i + "]/td[3]")).getText()
					.contentEquals(UserID)) {
				driver.findElement(By.xpath("//table[@id='grid']//tbody/tr[" + i
						+ "]/td[9]/div/img[contains(@title,'Terminate Employee')]")).click();
				break;

			}
		}
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public static void restoreEmployee(WebDriver driver, String  UserID) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.terminatedEmployeeIdDisplayTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[4]")).getText()
					.contentEquals(UserID)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[10]/div/img[4]")));
				driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[10]/div/img[4]")).click();
				driver.switchTo().alert().accept();
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.OKConfirmatioButtonXpath)));
				EmployessEmployeesPagePOM.clickOKConfirmationTab(driver);

			}
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.OKConfirmatioButtonXpath)));

	}
	
	
	public static boolean restoreEmployeeSuccess(WebDriver driver, String  UserID) {
		boolean restoreSuccess = true;
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.terminatedEmployeeIdDisplayTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[4]")).getText()
					.contentEquals(UserID)) {
				restoreSuccess = false;
				break;

			}
			restoreSuccess = true;
		}
		return restoreSuccess;

	}
	
	
	public static void SelectViewEmployee(WebDriver driver, String  UserID) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.firstNameColumnResultTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//table[@id='grid']//tbody/tr[" + i + "]/td[3]")).getText()
					.contentEquals(UserID)) {
				driver.findElement(By.xpath("//table[@id='grid']//tbody/tr[" + i
						+ "]/td[9]/div/img[@title = 'View']")).click();

			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageLoadingImageXpath)));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(pageLoadingImageXpath)));
		
	}
	
	public static void archieveEmployee(WebDriver driver, String  UserID) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.terminatedEmployeeIdDisplayTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[4]")).getText()
					.contentEquals(UserID)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[10]/div/img[3]")));
				driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[10]/div/img[3]")).click();
				driver.switchTo().alert().accept();

			}
		}

	}
	
	public static boolean archieveEmployeeSuccess(WebDriver driver, String  UserID) {
		boolean archieveSuccess = true;
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.terminatedEmployeeIdDisplayTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[4]")).getText()
					.contentEquals(UserID)) {
				
				archieveSuccess = false;
				break;
				

			}
			archieveSuccess = true;
		}
		return archieveSuccess;

	}
	
	public static void SelectEmployeeArchieveDelete(WebDriver driver, String  UserID) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.archivedEmployeeTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//div[@id = 'ArchivedEmployee']//table[@id = 'grid']/tbody/tr[" + i + "]/td[3]")).getText()
					.contentEquals(UserID)) {
				driver.findElement(By.xpath("//div[@id = 'ArchivedEmployee']//table[@id = 'grid']/tbody/tr[" + i + "]/td[9]//img[2]")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButtonArchieveWindowXpath)));
				driver.findElement(By.xpath(deleteButtonArchieveWindowXpath)).click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(deleteButtonArchieveWindowXpath)));
				break;
			}
		}		
	}
	
	
	public static void SelectEmployeeArchieveDataDownload(WebDriver driver, String  UserID) throws AWTException, InterruptedException {
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.archivedEmployeeTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//div[@id = 'ArchivedEmployee']//table[@id = 'grid']/tbody/tr[" + i + "]/td[3]")).getText()
					.contentEquals(UserID)) {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id = 'ArchivedEmployee']//table[@id = 'grid']/tbody/tr[" + i + "]/td[9]//img[1]")).click();
				//wait.until(ExpectedConditions.alertIsPresent());
				//driver.switchTo().alert();
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_TAB); 
				r.keyPress(KeyEvent.VK_TAB); 
				r.keyPress(KeyEvent.VK_ENTER);
				
				break;
			}
		}		
	}
	
	public static int numberofArchivedEmployees(WebDriver driver) {
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.archivedEmployeeTableXpath));
		return recordsloaded.size();		
	}
	
	
	


}
