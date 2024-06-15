package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverUtility.UtlityClassObject;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.listenerutility.ListImplimentaionClass;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationPage;
import com.crm.comcast.basetest.BaseClass;
/**
 * 
 * @author sruthi
 *
 */
@Listeners(com.comcast.crm.listenerutility.ListImplimentaionClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups="smokeTest")
	public void CreateOrganization() throws Exception {
		//UtlityClassObject.getTest().log(Status.INFO,"read data from excel");

		/* featching data from excel*/
		String orgname = eu.getDataFromExcel("TC", 4, 2) + ju.getRandomNumber();

		// step2:navigate to the organization module
		ListImplimentaionClass.test.log(Status.INFO,"navigate to orgpage");
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// step3:click on create organization button
		ListImplimentaionClass.test.log(Status.INFO,"create org page");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgbutton().click();

		// enter details &create new organization
		ListImplimentaionClass.test.log(Status.INFO,"create new org");
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrg(orgname);
		ListImplimentaionClass.test.log(Status.INFO,orgname+"====create a new org");

		// verify header msg expeced Result
		// String headermge =
		// driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actorgName = oip.getGetHeadermge().getText();
		//Assert.assertEquals(orgname, actorgName.contains(orgname));
		Assert.assertTrue(actorgName.contains(orgname));
	}

		@Test(groups="smokeTest")
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
		
			OrganizationInfoPage oip2=new OrganizationInfoPage(driver);
			oip2.gettypedropdown().click();
			wu.select(oip.gettypedropdown(), type);
		
		oip.getphontext().sendKeys(Phonenum);
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		oip.getsavebtn().click();
		
		//verify the actualindustries and type info
		String actphon = oip.getactphonnumber().getText();
		 //String actphon = driver.findElement(By.id("dtlview_Phone")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals( actphon,Phonenum );
	    soft.assertAll();
		
	}
		
	@Test(groups="regressionTest")
	public void CreateOrgagnizationWithIndustriesTest() throws Exception {
		
		// read testScritdata from excel file
		String orgname=eu.getDataFromExcel("TC", 4, 2)+ju.getRandomNumber();
		String industry=eu.getDataFromExcel("TC", 4, 3);
		String type=eu.getDataFromExcel("TC", 4, 4);

				// step2:navigate to the organization module
				HomePage hp = new HomePage(driver);
				hp.getOrglink().click();

				// step3:click on create organization button
				OrganizationPage op = new OrganizationPage(driver);
				op.getCreateNewOrgbutton().click();

				// step4:enter details
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				oip.getOrgName().sendKeys(orgname);
				oip.getInddropdown().click();
				WebDriverUtility wu = new WebDriverUtility();
				wu.select(oip.getInddropdown(), industry);

				OrganizationInfoPage oip2=new OrganizationInfoPage(driver);
				  oip2.gettypedropdown().click();
				wu.select(oip.gettypedropdown(), type);

				oip.getsavebtn().click();

				// verify the actualindustries and type info
				String actindus = driver.findElement(By.id("mouseArea_Industry")).getText();
				if (actindus.equals(industry)) {
					System.out.println(actindus + "information is verfied==>pass");
				} else {
					System.out.println(actindus + "information is not verified==>fail");
				}
				String acttype = driver.findElement(By.id("dtlview_Type")).getText();
				if (acttype.equals(type)) {
					System.out.println( acttype+ "information is verified==>pass ");
				} else {
					System.out.println("information is not verified==>fail");
				}

			}
	}
	// verify the header orgname info expected Result
//	 String actorg = driver.findElement(By.id("dtlview_Organization Name")).getText();
//	if(actorg.equals(orgname))
//	{
//		System.out.println(orgname+" is crated==>pass");
//	}
//	else
//	{
//	System.out.println(orgname+" is not created==>fail");
//	}

	// logout
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
//	wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//	Thread.sleep(3000);
//	Actions action=new Actions(driver);
//	action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
//	
//	driver.findElement(By.linkText("Sign Out")).click();
//	//verifying header orgname info Expected Result
//	//containd is used to compare the partial data

//	driver.quit();

