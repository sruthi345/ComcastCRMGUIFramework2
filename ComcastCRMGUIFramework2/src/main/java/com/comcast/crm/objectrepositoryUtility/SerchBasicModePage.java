package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SerchBasicModePage {
	WebDriver driver;
	public SerchBasicModePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="SerchBasicModePage")
	private WebElement searchtxt;

}
