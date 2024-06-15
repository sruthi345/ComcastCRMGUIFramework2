package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	//Rule-1 create a separate java class
	//Rule-2 Object Creation
	public HomePage(WebDriver driver)//business logic//creating constructor//object initialization
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;
	
	@FindBy(xpath="//span[@class='userName']/../..//td[2]")
	private WebElement signoutImag;
	
	public WebElement getsignoutImag()
	{
		return signoutImag;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getAdminIcon() {
		return adminIcon;
	}

	public WebElement getSignout() {
		return signout;
	}

	
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	public WebElement getcampaignlink() {
		Actions act=new Actions(driver);
		act.moveToElement(morelink).perform();
		return campaignlink;
	}
	//bussiness method
	public void logout(){
		Actions act=new Actions(driver);
		act.moveToElement(adminIcon).perform();
	signout.click();
	}

}
