package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
		private WebElement orgNameEdt;
	
	@FindBy(name="button")
	 private WebElement savebtn;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	public WebElement getLastName()
	{
		return getLastName();
	}
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	public void createOrg(String orgname)
	{
		orgNameEdt.sendKeys(orgname);
		savebtn.click();
	}
	public void createOrg(String orgname,String pindustry)
	{
		orgNameEdt.sendKeys(orgname);
		Select sel=new Select(industry);
		sel.selectByVisibleText(pindustry);
		savebtn.click();
	}

}
