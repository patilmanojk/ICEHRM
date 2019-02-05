package sprint0.login.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeDeactivePOM {
	public static WebDriver driver;
	
	public static String terminatedEmployeeFormXpath = "//div[@id = 'TerminatedEmployeeForm']";	
	public static String firstNameColumnTerminatedEmployeeResultTableXpath = " //div[@id = 'tabPageTerminatedEmployee']//table[@id='grid']//tbody/tr/td[4]";
	public static String searchTextboxXpath = "//div[@id = 'TerminatedEmployee']//input[@class = 'form-control' and @placeholder = 'Search']";
	public static String filterButton = "//div[@id = 'TerminatedEmployee']//button[1]";
	public static String filterButtonOnForm = "//form[@id = 'TerminatedEmployee_filter']//button[1]";
	public static String jobTitleFilterXpath = "//form[@id = 'TerminatedEmployee_filter']//div[@id = 's2id_job_title']";
	public static String jobTitleFilterInputXpath = "//input[@id = 's2id_autogen2_search']";
	public static String departmentFilterXpath = "//form[@id = 'TerminatedEmployee_filter']//div[@id = 's2id_department']";
	public static String departmentFilterInputXpath = "//input[@id = 's2id_autogen3_search']";
	public static String supervisorFilterFilterXpath = "//form[@id = 'TerminatedEmployee_filter']//div[@id = 's2id_supervisor]";
	public static String supervisorFilterFilterInputXpath = "//input[@id = 's2id_autogen4_search']";
	public static String empIdColumnXpath ="//div[@id = 'TerminatedEmployee']//tbody//tr/td[3]";
	public static String resetFilterButton = "//div[@id = 'TerminatedEmployee']//button[@id = 'TerminatedEmployee_resetFilters']";
	
	public static void searchEmployee(WebDriver driver, String searchKey) {
		driver.findElement(By.xpath(searchTextboxXpath)).clear();
		driver.findElement(By.xpath(searchTextboxXpath)).sendKeys(searchKey,  Keys.ENTER);
	}
	
	public static void searchJobTitleFilter(WebDriver driver, String searchKey) {
		driver.findElement(By.xpath(jobTitleFilterXpath)).click();
		driver.findElement(By.xpath(jobTitleFilterInputXpath)).sendKeys(searchKey,  Keys.ENTER);
	}
	
	public static void searchDepartmentFilter(WebDriver driver, String searchKey) {
		driver.findElement(By.xpath(departmentFilterXpath)).click();
		driver.findElement(By.xpath(departmentFilterInputXpath)).sendKeys(searchKey,  Keys.ENTER);
	}
	
	public static void searchSupervisorFilter(WebDriver driver, String searchKey) {
		driver.findElement(By.xpath(supervisorFilterFilterXpath)).click();
		driver.findElement(By.xpath(supervisorFilterFilterInputXpath)).sendKeys(searchKey,  Keys.ENTER);
	}
	
	public static void clickFilter(WebDriver driver) {
		driver.findElement(By.xpath(filterButton)).click(); 
		}
	
	public static void clickFilterButtonOnForm(WebDriver driver) {
		driver.findElement(By.xpath(filterButtonOnForm)).click(); 
		}
	
	public static void clickResetFilter(WebDriver driver) {
		driver.findElement(By.xpath(resetFilterButton)).click(); 
		}
	
	public static int noOfRecordsDisplayed(WebDriver driver) {
		List<WebElement> recorddisplayed = driver.findElements(By.xpath(empIdColumnXpath));
		return recorddisplayed.size();
		}
	
	public static void terminateEmployee(WebDriver driver, String searchKey) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		HomePagePOM.openEmployeeTab(driver);	
		String ParentWindowId = driver.getWindowHandle();
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(driver);
		EmployessEmployeesPagePOM.searchEmployee(driver, searchKey);
		EmployessEmployeesPagePOM.waitforEmployeeSearchResult(driver);
		EmployessEmployeesPagePOM.SelectTerminateEmployee(driver, searchKey);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		driver.switchTo().window(ParentWindowId);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(EmployessEmployeesPagePOM.OKConfirmatioButtonXpath)));
		EmployessEmployeesPagePOM.clickOKConfirmationTab(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.OKConfirmatioButtonXpath)));
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(driver);

	}
	
	public static void editEmployee(WebDriver driver, String  UserID) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.terminatedEmployeeIdDisplayTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[4]")).getText()
					.contentEquals(UserID)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[10]/div/img[1]")));
				driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[10]/div/img[1]")).click();
				break;

			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.pageLoadingImageXpath)));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.pageLoadingImageXpath)));
	}
	
	public static void restoreEmployee(WebDriver driver, String  UserID) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.terminatedEmployeeIdDisplayTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[4]")).getText()
					.contentEquals(UserID)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[10]/div/img[4]")));
				driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[10]/div/img[4]")).click();
				wait.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().accept();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'messageModel']//button[@class = 'btn']")));
				driver.findElement(By.xpath("//div[@id = 'messageModel']//button[@class = 'btn']")).click();
	
				break;

			}
		}
	}
	
	public static boolean findEmployee(WebDriver driver, String  UserID) {
		boolean empexist = false;
		List<WebElement> recordsloaded = driver.findElements(By.xpath(EmployessEmployeesPagePOM.terminatedEmployeeIdDisplayTableXpath));
		for (int i = 1; i <= recordsloaded.size(); i++) {
			if (driver.findElement(By.xpath("//div[@id = 'TerminatedEmployee']//table[@id='grid']/tbody/tr["+ i +"]/td[4]")).getText()
					.contentEquals(UserID)) {
				empexist = true;
			}
		}
		return empexist;

	}
	
	


}
