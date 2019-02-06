package org.Guru99.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.By;


public class RegisterPage {

	public RegisterPage(WebDriver driver){
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(how=How.XPATH,using = ".//*[@id='firstname']")
	public WebElement firstname;
	
	@FindBy(how=How.XPATH,using= ".//*[@id='lastname']")
	public WebElement Lastname;
	
	@FindBy(how=How.XPATH,using=".//*[@id='email_address']")
	public WebElement email;
	
	@FindBy(how=How.XPATH,using= "//*[@id='password']")
	public WebElement password;
	
	@FindBy(how=How.XPATH,using ="//*[@id='confirmation']")
	public WebElement conpassword;
	
	@FindBy(how=How.XPATH,using="//*[@id='form-validate']/div[2]/button")
	public WebElement register;
	
	
}
