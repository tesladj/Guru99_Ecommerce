package org.Guru99.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

	public WishlistPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='wishlist-view-form']/div/div/button[1]/span/span")
	public WebElement shareWish;
}
