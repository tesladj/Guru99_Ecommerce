package org.Guru99.Module;

import java.util.concurrent.TimeUnit;

import org.Guru99.Config.Config;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;



public  class LaunchApp {

	public static int timeout =30;
	public static void LaunchApplication(String BrowserName,String URL,String WebDriverXPath){
	try{
		if(BrowserName.equalsIgnoreCase("ff")){
			Config.driver = new FirefoxDriver();
		}
		if(BrowserName.equalsIgnoreCase("ch")){
			System.setProperty("webdriver.chrome.driver",WebDriverXPath);
			Config.driver = new ChromeDriver();
		}
		if(BrowserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.chrome.driver",WebDriverXPath);
			Config.driver = new InternetExplorerDriver();
		}
		Config.wait = new WebDriverWait(Config.driver,timeout);
		Config.driver.get(URL);
		Config.driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		Config.driver.manage().window().maximize();
	}
	catch(Exception ex){
		throw new WebDriverException();
	}
	}
	
}
