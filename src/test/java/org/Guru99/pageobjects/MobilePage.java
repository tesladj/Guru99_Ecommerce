package org.Guru99.pageobjects;

import org.Guru99.Config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MobilePage {
	
	public MobilePage(WebDriver driver){
		PageFactory.initElements(Config.driver, this);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='product-collection-image-1']")
	public WebElement MobileImage;
	
	@FindBy(how=How.XPATH,using="(.//*[@class='button btn-cart']/span/span)[1]")
	public WebElement AddtoCart;
	
//	@FindBy(how=How.XPATH,using="")
//	public WebElement AddtoWishlist;
	
	@FindBy(how=How.XPATH,using=".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	public WebElement Sort;
	
	@FindBy(how=How.XPATH,using =".//*[@id='product-price-1']/span[@class='price']")
	public WebElement MobilePrice;
	
	@FindBy(how=How.XPATH,using="(.//*[@class='link-compare'])[1]")
	public WebElement AddComparefirst;
	
	@FindBy(how=How.XPATH,using="(.//*[@class='link-compare'])[2]")
	public WebElement AddCompareSecond;
	
	@FindBy(how=How.XPATH,using=".//*[@class='actions']/*[@class='button'][@title='Compare']")
	public WebElement Compare;
	
	
	
//	@FindBy(how=How.XPATH,using= ".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/h2/a")
//	public WebElement MobileImage;
	

}
