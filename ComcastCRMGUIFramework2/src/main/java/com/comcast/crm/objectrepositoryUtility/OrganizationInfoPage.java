package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement getHeadermge;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement getTextOforgName;
	
	@FindBy(name="accountname")
	private WebElement getOrgName;
	
	@FindBy(name="industry")
	private WebElement getInddropdown;
	
	@FindBy(name="accounttype")
	private WebElement gettypedropdrop;
	
	@FindBy(id="phone")
	private WebElement getphontext;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement getsavebtn;
	
	@FindBy(id="dtlview_Phone")
	private WebElement getactphonnumber;
	
	public WebElement getactphonnumber()
	{
		return getactphonnumber;
	}
	public WebElement getsavebtn()
	{
		return getsavebtn;
	}
	
	public WebElement getphontext()
	{
		return getphontext;
	}
	
	public WebElement gettypedropdown()
	{
		return gettypedropdrop;
	}
	
	public WebElement getInddropdown()
	{
	return getInddropdown;
	}
	
	public WebElement getOrgName()
	{
		return getOrgName;
	}

	public WebElement getGetTextOforgName() {
		return getTextOforgName;
	}


	public WebElement getGetHeadermge() {
		return getHeadermge;
	}
}
