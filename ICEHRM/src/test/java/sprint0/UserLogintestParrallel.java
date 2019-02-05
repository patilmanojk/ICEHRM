package sprint0;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sprint0.login.POM.HomePagePOM;
import sprint0.login.POM.loginPagePOM;
import testbase.LocalDriverManager;
import testbase.TestSetup;

import utils.constants;

public class UserLogintestParrallel {

	static WebDriver driver;

	@Test(priority = 1,enabled = false)
	public void testUserLogin_valid() {
		driver = LocalDriverManager.getDriver();
		TestSetup.AUTlogin(driver);
		HomePagePOM.clickuserProfileMenuButton(driver);
		HomePagePOM.clickSignOutButton(driver);
		Assert.assertEquals("ICE Hrm Login",driver.getTitle() );
	}

	@Test(priority = 2, dataProvider = "LoginData", enabled = false)
	public void testUserLogin_inValid(String username, String password, String noOfErrorElements) {
		driver = LocalDriverManager.getDriver();
		for(int i=0; i<=2;i++)
		{ try{
			loginPagePOM.enterUserName(driver, username);
		break;

		}
		catch(Exception e)
		{
			System.out.println("Element not found +" + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
		}
		//loginPagePOM.enterUserName(driver, username);
		for(int i=0; i<=2;i++)
		{ try{
			loginPagePOM.enterPassWord(driver, password);
		break;

		}
		catch(Exception e)
		{
			System.out.println("Element not found +" + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
		}
	//	loginPagePOM.enterPassWord(driver, password);
		loginPagePOM.clickLoginButton(driver);
		Assert.assertEquals(noOfErrorElements, loginPagePOM.checkErrorMessageExists(driver));
	}

	@DataProvider ( parallel = true)
	public Object[][] LoginData() {
		String sheetName = "Login";
		String tableName = "LoginData";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}
}

