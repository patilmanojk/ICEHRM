package sprint0;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sprint0.login.POM.HomePagePOM;
import sprint0.login.POM.loginPagePOM;
import testbase.TestSetup;
import utils.constants;

public class UserLogin extends TestSetup {

	static WebDriver driver;

	@Test(priority = 1)
	public void testUserLogin_valid() {
		TestSetup.AUTlogin(getDriver());
		HomePagePOM.clickuserProfileMenuButton(getDriver());
		HomePagePOM.clickSignOutButton(getDriver());
		System.out.println(getDriver().getTitle() );
		Assert.assertTrue(getDriver().getTitle().contains("ICE Hrm"));
	
	}

	@Test(priority = 2, dataProvider = "LoginData", enabled = true)
	public void testUserLogin_inValid(String username, String password, String noOfErrorElements) {
		loginPagePOM.enterUserName(getDriver(), username);
		loginPagePOM.enterPassWord(getDriver(), password);
		loginPagePOM.clickLoginButton(getDriver());
		Assert.assertEquals(noOfErrorElements, loginPagePOM.checkErrorMessageExists(getDriver()));
	}

	@DataProvider
	public Object[][] LoginData() {
		String sheetName = "Login";
		String tableName = "LoginData";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}
}
