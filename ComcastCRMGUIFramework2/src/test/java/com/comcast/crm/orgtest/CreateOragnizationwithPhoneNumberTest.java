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

public class CreateOragnizationwithPhoneNumberTest extends BaseClass {
	@Test
	public void CreateOrgPnoNum() throws Exception {
		//data featching form excel
		String orgname=eu.getDataFromExcel("TC", 4, 2)+ju.getRandomNumber();
		String industry=eu.getDataFromExcel("TC", 4, 3);
		String type=eu.getDataFromExcel("TC", 4, 4);
		String Phonenum=eu.getDataFromExcel("TC", 4, 5);
	
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
	//WebElement industrydro = driver.findElement(By.name("industry"));
	//Select se1=new Select(industrydro);
	//se1.selectByVisibleText(industry);
	
		OrganizationInfoPage oip2=new OrganizationInfoPage(driver);
		oip2.gettypedropdown().click();
		wu.select(oip.gettypedropdown(), type);
	//WebElement typedro = driver.findElement(By.name("accounttype"));
//	Select se=new Select(typedro);
//	se.selectByVisibleText(type);
	
	//driver.findElement(By.id("phone")).sendKeys(Phonenum);
	oip.getphontext().sendKeys(Phonenum);
	
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	oip.getsavebtn().click();
	
	//verify the actualindustries and type info
	String actphon = oip.getactphonnumber().getText();
	 //String actphon = driver.findElement(By.id("dtlview_Phone")).getText();
	if(actphon.equals(Phonenum))
	{
		System.out.println(actphon+"information is verfied==>pass");
	}else
	{
	System.out.println(actphon+"information is not verified==>fail");
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
