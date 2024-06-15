package PracticeAssert;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageVerificationTest {
	@Test
	public void HomePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+" Test Start");
		String title = "Homepage";
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		String actTitile = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		//Hard Assert
		Assert.assertEquals(actTitile, title);
		driver.quit();
		System.out.println(mtd.getName()+"Test end");
	}
	
	@Test
	public void VerifyLogoHomePage(Method mtd)
	{
		System.out.println(mtd.getName()+"Test Start");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
		//HardAssert
		Assert.assertTrue(status);
		driver.quit();
		System.out.println(mtd.getName()+"Test End");
		
		}
		
	}
	
