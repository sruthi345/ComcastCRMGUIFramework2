package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectorgNamebtn;
	
	@FindBy(id="mobile")
	private WebElement getPhoneNum;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
			private WebElement savebtn;
	
	public WebElement getPhoneNum()
	{
		return getPhoneNum;
	}


	public WebElement getSelectorgNamebtn() {
		return selectorgNamebtn;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	

	
}
