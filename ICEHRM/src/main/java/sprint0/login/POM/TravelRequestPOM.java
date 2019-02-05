package sprint0.login.POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class TravelRequestPOM {
	static String name="Ja";
	//static String transport="Rail";
	

	public static WebDriver driver;
	public static String clickOnTravelRequestXpath="//a[@id='travelLink']";
	public static String clickOnAddNewButtonXpath="//button[@class='btn btn-small btn-primary']";
	public static String clickOnEmployeeXpath="//div[@id='s2id_employee']";
	public static String clickOnEmployeeSearchxpath="s2id_autogen2_search";
	public static String EmployeeSearchSize="//ul[@id='select2-results-2']";
	public static String ClickOnModeOfTransport="//div[@id = 'EmployeeTravelRecordForm']//div[@id = 'field_type']//select";
	public static String ClickOnPurposeofTravel="//textarea[@id='purpose']";
	public static String employeeTravelRecordTableXpath =  "//div[@id = 'EmployeeTravelRecord']//tbody/tr";
	
	//Click On Travel Request On Main Page
	public static void ClickOnTravelRequest(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath(clickOnTravelRequestXpath)).click();
		Thread.sleep(5000);
	}
	
	//Click on Add new
	public static void ClickOnAddNewButton(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath(clickOnAddNewButtonXpath)).click();
		//Thread.sleep(5000);
	}
	
	//Searching Employee
	public static void ClickonEmployeeField(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath(clickOnEmployeeXpath)).click();
	//	Thread.sleep(5000);
	}
	
	 public static void clickOnEmployeeSearch(WebDriver driver) throws InterruptedException
	{
		 
		 driver.findElement(By.id(clickOnEmployeeSearchxpath)).sendKeys(name);
		 
		 for(int i=1;i<=2;i++) {
		 driver.findElement(By.id(clickOnEmployeeSearchxpath)).sendKeys(Keys.ARROW_DOWN);
		 }
		 driver.findElement(By.id(clickOnEmployeeSearchxpath)).sendKeys(Keys.ENTER);
		 
	}
	 	 
	 //Selecting Means of Transportation
	 public static void ModeOfTransport(WebDriver driver, String transport){
		 //Thread.sleep(2000);
		 
		 //Select dropdown= new Select(driver.findElement(By.xpath(ClickOnModeOfTransport)));
		 
		 Select transportMode = new Select(driver.findElement(By.xpath(ClickOnModeOfTransport)));
	
		// System.out.print(dropdown);
		// transportMode.selectByVisibleText(transport);
		 transportMode.selectByIndex(2);
		 }
		
	 
	 //Entering Purpose OfTravel
	 	public static void PurposeOfTravel(WebDriver driver,String PurposeOfTraveltxt) throws InterruptedException
	 	{
	 		
	 		driver.findElement(By.xpath(ClickOnPurposeofTravel)).sendKeys(PurposeOfTraveltxt);
	 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 	}
		 
	 }
	


