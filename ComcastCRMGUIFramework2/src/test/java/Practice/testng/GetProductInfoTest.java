package Practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileUtility.ExcelUtility;

public class GetProductInfoTest {
	@Test(dataProvider="getdata")
	public void getProduct(String brandname,String productname)
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in/");
	
	//search product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
	
	//capture product info
	String x= "//span[text()='"+productname+"']/../../../..//span[@class='a-price-whole']";
	//(//span[text()='Apple iPhone 15 (128 GB) - Black'])[1]/../../../../div[3]/div[1]/div[1]/div[1]/div/div/a/span/span[2]/span[2]
	//(//span[text()='Apple iPhone 15 (128 GB) - Black'])[1]/../../../../div[3]/div[1]/div[1]/div[1]/div[1]//span[1]/span/span[2]
	String price = driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	
	driver.quit();
	}
	
	@DataProvider
	public Object[][] getdata() throws Exception
	{
		ExcelUtility eu=new ExcelUtility();
		int rowcount =eu.getRowCount("product");
		System.out.println(rowcount);
		
		Object[][] data=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++)
		{
		data[i][0]=eu.getDataFromExcel("product", i+1, 0);
		data[i][1]=eu.getDataFromExcel("product", i+1, 1);
	    }
		return data;
	}
}

