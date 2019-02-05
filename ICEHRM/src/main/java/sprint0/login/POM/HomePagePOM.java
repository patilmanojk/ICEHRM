package sprint0.login.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePOM {
	public static WebDriver driver;
	
	public static String userProfileMenuXpath = "//div[@class = 'navbar-right']/ul/li[5]/a/span";
	public static String signOutButtonXpath = "//a[@href='https://icehrm.com/app/testGK/logout.php']";
	public static String employeeMenuXpath = "//a[@href='#']/span[text() = 'Employees']"; //"//ul[@class = 'sidebar-menu']/li[2]/a"; 
	public static String employeeSubmenuXpath = "//ul[@id = 'admin_Employees']/li[1]"; //"//ul[@class = 'sidebar-menu']/li[2]/ul/li[1]/a";
	public static String appLanguageOptionsXpath = "//*[@id='delegationDiv']/nav/div[2]/ul/li[4]/a";
	public static String appEngLanguageSelectXpath = "//ul[contains(@class , 'language-list')]/li/a[1]";
	public static String adminMenuXpath = "//li[@ref = 'admin_Admin']/a";
	public static String adminSubMenusXpath = "//ul[@id='admin_Admin']/li";
	public static String adminMenuDownArrowXpath = "//li[@ref='admin_Admin']/a/i[contains(@class,'fa-angle-down')]";
	public static String AdminSubMenuXpath = "//ul[@id='admin_Admin']/li";
	public static String employeeResultTableXpath = "//table[@id='grid']//tbody/tr/td[1]";
	public static String LoginAsUserXpath = "//section[@class = 'sidebar']/div[2]/div[2]/p";
	public static String LoginAsUserRemoveButtonXpath = "//section[@class = 'sidebar']/div[2]/button";
	public static String UserSidebarXpath = "//section[@class = 'sidebar']/div";
	
	
	
	public static void clickuserProfileMenuButton(WebDriver driver) {
		driver.findElement(By.xpath(userProfileMenuXpath)).click();
	}
	
	public static void clickSignOutButton(WebDriver driver) {
		driver.findElement(By.xpath(signOutButtonXpath)).click();
	}
	
	public static void clickadminMenu(WebDriver driver) {
		driver.findElement(By.xpath(adminMenuXpath)).click();
	}
	
	public static void clickEmployeeMenu(WebDriver driver) {
		driver.findElement(By.xpath(employeeMenuXpath)).click();
	}
	
	public static void clickEmployeeSubmenu(WebDriver driver) {
		driver.findElement(By.xpath(employeeSubmenuXpath)).click();
	}
	
	public static void clickappLanguageOptions(WebDriver driver) {
		driver.findElement(By.xpath(appLanguageOptionsXpath)).click();
	}
	
	public static void clickAppEngLanguageSelect(WebDriver driver) {
		driver.findElement(By.xpath(appEngLanguageSelectXpath)).click();
	}
	
	public static void clickLoginAsUserRemoveButton(WebDriver driver) {
		driver.findElement(By.xpath(LoginAsUserRemoveButtonXpath)).click();
	}
	
	
	public static void openEmployeeTab(WebDriver driver) {
		List<WebElement> adminSubMenus = driver.findElements(By.xpath(adminSubMenusXpath));
		int noofAdminSubmenus = adminSubMenus.size();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(adminMenuDownArrowXpath)));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(AdminSubMenuXpath+"[" + noofAdminSubmenus + "]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(employeeMenuXpath)));
		driver.findElement(By.xpath(employeeMenuXpath)).click();
		driver.findElement(By.xpath(employeeSubmenuXpath)).click();
		driver.findElement(By.id("tabEmployee")).click();
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(driver);
	}

}
