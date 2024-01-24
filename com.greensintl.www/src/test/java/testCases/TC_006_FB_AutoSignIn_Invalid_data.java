package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.excelUtility;
import pageObjects.facebookSignInPage;
import pageObjects.homePage;
import pageObjects.signPage;
import pageObjects.toastPage;
import testBase.BaseClass;

public class TC_006_FB_AutoSignIn_Invalid_data extends BaseClass{
	@Test
	public void verify_FB_AutoSignIn_Invalid_data() throws Throwable
	{
		try {
			homePage hp=new homePage(driver);
			hp.clickSignIn();
			signPage sip=new signPage(driver);
			sip.clickSigninWithFacebook();
			excelUtility ex=new excelUtility();
			facebookSignInPage fpg=new facebookSignInPage(driver);
			fpg.setEmail(ex.getSingleDataFromExcel("Sheet1", 14, 2));
			fpg.setPswd(ex.getSingleDataFromExcel("Sheet1", 15, 2));
			fpg.clickLogIn();
			Thread.sleep(2000);
			String st = driver.getCurrentUrl();
			System.out.println(st);
			String st1=ex.getSingleDataFromExcel("Sheet1", 14, 4);
			System.out.println(st1);
			if(st.contains(st1))
			{
				System.out.println("Test is passed");
				Assert.assertTrue(true);
			}
			else
			{
				System.out.println("test is failed");
				Assert.fail();
			}
		}catch(Exception e) {
			Assert.fail();
		}
	}

}
