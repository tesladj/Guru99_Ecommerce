package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.Guru99.Config.Config;
import org.Guru99.Module.CellphoneModule;
import org.Guru99.Module.HomeModule;
import org.Guru99.Module.LaunchApp;
import org.Guru99.Module.LoginModule;
import org.Guru99.Module.MobilePageModule;
import org.Guru99.Module.ShoppingCartModule;
import org.Guru99.pageobjects.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC3 {

	public static int timeout = 30;
	public int scc = 0;
	
	LoginModule lm ;
	HomeModule hm ;
	HomePage hp;
	MobilePageModule mpm;
	CellphoneModule cm;
	ShoppingCartModule sm;
	
	
	@Test
	@Parameters({"BrowserName" , "URL" , "WebDriverXPath"})
	public void ExecuteTc3(String BrowserName,String URL,String WebDriverXPath) throws IOException{
		LaunchApp.LaunchApplication( BrowserName, URL, WebDriverXPath+"chromedriver.exe");
		LoginModule lm = new LoginModule();
		HomeModule hm = new HomeModule();
		HomePage hp = new HomePage(Config.driver);
		CellphoneModule cm = new CellphoneModule();
		MobilePageModule mpm = new MobilePageModule(Config.driver);
		ShoppingCartModule sm = new ShoppingCartModule();
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
		mpm.AddToCart();
		
		Config.driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		sm.UpdateQuantity("1000");
		sm.UpdateQuantityClick();
		sm.EmptyCart();
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		if(sm.VerifyEmptyCart()==true){
			System.out.println("the cart is empty");
		}
		else{
			System.out.println("the cart is not empty");
		}
}
	@AfterTest
	public void tearDown() throws Exception {
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		Config.driver.close();
	   
	  }
	
//	public static void main(String args[]) throws IOException{
//		TC3 ob = new TC3();
//		ob.ExecuteTc3("ff","http://live.guru99.com/"," ");
//	}
}
