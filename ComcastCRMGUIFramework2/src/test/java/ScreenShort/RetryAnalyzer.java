package ScreenShort;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzer {
	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryAnalyzer.class)
	public void ActivateSim()
	{
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals("Login", "Login");
		System.out.println("test1");
		System.out.println("test2");
		System.out.println("test3");
		System.out.println("test4");

}
}
