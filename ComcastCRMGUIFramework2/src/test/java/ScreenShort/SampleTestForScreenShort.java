package ScreenShort;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.crm.comcast.basetest.BaseClass;

public class SampleTestForScreenShort {
	@Test
	public void amazonTest() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://amazon.com");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./ScreenShot/test.png");
			FileHandler.copy(temp, des);
			driver.close();
		
		//step-1:create an Object to EventFiring Webdriver
		//EventFiringWebDriver
		
	}

}
