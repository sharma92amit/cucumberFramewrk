package com.util.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase  {

	public static WebDriver driver;
	public static Properties prop;
	public static HashMap<String, String> configurationMap;
	public TestBase(){
		try{
			configurationMap=new HashMap<String, String>();
			prop=new Properties();
			FileInputStream fis=new FileInputStream("config/config.properties");
			prop.load(fis);
		}catch(IOException e){
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	public static void initialisation(){
		String BrowserName=prop.getProperty("Browser");
		if(BrowserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "resources/driver/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","resources/driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
	
	public static void setMapGlobalVariable(String key,String value){
		configurationMap.put(key, value);
	}
	
	public static String getMapGlobalVariable(String key){
		return configurationMap.get(key);
	}
	
}
