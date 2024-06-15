package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WithPomStaleElementException {
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	@FindAll({@FindBy(id="submitBut"),@FindBy(xpath="//input[@type='submit']")})
	WebElement ele3;
	
 @Test
 public void sampleTest()
 {
	 
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
//	WebElement ele1 = driver.findElement(By.name("user_name"));
//	WebElement ele2 = driver.findElement(By.name("user_password"));
//	WebElement ele3 = driver.findElement(By.id("submitButton"));
	WithPomStaleElementException s = PageFactory.initElements(driver, WithPomStaleElementException.class);
	
	s.ele1.sendKeys("admin");
	s.ele2.sendKeys("password");
driver.navigate().refresh();
	
	s.ele1.sendKeys("admin");
	s.ele2.sendKeys("password");
	s.ele3.click();
	

}
}
