package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TC001_LoginTest extends BaseClass {
	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.userName(username);
		lp.passWord(password);
		lp.loginButton();
		Thread.sleep(2000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			screenShot(driver,"TC001_LoginTest");
			Assert.assertTrue(true);
			System.out.println("test case passed");
		}else {
			System.out.println("test case failed");
		}
		lp.LogoutButton();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

}
