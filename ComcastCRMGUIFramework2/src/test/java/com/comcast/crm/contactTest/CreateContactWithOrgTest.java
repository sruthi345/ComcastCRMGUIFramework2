package com.comcast.crm.contactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.crm.comcast.basetest.BaseClass;

public class CreateContactWithOrgTest extends BaseClass{
	@Test
	public void CCOrgTest() throws Exception
	{
		//read testScritdata from excel file
		String orgname = eu.getDataFromExcel("TC", 1, 2)+ju.getRandomNumber();
		String contactlaname =eu.getDataFromExcel("TC", 1, 3);
		
	//navigate to the organization module
	driver.findElement(By.linkText("Organizations")).click();
	
	//click on create organization button
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//enter details &create new organization
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(orgname);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//verify header msg expeced Result
	String actlastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if( actlastname.contains(orgname))
	{
		System.out.println(orgname+"is created==>pass");
	}
	else
	{
	System.out.println(orgname+"is not created==>fail");
	}
	//step5: navigate to contact model
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create Contacts button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//enter details &create new Create organization...
		driver.findElement(By.name("lastname")).sendKeys(contactlaname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//Switch to child window
		wdu.switchToTabOnURL(driver, "module=Accounts");
		//Set<String> set = driver.getWindowHandles();
		//Iterator<String> it = set.iterator();
		//we can write if we have multiple window
//		while (it.hasNext()) {
//			String windowId = it.next();
//			driver.switchTo().window(windowId);
//			
//			String actUrl=driver.getCurrentUrl();
//			if(actUrl.contains("module=Accounts"))
//			{
//				break;
//			
//		    }
//		}
		
		driver.findElement(By.id("search_txt")).sendKeys(orgname);	
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		
		//switch to parent window
		wdu.switchToTabOnURL(driver, "module=Accounts");
//				Set<String> set1 = driver.getWindowHandles();
//				Iterator<String> it1 = set1.iterator();
//				//we can write if we have multiple window
//				while (it1.hasNext()) {
//					String windowId = it1.next();
//					driver.switchTo().window(windowId);
//					
//					String actUrl=driver.getCurrentUrl();
//					if(actUrl.contains("module=Accounts"))//Contacts&action
//					{
//						break;
//					
//				    }
//				}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		//verify the header orgname info expected Result
		 String headinfo = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(headinfo.contains(orgname))//if(headinfo.trim().contains(orgname))//for removee space.
		{
			System.out.println(orgname+" is crated==>pass");
		}
		else
		{
		System.out.println(orgname+" is not created==>fail");
		}
		
	
	//logout
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
//	wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	Thread.sleep(3000);
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	//verifying header orgname info Expected Result
	//containd is used to compare the partial data
	 
	driver.quit();
}

}
