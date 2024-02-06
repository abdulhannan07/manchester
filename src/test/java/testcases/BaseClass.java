package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ExcelLibrary;
import utilities.ReadCon;

public class BaseClass {
	
	public ExcelLibrary ex=new ExcelLibrary();
	
	public static WebDriver driver;
	
	public ReadCon rc=new ReadCon();
	
	public String baseurl=rc.Url();
	public String username=rc.userName();
	public String password=rc.passWord();
	public static  Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void launchUrl(String br) {
		logger=Logger.getLogger("Automation Project");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", rc.firefoxD());
		driver=new FirefoxDriver();
		} else if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", rc.chDriver());
			driver=new ChromeDriver();
		}
		
		logger.info("launched browser");
		driver.manage().window().maximize();
		driver.get(baseurl);
		logger.info("entered url");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeUrl() {
		logger.info("closed browser");
		driver.close();
		
	}
	
	
	public void screenShot(WebDriver driver, String testname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//Screenshots//"+testname+".png");
		FileUtils.copyFile(source, dest);
		System.out.println("Screenshot taken");
		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch (NoAlertPresentException e){
				return false;
				
				
			}
		}
	}


