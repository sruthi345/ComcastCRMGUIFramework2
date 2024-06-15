package DWS_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWS_HomePage {
	public DWS_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//WebElememts
	@FindBy(linkText="Register")
	 WebElement registerlink;
	
	@FindBy(linkText="Log in")
	private WebElement loginlink;
	
	@FindBy(linkText="Shopping cart")
	private WebElement shoppinglink;
	
	@FindBy(id="small-searchterms")
	WebElement searchtex;
	
	//Actions or methods of WebElements
	public void enterSearchText(String value)
	{
		searchtex.sendKeys(value);
	}
	public void clickLoginLink()
	{
		loginlink.click();
	}
	public void clickRegisterLink()
	{
		registerlink.click();
	}
}
