package com.flipkart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class GoogleHomePage extends TestBase{
	
	@FindBy(name="q")
	WebElement googleSearch;
	
	@FindBy(xpath="//ul[@role='listbox']//li[@role='presentation']")
	List<WebElement> googleSuggestionList;
	
	@FindBy(xpath="//input[@title='Search flipkart.com']//ancestor::table//preceding-sibling::div//a[@href='https://www.flipkart.com/']")
	WebElement flipkartLink;
	
	@FindBy(xpath="//div[contains(@class,'kKvsb')]//a//img")
	WebElement googleLogo;
	
	//Initializing the Page Objects:
	public GoogleHomePage(){
			PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateGoogleSearch() {
		return googleSearch.isDisplayed();
	}
	
	public void searchFlipkart(String searchTerm) {
		googleSearch.sendKeys(searchTerm);
		
		
	}
	public void printAutoSuggestionList() {
		
		System.out.println("Printing Google auto suggestion list:");
		System.out.println("===============Start======================");
		
		for (int i = 0; i < googleSuggestionList.size(); i++) {
			System.out.println(googleSuggestionList.get(i).getText()); 
		} 
		System.out.println("============End===========================");
		googleSearch.submit();
	}
	public String validateFlipkartSearchTitle() {
		return driver.getTitle();
	}
	
	public FlipkartHomePage clickOnFlipkartLink() {
		
		flipkartLink.click();
		return new FlipkartHomePage();
		
	}
	
	
	

}
