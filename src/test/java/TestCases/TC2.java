package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.Guru99.Config.Config;
import org.Guru99.Module.CellphoneModule;
import org.Guru99.Module.HomeModule;
import org.Guru99.Module.LaunchApp;
import org.Guru99.Module.LoginModule;
import org.Guru99.Module.MobilePageModule;
import org.Guru99.pageobjects.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(org.Guru99.Config.Listener.class)

public class TC2 {

	public static int timeout = 30;
	public int scc = 0;
	
	LoginModule lm ;
	HomeModule hm ;
	HomePage hp;
	MobilePageModule mpm;
	CellphoneModule cm;
	
	@Test
	@Parameters({"BrowserName" , "URL" , "WebDriverXPath"})
	public void ExecuteTc2(String BrowserName,String URL,String WebDriverXPath) throws IOException{
		LaunchApp.LaunchApplication( BrowserName, URL, WebDriverXPath);
		LoginModule lm = new LoginModule();
		HomeModule hm = new HomeModule();
		HomePage hp = new HomePage(Config.driver);
		CellphoneModule cm = new CellphoneModule();
		MobilePageModule mpm = new MobilePageModule(Config.driver);
		hm.AccountClick();
		hm.LoginClick();
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		lm.EnterEmail("cybagetest@gmail.com");
		lm.EnterPassword("cybagetest");
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		lm.Login();
		String title = hp.MyAccount.getText();
		System.out.println(title);
		if(title.equals("MY ACCOUNT")){
			System.out.println("p");
		}
		else{
			System.out.println("f");
		}
		hm.MobileClick();
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		String title1= Config.driver.getTitle();
		System.out.println(title1);
		if(title1.equals("Mobile")){
			System.out.println("p");
		}
		else{
			System.out.println("f");
		}
		
		String price1 = mpm.MobilePrice();
		System.out.println(price1);
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		mpm.MobileImageclick();
		
		Config.driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		String price2 =  cm.CellPrice();
		System.out.println(price2);
		if(price1.equals(price2)){
			System.out.println("Price is ok");
		}
		else{
			System.out.println("price not ok");
		}
		
}
	@AfterTest
	public void tearDown() throws Exception {
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		Config.driver.close();
	   
	  }
//	public static void main(String args[]) throws IOException{
//		TC2 ob = new TC2();
//		ob.ExecuteTc2("ff","http://live.guru99.com/"," ");
//	}
	}
