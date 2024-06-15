package com.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationPage;

public class DeleteOrgTest {
		public static void main(String[] args) throws Exception {
			//reading data from properties
			FileUtility fu=new FileUtility();
			ExcelUtility eu=new ExcelUtility();
			JavaUtility ju=new JavaUtility();
			WebDriverUtility wdu=new WebDriverUtility();
			
			 String BROWSER =fu.getDataFromPropertiesFile("browser");
		     String URL = fu.getDataFromPropertiesFile("url");
		     String  USERNAME= fu.getDataFromPropertiesFile("username");
	         String PASSWORD = fu.getDataFromPropertiesFile("password");
	         
			String orgname=eu.getDataFromExcel("TC", 1, 2)+ju.getRandomNumber();
			
			 WebDriver driver=null;
		
		 if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		 else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		//Step-1 :login to the application
		wdu.waitForPageToLoad(driver);
		LoginPage lp = new LoginPage(driver);//object creation from LoginPage Obejctrepository
		lp.loginToapp(URL,USERNAME, PASSWORD);
		
		//step2:navigate to the organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		
		//step3:click on create organization button
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateNewOrgbutton().click();
		
		//Step4:enter details &create new organization
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createOrg(orgname);
		
		//Step5:verify header msg expeced Result
//		String headermge = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actorgName=oip.getGetHeadermge().getText();
		if( actorgName.contains(orgname))
		{
			System.out.println(orgname+"is verifyed==>pass");
		}
		else
		{
		System.out.println(orgname+"is not created==>fail");
		}
		
		//get text of org name
				String orgtext = oip.getGetTextOforgName().getText();
		System.out.println(orgtext);
		
		//go back to organizations page
		hp.getOrglink().click();
		
		//search for oraganization
		op.getSearchboxTextField().sendKeys(orgname);
		
		//select orgname dropdown
		wdu.select(op.getDropdownorgname(), "Organization Name");
		
		//click on search button
		op.getSearchbtn().click();
		
		
		
		//click on delete 
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		
		//condition
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		//handle 
		wdu.switchToAlertAndAccept(driver);
		
       //Step6:logout
		HomePage hps=new HomePage(driver);
		hps.logout();
	}

}
