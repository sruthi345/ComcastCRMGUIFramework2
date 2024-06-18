package CodingStandeds;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.crm.comcast.basetest.BaseClass;

/**
 * test class for contact module
 * @author sruthi
 *
 */
public class SearchContactTest extends BaseClass {
	/**
	 * senario:login()==>naviagteContact==>createcontact()==verify
	 */
	@Test
	public void searchcontactTest()
	{
		/*step 1:login to app*/
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp("url", "username", "password");
	}

}
