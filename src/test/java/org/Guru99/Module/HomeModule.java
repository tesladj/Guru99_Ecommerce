package org.Guru99.Module;

import org.Guru99.Config.Config;
import org.Guru99.pageobjects.HomePage;

public class HomeModule {

	HomePage hp=new HomePage(Config.driver);
	
	public void MobileClick(){
		hp.Mobile.click();
	}
	
	public void AccountClick(){
		hp.Account.click();
	}
	
	public void LoginClick(){
		hp.LogIn.click();
	}
	
	public void TvClick(){
		hp.TV.click();
	}
	
	
	
	
	
}
