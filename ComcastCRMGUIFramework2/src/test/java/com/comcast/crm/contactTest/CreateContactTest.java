package com.comcast.crm.contactTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectrepositoryUtility.ContactsPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.crm.comcast.basetest.BaseClass;

import junit.framework.Assert;

public class CreateContactTest extends BaseClass {
	@Test(groups="regresssionTest")
	public void createcontactTest() throws Exception {
		// read testScritdata from excel file
		String lastName = eu.getDataFromExcel("TC", 4, 1) + ju.getRandomNumber();
		String phoneNum = eu.getDataFromExcel("TC", 4, 5);

		// navigate to the Contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// click on create Contacts button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactbtn().click();

		// enter details &create new Create Contact...
		CreatingNewContactPage cnop = new CreatingNewContactPage(driver);
		cnop.getLastnameEdt().sendKeys(lastName);
		cnop.getPhoneNum().sendKeys(phoneNum);
		// driver.findElement(By.name("lastname")).sendKeys(lastName);
		cnop.getSavebtn().click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		
		// verify header phone number msg expeced Result
		String actlastname = driver.findElement(By.xpath("//span[contains(@class,'dvHeaderText')]")).getText();
		boolean status = actlastname.contains(lastName);
		Assert.assertEquals(status, true);
		
		String actlastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals( actlastName,lastName );
	soft.assertAll();

		// logout
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
//	wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//	Thread.sleep(3000);
//	Actions action=new Actions(driver);
//	action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
//	
//	driver.findElement(By.linkText("Sign Out")).click();
		// verifying header orgname info Expected Result
		// containd is used to compare the partial data

	}
}
