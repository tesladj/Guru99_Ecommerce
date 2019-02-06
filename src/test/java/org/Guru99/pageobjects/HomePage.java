package org.Guru99.pageobjects;

import org.Guru99.Config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.By;

public class HomePage {
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//Login
	@FindBy(how=How.XPATH,using=".//*[@id='header']/div/div[2]/div/a/span[2]")
	public WebElement Account;
	
	@FindBy(how=How.XPATH,using=".//*[@id='header-account']/div/ul/li[6]/a")
	public WebElement LogIn;

	//Select Mobile and Tv
	@FindBy(how=How.XPATH,using=".//*[.='Mobile']")
	public WebElement Mobile;
	
	@FindBy(how=How.XPATH,using=".//*[.='TV']")
	public WebElement  TV;
	
	//cart
	@FindBy(how=How.XPATH,using=".//*[.='Cart']")
	public WebElement Cart;
	
	@FindBy(how=How.XPATH,using=".//*[@id='top']/body/div/div/div[2]/div/div[1]/div/div[1]/strong/span")
	public WebElement MyAccount;
	
	@FindBy(how=How.XPATH,using=".//*[@id='header-account']/div/ul/li[5]/a")
	public WebElement registerAccount;
	
	@FindBy(how=How.XPATH,using="//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")
	public WebElement verifyRegister;
	
	@FindBy(how=How.XPATH,using="(.//*[@class='link-wishlist'])[1]")
	public WebElement addWish;
	
	
	
}
