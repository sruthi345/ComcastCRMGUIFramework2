package com.crm.comcast.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseUtility.DataBaseUtility;
import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.UtlityClassObject;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public FileUtility fu=new FileUtility();
	public  ExcelUtility eu=new ExcelUtility();
	public  JavaUtility ju=new JavaUtility();
	public  WebDriverUtility wdu=new WebDriverUtility();
	public DataBaseUtility dbu=new DataBaseUtility();
	
	@BeforeSuite(alwaysRun = true)
		public void configBs() throws Throwable
		{
			System.out.println("===Connect to DB,Report Config===");
			dbu.getDbConnection();
		}
	
	    //@Parameters	("BROWSER")
		@BeforeClass(alwaysRun = true)
		public void configBC() throws Exception
		{
			System.out.println("===Launch the Browser");
			//for parallel executuion
			//String BROWSER=browser;
			//String BROWSER = fu.getDataFromPropertiesFile("browser");

			String BROWSER = fu.getDataFromPropertiesFile("browser");
			if(BROWSER.equals("chrome"))
			{
				 driver=new ChromeDriver();	
			}
			else if(BROWSER.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else if(BROWSER.equals("edge"))
			{
				driver=new EdgeDriver();
			}
			sdriver=driver;
			UtlityClassObject.setDriver(driver);
		}
		
		@BeforeMethod(alwaysRun = true)
		public void configBM() throws Exception
		{
			Thread.sleep(5000);
			System.out.println("Login to application");
			String URL = fu.getDataFromPropertiesFile("url");
			String USERNAME = fu.getDataFromPropertiesFile("username");
			String PASSWORD = fu.getDataFromPropertiesFile("password");
			LoginPage lp=new LoginPage(driver);
			lp.loginToapp(URL,USERNAME, PASSWORD);
		}
		@AfterMethod(alwaysRun = true)
		public void configAM() throws InterruptedException
		{
			System.out.println("Logout the application");
			HomePage hp=new HomePage(driver);
			hp.getsignoutImag().click();
			hp.getSignout().click();
			
			
		}
		@AfterClass(alwaysRun = true)
		public void configAC()
		{
			System.out.println("Close the Broser");
			driver.quit();
		}
		@AfterSuite(alwaysRun = true)
		public void configAS() throws Exception
		{
			System.out.println("====close the DB ");
			dbu.closeDbConnetion();
		}
	}

