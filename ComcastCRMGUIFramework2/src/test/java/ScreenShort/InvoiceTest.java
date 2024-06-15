package ScreenShort;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.basetest.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListImplimentaionClass.class)
public class InvoiceTest extends BaseClass {
	@Test
		public void createInvoiceTest()
		{
			System.out.println("execute createInvoiceTest");
			String actTiltle = driver.getTitle();
			Assert.assertEquals(actTiltle, "Login");
			System.out.println("test1");
			System.out.println("test2");
			System.out.println("test3");
			System.out.println("test4");
		}
	@Test
	public void createInvoicewithContactTest()
	{
			System.out.println("execute createInvoiceTest");
			String actTiltle = driver.getTitle();
			System.out.println("test1");
			System.out.println("test2");
			System.out.println("test3");
			System.out.println("test4");
		}
	}

