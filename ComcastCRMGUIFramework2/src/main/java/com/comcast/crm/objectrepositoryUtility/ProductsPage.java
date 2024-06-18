package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {
	@FindBy(name="searchlink")
	private WebElement searchlink;
	
	public WebElement getsearchlink()
	{
		//ttthhhhg
		return  searchlink;
	}
	
}
