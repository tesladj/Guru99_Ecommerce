package org.Guru99.Module;

import org.Guru99.Config.Config;
import org.Guru99.pageobjects.MobilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MobilePageModule {

	public MobilePageModule(WebDriver driver){
		
		PageFactory.initElements(Config.driver, this);
	}
	
	 MobilePage mp = new MobilePage(Config.driver);
	
	public void sort(String SortValue){
		Select dropdown = new Select(mp.Sort);
		dropdown.selectByVisibleText(SortValue);
	}
	
	public String MobilePrice(){
		String price = mp.MobilePrice.getText();
		return price;
		
	}
	
	public void  MobileImageclick(){
		mp.MobileImage.click();
	}
	
	public void AddToCart(){
		mp.AddtoCart.click();
	}
	
	public void AddToCompareFirst(){
		mp.AddComparefirst.click();
	}
	
	public void AddToCompareSecond(){
		mp.AddCompareSecond.click();
	}
	
	public void Copmare(){
		mp.Compare.click();
	}
}

