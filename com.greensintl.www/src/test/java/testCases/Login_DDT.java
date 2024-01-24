package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.excelUtility;
import pageObjects.homePage;
import pageObjects.signPage;
import pageObjects.signPageWithPassword;
import pageObjects.toastPage;
import testBase.BaseClass;

public class Login_DDT extends BaseClass
{
	@Test (dataProvider = "LoginData",dataProviderClass = DataProvider.class)
	public void verify_loginDDT(String email,String password,String exp) throws Throwable
	{
		try {
		homePage hp = new homePage(driver);
		hp.clickSignIn();
		signPage sip = new signPage(driver);
		sip.clickUseEmailAddress();
		signPageWithPassword spwp = new signPageWithPassword(driver);
		logger.info("Entering customer details");
		excelUtility ex = new excelUtility();
		spwp.setEmail(email);
		spwp.setPassword(password);
		spwp.clickSigninBtn();
		toastPage tp = new toastPage(driver);
		Thread.sleep(2000);
		String st = tp.getToastMsg();
		System.out.println(st);
		String st2 = ex.getSingleDataFromExcel("Sheet1", 3, 4);
		logger.info("validating expected message");

		if (st.equals(st2)) {
			logger.info("test is passed");
			Assert.assertTrue(true);
		} else {
			logger.error("test is failed");
			Assert.fail();
		}
	} catch (Exception e) {
		logger.error("test failed");
		logger.debug("debug logs");
		Assert.fail();
	}
	}

}
