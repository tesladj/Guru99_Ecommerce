package TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.Guru99.Config.Config;
import org.Guru99.Module.HomeModule;
import org.Guru99.Module.LaunchApp;
import org.Guru99.Module.LoginModule;
import org.Guru99.Module.MobilePageModule;
import org.Guru99.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC4 {

	public static int timeout = 30;
	public int scc = 0;
	
	LoginModule lm ;
	HomeModule hm ;
	HomePage hp;
	MobilePageModule mpm;
	
	@Test
	@Parameters({"BrowserName" , "URL" , "WebDriverXPath"})
	public void ExecuteTc4(String BrowserName,String URL,String WebDriverXPath) throws IOException{
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
		
		mpm.AddToCompareFirst();
		mpm.AddToCompareSecond();
		mpm.Copmare();
		Config.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		String parentWindowHandler = Config.driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = Config.driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		
		
		Config.driver.switchTo().window(subWindowHandler); // switch to popup window
		if(Config.driver.findElement(By.xpath(".//*[.='Compare Products']")).isDisplayed()){
			System.out.println("pop up opened");
		}
		
		else{
			System.out.println("pop up closed");
		}
		Config.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Config.driver.findElement(By.xpath(".//*[@class='button']")).click();
		//Config.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Config.driver.switchTo().window(parentWindowHandler);  // switch back to parent window
		System.out.println("end");
		
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
//		TC4 ob = new TC4();
//		ob.ExecuteTc4("ff","http://live.guru99.com/","");
//	}
}


