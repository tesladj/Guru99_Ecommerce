package TestCases;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.Guru99.Config.Config;
import org.Guru99.Module.HomeModule;
import org.Guru99.Module.LaunchApp;
import org.Guru99.Module.LoginModule;
import org.Guru99.Module.MobilePageModule;
import org.Guru99.Module.RegisterPageModule;
import org.Guru99.Module.WishlistModule;
import org.Guru99.pageobjects.HomePage;
import org.Guru99.pageobjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(org.Guru99.Config.Listener.class)

public class AllTestCase {
	
	public static int timeout = 30;
	public int scc = 0;
	
	LoginModule lm ;
	HomeModule hm ;
	HomePage hp;
	MobilePageModule mpm;
	RegisterPage rp;
	RegisterPageModule rpm;
	WishlistModule wlm;
	Random rad = new Random();

	@Test(groups="Regression",priority=1)
	@Parameters({"BrowserName" , "URL" , "WebDriverXPath"})
	@BeforeClass
	public void AllTest(String BrowserName,String URL,String WebDriverXPath) throws IOException{
		LaunchApp.LaunchApplication( BrowserName, URL, WebDriverXPath);
		LoginModule lm = new LoginModule();
		HomeModule hm = new HomeModule();
		HomePage hp = new HomePage(Config.driver);
		MobilePageModule mpm = new MobilePageModule(Config.driver);
		RegisterPageModule rpm= new RegisterPageModule(Config.driver);
		hm.AccountClick();
		hm.registerMyAccount();
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		rpm.firstrName("test");
		rpm.lastName("testss");
		for (int j=1; j<=1; j++ )
        {
        String RanEmail = "dhanesh"+rad.nextInt(100)+"@gmail.com";  
        System.out.println(RanEmail);
        rpm.enterEmail(RanEmail);
        }
		
		rpm.enterPass("123456");
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		rpm.enterConPass("123456");
		rpm.clickRegister();
		hm.VerifyRegister();
		System.out.println("Test travis");
		try{
			System.out.println("Text is present and user is registered");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		hm.TvClick();
		hm.addWishlist();
		
		
		
}
	
	@AfterClass
	public void tearDown(){
		Config.driver.close();;
	}

//	public static void main(String args[]) throws IOException{
//		AllTestCase at = new AllTestCase();
//		at.AllTest("ff","http://live.guru99.com/","");
//	}
	}