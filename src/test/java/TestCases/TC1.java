package TestCases;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.Guru99.Config.Config;
import org.Guru99.Module.HomeModule;
import org.Guru99.Module.LaunchApp;
import org.Guru99.Module.LoginModule;
import org.Guru99.Module.MobilePageModule;
import org.Guru99.pageobjects.HomePage;
import org.apache.commons.io.FileUtils;



@Listeners(org.Guru99.Config.Listener.class)


public class TC1 {
	public static int timeout = 30;
	public int scc = 0;
	
	LoginModule lm ;
	HomeModule hm ;
	HomePage hp;
	MobilePageModule mpm;
	//testing
	@Test
	@Parameters({"BrowserName" , "URL" , "WebDriverXPath"})
	public void ExecuteTc1(String BrowserName,String URL,String WebDriverXPath) throws IOException{
		LaunchApp.LaunchApplication( BrowserName, URL, WebDriverXPath);
		LoginModule lm = new LoginModule();
		HomeModule hm = new HomeModule();
		HomePage hp = new HomePage(Config.driver);
		MobilePageModule mpm = new MobilePageModule(Config.driver);
		hm.AccountClick();
		hm.LoginClick();
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		lm.EnterEmail("cybagetest@gmail.com");
		lm.EnterPassword("cybagetest");
		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		lm.Login();
		System.out.println("Test travis");
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
		
		mpm.sort("Name");
		System.out.println("sorted");
		
//		Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
//		scc = (scc+1);
//		File scrFile = ((TakesScreenshot)Config.driver).getScreenshotAs(OutputType.FILE);
//		String png = ("C:\\Users\\dhanesh\\workspace_Java\\ejagruti_cucumber\\screenshot\\Mobile Products are sorted" + scc + ".png");
//		FileUtils.copyFile(scrFile, new File(png));
	
		
	}
	
	  
		@AfterTest
		public void tearDown() throws Exception {
			Config.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
			Config.driver.close();
		   
		  }
	
//	public static void main(String args[]) throws IOException{
//		TC1 ob = new TC1();
//		ob.ExecuteTc1("ff","http://live.guru99.com/","");
//	}
}

