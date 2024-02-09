package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.excelUtility;
import pageObjects.facebookSignInPage;
import pageObjects.homePage;
import pageObjects.signPage;
import pageObjects.toastPage;
import testBase.BaseClass;

public class TC_005_FB_AutoSignIn_Valid_data extends BaseClass {
@Test(groups = {"regression","master"})
public void verify_FB_AutoSignIn() throws Throwable
{

	logger.info("*****starting TC_005_FB_AutoSignIn_Valid_data*****");
	try {
	homePage hp=new homePage(driver);
	hp.clickSignIn();
	signPage sip=new signPage(driver);
	sip.clickSigninWithFacebook();
	excelUtility ex=new excelUtility();
	facebookSignInPage fpg=new facebookSignInPage(driver);
	fpg.setEmail(ex.getSingleDataFromExcel("Sheet1", 10, 2));
	fpg.setPswd(ex.getSingleDataFromExcel("Sheet1", 11, 2));
	fpg.clickLogIn();
	Thread.sleep(2000);
	String st = driver.getCurrentUrl();
	System.out.println(st);
	String st1=ex.getSingleDataFromExcel("Sheet1", 10, 4);
	System.out.println(st1);
	
	if(st.contains(st1))
	{
		System.out.println("Test is passed");
		Assert.assertTrue(true);
	}
	else {
		System.out.println("Test is failed");
		Assert.fail();
	}
}catch(Exception e) {
	Assert.fail();
}
}
	
}
