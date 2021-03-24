package com.flipkart.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;
import com.flipkart.util.CommonMethods;

public class FlipkartHomePage extends TestBase {
	
	CommonMethods commonMethod=new CommonMethods();

	@FindBy(xpath="//span[text()='Get access to your Orders, Wishlist and Recommendations']")
	WebElement loginPopup;
	
	@FindBy(xpath="//img[@alt='Appliances']")
	WebElement Appliances;
	
	@FindBy(xpath="//a[text()='Air Conditioners']")
	WebElement AirConditioner;
	
	@FindBy(xpath="//a[text()='Window ACs']")
	WebElement WindowsAc;
	
	@FindBy(xpath="//a[@rel='noopener noreferrer']")
	List<WebElement> TotalAc;
	
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12'][\"+i+\"]//a//label//div")
	WebElement AddToCompare;
	
	@FindBy(xpath="//span[text()='COMPARE']")
	WebElement CompareButton;
	
	@FindBy(xpath="//div[@id='fk-compare-page']//div[@class='row']//div[contains(@class,'col')]//button[text()='ADD TO CART']")
	List<WebElement> AddToCart;
	
	@FindBy(xpath="//span[text()='COMPARE']//parent::span//following-sibling::div//span[text()='3']")
	List<WebElement> TotalCompareExist;
	
	public FlipkartHomePage() {
		PageFactory.initElements(driver, this);
	}
	public String validateFlipKartTitle() {
		return driver.getTitle();
	}
	
	public void closeLoginPopup() throws AWTException {
		if(loginPopup.isDisplayed()) {
			Robot robot = new Robot(); 
	    	robot.keyPress(KeyEvent.VK_ESCAPE);
		}
		else {
			System.out.println("Login popup not available");
		}
	}
	
	public void clickOnWindowsAc() {
		commonMethod.moveToElement(Appliances);
		commonMethod.moveToElement(AirConditioner);
		commonMethod.moveToElement(WindowsAc);
		WindowsAc.click();
	}
	
	public AddToCartPage addToCompare() {
		
		System.out.println("Total AC Result"+ TotalAc.size());
		for (int i=1; i<=TotalAc.size();i++){
	    	
	    	if(i==2 || i==3 || i==6) {
	    		
	    		commonMethod.moveToElement(AddToCompare);
	    		WebElement AddToCompareCheckbox=driver.findElement(By.xpath("//div[@class='_1AtVbE col-12-12']["+i+"]//a//label//div"));
	    	    System.out.println("Selecting "+i+" Item");
	    		AddToCompareCheckbox.click();		
	    	    
	    	    if(TotalCompareExist.size()>0) {
	    	    	
	    	    	CompareButton.click();
	    	    	System.out.println("Total Compare Result "+AddToCart.size());
	    	    }
	    	}
	
		}
		return new AddToCartPage();
	}
	
	
}
