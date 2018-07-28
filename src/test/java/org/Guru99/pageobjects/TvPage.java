package org.Guru99.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TvPage {
	
	public TvPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="(.//*[@class='button btn-cart'])[1]")
	public WebElement AddLg;
	
	@FindBy(how=How.XPATH,using="(.//*[@class='button btn-cart'])[2]")
	public WebElement AddSamsung;
	
	@FindBy(how=How.XPATH,using="(.//*[@class='list'])[1]")
	public WebElement List;
	
	@FindBy(how=How.XPATH,using="(.//*[@class='grid'])[1]")
	public WebElement Grid;
	
	
}
