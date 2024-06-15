package Practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	@Test
	public void createContacttest() {
		System.out.println("execute createContact with-->HDFC");
	}
	@Test(dependsOnMethods="modifyContactTest")
	public void deleteContactTest()
	{
		System.out.println("execute deleteContactTest ICICI ");
	}
	@Test(dependsOnMethods="createContacttest")
	public void modifyContactTest ()  
	{
		System.out.println("execute modifyContactTest -->HDFC-->ICICI");
	}
}
