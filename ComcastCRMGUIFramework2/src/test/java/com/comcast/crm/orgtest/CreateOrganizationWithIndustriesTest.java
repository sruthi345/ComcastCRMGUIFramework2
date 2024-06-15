package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationPage;
import com.crm.comcast.basetest.BaseClass;

public class CreateOrganizationWithIndustriesTest extends BaseClass {
	@Test
	public void CreateOrgWithIndusTest() throws Exception{
		
		//read testScritdata from excel file
         String orgname=eu.getDataFromExcel("Sheet1", 1, 2)+ju.getRandomNumber();
		String industry=eu.getDataFromExcel("Sheet1", 1, 3);
		String type=eu.getDataFromExcel("Sheet1", 1, 4);
	
	//step2:navigate to the organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
	
	//step3:click on create organization button
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateNewOrgbutton().click();
	
	//step4:enter details 
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		oip.getOrgName().sendKeys(orgname);
		oip.getInddropdown().click();
		WebDriverUtility wu=new WebDriverUtility();
		wu.select(oip.getInddropdown(),industry );
		//driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(orgname);
	//WebElement industrydro = driver.findElement(By.name("industry"));
	//Select se1=new Select(industrydro);
	//se1.selectByVisibleText(industry);
	
	WebElement typedro = driver.findElement(By.name("accounttype"));
	Select se=new Select(typedro);
	se.selectByVisibleText(type);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//verify the actualindustries and type info
	 String actindus = driver.findElement(By.id("mouseArea_Industry")).getText();
	if(actindus.equals(industry))
	{
		System.out.println(actindus+"information is verfied==>pass");
	}
	else
	{
	System.out.println(actindus+"information is not verified==>fail");
	}
	String acttype = driver.findElement(By.id("dtlview_Type")).getText();
	if(acttype.equals(type))
	{
		System.out.println(typedro+"information is verified==>pass ");
	}
	else {
		System.out.println("information is not verified==>fail");
	}
	//logout
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
//	wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	/*
	 * Thread.sleep(3000); Actions action=new Actions(driver);
	 * action.moveToElement(driver.findElement(By.xpath(
	 * "//img[@src='themes/softed/images/user.PNG']"))).build().perform();
	 * 
	 * driver.findElement(By.linkText("Sign Out")).click(); //verifying header
	 * orgname info Expected Result //containe is used to compare the partial data
	 * driver.quit();
	 */
}

}
