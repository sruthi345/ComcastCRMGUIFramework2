package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithOutUsingPom {
	public static void main(String[] args) {
		
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
	WebElement ele1 = driver.findElement(By.name("user_name"));
	WebElement ele2 = driver.findElement(By.name("user_password"));
	//WebElement ele3 = driver.findElement(By.id("submitButton"));
	
	ele1.sendKeys("admin");
	ele2.sendKeys("password");
	//ele3.click();
	
	driver.navigate().refresh();
	
	ele1.sendKeys("admin");
	ele2.sendKeys("password");
	//ele3.click();
	
	

}
}
