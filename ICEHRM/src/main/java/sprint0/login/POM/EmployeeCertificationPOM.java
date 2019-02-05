package sprint0.login.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeCertificationPOM {
	public static WebDriver driver;

	public static String employeeTabLinkXpath = "//a[@id = 'employeeLink']";

	public static String certificationTabLinkXpath = "//a[@id = 'tabEmployeeCertification']";
	public static String tableHeaderEmployeeXpath = "//th [text()='Employee']";
	public static String tableHeaderCertificationXpath = "//th [text()='Certification']";
	public static String tableHeaderInstituteXpath = "//th [text()='Institute']";
	public static String tableHeaderGrantedOnXpath = "//th [text()='Granted On']";
	public static String tableHeaderValidThruXpath = "//th [text()='Valid Thru']";
	public static String queryProcessingTextXpath = "//div[@id='grid_processing']";
	public static String certificationTableCol1Xpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr/td[1]";
	public static String certificationTableCol2Xpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr/td[2]";
	public static String certificationTableCol3Xpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr/td[3]";
	public static String certificationTableCol6Xpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr/td[6]";

	public static String editButtonXpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr[4]/td[6]//div/img[1]";
	public static String deleteButtonXpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr[4]/td[6]//div/img[1]";
	public static String copyButtonXpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr[4]/td[6]//div/img[1]";

	public static String addNewButtonXpath = "//*[@id='EmployeeCertification']/div[1]/div/button[1]";
	public static String filterButtonXpath = "//*[@id='EmployeeCertification']/div[1]/div/button[2]";
	public static String searchInputboxXpath = "//div[@id = 'EmployeeCertification']//input";

	// Add New Certification Page

	public static String fieldNameEmployeeXpath = "//div[@id='field_employee']/label";
	public static String fieldNameCertificationXpath = "//div[@id='field_certification_id']/label";
	public static String fieldNameInstituteXpath = "//div[@id='field_institute']/label";

	public static String employeeAreaXpath = "//div [@id = 's2id_employee']";
	public static String employeeInputboxXpath = "//input[@id = 's2id_autogen2_search']";

	public static String certificationAreaXpath = "//div [@id = 's2id_certification_id']";
	public static String certificationInputboxXpath = "//input[@id = 's2id_autogen3_search']";

	public static String instituteInputboxXpath = "//input[@id = 'institute']";
	public static String grantedOnDateInputboxXpath = "//input[@id = 'date_start']";
	public static String validThruDateXpath = "//input[@id = 'date_end']";
	public static String cancelButtonXpath = "//button [contains(text(),'Cancel')]";
	public static String saveButtonXpath = "//button [contains(text(),'Save')]";

	// Filter Pop up Page
	public static String filterPopUpEmpAreaXpath = "//div[@id='field_employee']/div[1]";
	public static String filterPopUpEmpInputboxXpath = "//input[@id='s2id_autogen2_search']";
	public static String filterPopUpCertAreaXpath = "//div[@id='field_certification_id']/div[1]";
	public static String filterPopUpCertInputboxXpath = "//input[@id='s2id_autogen3_search']";
	public static String filterPopUpButtonXpath = "//*[@id='EmployeeCertification_filter']/div/div[4]/div[1]/button";

	// edit, delete, copy
	public static String editRecordXpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']/tbody/tr[4]/td[6]/div/img[1]";
	public static String deleteRecordXpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']/tbody/tr[5]/td[6]/div/img[2]";
	public static String copyRecordXpath = "//div[@id = 'EmployeeCertification']//table[@id='grid']/tbody/tr[4]/td[6]/div/img[3]";

	public static String deleteCancelButtonXpath = "//*[@id='deleteModel']/div/div/div[3]/button[1]";
	public static String deleteConfirmButtonXpath = "//*[@id='deleteModel']/div/div/div[3]/button[2]";

	public static String copyCancelButtonXpath = "//*[@id='EmployeeCertification_submit']/div/div[7]/div[1]/button[2]";
	public static String copySaveButtonXpath = "//*[@id='EmployeeCertification_submit']/div/div[7]/div[1]/button[1]";
	public static String copyDuplicateRecordMsgXpath = "//p[@id = 'messageModelBody']";
	public static String copyDuplicateRecordOKButtonXpath = "//*[@id='messageModel']/div/div/div[3]/button";

	//

	public static void clickEmployeeTab(WebDriver driver) {
		driver.findElement(By.xpath(employeeTabLinkXpath)).click();
	}

	public static void clickCertificationTab(WebDriver driver) {
		driver.findElement(By.xpath(certificationTabLinkXpath)).click();
	}

	public static int numberOfEmployeesInCertTable(WebDriver driver) {
		List<WebElement> numberOfRecords = driver.findElements(By.xpath(certificationTableCol1Xpath));
		return numberOfRecords.size();
	}

	public static void clickAddnewButton(WebDriver driver) {
		driver.findElement(By.xpath(addNewButtonXpath)).click();
	}

	public static void clickFilterButton(WebDriver driver) {
		driver.findElement(By.xpath(filterButtonXpath)).click();
	}

	public static void enterSearch(WebDriver driver, String searchString) {
		driver.findElement(By.xpath(searchInputboxXpath)).clear();
		driver.findElement(By.xpath(searchInputboxXpath)).sendKeys(searchString, Keys.ENTER);
	}

	public static void clickEditImage(WebDriver driver) {
		driver.findElement(By.xpath(editRecordXpath)).click();
	}

	public static void clickDeleteImage(WebDriver driver) {
		driver.findElement(By.xpath(deleteRecordXpath)).click();
	}

	public static void clickDeleteCancelButton(WebDriver driver) {
		driver.findElement(By.xpath(deleteCancelButtonXpath)).click();
	}

	public static void clickDeleteConfirmButton(WebDriver driver) {
		driver.findElement(By.xpath(deleteConfirmButtonXpath)).click();
	}

	public static void clickCopyImage(WebDriver driver) {
		driver.findElement(By.xpath(copyRecordXpath)).click();
	}

	public static void clickCopyCancelButton(WebDriver driver) {
		driver.findElement(By.xpath(copyCancelButtonXpath)).click();
	}

	public static void clickCopySaveButton(WebDriver driver) {
		driver.findElement(By.xpath(copySaveButtonXpath)).click();
	}

	public static void clickCopyDuplicateRecordOKButton(WebDriver driver) {
		driver.findElement(By.xpath(copyDuplicateRecordOKButtonXpath)).click();
	}

//	Filter Pop-up page
	public static void clickFilterPopupEmp(WebDriver driver, String ename) {
		driver.findElement(By.xpath(filterPopUpEmpAreaXpath)).click();
		driver.findElement(By.xpath(filterPopUpEmpInputboxXpath)).clear();
		driver.findElement(By.xpath(filterPopUpEmpInputboxXpath)).sendKeys(ename, Keys.ENTER);
	}

	public static void clickFilterPopupCert(WebDriver driver, String certificate) {
		driver.findElement(By.xpath(filterPopUpCertAreaXpath)).click();
		driver.findElement(By.xpath(filterPopUpCertInputboxXpath)).clear();
		driver.findElement(By.xpath(filterPopUpCertInputboxXpath)).sendKeys(certificate, Keys.ENTER);
	}

	public static void clickFilterPopupButton(WebDriver driver) {
		driver.findElement(By.xpath(filterPopUpButtonXpath)).click();
	}

//	Add new Cert Pop-up page	

	public static void enterEmployeeName(WebDriver driver, String ename) {
		driver.findElement(By.xpath(employeeAreaXpath)).click();
		driver.findElement(By.xpath(employeeInputboxXpath)).clear();
		driver.findElement(By.xpath(employeeInputboxXpath)).sendKeys(ename, Keys.ENTER);
	}

	public static void enterCertification(WebDriver driver, String certification) {
		driver.findElement(By.xpath(certificationAreaXpath)).click();
		driver.findElement(By.xpath(certificationInputboxXpath)).clear();
		driver.findElement(By.xpath(certificationInputboxXpath)).sendKeys(certification, Keys.ENTER);
	}

	public static void enterInstitute(WebDriver driver, String institute) {
		driver.findElement(By.xpath(instituteInputboxXpath)).clear();
		driver.findElement(By.xpath(instituteInputboxXpath)).sendKeys(institute);
	}

	public static void enterGrantOnDate(WebDriver driver, String grantDate) {
		driver.findElement(By.xpath(grantedOnDateInputboxXpath)).clear();
		driver.findElement(By.xpath(grantedOnDateInputboxXpath)).sendKeys(grantDate);
	}

	public static void enterValidThruDate(WebDriver driver, String validThru) {
		driver.findElement(By.xpath(validThruDateXpath)).clear();
		driver.findElement(By.xpath(validThruDateXpath)).sendKeys(validThru);
	}

	public static void clickCancelButton(WebDriver driver) {
		driver.findElement(By.xpath(cancelButtonXpath)).click();
	}

	public static void clickSaveButton(WebDriver driver) {
		driver.findElement(By.xpath(saveButtonXpath)).click();
	}



}
