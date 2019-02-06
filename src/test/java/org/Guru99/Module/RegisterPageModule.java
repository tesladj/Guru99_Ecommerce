package org.Guru99.Module;

import org.Guru99.Config.Config;
import org.Guru99.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageModule extends RegisterPage{

	public RegisterPageModule(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	RegisterPage rp = new RegisterPage(Config.driver);
	
	
	
	public void firstrName(String a){
		rp.firstname.sendKeys(a);
	}
	public void lastName(String b){
		rp.Lastname.sendKeys(b);
	}
	public void enterEmail(String c){
		rp.email.sendKeys(c);
	}
	public void enterPass(String d){
		rp.password.sendKeys(d);
	}
	public void enterConPass(String e){
		rp.conpassword.sendKeys(e);
	}
	public void clickRegister(){
		rp.register.click();
	}
}
