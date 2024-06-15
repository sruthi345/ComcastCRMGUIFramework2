package com.comcast.crm.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.ContactsPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class CreateNewContactTestIT {
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
         
         //featching data from excel
        String lastname = eu.getDataFromExcel("TC", 1, 1);
        
        WebDriver driver=null;
    	
    
        
        driver.get(URL);
        wdu.waitForPageToLoad(driver);
        LoginPage lp = new LoginPage(driver);//object creation from LoginPage Obejctrepository
		lp.loginToapp(URL,USERNAME, PASSWORD);
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContactbtn().click();
		
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.getLastnameEdt().sendKeys(lastname);
		cncp.getSelectorgNamebtn().click();
		
		wdu.switchToFrame(driver, "module=Accounts");
		
		
		
		
		
	}

}
