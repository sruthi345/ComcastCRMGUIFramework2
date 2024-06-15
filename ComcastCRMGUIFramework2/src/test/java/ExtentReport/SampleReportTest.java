package ExtentReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.listenerutility.ListImplimentaionClass;
import com.crm.comcast.basetest.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListImplimentaionClass.class)
public class SampleReportTest extends BaseClass {
	@Test
	public void createContactTest()
	{
				
		TakesScreenshot eDriver=(TakesScreenshot)driver;
		String filepath=eDriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test= ListImplimentaionClass.report.createTest("createContactTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create account");
		if("HDjFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is created");
			
		}
		else
		{
			test.addScreenCaptureFromBase64String(filepath,"ErrorFile");
		}
		
		test.log(Status.INFO,"login to app");
	}

}
