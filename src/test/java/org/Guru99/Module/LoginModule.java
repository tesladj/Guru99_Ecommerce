package org.Guru99.Module;

import org.Guru99.Config.Config;
import org.Guru99.pageobjects.LoginPage;

public class LoginModule {

	LoginPage lp=new LoginPage(Config.driver);
	
	public void EnterEmail(String Email){
		lp.EnterEmail.sendKeys(Email);
	}
	
	public void EnterPassword(String Password){
		lp.EnterPassword.sendKeys(Password);
	}
	
	public void Login(){
		lp.Login.click();
	}
}
