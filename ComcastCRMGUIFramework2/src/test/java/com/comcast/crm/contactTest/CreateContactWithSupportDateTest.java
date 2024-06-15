package com.comcast.crm.contactTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.basetest.BaseClass;


public class CreateContactWithSupportDateTest extends BaseClass {
	@Test
	public void CreateContactSupportDateTest() throws Exception 
	{
		
       //read testScritdata from excel file
         String lastname =eu.getDataFromExcel("TC", 4, 2)+ju.getRandomNumber();
		
	//navigate to the Contacts module
	driver.findElement(By.linkText("Contacts")).click();
	
	//click on create Contacts button
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	//enter details &create
	String startdate = ju.systemDateYYYYDDMM();
	String enddate = ju.getRequirdDateYYYYDDMM(30);

	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.id("jscal_field_support_start_date")).clear();
	driver.findElement(By.id("jscal_field_support_start_date")).sendKeys(startdate);
	
	driver.findElement(By.id("jscal_field_support_end_date")).clear();
	driver.findElement(By.id("jscal_field_support_end_date")).sendKeys(enddate);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//verify header  phone number msg expeced Result
	String actstartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
	if( actstartDate.equals(startdate))
	{
		System.out.println(startdate+"is selected==>pass");
	}
	else
	{
	System.out.println(startdate+"is not created==>fail");
	}
	String actendDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
	if( actendDate.equals(enddate))
	{
		System.out.println(enddate+"is selected==>pass");
	}
	else
	{
	System.out.println(enddate+"is not created==>fail");
	}
	
	//logout
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
//	wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//	Thread.sleep(3000);
//	Actions action=new Actions(driver);
//	action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
//	
//	driver.findElement(By.linkText("Sign Out")).click();
	//verifying header orgname info Expected Result
	//containd is used to compare the partial data
	 
	}

}
