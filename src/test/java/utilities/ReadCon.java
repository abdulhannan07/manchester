package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadCon {
	
	public Properties pro;
	
	
	public ReadCon() {
		
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//Configurations//Config.properties");
			pro=new Properties();
			pro.load(file);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String Url () {
		String baseUrl=pro.getProperty("baseurl");
		return baseUrl  ;
	}
	
	
	public String userName () {
		String userName=pro.getProperty("username");
		return userName   ;
	}
	
	public String passWord() {
		String pw=pro.getProperty("password");
		return  pw ;
	}
	
	
	public String chDriver() {
		String chromeDriver=pro.getProperty("chromepath");
		return  chromeDriver ;
	}
	
	
	public String firefoxD () {
		String firefoxDriver=pro.getProperty("firefoxpath");
		return firefoxDriver ;
	}
	

}
