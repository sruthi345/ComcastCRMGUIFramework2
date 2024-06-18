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
	@FindBy(id="newsletter-email")
	private WebElement NewsletterTextField;

	@FindBy(linkText="Log in")
	private WebElement loginlink;
	
	@FindBy(linkText="Shopping cart")
	private WebElement shoppingcartlink;
	
	@FindBy(id="small-searchterms")
	 private WebElement searchtex;
	
	@FindBy(xpath="//span[text()='Wishlist']")
	private WebElement Wishlist;
	
	@FindBy(id="newsletter-subscribe-button")
	private WebElement subscribButton;
	
	@FindBy(id="pollanswers-1")
	private WebElement ExcellentRadioButton;
	
	@FindBy(id="pollanswers-2")
	private WebElement GoodRadioButton;
	
	@FindBy(id="pollanswers-3")
	private WebElement PoorRadioButton;
	
	@FindBy(id="pollanswers-4")
	private WebElement VeryBadButton;
	@FindBy(id="vote-poll-1")
	private WebElement VoteButton;
	
	//Actions or methods of WebElements
	public WebElement getVoteButton()
	{
		 return VoteButton;
	}
	public WebElement getVeryBadButton()
	{
		 return VeryBadButton;
	}
	public WebElement getPoorRadioButton()
	{
		 return PoorRadioButton;
	}
	public WebElement getGoodRadioButton()
	{
		 return GoodRadioButton;
	}
	public WebElement getsubscribButton()
	{
		 return subscribButton;
	}
	public WebElement getNewsletterTextField()
	{
		 return NewsletterTextField;
	}

	public WebElement getWishlilst()
	{
		 return Wishlist;
	}
	public void enterSearchText(String value)
	{
		searchtex.sendKeys(value);
	}
	public void clickLoginLink()
	{
		loginlink.click();
	}
	}
