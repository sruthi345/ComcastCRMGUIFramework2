package PracticeAssert;



import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class HomePageSampleTest {
	
	@Test
	public void homepageTest(Method md)
	{
		SoftAssert SoftAssert = new SoftAssert();
		System.out.println(md.getName()+"test Start");
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertEquals("Home1", "Home");
		System.out.println("step-3");
		Assert.assertEquals("Home-crm", "Home-crm");
		System.out.println("step-4");
		SoftAssert.assertAll();
		System.out.println(md.getName()+"test end");
		
	}
	@Test
	public void VerifyLogoHomePageTest(Method md)
	{
		Reporter.log(md.getName()+"test Start");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Assert.assertTrue(true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log(md.getName()+"test end");
	}

}
