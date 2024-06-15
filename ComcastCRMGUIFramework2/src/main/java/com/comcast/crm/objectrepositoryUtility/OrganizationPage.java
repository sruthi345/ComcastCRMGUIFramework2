package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgbutton;

	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchboxTextField;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchbtn;
	
	@FindBy(id="bas_searchfield")
	private WebElement dropdownorgname;
	
	public WebElement getDropdownorgname() {
		return dropdownorgname;
	}
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public WebElement getSearchboxTextField() {
		return searchboxTextField;
	}
	
	
	public WebElement getCreateNewOrgbutton() {
		return createNewOrgbutton;
	}



}
