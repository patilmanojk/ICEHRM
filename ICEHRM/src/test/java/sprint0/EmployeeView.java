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

public class EmployeeView extends TestSetup {

	@Test(priority = 1, dataProvider = "EmpFirstNameSearchData" , enabled = true )
	public void testEmployeeView(String searchKey) {
		SoftAssert softAssertion1 = new SoftAssert();
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.clickadminMenu(getDriver());
		HomePagePOM.openEmployeeTab(getDriver());	
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), searchKey);
		EmployessEmployeesPagePOM.waitforEmployeeSearchResult(getDriver());
		EmployessEmployeesPagePOM.SelectViewEmployee(getDriver(), searchKey);
		softAssertion1.assertTrue( getDriver().findElement(By.xpath(EmployessEmployeesPagePOM.viewEmployeeEmployeeNameXpath)).getText().contains(searchKey) ,"No matching records found for  employee view search"  );
		softAssertion1.assertAll();	
	}
	
	@Test(priority = 2, dataProvider = "EmpFirstNameSearchData" , enabled = true)
	public void testProfileImageUpload(String searchKey) throws InterruptedException {
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
		String imgSrc = getDriver().findElement(By.xpath(EmployessEmployeesPagePOM.viewEmployeeProfileImageXpath)).getAttribute("src");
		String defaultImageFile = imgSrc.substring(imgSrc.lastIndexOf("/")+1, imgSrc.length());
		System.out.println(defaultImageFile);
		EmployessEmployeesPagePOM.clickUploadImageBtn(getDriver());		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.uploadImageWindowXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
		int size = getDriver().findElements(By.tagName("iframe")).size();
		for (int i = 0; i <= size-1; i++) {
			getDriver().switchTo().frame(i);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.chooseFileBtnXpath)));
			EmployessEmployeesPagePOM.uploadFile(getDriver(), constants.Path_TestData+"download.png");
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.chooseFileBtnXpath)));
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.uploadImageWindowXpath)));
			 getDriver().switchTo().defaultContent();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmployessEmployeesPagePOM.viewEmployeeProfileImageXpath)));
			  String imgSrc1 = getDriver().findElement(By.xpath(EmployessEmployeesPagePOM.viewEmployeeProfileImageXpath)).getAttribute("src");
			 String loadedImageFile =  imgSrc1.substring(imgSrc1.lastIndexOf("/")+1, imgSrc1.length());
			 System.out.println(loadedImageFile);
			 softAssertion1.assertTrue(defaultImageFile != loadedImageFile, "Default Image file and loaded Image files are same"  );
			}
		waitForJavascript(getDriver());
	
		EmployessEmployeesPagePOM.clickDeleteProfileImageButton(getDriver());		
		EmployessEmployeesPagePOM.clickemployeeTab(getDriver());
		EmployessEmployeesPagePOM.waitforEmployeeHomePageReady(getDriver());
		EmployessEmployeesPagePOM.searchEmployee(getDriver(), searchKey);
		EmployessEmployeesPagePOM.waitforEmployeeSearchResult(getDriver());
		EmployessEmployeesPagePOM.SelectViewEmployee(getDriver(), searchKey);
		
		String imgSrc2 = getDriver().findElement(By.xpath(EmployessEmployeesPagePOM.viewEmployeeProfileImageXpath)).getAttribute("src");
		String reloadedImageFile = imgSrc2.substring(imgSrc2.lastIndexOf("/")+1, imgSrc2.length());
		System.out.println(reloadedImageFile);
		softAssertion1.assertTrue(reloadedImageFile.contains(defaultImageFile), "Default Image file and Reloaded Image files are different" );
		
		
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
