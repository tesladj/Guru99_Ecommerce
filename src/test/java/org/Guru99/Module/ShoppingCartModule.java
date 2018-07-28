package org.Guru99.Module;

import org.Guru99.Config.Config;
import org.Guru99.pageobjects.ShoppingCartPage;
import org.openqa.selenium.WebDriver;

public class ShoppingCartModule {

	ShoppingCartPage sc = new ShoppingCartPage(Config.driver);
	public void UpdateQuantity(String value){
		sc.Quantity.sendKeys(value);
	}
	
	public void UpdateQuantityClick(){
		sc.Update.click();
	}
	
	public void EmptyCart(){
		sc.Emptycart.click();
	}
	
	public boolean VerifyEmptyCart(){
		boolean text = sc.ValidateEmptyCard.isDisplayed();
		return text;
		
	}
}
