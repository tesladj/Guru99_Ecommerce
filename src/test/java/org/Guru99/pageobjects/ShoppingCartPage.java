package org.Guru99.pageobjects;

import org.Guru99.Config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	public ShoppingCartPage(WebDriver driver){
		PageFactory.initElements(Config.driver, this);
	}
	@FindBy(how=How.XPATH,using=".//*[@class='input-text qty']")
	public WebElement Quantity;
	
	@FindBy(how=How.XPATH,using=".//*[@class='button btn-update']")
	public WebElement Update;
	
	@FindBy(how=How.XPATH,using=".//*[@id='empty_cart_button']")
	public WebElement Emptycart;
	
	@FindBy(how=How.XPATH,using=".//*[.='Shopping Cart is Empty']")
	public WebElement ValidateEmptyCard;
}
