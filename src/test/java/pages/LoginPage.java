package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
   @FindBy (name="uid")
    WebElement txtUsername;
   
   @FindBy(name="password")
   WebElement txtPassword;
   
   @FindBy(name="btnLogin")
   WebElement login;
   
   @FindBy(partialLinkText="Log out")
   WebElement logOut;
   
   
   public void userName(String user) {
	   txtUsername.sendKeys(user);
   }
   
   public void passWord(String pass) {
	   txtPassword.sendKeys(pass);
	   
   }
   
   public void loginButton() {
	   login.click();
   }
   
   public void LogoutButton() {
	   logOut.click();
   
   
   }
   
}
