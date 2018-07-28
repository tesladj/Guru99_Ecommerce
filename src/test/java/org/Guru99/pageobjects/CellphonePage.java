package org.Guru99.pageobjects;

import org.Guru99.Config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CellphonePage {

	public CellphonePage(WebDriver driver){
		PageFactory.initElements(Config.driver, this);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='product-price-1']/span[@class='price']")
	public WebElement Price;
	
	
}
