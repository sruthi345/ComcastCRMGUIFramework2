package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	
	//Rule-1 create a separate java class
	//Rule-2 Object Creation
	WebDriver driver;
	public LoginPage(WebDriver driver)//business logic//creating constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule-3 Object Initialization
		//Rule-4 Object Encapulation

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * login to application based on username,password,url arguments
	 * 
	 * @param url
	 * @param usernmae
	 * @param password
	 */
	//Rule-5 object utilization action//bussiness method
	public void loginToapp(String url,String usernmae,String password)
	{
		
		driver.get(url);
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		usernameEdit.sendKeys("admin");
		passwordEdt.sendKeys("password");
		loginBtn.click();
	}

	}

		

