package sprint0.login.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPagePOM {
	public static WebDriver driver;
	
	public static String  userNameTextboxXpath = "//input[@id='username']" ;
	public static String  passWordTextboxXpath = "//input[@id='password']" ;
	public static String  loginButtonXpath = "//form[@id='loginForm']//button" ;
	public static String  rememberCheckBoxXpath = "//input[@id='remember']" ;
	public static String  forgotPasswordLinkXpath = "//a[text()='Forgot password']" ;
	public static String  errorMessageXpath = "//div[@class = 'login-form']/form/fieldset/div[4]";
	
	
	public static void enterUserName(WebDriver driver, String username) {
		driver.findElement(By.xpath(userNameTextboxXpath)).clear();
		driver.findElement(By.xpath(userNameTextboxXpath)).sendKeys(username);
	}
	
	public static void enterPassWord(WebDriver driver, String password) {
		driver.findElement(By.xpath(passWordTextboxXpath)).clear();
		driver.findElement(By.xpath(passWordTextboxXpath)).sendKeys(password);
	}
	
	public static void clickLoginButton(WebDriver driver) {
		driver.findElement(By.xpath(loginButtonXpath)).click();
	}
	
	public static void clickForgotPasswordLink(WebDriver driver) {
		driver.findElement(By.xpath(forgotPasswordLinkXpath)).click();
	}
	
	public static void clickRememberMeCheckBox(WebDriver driver) {
		driver.findElement(By.xpath(rememberCheckBoxXpath)).click();
	}
	
	public static String getErrorMessageText(WebDriver driver) {
		String errorMessage = driver.findElement(By.xpath(errorMessageXpath)).getText();
		return  errorMessage;
	}
	
	public static String checkErrorMessageExists(WebDriver driver) {
		String errorMessageEleSize = String.valueOf(driver.findElements(By.xpath(errorMessageXpath)).size());
		return  errorMessageEleSize;
	}

}
