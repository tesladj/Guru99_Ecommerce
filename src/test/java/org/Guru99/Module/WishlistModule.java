package org.Guru99.Module;

import org.Guru99.pageobjects.WishlistPage;
import org.openqa.selenium.WebDriver;

public class WishlistModule extends WishlistPage {

	WishlistPage  wp;
	public WishlistModule(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickShareWish(){
		wp.shareWish.click();
	}

	
}
