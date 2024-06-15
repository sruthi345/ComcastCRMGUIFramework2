package Practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderContact {
	@Test(dataProvider="getData")
	public void createContactTest(String username,String password)
	{
		System.out.println("Firstname:"+username+"pssword:"+password);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="sruthi";
		data[0][1]="tester";
		data[1][0]="divya";
		data[1][1]="8795641";
		return data;
	}

}
