package sprint0;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sprint0.login.POM.EmployeeCertificationPOM;

import testbase.TestSetup;
import utils.constants;

public class EmployeeCert extends  TestSetup{



   @Test (priority = 1)
   public void testCertificationPage() {
	WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	TestSetup.AUTlogin(getDriver());
	EmployeeCertificationPOM.clickEmployeeTab(getDriver());
   	EmployeeCertificationPOM.clickCertificationTab(getDriver());
   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath)));
   	List<WebElement> names = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
   	
   	int list = names.size();
   	
   	System.out.println("Row count: "+ list);
   	
 	for(WebElement e : names){
 		System.out.println(e.getText());
 		}
 	   
 	String emp = getDriver().findElement(By.xpath(EmployeeCertificationPOM.tableHeaderEmployeeXpath)).getText();
 	System.out.println("Employee field is displyed as : "+emp); 	
 	String cert = getDriver().findElement(By.xpath(EmployeeCertificationPOM.tableHeaderCertificationXpath)).getText();
 	System.out.println("Certification field is displyed as : "+cert);
 	String insti = getDriver().findElement(By.xpath(EmployeeCertificationPOM.tableHeaderInstituteXpath)).getText();
 	System.out.println("Institute field is displyed as : "+insti);
 	String start = getDriver().findElement(By.xpath(EmployeeCertificationPOM.tableHeaderGrantedOnXpath)).getText();
 	System.out.println("Granted On field is displyed as : "+start);
 	String end = getDriver().findElement(By.xpath(EmployeeCertificationPOM.tableHeaderValidThruXpath)).getText();
 	System.out.println("Valid Thru field is displyed as : "+end);
 	
 	SoftAssert softAssertion1= new SoftAssert();
 	softAssertion1.assertEquals(emp,"Employee");
 	SoftAssert softAssertion2= new SoftAssert();
 	softAssertion2.assertEquals(cert,"Certification");
 	SoftAssert softAssertion3= new SoftAssert();
 	softAssertion3.assertEquals(insti,"Institute");
 	SoftAssert softAssertion4= new SoftAssert();
 	softAssertion4.assertEquals(start,"Granted On");
 	SoftAssert softAssertion5= new SoftAssert();
 	softAssertion5.assertEquals(end,"Valid Thru");
 	softAssertion5.assertAll();
   	}
   
   @Test (priority = 2, dataProvider = "InvalidCertEmployeeData",  enabled = true)
   public void testAddNewCertPage(String ename) {
	WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	TestSetup.AUTlogin(getDriver());
	EmployeeCertificationPOM.clickEmployeeTab(getDriver());
   	EmployeeCertificationPOM.clickCertificationTab(getDriver());
   	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
   	EmployeeCertificationPOM.clickAddnewButton(getDriver());
   	
 	String emp = getDriver().findElement(By.xpath(EmployeeCertificationPOM.fieldNameEmployeeXpath)).getText();
 	System.out.println("Employee field is displyed as : "+emp); 	
 	String cert = getDriver().findElement(By.xpath(EmployeeCertificationPOM.fieldNameCertificationXpath)).getText();
 	System.out.println("Certification field is displyed as : "+cert);
 	String insti = getDriver().findElement(By.xpath(EmployeeCertificationPOM.fieldNameInstituteXpath)).getText();
 	System.out.println("Institute field is displyed as : "+insti);
 	
 	SoftAssert softAssertion6= new SoftAssert();
 	softAssertion6.assertEquals(emp, "Employee");
 	SoftAssert softAssertion7= new SoftAssert();
 	softAssertion7.assertEquals(cert, "Certification");
 	SoftAssert softAssertion8= new SoftAssert();
 	softAssertion8.assertEquals(insti, "Institute");
	
 	EmployeeCertificationPOM.enterEmployeeName(getDriver(), ename);
 	
 	String noMatch = getDriver().findElement(By.xpath("//li [contains(text(),'No matches found')]")).getText();
 	System.out.println("Employee result : "+noMatch);	
	SoftAssert softAssertion9= new SoftAssert();
 	softAssertion9.assertEquals(noMatch, "No matches found");
	softAssertion9.assertAll();
   }
 	  
   
 @Test (priority = 3, dataProvider = "SkipMandatoryFieldData",  enabled = true)
 public void testAddNewCertPage_mandatoryFields(String ename, String certification) {
	WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	TestSetup.AUTlogin(getDriver());
	EmployeeCertificationPOM.clickEmployeeTab(getDriver());
 	EmployeeCertificationPOM.clickCertificationTab(getDriver());
 	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
 	
 	EmployeeCertificationPOM.clickAddnewButton(getDriver());
 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.cancelButtonXpath)));
 	String title1 = getDriver().getTitle();
 	System.out.println("Page Title before: "+ title1);
 	
	EmployeeCertificationPOM.enterEmployeeName(getDriver(), ename);
	EmployeeCertificationPOM.enterCertification(getDriver(), certification);
    
	EmployeeCertificationPOM.clickSaveButton(getDriver());
 	String title2 = getDriver().getTitle();
 	System.out.println("Page Title after: "+ title2);
	
	SoftAssert softAssertion9= new SoftAssert();
	softAssertion9.assertEquals(title1, title2);
	softAssertion9.assertAll();
 }
   
   
   @Test(priority = 4, dataProvider = "dp",  enabled = true)
   public void testAddnewCertPage_cancel(String ename, String institute, String grantDate, String validThru, String certification) {
	   WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	   TestSetup.AUTlogin(getDriver());
	EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	int list1 = names1.size();
	System.out.println("Row count before: "+ list1);
	
	EmployeeCertificationPOM.clickAddnewButton(getDriver());
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.cancelButtonXpath)));
	EmployeeCertificationPOM.enterEmployeeName(getDriver(), ename);
  
    EmployeeCertificationPOM.enterInstitute(getDriver(), institute);
    EmployeeCertificationPOM.enterGrantOnDate(getDriver(), grantDate);
    EmployeeCertificationPOM.enterValidThruDate(getDriver(), validThru);
    EmployeeCertificationPOM.enterCertification(getDriver(), certification);
    EmployeeCertificationPOM.clickCancelButton(getDriver());
   
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	int list2 = names2.size();
	System.out.println("Row count after: "+ list2);
	
 	SoftAssert softAssertion10= new SoftAssert();
 	softAssertion10.assertTrue(list1==list2);
 	
 	softAssertion10.assertAll();
 	
   	}
   
   @Test(priority = 5, dataProvider = "dp", enabled = true)
   public void testAddnewCertPage_save(String ename, String institute, String grantDate, String validThru, String certification) {
	   WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	   TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	int list1 = names1.size();
	System.out.println("Row count before: "+ list1);
	
 	for(WebElement e : names1){
 		System.out.println("Before names: "+e.getText());
 	}
 	
	EmployeeCertificationPOM.clickAddnewButton(getDriver());
	
	EmployeeCertificationPOM.enterEmployeeName(getDriver(), ename);
   	EmployeeCertificationPOM.enterInstitute(getDriver(), institute);
   	EmployeeCertificationPOM.enterGrantOnDate(getDriver(), grantDate);
 	EmployeeCertificationPOM.enterValidThruDate(getDriver(), validThru);
    EmployeeCertificationPOM.enterCertification(getDriver(), certification);
 	EmployeeCertificationPOM.clickSaveButton(getDriver());

 	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
 	getDriver().navigate().refresh();
 	EmployeeCertificationPOM.clickCertificationTab(getDriver());
 	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
 	
 	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	List<WebElement> cert1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol2Xpath));
	List<WebElement> insti1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol3Xpath));
	int list2 = names2.size();
	System.out.println("Row count after: "+ list2);
	
 	for(WebElement a : names2){
 		System.out.println("After names: "+a.getText());
 		}
 	
	SoftAssert softAssertion11= new SoftAssert();
	softAssertion11.assertEquals(list1+1, list2);
	softAssertion11.assertAll();
 	
	for (int i=0; i<list2; i++)
 	{
 		String name = names2.get(i).getText();
 		
	 	if (name.equals(ename))
	 	{
	 		for (int j=0; j<list2; j++)
	 		{
	 			String cert = cert1.get(j).getText();
	 			
	 			if(cert.equals(certification))
	 			{
	 				for (int k=0; k<list2; k++)
	 				{
		 				String insti = insti1.get(k).getText();
		 				if(insti.equals(institute))
		 				{
 		 				System.out.println("New Employee added to the table: "+ ename);
 		 				System.out.println("New Certification added to the table: "+ certification);
 		 				System.out.println("New Institute added to the table: "+institute);
		 				}	
	 				}
	 			}
	 		}
	 		break;
	 	}
	 }
	}
   
   
 @Test(priority = 6, dataProvider = "FilterCriteria", enabled = true)
 public void testFilterPage_valid(String ename, String certification) {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	int list1 = names1.size();
	System.out.println("Row count before: "+ list1);
	
	for(WebElement e : names1){
		System.out.println("Before names: "+e.getText());
	}
	
	EmployeeCertificationPOM.clickFilterButton(getDriver());
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.filterPopUpButtonXpath)));
	
	EmployeeCertificationPOM.clickFilterPopupEmp(getDriver(), ename);
	EmployeeCertificationPOM.clickFilterPopupCert(getDriver(), certification);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.filterPopUpButtonXpath)));
	
	EmployeeCertificationPOM.clickFilterPopupButton(getDriver());

	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	int list2 = names2.size();
	System.out.println("Row count after: "+ list2);
	
	for(WebElement a : names2){
		System.out.println("After names: "+a.getText());
		}
	
	SoftAssert softAssertion12= new SoftAssert();
	softAssertion12.assertNotEquals(list1, list2);
	softAssertion12.assertAll();
 }
 
 @Test(priority = 7, dataProvider = "FilterCriteriaInvalid", enabled = true)
 public void testFilterPage_invalid(String ename, String certification) {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	int list1 = names1.size();
	System.out.println("Row count before: "+ list1);
	
	for(WebElement e : names1){
		System.out.println("Before names: "+e.getText());
	}
	
	EmployeeCertificationPOM.clickFilterButton(getDriver());
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.filterPopUpButtonXpath)));
	
	EmployeeCertificationPOM.clickFilterPopupEmp(getDriver(), ename);
	EmployeeCertificationPOM.clickFilterPopupCert(getDriver(), certification);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.filterPopUpButtonXpath)));
	
	EmployeeCertificationPOM.clickFilterPopupButton(getDriver());

	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	int list2 = names2.size();
	System.out.println("Row count after: "+ list2);
	
	for(WebElement a : names2){
		System.out.println("After filter no names should appear: "+a.getText());
		}
	
	SoftAssert softAssertion13= new SoftAssert();
	softAssertion13.assertEquals(list2, 1);
	
	softAssertion13.assertAll();
 }
 
 @Test(priority = 8, dataProvider = "SearchCriteria", enabled = true)
 public void testSearch_valid(String searchString) throws InterruptedException {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	int list1 = names1.size();
	System.out.println("Row count before search: "+ list1);
	
	for(WebElement e : names1){
		System.out.println("Before search name: "+e.getText());
	}
	
	EmployeeCertificationPOM.enterSearch(getDriver(), searchString);
	
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	int list2 = names2.size();
	System.out.println("Row count after search: "+ list2);
	
	for(WebElement a : names2){
		System.out.println("After search name: "+a.getText());
		}

	SoftAssert softAssertion14= new SoftAssert();
	softAssertion14.assertNotEquals(list1, list2);
	softAssertion14.assertAll();
 }
 
 @Test(priority = 9, dataProvider = "SearchCriteriaInvalid", enabled = true)
 public void testSearch_invalid(String searchString) throws InterruptedException {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	int list1 = names1.size();
	System.out.println("Row count before search: "+ list1);
	
	for(WebElement e : names1){
		System.out.println("Before search name: "+e.getText());
	}
	
	EmployeeCertificationPOM.enterSearch(getDriver(), searchString);
	
	Thread.sleep(3000);
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	int list2 = names2.size();
	
	for(WebElement a : names2){
		System.out.println("After search name no matching records should be found: "+a.getText());
		}

	SoftAssert softAssertion15= new SoftAssert();
	softAssertion15.assertEquals(list2, 1);
	softAssertion15.assertAll();
 }
 
   
 @Test(priority = 10,  dataProvider = "RecordAction", enabled = true)
 public void testEdit_cancel(String ename) {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 3));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	System.out.println("Row count before edit: "+ names1.size());
	
	for (int i = 1; i <= names1.size(); i++) {
		System.out.println(getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText());
		
		if (getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText().contains(ename))
		{
			System.out.println("Employee record to be actioned is: "+i);
			System.out.println("Employee Edited: "+getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText());
			getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[6]/div/img[1]")).click();
			break;
		}
	}
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.cancelButtonXpath)));
	EmployeeCertificationPOM.clickCancelButton(getDriver());
	
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 3));
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	System.out.println("Row count after: "+ names2.size());
	
	SoftAssert softAssertion16= new SoftAssert();
	softAssertion16.assertEquals(names2.size(), names1.size());
	softAssertion16.assertAll();
	}
 
 @Test(priority = 11, dataProvider = "EditValid", enabled = true)
 public void testEdit_save(String ename, String grantDate) {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 3));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	System.out.println("Row count before edit: "+ names1.size());
	
	for (int i = 1; i <= names1.size(); i++) {
				
		if (getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText().contains(ename))
		{
			System.out.println("Employee record to be actioned is: "+i);
			System.out.println("Employee Edited: "+getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText());
			System.out.println("Grant Date before: "+ getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[4]")).getText());
			getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[6]/div/img[1]")).click();
			break;
		}
	}
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.cancelButtonXpath)));
	
	EmployeeCertificationPOM.enterGrantOnDate(getDriver(), grantDate);
	EmployeeCertificationPOM.clickSaveButton(getDriver());
	
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 3));
	
	TestSetup.waitForJavascript(getDriver());
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	System.out.println("Row count after: "+ names2.size());
	String gDateAfter = null;
	for (int i = 1; i <= names1.size(); i++) {
		
		if (getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText().contains(ename))
		{
			gDateAfter = getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[4]")).getText();
			System.out.println("Grant Date after: "+gDateAfter) ;
			break;
		}
	}
		
	SoftAssert softAssertion17= new SoftAssert();
	softAssertion17.assertEquals(names2.size(), names1.size());
	SoftAssert softAssertion18= new SoftAssert();
	softAssertion18.assertEquals(grantDate, gDateAfter);
	softAssertion18.assertAll();
	}
 
  
 @Test(priority = 12,  dataProvider = "RecordAction", enabled = true)
 public void testCopy_cancel(String ename) {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	System.out.println("Row count before edit: "+ names1.size());
	
	for (int i = 1; i <= names1.size(); i++) {
				
		if (getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText().contains(ename))
		{
			System.out.println("Employee record to be actioned is: "+i);
			System.out.println("Employee to be Copied: "+getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText());
			getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[6]/div/img[3]")).click();
			break;
		}
		
	}
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.copyCancelButtonXpath)));
	EmployeeCertificationPOM.clickCopyCancelButton(getDriver());
	
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 0));
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	System.out.println("Row count after: "+ names2.size());
	
	SoftAssert softAssertion19= new SoftAssert();
	softAssertion19.assertEquals(names2.size(), names1.size());
	softAssertion19.assertAll();
	}
 
 @Test(priority = 13,  dataProvider = "RecordAction", enabled = true)
 public void testCopy_SaveDuplicate(String ename) {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 2));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	System.out.println("Row count before edit: "+ names1.size());
	
	for (int i = 1; i <= names1.size(); i++) {
	
	if (getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText().contains(ename))
		{
		System.out.println("Employee record to be actioned is: "+i);
		System.out.println("Employee to be Copied: "+getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText());
		getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[6]/div/img[3]")).click();
		break;
		}
	}
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.copyCancelButtonXpath)));
	EmployeeCertificationPOM.clickCopySaveButton(getDriver());
	TestSetup.waitForJavascript(getDriver());
	System.out.println("Message: "+getDriver().findElement(By.xpath(EmployeeCertificationPOM.copyDuplicateRecordMsgXpath)).getText());
	SoftAssert softAssertion15= new SoftAssert();
	softAssertion15.assertEquals(getDriver().findElement(By.xpath(EmployeeCertificationPOM.copyDuplicateRecordMsgXpath)).getText(), "A duplicate entry found");
		
	EmployeeCertificationPOM.clickCopyDuplicateRecordOKButton(getDriver());
	
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 2));
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	System.out.println("Row count after: "+ names2.size());
	
	SoftAssert softAssertion20= new SoftAssert();
	softAssertion20.assertEquals(names2.size(), names1.size());
	softAssertion20.assertAll();
	}
 
@Test(priority = 14, dataProvider = "CopyValid", enabled = true)
public void testCopy_save(String ename, String certificate, String institute) {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 2));
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	System.out.println("Row count before edit: "+ names1.size());
	
	for (int i = 1; i <= names1.size(); i++) {
	
	if (getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText().contains(ename))
		{
		System.out.println("Employee record to be actioned is: "+i);
		System.out.println("Employee to be Copied: "+getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText());
		getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[6]/div/img[3]")).click();
		break;
		}
	}
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.copyCancelButtonXpath)));
	
	EmployeeCertificationPOM.enterCertification(getDriver(), certificate);
	EmployeeCertificationPOM.enterInstitute(getDriver(), institute);
	EmployeeCertificationPOM.clickCopySaveButton(getDriver());
	
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 2));
	TestSetup.waitForJavascript(getDriver());
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	System.out.println("Row count after: "+ names2.size());
	
	String cert = null;
	String insti = null;
	
	for (int i = 1; i <= names2.size(); i++) {
		
	if (getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText().contains(ename))
		{
		System.out.println("Employee Copied: "+getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText());
		cert = getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[2]")).getText();
		insti = getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[3]")).getText();
		break;
		}
	}
	SoftAssert softAssertion21= new SoftAssert();
	softAssertion21.assertEquals(certificate, cert);
	SoftAssert softAssertion22= new SoftAssert();
	softAssertion22.assertEquals(institute, insti);
	SoftAssert softAssertion23= new SoftAssert();
	softAssertion23.assertEquals(names2.size(), names1.size()+1);
	softAssertion23.assertAll();
	}
 
 @Test(priority = 15,  dataProvider = "RecordAction", enabled = true)
 public void testDelete_cancel(String ename) {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 3));
	new FluentWait<WebDriver>(getDriver()).ignoring(NoSuchElementException.class);
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	
	System.out.println("Row count before delete: "+ names1.size());
	
	for (int i = 1; i <= names1.size(); i++) {
				
		if (getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText().contains(ename))
		{
			System.out.println("Employee record to be actioned is: "+i);
			System.out.println("Employee to be Deleted: "+getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText());
			getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[6]/div/img[2]")).click();
			break;
		}
		
	}
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.cancelButtonXpath)));
	EmployeeCertificationPOM.clickDeleteCancelButton(getDriver());
	
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath), 3));
	TestSetup.waitForJavascript(getDriver());
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	System.out.println("Row count after: "+ names2.size());
	
	SoftAssert softAssertion24= new SoftAssert();
	softAssertion24.assertEquals(names2.size(), names1.size());
	softAssertion24.assertAll();
	}

@Test(priority = 16, dataProvider = "RecordAction", enabled = true)
public void testDelete_confirm(String ename) {
	 WebDriverWait wait = new WebDriverWait(getDriver(), 30);
	 TestSetup.AUTlogin(getDriver());
	 getDriver().manage().window().maximize();
	 
	EmployeeCertificationPOM.clickEmployeeTab(getDriver());
	EmployeeCertificationPOM.clickCertificationTab(getDriver());
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol6Xpath), 3));
	
	new FluentWait<WebDriver>(getDriver()).ignoring(NoSuchElementException.class);
	
	List<WebElement> names1 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));
	System.out.println("Row count before delete: "+ names1.size());
	for (int i = 1; i <= names1.size(); i++) {
				
		if (getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText().contains(ename))
		{
			System.out.println("Employee record to be actioned is: "+i);
			System.out.println("Employee to be Deleted: "+getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[1]")).getText());
			getDriver().findElement(By.xpath("//div[@id = 'EmployeeCertification']//table[@id='grid']//tbody/tr["+i+"]/td[6]/div/img[2]")).click();
			break;
		}
		
	}
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EmployeeCertificationPOM.deleteCancelButtonXpath)));
	EmployeeCertificationPOM.clickDeleteConfirmButton(getDriver());
	
	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(EmployeeCertificationPOM.certificationTableCol6Xpath), 3));
	//getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	TestSetup.waitForJavascript(getDriver());
	
	List<WebElement> names2 = getDriver().findElements(By.xpath(EmployeeCertificationPOM.certificationTableCol1Xpath));

	System.out.println("Row count after delete: "+ names2.size());
	
	SoftAssert softAssertion25= new SoftAssert();
	softAssertion25.assertEquals(names2.size()+1, names1.size());
	softAssertion25.assertAll();
	}
 
   
 
@DataProvider
	public Object[][] InvalidCertEmployeeData() {
		String sheetName = "AddnewCert";
		String tableName = "InvalidData";
		String xlFilePath = constants.Path_TestData + constants.File_TestData;
		return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
	}
 
@DataProvider
public Object[][]  SkipMandatoryFieldData() {
  String sheetName = "AddnewCert";
  String tableName = " SkipMandatoryFieldData";
  String xlFilePath = constants.Path_TestData+constants.File_TestData;
  return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
}

   @DataProvider
   public Object[][] dp() {
	  String sheetName = "AddnewCert";
	  String tableName = "NewCertData";
	  String xlFilePath = constants.Path_TestData+constants.File_TestData;
	  return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
}
   
   @DataProvider
   public Object[][] FilterCriteria() {
	  String sheetName = "AddnewCert";
	  String tableName = "FilterData";
	  String xlFilePath = constants.Path_TestData+constants.File_TestData;
	  return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
}
   
   @DataProvider
   public Object[][] FilterCriteriaInvalid() {
	  String sheetName = "AddnewCert";
	  String tableName = "FilterDataInvalid";
	  String xlFilePath = constants.Path_TestData+constants.File_TestData;
	  return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
}
   
   @DataProvider
   public Object[][] SearchCriteria() {
	  String sheetName = "AddnewCert";
	  String tableName = "SearchData";
	  String xlFilePath = constants.Path_TestData+constants.File_TestData;
	  return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
}
   
   @DataProvider
   public Object[][] SearchCriteriaInvalid() {
	  String sheetName = "AddnewCert";
	  String tableName = "SearchDataInvalid";
	  String xlFilePath = constants.Path_TestData+constants.File_TestData;
	  return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
}
 
@DataProvider
public Object[][] EditValid() {
  String sheetName = "AddnewCert";
  String tableName = "EditValid";
  String xlFilePath = constants.Path_TestData+constants.File_TestData;
  return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
}
 
@DataProvider
public Object[][] CopyValid() {
  String sheetName = "AddnewCert";
  String tableName = "CopyValid";
  String xlFilePath = constants.Path_TestData+constants.File_TestData;
  return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
}
  
  @DataProvider
  public Object[][] RecordAction() {
    String sheetName = "AddnewCert";
    String tableName = "RecordAction";
    String xlFilePath = constants.Path_TestData+constants.File_TestData;
    return TestSetup.DataProviderRead(xlFilePath, sheetName, tableName);
}
}
