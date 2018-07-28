package org.Guru99.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;

public class LoginPage {

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='email']")
	public WebElement EnterEmail;
	
	@FindBy(how=How.XPATH,using=".//*[@id='pass']")
	public WebElement EnterPassword;
	
	@FindBy(how=How.XPATH,using=".//*[@id='send2']")
	public WebElement Login;
	
}
