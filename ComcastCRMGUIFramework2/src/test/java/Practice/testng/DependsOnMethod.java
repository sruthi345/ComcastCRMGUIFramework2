package Practice.testng;

import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test
	public void CreteOrderTest()
	{
		System.out.println("execute createOrderTEst==>123");
		String str=null;
		System.out.println(str.equals("123"));
	}
	@Test(dependsOnMethods="CreteOrderTest")
	public void billingAnotherTest()
	{
		System.out.println("execute billingAnotherOrder==>123");
	}

}
