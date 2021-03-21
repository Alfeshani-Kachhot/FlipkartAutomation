package com.flipkart.util;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.flipkart.base.TestBase;

public class CommonMethods extends TestBase {

	
	Actions actions = new Actions(driver);
	
	public void moveToElement(WebElement webElement) {
		
		actions.moveToElement(webElement).perform();;
		
	}
	
	public void printProductNameAndPrice(List<WebElement> productName,List<WebElement> productPrice) {
		
		for(int i=0;i<productName.size();i++) {
			System.out.println("Product Name:");
		}
	}
	
	public void GetDeliveryMsg() {
		
	}
}
