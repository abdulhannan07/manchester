package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.LoginPage;

public class TC002_DDTLoginTest extends BaseClass {
	
	
	
	@Test(dataProvider="DDT")
	public void dataDTest(String us, String pw) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.userName(us);
		lp.passWord(pw);
		lp.loginButton();
		Thread.sleep(2000);
		if(isAlertPresent()==true){
				driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			System.out.println("test case failed");
			
		}else {
			Assert.assertTrue(true);
			System.out.println("test case passed");
			lp.LogoutButton();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	
		
	}
	
	
	@DataProvider(name="DDT")
	public Object[][]  dataP() {
		return new Object[][] {
			
			{ex.getExcelLibrary("Sheet", 0, 0), ex.getExcelLibrary("Sheet", 0, 1)},
			{ex.getExcelLibrary("Sheet", 1, 0), ex.getExcelLibrary("Sheet", 1, 1)},
			{ex.getExcelLibrary("Sheet", 2, 0), ex.getExcelLibrary("Sheet", 2, 1)},
			{ex.getExcelLibrary("Sheet", 3, 0), ex.getExcelLibrary("Sheet", 3, 1)},
			{ex.getExcelLibrary("Sheet", 4, 0), ex.getExcelLibrary("Sheet", 4, 1)},
			{ex.getExcelLibrary("Sheet", 5, 0), ex.getExcelLibrary("Sheet", 5, 1)},
			
		
	};

}
}